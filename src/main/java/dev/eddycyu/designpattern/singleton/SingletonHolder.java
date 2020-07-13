package dev.eddycyu.designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This example shows how to implement the Singleton design pattern following
 * the initialization-on-demand holder idiom with a public static factory
 * method. It uses lazy initialization and is thread safe.
 * <p>
 * In order to preserve the singleton property for "serde", the
 * <code>readResolve()</code> method is required.
 * <p>
 * Pros:
 * - lazy initialization
 * - thread safe
 * Cons:
 * - requires additional serialization code
 * - non-instantiation via constructor can be bypassed through reflection
 * <p>
 * Use Cases: logging, caches, thread pools, configuration, etc.
 * <p>
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 * https://en.wikipedia.org/wiki/Lazy_initialization
 *
 * @see SingletonEager
 * @see SingletonLazy
 * @see SingletonEnum
 */
public class SingletonHolder implements Serializable {

    private static final long serialVersionUID = 1L;

    private static class LazyHolder {
        static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    // hide the constructor
    private SingletonHolder() {
    }

    // factory method to access single instance
    public static SingletonHolder getInstance() {
        // lazy initialization
        return LazyHolder.INSTANCE;
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
        final SingletonHolder instance1 = SingletonHolder.getInstance();
        final SingletonHolder instance2 = SingletonHolder.getInstance();
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
        final SingletonHolder instance3 = (SingletonHolder) ois.readObject();
        if (instance1 == instance3) {
            System.out.println("instance1 and instance3 are the same instance");
        } else {
            System.out.println("instance1 and instance3 are different instances");
        }
        ois.close();
    }
}
