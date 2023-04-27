package main.java.GUI;

import main.java.DTO.SanPhamDTO;
import main.java.BLL.SanPhamBLL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BanHangView extends JPanel {
    private JPanel JPBanHang;
    private JTable TbSanPham;
    private JTextField JTTimKiem;
    private JButton JBThem;
    private JLabel JLGioHang;
    private JPanel JPSanPham;
    private JLabel JLNhap;
    private JPanel JPGioHang;
    private JPanel JPChucNang;
    private JTable JTGioHang;
    private JTable JTSanPham;
    private JScrollPane JSGioHang;
    private JScrollPane JSSanPham;
    private JTextField JTMaKH;
    private JTextField JTMaHD;
    private JTextField JTMaNV;
    private JTextField JTTongTien;
    private JTextField JTNgayTao;
    private JTextField JTTrangThai;
    private JTextField JTNhan;
    private JTextField JTTienThoi;
    private JButton JBTaoHD;
    private JButton JBTimKiem;
    private JLabel JLMaHD;
    private JLabel JLMaKH;
    private JLabel JLMaNV;
    private JLabel JLTongTien;
    private JLabel JLNgayTao;
    private JLabel JLTrangThai;
    private JLabel JLNhan;
    private JLabel JLTienThoi;
    private JLabel JL2;
    private JLabel JL1;
    private JLabel JL3;
    private JButton JBXoa;

    private DefaultTableModel modelGioHang;
    SanPhamBLL spBLL = new SanPhamBLL();

    public BanHangView() {
        initComponents();
        loadSP();
        modelGioHang = new DefaultTableModel();
        modelGioHang.addColumn("Mã sản phẩm");
        modelGioHang.addColumn("Tên sản phẩm ");
        modelGioHang.addColumn("Giá thành");
        modelGioHang.addColumn("Số lượng");
        modelGioHang.addColumn("Nhà cung cấp");
        JTGioHang.setModel(modelGioHang);
    }

    public void initComponents() {
        JPBanHang.setPreferredSize(new Dimension(1140, 545));
        add(JPBanHang);
        JBThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSPtoCart();
                float TongTien = 0.0f;
                for (int i = 0; i < JTGioHang.getRowCount(); i++){
                    float Gia = Float.parseFloat(JTGioHang.getValueAt(i, 2).toString());
                    int SL = Integer.parseInt(JTGioHang.getValueAt(i, 3).toString());
                    TongTien = TongTien + (Gia * SL);
                }
                JTTongTien.setText(Float.toString(TongTien));
            }
        });

        JBXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectrow = JTGioHang.getSelectedRow();
                String MaSP = JTGioHang.getValueAt(selectrow, 0).toString();
                spBLL.deleteSPfromCart(MaSP);
                loadSP();
                //load sản phẩm lên giỏ hàng
                int SL = Integer.parseInt(JTGioHang.getValueAt(selectrow, 3).toString());
                if (SL == 1){
                    modelGioHang.removeRow(selectrow);
                }
                else {
                    JTGioHang.getModel().setValueAt(SL - 1, selectrow, 3);
                }
            }
        });

        JPBanHang.setVisible(true); // hiển thị JPanel
    }

    public void loadSP() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm ");
        model.addColumn("Giá thành");
        model.addColumn("Số lượng");
        model.addColumn("Nhà cung cấp");

        JTSanPham.setModel(model);
        Vector<SanPhamDTO> arr = new Vector<SanPhamDTO>();
        arr = spBLL.getAllSanPham();
        for (int i = 0; i < arr.size(); i++) {
            SanPhamDTO sp = arr.get(i);
            String MaSP = sp.getMaSP();
            String TenSP = sp.getTenSP();
            float Gia = sp.getGia();
            int SoLg = sp.getSoLg();
            String NCC = sp.getNCC();
            Object[] row = {MaSP, TenSP, Gia, SoLg, NCC};
            model.addRow(row);
        }
    }

    public void addSPtoCart(){
        int selectrow = JTSanPham.getSelectedRow();
        String MaSP = JTSanPham.getValueAt(selectrow, 0).toString();
        spBLL.addSPtoCart(MaSP);
        loadSP();
        //load sản phẩm lên giỏ hàng
        System.out.println(MaSP + selectrow);
        String TenSP = JTSanPham.getValueAt(selectrow, 1).toString();
        float Gia = Float.parseFloat(JTSanPham.getValueAt(selectrow, 2).toString());
        //int SLTon = 0;
        String MaNCC = JTSanPham.getValueAt(selectrow, 4).toString();
        if (JTGioHang.getRowCount() == 0){
            System.out.println("IF NGOÀI CÙNG");
            int SLTon = 1;
            Object[] row = {MaSP, TenSP, Gia, SLTon, MaNCC};
            modelGioHang.addRow(row);
        }
        else {
            //duyệt trong bảng xem có mã sản phẩm mình cần không
            for (int i = 0; i <= JTGioHang.getRowCount(); i++) {
                if(i == JTGioHang.getRowCount()){
                    System.out.println("IF 2");
                    int SLTon2 = 1;
                    Object[] row = {MaSP, TenSP, Gia, SLTon2, MaNCC};
                    modelGioHang.addRow(row);
                    break;
                }
                else {
                    String value = JTGioHang.getValueAt(i, 0).toString();
                    if (value.equals(MaSP)) {
                        int SL = Integer.parseInt(JTGioHang.getValueAt(i, 3).toString());
                        System.out.println("IF 3");
                        JTGioHang.getModel().setValueAt(SL + 1, i, 3);
                        break;
                    }
                }
            }
        }
    }

}
