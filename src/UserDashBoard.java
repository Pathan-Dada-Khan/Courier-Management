import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class UserDashBoard extends JFrame implements ActionListener,ItemListener,FocusListener {
    int i=2021001;
    JButton lo,ti,rsubmit,rcan,hisa, tacka;
    JTextField tnum,rn,rph,rc,rw,rd,rs;
    JTextArea radd;
    JCheckBox cid;
    JLabel uname,rcost,recd1,msg;
    JTable jt, ttable;
    DefaultTableModel model, model1;
    JScrollPane pane,pane1;
    JPanel t1,t2,t3,t4;
    int d=1;
    UserDashBoard(String userName){
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
        track.setBounds(20,140,700,430);
        track.setBackground(new Color(0,0,0,175));
        JLabel toc=new JLabel("TRACK YOUR COURIER");
        toc.setBounds(20,20,400,30);
        toc.setFont(f1);
        toc.setForeground(Color.GREEN);
        JLabel tid=new JLabel("Tracking ID:");
        tid.setBounds(20,60,100,30);
        tid.setForeground(Color.RED);
        tid.setFont(new Font("Sarif",Font.BOLD,15));
        tnum=new JTextField();
        tnum.setBounds(20,90,200,30);
        tnum.setFont(new Font("Sarif",Font.PLAIN,15));
        ti=new JButton("Search");
        ti.setBounds(240,90,100,30);
        ti.setForeground(Color.WHITE);
        ti.setBackground(Color.GREEN);
        ti.addActionListener(this);

        tacka=new JButton("Track your Courier");
        tacka.setBounds(250,350,300,30);
        tacka.setFont(new Font("Sarif",Font.BOLD,16));
        tacka.setForeground(Color.WHITE);
        tacka.setBackground(Color.BLACK);
        tacka.setEnabled(false);
        tacka.setVisible(true);

        model1 =new DefaultTableModel(new String[]{"Track ID","Current Location","Time Left To Reach","Delay","Delay Reason","Courier Status","Updated Date",},0);
        ttable=new JTable(model1);
        ttable.setEnabled(false);
        ttable.setBackground(new Color(0,0,0));
        ttable.setForeground(Color.WHITE);
        pane1 = new JScrollPane(ttable);
        pane1.setBounds(40, 160, 660, 390);
        pane1.setVisible(false);

        t1 =new JPanel();
        t1.add(pane1);
        t1.add(track);
        t1.add(tacka);
        t1.add(tnum);
        t1.add(toc);
        t1.add(ti);
        t1.add(tid);
        t1.setOpaque(false);
        t1.setLayout(null);
        //order
        JPanel order =new JPanel();
        order.setBounds(335,30,700,525);
        order.setBackground(new Color(0,0,0,175));
        JLabel RN =new JLabel("Recipient's Name");
        RN.setBounds(370,60,200,20);
        RN.setForeground(Color.GREEN);
        RN.setFont(new Font("Sarif",Font.BOLD,18));
        rn=new JTextField();
        rn.setBounds(370,85,300,30);
        rn.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RPH =new JLabel("Recipient's Phone NO:");
        RPH.setBounds(700,60,200,20);
        RPH.setForeground(Color.GREEN);
        RPH.setFont(new Font("Sarif",Font.BOLD,18));
        rph=new JTextField();
        rph.setBounds(700,85,300,30);
        rph.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RAD =new JLabel("Recipient's Address");
        RAD.setBounds(370,135,200,20);
        RAD.setForeground(Color.GREEN);
        RAD.setFont(new Font("Sarif",Font.BOLD,18));
        radd=new JTextArea();
        radd.setLineWrap(true);
        radd.setFont(new Font("Sarif",Font.PLAIN,15));
        radd.setBounds(370,160,300,90);
        JLabel RC =new JLabel("Recipient's City");
        RC.setBounds(700,135,200,20);
        RC.setForeground(Color.GREEN);
        RC.setFont(new Font("Sarif",Font.BOLD,18));
        rc=new JTextField();
        rc.setBounds(700,160,300,30);
        rc.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RS =new JLabel("Recipient's State");
        RS.setBounds(700,195,200,20);
        RS.setForeground(Color.GREEN);
        RS.setFont(new Font("Sarif",Font.BOLD,18));
        rs=new JTextField();
        rs.setBounds(700,220,300,30);
        rs.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RW =new JLabel("Courier Weight");
        RW.setBounds(370,270,200,20);
        RW.setForeground(Color.GREEN);
        RW.setFont(new Font("Sarif",Font.BOLD,18));
        rw=new JTextField();
        rw.setBounds(370,295,200,30);
        rw.setFont(new Font("Sarif",Font.PLAIN,15));
        JLabel RD =new JLabel("Date");
        RD.setBounds(370,345,200,20);
        RD.setForeground(Color.GREEN);
        RD.setFont(new Font("Sarif",Font.BOLD,18));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        rd=new JTextField(format.format(new Date()));
        rd.setBounds(370,370,200,30);
        rd.setForeground(new Color(112,112,112));
        rd.setFont(new Font("Sarif",Font.PLAIN,15));
        rd.setEnabled(false);
        rd.addFocusListener(this);
        rsubmit =new JButton("SUBMIT");
        rsubmit.setEnabled(false);
        rsubmit.setBounds(370,495,100,30);
        rsubmit.setForeground(Color.WHITE);
        rsubmit.setBackground(Color.RED);
        rsubmit.addActionListener(this);
        rcan =new JButton("CANCEL");
        rcan.setBounds(900,495,100,30);
        rcan.setForeground(Color.WHITE);
        rcan.setBackground(Color.RED);
        JLabel cost=new JLabel("Cost Rs:");
        cost.setBounds(700,300,200,20);
        cost.setForeground(Color.GREEN);
        cost.setFont(new Font("Sarif",Font.BOLD,20));
        rcost=new JLabel("");
        rcost.setBounds(790,300,200,20);
        rcost.setForeground(Color.RED);
        rcost.setFont(new Font("Sarif",Font.BOLD,20));
        JLabel recd=new JLabel("Received Date:");
        recd.setBounds(700,375,200,20);
        recd.setForeground(Color.GREEN);
        recd.setFont(new Font("Sarif",Font.BOLD,20));
        recd1=new JLabel("");
        recd1.setBounds(850,375,200,20);
        recd1.setForeground(Color.RED);
        recd1.setFont(new Font("Sarif",Font.BOLD,20));
        msg=new JLabel("");
        msg.setBounds(530,500,300,20);
        msg.setForeground(Color.RED);
        msg.setFont(new Font("Sarif",Font.BOLD,20));
        cid =new JCheckBox("Click to know Cost,Date.");
        cid.setBounds(370,440,220,20);
        cid.setForeground(Color.GREEN);
        cid.setFont(new Font("Sarif",Font.BOLD,16));
        cid.setBackground(Color.BLACK);
        cid.addItemListener(this);
        t2 =new JPanel();
        t2.setOpaque(false);
        t2.add(rcost);
        t2.add(cid);
        t2.add(rs);
        t2.add(RS);
        t2.add(recd);
        t2.add(recd1);
        t2.add(cost);
        t2.add(rsubmit);
        t2.add(msg);
        t2.add(rcan);
        t2.add(rd);
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
        t3 =new JPanel();
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
        hisa=new JButton("Couriers that you add appear here");
        hisa.setBounds(530,250,300,30);
        hisa.setFont(new Font("Sarif",Font.BOLD,16));
        hisa.setForeground(Color.WHITE);
        hisa.setBackground(Color.BLACK);
        hisa.setEnabled(false);
        hisa.setVisible(false);
        model =new DefaultTableModel(new String[]{"Track ID","Name","Phone","Address","City","State","Weight","Price","Ordered","Received"},0);
        jt=new JTable(model);
        jt.setEnabled(false);
        jt.setBackground(new Color(0,0,0));
        jt.setForeground(Color.WHITE);
        pane=new JScrollPane(jt);
        pane.setBounds(370,62,630,400);
        JPanel hist =new JPanel();
        hist.setBounds(335,30,700,525);
        hist.setBackground(new Color(0,0,0,175));
        JPanel t4 =new JPanel();
        t4.add(hisa);
        t4.add(pane);
        t4.setOpaque(false);
        t4.add(hist);
        t4.setLayout(null);
        //tabbed pane
        UIManager.put("TabbedPane.contentOpaque",false);
        JTabbedPane tp=new JTabbedPane();
        tp.setBackground(new Color(0,0,0,0));
        tp.setBounds(0,80,1370,625);
        tp.add("Home",t3);
        tp.add("Track Courier",t1);
        tp.add("Add Courier",t2);
        tp.add("Courier History",t4);
        tp.setFont(f1);
        tp.setForeground(Color.RED);

        JLabel name=new JLabel("COURIER MANAGEMENT");
        name.setForeground(Color.GREEN);
        name.setBounds(200,50,400,100);
        name.setFont(f);
        uname=new JLabel(userName);
        uname.setForeground(Color.RED);
        uname.setBounds(20,13,400,50);
        uname.setFont(new Font("Sarif",Font.BOLD,30));
        heading.add(name);
        //image
        ImageIcon img=new ImageIcon("images/dash_board_background.jpeg");
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
        bg.add(lo);
        bg.add(uname);
        bg.add(heading);
        bg.add(tp);
        add(bg);
        try{
            int yes=0;
            String q3="select TrackID,ReceiverName, ReceiverPhone, ReceiverAddress, ReceiverCity, ReceiverState, Weight, Price, OrderDate, ReceivedDate from UserCouriers where UserID = '"+uname.getText()+"'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
            Statement st=con.createStatement();
            ResultSet result=st.executeQuery(q3);
            while(result.next()){
                yes++;
                model=(DefaultTableModel)jt.getModel();
                model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10)});
            }
            st.close();
            con.close();
            if(yes==0){
                hisa.setVisible(true);
                pane.setVisible(false);
            }
        }catch(Exception exp){System.out.println(exp);};
    }
    public void focusGained(FocusEvent e){
        if(rd.getText().equals("DD/MM/YYYY")){
            rd.setText("");
            rd.setForeground(Color.BLACK);
        }
    }
    public void focusLost(FocusEvent e){
        if(rd.getText().isEmpty()){
            rd.setText("DD/MM/YYYY");
            rd.setForeground(new Color(112,112,112));
        }
    }
    public void itemStateChanged(ItemEvent e){
        if(cid.isSelected()==true){
            try{
                rcost.setText(String.valueOf(cost()));
            }catch(Exception ex){System.out.println(ex);};
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 3);

            recd1.setText(dateFormat.format(calendar.getTime()));
            rsubmit.setEnabled(true);
        }
        if(cid.isSelected()==false){
            rsubmit.setEnabled(false);
        }
    }
    public float cost(){
        float n=Float.parseFloat(rw.getText());
        if(n<20)return 40;
        else return n*2;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==ti){
            int i=0;
            if(!tnum.getText().isEmpty()){
                            if(d==0){
                                int size = model1.getDataVector().size();
                                for(int c=0;c<size;c++){
                                    model1.removeRow(0);
                                }
                            }
                            try{
                                String q2="Select * from UpdatedCouriers where TrackID='"+tnum.getText()+"'";
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
                                Statement st=con.createStatement();
                                ResultSet result=st.executeQuery(q2);
                                while(result.next()){
                                    i++;
                                    d=0;
                                    model1=(DefaultTableModel)ttable.getModel();
                                    model1.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7)});
                                }
                                st.close();
                                con.close();
                        }catch(Exception exp){System.out.println(exp);};
                        pane1.setVisible(true);
                        tacka.setVisible(false);
                        if(i==0){
                            pane1.setVisible(false);
                            tacka.setText("Check your Tracker ID");
                            tacka.setVisible(true);
                        }
            } else {
                pane1.setVisible(false);
                tacka.setText("Please enter tracker ID");
                tacka.setVisible(true);
            }
        }
        if(e.getSource()==lo){
            new LoginPage();
            dispose();
        }
        if(e.getSource()==rsubmit){
            if(rn.getText().isEmpty() ||rph.getText().isEmpty() || radd.getText().isEmpty() || rs.getText().isEmpty() || rc.getText().isEmpty() ||rw.getText().isEmpty() || rd.getText().isEmpty())
            {
                msg.setText("Make sure you fill all the Details");
            }
            else{
                try{
                    String q1="INSERT INTO UserCouriers (ReceiverName, ReceiverPhone, ReceiverAddress, ReceiverCity, ReceiverState, Weight, Price, OrderDate, ReceivedDate, UserID) values('"+rn.getText()+"','"+rph.getText()+"','"+radd.getText()+"','"+rc.getText()+"','"+rs.getText()+"','"+rw.getText()+"','"+rcost.getText()+"','"+rd.getText()+"','"+recd1.getText()+"','"+uname.getText()+"')";
                    String q2="select TrackID from UserCouriers where ReceiverPhone='"+rph.getText()+"' and OrderDate='"+rd.getText()+"'";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Couriers","root","root");
                    Statement st=con.createStatement();
                    st.executeUpdate(q1);
                    ResultSet result=st.executeQuery(q2);
                    result.next();
                    String s=result.getString("TrackID");
                    JOptionPane.showMessageDialog(new JFrame(),"Tracker ID="+s+"");
                    st.close();
                    con.close();
                    new UserDashBoard(uname.getText());
                    dispose();
                }catch(Exception exp){System.out.println(exp);};
            }
        }
    }
}