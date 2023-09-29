package org.learning.ricette.controller;


import jakarta.validation.Valid;
import org.learning.ricette.model.Ricetta;
import org.learning.ricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ricette")
public class RicettaController {

@Autowired
    RicettaRepository ricettaRepository;

    @GetMapping
    private String index(Model model) {
       List<Ricetta> ricette = ricettaRepository.findAll();
       System.out.println(ricette);
        model.addAttribute("ricette", ricette);
        return "ricetta-lista";
    }

    @GetMapping("ricetta/{id}")
    public String ricetta(@PathVariable("id") Integer id, Model model) {
        Optional<Ricetta> ricetta = ricettaRepository.findById(id);
        if (ricetta.isPresent()) {
            Ricetta ricettaDB = ricetta.get();
            model.addAttribute("ricetta", ricettaDB);
            return "ricetta";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ricetta non è presente sul sito");
        }
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ricetta", new Ricetta());
        return "form";

    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("pizza") Ricetta formRicetta, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("ricette", ricettaRepository.findAll());

            return "form";
        }
        formRicetta.setTitolo(formRicetta.getTitolo().toUpperCase());

        ricettaRepository.save(formRicetta);
        return "redirect:/ricette";
    }
}

