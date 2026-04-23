// concrete component
public class BaseInputStream implements CustomInputStream {
	@Override
	public void read() {
		System.out.println("Reading raw data");
	}
}
