package encoding;

import java.util.Base64;

public class Base64s {
	public static void main(String[] args) {
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode("ifa=090AA000-9999-9999-99B9-123456FABCDE&atsi=1&ati=1".getBytes());
		String param = new String(encodedBytes);
		System.out.println(param);
	}
}
