package com.davacom.crudthymleafspringboot.controller;


import com.davacom.crudthymleafspringboot.dto.BlogerDto;
import com.davacom.crudthymleafspringboot.models.BlogUser;
import com.davacom.crudthymleafspringboot.service.BloggerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class Controllers {
    private final BloggerUserService bloggerUserService;

    //Displays login page
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("blogger", new BlogUser());
        return mav;
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") BlogUser user ) {

        BlogUser oauthUser = bloggerUserService.login(user.getEmail(), user.getPassword());

        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/landing";
        } else {
            return "redirect:/login";
        }

    }


    //Displays index/home page
    @GetMapping("/index")
    public String home() {
        return "index";
    }



    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    //Displays signup page
    @PostMapping("/signup")
    public String register(@ModelAttribute BlogerDto user, Model model) {
        model.addAttribute("user", user);
        BlogUser toSaveUser = bloggerUserService.create(user);

        BlogUser oauthUser = bloggerUserService.login(user.getEmail(), user.getPassword());

        if(Objects.nonNull(oauthUser)) {
            return "redirect:/login";
        } else {
            return "redirect:/signup";
        }
    }


    //Displays landing page
    @GetMapping("/landing")
    public String land() {
        return "landing";
    }

}
