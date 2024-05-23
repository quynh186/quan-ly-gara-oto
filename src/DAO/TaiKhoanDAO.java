/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JdbcHelper.JdbcHelper;
import static JdbcHelper.JdbcHelper.executeUpdate;
import static JdbcHelper.JdbcHelper.preparedStatement;
import Model.TaiKhoan;
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
public class TaiKhoanDAO {
      public List<TaiKhoan> hienDanhSachTaiKhoan() {
        String sql = "SELECT * FROM tai_khoan";
        return truyVanTaiKhoan(sql);
    }

    public List<TaiKhoan> hienThiTaiKhoan(Object... args) {
        String sql = "SELECT * FROM tai_khoan WHERE tentaikhoan = ?";
        return truyVanTaiKhoan(sql, args);
    }
    // Phương thức dùng để xác thực tài khoản người dùng
    public boolean dangNhap(String tenTaiKhoan, String matKhau) {
        String sql = "SELECT * FROM tai_khoan WHERE tentaikhoan = ? AND matkhau = ?"; // dấu ? dùng để xác định hai đối số tenTaiKhoan và matKhau
        return !truyVanTaiKhoan(sql, tenTaiKhoan, matKhau).isEmpty();
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

    private List<TaiKhoan> truyVanTaiKhoan(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);

                while (rs.next()) {
                    TaiKhoan taiKhoan = layDuLieuTuBangTaiKhoan(rs);
                    list.add(taiKhoan);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private TaiKhoan layDuLieuTuBangTaiKhoan(ResultSet rs) throws SQLException {
        TaiKhoan taiKhoan =
                new TaiKhoan(
                             rs.getString("tentaikhoan"),
                             rs.getString("matkhau"),
                             rs.getString("quyen")
                            ); 
 
        return taiKhoan;
    }
    
     public static void main(String[] args) throws SQLException {
         TaiKhoanDAO tkDAO = new TaiKhoanDAO();
                 
                  
//                  System.out.print(tkDAO.dangNhap("quynh","123"));

//         for(int i = 0; i<dstaikhoan.size(); i++ ){
//             System.out.print(dstaikhoan.get(i).toString());
//         }

    }
}
