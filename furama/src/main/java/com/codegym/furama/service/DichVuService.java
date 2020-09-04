package com.codegym.furama.service;

import com.codegym.furama.Entity.FuramaDichVu;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DichVuService {
    public Iterable<FuramaDichVu> getAllDichVu();
    public FuramaDichVu getDichVu(Long idDichVu);
    public void saveDichVu(FuramaDichVu dichVu);
    public void deleteDichVu(Long idDichVu);
    public Iterable<FuramaDichVu> findAllByChiPhiThuBetween(Integer fromPrice,Integer toPrice);
}
