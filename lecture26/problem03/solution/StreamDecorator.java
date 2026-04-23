// decorator
public abstract class StreamDecorator implements CustomInputStream {
	protected CustomInputStream decoratedStream;

	public StreamDecorator(CustomInputStream stream) {
		this.decoratedStream = stream;
	}

	public void read() {
		decoratedStream.read();
	}
}
