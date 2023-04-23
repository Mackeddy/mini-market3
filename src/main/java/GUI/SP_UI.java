package main.java.GUI;
import main.java.BLL.SanPhamBLL;
import main.java.DTO.SanPhamDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class SP_UI extends JPanel {

    private JPanel SP_Panel;
    private JTextField JT_TenSP;
    private JTextField JT_MaSP;
    private JTextField JT_GiaSP;
    private JTextField JT_NCC;
    private JButton JB_ThemSP;
    private JButton JB_XoaSP;
    private JButton JB_SuaSP;
    private JButton JB_TimSP;
    private JScrollBar scrollBar1;
    private JTable JTB_SP;
    private JLabel JL_TenSP;
    private JLabel JL_MaSP;
    private JLabel JL_GiaSP;
    private JLabel JL_NCC;
    private JPanel TT;
    private JLabel JL_SoLg;
    private JTextField JT_SoLg;
    SanPhamBLL spBLL = new SanPhamBLL();

    SP_UI(){
        SP_Panel.setPreferredSize(new Dimension(1128, 510));
        add(SP_Panel);
        SP_Panel.setVisible(true); // hiển thị JPanel
        initComponents();
        loadSP();
    }
    public void initComponents(){
//        SP_Panel.setPreferredSize(new Dimension(1128,510));
//        add(SP_Panel);
        JB_ThemSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(JT_MaSP.getText().trim().equals("") ||
                            JT_TenSP.getText().trim().equals("") ||
                            JT_GiaSP.getText().trim().equals("") ||
                            JT_NCC.getText().trim().equals("") ||
                            JT_SoLg.getText().trim().equals(""))
                        JOptionPane.showMessageDialog(SP_Panel,"Vui lòng nhập lại thông tin");
                    else{
                        SanPhamDTO sp = new SanPhamDTO();
                        sp.setMaSP(JT_MaSP.getText());
                        sp.setTenSP(JT_TenSP.getText());
                        sp.setGia(Float.parseFloat(JT_GiaSP.getText()));
                        sp.setNCC(JT_NCC.getText());
                        JOptionPane.showMessageDialog(SP_Panel,spBLL.addSP(sp));
                        loadSP();
                    }
                }catch (NumberFormatException ex ){
                        JOptionPane.showMessageDialog(SP_Panel,"Thông tin không hợp lệ");
                }
            }
        });
        JB_XoaSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int selectRow = JTB_SP.getSelectedRow();
                    String MaSP = JTB_SP.getValueAt(selectRow,0).toString();
                    SanPhamDTO sp = new SanPhamDTO();
                    sp.setMaSP(MaSP);
                    JOptionPane.showMessageDialog(SP_Panel,spBLL.deleteSP(sp));
                    loadSP();
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(SP_Panel,"Thông tin không hợp lệ");
                }
            }
        });
        JB_SuaSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(JT_MaSP.getText().trim().equals("") ||
                            JT_TenSP.getText().trim().equals("") ||
                            JT_GiaSP.getText().trim().equals("") ||
                            JT_NCC.getText().trim().equals("") ||
                            JT_SoLg.getText().trim().equals(""))
                        JOptionPane.showMessageDialog(SP_Panel,"Vui lòng nhập lại thông tin");
                    else {
                        int selectRow = JTB_SP.getSelectedRow();
                        String MaSP_old = JTB_SP.getValueAt(selectRow, 0).toString(); //Lấy mã nhân viên của hàng được chọn
                        SanPhamDTO sp = new SanPhamDTO();
                        sp.setMaSP(JT_MaSP.getText());
                        sp.setTenSP(JT_TenSP.getText());
                        sp.setGia(Float.parseFloat(JT_GiaSP.getText()));
                        sp.setNCC(JT_NCC.getText());
                        JOptionPane.showMessageDialog(SP_Panel,spBLL.updateSP(sp,MaSP_old));
                        loadSP();
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(SP_Panel,"Thôn tin không hợp lệ");
                }
            }
        });
        SP_Panel.setVisible(true);
    }
    public void loadSP(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm ");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Giá thành");
        model.addColumn("Số lượng");
        JTB_SP.setModel(model);
        Vector<SanPhamDTO> arr = new Vector<SanPhamDTO>();
        arr = spBLL.getAllSanPham();
        for (int i = 0; i < arr.size(); i++){
            SanPhamDTO sp = arr.get(i);
            String MaSP = sp.getMaSP();
            String TenSP = sp.getTenSP();
            String NCC = sp.getNCC();
            float Gia = sp.getGia();
            int SoLg = sp.getSoLg();
            Object[] row = {MaSP,TenSP,NCC,Gia,SoLg};
            model.addRow(row);
        }

    }


    public static void main(String[] args) {
        new SP_UI();
    }
}
