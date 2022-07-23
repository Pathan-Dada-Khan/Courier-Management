import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField US, DOB, PH;
    JButton back, submit;
    JLabel pwd, msg;

    ForgetPassword() {
        //IMAGE
        ImageIcon img = new ImageIcon("images/forget_password_background.png");
        Image bimg = img.getImage();
        Image i = bimg.getScaledInstance(1370, 705, bimg.SCALE_SMOOTH);
        img = new ImageIcon(i);
        JLabel bg = new JLabel("", img, JLabel.LEFT);
        bg.setVerticalAlignment(bg.TOP);
        bg.setBounds(0, 0, 1920, 1080);
        //Lable
        JLabel fp = new JLabel("forget password?");
        fp.setBounds(870, 29, 300, 40);
        fp.setFont(new Font("Sarif", Font.BOLD, 30));
        fp.setForeground(Color.BLUE);

        JLabel us = new JLabel("User ID");
        us.setBounds(880, 90, 100, 30);
        us.setFont(new Font("Sarif", Font.BOLD, 20));

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(880, 130, 150, 30);
        dob.setFont(new Font("Sarif", Font.BOLD, 20));

        JLabel ph = new JLabel("Phone Number");
        ph.setBounds(880, 170, 150, 30);
        ph.setFont(new Font("Sarif", Font.BOLD, 20));

        JLabel up = new JLabel("PASSWORD:");
        up.setBounds(880, 550, 150, 30);
        up.setFont(new Font("Sarif", Font.BOLD, 20));

        pwd = new JLabel();
        pwd.setBounds(1010, 550, 150, 30);
        pwd.setForeground(Color.RED);
        pwd.setFont(new Font("Sarif", Font.BOLD, 20));
        msg = new JLabel();
        msg.setBounds(880, 450, 450, 30);
        msg.setForeground(Color.RED);
        msg.setFont(new Font("Sarif", Font.BOLD, 20));
        //textfields
        US = new JTextField();
        US.setBounds(1080, 95, 200, 30);
        DOB = new JTextField();
        DOB.setBounds(1080, 132, 200, 30);
        PH = new JTextField();
        PH.setBounds(1080, 170, 200, 30);
        //Button
        back = new JButton("Back");
        back.setBounds(880, 500, 100, 30);
        back.setForeground(Color.BLUE);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        submit = new JButton("Submit");
        submit.setBounds(1180, 500, 100, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.addActionListener(this);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        bg.add(msg);
        bg.add(up);
        bg.add(pwd);
        bg.add(back);
        bg.add(submit);
        bg.add(PH);
        bg.add(US);
        bg.add(DOB);
        bg.add(ph);
        bg.add(us);
        bg.add(dob);
        bg.add(fp);
        add(bg);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new LoginPage();
            dispose();
        }
        if (e.getSource() == submit) {
            if (US.getText().isEmpty() || PH.getText().isEmpty() || DOB.getText().isEmpty()) {
                msg.setText("Make sure to fill all the details");
            } else {
                try {
                    String q1 = "select * from UserDetails where UserID = '"+US.getText()+"' and DOB = '"+DOB.getText()+"' and Phone = '"+PH.getText()+"';";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers", "root", "root");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(q1);
                    if (rs.next()) {
                        msg.setText("");
                        String q2 = "select UserPassword from UserLoginDetails where UserID='" + US.getText() + "';";
                        rs = st.executeQuery(q2);
                        rs.next();
                        pwd.setText(rs.getString(1));
                    } else {
                        pwd.setText("");
                        msg.setText("Check your Details");
                    }
                    st.close();
                    con.close();
                } catch (Exception exp) {
                    System.out.println(exp);
                }
                ;
            }
        }
    }

    public static void main(String arg[]) {
        new ForgetPassword();
    }
}