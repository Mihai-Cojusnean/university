package com.cojusnean.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(
            Model model
    ) throws JsonProcessingException {
        HashMap<Object, Object> data = new HashMap<>();


        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", true);

        return "index";
    }
}
