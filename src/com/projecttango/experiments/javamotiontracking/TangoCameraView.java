package com.projecttango.experiments.javamotiontracking;

import java.io.IOException;

import com.google.atap.tangoservice.Tango;
import com.google.atap.tangoservice.TangoConfig;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public class TangoCameraView extends SurfaceView implements SurfaceHolder.Callback {


	private SurfaceView surfaceView;
	private SurfaceHolder surfaceHolder;
	private Tango mTango;

	private Camera camera;
	private static final String TAG = TangoCameraView.class.getSimpleName();

	public TangoCameraView( Context context, Tango aTango ) {
		super( context );
		mTango=aTango;
		// We're implementing the Callback interface and want to get notified
		// about certain surface events.
		getHolder().addCallback( this );
		// We're changing the surface to a PUSH surface, meaning we're receiving
		// all buffer data from another component - the camera, in this case.
		getHolder().setType( SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS );
	}

	public TangoCameraView(Context context, AttributeSet attrs, Tango aTango) {
		super(context, attrs);		
		mTango=aTango;
		// We're implementing the Callback interface and want to get notified
		// about certain surface events.
		getHolder().addCallback( this );
		// We're changing the surface to a PUSH surface, meaning we're receiving
		// all buffer data from another component - the camera, in this case.
		getHolder().setType( SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS );
	}



	public void surfaceCreated( SurfaceHolder holder ) {
		// Once the surface is created, simply open a handle to the camera hardware.
		//camera = Camera.open();
		Surface surface = holder.getSurface();
		if (surface.isValid()) {
			///////////THIS IS A KEY LINE WHERE TANGO SURFACE IS MAPPED///////////////
			mTango.connectSurface(0, surface);
			Log.i(TAG, "tango surface connected :)");
			//mTango.connect(config);
		} else {

			Log.i(TAG, "tango surface not connected :(");
		}
		Log.i(TAG, "surfaceCreated");
	}

	public void surfaceChanged( SurfaceHolder holder, int format, int width, int height ) {
		// This method is called when the surface changes, e.g. when it's size is set.
		// We use the opportunity to initialize the camera preview display dimensions.
		//Camera.Parameters p = camera.getParameters();
		//p.setPreviewSize( width, height );
		//camera.setParameters( p );
		Log.i(TAG, "surfcaeChanged");

	}

	public void surfaceDestroyed( SurfaceHolder holder ) {
		// Once the surface gets destroyed, we stop the preview mode and release
		// the whole camera since we no longer need it.
		mTango.disconnectSurface(0);
	}
}