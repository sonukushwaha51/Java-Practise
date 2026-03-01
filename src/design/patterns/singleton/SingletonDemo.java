package design.patterns.singleton;

import java.util.concurrent.ConcurrentHashMap;

public class SingletonDemo {

    public static void main(String[] args) {
        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
        SimpleSingleton simpleSingleton1 = SimpleSingleton.getInstance();

        System.out.println(simpleSingleton.hashCode() == simpleSingleton1.hashCode());
        System.out.println(simpleSingleton.equals(simpleSingleton1));

        //Eager SIngleton
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();

        System.out.println(eagerSingleton.hashCode() == eagerSingleton1.hashCode());

        // Synchronized singleton
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(SynchronizedSingleton::getInstance);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SimpleSingleton {

    private static SimpleSingleton simpleSingleton;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        if (simpleSingleton == null) {
            simpleSingleton = new SimpleSingleton();
        } else {
            System.out.println("SimpleSingleton is already instantiated");
        }
        return simpleSingleton;
    }
}

class EagerSingleton {

    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}

class SynchronizedSingleton {

    private static final ConcurrentHashMap<String, SynchronizedSingleton> map = new ConcurrentHashMap<>();

    private SynchronizedSingleton() {

    }
    public static void getInstance() {
        synchronized (SynchronizedSingleton.class) {
            if (!map.containsKey(SynchronizedSingleton.class.getSimpleName())) {
                map.put(SynchronizedSingleton.class.getSimpleName(), new SynchronizedSingleton());
                System.out.println(Thread.currentThread().getName() + " created instance");
            } else {
                System.out.println("Already instantiated in synchronized block");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        map.get(SynchronizedSingleton.class.getSimpleName());
    }
}

