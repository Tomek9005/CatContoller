package com.sda.cats.controller;

import com.sda.cats.model.CatDto;
import com.sda.cats.model.CreateCatRequest;
import com.sda.cats.service.CatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class CatController {

    private final CatManager catManager;

    @Autowired
    public CatController(CatManager catManager){
        this.catManager = catManager;
    }

    @GetMapping
    String listCats(Model model) {
        model.addAttribute("cats", catManager.getAllCats());
        return "cats";
    }
    @GetMapping("/add")
        String addCat(){
        return "addcat";
        }

        @GetMapping("edit/{id}")
        String editCat(@PathVariable("id") Long id, Model model ){
        model.addAttribute("cat", catManager.getCat(id));
        return "editcat";
        }

    @PostMapping("add")
    RedirectView saveCat(CreateCatRequest createCatRequest) {
        catManager.saveCat(createCatRequest);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;

    }
    @PostMapping("delete/{id}")
    RedirectView deleteCat(@PathVariable("id")long id){
        catManager.deleteCat(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;


    }

    @PostMapping("edit/{id}")
    RedirectView updateCat(@PathVariable("id") Long id, CreateCatRequest createCatRequest){
        catManager.updateCat(id, createCatRequest);
        return redirectHome();
    }

    private RedirectView redirectHome() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;
    }}


