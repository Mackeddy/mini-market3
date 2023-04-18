package main.java.GUI;

import main.java.BLL.AdminBLL;
import main.java.DTO.AdminDTO;
import main.java.DAL.AdminDAL;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TaiKhoanView extends  JPanel{
    private JTextField JTTimKiem;
    private JButton JBTimKiem;
    private JButton JBThem;
    private JButton JBXoa;
    private JTable TBTaiKhoan;
    private JButton JBCapNhat;
    private JTextField JTMaTK;
    private JTextField JTTenTK;
    private JTextField JTMatKhau;
    private JPanel JPTaiKhoan;
    private JPanel JPTable;
    private JScrollPane JSTable;
    private JLabel JLNhap;
    private JLabel JLMaTK;
    private JLabel JLTenTK;
    private JLabel JLMatKhau;
    private JLabel JLTimkiem;

    AdminBLL tkBLL = new AdminBLL();
    public TaiKhoanView(){
        initComponents();
        loadTaiKhoan();
    }

    public void initComponents(){
        JPTaiKhoan.setPreferredSize(new Dimension(1128, 510));
        add(JPTaiKhoan);
        JBThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (JTMaTK.getText().trim().equals("") ||
                            JTTenTK.getText().trim().equals("") ||
                            JTMatKhau.getText().trim().equals(""))
                        JOptionPane.showMessageDialog(JPTaiKhoan,"Vui lòng nhập đủ thông tin");
                    else {
                        //Lấy dữ liệu người dùng nhập vào để chuyển xuống BLL
                        AdminDTO tk = new AdminDTO();
                        tk.setMaTK(JTMaTK.getText());
                        tk.setTenTK(JTTenTK.getText());
                        tk.setMatKhau(JTMatKhau.getText());
                        JOptionPane.showMessageDialog(JPTaiKhoan, tkBLL.addTaiKhoan(tk));
                        loadTaiKhoan();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(JPTaiKhoan, "Thông tin không hợp lệ");
                }
            }
        });
        JPTaiKhoan.setVisible(true); // hiển thị JPanel
    }

    public void loadTaiKhoan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Tài Khoản");
        model.addColumn("Tên Người dùng ");
        model.addColumn("Mật Khẩu");

        // Gắn model vào bảng
        TBTaiKhoan.setModel(model);
        Vector<AdminDTO> arr = new Vector<AdminDTO>();
        arr = tkBLL.getAllTK();
        for (int i = 0; i < arr.size(); i++){
            AdminDTO tk = arr.get(i);
            String MaTK = tk.getMaTK();
            String TenTK = tk.getTenTK();
            String MatKhau = tk.getMatKhau();
            Object[] row = {MaTK, TenTK, MatKhau};
            model.addRow(row);
        }
    }

}
