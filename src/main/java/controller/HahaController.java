package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 2016/8/8.
 */
@Controller
@RequestMapping("/haha")
public class HahaController
{
    @RequestMapping("/ha")
    public String hah()
    {
        System.out.println("haha");
        return "index";
    }
}
