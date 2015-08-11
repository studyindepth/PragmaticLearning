package proxy;

public class ProxyImage implements Image {

	private Image image;

	@Override
	public void display() {
		if (image == null) {
			image = new RealImage();
		}

		before();
		image.display();
		after();
	}

	private void before() {

	}

	private void after() {

	}

	public ProxyImage() {
	}

}
