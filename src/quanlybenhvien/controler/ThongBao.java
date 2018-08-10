package quanlybenhvien.controler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ThongBao {
    
   private JFrame mainFrame;
   
  

   public ThongBao(){
      prepareGUI();
   }

  

   private void prepareGUI(){
      mainFrame = new JFrame("THÔNG BÁO");
      mainFrame.setSize(400,200);
      mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     

     
      mainFrame.setVisible(true);  
      
   }
   private void  button(){
       
      // ex.setSize(100, 20);
      
       
   }
   public void showLabelDemo(int i){
     CacThongBao cacThongBao=new CacThongBao();
     JLabel label  = new JLabel("", JLabel.CENTER); 
      label.setBounds(0, 0, 400, 100);
      label.setText(cacThongBao.ThongBaoRa(i));
      label.setOpaque(true);
      label.setBackground(Color.GRAY);
      label.setForeground(Color.WHITE);
      mainFrame.add(label);
      JButton ex=new JButton("Đồng Ý"); 
      ex.setBounds(140, 120, 100, 30);
       ex.setOpaque(true);
       mainFrame.add(ex);
       mainFrame.setLayout(null);
       ex.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
            mainFrame.hide();
          }
      });
      mainFrame.setVisible(true);  
      mainFrame.setLocationRelativeTo(null);
   }
}
class CacThongBao{
        public String ThongBaoRa(int i) {
        String ex = null;
        if(i==1){
            ex="Không được để trống";
        }
        if(i==2){
            ex="Không tìm thấy dữ liệu";
        }
        if(i==3){
            ex="Thêm thành công";
        }
        if(i==4){
            ex="Thêm thất bại";
        }
        if(i==5){
            ex="Sửa thành công";
        }
        if(i==6){
            ex="Sửa thất bại";
        }
        if(i==7){
            ex="Xóa Thành Công";
        }
        if(i==8){
            ex="Xóa thất bại ";
        }
        
  return ex;}
}