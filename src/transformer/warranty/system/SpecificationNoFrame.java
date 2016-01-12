/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Popup;

/**
 *
 * @author Jatin
 */
public class SpecificationNoFrame extends javax.swing.JFrame {
static Connection con;Statement st;ResultSet rt;
    static int date_of_warehouse,month_of_warehouse,year_of_warehouse,DWare;
    static int date_of_warranty,month_of_warranty,year_of_warranty,DTW;   
    static int date_of_expiry,month_of_expiry,year_of_expiry; 
    static int date1,month1,year1;
    String po_no; String item;
    String buyer; String department; String price;
    String date; String month; String year;
    String warrantymonth;
    String warehousemonth;
    /**
     * Creates new form SpecificationNoFrame
     */
    public SpecificationNoFrame(String po_no1, String item1,String buyer1, String department1, String price1,String date1, String month1, String year1, String warrantymonth1, String warehousemonth1) {
        initComponents();
        PopUp pop = new PopUp();
        SQLConnect sqlcon =new SQLConnect();
        con = sqlcon.sqlCon(con);
        try{
            st = con.createStatement();
        }
        catch(Exception e){
           pop.setMessagelabel("Connection Failed");
        }
        po_no = po_no1; item=item1; buyer =buyer1;
        department = department1; price = price1;
        date = date1; month = month1; year = year1;
        warrantymonth = warrantymonth1;
        warehousemonth = warehousemonth1;
        //System.out.println(po_no);
        //System.out.println(price);
        //System.out.println(date);

    }
    
    public void caldate(int d,int m,int y)
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
        date_of_warehouse=d1;month_of_warehouse=m1;year_of_warehouse=y1;
    }
   public void Cal_day(int d1,int m1,int y1,int d2,int m2,int y2)
    {
        int j=d1;
        int i=m1,d = 0,k,r;
       // int a=m2;
      
       if(i==m2&&y1==y2)
       {
           d=d2-d1;
           DWare=d;
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
          DWare=d;
        }
    }
   public void Cal_day1(int d1,int m1,int y1,int d2,int m2,int y2)
    {
        int j=d1;
        int i=m1,d = 0,k,r;
       // int a=m2;
      
       if(i==m2&&y1==y2)
       {
           d=d2-d1;
           DTW=d;
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
          DTW=d;
        }
    }
    public void caldate1(int d,int m,int y,int mtw)
    {
        int d1=0,m1 = 0,y1 = y;
        if((d>1)&&(d<=31))
        {
            d1=d-1;
            m1=m;y1=y1+(mtw/12);
        }
         else
        {
            if(d==1)
           {
               while(mtw!=0)
               {
                   if((mtw/12)!=1)
                   {
                       d1=d;m1=m;y1=y1+1;mtw=mtw-12;
                   }
                   else
                   {
                       if(m1==1||m1==2||m1==3||m1==4||m1==6||m1==8||m1==9||m1==11)
                       {
                           if(m1==3&&(((y1+1)%4)==0))
                           {
                               d1=29;m1=2;y1=y1+1;
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
                       mtw=0;
                   }
               }
           }    
        }
        date_of_warranty=d1;month_of_warranty=m1;year_of_warranty=y1; 
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
        date_of_expiry=d1;month_of_expiry=k;year_of_expiry=y;
    }
   void Cal_left1(int d,int d1,int m,int y)
    {
       int k=m,a=d1;
       if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
       {
           a=31-a;
           if(a<d)
           {
               if(a==0)
               {
                   d1=1;m++;d=0;
               }
               else
               {
                    d=d-a-1;m++;
               }  
            }
           else
           {
               if(d==1)
               {
                   d=a-d;
                   d1=31-d;
                   d=0;
                }
               else
               {
                   d=a-d;
                   d1=31-d-1;
                   d=0; 
                }
            }
        }
       else
       {
           if(k==2)
           {
               if(y%4==0)
               {
                   a=29-a;
                   if(a<d)
                   {
                      if(a==0)
                       {
                           d1=1;m++;d=0;
                       }
                       else
                       {
                            d=d-a-1;m++;
                       }  
                    }
                   else
                   {
                      if(d==1)
                       {
                           d=a-d;
                           d1=29-d;
                           d=0;
                       }
                       else
                       {
                           d=a-d;
                           d1=29-d-1;
                           d=0; 
                       }
                    } 
               }
               else
               {
                   a=28-a;
                   if(a<d)
                   {
                      if(a==0)
                       {
                           d1=1;m++;d=0;
                       }
                       else
                       {
                            d=d-a-1;m++;
                       }
                    }
                   else
                   {
                      if(d==1)
                       {
                           d=a-d;
                           d1=28-d;
                           d=0;
                       }
                       else
                       {
                           d=a-d;
                           d1=28-d-1;
                           d=0; 
                       }
                    }
               }
            }
           else
           {
               a=30-a;
               if(a<d)
               {
                  if(a==0)
                   {
                       d1=1;m++;d=0;
                    }
                   else
                   {
                        d=d-a-1;m++;
                    }  
               }
               else
               {
                  if(d==1)
                   {
                       d=a-d;
                       d1=30-d;
                       d=0;
                   }
                   else
                   {
                       d=a-d;
                       d1=30-d-1;
                       d=0; 
                    }
                }
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
        date1=d1;month1=k;year1=y;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SpecificationNo = new javax.swing.JLabel();
        SpecficationNoTextField = new javax.swing.JTextField();
        SpecificationEditTxt1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        okbtn = new javax.swing.JLabel();
        Astrisk3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(340, 200));
        setMinimumSize(new java.awt.Dimension(340, 200));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(340, 200));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        SpecificationNo.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        SpecificationNo.setForeground(new java.awt.Color(153, 0, 153));
        SpecificationNo.setText("Specification No.");
        getContentPane().add(SpecificationNo);
        SpecificationNo.setBounds(20, 80, 116, 18);

        SpecficationNoTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        SpecficationNoTextField.setToolTipText("Type the ID");
        SpecficationNoTextField.setBorder(null);
        SpecficationNoTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        SpecficationNoTextField.setDragEnabled(true);
        SpecficationNoTextField.setMaximumSize(new java.awt.Dimension(152, 16));
        SpecficationNoTextField.setMinimumSize(new java.awt.Dimension(152, 16));
        SpecficationNoTextField.setPreferredSize(new java.awt.Dimension(152, 16));
        SpecficationNoTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        SpecficationNoTextField.setSelectionEnd(6);
        SpecficationNoTextField.setSelectionStart(6);
        SpecficationNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecficationNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(SpecficationNoTextField);
        SpecficationNoTextField.setBounds(164, 82, 152, 16);

        SpecificationEditTxt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        SpecificationEditTxt1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(SpecificationEditTxt1);
        SpecificationEditTxt1.setBounds(160, 80, 160, 21);

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 153));
        jLabel7.setText("Enter Specification No.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 40, 175, 19);

        okbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Ok_button.png"))); // NOI18N
        okbtn.setToolTipText("");
        okbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okbtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                okbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                okbtnMouseReleased(evt);
            }
        });
        getContentPane().add(okbtn);
        okbtn.setBounds(285, 140, 35, 25);

        Astrisk3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk3.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk3.setText("*");
        getContentPane().add(Astrisk3);
        Astrisk3.setBounds(135, 78, 10, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Taskbar1_1.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(340, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(340, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(340, 20));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 340, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/boundary.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 3, 200);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Horizontal_boundary.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 197, 340, 3);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/boundary.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(337, 0, 3, 200);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/login_pass.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(340, 200));
        jLabel2.setMinimumSize(new java.awt.Dimension(340, 200));
        jLabel2.setPreferredSize(new java.awt.Dimension(340, 200));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 340, 200);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SpecficationNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecficationNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecficationNoTextFieldActionPerformed

    private void okbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okbtnMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("OK_button_hover.png"));
       okbtn.setIcon(ISB);
    }//GEN-LAST:event_okbtnMouseEntered

    private void okbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okbtnMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("OK_button.png"));
       okbtn.setIcon(ISB);
    }//GEN-LAST:event_okbtnMouseExited

    private void okbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okbtnMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("OK_button_pressed.png"));
       okbtn.setIcon(ISB);
       int date2 = Integer.parseInt(date);
       int month2 = Integer.parseInt(month);
       int year2 = Integer.parseInt(year);
       int warrantymonth2 = Integer.parseInt(warrantymonth);
       int warehousemonth2 = Integer.parseInt(warehousemonth);
       double price2 = Double.parseDouble(price);
      
       try
             {
              date_of_warehouse=0;month_of_warehouse=0;year_of_warehouse=0;DWare=0;
              date_of_warranty=0;month_of_warranty=0;year_of_warranty=0;DTW=0;
              //JOptionPane.showMessageDialog(null, "Success");
              st.executeUpdate("INSERT INTO Transf_Details VALUES('"+SpecficationNoTextField.getText() +"'," +date2+"," +month2+ ","+year2+ ",'" + po_no+ "','" + buyer+ "','" + item+ "','"+department+"'," + price2+","+ warrantymonth2+","+ warehousemonth2+","+null+","+null+","+null+")");
              
//int Date_of_purchase=Integer.parseInt(DateTextField.getText());
             // int Month_of_purchase=Integer.parseInt(MonthTextField.getText());
              //int Year_of_purchase=Integer.parseInt(YearTextField.getText());
             // int warranty=Integer.parseInt(WarrantyMonth.getText());
              this.caldate(date2,month2,year2);
              this.Cal_day(date2,month2,year2,date_of_warehouse,month_of_warehouse,year_of_warehouse);
              caldate1(date_of_warehouse,month_of_warehouse,year_of_warehouse,warrantymonth2);
              this.Cal_day1(date_of_warehouse,month_of_warehouse,year_of_warehouse,date_of_warranty,month_of_warranty,year_of_warranty);
              st.executeUpdate("INSERT INTO Type_of_warranty VALUES('"+SpecficationNoTextField.getText() +"'," +warrantymonth2+"," + warehousemonth2+ ","+ DTW+ ","+ DWare+ ")");
              String query = "CREATE TABLE "+SpecficationNoTextField.getText()+
                                  "(Sno INTEGER NOT NULL,"+
                                  "Purchase_date INTEGER NULL,"+
                                  "Purchase_month INTEGER NULL,"+
                                  "Purchase_year INTEGER NULL,"+
                                  "Installation_date INTEGER NULL,"+
                                  "Installation_month INTEGER NULL,"+
                                  "Installation_year INTEGER NULL,"+
                                  "Complain_date INTEGER NULL,"+
                                  "Complain_month INTEGER NULL,"+
                                  "Complain_year INTEGER NULL,"+
                                  "Re_install_date INTEGER NULL,"+
                                  "Re_install_month INTEGER NULL,"+
                                  "Re_install_year INTEGER NULL,"+
                                  "Expiry_date INTEGER NULL,"+
                                  "Expiry_month INTEGER NULL,"+
                                  "Expiry_year INTEGER NULL,"+
                                  "Details VARCHAR(70) NULL,"+
                                  "PRIMARY KEY(Sno))";
              st.executeUpdate(query);
              rt=st.executeQuery("SELECT * FROM Type_of_warranty WHERE Tid='"+SpecficationNoTextField.getText()+"'");
              if(rt.next())
              {
              int Warranty_Days=rt.getInt(4)+1;
              int Warehouse_Days=rt.getInt(5);
              this.Cal_left(Warehouse_Days,date2,month2,year2);
              this.Cal_left(Warranty_Days,date_of_expiry,month_of_expiry,year_of_expiry);
              int sno=1;
              String query1="INSERT INTO "+SpecficationNoTextField.getText()+" VALUES("
                                          +sno+","
                                          + date2+","
                                          + month2+ ","
                                          + year2+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +null+","
                                          +date_of_expiry+","
                                          +month_of_expiry+"," 
                                          +year_of_expiry+","
                                          +null+")";
              st.executeUpdate(query1);
              JOptionPane.showMessageDialog(null,"Successfully added");
              this.dispose();
              }
             }catch(Exception e)
             {
                 System.out.println(e);
             } 
      try{
           st.executeUpdate("INSERT INTO historyinsert VALUES('"+SpecficationNoTextField.getText()+"')");
           
       }
       catch(Exception e1){
           PopUp pop = new PopUp();
           pop.setMessagelabel("Error");
           pop.setVisible(true);
       }
    }//GEN-LAST:event_okbtnMousePressed

    private void okbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okbtnMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("OK_button_hover.png"));
       okbtn.setIcon(ISB);
    }//GEN-LAST:event_okbtnMouseReleased

    private void okbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okbtnMouseClicked
         
    }//GEN-LAST:event_okbtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpecificationNoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpecificationNoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpecificationNoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpecificationNoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SpecificationNoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Astrisk3;
    private javax.swing.JTextField SpecficationNoTextField;
    private javax.swing.JLabel SpecificationEditTxt1;
    private javax.swing.JLabel SpecificationNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel okbtn;
    // End of variables declaration//GEN-END:variables
}
