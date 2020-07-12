package dev.eddycyu.designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This example shows how to implement the singleton design pattern using lazy
 * initialization for a single threaded environment.
 * <p>
 * In order to preserve the singleton property for serde, the
 * <code>readResolve()</code> method is required.
 * <p>
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
 * https://en.wikipedia.org/wiki/Lazy_initialization
 *
 * @see dev.eddycyu.designpattern.singleton.SingletonMultiThreadedEnum
 * @see dev.eddycyu.designpattern.singleton.SingletonMultiThreadedHolder
 */
public class SingletonSingleThreaded implements Serializable {

    private static final long serialVersionUID = 1L;
    private static SingletonSingleThreaded instance = null;

    // hide the constructor
    private SingletonSingleThreaded() {
        super();
    }

    public static SingletonSingleThreaded getInstance() {
        // lazy initialization (not multi-thread safe)
        if (instance == null) {
            instance = new SingletonSingleThreaded();
        }
        return instance;
    }

    // required in order to preserve singleton property for serde
    private Object readResolve() {
        return getInstance();
    }

    public static void main(String[] args) throws Exception {
        final SingletonSingleThreaded instance1 = SingletonSingleThreaded.getInstance();
        final SingletonSingleThreaded instance2 = SingletonSingleThreaded.getInstance();
        if (instance1 == instance2) {
            System.out.println("instance1 and instance2 are the same instance");
        } else {
            System.out.println("instance1 and instance2 are different instances");
        }

        // verify that serde is working properly
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance1);
        oos.close();
        final InputStream is = new ByteArrayInputStream(baos.toByteArray());
        final ObjectInputStream ois = new ObjectInputStream(is);
        final SingletonSingleThreaded instance3 = (SingletonSingleThreaded) ois.readObject();
        if (instance1 == instance3) {
            System.out.println("instance1 and instance3 are the same instance");
        } else {
            System.out.println("instance1 and instance3 are different instances");
        }
        ois.close();
    }
}
