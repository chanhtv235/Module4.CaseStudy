package com.codegym.furama.repository;

import com.codegym.furama.Entity.FuramaKhachHang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends CrudRepository<FuramaKhachHang,Long> {
}
