/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL Latitude
 */
public class TaiKhoan {
    private String tenTaiKhoan;
    private String matKhau;
    static String quyen;

    public TaiKhoan(String tenTaiKhoan, String matKhau, String quyen) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;        
        TaiKhoan.quyen = quyen;
    }

    

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public static String getQuyen() {
        return quyen;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public static void setQuyen(String quyen) {
        TaiKhoan.quyen = quyen;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + '}';
    }
    
    
}
