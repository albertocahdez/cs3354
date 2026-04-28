public class Shelf {
	private Book[] books = new Book[10];
	private int count = 0;

	public void addBook(Book b) {
		if (count < books.length)
			books[count++] = b;
	}

	public MyIterator<Book> createIterator() {
		return new ShelfIterator();
	}

	// Inner class hides the traversal logic
	private class ShelfIterator implements MyIterator<Book> {
		private int position = 0;

		public boolean hasNext() {
			return position < count && books[position] != null;
		}

		public Book next() {
			return books[position++];
		}
	}
}
