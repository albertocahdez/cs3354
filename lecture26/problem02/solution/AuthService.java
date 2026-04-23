public class AuthService {
	private RateLimitStrategy rateLimiter;

	// The strategy is injected, allowing the policy to change dynamically
	public void setRateLimitStrategy(RateLimitStrategy strategy) {
		this.rateLimiter = strategy;
	}

	public boolean login(String username, String password) {
		if (rateLimiter != null && !rateLimiter.isAllowed(username)) {
			return false;
		}

		// Authentication logic remains untouched regardless of policy
		System.out.println("User authenticated successfully.");
		return true;
	}
}
