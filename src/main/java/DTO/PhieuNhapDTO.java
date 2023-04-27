package main.java.DTO;

import java.util.Date;

public class PhieuNhapDTO {
    private String MaPN, MaNCC;
    private Float TongTien;
    private Date NgayNhap;

    public String getMaPN(){
        return MaPN;
    }
    public void setMaPN(String MaPN){
        this.MaPN = MaPN;
    }
    public String getMaNCC(){
        return MaNCC;
    }
    public void setMaNCC(String MaNCC){
        this.MaNCC = MaNCC;
    }
    public Float getTongTien(){
        return TongTien;
    }
    public void setTongTien(Float TongTien){
        this.TongTien = TongTien;
    }
    public Date getNgayNhap(){
        return NgayNhap;
    }
    public void setNgayNhap(Date NgayNhap){
        this.NgayNhap = NgayNhap;
    }
}
