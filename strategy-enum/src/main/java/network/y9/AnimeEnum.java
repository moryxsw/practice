package network.y9;

/**
 * AnimeEnum
 *
 * @author wanghongyu10924
 * @since 2023/9/23
 */
public enum AnimeEnum implements Eat{

    Dog(){
        @Override
        public void eat(){
            System.out.println("吃骨头");
        }
    },

    Cat(){
        @Override
        public void eat() {
            System.out.println("吃鱼");
        }
    },
    ;

}
