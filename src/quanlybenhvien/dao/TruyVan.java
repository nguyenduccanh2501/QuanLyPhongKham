/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybenhvien.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quanlybenhvien.model.BenhAn;
import quanlybenhvien.model.DayXetNghiem;
import quanlybenhvien.model.DonThuoc;
import quanlybenhvien.model.HoSo;
import quanlybenhvien.model.PhieuKham;
import quanlybenhvien.model.XetNghiem;

/**
 *
 * @author Khang
 */
public class TruyVan {

    Connection connection;

    public TruyVan() {
        DuLieuKetNoi dlkn = new DuLieuKetNoi();

        try {
            Class.forName(dlkn.classname);

            connection = DriverManager.getConnection(dlkn.url, dlkn.ure, dlkn.passwork);
            System.out.println("dsvsc");
        } catch (ClassNotFoundException e) {
            System.out.println("class ko vfvf");
        } catch (SQLException e) {
            System.out.println("het");
        }
    }

    public ResultSet traHoSo(String maHoSo) {
        ResultSet rs = null;
        String mySql = "SELECT hoso.* from hoso "
                + " where idHOSO = ? ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maHoSo);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public boolean themHoSo(HoSo hoSo) {
        PreparedStatement ps;
        String mySql = "INSERT INTO `sql12249124`.`hoso` (`idHOSO`, `hoTen`, `Ten`, `diaChi`, `gioiTinh`, `ngaySinh`, `ghiChu`)"
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, hoSo.getMaHoSo());
            ps.setString(2, hoSo.getTen());
            ps.setString(3, hoSo.getHoTen());
            ps.setString(4, hoSo.getDiaChi());
            ps.setString(5, (String.valueOf(hoSo.isGioiTinh())));
            ps.setDate(6, hoSo.getNgaySinh());
            ps.setString(7, hoSo.getGhiChu());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println(""+ex.getMessage());
            return false;
        }

        return false;
    }

    public boolean suaHoSo(HoSo hoSo, String maHoSo) {
        PreparedStatement ps;
        String mySql = "UPDATE `sql12249124`.`hoso` SET `idHOSO`=?, `hoTen`=?, `Ten`=?, `diaChi`=?"
                + ", `gioiTinh`=?, `ngaySinh`=?, `ghiChu`=? "
                + "WHERE `idHOSO`=?;";
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, hoSo.getMaHoSo());
            ps.setString(2, hoSo.getTen());
            ps.setString(3, hoSo.getHoTen());
            ps.setString(4, hoSo.getDiaChi());
            ps.setString(5, (String.valueOf(hoSo.isGioiTinh())));
            ps.setDate(6, hoSo.getNgaySinh());
            ps.setString(7, hoSo.getGhiChu());
            ps.setString(8, maHoSo);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi");
        }

        return false;
    }

    public boolean xoaHoSo(String maHoSo) {
        String mySql = " DELETE FROM `sql12249124`.`hoso` WHERE `idHOSO`=?";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, maHoSo);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi");
        }

        return false;
    }

    public boolean themBenhAn(BenhAn an) {
        PreparedStatement ps;
        String mySql = "INSERT INTO `sql12249124`.`benhan` (`idbenhAn`, `idhoso`, `tenbenh`, `thoigianmac`, `thoigiankhoi`, `ghichu`) "
                + "VALUES (?,?,?,?,?,?)";

        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, an.getMaBenhAn());
            ps.setString(2, an.getMaHoSo());
            ps.setString(3, an.getTenBenh());
            ps.setDate(4, an.getThoiGianMacBenh());
            ps.setDate(5, an.getThoiGianKhoi());
            ps.setString(6, an.getGhiChu());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {

            System.out.println("" + e.getMessage());
        }

        return false;
    }

    public ResultSet traBenhAn(String maBenhAn) {
        ResultSet rs = null;
        String mySql = "SELECT benhan.* from benhan "
                + " where idbenhAn = ? ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maBenhAn);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public boolean suaBenhAn(BenhAn an, String maBenhAn) {
        String mySql = "UPDATE `sql12249124`.`benhan` SET `idbenhAn`=?, `idhoso`=?, `tenbenh`=?, `thoigianmac`=?, `thoigiankhoi`=?, `ghichu`=? "
                + "         WHERE `idbenhAn`=?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, an.getMaBenhAn());
            ps.setString(2, an.getMaHoSo());
            ps.setString(3, an.getTenBenh());
            ps.setDate(4, an.getThoiGianMacBenh());
            ps.setDate(5, an.getThoiGianKhoi());
            ps.setString(6, an.getGhiChu());
            ps.setString(7, maBenhAn);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {

            System.out.println("" + e.getMessage());
        }
        return false;
    }

    public boolean xoaBenhAn(String maBenhAn) {
        String mySql = "DELETE FROM `sql12249124`.`benhan` WHERE `idbenhAn`=?";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, maBenhAn);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean themPhieuKham(PhieuKham kham) {
        String mySql = "INSERT INTO `sql12249124`.`phieukham` (`idPHIEUKHAM`, `IDHOSO`, `ghichu`, `thoiGianCap`) VALUES (?, ?, ?, ?);";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, kham.getMaPhieuKham());
            ps.setString(2, kham.getMaHoSo());
            ps.setString(3, kham.getGhiChu());
            ps.setDate(4, kham.getThoiGianCap());
            if (ps.executeUpdate() > 0) {
                System.out.println("ghbjnkm");
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean suaPhieuKham(PhieuKham kham, String maSophieu) {
        String mySql = "UPDATE sql12249124.`phieukham` SET idPHIEUKHAM = ?, IDHOSO = ?, ghichu = ?, "
                + "thoiGianCap = ? WHERE (idPHIEUKHAM = ?);";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, kham.getMaPhieuKham());
            ps.setString(2, kham.getMaHoSo());ps.setString(3, kham.getGhiChu());
            ps.setDate(4, kham.getThoiGianCap());
            
            ps.setString(5, maSophieu);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaPhieuKham(String maPhieuKham) {
        String maSql = "DELETE FROM `sql12249124`.`phieukham` WHERE `idPHIEUKHAM`=?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(maSql);
            ps.setString(1, maPhieuKham);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public ResultSet traPhieuKham(String maPhieuKham) {
        ResultSet rs = null;
        String mySql = "SELECT phieukham.* from phieukham "
                + " where idPHIEUKHAM = ? ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maPhieuKham);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public boolean themDonThuoc(DonThuoc donThuoc) {
        String mySql = "INSERT INTO `sql12249124`.`donthuoc` (`idPHIEUKHAM`, `tenThuoc`, `soLuong`, `GiaThanh`, `ghichu`, `stt`) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, donThuoc.getMaPhieuKham());
            ps.setString(2, donThuoc.getTenThuoc());
            ps.setInt(3, donThuoc.getSoLuong());
            ps.setInt(4, donThuoc.getDonGia());
            ps.setString(5, donThuoc.getGhiChu());
            ps.setInt(6, donThuoc.getsTT());
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean suaDonThuoc(DonThuoc donThuoc, String maSophieu, int stt) {
        String mySql = "UPDATE `sql12249124`.`donthuoc` SET `idPHIEUKHAM`=?, `tenThuoc`=?, `soLuong`=?, `GiaThanh`=?, `ghichu`=?, `stt`=?"
                + "   WHERE `idPHIEUKHAM`=? and`stt`=?";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, donThuoc.getMaPhieuKham());
            ps.setString(2, donThuoc.getTenThuoc());
            ps.setInt(3, donThuoc.getSoLuong());
            ps.setInt(4, donThuoc.getDonGia());
            ps.setString(5, donThuoc.getGhiChu());
            ps.setInt(6, donThuoc.getsTT());
            ps.setInt(8, stt);
            ps.setString(7, maSophieu);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaDonThuoc(String maPhieuKham, int stt) {
        String maSql = "DELETE FROM `sql12249124`.`donthuoc` WHERE `idPHIEUKHAM`=? and`stt`=?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(maSql);
            ps.setString(1, maPhieuKham);
            ps.setInt(2, stt);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public ResultSet traDonThuoc(String maPhieuKham, int stt) {
        ResultSet rs = null;
        String mySql = "SELECT donthuoc.* from donthuoc "
                + " where idPHIEUKHAM = ? and stt=? ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maPhieuKham);
            pts.setInt(2, stt);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ResultSet traDonThuoc(String maPhieuKham) {
        ResultSet rs = null;
        String mySql = "SELECT donthuoc.* from donthuoc "
                + " where idPHIEUKHAM = ?  ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maPhieuKham);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public boolean themXetNghiem(XetNghiem nghiem) {
        String mySql = "INSERT INTO `sql12249124`.`xetngiem` (`idXetNgiem`, `tenXetNgiem`, `NgayxetNgiem`, `KetQua`) "
                + "VALUES (?,?,?,?);";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, nghiem.getMaXetNghiem());
            ps.setString(2, nghiem.getTenXetNghiem());
            ps.setDate(3, nghiem.getThoiGianXetNghiem());
            ps.setString(4, nghiem.getKetQua());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean suaXetNghiem(XetNghiem nghiem, String maXetNghiem) {
        String mySql = "UPDATE `sql12249124`.`xetngiem` SET `idXetNgiem`=?, `tenXetNgiem`=?, `NgayxetNgiem`=?, `KetQua`=? "
                + "WHERE `idXetNgiem`=?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, nghiem.getMaXetNghiem());
            ps.setString(2, nghiem.getTenXetNghiem());
            ps.setDate(3, nghiem.getThoiGianXetNghiem());
            ps.setString(4, nghiem.getKetQua());
            ps.setString(5, maXetNghiem);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaXetNghiem(String maXetNghiem) {
        String mySql = "DELETE FROM `sql12249124`.`xetngiem` WHERE `idXetNgiem`=?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, maXetNghiem);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public ResultSet traXetNghiem(String maXetnghiem) {
        ResultSet rs = null;
        String mySql = "SELECT xetngiem.* from xetngiem "
                + " where idXetNgiem = ?  ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maXetnghiem);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public boolean themDayXetNghiem(DayXetNghiem dayXetNghiem) {
        String mySql = "INSERT INTO `sql12249124`.`dayxetngihiem` (`iddayxetngihiem`, `idxetnghiem`) VALUES (?, ?);";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, dayXetNghiem.getMaPhieuKham());
            ps.setString(2, dayXetNghiem.getMaXetNghiem());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean suaDayXetNghiem(DayXetNghiem dayXetNghiem, String maPhieu, String maXetNghiem) {
        String mySql = "UPDATE `sql12249124`.`dayxetngihiem` SET `iddayxetngihiem`=?,"
                + " `idxetnghiem`=? WHERE `iddayxetngihiem`=? and`idxetnghiem`= ?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, dayXetNghiem.getMaPhieuKham());
            ps.setString(2, dayXetNghiem.getMaXetNghiem());
            ps.setString(3, maPhieu);
            ps.setString(4, maXetNghiem);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaDayXetNghiem(String maPhieu, String maXetNghiem) {
        String mySql = "DELETE FROM `sql12249124`.`dayxetngihiem` WHERE `iddayxetngihiem`=? and`idxetnghiem`=?;";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(mySql);
            ps.setString(1, maPhieu);
            ps.setString(2, maXetNghiem);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public ResultSet traDayXetNghiem(String maphieu) {
        ResultSet rs = null;
        String mySql = "SELECT dayxetngihiem.* from dayxetngihiem "
                + " where iddayxetngihiem = ? ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maphieu);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ArrayList<DayXetNghiem> xuatDayXetNghiem(ResultSet rs) {
        if (rs == null) {
            System.out.println("Lỗi ở Đây");
            return null;
        }
        ArrayList<DayXetNghiem> al = new ArrayList<>();
        try {
            while (rs.next()) {
                DayXetNghiem dayXetNghiem = new DayXetNghiem();
                dayXetNghiem.setMaPhieuKham(rs.getString("iddayxetngihiem"));
                dayXetNghiem.setMaXetNghiem(rs.getString("idxetnghiem"));
                al.add(dayXetNghiem);
            }
        } catch (Exception e) {
        }
        return al;
    }

    public ArrayList<HoSo> xuatHoSo(ResultSet rs) {
        if (rs == null) {
            System.out.println("Lỗi ở Đây");
            return null;
        }
        ArrayList<HoSo> al = new ArrayList<>();
        try {
            while (rs.next()) {
                HoSo hoSo = new HoSo();
                hoSo.setDiaChi(rs.getString("diaChi"));
                hoSo.setMaHoSo(rs.getString("idHOSO"));
                hoSo.setGhiChu(rs.getString("ghiChu"));
                hoSo.setGioiTinh(Boolean.valueOf(rs.getString("gioiTinh")));
                hoSo.setNgaySinh(rs.getDate("ngaySinh"));
                hoSo.setHoTen(rs.getString("hoTen"));
                hoSo.setTen(rs.getString("Ten"));
                al.add(hoSo);
            }
        } catch (Exception e) {
        }
        return al;
    }

    public ArrayList<XetNghiem> xuatXetNghiem(ResultSet rs) {
        if (rs == null) {
            System.out.println("Lỗi ở Đây");
            return null;
        }
        ArrayList<XetNghiem> al = new ArrayList<>();
        try {
            while (rs.next()) {
                XetNghiem nghiem = new XetNghiem();
                nghiem.setKetQua(rs.getString("KetQua"));
                nghiem.setMaXetNghiem(rs.getString("idXetNgiem"));
                nghiem.setTenXetNghiem(rs.getString("tenXetNgiem"));
                nghiem.setThoiGianXetNghiem(rs.getDate("NgayXetNgiem"));
                al.add(nghiem);
            }
        } catch (Exception e) {
        }
        return al;
    }

    public ArrayList<BenhAn> xuatBenhAn(ResultSet rs) {

        if (rs == null) {
            System.out.println("Lỗi ở Đây");
            return null;
        }
        ArrayList<BenhAn> al = new ArrayList<>();
        try {
            while (rs.next()) {
                BenhAn an = new BenhAn();
                an.setMaBenhAn(rs.getString("idbenhAn"));
                an.setMaHoSo(rs.getString("idhoso"));
                an.setTenBenh(rs.getString("tenbenh"));
                an.setThoiGianMacBenh(rs.getDate("thoigianmac"));
                an.setThoiGianKhoi(rs.getDate("thoigiankhoi"));
                an.setGhiChu(rs.getString("ghichu"));
                al.add(an);
            }
        } catch (Exception e) {
        }
        return al;
    }

    public ArrayList<DonThuoc> xuatDonThuoc(ResultSet rs) {

        if (rs == null) {
            System.out.println("Lỗi ở Đây");
            return null;
        }
        ArrayList<DonThuoc> al = new ArrayList<>();
        try {
            while (rs.next()) {
                DonThuoc donThuoc = new DonThuoc();
                donThuoc.setDonGia(rs.getInt("GiaThanh"));
                donThuoc.setGhiChu(rs.getString("ghichu"));
                donThuoc.setMaPhieuKham(rs.getString("idPHIEUKHAM"));
                donThuoc.setsTT(rs.getInt("stt"));
                donThuoc.setSoLuong(rs.getInt("soLuong"));
                donThuoc.setTenThuoc(rs.getString("tenThuoc"));
                al.add(donThuoc);

            }
        } catch (Exception e) {
        }
        return al;
    }

    public ArrayList<PhieuKham> xuatPhieuKham(ResultSet rs) {

        if (rs == null) {
            System.out.println("Lỗi ở Đây");
            return null;
        }
        ArrayList<PhieuKham> al = new ArrayList<>();
        try {
            while (rs.next()) {
                PhieuKham kham = new PhieuKham();
                kham.setMaHoSo(rs.getString("idPHIEUKHAM"));
                kham.setMaPhieuKham(rs.getString("IDHOSO"));
                kham.setThoiGianCap(rs.getDate("thoiGianCap"));
                kham.setGhiChu(rs.getString("ghichu"));
                al.add(kham);
            }
        } catch (Exception e) {
        }
        return al;
    }

    public ResultSet xuatDanhSachXetNghiem() {
        ResultSet rs = null;
        String mySql = "SELECT * from xetngiem ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);

            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ResultSet xuatDanhSachHoSo() {
        ResultSet rs = null;
        String mySql = "SELECT hoso.* from hoso ";

        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);

            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ResultSet xuatDanhSachDonThuoc() {
        ResultSet rs = null;
        String mySql = "SELECT donthuoc.* from donthuoc ";

        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);

            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ResultSet xuatDanhSachPhieuKham() {
        ResultSet rs = null;
        String mySql = "SELECT phieukham.* from phieukham ";

        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);

            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ResultSet xuatDanhSachBenhAn() {
        ResultSet rs = null;
        String mySql = "SELECT benhan.* from benhan ";

        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);

            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    public ResultSet xuatDanhSachDayXetNghiem() {
        ResultSet rs = null;
        String mySql = "SELECT dayxetngihiem.* from dayxetngihiem ";

        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);

            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }
    public ResultSet traDayXetNghiem1(String maxetnghiemj) {
        ResultSet rs = null;
        String mySql = "SELECT dayxetngihiem.* from dayxetngihiem "
                + " where idxetnghiem = ? ";
        PreparedStatement pts;
        try {
            pts = connection.prepareCall(mySql);
            pts.setString(1, maxetnghiemj);
            rs = pts.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }
}

class aaa {

    public static void main(String[] args) throws SQLException {
        TruyVan cc = new TruyVan();

        String a = "2015-01-04";
        Date d = Date.valueOf(a);
//        HoSo hoSo = new HoSo("1FS", "gvfcrfc", "ijmgf", true, "gf", d, "uij");
        HoSo hoSo=new HoSo(a, a, a, a, true, d, a);
        BenhAn an = new BenhAn("FD5S", "njnnjk", "jiosod", d, d, "mdksa");
        PhieuKham kham = new PhieuKham("sdasd", "8", d, "deo co ghi chu j");
        DonThuoc donThuoc = new DonThuoc("as", "hihii", 3, 0, 0, 0, a);
        XetNghiem nghiem = new XetNghiem("8", "dcfvgh", d, a);
        //cc.themHoSo(hoSo);
      // System.err.println(""+cc.xuatPhieuKham(cc.xuatDanhSachPhieuKham()).size());

           }
}
