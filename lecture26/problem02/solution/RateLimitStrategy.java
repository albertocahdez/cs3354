public interface RateLimitStrategy {
	boolean isAllowed(String username);
}
