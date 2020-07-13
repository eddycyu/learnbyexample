package dev.eddycyu.designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This example shows how to implement the Singleton design pattern using lazy
 * initialization with a public static factory method. It is designed for use
 * in a single-threaded environment only.
 * <p>
 * In order to preserve the singleton property for "serde", the
 * <code>readResolve()</code> method is required.
 * <p>
 * Pros:
 * - lazy initialization
 * Cons:
 * - not thread safe
 * - requires additional serialization code
 * - non-instantiation via constructor can be bypassed through reflection
 * <p>
 * Use Cases: logging, caches, thread pools, configuration, etc.
 * <p>
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
 * https://en.wikipedia.org/wiki/Lazy_initialization
 *
 * @see SingletonEager
 * @see SingletonEnum
 * @see SingletonHolder
 */
public class SingletonLazy implements Serializable {

    private static final long serialVersionUID = 1L;
    private static SingletonLazy instance = null;

    // hide the constructor
    private SingletonLazy() {
    }

    // factory method to access single instance
    public static SingletonLazy getInstance() {
        // lazy initialization (not thread safe)
        if (instance == null) {
            instance = new SingletonLazy();
        }
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
        final SingletonLazy instance1 = SingletonLazy.getInstance();
        final SingletonLazy instance2 = SingletonLazy.getInstance();
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
        final SingletonLazy instance3 = (SingletonLazy) ois.readObject();
        if (instance1 == instance3) {
            System.out.println("instance1 and instance3 are the same instance");
        } else {
            System.out.println("instance1 and instance3 are different instances");
        }
        ois.close();
    }
}
