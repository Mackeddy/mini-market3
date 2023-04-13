package main.java.BLL;

public class Nhanvien {
    String ID;
    Double Luong, heSo;
    Integer soGio;
    public Nhanvien(String ID, Double Luong, Double heSo, Integer soGio){
        super();
        this.ID = ID;
        this.Luong = Luong;
        this.heSo = heSo;
        this.soGio = soGio;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public Double getLuong() {
        return Luong;
    }

    public void setLuong(Double Luong) {
        this.Luong = Luong;
    }

    public Double getHeSo() {
        return heSo;
    }

    public void setHeSo(Double heSo) {
        this.heSo = heSo;
    }

    public Integer getSoGio() {
        return soGio;
    }

    public void setSoGio(Integer soGio) {
        this.soGio = soGio;
    }
}
