package main.java.DAL;

import DTO.SanPhamDTO;

import java.sql.*;
import java.util.Vector;

public class SanPhamDAL {
    private Connection con;
    public  boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;database=SanPham;encrypt=false";
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
                String sql = "SELECT * FROM ministore.SP";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    SanPhamDTO sp = new SanPhamDTO();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setGia(rs.getFloat("GiaSP"));
                    sp.setSoLg(rs.getInt("SoLg"));
                    sp.setNCC(rs.getString("NCC"));
                    arr.add(sp);
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
                String sql = "INSERT INTO ministore.SP values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,sp.getMaSP());
                stmt.setString(2,sp.getTenSP());
                stmt.setFloat(3,sp.getGia());
                stmt.setInt(4,sp.getSoLg());
                stmt.setString(5,sp.getNCC());
                if(stmt.executeUpdate()>=1)
                    result = true;

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Lỗi ở hàm add");
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
                String sql ="SELECT * FROM ministore.SP WHERE MaSP ='"+MaSP+"'";
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
                String sql = "DELETE  FROM ministore.SP WHERE MaSP ='" + MaSP + "'";
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
    public boolean updateSP(SanPhamDTO sp,String MaSP){
        boolean result = false;
        if(openConnection()){
            try{
                System.out.println(MaSP);
                String sql = "UPDATE ministore.SP SET MaSP = ?, TenSP = ?, GiaSP = ?, SoLg = ?, NCC = ?"+" WHERE MaSp = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,sp.getMaSP());
                stmt.setString(2,sp.getTenSP());
                stmt.setFloat(3,sp.getGia());
                stmt.setInt(4,sp.getSoLg());
                stmt.setString(5,sp.getNCC());
                stmt.setString(6,MaSP);
                int rowCount = stmt.executeUpdate();
                System.out.println(rowCount);
                if(rowCount > 0)
                    result = true;

            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Lỗi ở hàm Update");
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public boolean searchMaSP(Vector<SanPhamDTO> sp_arr, String MaSP){
        boolean result = false;
        if (openConnection()) {
            try {
                //dùng câu truy vấn để lấy bản ghi của cột MaTK trùng với MaTK truyền vào
                String sql = "SELECT * FROM ministore.SP WHERE MaSP = '" + MaSP + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    SanPhamDTO sp = new SanPhamDTO();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setGia(rs.getFloat("GiaSP"));
                    sp.setSoLg(rs.getInt("SoLg"));
                    sp.setNCC(rs.getString("NCC"));
                    sp_arr.add(sp);
                }
                if(sp_arr.size() > 0)
                    result = true;
            } catch (SQLException ex){
                System.out.println("Lỗi ở hàm searchSP của class SanPhamDAL");
            } finally {
                closeConnection();
            }
        }
        return result;
    }
}
