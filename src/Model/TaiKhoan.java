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
    private String id;    
    private String tenTaiKhoan;

    private String matKhau;
    public static String quyen;

    public TaiKhoan(String id, String tenTaiKhoan, String matKhau, String quyen) {
        this.id = id;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;        
        TaiKhoan.quyen = quyen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "TaiKhoan{" + "id=" + id + ", tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + '}';
    }
    
}
