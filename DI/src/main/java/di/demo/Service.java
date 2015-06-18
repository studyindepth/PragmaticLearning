package di.demo;

import di.api.Bean;
import di.api.Injected;

@Bean
public class Service {
	@Injected
	private Repository repo;

	public Repository getRepo() {
		return repo;
	}
}
