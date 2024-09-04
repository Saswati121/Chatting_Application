
package chatting.apllication;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;



public class Server  implements ActionListener {
    JTextField text ;
    JPanel a1;
   static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dout;
    Server(){//Create constructor(Frame all part )
        f.setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));//its set the paneel color 
        p1.setBounds(0,0,450,70);//its set the location of pannel
        p1.setLayout(null);
        f.add(p1);//its add to the frame 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));//first create a object for imageicon and carry those image
        Image i2 = i1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);//image scalling
        ImageIcon i3= new ImageIcon(i2);
        JLabel back = new JLabel(i3);//image and imageIcon not same class so jlabel only can take Imageicon
        back.setBounds(5, 20, 25, 25);//first two image position and second two image length and width 
        p1.add(back);//we add on the panel
        
        //if we want to close the frame we use back 
        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                //setVisible(false);
                System.exit(0);
                
            }
        
    });
        //for profile image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/pp.jpeg"));//first create a object for imageicon and carry those image
        Image i5 = i4.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);//image scalling
        ImageIcon i6= new ImageIcon(i5);
        JLabel profile = new JLabel(i6);//image and imageIcon not same class so jlabel only can take Imageicon
        profile.setBounds(40, 10, 50, 50);//first two image position and second two image length and width 
        p1.add(profile);
        
        
        //for video image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));//first create a object for imageicon and carry those image
        Image i8 = i7.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);//image scalling
        ImageIcon i9= new ImageIcon(i8);
        JLabel video = new JLabel(i9);//image and imageIcon not same class so jlabel only can take Imageicon
        video.setBounds(300, 20, 30, 30);//first two image position and second two image length and width 
        p1.add(video);
        
        
        
       //phone icon
       ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));//first create a object for imageicon and carry those image
        Image i11 = i10.getImage().getScaledInstance(35, 30,Image.SCALE_DEFAULT);//image scalling
        ImageIcon i12= new ImageIcon(i11);
        JLabel phone = new JLabel(i12);//image and imageIcon not same class so jlabel only can take Imageicon
        phone.setBounds(360, 20, 35, 30);//first two image position and second two image length and width 
        p1.add(phone);
        
        
        //more icon
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));//first create a object for imageicon and carry those image
        Image i14 = i13.getImage().getScaledInstance(10, 25,Image.SCALE_DEFAULT);//image scalling
        ImageIcon i15= new ImageIcon(i14);
        JLabel more = new JLabel(i15);//image and imageIcon not same class so jlabel only can take Imageicon
        more.setBounds(420, 20, 10, 25);//first two image position and second two image length and width 
        p1.add(more);
        
        //Name 
        //with jlabel we can write anythin in frame
        
        JLabel name=new JLabel("Saswati");
        name.setBounds(110,15,100,18);
        name.setForeground(Color.WHITE);//it chage the name color
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        p1.add(name);
        
       //status
       
       JLabel status=new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.WHITE);//it chage the name color
        name.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(status);
        //for text area
        //because we use this pannel outer the class
        
        a1= new JPanel();
        a1.setBounds(5, 75, 440, 570);
        f.add(a1);
        
        //create TextField
        //JTextField text = new JTextField();//not use there bcz we make this object global so we can easily acces through class
        text=new JTextField();
        text.setBounds(5,655,318,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);
        
        //add send boutton on right text field
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));//it chane the word size style
        f.add(send);
        
        
        f.setSize(450,700); //function define frame size 
        f.setLocation(200,50);//its can change the frame open location 
        f.setUndecorated(true);//to remove header
        f.getContentPane().setBackground(Color.WHITE);//it's set the bakground colour
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
        //with the help of getText we can acces the text
            String out = text.getText();
       // JLabel output = new JLabel(out);//bcz its cant take string 
            JPanel p2 = formatLabel(out);
        //p2.add(output);
             a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2,BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));//space b/w two line 
            a1.add(vertical,BorderLayout.PAGE_START);
            dout.writeUTF(out);
            text.setText("");//delete msg from text field
            f.repaint();
            f.invalidate();
            f.validate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    public static JPanel formatLabel(String out){
        
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    JLabel output= new JLabel("<html><p style =\"width:150px\">" + out +"</p><html>");
    output.setFont(new Font ("Tahoma",Font.PLAIN,16));
    output.setBackground(new Color(37,211,102));
    output.setOpaque(true);
    output.setBorder(new EmptyBorder(15,15,15,50));
    panel.add(output);
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    JLabel time = new JLabel();
    time.setText(sdf.format(cal.getTime()));
    panel.add(time);
    
    
    
    
    return panel;
}
    public static void main(String[] args){
       Server s = new Server();//create new object for class
       try{
           ServerSocket skt = new ServerSocket(6001);
           while(true){
             Socket sk =  skt.accept();
             DataInputStream din = new DataInputStream(sk.getInputStream());
              dout = new DataOutputStream(sk.getOutputStream());
             //read UTF 
             while(true){
                 String msg = din.readUTF();
                 JPanel panel = formatLabel(msg);
                 
                 JPanel left = new JPanel(new BorderLayout());
                 left.add(panel,BorderLayout.LINE_START);
                 vertical.add(left);
                 f.validate();
                 
             }
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
    }
    
}
