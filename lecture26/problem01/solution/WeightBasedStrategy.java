public class WeightBasedStrategy implements ShippingStrategy {
	@Override
	public double calculate(double weight, double distance) {
		return weight * 2.5;
	}
}
