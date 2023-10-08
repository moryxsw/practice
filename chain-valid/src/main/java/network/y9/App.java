package network.y9;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Handler.Builder builder = new Handler.Builder();
        //链式编程，谁在前谁在后看的清清楚楚
        builder.addHandler(new LoginHandler())
                .addHandler(new AuthHandler());
        User user = new User();
        user.setUserName("woniu");
        user.setPassWord("666");
        builder.build().doHandler(user);

    }
}
