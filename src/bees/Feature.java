/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bees;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Feature implements Comparable< Feature >, Serializable
{
	public float scale;
	public float orientation;
	public float[] location;
	public float[] descriptor;

	
	public Feature() {}
	
	public Feature( float s, float o, float[] l, float[] d )
	{
		scale = s;
		orientation = o;
		location = l;
		descriptor = d;
	}

	
	public int compareTo( Feature f )
	{
		return scale < f.scale ? 1 : scale == f.scale ? 0 : -1;
	}
	
	public float descriptorDistance( Feature f )
	{
		float d = 0;
		for ( int i = 0; i < descriptor.length; ++i )
		{
			float a = descriptor[ i ] - f.descriptor[ i ];
			d += a * a;
                       /* if(f.descriptor[i]==0)
                            d = d+(a * a);
                        else
                            d = d+((a * a)/f.descriptor[ i ]);
                        //System.out.print(descriptor[i]+" ");*/
		}
                //System.out.println("dis "+d);
		//return ( float )Math.sqrt( d );
                return d;
	}
}
