package com.codegym.furama.controllers;

import com.codegym.furama.Entity.FuramaFavorite;
import com.codegym.furama.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("favorite")
public class HomeController {
    @Autowired
    DichVuService dichVuService;

    @GetMapping("/")
    public ModelAndView home(@RequestParam(value = "fromPrice", required = false) Integer fromPrice,
                             @RequestParam(value = "toPrice", required = false) Integer toPrice) {
        ModelAndView modelAndView = new ModelAndView("home/index");
        if (fromPrice == null || toPrice == null) {
            modelAndView.addObject("dichvuList", dichVuService.getAllDichVu());
        } else {
            modelAndView.addObject("dichvuList", dichVuService.findAllByChiPhiThuBetween(fromPrice, toPrice));
        }
        return modelAndView;
    }

    @GetMapping("/dichvu/{id}")
    public ModelAndView getDichVuDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("dichvu/dichvuchitiet", "dichvuchitiet", dichVuService.getDichVu(id));
        modelAndView.addObject("dichvuList", dichVuService.getAllDichVu());
        return modelAndView;
    }

    @GetMapping("/favorite/{id}")
    public String saveFavorite(@PathVariable(value = "id") Long id, @ModelAttribute("favorite") FuramaFavorite sessionFavorite) {
        sessionFavorite.add(dichVuService.getDichVu(id));
        return "redirect:/";
    }

    @GetMapping("/favoritePage")
    public String getSessionFavorite() {
        return "home/favorite";
    }

    // setup Session
    @ModelAttribute("favorite")
    public FuramaFavorite setupSession() {
        return new FuramaFavorite();
    }
}
