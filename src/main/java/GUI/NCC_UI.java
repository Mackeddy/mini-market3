package main.java.GUI;

import javax.swing.*;
import java.awt.*;

public class NCC_UI extends JPanel{
    private JPanel NCC_Panel;
    private JLabel l_ten;
    private JTextField t_ten;
    private JLabel l_ma;
    private JLabel l_diachi;
    private JTextField t_diachi;
    private JLabel l_ncc;
    private JTextField t_ncc;
    private JButton b_xoa;
    private JButton b_sua;
    private JButton b_tim;
    private JTextField t_ma;
    private JButton b_them;
    private JScrollBar JSNCC;
    private JTable JTNCC;
    private JTextField t_email;
    private JLabel l_email;
    private JPanel NNC_Panel;
    private JPanel JPNcc_table;

    NCC_UI(){
        NNC_Panel.setPreferredSize(new Dimension(1128, 510));
        add(NNC_Panel);
        NNC_Panel.setVisible(true); // hiển thị JPanel
    }
}
