/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybenhvien.controler;

import java.sql.ResultSet;

/**
 *
 * @author Ta Cao Canh
 */
public class KiemTra {
    public boolean kiemTraDuLieu(ResultSet result){
        try {
            if(result.next()){
            return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    
}
