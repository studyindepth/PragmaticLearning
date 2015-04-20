package bytecodes;

import guava.basicutilities.TablesType;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class ClassPools {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ct = pool.get("guava.basicutilities.TablesType");
        CtMethod m = ct.getDeclaredMethod("say");
        CtMethod m1 = ct.getDeclaredMethod("main");
        m.insertBefore("System.out.println(\"before calling main\");");
        m1.insertBefore("System.out.println(\"before calling main\");");
        Class<?> c = ct.toClass();
        TablesType type1 = (TablesType) c.newInstance();
        type1.say();
        TablesType.main(null);

    }
}
