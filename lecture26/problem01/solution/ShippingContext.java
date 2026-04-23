public class ShippingContext {
	private ShippingStrategy strategy;

	// Allows dynamic switching of policies at runtime
	public void setStrategy(ShippingStrategy strategy) {
		this.strategy = strategy;
	}

	public double executeStrategy(double weight, double distance) {
		if (strategy == null) {
			throw new IllegalStateException("Shipping strategy not set");
		}
		return strategy.calculate(weight, distance);
	}
}
