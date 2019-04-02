package org.launchcode.controllers;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.bind.ValidationEventLocator;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("title", "Register");

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {
        if (user.getPassword().equals(verify)) {
            model.addAttribute(user);
            if (user.getPassword().equals(verify)) {
                return "user/index";
            }
            model.addAttribute("error", "Error: Passwords don't match.");
            model.addAttribute("title", "register");
            return "user/add";
        }
        return "user/index";
    }
}