package com.igenox.basicauth.api.rest;

import com.igenox.basicauth.model.FooBar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by alexandru.ionita on 5/9/15.
 */
@Controller
@RequestMapping(value = "/api", produces = "application/json")
public class FooBarResource
{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public FooBar getDefaultObject()
    {
        if ( (new Date()).getTime() > 1)
            throw new IllegalArgumentException("Si ce mai faci, Gigi?");
        FooBar defOb = new FooBar();
        defOb.setName("fucker einstein");
        defOb.setId("345345345");
        return defOb;
    }
}
