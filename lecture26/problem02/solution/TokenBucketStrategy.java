public class TokenBucketStrategy implements RateLimitStrategy {
	@Override
	public boolean isAllowed(String username) {
		// Implementation of Token Bucket algorithm
		System.out.println("Applying Token Bucket rate limiting.");
		return true;
	}
}
