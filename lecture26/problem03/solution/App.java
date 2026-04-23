public class App {
	public static void main(String[] args) {
		// We can mix and match any combination at runtime!
		CustomInputStream stream =
				new EncryptionDecorator(new BufferedDecorator(new BaseInputStream()));

		// Output: Decrypting -> Buffering -> Reading raw data
		stream.read();
	}
}
