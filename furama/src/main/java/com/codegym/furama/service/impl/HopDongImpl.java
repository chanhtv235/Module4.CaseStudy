package com.codegym.furama.service.impl;

import com.codegym.furama.Entity.FuramaHopDong;
import com.codegym.furama.repository.HopDongRepository;
import com.codegym.furama.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongImpl implements HopDongService {
    @Autowired
    HopDongRepository hopDongRepository;
    @Override
    public Iterable<FuramaHopDong> getAllHopDong() {
        return hopDongRepository.findAll();
    }

    @Override
    public FuramaHopDong getHopDong(Long idHopDong) {
        return hopDongRepository.findById(idHopDong).orElse(null);
    }

    @Override
    public void saveHopDong(FuramaHopDong hopDong) {
        hopDongRepository.save(hopDong);
    }

    @Override
    public void deleteHopDong(Long idHopDong) {
        hopDongRepository.deleteById(idHopDong);
    }

    @Override
    public Iterable<FuramaHopDong> findAllByIdKhachHang(Long idKhachHang) {
        return hopDongRepository.findAllByIdKhachHang(idKhachHang);
    }


}
