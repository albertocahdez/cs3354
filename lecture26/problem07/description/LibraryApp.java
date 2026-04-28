import java.util.*;

public class LibraryApp {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book("The Hobbit"));

		LinkedList<Member> members = new LinkedList<>();
		members.add(new Member("Alice"));

		Book[] shelf = {new Book("Two towers"), new Book("Scott Pilgrim")};

		// 1. Traversing ArrayList (Using index)
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).title);
		}

		// 2. Traversing LinkedList (Using a specific linked iterator)
		for (Member m : members) {
			System.out.println(m.name);
		}

		// 3. Traversing Array (Using index)
		for (int i = 0; i < shelf.length; i++) {
			System.out.println(shelf[i].title);
		}

		// This approach is messy because if the "Shelf" changes
		// from an Array to a Tree, this code breaks.
	}
}
