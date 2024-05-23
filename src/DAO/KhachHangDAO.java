/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JdbcHelper.JdbcHelper;
import static JdbcHelper.JdbcHelper.executeUpdate;
import static JdbcHelper.JdbcHelper.preparedStatement;
import Model.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL Latitude
 */
public class KhachHangDAO {
      public List<KhachHang> hienDanhSachKhachHang() {
        String sql = "SELECT * FROM canbo";
        return truyVanKhachHang(sql);
    }

    public List<KhachHang> hienThiCanBo(String timKiem) {
        String sql = "{CALL tim_kiem_can_bo(?)} ";
        return truyVanKhachHang(sql, timKiem);
    }

    public List<KhachHang> timAnh(String maCanBo) {
        String sql = "SELECT * FROM canbo WHERE macanbo = ?";
        return truyVanKhachHang(sql, maCanBo);
    }

    public void themCanBo(String maCanBo, String hoTenKhaiSinh,
            String gioiTinh, String ngaySinh, String tinhTrangHonNhan,
            String soCMND, String queQuan, String noiOHienTai, String email,
            String danToc, String tonGiao, String ngayHopDong,
            String congViecDuocGiao, String maChucVu, String chuyenNganhDaoTao,
            String noiDaoTao, String namTotNghiep, String trinhDoNgoaiNgu,
            String maPhongBan, String anh, Object... args) throws SQLException {

        String sql = """
                     INSERT INTO canbo (
                             macanbo,
                             hotenkhaisinh,
                             gioitinh,
                             ngaysinh,
                             tinhtranghonnhan,
                             soCMND,
                             quequan,
                             noiohientai,
                             email,
                             dantoc,
                             tongiao,
                             ngayhopdong,
                             congviecduocgiao,
                             machucvu,
                             chuyennganhdaotao,
                             noidaotao,
                             namtotnghiep,
                             trinhdongoainnguthanhthaonhat,
                             maphongban,
                             anh 
                          
                         ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)""";

        try (PreparedStatement pstmt = preparedStatement(sql, maCanBo, hoTenKhaiSinh,
                gioiTinh, ngaySinh, tinhTrangHonNhan,
                soCMND, queQuan, noiOHienTai, email,
                danToc, tonGiao, ngayHopDong,
                congViecDuocGiao, maChucVu, chuyenNganhDaoTao,
                noiDaoTao, namTotNghiep, trinhDoNgoaiNgu,
                maPhongBan, anh
        )) {
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void suaCanBo(String maCanBo, String hoTenKhaiSinh,
            String gioiTinh, String ngaySinh, String tinhTrangHonNhan,
            String soCMND, String queQuan, String noiOHienTai, String email,
            String danToc, String tonGiao, String ngayHopDong,
            String congViecDuocGiao, String maChucVu, String chuyenNganhDaoTao,
            String noiDaoTao, String namTotNghiep, String trinhDoNgoaiNgu,
            String maPhongBan, String anh, Object... args) throws SQLException {

        String sql = """
                     UPDATE canbo 
                     SET
                     hotenkhaisinh = ?,
                     gioitinh = ?,
                     ngaysinh = ?,
                     tinhtranghonnhan = ?,
                     soCMND = ?,
                     quequan = ?,
                     noiohientai = ?,
                     email = ?,
                     dantoc = ?,
                     tongiao = ?,
                     ngayhopdong = ?,
                     congviecduocgiao = ?,
                     machucvu = ?,
                     chuyennganhdaotao = ?,
                     noidaotao = ?,
                     namtotnghiep = ?,
                     trinhdongoainnguthanhthaonhat = ?,
                     maphongban = ?,
                     anh = ? 
                     WHERE macanbo = ?""";
        try {
            executeUpdate(sql, hoTenKhaiSinh,
                    gioiTinh, ngaySinh, tinhTrangHonNhan,
                    soCMND, queQuan, noiOHienTai, email,
                    danToc, tonGiao, ngayHopDong,
                    congViecDuocGiao, maChucVu, chuyenNganhDaoTao,
                    noiDaoTao, namTotNghiep, trinhDoNgoaiNgu,
                    maPhongBan, anh, maCanBo
            );
            JOptionPane.showMessageDialog(null, "Sửa cán bộ " + maCanBo + " thành công");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void xoaCanBo(String maCanBo, Object... args) throws SQLException {
        String sql = """
                      DELETE FROM canbo WHERE macanbo = ?
                     """;
        try {
            executeUpdate(sql, maCanBo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private List<KhachHang> truyVanKhachHang(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);

                while (rs.next()) {
                    KhachHang khachHang = layDuLieuTuBangCanBo(rs);
                    list.add(khachHang);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private KhachHang layDuLieuTuBangCanBo(ResultSet rs) throws SQLException {
        KhachHang khachHang = new KhachHang("","",""); 
        return khachHang;
    }
}
