package proxy.java;

public interface Command<T> {
	T run();
	T calc(int i);
}
