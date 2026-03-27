package design.patterns.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonBreak {

    public static void main(String[] args) {
        try {
            Constructor<SimpleSingleton> simpleSingletonConstructor = SimpleSingleton.class.getDeclaredConstructor();
            simpleSingletonConstructor.setAccessible(true);
            SimpleSingleton simpleSingleton = simpleSingletonConstructor.newInstance();
            System.out.println(simpleSingleton.sayHello());

            // Make any field private to public accessible
//            Field[] fields = SimpleSingleton.class.getDeclaredFields();
//            for (Field field : fields) {
//                field.setAccessible(true);
//                String fieldName = field.getName();
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
