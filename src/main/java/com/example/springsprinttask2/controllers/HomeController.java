package com.example.springsprinttask2.controllers;

import com.example.springsprinttask2.models.ApplicationRequest;
import com.example.springsprinttask2.repositories.ApplicationReqRep;
import com.example.springsprinttask2.services.ApplicationReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.LongToIntFunction;

@Controller
public class HomeController {
    @Autowired
    ApplicationReqService applicationReqService;
    @Autowired
    ApplicationReqRep applicationReqRep;


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("info", applicationReqService.getAppReq());
        return "home";
    }


//@GetMapping("/search")
//public String searchPage(@RequestParam(name = "search") String search ,Model model) {
//    System.out.println(search);
//    model.addAttribute("items",applicationReqRep.findAllByUserName(search));
//    return "home";
//}

    @GetMapping("/Add-Page")
    public String addPage() {
        return "Add-Page";
    }

    @PostMapping("/Add-Page")
    public String addApp(ApplicationRequest applicationRequest) {
        applicationReqService.addApp(applicationRequest);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String DetailsPage(@PathVariable Long id, Model model) {
        System.out.println(id);
        ApplicationRequest applicationRequest = applicationReqService.getById(id);
        model.addAttribute("det", applicationRequest);
        return "/details";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        System.out.println(id);
        applicationReqService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/edit-appReq/{id}")
    public String editAppReq(ApplicationRequest applicationRequest) {
        applicationReqService.editAppReqById(applicationRequest);
        return "redirect:/";
    }

    @GetMapping("/newAppReq")
    public String newAppReq(Model model) {
        model.addAttribute("newApp", applicationReqService.sortNew(applicationReqService.getAppReq()));
        return "/newAppReq";
    }

    @GetMapping("/processedApplications")
    public String processedAppReq(Model model) {
        model.addAttribute("prs", applicationReqService.sortOld(applicationReqService.getAppReq()));
        return "processedApplications";
    }
}



