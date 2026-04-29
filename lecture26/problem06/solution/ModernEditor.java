package problem06.solution;

public class ModernEditor {
	public static void main(String[] args) {
		// 1. The legacy bitmap object
		BitmapImage legacyBitmap = new BitmapImage();

		// 2. The adapter that makes the bitmap look like a VectorShape
		VectorShape shape = new BitmapToVectorAdapter(legacyBitmap, 0xFFFFFF);

		// 3. The editor uses the high-level interface only
		renderShape(shape);
	}

	private static void renderShape(VectorShape shape) {
		shape.draw(50, 50);
	}
}
