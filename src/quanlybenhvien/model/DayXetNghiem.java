
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
public class DayXetNghiem {
    private String maPhieuKham;
    private String maXetNghiem;

    public String getMaPhieuKham() {
        return maPhieuKham;
    }

    public void setMaPhieuKham(String maPhieuKham) {
        this.maPhieuKham = maPhieuKham;
    }

    public String getMaXetNghiem() {
        return maXetNghiem;
    }

    public void setMaXetNghiem(String maXetNghiem) {
        this.maXetNghiem = maXetNghiem;
    }

    public DayXetNghiem() {
    }

    public DayXetNghiem(String maPhieuKham, String maXetNghiem) {
        this.maPhieuKham = maPhieuKham;
        this.maXetNghiem = maXetNghiem;
    }
    
}
