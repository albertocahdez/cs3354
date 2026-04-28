public class UnifiedLibraryApp {
	public static void main(String[] args) {
		Shelf shelf = new Shelf();
		shelf.addBook(new Book("Design Patterns"));
		shelf.addBook(new Book("Clean Code"));

		// The App doesn't know 'Shelf' uses an Array internally
		MyIterator<Book> iterator = shelf.createIterator();

		printItems(iterator);
	}

	// This method can now print ANY collection that provides our Iterator
	private static void printItems(MyIterator<?> iterator) {
		while (iterator.hasNext()) {
			System.out.println("Item: " + iterator.next());
		}
	}
}
