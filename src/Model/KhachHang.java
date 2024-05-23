/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL Latitude
 */
public class KhachHang {
    private String maKhachHang;    
    private String soDienThoai;
    private String diaCHi;

    public KhachHang(String maKhachHang, String soDienThoai, String diaCHi) {
        this.maKhachHang = maKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaCHi = diaCHi;
    }

   

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaCHi() {
        return diaCHi;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDiaCHi(String diaCHi) {
        this.diaCHi = diaCHi;
    }
           
}
