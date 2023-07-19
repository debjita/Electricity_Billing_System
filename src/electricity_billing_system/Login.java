
package electricity_billing_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    JPanel p1,p2,p3,p4;
    Choice c1;
    Login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(new Color(236, 235, 233));
        
        l1=new JLabel("Username");
        l1.setBounds(400, 80,100, 20);
        l1.setForeground(Color.BLACK);
        add(l1);
        
        l2=new JLabel("Password");
        l2.setBounds(400, 120,100, 20);
        l2.setForeground(Color.BLACK);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(500,80,150,20);
        add(tf1);
        pf2 = new JPasswordField(15);
        pf2.setBounds(500,120,150,20);
        add(pf2);
        
        l4=new JLabel("Logging in as");
        l4.setForeground(Color.BLACK);
        l4.setBounds(400, 160, 100,20);
        add(l4);
        
        c1=new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(500, 160, 150, 200);
        add(c1);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b1 = new JButton ("Login", new ImageIcon(i1));
        b1.setBounds(430, 210, 100, 20);
        //b1.setBackground(new Color(185, 176, 159));
        //b1.setForeground(Color.BLACK);
        add(b1);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel",new ImageIcon(i2));
        b2.setBounds(550, 210, 100, 20);
        add(b2);
        
        l5= new JLabel("Don't have an account ?");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Consolas",Font.ITALIC,10));
        l5.setBounds(350, 270, 180,20);
        
        add(l5);
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b3 = new JButton("Signup",new ImageIcon(i4));
        b3.setBounds(490, 270, 130, 20);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/login_side.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(370, 500,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 300, 500);
        add(l3);
        
        setLayout(new BorderLayout());
    
     
        setSize(740,450);
        setLocation(600,300);
        setVisible(true);
        
        
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
               try{        
                Conn c = new Conn();
                String a  = tf1.getText();
                String b  = pf2.getText();
                String user = c1.getSelectedItem();
                String q  = "select * from login where username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}
