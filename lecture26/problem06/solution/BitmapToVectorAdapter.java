public class BitmapToVectorAdapter implements VectorShape {
	private BitmapImage bitmapImage;
	private int colorCode;

	public BitmapToVectorAdapter(BitmapImage bitmapImage, int colorCode) {
		this.bitmapImage = bitmapImage;
		this.colorCode = colorCode;
	}

	@Override
	public void draw(int x, int y) {
		// Translating a "Vector Draw" command into "Bitmap Pixel" commands
		bitmapImage.setPixel(x, y, colorCode);
		bitmapImage.renderBuffer();
	}
}
