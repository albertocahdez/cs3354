public class ArrayExample {

	class Weeble {
		// This is an empty class
	}

	public static void main(String[] args) {
		Weeble[] c = new Weeble[4]; // Array of references of Weeble type
		for (int i = 0; i < c.length; i++)
			if (c[i] == null) // test for null reference
				c[i] = new Weeble();
		int[] a = new int[20]; // Array of integer variables
		String[] Array = new String[20]; // Array of String objects
	}
}
