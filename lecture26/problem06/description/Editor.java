public class Editor {
	public static void main(String[] args) {
		BitmapImage bitmap = new BitmapImage();

		// The editor is forced to do manual conversion logic
		System.out.println("Editor drawing a 'Vector' Point...");
		int x = 10;
		int y = 20;

		// Editor must know how the Bitmap library works internally
		bitmap.setPixel(x, y, 0x000000);
		bitmap.renderBuffer();
	}
}
