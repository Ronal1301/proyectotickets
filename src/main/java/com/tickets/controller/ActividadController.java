package com.tickets.controller;

import com.tickets.domain.Actividad;
import com.tickets.service.ActividadService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@Slf4j
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired

    private ActividadService actividadService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var actividades = actividadService.getActividades(false);/*Arrays.asList(actividad1, actividad2, actividad3);*/
        model.addAttribute("actividades", actividades);
        model.addAttribute("totalActividades", actividades.size());

        return "/actividad/listado";
    }

    @GetMapping("/nuevo")
    public String actividadNuevo(Actividad actividad) {
        return "/actividad/modifica";
    }

    @PostMapping("/guardar")
    public String actividadGuardar(Actividad actividad) {
        actividadService.save(actividad);
        return "redirect:/actividad/listado";
    }

    @GetMapping("/eliminar/{idActividad}")
    public String actividadEliminar(Actividad actividad) {
        actividadService.delete(actividad);
        return "redirect:/actividad/listado";
    }

    @GetMapping("/modificar/{idActividad}")
    public String actividadModificar(Actividad actividad, Model model) {
        actividad = actividadService.getActividad(actividad);
        model.addAttribute("actividad", actividad);
        return "/actividad/modifica";
    }

}
