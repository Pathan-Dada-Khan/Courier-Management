import javax.swing.*;
import java.awt.*;

class SplashScreen extends JFrame{

    int progress = 0;
    JProgressBar progressBar;

    public SplashScreen(){

        //Creating Image object
        ImageIcon imageIcon = new ImageIcon("images/splash_screen_background.jpg");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(1375,705, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);

        //Setting Image for background
        JLabel background = new JLabel("", backgroundImage, JLabel.LEFT);
        background.setVerticalAlignment(JLabel.TOP);
        background.setBounds(0,0,1920,1080);

        //Panel for content
        JPanel panel = new JPanel();
        panel.setBounds(320,270,700,170);
        panel.setBackground(new Color(0,0,0,175));

        //Label for the title
        JLabel title = new JLabel("COURIER MANAGEMENT");
        title.setForeground(new Color(242, 88, 27));
        title.setBounds(368,280,700,100);
        title.setFont(new Font("Sarif",Font.BOLD,50));

        //ProgressBar
        progressBar = new JProgressBar(0,4000);
        progressBar.setBounds(368,375,600,20);
        progressBar.setForeground(Color.GREEN);

        //Layout
        setSize(900,600);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(progressBar);
        add(title);
        add(panel);
        add(background);
    }
    public void progress(){
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        while(progress <= 3500){
            progress = progress + 50;
            progressBar.setValue(progress);
            try{
                Thread.sleep(25);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try{
            Thread.sleep(1500);
        }catch(Exception e){
            e.printStackTrace();
        }
        progressBar.setValue(4000);
        new HomePage();
        dispose();
    }
    public static void main(String[] args){
        SplashScreen start=new SplashScreen();
        start.progress();
    }
}