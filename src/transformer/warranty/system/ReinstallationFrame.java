/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Anugrah
 */
public class ReinstallationFrame extends javax.swing.JFrame {

    Statement st,st1;ResultSet rt,rt1,rt2;
    static int WarehouseDate,WarehouseMonth,WarehouseYear,expirydate,expirymonth,expiryyear,date,month,year,days,sno,date_of_warranty,month_of_warranty,year_of_warranty;
    public ReinstallationFrame(Connection con) {
        initComponents();
        SQLConnect sqlcon = new SQLConnect();
        con=sqlcon.sqlCon(con);
         try {            
             st=con.createStatement();
            // st1=con.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public void caldate(int d,int m,int y)
    {
        int d1 = 0,m1,y1 = y;
        if((d>1)&&(d<=29))
        {
            d1=d-1;m1=m+6;
            if(m1>12)
            {
                m1=m1-12;y1=y+1;
            }  
        }
        else
        {
            if((d==30)&&(m==8)&&(((y+1)%4)==0))
            {
                d1=29;m1=2;y1=y+1;
            }
            else
            {
               if((d==30)&&(m==8)&&(((y+1)%4)!=0))
               {
                d1=28;m1=2;y1=y+1;
               }
               else
               {
                  if((d==31)&&(m==8)&&(((y+1)%4)==0))
                    {
                      d1=29;m1=2;y1=y+1;
                    }
                    else
                    {
                        if((d==31)&&(m==8)&&(((y+1)%4)!=0))
                        {
                            d1=28;m1=2;y1=y+1;
                        }
                        else
                        {
                            if(d==1)
                            {
                               m1=m+6;
                               if(m1>12)
                               {
                                   m1=m1-12;
                                   if(m1==1||m1==2||m1==3||m1==4||m1==6||m1==8||m1==9||m1==11)
                                   {
                                       if(m1==3&&(((y+1)%4)==0))
                                       {
                                           d1=29;m1=2;y1=y+1;
                                       }
                                       else
                                       {
                                           if(m1==3&&(((y+1)%4)!=0))
                                           {
                                           d1=28;m1=2;y1=y+1;
                                           }
                                           else
                                           {
                                               if(m1==1)
                                               {
                                                   d1=31;m1=12;
                                               }
                                               else
                                               {
                                                d1=31;m1=m1-1;y1=y+1;
                                               }
                                           }
                                       }
                                    }
                                   else
                                   {
                                   d1=30;m1=m1-1;y1=y+1;
                                   }
                               }
                               else
                               {
                                   if(m1==1||m1==2||m1==3||m1==4||m1==6||m1==8||m1==9||m1==11)
                                   {
                                       if(m1==3&&(((y+1)%4)==0))
                                       {
                                           d1=29;m1=2;
                                       }
                                       else
                                       {
                                           if(m1==3&&(((y+1)%4)!=0))
                                           {
                                           d1=28;m1=2;
                                           }
                                           else
                                           {
                                               d1=31;m1=m1-1;
                                           }
                                       }
                                    }
                                   else
                                   {
                                   d1=30;m1=m1-1;
                                    }
                                }
                            }
                           else
                            {     
                                d1=d-1;m1=m+6;
                                if(m1>12)
                                {
                                   m1=m1-12;y1=y+1;
                                }
                            }
                        }
                    }
               }
            }
           
        }
        //date=d1;month=m1;year=y1;
       WarehouseDate=d1;WarehouseMonth=m1;WarehouseYear=y1;
    }
     public void caldate11(int d,int m,int y)
    {
        int d1,m1,y1 = y;
        if((d>=1)&&(d<=29))
        {
            d1=d-1;m1=m+6;
            if(m1>12)
            {
                m1=m1-12;y1=y+1;
            }  
        }
        else
        {
            if((d==30)&&(m==8)&&(((y+1)%4)==0))
            {
                d1=d-1;m1=2;y1=y+1;
            }
            else
            {
               if((d==30)&&(m==8)&&(((y+1)%4)!=0))
               {
                d1=1;m1=3;y1=y+1;
               }
               else
               {
                  if((d==31)&&(m==8)&&(((y+1)%4)==0))
                    {
                      d1=1;m1=3;y1=y+1;
                    }
                    else
                    {
                        if((d==31)&&(m==8)&&(((y+1)%4)!=0))
                        {
                            d1=2;m1=3;y1=y+1;
                        }
                        else
                        {
                           d1=d-1;m1=m+6;
                            if(m1>12)
                            {
                               m1=m1-12;y1=y+1;
                            } 
                        }
                    }
               }
            }
           
        }
        date_of_warranty=d1;month_of_warranty=m1;year_of_warranty=y1;
    } 
      public void Cal_day(int d1,int m1,int y1,int d2,int m2,int y2)
    {
        int j=d1;
        int i=m1,d = 0,k,r;
       // int a=m2;
      
       if(i==m2&&y1==y2)
       {
           d=d2-d1;
           System.out.println("\n"+d);
       }
       else
       {   
           if((y1%4)==0)
           {
                if(i==1||i==3||i==5||i==7||i==8||i==10||i==12)
                {
                   d=31-j+1; i=i+1;  
                }
               else
                {
                    if(i==2)
                    {
                        d=29-j+1;i=i+1;
                    }
                    else
                    {
                        d=30-j+1;i=i+1;
                    }
               }
            }
           else
           {   
               if(i==1||i==3||i==5||i==7||i==8||i==10||i==12)
                {
                   d=31-j+1; i=i+1;  
                }
               else
                {
                    if(i==2)
                    {
                        d=28-j+1;i=i+1;
                    }
                    else
                    {
                        d=30-j+1;i=i+1;
                    }
               }
           }
      // if(m1!=m2&&y1!=y2)
            for(int y=y1;y<=y2;y++)
            {   
                if((y%4)==0)
                {
                    if(i>m2&&y<y2)
                    {   
                        for(k=i;k<=12;k++)
                        {  
                            if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                            {
                                d=d+31;  
                            }
                            else
                            {
                                if(k==2)
                                {
                                d=d+29;
                                }
                                else
                                {
                                d=d+30;
                                }
                            }   
                        }
                      i=1;
                    }
                   else
                   {   
                       if(i<=m2&&y<y2)
                        {
                            for(k=i;k<=12;k++)
                            {  
                                if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                                {
                                    d=d+31;  
                                }
                               else
                               {
                                    if(k==2)
                                    {
                                     d=d+29;
                                    }
                                    else
                                    {
                                     d=d+30;
                                    }
                                }    
                            }i=1;
                        }
                       else
                       {
                            for(k=i;k<m2;k++)
                            {  
                                if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                                {
                                   d=d+31;  
                                }
                               else
                               {
                                   if(k==2)
                                   {
                                      d=d+29;
                                    }
                                   else
                                   {
                                      d=d+30;
                                    }
                               }   
                            } 
                        }   
                    }
                }
               else
               {
                   if(i>m2&&y<y2)
                   {   
                       for(k=i;k<=12;k++)
                       {  
                            if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                           {
                               d=d+31;  
                            }
                           else
                           {
                               if(k==2)
                               {
                                  d=d+28;
                                }
                               else
                               {
                                  d=d+30;
                                }
                            }   
                        }
                     i=1;
                    }
                   else
                   {   
                       if(i<=m2&&y<y2)
                       {
                            for(k=i;k<=12;k++)
                           {  
                                if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                                {
                                   d=d+31;  
                                }
                               else
                               {
                                    if(k==2)
                                   {
                                      d=d+28;
                                    }
                                   else
                                   {
                                      d=d+30;
                                    }
                                }
                            }i=1;
                        }
                       else
                       {
                           for(k=i;k<m2;k++)
                           {  
                               if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                               {
                                  d=d+31;  
                                }
                               else
                               {
                                   if(k==2)
                                   {
                                      d=d+28;
                                    }
                                   else
                                   {
                                      d=d+30;
                                    }
                                }
                            } 
                        }   
                    }   
                }
            }
           d=d+d2;
          days=d;
        }
    }
 public void caldate1(int d,int m,int y,int mtw)
    {
        int d1=d,m1=m;int y1=y;
        while(mtw!=0)
        {
            if(mtw>12)
           {
                mtw=mtw-12;
                y1=y1+1;
            }
            else
            {
               if((d>1)&&(d<=29))
               {
                   d1=d1-1;m1=m1+6;
                   if(m1>12)
                   {
                        m1=m1-12;y1=y1+1;
                    }  
                }
               else
               {
                   if((d==30)&&(m==8)&&(((y1+1)%4)==0))
                   {
                       d1=29;m1=2;y1=y1+1;
                    }
                   else
                   {
                       if((d==30)&&(m==8)&&(((y1+1)%4)!=0))
                       {
                            d1=28;m1=2;y1=y1+1;
                        }
                       else
                       {
                            if((d==31)&&(m==8)&&(((y1+1)%4)==0))
                           {
                               d1=29;m1=2;y1=y1+1;
                            }
                           else
                           {
                               if((d==31)&&(m==8)&&(((y1+1)%4)!=0))
                               {
                                    d1=28;m1=2;y1=y1+1;
                                }
                               else
                               {
                                    if(d==1)
                                   {
                                        m1=m1+6;
                                       if(m1>12)
                                       {
                                           m1=m1-12;
                                           if(m1==1||m1==2||m1==3||m1==4||m1==6||m1==8||m1==9||m1==11)
                                           {
                                               if(m1==3&&(((y1+1)%4)==0))
                                               {
                                                   d1=29;m1=2;y1=y+1;
                                                }
                                               else
                                               {
                                                   if(m1==3&&(((y1+1)%4)!=0))
                                                    {
                                                       d1=28;m1=2;y1=y1+1;
                                                    }
                                                   else
                                                   {
                                                       if(m1==1)
                                                       {
                                                           d1=31;m1=12;
                                                        }
                                                       else
                                                       {
                                                           d1=31;m1=m1-1;y1=y1+1;
                                                        }
                                                    }
                                                }
                                            }
                                       else
                                       {
                                           d1=30;m1=m1-1;y1=y1+1;
                                        }
                                    }
                                   else
                                   {
                                       if(m1==1||m1==2||m1==3||m1==4||m1==6||m1==8||m1==9||m1==11)
                                       {
                                           if(m1==3&&(((y1+1)%4)==0))
                                           {
                                               d1=29;m1=2;
                                            }
                                           else
                                           {
                                               if(m1==3&&(((y1+1)%4)!=0))
                                               {
                                                   d1=28;m1=2;
                                                }
                                               else
                                               {
                                                   d1=31;m1=m1-1;
                                                }
                                            }
                                        }
                                       else
                                       {
                                           d1=30;m1=m1-1;
                                        }
                                    }
                                }
                               else
                               {     
                                   d1=d-1;m1=m+6;
                                   if(m1>12)
                                   {
                                   m1=m1-12;y1=y1+1;
                                   }
                                }
                            }
                        }
                    }
                }
                          
            }
            mtw=0; 
         }
        }date=d1;month=m1;year=y1;
    }
   public void Cal_left(int d,int d1,int m,int y)
    {
       int k=m,a=d1;
       
       if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
       {
           a=31-a;  
           d=d-a-1;m++;
        }
       else
       {
           if(k==2)
           {
                a=28-a;
                d=d-a-1;m++;
            }
           else
           {
                a=30-a;
                d=d-a-1;m++;
            }
        }
       if(m>12){
           k=1;y++;
       }
       else
       {
           k=m;
       }
        while(d>0)
        {
           if((y%4)==0)
           {
               if((k==0||k==1||k==3||k==5||k==7||k==8||k==10||k==12)&&(d>=31))
               {
                   d=d-31;k++;
               }
               else
               {
                   if((k==2)&&(d>=29))
                   {
                       d=d-29;k++;
                   }
                   else
                   {    
                       if((k==4||k==6||k==9||k==11)&&(d>=30))
                       {
                           d=d-30;k++;  
                        }
                       else
                       {
                           d1=d;d=0;
                        }
                    }
               }
               if(k>12)
               {
                    y++;k=1;
                }
           }
           else
           {
               if((k==0||k==1||k==3||k==5||k==7||k==8||k==10||k==12)&&(d>=31))
               {
                   d=d-31;k++;
                }
               else
               {
                   if((k==2)&&(d>=28))
                   {
                       d=d-28;k++;
                    }
                   else
                   {
                       if((k==4||k==6||k==9||k==11)&&(d>=30))
                       {
                           d=d-30;k++;  
                        }
                       else
                       {
                           d1=d;d=0;
                        }
                    }    
                } 
               if(k>12)
               {
                   y++;k=1;
                }
            }    
        }
        expirydate=d1;expirymonth=k;expiryyear=y;
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SpecificationNo_textfield = new javax.swing.JTextField();
        PO_No_textfield = new javax.swing.JTextField();
        Date_of_reinstallation = new javax.swing.JTextField();
        Month_of_reinstallation = new javax.swing.JTextField();
        Year_of_reinstallation = new javax.swing.JTextField();
        CloseButton = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Reinstallation_date = new javax.swing.JLabel();
        Specification_no = new javax.swing.JLabel();
        Po_No = new javax.swing.JLabel();
        DateOfReinstallation = new javax.swing.JLabel();
        Specification_Textbox = new javax.swing.JLabel();
        PO_No_Textbox = new javax.swing.JLabel();
        Date_of_installation_textbox = new javax.swing.JLabel();
        dash1 = new javax.swing.JLabel();
        Month_of_reinstallation_textbox = new javax.swing.JLabel();
        dash2 = new javax.swing.JLabel();
        Year_of_reinstallation_textbox = new javax.swing.JLabel();
        NextButton = new javax.swing.JLabel();
        CancelButton = new javax.swing.JLabel();
        Reinstallation_logo = new javax.swing.JLabel();
        Titlebar = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(650, 420));
        getContentPane().setLayout(null);

        SpecificationNo_textfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        SpecificationNo_textfield.setBorder(null);
        SpecificationNo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecificationNo_textfieldActionPerformed(evt);
            }
        });
        getContentPane().add(SpecificationNo_textfield);
        SpecificationNo_textfield.setBounds(332, 154, 157, 16);

        PO_No_textfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        PO_No_textfield.setBorder(null);
        getContentPane().add(PO_No_textfield);
        PO_No_textfield.setBounds(332, 209, 157, 16);

        Date_of_reinstallation.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Date_of_reinstallation.setBorder(null);
        getContentPane().add(Date_of_reinstallation);
        Date_of_reinstallation.setBounds(333, 263, 20, 17);

        Month_of_reinstallation.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Month_of_reinstallation.setBorder(null);
        getContentPane().add(Month_of_reinstallation);
        Month_of_reinstallation.setBounds(371, 263, 20, 17);

        Year_of_reinstallation.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Year_of_reinstallation.setBorder(null);
        getContentPane().add(Year_of_reinstallation);
        Year_of_reinstallation.setBounds(410, 263, 34, 17);

        CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_close.png"))); // NOI18N
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseButtonMouseReleased(evt);
            }
        });
        getContentPane().add(CloseButton);
        CloseButton.setBounds(620, 5, 23, 15);

        Title.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Transformer Re-Installation");
        getContentPane().add(Title);
        Title.setBounds(246, 5, 180, 17);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Logo.png"))); // NOI18N
        getContentPane().add(Logo);
        Logo.setBounds(4, 0, 25, 25);

        Reinstallation_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Reinstallation_date.setForeground(new java.awt.Color(153, 0, 153));
        Reinstallation_date.setText("Re-Installation Date");
        getContentPane().add(Reinstallation_date);
        Reinstallation_date.setBounds(100, 60, 210, 26);

        Specification_no.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Specification_no.setForeground(new java.awt.Color(153, 0, 153));
        Specification_no.setText("Specification Number");
        getContentPane().add(Specification_no);
        Specification_no.setBounds(150, 155, 150, 18);

        Po_No.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Po_No.setForeground(new java.awt.Color(153, 0, 153));
        Po_No.setText("PO number");
        getContentPane().add(Po_No);
        Po_No.setBounds(150, 210, 80, 18);

        DateOfReinstallation.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        DateOfReinstallation.setForeground(new java.awt.Color(153, 0, 153));
        DateOfReinstallation.setText("Date of Re-Installation");
        getContentPane().add(DateOfReinstallation);
        DateOfReinstallation.setBounds(150, 265, 154, 18);

        Specification_Textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        getContentPane().add(Specification_Textbox);
        Specification_Textbox.setBounds(330, 150, 160, 21);

        PO_No_Textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        getContentPane().add(PO_No_Textbox);
        PO_No_Textbox.setBounds(330, 205, 160, 21);

        Date_of_installation_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        getContentPane().add(Date_of_installation_textbox);
        Date_of_installation_textbox.setBounds(330, 260, 27, 21);

        dash1.setText("-");
        getContentPane().add(dash1);
        dash1.setBounds(360, 264, 7, 14);

        Month_of_reinstallation_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        getContentPane().add(Month_of_reinstallation_textbox);
        Month_of_reinstallation_textbox.setBounds(368, 260, 27, 21);

        dash2.setText("-");
        getContentPane().add(dash2);
        dash2.setBounds(397, 264, 7, 14);

        Year_of_reinstallation_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/year.png"))); // NOI18N
        getContentPane().add(Year_of_reinstallation_textbox);
        Year_of_reinstallation_textbox.setBounds(406, 260, 43, 21);

        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NextButton_default1.png"))); // NOI18N
        NextButton.setToolTipText("");
        NextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NextButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NextButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NextButtonMouseReleased(evt);
            }
        });
        getContentPane().add(NextButton);
        NextButton.setBounds(237, 330, 80, 25);

        CancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/cancelButton_default_3.png"))); // NOI18N
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CancelButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CancelButtonMouseReleased(evt);
            }
        });
        getContentPane().add(CancelButton);
        CancelButton.setBounds(355, 330, 80, 25);

        Reinstallation_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Reinstallationicon.png"))); // NOI18N
        getContentPane().add(Reinstallation_logo);
        Reinstallation_logo.setBounds(30, 50, 60, 40);

        Titlebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Installation_Taskbar.png"))); // NOI18N
        getContentPane().add(Titlebar);
        Titlebar.setBounds(0, 0, 650, 25);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/InstallationBackkground.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 650, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SpecificationNo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecificationNo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecificationNo_textfieldActionPerformed

    private void NextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseEntered
        ImageIcon IV=new ImageIcon(getClass().getResource("NextButton_hover.png"));
        NextButton.setIcon(IV);
    }//GEN-LAST:event_NextButtonMouseEntered

    private void NextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseExited
        ImageIcon IV=new ImageIcon(getClass().getResource("NextButton_default1.png"));
        NextButton.setIcon(IV);
    }//GEN-LAST:event_NextButtonMouseExited

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMousePressed
         ImageIcon IV=new ImageIcon(getClass().getResource("NewButton_pressed3.png"));
         NextButton.setIcon(IV);
    }//GEN-LAST:event_NextButtonMousePressed

    private void NextButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseReleased
        ImageIcon IV=new ImageIcon(getClass().getResource("NextButton_hover.png"));
         NextButton.setIcon(IV);
    }//GEN-LAST:event_NextButtonMouseReleased

    private void CancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseEntered
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
         CancelButton.setIcon(IV);
    }//GEN-LAST:event_CancelButtonMouseEntered

    private void CancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseExited
       ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_default_3.png"));
       CancelButton.setIcon(IV);
    }//GEN-LAST:event_CancelButtonMouseExited

    private void CancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMousePressed
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_pressed.png"));
        CancelButton.setIcon(IV);
    }//GEN-LAST:event_CancelButtonMousePressed

    private void CancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseReleased
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
        CancelButton.setIcon(IV);
    }//GEN-LAST:event_CancelButtonMouseReleased

    private void CloseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseEntered
        ImageIcon IV=new ImageIcon(getClass().getResource("Hover_close.png"));
        CloseButton.setIcon(IV);
    }//GEN-LAST:event_CloseButtonMouseEntered

    private void CloseButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseExited
        ImageIcon IV=new ImageIcon(getClass().getResource("Default_close.png"));
        CloseButton.setIcon(IV);
    }//GEN-LAST:event_CloseButtonMouseExited

    private void CloseButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMousePressed
       ImageIcon IV=new ImageIcon(getClass().getResource("Pressed_close.png"));
       CloseButton.setIcon(IV);
    }//GEN-LAST:event_CloseButtonMousePressed

    private void CloseButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseReleased
        ImageIcon IV=new ImageIcon(getClass().getResource("Hover_close.png"));
        CloseButton.setIcon(IV);       
    }//GEN-LAST:event_CloseButtonMouseReleased

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
       this.dispose();
    }//GEN-LAST:event_CloseButtonMouseClicked

    private void NextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseClicked
        ValidateInput valip2 = new ValidateInput();
        String d2 = Date_of_reinstallation.getText();
        String m2 = Month_of_reinstallation.getText();
        String y2 = Year_of_reinstallation.getText();
        boolean b =valip2.datecheck2(d2, m2, y2);
        if(b==true){
        try
        {
           String update="SELECT * FROM Transf_Details WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
           rt=st.executeQuery(update);
           if(rt.next())
           {
               String Po_No2=PO_No_textfield.getText();
               String Po_No1=rt.getString(5);
               int mon=rt.getInt(10);
               if(Po_No1.equals(Po_No2))
               {
                   String query1="SELECT max(Sno) FROM "+SpecificationNo_textfield.getText();
                   rt=st.executeQuery(query1);
                   if(rt.next())
                   {
                       sno=rt.getInt(1);
                       int temp=sno-1;
                       if(temp==0)
                       {
                           String query2="SELECT * FROM "+SpecificationNo_textfield.getText()+" WHERE Sno=1";
                           rt=st.executeQuery(query2);
                           if(rt.next())
                           {
                               int purchaseDate=rt.getInt(2);
                               int purchaseMonth=rt.getInt(3);
                               int purchaseYear=rt.getInt(4);
                               int installationDate=rt.getInt(5);
                               int installationMonth=rt.getInt(6);
                               int installationYear=rt.getInt(7);
                               int complain_date=rt.getInt(8);
                               int complain_month=rt.getInt(9);
                               int complain_year=rt.getInt(10);
                               int DORI=rt.getInt(11);
                               int MORI=rt.getInt(12);
                               int YORI=rt.getInt(13);
                               int expiry_date=rt.getInt(14);
                               int expiry_month=rt.getInt(15);
                               int expiry_year=rt.getInt(16);
                               if((DORI==0)&&(MORI==0)&&(YORI==0))
                               {
                                   if(Integer.parseInt(Year_of_reinstallation.getText())==complain_year)
                                   {
                                       if(Integer.parseInt(Month_of_reinstallation.getText())==complain_month)
                                       {
                                           if(Integer.parseInt(Date_of_reinstallation.getText())==complain_date)
                                           {
                                               JOptionPane.showMessageDialog(null, "Invalid date...");
                                           }
                                           else
                                           {
                                               if(Integer.parseInt(Date_of_reinstallation.getText())<complain_date)
                                               {
                                                   JOptionPane.showMessageDialog(null, "Invalid date...");
                                               }
                                               else
                                               {
                                                   if(installationDate==0&&installationMonth==0&&installationYear==0)
                                                   {
                                                       this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                       this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
                                                       this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
                                                       String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
                                                                                                                ", Expiry_month="+month+
                                                                                                                ", Expiry_year="+year+
                                                                                                                " WHERE Sno="+sno; 
                                                       st.executeUpdate(query3);
                                                       String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                       st.executeUpdate(query10);
                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno=1"; 
                                                       st.executeUpdate(query9);
                                                       String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+sno;
                                                       st.executeUpdate(query4);
                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                    }
                                                   else
                                                   {
                                                       int d=expiry_date;int m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
                                                       if((d>=1)&&(d<=27))
                                                       {
                                                            d1=d+1;m1=m-6;
                                                            if(m1<0)
                                                            {
                                                                m1=12+m1;y1=y-1;
                                                            }
                                                            else
                                                            {
                                                                if(m1==0)
                                                                {
                                                                   m1=12;y1=y-1;
                                                                }
                                                            }
                                                        }
                                                        else
                                                        {
                                                            if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
                                                            {
                                                                d1=29;m1=2;
                                                            }
                                                            else
                                                            {
                                                               if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
                                                               {
                                                                d1=28;m1=2;
                                                               }
                                                               else
                                                               {
                                                                  if((d==31)&&(m==8)&&(((y)%4)==0))
                                                                    {
                                                                      d1=1;m1=3;
                                                                    }
                                                                    else
                                                                    {
                                                                        if((d==31)&&(m==8)&&(((y)%4)!=0))
                                                                        {
                                                                            d1=1;m1=3;
                                                                        }
                                                                        else
                                                                        {
                                                                            if(d==31||d==30)
                                                                            {
                                                                               m1=m-6;
                                                                               if(m1<0)
                                                                               {
                                                                                   m1=12+m1;
                                                                                   if(d==30)
                                                                                   {
                                                                                       if(m1==9||m1==11)
                                                                                       {
                                                                                           d1=1;m1=m1+1;y1=y-1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                          d1=31;y1=y-1;
                                                                                       }
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       if(m1==11||m1==9||m1==7)
                                                                                       {
                                                                                           d1=1;m1=m1+1;y1=y-1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           d1=1;m1=m1+1;y1=y-1;
                                                                                       }
                                                                                   }
                                                                               }
                                                                               else
                                                                               {
                                                                                   if(d==30)
                                                                                   {
                                                                                       if(m1==0)
                                                                                       {
                                                                                          d1=31;m1=12;y1=y-1; 
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           if(m1==6||m1==4)
                                                                                           {
                                                                                               d1=1;m1=m1+1;
                                                                                           }
                                                                                           else
                                                                                           {
                                                                                               if(m1==5||m1==3||m1==1)
                                                                                               {
                                                                                                   d1=31;
                                                                                               }
                                                                                           }
                                                                                       }
                                                                                    }
                                                                                   else
                                                                                   {
                                                                                       if(m1==7||m1==8||m1==10||m1==12)
                                                                                       {
                                                                                           d1=1;m1=m1+1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           d1=1;m1=m1+1;
                                                                                       }
                                                                                   }
                                                                                }
                                                                            }
                                                                           else
                                                                            {     
                                                                                m1=m-6;
                                                                                if(m1<0)
                                                                                {
                                                                                   d1=d+1;m1=12+m1;y1=y-1;
                                                                                }
                                                                                else
                                                                                {
                                                                                    if(m1==0)
                                                                                    {
                                                                                       d1=d+1;m1=12;y1=y-1;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                       d1=d+1;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                       int minidate=d1;
                                                       int minimonth=m1;
                                                       int miniyear=y1;
                                                       if(complain_year==miniyear)
                                                       {
                                                           if(complain_month==minimonth)
                                                           {
                                                               if(complain_date==minidate)
                                                               {
                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+date_of_warranty+
                                                                                                                               ", Expiry_month="+month_of_warranty+
                                                                                                                               ", Expiry_year="+year_of_warranty+
                                                                                                                               " WHERE Sno="+sno;
                                                                   st.executeUpdate(query7);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                               else
                                                               {
                                                                   if(complain_date<expiry_date)
                                                                   {
                                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                                       rt=st.executeQuery(query5);
                                                                       if(rt.next())
                                                                       {
                                                                           int warranty_days=rt.getInt(4);
                                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                       ", Expiry_date="+expirydate+
                                                                                                                                       ", Expiry_month="+expirymonth+
                                                                                                                                       ", Expiry_year="+expiryyear+
                                                                                                                                       " WHERE Sno="+sno;  
                                                                           st.executeUpdate(query6);
                                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                " WHERE Sno="+temp; 
                                                                           st.executeUpdate(query9);
                                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                                        }
                                                                    }
                                                                   else
                                                                   {
                                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                   ", Expiry_date="+date_of_warranty+
                                                                                                                                   ", Expiry_month="+month_of_warranty+
                                                                                                                                   ", Expiry_year="+year_of_warranty+
                                                                                                                                   " WHERE Sno="+sno;
                                                                       st.executeUpdate(query7);
                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                            " WHERE Sno="+temp; 
                                                                       st.executeUpdate(query9);
                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                                    }
                                                                }
                                                            }
                                                           else
                                                           {
                                                              if(complain_month<expiry_month)
                                                               {
                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                                   rt=st.executeQuery(query5);
                                                                   if(rt.next())
                                                                   {
                                                                       int warranty_days=rt.getInt(4);
                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                   ", Expiry_date="+expirydate+
                                                                                                                                   ", Expiry_month="+expirymonth+
                                                                                                                                   ", Expiry_year="+expiryyear+
                                                                                                                                   " WHERE Sno="+sno;  
                                                                       st.executeUpdate(query6);
                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                            " WHERE Sno="+temp; 
                                                                       st.executeUpdate(query9);
                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                                    }
                                                                }
                                                               else
                                                               {
                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+date_of_warranty+
                                                                                                                               ", Expiry_month="+month_of_warranty+
                                                                                                                               ", Expiry_year="+year_of_warranty+
                                                                                                                               " WHERE Sno="+sno;
                                                                   st.executeUpdate(query7);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }    
                                                        }
                                                       else
                                                       {
                                                           if(complain_year<expiry_year)
                                                           {
                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                               rt=st.executeQuery(query5);
                                                               if(rt.next())
                                                               {
                                                                   int warranty_days=rt.getInt(4);
                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+expirydate+
                                                                                                                               ", Expiry_month="+expirymonth+
                                                                                                                               ", Expiry_year="+expiryyear+
                                                                                                                               " WHERE Sno="+sno;  
                                                                   st.executeUpdate(query6);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                           else
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                       else
                                       {
                                           if(Integer.parseInt(Month_of_reinstallation.getText())<complain_month)
                                           {
                                              JOptionPane.showMessageDialog(null, "Invalid date...");
                                            }
                                          else
                                           {
                                              if(installationDate==0&&installationMonth==0&&installationYear==0)
                                               {
                                                   this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                   this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
                                                   this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
                                                   String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
                                                                                                            ", Expiry_month="+month+
                                                                                                            ", Expiry_year="+year+
                                                                                                            " WHERE Sno="+sno; 
                                                   st.executeUpdate(query3);
                                                   String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                   st.executeUpdate(query10);
                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno=1"; 
                                                   st.executeUpdate(query9);
                                                   String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+sno;
                                                   st.executeUpdate(query4);
                                                   JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                }
                                               else
                                               {
                                                   int d=expiry_date;int m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
                                                   if((d>=1)&&(d<=27))
                                                   {
                                                        d1=d+1;m1=m-6;
                                                        if(m1<0)
                                                        {
                                                            m1=12+m1;y1=y-1;
                                                        }
                                                        else
                                                        {
                                                            if(m1==0)
                                                            {
                                                               m1=12;y1=y-1;
                                                            }
                                                        }
                                                    }
                                                    else
                                                    {
                                                        if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
                                                        {
                                                            d1=29;m1=2;
                                                        }
                                                        else
                                                        {
                                                           if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
                                                           {
                                                            d1=28;m1=2;
                                                           }
                                                           else
                                                           {
                                                              if((d==31)&&(m==8)&&(((y)%4)==0))
                                                                {
                                                                  d1=1;m1=3;
                                                                }
                                                                else
                                                                {
                                                                    if((d==31)&&(m==8)&&(((y)%4)!=0))
                                                                    {
                                                                        d1=1;m1=3;
                                                                    }
                                                                    else
                                                                    {
                                                                        if(d==31||d==30)
                                                                        {
                                                                           m1=m-6;
                                                                           if(m1<0)
                                                                           {
                                                                               m1=12+m1;
                                                                               if(d==30)
                                                                               {
                                                                                   if(m1==9||m1==11)
                                                                                   {
                                                                                       d1=1;m1=m1+1;y1=y-1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                      d1=31;y1=y-1;
                                                                                   }
                                                                               }
                                                                               else
                                                                               {
                                                                                   if(m1==11||m1==9||m1==7)
                                                                                   {
                                                                                       d1=1;m1=m1+1;y1=y-1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       d1=1;m1=m1+1;y1=y-1;
                                                                                   }
                                                                               }
                                                                           }
                                                                           else
                                                                           {
                                                                               if(d==30)
                                                                               {
                                                                                   if(m1==0)
                                                                                   {
                                                                                      d1=31;m1=12;y1=y-1; 
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       if(m1==6||m1==4)
                                                                                       {
                                                                                           d1=1;m1=m1+1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           if(m1==5||m1==3||m1==1)
                                                                                           {
                                                                                               d1=31;
                                                                                           }
                                                                                       }
                                                                                   }
                                                                                }
                                                                               else
                                                                               {
                                                                                   if(m1==7||m1==8||m1==10||m1==12)
                                                                                   {
                                                                                       d1=1;m1=m1+1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       d1=1;m1=m1+1;
                                                                                   }
                                                                               }
                                                                            }
                                                                        }
                                                                       else
                                                                        {     
                                                                            m1=m-6;
                                                                            if(m1<0)
                                                                            {
                                                                               d1=d+1;m1=12+m1;y1=y-1;
                                                                            }
                                                                            else
                                                                            {
                                                                                if(m1==0)
                                                                                {
                                                                                   d1=d+1;m1=12;y1=y-1;
                                                                                }
                                                                                else
                                                                                {
                                                                                   d1=d+1;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                   int minidate=d1;
                                                   int minimonth=m1;
                                                   int miniyear=y1;
                                                   if(complain_year==miniyear)
                                                   {
                                                       if(complain_month==minimonth)
                                                       {
                                                           if(complain_date==minidate)
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                           else
                                                           {
                                                               if(complain_date<expiry_date)
                                                               {
                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                                   rt=st.executeQuery(query5);
                                                                   if(rt.next())
                                                                   {
                                                                       int warranty_days=rt.getInt(4);
                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                   ", Expiry_date="+expirydate+
                                                                                                                                   ", Expiry_month="+expirymonth+
                                                                                                                                   ", Expiry_year="+expiryyear+
                                                                                                                                   " WHERE Sno="+sno;  
                                                                       st.executeUpdate(query6);
                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                            " WHERE Sno="+temp; 
                                                                       st.executeUpdate(query9);
                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                                    }
                                                                }
                                                               else
                                                               {
                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+date_of_warranty+
                                                                                                                               ", Expiry_month="+month_of_warranty+
                                                                                                                               ", Expiry_year="+year_of_warranty+
                                                                                                                               " WHERE Sno="+sno;
                                                                   st.executeUpdate(query7);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                        }
                                                       else
                                                       {
                                                          if(complain_month<expiry_month)
                                                           {
                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                               rt=st.executeQuery(query5);
                                                               if(rt.next())
                                                               {
                                                                   int warranty_days=rt.getInt(4);
                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+expirydate+
                                                                                                                               ", Expiry_month="+expirymonth+
                                                                                                                               ", Expiry_year="+expiryyear+
                                                                                                                               " WHERE Sno="+sno;  
                                                                   st.executeUpdate(query6);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                           else
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }    
                                                    }
                                                   else
                                                   {
                                                       if(complain_year<expiry_year)
                                                       {
                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                           rt=st.executeQuery(query5);
                                                           if(rt.next())
                                                           {
                                                               int warranty_days=rt.getInt(4);
                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+expirydate+
                                                                                                                           ", Expiry_month="+expirymonth+
                                                                                                                           ", Expiry_year="+expiryyear+
                                                                                                                           " WHERE Sno="+sno;  
                                                               st.executeUpdate(query6);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                       else
                                                       {
                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+date_of_warranty+
                                                                                                                       ", Expiry_month="+month_of_warranty+
                                                                                                                       ", Expiry_year="+year_of_warranty+
                                                                                                                       " WHERE Sno="+sno;
                                                           st.executeUpdate(query7);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                    }
                                                }
                                          }
                                       }
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Year_of_reinstallation.getText())<complain_year)
                                       {
                                           JOptionPane.showMessageDialog(null, "Invalid date...");
                                       }
                                       else
                                       {
                                           if(installationDate==0&&installationMonth==0&&installationYear==0)
                                           {
                                               this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                               this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
                                               this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
                                               String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
                                                                                                        ", Expiry_month="+month+
                                                                                                        ", Expiry_year="+year+
                                                                                                        " WHERE Sno="+sno; 
                                               st.executeUpdate(query3);
                                               String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                               st.executeUpdate(query10);
                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                        " WHERE Sno=1"; 
                                               st.executeUpdate(query9);
                                               String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                        ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                        ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                        " WHERE Sno="+sno;
                                               st.executeUpdate(query4);
                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                            }
                                           else
                                           {
                                               int d=expiry_date;int m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
                                               if((d>=1)&&(d<=27))
                                               {
                                                    d1=d+1;m1=m-6;
                                                    if(m1<0)
                                                    {
                                                        m1=12+m1;y1=y-1;
                                                    }
                                                    else
                                                    {
                                                        if(m1==0)
                                                        {
                                                           m1=12;y1=y-1;
                                                        }
                                                    }
                                                }
                                                else
                                                {
                                                    if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
                                                    {
                                                        d1=29;m1=2;
                                                    }
                                                    else
                                                    {
                                                       if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
                                                       {
                                                        d1=28;m1=2;
                                                       }
                                                       else
                                                       {
                                                          if((d==31)&&(m==8)&&(((y)%4)==0))
                                                            {
                                                              d1=1;m1=3;
                                                            }
                                                            else
                                                            {
                                                                if((d==31)&&(m==8)&&(((y)%4)!=0))
                                                                {
                                                                    d1=1;m1=3;
                                                                }
                                                                else
                                                                {
                                                                    if(d==31||d==30)
                                                                    {
                                                                       m1=m-6;
                                                                       if(m1<0)
                                                                       {
                                                                           m1=12+m1;
                                                                           if(d==30)
                                                                           {
                                                                               if(m1==9||m1==11)
                                                                               {
                                                                                   d1=1;m1=m1+1;y1=y-1;
                                                                               }
                                                                               else
                                                                               {
                                                                                  d1=31;y1=y-1;
                                                                               }
                                                                           }
                                                                           else
                                                                           {
                                                                               if(m1==11||m1==9||m1==7)
                                                                               {
                                                                                   d1=1;m1=m1+1;y1=y-1;
                                                                               }
                                                                               else
                                                                               {
                                                                                   d1=1;m1=m1+1;y1=y-1;
                                                                               }
                                                                           }
                                                                       }
                                                                       else
                                                                       {
                                                                           if(d==30)
                                                                           {
                                                                               if(m1==0)
                                                                               {
                                                                                  d1=31;m1=12;y1=y-1; 
                                                                               }
                                                                               else
                                                                               {
                                                                                   if(m1==6||m1==4)
                                                                                   {
                                                                                       d1=1;m1=m1+1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       if(m1==5||m1==3||m1==1)
                                                                                       {
                                                                                           d1=31;
                                                                                       }
                                                                                   }
                                                                               }
                                                                            }
                                                                           else
                                                                           {
                                                                               if(m1==7||m1==8||m1==10||m1==12)
                                                                               {
                                                                                   d1=1;m1=m1+1;
                                                                               }
                                                                               else
                                                                               {
                                                                                   d1=1;m1=m1+1;
                                                                               }
                                                                           }
                                                                        }
                                                                    }
                                                                   else
                                                                    {     
                                                                        m1=m-6;
                                                                        if(m1<0)
                                                                        {
                                                                           d1=d+1;m1=12+m1;y1=y-1;
                                                                        }
                                                                        else
                                                                        {
                                                                            if(m1==0)
                                                                            {
                                                                               d1=d+1;m1=12;y1=y-1;
                                                                            }
                                                                            else
                                                                            {
                                                                               d1=d+1;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                               int minidate=d1;
                                               int minimonth=m1;
                                               int miniyear=y1;
                                               if(complain_year==miniyear)
                                               {
                                                   if(complain_month==minimonth)
                                                   {
                                                       if(complain_date==minidate)
                                                       {
                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+date_of_warranty+
                                                                                                                       ", Expiry_month="+month_of_warranty+
                                                                                                                       ", Expiry_year="+year_of_warranty+
                                                                                                                       " WHERE Sno="+sno;
                                                           st.executeUpdate(query7);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                        " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                       else
                                                       {
                                                           if(complain_date<expiry_date)
                                                           {
                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                               rt=st.executeQuery(query5);
                                                               if(rt.next())
                                                               {
                                                                   int warranty_days=rt.getInt(4);
                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+expirydate+
                                                                                                                               ", Expiry_month="+expirymonth+
                                                                                                                               ", Expiry_year="+expiryyear+
                                                                                                                               " WHERE Sno="+sno;  
                                                                   st.executeUpdate(query6);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                           else
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                    }
                                                   else
                                                   {
                                                      if(complain_month<expiry_month)
                                                       {
                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                           rt=st.executeQuery(query5);
                                                           if(rt.next())
                                                           {
                                                               int warranty_days=rt.getInt(4);
                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+expirydate+
                                                                                                                           ", Expiry_month="+expirymonth+
                                                                                                                           ", Expiry_year="+expiryyear+
                                                                                                                           " WHERE Sno="+sno;  
                                                               st.executeUpdate(query6);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                       else
                                                       {
                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+date_of_warranty+
                                                                                                                       ", Expiry_month="+month_of_warranty+
                                                                                                                       ", Expiry_year="+year_of_warranty+
                                                                                                                       " WHERE Sno="+sno;
                                                           st.executeUpdate(query7);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                    }    
                                                }
                                               else
                                               {
                                                   if(complain_year<expiry_year)
                                                   {
                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                       rt=st.executeQuery(query5);
                                                       if(rt.next())
                                                       {
                                                           int warranty_days=rt.getInt(4);
                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+expirydate+
                                                                                                                       ", Expiry_month="+expirymonth+
                                                                                                                       ", Expiry_year="+expiryyear+
                                                                                                                       " WHERE Sno="+sno;  
                                                           st.executeUpdate(query6);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                    }
                                                   else
                                                   {
                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                   ", Expiry_date="+date_of_warranty+
                                                                                                                   ", Expiry_month="+month_of_warranty+
                                                                                                                   ", Expiry_year="+year_of_warranty+
                                                                                                                   " WHERE Sno="+sno;
                                                       st.executeUpdate(query7);
                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+temp; 
                                                       st.executeUpdate(query9);
                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                    }
                                                }
                                            }
                                        }
                                    }
//                                   if(Integer.parseInt(Year_of_reinstallation.getText())<=complain_year)
//                                   {
//                                       if(Integer.parseInt(Year_of_reinstallation.getText())==complain_year)
//                                       {
//                                           if(Integer.parseInt(Month_of_reinstallation.getText())<=complain_month)
//                                           {
//                                               if(Integer.parseInt(Month_of_reinstallation.getText())==complain_month)
//                                               {
//                                                   if(Integer.parseInt(Date_of_reinstallation.getText())<=complain_date)
//                                                   {
//                                                       if(Integer.parseInt(Date_of_reinstallation.getText())==complain_date)
//                                                        {
//                                                           JOptionPane.showMessageDialog(null, "Invalid date...");
//                                                        }
//                                                       else
//                                                       {
//                                                           JOptionPane.showMessageDialog(null, "Invalid date...!"); 
//                                                        }
//                                                    }
//                                                   else
//                                                   {
//                                                       if(installationDate==0&&installationMonth==0&&installationYear==0)
//                                                       {
//                                                           this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
//                                                           this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
//                                                           String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
//                                                                                                                    ", Expiry_month="+month+
//                                                                                                                    ", Expiry_year="+year+
//                                                                                                                    " WHERE Sno="+sno; 
//                                                           st.executeUpdate(query3);
//                                                           String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                           st.executeUpdate(query10);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno=1"; 
//                                                           st.executeUpdate(query9);
//                                                           String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+sno;
//                                                           st.executeUpdate(query4);
//                                                           JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                        }
//                                                       else
//                                                       {
//                                                           int d=expiry_date;int m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
//                                                           if((d>=1)&&(d<=27))
//                                                           {
//                                                                d1=d+1;m1=m-6;
//                                                                if(m1<0)
//                                                                {
//                                                                    m1=12+m1;y1=y-1;
//                                                                }
//                                                                else
//                                                                {
//                                                                    if(m1==0)
//                                                                    {
//                                                                       m1=12;y1=y-1;
//                                                                    }
//                                                                }
//                                                            }
//                                                            else
//                                                            {
//                                                                if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
//                                                                {
//                                                                    d1=29;m1=2;
//                                                                }
//                                                                else
//                                                                {
//                                                                   if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
//                                                                   {
//                                                                    d1=28;m1=2;
//                                                                   }
//                                                                   else
//                                                                   {
//                                                                      if((d==31)&&(m==8)&&(((y)%4)==0))
//                                                                        {
//                                                                          d1=1;m1=3;
//                                                                        }
//                                                                        else
//                                                                        {
//                                                                            if((d==31)&&(m==8)&&(((y)%4)!=0))
//                                                                            {
//                                                                                d1=1;m1=3;
//                                                                            }
//                                                                            else
//                                                                            {
//                                                                                if(d==31||d==30)
//                                                                                {
//                                                                                   m1=m-6;
//                                                                                   if(m1<0)
//                                                                                   {
//                                                                                       m1=12+m1;
//                                                                                       if(d==30)
//                                                                                       {
//                                                                                           if(m1==9||m1==11)
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                              d1=31;y1=y-1;
//                                                                                           }
//                                                                                       }
//                                                                                       else
//                                                                                       {
//                                                                                           if(m1==11||m1==9||m1==7)
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                                           }
//                                                                                       }
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       if(d==30)
//                                                                                       {
//                                                                                           if(m1==0)
//                                                                                           {
//                                                                                              d1=31;m1=12;y1=y-1; 
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                               if(m1==6||m1==4)
//                                                                                               {
//                                                                                                   d1=1;m1=m1+1;
//                                                                                               }
//                                                                                               else
//                                                                                               {
//                                                                                                   if(m1==5||m1==3||m1==1)
//                                                                                                   {
//                                                                                                       d1=31;
//                                                                                                   }
//                                                                                               }
//                                                                                           }
//                                                                                        }
//                                                                                       else
//                                                                                       {
//                                                                                           if(m1==7||m1==8||m1==10||m1==12)
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;
//                                                                                           }
//                                                                                       }
//                                                                                    }
//                                                                                }
//                                                                               else
//                                                                                {     
//                                                                                    m1=m-6;
//                                                                                    if(m1<0)
//                                                                                    {
//                                                                                       d1=d+1;m1=12+m1;y1=y-1;
//                                                                                    }
//                                                                                    else
//                                                                                    {
//                                                                                        if(m1==0)
//                                                                                        {
//                                                                                           d1=d+1;m1=12;y1=y-1;
//                                                                                        }
//                                                                                        else
//                                                                                        {
//                                                                                           d1=d+1;
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                           int minidate=d1;
//                                                           int minimonth=m1;
//                                                           int miniyear=y1;
//                                                           if(complain_year==miniyear)
//                                                           {
//                                                               if(complain_month==minimonth)
//                                                               {
//                                                                   if(complain_date==minidate)
//                                                                   {
//                                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                                   " WHERE Sno="+sno;
//                                                                       st.executeUpdate(query7);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       if(complain_date<expiry_date)
//                                                                       {
//                                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                           rt=st.executeQuery(query5);
//                                                                           if(rt.next())
//                                                                           {
//                                                                               int warranty_days=rt.getInt(4);
//                                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                           ", Expiry_date="+expirydate+
//                                                                                                                                           ", Expiry_month="+expirymonth+
//                                                                                                                                           ", Expiry_year="+expiryyear+
//                                                                                                                                           " WHERE Sno="+sno;  
//                                                                               st.executeUpdate(query6);
//                                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                    " WHERE Sno="+temp; 
//                                                                               st.executeUpdate(query9);
//                                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                       ", Expiry_date="+date_of_warranty+
//                                                                                                                                       ", Expiry_month="+month_of_warranty+
//                                                                                                                                       ", Expiry_year="+year_of_warranty+
//                                                                                                                                       " WHERE Sno="+sno;
//                                                                           st.executeUpdate(query7);
//                                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                " WHERE Sno="+temp; 
//                                                                           st.executeUpdate(query9);
//                                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                        }
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                  if(complain_month<expiry_month)
//                                                                   {
//                                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                       rt=st.executeQuery(query5);
//                                                                       if(rt.next())
//                                                                       {
//                                                                           int warranty_days=rt.getInt(4);
//                                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                       ", Expiry_date="+expirydate+
//                                                                                                                                       ", Expiry_month="+expirymonth+
//                                                                                                                                       ", Expiry_year="+expiryyear+
//                                                                                                                                       " WHERE Sno="+sno;  
//                                                                           st.executeUpdate(query6);
//                                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                " WHERE Sno="+temp; 
//                                                                           st.executeUpdate(query9);
//                                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                        }
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                                   " WHERE Sno="+sno;
//                                                                       st.executeUpdate(query7);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                            " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                }    
//                                                            }
//                                                           else
//                                                           {
//                                                               if(complain_year<expiry_year)
//                                                               {
//                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                   rt=st.executeQuery(query5);
//                                                                   if(rt.next())
//                                                                   {
//                                                                       int warranty_days=rt.getInt(4);
//                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+expirydate+
//                                                                                                                                   ", Expiry_month="+expirymonth+
//                                                                                                                                   ", Expiry_year="+expiryyear+
//                                                                                                                                   " WHERE Sno="+sno;  
//                                                                       st.executeUpdate(query6);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                            " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                               ", Expiry_date="+date_of_warranty+
//                                                                                                                               ", Expiry_month="+month_of_warranty+
//                                                                                                                               ", Expiry_year="+year_of_warranty+
//                                                                                                                               " WHERE Sno="+sno;
//                                                                   st.executeUpdate(query7);
//                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                        " WHERE Sno="+temp; 
//                                                                   st.executeUpdate(query9);
//                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                }
//                                                            }
//                                                       }
//                                                    }
//                                                }
//                                               else
//                                               {
//                                                  JOptionPane.showMessageDialog(null, "Invalid date...");
//                                                }
//                                            }
//                                           else
//                                           {
//                                               if(installationDate==0&&installationMonth==0&&installationYear==0)
//                                               {
//                                                   this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                   this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
//                                                   this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
//                                                   String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
//                                                                                                            ", Expiry_month="+month+
//                                                                                                            ", Expiry_year="+year+
//                                                                                                            " WHERE Sno="+sno; 
//                                                   st.executeUpdate(query3);
//                                                   String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                   st.executeUpdate(query10);
//                                                   String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+sno;
//                                                   st.executeUpdate(query4);
//                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno=1"; 
//                                                   st.executeUpdate(query9);
//                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                }
//                                               else
//                                               {
//                                                   int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
//                                                   if((d>=1)&&(d<=27))
//                                                   {
//                                                        d1=d+1;m1=m-6;
//                                                        if(m1<0)
//                                                        {
//                                                            m1=12+m1;y1=y-1;
//                                                        }
//                                                        else
//                                                        {
//                                                            if(m1==0)
//                                                            {
//                                                               m1=12;y1=y-1;
//                                                            }
//                                                        }
//                                                    }
//                                                    else
//                                                    {
//                                                        if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
//                                                        {
//                                                            d1=29;m1=2;
//                                                        }
//                                                        else
//                                                        {
//                                                           if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
//                                                           {
//                                                            d1=28;m1=2;
//                                                           }
//                                                           else
//                                                           {
//                                                              if((d==31)&&(m==8)&&(((y)%4)==0))
//                                                                {
//                                                                  d1=1;m1=3;
//                                                                }
//                                                                else
//                                                                {
//                                                                    if((d==31)&&(m==8)&&(((y)%4)!=0))
//                                                                    {
//                                                                        d1=1;m1=3;
//                                                                    }
//                                                                    else
//                                                                    {
//                                                                        if(d==31||d==30)
//                                                                        {
//                                                                           m1=m-6;
//                                                                           if(m1<0)
//                                                                           {
//                                                                               m1=12+m1;
//                                                                               if(d==30)
//                                                                               {
//                                                                                   if(m1==9||m1==11)
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;y1=y-1;
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                      d1=31;y1=y-1;
//                                                                                   }
//                                                                               }
//                                                                               else
//                                                                               {
//                                                                                   if(m1==11||m1==9||m1==7)
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;y1=y-1;
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;y1=y-1;
//                                                                                   }
//                                                                               }
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               if(d==30)
//                                                                               {
//                                                                                   if(m1==0)
//                                                                                   {
//                                                                                      d1=31;m1=12;y1=y-1; 
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       if(m1==6||m1==4)
//                                                                                       {
//                                                                                           d1=1;m1=m1+1;
//                                                                                       }
//                                                                                       else
//                                                                                       {
//                                                                                           if(m1==5||m1==3||m1==1)
//                                                                                           {
//                                                                                               d1=31;
//                                                                                           }
//                                                                                       }
//                                                                                   }
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   if(m1==7||m1==8||m1==10||m1==12)
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;
//                                                                                   }
//                                                                               }
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                        {     
//                                                                            m1=m-6;
//                                                                            if(m1<0)
//                                                                            {
//                                                                               d1=d+1;m1=12+m1;y1=y-1;
//                                                                            }
//                                                                            else
//                                                                            {
//                                                                                if(m1==0)
//                                                                                {
//                                                                                   d1=d+1;m1=12;y1=y-1;
//                                                                                }
//                                                                                else
//                                                                                {
//                                                                                   d1=d+1;
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                   int minidate=d1;
//                                                   int minimonth=m1;
//                                                   int miniyear=y1;
//                                                   if(complain_year==miniyear)
//                                                   {
//                                                       if(complain_month==minimonth)
//                                                       {
//                                                           if(complain_date==minidate)
//                                                           {
//                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+date_of_warranty+
//                                                                                                                           ", Expiry_month="+month_of_warranty+
//                                                                                                                           ", Expiry_year="+year_of_warranty+
//                                                                                                                           " WHERE Sno="+sno;
//                                                               st.executeUpdate(query7);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                           else
//                                                           {
//                                                               if(complain_date<expiry_date)
//                                                               {
//                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                   rt=st.executeQuery(query5);
//                                                                   if(rt.next())
//                                                                   {
//                                                                       int warranty_days=rt.getInt(4);
//                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+expirydate+
//                                                                                                                                   ", Expiry_month="+expirymonth+
//                                                                                                                                   ", Expiry_year="+expiryyear+
//                                                                                                                                   " WHERE Sno="+sno;  
//                                                                       st.executeUpdate(query6);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                            " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                               ", Expiry_date="+date_of_warranty+
//                                                                                                                               ", Expiry_month="+month_of_warranty+
//                                                                                                                               ", Expiry_year="+year_of_warranty+
//                                                                                                                               " WHERE Sno="+sno;
//                                                                   st.executeUpdate(query7);
//                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                        " WHERE Sno="+temp; 
//                                                                   st.executeUpdate(query9);
//                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                }
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                          if(complain_month<expiry_month)
//                                                           {
//                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                               rt=st.executeQuery(query5);
//                                                               if(rt.next())
//                                                               {
//                                                                   int warranty_days=rt.getInt(4);
//                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                               ", Expiry_date="+expirydate+
//                                                                                                                               ", Expiry_month="+expirymonth+
//                                                                                                                               ", Expiry_year="+expiryyear+
//                                                                                                                               " WHERE Sno="+sno;  
//                                                                   st.executeUpdate(query6);
//                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                        " WHERE Sno="+temp; 
//                                                                   st.executeUpdate(query9);
//                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                }
//                                                            }
//                                                           else
//                                                           {
//                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+date_of_warranty+
//                                                                                                                           ", Expiry_month="+month_of_warranty+
//                                                                                                                           ", Expiry_year="+year_of_warranty+
//                                                                                                                           " WHERE Sno="+sno;
//                                                               st.executeUpdate(query7);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                        }    
//                                                    }
//                                                   else
//                                                   {
//                                                       if(complain_year<expiry_year)
//                                                       {
//                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                           rt=st.executeQuery(query5);
//                                                           if(rt.next())
//                                                           {
//                                                               int warranty_days=rt.getInt(4);
//                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+expirydate+
//                                                                                                                           ", Expiry_month="+expirymonth+
//                                                                                                                           ", Expiry_year="+expiryyear+
//                                                                                                                           " WHERE Sno="+sno;  
//                                                               st.executeUpdate(query6);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                       ", Expiry_date="+date_of_warranty+
//                                                                                                                       ", Expiry_month="+month_of_warranty+
//                                                                                                                       ", Expiry_year="+year_of_warranty+
//                                                                                                                       " WHERE Sno="+sno;
//                                                           st.executeUpdate(query7);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                       else
//                                       {
//                                          JOptionPane.showMessageDialog(null, "Invalid date...");
//                                       }
//                                    }
//                                   else
//                                   {
//                                      if(installationDate==0&&installationMonth==0&&installationYear==0)
//                                        {
//                                           this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                           this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
//                                           this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
//                                           String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
//                                                                                                    ", Expiry_month="+month+
//                                                                                                    ", Expiry_year="+year+
//                                                                                                    " WHERE Sno="+sno; 
//                                           st.executeUpdate(query3);
//                                           String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                           st.executeUpdate(query10);
//                                           String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                    ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                    ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                    " WHERE Sno="+sno;
//                                           st.executeUpdate(query4);
//                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno=1"; 
//                                           st.executeUpdate(query9);
//                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                        }
//                                       else
//                                       {
//                                           int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
//                                           if((d>=1)&&(d<=27))
//                                           {
//                                                d1=d+1;m1=m-6;
//                                                if(m1<0)
//                                                {
//                                                    m1=12+m1;y1=y-1;
//                                                }
//                                                else
//                                                {
//                                                    if(m1==0)
//                                                    {
//                                                       m1=12;y1=y-1;
//                                                    }
//                                                }
//                                            }
//                                            else
//                                            {
//                                                if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
//                                                {
//                                                    d1=29;m1=2;
//                                                }
//                                                else
//                                                {
//                                                   if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
//                                                   {
//                                                    d1=28;m1=2;
//                                                   }
//                                                   else
//                                                   {
//                                                      if((d==31)&&(m==8)&&(((y)%4)==0))
//                                                        {
//                                                          d1=1;m1=3;
//                                                        }
//                                                        else
//                                                        {
//                                                            if((d==31)&&(m==8)&&(((y)%4)!=0))
//                                                            {
//                                                                d1=1;m1=3;
//                                                            }
//                                                            else
//                                                            {
//                                                                if(d==31||d==30)
//                                                                {
//                                                                   m1=m-6;
//                                                                   if(m1<0)
//                                                                   {
//                                                                       m1=12+m1;
//                                                                       if(d==30)
//                                                                       {
//                                                                           if(m1==9||m1==11)
//                                                                           {
//                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                              d1=31;y1=y-1;
//                                                                           }
//                                                                       }
//                                                                       else
//                                                                       {
//                                                                           if(m1==11||m1==9||m1==7)
//                                                                           {
//                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                           }
//                                                                       }
//                                                                   }
//                                                                   else
//                                                                   {
//                                                                       if(d==30)
//                                                                       {
//                                                                           if(m1==0)
//                                                                           {
//                                                                              d1=31;m1=12;y1=y-1; 
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               if(m1==6||m1==4)
//                                                                               {
//                                                                                   d1=1;m1=m1+1;
//                                                                               }
//                                                                               else
//                                                                               {
//                                                                                   if(m1==5||m1==3||m1==1)
//                                                                                   {
//                                                                                       d1=31;
//                                                                                   }
//                                                                               }
//                                                                           }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           if(m1==7||m1==8||m1==10||m1==12)
//                                                                           {
//                                                                               d1=1;m1=m1+1;
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               d1=1;m1=m1+1;
//                                                                           }
//                                                                       }
//                                                                    }
//                                                                }
//                                                               else
//                                                                {     
//                                                                    m1=m-6;
//                                                                    if(m1<0)
//                                                                    {
//                                                                       d1=d+1;m1=12+m1;y1=y-1;
//                                                                    }
//                                                                    else
//                                                                    {
//                                                                        if(m1==0)
//                                                                        {
//                                                                           d1=d+1;m1=12;y1=y-1;
//                                                                        }
//                                                                        else
//                                                                        {
//                                                                           d1=d+1;
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                           int minidate=d1;
//                                           int minimonth=m1;
//                                           int miniyear=y1;
//                                           if(complain_year==miniyear)
//                                           {
//                                               if(complain_month==minimonth)
//                                               {
//                                                   if(complain_date==minidate)
//                                                   {
//                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                   " WHERE Sno="+sno;
//                                                       st.executeUpdate(query7);
//                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                    " WHERE Sno="+temp; 
//                                                       st.executeUpdate(query9);
//                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                    }
//                                                   else
//                                                   {
//                                                       if(complain_date<expiry_date)
//                                                       {
//                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                           rt=st.executeQuery(query5);
//                                                           if(rt.next())
//                                                           {
//                                                               int warranty_days=rt.getInt(4);
//                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+expirydate+
//                                                                                                                           ", Expiry_month="+expirymonth+
//                                                                                                                           ", Expiry_year="+expiryyear+
//                                                                                                                           " WHERE Sno="+sno;  
//                                                               st.executeUpdate(query6);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                       ", Expiry_date="+date_of_warranty+
//                                                                                                                       ", Expiry_month="+month_of_warranty+
//                                                                                                                       ", Expiry_year="+year_of_warranty+
//                                                                                                                       " WHERE Sno="+sno;
//                                                           st.executeUpdate(query7);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                        }
//                                                    }
//                                                }
//                                               else
//                                               {
//                                                  if(complain_month<expiry_month)
//                                                   {
//                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                       rt=st.executeQuery(query5);
//                                                       if(rt.next())
//                                                       {
//                                                           int warranty_days=rt.getInt(4);
//                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                       ", Expiry_date="+expirydate+
//                                                                                                                       ", Expiry_month="+expirymonth+
//                                                                                                                       ", Expiry_year="+expiryyear+
//                                                                                                                       " WHERE Sno="+sno;  
//                                                           st.executeUpdate(query6);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                        }
//                                                    }
//                                                   else
//                                                   {
//                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                   " WHERE Sno="+sno;
//                                                       st.executeUpdate(query7);
//                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+temp; 
//                                                       st.executeUpdate(query9);
//                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                    }
//                                                }    
//                                            }
//                                           else
//                                           {
//                                               if(complain_year<expiry_year)
//                                               {
//                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                   rt=st.executeQuery(query5);
//                                                   if(rt.next())
//                                                   {
//                                                       int warranty_days=rt.getInt(4);
//                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                   ", Expiry_date="+expirydate+
//                                                                                                                   ", Expiry_month="+expirymonth+
//                                                                                                                   ", Expiry_year="+expiryyear+
//                                                                                                                   " WHERE Sno="+sno;  
//                                                       st.executeUpdate(query6);
//                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+temp; 
//                                                       st.executeUpdate(query9);
//                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                    }
//                                                }
//                                               else
//                                               {
//                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                               ", Expiry_date="+date_of_warranty+
//                                                                                                               ", Expiry_month="+month_of_warranty+
//                                                                                                               ", Expiry_year="+year_of_warranty+
//                                                                                                               " WHERE Sno="+sno;
//                                                   st.executeUpdate(query7);
//                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                        " WHERE Sno="+temp; 
//                                                   st.executeUpdate(query9);
//                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                }
//                                            }
//                                        }
//                                    }
                                }
                               else
                               {
                                  JOptionPane.showMessageDialog(null, "Re-installation Date already exist");
                               }
                            }
                        }
                      else
                       {
                           String query2="SELECT * FROM "+SpecificationNo_textfield.getText()+" WHERE Sno="+temp;
                           rt=st.executeQuery(query2);
                           if(rt.next())
                           {
                               int purchaseDate=rt.getInt(2);
                               int purchaseMonth=rt.getInt(3);
                               int purchaseYear=rt.getInt(4);
                               int installationDate=rt.getInt(5);
                               int installationMonth=rt.getInt(6);
                               int installationYear=rt.getInt(7);
                               int complain_date=rt.getInt(8);
                               int complain_month=rt.getInt(9);
                               int complain_year=rt.getInt(10);
                               int DORI=rt.getInt(11);
                               int MORI=rt.getInt(12);
                               int YORI=rt.getInt(13);
                               int expiry_date=rt.getInt(14);
                               int expiry_month=rt.getInt(15);
                               int expiry_year=rt.getInt(16);
                               if((DORI==0)&&(MORI==0)&&(YORI==0))
                               {
                                   if(Integer.parseInt(Year_of_reinstallation.getText())==complain_year)
                                   {
                                       if(Integer.parseInt(Month_of_reinstallation.getText())==complain_month)
                                       {
                                           if(Integer.parseInt(Date_of_reinstallation.getText())==complain_date)
                                           {
                                               JOptionPane.showMessageDialog(null, "Invalid date...");
                                           }
                                           else
                                           {
                                               if(Integer.parseInt(Date_of_reinstallation.getText())<complain_date)
                                               {
                                                   JOptionPane.showMessageDialog(null, "Invalid date...");
                                               }
                                               else
                                               {
                                                   if(installationDate==0&&installationMonth==0&&installationYear==0)
                                                   {
                                                       this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                       this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
                                                       this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
                                                       String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
                                                                                                                ", Expiry_month="+month+
                                                                                                                ", Expiry_year="+year+
                                                                                                                " WHERE Sno="+sno; 
                                                       st.executeUpdate(query3);
                                                       String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                       st.executeUpdate(query10);
                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                       st.executeUpdate(query9);
                                                       String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+sno;
                                                       st.executeUpdate(query4);
                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                    }
                                                   else
                                                   {
                                                       int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
                                                       if((d>=1)&&(d<=27))
                                                       {
                                                            d1=d+1;m1=m-6;
                                                            if(m1<0)
                                                            {
                                                                m1=12+m1;y1=y-1;
                                                            }
                                                            else
                                                            {
                                                                if(m1==0)
                                                                {
                                                                   m1=12;y1=y-1;
                                                                }
                                                            }
                                                        }
                                                        else
                                                        {
                                                            if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
                                                            {
                                                                d1=29;m1=2;
                                                            }
                                                            else
                                                            {
                                                               if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
                                                               {
                                                                d1=28;m1=2;
                                                               }
                                                               else
                                                               {
                                                                  if((d==31)&&(m==8)&&(((y)%4)==0))
                                                                    {
                                                                      d1=1;m1=3;
                                                                    }
                                                                    else
                                                                    {
                                                                        if((d==31)&&(m==8)&&(((y)%4)!=0))
                                                                        {
                                                                            d1=1;m1=3;
                                                                        }
                                                                        else
                                                                        {
                                                                            if(d==31||d==30)
                                                                            {
                                                                               m1=m-6;
                                                                               if(m1<0)
                                                                               {
                                                                                   m1=12+m1;
                                                                                   if(d==30)
                                                                                   {
                                                                                       if(m1==9||m1==11)
                                                                                       {
                                                                                           d1=1;m1=m1+1;y1=y-1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                          d1=31;y1=y-1;
                                                                                       }
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       if(m1==11||m1==9||m1==7)
                                                                                       {
                                                                                           d1=1;m1=m1+1;y1=y-1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           d1=1;m1=m1+1;y1=y-1;
                                                                                       }
                                                                                   }
                                                                               }
                                                                               else
                                                                               {
                                                                                   if(d==30)
                                                                                   {
                                                                                       if(m1==0)
                                                                                       {
                                                                                          d1=31;m1=12;y1=y-1; 
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           if(m1==6||m1==4)
                                                                                           {
                                                                                               d1=1;m1=m1+1;
                                                                                           }
                                                                                           else
                                                                                           {
                                                                                               if(m1==5||m1==3||m1==1)
                                                                                               {
                                                                                                   d1=31;
                                                                                               }
                                                                                           }
                                                                                       }
                                                                                    }
                                                                                   else
                                                                                   {
                                                                                       if(m1==7||m1==8||m1==10||m1==12)
                                                                                       {
                                                                                           d1=1;m1=m1+1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           d1=1;m1=m1+1;
                                                                                       }
                                                                                   }
                                                                                }
                                                                            }
                                                                           else
                                                                            {     
                                                                                m1=m-6;
                                                                                if(m1<0)
                                                                                {
                                                                                   d1=d+1;m1=12+m1;y1=y-1;
                                                                                }
                                                                                else
                                                                                {
                                                                                    if(m1==0)
                                                                                    {
                                                                                       d1=d+1;m1=12;y1=y-1;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                       d1=d+1;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                       int minidate=d1;
                                                       int minimonth=m1;
                                                       int miniyear=y1;
                                                       if(complain_year==miniyear)
                                                       {
                                                           if(complain_month==minimonth)
                                                           {
                                                               if(complain_date==minidate)
                                                               {
                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+date_of_warranty+
                                                                                                                               ", Expiry_month="+month_of_warranty+
                                                                                                                               ", Expiry_year="+year_of_warranty+
                                                                                                                               " WHERE Sno="+sno;
                                                                   st.executeUpdate(query7);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                               else
                                                               {
                                                                   if(complain_date<expiry_date)
                                                                   {
                                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                                       rt=st.executeQuery(query5);
                                                                       if(rt.next())
                                                                       {
                                                                           int warranty_days=rt.getInt(4);
                                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                       ", Expiry_date="+expirydate+
                                                                                                                                       ", Expiry_month="+expirymonth+
                                                                                                                                       ", Expiry_year="+expiryyear+
                                                                                                                                       " WHERE Sno="+sno;  
                                                                           st.executeUpdate(query6);
                                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                " WHERE Sno="+temp; 
                                                                           st.executeUpdate(query9);
                                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                                        }
                                                                    }
                                                                   else
                                                                   {
                                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                   ", Expiry_date="+date_of_warranty+
                                                                                                                                   ", Expiry_month="+month_of_warranty+
                                                                                                                                   ", Expiry_year="+year_of_warranty+
                                                                                                                                   " WHERE Sno="+sno;
                                                                       st.executeUpdate(query7);
                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                            " WHERE Sno="+temp; 
                                                                       st.executeUpdate(query9);
                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                                    }
                                                                }
                                                            }
                                                           else
                                                           {
                                                              if(complain_month<expiry_month)
                                                               {
                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                                   rt=st.executeQuery(query5);
                                                                   if(rt.next())
                                                                   {
                                                                       int warranty_days=rt.getInt(4);
                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                   ", Expiry_date="+expirydate+
                                                                                                                                   ", Expiry_month="+expirymonth+
                                                                                                                                   ", Expiry_year="+expiryyear+
                                                                                                                                   " WHERE Sno="+sno;  
                                                                       st.executeUpdate(query6);
                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                            " WHERE Sno="+temp; 
                                                                       st.executeUpdate(query9);
                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                                    }
                                                                }
                                                               else
                                                               {
                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+date_of_warranty+
                                                                                                                               ", Expiry_month="+month_of_warranty+
                                                                                                                               ", Expiry_year="+year_of_warranty+
                                                                                                                               " WHERE Sno="+sno;
                                                                   st.executeUpdate(query7);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }    
                                                        }
                                                       else
                                                       {
                                                           if(complain_year<expiry_year)
                                                           {
                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                               rt=st.executeQuery(query5);
                                                               if(rt.next())
                                                               {
                                                                   int warranty_days=rt.getInt(4);
                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+expirydate+
                                                                                                                               ", Expiry_month="+expirymonth+
                                                                                                                               ", Expiry_year="+expiryyear+
                                                                                                                               " WHERE Sno="+sno;  
                                                                   st.executeUpdate(query6);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                           else
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                    }
                                               }
                                           }
                                       }
                                       else
                                       {
                                           if(Integer.parseInt(Month_of_reinstallation.getText())<complain_month)
                                           {
                                               JOptionPane.showMessageDialog(null, "Invalid date...");
                                           }
                                           else
                                           {
                                               if(installationDate==0&&installationMonth==0&&installationYear==0)
                                               {
                                                   this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                   this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
                                                   this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
                                                   String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
                                                                                                            ", Expiry_month="+month+
                                                                                                            ", Expiry_year="+year+
                                                                                                            " WHERE Sno="+sno; 
                                                   st.executeUpdate(query3);
                                                   String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                   st.executeUpdate(query10);
                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+temp; 
                                                   st.executeUpdate(query9);
                                                   String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+sno;
                                                   st.executeUpdate(query4);
                                                   JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                }
                                               else
                                               {
                                                   int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
                                                   if((d>=1)&&(d<=27))
                                                   {
                                                        d1=d+1;m1=m-6;
                                                        if(m1<0)
                                                        {
                                                            m1=12+m1;y1=y-1;
                                                        }
                                                        else
                                                        {
                                                            if(m1==0)
                                                            {
                                                               m1=12;y1=y-1;
                                                            }
                                                        }
                                                    }
                                                    else
                                                    {
                                                        if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
                                                        {
                                                            d1=29;m1=2;
                                                        }
                                                        else
                                                        {
                                                           if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
                                                           {
                                                            d1=28;m1=2;
                                                           }
                                                           else
                                                           {
                                                              if((d==31)&&(m==8)&&(((y)%4)==0))
                                                                {
                                                                  d1=1;m1=3;
                                                                }
                                                                else
                                                                {
                                                                    if((d==31)&&(m==8)&&(((y)%4)!=0))
                                                                    {
                                                                        d1=1;m1=3;
                                                                    }
                                                                    else
                                                                    {
                                                                        if(d==31||d==30)
                                                                        {
                                                                           m1=m-6;
                                                                           if(m1<0)
                                                                           {
                                                                               m1=12+m1;
                                                                               if(d==30)
                                                                               {
                                                                                   if(m1==9||m1==11)
                                                                                   {
                                                                                       d1=1;m1=m1+1;y1=y-1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                      d1=31;y1=y-1;
                                                                                   }
                                                                               }
                                                                               else
                                                                               {
                                                                                   if(m1==11||m1==9||m1==7)
                                                                                   {
                                                                                       d1=1;m1=m1+1;y1=y-1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       d1=1;m1=m1+1;y1=y-1;
                                                                                   }
                                                                               }
                                                                           }
                                                                           else
                                                                           {
                                                                               if(d==30)
                                                                               {
                                                                                   if(m1==0)
                                                                                   {
                                                                                      d1=31;m1=12;y1=y-1; 
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       if(m1==6||m1==4)
                                                                                       {
                                                                                           d1=1;m1=m1+1;
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                           if(m1==5||m1==3||m1==1)
                                                                                           {
                                                                                               d1=31;
                                                                                           }
                                                                                       }
                                                                                   }
                                                                                }
                                                                               else
                                                                               {
                                                                                   if(m1==7||m1==8||m1==10||m1==12)
                                                                                   {
                                                                                       d1=1;m1=m1+1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       d1=1;m1=m1+1;
                                                                                   }
                                                                               }
                                                                            }
                                                                        }
                                                                       else
                                                                        {     
                                                                            m1=m-6;
                                                                            if(m1<0)
                                                                            {
                                                                               d1=d+1;m1=12+m1;y1=y-1;
                                                                            }
                                                                            else
                                                                            {
                                                                                if(m1==0)
                                                                                {
                                                                                   d1=d+1;m1=12;y1=y-1;
                                                                                }
                                                                                else
                                                                                {
                                                                                   d1=d+1;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                   int minidate=d1;
                                                   int minimonth=m1;
                                                   int miniyear=y1;
                                                   if(complain_year==miniyear)
                                                   {
                                                       if(complain_month==minimonth)
                                                       {
                                                           if(complain_date==minidate)
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                           else
                                                           {
                                                               if(complain_date<expiry_date)
                                                               {
                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                                   rt=st.executeQuery(query5);
                                                                   if(rt.next())
                                                                   {
                                                                       int warranty_days=rt.getInt(4);
                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                                   ", Expiry_date="+expirydate+
                                                                                                                                   ", Expiry_month="+expirymonth+
                                                                                                                                   ", Expiry_year="+expiryyear+
                                                                                                                                   " WHERE Sno="+sno;  
                                                                       st.executeUpdate(query6);
                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                            " WHERE Sno="+temp; 
                                                                       st.executeUpdate(query9);
                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                                    }
                                                                }
                                                               else
                                                               {
                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+date_of_warranty+
                                                                                                                               ", Expiry_month="+month_of_warranty+
                                                                                                                               ", Expiry_year="+year_of_warranty+
                                                                                                                               " WHERE Sno="+sno;
                                                                   st.executeUpdate(query7);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                        }
                                                       else
                                                       {
                                                          if(complain_month<expiry_month)
                                                           {
                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                               rt=st.executeQuery(query5);
                                                               if(rt.next())
                                                               {
                                                                   int warranty_days=rt.getInt(4);
                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+expirydate+
                                                                                                                               ", Expiry_month="+expirymonth+
                                                                                                                               ", Expiry_year="+expiryyear+
                                                                                                                               " WHERE Sno="+sno;  
                                                                   st.executeUpdate(query6);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                           else
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }    
                                                    }
                                                   else
                                                   {
                                                       if(complain_year<expiry_year)
                                                       {
                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                           rt=st.executeQuery(query5);
                                                           if(rt.next())
                                                           {
                                                               int warranty_days=rt.getInt(4);
                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+expirydate+
                                                                                                                           ", Expiry_month="+expirymonth+
                                                                                                                           ", Expiry_year="+expiryyear+
                                                                                                                           " WHERE Sno="+sno;  
                                                               st.executeUpdate(query6);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                       else
                                                       {
                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+date_of_warranty+
                                                                                                                       ", Expiry_month="+month_of_warranty+
                                                                                                                       ", Expiry_year="+year_of_warranty+
                                                                                                                       " WHERE Sno="+sno;
                                                           st.executeUpdate(query7);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                    }
                                                }
                                           }
                                       }
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Year_of_reinstallation.getText())<complain_year)
                                       {
                                           JOptionPane.showMessageDialog(null, "Invalid date...");
                                       }
                                       else
                                       {
                                           if(installationDate==0&&installationMonth==0&&installationYear==0)
                                           {
                                               this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                               this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
                                               this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
                                               String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
                                                                                                        ", Expiry_month="+month+
                                                                                                        ", Expiry_year="+year+
                                                                                                        " WHERE Sno="+sno; 
                                               st.executeUpdate(query3);
                                               String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                               st.executeUpdate(query10);
                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                        " WHERE Sno="+temp; 
                                               st.executeUpdate(query9);
                                               String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                        ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                        ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                        " WHERE Sno="+sno;
                                               st.executeUpdate(query4);
                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                            }
                                           else
                                           {
                                               int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
                                               if((d>=1)&&(d<=27))
                                               {
                                                    d1=d+1;m1=m-6;
                                                    if(m1<0)
                                                    {
                                                        m1=12+m1;y1=y-1;
                                                    }
                                                    else
                                                    {
                                                        if(m1==0)
                                                        {
                                                           m1=12;y1=y-1;
                                                        }
                                                    }
                                                }
                                                else
                                                {
                                                    if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
                                                    {
                                                        d1=29;m1=2;
                                                    }
                                                    else
                                                    {
                                                       if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
                                                       {
                                                        d1=28;m1=2;
                                                       }
                                                       else
                                                       {
                                                          if((d==31)&&(m==8)&&(((y)%4)==0))
                                                            {
                                                              d1=1;m1=3;
                                                            }
                                                            else
                                                            {
                                                                if((d==31)&&(m==8)&&(((y)%4)!=0))
                                                                {
                                                                    d1=1;m1=3;
                                                                }
                                                                else
                                                                {
                                                                    if(d==31||d==30)
                                                                    {
                                                                       m1=m-6;
                                                                       if(m1<0)
                                                                       {
                                                                           m1=12+m1;
                                                                           if(d==30)
                                                                           {
                                                                               if(m1==9||m1==11)
                                                                               {
                                                                                   d1=1;m1=m1+1;y1=y-1;
                                                                               }
                                                                               else
                                                                               {
                                                                                  d1=31;y1=y-1;
                                                                               }
                                                                           }
                                                                           else
                                                                           {
                                                                               if(m1==11||m1==9||m1==7)
                                                                               {
                                                                                   d1=1;m1=m1+1;y1=y-1;
                                                                               }
                                                                               else
                                                                               {
                                                                                   d1=1;m1=m1+1;y1=y-1;
                                                                               }
                                                                           }
                                                                       }
                                                                       else
                                                                       {
                                                                           if(d==30)
                                                                           {
                                                                               if(m1==0)
                                                                               {
                                                                                  d1=31;m1=12;y1=y-1; 
                                                                               }
                                                                               else
                                                                               {
                                                                                   if(m1==6||m1==4)
                                                                                   {
                                                                                       d1=1;m1=m1+1;
                                                                                   }
                                                                                   else
                                                                                   {
                                                                                       if(m1==5||m1==3||m1==1)
                                                                                       {
                                                                                           d1=31;
                                                                                       }
                                                                                   }
                                                                               }
                                                                            }
                                                                           else
                                                                           {
                                                                               if(m1==7||m1==8||m1==10||m1==12)
                                                                               {
                                                                                   d1=1;m1=m1+1;
                                                                               }
                                                                               else
                                                                               {
                                                                                   d1=1;m1=m1+1;
                                                                               }
                                                                           }
                                                                        }
                                                                    }
                                                                   else
                                                                    {     
                                                                        m1=m-6;
                                                                        if(m1<0)
                                                                        {
                                                                           d1=d+1;m1=12+m1;y1=y-1;
                                                                        }
                                                                        else
                                                                        {
                                                                            if(m1==0)
                                                                            {
                                                                               d1=d+1;m1=12;y1=y-1;
                                                                            }
                                                                            else
                                                                            {
                                                                               d1=d+1;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                               int minidate=d1;
                                               int minimonth=m1;
                                               int miniyear=y1;
                                               if(complain_year==miniyear)
                                               {
                                                   if(complain_month==minimonth)
                                                   {
                                                       if(complain_date==minidate)
                                                       {
                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+date_of_warranty+
                                                                                                                       ", Expiry_month="+month_of_warranty+
                                                                                                                       ", Expiry_year="+year_of_warranty+
                                                                                                                       " WHERE Sno="+sno;
                                                           st.executeUpdate(query7);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                        " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                       else
                                                       {
                                                           if(complain_date<expiry_date)
                                                           {
                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                               rt=st.executeQuery(query5);
                                                               if(rt.next())
                                                               {
                                                                   int warranty_days=rt.getInt(4);
                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                               ", Purchase_month="+purchaseMonth+
                                                                                                                               ", Purchase_year="+purchaseYear+
                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                               ", Expiry_date="+expirydate+
                                                                                                                               ", Expiry_month="+expirymonth+
                                                                                                                               ", Expiry_year="+expiryyear+
                                                                                                                               " WHERE Sno="+sno;  
                                                                   st.executeUpdate(query6);
                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                        " WHERE Sno="+temp; 
                                                                   st.executeUpdate(query9);
                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
                                                                }
                                                            }
                                                           else
                                                           {
                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+date_of_warranty+
                                                                                                                           ", Expiry_month="+month_of_warranty+
                                                                                                                           ", Expiry_year="+year_of_warranty+
                                                                                                                           " WHERE Sno="+sno;
                                                               st.executeUpdate(query7);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                    }
                                                   else
                                                   {
                                                      if(complain_month<expiry_month)
                                                       {
                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                           rt=st.executeQuery(query5);
                                                           if(rt.next())
                                                           {
                                                               int warranty_days=rt.getInt(4);
                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                           ", Purchase_month="+purchaseMonth+
                                                                                                                           ", Purchase_year="+purchaseYear+
                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                           ", Expiry_date="+expirydate+
                                                                                                                           ", Expiry_month="+expirymonth+
                                                                                                                           ", Expiry_year="+expiryyear+
                                                                                                                           " WHERE Sno="+sno;  
                                                               st.executeUpdate(query6);
                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                    " WHERE Sno="+temp; 
                                                               st.executeUpdate(query9);
                                                               JOptionPane.showMessageDialog(null, "Successfully added");
                                                            }
                                                        }
                                                       else
                                                       {
                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+date_of_warranty+
                                                                                                                       ", Expiry_month="+month_of_warranty+
                                                                                                                       ", Expiry_year="+year_of_warranty+
                                                                                                                       " WHERE Sno="+sno;
                                                           st.executeUpdate(query7);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                    }    
                                                }
                                               else
                                               {
                                                   if(complain_year<expiry_year)
                                                   {
                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
                                                       rt=st.executeQuery(query5);
                                                       if(rt.next())
                                                       {
                                                           int warranty_days=rt.getInt(4);
                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                       ", Purchase_month="+purchaseMonth+
                                                                                                                       ", Purchase_year="+purchaseYear+
                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                       ", Expiry_date="+expirydate+
                                                                                                                       ", Expiry_month="+expirymonth+
                                                                                                                       ", Expiry_year="+expiryyear+
                                                                                                                       " WHERE Sno="+sno;  
                                                           st.executeUpdate(query6);
                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                " WHERE Sno="+temp; 
                                                           st.executeUpdate(query9);
                                                           JOptionPane.showMessageDialog(null, "Successfully added");
                                                        }
                                                    }
                                                   else
                                                   {
                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
                                                                                                                   ", Purchase_month="+purchaseMonth+
                                                                                                                   ", Purchase_year="+purchaseYear+
                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                                   ", Expiry_date="+date_of_warranty+
                                                                                                                   ", Expiry_month="+month_of_warranty+
                                                                                                                   ", Expiry_year="+year_of_warranty+
                                                                                                                   " WHERE Sno="+sno;
                                                       st.executeUpdate(query7);
                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
                                                                                                            " WHERE Sno="+temp; 
                                                       st.executeUpdate(query9);
                                                       JOptionPane.showMessageDialog(null, "Successfully added");
                                                    }
                                                }
                                            }
                                       }
                                   }
//                                   if(Integer.parseInt(Year_of_reinstallation.getText())<=complain_year)
//                                   {
//                                       if(Integer.parseInt(Year_of_reinstallation.getText())==complain_year)
//                                       {
//                                           if(Integer.parseInt(Month_of_reinstallation.getText())<=complain_month)
//                                           {
//                                               if(Integer.parseInt(Month_of_reinstallation.getText())==complain_month)
//                                               {
//                                                   if(Integer.parseInt(Date_of_reinstallation.getText())<=complain_date)
//                                                   {
//                                                       if(Integer.parseInt(Date_of_reinstallation.getText())==complain_date)
//                                                        {
//                                                           JOptionPane.showMessageDialog(null, "Invalid date...");
//                                                        }
//                                                       else
//                                                       {
//                                                           JOptionPane.showMessageDialog(null, "Invalid date...!"); 
//                                                        }
//                                                    }
//                                                   else
//                                                   {
//                                                       if(installationDate==0&&installationMonth==0&&installationYear==0)
//                                                       {
//                                                           this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
//                                                           this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
//                                                           String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
//                                                                                                                    ", Expiry_month="+month+
//                                                                                                                    ", Expiry_year="+year+
//                                                                                                                    " WHERE Sno="+sno; 
//                                                           st.executeUpdate(query3);
//                                                           String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                           st.executeUpdate(query10);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+sno;
//                                                           st.executeUpdate(query4);
//                                                           JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                        }
//                                                       else
//                                                       {
//                                                           int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
//                                                           if((d>=1)&&(d<=27))
//                                                           {
//                                                                d1=d+1;m1=m-6;
//                                                                if(m1<0)
//                                                                {
//                                                                    m1=12+m1;y1=y-1;
//                                                                }
//                                                                else
//                                                                {
//                                                                    if(m1==0)
//                                                                    {
//                                                                       m1=12;y1=y-1;
//                                                                    }
//                                                                }
//                                                            }
//                                                            else
//                                                            {
//                                                                if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
//                                                                {
//                                                                    d1=29;m1=2;
//                                                                }
//                                                                else
//                                                                {
//                                                                   if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
//                                                                   {
//                                                                    d1=28;m1=2;
//                                                                   }
//                                                                   else
//                                                                   {
//                                                                      if((d==31)&&(m==8)&&(((y)%4)==0))
//                                                                        {
//                                                                          d1=1;m1=3;
//                                                                        }
//                                                                        else
//                                                                        {
//                                                                            if((d==31)&&(m==8)&&(((y)%4)!=0))
//                                                                            {
//                                                                                d1=1;m1=3;
//                                                                            }
//                                                                            else
//                                                                            {
//                                                                                if(d==31||d==30)
//                                                                                {
//                                                                                   m1=m-6;
//                                                                                   if(m1<0)
//                                                                                   {
//                                                                                       m1=12+m1;
//                                                                                       if(d==30)
//                                                                                       {
//                                                                                           if(m1==9||m1==11)
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                              d1=31;y1=y-1;
//                                                                                           }
//                                                                                       }
//                                                                                       else
//                                                                                       {
//                                                                                           if(m1==11||m1==9||m1==7)
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                                           }
//                                                                                       }
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       if(d==30)
//                                                                                       {
//                                                                                           if(m1==0)
//                                                                                           {
//                                                                                              d1=31;m1=12;y1=y-1; 
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                               if(m1==6||m1==4)
//                                                                                               {
//                                                                                                   d1=1;m1=m1+1;
//                                                                                               }
//                                                                                               else
//                                                                                               {
//                                                                                                   if(m1==5||m1==3||m1==1)
//                                                                                                   {
//                                                                                                       d1=31;
//                                                                                                   }
//                                                                                               }
//                                                                                           }
//                                                                                        }
//                                                                                       else
//                                                                                       {
//                                                                                           if(m1==7||m1==8||m1==10||m1==12)
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;
//                                                                                           }
//                                                                                           else
//                                                                                           {
//                                                                                               d1=1;m1=m1+1;
//                                                                                           }
//                                                                                       }
//                                                                                    }
//                                                                                }
//                                                                               else
//                                                                                {     
//                                                                                    m1=m-6;
//                                                                                    if(m1<0)
//                                                                                    {
//                                                                                       d1=d+1;m1=12+m1;y1=y-1;
//                                                                                    }
//                                                                                    else
//                                                                                    {
//                                                                                        if(m1==0)
//                                                                                        {
//                                                                                           d1=d+1;m1=12;y1=y-1;
//                                                                                        }
//                                                                                        else
//                                                                                        {
//                                                                                           d1=d+1;
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                           int minidate=d1;
//                                                           int minimonth=m1;
//                                                           int miniyear=y1;
//                                                           if(complain_year==miniyear)
//                                                           {
//                                                               if(complain_month==minimonth)
//                                                               {
//                                                                   if(complain_date==minidate)
//                                                                   {
//                                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                                   " WHERE Sno="+sno;
//                                                                       st.executeUpdate(query7);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       if(complain_date<expiry_date)
//                                                                       {
//                                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                           rt=st.executeQuery(query5);
//                                                                           if(rt.next())
//                                                                           {
//                                                                               int warranty_days=rt.getInt(4);
//                                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                           ", Expiry_date="+expirydate+
//                                                                                                                                           ", Expiry_month="+expirymonth+
//                                                                                                                                           ", Expiry_year="+expiryyear+
//                                                                                                                                           " WHERE Sno="+sno;  
//                                                                               st.executeUpdate(query6);
//                                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                    " WHERE Sno="+temp; 
//                                                                               st.executeUpdate(query9);
//                                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                       ", Expiry_date="+date_of_warranty+
//                                                                                                                                       ", Expiry_month="+month_of_warranty+
//                                                                                                                                       ", Expiry_year="+year_of_warranty+
//                                                                                                                                       " WHERE Sno="+sno;
//                                                                           st.executeUpdate(query7);
//                                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                " WHERE Sno="+temp; 
//                                                                           st.executeUpdate(query9);
//                                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                        }
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                  if(complain_month<expiry_month)
//                                                                   {
//                                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                       rt=st.executeQuery(query5);
//                                                                       if(rt.next())
//                                                                       {
//                                                                           int warranty_days=rt.getInt(4);
//                                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                       ", Expiry_date="+expirydate+
//                                                                                                                                       ", Expiry_month="+expirymonth+
//                                                                                                                                       ", Expiry_year="+expiryyear+
//                                                                                                                                       " WHERE Sno="+sno;  
//                                                                           st.executeUpdate(query6);
//                                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                " WHERE Sno="+temp; 
//                                                                           st.executeUpdate(query9);
//                                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                        }
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                                   " WHERE Sno="+sno;
//                                                                       st.executeUpdate(query7);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                            " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                }    
//                                                            }
//                                                           else
//                                                           {
//                                                               if(complain_year<expiry_year)
//                                                               {
//                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                   rt=st.executeQuery(query5);
//                                                                   if(rt.next())
//                                                                   {
//                                                                       int warranty_days=rt.getInt(4);
//                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+expirydate+
//                                                                                                                                   ", Expiry_month="+expirymonth+
//                                                                                                                                   ", Expiry_year="+expiryyear+
//                                                                                                                                   " WHERE Sno="+sno;  
//                                                                       st.executeUpdate(query6);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                            " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                               ", Expiry_date="+date_of_warranty+
//                                                                                                                               ", Expiry_month="+month_of_warranty+
//                                                                                                                               ", Expiry_year="+year_of_warranty+
//                                                                                                                               " WHERE Sno="+sno;
//                                                                   st.executeUpdate(query7);
//                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                        " WHERE Sno="+temp; 
//                                                                   st.executeUpdate(query9);
//                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                               else
//                                               {
//                                                  JOptionPane.showMessageDialog(null, "Invalid date...");
//                                                }
//                                            }
//                                           else
//                                           {
//                                               if(installationDate==0&&installationMonth==0&&installationYear==0)
//                                               {
//                                                   this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                   this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
//                                                   this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
//                                                   String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
//                                                                                                            ", Expiry_month="+month+
//                                                                                                            ", Expiry_year="+year+
//                                                                                                            " WHERE Sno="+sno; 
//                                                   st.executeUpdate(query3);
//                                                   String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                   st.executeUpdate(query10);
//                                                   String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+sno;
//                                                   st.executeUpdate(query4);
//                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                   st.executeUpdate(query9);
//                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                }
//                                               else
//                                               {
//                                                   int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
//                                                   if((d>=1)&&(d<=27))
//                                                   {
//                                                        d1=d+1;m1=m-6;
//                                                        if(m1<0)
//                                                        {
//                                                            m1=12+m1;y1=y-1;
//                                                        }
//                                                        else
//                                                        {
//                                                            if(m1==0)
//                                                            {
//                                                               m1=12;y1=y-1;
//                                                            }
//                                                        }
//                                                    }
//                                                    else
//                                                    {
//                                                        if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
//                                                        {
//                                                            d1=29;m1=2;
//                                                        }
//                                                        else
//                                                        {
//                                                           if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
//                                                           {
//                                                            d1=28;m1=2;
//                                                           }
//                                                           else
//                                                           {
//                                                              if((d==31)&&(m==8)&&(((y)%4)==0))
//                                                                {
//                                                                  d1=1;m1=3;
//                                                                }
//                                                                else
//                                                                {
//                                                                    if((d==31)&&(m==8)&&(((y)%4)!=0))
//                                                                    {
//                                                                        d1=1;m1=3;
//                                                                    }
//                                                                    else
//                                                                    {
//                                                                        if(d==31||d==30)
//                                                                        {
//                                                                           m1=m-6;
//                                                                           if(m1<0)
//                                                                           {
//                                                                               m1=12+m1;
//                                                                               if(d==30)
//                                                                               {
//                                                                                   if(m1==9||m1==11)
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;y1=y-1;
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                      d1=31;y1=y-1;
//                                                                                   }
//                                                                               }
//                                                                               else
//                                                                               {
//                                                                                   if(m1==11||m1==9||m1==7)
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;y1=y-1;
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;y1=y-1;
//                                                                                   }
//                                                                               }
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               if(d==30)
//                                                                               {
//                                                                                   if(m1==0)
//                                                                                   {
//                                                                                      d1=31;m1=12;y1=y-1; 
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       if(m1==6||m1==4)
//                                                                                       {
//                                                                                           d1=1;m1=m1+1;
//                                                                                       }
//                                                                                       else
//                                                                                       {
//                                                                                           if(m1==5||m1==3||m1==1)
//                                                                                           {
//                                                                                               d1=31;
//                                                                                           }
//                                                                                       }
//                                                                                   }
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   if(m1==7||m1==8||m1==10||m1==12)
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;
//                                                                                   }
//                                                                                   else
//                                                                                   {
//                                                                                       d1=1;m1=m1+1;
//                                                                                   }
//                                                                               }
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                        {     
//                                                                            m1=m-6;
//                                                                            if(m1<0)
//                                                                            {
//                                                                               d1=d+1;m1=12+m1;y1=y-1;
//                                                                            }
//                                                                            else
//                                                                            {
//                                                                                if(m1==0)
//                                                                                {
//                                                                                   d1=d+1;m1=12;y1=y-1;
//                                                                                }
//                                                                                else
//                                                                                {
//                                                                                   d1=d+1;
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                   int minidate=d1;
//                                                   int minimonth=m1;
//                                                   int miniyear=y1;
//                                                   if(complain_year==miniyear)
//                                                   {
//                                                       if(complain_month==minimonth)
//                                                       {
//                                                           if(complain_date==minidate)
//                                                           {
//                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+date_of_warranty+
//                                                                                                                           ", Expiry_month="+month_of_warranty+
//                                                                                                                           ", Expiry_year="+year_of_warranty+
//                                                                                                                           " WHERE Sno="+sno;
//                                                               st.executeUpdate(query7);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                           else
//                                                           {
//                                                               if(complain_date<expiry_date)
//                                                               {
//                                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                                   rt=st.executeQuery(query5);
//                                                                   if(rt.next())
//                                                                   {
//                                                                       int warranty_days=rt.getInt(4);
//                                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                                   ", Expiry_date="+expirydate+
//                                                                                                                                   ", Expiry_month="+expirymonth+
//                                                                                                                                   ", Expiry_year="+expiryyear+
//                                                                                                                                   " WHERE Sno="+sno;  
//                                                                       st.executeUpdate(query6);
//                                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                            " WHERE Sno="+temp; 
//                                                                       st.executeUpdate(query9);
//                                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                               ", Expiry_date="+date_of_warranty+
//                                                                                                                               ", Expiry_month="+month_of_warranty+
//                                                                                                                               ", Expiry_year="+year_of_warranty+
//                                                                                                                               " WHERE Sno="+sno;
//                                                                   st.executeUpdate(query7);
//                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                        " WHERE Sno="+temp; 
//                                                                   st.executeUpdate(query9);
//                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                }
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                          if(complain_month<expiry_month)
//                                                           {
//                                                               String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                               rt=st.executeQuery(query5);
//                                                               if(rt.next())
//                                                               {
//                                                                   int warranty_days=rt.getInt(4);
//                                                                   this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                                   String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                               ", Expiry_date="+expirydate+
//                                                                                                                               ", Expiry_month="+expirymonth+
//                                                                                                                               ", Expiry_year="+expiryyear+
//                                                                                                                               " WHERE Sno="+sno;  
//                                                                   st.executeUpdate(query6);
//                                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                        " WHERE Sno="+temp; 
//                                                                   st.executeUpdate(query9);
//                                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                                }
//                                                            }
//                                                           else
//                                                           {
//                                                               this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+date_of_warranty+
//                                                                                                                           ", Expiry_month="+month_of_warranty+
//                                                                                                                           ", Expiry_year="+year_of_warranty+
//                                                                                                                           " WHERE Sno="+sno;
//                                                               st.executeUpdate(query7);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                        }    
//                                                    }
//                                                   else
//                                                   {
//                                                       if(complain_year<expiry_year)
//                                                       {
//                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                           rt=st.executeQuery(query5);
//                                                           if(rt.next())
//                                                           {
//                                                               int warranty_days=rt.getInt(4);
//                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+expirydate+
//                                                                                                                           ", Expiry_month="+expirymonth+
//                                                                                                                           ", Expiry_year="+expiryyear+
//                                                                                                                           " WHERE Sno="+sno;  
//                                                               st.executeUpdate(query6);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                       ", Expiry_date="+date_of_warranty+
//                                                                                                                       ", Expiry_month="+month_of_warranty+
//                                                                                                                       ", Expiry_year="+year_of_warranty+
//                                                                                                                       " WHERE Sno="+sno;
//                                                           st.executeUpdate(query7);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                       else
//                                       {
//                                          JOptionPane.showMessageDialog(null, "Invalid date...");
//                                       }
//                                    }
//                                   else
//                                   {
//                                      if(installationDate==0&&installationMonth==0&&installationYear==0)
//                                        {
//                                           this.caldate(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                           this.caldate1(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()),mon+6);
//                                           this.Cal_day(WarehouseDate,WarehouseMonth,WarehouseYear,date,month,year);
//                                           String query3="UPDATE "+SpecificationNo_textfield.getText()+" SET Expiry_date="+date+
//                                                                                                    ", Expiry_month="+month+
//                                                                                                    ", Expiry_year="+year+
//                                                                                                    " WHERE Sno="+sno; 
//                                           st.executeUpdate(query3);
//                                           String query10="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                           st.executeUpdate(query10);
//                                           String query4="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                    ", Purchase_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                    ", Purchase_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                    " WHERE Sno="+sno;
//                                           st.executeUpdate(query4);
//                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                           st.executeUpdate(query9);
//                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                        }
//                                       else
//                                       {
//                                           int d=expiry_date,m=expiry_month;int y=expiry_year;int d1=0,m1=0,y1=0;
//                                           if((d>=1)&&(d<=27))
//                                           {
//                                                d1=d+1;m1=m-6;
//                                                if(m1<0)
//                                                {
//                                                    m1=12+m1;y1=y-1;
//                                                }
//                                                else
//                                                {
//                                                    if(m1==0)
//                                                    {
//                                                       m1=12;y1=y-1;
//                                                    }
//                                                }
//                                            }
//                                            else
//                                            {
//                                                if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)==0))
//                                                {
//                                                    d1=29;m1=2;
//                                                }
//                                                else
//                                                {
//                                                   if((d==30||d==28||d==29)&&(m==8)&&(((y)%4)!=0))
//                                                   {
//                                                    d1=28;m1=2;
//                                                   }
//                                                   else
//                                                   {
//                                                      if((d==31)&&(m==8)&&(((y)%4)==0))
//                                                        {
//                                                          d1=1;m1=3;
//                                                        }
//                                                        else
//                                                        {
//                                                            if((d==31)&&(m==8)&&(((y)%4)!=0))
//                                                            {
//                                                                d1=1;m1=3;
//                                                            }
//                                                            else
//                                                            {
//                                                                if(d==31||d==30)
//                                                                {
//                                                                   m1=m-6;
//                                                                   if(m1<0)
//                                                                   {
//                                                                       m1=12+m1;
//                                                                       if(d==30)
//                                                                       {
//                                                                           if(m1==9||m1==11)
//                                                                           {
//                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                              d1=31;y1=y-1;
//                                                                           }
//                                                                       }
//                                                                       else
//                                                                       {
//                                                                           if(m1==11||m1==9||m1==7)
//                                                                           {
//                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               d1=1;m1=m1+1;y1=y-1;
//                                                                           }
//                                                                       }
//                                                                   }
//                                                                   else
//                                                                   {
//                                                                       if(d==30)
//                                                                       {
//                                                                           if(m1==0)
//                                                                           {
//                                                                              d1=31;m1=12;y1=y-1; 
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               if(m1==6||m1==4)
//                                                                               {
//                                                                                   d1=1;m1=m1+1;
//                                                                               }
//                                                                               else
//                                                                               {
//                                                                                   if(m1==5||m1==3||m1==1)
//                                                                                   {
//                                                                                       d1=31;
//                                                                                   }
//                                                                               }
//                                                                           }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           if(m1==7||m1==8||m1==10||m1==12)
//                                                                           {
//                                                                               d1=1;m1=m1+1;
//                                                                           }
//                                                                           else
//                                                                           {
//                                                                               d1=1;m1=m1+1;
//                                                                           }
//                                                                       }
//                                                                    }
//                                                                }
//                                                               else
//                                                                {     
//                                                                    m1=m-6;
//                                                                    if(m1<0)
//                                                                    {
//                                                                       d1=d+1;m1=12+m1;y1=y-1;
//                                                                    }
//                                                                    else
//                                                                    {
//                                                                        if(m1==0)
//                                                                        {
//                                                                           d1=d+1;m1=12;y1=y-1;
//                                                                        }
//                                                                        else
//                                                                        {
//                                                                           d1=d+1;
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                           int minidate=d1;
//                                           int minimonth=m1;
//                                           int miniyear=y1;
//                                           if(complain_year==miniyear)
//                                           {
//                                               if(complain_month==minimonth)
//                                               {
//                                                   if(complain_date==minidate)
//                                                   {
//                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                   " WHERE Sno="+sno;
//                                                       st.executeUpdate(query7);
//                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                    " WHERE Sno="+temp; 
//                                                       st.executeUpdate(query9);
//                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                    }
//                                                   else
//                                                   {
//                                                       if(complain_date<expiry_date)
//                                                       {
//                                                           String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                           rt=st.executeQuery(query5);
//                                                           if(rt.next())
//                                                           {
//                                                               int warranty_days=rt.getInt(4);
//                                                               this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                               String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                           ", Purchase_month="+purchaseMonth+
//                                                                                                                           ", Purchase_year="+purchaseYear+
//                                                                                                                           ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                           ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                           ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                           ", Expiry_date="+expirydate+
//                                                                                                                           ", Expiry_month="+expirymonth+
//                                                                                                                           ", Expiry_year="+expiryyear+
//                                                                                                                           " WHERE Sno="+sno;  
//                                                               st.executeUpdate(query6);
//                                                               String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                    ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                    " WHERE Sno="+temp; 
//                                                               st.executeUpdate(query9);
//                                                               JOptionPane.showMessageDialog(null, "Successfully added");
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                           this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                       ", Expiry_date="+date_of_warranty+
//                                                                                                                       ", Expiry_month="+month_of_warranty+
//                                                                                                                       ", Expiry_year="+year_of_warranty+
//                                                                                                                       " WHERE Sno="+sno;
//                                                           st.executeUpdate(query7);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                        }
//                                                    }
//                                                }
//                                               else
//                                               {
//                                                  if(complain_month<expiry_month)
//                                                   {
//                                                       String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                       rt=st.executeQuery(query5);
//                                                       if(rt.next())
//                                                       {
//                                                           int warranty_days=rt.getInt(4);
//                                                           this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                           String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                       ", Purchase_month="+purchaseMonth+
//                                                                                                                       ", Purchase_year="+purchaseYear+
//                                                                                                                       ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                       ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                       ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                       ", Expiry_date="+expirydate+
//                                                                                                                       ", Expiry_month="+expirymonth+
//                                                                                                                       ", Expiry_year="+expiryyear+
//                                                                                                                       " WHERE Sno="+sno;  
//                                                           st.executeUpdate(query6);
//                                                           String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                " WHERE Sno="+temp; 
//                                                           st.executeUpdate(query9);
//                                                           JOptionPane.showMessageDialog(null, "Successfully added");
//                                                        }
//                                                    }
//                                                   else
//                                                   {
//                                                       this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                       String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                   ", Expiry_date="+date_of_warranty+
//                                                                                                                   ", Expiry_month="+month_of_warranty+
//                                                                                                                   ", Expiry_year="+year_of_warranty+
//                                                                                                                   " WHERE Sno="+sno;
//                                                       st.executeUpdate(query7);
//                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+temp; 
//                                                       st.executeUpdate(query9);
//                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                    }
//                                                }    
//                                            }
//                                           else
//                                           {
//                                               if(complain_year<expiry_year)
//                                               {
//                                                   String query5="SELECT * FROM Type_of_warranty WHERE Tid='"+SpecificationNo_textfield.getText()+"'";
//                                                   rt=st.executeQuery(query5);
//                                                   if(rt.next())
//                                                   {
//                                                       int warranty_days=rt.getInt(4);
//                                                       this.Cal_left(warranty_days,Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                       String query6="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                                   ", Purchase_month="+purchaseMonth+
//                                                                                                                   ", Purchase_year="+purchaseYear+
//                                                                                                                   ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                                   ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                                   ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                                   ", Expiry_date="+expirydate+
//                                                                                                                   ", Expiry_month="+expirymonth+
//                                                                                                                   ", Expiry_year="+expiryyear+
//                                                                                                                   " WHERE Sno="+sno;  
//                                                       st.executeUpdate(query6);
//                                                       String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                            ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                            ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                            " WHERE Sno="+temp; 
//                                                       st.executeUpdate(query9);
//                                                       JOptionPane.showMessageDialog(null, "Successfully added");
//                                                    }
//                                                }
//                                               else
//                                               {
//                                                   this.caldate11(Integer.parseInt(Date_of_reinstallation.getText()),Integer.parseInt(Month_of_reinstallation.getText()),Integer.parseInt(Year_of_reinstallation.getText()));
//                                                   String query7="UPDATE "+SpecificationNo_textfield.getText()+" SET Purchase_date="+purchaseDate+
//                                                                                                               ", Purchase_month="+purchaseMonth+
//                                                                                                               ", Purchase_year="+purchaseYear+
//                                                                                                               ", Installation_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                               ", Installation_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                               ", Installation_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                               ", Expiry_date="+date_of_warranty+
//                                                                                                               ", Expiry_month="+month_of_warranty+
//                                                                                                               ", Expiry_year="+year_of_warranty+
//                                                                                                               " WHERE Sno="+sno;
//                                                   st.executeUpdate(query7);
//                                                   String query9="UPDATE "+SpecificationNo_textfield.getText()+" SET Re_install_date="+Integer.parseInt(Date_of_reinstallation.getText())+
//                                                                                                        ", Re_install_month="+Integer.parseInt(Month_of_reinstallation.getText())+
//                                                                                                        ", Re_install_year="+Integer.parseInt(Year_of_reinstallation.getText())+
//                                                                                                        " WHERE Sno="+temp; 
//                                                   st.executeUpdate(query9);
//                                                   JOptionPane.showMessageDialog(null, "Successfully added");
//                                                }
//                                            }
//                                        }
//                                    }
                                }
                               else
                               {
                                  JOptionPane.showMessageDialog(null, "Re-installation Date already exist");
                               }
                           }
                       }
                    }
                }
               else
               {
                   JOptionPane.showMessageDialog(null,"PO_No Doesn't match");
               }
            }
           else
           {
              JOptionPane.showMessageDialog(null,"Transformer ID doesn't exist"); 
           }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }}
        else{
            PopUp pop = new PopUp();
            pop.setMessagelabel("Invalid Date");
            pop.setVisible(true);
        }
    }//GEN-LAST:event_NextButtonMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel CancelButton;
    private javax.swing.JLabel CloseButton;
    private javax.swing.JLabel DateOfReinstallation;
    private javax.swing.JLabel Date_of_installation_textbox;
    private javax.swing.JTextField Date_of_reinstallation;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField Month_of_reinstallation;
    private javax.swing.JLabel Month_of_reinstallation_textbox;
    private javax.swing.JLabel NextButton;
    private javax.swing.JLabel PO_No_Textbox;
    private javax.swing.JTextField PO_No_textfield;
    private javax.swing.JLabel Po_No;
    private javax.swing.JLabel Reinstallation_date;
    private javax.swing.JLabel Reinstallation_logo;
    private javax.swing.JTextField SpecificationNo_textfield;
    private javax.swing.JLabel Specification_Textbox;
    private javax.swing.JLabel Specification_no;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Titlebar;
    private javax.swing.JTextField Year_of_reinstallation;
    private javax.swing.JLabel Year_of_reinstallation_textbox;
    private javax.swing.JLabel dash1;
    private javax.swing.JLabel dash2;
    // End of variables declaration//GEN-END:variables
}
