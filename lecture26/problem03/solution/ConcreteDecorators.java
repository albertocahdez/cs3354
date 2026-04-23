// concrete decorators
class BufferedDecorator extends StreamDecorator {
	public BufferedDecorator(CustomInputStream s) {
		super(s);
	}

	@Override
	public void read() {
		System.out.print("Buffering -> ");
		super.read();
	}
}


class EncryptionDecorator extends StreamDecorator {
	public EncryptionDecorator(CustomInputStream s) {
		super(s);
	}

	@Override
	public void read() {
		System.out.print("Decrypting -> ");
		super.read();
	}
}
