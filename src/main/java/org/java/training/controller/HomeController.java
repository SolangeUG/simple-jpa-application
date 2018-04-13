package org.java.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller
 * @author Solange U. Gasengayire
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    /**
     * Return the homepage
     * @return
     */
    public String home() {
        return "index";
    }
}
