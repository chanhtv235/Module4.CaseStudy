package com.codegym.furama.service.impl;

import com.codegym.furama.Entity.FuramaKhachHang;
import com.codegym.furama.repository.KhachHangRepository;
import com.codegym.furama.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public Iterable<FuramaKhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public FuramaKhachHang getKhachHang(Long idKhachHang) {
        return khachHangRepository.findById(idKhachHang).orElse(null);
    }

    @Override
    public void saveKhachHang(FuramaKhachHang khachHang) {
        khachHangRepository.save(khachHang);

    }

    @Override
    public void deleteKhachHang(Long idKhachHang) {
        khachHangRepository.deleteById(idKhachHang);
    }
}
