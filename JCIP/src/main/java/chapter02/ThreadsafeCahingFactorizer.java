package chapter02;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadsafeCahingFactorizer extends HttpServlet {

	/**
	 * 
	 */
	@GuardedBy("this")
	private BigInteger lastNumber;

	@GuardedBy("this")
	private BigInteger[] lastFactors;

	@GuardedBy("this")
	private long hits;

	@GuardedBy("this")
	private long cacheHits;

	private static final long serialVersionUID = -9203693577820754372L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = null;

		synchronized (this) {
			hits++;
			if (i.equals(lastNumber)) {
				// make defensive copy, shadow copy
				factors = lastFactors.clone();
				cacheHits++;
			}
		}
		if (factors == null) {
			factors = factor(i);
			synchronized (this) {
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}

		logCacheHitsInfo();
		encodeIntoResponse(resp, factors);
	}

	@ThreadSafeMethod
	@GuardedBy("this")
	private synchronized void logCacheHitsInfo() {
		// no need to use synchronized getHits,...
		// hits and cacheHits are involved in a invariant, and guarded by this
		System.out.println(getHits());
		System.out.println(getCacheHits());
		System.out.println(getCacheHitRate());
	}

	@NotThreadSafeMethod
	private void logCacheHitsInfo1() {
		// not thread safe event all methods are thread safe
		System.out.println(hits);
		System.out.println(cacheHits);
		System.out.println(getCacheHitRate0());
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

	public synchronized long getHits() {
		return hits;
	}

	@NotUsed
	public synchronized void setHits(long hits) {
		this.hits = hits;
	}

	public synchronized long getCacheHits() {
		return cacheHits;
	}

	@NotUsed
	public synchronized void setCacheHits(long cacheHits) {
		this.cacheHits = cacheHits;
	}

	public synchronized double getCacheHitRate() {
		return getCacheHitRate0();
	}

	@NotThreadSafeMethod
	public double getCacheHitRate0() {
		return cacheHits / hits;
	}
}
