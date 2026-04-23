public abstract class ServiceDecorator implements DataService {
	protected DataService wrappedService;

	public ServiceDecorator(DataService service) {
		this.wrappedService = service;
	}

	@Override
	public String fetchData(String id) {
		return wrappedService.fetchData(id);
	}
}
