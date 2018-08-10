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
import quanlybenhvien.model.DayXetNghiem;
import quanlybenhvien.model.XetNghiem;

/**
 *
 * @author nguyenduccanh
 */
public class XuatDuLieu {
    public void xuatDuLieu(ArrayList<XetNghiem> al,JTable jTable,String aa){
         Vector rowHeader = new Vector();
                rowHeader.add("Mã xét nghiệm");
                rowHeader.add("Tên xét nghiệm");
                rowHeader.add("Thời gian");
                rowHeader.add("Kết quả");
                rowHeader.add("Mã phiếu khám");
                DefaultTableModel model = new DefaultTableModel(rowHeader, 0);
                jTable.setModel(model);
                Vector rowData;
                for (XetNghiem xet : al) {
                    rowData = new Vector();
                    rowData.add(xet.getMaXetNghiem());
                    rowData.add(xet.getTenXetNghiem());
                    rowData.add(xet.getThoiGianXetNghiem());
                    rowData.add(xet.getKetQua());
                    if(aa.length()==0){
                    TruyVan truyVan=new TruyVan();
                    ArrayList<DayXetNghiem> al1=truyVan.xuatDayXetNghiem(truyVan.traDayXetNghiem1(xet.getMaXetNghiem()));
                    if(al1.size()==0){
                    rowData.add("");}else{
                        rowData.add(al1.get(0).getMaPhieuKham());
                    }}
                    else{
                         rowData.add(aa);
                    }
                    model.addRow(rowData);
                }
        
    }
    
}
