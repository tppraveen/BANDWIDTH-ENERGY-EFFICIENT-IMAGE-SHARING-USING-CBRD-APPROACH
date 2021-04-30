/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bees;
import java.util.Random;
import java.util.Collection;
import java.awt.geom.AffineTransform;
/**
 *
 * @author admin
 */
abstract public class Model 
{
    static final public int MIN_SET_SIZE = 0;
	
	// real random
	//final Random random = new Random( System.currentTimeMillis() );
	// repeatable results
	final static Random rnd = new Random( 69997 );

	/**
	 * error depends on what kind of algorithm is running
	 * small error is better than large error
	 */
	public double error;
	
	/**
	 * instantiates an empty model with maximally large error
	 */
	public Model()
	{
		error = Double.MAX_VALUE;
	}

	/**
	 * fit the model to a minimal set of point correpondences
	 * estimates a model to transform match.p2.local to match.p1.world
	 * 
	 * @param min_matches minimal set of point correpondences
	 * @return true if a model was estimated
	 */
	public abstract boolean fit( PointMatch[] min_matches );

	/**
	 * apply the model to a point location
	 * 
	 * @param point
	 * @return transformed point
	 */
	public abstract float[] apply( float[] point );
	
	/**
	 * apply the model to a point location
	 * 
	 * @param point
	 */
	public abstract void applyInPlace( float[] point );
	
	/**
	 * apply the inverse of the model to a point location
	 * 
	 * @param point
	 * @return transformed point
	 */
	public abstract float[] applyInverse( float[] point );
	
	/**
	 * apply the inverse of the model to a point location
	 * 
	 * @param point
	 */
	public abstract void applyInverseInPlace( float[] point );
	
	/**
	 * test the model for a set of point correspondence candidates
	 * 
	 * clears inliers and fills it with the fitting subset of candidates
	 * 
	 * @param candidates set of point correspondence candidates
	 * @param inliers set of point correspondences that fit the model
	 * @param epsilon maximal allowed transfer error
	 * @param min_inliers minimal ratio of inliers (0.0 => 0%, 1.0 => 100%)
	 */
	public boolean test(
			Collection< PointMatch > candidates,
			Collection< PointMatch > inliers,
			double epsilon,
			double min_inlier_ratio )
	{
		inliers.clear();
		
		for ( PointMatch m : candidates )
		{
			m.apply( this );
			if ( m.getDistance() < epsilon ) inliers.add( m );
		}
		
		float ir = ( float )inliers.size() / ( float )candidates.size();
		error = 1.0 - ir;
		if (error > 1.0)
			error = 1.0;
		if (error < 0)
			error = 0.0;
		
		return ( ir > min_inlier_ratio );
	}

	/**
	 * less than operater to make the models comparable, returns false for error < 0
	 * 
	 * @param m
	 * @return false for error < 0, otherwise true if this.error is smaller than m.error
	 */
	public boolean betterThan( Model m )
	{
		if ( error < 0 ) return false;
		return error < m.error;
	}
	
	/**
	 * randomly change the model a bit
	 * 
	 * estimates the necessary amount of shaking for each single dimensional
	 * distance in the set of matches
	 *
	 * @param matches point matches
	 * @param scale gives a multiplicative factor to each dimensional distance (scales the amount of shaking)
	 * @param center local pivot point for centered shakes (e.g. rotation)
	 */
	abstract public void shake(
			Collection< PointMatch > matches,
			float scale,
			float[] center );
	
	abstract public void minimize( Collection< PointMatch > matches );
	
	abstract public AffineTransform getAffine();

	/**
	 * string to output stream
	 */
	abstract public String toString();
	
	/**
	 * clone
	 */
	abstract public Model clone();
};
