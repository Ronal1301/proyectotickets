package com.tickets.controller;

import com.tickets.service.ActividadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping("/")
    public String inicio(Model model) {
        var actividades = actividadService.getActividades(true);/*Arrays.asList(cliente1, cliente2, cliente3);*/
        model.addAttribute("actividades", actividades);
        return "index";
    }
}
