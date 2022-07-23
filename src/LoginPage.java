import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener, ItemListener, MouseListener {

    public static JTextField userName;
    JPasswordField password;
    JLabel u, p, fp, ms;
    JButton lb, s, back;
    JCheckBox sp, aw;
    final int i = HomePage.i;

    LoginPage() {

        JFrame jf = new JFrame();
        jf.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        jf.setUndecorated(true);
        Font f = new Font("Sarif", Font.BOLD, 50);
        Font l = new Font("Sarif", Font.BOLD, 20);

        //TextField

        u = new JLabel();
        u.setFont(l);
        u.setBounds(525, 205, 175, 30);
        u.setForeground(Color.BLUE);
        p = new JLabel("PASSWORD");
        p.setFont(l);
        p.setBounds(525, 280, 175, 30);
        p.setForeground(Color.BLUE);

        userName = new JTextField();
        userName.setBounds(525, 240, 320, 30);
        userName.setFont(new Font("Sarif", Font.PLAIN, 15));

        password = new JPasswordField();
        password.setBounds(525, 315, 320, 30);
        password.setFont(new Font("Sarif", Font.PLAIN, 15));
        //buttons
        lb = new JButton("LOG IN");
        lb.setForeground(Color.WHITE);
        lb.setBounds(525, 410, 320, 30);
        lb.setBackground(Color.GREEN);
        lb.addActionListener(this);

        s = new JButton("CREATE NEW ACCOUNT");
        s.setForeground(Color.WHITE);
        s.setBounds(525, 460, 320, 30);
        s.setBackground(Color.BLUE);
        s.addActionListener(this);
        fp = new JLabel("Forget password?");
        fp.setBounds(635, 510, 175, 30);
        fp.setForeground(Color.BLUE);
        fp.addMouseListener(this);

        ms = new JLabel("", JLabel.CENTER);
        ms.setVerticalAlignment(SwingConstants.CENTER);
        ms.setBounds(525, 560, 320, 30);
        ms.setForeground(Color.RED);

        //header
        JPanel heading = new JPanel();
        heading.setBounds(0, 0, 1370, 95);
        heading.setBackground(new Color(0, 0, 0, 200));
        //login
        JPanel login = new JPanel();
        login.setBounds(485, 160, 400, 480);
        login.setBackground(new Color(0, 0, 0, 200));
        login.setLayout(null);


        JLabel name = new JLabel("COURIER MANAGEMENT");
        name.setForeground(new Color(242, 88, 27));
        name.setBounds(410, 0, 700, 100);
        name.setFont(f);
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.RED);
        back.addActionListener(this);
        back.setBounds(30, 25, 100, 40);
        heading.setLayout(null);
        heading.add(back);
        heading.add(name);
        //Frame
        setSize(900, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (i == 0) u.setText("USER ID");
        else {
            u.setText("ADMIN ID");
            s.setVisible(false);
        }
        //background
        ImageIcon bimg = new ImageIcon("images/home_page_background.jpg");
        Image img = bimg.getImage();
        Image i12 = img.getScaledInstance(1370, 705, img.SCALE_SMOOTH);
        bimg = new ImageIcon(i12);

        sp = new JCheckBox("Show password");
        sp.setBounds(525, 360, 150, 30);
        sp.setForeground(new Color(255, 0, 0));
        sp.setBackground(new Color(0, 0, 0));
        sp.addItemListener(this);
        aw = new JCheckBox("For Admin login");
        aw.setBounds(695, 360, 150, 30);
        aw.setForeground(new Color(255, 0, 0));
        aw.setBackground(new Color(0, 0, 0));
        aw.addItemListener(this);

        JLabel bg = new JLabel("", bimg, JLabel.LEFT);
        bg.setVerticalAlignment(JLabel.TOP);

        //bg.add(aw);
        bg.add(ms);
        bg.add(fp);
        bg.add(lb);
        bg.add(s);
        bg.add(sp);
        bg.add(u);
        bg.add(p);
        bg.add(userName);
        bg.add(password);
        bg.add(login);
        bg.add(heading);
        bg.setBounds(0, 0, 1920, 1080);
        add(bg);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void formWindowOpened(WindowEvent e) {
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public void itemStateChanged(ItemEvent e) {
        if (sp.isSelected() == true)
            password.setEchoChar((char) 0);
        if (sp.isSelected() == false) {
            password.setEchoChar('*');
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == fp) {
            if (i == 0) {
                fp.setForeground(Color.WHITE);
                new ForgetPassword();
                dispose();
                fp.setForeground(Color.BLUE);
            } else {
                ms.setText("Please Contact your Manager");
            }
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new HomePage();
            dispose();
        }
        if (e.getSource() == s) {
            new CreateAccount();
            dispose();
        }
        if (e.getSource() == lb) {
            if (userName.getText().trim().isEmpty() && password.getText().trim().isEmpty())
                ms.setText("Please enter your username and password");
            else if (userName.getText().trim().isEmpty())
                ms.setText("Please enter your username");
            else if (password.getText().trim().isEmpty())
                ms.setText("Please enter your password");
            else {
                String q1;
                if (i==0){
                    q1 = "select * from UserLoginDetails where UserID = '" + userName.getText()
                            + "' and UserPassword = '" + password.getText() +"';";
                } else {
                    q1 = "select * from AdminLoginDetails where AdminName = '" + userName.getText()
                            + "' and AdminPassword = '" + password.getText() +"';";
                }
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers", "root", "root");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(q1);
                    if(rs.next()){
                        if(i == 0){
                            new UserDashBoard(userName.getText());
                            dispose();
                        } else {
                            new AdminDashBoard(userName.getText());
                            dispose();
                        }
                    } else {
                        ms.setText("<html><body style='text-align: center'>!Wrong password<br>Try again or click Forgot password to reset it.</html>");
                    }
                    st.close();
                    con.close();
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        }
    }

    public static void main(String args[]) {
        new LoginPage();
    }

}