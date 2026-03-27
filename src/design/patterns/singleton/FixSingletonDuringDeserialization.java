package design.patterns.singleton;

import java.io.*;

public class FixSingletonDuringDeserialization implements Serializable {

    private static final FixSingletonDuringDeserialization INSTANCE = new FixSingletonDuringDeserialization();

    private FixSingletonDuringDeserialization() {

    }

    public static FixSingletonDuringDeserialization getInstance() {
        return INSTANCE;
    }

    @Serial
    public Object readResolve() {
        return INSTANCE;
    }
}

class FixSingletonDuringDeserializationMain {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.object"))) {
            FixSingletonDuringDeserialization fixSingletonDuringDeserialization1 = FixSingletonDuringDeserialization.getInstance();
            oos.writeObject(fixSingletonDuringDeserialization1);
            System.out.println(fixSingletonDuringDeserialization1.hashCode());
        } catch (Exception exception) {
            //
        }

        // Hashcode of second object will be different
        // object 1 hash code = 1174361318
        // object 2 has code = 1327763628
        // to fix this we should use readResolve method in singleton class
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.object"))) {
            FixSingletonDuringDeserialization fixSingletonDuringDeserialization2 = (FixSingletonDuringDeserialization) ois.readObject();
            System.out.println(fixSingletonDuringDeserialization2.hashCode());
        } catch (Exception exception) {
            //
        }
    }
}
