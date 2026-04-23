// Base class
class SimpleInputStream {
	public void read() {
		System.out.println("Reading base data...");
	}
}


// What if I want buffering?
class BufferedInputStream extends SimpleInputStream {
	@Override
	public void read() {
		System.out.print("Buffering -> ");
		super.read();
	}
}


// What if I want buffering AND encryption?
// I have to create a specific class for this combination!
class BufferedEncryptedInputStream extends BufferedInputStream {
	@Override
	public void read() {
		System.out.print("Decrypting -> ");
		super.read();
	}
}

// The problem: What if I want just Encryption? Or Compression and Buffering?
// You end up with N! classes.
