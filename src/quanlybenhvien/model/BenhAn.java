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
public class BenhAn {

    private String maHoSo;
    private String maBenhAn;
    private String tenBenh;
    private Date thoiGianMacBenh;
    private Date thoiGianKhoi;
    private String ghiChu;

    public BenhAn() {
    }

    public BenhAn(String maHoSo, String maBenhAn, String tenBenh, Date thoiGianMacBenh, Date thoiGianKhoi, String ghiChu) {
        this.maHoSo = maHoSo;
        this.maBenhAn = maBenhAn;
        this.tenBenh = tenBenh;
        this.thoiGianMacBenh = thoiGianMacBenh;
        this.thoiGianKhoi = thoiGianKhoi;
        this.ghiChu = ghiChu;
    }

    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public Date getThoiGianMacBenh() {
        return thoiGianMacBenh;
    }

    public void setThoiGianMacBenh(Date thoiGianMacBenh) {
        this.thoiGianMacBenh = thoiGianMacBenh;
    }

    public Date getThoiGianKhoi() {
        return thoiGianKhoi;
    }

    public void setThoiGianKhoi(Date thoiGianKhoi) {
        this.thoiGianKhoi = thoiGianKhoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

}
