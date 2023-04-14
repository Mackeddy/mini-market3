package main.java.GUI;

import javax.swing.*;

public class NCC_UI extends JFrame{
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
    private JScrollBar scrollBar1;
    private JTable table1;
    private JTextField t_email;
    private JLabel l_email;
    NCC_UI(){
        setContentPane(NCC_Panel);
        setTitle("Sản phẩm");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
