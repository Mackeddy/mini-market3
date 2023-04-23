package main.java.DAL;

import main.java.DTO.SanPhamDTO;

import java.sql.*;
import java.util.Vector;

public class SanPhamDAL {
    private Connection con;
    public  boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;database=SanPham";
            String username ="sa"; String password = "123456aA@$";
            con = DriverManager.getConnection(dbUrl,username,password);
            return true;

        }catch (Exception e){
            System.out.println(e);
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
    public Vector<SanPhamDTO> getAllSanPham(){
        Vector<SanPhamDTO> arr = new Vector<SanPhamDTO>();
        if(openConnection()){
            try {
                String sql = "Select * from San_Pham";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    SanPhamDTO sp = new SanPhamDTO();
                    sp.setMaSP(rs.getString("Mã sản phẩm"));
                    sp.setTenSP(rs.getString("Tên sản phẩm "));
                    sp.setNCC(rs.getString("Nhà cung cấp"));
                    sp.setGia(rs.getFloat("Giá thành"));
                    sp.setSoLg(rs.getInt("Số lượng"));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }finally {
                closeConnection();
            }}
        return arr;
    }
    //MaSP,TenSP,NCC,Gia,SL
    public boolean addSP(SanPhamDTO sp)  {
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "insert into San_Pham(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,sp.getMaSP());
                stmt.setString(2,sp.getTenSP());
                stmt.setString(3,sp.getNCC());
                stmt.setDouble(4,sp.getGia());
                stmt.setInt(5,sp.getSoLg());
                if(stmt.executeUpdate()>=1)
                result = true;
            }catch (Exception e){
                System.out.println(e);
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public boolean hasMaSP(String MaSP){
        boolean result = false;
        if(openConnection()){
            try{
                String sql ="SELECT * FROM San_Pham WHERE MaSP ='"+MaSP+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            }catch (SQLException e){
                System.out.println(e);
            }finally {
                closeConnection();
            }

        }
        return result;
    }
    public boolean deleteSP(String MaSP) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "DELETE * FROM San_Pham WHERE MaSP ='" + MaSP + "'";
                Statement stmt = con.createStatement();
                int rowCount = stmt.executeUpdate(sql);
                if (rowCount > 0)
                    result = true;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Lỗi ở hàm  delete");
            } finally {
                closeConnection();
            }
        }
        return result;
    }
    public boolean updateSP(SanPhamDTO sp,String MaSP_old){
        boolean result = false;
        if(openConnection()){
            try{
                System.out.println(MaSP_old);
                String sql = "Update San_Pham  TenSP = ?, GiaSP = ? " + "Where MaSp = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,sp.getTenSP());
                stmt.setDouble(2,sp.getGia());
                stmt.setString(3,MaSP_old);
                int rowCount = stmt.executeUpdate();
                System.out.println(rowCount);
                if(rowCount > 0) result = true;

            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Lỗi ở hàm Update");
            }finally {
                closeConnection();
            }
        }
        return result;
    }
}
