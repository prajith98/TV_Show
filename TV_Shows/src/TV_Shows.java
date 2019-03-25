import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class TV_Shows  extends JFrame implements ActionListener
{
    JTextField ans;
    int score;
    int no;
    JLabel TV_Label;
    int z=0;
    int n=1;
    String TV[]=new String[]{"Doctor who","Good Doctor","Punisher","Brooklyn Nine Nine","Mr Robot","Breaking Bad","Prison Break","Narcos","The Walking Dead","Lucifer","Westworld","How to Get Away with Murder","Sherlock","Grey's Anatomy","This is us","13 Reasons Why","Tom Clancy's Jack Ryan","Mordern Family","Orange is the new Black","Suits","Game of Thrones","Stranger Things","Friends","Dexter","Big Bang Theory","White Collar","Riverdale","House of Cards","How I Met Your Mother","Dark"};
    int c[]=new int[30];
    JButton Next;
    Random r = new Random();
    int x=r.nextInt(30);
    String scramble()
    {
        int z=Randomizer(x);
        if(z==999)
            return "null";
        char a[] = TV[z].toCharArray();
        this.z++;
        for( int i=0 ; i<a.length ; i++ )
        {
            int j = r.nextInt(a.length);
            char temp = a[i]; a[i] = a[j];  a[j] = temp;
        }       
        return new String( a );
    }
    int randomG(int x)
    {
        int flag=1;
        for(int i=0;i<10;i++)
        {
            if(x==this.c[i])
            {
                //this.c[i]=0;
                flag=0;
                System.out.println(x);
                break;
            }
            else if(x==999)
                return 2;
            else continue;
        }
        return flag;
    }
    int Randomizer(int x)
    {
        int flag=randomG(x);
        if(flag==1)
        {
            x=r.nextInt(30);
            if(this.z<10)
                x=Randomizer(x);
            else 
                return 999;
                
        }
        else if(flag==0)
        {    this.c[x]=999;
            for(int i=0;i<30;i++)
                System.out.print(+c[i]+" ");
            System.out.println();
        }
        else if(flag==2)
            return 999;
        return x;
    }
    TV_Shows(int q[],int s,int z)
    {   try{
        for(int i=0;i<30;i++)
            c[i]=q[i];
        this.score=s;
        this.z=z;
        setVisible(true);
        setSize(517, 309);
        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        JPanel p=new JPanel(); 
        String TV_SHOW;
        URL url_back = new URL("https://i.ibb.co/MCyqcFn/Back.png");
        Image Q=ImageIO.read(url_back.openStream());
        JLabel J=new JLabel(new ImageIcon(Q));
        TV_SHOW=scramble();
        if(TV_SHOW=="null")
            this.n=0;
        TV_Label=new JLabel(TV_SHOW.toLowerCase(), SwingConstants.CENTER);
        ans=new JTextField(20);
        Next=new JButton("Next");
        ans.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font font = new Font("Comic Sans MS",Font.PLAIN,16);
        Font font1 = new Font("Comic Sans MS",Font.BOLD,23);
        ans.setFont(font);
        Next.setFont(font);
        TV_Label.setFont(font1);
        J.setBounds(0,0,517, 309);
        TV_Label.setSize(300,30);
        TV_Label.setLocation((517-TV_Label.getWidth())/2,94);
        ans.setBounds(259,192,188,26);
        Next.setBounds(205,235,100,26);
        p.setLayout(null);
        p.add(TV_Label);
        p.add(Next);
        p.add(ans);
        p.add(J);
        add(p);
        setVisible(true);
        this.getRootPane().setDefaultButton(Next);
        Next.addActionListener(this);
        }
        catch(Exception e){}
    }
    void calculate(String s)
    {
        for(int i=0;i<10;i++)
            if(s.equalsIgnoreCase(TV[i]))
                this.score++;
            else
                continue;
        System.out.println(this.score);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Next)
        {
            try{    dispose();
            calculate(ans.getText());
            if(this.z<10)
                new TV_Shows(this.c,this.score,this.z);
            else if(this.z==10||this.n==0)
                JOptionPane.showMessageDialog(this,"Score = "+this.score+"\n","SCORE",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e){}
        }
    }
}
