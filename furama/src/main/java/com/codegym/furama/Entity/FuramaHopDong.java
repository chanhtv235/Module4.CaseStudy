package com.codegym.furama.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hopdong")
public class FuramaHopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhopdong")
    private Long idHopDong;

    @Column(name = "idnhanvien")
    private Long idNhanVien;

    @Column(name = "idkhachhang")
    private Long idKhachHang;

    @Column(name = "ngaylaphopdong")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date ngayLapHopDong;

    @Column(name = "ngayketthuc")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date ngayKetThuc;

    @Column(name = "tiendatcoc")
    private Double tienDatCoc;

    @Column(name = "tongtien")
    private Double tongTien;

    @Column(name = "iddichvu")
    private Long idDichVu;

    public FuramaHopDong() {

    }

    public Long getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(Long idHopDong) {
        this.idHopDong = idHopDong;
    }

    public Long getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Long idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgayLapHopDong() {
        return ngayLapHopDong;
    }

    public void setNgayLapHopDong(Date ngayLapHopDong) {
        this.ngayLapHopDong = ngayLapHopDong;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(Double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Long getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Long idDichVu) {
        this.idDichVu = idDichVu;
    }
}
