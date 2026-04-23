class LoggingDecorator extends ServiceDecorator {
	public LoggingDecorator(DataService s) {
		super(s);
	}

	@Override
	public String fetchData(String id) {
		System.out.println("[LOG] Requesting ID: " + id);
		return super.fetchData(id);
	}
}


class RetryDecorator extends ServiceDecorator {
	public RetryDecorator(DataService s) {
		super(s);
	}

	@Override
	public String fetchData(String id) {
		System.out.println("[RETRY] Attempting fetch...");
		return super.fetchData(id);
	}
}


class CachingDecorator extends ServiceDecorator {
	public CachingDecorator(DataService s) {
		super(s);
	}

	@Override
	public String fetchData(String id) {
		System.out.println("[CACHE] Checking local storage...");
		return super.fetchData(id);
	}
}
