package test;

import javax.swing.*;

import view.StudentManagerView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel {
    private JFrame loginFrame;
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginPanel() {
        loginFrame = new JFrame("Đăng nhập");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Nơi tải lung tung\\pngtree-student-glyph-black-icon-png-image_691145.jpg"));
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        loginPanel.add(new JLabel("Tên đăng nhập:"), gbc);

        gbc.gridy++;
        loginPanel.add(new JLabel("Mật khẩu:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtUsername = new JTextField(20);
        loginPanel.add(txtUsername, gbc);

        gbc.gridy++;
        txtPassword = new JPasswordField(20);
        loginPanel.add(txtPassword, gbc);

        btnLogin = new JButton("Đăng nhập");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLogin);

        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.add(buttonPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                // Kiểm tra thông tin đăng nhập
                if (validateLogin(username, password)) {
                    // Nếu đúng, hiển thị giao diện quản lý sinh viên
                	StudentManagerView stv =new StudentManagerView();
        			stv.setLocationRelativeTo(null);
                    loginFrame.dispose(); // Đóng giao diện đăng nhập
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Tên đăng nhập hoặc mật khẩu không đúng.");
                }
            }
        });

        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private boolean validateLogin(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }

        // Kiểm tra thông tin đăng nhập của người dùng
        if (username.equals("user") && password.equals("user")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginPanel();
            }
        });
    }
}