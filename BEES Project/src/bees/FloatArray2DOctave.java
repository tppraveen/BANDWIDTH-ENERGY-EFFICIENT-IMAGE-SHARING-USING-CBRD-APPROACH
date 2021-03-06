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
public class FloatArray2DOctave 
{
     public enum State { EMPTY, STUB, COMPLETE }

	public State state = State.EMPTY;
	
	public int width = 0;
	public int height = 0;
	
	private float K = 2.0f; 
	private float K_MIN1_INV = 1.0f / ( K - 1.0f );

	/**
	 * steps per octave
	 * 
	 * an octave consists of STEPS + 3 images to be 
	 */
	public int STEPS = 1;
	
	/**
	 * sigma of gaussian kernels corresponding to the steps of the octave
	 * 
	 * the first member is the sigma of the gaussian kernel that is assumed to
	 * be the generating kernel of the first gaussian image instance of the
	 * octave 
	 */
	public float[] SIGMA;
//	public float[] getSigma()
//	{
//		return SIGMA;
//	}
	
	/**
	 * sigma of gaussian kernels required to create the corresponding gaussian
	 * image instances from the first one
	 */
	private float[] SIGMA_DIFF;
	
	/**
	 * 1D gaussian kernels required to create the corresponding gaussian
	 * image instances from the first one
	 */
	private float[][] KERNEL_DIFF;
	
	/**
	 * gaussian smoothed images
	 */
	private FloatArray2D[] l;
	public FloatArray2D[] getL()
	{
		return l;
	}
	public FloatArray2D getL( int i )
	{
		return l[ i ];
	}
	
	/**
	 * scale normalised difference of gaussian images
	 */
	private FloatArray2D[] d;
	public FloatArray2D[] getD()
	{
		return d;
	}
	public FloatArray2D getD( int i )
	{
		return d[ i ];
	}
	
	/**
	 * gradients of the gaussian smoothed images; 0=>amplitudes; 1=>orientations
	 */
	private FloatArray2D[][] l1;
	/**
	 * get the gradients of the corresponding gaussian image, generates it on
	 * demand, if not yet available.
	 * 
	 * @param i index will not be checked for efficiency reasons, so take care
	 *   that it is within a valid range
	 *
	 * @returns reference to the gradients
	 */
	public FloatArray2D[] getL1( int i )
	{
		if ( l1[ i ] == null )
		{
			l1[ i ] = Filter.createGradients( l[ i ] );
		}
		return l1[ i ];
	}
	
	/**
	 * Constructor
	 * 
	 * @param img image being the first gaussian instance of the scale octave
	 *   img must be a 2d-array of float values in range [0.0f, ..., 1.0f]
	 * @param initial_sigma inital gaussian sigma
	 */
	public FloatArray2DOctave(
			FloatArray2D img,
			int steps,
			float initial_sigma )
	{
		state = State.EMPTY;
		
		width = img.width;
		height = img.height;
		
		STEPS = steps;
		
		K = ( float )Math.pow( 2.0, 1.0 / ( float )STEPS );
		K_MIN1_INV = 1.0f / ( K - 1.0f );
			
		SIGMA = new float[ STEPS + 3 ];
		SIGMA[ 0 ] = initial_sigma;
		SIGMA_DIFF = new float[ STEPS + 3 ];
		SIGMA_DIFF[ 0 ] = 0.0f;
		KERNEL_DIFF = new float[ STEPS + 3 ][];
		
		//System.out.println( "sigma[0] = " + SIGMA[ 0 ] + "; sigma_diff[0] = " + SIGMA_DIFF[ 0 ] );
			
		for ( int i = 1; i < STEPS + 3; ++i )
		{
			SIGMA[ i ] = initial_sigma * ( float )Math.pow( 2.0f, ( float )i / ( float )STEPS );
			SIGMA_DIFF[ i ] = ( float )Math.sqrt( SIGMA[ i ] * SIGMA[ i ] - initial_sigma * initial_sigma );
			
			//System.out.println( "sigma[" + i + "] = " + SIGMA[ i ] + "; sigma_diff[" + i + "] = " + SIGMA_DIFF[ i ] );

			KERNEL_DIFF[ i ] = Filter.createGaussianKernel1D(
					SIGMA_DIFF[ i ],
					true );
		}
		l = new FloatArray2D[ 1 ];
		l[ 0 ] = img;
		d = null;
		l1 = null;		
	}
	
	/**
	 * Constructor
	 * 
	 * faster initialisation with precomputed gaussian kernels
	 * 
	 * @param img image being the first gaussian instance of the scale octave 
	 * @param initial_sigma inital gaussian sigma
	 * 
	 */
	public FloatArray2DOctave(
			FloatArray2D img,
			float[] sigma,
			float[] sigma_diff,
			float[][] kernel_diff )
	{
		state = State.EMPTY;
		
		width = img.width;
		height = img.height;
		
		STEPS = sigma.length - 3;
		
		K = ( float )Math.pow( 2.0, 1.0 / ( float )STEPS );
		K_MIN1_INV = 1.0f / ( K - 1.0f );
			
		SIGMA = sigma;
		SIGMA_DIFF = sigma_diff;
		KERNEL_DIFF = kernel_diff;
		
		l = new FloatArray2D[ 1 ];
		l[ 0 ] = img;
		d = null;
		l1 = null;		
	}
	
	/**
	 * build only the gaussian image with 2 * INITIAL_SIGMA
	 * 
	 * Use this method for the partial creation of an octaved scale space
	 * without creating each scale octave.  Like proposed by Lowe
	 * \citep{Lowe04}, you can use this image to build the next scale octave.
	 * Taking every second pixel of this image, you get a gaussian  image with
	 * INITIAL_SIGMA of the half image size.
	 */
	public void buildStub()
	{
		FloatArray2D img = l[ 0 ];
		l = new FloatArray2D[ 2 ];
		l[ 0 ] = img;
		l[ 1 ] = Filter.convolveSeparable( l[ 0 ], KERNEL_DIFF[ STEPS ], KERNEL_DIFF[ STEPS ] );
		             
		state = State.STUB;
	}
	
	
	/**
	 * build the scale octave
	 */
	public boolean build()
	{
		FloatArray2D img = l[ 0 ];
		FloatArray2D img2;
		if ( state == State.STUB )
		{
			img2 = l[ 1 ];
			l = new FloatArray2D[ STEPS + 3 ];
			l[ STEPS ] = img2;
		}
		else l = new FloatArray2D[ STEPS + 3 ];
		l[ 0 ] = img;
		for ( int i = 1; i < SIGMA_DIFF.length; ++i )
		{
			if ( state == State.STUB && i == STEPS ) continue;
			// use precomputed kernels
			l[ i ] = Filter.convolveSeparable( l[ 0 ], KERNEL_DIFF[ i ], KERNEL_DIFF[ i ] );
			//l[ i ] = ImageFilter.computeGaussian( l[ 0 ], SIGMA_DIFF[ i ] );
		}
		d = new FloatArray2D[ STEPS + 2 ];
		for ( int i = 0; i < d.length; ++i )
		{
			d[ i ] = new FloatArray2D( l[ i ].width, l[ i ].height );
			int j = i + 1;
			for ( int k = 0; k < l[ i ].data.length; ++k )
			{
				d[ i ].data[ k ] = ( l[ j ].data[ k ] - l[ i ].data[ k ] ) * K_MIN1_INV;
			}
		}
		l1 = new FloatArray2D[ STEPS + 3 ][];
		for ( int i = 0; i < l1.length; ++i )
		{
			l1[ i ] = null;
		}
		
		state = State.COMPLETE;
		
		return true;
	}
	
	/**
	 * clear the scale octave to save memory
	 */
	public void clear()
	{
		this.state = State.EMPTY;
		this.d = null;
		this.l = null;
		this.l1 = null;
	}


	/**
	 * downsample {@link src} by simply using every second pixel into
	 * {@link dst}
	 * 
	 * For efficiency reasons, the dimensions of {@link dst} are not checked,
	 * that is, you have to take care, that
	 * dst.width == src.width / 2 + src.width % 2 &&
	 * dst.height == src.height / 2 + src.height % 2 .
	 * 
	 * @param src the source image
	 * @param dst destination image
	 */
	public static void downsample( FloatArray2D src, FloatArray2D dst )
	{
		int ws = 2 * src.width;
		int rs = 0;
		for ( int r = 0; r < dst.data.length; r += dst.width )
		{
			int xs = 0;
			for ( int x = 0; x < dst.width; ++x )
			{
				dst.data[ r + x ] = src.data[ rs + xs ];
				xs += 2;
			}
			rs += ws;
		}
	}
	
	/**
	 * upsample {@link src} by linearly interpolating into {@link dst}
	 * 
	 * For efficiency reasons, the dimensions of {@link dst} are not checked,
	 * that is, you have to take care, that
	 * src.width == dst.width / 2 + dst.width % 2 &&
	 * src.height == dst.height / 2 + dst.height % 2 .
	 * 
	 * @param src the source image
	 * @param dst destination image
	 */
	public static void upsample( FloatArray2D src, FloatArray2D dst )
	{
		int rdw = 2 * dst.width;
		int rd1 = rdw;
		int rd2 = dst.width;
		int xd1 = 2;
		int xd2 = 1;
		dst.data[ 0 ] = src.data[ 0 ];
		for ( int xs1 = 1; xs1 < src.width; ++xs1 )
		{
			int xs2 = xs1 - 1;
			dst.data[ xd1 ] = src.data[ xs1 ];
			dst.data[ xd2 ] = ( src.data[ xs1 ] + src.data[ xs2 ] ) / 2.0f;
			xd1 += 2;
			xd2 += 2;
		}
		for ( int rs1 = src.width; rs1 < src.data.length; rs1 += src.width )
		{
			int rs2 = rs1 - src.width;
			xd1 = 2;
			xd2 = 1;
			dst.data[ rd1 ] = src.data[ rs1 ];
			dst.data[ rd2 ] = ( src.data[ rs1 ] + src.data[ rs2 ] ) / 2;
			
			for ( int xs1 = 1; xs1 < src.width; ++xs1 )
			{
				int xs2 = xs1 - 1;
				dst.data[ rd1 + xd1 ] = src.data[ rs1 + xs1 ];
				dst.data[ rd1 + xd2 ] = ( src.data[ rs1 + xs1 ] + src.data[ rs1 + xs2 ] ) / 2.0f;
				dst.data[ rd2 + xd1 ] = ( src.data[ rs1 + xs1 ] + src.data[ rs2 + xs1 ] ) / 2.0f;
				dst.data[ rd2 + xd2 ] = ( src.data[ rs1 + xs1 ] + src.data[ rs2 + xs2 ] ) / 2.0f;
				xd1 += 2;
				xd2 += 2;
			}
			rd1 += rdw;
			rd2 += rdw;
		}
		if ( dst.height % 2 == 0 )
		{
			rd1 = dst.data.length - dst.width;
			rd2 = rd1 - dst.width;
			for ( xd1 = 0; xd1 < dst.width; ++xd1 )
			{
				dst.data[ rd1 + xd1 ] = dst.data[ rd2 + xd1 ];
			}
		}
		if ( dst.height % 2 == 0 )
		{
			xd1 = dst.width - 1;
			xd2 = dst.width - 2;
			for ( rd1 = 0; rd1 < dst.data.length; rd1 += dst.width )
			{
				dst.data[ rd1 + xd1 ] = dst.data[ rd1 + xd2 ];
			}
		}
	}
}
