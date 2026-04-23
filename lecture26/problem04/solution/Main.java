public class Main {
	public static void main(String[] args) {
		// Combine them all: Logging -> Retry -> Cache -> Core
		DataService myService = new LoggingDecorator(
				new RetryDecorator(new CachingDecorator(new CoreDataService())));

		System.out.println(myService.fetchData("user_123"));
	}
}
