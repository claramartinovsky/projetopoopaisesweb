package com.poopaises.paises.controller;

import com.poopaises.paises.entity.ContinentEntity;
import com.poopaises.paises.entity.PaisesEntity;
import com.poopaises.paises.service.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaisesController {

    @Autowired
    private PaisesService service;

    @GetMapping("/paises")
    public String showPaises(Model model,
                             @RequestParam(required = false) String sortBy,
                             @RequestParam(required = false) String continent) {
        ContinentEntity selectedContinent = null;
        if (continent != null && !continent.isBlank()) {
            try {
                selectedContinent = ContinentEntity.valueOf(continent);
            } catch (IllegalArgumentException e) {
                selectedContinent = null;
            }
        }
        model.addAttribute("paises", service.getAllPaises(sortBy, selectedContinent));
        model.addAttribute("continents", service.getAllContinents());
        model.addAttribute("selectedContinent", selectedContinent != null ? selectedContinent.name() : "");
        model.addAttribute("sortBy", sortBy != null ? sortBy : "name");
        return "paises";
    }
}