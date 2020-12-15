package com.blueochild.route;

import java.util.List;
import com.blueochild.model.User;
import com.blueochild.service.UserService;
import com.blueochild.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRoute {

    private final UserService userService;

    @Autowired
    public UserRoute(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> getUsers(){
        return this.userService.findAll();
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public User getUser(@PathVariable(value="userId") String userId) throws Exception{
        return this.userService.find(Integer.parseInt(userId));
    }

    @GetMapping("/initializeUser")
    public void initializeUsers() {
        this.userService.initializeUsers();
    }

    @PostMapping("/register")
    public void createUser(UserRegisterVO user){
        this.userService.createUser(user);
        System.out.println(user);
    }


}
