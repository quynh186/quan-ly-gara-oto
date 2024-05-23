/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL Latitude
 */
public class Oto {
    String bienSo;
    String loaiXe;
    String tinhTrangXe;

    public Oto(String bienSo, String loaiXe, String tinhTrangXe) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.tinhTrangXe = tinhTrangXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public String getTinhTrangXe() {
        return tinhTrangXe;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public void setTinhTrangXe(String tinhTrangXe) {
        this.tinhTrangXe = tinhTrangXe;
    }
    
}
