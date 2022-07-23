import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CreateAccount extends JFrame implements FocusListener,ItemListener,ActionListener{
    JTextField fn,ln,un,ph,em,day,age;
    JTextArea addr;
    JPasswordField pass,rpass;
    JButton back,submit;
    JRadioButton m,f;
    JCheckBox agree;
    JLabel msg;
    String gen;
    CreateAccount(){
        //buttons
        back =new JButton("Back");
        back.setBounds(40,600,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(26, 156, 31));
        back.addActionListener(this);
        msg =new JLabel("");
        msg.setForeground(Color.RED);
        msg.setBounds(195,600,500,30);
        msg.setFont(new Font("Sarif",Font.PLAIN,18));
        submit =new JButton("Submit");
        submit.setBounds(500,600,100,30);
        submit.setBackground(new Color(26, 156, 31));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        ButtonGroup mf=new ButtonGroup();
        m =new JRadioButton("Male");
        m.setBounds(40,510,100,30);
        m.setBackground(Color.WHITE);
        m.setFont(new Font("Sarif",Font.PLAIN,15));
        m.addActionListener(this);
        f =new JRadioButton("Female");
        f.setBounds(140,510,100,30);
        f.setBackground(Color.WHITE);
        f.setFont(new Font("Sarif",Font.PLAIN,15));
        f.addActionListener(this);
        mf.add(m);
        mf.add(f);
        agree =new JCheckBox("I agree terms & Condition");
        agree.setBounds(40,550,300,30);
        agree.setBackground(Color.WHITE);
        agree.addItemListener(this);
        //text
        fn=new JTextField("First name");
        fn.setBounds(40,140,265,30);
        fn.setForeground(new Color(112,112,112));
        fn.setFont(new Font("Sarif",Font.PLAIN,15));
        fn.addFocusListener(this);
        ln=new JTextField("Last name");
        ln.setBounds(335,140,265,30);
        ln.setForeground(new Color(112,112,112));
        ln.setFont(new Font("Sarif",Font.PLAIN,15));
        ln.addFocusListener(this);
        un=new JTextField("User ID");
        un.setBounds(40,180,265,30);
        un.setForeground(new Color(112,112,112));
        un.setFont(new Font("Sarif",Font.PLAIN,15));
        un.addFocusListener(this);
        pass=new JPasswordField("Password");
        pass.setBounds(40,220,265,30);
        pass.setForeground(new Color(112,112,112));
        pass.setEchoChar((char)0);
        pass.addFocusListener(this);
        pass.setFont(new Font("Sarif",Font.PLAIN,15));
        rpass=new JPasswordField("Confirm");
        rpass.setBounds(335,220,265,30);
        rpass.setForeground(new Color(112,112,112));
        rpass.setEchoChar((char)0);
        rpass.setFont(new Font("Sarif",Font.PLAIN,15));
        rpass.addFocusListener(this);
        JLabel sp=new JLabel("Use 8 or more characters with a mix of letters, numbers & symbols");
        sp.setBounds(40,250,400,30);
        ph=new JTextField("Phone number");
        ph.setBounds(40,280,265,30);
        ph.setForeground(new Color(112,112,112));
        ph.setFont(new Font("Sarif",Font.PLAIN,15));
        ph.addFocusListener(this);
        em=new JTextField("Email ID");
        em.setBounds(40,320,265,30);
        em.setForeground(new Color(112,112,112));
        em.setFont(new Font("Sarif",Font.PLAIN,15));
        em.addFocusListener(this);
        addr=new JTextArea("Address");
        addr.setBounds(40,360,265,60);
        addr.setBackground(new Color(219, 218, 202));
        addr.setForeground(new Color(112,112,112));
        addr.setFont(new Font("Sarif",Font.PLAIN,15));
        addr.setLineWrap(true);
        addr.addFocusListener(this);
        day=new JTextField("DD/MM/YYYY");
        day.setBounds(90,430,100,30);
        day.setFont(new Font("Sarif",Font.PLAIN,15));
        day.setForeground(new Color(112,112,112));
        day.addFocusListener(this);
        age =new JTextField("YY");
        JLabel yy=new JLabel("Age");
        yy.setBounds(40,470,40,30);
        yy.setFont(new Font("Sarif",Font.PLAIN,18));
        age.setBounds(90,470,40,30);
        age.setForeground(new Color(112,112,112));
        age.setFont(new Font("Sarif",Font.PLAIN,15));
        age.addFocusListener(this);
        //label
        JLabel c=new JLabel("Courier");
        c.setBounds(40,70,100,30);
        c.setFont(new Font("Sarif",Font.BOLD,20));
        c.setForeground(new Color(242, 88, 27));
        JLabel cua=new JLabel("Create your account");
        cua.setBounds(40,100,400,30);
        cua.setFont(new Font("Sarif",Font.PLAIN,25));
        JLabel uh=new JLabel("CUSTOMER");
        uh.setBounds(40,20,400,30);
        uh.setForeground(Color.GREEN);
        uh.setFont(new Font("Sarif",Font.BOLD,25));
        JLabel dd=new JLabel("Date");
        dd.setBounds(40,430,90,30);
        dd.setFont(new Font("Sarif",Font.PLAIN,18));
        //image
        ImageIcon img=new ImageIcon("images/create_account_background.png");
        Image i=img.getImage();
        Image i1=i.getScaledInstance(1370,705,i.SCALE_SMOOTH);
        img=new ImageIcon(i1);
        //background
        JLabel bg=new JLabel("",img,JLabel.LEFT);
        bg.setVerticalAlignment(JLabel.TOP);
        bg.setBounds(0,0,1370,705);
        setSize(900,600);
        setVisible(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bg.add(back);
        bg.add(msg);
        bg.add(submit);
        bg.add(addr);
        bg.add(sp);
        bg.add(ph);
        bg.add(m);
        bg.add(f);
        bg.add(pass);
        bg.add(agree);
        bg.add(rpass);
        bg.add(em);
        bg.add(un);
        bg.add(fn);
        bg.add(ln);
        bg.add(cua);
        bg.add(age);
        bg.add(day);
        bg.add(dd);
        bg.add(yy);
        bg.add(c);
        bg.add(uh);
        add(bg);
        getContentPane().requestFocusInWindow();
    }
    public void focusGained(FocusEvent e) {
        if(e.getSource()==age){
            if (age.getText().equals("YY")) {
                age.setText("");
                age.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==day){
            if (day.getText().equals("DD/MM/YYYY")) {
                day.setText("");
                day.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==fn){
            if (fn.getText().equals("First name")) {
                fn.setText("");
                fn.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==ln){
            if (ln.getText().equals("Last name")) {
                ln.setText("");
                ln.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==un){
            if (un.getText().equals("User ID")) {
                un.setText("");
                un.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==addr){
            if (addr.getText().equals("Address")) {
                addr.setText("");
                addr.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==ph){
            if (ph.getText().equals("Phone number")) {
                ph.setText("");
                ph.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==age){
            if (age.getText().equals("Age")) {
                age.setText("");
                age.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==em){
            if (em.getText().equals("Email ID")) {
                em.setText("");
                em.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==pass){
            if (pass.getText().equals("Password")) {
                pass.setText("");
                pass.setEchoChar('*');
                pass.setForeground(Color.BLACK);
            }
        }
        if(e.getSource()==rpass){
            if (rpass.getText().equals("Confirm")) {
                rpass.setText("");
                rpass.setEchoChar('*');
                rpass.setForeground(Color.BLACK);
            }
        }
    }
    public void focusLost(FocusEvent e) {
        if (age.getText().isEmpty()) {
            age.setForeground(Color.GRAY);
            age.setText("YY");
        }
        if (day.getText().isEmpty()) {
            day.setForeground(Color.GRAY);
            day.setText("DD/MM/YYYY");
        }
        if (fn.getText().isEmpty()) {
            fn.setForeground(Color.GRAY);
            fn.setText("First name");
        }
        if (ln.getText().isEmpty()) {
            ln.setForeground(Color.GRAY);
            ln.setText("Last name");
        }
        if (un.getText().isEmpty()) {
            un.setForeground(Color.GRAY);
            un.setText("User ID");
        }
        if (ph.getText().isEmpty()) {
            ph.setForeground(Color.GRAY);
            ph.setText("Phone number");
        }
        if (em.getText().isEmpty()) {
            em.setForeground(Color.GRAY);
            em.setText("Email ID");
        }
        if (addr.getText().isEmpty()) {
            addr.setForeground(Color.GRAY);
            addr.setText("Address");
        }
        if (age.getText().isEmpty()) {
            age.setForeground(Color.GRAY);
            age.setText("Age");
        }
        if (pass.getText().isEmpty()) {
            pass.setForeground(Color.GRAY);
            pass.setText("Password");
            pass.setEchoChar((char)0);
        }
        if (rpass.getText().isEmpty()) {
            rpass.setForeground(Color.GRAY);
            rpass.setText("Confirm");
            rpass.setEchoChar((char)0);
        }
    }
    public void itemStateChanged(ItemEvent e){
        if(agree.isSelected()==true)
            submit.setEnabled(true);
        if(agree.isSelected()==false)
            submit.setEnabled(false);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==m)
            gen="Male";
        if(e.getSource()==f)
            gen="Female";
        if(e.getSource()==back){
            new LoginPage();
            dispose();
        }
        if(e.getSource()==submit){
            if(addr.getText().equals("Address") ||fn.getText().equals("First name") || ln.getText().equals("Last name") || un.getText().equals("User ID") || pass.getText().equals("Password") || rpass.getText().equals("Confirm") ||ph.getText().equals("Phone number") || em.getText().equals("Email ID") ||day.getText().equals("DD/MM/YYYY") || age.getText().equals("YY"))
            {
                msg.setText("Make sure you fill all the Details");
            }
            else if(!pass.getText().equals(rpass.getText())){
                msg.setText("Two passwords must be same");
            }
            else{
                try{
                    String q1="insert into UserDetails values('"+fn.getText()+"','"+ln.getText()+"','"+un.getText()+"','"+ph.getText()+"','"+em.getText()+"','"+addr.getText()+"','"+day.getText()+"','"+age.getText()+"','"+gen+"')";
                    String q2="insert into UserLoginDetails values('"+un.getText()+"','"+pass.getText()+"')";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
                    Statement st=con.createStatement();
                    st.executeUpdate(q1);
                    st.executeUpdate(q2);
                    st.close();
                    con.close();
                    JOptionPane.showMessageDialog(new JFrame(),"Registration Completed");
                    new LoginPage();
                    dispose();
                }catch(Exception exp)
                {
                    System.out.println(exp);
                    msg.setText("User ID already Exists");
                };

            }
        }
    }
    public static void main(String args[]){
        new CreateAccount();
    }
}