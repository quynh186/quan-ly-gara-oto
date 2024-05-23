/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_gara;


import HienThiQuanLy.QuanLyVatTu;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TrangChu extends JFrame implements ActionListener {
    JPanel contentPane;
    CardLayout cardLayout;
    
    public TrangChu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        
        // JPanel chứa các form khác nhau
        contentPane = new JPanel();
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        
        // Tạo các form khác nhau
        
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Trang chủ"));
        homePanel.setBackground(Color.YELLOW); // Màu
        JPanel vatTuPanel = new QuanLyVatTu();
        vatTuPanel.add(new JLabel("Quản lý vật tư"));
        vatTuPanel.setBackground(Color.RED); // Màu
        JPanel dichVuPanel = new JPanel();
        dichVuPanel.add(new JLabel("Dịch vụ"));
        dichVuPanel.setBackground(Color.BLUE); // Màu
        // Thêm các form vào CardLayout
        contentPane.add(homePanel, "home");
        contentPane.add(vatTuPanel, "vatTu");
        contentPane.add(dichVuPanel, "dichVu");
        
        // Thanh điều hướng
        JPanel navigationPanel = new JPanel();
        JButton btnHome = new JButton("Trang chủ");
        btnHome.setActionCommand("home");
        btnHome.addActionListener(this);
        JButton btnVatTu = new JButton("Quản lý vật tư");
        btnVatTu.setActionCommand("vatTu");
        btnVatTu.addActionListener(this);
        JButton btnDichVu = new JButton("Dịch vụ");
        btnDichVu.setActionCommand("dichVu");
        btnDichVu.addActionListener(this);
        
        navigationPanel.add(btnHome);
        navigationPanel.add(btnVatTu);
        navigationPanel.add(btnDichVu);
        
        // Đặt vị trí của thanh điều hướng
        add(navigationPanel, BorderLayout.NORTH);
        add(contentPane, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        cardLayout.show(contentPane, command);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrangChu());
    }
}

