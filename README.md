A test application for Augmented Reality and Google Tango Motion (Java).

This test application only feature these Motion Capture capabilities of the Google Tango.

I started with the Tango SDK MotionCapture demo and added a camera image to the background using the Tango *connectSurface* approach.  (See: http://stackoverflow.com/questions/26771558/getting-color-data-in-java-tango-sdk-or-c-sdk?rq=1)

The demo is not a validated AR application and is only to demonstrate (a) how to use a Tango connectSurface call to a SurfaceView  and (b) create an OpenGL scene over the camera view.  

The Camera and Tango need careful calibration to ensure the Augented Reality registration is as accurate as possible.

YouTube demo:  http://youtu.be/mwLznQ3lJ3s

![ScreenShot](screenshot.jpg)
