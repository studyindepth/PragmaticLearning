package di.api;

public interface Container {
	<T> T getBean(Class<T> clazz);
}
