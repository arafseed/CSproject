package com.example.online_backend.Controller;

import com.example.online_backend.repository.model.Child;
import com.example.online_backend.repository.ChildRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ChildAPI {
    @Autowired
    private ChildRepo childRepo;

@GetMapping({"/viewchild","/","list"})
    public ModelAndView showChild(){
    ModelAndView mav = new ModelAndView("dashboard");
    List<Child> childList = childRepo.findAll();
    mav.addObject("Child",childList);
    return mav;
}

@GetMapping("/add-children")
    public ModelAndView addchildren(){
    ModelAndView modelAndView = new ModelAndView("add-child-form");
    Child child = new Child();
    modelAndView.addObject("childing",child);
    return  modelAndView;
}


    @GetMapping("/updatechild")
    public ModelAndView updatechild(@RequestParam int r_Number){
        ModelAndView modelAndView = new ModelAndView( "update-child-form");
        Optional<Child> u_child = childRepo.findById(r_Number);
        modelAndView.addObject( "U_child",u_child);
        return  modelAndView;
    }


@PostMapping("/saveChild")
    public String saveChild(@ModelAttribute Child child){
    childRepo.save(child);
    return "redirect:/list";

}

@GetMapping("/deletechild")
    public String deletechild(@RequestParam int r_Number){
    childRepo.deleteById(r_Number);
    return "redirect:/list";
}

    @GetMapping("/view-children")
    public ModelAndView V_children(){
        ModelAndView modelAndView = new ModelAndView("view-children");
        Child V_child = new Child();
        modelAndView.addObject("arafa",V_child);
        return  modelAndView;
    }
}
