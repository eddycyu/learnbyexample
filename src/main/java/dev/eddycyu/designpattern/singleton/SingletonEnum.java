package dev.eddycyu.designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This example shows how to implement the Singleton design pattern using a
 * single-element <code>Enum</code> type, which provides a lazy initialization,
 * thread-safe and serializable implementation.
 * <p>
 * Pros:
 * - lazy initialization
 * - thread safe
 * - inherently serializable (no additional code required)
 * Cons:
 * - none
 * <p>
 * Use Cases: logging, caches, thread pools, configuration, etc.
 * <p>
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * https://en.wikipedia.org/wiki/Lazy_initialization
 *
 * @see SingletonEager
 * @see SingletonLazy
 * @see SingletonHolder
 */
public enum SingletonEnum {
    INSTANCE;

    // other methods...
    public String doSomething() {
        return "do something";
    }

    public static void main(String[] args) throws Exception {
        final SingletonEnum instance1 = SingletonEnum.INSTANCE;
        final SingletonEnum instance2 = SingletonEnum.INSTANCE;
        if (instance1 == instance2) {
            System.out.println("instance1 and instance2 are the same instance");
        } else {
            System.out.println("instance1 and instance2 are different instances");
        }

        // verify that "serde" works properly
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance1);
        oos.close();
        final InputStream is = new ByteArrayInputStream(baos.toByteArray());
        final ObjectInputStream ois = new ObjectInputStream(is);
        final SingletonEnum instance3 = (SingletonEnum) ois.readObject();
        if (instance1 == instance3) {
            System.out.println("instance1 and instance3 are the same instance");
        } else {
            System.out.println("instance1 and instance3 are different instances");
        }
        ois.close();
    }
}
