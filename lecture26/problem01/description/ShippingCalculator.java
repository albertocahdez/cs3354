public class ShippingCalculator {
    public double calculateCost(String policy, double weight, double distance) {
        if (policy.equalsIgnoreCase("FLAT_RATE")) {
            return 10.0;
        } else if (policy.equalsIgnoreCase("WEIGHT_BASED")) {
            return weight * 2.5;
        } else if (policy.equalsIgnoreCase("DISTANCE_BASED")) {
            return distance * 0.75;
        } else if (policy.equalsIgnoreCase("CARRIER_SPECIFIC")) {
            // Complex logic for a specific carrier
            return (weight * 1.2) + (distance * 0.5);
        } else {
            throw new IllegalArgumentException("Unknown shipping policy");
        }
    }
}
