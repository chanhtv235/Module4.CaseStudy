package com.codegym.furama.controllers;

import com.codegym.furama.Entity.FuramaDichVu;
import com.codegym.furama.Entity.FuramaHopDong;
import com.codegym.furama.service.DichVuService;
import com.codegym.furama.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
public class BookingController {
    @Autowired
    DichVuService dichVuService;
    @Autowired
    HopDongService hopDongService;
    @GetMapping("/booking/{id}")
    public ModelAndView getBookingPage(@PathVariable(value = "id")Long id){
        ModelAndView modelAndView=new ModelAndView("dichvu/booking");
        FuramaDichVu furamaDichVu=dichVuService.getDichVu(id);
       modelAndView.addObject("dichvu",furamaDichVu);
        return modelAndView;
    }
    @PostMapping ("/booking")
    public ModelAndView saveBooking(@RequestParam(value = "id")Long id,
                                    @RequestParam(value = "ngaybatdau")Date ngayBatDau,
                                    @RequestParam(value = "ngayketthuc")Date ngayketthuc,
                                    HttpServletRequest request, HttpServletResponse response) {
        FuramaHopDong furamaHopDong = new FuramaHopDong();
        furamaHopDong.setIdDichVu(id);
        furamaHopDong.setNgayLapHopDong(ngayBatDau);
        furamaHopDong.setNgayKetThuc(ngayketthuc);
        furamaHopDong.setIdKhachHang((long) 1);
        furamaHopDong.setIdNhanVien((long) 1);
        furamaHopDong.setTienDatCoc((double) 10);
        furamaHopDong.setTongTien((double) 500);
        hopDongService.saveHopDong(furamaHopDong);
        //Cookie
        Iterable<FuramaHopDong> hopDongList=hopDongService.findAllByIdKhachHang((long) 1);
        for (FuramaHopDong hopdong: hopDongList) {
            String cookieValue=hopdong.getIdHopDong()+"_"+hopdong.getIdDichVu()+"_"+hopdong.getNgayLapHopDong()+"_"+ hopdong.getNgayKetThuc();
            Cookie cookie=new Cookie("hopdong"+hopdong.getIdHopDong(),cookieValue);
            cookie.setMaxAge(60*60);
            cookie.setPath("/history");
            response.addCookie(cookie);
        }
        ModelAndView modelAndView = new ModelAndView("dichvu/bookingSuccessfull");
        return modelAndView;
    }
}
