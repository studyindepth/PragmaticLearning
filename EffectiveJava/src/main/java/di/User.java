package di;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class User {
    private String name;

    public User() {
    }

    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException {
        Constructor<?>[] cons = User.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        Field name = User.class.getDeclaredField("name");
        name.set(o, "toan");
        System.out.println(o);

        User u = (User) o;
        
        System.out.println(u);
    }
}
