/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybenhvien.model;

/**
 *
 * @author Khang
 */
public class DonThuoc {
    private  String maPhieuKham;
    private String tenThuoc;
    private int sTT;
    private int lieuDung;
    private int soLuong;
    private int donGia;
    private String ghiChu;

    public DonThuoc() {
    }

    public DonThuoc(String maPhieuKham, String tenThuoc, int sTT, int lieuDung,
            int soLuong, int donGia, String ghiChu) {
        this.maPhieuKham = maPhieuKham;
        this.tenThuoc = tenThuoc;
        this.sTT = sTT;
        this.lieuDung = lieuDung;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
    }

    public int getLieuDung() {
        return lieuDung;
    }

    public void setLieuDung(int lieuDung) {
        this.lieuDung = lieuDung;
    }

    public String getMaPhieuKham() {
        return maPhieuKham;
    }

    public void setMaPhieuKham(String maPhieuKham) {
        this.maPhieuKham = maPhieuKham;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public int getsTT() {
        return sTT;
    }

    public void setsTT(int sTT) {
        this.sTT = sTT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
