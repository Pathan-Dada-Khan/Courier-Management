import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener{

    JButton admin,user;
    static int i;

    public HomePage(){

        Font f = new Font("Sarif",Font.BOLD,50);
        JPanel heading = new JPanel();
        heading.setBounds(0,0,1370,95);
        heading.setBackground(new Color(0,0,0,200));

        //Login
        JPanel login =new JPanel();
        login.setBounds(350,218,700,360);
        login.setBackground(new Color(0,0,0,200));
        login.setLayout(null);

        JLabel name=new JLabel("COURIER MANAGEMENT");
        name.setForeground(new Color(242, 88, 27));
        name.setBounds(200,20,400,100);
        name.setFont(f);
        heading.add(name);
        //image
        ImageIcon himg1=new ImageIcon("images/admin.png");
        Image h1=himg1.getImage();
        Image h11=h1.getScaledInstance(250,270,h1.SCALE_SMOOTH);
        himg1=new ImageIcon(h11);
        JLabel home=new JLabel("", himg1, JLabel.LEFT);
        home.setVerticalAlignment(JLabel.TOP);
        home.setBounds(80,20,400,300);
        ImageIcon himg2=new ImageIcon("images/customer.png");
        Image h2=himg2.getImage();
        Image h22=h2.getScaledInstance(400,260,h2.SCALE_SMOOTH);
        himg2=new ImageIcon(h22);
        JLabel home1=new JLabel("", himg2, JLabel.LEFT);
        home1.setVerticalAlignment(JLabel.TOP);
        home1.setBounds(320,30,400,300);
        login.add(home);
        login.add(home1);
        //button
        admin=new JButton("ADMINISTRATOR");
        admin.setBounds(40,298,300,35);
        admin.setForeground(Color.WHITE);
        admin.setBackground(Color.RED);
        admin.addActionListener(this);

        user=new JButton("CUSTOMER");
        user.setBounds(370,298,300,35);
        user.setForeground(Color.WHITE);
        user.setBackground(Color.GREEN);
        user.addActionListener(this);
        login.add(admin);
        login.add(user);
        //background
        ImageIcon bimg=new ImageIcon("images/home_page_background.jpg");
        Image img=bimg.getImage();
        Image i=img.getScaledInstance(1370,705,img.SCALE_SMOOTH);
        bimg=new ImageIcon(i);
        JLabel bg=new JLabel("", bimg, JLabel.LEFT);
        bg.setVerticalAlignment(JLabel.TOP);
        bg.add(login);
        bg.add(heading);
        add(bg);
        bg.setBounds(0,0,1920,1080);
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==admin){
            i=1;
            new LoginPage();
            dispose();
        }
        if(e.getSource()==user){
            i=0;
            new LoginPage();
            dispose();
        }
    }
    public static void main(String arg[]){
        new HomePage();
    }
}