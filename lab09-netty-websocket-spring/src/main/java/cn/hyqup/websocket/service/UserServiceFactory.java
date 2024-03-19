package cn.hyqup.websocket.service;

public abstract class UserServiceFactory {

    private static UserService userService = new UserService();

    public static UserService getUserService() {
        return userService;
    }
}
