package ioc;

public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
