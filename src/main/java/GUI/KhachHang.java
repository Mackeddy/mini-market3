package main.java.GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class KhachHang extends JPanel{

    private JTable table1;
    private JButton thêmButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton xóaButton;
    private JButton sửaButton;
    private JButton tìmKiếmButton;
    private JTextField textField8;
    private JPanel JPKhachHang;

    KhachHang(){
        JPKhachHang.setPreferredSize(new Dimension(1128, 510));
        add(JPKhachHang);
        JPKhachHang.setVisible(true); // hiển thị JPanel
    }
}
