package bfzdevelop.crudjdbctemplate.controller;

import bfzdevelop.crudjdbctemplate.entity.User;
import bfzdevelop.crudjdbctemplate.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void edit(@PathVariable("id") int id, @RequestBody User user){
        userService.edit(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        userService.delete(id);
    }

}
