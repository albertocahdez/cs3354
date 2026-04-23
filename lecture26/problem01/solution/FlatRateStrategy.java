public class FlatRateStrategy implements ShippingStrategy {
	@Override
	public double calculate(double weight, double distance) {
		return 10.0;
	}
}
