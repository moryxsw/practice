package network.y9;

public class LoginHandler extends Handler{
    @Override
    public void doHandler(User user) {
        if (!"woniu".equals(user.getUserName()) || !"666".equals(user.getPassWord())) {
            System.out.println("用户名密码不正确");
            return;
        }
        if (null != next) {
            next.doHandler(user);
        }

    }
}
