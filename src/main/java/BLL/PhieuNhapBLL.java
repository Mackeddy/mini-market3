package main.java.BLL;

import main.java.DAL.PhieuNhapDAL;
import main.java.DTO.PhieuNhapDTO;

public class PhieuNhapBLL {
    PhieuNhapDAL pnDAL = new PhieuNhapDAL();
    public String addNhanVien(PhieuNhapDTO pn){
        // BLL xử lý logic và đưa xuống DAL để DAL add dữ liệu vào csdl
        if (pnDAL.hasMaPN(pn.getMaPN()))
            return "Mã phiếu nhập đã tồn tại";
        if (pnDAL.addPhieuNhap(pn))
            return "Thêm phiếu nhập thành công";
        return "Thêm phiếu nhập thất bại";
    }
}
