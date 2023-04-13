package main.java.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
    private JPanel panel1;
    private JButton JBKhachHang;
    private JButton JBNhanVien;
    private JButton JBHoaDon;
    private JButton JBNhaCungCap;
    private JButton JBBanHang;
    private JLabel JLAdmin;
    private JButton JBDoanhThu;
    private JButton JBTroVe;
    private JPanel JPright;
    private JButton JBSanPham;
    private JButton tàiKhoảnButton;

    public MainView() {
        setTitle("Trang chủ quản lý bán hàng");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 650);
        setVisible(true);

        //thêm sự kiện vào nút trở về
        JBTroVe.addActionListener(new ActionListener() {
            //Xử lý sự kiện cho nút
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Đã nhấn nút Trở về");
                DangNhap dn = new DangNhap();
                dn.setSize(900, 600); // Đặt kích thước của frame DangNhap dựa trên nội dung của các thành phần bên trong
                dn.setLocationRelativeTo(null); // Đặt vị trí của frame DangNhap giữa màn hình
                dn.setVisible(true);
                setVisible(false);
                //dispose();
            }
        });
        JBBanHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPright.removeAll();
                JPright.add(new BanHangView());
                JPright.revalidate(); // Cập nhật lại giao diện
                JPright.repaint();
            }
        });

        JBSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPright.removeAll();
                JPright.add(new NhanVienView());
                JPright.revalidate(); // Cập nhật lại giao diện
                JPright.repaint();
            }
        });

//        JBNhanVien.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JPright.removeAll();
//                JPright.add(new SP_UI());
//                JPright.revalidate(); // Cập nhật lại giao diện
//                JPright.repaint();
//            }
//        });

    }

    public static void main(String[] args) {
        new MainView();
        // Hiển thị frame
    }
}
