package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


//add annotation so spring recognizes it as controller
@Controller
//specify base request path for every method in controller.
// every val below (value="")should be preceded with /cheese
@ RequestMapping("cheese")

public class CheeseController {

    //static member of class. make list accessible to methods.  This data will only exist while app is running.  removed when app stopped.
    static ArrayList<String> cheeses = new ArrayList<>();

    //to configure route to configure route. value spec route at which req should be mapped to this handler
    //request path /cheese
    @RequestMapping(value="")

    //allows controller method to return text directly from controller method or handler
    //@ResponseBody (we don't want this since we're using templates

    //
    public String index(Model model) {

        //passing object ArrayList
        model.addAttribute("cheeses", cheeses);


        //can use model to pass data into view from controller. Will be key val pair
        //title is ${title} im template
        model.addAttribute("title", "My Cheeses");

        //below: give template name (same as file before .
        //we don't have to tell it where the template lives (default for spring boot in templates folder)
        return "cheese/index";
    }

    //form display - common to have them live at the same URL display is get, processing is post.
    //where it lives (value)
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title","Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    //RequestParam - Spring should look for req param with the name cheeseName and insert it here
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        //add cheese to list from form
        cheeses.add(cheeseName);
        //redirect to /cheese (this handler)
        return "redirect:";
    }

}
