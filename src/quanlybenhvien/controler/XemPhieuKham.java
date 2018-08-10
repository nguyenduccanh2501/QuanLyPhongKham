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
import quanlybenhvien.model.PhieuKham;

/**
 *
 * @author nguyenduccanh
 */
public class XemPhieuKham {
    public void xuatDuLieu(ArrayList<PhieuKham> al,JTable jTable,String aa){
         Vector rowHeader = new Vector();
                rowHeader.add("Mã h? so");
                rowHeader.add("Mã phi?u khám");
                rowHeader.add("Phòng khám");
                rowHeader.add("Th?i gian c?p");
                
                DefaultTableModel model = new DefaultTableModel(rowHeader, 0);
                jTable.setModel(model);
                Vector rowData;
                for (PhieuKham xet : al) {
                    rowData = new Vector();
                    rowData.add(xet.getMaHoSo());
                    rowData.add(xet.getMaPhieuKham());
                    rowData.add(xet.getGhiChu());
                    rowData.add(xet.getThoiGianCap());
                    if(aa.length()==0){
                    TruyVan truyVan=new TruyVan();
                    ArrayList<PhieuKham> al1=truyVan.xuatPhieuKham(truyVan.traPhieuKham(xet.getMaPhieuKham()));
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
