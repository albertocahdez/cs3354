// Core Service
class DataService {
	public String fetchData(String id) {
		return "Data for " + id;
	}
}


// Adding Logging... easy enough.
class LoggingDataService extends DataService {
	@Override
	public String fetchData(String id) {
		System.out.println("Logging: Fetching " + id);
		return super.fetchData(id);
	}
}


// Adding Caching... okay.
class CachingDataService extends DataService {
	@Override
	public String fetchData(String id) {
		System.out.println("Checking Cache...");
		return super.fetchData(id);
	}
}


// BUT: What if I want BOTH Logging and Caching?
// I have to create a brand new class. This is unsustainable.
class LoggingAndCachingDataService extends LoggingDataService {
	@Override
	public String fetchData(String id) {
		System.out.println("Checking Cache...");
		return super.fetchData(id);
	}
}
