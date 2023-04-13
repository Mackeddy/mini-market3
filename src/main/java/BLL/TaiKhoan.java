package main.java.BLL;

public class TaiKhoan {
    String ID_taiKhoan, tenTaiKhoan, matKhau;
    public TaiKhoan(String ID_taiKhoan, String tenTaiKhoan, String matKhau){
        this.ID_taiKhoan = ID_taiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this. matKhau =  matKhau;
    }

    public String getID_taiKhoan() {
        return ID_taiKhoan;
    }

    public void setID_taiKhoan(String ID_taiKhoan) {
        this.ID_taiKhoan = ID_taiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
