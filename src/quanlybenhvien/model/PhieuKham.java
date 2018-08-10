/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybenhvien.model;

import java.sql.Date;

/**
 *
 * @author Khang
 */
public class PhieuKham {
    private String maPhieuKham;
    private String maHoSo;
    private Date thoiGianCap;
    private String ghiChu;
    public PhieuKham() {
    }

    public PhieuKham(String maPhieuKham, String maHoSo, Date thoiGianCap, String ghiChu) {
        this.maPhieuKham = maPhieuKham;
        this.maHoSo = maHoSo;
        this.thoiGianCap = thoiGianCap;
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
    public String getMaPhieuKham() {
        return maPhieuKham;
    }

    public void setMaPhieuKham(String maPhieuKham) {
        this.maPhieuKham = maPhieuKham;
    }

    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public Date getThoiGianCap() {
        return thoiGianCap;
    }

    public void setThoiGianCap(Date thoiGianCap) {
        this.thoiGianCap = thoiGianCap;
    }
    
}
