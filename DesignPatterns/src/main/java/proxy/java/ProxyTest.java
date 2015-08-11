package proxy.java;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Command<String> command = (Command<String>) Proxy.newProxyInstance(
				Command.class.getClassLoader(), new Class[] { Command.class },
				(Object proxy, Method method, Object[] argss) -> {
					// method.invoke(proxy);
				// System.out.println(proxy);
				System.out.println(proxy.getClass());
				System.out.println(method.getName());
				System.out.println("running");
				return "test";
			});
		command.run();
		command.calc(1);
	}
}
