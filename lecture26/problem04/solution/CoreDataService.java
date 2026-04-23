public class CoreDataService implements DataService {
	@Override
	public String fetchData(String id) {
		// The core business logic stays clean
		return "Real Data from Repository for " + id;
	}
}
