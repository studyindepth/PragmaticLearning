package hash;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class MurmurHashing {
	public static void main(String[] args) {
		HashFunction function = Hashing.murmur3_32(256);
		
		long s = System.currentTimeMillis();
		HashCode hashCode = function.hashUnencodedChars(
				"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/43.0.2357.81 Chrome/43.0.2357.81 Safari/537.36");
		System.out.println(hashCode.asInt());
		long e = System.currentTimeMillis();
		
		System.out.println(e - s);
	}
}
