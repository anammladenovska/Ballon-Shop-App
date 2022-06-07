package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidUserCredentialsExcetion;
import mk.ukim.finki.wp.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/user")
    public String login(HttpServletRequest request, Model model){
        User user = null;
        try{
            user = this.userService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user",user);
            return "listBalloons";
        }
        catch (InvalidUserCredentialsExcetion excetion){
            model.addAttribute("hasError", true);
            model.addAttribute("error",excetion.getMessage());
            return "login";
        }
    }
}

