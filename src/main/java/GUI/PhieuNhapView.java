package main.java.GUI;

import javax.swing.*;
import java.awt.*;

public class PhieuNhapView extends JPanel{
    private JTextField JTPhieuNhap;
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
    private JTextField textField12;
    private JButton button5;
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
    private JLabel JTTimKiem_CTPN;

    public PhieuNhapView(){
        initComponents();
    }

    public void initComponents(){
        JPPhieuNhap.setPreferredSize(new Dimension(1130, 545));
        add(JPPhieuNhap);
        JPPhieuNhap.setVisible(true); // hiển thị JPanel
    }

}
