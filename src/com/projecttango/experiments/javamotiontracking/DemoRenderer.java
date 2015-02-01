package com.projecttango.experiments.javamotiontracking;

public interface DemoRenderer {
	public void setCameraPosition(float x, float y, float z);
	public void setCameraAngles(float qx, float qy, float qz, float qw);
}
