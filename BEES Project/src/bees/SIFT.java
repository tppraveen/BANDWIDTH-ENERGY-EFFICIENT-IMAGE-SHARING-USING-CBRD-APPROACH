/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bees;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.imageio.ImageIO;

import ij.process.ImageProcessor;
import ij.ImagePlus;
import ij.gui.GenericDialog;
/**
 *
 * @author admin
 */
public class SIFT 
{
    private static int steps = 3;	
    private static float initial_sigma = 1.6f;

    private static int fdsize = 4;
    private static int fdbins = 8;
   
    private static int min_size = 20;
    private static int max_size = 60;//1024;


    private static boolean upscale = false;
    private static float scale = 1.0f;

	
	
	static void drawSquare( ImageProcessor ip, double[] o, double scale, double orient )
	{
		scale /= 2;
		
                
                
	    double sin = Math.sin( orient );
	    double cos = Math.cos( orient );
	    
	    int[] x = new int[ 6 ];
	    int[] y = new int[ 6 ];
	    

	    x[ 0 ] = ( int )( o[ 0 ] + ( sin - cos ) * scale );
	    y[ 0 ] = ( int )( o[ 1 ] - ( sin + cos ) * scale );
	    
	    x[ 1 ] = ( int )o[ 0 ];
	    y[ 1 ] = ( int )o[ 1 ];
	    
	    x[ 2 ] = ( int )( o[ 0 ] + ( sin + cos ) * scale );
	    y[ 2 ] = ( int )( o[ 1 ] + ( sin - cos ) * scale );
	    x[ 3 ] = ( int )( o[ 0 ] - ( sin - cos ) * scale );
	    y[ 3 ] = ( int )( o[ 1 ] + ( sin + cos ) * scale );
	    x[ 4 ] = ( int )( o[ 0 ] - ( sin + cos ) * scale );
	    y[ 4 ] = ( int )( o[ 1 ] - ( sin - cos ) * scale );
	    x[ 5 ] = x[ 0 ];
	    y[ 5 ] = y[ 0 ];
	    
	    ip.drawPolygon( new Polygon( x, y, x.length ) );
	}

	
	public Vector< Feature > run1(String fp)//,String fo)
	{
            ArrayList feat=new ArrayList();
		ArrayList at1=new ArrayList();
            
		final ImagePlus imp = new ImagePlus(fp);

		

		final GenericDialog gd = new GenericDialog( "Test SIFT" );
		
		gd.addNumericField( "steps_per_scale_octave :", steps, 0 );
		gd.addNumericField( "initial_gaussian_blur :", initial_sigma, 2 );
		gd.addNumericField( "feature_descriptor_size :", fdsize, 0 );
		gd.addNumericField( "feature_descriptor_orientation_bins :", fdbins, 0 );
		gd.addNumericField( "minimum_image_size :", min_size, 0 );
		gd.addNumericField( "maximum_image_size :", max_size, 0 );
		gd.addCheckbox( "upscale_image_first", upscale );
		//gd.showDialog();
		
		steps = ( int )gd.getNextNumber();
		initial_sigma = ( float )gd.getNextNumber();
		fdsize = ( int )gd.getNextNumber();
		fdbins = ( int )gd.getNextNumber();
		min_size = ( int )gd.getNextNumber();
		max_size = ( int )gd.getNextNumber();
		upscale = gd.getNextBoolean();
		if ( upscale ) scale = 2.0f;
		
		
		ImageProcessor ip1 = imp.getProcessor().convertToFloat();
		ImageProcessor ip2 = imp.getProcessor().duplicate().convertToRGB();
		
		Vector< Feature > fs1;
		
		FloatArray2DSIFT sift = new FloatArray2DSIFT( fdsize, fdbins );
		
		FloatArray2D fa = ImageArrayConverter.ImageToFloatArray2D( ip1 );
		Filter.enhance( fa, 1.0f );
		
		if ( upscale )
		{
			FloatArray2D fat = new FloatArray2D( fa.width * 2 - 1, fa.height * 2 - 1 ); 
			FloatArray2DOctave.upsample( fa, fat );
			fa = fat;
			fa = Filter.computeGaussianFastMirror( fa, ( float )Math.sqrt( initial_sigma * initial_sigma - 1.0 ) );
		}
		else
			fa = Filter.computeGaussianFastMirror( fa, ( float )Math.sqrt( initial_sigma * initial_sigma - 0.25 ) );
		
		long start_time = System.currentTimeMillis();
		System.out.print( "processing SIFT ..." );
		sift.init( fa, steps, initial_sigma, min_size, max_size );
		fs1 = sift.run( max_size );
		Collections.sort( fs1 );
		System.out.println( " took " + ( System.currentTimeMillis() - start_time ) + "ms" );
		
		System.out.println( fs1.size() + " features identified and processed" );
		
		ip2.setLineWidth( 1 );
		ip2.setColor( Color.red );
		for ( Feature f : fs1 )
		{
                    
			//System.out.println( f.location[ 0 ] + " " + f.location[ 1 ] + " " + f.scale + " " + f.orientation );
			drawSquare( ip2, new double[]{ f.location[ 0 ] / scale, f.location[ 1 ] / scale }, fdsize * 4.0 * ( double )f.scale / scale, ( double )f.orientation );
		}
	
		ImagePlus imp1 = new ImagePlus( imp.getTitle() + " Features ", ip2 );
                
                //if(bool)
		  // imp1.show();
                BufferedImage bi1=imp1.getBufferedImage();
                try
                {
                //ImageIO.write(bi1, "jpg",new File(fo));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
		
		Feature ft1=fs1.get(0);
                System.out.println("=== "+ft1.descriptor.length);
			
			
		for(int i=0;i<fs1.size();i++)	
		{
			float des[]=fs1.get(i).descriptor;
			for(int j=0;j<des.length;j++)
			{
				if(!at1.contains(des[j]))
					at1.add(des[j]);
			}
		}
		System.out.println(at1.size());
                
                for(int i=0;i<at1.size();i++)
                {
                    float v1=Float.parseFloat(at1.get(i).toString());
                    int cnt=0;
                    for(int j=0;j<fs1.size();j++)	
                    {
			float des[]=fs1.get(j).descriptor;
			for(int k=0;k<des.length;k++)
			{
                            if(v1==des[k])
                                cnt++;
			}
                    }
                    feat.add(v1+"#"+cnt);
                   // System.out.println(v1+" : "+cnt);
                }
                
		//return feat;
                //return at1;
                return fs1;
	}
    
}
