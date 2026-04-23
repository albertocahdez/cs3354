public class XmlLoggerAdapter implements JsonLogger {
	private LegacyXmlLogger legacyLogger;

	public XmlLoggerAdapter(LegacyXmlLogger legacyLogger) {
		this.legacyLogger = legacyLogger;
	}

	@Override
	public void log(String message) {
		// Translate the call from the new format to the legacy format
		String translatedXml = "<json_wrapper><msg>" + message + "</msg></json_wrapper>";
		legacyLogger.logXml(translatedXml);
	}
}
