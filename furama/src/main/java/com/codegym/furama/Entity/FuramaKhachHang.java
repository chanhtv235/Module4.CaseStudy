package com.codegym.furama.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Table(name = "khachhang")
public class FuramaKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkhachhang")
    private Long id;

    @Column(name = "idloaikhach")
    private Long idLoaiKhach;

    @NotEmpty(message = "Vui lòng điền họ và tên")
    @Column(name = "hoten")
    private String hoTen;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @NotEmpty(message = "Vui lòng điền CMND")
    @Column(name = "cmnd")
    private String CMND;

    @NotEmpty(message = "Vui lòng điền số điện thoại")
    @Column(name = "sodientthoai")
    private String soDienThoai;

    @NotEmpty(message = "Vui lòng điền email")
    @Pattern(regexp = "^[A-Za-z0-9]{2,}@[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}$",message = "Email không đúng định dạng")
    @Column(name = "email")
    private  String email;

    @NotEmpty(message = "Vui lòng điền địa chỉ")
    @Column(name = "diachi")
    private  String diaChi;

    public FuramaKhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLoaiKhach() {
        return idLoaiKhach;
    }

    public void setIdLoaiKhach(Long idLoaiKhach) {
        this.idLoaiKhach = idLoaiKhach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
