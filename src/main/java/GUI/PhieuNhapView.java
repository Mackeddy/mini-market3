package main.java.GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import main.java.BLL.PhieuNhapBLL;
import main.java.DAL.PhieuNhapDAL;
import main.java.DTO.PhieuNhapDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PhieuNhapView extends JPanel{
    private JTextField JTMaPN;
    private JTextField JTNgayNhap;
    private JTextField JTMaNCC;
    private JTextField JTTongTien;
    private JTextField JTMaPN2;
    private JTextField JTMaSP;
    private JTextField JTTenSP;
    private JTextField JTSoLuong;
    private JTextField JTDonGia;
    private JTextField JTThanhTIen;
    private JPanel JPPhieuNhap;
    private JButton JBThem;
    private JButton JBXoa;
    private JButton JBSua;
    private JButton JLCTPN_Them;
    private JButton JLCTPN_Xoa;
    private JButton JBCTPN_Sua;
    private JTable JTQLPhieuNhap;
    private JTable JTCTPN;
    private JTextField JTTimKiem;
    private JButton JBTimkiem;
    private JPanel JPQLPhieuNhap;
    private JScrollPane JSQLPhieuNhap;
    private JPanel JPCTPN;
    private JScrollPane JSCTPN;
    private JPanel JPNhapPN;
    private JPanel JPNhapCTPN;
    private JLabel JLMaPN;
    private JLabel JLNgayNhap;
    private JLabel JLMaNCC;
    private JLabel JLTongTIen;
    private JLabel JLMaPN2;
    private JLabel JLMaSP;
    private JLabel JLTenSP;
    private JLabel JLSoLuong;
    private JLabel JLDonGia;
    private JLabel JLThanhTien;
    private JLabel JLNhap_CTPN;
    private JLabel JLNhap;
    private JLabel JLPhieuNhap;
    private JLabel JLTimKiem;

    PhieuNhapBLL pnBLL = new PhieuNhapBLL();

    public PhieuNhapView(){
        initComponents();
        loadPhieuNhap();
    }

    public void initComponents(){
        JPPhieuNhap.setPreferredSize(new Dimension(1130, 545));
        add(JPPhieuNhap);
        JPPhieuNhap.setVisible(true); // hiển thị JPanel
        JBThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Kiểm tra thông tin nhập vào có đúng không
                    if ( JTMaPN.getText().trim().equals("")    ||
                            JTNgayNhap.getText().trim().equals("") ||
                            JTMaNCC.getText().trim().equals("")     ||
                            JTTongTien.getText().trim().equals(""))
                        JOptionPane.showMessageDialog(JPPhieuNhap,"Vui lòng nhập đủ thông tin");
                    else {
                        // Lấy dữ liệu người dùng nhập vào để chuyển xuống BLL
                        PhieuNhapDTO pn = new PhieuNhapDTO();
                        pn.setMaPN(JTMaPN.getText());
                        String NgayNhap = JTNgayNhap.getText();
                        if (NgayNhap != null) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date nt = null;
                            try {
                                nt = sdf.parse(NgayNhap);
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                            pn.setNgayNhap(nt);
                        }
                        pn.setMaNCC(JTMaNCC.getText());
                        pn.setTongTien(Float.parseFloat(JTTongTien.getText()));
                        JOptionPane.showMessageDialog(JPPhieuNhap, pnBLL.addPhieuNhap(pn));
                        loadPhieuNhap();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(JPPhieuNhap, "Thông tin không hợp lệ");
                }
            }
        });
    }

    public void loadPhieuNhap(){
        // Tạo model và thêm các cột vào model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Phiếu Nhập");
        model.addColumn("Ngày Nhập");
        model.addColumn("Mã Nhà Cung Cấp");
        model.addColumn("Tổng Tiền");

        // Gắn model vào bảng
        JTQLPhieuNhap.setModel(model);
        Vector<PhieuNhapDTO> pn_arr = new Vector<PhieuNhapDTO>();
        pn_arr = pnBLL.getAllPhieuNhap();
        for (int i = 0; i < pn_arr.size(); i++){
            PhieuNhapDTO pn = pn_arr.get(i);
            String MaPN = pn.getMaPN();
            Date NgayNhap = pn.getNgayNhap();
            String MaNCC = pn.getMaNCC();
            Float TongTien = pn.getTongTien();
            Object[] row = {MaPN, NgayNhap, MaNCC, TongTien};
            model.addRow(row);
        }
    }

}
