package com.codegym.furama.service;

import com.codegym.furama.Entity.FuramaHopDong;
import com.codegym.furama.Entity.FuramaKhachHang;

public interface KhachHangService {
    public Iterable<FuramaKhachHang> getAllKhachHang();
    public FuramaKhachHang getKhachHang(Long idKhachHang);
    public void saveKhachHang(FuramaKhachHang khachHang);
    public void deleteKhachHang(Long idKhachHang);
}
