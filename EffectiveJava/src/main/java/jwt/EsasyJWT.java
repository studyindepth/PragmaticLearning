package jwt;

import java.util.Base64;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class EsasyJWT {
	public static void main(String[] args) {
		// Key key = MacProvider.generateKey();
		// System.out.println(key.getEncoded());
		// String s =
		// Jwts.builder().setSubject("11").signWith(SignatureAlgorithm.HS512,
		// key).compact();
		// System.out.println(s);
		// Key key1 = MacProvider.generateKey();
		// Claims content =
		// Jwts.parser().setSigningKey(key).parseClaimsJws(s).getBody();//
		// .getSubject();
		// System.out.println(content.getSubject());

		byte[] secretKey = Base64.getEncoder().encode("java".getBytes());
		String java = new String(Base64.getDecoder().decode(secretKey));
		System.out.println(java);
		System.out.println(secretKey.length);
		String stringKey = new String(secretKey);
		System.out.println(stringKey);

		String token = Jwts.builder().setSubject("toando").signWith(SignatureAlgorithm.HS512, stringKey).compact();
		System.out.println(token);

		long start = System.nanoTime();
		String username = Jwts.parser().setSigningKey(stringKey).parseClaimsJws(token).getBody().getSubject();
		long end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(username);
	}
}
