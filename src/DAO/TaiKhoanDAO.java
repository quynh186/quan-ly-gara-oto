/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBCHelper.JdbcHelper;
import static JDBCHelper.JdbcHelper.executeUpdate;
import static JDBCHelper.JdbcHelper.preparedStatement;
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

    // Phương thức dùng để xác thực tài khoản người dùng
    public boolean dangNhap(String tenTaiKhoan, String matKhau) {
        String sql = "SELECT * FROM tai_khoan WHERE tentaikhoan = ? AND matkhau = ?"; // dấu ? dùng để xác định hai đối số tenTaiKhoan và matKhau
        List<TaiKhoan> xacThuc = truyVanTaiKhoan(sql, tenTaiKhoan, matKhau);
        if (!xacThuc.isEmpty()) {
            TaiKhoan.isAmind = xacThuc.get(0).getQuyen();

        }
        return !xacThuc.isEmpty();
    }

    public void themTaiKhoan(Object... args) throws SQLException {

        String sql = """
                     INSERT INTO tai_khoan (
                             tentaikhoan,
                             matkhau,
                             quyen
                         ) VALUES(?,?,?)""";

        try (PreparedStatement pstmt = preparedStatement(sql, args
        )) {
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void suaTaiKhoan(Object... args) throws SQLException {

        String sql = """
                     UPDATE taikhoan 
                     SET
                     tentaikhoan = ?,
                     matkhau = ?,
                     quyen = ? 
                     WHERE id = ?""";
        try {
            executeUpdate(sql, args
            );
            JOptionPane.showMessageDialog(null, "Sửa tài khoản " + args[1] + " thành công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa tài khoản " + args[1] + " thất bại");

            System.out.println(ex.getMessage());
        }

    }

    public void xoaTaiKhoan(String maTaiKhoan, Object... args) throws SQLException {
        String sql = """
                      DELETE FROM taikhoan WHERE id = ?
                     """;
        try {
            executeUpdate(sql, maTaiKhoan);
            JOptionPane.showMessageDialog(null, "Xóa tài khoản " + args[1] + " thành công");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xóa tài khoản " + args[1] + " thất bại");

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
        TaiKhoan taiKhoan
                = new TaiKhoan(
                        rs.getString("id"),
                        rs.getString("tentaikhoan"),
                        rs.getString("matkhau"),
                        rs.getString("quyen")
                );

        return taiKhoan;
    }
}
