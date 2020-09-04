package com.codegym.furama.controllers;

import com.codegym.furama.Entity.FuramaKhachHang;
import com.codegym.furama.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/dangkykhachhang")
    public String getTrangDangKy(Model model) {
        model.addAttribute("khachhang", new FuramaKhachHang());
        return "khachhang/dangky";
    }
    @PostMapping ("/dangky")
    public String saveKhachHang(@Valid @ModelAttribute(value = "khachhang") FuramaKhachHang khachHang, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "khachhang/dangky";
        }else {
            khachHangService.saveKhachHang(khachHang);
            return "khachhang/dangkythanhcong";
        }
    }
}
