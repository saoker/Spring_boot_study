package com.spring.vnbig.first.init_start.controller;

import com.spring.vnbig.first.init_start.domain.User;
import com.spring.vnbig.first.init_start.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository ur;

    @GetMapping
    public ModelAndView getAllusers(Model md) {
        md.addAttribute("userlist", ur.getAllUser());
        md.addAttribute("title", "用户列表");
        return new ModelAndView("users/list", "usermodel", md);
    }

    @RequestMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model md) {
        User userTemp = ur.getUserbyId(id);
        md.addAttribute("user", userTemp);
        md.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "usermodel", md);
    }

    @RequestMapping("/form")
    public ModelAndView adduser(@PathVariable("id") Long id, Model md) {
        md.addAttribute("user", new User());
        md.addAttribute("title", "添加新用户");
        return new ModelAndView("users/form", "usermodel", md);
    }

    /**
     * 新建用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        user = ur.addUser(user);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteuser(@PathVariable("id") Long id, Model md) {
        ur.deleteUser(id);
        md.addAttribute("userist", ur.getAllUser());
        md.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "usermodel", md);
    }

    /**
     * 修改用户
     *
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = ur.getUserbyId(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
