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
import quanlybenhvien.model.BenhAn;
import quanlybenhvien.model.HoSo;

/**
 *
 * @author nguyenduccanh
 */
public class XuatDuLieuBenhAn {
     public void xuatDuLieuBenhAn(ArrayList<BenhAn> benhAn,JTable table) {
        Vector rowHeader = new Vector();
        rowHeader.add("Mã bệnh án");
        rowHeader.add("Mã hồ sơ");
        rowHeader.add("Tên bệnh");
        rowHeader.add("Thời gian mắc");
        rowHeader.add("Thời gian khỏi");
        rowHeader.add("Ghi chú");
        
        DefaultTableModel model = new DefaultTableModel(rowHeader, 0);
        table.setModel(model);
        Vector rowData;
        for ( BenhAn list : benhAn) {
            rowData = new Vector();
            rowData.add(list.getMaBenhAn());
            rowData.add(list.getMaHoSo());
            rowData.add(list.getTenBenh());
            rowData.add(list.getThoiGianMacBenh());
            rowData.add(list.getThoiGianKhoi());
            rowData.add(list.getGhiChu());
            model.addRow(rowData);
        }

    }
}
