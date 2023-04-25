package com.roudeen.smt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.roudeen.smt.model.Tugas;
import com.roudeen.smt.service.TugasService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tugas")
@RequiredArgsConstructor
public class TugasController{
    private final TugasService tugasService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTugas(@ModelAttribute Tugas tugas) {
        tugasService.addTugas(tugas);
        return "redirect:/tugas";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTugas(@ModelAttribute Tugas tugas) {
        tugasService.updateTugas(tugas);
        return "redirect:/tugas";
    }

    @GetMapping
    public String getAllTugas(Model model) {
        List<Tugas> DataTugas = tugasService.getAllTugas();
        model.addAttribute("DataTugas", DataTugas);
        return "tugas/index";
    }


    @GetMapping("/delete/{id}")
    public String deleteBarang(@PathVariable("id") String id) {
      
        tugasService.deleteTugasById(id);
        return "redirect:/tugas";
    }

}