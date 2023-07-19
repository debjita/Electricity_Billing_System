
package electricity_billing_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener{
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JLabel l11, l12;
    JButton b1, b2;
    String meter;
    UpdateInformation(String meter){
        this.meter = meter;
        
        setBounds(300, 220, 600, 485);
        setLayout(null);
        getContentPane().setBackground(new Color(236, 235, 233));
        
        JLabel title = new JLabel("UPDATE  CUSTOMER  INFORMATION");
        title.setBounds(110, 20, 500, 30);
        title.setFont(new Font("Segoe UI", Font.ROMAN_BASELINE, 25));
        title.setForeground(new Color(223, 118, 82));
        add(title);
        
        JLabel l1 = new JLabel("Name:");
        l1.setBounds(60, 70, 100, 20);
        l1.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(300, 70, 200, 20);
       l11.setForeground(Color.WHITE);
        add(l11);
        
        JLabel l2 = new JLabel("Meter Number:");
        l2.setBounds(60, 110, 150, 20);
        l2.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l2);
        
        l12 = new JLabel();
        l12.setBounds(300, 110, 200, 20);
        l12.setForeground(Color.WHITE);
        add(l12);
        
        JLabel l3 = new JLabel("Address:");
        l3.setBounds(60, 150, 100, 20);
        l3.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(300, 150, 200, 20);
        add(t1);
        
        JLabel l4 = new JLabel("City:");
        l4.setBounds(60, 190, 100, 20);
        l4.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(300, 190, 200, 20);
        add(t2);
        
        JLabel l5 = new JLabel("State:");
        l5.setBounds(60, 230, 100, 20);
        l5.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(300, 230, 200, 20);
        add(t3);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(60, 270, 100, 20);
        l6.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(300, 270, 200, 20);
        add(t4);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(60, 310, 100, 20);
        l7.setFont(new Font("Segoe UI",Font.PLAIN,18));
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(300, 310, 200, 20);
        add(t5);
        
        b1 = new JButton("Update");
        b1.setBackground(new Color(236, 235, 233));
        b1.setForeground(Color.BLACK);
        b1.setBounds(280, 360, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(new Color(236, 235, 233));
        b2.setForeground(Color.BLACK);
        b2.setBounds(400, 360, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                t1.setText(rs.getString(3));
                t2.setText(rs.getString(4));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/updateinfo.png"));
        Image i2  = i1.getImage().getScaledInstance(700,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8  = new JLabel(i3);
        l8.setBounds(
                0, 0, 700, 450);
        add(l8);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String s1 = l11.getText();
            String s2 = l12.getText();
            String s3 = t1.getText();
            String s4 = t2.getText();
            String s5 = t3.getText();
            String s6 = t4.getText();
            String s7 = t5.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address = '"+s3+"', city = '"+s4+"', state = '"+s5+"', email = '"+s6+"', phone = '"+s7+"' where meter = '"+meter+"'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateInformation("").setVisible(true);
        
    }
}
