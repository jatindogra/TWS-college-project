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
public class InstallationFrame extends javax.swing.JFrame {
    Statement st,st1;ResultSet rt,rt1,rt2; 
    static int WarehouseDate,WarehouseMonth,WarehouseYear,expirydate,expirymonth,expiryyear,date,month,year,days,sno;
    public InstallationFrame(Connection con) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("Logo4.png")).getImage());
        SQLConnect sqlcon = new SQLConnect();
        con=sqlcon.sqlCon(con);
         /*try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
         }*/
//         try {
//             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transrec","Anugrah", "7837");
//         } catch (SQLException ex) {
//             Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
//         }
         try {            
             st=con.createStatement();
            // st1=con.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

//    InstallationFrame(Connection con) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
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
       date=d1;month=m1;year=y1;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SpecificationTextField = new javax.swing.JTextField();
        Po_NoTextfield = new javax.swing.JTextField();
        Date_of_installationTextfield = new javax.swing.JTextField();
        Month_of_installationTextField = new javax.swing.JTextField();
        Year_of_installationTextfield = new javax.swing.JTextField();
        CloseButton = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Installation_Date = new javax.swing.JLabel();
        Specification_Number = new javax.swing.JLabel();
        PO_Number = new javax.swing.JLabel();
        Date_of_installation = new javax.swing.JLabel();
        SpecificationNumberTextBox = new javax.swing.JLabel();
        PoNumberTextBox = new javax.swing.JLabel();
        DateOfInstallationTextBox = new javax.swing.JLabel();
        dash1 = new javax.swing.JLabel();
        MonthOfInstallationTextBox = new javax.swing.JLabel();
        dash2 = new javax.swing.JLabel();
        YearOfInstallationTextBox = new javax.swing.JLabel();
        NextButton = new javax.swing.JLabel();
        CancelButton = new javax.swing.JLabel();
        Installation_date_logo = new javax.swing.JLabel();
        Title_Bar = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 420));
        setUndecorated(true);
        getContentPane().setLayout(null);

        SpecificationTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        SpecificationTextField.setBorder(null);
        getContentPane().add(SpecificationTextField);
        SpecificationTextField.setBounds(332, 154, 157, 16);

        Po_NoTextfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Po_NoTextfield.setBorder(null);
        getContentPane().add(Po_NoTextfield);
        Po_NoTextfield.setBounds(332, 209, 157, 16);

        Date_of_installationTextfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Date_of_installationTextfield.setBorder(null);
        getContentPane().add(Date_of_installationTextfield);
        Date_of_installationTextfield.setBounds(333, 263, 20, 17);

        Month_of_installationTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Month_of_installationTextField.setBorder(null);
        getContentPane().add(Month_of_installationTextField);
        Month_of_installationTextField.setBounds(371, 263, 20, 17);

        Year_of_installationTextfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Year_of_installationTextfield.setBorder(null);
        getContentPane().add(Year_of_installationTextfield);
        Year_of_installationTextfield.setBounds(410, 262, 34, 17);

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
        Title.setText("Transformer Installation ");
        getContentPane().add(Title);
        Title.setBounds(260, 5, 161, 17);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Logo.png"))); // NOI18N
        getContentPane().add(Logo);
        Logo.setBounds(4, 0, 25, 25);

        Installation_Date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Installation_Date.setForeground(new java.awt.Color(153, 0, 153));
        Installation_Date.setText("Installation Date");
        getContentPane().add(Installation_Date);
        Installation_Date.setBounds(80, 60, 200, 30);

        Specification_Number.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Specification_Number.setForeground(new java.awt.Color(153, 0, 153));
        Specification_Number.setText("Specification Number");
        getContentPane().add(Specification_Number);
        Specification_Number.setBounds(150, 155, 150, 18);

        PO_Number.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        PO_Number.setForeground(new java.awt.Color(153, 0, 153));
        PO_Number.setText("PO Number");
        getContentPane().add(PO_Number);
        PO_Number.setBounds(150, 210, 83, 18);

        Date_of_installation.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Date_of_installation.setForeground(new java.awt.Color(153, 0, 153));
        Date_of_installation.setText("Date of Installation");
        getContentPane().add(Date_of_installation);
        Date_of_installation.setBounds(150, 265, 130, 18);

        SpecificationNumberTextBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        getContentPane().add(SpecificationNumberTextBox);
        SpecificationNumberTextBox.setBounds(330, 150, 160, 21);

        PoNumberTextBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        getContentPane().add(PoNumberTextBox);
        PoNumberTextBox.setBounds(330, 205, 160, 21);

        DateOfInstallationTextBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        getContentPane().add(DateOfInstallationTextBox);
        DateOfInstallationTextBox.setBounds(330, 260, 27, 21);

        dash1.setText("-");
        getContentPane().add(dash1);
        dash1.setBounds(360, 264, 7, 14);

        MonthOfInstallationTextBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        getContentPane().add(MonthOfInstallationTextBox);
        MonthOfInstallationTextBox.setBounds(368, 260, 27, 21);

        dash2.setText("-");
        getContentPane().add(dash2);
        dash2.setBounds(397, 264, 7, 14);

        YearOfInstallationTextBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/year.png"))); // NOI18N
        getContentPane().add(YearOfInstallationTextBox);
        YearOfInstallationTextBox.setBounds(406, 260, 43, 21);

        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NextButton_default1.png"))); // NOI18N
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

        Installation_date_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Installation_icon.png"))); // NOI18N
        getContentPane().add(Installation_date_logo);
        Installation_date_logo.setBounds(30, 50, 40, 40);

        Title_Bar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Installation_Taskbar.png"))); // NOI18N
        getContentPane().add(Title_Bar);
        Title_Bar.setBounds(0, 0, 650, 25);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/InstallationBackkground.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 650, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
       this.dispose();
    }//GEN-LAST:event_CloseButtonMouseClicked

    private void NextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseClicked
         ValidateInput valip2 = new ValidateInput();
        String d = Date_of_installationTextfield.getText();
        String m2 = Month_of_installationTextField.getText();
        String y = Year_of_installationTextfield.getText();
        boolean b =valip2.datecheck2(d, m2, y);
        if(b==true){
        try
        {
           String update="SELECT * FROM Transf_Details WHERE Tid='"+SpecificationTextField.getText()+"'";
           rt=st.executeQuery(update);
           if(rt.next())
           {
               String Po_No2=Po_NoTextfield.getText();
               String Po_No1=rt.getString(5);
               if(Po_No1.equals(Po_No2))
               {
                   int DOI=rt.getInt(12);
                   int MOI=rt.getInt(13);
                   int YOI=rt.getInt(14);
                   if((DOI==0)&&(MOI==0)&&(YOI==0))
                   {
                       String query6="SELECT max(Sno) FROM "+SpecificationTextField.getText();
                       rt=st.executeQuery(query6);
                       if(rt.next())
                       {
                           sno=rt.getInt(1);
                           String query7="SELECT * FROM "+SpecificationTextField.getText()+" WHERE Sno="+sno;
                           rt=st.executeQuery(query7);
                           if(rt.next())
                           {
                           int checkdate=rt.getInt(14);
                           int checkmonth=rt.getInt(15);
                           int checkyear=rt.getInt(16);
                           int purchaseDate=rt.getInt(2);
                           int purchaseMonth=rt.getInt(3);
                           int purchaseYear=rt.getInt(4);
                           int installationDate=Integer.parseInt(Date_of_installationTextfield.getText());
                           int installationMonth=Integer.parseInt(Month_of_installationTextField.getText());
                           int installationYear=Integer.parseInt(Year_of_installationTextfield.getText());
                           if(installationYear==purchaseYear)
                           {
                               if(installationMonth==purchaseMonth)
                               {
                                   if(installationDate==purchaseDate)
                                   {
                                      JOptionPane.showMessageDialog(null,"Invalid Installaton date"); 
                                   }
                                   else
                                   {
                                       if(installationDate<purchaseDate)
                                       {
                                           JOptionPane.showMessageDialog(null,"Invalid Installaton date");
                                       }
                                       else
                                       {
                                           if(installationYear==checkyear)
                                           {
                                               if(installationMonth==checkmonth)
                                               {
                                                   if(installationDate==checkdate)
                                                   {
                                                       String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                       ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                       ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                       " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query);
                                                       this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                       if(installationYear==WarehouseYear)
                                                       {
                                                           if(installationMonth==WarehouseMonth)
                                                           {
                                                               if(installationDate==WarehouseDate)
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                               else
                                                               {
                                                                   if(installationDate<WarehouseDate)
                                                                   {
                                                                       expirydate=installationDate; 
                                                                       expirymonth=installationMonth;
                                                                       expiryyear=installationYear;
                                                                   }
                                                                   else
                                                                   {
                                                                       expirydate=WarehouseDate; 
                                                                       expirymonth=WarehouseMonth;
                                                                       expiryyear=WarehouseYear;
                                                                   }
                                                               }
                                                           }
                                                           else
                                                           {
                                                               if(installationMonth<WarehouseMonth)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationYear<WarehouseYear)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                       String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       rt=st.executeQuery(query4);
                                                       if(rt.next())
                                                       {
                                                           int m=rt.getInt(10);
                                                           this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                           String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                 ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                 ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                 ", Expiry_date="+date+
                                                                                 ", Expiry_month="+month+
                                                                                 ", Expiry_year="+year+
                                                                                 " WHERE Sno="+sno;
                                                           st.executeUpdate(query1);
                                                           this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                           String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                           st.executeUpdate(query5);
                                                           JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                        }   
                                                    }
                                                   else
                                                   {
                                                       if(installationDate<checkdate)
                                                       {
                                                           String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                       ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                       ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                       " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                           st.executeUpdate(query);
                                                           this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                           if(installationYear==WarehouseYear)
                                                           {
                                                               if(installationMonth==WarehouseMonth)
                                                               {
                                                                   if(installationDate==WarehouseDate)
                                                                   {
                                                                       expirydate=WarehouseDate; 
                                                                       expirymonth=WarehouseMonth;
                                                                       expiryyear=WarehouseYear;
                                                                   }
                                                                   else
                                                                   {
                                                                       if(installationDate<WarehouseDate)
                                                                       {
                                                                           expirydate=installationDate; 
                                                                           expirymonth=installationMonth;
                                                                           expiryyear=installationYear;
                                                                       }
                                                                       else
                                                                       {
                                                                           expirydate=WarehouseDate; 
                                                                           expirymonth=WarehouseMonth;
                                                                           expiryyear=WarehouseYear;
                                                                       }
                                                                   }
                                                               }
                                                               else
                                                               {
                                                                   if(installationMonth<WarehouseMonth)
                                                                   {
                                                                       expirydate=installationDate; 
                                                                       expirymonth=installationMonth;
                                                                       expiryyear=installationYear;
                                                                   }
                                                                   else
                                                                   {
                                                                       expirydate=WarehouseDate; 
                                                                       expirymonth=WarehouseMonth;
                                                                       expiryyear=WarehouseYear;
                                                                   }
                                                               }
                                                           }
                                                           else
                                                           {
                                                               if(installationYear<WarehouseYear)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                           String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                           rt=st.executeQuery(query4);
                                                           if(rt.next())
                                                           {
                                                               int m=rt.getInt(10);
                                                               this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                               String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                     ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                     ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                     ", Expiry_date="+date+
                                                                                     ", Expiry_month="+month+
                                                                                     ", Expiry_year="+year+
                                                                                     " WHERE Sno="+sno;
                                                               st.executeUpdate(query1);
                                                               this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                               String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                               st.executeUpdate(query5);
                                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                            } 
                                                       }
                                                       else
                                                       {
                                                           JOptionPane.showMessageDialog(null,"Warranty Expired");
                                                       }
                                                   }
                                               }
                                               else
                                               {
                                                   if(installationMonth<checkmonth)
                                                   {
                                                       String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                       ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                       ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                       " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query);
                                                       this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                       if(installationYear==WarehouseYear)
                                                       {
                                                           if(installationMonth==WarehouseMonth)
                                                           {
                                                               if(installationDate==WarehouseDate)
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                               else
                                                               {
                                                                   if(installationDate<WarehouseDate)
                                                                   {
                                                                       expirydate=installationDate; 
                                                                       expirymonth=installationMonth;
                                                                       expiryyear=installationYear;
                                                                   }
                                                                   else
                                                                   {
                                                                       expirydate=WarehouseDate; 
                                                                       expirymonth=WarehouseMonth;
                                                                       expiryyear=WarehouseYear;
                                                                   }
                                                               }
                                                           }
                                                           else
                                                           {
                                                               if(installationMonth<WarehouseMonth)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationYear<WarehouseYear)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                       String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       rt=st.executeQuery(query4);
                                                       if(rt.next())
                                                       {
                                                           int m=rt.getInt(10);
                                                           this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                           String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                 ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                 ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                 ", Expiry_date="+date+
                                                                                 ", Expiry_month="+month+
                                                                                 ", Expiry_year="+year+
                                                                                 " WHERE Sno="+sno;
                                                           st.executeUpdate(query1);
                                                           this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                           String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                           st.executeUpdate(query5);
                                                           JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                        } 
                                                   }
                                                   else
                                                   {
                                                       JOptionPane.showMessageDialog(null,"Warranty Expired");
                                                   }
                                               }
                                           }
                                           else
                                           {
                                               if(installationYear<checkyear)
                                               {
                                                   String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                       ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                       ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                       " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query);
                                                   this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                   if(installationYear==WarehouseYear)
                                                   {
                                                       if(installationMonth==WarehouseMonth)
                                                       {
                                                           if(installationDate==WarehouseDate)
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                           else
                                                           {
                                                               if(installationDate<WarehouseDate)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationMonth<WarehouseMonth)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationYear<WarehouseYear)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   rt=st.executeQuery(query4);
                                                   if(rt.next())
                                                   {
                                                       int m=rt.getInt(10);
                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                             ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                             ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                             ", Expiry_date="+date+
                                                                             ", Expiry_month="+month+
                                                                             ", Expiry_year="+year+
                                                                             " WHERE Sno="+sno;
                                                       st.executeUpdate(query1);
                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query5);
                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                    } 
                                                }
                                               else
                                               {
                                                   JOptionPane.showMessageDialog(null,"Warranty Expired");
                                               }
                                           }
                                       }
                                   }
                               }
                               else
                               {
                                   if(installationMonth<purchaseMonth)
                                   {
                                       JOptionPane.showMessageDialog(null,"Invalid Installaton date");
                                   }
                                   else
                                   {
                                       if(installationYear==checkyear)
                                       {
                                           if(installationMonth==checkmonth)
                                           {
                                               if(installationDate==checkdate)
                                               {
                                                   String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                   ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                   ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                   " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query);
                                                   this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                   if(installationYear==WarehouseYear)
                                                   {
                                                       if(installationMonth==WarehouseMonth)
                                                       {
                                                           if(installationDate==WarehouseDate)
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                           else
                                                           {
                                                               if(installationDate<WarehouseDate)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationMonth<WarehouseMonth)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationYear<WarehouseYear)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   rt=st.executeQuery(query4);
                                                   if(rt.next())
                                                   {
                                                       int m=rt.getInt(10);
                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                             ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                             ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                             ", Expiry_date="+date+
                                                                             ", Expiry_month="+month+
                                                                             ", Expiry_year="+year+
                                                                             " WHERE Sno="+sno;
                                                       st.executeUpdate(query1);
                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query5);
                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                    }   
                                               }
                                               else
                                               {
                                                   if(installationDate<checkdate)
                                                   {
                                                       String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                   ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                   ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                   " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query);
                                                       this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                       if(installationYear==WarehouseYear)
                                                       {
                                                           if(installationMonth==WarehouseMonth)
                                                           {
                                                               if(installationDate==WarehouseDate)
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                               else
                                                               {
                                                                   if(installationDate<WarehouseDate)
                                                                   {
                                                                       expirydate=installationDate; 
                                                                       expirymonth=installationMonth;
                                                                       expiryyear=installationYear;
                                                                   }
                                                                   else
                                                                   {
                                                                       expirydate=WarehouseDate; 
                                                                       expirymonth=WarehouseMonth;
                                                                       expiryyear=WarehouseYear;
                                                                   }
                                                               }
                                                           }
                                                           else
                                                           {
                                                               if(installationMonth<WarehouseMonth)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationYear<WarehouseYear)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                       String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       rt=st.executeQuery(query4);
                                                       if(rt.next())
                                                       {
                                                           int m=rt.getInt(10);
                                                           this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                           String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                 ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                 ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                 ", Expiry_date="+date+
                                                                                 ", Expiry_month="+month+
                                                                                 ", Expiry_year="+year+
                                                                                 " WHERE Sno="+sno;
                                                           st.executeUpdate(query1);
                                                           this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                           String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                           st.executeUpdate(query5);
                                                           JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                        } 
                                                   }
                                                   else
                                                   {
                                                       JOptionPane.showMessageDialog(null,"Warranty Expired");
                                                   }
                                               }
                                           }
                                           else
                                           {
                                               if(installationMonth<checkmonth)
                                               {
                                                   String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                   ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                   ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                   " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query);
                                                   this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                   if(installationYear==WarehouseYear)
                                                   {
                                                       if(installationMonth==WarehouseMonth)
                                                       {
                                                           if(installationDate==WarehouseDate)
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                           else
                                                           {
                                                               if(installationDate<WarehouseDate)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationMonth<WarehouseMonth)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationYear<WarehouseYear)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   rt=st.executeQuery(query4);
                                                   if(rt.next())
                                                   {
                                                       int m=rt.getInt(10);
                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                             ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                             ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                             ", Expiry_date="+date+
                                                                             ", Expiry_month="+month+
                                                                             ", Expiry_year="+year+
                                                                             " WHERE Sno="+sno;
                                                       st.executeUpdate(query1);
                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query5);
                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                    } 
                                               }
                                               else
                                               {
                                                   JOptionPane.showMessageDialog(null,"Warranty Expired");
                                               }
                                           }
                                       }
                                       else
                                       {
                                           if(installationYear<checkyear)
                                           {
                                               String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                                   ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                                   ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                                   " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               st.executeUpdate(query);
                                               this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                               if(installationYear==WarehouseYear)
                                               {
                                                   if(installationMonth==WarehouseMonth)
                                                   {
                                                       if(installationDate==WarehouseDate)
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                       else
                                                       {
                                                           if(installationDate<WarehouseDate)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationMonth<WarehouseMonth)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                               }
                                               else
                                               {
                                                   if(installationYear<WarehouseYear)
                                                   {
                                                       expirydate=installationDate; 
                                                       expirymonth=installationMonth;
                                                       expiryyear=installationYear;
                                                   }
                                                   else
                                                   {
                                                       expirydate=WarehouseDate; 
                                                       expirymonth=WarehouseMonth;
                                                       expiryyear=WarehouseYear;
                                                   }
                                               }
                                               String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               rt=st.executeQuery(query4);
                                               if(rt.next())
                                               {
                                                   int m=rt.getInt(10);
                                                   this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                   String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                         ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                         ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                         ", Expiry_date="+date+
                                                                         ", Expiry_month="+month+
                                                                         ", Expiry_year="+year+
                                                                         " WHERE Sno="+sno;
                                                   st.executeUpdate(query1);
                                                   this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                   String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query5);
                                                   JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                } 
                                            }
                                           else
                                           {
                                               JOptionPane.showMessageDialog(null,"Warranty Expired");
                                           }
                                       }
                                   }
                               }
                           }
                           else
                           {
                               if(installationYear<purchaseYear)
                               {
                                   JOptionPane.showMessageDialog(null,"Invalid Installaton date");
                               }
                               else
                               {
                                   if(installationYear==checkyear)
                                   {
                                       if(installationMonth==checkmonth)
                                       {
                                           if(installationDate==checkdate)
                                           {
                                               String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                               ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                               ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                               " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               st.executeUpdate(query);
                                               this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                               if(installationYear==WarehouseYear)
                                               {
                                                   if(installationMonth==WarehouseMonth)
                                                   {
                                                       if(installationDate==WarehouseDate)
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                       else
                                                       {
                                                           if(installationDate<WarehouseDate)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationMonth<WarehouseMonth)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                               }
                                               else
                                               {
                                                   if(installationYear<WarehouseYear)
                                                   {
                                                       expirydate=installationDate; 
                                                       expirymonth=installationMonth;
                                                       expiryyear=installationYear;
                                                   }
                                                   else
                                                   {
                                                       expirydate=WarehouseDate; 
                                                       expirymonth=WarehouseMonth;
                                                       expiryyear=WarehouseYear;
                                                   }
                                               }
                                               String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               rt=st.executeQuery(query4);
                                               if(rt.next())
                                               {
                                                   int m=rt.getInt(10);
                                                   this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                   String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                         ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                         ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                         ", Expiry_date="+date+
                                                                         ", Expiry_month="+month+
                                                                         ", Expiry_year="+year+
                                                                         " WHERE Sno="+sno;
                                                   st.executeUpdate(query1);
                                                   this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                   String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query5);
                                                   JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                }   
                                           }
                                           else
                                           {
                                               if(installationDate<checkdate)
                                               {
                                                   String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                               ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                               ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                               " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query);
                                                   this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                                   if(installationYear==WarehouseYear)
                                                   {
                                                       if(installationMonth==WarehouseMonth)
                                                       {
                                                           if(installationDate==WarehouseDate)
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                           else
                                                           {
                                                               if(installationDate<WarehouseDate)
                                                               {
                                                                   expirydate=installationDate; 
                                                                   expirymonth=installationMonth;
                                                                   expiryyear=installationYear;
                                                               }
                                                               else
                                                               {
                                                                   expirydate=WarehouseDate; 
                                                                   expirymonth=WarehouseMonth;
                                                                   expiryyear=WarehouseYear;
                                                               }
                                                           }
                                                       }
                                                       else
                                                       {
                                                           if(installationMonth<WarehouseMonth)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationYear<WarehouseYear)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   rt=st.executeQuery(query4);
                                                   if(rt.next())
                                                   {
                                                       int m=rt.getInt(10);
                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                             ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                             ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                             ", Expiry_date="+date+
                                                                             ", Expiry_month="+month+
                                                                             ", Expiry_year="+year+
                                                                             " WHERE Sno="+sno;
                                                       st.executeUpdate(query1);
                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                       st.executeUpdate(query5);
                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                    } 
                                               }
                                               else
                                               {
                                                   JOptionPane.showMessageDialog(null,"Warranty Expired");
                                               }
                                           }
                                       }
                                       else
                                       {
                                           if(installationMonth<checkmonth)
                                           {
                                               String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                               ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                               ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                               " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               st.executeUpdate(query);
                                               this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                               if(installationYear==WarehouseYear)
                                               {
                                                   if(installationMonth==WarehouseMonth)
                                                   {
                                                       if(installationDate==WarehouseDate)
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                       else
                                                       {
                                                           if(installationDate<WarehouseDate)
                                                           {
                                                               expirydate=installationDate; 
                                                               expirymonth=installationMonth;
                                                               expiryyear=installationYear;
                                                           }
                                                           else
                                                           {
                                                               expirydate=WarehouseDate; 
                                                               expirymonth=WarehouseMonth;
                                                               expiryyear=WarehouseYear;
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       if(installationMonth<WarehouseMonth)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                               }
                                               else
                                               {
                                                   if(installationYear<WarehouseYear)
                                                   {
                                                       expirydate=installationDate; 
                                                       expirymonth=installationMonth;
                                                       expiryyear=installationYear;
                                                   }
                                                   else
                                                   {
                                                       expirydate=WarehouseDate; 
                                                       expirymonth=WarehouseMonth;
                                                       expiryyear=WarehouseYear;
                                                   }
                                               }
                                               String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               rt=st.executeQuery(query4);
                                               if(rt.next())
                                               {
                                                   int m=rt.getInt(10);
                                                   this.caldate1(expirydate,expirymonth,expiryyear, m);
                                                   String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                         ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                         ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                         ", Expiry_date="+date+
                                                                         ", Expiry_month="+month+
                                                                         ", Expiry_year="+year+
                                                                         " WHERE Sno="+sno;
                                                   st.executeUpdate(query1);
                                                   this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                                   String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                                   st.executeUpdate(query5);
                                                   JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                                } 
                                           }
                                           else
                                           {
                                               JOptionPane.showMessageDialog(null,"Warranty Expired");
                                           }
                                       }
                                   }
                                   else
                                   {
                                       if(installationYear<checkyear)
                                       {
                                           String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                                                                               ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                                                                               ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                                                                               " WHERE Tid='"+SpecificationTextField.getText()+"'";
                                           st.executeUpdate(query);
                                           this.caldate(purchaseDate,purchaseMonth,purchaseYear);
                                           if(installationYear==WarehouseYear)
                                           {
                                               if(installationMonth==WarehouseMonth)
                                               {
                                                   if(installationDate==WarehouseDate)
                                                   {
                                                       expirydate=WarehouseDate; 
                                                       expirymonth=WarehouseMonth;
                                                       expiryyear=WarehouseYear;
                                                   }
                                                   else
                                                   {
                                                       if(installationDate<WarehouseDate)
                                                       {
                                                           expirydate=installationDate; 
                                                           expirymonth=installationMonth;
                                                           expiryyear=installationYear;
                                                       }
                                                       else
                                                       {
                                                           expirydate=WarehouseDate; 
                                                           expirymonth=WarehouseMonth;
                                                           expiryyear=WarehouseYear;
                                                       }
                                                   }
                                               }
                                               else
                                               {
                                                   if(installationMonth<WarehouseMonth)
                                                   {
                                                       expirydate=installationDate; 
                                                       expirymonth=installationMonth;
                                                       expiryyear=installationYear;
                                                   }
                                                   else
                                                   {
                                                       expirydate=WarehouseDate; 
                                                       expirymonth=WarehouseMonth;
                                                       expiryyear=WarehouseYear;
                                                   }
                                               }
                                           }
                                           else
                                           {
                                               if(installationYear<WarehouseYear)
                                               {
                                                   expirydate=installationDate; 
                                                   expirymonth=installationMonth;
                                                   expiryyear=installationYear;
                                               }
                                               else
                                               {
                                                   expirydate=WarehouseDate; 
                                                   expirymonth=WarehouseMonth;
                                                   expiryyear=WarehouseYear;
                                               }
                                           }
                                           String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
                                           rt=st.executeQuery(query4);
                                           if(rt.next())
                                           {
                                               int m=rt.getInt(10);
                                               this.caldate1(expirydate,expirymonth,expiryyear, m);
                                               String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
                                                                     ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
                                                                     ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
                                                                     ", Expiry_date="+date+
                                                                     ", Expiry_month="+month+
                                                                     ", Expiry_year="+year+
                                                                     " WHERE Sno="+sno;
                                               st.executeUpdate(query1);
                                               this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
                                               String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
                                               st.executeUpdate(query5);
                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
                                            } 
                                        }
                                       else
                                       {
                                           JOptionPane.showMessageDialog(null,"Warranty Expired");
                                       }
                                   }
                               }
                           }
//                           if(installationYear<=purchaseYear)
//                           {
//                               if(installationYear==purchaseYear)
//                               {
//                                   if(installationMonth<=purchaseMonth)
//                                   {
//                                       if(installationMonth==purchaseMonth)
//                                       {
//                                           if(installationDate<=purchaseDate)
//                                           {
//                                               if(installationDate==purchaseDate)
//                                               {
//                                                   JOptionPane.showMessageDialog(null,"Invalid Installaton date");
//                                               }
//                                               else
//                                               {
//                                                   JOptionPane.showMessageDialog(null,"Invalid Installaton date");
//                                               }
//                                            }
//                                           else
//                                           {
//                                               if(Integer.parseInt(Year_of_installationTextfield.getText())<=checkyear)
//                                               {
//                                                   if(Integer.parseInt(Year_of_installationTextfield.getText())==checkyear)
//                                                   {
//                                                       if(Integer.parseInt(Month_of_installationTextField.getText())<=checkmonth)
//                                                       {
//                                                           if(Integer.parseInt(Month_of_installationTextField.getText())==checkmonth)
//                                                           {
//                                                               if(Integer.parseInt(Date_of_installationTextfield.getText())<=checkdate)
//                                                               {
//                                                                   if(Integer.parseInt(Date_of_installationTextfield.getText())==checkdate)
//                                                                   {
//                                                                     JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                                               ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                                               ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                                               " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                       st.executeUpdate(query);
//                                                                       String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                                                       rt=st.executeQuery(query3);
//                                                                       if(rt.next())
//                                                                       {
//                                                                           sno=rt.getInt(1);
//                                                                           WarehouseDate=rt.getInt(2);
//                                                                           WarehouseMonth=rt.getInt(3);
//                                                                           WarehouseYear=rt.getInt(4);
//                                                                           this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                                           if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                                           {
//                                                                               if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                                               {
//                                                                                   if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                                                   {
//                                                                                       if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                                                       {
//                                                                                           if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                                           {
//                                                                                               if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                                               {
//                                                                                                   expirydate=WarehouseDate; 
//                                                                                                   expirymonth=WarehouseMonth;
//                                                                                                   expiryyear=WarehouseYear;
//                                                                                                }
//                                                                                               else
//                                                                                               {
//                                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                                }
//                                                                                            }
//                                                                                           else
//                                                                                           {
//                                                                                               expirydate=WarehouseDate; 
//                                                                                               expirymonth=WarehouseMonth;
//                                                                                               expiryyear=WarehouseYear;
//                                                                                            }
//                                                                                        }
//                                                                                       else
//                                                                                       {
//                                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                        }
//                                                                                    }
//                                                                                  else
//                                                                                   {
//                                                                                       expirydate=WarehouseDate; 
//                                                                                       expirymonth=WarehouseMonth;
//                                                                                       expiryyear=WarehouseYear;
//                                                                                    }
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                }
//                                                                            }
//                                                                           else
//                                                                           {
//                                                                               expirydate=WarehouseDate; 
//                                                                               expirymonth=WarehouseMonth;
//                                                                               expiryyear=WarehouseYear;
//                                                                            }
//                                                                           String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                           rt=st.executeQuery(query4);
//                                                                           if(rt.next())
//                                                                           {
//                                                                               int m=rt.getInt(10);
//                                                                               this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                                               String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                     ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                     ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                     ", Expiry_date="+date+
//                                                                                                     ", Expiry_month="+month+
//                                                                                                     ", Expiry_year="+year+
//                                                                                                     " WHERE Sno="+sno;
//                                                                               st.executeUpdate(query1);
//                                                                               this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                                               String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                               st.executeUpdate(query5);
//                                                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                                            }  
//                                                                        }
//                                                                    }
//                                                                }
//                                                               else
//                                                                {
//                                                                JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                                }
//                                                            }       
//                                                           else
//                                                           {
//                                                              String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                                     ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                                     ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                                     " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                               st.executeUpdate(query);
//                                                               String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                                               rt=st.executeQuery(query3);
//                                                               if(rt.next())
//                                                               {
//                                                                   sno=rt.getInt(1);
//                                                                   WarehouseDate=rt.getInt(2);
//                                                                   WarehouseMonth=rt.getInt(3);
//                                                                   WarehouseYear=rt.getInt(4);
//                                                                   this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                                   if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                                   {
//                                                                       if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                                       {
//                                                                           if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                                           {
//                                                                               if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                                               {
//                                                                                   if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                                   {
//                                                                                       if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                                       {
//                                                                                           expirydate=WarehouseDate; 
//                                                                                           expirymonth=WarehouseMonth;
//                                                                                           expiryyear=WarehouseYear;
//                                                                                        }
//                                                                                       else
//                                                                                       {
//                                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                        }
//                                                                                    }
//                                                                                   else
//                                                                                   {
//                                                                                       expirydate=WarehouseDate; 
//                                                                                       expirymonth=WarehouseMonth;
//                                                                                       expiryyear=WarehouseYear;
//                                                                                    }
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                }
//                                                                            }
//                                                                           else
//                                                                           {
//                                                                               expirydate=WarehouseDate; 
//                                                                               expirymonth=WarehouseMonth;
//                                                                               expiryyear=WarehouseYear;
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                        }
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       expirydate=WarehouseDate; 
//                                                                       expirymonth=WarehouseMonth;
//                                                                       expiryyear=WarehouseYear;
//                                                                    }
//                                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                   rt=st.executeQuery(query4);
//                                                                   if(rt.next())
//                                                                   {
//                                                                       int m=rt.getInt(10);
//                                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                                                ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                                                ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                                                ", Expiry_date="+date+
//                                                                                                                                ", Expiry_month="+month+
//                                                                                                                                ", Expiry_year="+year+
//                                                                                                                                " WHERE Sno="+sno;
//                                                                       st.executeUpdate(query1);
//                                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                       st.executeUpdate(query5);
//                                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                                    }
//                                                                }
//                                                            }
//                                                       }
//                                                      else
//                                                      {
//                                                          JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                      }
//                                                  }        
//                                                 else
//                                                 {
//
//                                                    String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                              ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                              ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                              " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                    st.executeUpdate(query);
//                                                    String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                                    rt=st.executeQuery(query3);
//                                                    if(rt.next())
//                                                    {
//                                                        sno=rt.getInt(1);
//                                                        WarehouseDate=rt.getInt(2);
//                                                        WarehouseMonth=rt.getInt(3);
//                                                        WarehouseYear=rt.getInt(4);
//                                                        this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                        if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                        {
//                                                           if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                           {
//                                                              if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                              {
//                                                                 if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                                  {
//                                                                     if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                      {
//                                                                         if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                          {
//                                                                                   expirydate=WarehouseDate; 
//                                                                                   expirymonth=WarehouseMonth;
//                                                                                   expiryyear=WarehouseYear;
//                                                                          }
//                                                                         else
//                                                                         {
//                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                         }
//                                                                      }
//                                                                     else
//                                                                     {
//                                                                         expirydate=WarehouseDate; 
//                                                                         expirymonth=WarehouseMonth;
//                                                                         expiryyear=WarehouseYear;
//                                                                      }
//                                                                  }
//                                                                 else
//                                                                 {
//                                                                     expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                     expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                     expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                  }
//                                                              }
//                                                             else
//                                                              {
//                                                                   expirydate=WarehouseDate; 
//                                                                   expirymonth=WarehouseMonth;
//                                                                   expiryyear=WarehouseYear;
//                                                              }
//                                                          }
//                                                         else
//                                                          {
//                                                               expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                               expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                               expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                          }
//                                                      }
//                                                     else
//                                                     {
//                                                          expirydate=WarehouseDate; 
//                                                          expirymonth=WarehouseMonth;
//                                                          expiryyear=WarehouseYear;
//                                                     }
//                                                     String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                     rt=st.executeQuery(query4);
//                                                     if(rt.next())
//                                                     {
//                                                         int m=rt.getInt(10);
//                                                         this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                         String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                     ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                     ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                     ", Expiry_date="+date+
//                                                                                                     ", Expiry_month="+month+
//                                                                                                     ", Expiry_year="+year+
//                                                                                                     " WHERE Sno="+sno;
//                                                        st.executeUpdate(query1);
//                                                        this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                        String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                        st.executeUpdate(query5);
//                                                      JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                            }
//                                                        }
//                                                    }
//                                                 }
//                                               else
//                                               {
//                                                   JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                }
//                                           }
//                                       }
//                                       else
//                                       {
//                                           JOptionPane.showMessageDialog(null,"Invalid Installaton date");
//                                       }
//                                    }
//                                   else
//                                   {
//                                       if(Integer.parseInt(Year_of_installationTextfield.getText())<=checkyear)
//                                       {
//                                           if(Integer.parseInt(Year_of_installationTextfield.getText())==checkyear)
//                                           {
//                                               if(Integer.parseInt(Month_of_installationTextField.getText())<=checkmonth)
//                                               {
//                                                   if(Integer.parseInt(Month_of_installationTextField.getText())==checkmonth)
//                                                   {
//                                                       if(Integer.parseInt(Date_of_installationTextfield.getText())<=checkdate)
//                                                       {
//                                                           if(Integer.parseInt(Date_of_installationTextfield.getText())==checkdate)
//                                                           {
//                                                             JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                            }
//                                                           else
//                                                           {
//                                                               String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                                       ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                                       ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                                       " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                               st.executeUpdate(query);
//                                                               String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                                               rt=st.executeQuery(query3);
//                                                               if(rt.next())
//                                                               {
//                                                                   sno=rt.getInt(1);
//                                                                   WarehouseDate=rt.getInt(2);
//                                                                   WarehouseMonth=rt.getInt(3);
//                                                                   WarehouseYear=rt.getInt(4);
//                                                                   this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                                   if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                                   {
//                                                                       if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                                       {
//                                                                           if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                                           {
//                                                                               if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                                               {
//                                                                                   if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                                   {
//                                                                                       if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                                       {
//                                                                                           expirydate=WarehouseDate; 
//                                                                                           expirymonth=WarehouseMonth;
//                                                                                           expiryyear=WarehouseYear;
//                                                                                        }
//                                                                                       else
//                                                                                       {
//                                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                        }
//                                                                                    }
//                                                                                   else
//                                                                                   {
//                                                                                       expirydate=WarehouseDate; 
//                                                                                       expirymonth=WarehouseMonth;
//                                                                                       expiryyear=WarehouseYear;
//                                                                                    }
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                }
//                                                                            }
//                                                                          else
//                                                                           {
//                                                                               expirydate=WarehouseDate; 
//                                                                               expirymonth=WarehouseMonth;
//                                                                               expiryyear=WarehouseYear;
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                        }
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       expirydate=WarehouseDate; 
//                                                                       expirymonth=WarehouseMonth;
//                                                                       expiryyear=WarehouseYear;
//                                                                    }
//                                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                   rt=st.executeQuery(query4);
//                                                                   if(rt.next())
//                                                                   {
//                                                                       int m=rt.getInt(10);
//                                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                             ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                             ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                             ", Expiry_date="+date+
//                                                                                             ", Expiry_month="+month+
//                                                                                             ", Expiry_year="+year+
//                                                                                             " WHERE Sno="+sno;
//                                                                       st.executeUpdate(query1);
//                                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                                       st.executeUpdate(query5);
//                                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                                    }  
//                                                                }
//                                                            }
//                                                        }
//                                                       else
//                                                        {
//                                                        JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                        }
//                                                    }       
//                                                   else
//                                                   {
//                                                      String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                             ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                             ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                             " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                       st.executeUpdate(query);
//                                                       String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                                       rt=st.executeQuery(query3);
//                                                       if(rt.next())
//                                                       {
//                                                           sno=rt.getInt(1);
//                                                           WarehouseDate=rt.getInt(2);
//                                                           WarehouseMonth=rt.getInt(3);
//                                                           WarehouseYear=rt.getInt(4);
//                                                           this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                           if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                           {
//                                                               if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                               {
//                                                                   if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                                   {
//                                                                       if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                                       {
//                                                                           if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                           {
//                                                                               if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                               {
//                                                                                   expirydate=WarehouseDate; 
//                                                                                   expirymonth=WarehouseMonth;
//                                                                                   expiryyear=WarehouseYear;
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                }
//                                                                            }
//                                                                           else
//                                                                           {
//                                                                               expirydate=WarehouseDate; 
//                                                                               expirymonth=WarehouseMonth;
//                                                                               expiryyear=WarehouseYear;
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                        }
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       expirydate=WarehouseDate; 
//                                                                       expirymonth=WarehouseMonth;
//                                                                       expiryyear=WarehouseYear;
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                }
//                                                            }
//                                                           else
//                                                           {
//                                                               expirydate=WarehouseDate; 
//                                                               expirymonth=WarehouseMonth;
//                                                               expiryyear=WarehouseYear;
//                                                            }
//                                                           String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                           rt=st.executeQuery(query4);
//                                                           if(rt.next())
//                                                           {
//                                                               int m=rt.getInt(10);
//                                                               this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                               String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                                        ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                                        ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                                        ", Expiry_date="+date+
//                                                                                                                        ", Expiry_month="+month+
//                                                                                                                        ", Expiry_year="+year+
//                                                                                                                        " WHERE Sno="+sno;
//                                                               st.executeUpdate(query1);
//                                                               this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                               String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                               st.executeUpdate(query5);
//                                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                            }
//                                                        }
//                                                    }
//                                               }
//                                              else
//                                              {
//                                                  JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                              }
//                                          }        
//                                         else
//                                         {
//
//                                            String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                      ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                      ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                      " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                            st.executeUpdate(query);
//                                            String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                            rt=st.executeQuery(query3);
//                                            if(rt.next())
//                                            {
//                                                sno=rt.getInt(1);
//                                                WarehouseDate=rt.getInt(2);
//                                                WarehouseMonth=rt.getInt(3);
//                                                WarehouseYear=rt.getInt(4);
//                                                this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                {
//                                                   if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                   {
//                                                      if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                      {
//                                                         if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                          {
//                                                             if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                              {
//                                                                 if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                  {
//                                                                           expirydate=WarehouseDate; 
//                                                                           expirymonth=WarehouseMonth;
//                                                                           expiryyear=WarehouseYear;
//                                                                  }
//                                                                 else
//                                                                 {
//                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                 }
//                                                              }
//                                                             else
//                                                             {
//                                                                 expirydate=WarehouseDate; 
//                                                                 expirymonth=WarehouseMonth;
//                                                                 expiryyear=WarehouseYear;
//                                                              }
//                                                          }
//                                                         else
//                                                         {
//                                                             expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                             expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                             expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                          }
//                                                      }
//                                                     else
//                                                      {
//                                                           expirydate=WarehouseDate; 
//                                                           expirymonth=WarehouseMonth;
//                                                           expiryyear=WarehouseYear;
//                                                      }
//                                                  }
//                                                 else
//                                                  {
//                                                       expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                       expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                       expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                  }
//                                              }
//                                             else
//                                             {
//                                                  expirydate=WarehouseDate; 
//                                                  expirymonth=WarehouseMonth;
//                                                  expiryyear=WarehouseYear;
//                                             }
//                                             String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                             rt=st.executeQuery(query4);
//                                             if(rt.next())
//                                             {
//                                                 int m=rt.getInt(10);
//                                                 this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                 String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                             ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                             ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                             ", Expiry_date="+date+
//                                                                                             ", Expiry_month="+month+
//                                                                                             ", Expiry_year="+year+
//                                                                                             " WHERE Sno="+sno;
//                                                st.executeUpdate(query1);
//                                                this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                st.executeUpdate(query5);
//                                              JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                    }
//                                                }
//                                            }
//                                         }
//                                       else
//                                       {
//                                           JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                        }
//                                   }
//                               }
//                               else
//                               {
//                                   JOptionPane.showMessageDialog(null,"Invalid Installaton date");
//                               }
//                           }
//                           else
//                           {
//                               if(Integer.parseInt(Year_of_installationTextfield.getText())<=checkyear)
//                               {
//                                   if(Integer.parseInt(Year_of_installationTextfield.getText())==checkyear)
//                                   {
//                                       if(Integer.parseInt(Month_of_installationTextField.getText())<=checkmonth)
//                                       {
//                                           if(Integer.parseInt(Month_of_installationTextField.getText())==checkmonth)
//                                           {
//                                               if(Integer.parseInt(Date_of_installationTextfield.getText())<=checkdate)
//                                               {
//                                                   if(Integer.parseInt(Date_of_installationTextfield.getText())==checkdate)
//                                                   {
//                                                     JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                    }
//                                                   else
//                                                   {
//                                                       String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                               ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                               ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                               " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                       st.executeUpdate(query);
//                                                       String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                                       rt=st.executeQuery(query3);
//                                                       if(rt.next())
//                                                       {
//                                                           sno=rt.getInt(1);
//                                                           WarehouseDate=rt.getInt(2);
//                                                           WarehouseMonth=rt.getInt(3);
//                                                           WarehouseYear=rt.getInt(4);
//                                                           this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                           if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                           {
//                                                               if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                               {
//                                                                   if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                                   {
//                                                                       if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                                       {
//                                                                           if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                           {
//                                                                               if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                               {
//                                                                                   expirydate=WarehouseDate; 
//                                                                                   expirymonth=WarehouseMonth;
//                                                                                   expiryyear=WarehouseYear;
//                                                                                }
//                                                                               else
//                                                                               {
//                                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                                }
//                                                                            }
//                                                                           else
//                                                                           {
//                                                                               expirydate=WarehouseDate; 
//                                                                               expirymonth=WarehouseMonth;
//                                                                               expiryyear=WarehouseYear;
//                                                                            }
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                        }
//                                                                    }
//                                                                  else
//                                                                   {
//                                                                       expirydate=WarehouseDate; 
//                                                                       expirymonth=WarehouseMonth;
//                                                                       expiryyear=WarehouseYear;
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                }
//                                                            }
//                                                           else
//                                                           {
//                                                               expirydate=WarehouseDate; 
//                                                               expirymonth=WarehouseMonth;
//                                                               expiryyear=WarehouseYear;
//                                                            }
//                                                           String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                           rt=st.executeQuery(query4);
//                                                           if(rt.next())
//                                                           {
//                                                               int m=rt.getInt(10);
//                                                               this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                               String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                     ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                     ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                     ", Expiry_date="+date+
//                                                                                     ", Expiry_month="+month+
//                                                                                     ", Expiry_year="+year+
//                                                                                     " WHERE Sno="+sno;
//                                                               st.executeUpdate(query1);
//                                                               this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                               String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                               st.executeUpdate(query5);
//                                                               JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                            }  
//                                                        }
//                                                    }
//                                                }
//                                               else
//                                                {
//                                                JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                                }
//                                            }       
//                                           else
//                                           {
//                                              String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                     ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                     ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                     " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                               st.executeUpdate(query);
//                                               String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                               rt=st.executeQuery(query3);
//                                               if(rt.next())
//                                               {
//                                                   sno=rt.getInt(1);
//                                                   WarehouseDate=rt.getInt(2);
//                                                   WarehouseMonth=rt.getInt(3);
//                                                   WarehouseYear=rt.getInt(4);
//                                                   this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                                   if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                                   {
//                                                       if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                                       {
//                                                           if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                                           {
//                                                               if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                               {
//                                                                   if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                                   {
//                                                                       if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                                       {
//                                                                           expirydate=WarehouseDate; 
//                                                                           expirymonth=WarehouseMonth;
//                                                                           expiryyear=WarehouseYear;
//                                                                        }
//                                                                       else
//                                                                       {
//                                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                        }
//                                                                    }
//                                                                   else
//                                                                   {
//                                                                       expirydate=WarehouseDate; 
//                                                                       expirymonth=WarehouseMonth;
//                                                                       expiryyear=WarehouseYear;
//                                                                    }
//                                                                }
//                                                               else
//                                                               {
//                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                                }
//                                                            }
//                                                           else
//                                                           {
//                                                               expirydate=WarehouseDate; 
//                                                               expirymonth=WarehouseMonth;
//                                                               expiryyear=WarehouseYear;
//                                                            }
//                                                        }
//                                                       else
//                                                       {
//                                                           expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                           expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                           expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                        }
//                                                    }
//                                                   else
//                                                   {
//                                                       expirydate=WarehouseDate; 
//                                                       expirymonth=WarehouseMonth;
//                                                       expiryyear=WarehouseYear;
//                                                    }
//                                                   String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                   rt=st.executeQuery(query4);
//                                                   if(rt.next())
//                                                   {
//                                                       int m=rt.getInt(10);
//                                                       this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                                       String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                                                ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                                                ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                                                ", Expiry_date="+date+
//                                                                                                                ", Expiry_month="+month+
//                                                                                                                ", Expiry_year="+year+
//                                                                                                                " WHERE Sno="+sno;
//                                                       st.executeUpdate(query1);
//                                                       this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                                       String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                                       st.executeUpdate(query5);
//                                                       JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                                    }
//                                                }
//                                            }
//                                       }
//                                      else
//                                      {
//                                          JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                      }
//                                  }        
//                                 else
//                                 {
//
//                                    String query="UPDATE Transf_Details SET Installed_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                              ", Installed_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                              ", Installed_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                              " WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                    st.executeUpdate(query);
//                                    String query3="SELECT max(Sno),Purchase_date,Purchase_month,Purchase_year FROM "+SpecificationTextField.getText();
//                                    rt=st.executeQuery(query3);
//                                    if(rt.next())
//                                    {
//                                        sno=rt.getInt(1);
//                                        WarehouseDate=rt.getInt(2);
//                                        WarehouseMonth=rt.getInt(3);
//                                        WarehouseYear=rt.getInt(4);
//                                        this.caldate(WarehouseDate,WarehouseMonth,WarehouseYear);
//                                        if(Integer.parseInt(Year_of_installationTextfield.getText())<=WarehouseYear)
//                                        {
//                                           if(Integer.parseInt(Year_of_installationTextfield.getText())==WarehouseYear)
//                                           {
//                                              if(Integer.parseInt(Month_of_installationTextField.getText())<=WarehouseMonth)
//                                              {
//                                                 if(Integer.parseInt(Month_of_installationTextField.getText())==WarehouseMonth)
//                                                  {
//                                                     if(Integer.parseInt(Date_of_installationTextfield.getText())<=WarehouseDate)
//                                                      {
//                                                         if(Integer.parseInt(Date_of_installationTextfield.getText())==WarehouseDate)
//                                                          {
//                                                                   expirydate=WarehouseDate; 
//                                                                   expirymonth=WarehouseMonth;
//                                                                   expiryyear=WarehouseYear;
//                                                          }
//                                                         else
//                                                         {
//                                                                   expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                                   expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                                   expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                         }
//                                                      }
//                                                     else
//                                                     {
//                                                         expirydate=WarehouseDate; 
//                                                         expirymonth=WarehouseMonth;
//                                                         expiryyear=WarehouseYear;
//                                                      }
//                                                  }
//                                                 else
//                                                 {
//                                                     expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                                     expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                                     expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                                  }
//                                              }
//                                             else
//                                              {
//                                                   expirydate=WarehouseDate; 
//                                                   expirymonth=WarehouseMonth;
//                                                   expiryyear=WarehouseYear;
//                                              }
//                                          }
//                                         else
//                                          {
//                                               expirydate=Integer.parseInt(Date_of_installationTextfield.getText());
//                                               expirymonth=Integer.parseInt(Month_of_installationTextField.getText()); 
//                                               expiryyear=Integer.parseInt(Year_of_installationTextfield.getText());
//                                          }
//                                      }
//                                     else
//                                     {
//                                          expirydate=WarehouseDate; 
//                                          expirymonth=WarehouseMonth;
//                                          expiryyear=WarehouseYear;
//                                     }
//                                     String query4="SELECT * FROM Transf_details WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                     rt=st.executeQuery(query4);
//                                     if(rt.next())
//                                     {
//                                         int m=rt.getInt(10);
//                                         this.caldate1(expirydate,expirymonth,expiryyear, m);
//                                         String query1="UPDATE "+SpecificationTextField.getText()+" SET Installation_date="+Integer.parseInt(Date_of_installationTextfield.getText())+
//                                                                                     ", Installation_month="+Integer.parseInt(Month_of_installationTextField.getText())+
//                                                                                     ", Installation_year="+Integer.parseInt(Year_of_installationTextfield.getText())+
//                                                                                     ", Expiry_date="+date+
//                                                                                     ", Expiry_month="+month+
//                                                                                     ", Expiry_year="+year+
//                                                                                     " WHERE Sno="+sno;
//                                        st.executeUpdate(query1);
//                                        this.Cal_day(expirydate,expirymonth,expiryyear,date,month,year);
//                                        String query5="UPDATE Type_of_warranty SET Warranty_Days="+days+" WHERE Tid='"+SpecificationTextField.getText()+"'";
//                                        st.executeUpdate(query5);
//                                      JOptionPane.showMessageDialog(null,"Successfully added..!!");
//                                            }
//                                        }
//                                    }
//                                 }
//                               else
//                               {
//                                   JOptionPane.showMessageDialog(null,"Warranty Expired");
//                                }
//                            }
                        }
                     }
                    }  
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Installation Date Already exist");
                    }
                } 
               else
               {
                   JOptionPane.showMessageDialog(null,"TID Doesn't Exist");
                }
            }
           else
           {
               JOptionPane.showMessageDialog(null,"TID Doesn't Exist");
           }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        } }
        else{
            PopUp pop = new PopUp();
            pop.setMessagelabel("Invalid Date");
            pop.setVisible(true);
        }
        
        
    }//GEN-LAST:event_NextButtonMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel CancelButton;
    private javax.swing.JLabel CloseButton;
    private javax.swing.JLabel DateOfInstallationTextBox;
    private javax.swing.JLabel Date_of_installation;
    private javax.swing.JTextField Date_of_installationTextfield;
    private javax.swing.JLabel Installation_Date;
    private javax.swing.JLabel Installation_date_logo;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MonthOfInstallationTextBox;
    private javax.swing.JTextField Month_of_installationTextField;
    private javax.swing.JLabel NextButton;
    private javax.swing.JLabel PO_Number;
    private javax.swing.JLabel PoNumberTextBox;
    private javax.swing.JTextField Po_NoTextfield;
    private javax.swing.JLabel SpecificationNumberTextBox;
    private javax.swing.JTextField SpecificationTextField;
    private javax.swing.JLabel Specification_Number;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title_Bar;
    private javax.swing.JLabel YearOfInstallationTextBox;
    private javax.swing.JTextField Year_of_installationTextfield;
    private javax.swing.JLabel dash1;
    private javax.swing.JLabel dash2;
    // End of variables declaration//GEN-END:variables
}
