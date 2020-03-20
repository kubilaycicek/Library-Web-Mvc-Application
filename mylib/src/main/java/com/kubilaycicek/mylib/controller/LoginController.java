package com.kubilaycicek.mylib.controller;

import com.kubilaycicek.mylib.dto.UserDto;
import com.kubilaycicek.mylib.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;

    @RequestMapping({"/", ""})
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            System.out.println("deneme");
            return "redirect:/web/book/list";
        }
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @RequestMapping(value = "/registerSave", method = RequestMethod.GET)
    public String registerSave(Model model) {
        UserDto dto = (UserDto) model.getAttribute("userDto");
        userService.addUser(dto);
        return "register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String logout() {
        return "login";
    }
}
