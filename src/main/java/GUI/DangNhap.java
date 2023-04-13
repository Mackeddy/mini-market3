package main.java.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhap extends JFrame{
    private JTextField tfTentaikhoan;
    private JButton JBDangnhap;
    private JButton JBThoat;
    private JLabel JLTentaikhoan;
    private JLabel JLMatkhau;
    private JPanel JPDangnhap;
    private JPasswordField JFMatkhau;
    private JButton JBDangNhap;


    public DangNhap() {
        setContentPane(JPDangnhap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);

        JBDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Đã nhấn nút đăng nhập");
                MainView mainView = new MainView();
                mainView.setSize(900, 600); // Đặt kích thước của frame DangNhap dựa trên nội dung của các thành phần bên trong
                mainView.setLocationRelativeTo(null); // Đặt vị trí của frame DangNhap giữa màn hình
                mainView.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new DangNhap();
        System.out.println("Đã khởi tạo DangNhap");
        // Hiển thị frame
    }
}
