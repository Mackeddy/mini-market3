package main.java.BLL;

import main.java.DTO.SanPhamDTO;
import main.java.DAL.SanPhamDAL;

import java.util.Vector;

public class SanPhamBLL {
    SanPhamDAL spDAL = new SanPhamDAL();
    public Vector<SanPhamDTO> getAllSanPham(){
        return spDAL.getAllSanPham();
    }

    public String addSP(SanPhamDTO sp) {
        // BLL xử lý logic và đưa xuống DAL để DAL add dữ liệu vào csdl
        if (spDAL.hasMaSP(sp.getMaSP()))
            return "Mã SP đã tồn tại";
        if (spDAL.addSP(sp))
            return "Thêm thành công";
        return "Thêm thất bại";
    }

    public String deleteSP(SanPhamDTO tk){
        // BLL xử lý logic và đưa xuống DAL để DAL add dữ liệu vào csdl
        if (spDAL.deleteSP(tk.getMaSP()))
            return "Xóa sản phẩm thành công";
        return "Xóa sản phẩm thất bại";
    }

    public String updateSP(SanPhamDTO sp, String MaSP_old){
        // BLL xử lý logic và đưa xuống DAL để DAL add dữ liệu vào csdl
        if (spDAL.updateSP(sp, MaSP_old))
            return "Cập nhật sản phẩm thành công";
        return "Cập nhật sản phẩm thất bại";
    }


}
