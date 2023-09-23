package network.y9;

/**
 * SingletonExample
 * 单例模式
 * @author wanghongyu10924
 * @since 2023/9/23
 */
public class SingletonExample {

    // 构造函数
    private SingletonExample() {
    }

    public static SingletonExample getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonExample instance;

        Singleton(){
            instance =  new SingletonExample();
        }
        public SingletonExample getInstance(){
            return instance;
        }


    }
}
