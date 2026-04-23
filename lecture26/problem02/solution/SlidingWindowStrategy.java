public class SlidingWindowStrategy implements RateLimitStrategy {
	@Override
	public boolean isAllowed(String username) {
		// Implementation of Sliding Window Log or Sliding Window Counter
		System.out.println("Applying Sliding Window rate limiting for high-precision tracking.");

		// Logic: Check timestamps of requests within the last 'X' seconds
		return true;
	}
}
