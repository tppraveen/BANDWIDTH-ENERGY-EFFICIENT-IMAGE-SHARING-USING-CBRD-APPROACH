/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bees;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author admin
 */
public class Graph1 
{
    Details dt=new Details();
    Graph1()
    {
        
    }
    
    public void displayGraph1()
    {
        try
        {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(int i=0;i<dt.graph1.size();i++)
            {
                String g1[]=dt.graph1.get(i).toString().split("#");
                dataset.setValue(Double.parseDouble(g1[0]),g1[1],"");
                
            }
            
            JFreeChart chart = ChartFactory.createBarChart
            ("Performance","", "Time (Seconds)", dataset, 
  
            PlotOrientation.VERTICAL, true,true, false);
  
            chart.getTitle().setPaint(Color.blue); 
  
            CategoryPlot p = chart.getCategoryPlot(); 
            final NumberAxis rangeAxis = (NumberAxis) p.getRangeAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            p.setRangeGridlinePaint(Color.red); 
              
            CategoryItemRenderer renderer = p.getRenderer();
      

            renderer.setSeriesPaint(0, Color.red);
            renderer.setSeriesPaint(1, Color.blue);	  
            renderer.setSeriesPaint(2, Color.green);
            
            ChartFrame frame1=new ChartFrame("Feature Extraction Time",chart);
  
            frame1.setSize(500,400);
  
            frame1.setVisible(true);
  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void displayGraph2()
    {
        try
        {
            final XYSeries series1 = new XYSeries("Original");
            final XYSeries series2 = new XYSeries("Compressed");
            
            
            for(int i=0;i<dt.graph2.size();i++)
            {
                String g1[]=dt.graph2.get(i).toString().split("#");
                double e1=Double.parseDouble(g1[0]);
                double e2=Double.parseDouble(g1[1]);
                
                series1.add(i+1, e1);
                series2.add(i+1, e2);                                
            }
            
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series1);
            dataset.addSeries(series2);
            
            
            JFreeChart chart = ChartFactory.createXYLineChart
            ("Quality Compression","Image", "File Size (kb)", dataset, 
  
            PlotOrientation.VERTICAL, true,true, false);
  
            chart.getTitle().setPaint(Color.blue); 
  
           final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
	renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

            
            ChartFrame frame1=new ChartFrame("Quality Compression",chart);
  
            frame1.setSize(500,400);
  
            frame1.setVisible(true);
  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void displayGraph3()
    {
        try
        {
            final XYSeries series1 = new XYSeries("Original");
            final XYSeries series2 = new XYSeries("Compressed");
            
            
            for(int i=0;i<dt.graph3.size();i++)
            {
                String g1[]=dt.graph3.get(i).toString().split("#");
                double e1=Double.parseDouble(g1[0]);
                double e2=Double.parseDouble(g1[1]);
                
                series1.add(i+1, e1);
                series2.add(i+1, e2);                                
            }
            
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series1);
            dataset.addSeries(series2);
            
            
            JFreeChart chart = ChartFactory.createXYLineChart
            ("Resolution Compression","Image", "File Size (kb)", dataset, 
  
            PlotOrientation.VERTICAL, true,true, false);
  
            chart.getTitle().setPaint(Color.blue); 
  
           final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
	renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

            
            ChartFrame frame1=new ChartFrame("Resolution Compression",chart);
  
            frame1.setSize(500,400);
  
            frame1.setVisible(true);
  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
