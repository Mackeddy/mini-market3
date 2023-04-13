package main.java.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BanHangView extends JPanel{
    private JPanel JPBanHang;
    private JTextField JTMaHoaDon;
    private JTextField JTTongTien;
    private JTextField JTThue;
    private JTextField JTThanhToan;
    private JTextField JTNhan;
    private JTable TbGioHang;
    private JTable TbSanPham;
    private JTextField JTTienThoi;
    private JTextField JTNguoiLap;
    private JTextField JTTimKiem;
    private JButton JBThem;
    private JButton tạoHóaĐơnButton;
    private JLabel JLGioHang;
    private JScrollPane JSGioHang;
    private JPanel JPSanPham;
    private JScrollPane JSSanPham;
    private JLabel JLTimKiem;
    private JLabel JLMaHoaDon;
    private JLabel JLNguoiLap;
    private JLabel JLTongTien;
    private JLabel JThue;
    private JLabel JThanhToan;
    private JLabel JLNhan;
    private JLabel JLTienThoi;
    private JLabel JLTienTe3;
    private JLabel JLTienTe1;
    private JLabel JLTienTe2;
    private JPanel JPGioHang;
    private JPanel JPChucNang;

    public BanHangView(){
        JPBanHang.setPreferredSize(new Dimension(1128, 510));
        add(JPBanHang);
        JPBanHang.setVisible(true); // hiển thị JPanel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sản Phẩm");
        model.addColumn("Tên Sản Phẩm ");
        model.addColumn("Giá");

        // Gắn model vào bảng
        TbSanPham.setModel(model);
    }

    public static void main (String[] args){
        new BanHangView();
    }
}
