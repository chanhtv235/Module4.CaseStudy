package com.codegym.furama.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaidichvu")
public class FuramaLoaiDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tendichvu")
    private String tenDichVu;
    @OneToMany(targetEntity = FuramaDichVu.class)
    List<FuramaDichVu> furamaDichVu;

    public FuramaLoaiDichVu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public List<FuramaDichVu> getFuramaDichVu() {
        return furamaDichVu;
    }

    public void setFuramaDichVu(List<FuramaDichVu> furamaDichVu) {
        this.furamaDichVu = furamaDichVu;
    }
}
