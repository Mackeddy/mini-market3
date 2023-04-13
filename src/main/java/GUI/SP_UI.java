package main.java.GUI;
import javax.swing.*;
import java.awt.*;

public class SP_UI extends JPanel {

    private JPanel SP_Panel;
    private JTextField t_ten;
    private JComboBox cb_dm;
    private JTextField t_ma;
    private JTextField t_gia;
    private JTextField t_ncc;
    private JButton b_them;
    private JButton b_xoa;
    private JButton b_sua;
    private JButton b_tim;
    private JScrollBar scrollBar1;
    private JTable tb_SP;
    private JLabel l_ten;
    private JLabel l_dm;
    private JLabel l_ma;
    private JLabel l_gia;
    private JLabel l_ncc;

    SP_UI(){
        SP_Panel.setPreferredSize(new Dimension(1128, 510));
        add(SP_Panel);
        SP_Panel.setVisible(true); // hiển thị JPanel
    }

    public static void main(String[] args) {
    }
}
