/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bees;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.imageio.ImageIO;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import javax.swing.AbstractAction;
import static javax.swing.Action.LARGE_ICON_KEY;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingWorker;
/**
 *
 * @author admin
 */
public class DisplayImage extends JFrame
{
    String imageCaptions[]=new String[10];
    String imageFileNames[];
    int imgcnt=0;
    private Icons icn1 = new Icons();

    private JLabel jLabel1 = new JLabel();
    private JToolBar jToolBar = new JToolBar();
   JScrollPane jScrollPane1 = new JScrollPane();

    public DisplayImage(ArrayList al)
    {
        imageFileNames=new String[al.size()];
        for(int i=0;i<al.size();i++)        
        {
            imageFileNames[imgcnt++]=al.get(i).toString();
        }

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Search Result");

        jLabel1.setVerticalTextPosition(JLabel.BOTTOM);
        jLabel1.setHorizontalTextPosition(JLabel.CENTER);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        
        jToolBar.add(Box.createGlue());
        jToolBar.add(Box.createGlue());
        //jToolBar.setRollover(false);

		//jScrollPane1.setViewportView(jToolBar);

       add(jToolBar, BorderLayout.SOUTH);
                
        //add(jScrollPane1,BorderLayout.SOUTH);
        add(jLabel1, BorderLayout.CENTER);

       
        setSize(1000, 400);
        setResizable(false);
       
        setLocationRelativeTo(null);

        
        loadimages.execute();

        
    }


    public RenderedImage rescale(RenderedImage i)
    {
        int baseSize=200;
      float scaleW = ((float) baseSize) / i.getWidth();
      float scaleH = ((float) baseSize) / i.getHeight();
      // Scales the original image
      ParameterBlock pb = new ParameterBlock();
      pb.addSource(i);
      pb.add(scaleW);
      pb.add(scaleH);
      pb.add(0.0F);
      pb.add(0.0F);
      pb.add(new InterpolationNearest());
     // Creates a new, scaled image and uses it on the DisplayJAI component
      return JAI.create("scale", pb);
      }

    public BufferedImage convertRenderedImage(RenderedImage img)
    {
		if (img instanceof BufferedImage) {
			return (BufferedImage)img;
		}
		ColorModel cm = img.getColorModel();
		int width = img.getWidth();
		int height = img.getHeight();
		WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		Hashtable properties = new Hashtable();
		String[] keys = img.getPropertyNames();
		if (keys!=null) {
			for (int i = 0; i < keys.length; i++) {
				properties.put(keys[i], img.getProperty(keys[i]));
			}
		}
		BufferedImage result = new BufferedImage(cm, raster, isAlphaPremultiplied, properties);
		img.copyData(raster);
		return result;
	}


    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>()
	{

        @Override
        protected Void doInBackground() throws Exception
        {
       
            for (int i = 0; i < imageFileNames.length; i++)
            {
            //    ImageIcon icon;
              //  icon = createImageIcon(imageFileNames[i], String.valueOf(i+1));
                BufferedImage bi=ImageIO.read(new File(imageFileNames[i]));
                RenderedImage rimg=rescale(bi);
                BufferedImage bimg= convertRenderedImage(rimg);
                ImageIcon icon=new ImageIcon(bimg);


                ThumbnailAction thumbAction;
                if(icon != null)
                {

                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));

                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, String.valueOf(i+1));

                }
                else
                {
                    
                    thumbAction = new ThumbnailAction(icn1, icn1, String.valueOf(i+1));
                }
                publish(thumbAction);
            }
            
            return null;
        }

        
        @Override
        protected void process(List<ThumbnailAction> chunks)
		{
            for (ThumbnailAction thumbAction : chunks)
			{
                JButton thumbButton = new JButton(thumbAction);
               
               jToolBar.add(thumbButton, jToolBar.getComponentCount() - 1);
               
            }
        }
    };

    
    protected ImageIcon createImageIcon(String path,
            String description)
			{
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    
    private Image getScaledImage(Image srcImg, int w, int h)
	{
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    
    private class ThumbnailAction extends AbstractAction
    {

        
        private Icon displayPhoto;

        
        public ThumbnailAction(Icon photo, Icon thumb, String desc)
	{
            displayPhoto = photo;

            
            putValue(SHORT_DESCRIPTION, desc);

            
            putValue(LARGE_ICON_KEY, thumb);
        }

        
        public void actionPerformed(ActionEvent e)
        {
            jLabel1.setIcon(displayPhoto);
            setTitle("Result: " + getValue(SHORT_DESCRIPTION).toString());
        }
    }

	public class Icons implements Icon
	{

    private int width = 32;
    private int height = 32;

    private BasicStroke stroke = new BasicStroke(4);

    public void paintIcon(Component c, Graphics g, int x, int y)
	{
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(x +1 ,y + 1,width -2 ,height -2);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(x +1 ,y + 1,width -2 ,height -2);

        g2d.setColor(Color.RED);

        g2d.setStroke(stroke);
        g2d.drawLine(x +10, y + 10, x + width -10, y + height -10);
        g2d.drawLine(x +10, y + height -10, x + width -10, y + 10);

        g2d.dispose();
    }

    public int getIconWidth()
	{
        return width;
    }

    public int getIconHeight()
	{
        return height;
    }

}
    
}
