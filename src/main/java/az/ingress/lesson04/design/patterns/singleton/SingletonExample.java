package az.ingress.lesson04.design.patterns.singleton;

public class SingletonExample {
    public static SingletonExample instance;

    private SingletonExample() {

    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            synchronized(SingletonExample.class) {
                if (instance == null) {
                    instance = new SingletonExample();
                }
            }
        }

        return instance;
    }

}
