package proxy;

public class RealImage implements Image {

	public RealImage() {
		load();
	}

	@Override
	public void display() {
		// why not load here
		System.out.println("displaying");
	}

	private void load() {
		System.out.println("loaded");
	}
}
