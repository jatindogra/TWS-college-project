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
import javax.swing.UIManager;

/**
 *
 * @author Jatin
 */
public class ChangePassword extends javax.swing.JFrame {

    Connection con = null; Statement stmt = null; ResultSet rs = null;
    RandomStringGenerator rsg = new RandomStringGenerator();
    MD5Generator pass = new MD5Generator();
    PopUp popobj = new PopUp();
    static String idemail;
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
        SQLConnect sqlcon = new SQLConnect();
        con=sqlcon.sqlCon(con);
        jPasswordField2.setEnabled(false);
        jPasswordField3.setEnabled(false);
    }
     public static void email(String email_id){
        idemail = email_id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        taskbar = new javax.swing.JLabel();
        changepasslabel = new javax.swing.JLabel();
        Oldpass = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        changepasswordbutton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 420));
        setMinimumSize(new java.awt.Dimension(650, 420));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(650, 420));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Logo.png"))); // NOI18N
        logo.setText("jLabel2");
        getContentPane().add(logo);
        logo.setBounds(4, 0, 25, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_close.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(620, 5, 23, 15);

        taskbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Installation_Taskbar.png"))); // NOI18N
        getContentPane().add(taskbar);
        taskbar.setBounds(0, 0, 650, 25);

        changepasslabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        changepasslabel.setForeground(new java.awt.Color(153, 0, 153));
        changepasslabel.setText("Change Your Password");
        getContentPane().add(changepasslabel);
        changepasslabel.setBounds(80, 60, 243, 26);

        Oldpass.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Oldpass.setForeground(new java.awt.Color(153, 0, 153));
        Oldpass.setText("Old Password");
        getContentPane().add(Oldpass);
        Oldpass.setBounds(130, 155, 96, 18);

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("New Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 210, 103, 18);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 153));
        jLabel5.setText("Confirm New Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 265, 164, 18);

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(153, 0, 153));
        jPasswordField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jPasswordField1CaretUpdate(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(360, 155, 160, 21);

        jPasswordField2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(361, 211, 158, 19);

        jPasswordField3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPasswordField3.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(361, 266, 158, 19);

        changepasswordbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/ChangePassword.png"))); // NOI18N
        changepasswordbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changepasswordbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changepasswordbuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changepasswordbuttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changepasswordbuttonMouseReleased(evt);
            }
        });
        getContentPane().add(changepasswordbutton);
        changepasswordbutton.setBounds(240, 330, 160, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/InstallationBackkground.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changepasswordbuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordbuttonMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("ChangePassword_pressed.png"));
       changepasswordbutton.setIcon(ISB);
        String oldpassword = new String(jPasswordField1.getPassword());
        String newpassword = new String(jPasswordField2.getPassword());
        String confirmnewpassword = new String(jPasswordField3.getPassword());
        String password_md5 = pass.passwordgenerator(newpassword);
        try{
            stmt = con.createStatement();
            if(oldpassword.equals(newpassword)||oldpassword.equals(confirmnewpassword)){
                popobj.setMessagelabel("Old Password and New Password are same");
                popobj.setVisible(true);
                jPasswordField2.setText(null);
                jPasswordField3.setText(null);
            }
            else{
            if(newpassword.equals(confirmnewpassword)){
            stmt.executeUpdate("update login set password='"+password_md5+"' where email_id='"+idemail+"'");
            this.dispose();
            
        }
            else{
                popobj.setMessagelabel("Passwords don't match");
                popobj.setVisible(true);
                jPasswordField2.setText(null);
                jPasswordField3.setText(null);
            }
        }
        }
        catch(Exception e1){
            popobj.setMessagelabel("Exception occured : " + e1);
            popobj.setVisible(true);
        }
    }//GEN-LAST:event_changepasswordbuttonMousePressed

    private void changepasswordbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordbuttonMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("ChangePassword_hover.png"));
       changepasswordbutton.setIcon(ISB);   
    }//GEN-LAST:event_changepasswordbuttonMouseEntered

    private void changepasswordbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordbuttonMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("ChangePassword.png"));
       changepasswordbutton.setIcon(ISB);   
    }//GEN-LAST:event_changepasswordbuttonMouseExited

    private void changepasswordbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordbuttonMouseReleased
         ImageIcon ISB=new ImageIcon(getClass().getResource("ChangePassword_hover.png"));
       changepasswordbutton.setIcon(ISB);   
    }//GEN-LAST:event_changepasswordbuttonMouseReleased

    private void jPasswordField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jPasswordField1CaretUpdate
        String password_temp = new String(jPasswordField1.getPassword());
        String password_md5 = pass.passwordgenerator(password_temp);       
        try{
        stmt = con.createStatement();
        rs= stmt.executeQuery("select * from login where password='"+password_md5+"' and email_id='"+idemail+"'");
        if(rs.next())
        {
            
            jPasswordField2.setEnabled(true);
            
            jPasswordField3.setEnabled(true);
        }
        }
        catch(Exception e1){
            popobj.setMessagelabel("Exception occured : " + e1);
            popobj.setVisible(true);
        }
    }//GEN-LAST:event_jPasswordField1CaretUpdate

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        this.dispose();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseReleased

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ChangePassword().setVisible(true);
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Oldpass;
    private javax.swing.JLabel changepasslabel;
    private javax.swing.JLabel changepasswordbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel taskbar;
    // End of variables declaration//GEN-END:variables
}
