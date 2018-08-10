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
public class XetNghiem {

   
    private String maXetNghiem;
    private String tenXetNghiem;
    private Date thoiGianXetNghiem;
    private String ketQua;

    public XetNghiem(String maXetNghiem, String tenXetNghiem, Date thoiGianXetNghiem, String ketQua) {
        this.maXetNghiem = maXetNghiem;
        
        this.tenXetNghiem = tenXetNghiem;
        this.thoiGianXetNghiem = thoiGianXetNghiem;
        this.ketQua = ketQua;
        
    }

    public XetNghiem() {
    }

    public String getMaXetNghiem() {
        return maXetNghiem;
    }

    public void setMaXetNghiem(String maXetNghiem) {
        this.maXetNghiem = maXetNghiem;
    }

    public String getTenXetNghiem() {
        return tenXetNghiem;
    }

    public void setTenXetNghiem(String tenXetNghiem) {
        this.tenXetNghiem = tenXetNghiem;
    }

    public Date getThoiGianXetNghiem() {
        return thoiGianXetNghiem;
    }

    public void setThoiGianXetNghiem(Date thoiGianXetNghiem) {
        this.thoiGianXetNghiem = thoiGianXetNghiem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

}
