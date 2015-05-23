package fluentd;

import java.util.HashMap;
import java.util.Map;

import org.fluentd.logger.FluentLogger;

public class Fluentd {
	private static FluentLogger LOG = FluentLogger.getLogger("app");

	public static void doApplicationLogic() {
		// ...
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("from", "userA");
		data.put("to", "userB");
		LOG.log("follow", data);
		// ...
	}
	
	public static void main(String[] args) {
		doApplicationLogic();
	}
}
