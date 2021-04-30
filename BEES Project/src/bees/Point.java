/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bees;

/**
 *
 * @author admin
 */
public class Point 
{
    private float[] w;
	final public float[] getW() { return w; }
	
	/**
	 * local coordinates
	 */
	final private float[] l;
	final public float[] getL() { return l; }
	
	/**
	 * Constructor
	 *          
	 * sets this.l to the given float[] reference
	 * 
	 * @param l reference to the local coordinates of the point
	 */
	public Point( float[] l )
	{
		this.l = l;
//		new float[ l.length ];
		w = l.clone();		
	}
	
	/**
	 * apply a model to the point
	 * 
	 * transfers the local coordinates to new world coordinates
	 */
	final public void apply( Model model )
	{
		w = model.apply( l );
	}
	
	/**
	 * estimate the Euclidean distance of two points in the world
	 *  
	 * @param p1
	 * @param p2
	 * @return Euclidean distance
	 */
	final public static float distance( Point p1, Point p2 )
	{
		double sum = 0.0;
		for ( int i = 0; i < p1.w.length; ++i )
		{
			double d = p1.w[ i ] - p2.w[ i ];
			sum += d * d;
		}
		return ( float )Math.sqrt( sum );
	}
}
