import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Start extends JFrame implements ActionListener
{
    CircleButton start;
    int score=0;
    int z=0;
    int C[]=new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
    Start()
    {   try{
        setVisible(true);
        setSize(521, 367);
        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        JPanel p=new JPanel();
        URL url_s = new URL("https://i.ibb.co/QJZFcF5/start.png");
        Image Q=ImageIO.read(url_s.openStream());
        JLabel J=new JLabel(new ImageIcon(Q));
        start=new CircleButton("START");
        Font font = new Font("Comic Sans MS",Font.PLAIN,20);
        start.setFont(font);
        start.setBounds(205,200,100,100);
        J.setBounds(0,0,521,367);
        p.setLayout(null);
        p.add(start);
        p.add(J);
        add(p);
        setVisible(true);
        this.getRootPane().setDefaultButton(start);
        start.addActionListener(this);
        }catch(Exception e){}
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            new TV_Shows(C,score,z);
            dispose();
        }
    }
    public static void main(String agrs[])
    {
        Start s=new Start();
    }
}
