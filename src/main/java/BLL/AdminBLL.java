package main.java.BLL;

import main.java.DTO.AdminDTO;
import main.java.DAL.AdminDAL;
import java.util.Vector;
public class AdminBLL {
    AdminDAL tkDAL = new AdminDAL();
    public Vector<AdminDTO> getAllTK(){
        return tkDAL.getAllTK();
    }

    public String addTaiKhoan(AdminDTO tkn) {
        // BLL xử lý logic và đưa xuống DAL để DAL add dữ liệu vào csdl
        if (tkDAL.hasMaTK(tkn.getMaTK()))
            return "Mã NV đã tồn tại";
        if (tkDAL.addTaiKhoan(tkn))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
}

