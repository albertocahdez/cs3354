package problem06.description;

public class BitmapImage {
	public void setPixel(int x, int y, int color) {
		System.out.println("Setting pixel at (" + x + "," + y + ") to color " + color);
	}

	public void renderBuffer() {
		System.out.println("Rendering bitmap buffer to screen.");
	}
}
