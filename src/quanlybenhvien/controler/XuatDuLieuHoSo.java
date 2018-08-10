/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybenhvien.controler;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import quanlybenhvien.dao.TruyVan;
import quanlybenhvien.model.HoSo;
import quanlybenhvien.model.PhieuKham;

/**
 *
 * @author nguyenduccanh
 */
public class XuatDuLieuHoSo {
     public void xuatDuLieuHoSo(ArrayList<HoSo> hoSo,JTable table) {
        Vector rowHeader = new Vector();
        rowHeader.add("Mã hồ sơ");
        rowHeader.add("Họ tên");
        rowHeader.add("Tên");
        rowHeader.add("Địa chỉ");
        rowHeader.add("Giới tính");
        rowHeader.add("Ngày sinh");
        rowHeader.add("Ghi chú");
        
        DefaultTableModel model = new DefaultTableModel(rowHeader, 0);
        table.setModel(model);
        Vector rowData;
        for ( HoSo list : hoSo) {
            rowData = new Vector();
            rowData.add(list.getMaHoSo());
            rowData.add(list.getTen());
            
            rowData.add(list.getHoTen());
            rowData.add(list.getDiaChi());
            if(list.isGioiTinh()==false){
            rowData.add("Nữ");}else{
                rowData.add("Nam");
            }
            rowData.add(list.getNgaySinh());
            rowData.add(list.getGhiChu());
            model.addRow(rowData);
        }

    }
}
