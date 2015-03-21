package id.promoanda.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tsagita on 16/3/15.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public String authenticate() {

        return "redirect:/welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "welcome")
    public String welcomePage() {
        return "welcomePage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();

        return "redirect:/";
    }
}
