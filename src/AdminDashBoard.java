import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class AdminDashBoard extends JFrame implements ActionListener{
    JButton lo,rsubmit,rcan,hisa,tacka,dsb;
    JTextField rn,rc,rph,rd;
    JTextArea radd;
    JLabel uname,rcost,rtrackid,msg,dsbmsg;
    JComboBox rs,rw;
    DefaultTableModel model1;
    JTable ctable;
    String gettid;
    JScrollPane pane1,pane;
    AdminDashBoard(String adminName){
        Font f=new Font("Sarif",Font.BOLD,50);
        Font f1=new Font("Sarif",Font.BOLD,20);
        //button
        lo=new JButton("LOGOUT");
        lo.setBounds(1250,20,100,40);
        lo.setBackground(Color.RED);
        lo.setForeground(Color.WHITE);
        lo.addActionListener(this);

        //header
        JPanel heading =new JPanel();
        heading.setBounds(0,0,1370,80);
        heading.setBackground(new Color(0,0,0,100));
        //track
        JPanel track =new JPanel();
        track.setBounds(335,30,700,525);
        track.setBackground(new Color(0,0,0,175));
        tacka=new JButton("Added Couriers");
        tacka.setBounds(530,250,300,30);
        tacka.setFont(new Font("Sarif",Font.BOLD,16));
        tacka.setForeground(Color.WHITE);
        tacka.setBackground(Color.BLACK);
        tacka.setEnabled(false);
        tacka.setVisible(false);
        DefaultTableModel model =new DefaultTableModel(new String[]{"Track ID","Receiver's Name","Receiver's City","Cost","Sender Name","Sender City","Ordered ON"},0);
        JTable jt=new JTable(model);
        jt.setEnabled(false);
        jt.setBackground(new Color(0,0,0));
        jt.setForeground(Color.WHITE);
        pane=new JScrollPane(jt);
        pane.setBounds(370,62,630,400);
        JPanel t1 =new JPanel();
        t1.add(tacka);
        t1.add(pane);
        t1.add(track);
        t1.setOpaque(false);
        t1.setLayout(null);
        //order
        JPanel order =new JPanel();
        order.setBounds(335,30,700,525);
        order.setBackground(new Color(0,0,0,175));
        JLabel RN =new JLabel("Track ID");
        RN.setBounds(370,60,200,20);
        RN.setForeground(Color.GREEN);
        RN.setFont(new Font("Sarif",Font.BOLD,18));
        rn=new JTextField();
        rn.setBounds(370,85,300,30);
        rn.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RPH =new JLabel("Current Location");
        RPH.setBounds(700,60,200,20);
        RPH.setForeground(Color.GREEN);
        RPH.setFont(new Font("Sarif",Font.BOLD,18));
        rph=new JTextField();
        rph.setBounds(700,85,300,30);
        rph.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RAD =new JLabel("Reason for Delay");
        RAD.setBounds(700,135,200,20);
        RAD.setForeground(Color.GREEN);
        RAD.setFont(new Font("Sarif",Font.BOLD,18));
        radd=new JTextArea("NONE");
        radd.setLineWrap(true);
        radd.setFont(new Font("Sarif",Font.PLAIN,15));
        radd.setBounds(700,160,300,90);
        JLabel RC =new JLabel("Date");
        RC.setBounds(370,135,200,20);
        RC.setForeground(Color.GREEN);
        RC.setFont(new Font("Sarif",Font.BOLD,18));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        rc=new JTextField(format.format(new Date()));
        rc.setBounds(370,160,300,30);
        rc.setFont(new Font("Sarif",Font.PLAIN,15));
        rc.setEnabled(false);
        JLabel RS =new JLabel("Delay");
        RS.setBounds(370,195,200,20);
        RS.setForeground(Color.GREEN);
        RS.setFont(new Font("Sarif",Font.BOLD,18));
        String yn[]={"-Select-","YES","NO"};
        rs=new JComboBox(yn);
        rs.setBounds(370,220,100,30);
        rs.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RW =new JLabel("Status");
        RW.setBounds(370,270,200,20);
        RW.setForeground(Color.GREEN);
        RW.setFont(new Font("Sarif",Font.BOLD,18));
        String ds[]={"-Select-","Picked UP","Packed","Shipped","Delivered","Canceled","Refunded"};
        rw=new JComboBox(ds);
        rw.setBounds(370,295,150,30);
        rw.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RD =new JLabel("Time Left to Reach");
        RD.setBounds(370,345,200,20);
        RD.setForeground(Color.GREEN);
        RD.setFont(new Font("Sarif",Font.BOLD,18));
        rd=new JTextField();
        rd.setBounds(370,370,150,30);
        rd.setFont(new Font("Sarif",Font.PLAIN,15));
        rsubmit =new JButton("SUBMIT");
        rsubmit.setBounds(370,495,100,30);
        rsubmit.setForeground(Color.WHITE);
        rsubmit.setBackground(Color.RED);
        rsubmit.addActionListener(this);
        msg=new JLabel("");
        msg.setBounds(530,500,300,20);
        msg.setForeground(Color.RED);
        msg.setFont(new Font("Sarif",Font.BOLD,20));
        rcan =new JButton("CANCEL");
        rcan.setBounds(900,495,100,30);
        rcan.setForeground(Color.WHITE);
        rcan.setBackground(Color.RED);
        JPanel t2 =new JPanel();
        t2.setOpaque(false);
        t2.add(rs);
        t2.add(RS);
        t2.add(rsubmit);
        t2.add(rcan);
        t2.add(rd);
        t2.add(msg);
        t2.add(RD);
        t2.add(rw);
        t2.add(RW);
        t2.add(rc);
        t2.add(RC);
        t2.add(radd);
        t2.add(RAD);
        t2.add(rph);
        t2.add(RPH);
        t2.add(rn);
        t2.add(RN);
        t2.add(order);
        t2.setLayout(null);
        //Home
        ImageIcon himg1=new ImageIcon("images/courier_boy.jpg");
        Image h1=himg1.getImage();
        Image h11=h1.getScaledInstance(400,250,h1.SCALE_SMOOTH);
        himg1=new ImageIcon(h11);
        JLabel home=new JLabel("", himg1, JLabel.LEFT);
        home.setBounds(20,20,400,250);
        home.setVerticalAlignment(JLabel.TOP);
        ImageIcon himg2=new ImageIcon("images/courier_van.png");
        Image h2=himg2.getImage();
        Image h22=h2.getScaledInstance(400,260,h2.SCALE_SMOOTH);
        himg2=new ImageIcon(h22);
        JLabel home1=new JLabel("", himg2, JLabel.LEFT);
        home1.setBounds(20,300,400,260);
        home1.setVerticalAlignment(JLabel.TOP);
        JLabel text=new JLabel("COURIER MANAGEMENT SOFTWARE");
        text.setBounds(450,12,400,30);
        text.setFont(new Font("Sarif",Font.BOLD,20));
        text.setForeground(Color.GREEN);
        JLabel text1=new JLabel("<html>We have been working with various courier companies since 2000. Thus very aware of every need of the industry and with realisation We've developed a wide range of software to suit different perspectives.</html>");
        text1.setBounds(450,50,900,60);
        text1.setFont(new Font("Sarif",Font.BOLD,14));
        text1.setForeground(Color.WHITE);
        JLabel text3=new JLabel("About Courier Management Software");
        text3.setBounds(450,120,500,30);
        text3.setFont(new Font("Sarif",Font.BOLD,20));
        text3.setForeground(Color.GREEN);
        JLabel text4=new JLabel("A software to manage courier company");
        text4.setBounds(450,150,500,30);
        text4.setFont(new Font("Sarif",Font.BOLD,16));
        text4.setForeground(new Color(242, 88, 27));
        JLabel text5=new JLabel("<html>A unique software for any organization that hires no. of employees for distribution of their bulk documents as telephone bills, A/C statements, etc.<br>We have developed software that manages packet distribution to Courier Company and supports terrific  reporting, billing and control over Courier Company and thus provides clear report to management at all levels about how the courier company is performing its assigned job.</html>");
        text5.setBounds(450,180,900,100);
        text5.setFont(new Font("Sarif",Font.BOLD,14));
        text5.setForeground(Color.WHITE);
        JLabel text6=new JLabel("Domestic Courier Management");
        text6.setBounds(450,280,400,30);
        text6.setFont(new Font("Sarif",Font.BOLD,16));
        text6.setForeground(new Color(242, 88, 27));
        JLabel text7=new JLabel("<html>Our DCMS a Courier software make up a vital element of supply chain by helping firms ensure that their product and services promptly get to target locations through the competent methods.<br>Running your Courier Company with Simplicity, DCMS (Domestic Courier Management software), will enable you to take as much control as possible over all aspects of your courier business.  A software will help to maximise efficiency at all levels while eliminating errors and inefficiencies associated with courier service/process.<br>Utilization of appropriate technology; speed and efficiency that will set your business apart from the competition, thereby securing new clients while pleasing and maintaining your existing ones. We provide the best and trusted software solution for your courier company.</html>");
        text7.setBounds(450,310,900,170);
        text7.setForeground(Color.WHITE);
        text7.setFont(new Font("Sarif",Font.BOLD,16));
        JLabel text8=new JLabel("Contact us:");
        text8.setBounds(450,480,200,30);
        text8.setFont(new Font("Sarif",Font.BOLD,16));
        text8.setForeground(new Color(52,218,247));
        JLabel text9=new JLabel("+91 9347786211");
        text9.setBounds(450,505,200,30);
        text9.setFont(new Font("Sarif",Font.BOLD,16));
        text9.setForeground(Color.WHITE);
        JPanel t3 =new JPanel();
        t3.setOpaque(false);
        t3.add(text9);
        t3.add(text8);
        t3.add(text7);
        t3.add(text6);
        t3.add(text5);
        t3.add(text4);
        t3.add(text3);
        t3.add(text1);
        t3.add(text);
        t3.add(home);
        t3.add(home1);
        t3.setLayout(null);
        //History
        hisa=new JButton("No Couriers Added");
        hisa.setBounds(580,250,200,30);
        hisa.setFont(new Font("Sarif",Font.BOLD,16));
        hisa.setForeground(Color.WHITE);
        hisa.setBackground(Color.BLACK);
        hisa.setEnabled(false);
        hisa.setVisible(false);
        model1 =new DefaultTableModel(new String[]{"Track ID","Receiver's Name","Receiver's Address","Cost","Sender Name","Sender City","Ordered ON"},0);
        ctable=new JTable(model1);
        pane1=new JScrollPane(ctable);
        pane1.setBounds(370,62,630,400);
        dsbmsg =new JLabel("");
        dsbmsg.setBounds(625,460,280,40);
        dsbmsg.setForeground(Color.RED);
        dsbmsg.setFont(new Font("Sarif",Font.BOLD,18));
        dsb=new JButton("Delete Selected Row");
        dsb.setBounds(550,500,280,40);
        dsb.setBackground(Color.RED);
        dsb.setForeground(Color.WHITE);
        dsb.addActionListener(this);
        JPanel hist =new JPanel();
        hist.setBounds(335,30,700,525);
        hist.setBackground(new Color(0,0,0,175));
        JPanel t4 =new JPanel();
        t4.add(pane1);
        t4.add(dsb);
        t4.add(dsbmsg);
        t4.add(hisa);
        t4.setOpaque(false);
        t4.add(hist);
        t4.setLayout(null);
        //tabbed pane
        UIManager.put("TabbedPane.contentOpaque",false);
        JTabbedPane tp=new JTabbedPane();
        tp.setBackground(new Color(0,0,0,0));
        tp.setBounds(0,80,1370,625);
        tp.add("Home",t3);
        tp.add("View Couriers",t1);
        tp.add("Update Courier",t2);
        tp.add("Delete Courier",t4);
        tp.setFont(f1);
        tp.setForeground(Color.RED);

        JLabel name=new JLabel("COURIER MANAGEMENT");
        name.setForeground(Color.GREEN);
        name.setBounds(200,50,400,100);
        name.setFont(f);
        uname=new JLabel(adminName);
        uname.setForeground(Color.RED);
        uname.setBounds(20,13,400,50);
        uname.setFont(new Font("Sarif",Font.BOLD,30));
        heading.add(name);
        //image
        ImageIcon img=new ImageIcon("images/dash_board_background.jpeg");
        Image i=img.getImage();
        Image i1=i.getScaledInstance(1370,705,i.SCALE_SMOOTH);
        img=new ImageIcon(i1);
        //bacgground
        JLabel bg=new JLabel("",img,JLabel.LEFT);
        bg.setVerticalAlignment(JLabel.TOP);
        bg.setBounds(0,0,1370,705);
        setSize(900,600);
        setVisible(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bg.add(lo);
        bg.add(uname);
        bg.add(heading);
        bg.add(tp);
        add(bg);
        try{
            int yes=0;
            String q3="select TrackID,ReceiverName,ReceiverAddress,Price,FirstName,Address,OrderDate from UserCouriers inner join UserDetails where  UserCouriers.UserID=UserDetails.UserID";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
            Statement st=con.createStatement();
            ResultSet result=st.executeQuery(q3);
            while(result.next()){
                model1=(DefaultTableModel)ctable.getModel();
                model1.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7)});
                yes++;
                model=(DefaultTableModel)jt.getModel();
                model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7)});
            }
            st.close();
            con.close();
            if(yes==0){
                pane1.setVisible(false);
                pane.setVisible(false);
                hisa.setVisible(true);
                tacka.setVisible(true);
                dsb.setVisible(false);
            }
        }catch(Exception exp){System.out.println(exp);};

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==lo){
            new LoginPage();
            dispose();
        }
        if(e.getSource()==dsb){
            try{
                int i=ctable.getSelectedRow();
                model1=(DefaultTableModel)ctable.getModel();
                gettid=model1.getValueAt(i,0).toString();
                try{
                    String q1="delete from UserCouriers where TrackID='"+gettid+"'";
                    String q2="delete from UpdatedCouriers where TrackID='"+gettid+"'";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
                    Statement st=con.createStatement();
                    st.executeUpdate(q2);
                    st.executeUpdate(q1);
                    st.close();
                    con.close();
                }catch(Exception exp){System.out.println(exp);};
                model1.removeRow(i);
            }catch(Exception exp){
                dsbmsg.setText("Select any Row");
            }
        }
        if(e.getSource()==rsubmit){
            if(rn.getText().isEmpty() ||rph.getText().isEmpty() || radd.getText().isEmpty() || rs.getSelectedItem().equals("-Select-") || rc.getText().isEmpty() ||rw.getSelectedItem().equals("-Select-") || rd.getText().isEmpty())
            {
                msg.setText("Make sure you fill all the Details");
            }
            else{
                try{
                    String q1="insert into UpdatedCouriers values('"+rn.getText()+"','"+rph.getText()+"','"+rd.getText()+"','"+rs.getSelectedItem()+"','"+radd.getText()+"','"+rw.getSelectedItem()+"','"+rc.getText()+"')";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
                    Statement st=con.createStatement();
                    st.executeUpdate(q1);
                    JOptionPane.showMessageDialog(new JFrame(),"Updated Successfully");
                    new AdminDashBoard(uname.getText());
                    dispose();
                    st.close();
                    con.close();
                }catch(Exception exp){System.out.println(exp);};
            }
        }
    }
}