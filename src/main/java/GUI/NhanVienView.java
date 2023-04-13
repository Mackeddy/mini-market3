package main.java.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NhanVienView extends JPanel{
    private JButton thêmButton;
    private JButton xóaButton;
    private JButton sửaButton;
    private JButton tìmKiếmButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField chứcVụTextField;
    private JTable table1;
    private JPanel JPChucNang;
    private JPanel JPThongTin;
    private JLabel JLId;
    private JLabel JLHoTen;
    private JLabel JLsdt;
    private JLabel JLEmail;
    private JLabel JLChucvu;
    private JPanel JPNhanVien;
    private JTextField textField5;
    private JTextField textField4;
    private JTextField textField6;

    public NhanVienView(){
        JPNhanVien.setPreferredSize(new Dimension(1120, 500));
        add(JPNhanVien);
        JPNhanVien.setVisible(true); // hiển thị JPanel
        // Tạo model và thêm các cột vào model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã sinh viên");
        model.addColumn("Họ và tên sinh viên");
        model.addColumn("Điểm");

        // Gắn model vào bảng
        table1.setModel(model);
        setVisible(true);
    }



    public static void main(String[] args) {
        new NhanVienView();
    }

}
