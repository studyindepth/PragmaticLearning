package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    public static void run(Class<?> testClass) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException {
        Object o = testClass.newInstance();
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(o);
                    System.out.println(m + " passed ");
                } catch (InvocationTargetException e) {
                    if (m.isAnnotationPresent(Expected.class)) {
                        Expected ex = m.getAnnotation(Expected.class);
                        if (ex.value().isInstance(e.getCause())) {
                            System.out.println(m + " passed with expected "
                                    + e.getCause());
                        } else {
                            System.out.println(m + " failed " + e.getCause());
                        }
                    } else {
                        System.out.println(m + " failed " + e.getCause());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException {
        run(UseTest.class);
        String s = (new TestRunner()).toString();
        System.out.println(s);
    }
}
