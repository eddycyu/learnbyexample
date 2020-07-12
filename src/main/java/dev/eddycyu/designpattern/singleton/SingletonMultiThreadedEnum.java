package dev.eddycyu.designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This example shows how to implement the singleton design pattern using a
 * single-element <code>Enum</code> type. It is both multi-thread safe and
 * serializable.
 * <p>
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * https://en.wikipedia.org/wiki/Lazy_initialization
 *
 * @see dev.eddycyu.designpattern.singleton.SingletonSingleThreaded
 * @see dev.eddycyu.designpattern.singleton.SingletonMultiThreadedHolder
 */
public enum SingletonMultiThreadedEnum {
    INSTANCE;

    public static SingletonMultiThreadedEnum getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        final SingletonMultiThreadedEnum instance1 = SingletonMultiThreadedEnum.getInstance();
        final SingletonMultiThreadedEnum instance2 = SingletonMultiThreadedEnum.getInstance();
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
        final SingletonMultiThreadedEnum instance3 = (SingletonMultiThreadedEnum) ois.readObject();
        if (instance1 == instance3) {
            System.out.println("instance1 and instance3 are the same instance");
        } else {
            System.out.println("instance1 and instance3 are different instances");
        }
        ois.close();
    }
}
