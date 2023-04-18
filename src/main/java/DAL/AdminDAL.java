package main.java.DAL;
import main.java.DTO.AdminDTO;
import java.sql.*;
import java.util.Vector;

public class AdminDAL {
    private Connection con;

    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String DBurl = "jdbc:sqlserver://localhost\\PD:1433;database=mini_market;encrypt=false;";
            String username = "sa";
            String password = "12345678";
            con = DriverManager.getConnection(DBurl, username, password);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    // Lấy danh sách tài khoản từ csdl
    public Vector<AdminDTO> getAllTK() {
        Vector<AdminDTO> arr = new Vector<AdminDTO>();
        if (openConnection()) {
            try {
                String sql = "Select * from TaiKhoan";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    AdminDTO tk = new AdminDTO();
                    tk.setMaTK(rs.getString("MaTK"));
                    tk.setTenTK(rs.getString("MaNV"));
                    tk.setMatKhau(rs.getString("MatKhau"));
                    arr.add(tk);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }

    //Thêm tk vào csdl
    public boolean addTaiKhoan(AdminDTO tkn) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "Insert into TaiKhoan values(?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, tkn.getMaTK());
                stmt.setString(2, tkn.getTenTK());
                stmt.setString(3, tkn.getMatKhau());
                if (stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    //Kiểm tra xem tk đưa vào có tồn tại không
    public boolean hasMaTK(String MaTK){
        boolean result = false;
        if (openConnection()) {
            try {
                //dùng câu truy vấn để lấy bản ghi của cột MaTK trùng với MaTK truyền vào
                String sql ="SELECT * FROM TaiKhoan WHERE MaTK = '" + MaTK + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                //Nếu câu truy vấn trả veef ít nhất 1 bản ghi thì cập nhật result là true
                result = rs.next();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
}