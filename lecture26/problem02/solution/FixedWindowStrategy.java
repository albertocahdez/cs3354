public class FixedWindowStrategy implements RateLimitStrategy {
	@Override
	public boolean isAllowed(String username) {
		// Implementation of Fixed Window algorithm
		System.out.println("Applying Fixed Window rate limiting.");
		return true;
	}
}
