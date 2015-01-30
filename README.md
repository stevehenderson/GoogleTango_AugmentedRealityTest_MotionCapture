A test application for Augmented Reality and Google Tango Motion Tracking (Java)

It uses OpenGL 1.0

I started with the Tango SDK MotionCapture demo and added a caemra image to the background using the Tango *connectSurface* approach.

The demo is not a true AR application and is only to demonstrate (a) how to use a Tango connectSurface call tto a surface and (b) create an OpenGL scene over the camera view.  The Cube is screen-fixed for now.  The Tango position and orientation information are displayed in text boxes.

![ScreenShot](screenshot.jpg)
