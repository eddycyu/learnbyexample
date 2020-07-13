package dev.eddycyu.designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This example shows how to implement the Singleton design pattern using eager
 * initialization with a public static factory method.
 * <p>
 * In order to preserve the singleton property for "serde", the
 * <code>readResolve()</code> method is required.
 * <p>
 * Pros:
 * - thread safe
 * Cons:
 * - eager initialization (if object creation is heavy)
 * - requires additional serialization code
 * - non-instantiation via constructor can be bypassed through reflection
 * <p>
 * Use Cases: logging, caches, thread pools, configuration, etc.
 * <p>
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
 *
 * @see SingletonLazy
 * @see SingletonEnum
 * @see SingletonHolder
 */
public class SingletonEager implements Serializable {

    private static final long serialVersionUID = 1L;

    // eager initialization
    private static SingletonEager instance = new SingletonEager();

    // hide the constructor
    private SingletonEager() {
    }

    // factory method to access single instance
    public static SingletonEager getInstance() {
        return instance;
    }

    // required in order to preserve singleton property for "serde"
    private Object readResolve() {
        return getInstance();
    }

    // other methods...
    public String doSomething() {
        return "do something";
    }

    public static void main(String[] args) throws Exception {
        final SingletonEager instance1 = SingletonEager.getInstance();
        final SingletonEager instance2 = SingletonEager.getInstance();
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
        final SingletonEager instance3 = (SingletonEager) ois.readObject();
        if (instance1 == instance3) {
            System.out.println("instance1 and instance3 are the same instance");
        } else {
            System.out.println("instance1 and instance3 are different instances");
        }
        ois.close();
    }
}
