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
import quanlybenhvien.model.PhieuKham;

/**
 *
 * @author Administrator
 */
public class xuatDiLieuPhieuKham {

    public void XuatDuLieu(ArrayList<PhieuKham> phieukham,JTable table) {
        Vector rowHeader = new Vector();
        rowHeader.add("Mã phiếu khám");
        rowHeader.add("Mã hồ sơ");
        rowHeader.add("Phòng khám");
        rowHeader.add("Thời gian cấp");
        
        DefaultTableModel model = new DefaultTableModel(rowHeader, 0);
        table.setModel(model);
        Vector rowData;
        for ( PhieuKham xet : phieukham) {
            rowData = new Vector();            
            
            rowData.add(xet.getMaHoSo());
            rowData.add(xet.getMaPhieuKham());
            rowData.add(xet.getGhiChu());
            rowData.add(xet.getThoiGianCap());
            rowData.add(xet);
            model.addRow(rowData);
        }

    }
}
