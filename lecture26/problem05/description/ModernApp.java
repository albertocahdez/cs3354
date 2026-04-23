public class ModernApp {
	private LegacyXmlLogger legacyLogger = new LegacyXmlLogger();

	public void processData(String message) {
		// Business logic...
		System.out.println("Processing data: " + message);

		// INCORRECT: The app is now responsible for XML formatting
		// just to satisfy the legacy logger. This is messy!
		String xmlLog = "<log><message>" + message + "</message><type>JSON_PROXY</type></log>";
		legacyLogger.logXml(xmlLog);
	}
}


class LegacyXmlLogger {
	public void logXml(String xmlData) {
		System.out.println("Legacy XML Log: " + xmlData);
	}
}
