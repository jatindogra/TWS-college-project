/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.awt.event.MouseAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.UIManager;


/**
 *
 * @author Jatin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Connection con = null;Statement stmt =null;ResultSet rs =null;
    String account_type;
    String Emailid;
    
    String Firstname;
    String Lastname;
    String user_name;
    
    
    
    public Login() {
        initComponents();
        SQLConnect sqlcon = new SQLConnect();
        con=sqlcon.sqlCon(con);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SignInButton = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        Frgt_passwd = new javax.swing.JLabel();
        Contact_us = new javax.swing.JLabel();
        Terms_of_use = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Privacy = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Default_Close = new javax.swing.JLabel();
        Default_Mininmize = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Language: English");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(885, 45, 125, 18);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Untitled-12_1.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 25, 70, 60);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transrec");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 32, 177, 53);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/shadowmasklogin.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(1024, 70));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 19, 1024, 80);

        SignInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Sign_in_button.png"))); // NOI18N
        SignInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignInButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignInButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignInButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignInButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SignInButtonMouseReleased(evt);
            }
        });
        getContentPane().add(SignInButton);
        SignInButton.setBounds(720, 385, 90, 35);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 0, 153));
        jTextField1.setText("Enter your username");
        jTextField1.setToolTipText("USERNAME");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(720, 260, 250, 30);

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(153, 0, 153));
        jPasswordField1.setText("Password");
        jPasswordField1.setToolTipText("Password");
        jPasswordField1.setPreferredSize(new java.awt.Dimension(110, 22));
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(720, 310, 250, 30);

        Frgt_passwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Forgot_Passwd.png"))); // NOI18N
        Frgt_passwd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Frgt_passwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Frgt_passwdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Frgt_passwdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Frgt_passwdMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Frgt_passwdMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Frgt_passwdMouseReleased(evt);
            }
        });
        getContentPane().add(Frgt_passwd);
        Frgt_passwd.setBounds(720, 440, 140, 20);

        Contact_us.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Contact_us_hover.png"))); // NOI18N
        Contact_us.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Contact_usMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Contact_usMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Contact_usMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Contact_usMouseReleased(evt);
            }
        });
        getContentPane().add(Contact_us);
        Contact_us.setBounds(430, 660, 100, 30);

        Terms_of_use.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Terms_of_use_hover.png"))); // NOI18N
        Terms_of_use.setText("jLabel4");
        Terms_of_use.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Terms_of_useMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Terms_of_useMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Terms_of_useMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Terms_of_useMouseReleased(evt);
            }
        });
        getContentPane().add(Terms_of_use);
        Terms_of_use.setBounds(580, 660, 100, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Zebra.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(900, 650, 100, 40);

        Privacy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Privacy_hover.png"))); // NOI18N
        Privacy.setText("jLabel5");
        Privacy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrivacyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrivacyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrivacyMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PrivacyMouseReleased(evt);
            }
        });
        getContentPane().add(Privacy);
        Privacy.setBounds(730, 660, 100, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/boundary.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 2, 700);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Horizontal_boundary.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 698, 1024, 2);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/boundary.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1022, 0, 2, 700);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/logintransfback.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(3, 91, 1018, 507);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Login.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(2, 90, 1020, 608);

        Default_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_close.png"))); // NOI18N
        Default_Close.setText("jLabel5");
        Default_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Default_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Default_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Default_CloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Default_CloseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Default_CloseMouseReleased(evt);
            }
        });
        getContentPane().add(Default_Close);
        Default_Close.setBounds(1001, 1, 20, 15);

        Default_Mininmize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_minimize.png"))); // NOI18N
        Default_Mininmize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Default_MininmizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Default_MininmizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Default_MininmizeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Default_MininmizeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Default_MininmizeMouseReleased(evt);
            }
        });
        getContentPane().add(Default_Mininmize);
        Default_Mininmize.setBounds(976, 1, 20, 15);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Login_taskbar.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(2, 0, 1020, 20);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void SignInButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInButtonMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Sign_in_button_pressed2.png"));
       SignInButton.setIcon(ISB);
         String username = jTextField1.getText();
         String password = new String(jPasswordField1.getPassword());
         String generatedPassword = null;
        
         try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(password.getBytes());
			//Get the hash's bytes 
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
         if(evt.getSource()==SignInButton){
             if(username.equals("")||username==null||password.equals("")||password==null){
                if(username.equals("")||username==null){
                    PopUp popobj = new PopUp();
                    popobj.setMessagelabel("Please fill the username");
                    popobj.setVisible(true);
                    
                }
                else
                    if(password.equals("")||password==null){
                     PopUp popobj = new PopUp();
                    popobj.setMessagelabel("Please fill the password");
                    popobj.setVisible(true);
                }
             } 

             else{
         try{
             stmt = con.createStatement();
             rs = stmt.executeQuery("select username,password from login where username='"+username+"' and password='"+generatedPassword+"'");
             if(rs.next()){
                 Welcome welobj = new Welcome();
                 welobj.setVisible(true);
                 this.dispose();
             }
             else
                {
                    PopUp popobj = new PopUp();
                    popobj.setMessagelabel("Incorrect username or password");
                    popobj.setVisible(true);
                }
         }
          catch (Exception e1)
        {
            PopUp popobj = new PopUp();
                    popobj.setMessagelabel("Exception Occured : " + e1);
                    popobj.setVisible(true);
        }
         try{
            
             stmt = con.createStatement();
             rs = stmt.executeQuery("select * from login where username='"+username+"'");
             rs.next();
             user_name = rs.getString("username");
             account_type = rs.getString("account_type");
             //password_profile =rs.getString("password");
             Emailid = rs.getString("email_id");
             Firstname = rs.getString("first_name");
             Lastname = rs.getString("lastname");
             //System.out.println(account_type);
             
             ChangePassword.email(Emailid);
             Welcome.displayaccount(account_type,user_name,Emailid,Firstname,Lastname);
         }
         catch(Exception e1)
         {
             System.out.println(e1);
             }
            } 
         }      
    }//GEN-LAST:event_SignInButtonMousePressed

    private void SignInButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInButtonMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Sign_in_button_hover2.png"));
       SignInButton.setIcon(ISB);
    }//GEN-LAST:event_SignInButtonMouseReleased

    private void SignInButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInButtonMouseEntered
         ImageIcon ISB=new ImageIcon(getClass().getResource("Sign_in_button_hover2.png"));
       SignInButton.setIcon(ISB);
    }//GEN-LAST:event_SignInButtonMouseEntered

    private void SignInButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInButtonMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Sign_in_button.png"));
       SignInButton.setIcon(ISB);
    }//GEN-LAST:event_SignInButtonMouseExited

    private void Frgt_passwdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frgt_passwdMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("Forgot_Passwd_hover.png"));
       Frgt_passwd.setIcon(ISB);
    }//GEN-LAST:event_Frgt_passwdMouseEntered

    private void Frgt_passwdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frgt_passwdMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("Forgot_Passwd.png"));
       Frgt_passwd.setIcon(ISB);
    }//GEN-LAST:event_Frgt_passwdMouseExited

    private void Frgt_passwdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frgt_passwdMousePressed
       ImageIcon ISB=new ImageIcon(getClass().getResource("Forgot_Passwd_pressed.png"));
       Frgt_passwd.setIcon(ISB);
    }//GEN-LAST:event_Frgt_passwdMousePressed

    private void Frgt_passwdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frgt_passwdMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Forgot_Passwd.png"));
       Frgt_passwd.setIcon(ISB);
    }//GEN-LAST:event_Frgt_passwdMouseReleased

    private void Contact_usMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Contact_usMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("Contact_us_hover2.png"));
       Contact_us.setIcon(ISB);
    }//GEN-LAST:event_Contact_usMouseEntered

    private void Contact_usMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Contact_usMousePressed
         ImageIcon ISB=new ImageIcon(getClass().getResource("Contact_us_pressed2.png"));
       Contact_us.setIcon(ISB);
    }//GEN-LAST:event_Contact_usMousePressed

    private void Contact_usMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Contact_usMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Contact_us_hover.png"));
       Contact_us.setIcon(ISB);
    }//GEN-LAST:event_Contact_usMouseExited

    private void Contact_usMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Contact_usMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Contact_us_hover2.png"));
       Contact_us.setIcon(ISB);
    }//GEN-LAST:event_Contact_usMouseReleased

    private void Terms_of_useMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Terms_of_useMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("Terms_of_use_hover2.png"));
       Terms_of_use.setIcon(ISB);
    }//GEN-LAST:event_Terms_of_useMouseEntered

    private void Terms_of_useMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Terms_of_useMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Terms_of_use_hover.png"));
       Terms_of_use.setIcon(ISB);
    }//GEN-LAST:event_Terms_of_useMouseExited

    private void Terms_of_useMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Terms_of_useMousePressed
       ImageIcon ISB=new ImageIcon(getClass().getResource("Terms_of_use_pressed2.png"));
       Terms_of_use.setIcon(ISB);
    }//GEN-LAST:event_Terms_of_useMousePressed

    private void Terms_of_useMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Terms_of_useMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Terms_of_use_hover2.png"));
       Terms_of_use.setIcon(ISB);
    }//GEN-LAST:event_Terms_of_useMouseReleased

    private void PrivacyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("Privacy_hover2.png"));
       Privacy.setIcon(ISB);
    }//GEN-LAST:event_PrivacyMouseEntered

    private void PrivacyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Privacy_hover.png"));
       Privacy.setIcon(ISB);
    }//GEN-LAST:event_PrivacyMouseExited

    private void PrivacyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Privacy_pressed2.png"));
       Privacy.setIcon(ISB);
    }//GEN-LAST:event_PrivacyMousePressed

    private void PrivacyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Privacy_hover2.png"));
       Privacy.setIcon(ISB);
    }//GEN-LAST:event_PrivacyMouseReleased

    private void Default_MininmizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_MininmizeMouseClicked
        this.setState(Welcome.ICONIFIED);
    }//GEN-LAST:event_Default_MininmizeMouseClicked

    private void Default_MininmizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_MininmizeMouseEntered
       ImageIcon II=new ImageIcon(getClass().getResource("Hover_minimize.png"));
       Default_Mininmize.setIcon(II);
    }//GEN-LAST:event_Default_MininmizeMouseEntered

    private void Default_MininmizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_MininmizeMouseExited
ImageIcon II=new ImageIcon(getClass().getResource("Default_minimize.png"));
       Default_Mininmize.setIcon(II);
    }//GEN-LAST:event_Default_MininmizeMouseExited

    private void Default_MininmizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_MininmizeMousePressed
        ImageIcon II=new ImageIcon(getClass().getResource("Pressed_minimize.png"));
        Default_Mininmize.setIcon(II);
    }//GEN-LAST:event_Default_MininmizeMousePressed

    private void Default_MininmizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_MininmizeMouseReleased
        ImageIcon II=new ImageIcon(getClass().getResource("Default_minimize.png"));
        Default_Mininmize.setIcon(II);
    }//GEN-LAST:event_Default_MininmizeMouseReleased

    private void Default_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_CloseMouseClicked
       System.exit(0);
    }//GEN-LAST:event_Default_CloseMouseClicked

    private void Default_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_CloseMouseEntered
         ImageIcon II=new ImageIcon(getClass().getResource("Hover_close.png"));
       Default_Close.setIcon(II);
    }//GEN-LAST:event_Default_CloseMouseEntered

    private void Default_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_CloseMouseExited
       ImageIcon II=new ImageIcon(getClass().getResource("Default_close.png"));
        Default_Close.setIcon(II);
    }//GEN-LAST:event_Default_CloseMouseExited

    private void Default_CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_CloseMousePressed
         ImageIcon II=new ImageIcon(getClass().getResource("Pressed_close.png"));
        Default_Close.setIcon(II);
    }//GEN-LAST:event_Default_CloseMousePressed

    private void Default_CloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Default_CloseMouseReleased
         ImageIcon II=new ImageIcon(getClass().getResource("Hover_close.png"));
        Default_Close.setIcon(II);
    }//GEN-LAST:event_Default_CloseMouseReleased

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void Frgt_passwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frgt_passwdMouseClicked
       ForgotPassword fpobj = new ForgotPassword();
       fpobj.setVisible(true);
       
    }//GEN-LAST:event_Frgt_passwdMouseClicked

    private void SignInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SignInButtonMouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked

                jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
       jPasswordField1.setText("");
    }//GEN-LAST:event_jPasswordField1MouseClicked
  
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", false);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }
                new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contact_us;
    private javax.swing.JLabel Default_Close;
    private javax.swing.JLabel Default_Mininmize;
    private javax.swing.JLabel Frgt_passwd;
    private javax.swing.JLabel Privacy;
    private javax.swing.JLabel SignInButton;
    private javax.swing.JLabel Terms_of_use;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
