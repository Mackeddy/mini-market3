package main.java.GUI;
import javax.swing.*;
import java.awt.*;

public class HoaDon extends JPanel{
    private JPanel JPHoaDon;
    private JButton thôngTinHóaĐơnButton;
    private JButton thôngTinChiTiếtButton;
    private JButton button1;

    HoaDon(){
        JPHoaDon.setPreferredSize(new Dimension(1128, 510));
        add(JPHoaDon);
        JPHoaDon.setVisible(true); // hiển thị JPanel
    }
}
