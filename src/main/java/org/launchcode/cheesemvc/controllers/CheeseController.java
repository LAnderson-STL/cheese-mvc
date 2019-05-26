package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


//add annotation so spring recognizes it as controller
@Controller
//specify base request path for every method in controller.
// every val below (value="")should be preceded with /cheese
@ RequestMapping("cheese")

public class CheeseController {



    //to configure route to configure route. value spec route at which req should be mapped to this handler
    //request path /cheese
    @RequestMapping(value="")

    //allows controller method to return text directly from controller method or handler
    //@ResponseBody (we don't want this since we're using templates

    //
    public String index(Model model) {

        //passing object ArrayList
        model.addAttribute("cheeses", CheeseData.getAll());


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

    //model binding will reduce amt of code.  model annotation will try to create obj for us
    //spring will look in descr to see which fields in class have getters and setters and try to match up to data from form
    //then will inject into class
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //RequestParam - Spring should look for req param with the name cheeseName and insert it here
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {
        //add cheese to list from form
        CheeseData.add(newCheese);
        //redirect to /cheese (this handler)

        return "redirect:";
    }

    //display delete form   Model gets hashmap of cheeses in
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteCheese(@RequestParam int[] cheeseIds){
        //for(int i = 0; i < cheese.size(); i++) {
        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }






}
