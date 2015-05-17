package com.igenox.basicauth.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by alexandru.ionita on 5/9/15.
 */
@Controller
public class HomeController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goHome(Model model)
    {
        return "index";
    }
}
