package hash;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class MurmurHashing {
	public static void main(String[] args) {
		HashFunction function = Hashing.murmur3_32(256);
		HashCode hashCode = function.hashBytes("12".getBytes(StandardCharsets.UTF_8));
		System.out.println(hashCode.getClass());
		System.out.println(hashCode.asInt());
		System.out.println(hashCode);
	}
}
