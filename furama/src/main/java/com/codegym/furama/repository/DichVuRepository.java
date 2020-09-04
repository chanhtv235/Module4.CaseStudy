package com.codegym.furama.repository;

import com.codegym.furama.Entity.FuramaDichVu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends PagingAndSortingRepository<FuramaDichVu,Long> {
    Iterable<FuramaDichVu> findAllByChiPhiThuBetween(Integer fromPrice,Integer toPrice);
}
