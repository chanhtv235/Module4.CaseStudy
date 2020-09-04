package com.codegym.furama.service;

import com.codegym.furama.Entity.FuramaDichVu;
import com.codegym.furama.Entity.FuramaHopDong;

public interface HopDongService {
    public Iterable<FuramaHopDong> getAllHopDong();
    public FuramaHopDong getHopDong(Long idHopDong);
    public void saveHopDong(FuramaHopDong hopDong);
    public void deleteHopDong(Long idHopDong);
    public  Iterable<FuramaHopDong> findAllByIdKhachHang(Long idKhachHang);
}
