package spark;

import static spark.Spark.get;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import spark.route.HttpMethod;
import spark.route.RouteMatcherFactory;

public class SparkJava {
	public static void main(String[] args) throws InterruptedException {
		get("/1", (req, res) -> "1");

		Executor ex = Executors.newSingleThreadExecutor();
		ex.execute(new Reader());
		Thread.sleep(1000);
		ex.execute(new Reader());
		get("/2", (req, res) -> "2");
		ex.execute(new Reader());
		System.out.println("222222");

	}
}

class Reader implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		System.out.println(RouteMatcherFactory.get().findTargetForRequestedRoute(HttpMethod.get, "/2",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"));
	}

}

class Hello {
	public static void start() {
		get("/hello/:name", (req, res) -> {
			String name = req.params("name");
			return "Hi " + name;
		});

	}
}
