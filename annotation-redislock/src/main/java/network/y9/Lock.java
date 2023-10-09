package network.y9;

public @interface Lock {

    /**
     * key
     * @return
     */
    String value();

    /**
     * 锁超时时间
     * 默认5000ms
     * @return
     */
    long expireTime() default 5000L;


    /**
     * 锁等待时间
     * 默认50ms
     * @return
     */
    long waitTime() default 50L;
}
