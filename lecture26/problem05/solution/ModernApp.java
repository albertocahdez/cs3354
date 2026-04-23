public class ModernApp {
	private JsonLogger logger;

	public ModernApp(JsonLogger logger) {
		this.logger = logger;
	}

	public void run() {
		// The app speaks "JSON", the adapter handles the rest
		logger.log("User logged in successfully");
	}

	public static void main(String[] args) {
		LegacyXmlLogger legacy = new LegacyXmlLogger();
		JsonLogger adapter = new XmlLoggerAdapter(legacy);

		ModernApp app = new ModernApp(adapter);
		app.run();
	}
}
