package chapter02;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnThreadSafeCahingFactorizer extends HttpServlet {

	/**
	 * 
	 */
	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();
	private static final long serialVersionUID = -9203693577820754372L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = null;
		if (i.equals(lastNumber.get())) {
			factors = lastFactors.get();
		} else {
			factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
		}

		encodeIntoResponse(resp, factors);
	}

	private void encodeIntoResponse(HttpServletResponse resp,
			BigInteger[] factors) {
	}

	private BigInteger[] factor(BigInteger i) {
		return null;
	}

	private BigInteger extractFromRequest(HttpServletRequest req) {
		return new BigInteger("123");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
