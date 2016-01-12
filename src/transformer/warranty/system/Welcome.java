/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import AppPackage.AnimationClass;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anugrah
 */
public class Welcome extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */ int Flag=1;
    AnimationClass AA = new AnimationClass();
    AnimationClass AB = new AnimationClass();
    AnimationClass AC = new AnimationClass();
    AnimationClass AD = new AnimationClass();
    AnimationClass AE = new AnimationClass();
    AnimationClass AF = new AnimationClass();
    AnimationClass AG= new AnimationClass();   
    static Connection con,c;Statement st,st1,st2;ResultSet rt,rt1; 
    static int date_of_warehouse,month_of_warehouse,year_of_warehouse,DWare;
    static int date_of_warranty,month_of_warranty,year_of_warranty,DTW;   
    static int date_of_expiry,month_of_expiry,year_of_expiry; 
    static int date1,month1,year1;
    String no_of_transformers; String po_no; String item;
    String buyer; String department; String price;
    String date; String month; String year;
    String warrantymonth;
    String warehousemonth;
    static String accountname;
    static String firstname;
    static String lastname;
    static String emailid;
    static String username;
    String name;
    
  
             
             
        
    public Welcome()  {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("Logo4.png")).getImage());
        this.invisible();
        this.slideshow4();
        about.setVisible(false);
        S_SpecificationNumber.setEnabled(false);
        S_PurchasedDate.setEnabled(false);
        S_PurchasedMonth.setEnabled(false);
        S_PurchasedYear.setEnabled(false);
        S_Warehouse.setEnabled(false);
        S_Warranty.setEnabled(false);
        PopUp pop = new PopUp();
        SQLConnect sqlcon = new SQLConnect();
        con=sqlcon.sqlCon(con);
        try{
            st = con.createStatement();
            st1=con.createStatement();
        }
        catch(Exception e){
           pop.setMessagelabel("Connection Failed");
        }
        
        uname.setVisible(false);
        uname.setEnabled(false);
        unamelabel.setVisible(false);
        unamelabel.setEnabled(false);
        id.setVisible(false);
        id.setEnabled(false);
        emailidlabel.setVisible(false);
        emailidlabel.setEnabled(false);
        typeacc.setVisible(false);
        typeacc.setEnabled(false);
        acctypelabel.setVisible(false);
        acctypelabel.setEnabled(false);
        deletebutton.setVisible(false);
        deletebutton.setEnabled(false);
        try{
            rt =con.prepareStatement("SELECT TOP 7 TID FROM historyinsert ORDER BY TID ASC").executeQuery();
            ArrayList<String> list = new ArrayList<String>();
            while(rt.next()){
                list.add(rt.getString("TID"));
            }
            String[] result = new String[list.size()];
            result = list.toArray(result);
            for(int i =0; i<result.length; i++){
            System.out.println(result[i]);
            }
            //R_history1.setText(result[0] + " was added");
        }
        catch(Exception e1){
            System.out.println(e1);
        }
        
    }
  public static void displayaccount(String account, String Username, String idemail, String first_name, String last_name){
      accountname = account;
      username = Username;
      emailid = idemail;
      firstname = first_name;
      lastname = last_name;
  }
  
  /*public void userdeletetable(){
      usertable.setFillsViewportHeight(true);
      String username, firstname, lastname, emailid, accounttype;
      
      try{
          rt= st.executeQuery("SELECT * FROM login");
           DefaultTableModel model=(DefaultTableModel) usertable.getModel();
           while(rt.next()){
               username = rt.getString(2);
               firstname = rt.getString(5);
               lastname = rt.getString(6);
               emailid = rt.getString(1);
               accounttype = rt.getString(4);
               model.addRow(new Object[] {username, firstname, lastname, emailid, accounttype});
              
           }
           
      }
      catch(Exception e1){
          PopUp pop = new PopUp();
          pop.setMessagelabel("Error Occured");         
      }
      
  }*/
          
    public void invisible()
    {
                    Search.setVisible(false);
                    Search.setEnabled(false);
                    searchby.setVisible(false);
                    searchby.setEnabled(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    Recently_added.setVisible(false);
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_add_history_button1.setVisible(false);
                    R_add_history_button2.setVisible(false);
                    R_add_history_button3.setVisible(false);
                    R_add_history_button4.setVisible(false);
                    R_add_history_button5.setVisible(false);
                    R_add_history_button6.setVisible(false);
                    R_add_history_button7.setVisible(false);
                    R_add_history_button1.setEnabled(false);
                    R_add_history_button2.setEnabled(false);
                    R_add_history_button3.setEnabled(false);
                    R_add_history_button4.setEnabled(false);
                    R_add_history_button5.setEnabled(false);
                    R_add_history_button6.setEnabled(false);
                    R_add_history_button7.setEnabled(false);
                    R_edit_history_button1.setVisible(false);
                    R_edit_history_button2.setVisible(false);
                    R_edit_history_button3.setVisible(false);
                    R_edit_history_button4.setVisible(false);
                    R_edit_history_button5.setVisible(false);
                    R_edit_history_button6.setVisible(false);
                    R_edit_history_button7.setVisible(false);
                    R_edit_history_button1.setEnabled(false);
                    R_edit_history_button2.setEnabled(false);
                    R_edit_history_button3.setEnabled(false);
                    R_edit_history_button4.setEnabled(false);
                    R_edit_history_button5.setEnabled(false);
                    R_edit_history_button6.setEnabled(false);
                    R_edit_history_button7.setEnabled(false);
                    R_delete_history_button1.setVisible(false);
                    R_delete_history_button2.setVisible(false);
                    R_delete_history_button3.setVisible(false);
                    R_delete_history_button4.setVisible(false);
                    R_delete_history_button5.setVisible(false);
                    R_delete_history_button6.setVisible(false);
                    R_delete_history_button7.setVisible(false);
                    R_delete_history_button1.setEnabled(false);
                    R_delete_history_button2.setEnabled(false);
                    R_delete_history_button3.setEnabled(false);
                    R_delete_history_button4.setEnabled(false);
                    R_delete_history_button5.setEnabled(false);
                    R_delete_history_button6.setEnabled(false);
                    R_delete_history_button7.setEnabled(false);
                    S_history_button1.setVisible(false);
                    S_history_button2.setVisible(false);
                    S_history_button3.setVisible(false);
                    S_history_button4.setVisible(false);
                    S_history_button5.setVisible(false);
                    S_history_button6.setVisible(false);
                    S_history_button7.setVisible(false);
                    S_history_button1.setEnabled(false);
                    S_history_button2.setEnabled(false);
                    S_history_button3.setEnabled(false);
                    S_history_button4.setEnabled(false);
                    S_history_button5.setEnabled(false);
                    S_history_button6.setEnabled(false);
                    S_history_button7.setEnabled(false);
                    Edit_Rightsidebarpanel.setVisible(false);
                    Edit_Rightsidebarpanel.setEnabled(false);
                    New_Rightsidebarpanel.setVisible(false);
                    New_Rightsidebarpanel.setEnabled(false);
                    Delete_Rightsidebarpanel.setVisible(false);
                    Delete_Rightsidebarpanel.setEnabled(false);
                    Search_Rightsidebarpanel.setVisible(false);
                    Search_Rightsidebarpanel.setEnabled(false);
                    Complain_Ridesidebarpanel.setVisible(false);
                    Complain_Ridesidebarpanel.setEnabled(false);
                    MultipleEntry.setEnabled(false);
                    MultipleEntry.setVisible(false);
                    Profile_Rightsidebarpanel.setEnabled(false);
                    Profile_Rightsidebarpanel.setVisible(false);
                    AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
                    
    }
     public void slideshow1()
    {
         new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    R_add_history1.setVisible(true);
                    R_add_history1_date.setVisible(true);
                    R_add_history2.setVisible(true);
                    R_add_history2_date.setVisible(true);
                    R_add_history3.setVisible(true);
                    R_add_history3_date.setVisible(true);
                    R_add_history4.setVisible(true);
                    R_add_history4_date.setVisible(true);
                    R_add_history5.setVisible(true);
                    R_add_history5_date.setVisible(true);
                    R_add_history6.setVisible(true);
                    R_add_history6_date.setVisible(true);
                    R_add_history7.setVisible(true);
                    R_add_history7_date.setVisible(true);
                    R_add_history1.setEnabled(true);
                    R_add_history1_date.setEnabled(true);
                    R_add_history2.setEnabled(true);
                    R_add_history2_date.setEnabled(true);
                    R_add_history3.setEnabled(true);
                    R_add_history3_date.setEnabled(true);
                    R_add_history4.setEnabled(true);
                    R_add_history4_date.setEnabled(true);
                    R_add_history5.setEnabled(true);
                    R_add_history5_date.setEnabled(true);
                    R_add_history6.setEnabled(true);
                    R_add_history6_date.setEnabled(true);
                    R_add_history7.setEnabled(true);
                    R_add_history7_date.setEnabled(true);
                    Recently_added.setVisible(true);
                    Recent.setVisible(false);
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                    //Thread.sleep(50);
                    AA.jLabelXRight(-170,6,2, 2, Recently_added);
                    
                    AA.jLabelXRight(-165,30,1, 3, R_add_history1);
                    AA.jLabelXRight(-99,30,2, 1,R_add_history1_date);
                    Thread.sleep(50);
                    AB.jLabelXRight(-165,30,1, 3,R_add_history2);
                    AB.jLabelXRight(-99,30,2, 1,R_add_history2_date);
                    //Thread.sleep(53);
                    AC.jLabelXRight(-165,30,1, 3, R_add_history3);
                    AC.jLabelXRight(-99,30,2, 1,R_add_history3_date);
                   // Thread.sleep(56);
                    AD.jLabelXRight(-165,30,1, 3,R_add_history4);
                    AD.jLabelXRight(-99,30,2, 1,R_add_history4_date);
                   // Thread.sleep(59);
                    AE.jLabelXRight(-165,30,1, 3, R_add_history5);
                    AE.jLabelXRight(-99,30,2, 1,R_add_history5_date);
                   // Thread.sleep(62);
                    AF.jLabelXRight(-165,30,1, 3, R_add_history6);
                    AF.jLabelXRight(-99,30,2, 1,R_add_history6_date);
                    Thread.sleep(50);
                    AG.jLabelXRight(-165,30,1, 3, R_add_history7);
                    AG.jLabelXRight(-99,30,2, 1,R_add_history7_date);
                    
                    AA.jLabelXLeft(6,-170,1, 2, Recently_edited);
                    AA.jLabelXLeft(6,-170,1, 2, Recently_deleted);
                    AA.jLabelXLeft(30,-165,1, 3, R_edit_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_edit_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_edit_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_edit_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_edit_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_edit_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_edit_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_edit_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_edit_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_edit_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_edit_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_edit_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_edit_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_edit_history7_date);
                    AA.jLabelXLeft(30,-165,1, 1, R_delete_history1);
                    AA.jLabelXLeft(30,-99,1, 1,R_delete_history1_date);
                    AB.jLabelXLeft(30,-165,1, 1,R_delete_history2);
                    AB.jLabelXLeft(30,-99,1, 1,R_delete_history2_date);
                    AC.jLabelXLeft(30,-165,1, 1, R_delete_history3);
                    AC.jLabelXLeft(30,-99,1, 1,R_delete_history3_date);
                    AD.jLabelXLeft(30,-165,1, 1, R_delete_history4);
                    AD.jLabelXLeft(30,-99,1, 1,R_delete_history4_date);
                    AE.jLabelXLeft(30,-165,1, 1, R_delete_history5);
                    AE.jLabelXLeft(30,-99,1, 1,R_delete_history5_date);
                    AF.jLabelXLeft(30,-165,1, 1, R_delete_history6);
                    AF.jLabelXLeft(30,-99,1, 1,R_delete_history6_date);
                    AG.jLabelXLeft(30,-165,1, 1, R_delete_history7);
                    AG.jLabelXLeft(30,-99,1, 1,R_delete_history7_date); 
                    
                 }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
    public void slideshow2()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    R_edit_history1.setVisible(true);
                    R_edit_history1_date.setVisible(true);
                    R_edit_history2.setVisible(true);
                    R_edit_history2_date.setVisible(true);
                    R_edit_history3.setVisible(true);
                    R_edit_history3_date.setVisible(true);
                    R_edit_history4.setVisible(true);
                    R_edit_history4_date.setVisible(true);
                    R_edit_history5.setVisible(true);
                    R_edit_history5_date.setVisible(true);
                    R_edit_history6.setVisible(true);
                    R_edit_history6_date.setVisible(true);
                    R_edit_history7.setVisible(true);
                    R_edit_history7_date.setVisible(true);
                    R_edit_history1.setEnabled(true);
                    R_edit_history1_date.setEnabled(true);
                    R_edit_history2.setEnabled(true);
                    R_edit_history2_date.setEnabled(true);
                    R_edit_history3.setEnabled(true);
                    R_edit_history3_date.setEnabled(true);
                    R_edit_history4.setEnabled(true);
                    R_edit_history4_date.setEnabled(true);
                    R_edit_history5.setEnabled(true);
                    R_edit_history5_date.setEnabled(true);
                    R_edit_history6.setEnabled(true);
                    R_edit_history6_date.setEnabled(true);
                    R_edit_history7.setEnabled(true);
                    R_edit_history7_date.setEnabled(true);
                    Recently_edited.setVisible(true);
                    Recently_added.setVisible(false);
                    Recent.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                   // Thread.sleep(50);
                    AA.jLabelXRight(-170,6,2, 2, Recently_edited);
                    AA.jLabelXRight(-165,30,1, 3, R_edit_history1);
                    AA.jLabelXRight(-99,30,2, 1,R_edit_history1_date);
                    Thread.sleep(50);
                    AB.jLabelXRight(-165,30,1, 3,R_edit_history2);
                    AB.jLabelXRight(-99,30,2, 1,R_edit_history2_date);
                  //  Thread.sleep(53);
                    AC.jLabelXRight(-165,30,1, 3, R_edit_history3);
                    AC.jLabelXRight(-99,30,2, 1,R_edit_history3_date);
                   // Thread.sleep(56);
                    AD.jLabelXRight(-165,30,1, 3,R_edit_history4);
                    AD.jLabelXRight(-99,30,2, 1,R_edit_history4_date);
                   // Thread.sleep(59);
                    AE.jLabelXRight(-165,30,1, 3, R_edit_history5);
                    AE.jLabelXRight(-99,30,2, 1,R_edit_history5_date);
                  //  Thread.sleep(62);
                    AF.jLabelXRight(-165,30,1, 3, R_edit_history6);
                    AF.jLabelXRight(-99,30,2, 1,R_edit_history6_date);
                    Thread.sleep(50);
                    AG.jLabelXRight(-165,30,1, 3, R_edit_history7);
                    AG.jLabelXRight(-99,30,2, 1,R_edit_history7_date);
                   
                    AA.jLabelXLeft(6,-170,1, 2, Recently_added);
                    AA.jLabelXLeft(6,-170,1, 2, Recently_deleted);
                    AA.jLabelXLeft(30,-165,1, 3, R_add_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_add_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_add_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_add_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_add_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_add_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_add_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_add_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_add_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_add_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_add_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_add_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_add_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_add_history7_date);
                    AA.jLabelXLeft(30,-165,1, 1, R_delete_history1);
                    AA.jLabelXLeft(30,-99,1, 1,R_delete_history1_date);
                    AB.jLabelXLeft(30,-165,1, 1,R_delete_history2);
                    AB.jLabelXLeft(30,-99,1, 1,R_delete_history2_date);
                    AC.jLabelXLeft(30,-165,1, 1, R_delete_history3);
                    AC.jLabelXLeft(30,-99,1, 1,R_delete_history3_date);
                    AD.jLabelXLeft(30,-165,1, 1, R_delete_history4);
                    AD.jLabelXLeft(30,-99,1, 1,R_delete_history4_date);
                    AE.jLabelXLeft(30,-165,1, 1, R_delete_history5);
                    AE.jLabelXLeft(30,-99,1, 1,R_delete_history5_date);
                    AF.jLabelXLeft(30,-165,1, 1, R_delete_history6);
                    AF.jLabelXLeft(30,-99,1, 1,R_delete_history6_date);
                    AG.jLabelXLeft(30,-165,1, 1, R_delete_history7);
                    AG.jLabelXLeft(30,-99,1, 1,R_delete_history7_date); 
                   
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
    public void slideshow3()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    R_delete_history1.setVisible(true);
                    R_delete_history1_date.setVisible(true);
                    R_delete_history2.setVisible(true);
                    R_delete_history2_date.setVisible(true);
                    R_delete_history3.setVisible(true);
                    R_delete_history3_date.setVisible(true);
                    R_delete_history4.setVisible(true);
                    R_delete_history4_date.setVisible(true);
                    R_delete_history5.setVisible(true);
                    R_delete_history5_date.setVisible(true);
                    R_delete_history6.setVisible(true);
                    R_delete_history6_date.setVisible(true);
                    R_delete_history7.setVisible(true);
                    R_delete_history7_date.setVisible(true);
                    R_delete_history1.setEnabled(true);
                    R_delete_history1_date.setEnabled(true);
                    R_delete_history2.setEnabled(true);
                    R_delete_history2_date.setEnabled(true);
                    R_delete_history3.setEnabled(true);
                    R_delete_history3_date.setEnabled(true);
                    R_delete_history4.setEnabled(true);
                    R_delete_history4_date.setEnabled(true);
                    R_delete_history5.setEnabled(true);
                    R_delete_history5_date.setEnabled(true);
                    R_delete_history6.setEnabled(true);
                    R_delete_history6_date.setEnabled(true);
                    R_delete_history7.setEnabled(true);
                    R_delete_history7_date.setEnabled(true);
                    Recently_deleted.setVisible(true);
                    Recently_edited.setVisible(false);
                    Recently_added.setVisible(false);
                    Recent.setVisible(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                    //Thread.sleep(50);
                    AA.jLabelXRight(-170,6,2, 2, Recently_deleted);
                    AA.jLabelXRight(-165,30,1, 3, R_delete_history1);
                    AA.jLabelXRight(-99,30,3, 1,R_delete_history1_date);
                   Thread.sleep(50);
                    AB.jLabelXRight(-165,30,1, 3,R_delete_history2);
                    AB.jLabelXRight(-99,30,3, 1,R_delete_history2_date);
                   // Thread.sleep(53);
                    AC.jLabelXRight(-165,30,1, 3, R_delete_history3);
                    AC.jLabelXRight(-99,30,3, 1,R_delete_history3_date);
                  //  Thread.sleep(56);
                    AD.jLabelXRight(-165,30,1, 3,R_delete_history4);
                    AD.jLabelXRight(-99,30,3, 1,R_delete_history4_date);
                 // Thread.sleep(59);
                    AE.jLabelXRight(-165,30,1, 3, R_delete_history5);
                    AE.jLabelXRight(-99,30,3, 1,R_delete_history5_date);
                  //  Thread.sleep(62);
                    AF.jLabelXRight(-165,30,1, 3, R_delete_history6);
                    AF.jLabelXRight(-99,30,3, 1,R_delete_history6_date);
                    Thread.sleep(50);
                    AG.jLabelXRight(-165,30,1, 3, R_delete_history7);
                    AG.jLabelXRight(-99,30,3, 1,R_delete_history7_date);
                    
                    AA.jLabelXLeft(6,-170,1, 2, Recently_edited);
                    AA.jLabelXLeft(6,-170,1, 2, Recently_added);
                    AA.jLabelXLeft(30,-165,1, 3, R_add_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_add_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_add_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_add_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_add_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_add_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_add_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_add_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_add_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_add_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_add_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_add_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_add_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_add_history7_date);
                    AA.jLabelXLeft(30,-165,1, 3, R_edit_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_edit_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_edit_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_edit_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_edit_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_edit_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_edit_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_edit_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_edit_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_edit_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_edit_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_edit_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_edit_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_edit_history7_date);  
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
      public void slideshow4()
    {
         new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Recent.setVisible(true);
                    Record_leftsidebarpanel.setVisible(true);
                    R_history1.setVisible(true);
                    R_history1_date.setVisible(true);
                    R_history2.setVisible(true);
                    R_history2_date.setVisible(true);
                    R_history3.setVisible(true);
                    R_history3_date.setVisible(true);
                    R_history4.setVisible(true);
                    R_history4_date.setVisible(true);
                    R_history5.setVisible(true);
                    R_history5_date.setVisible(true);
                    R_history6.setVisible(true);
                    R_history6_date.setVisible(true);
                    R_history7.setVisible(true);
                    R_history7_date.setVisible(true);
                    Recently_search.setVisible(false);
                    Search_leftsidebarpanel.setVisible(false);
                    View_leftsidebarpanel.setVisible(false);
                    VIEW.setVisible(false);
                    Profile_leftsidebarpanel.setVisible(false);
                    PROFILE.setVisible(false);
                    Help_leftsidebarpanel.setVisible(false);
                    HELP.setVisible(false);
                    S_history1.setVisible(false);
                    S_history1_date.setVisible(false);
                    S_history2.setVisible(false);
                    S_history2_date.setVisible(false);
                    S_history3.setVisible(false);
                    S_history3_date.setVisible(false);
                    S_history4.setVisible(false);
                    S_history4_date.setVisible(false);
                    S_history5.setVisible(false);
                    S_history5_date.setVisible(false);
                    S_history6.setVisible(false);
                    S_history6_date.setVisible(false);
                    S_history7.setVisible(false);
                    S_history7_date.setVisible(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    Recently_added.setVisible(false);
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    
                    R_history1.setEnabled(true);
                    R_history1_date.setEnabled(true);
                    R_history2.setEnabled(true);
                    R_history2_date.setEnabled(true);
                    R_history3.setEnabled(true);
                    R_history3_date.setEnabled(true);
                    R_history4.setEnabled(true);
                    R_history4_date.setEnabled(true);
                    R_history5.setEnabled(true);
                    R_history5_date.setEnabled(true);
                    R_history6.setEnabled(true);
                    R_history6_date.setEnabled(true);
                    R_history7.setEnabled(true);
                    R_history7_date.setEnabled(true);
                    S_history1.setEnabled(false);
                    S_history1_date.setEnabled(false);
                    S_history2.setEnabled(false);
                    S_history2_date.setEnabled(false);
                    S_history3.setEnabled(false);
                    S_history3_date.setEnabled(false);
                    S_history4.setEnabled(false);
                    S_history4_date.setEnabled(false);
                    S_history5.setEnabled(false);
                    S_history5_date.setEnabled(false);
                    S_history6.setEnabled(false);
                    S_history6_date.setEnabled(false);
                    S_history7.setEnabled(false);
                    S_history7_date.setEnabled(false);
                    AA.jLabelXRight(-100,0,2, 2, Record_leftsidebarpanel);
                    AA.jLabelXRight(-190,26,1, 3, Line);
                    Thread.sleep(50);
                    AA.jLabelXRight(-170,6,2, 1, Recent);
                    AA.jLabelXRight(-165,30,1, 3, R_history1);
                    AA.jLabelXRight(-99,30,2, 1,R_history1_date);
                    Thread.sleep(50);
                    AB.jLabelXRight(-165,30,1, 3,R_history2);
                    AB.jLabelXRight(-99,30,2, 1,R_history2_date);
                    AC.jLabelXRight(-165,30,1, 3, R_history3);
                    AC.jLabelXRight(-99,30,2, 1,R_history3_date);
                    AD.jLabelXRight(-165,30,1, 3,R_history4);
                    AD.jLabelXRight(-99,30,2, 1,R_history4_date);
                    AE.jLabelXRight(-165,30,1, 3, R_history5);
                    AE.jLabelXRight(-99,30,2, 1,R_history5_date);
                    AF.jLabelXRight(-165,30,1, 3, R_history6);
                    AF.jLabelXRight(-99,30,2, 1,R_history6_date);
                    Thread.sleep(50);
                    AG.jLabelXRight(-165,30,1, 3, R_history7);
                    AG.jLabelXRight(-99,30,2, 1,R_history7_date);
                    
                    
                    AA.jLabelXLeft(0,-100,2, 2, Search_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line1);
                    AA.jLabelXLeft(26,-190,1, 3, Line2);
                    AA.jLabelXLeft(26,-190,1, 3, Line3);
                    AA.jLabelXLeft(26,-190,1, 3, Line4);
                    AA.jLabelXLeft(6,-151,1, 1, Recently_search);
                    AA.jLabelXLeft(30,-165,1, 3, S_history1);
                    AA.jLabelXLeft(30,-99,1, 3,S_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,S_history2);
                    AB.jLabelXLeft(30,-99,1, 3,S_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, S_history3);
                    AC.jLabelXLeft(30,-99,1, 3,S_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, S_history4);
                    AD.jLabelXLeft(30,-99,1, 3,S_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, S_history5);
                    AE.jLabelXLeft(30,-99,1, 3,S_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, S_history6);
                    AF.jLabelXLeft(30,-99,1, 3,S_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, S_history7);
                    AG.jLabelXLeft(30,-99,1, 3,S_history7_date);
                    AA.jLabelXLeft(0,-100,2, 2, View_leftsidebarpanel);
                    AA.jLabelXLeft(16,-140,2, 1,VIEW);
                    AA.jLabelXLeft(0,-100,2, 2, Profile_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,PROFILE);
                    AA.jLabelXLeft(0,-100,2, 2, Help_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,HELP);
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
       public void slideshow5()
    {
         new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Recently_search.setVisible(true);
                    Search_leftsidebarpanel.setVisible(true);
                    S_history1.setVisible(true);
                    S_history1_date.setVisible(true);
                    S_history2.setVisible(true);
                    S_history2_date.setVisible(true);
                    S_history3.setVisible(true);
                    S_history3_date.setVisible(true);
                    S_history4.setVisible(true);
                    S_history4_date.setVisible(true);
                    S_history5.setVisible(true);
                    S_history5_date.setVisible(true);
                    S_history6.setVisible(true);
                    S_history6_date.setVisible(true);
                    S_history7.setVisible(true);
                    S_history7_date.setVisible(true);
                    Recent.setVisible(false);
                    Record_leftsidebarpanel.setVisible(false);
                    View_leftsidebarpanel.setVisible(false);
                    VIEW.setVisible(false);
                    Profile_leftsidebarpanel.setVisible(false);
                    PROFILE.setVisible(false);
                    Help_leftsidebarpanel.setVisible(false);
                    HELP.setVisible(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    Recently_added.setVisible(false);                    
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    Recently_search.setEnabled(true);
                    Search_leftsidebarpanel.setEnabled(true);
                    S_history1.setEnabled(true);
                    S_history1_date.setEnabled(true);
                    S_history2.setEnabled(true);
                    S_history2_date.setEnabled(true);
                    S_history3.setEnabled(true);
                    S_history3_date.setEnabled(true);
                    S_history4.setEnabled(true);
                    S_history4_date.setEnabled(true);
                    S_history5.setEnabled(true);
                    S_history5_date.setEnabled(true);
                    S_history6.setEnabled(true);
                    S_history6_date.setEnabled(true);
                    S_history7.setEnabled(true);
                    S_history7_date.setEnabled(true);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                  
                    AA.jLabelXRight(-100,0,2, 2, Search_leftsidebarpanel);
                    AA.jLabelXRight(-190,26,1, 3, Line1);
                    Thread.sleep(50);
                    AA.jLabelXRight(-151,6,2, 1, Recently_search);
                    AA.jLabelXRight(-165,30,1, 3, S_history1);
                    AA.jLabelXRight(-99,30,2, 1,S_history1_date);
                    Thread.sleep(50);
                    AB.jLabelXRight(-165,30,1, 3,S_history2);
                    AB.jLabelXRight(-99,30,2, 1,S_history2_date);
                    AC.jLabelXRight(-165,30,1, 3, S_history3);
                    AC.jLabelXRight(-99,30,2, 1,S_history3_date);
                    AD.jLabelXRight(-165,30,1, 3,S_history4);
                    AD.jLabelXRight(-99,30,2, 1,S_history4_date);
                    AE.jLabelXRight(-165,30,1, 3, S_history5);
                    AE.jLabelXRight(-99,30,2, 1,S_history5_date);
                    AF.jLabelXRight(-165,30,1, 3, S_history6);
                    AF.jLabelXRight(-99,30,2, 1,S_history6_date);
                    Thread.sleep(50);
                    AG.jLabelXRight(-165,30,1, 3, S_history7);
                    AG.jLabelXRight(-99,30,2, 1,S_history7_date);
                    
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(26,-190,1, 3, Line2);
                    AA.jLabelXLeft(26,-190,1, 3, Line3);
                    AA.jLabelXLeft(26,-190,1, 3, Line4);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,2, 2, View_leftsidebarpanel);
                    AA.jLabelXLeft(16,-140,2, 1,VIEW);
                    AA.jLabelXLeft(0,-100,2, 2, Profile_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,PROFILE);
                    AA.jLabelXLeft(0,-100,2, 2, Help_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,HELP);
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
    public void slideshow6()
    {
         new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    View_leftsidebarpanel.setVisible(true);
                    VIEW.setVisible(true);
                    Recently_search.setVisible(false);
                    Search_leftsidebarpanel.setVisible(false);
                    S_history1.setVisible(false);
                    S_history1_date.setVisible(false);
                    S_history2.setVisible(false);
                    S_history2_date.setVisible(false);
                    S_history3.setVisible(false);
                    S_history3_date.setVisible(false);
                    S_history4.setVisible(false);
                    S_history4_date.setVisible(false);
                    S_history5.setVisible(false);
                    S_history5_date.setVisible(false);
                    S_history6.setVisible(false);
                    S_history6_date.setVisible(false);
                    S_history7.setVisible(false);
                    S_history7_date.setVisible(false);
                    Recent.setVisible(false);
                    Record_leftsidebarpanel.setVisible(false);
                    Profile_leftsidebarpanel.setVisible(false);
                    PROFILE.setVisible(false);
                    Help_leftsidebarpanel.setVisible(false);
                    HELP.setVisible(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    Recently_added.setVisible(false);                    
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    Recently_search.setEnabled(false);
                    Search_leftsidebarpanel.setEnabled(false);
                    S_history1.setEnabled(false);
                    S_history1_date.setEnabled(false);
                    S_history2.setEnabled(false);
                    S_history2_date.setEnabled(false);
                    S_history3.setEnabled(false);
                    S_history3_date.setEnabled(false);
                    S_history4.setEnabled(false);
                    S_history4_date.setEnabled(false);
                    S_history5.setEnabled(false);
                    S_history5_date.setEnabled(false);
                    S_history6.setEnabled(false);
                    S_history6_date.setEnabled(false);
                    S_history7.setEnabled(false);
                    S_history7_date.setEnabled(false);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                  
                    AA.jLabelXRight(-100,0,2, 2, View_leftsidebarpanel);
                    AA.jLabelXRight(-190,26,1, 3, Line2);
                    Thread.sleep(50);
                    AA.jLabelXRight(-140,16,2, 2,VIEW);
                    AA.jLabelXLeft(0,-100,2, 2, Search_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line1);
                    AA.jLabelXLeft(6,-151,1, 1, Recently_search);
                    AA.jLabelXLeft(30,-165,1, 3, S_history1);
                    AA.jLabelXLeft(30,-99,1, 3,S_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,S_history2);
                    AB.jLabelXLeft(30,-99,1, 3,S_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, S_history3);
                    AC.jLabelXLeft(30,-99,1, 3,S_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, S_history4);
                    AD.jLabelXLeft(30,-99,1, 3,S_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, S_history5);
                    AE.jLabelXLeft(30,-99,1, 3,S_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, S_history6);
                    AF.jLabelXLeft(30,-99,1, 3,S_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, S_history7);
                    AG.jLabelXLeft(30,-99,1, 3,S_history7_date);
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(26,-190,1, 3, Line3);
                    AA.jLabelXLeft(26,-190,1, 3, Line4);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,2, 2, Profile_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,PROFILE);
                    AA.jLabelXLeft(0,-100,2, 2, Help_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,HELP);
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
    public void slideshow7()
    {
         new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Profile_leftsidebarpanel.setVisible(true);
                    PROFILE.setVisible(true);
                    View_leftsidebarpanel.setVisible(false);
                    VIEW.setVisible(false);
                    Recently_search.setVisible(false);
                    Search_leftsidebarpanel.setVisible(false);
                    S_history1.setVisible(false);
                    S_history1_date.setVisible(false);
                    S_history2.setVisible(false);
                    S_history2_date.setVisible(false);
                    S_history3.setVisible(false);
                    S_history3_date.setVisible(false);
                    S_history4.setVisible(false);
                    S_history4_date.setVisible(false);
                    S_history5.setVisible(false);
                    S_history5_date.setVisible(false);
                    S_history6.setVisible(false);
                    S_history6_date.setVisible(false);
                    S_history7.setVisible(false);
                    S_history7_date.setVisible(false);
                    Recent.setVisible(false);
                    Record_leftsidebarpanel.setVisible(false);
                    Help_leftsidebarpanel.setVisible(false);
                    HELP.setVisible(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    Recently_added.setVisible(false);                    
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    Recently_search.setEnabled(false);
                    Search_leftsidebarpanel.setEnabled(false);
                    S_history1.setEnabled(false);
                    S_history1_date.setEnabled(false);
                    S_history2.setEnabled(false);
                    S_history2_date.setEnabled(false);
                    S_history3.setEnabled(false);
                    S_history3_date.setEnabled(false);
                    S_history4.setEnabled(false);
                    S_history4_date.setEnabled(false);
                    S_history5.setEnabled(false);
                    S_history5_date.setEnabled(false);
                    S_history6.setEnabled(false);
                    S_history6_date.setEnabled(false);
                    S_history7.setEnabled(false);
                    S_history7_date.setEnabled(false);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                  
                    AA.jLabelXRight(-100,0,2, 2, Profile_leftsidebarpanel);
                    AA.jLabelXRight(-190,26,1, 3, Line3);
                    Thread.sleep(50);
                    AA.jLabelXRight(-140,14,2, 2,PROFILE);
                    AA.jLabelXLeft(0,-100,2, 2, Search_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line1);
                    AA.jLabelXLeft(6,-151,1, 1, Recently_search);
                    AA.jLabelXLeft(30,-165,1, 3, S_history1);
                    AA.jLabelXLeft(30,-99,1, 3,S_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,S_history2);
                    AB.jLabelXLeft(30,-99,1, 3,S_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, S_history3);
                    AC.jLabelXLeft(30,-99,1, 3,S_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, S_history4);
                    AD.jLabelXLeft(30,-99,1, 3,S_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, S_history5);
                    AE.jLabelXLeft(30,-99,1, 3,S_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, S_history6);
                    AF.jLabelXLeft(30,-99,1, 3,S_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, S_history7);
                    AG.jLabelXLeft(30,-99,1, 3,S_history7_date);
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(26,-190,1, 3, Line2);
                    AA.jLabelXLeft(26,-190,1, 3, Line4);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,2, 2, View_leftsidebarpanel);
                    AA.jLabelXLeft(16,-140,2, 1,VIEW);
                    AA.jLabelXLeft(0,-100,2, 2, Help_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,HELP);
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
    }
    public void slideshow8()
    {
         new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Help_leftsidebarpanel.setVisible(true);
                    HELP.setVisible(true);
                    Profile_leftsidebarpanel.setVisible(false);
                    PROFILE.setVisible(false);
                    View_leftsidebarpanel.setVisible(false);
                    VIEW.setVisible(false);
                    Recently_search.setVisible(false);
                    Search_leftsidebarpanel.setVisible(false);
                    S_history1.setVisible(false);
                    S_history1_date.setVisible(false);
                    S_history2.setVisible(false);
                    S_history2_date.setVisible(false);
                    S_history3.setVisible(false);
                    S_history3_date.setVisible(false);
                    S_history4.setVisible(false);
                    S_history4_date.setVisible(false);
                    S_history5.setVisible(false);
                    S_history5_date.setVisible(false);
                    S_history6.setVisible(false);
                    S_history6_date.setVisible(false);
                    S_history7.setVisible(false);
                    S_history7_date.setVisible(false);
                    Recent.setVisible(false);
                    Record_leftsidebarpanel.setVisible(false);
                    R_history1.setVisible(false);
                    R_history1_date.setVisible(false);
                    R_history2.setVisible(false);
                    R_history2_date.setVisible(false);
                    R_history3.setVisible(false);
                    R_history3_date.setVisible(false);
                    R_history4.setVisible(false);
                    R_history4_date.setVisible(false);
                    R_history5.setVisible(false);
                    R_history5_date.setVisible(false);
                    R_history6.setVisible(false);
                    R_history6_date.setVisible(false);
                    R_history7.setVisible(false);
                    R_history7_date.setVisible(false);
                    R_add_history1.setVisible(false);
                    R_add_history1_date.setVisible(false);
                    R_add_history2.setVisible(false);
                    R_add_history2_date.setVisible(false);
                    R_add_history3.setVisible(false);
                    R_add_history3_date.setVisible(false);
                    R_add_history4.setVisible(false);
                    R_add_history4_date.setVisible(false);
                    R_add_history5.setVisible(false);
                    R_add_history5_date.setVisible(false);
                    R_add_history6.setVisible(false);
                    R_add_history6_date.setVisible(false);
                    R_add_history7.setVisible(false);
                    R_add_history7_date.setVisible(false);
                    R_add_history1.setEnabled(false);
                    R_add_history1_date.setEnabled(false);
                    R_add_history2.setEnabled(false);
                    R_add_history2_date.setEnabled(false);
                    R_add_history3.setEnabled(false);
                    R_add_history3_date.setEnabled(false);
                    R_add_history4.setEnabled(false);
                    R_add_history4_date.setEnabled(false);
                    R_add_history5.setEnabled(false);
                    R_add_history5_date.setEnabled(false);
                    R_add_history6.setEnabled(false);
                    R_add_history6_date.setEnabled(false);
                    R_add_history7.setEnabled(false);
                    R_add_history7_date.setEnabled(false);
                    Recently_added.setVisible(false);                    
                    Recently_edited.setVisible(false);
                    Recently_deleted.setVisible(false);
                    R_edit_history1.setVisible(false);
                    R_edit_history1_date.setVisible(false);
                    R_edit_history2.setVisible(false);
                    R_edit_history2_date.setVisible(false);
                    R_edit_history3.setVisible(false);
                    R_edit_history3_date.setVisible(false);
                    R_edit_history4.setVisible(false);
                    R_edit_history4_date.setVisible(false);
                    R_edit_history5.setVisible(false);
                    R_edit_history5_date.setVisible(false);
                    R_edit_history6.setVisible(false);
                    R_edit_history6_date.setVisible(false);
                    R_edit_history7.setVisible(false);
                    R_edit_history7_date.setVisible(false);
                    R_edit_history1.setEnabled(false);
                    R_edit_history1_date.setEnabled(false);
                    R_edit_history2.setEnabled(false);
                    R_edit_history2_date.setEnabled(false);
                    R_edit_history3.setEnabled(false);
                    R_edit_history3_date.setEnabled(false);
                    R_edit_history4.setEnabled(false);
                    R_edit_history4_date.setEnabled(false);
                    R_edit_history5.setEnabled(false);
                    R_edit_history5_date.setEnabled(false);
                    R_edit_history6.setEnabled(false);
                    R_edit_history6_date.setEnabled(false);
                    R_edit_history7.setEnabled(false);
                    R_edit_history7_date.setEnabled(false);
                    R_delete_history1.setVisible(false);
                    R_delete_history1_date.setVisible(false);
                    R_delete_history2.setVisible(false);
                    R_delete_history2_date.setVisible(false);
                    R_delete_history3.setVisible(false);
                    R_delete_history3_date.setVisible(false);
                    R_delete_history4.setVisible(false);
                    R_delete_history4_date.setVisible(false);
                    R_delete_history5.setVisible(false);
                    R_delete_history5_date.setVisible(false);
                    R_delete_history6.setVisible(false);
                    R_delete_history6_date.setVisible(false);
                    R_delete_history7.setVisible(false);
                    R_delete_history7_date.setVisible(false);
                    R_delete_history1.setEnabled(false);
                    R_delete_history1_date.setEnabled(false);
                    R_delete_history2.setEnabled(false);
                    R_delete_history2_date.setEnabled(false);
                    R_delete_history3.setEnabled(false);
                    R_delete_history3_date.setEnabled(false);
                    R_delete_history4.setEnabled(false);
                    R_delete_history4_date.setEnabled(false);
                    R_delete_history5.setEnabled(false);
                    R_delete_history5_date.setEnabled(false);
                    R_delete_history6.setEnabled(false);
                    R_delete_history6_date.setEnabled(false);
                    R_delete_history7.setEnabled(false);
                    R_delete_history7_date.setEnabled(false);
                    Recently_search.setEnabled(false);
                    Search_leftsidebarpanel.setEnabled(false);
                    S_history1.setEnabled(false);
                    S_history1_date.setEnabled(false);
                    S_history2.setEnabled(false);
                    S_history2_date.setEnabled(false);
                    S_history3.setEnabled(false);
                    S_history3_date.setEnabled(false);
                    S_history4.setEnabled(false);
                    S_history4_date.setEnabled(false);
                    S_history5.setEnabled(false);
                    S_history5_date.setEnabled(false);
                    S_history6.setEnabled(false);
                    S_history6_date.setEnabled(false);
                    S_history7.setEnabled(false);
                    S_history7_date.setEnabled(false);
                    R_history1.setEnabled(false);
                    R_history1_date.setEnabled(false);
                    R_history2.setEnabled(false);
                    R_history2_date.setEnabled(false);
                    R_history3.setEnabled(false);
                    R_history3_date.setEnabled(false);
                    R_history4.setEnabled(false);
                    R_history4_date.setEnabled(false);
                    R_history5.setEnabled(false);
                    R_history5_date.setEnabled(false);
                    R_history6.setEnabled(false);
                    R_history6_date.setEnabled(false);
                    R_history7.setEnabled(false);
                    R_history7_date.setEnabled(false);
                  
                    AA.jLabelXRight(-100,0,2, 2,Help_leftsidebarpanel);
                    AA.jLabelXRight(-190,26,1, 3, Line4);
                    Thread.sleep(50);
                    AA.jLabelXRight(-140,14,2, 2,HELP);
                    AA.jLabelXLeft(0,-100,2, 2, Search_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line1);
                    AA.jLabelXLeft(6,-151,1, 1, Recently_search);
                    AA.jLabelXLeft(30,-165,1, 3, S_history1);
                    AA.jLabelXLeft(30,-99,1, 3,S_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,S_history2);
                    AB.jLabelXLeft(30,-99,1, 3,S_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, S_history3);
                    AC.jLabelXLeft(30,-99,1, 3,S_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, S_history4);
                    AD.jLabelXLeft(30,-99,1, 3,S_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, S_history5);
                    AE.jLabelXLeft(30,-99,1, 3,S_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, S_history6);
                    AF.jLabelXLeft(30,-99,1, 3,S_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, S_history7);
                    AG.jLabelXLeft(30,-99,1, 3,S_history7_date);
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(26,-190,1, 3, Line2);
                    AA.jLabelXLeft(26,-190,1, 3, Line3);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,1, 2, Record_leftsidebarpanel);
                    AA.jLabelXLeft(26,-190,1, 3, Line);
                    AA.jLabelXLeft(6,-170,1, 1, Recent);
                    AA.jLabelXLeft(30,-165,1, 3, R_history1);
                    AA.jLabelXLeft(30,-99,1, 3,R_history1_date);
                    AB.jLabelXLeft(30,-165,1, 3,R_history2);
                    AB.jLabelXLeft(30,-99,1, 3,R_history2_date);
                    AC.jLabelXLeft(30,-165,1, 3, R_history3);
                    AC.jLabelXLeft(30,-99,1, 3,R_history3_date);
                    AD.jLabelXLeft(30,-165,1, 3, R_history4);
                    AD.jLabelXLeft(30,-99,1, 3,R_history4_date);
                    AE.jLabelXLeft(30,-165,1, 3, R_history5);
                    AE.jLabelXLeft(30,-99,1, 3,R_history5_date);
                    AF.jLabelXLeft(30,-165,1, 3, R_history6);
                    AF.jLabelXLeft(30,-99,1, 3,R_history6_date);
                    AG.jLabelXLeft(30,-165,1, 3, R_history7);
                    AG.jLabelXLeft(30,-99,1, 3,R_history7_date);
                    AA.jLabelXLeft(0,-100,2, 2, View_leftsidebarpanel);
                    AA.jLabelXLeft(16,-140,2, 1,VIEW);
                    AA.jLabelXLeft(0,-100,2, 2,Profile_leftsidebarpanel);
                    AA.jLabelXLeft(14,-140,2, 1,PROFILE);
                }
                catch(Exception e)
                {
                    
                }
            }
        }.start();
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
   public void exceute3(int sno)
   {
       try
       {
           this.Cal_left1(1,date_of_warehouse,month_of_warehouse,year_of_warehouse);
           String query7="UPDATE "+Specification_no_textfield.getText()+" SET Installation_date="+date1+
                                                        ", Installation_month="+month1+
                                                        ", Installation_year="+year1+
                                                        ", Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                        ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                        ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                        ", Details='"+TextArea.getText()+"'"+
                                                        " WHERE Sno="+sno;
           st.executeUpdate(query7);
           String query12="UPDATE Transf_Details SET Installed_date="+date1+
                                                  ", Installed_month="+month1+
                                                  ", Installed_year="+year1+
                                                  " WHERE Tid='"+Specification_no_textfield.getText()+"'";
           st.executeUpdate(query12);
           String query6="SELECT * FROM Type_of_warranty WHERE Tid='"+Specification_no_textfield.getText()+"'";
           rt=st.executeQuery(query6);
           if(rt.next())
           {
               int mtw=rt.getInt(2);
               int warranty_days=rt.getInt(4)+1;
               caldate1(date1,month1,year1,mtw);
               String query9="UPDATE "+Specification_no_textfield.getText()+" SET Expiry_date="+date_of_warranty+", Expiry_month="+month_of_warranty+", Expiry_year="+year_of_warranty+" WHERE Sno="+sno;
               st.executeUpdate(query9);
               int d=date_of_warranty,m=month_of_warranty;int y=year_of_warranty;int d1=0,m1=0,y1=y;
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
               //date=d1;month=m1;year=y1;
               int minidate=d1;
               int minimonth=m1;
               int miniyear=y1;
               if(Integer.parseInt(Year_textfield.getText())==miniyear)
               {
                  if(Integer.parseInt(Month_textfield.getText())==minimonth)
                   {
                       if(Integer.parseInt(Date_textfield.getText())==minidate)
                       {
                           Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                           DTW=warranty_days-DTW-1;
                           String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                           st.executeUpdate(query8);
                           sno=sno+1;
                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                           st.executeUpdate(query11);
                           JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                        }
                       else
                       {
                           if(Integer.parseInt(Date_textfield.getText())<minidate)
                           {
                               Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                               DTW=warranty_days-DTW-1;
                               String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                               st.executeUpdate(query8);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                           }
                           else
                           {
                               Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                               DTW=warranty_days-DTW-1;
                               String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                               st.executeUpdate(query8);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                               JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                            }
                        }
                    }
                   else
                   {
                       if(Integer.parseInt(Month_textfield.getText())<minimonth)
                       {
                           Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                           DTW=warranty_days-DTW-1;
                           String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                           st.executeUpdate(query8);
                           sno=sno+1;
                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                           st.executeUpdate(query11);
                       }
                       else
                       {
                           Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                           DTW=warranty_days-DTW-1;
                           String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                           st.executeUpdate(query8);
                           sno=sno+1;
                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                           st.executeUpdate(query11);
                           JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                       }
                    }
                }
               else
               {
                   if(Integer.parseInt(Year_textfield.getText())<miniyear)
                   {
                       Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                       DTW=warranty_days-DTW-1;
                       String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                       st.executeUpdate(query8);
                       sno=sno+1;
                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                       st.executeUpdate(query11);
                   }
                   else
                   {
                       Cal_day1(date1,month1,year1,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                       DTW=warranty_days-DTW-1;
                       String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                       st.executeUpdate(query8);
                       sno=sno+1;
                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                       st.executeUpdate(query11);
                       JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                   }

                }
            } 
       }
       catch(Exception e)
       {
           
       }
   }
   public void execute5(int sno, int installationDate,int installationMonth,int installationYear)
   {
       try
       {
           String query7="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                        ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                        ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                        ", Details='"+TextArea.getText()+"'"+
                                                                        " WHERE Sno="+sno;
           st.executeUpdate(query7);
           String query6="SELECT * FROM Type_of_warranty WHERE Tid='"+Specification_no_textfield.getText()+"'";
           rt=st.executeQuery(query6);
           if(rt.next())
           {
               int warranty_days=rt.getInt(4)+1;
               String query9="SELECT * FROM "+Specification_no_textfield.getText()+" WHERE Sno="+sno;
               rt=st.executeQuery(query9);
               if(rt.next())
               {
                   int d=rt.getInt(14),m=rt.getInt(15);int y=rt.getInt(16);int d1=0,m1=0,y1=y; 
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
                                                   d1=d+1;m1=12;y1=y-1;;
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
                    //date=d1;month=m1;year=y1;
                   int minidate=d1;
                   int minimonth=m1;
                   int miniyear=y1;
                   if(Integer.parseInt(Year_textfield.getText())==miniyear)
                   {
                      if(Integer.parseInt(Month_textfield.getText())==minimonth)
                       {
                           if(Integer.parseInt(Date_textfield.getText())==minidate)
                           {
                               Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                               DTW=warranty_days-DTW-1;
                               String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                               st.executeUpdate(query8);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                               JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                            }
                           else
                           {
                               if(Integer.parseInt(Date_textfield.getText())<minidate)
                               {
                                   Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                                   DTW=warranty_days-DTW-1;
                                   String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                                   st.executeUpdate(query8);
                                   sno=sno+1;
                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                   st.executeUpdate(query11);
                               }
                               else
                               {
                                   Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                                   DTW=warranty_days-DTW-1;
                                   String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                                   st.executeUpdate(query8);
                                   sno=sno+1;
                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                   st.executeUpdate(query11);
                                   JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                                }
                            }
                        }
                       else
                       {
                           if(Integer.parseInt(Month_textfield.getText())<minimonth)
                           {
                               Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                               DTW=warranty_days-DTW-1;
                               String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                               st.executeUpdate(query8);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                           }
                           else
                           {
                               Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                               DTW=warranty_days-DTW-1;
                               String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                               st.executeUpdate(query8);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                               JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                           }
                        }
                    }
                   else
                   {
                       if(Integer.parseInt(Year_textfield.getText())<miniyear)
                       {
                           Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                           DTW=warranty_days-DTW-1;
                           String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                           st.executeUpdate(query8);
                           sno=sno+1;
                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                           st.executeUpdate(query11);
                       }
                       else
                       {
                           Cal_day1(installationDate,installationMonth,installationYear,Integer.parseInt(Date_textfield.getText()),Integer.parseInt(Month_textfield.getText()),Integer.parseInt(Year_textfield.getText()));
                           DTW=warranty_days-DTW-1;
                           String query8="UPDATE Type_of_warranty SET Warranty_Days="+DTW+" WHERE Tid='"+Specification_no_textfield.getText()+"'";
                           st.executeUpdate(query8);
                           sno=sno+1;
                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                           st.executeUpdate(query11);
                           JOptionPane.showMessageDialog(null, "Warranty period goes to the last six month");
                       }
                    }
                }
            }   
       }
       catch(Exception e)
       {
           
       }
   }
public void execute1(int sno,int expirydate,int expirymonth,int expiryyear,int purchasedate,int purchasemonth,int purchaseyear,int installationdate,int installationmonth,int installationyear)
{
   if(installationdate==0&&installationmonth==0&&installationyear==0)
   {
       this.caldate(purchasedate,purchasemonth,purchaseyear);
       try
       {
          if(Integer.parseInt(Year_textfield.getText())==purchaseyear)
           {
               if(Integer.parseInt(Month_textfield.getText())==purchasemonth)
               {
                   if(Integer.parseInt(Date_textfield.getText())==purchasedate)
                   {
                       JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                   }
                   else
                   {
                       if(Integer.parseInt(Date_textfield.getText())<purchasedate)
                       {
                           JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                       }
                       else
                       {
                           if(Integer.parseInt(Year_textfield.getText())==year_of_warehouse)
                           {
                               if(Integer.parseInt(Month_textfield.getText())==month_of_warehouse)
                               {
                                   if(Integer.parseInt(Date_textfield.getText())==date_of_warehouse)
                                   {
                                       String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                       st.executeUpdate(query3);
                                       sno=sno+1;
                                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                       st.executeUpdate(query11);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Date_textfield.getText())<date_of_warehouse)
                                       {
                                           String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                           st.executeUpdate(query3);
                                           sno=sno+1;
                                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                           st.executeUpdate(query11);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                       else
                                       {
                                           this.exceute3(sno);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                   }
                               }
                               else
                               {
                                   if(Integer.parseInt(Month_textfield.getText())<month_of_warehouse)
                                   {
                                       String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                       st.executeUpdate(query3);
                                       sno=sno+1;
                                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                       st.executeUpdate(query11);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                                   else
                                   {
                                       this.exceute3(sno);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                               }
                           }
                           else
                           {
                               if(Integer.parseInt(Year_textfield.getText())<year_of_warehouse)
                               {
                                   String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                   st.executeUpdate(query3);
                                   sno=sno+1;
                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                   st.executeUpdate(query11);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                               }
                               else
                               {
                                   this.exceute3(sno);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                               }
                           }
                       }
                   }
               }
               else
               {
                   if(Integer.parseInt(Month_textfield.getText())<purchasemonth)
                   {
                       JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                   }
                   else
                   {
                       if(Integer.parseInt(Year_textfield.getText())==year_of_warehouse)
                       {
                           if(Integer.parseInt(Month_textfield.getText())==month_of_warehouse)
                           {
                               if(Integer.parseInt(Date_textfield.getText())==date_of_warehouse)
                               {
                                   String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                   st.executeUpdate(query3);
                                   sno=sno+1;
                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                   st.executeUpdate(query11);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                                }
                               else
                               {
                                   if(Integer.parseInt(Date_textfield.getText())<date_of_warehouse)
                                   {
                                       String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                       st.executeUpdate(query3);
                                       sno=sno+1;
                                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                       st.executeUpdate(query11);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                                   else
                                   {
                                        this.exceute3(sno);
                                        JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                               }
                           }
                           else
                           {
                               if(Integer.parseInt(Month_textfield.getText())<month_of_warehouse)
                               {
                                   String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                   st.executeUpdate(query3);
                                   sno=sno+1;
                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                   st.executeUpdate(query11);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                               }
                               else
                               {
                                   this.exceute3(sno);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                               }
                           }
                       }
                       else
                       {
                           if(Integer.parseInt(Year_textfield.getText())<year_of_warehouse)
                           {
                               String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                               st.executeUpdate(query3);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                               JOptionPane.showMessageDialog(null, "Successfully Added");
                           }
                           else
                           {
                               this.exceute3(sno);
                               JOptionPane.showMessageDialog(null, "Successfully Added");
                           }
                       }
                   }
               }
            }
           else
           {
               if(Integer.parseInt(Year_textfield.getText())<purchaseyear)
               {
                   JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
               }
               else
               {
                   if(Integer.parseInt(Year_textfield.getText())==year_of_warehouse)
                   {
                       if(Integer.parseInt(Month_textfield.getText())==month_of_warehouse)
                       {
                           if(Integer.parseInt(Date_textfield.getText())==date_of_warehouse)
                           {
                               String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                               st.executeUpdate(query3);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                               JOptionPane.showMessageDialog(null, "Successfully Added");
                           }
                           else
                           {
                               if(Integer.parseInt(Date_textfield.getText())<date_of_warehouse)
                               {
                                    String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                                   st.executeUpdate(query3);
                                   sno=sno+1;
                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                   st.executeUpdate(query11);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                               }
                               else
                               {
                                    this.exceute3(sno);
                                    JOptionPane.showMessageDialog(null, "Successfully Added");
                               }
                           }
                       }
                       else
                       {
                           if(Integer.parseInt(Month_textfield.getText())<month_of_warehouse)
                           {
                               String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                               st.executeUpdate(query3);
                               sno=sno+1;
                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                               st.executeUpdate(query11);
                               JOptionPane.showMessageDialog(null, "Successfully Added");
                           }
                           else
                           {
                               this.exceute3(sno);
                               JOptionPane.showMessageDialog(null, "Successfully Added");
                           }
                       }
                   }
                   else
                   {
                       if(Integer.parseInt(Year_textfield.getText())<year_of_warehouse)
                       {
                           String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                    ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                    ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                    ", Details='"+TextArea.getText()+"'"+
                                                                                                                    " WHERE Sno="+sno;
                           st.executeUpdate(query3);
                           sno=sno+1;
                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                           st.executeUpdate(query11);
                           JOptionPane.showMessageDialog(null, "Successfully Added");
                       }
                       else
                       {
                           this.exceute3(sno);
                           JOptionPane.showMessageDialog(null, "Successfully Added");
                       }
                   }
               }
            }
        }
       catch(Exception e)
       {
          JOptionPane.showMessageDialog(null, e);
       }
    }
   else
   {
       try
       {
           if(Integer.parseInt(Year_textfield.getText())==installationyear)
           {
               if(Integer.parseInt(Month_textfield.getText())==installationmonth) 
               {
                   if(Integer.parseInt(Date_textfield.getText())==installationdate) 
                   {
                       JOptionPane.showMessageDialog(null, "Invalid Date");
                   }
                   else
                   {
                       if(Integer.parseInt(Date_textfield.getText())<installationdate)
                       {
                           JOptionPane.showMessageDialog(null, "Invalid Date");
                       }
                       else
                       {
                           this.execute5(sno,installationdate,installationmonth,installationyear);
                           JOptionPane.showMessageDialog(null, "Successfully Added");
                       }
                   }
               }
               else
               {
                   if(Integer.parseInt(Month_textfield.getText())<installationmonth)
                   {
                       JOptionPane.showMessageDialog(null, "Invalid Date");
                   }
                   else
                   {
                       this.execute5(sno,installationdate,installationmonth,installationyear);
                       JOptionPane.showMessageDialog(null, "Successfully Added");
                   }
               }
            }
            else
            {
                if(Integer.parseInt(Year_textfield.getText())<installationyear)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                }
                else
                {
                   this.execute5(sno,installationdate,installationmonth,installationyear);
                   JOptionPane.showMessageDialog(null, "Successfully Added");
                }
            }
        }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"Last"+e);    
       }
    }
}
public void execute2(int sno)
{
    try
    {
       String query12="SELECT * FROM "+Specification_no_textfield.getText()+" WHERE Sno="+sno;
       rt=st.executeQuery(query12);
       if(rt.next())
       {
           int purchasedate=rt.getInt(2);
           int purchasemonth=rt.getInt(3);
           int purchaseyear=rt.getInt(4);
           int installationdate=rt.getInt(5);
           int installationmonth=rt.getInt(6);
           int installationyear=rt.getInt(7);
           int temp=sno;
           String query13="SELECT * FROM "+Specification_no_textfield.getText()+" WHERE Sno="+temp;
           rt=st.executeQuery(query13);
           if(rt.next())
           {
               int Reinstallationdate=rt.getInt(11);
               int Reinstallationmonth=rt.getInt(12);
               int Reinstallationyear=rt.getInt(13);
               if(Reinstallationdate==0&&Reinstallationmonth==0&&Reinstallationyear==0)
               {
                   if(installationdate==0&&installationmonth==0&&installationyear==0)
                   {
                       this.caldate(purchasedate,purchasemonth,purchaseyear);
                       if(Integer.parseInt(Year_textfield.getText())==purchaseyear)
                       {
                           if(Integer.parseInt(Month_textfield.getText())==purchasemonth)
                           {
                               if(Integer.parseInt(Date_textfield.getText())==purchasedate)
                               {
                                   JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                               }
                               else
                               {
                                   if(Integer.parseInt(Date_textfield.getText())<purchasedate)
                                   {
                                       JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Year_textfield.getText())==year_of_warehouse)
                                       {
                                           if(Integer.parseInt(Month_textfield.getText())==month_of_warehouse)
                                           {
                                               if(Integer.parseInt(Date_textfield.getText())==date_of_warehouse)
                                               {
                                                   String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                                   st.executeUpdate(query3);
                                                   sno=sno+1;
                                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                                   st.executeUpdate(query11);
                                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                                               }
                                               else
                                               {
                                                   if(Integer.parseInt(Date_textfield.getText())<date_of_warehouse)
                                                   {
                                                       String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                                       st.executeUpdate(query3);
                                                       sno=sno+1;
                                                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                                       st.executeUpdate(query11);
                                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                                   }
                                                   else
                                                   {
                                                       this.exceute3(sno);
                                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                                   }
                                               }
                                           }
                                           else
                                           {
                                               if(Integer.parseInt(Month_textfield.getText())<month_of_warehouse)
                                               {
                                                   String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                                   st.executeUpdate(query3);
                                                   sno=sno+1;
                                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                                   st.executeUpdate(query11);
                                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                                               }
                                               else
                                               {
                                                   this.exceute3(sno);
                                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                                               }
                                           }
                                       }
                                       else
                                       {
                                           if(Integer.parseInt(Year_textfield.getText())<year_of_warehouse)
                                           {
                                               String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                               st.executeUpdate(query3);
                                               sno=sno+1;
                                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                               st.executeUpdate(query11);
                                               JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                           else
                                           {
                                               this.exceute3(sno);
                                               JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                       }
                                   }
                               }
                           }
                           else
                           {
                               if(Integer.parseInt(Month_textfield.getText())<purchasemonth)
                               {
                                   JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                               }
                               else
                               {
                                   if(Integer.parseInt(Year_textfield.getText())==year_of_warehouse)
                                   {
                                       if(Integer.parseInt(Month_textfield.getText())==month_of_warehouse)
                                       {
                                           if(Integer.parseInt(Date_textfield.getText())==date_of_warehouse)
                                           {
                                               String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                               st.executeUpdate(query3);
                                               sno=sno+1;
                                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                               st.executeUpdate(query11);
                                               JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                           else
                                           {
                                               if(Integer.parseInt(Date_textfield.getText())<date_of_warehouse)
                                               {
                                                   String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                                   st.executeUpdate(query3);
                                                   sno=sno+1;
                                                   String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                                   st.executeUpdate(query11);
                                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                                               }
                                               else
                                               {
                                                    this.exceute3(sno);
                                                    JOptionPane.showMessageDialog(null, "Successfully Added");
                                               }
                                           }
                                       }
                                       else
                                       {
                                           if(Integer.parseInt(Month_textfield.getText())<month_of_warehouse)
                                           {
                                               String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                               st.executeUpdate(query3);
                                               sno=sno+1;
                                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                               st.executeUpdate(query11);
                                               JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                           else
                                           {
                                               this.exceute3(sno);
                                               JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                       }
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Year_textfield.getText())<year_of_warehouse)
                                       {
                                           String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                           st.executeUpdate(query3);
                                           sno=sno+1;
                                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                           st.executeUpdate(query11);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                       else
                                       {
                                           this.exceute3(sno);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                   }
                               }
                           }
                       }
                       else
                       {
                           if(Integer.parseInt(Year_textfield.getText())<purchaseyear)
                           {
                               JOptionPane.showMessageDialog(null,"Complain Date is Invalid");
                           }
                           else
                           {
                               if(Integer.parseInt(Year_textfield.getText())==year_of_warehouse)
                               {
                                   if(Integer.parseInt(Month_textfield.getText())==month_of_warehouse)
                                   {
                                       if(Integer.parseInt(Date_textfield.getText())==date_of_warehouse)
                                       {
                                           String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                           st.executeUpdate(query3);
                                           sno=sno+1;
                                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                           st.executeUpdate(query11);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                       else
                                       {
                                           if(Integer.parseInt(Date_textfield.getText())<date_of_warehouse)
                                           {
                                                String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                               st.executeUpdate(query3);
                                               sno=sno+1;
                                               String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                               st.executeUpdate(query11);
                                               JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                           else
                                           {
                                                this.exceute3(sno);
                                                JOptionPane.showMessageDialog(null, "Successfully Added");
                                           }
                                       }
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Month_textfield.getText())<month_of_warehouse)
                                       {
                                           String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                           st.executeUpdate(query3);
                                           sno=sno+1;
                                           String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                           st.executeUpdate(query11);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                       else
                                       {
                                           this.exceute3(sno);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                   }
                               }
                               else
                               {
                                   if(Integer.parseInt(Year_textfield.getText())<year_of_warehouse)
                                   {
                                       String query3="UPDATE "+Specification_no_textfield.getText()+" SET Complain_date="+Integer.parseInt(Date_textfield.getText())+
                                                                                                                                ", Complain_month="+Integer.parseInt(Month_textfield.getText())+
                                                                                                                                ", Complain_year="+Integer.parseInt(Year_textfield.getText())+
                                                                                                                                ", Details='"+TextArea.getText()+"'"+
                                                                                                                                " WHERE Sno="+sno;
                                       st.executeUpdate(query3);
                                       sno=sno+1;
                                       String query11="INSERT INTO "+Specification_no_textfield.getText()+" VALUES("+sno+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+","+null+")";
                                       st.executeUpdate(query11);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                                   else
                                   {
                                       this.exceute3(sno);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                               }
                           }
                       }
                    }
                   else
                   {
                       try
                       {
                           if(Integer.parseInt(Year_textfield.getText())==installationyear)
                           {
                               if(Integer.parseInt(Month_textfield.getText())==installationmonth) 
                               {
                                   if(Integer.parseInt(Date_textfield.getText())==installationdate) 
                                   {
                                       JOptionPane.showMessageDialog(null, "Invalid Date");
                                   }
                                   else
                                   {
                                       if(Integer.parseInt(Date_textfield.getText())<installationdate)
                                       {
                                           JOptionPane.showMessageDialog(null, "Invalid Date");
                                       }
                                       else
                                       {
                                           this.execute5(sno,installationdate,installationmonth,installationyear);
                                           JOptionPane.showMessageDialog(null, "Successfully Added");
                                       }
                                   }
                               }
                               else
                               {
                                   if(Integer.parseInt(Month_textfield.getText())<installationmonth)
                                   {
                                       JOptionPane.showMessageDialog(null, "Invalid Date");
                                   }
                                   else
                                   {
                                       this.execute5(sno,installationdate,installationmonth,installationyear);
                                       JOptionPane.showMessageDialog(null, "Successfully Added");
                                   }
                               }
                            }
                            else
                            {
                                if(Integer.parseInt(Year_textfield.getText())<installationyear)
                                {
                                    JOptionPane.showMessageDialog(null, "Invalid Date");
                                }
                                else
                                {
                                   this.execute5(sno,installationdate,installationmonth,installationyear);
                                   JOptionPane.showMessageDialog(null, "Successfully Added");
                                }
                            }
                        }catch(Exception e)
                       {
                           JOptionPane.showMessageDialog(null,"Last"+e);    
                        }
                    }
                }
               else
               {
                    JOptionPane.showMessageDialog(null,"Previous Reinstallation date doesn't exist");
                }
           }
       }
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
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

        Background = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        taskbar = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        signout = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        view = new javax.swing.JLabel();
        record = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        menubar = new javax.swing.JLabel();
        Record = new javax.swing.JPanel();
        Delete = new javax.swing.JLabel();
        Edit = new javax.swing.JLabel();
        New = new javax.swing.JLabel();
        multiple = new javax.swing.JLabel();
        InstallationDate = new javax.swing.JLabel();
        popup1 = new javax.swing.JLabel();
        Search = new javax.swing.JPanel();
        searchby = new javax.swing.JLabel();
        Searchbypo = new javax.swing.JLabel();
        Searchbydepartment = new javax.swing.JLabel();
        Searchbyunderrepairpo = new javax.swing.JLabel();
        popup2 = new javax.swing.JLabel();
        View = new javax.swing.JPanel();
        ComplainButton = new javax.swing.JLabel();
        UnderRepair = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        popup3 = new javax.swing.JLabel();
        Profile = new javax.swing.JPanel();
        YourProfile = new javax.swing.JLabel();
        UserNew = new javax.swing.JLabel();
        deleteuser = new javax.swing.JLabel();
        popup4 = new javax.swing.JLabel();
        Help = new javax.swing.JPanel();
        popup5 = new javax.swing.JLabel();
        About = new javax.swing.JPanel();
        popup6 = new javax.swing.JLabel();
        Record_Leftsidebarpanel = new javax.swing.JPanel();
        Recent = new javax.swing.JLabel();
        Recently_added = new javax.swing.JLabel();
        Recently_edited = new javax.swing.JLabel();
        Recently_deleted = new javax.swing.JLabel();
        R_history_button1 = new javax.swing.JLabel();
        R_history_button2 = new javax.swing.JLabel();
        R_history_button3 = new javax.swing.JLabel();
        R_history_button4 = new javax.swing.JLabel();
        R_history_button5 = new javax.swing.JLabel();
        R_history_button6 = new javax.swing.JLabel();
        R_history_button7 = new javax.swing.JLabel();
        R_add_history_button1 = new javax.swing.JLabel();
        R_add_history_button2 = new javax.swing.JLabel();
        R_add_history_button3 = new javax.swing.JLabel();
        R_add_history_button4 = new javax.swing.JLabel();
        R_add_history_button5 = new javax.swing.JLabel();
        R_add_history_button6 = new javax.swing.JLabel();
        R_add_history_button7 = new javax.swing.JLabel();
        R_edit_history_button1 = new javax.swing.JLabel();
        R_edit_history_button2 = new javax.swing.JLabel();
        R_edit_history_button3 = new javax.swing.JLabel();
        R_edit_history_button4 = new javax.swing.JLabel();
        R_edit_history_button5 = new javax.swing.JLabel();
        R_edit_history_button6 = new javax.swing.JLabel();
        R_edit_history_button7 = new javax.swing.JLabel();
        R_delete_history_button1 = new javax.swing.JLabel();
        R_delete_history_button2 = new javax.swing.JLabel();
        R_delete_history_button3 = new javax.swing.JLabel();
        R_delete_history_button4 = new javax.swing.JLabel();
        R_delete_history_button5 = new javax.swing.JLabel();
        R_delete_history_button6 = new javax.swing.JLabel();
        R_delete_history_button7 = new javax.swing.JLabel();
        R_history1 = new javax.swing.JLabel();
        R_history1_date = new javax.swing.JLabel();
        R_history2 = new javax.swing.JLabel();
        R_history2_date = new javax.swing.JLabel();
        R_history3 = new javax.swing.JLabel();
        R_history3_date = new javax.swing.JLabel();
        R_history4 = new javax.swing.JLabel();
        R_history4_date = new javax.swing.JLabel();
        R_history5 = new javax.swing.JLabel();
        R_history5_date = new javax.swing.JLabel();
        R_history6 = new javax.swing.JLabel();
        R_history6_date = new javax.swing.JLabel();
        R_history7 = new javax.swing.JLabel();
        R_history7_date = new javax.swing.JLabel();
        R_add_history1 = new javax.swing.JLabel();
        R_add_history1_date = new javax.swing.JLabel();
        R_add_history2 = new javax.swing.JLabel();
        R_add_history2_date = new javax.swing.JLabel();
        R_add_history3 = new javax.swing.JLabel();
        R_add_history3_date = new javax.swing.JLabel();
        R_add_history4 = new javax.swing.JLabel();
        R_add_history4_date = new javax.swing.JLabel();
        R_add_history5 = new javax.swing.JLabel();
        R_add_history5_date = new javax.swing.JLabel();
        R_add_history6 = new javax.swing.JLabel();
        R_add_history6_date = new javax.swing.JLabel();
        R_add_history7 = new javax.swing.JLabel();
        R_add_history7_date = new javax.swing.JLabel();
        R_edit_history1 = new javax.swing.JLabel();
        R_edit_history1_date = new javax.swing.JLabel();
        R_edit_history2 = new javax.swing.JLabel();
        R_edit_history2_date = new javax.swing.JLabel();
        R_edit_history3 = new javax.swing.JLabel();
        R_edit_history3_date = new javax.swing.JLabel();
        R_edit_history4 = new javax.swing.JLabel();
        R_edit_history4_date = new javax.swing.JLabel();
        R_edit_history5 = new javax.swing.JLabel();
        R_edit_history5_date = new javax.swing.JLabel();
        R_edit_history6 = new javax.swing.JLabel();
        R_edit_history6_date = new javax.swing.JLabel();
        R_edit_history7 = new javax.swing.JLabel();
        R_edit_history7_date = new javax.swing.JLabel();
        R_delete_history1 = new javax.swing.JLabel();
        R_delete_history1_date = new javax.swing.JLabel();
        R_delete_history2 = new javax.swing.JLabel();
        R_delete_history2_date = new javax.swing.JLabel();
        R_delete_history3 = new javax.swing.JLabel();
        R_delete_history3_date = new javax.swing.JLabel();
        R_delete_history4 = new javax.swing.JLabel();
        R_delete_history4_date = new javax.swing.JLabel();
        R_delete_history5 = new javax.swing.JLabel();
        R_delete_history5_date = new javax.swing.JLabel();
        R_delete_history6 = new javax.swing.JLabel();
        R_delete_history6_date = new javax.swing.JLabel();
        R_delete_history7 = new javax.swing.JLabel();
        R_delete_history7_date = new javax.swing.JLabel();
        Line = new javax.swing.JLabel();
        Record_leftsidebarpanel = new javax.swing.JLabel();
        Search_Leftsidebarpanel = new javax.swing.JPanel();
        Recently_search = new javax.swing.JLabel();
        S_history_button1 = new javax.swing.JLabel();
        S_history_button2 = new javax.swing.JLabel();
        S_history_button3 = new javax.swing.JLabel();
        S_history_button4 = new javax.swing.JLabel();
        S_history_button5 = new javax.swing.JLabel();
        S_history_button6 = new javax.swing.JLabel();
        S_history_button7 = new javax.swing.JLabel();
        S_history1 = new javax.swing.JLabel();
        S_history1_date = new javax.swing.JLabel();
        S_history2 = new javax.swing.JLabel();
        S_history2_date = new javax.swing.JLabel();
        S_history3 = new javax.swing.JLabel();
        S_history3_date = new javax.swing.JLabel();
        S_history4 = new javax.swing.JLabel();
        S_history4_date = new javax.swing.JLabel();
        S_history5 = new javax.swing.JLabel();
        S_history5_date = new javax.swing.JLabel();
        S_history6 = new javax.swing.JLabel();
        S_history6_date = new javax.swing.JLabel();
        S_history7 = new javax.swing.JLabel();
        S_history7_date = new javax.swing.JLabel();
        Line1 = new javax.swing.JLabel();
        Search_leftsidebarpanel = new javax.swing.JLabel();
        View_Leftsidebarpanel = new javax.swing.JPanel();
        VIEW = new javax.swing.JLabel();
        Line2 = new javax.swing.JLabel();
        View_leftsidebarpanel = new javax.swing.JLabel();
        Profile_Leftsidebarpanel = new javax.swing.JPanel();
        PROFILE = new javax.swing.JLabel();
        Line3 = new javax.swing.JLabel();
        Profile_leftsidebarpanel = new javax.swing.JLabel();
        Help_Leftsidebarpanel = new javax.swing.JPanel();
        HELP = new javax.swing.JLabel();
        Line4 = new javax.swing.JLabel();
        Help_leftsidebarpanel = new javax.swing.JLabel();
        New_Rightsidebarpanel = new javax.swing.JPanel();
        SpecficationNoTextField = new javax.swing.JTextField();
        DateTextField = new javax.swing.JTextField();
        MonthTextField = new javax.swing.JTextField();
        PoNoTextField = new javax.swing.JTextField();
        DeptTextField = new javax.swing.JTextField();
        YearTextField = new javax.swing.JTextField();
        ItemTextField = new javax.swing.JTextField();
        BuyerTextField = new javax.swing.JTextField();
        PriceTextField = new javax.swing.JTextField();
        WarrantyMonth = new javax.swing.JTextField();
        WarehouseMonth = new javax.swing.JTextField();
        WarningArea = new javax.swing.JLabel();
        SpecificationEditTxt = new javax.swing.JLabel();
        SpecificationNo = new javax.swing.JLabel();
        PurchasedDate = new javax.swing.JLabel();
        DateField = new javax.swing.JLabel();
        MonthField = new javax.swing.JLabel();
        Dash1 = new javax.swing.JLabel();
        Dash2 = new javax.swing.JLabel();
        PoNo = new javax.swing.JLabel();
        PoNoField = new javax.swing.JLabel();
        Item = new javax.swing.JLabel();
        TypeOfWarranty = new javax.swing.JLabel();
        Place = new javax.swing.JLabel();
        PlaceField = new javax.swing.JLabel();
        NEW = new javax.swing.JLabel();
        Astrisk1 = new javax.swing.JLabel();
        Astrisk2 = new javax.swing.JLabel();
        YearField = new javax.swing.JLabel();
        ItemField = new javax.swing.JLabel();
        Mandatory = new javax.swing.JLabel();
        Astrisk3 = new javax.swing.JLabel();
        Astrisk4 = new javax.swing.JLabel();
        Bar = new javax.swing.JLabel();
        BuyerField = new javax.swing.JLabel();
        Buyer = new javax.swing.JLabel();
        Astrisk5 = new javax.swing.JLabel();
        Astrisk6 = new javax.swing.JLabel();
        Astrisk7 = new javax.swing.JLabel();
        NextButton = new javax.swing.JLabel();
        CancelButton = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        PriceField = new javax.swing.JLabel();
        Astrisk8 = new javax.swing.JLabel();
        WarrantyTextbox = new javax.swing.JLabel();
        Divide = new javax.swing.JLabel();
        WarehouseTextbox = new javax.swing.JLabel();
        New_rightsidebarpanel = new javax.swing.JLabel();
        Edit_Rightsidebarpanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Search_SpecificationNumber = new javax.swing.JTextField();
        E_SpecificationNumber = new javax.swing.JLabel();
        S_SpecificationNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        S_PONumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        S_PurchasedMonth = new javax.swing.JTextField();
        S_PurchasedDate = new javax.swing.JTextField();
        S_PurchasedYear = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        S_Warehouse = new javax.swing.JTextField();
        S_Warranty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        S_Item = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        S_Buyer = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        S_Price = new javax.swing.JTextField();
        S_submit = new javax.swing.JLabel();
        S_next = new javax.swing.JLabel();
        S_cancel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        S_Department = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Edit_rightsidebarpanel = new javax.swing.JLabel();
        Delete_Rightsidebarpanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Delete_SpecificationNumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        D_Item = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        D_Price = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        D_PurchasedYear = new javax.swing.JLabel();
        D_Warehouse = new javax.swing.JLabel();
        D_PurchasedMonth = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        D_Po_No = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        D_PurchasedDate = new javax.swing.JLabel();
        D_Warranty = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        D_Buyer = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        D_SpecificationNumber = new javax.swing.JLabel();
        D_submit = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        D_Department = new javax.swing.JLabel();
        D_next = new javax.swing.JLabel();
        D_cancel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Delete_rightsidebarpanel = new javax.swing.JLabel();
        MultipleEntry = new javax.swing.JPanel();
        No_ofTransformersTextField1 = new javax.swing.JTextField();
        DateTextField1 = new javax.swing.JTextField();
        MonthTextField1 = new javax.swing.JTextField();
        PoNoTextField1 = new javax.swing.JTextField();
        YearTextField1 = new javax.swing.JTextField();
        DeptTextField1 = new javax.swing.JTextField();
        ItemTextField1 = new javax.swing.JTextField();
        BuyerTextField1 = new javax.swing.JTextField();
        PriceTextField1 = new javax.swing.JTextField();
        WarrantyMonth1 = new javax.swing.JTextField();
        WarehouseMonth1 = new javax.swing.JTextField();
        TypeOfWarranty1 = new javax.swing.JLabel();
        Item1 = new javax.swing.JLabel();
        PoNoField1 = new javax.swing.JLabel();
        PoNo1 = new javax.swing.JLabel();
        Dash3 = new javax.swing.JLabel();
        Dash4 = new javax.swing.JLabel();
        MonthField1 = new javax.swing.JLabel();
        DateField1 = new javax.swing.JLabel();
        PurchasedDate1 = new javax.swing.JLabel();
        No_ofTransformers = new javax.swing.JLabel();
        SpecificationEditTxt1 = new javax.swing.JLabel();
        WarningArea2 = new javax.swing.JLabel();
        Place1 = new javax.swing.JLabel();
        PlaceField1 = new javax.swing.JLabel();
        NEW1 = new javax.swing.JLabel();
        Astrisk9 = new javax.swing.JLabel();
        Astrisk10 = new javax.swing.JLabel();
        ItemField1 = new javax.swing.JLabel();
        Mandatory2 = new javax.swing.JLabel();
        Astrisk11 = new javax.swing.JLabel();
        Astrisk12 = new javax.swing.JLabel();
        YearField1 = new javax.swing.JLabel();
        Bar2 = new javax.swing.JLabel();
        BuyerField1 = new javax.swing.JLabel();
        Buyer1 = new javax.swing.JLabel();
        Astrisk13 = new javax.swing.JLabel();
        Astrisk14 = new javax.swing.JLabel();
        Astrisk15 = new javax.swing.JLabel();
        NextButton1 = new javax.swing.JLabel();
        WarehouseTextbox1 = new javax.swing.JLabel();
        Divide1 = new javax.swing.JLabel();
        WarrantyTextbox1 = new javax.swing.JLabel();
        Astrisk16 = new javax.swing.JLabel();
        PriceField1 = new javax.swing.JLabel();
        Price1 = new javax.swing.JLabel();
        CancelButton1 = new javax.swing.JLabel();
        New_rightsidebarpanel1 = new javax.swing.JLabel();
        Search_Rightsidebarpanel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        Search_Specification_Number = new javax.swing.JTextField();
        Se_Submit = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Se_Item = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Se_PurchasedMonth = new javax.swing.JLabel();
        Se_PurchasedYear = new javax.swing.JLabel();
        Se_Warehouse = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        Se_Price = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Se_PurchasedDate = new javax.swing.JLabel();
        Se_Warranty = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        Se_Po_No = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        Se_Buyer = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        Se_SpecificationNumber = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Se_Department = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Search_rightsidebarpanel1 = new javax.swing.JLabel();
        SearchByPO = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        SearchByPONumber = new javax.swing.JTextField();
        SearchByPO_Submit = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        Search_rightsidebarpanel = new javax.swing.JLabel();
        SearchByDepartment = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        SD_Department = new javax.swing.JTextField();
        SD_Submit = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        Search_rightsidebarpanel2 = new javax.swing.JLabel();
        SearchByUnderPO = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        SUP_Po_No = new javax.swing.JTextField();
        SUP_Submit = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        Search_rightsidebarpanel3 = new javax.swing.JLabel();
        Complain_Ridesidebarpanel = new javax.swing.JPanel();
        Specification_no_textfield = new javax.swing.JTextField();
        Date_textfield = new javax.swing.JTextField();
        Month_textfield = new javax.swing.JTextField();
        Year_textfield = new javax.swing.JTextField();
        COMPLAIN = new javax.swing.JLabel();
        Specification_No = new javax.swing.JLabel();
        Specification_no_textbox = new javax.swing.JLabel();
        Date_of_complain = new javax.swing.JLabel();
        Date_textbox = new javax.swing.JLabel();
        Separator1 = new javax.swing.JLabel();
        Mandatory1 = new javax.swing.JLabel();
        WarningArea1 = new javax.swing.JLabel();
        Month_textbox = new javax.swing.JLabel();
        Separator2 = new javax.swing.JLabel();
        year_textbox = new javax.swing.JLabel();
        Cause_of_failure = new javax.swing.JLabel();
        Next_button = new javax.swing.JLabel();
        Cancel_button = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        Text_box = new javax.swing.JLabel();
        Bar1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Complain_background = new javax.swing.JLabel();
        Profile_Rightsidebarpanel = new javax.swing.JPanel();
        NEW2 = new javax.swing.JLabel();
        accountype = new javax.swing.JLabel();
        Bar3 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Emailid = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        Firstname = new javax.swing.JLabel();
        Lastname = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        PasswordField = new javax.swing.JLabel();
        EditButton3 = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        firstnamelabel = new javax.swing.JLabel();
        lastnamelabel = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        Profile_rightsidebarpanel = new javax.swing.JLabel();
        AddNewUser = new javax.swing.JPanel();
        username1 = new javax.swing.JLabel();
        accountype1 = new javax.swing.JLabel();
        firstname1 = new javax.swing.JLabel();
        Bar4 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        NEW3 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        lastname1 = new javax.swing.JLabel();
        UsernameField1 = new javax.swing.JLabel();
        UsernameTextField1 = new javax.swing.JTextField();
        FirstNameField1 = new javax.swing.JLabel();
        FirstNameTextField1 = new javax.swing.JTextField();
        javax.swing.JLabel LastnameField1 = new javax.swing.JLabel();
        LastNameTextField1 = new javax.swing.JTextField();
        PasswordField1 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        EmailTextField1 = new javax.swing.JTextField();
        EmailField1 = new javax.swing.JLabel();
        accounttype = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        Astrisk17 = new javax.swing.JLabel();
        confpassword = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        PasswordField2 = new javax.swing.JLabel();
        Astrisk18 = new javax.swing.JLabel();
        Astrisk19 = new javax.swing.JLabel();
        Astrisk20 = new javax.swing.JLabel();
        Astrisk21 = new javax.swing.JLabel();
        Createbutton = new javax.swing.JLabel();
        Warninguser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DeleteUserPanel = new javax.swing.JPanel();
        NEW4 = new javax.swing.JLabel();
        Bar5 = new javax.swing.JLabel();
        deletebutton = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        uname = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        typeacc = new javax.swing.JLabel();
        unamelabel = new javax.swing.JLabel();
        emailidlabel = new javax.swing.JLabel();
        acctypelabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HelpRightside_panel = new javax.swing.JPanel();
        NEW6 = new javax.swing.JLabel();
        Bar7 = new javax.swing.JLabel();
        installhelp = new javax.swing.JLabel();
        addrecord = new javax.swing.JLabel();
        reinstallhelp = new javax.swing.JLabel();
        addcomplain = new javax.swing.JLabel();
        usingprofile = new javax.swing.JLabel();
        workingrecord = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Background.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_close.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeMouseReleased(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 4, -1, -1));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_minimize.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeMouseReleased(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 4, -1, -1));

        Name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Name2.png"))); // NOI18N
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Logo.png"))); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, -1, -1));

        taskbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Taskbar1.png"))); // NOI18N
        getContentPane().add(taskbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 25));

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Home_default.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeMouseReleased(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Sign_default.png"))); // NOI18N
        signout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signoutMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signoutMouseReleased(evt);
            }
        });
        getContentPane().add(signout, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 25, -1, -1));

        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/About_default.png"))); // NOI18N
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aboutMouseReleased(evt);
            }
        });
        getContentPane().add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 25, -1, -1));

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Help_default.png"))); // NOI18N
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                helpMouseReleased(evt);
            }
        });
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 25, -1, -1));

        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Profile_default.png"))); // NOI18N
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profileMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profileMouseReleased(evt);
            }
        });
        getContentPane().add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 25, -1, -1));

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Complain_Default.png"))); // NOI18N
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                viewMouseReleased(evt);
            }
        });
        getContentPane().add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 25, -1, -1));

        record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Record_pressed.png"))); // NOI18N
        record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recordMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                recordMouseReleased(evt);
            }
        });
        getContentPane().add(record, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 25, -1, -1));

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Search_default.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchMouseReleased(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 25, -1, -1));

        menubar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Menubar_1.png"))); // NOI18N
        getContentPane().add(menubar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        Record.setMaximumSize(new java.awt.Dimension(1024, 105));
        Record.setMinimumSize(new java.awt.Dimension(1024, 105));
        Record.setOpaque(false);
        Record.setPreferredSize(new java.awt.Dimension(1024, 105));
        Record.setRequestFocusEnabled(false);
        Record.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Deleteicon3.png"))); // NOI18N
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DeleteMouseReleased(evt);
            }
        });
        Record.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 12, -1, -1));

        Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Editicon.png"))); // NOI18N
        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EditMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditMouseReleased(evt);
            }
        });
        Record.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 12, -1, -1));

        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Newicon.png"))); // NOI18N
        New.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        New.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewMouseReleased(evt);
            }
        });
        Record.add(New, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        multiple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Multiple.png"))); // NOI18N
        multiple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multipleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                multipleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                multipleMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                multipleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                multipleMouseReleased(evt);
            }
        });
        Record.add(multiple, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 12, -1, -1));

        InstallationDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/InstallationButton_default.png"))); // NOI18N
        InstallationDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InstallationDateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InstallationDateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InstallationDateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InstallationDateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                InstallationDateMouseReleased(evt);
            }
        });
        Record.add(InstallationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 12, -1, -1));

        popup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/popup.png"))); // NOI18N
        popup1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                popup1MousePressed(evt);
            }
        });
        Record.add(popup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Record, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 1024, 105));

        Search.setMaximumSize(new java.awt.Dimension(1024, 105));
        Search.setOpaque(false);
        Search.setPreferredSize(new java.awt.Dimension(1024, 105));
        Search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchby.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/searchicon.png"))); // NOI18N
        searchby.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchby.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchbyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchbyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchbyMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchbyMouseReleased(evt);
            }
        });
        Search.add(searchby, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        Searchbypo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Searchpo.png"))); // NOI18N
        Searchbypo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchbypoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchbypoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchbypoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SearchbypoMouseReleased(evt);
            }
        });
        Search.add(Searchbypo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 12, -1, -1));

        Searchbydepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/searchdep.png"))); // NOI18N
        Searchbydepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchbydepartmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchbydepartmentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchbydepartmentMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SearchbydepartmentMouseReleased(evt);
            }
        });
        Search.add(Searchbydepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 12, -1, -1));

        Searchbyunderrepairpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/UnderRepairPo.png"))); // NOI18N
        Searchbyunderrepairpo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchbyunderrepairpoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchbyunderrepairpoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchbyunderrepairpoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SearchbyunderrepairpoMouseReleased(evt);
            }
        });
        Search.add(Searchbyunderrepairpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 12, -1, -1));

        popup2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/popup.png"))); // NOI18N
        Search.add(popup2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        View.setMaximumSize(new java.awt.Dimension(1024, 105));
        View.setOpaque(false);
        View.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComplainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/ComplainButton_default.png"))); // NOI18N
        ComplainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ComplainButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ComplainButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ComplainButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ComplainButtonMouseReleased(evt);
            }
        });
        View.add(ComplainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        UnderRepair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/UnderRepairButton_default.png"))); // NOI18N
        UnderRepair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UnderRepairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UnderRepairMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UnderRepairMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UnderRepairMouseReleased(evt);
            }
        });
        View.add(UnderRepair, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 12, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/ReinstallationButton_default.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        View.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 12, -1, -1));

        popup3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/popup.png"))); // NOI18N
        View.add(popup3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(View, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        Profile.setMaximumSize(new java.awt.Dimension(1024, 105));
        Profile.setOpaque(false);
        Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        YourProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/YourProfile.png"))); // NOI18N
        YourProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YourProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YourProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YourProfileMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                YourProfileMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                YourProfileMouseReleased(evt);
            }
        });
        Profile.add(YourProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        UserNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NewUser.png"))); // NOI18N
        UserNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserNewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserNewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UserNewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UserNewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UserNewMouseReleased(evt);
            }
        });
        Profile.add(UserNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 12, -1, -1));

        deleteuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Deleteicon3.png"))); // NOI18N
        deleteuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteuserMousePressed(evt);
            }
        });
        Profile.add(deleteuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 12, -1, -1));

        popup4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/popup.png"))); // NOI18N
        Profile.add(popup4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        Help.setMaximumSize(new java.awt.Dimension(1024, 105));
        Help.setOpaque(false);
        Help.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popup5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/popup.png"))); // NOI18N
        Help.add(popup5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Help, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        About.setMaximumSize(new java.awt.Dimension(1024, 105));
        About.setOpaque(false);
        About.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popup6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/popup.png"))); // NOI18N
        About.add(popup6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(About, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        Record_Leftsidebarpanel.setMaximumSize(new java.awt.Dimension(240, 550));
        Record_Leftsidebarpanel.setMinimumSize(new java.awt.Dimension(240, 550));
        Record_Leftsidebarpanel.setOpaque(false);
        Record_Leftsidebarpanel.setPreferredSize(new java.awt.Dimension(240, 550));
        Record_Leftsidebarpanel.setLayout(null);

        Recent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Recent.png"))); // NOI18N
        Record_Leftsidebarpanel.add(Recent);
        Recent.setBounds(-170, 60, 170, 30);

        Recently_added.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Recently_add.png"))); // NOI18N
        Record_Leftsidebarpanel.add(Recently_added);
        Recently_added.setBounds(-170, 60, 170, 30);

        Recently_edited.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Recently_edit.png"))); // NOI18N
        Record_Leftsidebarpanel.add(Recently_edited);
        Recently_edited.setBounds(-170, 60, 170, 30);

        Recently_deleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Recently_delete.png"))); // NOI18N
        Record_Leftsidebarpanel.add(Recently_deleted);
        Recently_deleted.setBounds(-170, 60, 170, 30);

        R_history_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button1MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button1);
        R_history_button1.setBounds(14, 115, 216, 42);

        R_history_button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button2MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button2);
        R_history_button2.setBounds(14, 164, 216, 42);

        R_history_button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button3MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button3);
        R_history_button3.setBounds(14, 215, 216, 42);

        R_history_button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button4MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button4);
        R_history_button4.setBounds(14, 264, 216, 42);

        R_history_button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button5MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button5);
        R_history_button5.setBounds(14, 314, 216, 42);

        R_history_button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button6MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button6);
        R_history_button6.setBounds(14, 364, 216, 42);

        R_history_button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_history_button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_history_button7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_history_button7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_history_button7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_history_button7MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_history_button7);
        R_history_button7.setBounds(14, 414, 216, 42);

        R_add_history_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button1MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button1);
        R_add_history_button1.setBounds(14, 115, 216, 42);

        R_add_history_button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button2MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button2);
        R_add_history_button2.setBounds(14, 164, 216, 42);

        R_add_history_button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button3MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button3);
        R_add_history_button3.setBounds(14, 215, 216, 42);

        R_add_history_button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button4MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button4);
        R_add_history_button4.setBounds(14, 314, 216, 42);

        R_add_history_button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button5MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button5);
        R_add_history_button5.setBounds(14, 264, 216, 42);

        R_add_history_button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button6MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button6);
        R_add_history_button6.setBounds(14, 364, 216, 42);

        R_add_history_button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_add_history_button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_add_history_button7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_add_history_button7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_add_history_button7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_add_history_button7MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_add_history_button7);
        R_add_history_button7.setBounds(14, 414, 216, 42);

        R_edit_history_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button1MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button1);
        R_edit_history_button1.setBounds(14, 115, 216, 42);

        R_edit_history_button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button2MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button2);
        R_edit_history_button2.setBounds(14, 164, 216, 42);

        R_edit_history_button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button3MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button3);
        R_edit_history_button3.setBounds(14, 215, 216, 42);

        R_edit_history_button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button4MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button4);
        R_edit_history_button4.setBounds(14, 314, 216, 42);

        R_edit_history_button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button5MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button5);
        R_edit_history_button5.setBounds(14, 264, 216, 42);

        R_edit_history_button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button6MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button6);
        R_edit_history_button6.setBounds(14, 364, 216, 42);

        R_edit_history_button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_edit_history_button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_edit_history_button7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_edit_history_button7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_edit_history_button7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_edit_history_button7MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_edit_history_button7);
        R_edit_history_button7.setBounds(14, 414, 216, 42);

        R_delete_history_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button1MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button1);
        R_delete_history_button1.setBounds(14, 115, 216, 42);

        R_delete_history_button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button2MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button2);
        R_delete_history_button2.setBounds(14, 164, 216, 42);

        R_delete_history_button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button3MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button3);
        R_delete_history_button3.setBounds(14, 215, 216, 42);

        R_delete_history_button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button4MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button4);
        R_delete_history_button4.setBounds(14, 314, 216, 42);

        R_delete_history_button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button5MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button5);
        R_delete_history_button5.setBounds(14, 264, 216, 42);

        R_delete_history_button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button6MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button6);
        R_delete_history_button6.setBounds(14, 364, 216, 42);

        R_delete_history_button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        R_delete_history_button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                R_delete_history_button7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                R_delete_history_button7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                R_delete_history_button7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                R_delete_history_button7MouseReleased(evt);
            }
        });
        Record_Leftsidebarpanel.add(R_delete_history_button7);
        R_delete_history_button7.setBounds(14, 414, 216, 42);

        R_history1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history1.setForeground(new java.awt.Color(255, 255, 255));
        R_history1.setText("TID245236A was added");
        Record_Leftsidebarpanel.add(R_history1);
        R_history1.setBounds(-165, 120, 165, 18);

        R_history1_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history1_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history1_date.setText("25/11/2014 10:10 pm");
        Record_Leftsidebarpanel.add(R_history1_date);
        R_history1_date.setBounds(-99, 140, 105, 12);

        R_history2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history2.setForeground(new java.awt.Color(255, 255, 255));
        R_history2.setText("TID1152282 was added");
        Record_Leftsidebarpanel.add(R_history2);
        R_history2.setBounds(-165, 170, 164, 18);

        R_history2_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history2_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history2_date.setText("2/5/2014 12:00 am");
        Record_Leftsidebarpanel.add(R_history2_date);
        R_history2_date.setBounds(-99, 190, 92, 12);

        R_history3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history3.setForeground(new java.awt.Color(255, 255, 255));
        R_history3.setText("TID748596 was edited");
        Record_Leftsidebarpanel.add(R_history3);
        R_history3.setBounds(-165, 220, 155, 18);

        R_history3_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history3_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history3_date.setText("5/4/2014 04:00 pm");
        Record_Leftsidebarpanel.add(R_history3_date);
        R_history3_date.setBounds(-99, 240, 93, 12);

        R_history4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history4.setForeground(new java.awt.Color(255, 255, 255));
        R_history4.setText(" TIID245236 was edited");
        Record_Leftsidebarpanel.add(R_history4);
        R_history4.setBounds(-165, 270, 163, 18);

        R_history4_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history4_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history4_date.setText("16/2/2014 04:01 pm");
        Record_Leftsidebarpanel.add(R_history4_date);
        R_history4_date.setBounds(-99, 290, 99, 12);

        R_history5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history5.setForeground(new java.awt.Color(255, 255, 255));
        R_history5.setText("TID123456 was edited");
        Record_Leftsidebarpanel.add(R_history5);
        R_history5.setBounds(-165, 320, 155, 18);

        R_history5_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history5_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history5_date.setText("8/2/2014 04:02 pm");
        Record_Leftsidebarpanel.add(R_history5_date);
        R_history5_date.setBounds(-99, 340, 93, 12);

        R_history6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history6.setForeground(new java.awt.Color(255, 255, 255));
        R_history6.setText("TID159753 was added");
        Record_Leftsidebarpanel.add(R_history6);
        R_history6.setBounds(-165, 370, 155, 18);

        R_history6_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history6_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history6_date.setText("8/2/2014 03:59 pm");
        Record_Leftsidebarpanel.add(R_history6_date);
        R_history6_date.setBounds(-99, 390, 93, 12);

        R_history7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_history7.setForeground(new java.awt.Color(255, 255, 255));
        R_history7.setText("TID987654 was deleted");
        Record_Leftsidebarpanel.add(R_history7);
        R_history7.setBounds(-165, 420, 163, 18);

        R_history7_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_history7_date.setForeground(new java.awt.Color(255, 255, 255));
        R_history7_date.setText("25/1/2014 04:13 pm");
        Record_Leftsidebarpanel.add(R_history7_date);
        R_history7_date.setBounds(-99, 440, 99, 12);

        R_add_history1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history1.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history1.setText("TID567890 was added");
        Record_Leftsidebarpanel.add(R_add_history1);
        R_add_history1.setBounds(-165, 120, 155, 18);

        R_add_history1_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history1_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history1_date.setText("2/11/2014 04:05 pm");
        Record_Leftsidebarpanel.add(R_add_history1_date);
        R_add_history1_date.setBounds(-99, 140, 99, 12);

        R_add_history2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history2.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history2.setText("TID963852 was added");
        Record_Leftsidebarpanel.add(R_add_history2);
        R_add_history2.setBounds(-165, 170, 155, 18);

        R_add_history2_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history2_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history2_date.setText("23/10/2014 10:20 pm");
        Record_Leftsidebarpanel.add(R_add_history2_date);
        R_add_history2_date.setBounds(-99, 190, 105, 12);

        R_add_history3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history3.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history3.setText("TID852741 was added");
        Record_Leftsidebarpanel.add(R_add_history3);
        R_add_history3.setBounds(-165, 220, 155, 18);

        R_add_history3_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history3_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history3_date.setText("23/10/2014 10:19 pm");
        Record_Leftsidebarpanel.add(R_add_history3_date);
        R_add_history3_date.setBounds(-99, 240, 105, 12);

        R_add_history4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history4.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history4.setText(" TIID245236 was added");
        R_add_history4.setMaximumSize(new java.awt.Dimension(165, 18));
        R_add_history4.setMinimumSize(new java.awt.Dimension(165, 18));
        R_add_history4.setPreferredSize(new java.awt.Dimension(165, 18));
        Record_Leftsidebarpanel.add(R_add_history4);
        R_add_history4.setBounds(-165, 270, 165, 18);

        R_add_history4_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history4_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history4_date.setText("23/10/2014 10:18 pm");
        Record_Leftsidebarpanel.add(R_add_history4_date);
        R_add_history4_date.setBounds(-99, 290, 105, 12);

        R_add_history5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history5.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history5.setText("TID741963 was added");
        Record_Leftsidebarpanel.add(R_add_history5);
        R_add_history5.setBounds(-165, 320, 155, 18);

        R_add_history5_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history5_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history5_date.setText("23/10/2014 10:12 pm");
        Record_Leftsidebarpanel.add(R_add_history5_date);
        R_add_history5_date.setBounds(-99, 340, 105, 12);

        R_add_history6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history6.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history6.setText("TID789123 was added");
        Record_Leftsidebarpanel.add(R_add_history6);
        R_add_history6.setBounds(-165, 370, 155, 18);

        R_add_history6_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history6_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history6_date.setText("23/10/2014 10:10 pm");
        Record_Leftsidebarpanel.add(R_add_history6_date);
        R_add_history6_date.setBounds(-99, 390, 105, 12);

        R_add_history7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_add_history7.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history7.setText("TID789321 was added");
        Record_Leftsidebarpanel.add(R_add_history7);
        R_add_history7.setBounds(-165, 420, 155, 18);

        R_add_history7_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_add_history7_date.setForeground(new java.awt.Color(255, 255, 255));
        R_add_history7_date.setText("22/10/2014 10:00 pm");
        Record_Leftsidebarpanel.add(R_add_history7_date);
        R_add_history7_date.setBounds(-99, 440, 105, 12);

        R_edit_history1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history1.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history1.setText("TID753951 was edited");
        Record_Leftsidebarpanel.add(R_edit_history1);
        R_edit_history1.setBounds(-165, 120, 155, 18);

        R_edit_history1_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history1_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history1_date.setText("19/10/2014 01:01 am");
        Record_Leftsidebarpanel.add(R_edit_history1_date);
        R_edit_history1_date.setBounds(-99, 140, 104, 12);

        R_edit_history2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history2.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history2.setText("TID741321 was edited");
        Record_Leftsidebarpanel.add(R_edit_history2);
        R_edit_history2.setBounds(-165, 170, 155, 18);

        R_edit_history2_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history2_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history2_date.setText("19/10/2014 01:01 pm");
        Record_Leftsidebarpanel.add(R_edit_history2_date);
        R_edit_history2_date.setBounds(-99, 190, 105, 12);

        R_edit_history3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history3.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history3.setText("TID78963 was edited");
        Record_Leftsidebarpanel.add(R_edit_history3);
        R_edit_history3.setBounds(-165, 220, 146, 18);

        R_edit_history3_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history3_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history3_date.setText("19/10/2014 01:00 pm");
        Record_Leftsidebarpanel.add(R_edit_history3_date);
        R_edit_history3_date.setBounds(-99, 240, 105, 12);

        R_edit_history4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history4.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history4.setText(" TIID245236 was edited");
        R_edit_history4.setMaximumSize(new java.awt.Dimension(165, 18));
        R_edit_history4.setMinimumSize(new java.awt.Dimension(165, 18));
        R_edit_history4.setPreferredSize(new java.awt.Dimension(165, 18));
        Record_Leftsidebarpanel.add(R_edit_history4);
        R_edit_history4.setBounds(-165, 270, 165, 18);

        R_edit_history4_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history4_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history4_date.setText("19/10/2014 01:00 am");
        Record_Leftsidebarpanel.add(R_edit_history4_date);
        R_edit_history4_date.setBounds(-99, 290, 104, 12);

        R_edit_history5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history5.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history5.setText("TID789852 was edited");
        Record_Leftsidebarpanel.add(R_edit_history5);
        R_edit_history5.setBounds(-165, 320, 155, 18);

        R_edit_history5_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history5_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history5_date.setText("19/10/2014 12:59 am");
        Record_Leftsidebarpanel.add(R_edit_history5_date);
        R_edit_history5_date.setBounds(-99, 340, 104, 12);

        R_edit_history6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history6.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history6.setText("TID789741 was edited");
        Record_Leftsidebarpanel.add(R_edit_history6);
        R_edit_history6.setBounds(-165, 370, 155, 18);

        R_edit_history6_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history6_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history6_date.setText("19/10/2014 12:59 am");
        Record_Leftsidebarpanel.add(R_edit_history6_date);
        R_edit_history6_date.setBounds(-99, 390, 104, 12);

        R_edit_history7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_edit_history7.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history7.setText("TID741456 was edited");
        Record_Leftsidebarpanel.add(R_edit_history7);
        R_edit_history7.setBounds(-165, 420, 155, 18);

        R_edit_history7_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_edit_history7_date.setForeground(new java.awt.Color(255, 255, 255));
        R_edit_history7_date.setText("19/10/2014 12:59 pm");
        Record_Leftsidebarpanel.add(R_edit_history7_date);
        R_edit_history7_date.setBounds(-99, 440, 105, 12);

        R_delete_history1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history1.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history1.setText("TID245463 was deleted");
        Record_Leftsidebarpanel.add(R_delete_history1);
        R_delete_history1.setBounds(-165, 120, 163, 18);

        R_delete_history1_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history1_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history1_date.setText("19/10/2014 10:12 pm");
        Record_Leftsidebarpanel.add(R_delete_history1_date);
        R_delete_history1_date.setBounds(-99, 140, 105, 12);

        R_delete_history2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history2.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history2.setText("TID115284 was deleted");
        Record_Leftsidebarpanel.add(R_delete_history2);
        R_delete_history2.setBounds(-165, 170, 163, 18);

        R_delete_history2_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history2_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history2_date.setText("19/10/2014 10:20 pm");
        Record_Leftsidebarpanel.add(R_delete_history2_date);
        R_delete_history2_date.setBounds(-99, 190, 105, 12);

        R_delete_history3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history3.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history3.setText("TID142536 was deleted");
        Record_Leftsidebarpanel.add(R_delete_history3);
        R_delete_history3.setBounds(-165, 220, 163, 18);

        R_delete_history3_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history3_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history3_date.setText("19/10/2014 10:19 pm");
        Record_Leftsidebarpanel.add(R_delete_history3_date);
        R_delete_history3_date.setBounds(-99, 240, 105, 12);

        R_delete_history4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history4.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history4.setText(" TID245753 was deleted");
        R_delete_history4.setMaximumSize(new java.awt.Dimension(173, 18));
        R_delete_history4.setMinimumSize(new java.awt.Dimension(173, 18));
        R_delete_history4.setPreferredSize(new java.awt.Dimension(173, 18));
        Record_Leftsidebarpanel.add(R_delete_history4);
        R_delete_history4.setBounds(-165, 270, 173, 18);

        R_delete_history4_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history4_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history4_date.setText("19/10/2014 10:19 pm");
        Record_Leftsidebarpanel.add(R_delete_history4_date);
        R_delete_history4_date.setBounds(-99, 290, 105, 12);

        R_delete_history5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history5.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history5.setText("TID1456987 was deleted");
        Record_Leftsidebarpanel.add(R_delete_history5);
        R_delete_history5.setBounds(-165, 320, 172, 18);

        R_delete_history5_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history5_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history5_date.setText("19/10/2014 10:20 pm");
        Record_Leftsidebarpanel.add(R_delete_history5_date);
        R_delete_history5_date.setBounds(-99, 340, 105, 12);

        R_delete_history6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history6.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history6.setText("TID145236 was deleted");
        R_delete_history6.setToolTipText("");
        Record_Leftsidebarpanel.add(R_delete_history6);
        R_delete_history6.setBounds(-165, 370, 163, 18);

        R_delete_history6_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history6_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history6_date.setText("19/10/2014 10:19 pm");
        Record_Leftsidebarpanel.add(R_delete_history6_date);
        R_delete_history6_date.setBounds(-99, 390, 105, 12);

        R_delete_history7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        R_delete_history7.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history7.setText("TID745896 was deleted");
        Record_Leftsidebarpanel.add(R_delete_history7);
        R_delete_history7.setBounds(-165, 420, 163, 18);

        R_delete_history7_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        R_delete_history7_date.setForeground(new java.awt.Color(255, 255, 255));
        R_delete_history7_date.setText("19/10/2014 10:19 pm");
        Record_Leftsidebarpanel.add(R_delete_history7_date);
        R_delete_history7_date.setBounds(-99, 440, 105, 12);

        Line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Line2.png"))); // NOI18N
        Record_Leftsidebarpanel.add(Line);
        Line.setBounds(-190, 465, 190, 3);

        Record_leftsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Record_Leftsidepanel.png"))); // NOI18N
        Record_Leftsidebarpanel.add(Record_leftsidebarpanel);
        Record_leftsidebarpanel.setBounds(-100, 0, 240, 550);

        getContentPane().add(Record_Leftsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 550));

        Search_Leftsidebarpanel.setMaximumSize(new java.awt.Dimension(240, 550));
        Search_Leftsidebarpanel.setMinimumSize(new java.awt.Dimension(240, 550));
        Search_Leftsidebarpanel.setOpaque(false);
        Search_Leftsidebarpanel.setPreferredSize(new java.awt.Dimension(240, 550));
        Search_Leftsidebarpanel.setLayout(null);

        Recently_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Recently_search.png"))); // NOI18N
        Search_Leftsidebarpanel.add(Recently_search);
        Recently_search.setBounds(-151, 61, 151, 30);

        S_history_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button1MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button1);
        S_history_button1.setBounds(14, 115, 216, 42);

        S_history_button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button2MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button2);
        S_history_button2.setBounds(14, 164, 216, 42);

        S_history_button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button3MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button3);
        S_history_button3.setBounds(14, 215, 216, 42);

        S_history_button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button4MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button4);
        S_history_button4.setBounds(14, 264, 216, 42);

        S_history_button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button5MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button5);
        S_history_button5.setBounds(14, 314, 216, 42);

        S_history_button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button6MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button6);
        S_history_button6.setBounds(14, 364, 216, 42);

        S_history_button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_default_button.png"))); // NOI18N
        S_history_button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_history_button7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_history_button7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_history_button7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_history_button7MouseReleased(evt);
            }
        });
        Search_Leftsidebarpanel.add(S_history_button7);
        S_history_button7.setBounds(14, 414, 216, 42);

        S_history1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history1.setForeground(new java.awt.Color(255, 255, 255));
        S_history1.setText("TID786512 was searched");
        Search_Leftsidebarpanel.add(S_history1);
        S_history1.setBounds(-165, 120, 174, 18);

        S_history1_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history1_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history1_date.setText("25/10/2014 11:20 pm");
        Search_Leftsidebarpanel.add(S_history1_date);
        S_history1_date.setBounds(-99, 140, 105, 12);

        S_history2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history2.setForeground(new java.awt.Color(255, 255, 255));
        S_history2.setText("TID745263 was searched");
        Search_Leftsidebarpanel.add(S_history2);
        S_history2.setBounds(-165, 170, 174, 18);

        S_history2_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history2_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history2_date.setText("24/10/2014 11:20 pm");
        Search_Leftsidebarpanel.add(S_history2_date);
        S_history2_date.setBounds(-99, 190, 105, 12);

        S_history3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history3.setForeground(new java.awt.Color(255, 255, 255));
        S_history3.setText("TID745612 was searched");
        Search_Leftsidebarpanel.add(S_history3);
        S_history3.setBounds(-165, 220, 174, 18);

        S_history3_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history3_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history3_date.setText("25/10/2014 11:20 pm");
        Search_Leftsidebarpanel.add(S_history3_date);
        S_history3_date.setBounds(-99, 240, 105, 12);

        S_history4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history4.setForeground(new java.awt.Color(255, 255, 255));
        S_history4.setText("TID784523 was searched");
        Search_Leftsidebarpanel.add(S_history4);
        S_history4.setBounds(-165, 270, 174, 18);

        S_history4_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history4_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history4_date.setText("25/10/2014 11:20 pm");
        Search_Leftsidebarpanel.add(S_history4_date);
        S_history4_date.setBounds(-99, 290, 105, 12);

        S_history5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history5.setForeground(new java.awt.Color(255, 255, 255));
        S_history5.setText("TID894523 was searched");
        Search_Leftsidebarpanel.add(S_history5);
        S_history5.setBounds(-165, 320, 174, 18);

        S_history5_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history5_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history5_date.setText("25/10/2014 11:10 pm");
        Search_Leftsidebarpanel.add(S_history5_date);
        S_history5_date.setBounds(-99, 340, 105, 12);

        S_history6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history6.setForeground(new java.awt.Color(255, 255, 255));
        S_history6.setText("TID745241 was searched");
        Search_Leftsidebarpanel.add(S_history6);
        S_history6.setBounds(-165, 370, 174, 18);

        S_history6_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history6_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history6_date.setText("25/10/2014 11:09 pm");
        Search_Leftsidebarpanel.add(S_history6_date);
        S_history6_date.setBounds(-99, 390, 105, 12);

        S_history7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        S_history7.setForeground(new java.awt.Color(255, 255, 255));
        S_history7.setText("TID145869 was searched");
        Search_Leftsidebarpanel.add(S_history7);
        S_history7.setBounds(-165, 420, 174, 18);

        S_history7_date.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        S_history7_date.setForeground(new java.awt.Color(255, 255, 255));
        S_history7_date.setText("25/10/2014 11:08 pm");
        Search_Leftsidebarpanel.add(S_history7_date);
        S_history7_date.setBounds(-99, 440, 105, 12);

        Line1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Line2.png"))); // NOI18N
        Search_Leftsidebarpanel.add(Line1);
        Line1.setBounds(-190, 465, 190, 3);

        Search_leftsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Search_Leftsidebarpanel.png"))); // NOI18N
        Search_Leftsidebarpanel.add(Search_leftsidebarpanel);
        Search_leftsidebarpanel.setBounds(-100, 0, 240, 550);

        getContentPane().add(Search_Leftsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 550));

        View_Leftsidebarpanel.setMaximumSize(new java.awt.Dimension(240, 550));
        View_Leftsidebarpanel.setMinimumSize(new java.awt.Dimension(240, 550));
        View_Leftsidebarpanel.setOpaque(false);
        View_Leftsidebarpanel.setPreferredSize(new java.awt.Dimension(240, 550));
        View_Leftsidebarpanel.setLayout(null);

        VIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/ComplainName.png"))); // NOI18N
        View_Leftsidebarpanel.add(VIEW);
        VIEW.setBounds(-140, 14, 140, 35);

        Line2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Line2.png"))); // NOI18N
        View_Leftsidebarpanel.add(Line2);
        Line2.setBounds(-190, 465, 190, 3);

        View_leftsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_background.png"))); // NOI18N
        View_Leftsidebarpanel.add(View_leftsidebarpanel);
        View_leftsidebarpanel.setBounds(-100, 0, 240, 550);

        getContentPane().add(View_Leftsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 550));

        Profile_Leftsidebarpanel.setMaximumSize(new java.awt.Dimension(240, 550));
        Profile_Leftsidebarpanel.setMinimumSize(new java.awt.Dimension(240, 550));
        Profile_Leftsidebarpanel.setOpaque(false);
        Profile_Leftsidebarpanel.setPreferredSize(new java.awt.Dimension(240, 550));
        Profile_Leftsidebarpanel.setLayout(null);

        PROFILE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Profie.png"))); // NOI18N
        Profile_Leftsidebarpanel.add(PROFILE);
        PROFILE.setBounds(-140, 14, 140, 35);

        Line3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Line2.png"))); // NOI18N
        Profile_Leftsidebarpanel.add(Line3);
        Line3.setBounds(-190, 465, 190, 3);

        Profile_leftsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_background.png"))); // NOI18N
        Profile_Leftsidebarpanel.add(Profile_leftsidebarpanel);
        Profile_leftsidebarpanel.setBounds(-100, 0, 240, 550);

        getContentPane().add(Profile_Leftsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 550));

        Help_Leftsidebarpanel.setMaximumSize(new java.awt.Dimension(240, 550));
        Help_Leftsidebarpanel.setMinimumSize(new java.awt.Dimension(240, 550));
        Help_Leftsidebarpanel.setOpaque(false);
        Help_Leftsidebarpanel.setPreferredSize(new java.awt.Dimension(240, 550));
        Help_Leftsidebarpanel.setLayout(null);

        HELP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Help.png"))); // NOI18N
        Help_Leftsidebarpanel.add(HELP);
        HELP.setBounds(-140, 14, 140, 35);

        Line4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Line2.png"))); // NOI18N
        Help_Leftsidebarpanel.add(Line4);
        Line4.setBounds(-190, 465, 190, 3);

        Help_leftsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Left_sidepanel_background.png"))); // NOI18N
        Help_Leftsidebarpanel.add(Help_leftsidebarpanel);
        Help_leftsidebarpanel.setBounds(-100, 0, 240, 550);

        getContentPane().add(Help_Leftsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 550));

        New_Rightsidebarpanel.setMaximumSize(new java.awt.Dimension(784, 550));
        New_Rightsidebarpanel.setMinimumSize(new java.awt.Dimension(784, 550));
        New_Rightsidebarpanel.setPreferredSize(new java.awt.Dimension(784, 550));
        New_Rightsidebarpanel.setLayout(null);

        SpecficationNoTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        SpecficationNoTextField.setToolTipText("Type the ID");
        SpecficationNoTextField.setBorder(null);
        SpecficationNoTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        SpecficationNoTextField.setDragEnabled(true);
        SpecficationNoTextField.setMaximumSize(new java.awt.Dimension(152, 19));
        SpecficationNoTextField.setMinimumSize(new java.awt.Dimension(152, 19));
        SpecficationNoTextField.setPreferredSize(new java.awt.Dimension(152, 19));
        SpecficationNoTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        SpecficationNoTextField.setSelectionEnd(6);
        SpecficationNoTextField.setSelectionStart(6);
        SpecficationNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecficationNoTextFieldActionPerformed(evt);
            }
        });
        New_Rightsidebarpanel.add(SpecficationNoTextField);
        SpecficationNoTextField.setBounds(214, 157, 152, 16);

        DateTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        DateTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DateTextField.setToolTipText("Type day");
        DateTextField.setBorder(null);
        DateTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        DateTextField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        DateTextField.setMaximumSize(new java.awt.Dimension(6, 20));
        DateTextField.setName(""); // NOI18N
        DateTextField.setOpaque(false);
        DateTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        New_Rightsidebarpanel.add(DateTextField);
        DateTextField.setBounds(573, 157, 20, 17);

        MonthTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        MonthTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        MonthTextField.setToolTipText("Type Month");
        MonthTextField.setBorder(null);
        MonthTextField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        MonthTextField.setMaximumSize(new java.awt.Dimension(6, 20));
        MonthTextField.setName(""); // NOI18N
        MonthTextField.setOpaque(false);
        MonthTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        New_Rightsidebarpanel.add(MonthTextField);
        MonthTextField.setBounds(612, 157, 20, 17);

        PoNoTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        PoNoTextField.setToolTipText("Type the PO No.");
        PoNoTextField.setBorder(null);
        PoNoTextField.setMaximumSize(new java.awt.Dimension(152, 19));
        PoNoTextField.setMinimumSize(new java.awt.Dimension(152, 19));
        PoNoTextField.setPreferredSize(new java.awt.Dimension(152, 19));
        PoNoTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        PoNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoNoTextFieldActionPerformed(evt);
            }
        });
        New_Rightsidebarpanel.add(PoNoTextField);
        PoNoTextField.setBounds(214, 205, 152, 16);

        DeptTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        DeptTextField.setToolTipText("Type the place of buyer");
        DeptTextField.setBorder(null);
        DeptTextField.setMaximumSize(new java.awt.Dimension(152, 19));
        DeptTextField.setMinimumSize(new java.awt.Dimension(152, 19));
        DeptTextField.setPreferredSize(new java.awt.Dimension(152, 19));
        DeptTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        DeptTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptTextFieldActionPerformed(evt);
            }
        });
        New_Rightsidebarpanel.add(DeptTextField);
        DeptTextField.setBounds(214, 349, 152, 16);

        YearTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        YearTextField.setToolTipText("Type year");
        YearTextField.setBorder(null);
        New_Rightsidebarpanel.add(YearTextField);
        YearTextField.setBounds(648, 157, 34, 16);

        ItemTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        ItemTextField.setBorder(null);
        New_Rightsidebarpanel.add(ItemTextField);
        ItemTextField.setBounds(214, 253, 316, 16);

        BuyerTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        BuyerTextField.setBorder(null);
        New_Rightsidebarpanel.add(BuyerTextField);
        BuyerTextField.setBounds(214, 301, 316, 16);

        PriceTextField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        PriceTextField.setToolTipText("Type the place of buyer");
        PriceTextField.setBorder(null);
        PriceTextField.setMaximumSize(new java.awt.Dimension(152, 19));
        PriceTextField.setMinimumSize(new java.awt.Dimension(152, 19));
        PriceTextField.setPreferredSize(new java.awt.Dimension(152, 19));
        PriceTextField.setSelectionColor(new java.awt.Color(153, 0, 153));
        PriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTextFieldActionPerformed(evt);
            }
        });
        New_Rightsidebarpanel.add(PriceTextField);
        PriceTextField.setBounds(214, 397, 152, 16);

        WarrantyMonth.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        WarrantyMonth.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        WarrantyMonth.setToolTipText("Type day");
        WarrantyMonth.setBorder(null);
        WarrantyMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        WarrantyMonth.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        WarrantyMonth.setMaximumSize(new java.awt.Dimension(6, 20));
        WarrantyMonth.setName(""); // NOI18N
        WarrantyMonth.setOpaque(false);
        WarrantyMonth.setSelectionColor(new java.awt.Color(153, 0, 153));
        New_Rightsidebarpanel.add(WarrantyMonth);
        WarrantyMonth.setBounds(573, 205, 20, 17);

        WarehouseMonth.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        WarehouseMonth.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        WarehouseMonth.setToolTipText("Type Month");
        WarehouseMonth.setBorder(null);
        WarehouseMonth.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        WarehouseMonth.setMaximumSize(new java.awt.Dimension(6, 20));
        WarehouseMonth.setName(""); // NOI18N
        WarehouseMonth.setOpaque(false);
        WarehouseMonth.setSelectionColor(new java.awt.Color(153, 0, 153));
        New_Rightsidebarpanel.add(WarehouseMonth);
        WarehouseMonth.setBounds(612, 205, 20, 17);
        New_Rightsidebarpanel.add(WarningArea);
        WarningArea.setBounds(72, 78, 400, 17);

        SpecificationEditTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        SpecificationEditTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        New_Rightsidebarpanel.add(SpecificationEditTxt);
        SpecificationEditTxt.setBounds(210, 154, 160, 21);

        SpecificationNo.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        SpecificationNo.setForeground(new java.awt.Color(153, 0, 153));
        SpecificationNo.setText("Specification No.");
        New_Rightsidebarpanel.add(SpecificationNo);
        SpecificationNo.setBounds(80, 160, 116, 18);

        PurchasedDate.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        PurchasedDate.setForeground(new java.awt.Color(153, 0, 153));
        PurchasedDate.setText("Date of Purchase");
        New_Rightsidebarpanel.add(PurchasedDate);
        PurchasedDate.setBounds(430, 160, 130, 19);

        DateField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        New_Rightsidebarpanel.add(DateField);
        DateField.setBounds(570, 154, 27, 21);

        MonthField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        New_Rightsidebarpanel.add(MonthField);
        MonthField.setBounds(608, 154, 27, 21);

        Dash1.setText("-");
        New_Rightsidebarpanel.add(Dash1);
        Dash1.setBounds(600, 157, 6, 14);

        Dash2.setText("-");
        New_Rightsidebarpanel.add(Dash2);
        Dash2.setBounds(638, 157, 6, 14);

        PoNo.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        PoNo.setForeground(new java.awt.Color(153, 0, 153));
        PoNo.setText("PO No.");
        New_Rightsidebarpanel.add(PoNo);
        PoNo.setBounds(80, 208, 50, 18);

        PoNoField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        New_Rightsidebarpanel.add(PoNoField);
        PoNoField.setBounds(210, 202, 160, 21);

        Item.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Item.setForeground(new java.awt.Color(153, 0, 153));
        Item.setText("Item");
        New_Rightsidebarpanel.add(Item);
        Item.setBounds(80, 256, 31, 18);

        TypeOfWarranty.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        TypeOfWarranty.setForeground(new java.awt.Color(153, 0, 153));
        TypeOfWarranty.setText("Type of Warranty");
        New_Rightsidebarpanel.add(TypeOfWarranty);
        TypeOfWarranty.setBounds(430, 208, 120, 18);

        Place.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Place.setForeground(new java.awt.Color(153, 0, 153));
        Place.setText("Department");
        New_Rightsidebarpanel.add(Place);
        Place.setBounds(80, 350, 90, 18);

        PlaceField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        New_Rightsidebarpanel.add(PlaceField);
        PlaceField.setBounds(210, 346, 160, 21);

        NEW.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        NEW.setForeground(new java.awt.Color(153, 0, 153));
        NEW.setText("New");
        New_Rightsidebarpanel.add(NEW);
        NEW.setBounds(20, 18, 80, 30);

        Astrisk1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk1.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk1.setText("*");
        New_Rightsidebarpanel.add(Astrisk1);
        Astrisk1.setBounds(128, 206, 10, 16);

        Astrisk2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk2.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk2.setText("*");
        New_Rightsidebarpanel.add(Astrisk2);
        Astrisk2.setBounds(548, 157, 10, 16);

        YearField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/year.png"))); // NOI18N
        New_Rightsidebarpanel.add(YearField);
        YearField.setBounds(644, 154, 44, 21);

        ItemField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        New_Rightsidebarpanel.add(ItemField);
        ItemField.setBounds(210, 250, 324, 21);

        Mandatory.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        Mandatory.setForeground(new java.awt.Color(255, 0, 51));
        Mandatory.setText("* Fields are mandatory to fill");
        New_Rightsidebarpanel.add(Mandatory);
        Mandatory.setBounds(70, 100, 160, 12);

        Astrisk3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk3.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk3.setText("*");
        New_Rightsidebarpanel.add(Astrisk3);
        Astrisk3.setBounds(194, 158, 10, 16);

        Astrisk4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk4.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk4.setText("*");
        New_Rightsidebarpanel.add(Astrisk4);
        Astrisk4.setBounds(552, 206, 10, 16);

        Bar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        New_Rightsidebarpanel.add(Bar);
        Bar.setBounds(0, 76, 784, 21);

        BuyerField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        New_Rightsidebarpanel.add(BuyerField);
        BuyerField.setBounds(210, 298, 324, 21);

        Buyer.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Buyer.setForeground(new java.awt.Color(153, 0, 153));
        Buyer.setText("Buyer");
        New_Rightsidebarpanel.add(Buyer);
        Buyer.setBounds(80, 304, 40, 18);

        Astrisk5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk5.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk5.setText("*");
        New_Rightsidebarpanel.add(Astrisk5);
        Astrisk5.setBounds(112, 254, 10, 16);

        Astrisk6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk6.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk6.setText("*");
        New_Rightsidebarpanel.add(Astrisk6);
        Astrisk6.setBounds(122, 302, 10, 16);

        Astrisk7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk7.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk7.setText("*");
        New_Rightsidebarpanel.add(Astrisk7);
        Astrisk7.setBounds(164, 350, 10, 16);

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
        New_Rightsidebarpanel.add(NextButton);
        NextButton.setBounds(490, 440, 80, 25);

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
        New_Rightsidebarpanel.add(CancelButton);
        CancelButton.setBounds(580, 440, 80, 25);

        Price.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Price.setForeground(new java.awt.Color(153, 0, 153));
        Price.setText("Price");
        New_Rightsidebarpanel.add(Price);
        Price.setBounds(80, 400, 34, 18);

        PriceField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        New_Rightsidebarpanel.add(PriceField);
        PriceField.setBounds(210, 394, 160, 21);

        Astrisk8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk8.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk8.setText("*");
        New_Rightsidebarpanel.add(Astrisk8);
        Astrisk8.setBounds(116, 398, 10, 16);

        WarrantyTextbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        New_Rightsidebarpanel.add(WarrantyTextbox);
        WarrantyTextbox.setBounds(570, 202, 27, 21);

        Divide.setText("/");
        New_Rightsidebarpanel.add(Divide);
        Divide.setBounds(600, 205, 4, 14);

        WarehouseTextbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        New_Rightsidebarpanel.add(WarehouseTextbox);
        WarehouseTextbox.setBounds(608, 202, 27, 21);

        New_rightsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        New_Rightsidebarpanel.add(New_rightsidebarpanel);
        New_rightsidebarpanel.setBounds(0, 0, 784, 550);

        getContentPane().add(New_Rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        Edit_Rightsidebarpanel.setMaximumSize(new java.awt.Dimension(784, 550));
        Edit_Rightsidebarpanel.setMinimumSize(new java.awt.Dimension(784, 550));
        Edit_Rightsidebarpanel.setPreferredSize(new java.awt.Dimension(784, 550));
        Edit_Rightsidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 153));
        jLabel5.setText("Enter the Specification Number");
        Edit_Rightsidebarpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));
        Edit_Rightsidebarpanel.add(Search_SpecificationNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 140, -1));

        E_SpecificationNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        E_SpecificationNumber.setForeground(new java.awt.Color(153, 0, 153));
        E_SpecificationNumber.setText("Specification Number");
        Edit_Rightsidebarpanel.add(E_SpecificationNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));
        Edit_Rightsidebarpanel.add(S_SpecificationNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 130, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 153));
        jLabel7.setText("PO number ");
        Edit_Rightsidebarpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        S_PONumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_PONumberActionPerformed(evt);
            }
        });
        Edit_Rightsidebarpanel.add(S_PONumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 130, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("Date of Purchase");
        Edit_Rightsidebarpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));
        Edit_Rightsidebarpanel.add(S_PurchasedMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 20, -1));
        Edit_Rightsidebarpanel.add(S_PurchasedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 20, -1));
        Edit_Rightsidebarpanel.add(S_PurchasedYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 50, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 153));
        jLabel9.setText("Type of Warranty");
        Edit_Rightsidebarpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));
        Edit_Rightsidebarpanel.add(S_Warehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 20, -1));
        Edit_Rightsidebarpanel.add(S_Warranty, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 20, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Buyer ");
        Edit_Rightsidebarpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));
        Edit_Rightsidebarpanel.add(S_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 350, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 153));
        jLabel11.setText("Item");
        Edit_Rightsidebarpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));
        Edit_Rightsidebarpanel.add(S_Buyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 350, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 153));
        jLabel12.setText("Department");
        Edit_Rightsidebarpanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));
        Edit_Rightsidebarpanel.add(S_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 130, -1));

        S_submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Submit.png"))); // NOI18N
        S_submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_submitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_submitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_submitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_submitMouseReleased(evt);
            }
        });
        Edit_Rightsidebarpanel.add(S_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 98, -1, -1));

        S_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NextButton_default1.png"))); // NOI18N
        S_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S_nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_nextMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_nextMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_nextMouseReleased(evt);
            }
        });
        Edit_Rightsidebarpanel.add(S_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, -1));

        S_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/cancelButton_default_3.png"))); // NOI18N
        S_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                S_cancelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                S_cancelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                S_cancelMouseReleased(evt);
            }
        });
        Edit_Rightsidebarpanel.add(S_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 153));
        jLabel6.setText("Price");
        Edit_Rightsidebarpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));
        Edit_Rightsidebarpanel.add(S_Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 130, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 153));
        jLabel21.setText("Edit");
        Edit_Rightsidebarpanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Edit_rightsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        Edit_Rightsidebarpanel.add(Edit_rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Edit_Rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        Delete_Rightsidebarpanel.setMaximumSize(new java.awt.Dimension(784, 550));
        Delete_Rightsidebarpanel.setMinimumSize(new java.awt.Dimension(784, 550));
        Delete_Rightsidebarpanel.setOpaque(false);
        Delete_Rightsidebarpanel.setPreferredSize(new java.awt.Dimension(784, 550));
        Delete_Rightsidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 153));
        jLabel13.setText("Enter Specification Number");
        Delete_Rightsidebarpanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        Delete_Rightsidebarpanel.add(Delete_SpecificationNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 140, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 153));
        jLabel14.setText("Specification Number");
        Delete_Rightsidebarpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        D_Item.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 330, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 153));
        jLabel16.setText("PO Number");
        Delete_Rightsidebarpanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        D_Price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 130, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 153));
        jLabel18.setText("Date of Purchase");
        Delete_Rightsidebarpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        D_PurchasedYear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_PurchasedYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 50, 20));

        D_Warehouse.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Warehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 20, 20));

        D_PurchasedMonth.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_PurchasedMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 20, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 153));
        jLabel22.setText("Buyer ");
        Delete_Rightsidebarpanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        D_Po_No.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Po_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 130, 20));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 153));
        jLabel24.setText("Type of Warranty");
        Delete_Rightsidebarpanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        D_PurchasedDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_PurchasedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 20, 20));

        D_Warranty.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Warranty, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 20, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 0, 153));
        jLabel27.setText("Item");
        Delete_Rightsidebarpanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        D_Buyer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Buyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 330, 20));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 0, 153));
        jLabel29.setText("Department");
        Delete_Rightsidebarpanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        D_SpecificationNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_SpecificationNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 130, 20));

        D_submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Submit.png"))); // NOI18N
        D_submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                D_submitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                D_submitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D_submitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                D_submitMouseReleased(evt);
            }
        });
        Delete_Rightsidebarpanel.add(D_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 98, -1, -1));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(153, 0, 153));
        jLabel57.setText("Price");
        Delete_Rightsidebarpanel.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        D_Department.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Delete_Rightsidebarpanel.add(D_Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 130, 20));

        D_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NextButton_default1.png"))); // NOI18N
        D_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D_nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                D_nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                D_nextMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D_nextMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                D_nextMouseReleased(evt);
            }
        });
        Delete_Rightsidebarpanel.add(D_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, -1, -1));

        D_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/cancelButton_default_3.png"))); // NOI18N
        D_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                D_cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                D_cancelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D_cancelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                D_cancelMouseReleased(evt);
            }
        });
        Delete_Rightsidebarpanel.add(D_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 153));
        jLabel23.setText("Delete");
        Delete_Rightsidebarpanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Delete_rightsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        Delete_Rightsidebarpanel.add(Delete_rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Delete_Rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        MultipleEntry.setMaximumSize(new java.awt.Dimension(784, 550));
        MultipleEntry.setMinimumSize(new java.awt.Dimension(784, 550));
        MultipleEntry.setPreferredSize(new java.awt.Dimension(784, 550));
        MultipleEntry.setLayout(null);

        No_ofTransformersTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        No_ofTransformersTextField1.setToolTipText("Type the ID");
        No_ofTransformersTextField1.setBorder(null);
        No_ofTransformersTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        No_ofTransformersTextField1.setDragEnabled(true);
        No_ofTransformersTextField1.setMaximumSize(new java.awt.Dimension(152, 19));
        No_ofTransformersTextField1.setMinimumSize(new java.awt.Dimension(152, 19));
        No_ofTransformersTextField1.setPreferredSize(new java.awt.Dimension(152, 19));
        No_ofTransformersTextField1.setSelectionColor(new java.awt.Color(153, 0, 153));
        No_ofTransformersTextField1.setSelectionEnd(6);
        No_ofTransformersTextField1.setSelectionStart(6);
        No_ofTransformersTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_ofTransformersTextField1ActionPerformed(evt);
            }
        });
        MultipleEntry.add(No_ofTransformersTextField1);
        No_ofTransformersTextField1.setBounds(214, 157, 152, 16);

        DateTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        DateTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DateTextField1.setToolTipText("Type day");
        DateTextField1.setBorder(null);
        DateTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        DateTextField1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        DateTextField1.setMaximumSize(new java.awt.Dimension(6, 20));
        DateTextField1.setName(""); // NOI18N
        DateTextField1.setOpaque(false);
        DateTextField1.setSelectionColor(new java.awt.Color(153, 0, 153));
        MultipleEntry.add(DateTextField1);
        DateTextField1.setBounds(573, 157, 20, 17);

        MonthTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        MonthTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        MonthTextField1.setToolTipText("Type Month");
        MonthTextField1.setBorder(null);
        MonthTextField1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        MonthTextField1.setMaximumSize(new java.awt.Dimension(6, 20));
        MonthTextField1.setName(""); // NOI18N
        MonthTextField1.setOpaque(false);
        MonthTextField1.setSelectionColor(new java.awt.Color(153, 0, 153));
        MultipleEntry.add(MonthTextField1);
        MonthTextField1.setBounds(612, 157, 20, 17);

        PoNoTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        PoNoTextField1.setToolTipText("Type the PO No.");
        PoNoTextField1.setBorder(null);
        PoNoTextField1.setMaximumSize(new java.awt.Dimension(152, 19));
        PoNoTextField1.setMinimumSize(new java.awt.Dimension(152, 19));
        PoNoTextField1.setPreferredSize(new java.awt.Dimension(152, 19));
        PoNoTextField1.setSelectionColor(new java.awt.Color(153, 0, 153));
        PoNoTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoNoTextField1ActionPerformed(evt);
            }
        });
        MultipleEntry.add(PoNoTextField1);
        PoNoTextField1.setBounds(214, 205, 152, 16);

        YearTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        YearTextField1.setToolTipText("Type year");
        YearTextField1.setBorder(null);
        MultipleEntry.add(YearTextField1);
        YearTextField1.setBounds(648, 157, 34, 16);

        DeptTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        DeptTextField1.setToolTipText("Type the place of buyer");
        DeptTextField1.setBorder(null);
        DeptTextField1.setMaximumSize(new java.awt.Dimension(152, 19));
        DeptTextField1.setMinimumSize(new java.awt.Dimension(152, 19));
        DeptTextField1.setPreferredSize(new java.awt.Dimension(152, 19));
        DeptTextField1.setSelectionColor(new java.awt.Color(153, 0, 153));
        DeptTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptTextField1ActionPerformed(evt);
            }
        });
        MultipleEntry.add(DeptTextField1);
        DeptTextField1.setBounds(214, 349, 152, 16);

        ItemTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        ItemTextField1.setBorder(null);
        MultipleEntry.add(ItemTextField1);
        ItemTextField1.setBounds(214, 253, 316, 16);

        BuyerTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        BuyerTextField1.setBorder(null);
        MultipleEntry.add(BuyerTextField1);
        BuyerTextField1.setBounds(214, 301, 316, 16);

        PriceTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        PriceTextField1.setToolTipText("Type the place of buyer");
        PriceTextField1.setBorder(null);
        PriceTextField1.setMaximumSize(new java.awt.Dimension(152, 19));
        PriceTextField1.setMinimumSize(new java.awt.Dimension(152, 19));
        PriceTextField1.setPreferredSize(new java.awt.Dimension(152, 19));
        PriceTextField1.setSelectionColor(new java.awt.Color(153, 0, 153));
        PriceTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTextField1ActionPerformed(evt);
            }
        });
        MultipleEntry.add(PriceTextField1);
        PriceTextField1.setBounds(214, 397, 152, 16);

        WarrantyMonth1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        WarrantyMonth1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        WarrantyMonth1.setToolTipText("Type day");
        WarrantyMonth1.setBorder(null);
        WarrantyMonth1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        WarrantyMonth1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        WarrantyMonth1.setMaximumSize(new java.awt.Dimension(6, 20));
        WarrantyMonth1.setName(""); // NOI18N
        WarrantyMonth1.setOpaque(false);
        WarrantyMonth1.setSelectionColor(new java.awt.Color(153, 0, 153));
        MultipleEntry.add(WarrantyMonth1);
        WarrantyMonth1.setBounds(573, 205, 20, 17);

        WarehouseMonth1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        WarehouseMonth1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        WarehouseMonth1.setToolTipText("Type Month");
        WarehouseMonth1.setBorder(null);
        WarehouseMonth1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        WarehouseMonth1.setMaximumSize(new java.awt.Dimension(6, 20));
        WarehouseMonth1.setName(""); // NOI18N
        WarehouseMonth1.setOpaque(false);
        WarehouseMonth1.setSelectionColor(new java.awt.Color(153, 0, 153));
        MultipleEntry.add(WarehouseMonth1);
        WarehouseMonth1.setBounds(612, 205, 20, 17);

        TypeOfWarranty1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        TypeOfWarranty1.setForeground(new java.awt.Color(153, 0, 153));
        TypeOfWarranty1.setText("Type of Warranty");
        MultipleEntry.add(TypeOfWarranty1);
        TypeOfWarranty1.setBounds(430, 208, 120, 18);

        Item1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Item1.setForeground(new java.awt.Color(153, 0, 153));
        Item1.setText("Item");
        MultipleEntry.add(Item1);
        Item1.setBounds(80, 256, 31, 18);

        PoNoField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        MultipleEntry.add(PoNoField1);
        PoNoField1.setBounds(210, 202, 160, 21);

        PoNo1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        PoNo1.setForeground(new java.awt.Color(153, 0, 153));
        PoNo1.setText("PO No.");
        MultipleEntry.add(PoNo1);
        PoNo1.setBounds(80, 208, 50, 18);

        Dash3.setText("-");
        MultipleEntry.add(Dash3);
        Dash3.setBounds(638, 157, 6, 14);

        Dash4.setText("-");
        MultipleEntry.add(Dash4);
        Dash4.setBounds(600, 157, 6, 14);

        MonthField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        MultipleEntry.add(MonthField1);
        MonthField1.setBounds(608, 154, 27, 21);

        DateField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        MultipleEntry.add(DateField1);
        DateField1.setBounds(570, 154, 27, 21);

        PurchasedDate1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        PurchasedDate1.setForeground(new java.awt.Color(153, 0, 153));
        PurchasedDate1.setText("Date of Purchase");
        MultipleEntry.add(PurchasedDate1);
        PurchasedDate1.setBounds(430, 160, 130, 19);

        No_ofTransformers.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        No_ofTransformers.setForeground(new java.awt.Color(153, 0, 153));
        No_ofTransformers.setText("No. of Transformers");
        MultipleEntry.add(No_ofTransformers);
        No_ofTransformers.setBounds(56, 160, 140, 18);

        SpecificationEditTxt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        SpecificationEditTxt1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        MultipleEntry.add(SpecificationEditTxt1);
        SpecificationEditTxt1.setBounds(210, 154, 160, 21);
        MultipleEntry.add(WarningArea2);
        WarningArea2.setBounds(72, 78, 400, 17);

        Place1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Place1.setForeground(new java.awt.Color(153, 0, 153));
        Place1.setText("Department");
        MultipleEntry.add(Place1);
        Place1.setBounds(80, 350, 90, 18);

        PlaceField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        MultipleEntry.add(PlaceField1);
        PlaceField1.setBounds(210, 346, 160, 21);

        NEW1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        NEW1.setForeground(new java.awt.Color(153, 0, 153));
        NEW1.setText("New");
        MultipleEntry.add(NEW1);
        NEW1.setBounds(20, 18, 80, 30);

        Astrisk9.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk9.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk9.setText("*");
        MultipleEntry.add(Astrisk9);
        Astrisk9.setBounds(128, 206, 10, 16);

        Astrisk10.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk10.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk10.setText("*");
        MultipleEntry.add(Astrisk10);
        Astrisk10.setBounds(548, 157, 10, 16);

        ItemField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        MultipleEntry.add(ItemField1);
        ItemField1.setBounds(210, 250, 324, 21);

        Mandatory2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        Mandatory2.setForeground(new java.awt.Color(255, 0, 51));
        Mandatory2.setText("* Fields are mandatory to fill");
        MultipleEntry.add(Mandatory2);
        Mandatory2.setBounds(70, 100, 160, 12);

        Astrisk11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk11.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk11.setText("*");
        MultipleEntry.add(Astrisk11);
        Astrisk11.setBounds(552, 206, 10, 16);

        Astrisk12.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk12.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk12.setText("*");
        MultipleEntry.add(Astrisk12);
        Astrisk12.setBounds(194, 158, 10, 16);

        YearField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/year.png"))); // NOI18N
        MultipleEntry.add(YearField1);
        YearField1.setBounds(644, 154, 44, 21);

        Bar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        MultipleEntry.add(Bar2);
        Bar2.setBounds(0, 76, 784, 21);

        BuyerField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        MultipleEntry.add(BuyerField1);
        BuyerField1.setBounds(210, 298, 324, 21);

        Buyer1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Buyer1.setForeground(new java.awt.Color(153, 0, 153));
        Buyer1.setText("Buyer");
        MultipleEntry.add(Buyer1);
        Buyer1.setBounds(80, 304, 40, 18);

        Astrisk13.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk13.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk13.setText("*");
        MultipleEntry.add(Astrisk13);
        Astrisk13.setBounds(112, 254, 10, 16);

        Astrisk14.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk14.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk14.setText("*");
        MultipleEntry.add(Astrisk14);
        Astrisk14.setBounds(122, 302, 10, 16);

        Astrisk15.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk15.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk15.setText("*");
        MultipleEntry.add(Astrisk15);
        Astrisk15.setBounds(164, 350, 10, 16);

        NextButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NextButton_default1.png"))); // NOI18N
        NextButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NextButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NextButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NextButton1MouseReleased(evt);
            }
        });
        MultipleEntry.add(NextButton1);
        NextButton1.setBounds(490, 440, 80, 25);

        WarehouseTextbox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        MultipleEntry.add(WarehouseTextbox1);
        WarehouseTextbox1.setBounds(608, 202, 27, 21);

        Divide1.setText("/");
        MultipleEntry.add(Divide1);
        Divide1.setBounds(600, 205, 4, 14);

        WarrantyTextbox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        MultipleEntry.add(WarrantyTextbox1);
        WarrantyTextbox1.setBounds(570, 202, 27, 21);

        Astrisk16.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk16.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk16.setText("*");
        MultipleEntry.add(Astrisk16);
        Astrisk16.setBounds(116, 398, 10, 16);

        PriceField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        MultipleEntry.add(PriceField1);
        PriceField1.setBounds(210, 394, 160, 21);

        Price1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Price1.setForeground(new java.awt.Color(153, 0, 153));
        Price1.setText("Price");
        MultipleEntry.add(Price1);
        Price1.setBounds(80, 400, 34, 18);

        CancelButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/cancelButton_default_3.png"))); // NOI18N
        CancelButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CancelButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CancelButton1MouseReleased(evt);
            }
        });
        MultipleEntry.add(CancelButton1);
        CancelButton1.setBounds(580, 440, 80, 25);

        New_rightsidebarpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        MultipleEntry.add(New_rightsidebarpanel1);
        New_rightsidebarpanel1.setBounds(0, 0, 784, 550);

        getContentPane().add(MultipleEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        Search_Rightsidebarpanel.setMaximumSize(new java.awt.Dimension(784, 550));
        Search_Rightsidebarpanel.setMinimumSize(new java.awt.Dimension(784, 550));
        Search_Rightsidebarpanel.setPreferredSize(new java.awt.Dimension(784, 550));
        Search_Rightsidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 0, 153));
        jLabel37.setText("Enter Specification Number");
        jLabel37.setToolTipText("");
        Search_Rightsidebarpanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        Search_Rightsidebarpanel.add(Search_Specification_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 190, -1));

        Se_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Submit.png"))); // NOI18N
        Se_Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Se_SubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Se_SubmitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Se_SubmitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Se_SubmitMouseReleased(evt);
            }
        });
        Search_Rightsidebarpanel.add(Se_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 96, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 0, 153));
        jLabel39.setText("Specfication Number");
        Search_Rightsidebarpanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        Se_Item.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 320, 20));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(153, 0, 153));
        jLabel41.setText("Date of Purchase");
        Search_Rightsidebarpanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        Se_PurchasedMonth.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_PurchasedMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 20, 20));

        Se_PurchasedYear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_PurchasedYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 50, 20));

        Se_Warehouse.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Warehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 20, 20));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 0, 153));
        jLabel45.setText("PO Number");
        Search_Rightsidebarpanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        Se_Price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 140, 20));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 0, 153));
        jLabel47.setText("Type of Warranty");
        Search_Rightsidebarpanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        Se_PurchasedDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_PurchasedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 20, 20));

        Se_Warranty.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Warranty, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 20, 20));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(153, 0, 153));
        jLabel50.setText("Buyer ");
        jLabel50.setToolTipText("");
        Search_Rightsidebarpanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        Se_Po_No.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Po_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 140, 20));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(153, 0, 153));
        jLabel52.setText("Item");
        Search_Rightsidebarpanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        Se_Buyer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Buyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 320, 20));

        Department.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Department.setForeground(new java.awt.Color(153, 0, 153));
        Department.setText("Department");
        Search_Rightsidebarpanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        Se_SpecificationNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_SpecificationNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 140, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 153));
        jLabel15.setText("Price");
        Search_Rightsidebarpanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        Se_Department.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Search_Rightsidebarpanel.add(Se_Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 140, 20));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 153));
        jLabel25.setText("Search");
        Search_Rightsidebarpanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Search_rightsidebarpanel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        Search_rightsidebarpanel1.setForeground(new java.awt.Color(153, 0, 153));
        Search_rightsidebarpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        Search_Rightsidebarpanel.add(Search_rightsidebarpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Search_Rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        SearchByPO.setMaximumSize(new java.awt.Dimension(784, 550));
        SearchByPO.setMinimumSize(new java.awt.Dimension(784, 550));
        SearchByPO.setPreferredSize(new java.awt.Dimension(784, 550));
        SearchByPO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 0, 153));
        jLabel31.setText("Enter PO Number");
        SearchByPO.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));
        SearchByPO.add(SearchByPONumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, -1));

        SearchByPO_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Submit.png"))); // NOI18N
        SearchByPO_Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchByPO_SubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchByPO_SubmitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchByPO_SubmitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SearchByPO_SubmitMouseReleased(evt);
            }
        });
        SearchByPO.add(SearchByPO_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 96, -1, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Specification Number", "PO Number", "Buyer", "Department", "Item", "Type of Warranty", "Purchased Date", "Installation Date", "Expiry Date"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setRowHeight(25);
        jScrollPane2.setViewportView(jTable1);

        SearchByPO.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 740, 340));

        jLabel26.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 0, 153));
        jLabel26.setText("Search PO Number");
        SearchByPO.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Search_rightsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        SearchByPO.add(Search_rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(SearchByPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        SearchByDepartment.setMaximumSize(new java.awt.Dimension(784, 550));
        SearchByDepartment.setMinimumSize(new java.awt.Dimension(784, 550));
        SearchByDepartment.setName(""); // NOI18N
        SearchByDepartment.setPreferredSize(new java.awt.Dimension(784, 550));
        SearchByDepartment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 0, 153));
        jLabel33.setText("Enter Department");
        SearchByDepartment.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));
        SearchByDepartment.add(SD_Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, -1));

        SD_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Submit.png"))); // NOI18N
        SD_Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SD_SubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SD_SubmitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SD_SubmitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SD_SubmitMouseReleased(evt);
            }
        });
        SearchByDepartment.add(SD_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 96, -1, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Specification Number", "PO Number", "Buyer", "Department", "Item", "Type of Warranty", "Purchased Date", "Installation Date", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable2.setRowHeight(25);
        jScrollPane3.setViewportView(jTable2);

        SearchByDepartment.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 740, 340));

        jLabel28.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 0, 153));
        jLabel28.setText("Search by Department");
        SearchByDepartment.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Search_rightsidebarpanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        SearchByDepartment.add(Search_rightsidebarpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(SearchByDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        SearchByUnderPO.setMaximumSize(new java.awt.Dimension(784, 550));
        SearchByUnderPO.setMinimumSize(new java.awt.Dimension(784, 550));
        SearchByUnderPO.setPreferredSize(new java.awt.Dimension(784, 550));
        SearchByUnderPO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 0, 153));
        jLabel35.setText("Enter PO Number");
        SearchByUnderPO.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));
        SearchByUnderPO.add(SUP_Po_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, -1));

        SUP_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Submit.png"))); // NOI18N
        SUP_Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SUP_SubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SUP_SubmitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SUP_SubmitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SUP_SubmitMouseReleased(evt);
            }
        });
        SearchByUnderPO.add(SUP_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 96, -1, -1));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Specification Number", "PO Number", "Buyer", "Department", "Item", "Type of Warranty", "Purchased Date", "Installation Date", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable3.setRowHeight(25);
        jScrollPane4.setViewportView(jTable3);

        SearchByUnderPO.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 740, 340));

        jLabel30.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 0, 153));
        jLabel30.setText("Search by PO under repair");
        SearchByUnderPO.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Search_rightsidebarpanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        SearchByUnderPO.add(Search_rightsidebarpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(SearchByUnderPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        Complain_Ridesidebarpanel.setMaximumSize(new java.awt.Dimension(784, 550));
        Complain_Ridesidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Specification_no_textfield.setBorder(null);
        Complain_Ridesidebarpanel.add(Specification_no_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 188, 157, 16));

        Date_textfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Date_textfield.setBorder(null);
        Complain_Ridesidebarpanel.add(Date_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 248, 20, 17));

        Month_textfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Month_textfield.setBorder(null);
        Complain_Ridesidebarpanel.add(Month_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 248, 20, 17));

        Year_textfield.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        Year_textfield.setBorder(null);
        Complain_Ridesidebarpanel.add(Year_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 249, 34, 16));

        COMPLAIN.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        COMPLAIN.setForeground(new java.awt.Color(153, 0, 153));
        COMPLAIN.setText("Complain");
        Complain_Ridesidebarpanel.add(COMPLAIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        Specification_No.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Specification_No.setForeground(new java.awt.Color(153, 0, 153));
        Specification_No.setText("Specification Number");
        Complain_Ridesidebarpanel.add(Specification_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        Specification_no_textbox.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Specification_no_textbox.setForeground(new java.awt.Color(153, 0, 153));
        Specification_no_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Textfield1.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(Specification_no_textbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 185, -1, -1));

        Date_of_complain.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Date_of_complain.setForeground(new java.awt.Color(153, 0, 153));
        Date_of_complain.setText("Date of Complain");
        Complain_Ridesidebarpanel.add(Date_of_complain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        Date_textbox.setForeground(new java.awt.Color(153, 0, 153));
        Date_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(Date_textbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 245, -1, -1));

        Separator1.setText("-");
        Complain_Ridesidebarpanel.add(Separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 248, -1, -1));

        Mandatory1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        Mandatory1.setForeground(new java.awt.Color(255, 0, 51));
        Mandatory1.setText("* Fields are mandatory to fill");
        Complain_Ridesidebarpanel.add(Mandatory1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 160, -1));
        Complain_Ridesidebarpanel.add(WarningArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 78, 400, 17));

        Month_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Date_textfield.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(Month_textbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 245, -1, -1));

        Separator2.setText("-");
        Complain_Ridesidebarpanel.add(Separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 248, -1, -1));

        year_textbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/year.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(year_textbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 245, -1, -1));

        Cause_of_failure.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Cause_of_failure.setForeground(new java.awt.Color(153, 0, 153));
        Cause_of_failure.setText("Cause of failure");
        Complain_Ridesidebarpanel.add(Cause_of_failure, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        Next_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/NextButton_default1.png"))); // NOI18N
        Next_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Next_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Next_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Next_buttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Next_buttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Next_buttonMouseReleased(evt);
            }
        });
        Complain_Ridesidebarpanel.add(Next_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        Cancel_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/cancelButton_default_3.png"))); // NOI18N
        Cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Cancel_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Cancel_buttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Cancel_buttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Cancel_buttonMouseReleased(evt);
            }
        });
        Complain_Ridesidebarpanel.add(Cancel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        TextArea.setColumns(20);
        TextArea.setLineWrap(true);
        TextArea.setRows(5);
        TextArea.setBorder(null);
        TextArea.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(TextArea);

        Complain_Ridesidebarpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 312, 247, 78));

        Text_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/TextArea.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(Text_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        Bar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(Bar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, -1, -1));

        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("*");
        Complain_Ridesidebarpanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 184, -1, -1));

        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("*");
        Complain_Ridesidebarpanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 246, -1, -1));

        Complain_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        Complain_Ridesidebarpanel.add(Complain_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Complain_Ridesidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        Profile_Rightsidebarpanel.setMinimumSize(new java.awt.Dimension(784, 550));
        Profile_Rightsidebarpanel.setPreferredSize(new java.awt.Dimension(784, 550));
        Profile_Rightsidebarpanel.setLayout(null);

        NEW2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        NEW2.setForeground(new java.awt.Color(153, 0, 153));
        NEW2.setText("Profile");
        NEW2.setToolTipText("");
        Profile_Rightsidebarpanel.add(NEW2);
        NEW2.setBounds(20, 18, 90, 30);

        accountype.setForeground(new java.awt.Color(153, 0, 153));
        Profile_Rightsidebarpanel.add(accountype);
        accountype.setBounds(710, 80, 60, 13);

        Bar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        Profile_Rightsidebarpanel.add(Bar3);
        Bar3.setBounds(0, 76, 784, 21);

        Username.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Username.setForeground(new java.awt.Color(153, 0, 153));
        Username.setText("Username");
        Profile_Rightsidebarpanel.add(Username);
        Username.setBounds(80, 160, 72, 18);

        Emailid.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Emailid.setForeground(new java.awt.Color(153, 0, 153));
        Emailid.setText("Email ID");
        Emailid.setToolTipText("");
        Profile_Rightsidebarpanel.add(Emailid);
        Emailid.setBounds(80, 380, 58, 18);

        password.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        password.setForeground(new java.awt.Color(153, 0, 153));
        password.setText("Password");
        Profile_Rightsidebarpanel.add(password);
        password.setBounds(80, 325, 68, 18);

        Firstname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Firstname.setForeground(new java.awt.Color(153, 0, 153));
        Firstname.setText("First Name");
        Profile_Rightsidebarpanel.add(Firstname);
        Firstname.setBounds(80, 215, 77, 18);

        Lastname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Lastname.setForeground(new java.awt.Color(153, 0, 153));
        Lastname.setText("Last Name");
        Lastname.setToolTipText("");
        Profile_Rightsidebarpanel.add(Lastname);
        Lastname.setBounds(80, 270, 75, 18);

        jPasswordField1.setForeground(new java.awt.Color(153, 0, 153));
        jPasswordField1.setText("Password");
        jPasswordField1.setToolTipText("");
        Profile_Rightsidebarpanel.add(jPasswordField1);
        jPasswordField1.setBounds(211, 326, 322, 19);

        PasswordField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        PasswordField.setText("Password");
        PasswordField.setToolTipText("");
        Profile_Rightsidebarpanel.add(PasswordField);
        PasswordField.setBounds(210, 325, 324, 21);

        EditButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Edit.png"))); // NOI18N
        EditButton3.setToolTipText("");
        EditButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditButton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EditButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditButton3MouseReleased(evt);
            }
        });
        Profile_Rightsidebarpanel.add(EditButton3);
        EditButton3.setBounds(620, 325, 40, 18);

        usernamelabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        usernamelabel.setForeground(new java.awt.Color(153, 0, 153));
        Profile_Rightsidebarpanel.add(usernamelabel);
        usernamelabel.setBounds(211, 160, 300, 20);

        firstnamelabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        firstnamelabel.setForeground(new java.awt.Color(153, 0, 153));
        firstnamelabel.setToolTipText("");
        Profile_Rightsidebarpanel.add(firstnamelabel);
        firstnamelabel.setBounds(211, 215, 300, 20);

        lastnamelabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        lastnamelabel.setForeground(new java.awt.Color(153, 0, 153));
        lastnamelabel.setToolTipText("");
        Profile_Rightsidebarpanel.add(lastnamelabel);
        lastnamelabel.setBounds(211, 270, 300, 20);

        emaillabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        emaillabel.setForeground(new java.awt.Color(153, 0, 153));
        emaillabel.setToolTipText("");
        Profile_Rightsidebarpanel.add(emaillabel);
        emaillabel.setBounds(211, 380, 300, 20);

        Profile_rightsidebarpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        Profile_rightsidebarpanel.setText("jLabel2");
        Profile_rightsidebarpanel.setMaximumSize(new java.awt.Dimension(784, 550));
        Profile_rightsidebarpanel.setMinimumSize(new java.awt.Dimension(784, 550));
        Profile_Rightsidebarpanel.add(Profile_rightsidebarpanel);
        Profile_rightsidebarpanel.setBounds(0, 0, 784, 550);

        getContentPane().add(Profile_Rightsidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        AddNewUser.setLayout(null);

        username1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        username1.setForeground(new java.awt.Color(153, 0, 153));
        username1.setText("Username");
        AddNewUser.add(username1);
        username1.setBounds(60, 160, 72, 18);

        accountype1.setForeground(new java.awt.Color(153, 0, 153));
        AddNewUser.add(accountype1);
        accountype1.setBounds(710, 80, 60, 13);

        firstname1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        firstname1.setForeground(new java.awt.Color(153, 0, 153));
        firstname1.setText("First Name");
        AddNewUser.add(firstname1);
        firstname1.setBounds(60, 215, 77, 18);

        Bar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        AddNewUser.add(Bar4);
        Bar4.setBounds(0, 76, 784, 21);

        email.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        email.setForeground(new java.awt.Color(153, 0, 153));
        email.setText("Email ID");
        email.setToolTipText("");
        AddNewUser.add(email);
        email.setBounds(60, 435, 58, 18);

        NEW3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        NEW3.setForeground(new java.awt.Color(153, 0, 153));
        NEW3.setText("Create New User");
        NEW3.setToolTipText("");
        AddNewUser.add(NEW3);
        NEW3.setBounds(20, 18, 222, 30);

        password1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        password1.setForeground(new java.awt.Color(153, 0, 153));
        password1.setText("Password");
        AddNewUser.add(password1);
        password1.setBounds(60, 325, 68, 18);

        lastname1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        lastname1.setForeground(new java.awt.Color(153, 0, 153));
        lastname1.setText("Last Name");
        lastname1.setToolTipText("");
        AddNewUser.add(lastname1);
        lastname1.setBounds(60, 270, 75, 18);

        UsernameField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        AddNewUser.add(UsernameField1);
        UsernameField1.setBounds(210, 160, 324, 21);

        UsernameTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        UsernameTextField1.setForeground(new java.awt.Color(153, 0, 153));
        UsernameTextField1.setBorder(null);
        UsernameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTextField1ActionPerformed(evt);
            }
        });
        AddNewUser.add(UsernameTextField1);
        UsernameTextField1.setBounds(214, 162, 316, 16);

        FirstNameField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        AddNewUser.add(FirstNameField1);
        FirstNameField1.setBounds(210, 215, 324, 21);

        FirstNameTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        FirstNameTextField1.setForeground(new java.awt.Color(153, 0, 153));
        FirstNameTextField1.setBorder(null);
        AddNewUser.add(FirstNameTextField1);
        FirstNameTextField1.setBounds(214, 217, 316, 16);

        LastnameField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        AddNewUser.add(LastnameField1);
        LastnameField1.setBounds(210, 270, 324, 21);

        LastNameTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        LastNameTextField1.setForeground(new java.awt.Color(153, 0, 153));
        LastNameTextField1.setBorder(null);
        AddNewUser.add(LastNameTextField1);
        LastNameTextField1.setBounds(214, 272, 316, 16);

        PasswordField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        AddNewUser.add(PasswordField1);
        PasswordField1.setBounds(210, 325, 324, 21);

        jPasswordField2.setForeground(new java.awt.Color(153, 0, 153));
        jPasswordField2.setToolTipText("");
        AddNewUser.add(jPasswordField2);
        jPasswordField2.setBounds(211, 326, 322, 19);

        EmailTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        EmailTextField1.setForeground(new java.awt.Color(153, 0, 153));
        EmailTextField1.setBorder(null);
        AddNewUser.add(EmailTextField1);
        EmailTextField1.setBounds(214, 437, 316, 16);

        EmailField1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        AddNewUser.add(EmailField1);
        EmailField1.setBounds(210, 435, 324, 21);

        accounttype.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        accounttype.setForeground(new java.awt.Color(153, 0, 153));
        accounttype.setText("Account Type");
        accounttype.setToolTipText("");
        AddNewUser.add(accounttype);
        accounttype.setBounds(60, 490, 93, 18);

        jComboBox1.setForeground(new java.awt.Color(153, 0, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Sub-Admin" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        AddNewUser.add(jComboBox1);
        jComboBox1.setBounds(210, 490, 120, 21);

        Astrisk17.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk17.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk17.setText("*");
        AddNewUser.add(Astrisk17);
        Astrisk17.setBounds(128, 322, 10, 16);

        confpassword.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        confpassword.setForeground(new java.awt.Color(153, 0, 153));
        confpassword.setText("Confirm Password");
        AddNewUser.add(confpassword);
        confpassword.setBounds(60, 380, 128, 18);

        jPasswordField3.setForeground(new java.awt.Color(153, 0, 153));
        jPasswordField3.setToolTipText("");
        AddNewUser.add(jPasswordField3);
        jPasswordField3.setBounds(211, 381, 322, 19);

        PasswordField2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Buyer.png"))); // NOI18N
        AddNewUser.add(PasswordField2);
        PasswordField2.setBounds(210, 380, 324, 21);

        Astrisk18.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk18.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk18.setText("*");
        AddNewUser.add(Astrisk18);
        Astrisk18.setBounds(188, 376, 10, 16);

        Astrisk19.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk19.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk19.setText("*");
        AddNewUser.add(Astrisk19);
        Astrisk19.setBounds(118, 432, 10, 16);

        Astrisk20.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk20.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk20.setText("*");
        AddNewUser.add(Astrisk20);
        Astrisk20.setBounds(152, 488, 10, 16);

        Astrisk21.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Astrisk21.setForeground(new java.awt.Color(255, 0, 51));
        Astrisk21.setText("*");
        AddNewUser.add(Astrisk21);
        Astrisk21.setBounds(130, 158, 10, 16);

        Createbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Create.png"))); // NOI18N
        Createbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatebuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreatebuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatebuttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CreatebuttonMouseReleased(evt);
            }
        });
        AddNewUser.add(Createbutton);
        Createbutton.setBounds(435, 490, 100, 30);
        AddNewUser.add(Warninguser);
        Warninguser.setBounds(570, 160, 180, 0);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        AddNewUser.add(jLabel2);
        jLabel2.setBounds(0, 0, 784, 550);

        getContentPane().add(AddNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        DeleteUserPanel.setLayout(null);

        NEW4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        NEW4.setForeground(new java.awt.Color(153, 0, 153));
        NEW4.setText("Delete Users");
        NEW4.setToolTipText("");
        DeleteUserPanel.add(NEW4);
        NEW4.setBounds(20, 18, 167, 30);

        Bar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        DeleteUserPanel.add(Bar5);
        Bar5.setBounds(0, 76, 784, 21);

        deletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Delete.png"))); // NOI18N
        deletebutton.setText("jLabel4");
        deletebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deletebuttonMousePressed(evt);
            }
        });
        DeleteUserPanel.add(deletebutton);
        deletebutton.setBounds(240, 450, 80, 30);

        jComboBox2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(153, 0, 153));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        DeleteUserPanel.add(jComboBox2);
        jComboBox2.setBounds(250, 160, 180, 24);

        uname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        uname.setForeground(new java.awt.Color(153, 0, 153));
        uname.setText("User Name :");
        DeleteUserPanel.add(uname);
        uname.setBounds(60, 270, 85, 18);

        id.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        id.setForeground(new java.awt.Color(153, 0, 153));
        id.setText("Email Id :");
        DeleteUserPanel.add(id);
        id.setBounds(60, 325, 62, 18);

        typeacc.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        typeacc.setForeground(new java.awt.Color(153, 0, 153));
        typeacc.setText("Account Type :");
        DeleteUserPanel.add(typeacc);
        typeacc.setBounds(60, 380, 100, 18);

        unamelabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        unamelabel.setForeground(new java.awt.Color(153, 0, 153));
        DeleteUserPanel.add(unamelabel);
        unamelabel.setBounds(250, 270, 200, 20);

        emailidlabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        emailidlabel.setForeground(new java.awt.Color(153, 0, 153));
        DeleteUserPanel.add(emailidlabel);
        emailidlabel.setBounds(250, 325, 200, 20);

        acctypelabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        acctypelabel.setForeground(new java.awt.Color(153, 0, 153));
        DeleteUserPanel.add(acctypelabel);
        acctypelabel.setBounds(250, 380, 200, 20);

        jButton1.setText("Show Details");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        DeleteUserPanel.add(jButton1);
        jButton1.setBounds(470, 110, 100, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("Select Username");
        DeleteUserPanel.add(jLabel4);
        jLabel4.setBounds(60, 160, 117, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        DeleteUserPanel.add(jLabel3);
        jLabel3.setBounds(0, 0, 784, 550);

        getContentPane().add(DeleteUserPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        HelpRightside_panel.setLayout(null);

        NEW6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 30)); // NOI18N
        NEW6.setForeground(new java.awt.Color(153, 0, 153));
        NEW6.setText("Getting Started");
        NEW6.setToolTipText("");
        HelpRightside_panel.add(NEW6);
        NEW6.setBounds(20, 18, 202, 30);

        Bar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/layer.png"))); // NOI18N
        HelpRightside_panel.add(Bar7);
        Bar7.setBounds(0, 76, 784, 21);

        installhelp.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        installhelp.setForeground(new java.awt.Color(153, 0, 153));
        installhelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/installdate.png"))); // NOI18N
        installhelp.setToolTipText("");
        installhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                installhelpMousePressed(evt);
            }
        });
        HelpRightside_panel.add(installhelp);
        installhelp.setBounds(60, 270, 300, 20);

        addrecord.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        addrecord.setForeground(new java.awt.Color(153, 0, 153));
        addrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/addrecordhelp.png"))); // NOI18N
        addrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addrecordMousePressed(evt);
            }
        });
        HelpRightside_panel.add(addrecord);
        addrecord.setBounds(60, 160, 160, 20);

        reinstallhelp.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        reinstallhelp.setForeground(new java.awt.Color(153, 0, 153));
        reinstallhelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/reinstall.png"))); // NOI18N
        reinstallhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reinstallhelpMousePressed(evt);
            }
        });
        HelpRightside_panel.add(reinstallhelp);
        reinstallhelp.setBounds(60, 325, 300, 20);

        addcomplain.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        addcomplain.setForeground(new java.awt.Color(153, 0, 153));
        addcomplain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/addingcomplain.png"))); // NOI18N
        addcomplain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addcomplainMousePressed(evt);
            }
        });
        HelpRightside_panel.add(addcomplain);
        addcomplain.setBounds(60, 215, 230, 20);

        usingprofile.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        usingprofile.setForeground(new java.awt.Color(153, 0, 153));
        usingprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Usingprofile.png"))); // NOI18N
        usingprofile.setToolTipText("");
        usingprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usingprofileMousePressed(evt);
            }
        });
        HelpRightside_panel.add(usingprofile);
        usingprofile.setBounds(60, 435, 130, 20);

        workingrecord.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        workingrecord.setForeground(new java.awt.Color(153, 0, 153));
        workingrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/workingwithrecords.png"))); // NOI18N
        workingrecord.setToolTipText("");
        workingrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                workingrecordMousePressed(evt);
            }
        });
        HelpRightside_panel.add(workingrecord);
        workingrecord.setBounds(60, 380, 180, 20);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Rightsidepanel.png"))); // NOI18N
        jLabel17.setText("jLabel17");
        HelpRightside_panel.add(jLabel17);
        jLabel17.setBounds(0, 0, 784, 550);

        getContentPane().add(HelpRightside_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 784, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
      this.setState(Welcome.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
       ImageIcon II=new ImageIcon(getClass().getResource("Hover_close.png"));
       close.setIcon(II);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
       ImageIcon II=new ImageIcon(getClass().getResource("Default_close.png"));
       close.setIcon(II);
    }//GEN-LAST:event_closeMouseExited

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
       ImageIcon II=new ImageIcon(getClass().getResource("Hover_minimize.png"));
       minimize.setIcon(II);
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
      ImageIcon II=new ImageIcon(getClass().getResource("Default_minimize.png"));
      minimize.setIcon(II);
    }//GEN-LAST:event_minimizeMouseExited

    private void minimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMousePressed
      ImageIcon II=new ImageIcon(getClass().getResource("Pressed_minimize.png"));
      minimize.setIcon(II);
    }//GEN-LAST:event_minimizeMousePressed

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
      ImageIcon II=new ImageIcon(getClass().getResource("Pressed_close.png"));
      close.setIcon(II);
    }//GEN-LAST:event_closeMousePressed

    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
       ImageIcon II=new ImageIcon(getClass().getResource("Hover_close.png"));
       close.setIcon(II);
    }//GEN-LAST:event_closeMouseReleased

    private void minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseReleased
       ImageIcon II=new ImageIcon(getClass().getResource("Default_minimize.png"));
       minimize.setIcon(II);
    }//GEN-LAST:event_minimizeMouseReleased

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
    }//GEN-LAST:event_homeMouseClicked

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
       ImageIcon IH=new ImageIcon(getClass().getResource("Home_hover.png"));
       home.setIcon(IH);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
      ImageIcon IH=new ImageIcon(getClass().getResource("Home_pressed.png"));
      home.setIcon(IH);
    }//GEN-LAST:event_homeMousePressed

    private void homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseReleased
     ImageIcon IH=new ImageIcon(getClass().getResource("Home_hover.png"));
      home.setIcon(IH);
    }//GEN-LAST:event_homeMouseReleased

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
       ImageIcon IH=new ImageIcon(getClass().getResource("Home_default.png"));
       home.setIcon(IH);
    }//GEN-LAST:event_homeMouseExited

    private void recordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseEntered
       if(Flag==1)
       {
         ImageIcon IR=new ImageIcon(getClass().getResource("Record_pressed.png"));
         record.setIcon(IR);  
       }
       else
       {
         ImageIcon IR=new ImageIcon(getClass().getResource("Record_hover.png"));
         record.setIcon(IR);  
       }
        
    }//GEN-LAST:event_recordMouseEntered

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
      if(Flag==2)
      {
           ImageIcon IS=new ImageIcon(getClass().getResource("Search_clicked.png"));
           search.setIcon(IS); 
      }
      else
      {
         ImageIcon IS=new ImageIcon(getClass().getResource("Search_hover.png"));
         search.setIcon(IS);  
      }
              
    }//GEN-LAST:event_searchMouseEntered

    private void searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMousePressed
        Search.setVisible(true);
        Search.setEnabled(true);
        searchby.setVisible(true);
        searchby.setEnabled(true);
        this.slideshow5();
        ImageIcon IS=new ImageIcon(getClass().getResource("Search_clicked.png"));
        search.setIcon(IS);
        Flag=2;
        Search_Leftsidebarpanel.setVisible(true);
        Search_Leftsidebarpanel.setEnabled(true);
        S_history_button1.setVisible(true);
        S_history_button2.setVisible(true);
        S_history_button3.setVisible(true);
        S_history_button4.setVisible(true);
        S_history_button5.setVisible(true);
        S_history_button6.setVisible(true);
        S_history_button7.setVisible(true);
        S_history_button1.setEnabled(true);
        S_history_button2.setEnabled(true);
        S_history_button3.setEnabled(true);
        S_history_button4.setEnabled(true);
        S_history_button5.setEnabled(true);
        S_history_button6.setEnabled(true);
        S_history_button7.setEnabled(true);
        R_history_button1.setVisible(false);
        R_history_button2.setVisible(false);
        R_history_button3.setVisible(false);
        R_history_button4.setVisible(false);
        R_history_button5.setVisible(false);
        R_history_button6.setVisible(false);
        R_history_button7.setVisible(false);
        R_history_button1.setEnabled(false);
        R_history_button2.setEnabled(false);
        R_history_button3.setEnabled(false);
        R_history_button4.setEnabled(false);
        R_history_button5.setEnabled(false);
        R_history_button6.setEnabled(false);
        R_history_button7.setEnabled(false);
        Record.setVisible(false);
        Record.setEnabled(false);
        New.setVisible(false);
        New.setEnabled(false);
        Edit.setVisible(false);
        Edit.setEnabled(false);
        Delete.setVisible(false);
        Delete.setEnabled(false);
        Record_Leftsidebarpanel.setVisible(false);
        Record_Leftsidebarpanel.setEnabled(false);
        View_Leftsidebarpanel.setVisible(false);
        View_Leftsidebarpanel.setEnabled(false);
        Help_Leftsidebarpanel.setVisible(false);
        Help_Leftsidebarpanel.setEnabled(false);
        Profile_Leftsidebarpanel.setVisible(false);
        Profile_Leftsidebarpanel.setEnabled(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_searchMousePressed

    private void searchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseReleased
      if(Flag==2)
      {
          
          ImageIcon IS=new ImageIcon(getClass().getResource("Search_clicked.png"));
          search.setIcon(IS);  
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Default.png"));
          view.setIcon(IV);  
          ImageIcon IR=new ImageIcon(getClass().getResource("Record_default1.png"));
          record.setIcon(IR);
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_default.png"));
          profile.setIcon(IP);
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_default.png"));
          help.setIcon(IH);
          ImageIcon IA=new ImageIcon(getClass().getResource("About_default.png"));
          about.setIcon(IA);  
      }
      else
      {
          ImageIcon IS=new ImageIcon(getClass().getResource("Search_clicked.png"));
          search.setIcon(IS);
      }
    }//GEN-LAST:event_searchMouseReleased

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
      if(Flag==2)
      {
       ImageIcon IS=new ImageIcon(getClass().getResource("Search_clicked.png"));
       search.setIcon(IS);
      }
      else 
      {
        ImageIcon IS=new ImageIcon(getClass().getResource("Search_default.png"));
        search.setIcon(IS);
      } 
    }//GEN-LAST:event_searchMouseExited

    private void viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseEntered
      if(Flag==3)
      {
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Pressed.png"));
          view.setIcon(IV);
      }
      else
      {
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Hover.png"));
          view.setIcon(IV);
      }
        
      
    }//GEN-LAST:event_viewMouseEntered

    private void viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseExited
      if(Flag==3)
      {
       ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Pressed.png"));
       view.setIcon(IV);
      }
      else
      {
        ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Default.png"));
        view.setIcon(IV);  
       }
    }//GEN-LAST:event_viewMouseExited

    private void viewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMousePressed
       this.slideshow6();
       ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Pressed.png"));
       view.setIcon(IV);
       Flag=3;
       Search.setVisible(false);
       Search.setEnabled(false);
       Record.setVisible(false);
       Record.setEnabled(false);
       View.setVisible(true);
       View.setEnabled(true);
       Profile.setVisible(false);
       Profile.setEnabled(false);
       Help.setVisible(false);
       Help.setEnabled(false);
       About.setVisible(false);
       About.setEnabled(false);
       Record_Leftsidebarpanel.setVisible(false);
       Record_Leftsidebarpanel.setEnabled(false);
       Search_Leftsidebarpanel.setVisible(false);
       Search_Leftsidebarpanel.setEnabled(false);
       View_Leftsidebarpanel.setVisible(true);
       View_Leftsidebarpanel.setEnabled(true);
       Help_Leftsidebarpanel.setVisible(false);
       Help_Leftsidebarpanel.setEnabled(false);
       Profile_Leftsidebarpanel.setVisible(false);
       Profile_Leftsidebarpanel.setEnabled(false);
       New_Rightsidebarpanel.setVisible(false);
       New_Rightsidebarpanel.setEnabled(false);
       Edit_Rightsidebarpanel.setVisible(false);
       Edit_Rightsidebarpanel.setEnabled(false);
       Delete_Rightsidebarpanel.setVisible(false);
       Delete_Rightsidebarpanel.setEnabled(false);
       Search_Rightsidebarpanel.setVisible(false);
       Search_Rightsidebarpanel.setEnabled(false);
       Complain_Ridesidebarpanel.setVisible(true);
       Complain_Ridesidebarpanel.setEnabled(true);
       Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByUnderPO.setEnabled(false);
       SearchByUnderPO.setVisible(false);
    }//GEN-LAST:event_viewMousePressed

    private void viewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseReleased
       if(Flag==3)
       {
           
           ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Pressed.png"));
           view.setIcon(IV); 
           ImageIcon IS=new ImageIcon(getClass().getResource("Search_default.png"));
           search.setIcon(IS);
           ImageIcon IR=new ImageIcon(getClass().getResource("Record_default1.png"));
           record.setIcon(IR);
           ImageIcon IP=new ImageIcon(getClass().getResource("Profile_default.png"));
           profile.setIcon(IP);
           ImageIcon IH=new ImageIcon(getClass().getResource("Help_default.png"));
           help.setIcon(IH);
           ImageIcon IA=new ImageIcon(getClass().getResource("About_default.png"));
           about.setIcon(IA);
       }
       else 
       {
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Pressed.png"));
          view.setIcon(IV);
       }
    }//GEN-LAST:event_viewMouseReleased

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
     
    }//GEN-LAST:event_viewMouseClicked

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseEntered
      if(Flag==4)
      {
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_clicked.png"));
          profile.setIcon(IP);
      }
      else
      {
           ImageIcon IP=new ImageIcon(getClass().getResource("Profile_hover.png"));
           profile.setIcon(IP);
      }
         
    }//GEN-LAST:event_profileMouseEntered

    private void profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseExited
      
      if(Flag==4)
      {
         ImageIcon IP=new ImageIcon(getClass().getResource("Profile_clicked.png"));
         profile.setIcon(IP);
      }
      else
      {
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_default.png"));
          profile.setIcon(IP);
      }
    }//GEN-LAST:event_profileMouseExited

    private void profileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMousePressed
      this.slideshow7();
      ImageIcon IP=new ImageIcon(getClass().getResource("Profile_clicked.png"));
      profile.setIcon(IP);
      Flag=4;
      Search.setVisible(false);
      Search.setEnabled(false);
      Record.setVisible(false);
      Record.setEnabled(false);
      View.setVisible(false);
      View.setEnabled(false);
      Profile.setVisible(true);
      Profile.setEnabled(true);
      Help.setVisible(false);
      Help.setEnabled(false);
      About.setVisible(false);
      About.setEnabled(false);
      Record_Leftsidebarpanel.setVisible(false);
      Record_Leftsidebarpanel.setEnabled(false);
      Search_Leftsidebarpanel.setVisible(false);
      Search_Leftsidebarpanel.setEnabled(false);
      View_Leftsidebarpanel.setVisible(false);
      View_Leftsidebarpanel.setEnabled(false);
      Help_Leftsidebarpanel.setVisible(false);
      Help_Leftsidebarpanel.setEnabled(false);
      Profile_Rightsidebarpanel.setVisible(true);
       Profile_Rightsidebarpanel.setEnabled(true);
        Profile_Leftsidebarpanel.setVisible(true);
       Profile_Leftsidebarpanel.setEnabled(true);
       New_Rightsidebarpanel.setVisible(false);
       New_Rightsidebarpanel.setEnabled(false);
       Search_Rightsidebarpanel.setVisible(false);
       Search_Rightsidebarpanel.setEnabled(false);
       Edit_Rightsidebarpanel.setVisible(false);
       Edit_Rightsidebarpanel.setEnabled(false);
       Delete_Rightsidebarpanel.setVisible(false);
       Delete_Rightsidebarpanel.setEnabled(false);
       MultipleEntry.setVisible(false);
       MultipleEntry.setEnabled(false);
       Complain_Ridesidebarpanel.setVisible(false);
       Complain_Ridesidebarpanel.setEnabled(false);
      accountype.setText(accountname);
      AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByUnderPO.setEnabled(false);
       SearchByUnderPO.setVisible(false);
       usernamelabel.setText(username);
       firstnamelabel.setText(firstname);
       lastnamelabel.setText(lastname);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
       emaillabel.setText(emailid);
       jPasswordField1.setEnabled(false);
       if(accountname.equals("Admin")){
           UserNew.setVisible(true);
           deleteuser.setVisible(true);
       }
       else{
           UserNew.setVisible(false);
           deleteuser.setVisible(false);
       }
    }//GEN-LAST:event_profileMousePressed

    private void profileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseReleased
      if(Flag==4)
      {
          
          ImageIcon IS=new ImageIcon(getClass().getResource("Search_default.png"));
          search.setIcon(IS);  
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Default.png"));
          view.setIcon(IV);  
          ImageIcon IR=new ImageIcon(getClass().getResource("Record_default1.png"));
          record.setIcon(IR);
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_clicked.png"));
          profile.setIcon(IP);
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_default.png"));
          help.setIcon(IH);
          ImageIcon IA=new ImageIcon(getClass().getResource("About_default.png"));
          about.setIcon(IA);  
      }
      else
      {
          ImageIcon IP=new ImageIcon(getClass().getResource("profile_clicked.png"));
          profile.setIcon(IP);
      }
    }//GEN-LAST:event_profileMouseReleased

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
      ImageIcon IH=new ImageIcon(getClass().getResource("Profile_clicked.png"));
      profile.setIcon(IH);
     Record_Leftsidebarpanel.setVisible(false);
      Record_Leftsidebarpanel.setEnabled(false);
      Search_Leftsidebarpanel.setVisible(false);
      Search_Leftsidebarpanel.setEnabled(false);
      View_Leftsidebarpanel.setVisible(false);
      View_Leftsidebarpanel.setEnabled(false);
      Help_Leftsidebarpanel.setVisible(false);
      Help_Leftsidebarpanel.setEnabled(false);
      Profile_Leftsidebarpanel.setVisible(true);
      Profile_Leftsidebarpanel.setEnabled(true);
      Profile_Rightsidebarpanel.setVisible(true);
       Profile_Rightsidebarpanel.setEnabled(true);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_profileMouseClicked

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
      ImageIcon IH=new ImageIcon(getClass().getResource("Help_clicked.png"));
      help.setIcon(IH);
    }//GEN-LAST:event_helpMouseClicked

    private void helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseEntered
      if(Flag==5)
      {
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_clicked.png"));
          help.setIcon(IH);
      }
      else
      {
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_hover.png"));
          help.setIcon(IH);
      }
        
    }//GEN-LAST:event_helpMouseEntered

    private void helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseExited
      if(Flag==5)
      {
      ImageIcon IH=new ImageIcon(getClass().getResource("Help_clicked.png"));
      help.setIcon(IH);
      }
      else
      {
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_default.png"));
          help.setIcon(IH);
      }
    }//GEN-LAST:event_helpMouseExited

    private void helpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMousePressed
      this.slideshow8();
      ImageIcon II=new ImageIcon(getClass().getResource("Help_clicked.png"));
      help.setIcon(II);
      Flag=5;
      Search.setVisible(false);
      Search.setEnabled(false);
      Record.setVisible(false);
      Record.setEnabled(false);
      View.setVisible(false);
      View.setEnabled(false);
      Profile.setVisible(false);
      Profile.setEnabled(false);
      Help.setVisible(true);
      Help.setEnabled(true);
      About.setVisible(false);
      About.setEnabled(false);
      Record_Leftsidebarpanel.setVisible(false);
      Record_Leftsidebarpanel.setEnabled(false);
      Search_Leftsidebarpanel.setVisible(false);
      Search_Leftsidebarpanel.setEnabled(false);
      View_Leftsidebarpanel.setVisible(false);
      View_Leftsidebarpanel.setEnabled(false);
      Help_Leftsidebarpanel.setVisible(true);
      Help_Leftsidebarpanel.setEnabled(true);
      Profile_Leftsidebarpanel.setVisible(false);
      Profile_Leftsidebarpanel.setEnabled(false);
      Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(true);
       HelpRightside_panel.setEnabled(true);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByUnderPO.setEnabled(false);
       SearchByUnderPO.setVisible(false);
       Complain_Ridesidebarpanel.setVisible(false);
       Complain_Ridesidebarpanel.setEnabled(false);
       Edit_Rightsidebarpanel.setVisible(false);
       Edit_Rightsidebarpanel.setEnabled(false);
       Delete_Rightsidebarpanel.setVisible(false);
       Delete_Rightsidebarpanel.setEnabled(false);
       MultipleEntry.setVisible(false);
       MultipleEntry.setEnabled(false);
    }//GEN-LAST:event_helpMousePressed

    private void helpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseReleased
      if(Flag==5)
      {
          
          ImageIcon IS=new ImageIcon(getClass().getResource("Search_default.png"));
          search.setIcon(IS);  
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Default.png"));
          view.setIcon(IV);  
          ImageIcon IR=new ImageIcon(getClass().getResource("Record_default1.png"));
          record.setIcon(IR);
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_default.png"));
          profile.setIcon(IP);
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_clicked.png"));
          help.setIcon(IH);
          ImageIcon IA=new ImageIcon(getClass().getResource("About_default.png"));
          about.setIcon(IA);  
      }
      else
      {
          ImageIcon IS=new ImageIcon(getClass().getResource("Help_clicked.png"));
          help.setIcon(IS);
      }
    }//GEN-LAST:event_helpMouseReleased

    private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
      
    }//GEN-LAST:event_aboutMouseClicked

    private void aboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseEntered
      if(Flag==6)
      {
          ImageIcon IA=new ImageIcon(getClass().getResource("About_clicked.png"));
          about.setIcon(IA);
      }
      else
      {
          ImageIcon IA=new ImageIcon(getClass().getResource("About_hover.png"));
          about.setIcon(IA);
      }
        
    }//GEN-LAST:event_aboutMouseEntered

    private void aboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseExited
      if(Flag==6)
      {
          ImageIcon IA=new ImageIcon(getClass().getResource("About_clicked.png"));
          about.setIcon(IA);
      }
      else
      {
           ImageIcon IA=new ImageIcon(getClass().getResource("About_default.png"));
           about.setIcon(IA); 
      }
    }//GEN-LAST:event_aboutMouseExited

    private void aboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMousePressed
      ImageIcon IA=new ImageIcon(getClass().getResource("About_clicked.png"));
      about.setIcon(IA);
      Flag=6;
      Search.setVisible(false);
      Search.setEnabled(false);
      Record.setVisible(false);
      Record.setEnabled(false);
      View.setVisible(false);
      View.setEnabled(false);
      Profile.setVisible(false);
      Profile.setEnabled(false);
      Help.setVisible(false);
      Help.setEnabled(false);
      About.setVisible(true);
      About.setEnabled(true);
    }//GEN-LAST:event_aboutMousePressed

    private void aboutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseReleased
       if(Flag==6)
      {
          
          ImageIcon IS=new ImageIcon(getClass().getResource("Search_default.png"));
          search.setIcon(IS);  
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Default.png"));
          view.setIcon(IV);  
          ImageIcon IR=new ImageIcon(getClass().getResource("Record_default1.png"));
          record.setIcon(IR);
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_default.png"));
          profile.setIcon(IP);
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_default.png"));
          help.setIcon(IH);
          ImageIcon IA=new ImageIcon(getClass().getResource("About_clicked.png"));
          about.setIcon(IA);  
      }
      else
      {
          ImageIcon IA=new ImageIcon(getClass().getResource("About_clicked.png"));
          about.setIcon(IA);
      }
    }//GEN-LAST:event_aboutMouseReleased

    private void signoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseClicked
     
    }//GEN-LAST:event_signoutMouseClicked

    private void signoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseEntered
      ImageIcon IS=new ImageIcon(getClass().getResource("Sign_hover.png"));
      signout.setIcon(IS);
    }//GEN-LAST:event_signoutMouseEntered

    private void signoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseExited
         ImageIcon IS=new ImageIcon(getClass().getResource("Sign_default.png"));
         signout.setIcon(IS); 
    }//GEN-LAST:event_signoutMouseExited

    private void signoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMousePressed
      ImageIcon IS=new ImageIcon(getClass().getResource("Sign_pressed.png"));
      signout.setIcon(IS);
      Login logout = new Login();
      this.dispose();
      logout.setVisible(true);
      
    }//GEN-LAST:event_signoutMousePressed

    private void signoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseReleased
      ImageIcon IS=new ImageIcon(getClass().getResource("Sign_hover.png"));
      signout.setIcon(IS);
    }//GEN-LAST:event_signoutMouseReleased

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
     
    }//GEN-LAST:event_searchMouseClicked

    private void DeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseEntered
      ImageIcon II=new ImageIcon(getClass().getResource("Hover_deleteicon.png"));
      Delete.setIcon(II);
    }//GEN-LAST:event_DeleteMouseEntered

    private void DeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMousePressed
     this.slideshow3();
     ImageIcon II=new ImageIcon(getClass().getResource("Pressed_deleteicon.png"));
     Delete.setIcon(II);
      R_delete_history_button1.setVisible(true);
     R_delete_history_button2.setVisible(true);
     R_delete_history_button3.setVisible(true);
     R_delete_history_button4.setVisible(true);
     R_delete_history_button5.setVisible(true);
     R_delete_history_button6.setVisible(true);
     R_delete_history_button7.setVisible(true);
     R_delete_history_button1.setEnabled(true);
     R_delete_history_button2.setEnabled(true);
     R_delete_history_button3.setEnabled(true);
     R_delete_history_button4.setEnabled(true);
     R_delete_history_button5.setEnabled(true);
     R_delete_history_button6.setEnabled(true);
     R_delete_history_button7.setEnabled(true); 
     R_edit_history_button1.setVisible(false);
     R_edit_history_button2.setVisible(false);
     R_edit_history_button3.setVisible(false);
     R_edit_history_button4.setVisible(false);
     R_edit_history_button5.setVisible(false);
     R_edit_history_button6.setVisible(false);
     R_edit_history_button7.setVisible(false);
     R_edit_history_button1.setEnabled(false);
     R_edit_history_button2.setEnabled(false);
     R_edit_history_button3.setEnabled(false);
     R_edit_history_button4.setEnabled(false);
     R_edit_history_button5.setEnabled(false);
     R_edit_history_button6.setEnabled(false);
     R_edit_history_button7.setEnabled(false);
     R_add_history_button1.setVisible(false);
     R_add_history_button2.setVisible(false);
     R_add_history_button3.setVisible(false);
     R_add_history_button4.setVisible(false);
     R_add_history_button5.setVisible(false);
     R_add_history_button6.setVisible(false);
     R_add_history_button7.setVisible(false);
     R_add_history_button1.setEnabled(false);
     R_add_history_button2.setEnabled(false);
     R_add_history_button3.setEnabled(false);
     R_add_history_button4.setEnabled(false);
     R_add_history_button5.setEnabled(false);
     R_add_history_button6.setEnabled(false);
     R_add_history_button7.setEnabled(false);
     R_history_button1.setVisible(false);
     R_history_button2.setVisible(false);
     R_history_button3.setVisible(false);
     R_history_button4.setVisible(false);
     R_history_button5.setVisible(false);
     R_history_button6.setVisible(false);
     R_history_button7.setVisible(false);
     R_history_button1.setEnabled(false);
     R_history_button2.setEnabled(false);
     R_history_button3.setEnabled(false);
     R_history_button4.setEnabled(false);
     R_history_button5.setEnabled(false);
     R_history_button6.setEnabled(false);
     R_history_button7.setEnabled(false);
     Edit_Rightsidebarpanel.setVisible(false);
     Edit_Rightsidebarpanel.setEnabled(false);
     New_Rightsidebarpanel.setVisible(false);
     New_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(true);
     Delete_Rightsidebarpanel.setEnabled(true);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_DeleteMousePressed

    private void DeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseReleased
      ImageIcon II=new ImageIcon(getClass().getResource("Deleteicon3.png"));
      Delete.setIcon(II);
     // this.slideshow2();
    }//GEN-LAST:event_DeleteMouseReleased

    private void NewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMouseEntered
     ImageIcon II=new ImageIcon(getClass().getResource("Newicon_hover.png"));
     New.setIcon(II);
    }//GEN-LAST:event_NewMouseEntered

    private void NewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMouseExited
     ImageIcon II=new ImageIcon(getClass().getResource("Newicon.png"));
     New.setIcon(II);
    }//GEN-LAST:event_NewMouseExited

    private void NewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMousePressed
     this.slideshow1();
     ImageIcon II=new ImageIcon(getClass().getResource("Newicon_pressed.png"));
     New.setIcon(II);
     R_add_history_button1.setVisible(true);
     R_add_history_button2.setVisible(true);
     R_add_history_button3.setVisible(true);
     R_add_history_button4.setVisible(true);
     R_add_history_button5.setVisible(true);
     R_add_history_button6.setVisible(true);
     R_add_history_button7.setVisible(true);
     R_add_history_button1.setEnabled(true);
     R_add_history_button2.setEnabled(true);
     R_add_history_button3.setEnabled(true);
     R_add_history_button4.setEnabled(true);
     R_add_history_button5.setEnabled(true);
     R_add_history_button6.setEnabled(true);
     R_add_history_button7.setEnabled(true);
     R_history_button1.setVisible(false);
     R_history_button2.setVisible(false);
     R_history_button3.setVisible(false);
     R_history_button4.setVisible(false);
     R_history_button5.setVisible(false);
     R_history_button6.setVisible(false);
     R_history_button7.setVisible(false);
     R_history_button1.setEnabled(false);
     R_history_button2.setEnabled(false);
     R_history_button3.setEnabled(false);
     R_history_button4.setEnabled(false);
     R_history_button5.setEnabled(false);
     R_history_button6.setEnabled(false);
     R_history_button7.setEnabled(false);
     R_edit_history_button1.setVisible(false);
     R_edit_history_button2.setVisible(false);
     R_edit_history_button3.setVisible(false);
     R_edit_history_button4.setVisible(false);
     R_edit_history_button5.setVisible(false);
     R_edit_history_button6.setVisible(false);
     R_edit_history_button7.setVisible(false);
     R_edit_history_button1.setEnabled(false);
     R_edit_history_button2.setEnabled(false);
     R_edit_history_button3.setEnabled(false);
     R_edit_history_button4.setEnabled(false);
     R_edit_history_button5.setEnabled(false);
     R_edit_history_button6.setEnabled(false);
     R_edit_history_button7.setEnabled(false);
     R_delete_history_button1.setVisible(false);
     R_delete_history_button2.setVisible(false);
     R_delete_history_button3.setVisible(false);
     R_delete_history_button4.setVisible(false);
     R_delete_history_button5.setVisible(false);
     R_delete_history_button6.setVisible(false);
     R_delete_history_button7.setVisible(false);
     R_delete_history_button1.setEnabled(false);
     R_delete_history_button2.setEnabled(false);
     R_delete_history_button3.setEnabled(false);
     R_delete_history_button4.setEnabled(false);
     R_delete_history_button5.setEnabled(false);
     R_delete_history_button6.setEnabled(false);
     R_delete_history_button7.setEnabled(false); 
     New_Rightsidebarpanel.setVisible(true);
     New_Rightsidebarpanel.setEnabled(true);
     Edit_Rightsidebarpanel.setVisible(false);
     Edit_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(false);
     Delete_Rightsidebarpanel.setEnabled(false);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_NewMousePressed

    private void NewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMouseReleased
     ImageIcon II=new ImageIcon(getClass().getResource("Newicon_hover.png"));
     New.setIcon(II);
     //this.slideshow2();
    }//GEN-LAST:event_NewMouseReleased

    private void EditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseEntered
       ImageIcon II=new ImageIcon(getClass().getResource("Editicon_hover.png"));
       Edit.setIcon(II);
    }//GEN-LAST:event_EditMouseEntered

    private void EditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseExited
       ImageIcon II=new ImageIcon(getClass().getResource("Editicon.png"));
       Edit.setIcon(II);
    }//GEN-LAST:event_EditMouseExited

    private void EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMousePressed
     this.slideshow2();
     ImageIcon II=new ImageIcon(getClass().getResource("Editicon_pressed.png"));
     Edit.setIcon(II);
     R_edit_history_button1.setVisible(true);
     R_edit_history_button2.setVisible(true);
     R_edit_history_button3.setVisible(true);
     R_edit_history_button4.setVisible(true);
     R_edit_history_button5.setVisible(true);
     R_edit_history_button6.setVisible(true);
     R_edit_history_button7.setVisible(true);
     R_edit_history_button1.setEnabled(true);
     R_edit_history_button2.setEnabled(true);
     R_edit_history_button3.setEnabled(true);
     R_edit_history_button4.setEnabled(true);
     R_edit_history_button5.setEnabled(true);
     R_edit_history_button6.setEnabled(true);
     R_edit_history_button7.setEnabled(true);
     R_add_history_button1.setVisible(false);
     R_add_history_button2.setVisible(false);
     R_add_history_button3.setVisible(false);
     R_add_history_button4.setVisible(false);
     R_add_history_button5.setVisible(false);
     R_add_history_button6.setVisible(false);
     R_add_history_button7.setVisible(false);
     R_add_history_button1.setEnabled(false);
     R_add_history_button2.setEnabled(false);
     R_add_history_button3.setEnabled(false);
     R_add_history_button4.setEnabled(false);
     R_add_history_button5.setEnabled(false);
     R_add_history_button6.setEnabled(false);
     R_add_history_button7.setEnabled(false);
     R_history_button1.setVisible(false);
     R_history_button2.setVisible(false);
     R_history_button3.setVisible(false);
     R_history_button4.setVisible(false);
     R_history_button5.setVisible(false);
     R_history_button6.setVisible(false);
     R_history_button7.setVisible(false);
     R_history_button1.setEnabled(false);
     R_history_button2.setEnabled(false);
     R_history_button3.setEnabled(false);
     R_history_button4.setEnabled(false);
     R_history_button5.setEnabled(false);
     R_history_button6.setEnabled(false);
     R_history_button7.setEnabled(false);
     R_delete_history_button1.setVisible(false);
     R_delete_history_button2.setVisible(false);
     R_delete_history_button3.setVisible(false);
     R_delete_history_button4.setVisible(false);
     R_delete_history_button5.setVisible(false);
     R_delete_history_button6.setVisible(false);
     R_delete_history_button7.setVisible(false);
     R_delete_history_button1.setEnabled(false);
     R_delete_history_button2.setEnabled(false);
     R_delete_history_button3.setEnabled(false);
     R_delete_history_button4.setEnabled(false);
     R_delete_history_button5.setEnabled(false);
     R_delete_history_button6.setEnabled(false);
     R_delete_history_button7.setEnabled(false); 
     Edit_Rightsidebarpanel.setVisible(true);
     Edit_Rightsidebarpanel.setEnabled(true);
     New_Rightsidebarpanel.setVisible(false);
     New_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(false);
     Delete_Rightsidebarpanel.setEnabled(false);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_EditMousePressed

    private void EditMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseReleased
       ImageIcon II=new ImageIcon(getClass().getResource("Editicon_hover.png"));
       Edit.setIcon(II);
       //this.slideshow2();
    }//GEN-LAST:event_EditMouseReleased

    private void recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseClicked
    
    }//GEN-LAST:event_recordMouseClicked

    private void recordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMousePressed
       this.slideshow4();
       ImageIcon IS=new ImageIcon(getClass().getResource("Record_pressed.png"));
       record.setIcon(IS);
       Flag=1;
       Search.setVisible(false);
       Search.setEnabled(false);
       New.setVisible(true);
       New.setEnabled(true);
       Edit.setVisible(true);
       Edit.setEnabled(true);
       Delete.setVisible(true);
       Delete.setEnabled(true);
       Record.setVisible(true);
       Record.setEnabled(true);
       R_history_button1.setVisible(true);
       R_history_button2.setVisible(true);
       R_history_button3.setVisible(true);
       R_history_button4.setVisible(true);
       R_history_button5.setVisible(true);
       R_history_button6.setVisible(true);
       R_history_button7.setVisible(true);
       R_history_button1.setEnabled(true);
       R_history_button2.setEnabled(true);
       R_history_button3.setEnabled(true);
       R_history_button4.setEnabled(true);
       R_history_button5.setEnabled(true);
       R_history_button6.setEnabled(true);
       R_history_button7.setEnabled(true);
       S_history_button1.setVisible(false);
       S_history_button2.setVisible(false);
       S_history_button3.setVisible(false);
       S_history_button4.setVisible(false);
       S_history_button5.setVisible(false);
       S_history_button6.setVisible(false);
       S_history_button7.setVisible(false);
       S_history_button1.setEnabled(false);
       S_history_button2.setEnabled(false);
       S_history_button3.setEnabled(false);
       S_history_button4.setEnabled(false);
       S_history_button5.setEnabled(false);
       S_history_button6.setEnabled(false);
       S_history_button7.setEnabled(false);
       Record_Leftsidebarpanel.setVisible(true);
       Record_Leftsidebarpanel.setEnabled(true);
       Search_Leftsidebarpanel.setVisible(false);
       Search_Leftsidebarpanel.setEnabled(false);
       View_Leftsidebarpanel.setVisible(false);
       View_Leftsidebarpanel.setEnabled(false);
       Help_Leftsidebarpanel.setVisible(false);
       Help_Leftsidebarpanel.setEnabled(false);
       Profile_Leftsidebarpanel.setVisible(false);
       Profile_Leftsidebarpanel.setEnabled(false);
       Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_recordMousePressed

    private void recordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseReleased
        if(Flag==1)
      {
          
          ImageIcon IS=new ImageIcon(getClass().getResource("Search_default.png"));
          search.setIcon(IS);  
          ImageIcon IV=new ImageIcon(getClass().getResource("Complain_Default.png"));
          view.setIcon(IV);  
          ImageIcon IR=new ImageIcon(getClass().getResource("Record_pressed.png"));
          record.setIcon(IR);
          ImageIcon IP=new ImageIcon(getClass().getResource("Profile_default.png"));
          profile.setIcon(IP);
          ImageIcon IH=new ImageIcon(getClass().getResource("Help_default.png"));
          help.setIcon(IH);
          ImageIcon IA=new ImageIcon(getClass().getResource("About_default.png"));
          about.setIcon(IA);  
      }
      else
      {
          ImageIcon IR=new ImageIcon(getClass().getResource("Record_pressed.png"));
          record.setIcon(IR);
      }
    }//GEN-LAST:event_recordMouseReleased

    private void recordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseExited
      if(Flag==1)
      {
       ImageIcon IR=new ImageIcon(getClass().getResource("Record_pressed.png"));
       record.setIcon(IR);
      }
      else 
      {
        ImageIcon IR=new ImageIcon(getClass().getResource("Record_default1.png"));
        record.setIcon(IR);
      } 
    }//GEN-LAST:event_recordMouseExited

    private void searchbyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbyMouseEntered
        ImageIcon IR=new ImageIcon(getClass().getResource("Searchicon_hover.png"));
        searchby.setIcon(IR);
    }//GEN-LAST:event_searchbyMouseEntered

    private void searchbyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbyMousePressed
        //this.slideshow5();
        ImageIcon IR=new ImageIcon(getClass().getResource("Searchicon_pressed.png"));
        searchby.setIcon(IR);
        Edit_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setEnabled(false);
        New_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setEnabled(false);
        Search_Rightsidebarpanel.setVisible(true);
        Search_Rightsidebarpanel.setEnabled(true);
        Complain_Ridesidebarpanel.setVisible(false);
        Complain_Ridesidebarpanel.setEnabled(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
//       ReportTable rt = new ReportTable();
//        rt.setVisible(true);
//        rt.setEnabled(true);
    }//GEN-LAST:event_searchbyMousePressed

    private void searchbyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbyMouseReleased
        //this.slideshow2();
        ImageIcon IR=new ImageIcon(getClass().getResource("Searchicon_hover.png"));
        searchby.setIcon(IR);
    }//GEN-LAST:event_searchbyMouseReleased

    private void searchbyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbyMouseExited
        ImageIcon IR=new ImageIcon(getClass().getResource("searchicon.png"));
        searchby.setIcon(IR);
    }//GEN-LAST:event_searchbyMouseExited

    private void NewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMouseClicked
        New_Rightsidebarpanel.setVisible(true);
        Edit_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setVisible(false);
        Search_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(true);
        Edit_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setEnabled(false);
        Search_Rightsidebarpanel.setEnabled(false);
        MultipleEntry.setEnabled(false);
        MultipleEntry.setVisible(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false); 
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_NewMouseClicked

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
        New_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setVisible(true);
        Delete_Rightsidebarpanel.setVisible(false);
        Search_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(false);
        Edit_Rightsidebarpanel.setEnabled(true);
        Delete_Rightsidebarpanel.setEnabled(false);
        Search_Rightsidebarpanel.setEnabled(false);
        MultipleEntry.setEnabled(false);
        MultipleEntry.setVisible(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_EditMouseClicked

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        New_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setVisible(true);
        Search_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(false);
        Edit_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setEnabled(true);
        Search_Rightsidebarpanel.setEnabled(false);
        MultipleEntry.setEnabled(false);
        MultipleEntry.setVisible(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_DeleteMouseClicked

    private void searchbyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbyMouseClicked
        New_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setVisible(false);
        Search_Rightsidebarpanel.setVisible(true);
        Search_Rightsidebarpanel.setEnabled(true);
        New_Rightsidebarpanel.setEnabled(false);
        Edit_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setEnabled(false);
        MultipleEntry.setEnabled(false);
        MultipleEntry.setVisible(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_searchbyMouseClicked

    private void popup1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popup1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_popup1MousePressed

    private void R_history_button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button1MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_history_button1MouseEntered

    private void R_history_button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button1MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_history_button1MouseExited

    private void R_history_button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button1MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_history_button1MousePressed

    private void R_history_button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button1MouseReleased
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_history_button1MouseReleased

    private void R_history_button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button2MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_history_button2MouseEntered

    private void R_history_button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button2MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_history_button2MouseExited

    private void R_history_button2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button2MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_history_button2MousePressed

    private void R_history_button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button2MouseReleased
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_history_button2MouseReleased

    private void R_history_button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button3MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_history_button3MouseEntered

    private void R_history_button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button3MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_history_button3MouseExited

    private void R_history_button3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button3MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_history_button3MousePressed

    private void R_history_button3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button3MouseReleased
        ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_history_button3MouseReleased

    private void R_history_button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button4MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_history_button4MouseEntered

    private void R_history_button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button4MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_history_button4MouseExited

    private void R_history_button4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button4MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_history_button4MousePressed

    private void R_history_button4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button4MouseReleased
        ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_history_button4MouseReleased

    private void R_history_button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button5MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_history_button5MouseEntered

    private void R_history_button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button5MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_history_button5MouseExited

    private void R_history_button5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button5MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_history_button5MousePressed

    private void R_history_button5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button5MouseReleased
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_history_button5MouseReleased

    private void R_history_button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button6MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_history_button6MouseEntered

    private void R_history_button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button6MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_history_button6MouseExited

    private void R_history_button6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button6MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_history_button6MousePressed

    private void R_history_button6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button6MouseReleased
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_history_button6MouseReleased

    private void R_history_button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button7MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
       R_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_history_button7MouseEntered

    private void R_history_button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button7MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_history_button7MouseExited

    private void R_history_button7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button7MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_history_button7MousePressed

    private void R_history_button7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_history_button7MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_history_button7MouseReleased

    private void R_add_history_button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button1MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button1MouseEntered

    private void R_add_history_button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button1MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_add_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button1MouseExited

    private void R_add_history_button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button1MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button1MousePressed

    private void R_add_history_button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button1MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button1MouseReleased

    private void R_add_history_button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button2MouseEntered
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button2MouseEntered

    private void R_add_history_button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button2MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
       R_add_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button2MouseExited

    private void R_add_history_button2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button2MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button2MousePressed

    private void R_add_history_button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button2MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button2MouseReleased

    private void R_add_history_button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button3MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button3MouseEntered

    private void R_add_history_button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button3MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_add_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button3MouseExited

    private void R_add_history_button3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button3MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button3MousePressed

    private void R_add_history_button3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button3MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button3MouseReleased

    private void R_add_history_button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button4MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button4MouseEntered

    private void R_add_history_button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button4MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_add_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button4MouseExited

    private void R_add_history_button4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button4MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button4MousePressed

    private void R_add_history_button4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button4MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button4MouseReleased

    private void R_add_history_button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button5MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button5MouseEntered

    private void R_add_history_button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button5MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_add_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button5MouseExited

    private void R_add_history_button5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button5MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button5MousePressed

    private void R_add_history_button5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button5MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button5MouseReleased

    private void R_add_history_button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button6MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button6MouseEntered

    private void R_add_history_button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button6MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_add_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button6MouseExited

    private void R_add_history_button6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button6MousePressed
        ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button6MousePressed

    private void R_add_history_button6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button6MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button6MouseReleased

    private void R_add_history_button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button7MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button7MouseEntered

    private void R_add_history_button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button7MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_add_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button7MouseExited

    private void R_add_history_button7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button7MousePressed
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
       R_add_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button7MousePressed

    private void R_add_history_button7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_add_history_button7MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_add_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_add_history_button7MouseReleased

    private void R_edit_history_button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button1MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button1MouseEntered

    private void R_edit_history_button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button1MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button1MouseExited

    private void R_edit_history_button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button1MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button1MousePressed

    private void R_edit_history_button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button1MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button1MouseReleased

    private void R_edit_history_button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button2MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button2MouseEntered

    private void R_edit_history_button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button2MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button2MouseExited

    private void R_edit_history_button2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button2MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button2MousePressed

    private void R_edit_history_button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button2MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button2MouseReleased

    private void R_edit_history_button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button3MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button3MouseEntered

    private void R_edit_history_button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button3MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button3MouseExited

    private void R_edit_history_button3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button3MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button3MousePressed

    private void R_edit_history_button3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button3MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button3MouseReleased

    private void R_edit_history_button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button4MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button4MouseEntered

    private void R_edit_history_button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button4MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button4MouseExited

    private void R_edit_history_button4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button4MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button4MousePressed

    private void R_edit_history_button4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button4MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button4MouseReleased

    private void R_edit_history_button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button5MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button5MouseEntered

    private void R_edit_history_button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button5MouseExited
     ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button5MouseExited

    private void R_edit_history_button5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button5MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button5MousePressed

    private void R_edit_history_button5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button5MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button5MouseReleased

    private void R_edit_history_button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button6MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button6MouseEntered

    private void R_edit_history_button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button6MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button6MouseExited

    private void R_edit_history_button6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button6MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button6MousePressed

    private void R_edit_history_button6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button6MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button6MouseReleased

    private void R_edit_history_button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button7MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button7MouseEntered

    private void R_edit_history_button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button7MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_edit_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button7MouseExited

    private void R_edit_history_button7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button7MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_edit_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button7MousePressed

    private void R_edit_history_button7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_edit_history_button7MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_edit_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_edit_history_button7MouseReleased

    private void R_delete_history_button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button1MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button1MouseEntered

    private void R_delete_history_button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button1MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button1MouseExited

    private void R_delete_history_button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button1MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button1MousePressed

    private void R_delete_history_button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button1MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button1.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button1MouseReleased

    private void R_delete_history_button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button2MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button2MouseEntered

    private void R_delete_history_button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button2MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button2MouseExited

    private void R_delete_history_button2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button2MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button2MousePressed

    private void R_delete_history_button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button2MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button2.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button2MouseReleased

    private void R_delete_history_button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button3MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button3MouseEntered

    private void R_delete_history_button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button3MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button3MouseExited

    private void R_delete_history_button3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button3MousePressed
     ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button3MousePressed

    private void R_delete_history_button3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button3MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button3.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button3MouseReleased

    private void R_delete_history_button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button4MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button4MouseEntered

    private void R_delete_history_button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button4MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button4MouseExited

    private void R_delete_history_button4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button4MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button4MousePressed

    private void R_delete_history_button4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button4MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button4.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button4MouseReleased

    private void R_delete_history_button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button5MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button5MouseEntered

    private void R_delete_history_button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button5MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button5MouseExited

    private void R_delete_history_button5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button5MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button5MousePressed

    private void R_delete_history_button5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button5MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button5.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button5MouseReleased

    private void R_delete_history_button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button6MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button6MouseEntered

    private void R_delete_history_button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button6MouseExited
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button6MouseExited

    private void R_delete_history_button6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button6MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button6MousePressed

    private void R_delete_history_button6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button6MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button6.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button6MouseReleased

    private void R_delete_history_button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button7MouseEntered
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button7MouseEntered

    private void R_delete_history_button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button7MouseExited
       ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      R_delete_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button7MouseExited

    private void R_delete_history_button7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button7MousePressed
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      R_delete_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button7MousePressed

    private void R_delete_history_button7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_delete_history_button7MouseReleased
      ImageIcon IRB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      R_delete_history_button7.setIcon(IRB);
    }//GEN-LAST:event_R_delete_history_button7MouseReleased

    private void S_history_button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button1MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button1.setIcon(ISB);
    }//GEN-LAST:event_S_history_button1MouseEntered

    private void S_history_button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button1MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button1.setIcon(ISB);
    }//GEN-LAST:event_S_history_button1MouseExited

    private void S_history_button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button1MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button1.setIcon(ISB);
    }//GEN-LAST:event_S_history_button1MousePressed

    private void S_history_button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button1MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button1.setIcon(ISB);
    }//GEN-LAST:event_S_history_button1MouseReleased

    private void S_history_button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button2MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button2.setIcon(ISB);
    }//GEN-LAST:event_S_history_button2MouseEntered

    private void S_history_button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button2MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button2.setIcon(ISB);
    }//GEN-LAST:event_S_history_button2MouseExited

    private void S_history_button2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button2MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button2.setIcon(ISB);
    }//GEN-LAST:event_S_history_button2MousePressed

    private void S_history_button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button2MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button2.setIcon(ISB);
    }//GEN-LAST:event_S_history_button2MouseReleased

    private void S_history_button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button3MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button3.setIcon(ISB);
    }//GEN-LAST:event_S_history_button3MouseEntered

    private void S_history_button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button3MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button3.setIcon(ISB);
    }//GEN-LAST:event_S_history_button3MouseExited

    private void S_history_button3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button3MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button3.setIcon(ISB);
    }//GEN-LAST:event_S_history_button3MousePressed

    private void S_history_button3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button3MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button3.setIcon(ISB);
    }//GEN-LAST:event_S_history_button3MouseReleased

    private void S_history_button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button4MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button4.setIcon(ISB);
    }//GEN-LAST:event_S_history_button4MouseEntered

    private void S_history_button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button4MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button4.setIcon(ISB);
    }//GEN-LAST:event_S_history_button4MouseExited

    private void S_history_button4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button4MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button4.setIcon(ISB);
    }//GEN-LAST:event_S_history_button4MousePressed

    private void S_history_button4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button4MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button4.setIcon(ISB);
    }//GEN-LAST:event_S_history_button4MouseReleased

    private void S_history_button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button5MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button5.setIcon(ISB);
    }//GEN-LAST:event_S_history_button5MouseEntered

    private void S_history_button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button5MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button5.setIcon(ISB);
    }//GEN-LAST:event_S_history_button5MouseExited

    private void S_history_button5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button5MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button5.setIcon(ISB);
    }//GEN-LAST:event_S_history_button5MousePressed

    private void S_history_button5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button5MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button5.setIcon(ISB);
    }//GEN-LAST:event_S_history_button5MouseReleased

    private void S_history_button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button6MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button6.setIcon(ISB);
    }//GEN-LAST:event_S_history_button6MouseEntered

    private void S_history_button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button6MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button6.setIcon(ISB);
    }//GEN-LAST:event_S_history_button6MouseExited

    private void S_history_button6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button6MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button6.setIcon(ISB);
    }//GEN-LAST:event_S_history_button6MousePressed

    private void S_history_button6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button6MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button6.setIcon(ISB);
    }//GEN-LAST:event_S_history_button6MouseReleased

    private void S_history_button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button7MouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button7.setIcon(ISB);
    }//GEN-LAST:event_S_history_button7MouseEntered

    private void S_history_button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button7MouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_default_button.png"));
      S_history_button7.setIcon(ISB);
    }//GEN-LAST:event_S_history_button7MouseExited

    private void S_history_button7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button7MousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_pressed_button.png"));
      S_history_button7.setIcon(ISB);
    }//GEN-LAST:event_S_history_button7MousePressed

    private void S_history_button7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_history_button7MouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("Left_sidepanel_button.png"));
      S_history_button7.setIcon(ISB);
    }//GEN-LAST:event_S_history_button7MouseReleased

    private void SpecficationNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecficationNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecficationNoTextFieldActionPerformed

    private void PoNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoNoTextFieldActionPerformed

    private void DeptTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeptTextFieldActionPerformed

    private void NextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseEntered
      ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
      NextButton.setIcon(ISB);
    }//GEN-LAST:event_NextButtonMouseEntered

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMousePressed
       ImageIcon ISB=new ImageIcon(getClass().getResource("NewButton_pressed3.png"));
       NextButton.setIcon(ISB);
       ValidateInput valip = new ValidateInput();
       String d = DateTextField.getText();
       String m = MonthTextField.getText();
       String y = YearTextField.getText();
        try{
           st.executeUpdate("INSERT INTO historyinsert VALUES('"+SpecficationNoTextField.getText()+"',"+null+","+null+")");
            PopUp pop = new PopUp();
           pop.setMessagelabel("Success");
           pop.setVisible(true);
       }
       catch(Exception e1){
           PopUp pop = new PopUp();
           pop.setMessagelabel("Error");
           pop.setVisible(true);
       }
       boolean b = valip.datecheck(d, m, y);
       if(b==true){
            try
             {
              
              date_of_warehouse=0;month_of_warehouse=0;year_of_warehouse=0;DWare=0;
              date_of_warranty=0;month_of_warranty=0;year_of_warranty=0;DTW=0;
              
              st.executeUpdate("INSERT INTO Transf_Details VALUES('"+SpecficationNoTextField.getText() +"'," + Integer.parseInt(DateTextField.getText())+"," + Integer.parseInt(MonthTextField.getText())+ ","+ Integer.parseInt(YearTextField.getText())+ ",'" + PoNoTextField.getText()+ "','" + BuyerTextField.getText()+ "','" + ItemTextField.getText()+ "','"+ DeptTextField.getText()+"'," + Double.parseDouble(PriceTextField.getText())+","+ Integer.parseInt(WarrantyMonth.getText())+","+ Integer.parseInt(WarehouseMonth.getText())+","+null+","+null+","+null+")");
              int Date_of_purchase=Integer.parseInt(DateTextField.getText());
              int Month_of_purchase=Integer.parseInt(MonthTextField.getText());
              int Year_of_purchase=Integer.parseInt(YearTextField.getText());
              int warranty=Integer.parseInt(WarrantyMonth.getText());
              this.caldate(Date_of_purchase,Month_of_purchase,Year_of_purchase);
              this.Cal_day(Date_of_purchase,Month_of_purchase,Year_of_purchase,date_of_warehouse,month_of_warehouse,year_of_warehouse);
              caldate1(date_of_warehouse,month_of_warehouse,year_of_warehouse,warranty);
              this.Cal_day1(date_of_warehouse,month_of_warehouse,year_of_warehouse,date_of_warranty,month_of_warranty,year_of_warranty);
              st.executeUpdate("INSERT INTO Type_of_warranty VALUES('"+SpecficationNoTextField.getText() +"'," + Integer.parseInt(WarrantyMonth.getText())+"," + Integer.parseInt(WarehouseMonth.getText())+ ","+ DTW+ ","+ DWare+ ")");
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
              this.Cal_left(Warehouse_Days,Date_of_purchase,Month_of_purchase,Year_of_purchase);
              this.Cal_left(Warranty_Days,date_of_expiry,month_of_expiry,year_of_expiry);
              int sno=1;
              String query1="INSERT INTO "+SpecficationNoTextField.getText()+" VALUES("
                                          +sno+","
                                          + Integer.parseInt(DateTextField.getText())+","
                                          + Integer.parseInt(MonthTextField.getText())+ ","
                                          + Integer.parseInt(YearTextField.getText())+","
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
              }
             }catch(Exception e)
             {
                 System.out.println(e);
             }   
      SpecficationNoTextField.setText("");
      DateTextField.setText("");
      MonthTextField.setText("");
      YearTextField.setText("");
      PoNoTextField.setText("");
      ItemTextField.setText("");
      BuyerTextField.setText("");
      DeptTextField.setText("");
      PriceTextField.setText("");
      WarrantyMonth.setText("");
      WarehouseMonth.setText("");
      }
      else{
          PopUp pop = new PopUp();
          pop.setMessagelabel("Invalid Date");
          pop.setVisible(true);       
      DateTextField.setText("");
      MonthTextField.setText("");
      YearTextField.setText("");
      }
      
    }//GEN-LAST:event_NextButtonMousePressed

    private void NextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_default1.png"));
      NextButton.setIcon(ISB);
    }//GEN-LAST:event_NextButtonMouseExited

    private void NextButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
      NextButton.setIcon(ISB);
    }//GEN-LAST:event_NextButtonMouseReleased

    private void CancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
      CancelButton.setIcon(ISB);
    }//GEN-LAST:event_CancelButtonMouseEntered

    private void CancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMousePressed
      ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_pressed.png"));
      CancelButton.setIcon(ISB);
      SpecficationNoTextField.setText("");
      DateTextField.setText("");
      MonthTextField.setText("");
      YearTextField.setText("");
      PoNoTextField.setText("");
      ItemTextField.setText("");
      BuyerTextField.setText("");
      DeptTextField.setText("");
      PriceTextField.setText("");
      WarrantyMonth.setText("");
      WarehouseMonth.setText("");
    }//GEN-LAST:event_CancelButtonMousePressed

    private void CancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseExited
      ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_default_3.png"));
      CancelButton.setIcon(ISB);
    }//GEN-LAST:event_CancelButtonMouseExited

    private void CancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
      CancelButton.setIcon(ISB);
    }//GEN-LAST:event_CancelButtonMouseReleased

    private void PriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTextFieldActionPerformed

    private void InstallationDateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InstallationDateMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("InstallationButton_hover.png"));
       InstallationDate.setIcon(ISB);
    }//GEN-LAST:event_InstallationDateMouseEntered

    private void InstallationDateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InstallationDateMouseExited
         ImageIcon ISB=new ImageIcon(getClass().getResource("InstallationButton_default.png"));
       InstallationDate.setIcon(ISB);
    }//GEN-LAST:event_InstallationDateMouseExited

    private void InstallationDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InstallationDateMousePressed
         ImageIcon ISB=new ImageIcon(getClass().getResource("InstallationButton_pressed.png"));
       InstallationDate.setIcon(ISB);
    }//GEN-LAST:event_InstallationDateMousePressed

    private void InstallationDateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InstallationDateMouseReleased
         ImageIcon ISB=new ImageIcon(getClass().getResource("InstallationButton_hover.png"));
       InstallationDate.setIcon(ISB);
    }//GEN-LAST:event_InstallationDateMouseReleased

    private void ComplainButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComplainButtonMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("ComplainButton_hover.png"));
        ComplainButton.setIcon(ISB);
    }//GEN-LAST:event_ComplainButtonMouseEntered

    private void ComplainButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComplainButtonMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("ComplainButton_default.png"));
       ComplainButton.setIcon(ISB);
    }//GEN-LAST:event_ComplainButtonMouseExited

    private void ComplainButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComplainButtonMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("ComplainButton_pressed.png"));
        ComplainButton.setIcon(ISB);
    }//GEN-LAST:event_ComplainButtonMousePressed

    private void ComplainButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComplainButtonMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("ComplainButton_hover.png"));
        ComplainButton.setIcon(ISB);
    }//GEN-LAST:event_ComplainButtonMouseReleased

    private void UnderRepairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnderRepairMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairButton_hover.png"));
        UnderRepair.setIcon(ISB);
    }//GEN-LAST:event_UnderRepairMouseEntered

    private void UnderRepairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnderRepairMouseExited
         ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairButton_default.png"));
         UnderRepair.setIcon(ISB);
    }//GEN-LAST:event_UnderRepairMouseExited

    private void UnderRepairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnderRepairMousePressed
         ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairButton_pressed.png"));
         UnderRepair.setIcon(ISB);
    }//GEN-LAST:event_UnderRepairMousePressed

    private void UnderRepairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnderRepairMouseReleased
         ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairButton_hover.png"));
         UnderRepair.setIcon(ISB);
    }//GEN-LAST:event_UnderRepairMouseReleased

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("ReinstallationButton_hover.png"));
       jLabel1.setIcon(ISB);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("ReinstallationButton_default.png"));
       jLabel1.setIcon(ISB);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
       ImageIcon ISB=new ImageIcon(getClass().getResource("ReinstallationButton_pressed.png"));
       jLabel1.setIcon(ISB);  
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("ReinstallationButton_hover.png"));
       jLabel1.setIcon(ISB);
    }//GEN-LAST:event_jLabel1MouseReleased

    private void Next_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Next_buttonMouseEntered
       ImageIcon IV=new ImageIcon(getClass().getResource("NextButton_hover.png"));
       Next_button.setIcon(IV);
    }//GEN-LAST:event_Next_buttonMouseEntered

    private void Next_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Next_buttonMouseExited
        ImageIcon IV=new ImageIcon(getClass().getResource("NextButton_default1.png"));
        Next_button.setIcon(IV);
    }//GEN-LAST:event_Next_buttonMouseExited

    private void Next_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Next_buttonMousePressed
        ImageIcon IV=new ImageIcon(getClass().getResource("NewButton_pressed3.png"));
        Next_button.setIcon(IV);
       
    }//GEN-LAST:event_Next_buttonMousePressed

    private void Next_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Next_buttonMouseReleased
        ImageIcon IV=new ImageIcon(getClass().getResource("NextButton_hover.png"));
        Next_button.setIcon(IV);
    }//GEN-LAST:event_Next_buttonMouseReleased

    private void Cancel_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel_buttonMouseEntered
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
        Cancel_button.setIcon(IV);
    }//GEN-LAST:event_Cancel_buttonMouseEntered

    private void Cancel_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel_buttonMouseExited
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_default_3.png"));
        Cancel_button.setIcon(IV);
    }//GEN-LAST:event_Cancel_buttonMouseExited

    private void Cancel_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel_buttonMousePressed
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_pressed.png"));
        Cancel_button.setIcon(IV);
    }//GEN-LAST:event_Cancel_buttonMousePressed

    private void Cancel_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel_buttonMouseReleased
        ImageIcon IV=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
        Cancel_button.setIcon(IV);
    }//GEN-LAST:event_Cancel_buttonMouseReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       ReinstallationFrame RI= new ReinstallationFrame(con);
       RI.setVisible(true);
       RI.setEnabled(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void InstallationDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InstallationDateMouseClicked
        InstallationFrame I= new InstallationFrame(con);
        I.setVisible(true);
        I.setEnabled(true);
    }//GEN-LAST:event_InstallationDateMouseClicked

    private void Next_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Next_buttonMouseClicked
        ValidateInput valip2 = new ValidateInput();
        String d = Date_textfield.getText();
        String m = Month_textfield.getText();
        String y = Year_textfield.getText();
        boolean b = valip2.datecheck2(d, m, y);
        if(b==true){
        try
        {
            String query1="SELECT max(Sno) FROM "+Specification_no_textfield.getText();
            rt=st.executeQuery(query1);
            if(rt.next())
            {
                int sno=rt.getInt(1);
                if(sno==1)
                {
                    String query2="SELECT * FROM "+Specification_no_textfield.getText()+" WHERE Sno="+sno;
                    rt=st.executeQuery(query2);
                    if(rt.next())
                    {
                        int expirydate=rt.getInt(14);
                        int expirymonth=rt.getInt(15);
                        int expiryyear=rt.getInt(16);
                        int purchasedate=rt.getInt(2);
                        int purchasemonth=rt.getInt(3);
                        int purchaseyear=rt.getInt(4);
                        int installationdate=rt.getInt(5);
                        int installationmonth=rt.getInt(6);
                        int installationyear=rt.getInt(7);
                       if(Integer.parseInt(Year_textfield.getText())==expiryyear)
                       {
                           if(Integer.parseInt(Month_textfield.getText())==expirymonth)
                           {
                               if(Integer.parseInt(Date_textfield.getText())==expirydate)
                               {
                                   this.execute1(sno,expirydate,expirymonth,expiryyear,purchasedate,purchasemonth,purchaseyear,installationdate,installationmonth,installationyear);
                                }
                               else
                               {
                                   if(Integer.parseInt(Date_textfield.getText())<expirydate)
                                   {
                                       this.execute1(sno,expirydate,expirymonth,expiryyear,purchasedate,purchasemonth,purchaseyear,installationdate,installationmonth,installationyear);
                                   }
                                   else
                                   {
                                      JOptionPane.showMessageDialog(null, "Warranty Expired..!"); 
                                   }
                                }
                            }
                           else
                           {
                               if(Integer.parseInt(Month_textfield.getText())<expirymonth)
                               {
                                   this.execute1(sno,expirydate,expirymonth,expiryyear,purchasedate,purchasemonth,purchaseyear,installationdate,installationmonth,installationyear);  
                                }
                               else
                               {
                                   JOptionPane.showMessageDialog(null, "Warranty Expired..!");
                                }
                            }                        
                        }
                       else
                       {
                           if(Integer.parseInt(Year_textfield.getText())<expiryyear)
                           {
                               this.execute1(sno,expirydate,expirymonth,expiryyear,purchasedate,purchasemonth,purchaseyear,installationdate,installationmonth,installationyear);
                           }
                           else
                           {
                               JOptionPane.showMessageDialog(null, "Warranty Expired..!");
                           }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "TID doesn't exist");
                    }
                }
               else
               {
                    String query10="SELECT * FROM "+Specification_no_textfield.getText()+" WHERE Sno="+sno;
                    rt=st.executeQuery(query10);
                    if(rt.next())
                    {
                        int expirydate=rt.getInt(14);
                        int expirymonth=rt.getInt(15);
                        int expiryyear=rt.getInt(16);
//                        int installdate=rt.getInt(5);
//                        int installmonth=rt.getInt(6);
//                        int installyear=rt.getInt(7);
//                        int complaindate=rt.getInt(8);
//                        int complainmonth=rt.getInt(9);
//                        int complainyear=rt.getInt(10);
                       if(Integer.parseInt(Year_textfield.getText())==expiryyear)
                       {
                           if(Integer.parseInt(Month_textfield.getText())==expirymonth)
                           {
                               if(Integer.parseInt(Date_textfield.getText())==expirydate)
                               {
                                   this.execute2(sno);
                                }
                               else
                               {
                                   if(Integer.parseInt(Date_textfield.getText())<expirydate)
                                   {
                                       this.execute2(sno);
                                   }
                                   else
                                   {
                                      JOptionPane.showMessageDialog(null, "Warranty Expired..!"); 
                                   }
                                }
                            }
                           else
                           {
                               if(Integer.parseInt(Month_textfield.getText())<expirymonth)
                               {
                                   this.execute2(sno);
                                }
                               else
                               {
                                   JOptionPane.showMessageDialog(null, "Warranty Expired..!");
                                }
                            }                        
                        }
                       else
                       {
                           if(Integer.parseInt(Year_textfield.getText())<expiryyear)
                           {
                               this.execute2(sno);
                           }
                           else
                           {
                               JOptionPane.showMessageDialog(null, "Warranty Expired..!");
                           }
                        }
                    }
                }
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "exceute2 "+e);
        }     }
        else{
            PopUp pop = new PopUp();
            pop.setMessagelabel("Invalid Date ");
            pop.setVisible(true);
        }
    }//GEN-LAST:event_Next_buttonMouseClicked

    private void No_ofTransformersTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_ofTransformersTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_No_ofTransformersTextField1ActionPerformed

    private void PoNoTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoNoTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoNoTextField1ActionPerformed

    private void DeptTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeptTextField1ActionPerformed

    private void PriceTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTextField1ActionPerformed

    private void NextButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButton1MouseEntered
         ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
       NextButton1.setIcon(ISB);
    }//GEN-LAST:event_NextButton1MouseEntered

    private void NextButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButton1MouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_default1.png"));
       NextButton1.setIcon(ISB);
    }//GEN-LAST:event_NextButton1MouseExited

    private void NextButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButton1MousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("NewButton_pressed3.png"));
       ValidateInput valip1 = new ValidateInput();
        NextButton1.setIcon(ISB);
       no_of_transformers = No_ofTransformersTextField1.getText();
       po_no = PoNoTextField1.getText();
       item = ItemTextField1.getText();
       buyer = BuyerTextField1.getText();
       department = DeptTextField1.getText();
       price = PriceTextField1.getText();
       date = DateTextField1.getText();
       month = MonthTextField1.getText();
       year = YearTextField1.getText();
       warrantymonth = WarrantyMonth1.getText();
       warehousemonth = WarehouseMonth1.getText();
       
       
       
       boolean b1 = valip1.datecheck(date, month, year);
       int no_of_transformers1 = Integer.parseInt(no_of_transformers);
       if(b1==true){
       //int j = 1;
       for(int i=1;i<=no_of_transformers1;i++){
           SpecificationNoFrame snf = new SpecificationNoFrame( po_no,item,buyer,department,price,date,month,year,warrantymonth,warehousemonth);
           //if(j==i){
           snf.setVisible(true);
           //}
           
           //j++;
       }}
       else{
           PopUp popob = new PopUp();
           popob.setMessagelabel("Invalid Date");
           popob.setVisible(true);
       }
    }//GEN-LAST:event_NextButton1MousePressed

    private void NextButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButton1MouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
       NextButton1.setIcon(ISB);
    }//GEN-LAST:event_NextButton1MouseReleased

    private void CancelButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButton1MouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
       CancelButton1.setIcon(ISB);
    }//GEN-LAST:event_CancelButton1MouseEntered

    private void CancelButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButton1MouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_default_3.png"));
       CancelButton1.setIcon(ISB);
    }//GEN-LAST:event_CancelButton1MouseExited

    private void CancelButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButton1MousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_pressed.png"));
       CancelButton1.setIcon(ISB);
    }//GEN-LAST:event_CancelButton1MousePressed

    private void CancelButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButton1MouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
       CancelButton1.setIcon(ISB);
    }//GEN-LAST:event_CancelButton1MouseReleased

    private void multipleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multipleMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Multiple_hover.png"));
       multiple.setIcon(ISB);
    }//GEN-LAST:event_multipleMouseEntered

    private void multipleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multipleMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Multiple.png"));
       multiple.setIcon(ISB);
    }//GEN-LAST:event_multipleMouseExited

    private void multipleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multipleMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Multiple_pressed.png"));
       multiple.setIcon(ISB);
    }//GEN-LAST:event_multipleMousePressed

    private void multipleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multipleMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Multiple_hover.png"));
       multiple.setIcon(ISB);
    }//GEN-LAST:event_multipleMouseReleased

    private void multipleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multipleMouseClicked
        MultipleEntry.setEnabled(true);
        MultipleEntry.setVisible(true);
        Edit_Rightsidebarpanel.setVisible(false);
     Edit_Rightsidebarpanel.setEnabled(false);
     New_Rightsidebarpanel.setVisible(false);
     New_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(false);
     Delete_Rightsidebarpanel.setEnabled(false);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_multipleMouseClicked

    private void EditButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButton3MouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Edit_hover.png"));
      EditButton3.setIcon(ISB);
    }//GEN-LAST:event_EditButton3MouseEntered

    private void EditButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButton3MouseExited
         ImageIcon ISB=new ImageIcon(getClass().getResource("Edit.png"));
      EditButton3.setIcon(ISB);
    }//GEN-LAST:event_EditButton3MouseExited

    private void EditButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButton3MousePressed
          ImageIcon ISB=new ImageIcon(getClass().getResource("Edit_hover.png"));
      EditButton3.setIcon(ISB);
      ChangePassword cp = new ChangePassword();
      cp.setVisible(true);
    }//GEN-LAST:event_EditButton3MousePressed

    private void EditButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButton3MouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Edit_hover.png"));
      EditButton3.setIcon(ISB);
    }//GEN-LAST:event_EditButton3MouseReleased

    private void UsernameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTextField1ActionPerformed

    private void YourProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_YourProfileMouseClicked

    private void YourProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileMouseEntered
 ImageIcon ISB=new ImageIcon(getClass().getResource("YourProfile_hover.png"));
       YourProfile.setIcon(ISB);        
    }//GEN-LAST:event_YourProfileMouseEntered

    private void YourProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("YourProfile.png"));
       YourProfile.setIcon(ISB); 
    }//GEN-LAST:event_YourProfileMouseExited

    private void YourProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("YourProfile_pressed.png"));
       YourProfile.setIcon(ISB); 
       New_Rightsidebarpanel.setVisible(false);
     New_Rightsidebarpanel.setEnabled(false);
     Edit_Rightsidebarpanel.setVisible(false);
     Edit_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(false);
     Delete_Rightsidebarpanel.setEnabled(false);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(true);
       Profile_Rightsidebarpanel.setEnabled(true);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
        SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_YourProfileMousePressed

    private void YourProfileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("YourProfile_hover.png"));
       YourProfile.setIcon(ISB); 
    }//GEN-LAST:event_YourProfileMouseReleased

    private void CreatebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatebuttonMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("Create_hover.png"));
       Createbutton.setIcon(ISB); 
    }//GEN-LAST:event_CreatebuttonMouseEntered

    private void CreatebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatebuttonMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Create.png"));
       Createbutton.setIcon(ISB); 
    }//GEN-LAST:event_CreatebuttonMouseExited

    private void CreatebuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatebuttonMousePressed
         ImageIcon ISB=new ImageIcon(getClass().getResource("Create_press.png"));
       Createbutton.setIcon(ISB);
       String user;
       String email;
       String Pass = new String(jPasswordField2.getPassword());
       String PasswordGenerated = null;
       PopUp pop1 = new PopUp();
       
      
       try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(Pass.getBytes());
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
			PasswordGenerated = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
       try{
           String ConfPass = new String(jPasswordField3.getPassword());
           String combobox = (String)jComboBox1.getSelectedItem();
           if(Pass.equals(ConfPass)){
               st.executeUpdate("INSERT INTO login VALUES('"+EmailTextField1.getText()+"','"+UsernameTextField1.getText()+"','"+PasswordGenerated+"','"+combobox+"','"+FirstNameTextField1.getText()+"','"+LastNameTextField1.getText()+"')");
           pop1.setMessagelabel("Account Created");
           pop1.setVisible(true);
           }
           else{
               pop1.setMessagelabel("Passwords don't match");
               pop1.setVisible(true);
           }
       }
       
       catch(Exception e1)
       {
           pop1.setMessagelabel("Error Occured");
           pop1.setVisible(true);
       }
       
       //st.executeUpdate("INSERT INTO login VALUES('"+EmailTextField1.getText()+"','"+UsernameTextField1.getText()+"','"+jPasswordField2.getText()+"',"
    }//GEN-LAST:event_CreatebuttonMousePressed

    private void CreatebuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatebuttonMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("Create_hover.png"));
       Createbutton.setIcon(ISB); 
    }//GEN-LAST:event_CreatebuttonMouseReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void UserNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNewMouseClicked

    private void UserNewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNewMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("NewUserhover.png"));
       UserNew.setIcon(ISB);    
    }//GEN-LAST:event_UserNewMouseEntered

    private void UserNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNewMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("NewUser.png"));
       UserNew.setIcon(ISB);  
    }//GEN-LAST:event_UserNewMouseExited

    private void UserNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNewMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("New_User_press.png"));
       UserNew.setIcon(ISB);  
    }//GEN-LAST:event_UserNewMousePressed

    private void UserNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNewMouseReleased
         ImageIcon ISB=new ImageIcon(getClass().getResource("NewUserhover.png"));
       UserNew.setIcon(ISB);  
       New_Rightsidebarpanel.setVisible(false);
     New_Rightsidebarpanel.setEnabled(false);
     Edit_Rightsidebarpanel.setVisible(false);
     Edit_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(false);
     Delete_Rightsidebarpanel.setEnabled(false);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(true);
       AddNewUser.setEnabled(true);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_UserNewMouseReleased

    private void deleteuserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteuserMousePressed
        New_Rightsidebarpanel.setVisible(false);
     New_Rightsidebarpanel.setEnabled(false);
     Edit_Rightsidebarpanel.setVisible(false);
     Edit_Rightsidebarpanel.setEnabled(false);
     Delete_Rightsidebarpanel.setVisible(false);
     Delete_Rightsidebarpanel.setEnabled(false);
     Search_Rightsidebarpanel.setVisible(false);
     Search_Rightsidebarpanel.setEnabled(false);
     Complain_Ridesidebarpanel.setVisible(false);
     Complain_Ridesidebarpanel.setEnabled(false);
     Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(true);
       DeleteUserPanel.setEnabled(true);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
       // userdeletetable();
       try{
           rt= st.executeQuery("SELECT * FROM login");
           while(rt.next()){
               String name = rt.getString("username");
               jComboBox2.addItem(name);
           }
       }
       catch(Exception e1)
       {
           PopUp pop = new PopUp();
           pop.setMessagelabel("Error Occured");
           pop.setVisible(true);
       }
    }//GEN-LAST:event_deleteuserMousePressed

    private void deletebuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMousePressed
       PopUp pop = new PopUp();
        try{
        st.executeUpdate("DELETE FROM login where username='"+name+"'");
        pop.setMessagelabel("Account Deleted");
        pop.setVisible(true);
       }
       catch(Exception e1){
           System.out.println(e1);
       }
    }//GEN-LAST:event_deletebuttonMousePressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
      
         name = (String) jComboBox2.getSelectedItem();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        PopUp pop = new PopUp();
        
        try{
                rt = st.executeQuery("SELECT * FROM login where username='"+name+"'");
                rt.next();
                String name_user = rt.getString("username");
                String id_email = rt.getString("email_id");
                String typeofacccount = rt.getString("account_type");
                if(name_user.equals("admin")){
                    pop.setMessagelabel("This account cannot be deleted");
                    pop.setVisible(true);
                }else{
                    uname.setVisible(true);
        uname.setEnabled(true);
        unamelabel.setVisible(true);
        unamelabel.setEnabled(true);
        id.setVisible(true);
        id.setEnabled(true);
        emailidlabel.setVisible(true);
        emailidlabel.setEnabled(true);
        typeacc.setVisible(true);
        typeacc.setEnabled(true);
        acctypelabel.setVisible(true);
        acctypelabel.setEnabled(true);
        deletebutton.setVisible(true);
        deletebutton.setEnabled(true);
                unamelabel.setText(name_user);
                emailidlabel.setText(id_email);
                acctypelabel.setText(typeofacccount);
                }
            }
            catch(Exception e1){
                pop.setMessagelabel("Error");
                pop.setVisible(true);
            }
    }//GEN-LAST:event_jButton1MousePressed

    private void S_PONumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_PONumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_PONumberActionPerformed

    private void SearchbypoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbypoMousePressed
         ImageIcon ISB=new ImageIcon(getClass().getResource("Searchpo_pressed.png"));
         Searchbypo.setIcon(ISB);
         Edit_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setEnabled(false);
        New_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setEnabled(false);
        Search_Rightsidebarpanel.setVisible(false);
        Search_Rightsidebarpanel.setEnabled(false);
        Complain_Ridesidebarpanel.setVisible(false);
        Complain_Ridesidebarpanel.setEnabled(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(true);
       SearchByPO.setVisible(true);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_SearchbypoMousePressed

    private void SearchbydepartmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbydepartmentMousePressed
         ImageIcon ISB=new ImageIcon(getClass().getResource("searchdep_pressed.png"));
         Searchbydepartment.setIcon(ISB);
        Edit_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setEnabled(false);
        New_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setEnabled(false);
        Search_Rightsidebarpanel.setVisible(false);
        Search_Rightsidebarpanel.setEnabled(false);
        Complain_Ridesidebarpanel.setVisible(false);
        Complain_Ridesidebarpanel.setEnabled(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(true);
       SearchByDepartment.setEnabled(true);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(false);
       SearchByUnderPO.setEnabled(false);
       HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_SearchbydepartmentMousePressed

    private void SearchbyunderrepairpoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbyunderrepairpoMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairPo_pressed.png"));
       Searchbyunderrepairpo.setIcon(ISB);
        Edit_Rightsidebarpanel.setVisible(false);
        Edit_Rightsidebarpanel.setEnabled(false);
        New_Rightsidebarpanel.setVisible(false);
        New_Rightsidebarpanel.setEnabled(false);
        Delete_Rightsidebarpanel.setVisible(false);
        Delete_Rightsidebarpanel.setEnabled(false);
        Search_Rightsidebarpanel.setVisible(false);
        Search_Rightsidebarpanel.setEnabled(false);
        Complain_Ridesidebarpanel.setVisible(false);
        Complain_Ridesidebarpanel.setEnabled(false);
        Profile_Rightsidebarpanel.setVisible(false);
       Profile_Rightsidebarpanel.setEnabled(false);
       AddNewUser.setVisible(false);
       AddNewUser.setEnabled(false);
       DeleteUserPanel.setVisible(false);
       DeleteUserPanel.setEnabled(false);
       SearchByDepartment.setVisible(false);
       SearchByDepartment.setEnabled(false);
       SearchByPO.setVisible(false);
       SearchByPO.setVisible(false);
       SearchByUnderPO.setVisible(true);
       SearchByUnderPO.setEnabled(true);HelpRightside_panel.setVisible(false);
       HelpRightside_panel.setEnabled(false);
    }//GEN-LAST:event_SearchbyunderrepairpoMousePressed

    private void S_submitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_submitMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_pressed.png"));
        S_submit.setIcon(ISB);
        try {
             // TODO add your handling code here:
             String txtdata=Search_SpecificationNumber.getText();
             String qry="SELECT * FROM Transf_Details WHERE Tid="+"'"+txtdata+"'";
             rt=st.executeQuery(qry);
             if(rt.next())
             {
                 String tid=rt.getString(1);
                 int p_date=rt.getInt(2);
                 int p_month=rt.getInt(3);
                 int p_year=rt.getInt(4);
                 String po_no=rt.getString(5);
                 String buyer=rt.getString(6);
                 String item=rt.getString(7);
                 String department=rt.getString(8);
                 int price=rt.getInt(9);
                 int warranty=rt.getInt(10);
                 int warehouse=rt.getInt(11);
                 
                 S_SpecificationNumber.setText(tid);
                 S_PurchasedDate.setText(Integer.toString(p_date));
                 S_PurchasedMonth.setText(Integer.toString(p_month));
                 S_PurchasedYear.setText(Integer.toString(p_year));
                 S_PONumber.setText(po_no);
                 S_Buyer.setText(buyer);
                 S_Item.setText(item);
                 S_Department.setText(department);
                 S_Price.setText(Integer.toString(price));
                 S_Warranty.setText(Integer.toString(warranty));
                 S_Warehouse.setText(Integer.toString(warehouse));
                }
             else
             {
                 JOptionPane.showMessageDialog(this,"Invalid Entry");
             }
            }
         
         catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
         }
    }//GEN-LAST:event_S_submitMousePressed

    private void S_nextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_nextMousePressed
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_pressed.png"));
       S_next.setIcon(ISB);
       try{
           st.executeUpdate("INSERT INTO historyedit VALUES('"+S_SpecificationNumber.getText()+"')");
       }
       catch(Exception e1){
           PopUp pop = new PopUp();
           pop.setMessagelabel("Error");
           pop.setVisible(true);
       }
       try
        {
        String spec_no=S_SpecificationNumber.getText();
        String po_no=S_PONumber.getText();
        String buyer=S_Buyer.getText();
        String item=S_Item.getText();
        String department=S_Department.getText();
        int price=Integer.parseInt(S_Price.getText());
        String qry="UPDATE Transf_Details SET Po_No='"+po_no+"',Buyer='"+buyer+"',Item='"+item+"',Department='"+department+"' WHERE Tid='"+spec_no+"'";
        st.executeUpdate(qry);
        S_Buyer.setText("");
        S_Department.setText("");
        S_Item.setText("");
        S_PONumber.setText("");
        S_Price.setText("");
        S_PurchasedDate.setText("");
        S_PurchasedMonth.setText("");
        S_PurchasedYear.setText("");
        S_SpecificationNumber.setText("");
        S_Warehouse.setText("");
        S_Warranty.setText("");
        Search_SpecificationNumber.setText("");
        JOptionPane.showMessageDialog(this,"Successfully Updated");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
         
    }//GEN-LAST:event_S_nextMousePressed

    private void S_cancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_cancelMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_pressed.png"));
        S_cancel.setIcon(ISB);
        S_Buyer.setText("");
        S_Department.setText("");
        S_Item.setText("");
        S_PONumber.setText("");
        S_Price.setText("");
        S_PurchasedDate.setText("");
        S_PurchasedMonth.setText("");
        S_PurchasedYear.setText("");
        S_SpecificationNumber.setText("");
        S_Warehouse.setText("");
        S_Warranty.setText("");
        Search_SpecificationNumber.setText("");
    }//GEN-LAST:event_S_cancelMousePressed

    private void D_submitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_submitMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_pressed.png"));
         D_submit.setIcon(ISB);
        try {
             // TODO add your handling code here:
             String txtdata=Delete_SpecificationNumber.getText();
             String qry="SELECT * FROM Transf_Details WHERE Tid="+"'"+txtdata+"'";
             rt=st.executeQuery(qry);
             if(rt.next())
             {
                 String tid=rt.getString(1);
                 int p_date=rt.getInt(2);
                 int p_month=rt.getInt(3);
                 int p_year=rt.getInt(4);
                 String po_no=rt.getString(5);
                 String buyer=rt.getString(6);
                 String item=rt.getString(7);
                 String department=rt.getString(8);
                 int price=rt.getInt(9);
                 int warranty=rt.getInt(10);
                 int warehouse=rt.getInt(11);
                 
                 D_SpecificationNumber.setText(tid);
                 D_PurchasedDate.setText(Integer.toString(p_date));
                 D_PurchasedMonth.setText(Integer.toString(p_month));
                 D_PurchasedYear.setText(Integer.toString(p_year));
                 D_Po_No.setText(po_no);
                 D_Buyer.setText(buyer);
                 D_Item.setText(item);
                 D_Department.setText(department);
                 D_Price.setText(Integer.toString(price));
                 D_Warranty.setText(Integer.toString(warranty));
                 D_Warehouse.setText(Integer.toString(warehouse));
            }  
            else
             {
                 JOptionPane.showMessageDialog(this, "Invalid Entry");
             }
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(this,e);
         }
    }//GEN-LAST:event_D_submitMousePressed

    private void D_nextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_nextMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_pressed.png"));
        D_next.setIcon(ISB);
        try{
           st.executeUpdate("INSERT INTO historydelete VALUES('"+Delete_SpecificationNumber.getText()+"')");
       }
       catch(Exception e1){
           PopUp pop = new PopUp();
           pop.setMessagelabel("Error");
           pop.setVisible(true);
       }
        try
        {
        String spec_no=Delete_SpecificationNumber.getText();
        String qry="DELETE FROM Transf_Details WHERE Tid='"+spec_no+"'";
        st.executeUpdate(qry);
        
        //String del_table=sp.getText();
        String qry1="DROP TABLE "+spec_no;
        st.executeUpdate(qry1);
        
        Delete_SpecificationNumber.setText("");
        D_SpecificationNumber.setText("");
        D_Buyer.setText("");
        D_Department.setText("");
        D_Item.setText("");
        D_Po_No.setText("");
        D_Price.setText("");
        D_PurchasedDate.setText("");
        D_PurchasedMonth.setText("");
        D_PurchasedYear.setText("");
        D_Warehouse.setText("");
        D_Warranty.setText("");
        JOptionPane.showMessageDialog(this,"Successfully Deleted");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
         
    }//GEN-LAST:event_D_nextMousePressed

    private void D_cancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_cancelMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_pressed.png"));
        D_cancel.setIcon(ISB);
        Delete_SpecificationNumber.setText("");
        D_SpecificationNumber.setText("");
        D_Buyer.setText("");
        D_Department.setText("");
        D_Item.setText("");
        D_Po_No.setText("");
        D_Price.setText("");
        D_PurchasedDate.setText("");
        D_PurchasedMonth.setText("");
        D_PurchasedYear.setText("");
        D_Warehouse.setText("");
        D_Warranty.setText("");
    }//GEN-LAST:event_D_cancelMousePressed

    private void Se_SubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Se_SubmitMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_pressed.png"));
        S_submit.setIcon(ISB);
        try {
             // TODO add your handling code here:
             String txtdata=Search_Specification_Number.getText();
             String qry="SELECT * FROM Transf_Details WHERE Tid="+"'"+txtdata+"'";
             rt=st.executeQuery(qry);
             if(rt.next())
             {
                 String tid=rt.getString(1);
                 int p_date=rt.getInt(2);
                 int p_month=rt.getInt(3);
                 int p_year=rt.getInt(4);
                 String po_no=rt.getString(5);
                 String buyer=rt.getString(6);
                 String item=rt.getString(7);
                 String department=rt.getString(8);
                 int price=rt.getInt(9);
                 int warranty=rt.getInt(10);
                 int warehouse=rt.getInt(11);
                 
                 Se_SpecificationNumber.setText(tid);
                 Se_PurchasedDate.setText(Integer.toString(p_date));
                 Se_PurchasedMonth.setText(Integer.toString(p_month));
                 Se_PurchasedYear.setText(Integer.toString(p_year));
                 Se_Po_No.setText(po_no);
                 Se_Buyer.setText(buyer);
                 Se_Item.setText(item);
                 Se_Department.setText(department);
                 Se_Price.setText(Integer.toString(price));
                 Se_Warranty.setText(Integer.toString(warranty));
                 Se_Warehouse.setText(Integer.toString(warehouse));
                }  
                 else
               {
                 JOptionPane.showMessageDialog(this, "Invalid Entry");
                }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
         }
    }//GEN-LAST:event_Se_SubmitMousePressed

    private void SearchByPO_SubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchByPO_SubmitMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_pressed.png"));
        SearchByPO_Submit.setIcon(ISB);
        String po=SearchByPONumber.getText();
        int j=0;
        jTable1.setFillsViewportHeight(true);
         DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
         String ReinstallationDate=null;
         String ReinstallationMonth=null;
         String ReinstallationYear=null;
         String ComplainDate=null;
         String ComplainMonth=null;
         String ComplainYear=null;
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try
         {
              rt=st.executeQuery("SELECT * FROM Transf_details WHERE Po_No='"+po+"'");
              while(rt.next())
              {
                    j=1;
                    String Tid=rt.getString(1);
                    String Expiry = null;
                    String ExpiryDate=null;
                    String ExpiryMonth=null;
                    String ExpiryYear=null;
                    String PurchaseDate=Integer.toString(rt.getInt(2));
                    String PurchaseMonth=Integer.toString(rt.getInt(3));
                    String PurchaseYear=Integer.toString(rt.getInt(4));
                    String InstallationDate=Integer.toString(rt.getInt(12));
                    String InstallationMonth=Integer.toString(rt.getInt(13));
                    String InstallationYear=Integer.toString(rt.getInt(14));
                    String Warranty=Integer.toString(rt.getInt(10));
                    String Warehouse=Integer.toString(rt.getInt(11));
                    String Po=rt.getString(5);
                    String Buyer=rt.getString(6);
                    String Dept=rt.getString(8);
                    String Item=rt.getString(7);
                    String Type=(Warranty+"/"+Warehouse);
                    String Purchase=(PurchaseDate+"/"+PurchaseMonth+"/"+PurchaseYear);
                    String Installation=(InstallationDate+"/"+InstallationMonth+"/"+InstallationYear);
//                    JOptionPane.showMessageDialog(this,Buyer);
                   rt1=st1.executeQuery("SELECT MAX(Sno) FROM "+Tid);
                   if(rt1.next())
                   {
                       int sno=rt1.getInt(1);
                       
                       if(sno==1)
                       {
                              rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
    //                       JOptionPane.showMessageDialog(this,"Working");
                           if(rt1.next())
                           {

                               ComplainDate=Integer.toString(rt1.getInt(8));
                               ComplainMonth=Integer.toString(rt1.getInt(9));
                               ComplainYear=Integer.toString(rt1.getInt(10));
                               ReinstallationDate=Integer.toString(rt1.getInt(11));
                               ReinstallationMonth=Integer.toString(rt1.getInt(12));
                               ReinstallationYear=Integer.toString(rt1.getInt(13));
                               ExpiryDate=Integer.toString(rt1.getInt(14));
                               ExpiryMonth=Integer.toString(rt1.getInt(15));
                               ExpiryYear=Integer.toString(rt1.getInt(16));
                               Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                               model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry});
                            } 
                       }
                       else
                       {
                            sno=sno-1;
                            rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
//                         JOptionPane.showMessageDialog(this,"Working");
                           if(rt1.next())
                           {

                               ComplainDate=Integer.toString(rt1.getInt(8));
                               ComplainMonth=Integer.toString(rt1.getInt(9));
                               ComplainYear=Integer.toString(rt1.getInt(10));
                               ReinstallationDate=Integer.toString(rt1.getInt(11));
                               ReinstallationMonth=Integer.toString(rt1.getInt(12));
                               ReinstallationYear=Integer.toString(rt1.getInt(13));
                               ExpiryDate=Integer.toString(rt1.getInt(14));
                               ExpiryMonth=Integer.toString(rt1.getInt(15));
                               ExpiryYear=Integer.toString(rt1.getInt(16));
                               Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                               model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry});
                            } 
                        }
                   }
                   
                }
              if(j==0)
               {
                   JOptionPane.showMessageDialog(this, "Invalid Entry");
               }
         }catch(Exception e)
         {
             JOptionPane.showMessageDialog(this,e);
         }
    }//GEN-LAST:event_SearchByPO_SubmitMousePressed

    private void SD_SubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SD_SubmitMousePressed
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_pressed.png"));
       SD_Submit.setIcon(ISB);
        String dep=SD_Department.getText();
        int j=0;
        jTable2.setFillsViewportHeight(true);
         DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
         String ReinstallationDate=null;
         String ReinstallationMonth=null;
         String ReinstallationYear=null;
         String ComplainDate=null;
         String ComplainMonth=null;
         String ComplainYear=null;
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try
         {
              rt=st.executeQuery("SELECT * FROM Transf_details WHERE Department='"+dep+"'");
              while(rt.next())
              {
                  j=1;
                    String Tid=rt.getString(1);
                    String Expiry = null;
                    String ExpiryDate=null;
                    String ExpiryMonth=null;
                    String ExpiryYear=null;
                    String PurchaseDate=Integer.toString(rt.getInt(2));
                    String PurchaseMonth=Integer.toString(rt.getInt(3));
                    String PurchaseYear=Integer.toString(rt.getInt(4));
                    String InstallationDate=Integer.toString(rt.getInt(12));
                    String InstallationMonth=Integer.toString(rt.getInt(13));
                    String InstallationYear=Integer.toString(rt.getInt(14));
                    String Warranty=Integer.toString(rt.getInt(10));
                    String Warehouse=Integer.toString(rt.getInt(11));
                    String Po=rt.getString(5);
                    String Buyer=rt.getString(6);
                    String Dept=rt.getString(8);
                    String Item=rt.getString(7);
                    String Type=(Warranty+"/"+Warehouse);
                    String Purchase=(PurchaseDate+"/"+PurchaseMonth+"/"+PurchaseYear);
                    String Installation=(InstallationDate+"/"+InstallationMonth+"/"+InstallationYear);
                   // JOptionPane.showMessageDialog(this,Buyer);
                   rt1=st1.executeQuery("SELECT max(Sno) FROM "+Tid);
                   if(rt1.next())
                   {
                       int sno=rt1.getInt(1);
                       
                       if(sno==1)
                       {
                           rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
                       //JOptionPane.showMessageDialog(this,"Working");
                       if(rt1.next())
                       {
                           
                           ComplainDate=Integer.toString(rt1.getInt(8));
                           ComplainMonth=Integer.toString(rt1.getInt(9));
                           ComplainYear=Integer.toString(rt1.getInt(10));
                           ReinstallationDate=Integer.toString(rt1.getInt(11));
                           ReinstallationMonth=Integer.toString(rt1.getInt(12));
                           ReinstallationYear=Integer.toString(rt1.getInt(13));
                           ExpiryDate=Integer.toString(rt1.getInt(14));
                           ExpiryMonth=Integer.toString(rt1.getInt(15));
                           ExpiryYear=Integer.toString(rt1.getInt(16));
                           Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                           
                           model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry});
                          
                        }
                       }
                       else
                       {
                           sno=sno-1;
                          rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
                       //JOptionPane.showMessageDialog(this,"Working");
                       if(rt1.next())
                       {
                           
                           ComplainDate=Integer.toString(rt1.getInt(8));
                           ComplainMonth=Integer.toString(rt1.getInt(9));
                           ComplainYear=Integer.toString(rt1.getInt(10));
                           ReinstallationDate=Integer.toString(rt1.getInt(11));
                           ReinstallationMonth=Integer.toString(rt1.getInt(12));
                           ReinstallationYear=Integer.toString(rt1.getInt(13));
                           ExpiryDate=Integer.toString(rt1.getInt(14));
                           ExpiryMonth=Integer.toString(rt1.getInt(15));
                           ExpiryYear=Integer.toString(rt1.getInt(16));
                           Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                           
                           model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry});
                          
                        } 
                    }
                       
                }
            }
              if(j==0)
              {
                  JOptionPane.showMessageDialog(this, "Invalid Entry");
              }
         }catch(Exception e)
         {
             JOptionPane.showMessageDialog(this, "Invalid Entry");
         }
    }//GEN-LAST:event_SD_SubmitMousePressed

    private void SUP_SubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_SubmitMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_pressed.png"));
        SUP_Submit.setIcon(ISB);
        String po=SUP_Po_No.getText();
        int j=0;
        jTable3.setFillsViewportHeight(true);
         DefaultTableModel model=(DefaultTableModel) jTable3.getModel();
         String ReinstallationDate=null;
         String ReinstallationMonth=null;
         String ReinstallationYear=null;
         String ComplainDate=null;
         String ComplainMonth=null;
         String ComplainYear=null;
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try
         {
              rt=st.executeQuery("SELECT * FROM Transf_details WHERE Po_No='"+po+"'");
              while(rt.next())
              {
                  j=1;
                    String Tid=rt.getString(1);
                    String Expiry = null;
                    String ExpiryDate=null;
                    String ExpiryMonth=null;
                    String ExpiryYear=null;
                    String PurchaseDate=Integer.toString(rt.getInt(2));
                    String PurchaseMonth=Integer.toString(rt.getInt(3));
                    String PurchaseYear=Integer.toString(rt.getInt(4));
                    String InstallationDate=Integer.toString(rt.getInt(12));
                    String InstallationMonth=Integer.toString(rt.getInt(13));
                    String InstallationYear=Integer.toString(rt.getInt(14));
                    String Warranty=Integer.toString(rt.getInt(10));
                    String Warehouse=Integer.toString(rt.getInt(11));
                    String Po=rt.getString(5);
                    String Buyer=rt.getString(6);
                    String Dept=rt.getString(8);
                    String Item=rt.getString(7);
                    String Type=(Warranty+"/"+Warehouse);
                    String Purchase=(PurchaseDate+"/"+PurchaseMonth+"/"+PurchaseYear);
                    String Installation=(InstallationDate+"/"+InstallationMonth+"/"+InstallationYear);
                   // JOptionPane.showMessageDialog(this,Buyer);
                   rt1=st1.executeQuery("SELECT max(Sno) FROM "+Tid);
                   if(rt1.next())
                   {
                       int sno=rt1.getInt(1);
                       
                       if(sno==1)
                       {
                           rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
                          //JOptionPane.showMessageDialog(this,"Working");
                          if(rt1.next())
                          {
                           
                           ComplainDate=Integer.toString(rt1.getInt(8));
                           ComplainMonth=Integer.toString(rt1.getInt(9));
                           ComplainYear=Integer.toString(rt1.getInt(10));
                           ReinstallationDate=Integer.toString(rt1.getInt(11));
                           ReinstallationMonth=Integer.toString(rt1.getInt(12));
                           ReinstallationYear=Integer.toString(rt1.getInt(13));
                           ExpiryDate=Integer.toString(rt1.getInt(14));
                           ExpiryMonth=Integer.toString(rt1.getInt(15));
                           ExpiryYear=Integer.toString(rt1.getInt(16));
                           Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                           if((rt1.getInt(11)==0)&&(rt1.getInt(12)==0)&&(rt1.getInt(13)==0)&&(rt1.getInt(8)!=0)&&(rt1.getInt(9)!=0)&&(rt1.getInt(10)!=0))
                           {
                              model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry});  
                           }
                        }
                       }
                       else
                       {
                           sno=sno-1;
                           rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
                       //JOptionPane.showMessageDialog(this,"Working");
                       if(rt1.next())
                       {
                           
                           ComplainDate=Integer.toString(rt1.getInt(8));
                           ComplainMonth=Integer.toString(rt1.getInt(9));
                           ComplainYear=Integer.toString(rt1.getInt(10));
                           ReinstallationDate=Integer.toString(rt1.getInt(11));
                           ReinstallationMonth=Integer.toString(rt1.getInt(12));
                           ReinstallationYear=Integer.toString(rt1.getInt(13));
                           ExpiryDate=Integer.toString(rt1.getInt(14));
                           ExpiryMonth=Integer.toString(rt1.getInt(15));
                           ExpiryYear=Integer.toString(rt1.getInt(16));
                           Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                           if((rt1.getInt(11)==0)&&(rt1.getInt(12)==0)&&(rt1.getInt(13)==0)&&(rt1.getInt(8)!=0)&&(rt1.getInt(9)!=0)&&(rt1.getInt(10)!=0))
                           {
                              model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry});  
                            }
                        }
                       }
                     }
                }
              if(j==0)
              {
                  JOptionPane.showMessageDialog(this, "Invalid Entry");
              }
         }catch(Exception e)
         {
             JOptionPane.showMessageDialog(this, "Invalid Entry");
         }
    }//GEN-LAST:event_SUP_SubmitMousePressed

    private void S_submitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_submitMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       S_submit.setIcon(ISB);
    }//GEN-LAST:event_S_submitMouseEntered

    private void S_submitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_submitMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       S_submit.setIcon(ISB);
    }//GEN-LAST:event_S_submitMouseReleased

    private void S_submitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_submitMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit.png"));
       S_submit.setIcon(ISB);
    }//GEN-LAST:event_S_submitMouseExited

    private void D_submitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_submitMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       D_submit.setIcon(ISB);
    }//GEN-LAST:event_D_submitMouseEntered

    private void D_submitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_submitMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit.png"));
       D_submit.setIcon(ISB);
    }//GEN-LAST:event_D_submitMouseExited

    private void D_submitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_submitMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       D_submit.setIcon(ISB);
    }//GEN-LAST:event_D_submitMouseReleased

    private void Se_SubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Se_SubmitMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       Se_Submit.setIcon(ISB);
    }//GEN-LAST:event_Se_SubmitMouseEntered

    private void Se_SubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Se_SubmitMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Submit.png"));
       Se_Submit.setIcon(ISB);
    }//GEN-LAST:event_Se_SubmitMouseExited

    private void Se_SubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Se_SubmitMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       Se_Submit.setIcon(ISB);
    }//GEN-LAST:event_Se_SubmitMouseReleased

    private void SearchByPO_SubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchByPO_SubmitMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       SearchByPO_Submit.setIcon(ISB);
    }//GEN-LAST:event_SearchByPO_SubmitMouseEntered

    private void SearchByPO_SubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchByPO_SubmitMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit.png"));
       SearchByPO_Submit.setIcon(ISB);
    }//GEN-LAST:event_SearchByPO_SubmitMouseExited

    private void SearchByPO_SubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchByPO_SubmitMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       SearchByPO_Submit.setIcon(ISB);
    }//GEN-LAST:event_SearchByPO_SubmitMouseReleased

    private void SD_SubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SD_SubmitMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       SD_Submit.setIcon(ISB);
    }//GEN-LAST:event_SD_SubmitMouseEntered

    private void SD_SubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SD_SubmitMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit.png"));
       SD_Submit.setIcon(ISB);
    }//GEN-LAST:event_SD_SubmitMouseExited

    private void SD_SubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SD_SubmitMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       SD_Submit.setIcon(ISB);
    }//GEN-LAST:event_SD_SubmitMouseReleased

    private void SUP_SubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_SubmitMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       SUP_Submit.setIcon(ISB);
    }//GEN-LAST:event_SUP_SubmitMouseEntered

    private void SUP_SubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_SubmitMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit.png"));
       SUP_Submit.setIcon(ISB);
    }//GEN-LAST:event_SUP_SubmitMouseExited

    private void SUP_SubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_SubmitMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("Submit_hover.png"));
       SUP_Submit.setIcon(ISB);
    }//GEN-LAST:event_SUP_SubmitMouseReleased

    private void S_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_nextMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
       S_next.setIcon(ISB);
    }//GEN-LAST:event_S_nextMouseEntered

    private void S_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_nextMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_default1.png"));
       S_next.setIcon(ISB);
    }//GEN-LAST:event_S_nextMouseExited

    private void S_nextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_nextMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
        S_next.setIcon(ISB);
    }//GEN-LAST:event_S_nextMouseReleased

    private void D_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_nextMouseEntered
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
       D_next.setIcon(ISB);
    }//GEN-LAST:event_D_nextMouseEntered

    private void D_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_nextMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_default1.png"));
       D_next.setIcon(ISB);
    }//GEN-LAST:event_D_nextMouseExited

    private void D_nextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_nextMouseReleased
       ImageIcon ISB=new ImageIcon(getClass().getResource("NextButton_hover.png"));
       D_next.setIcon(ISB);
    }//GEN-LAST:event_D_nextMouseReleased

    private void D_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_cancelMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
        D_cancel.setIcon(ISB);
    }//GEN-LAST:event_D_cancelMouseEntered

    private void D_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_cancelMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_default_3.png"));
       D_cancel.setIcon(ISB);
    }//GEN-LAST:event_D_cancelMouseExited

    private void D_cancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_cancelMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
        D_cancel.setIcon(ISB);
    }//GEN-LAST:event_D_cancelMouseReleased

    private void S_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_cancelMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
        S_cancel.setIcon(ISB);
    }//GEN-LAST:event_S_cancelMouseEntered

    private void S_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_cancelMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_default_3.png"));
        S_cancel.setIcon(ISB);
    }//GEN-LAST:event_S_cancelMouseExited

    private void S_cancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_cancelMouseReleased
      ImageIcon ISB=new ImageIcon(getClass().getResource("cancelButton_hover.png"));
      S_cancel.setIcon(ISB);
    }//GEN-LAST:event_S_cancelMouseReleased

    private void SearchbypoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbypoMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("Searchpo_hover.png"));
        Searchbypo.setIcon(ISB);
    }//GEN-LAST:event_SearchbypoMouseEntered

    private void SearchbypoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbypoMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("Searchpo.png"));
      Searchbypo.setIcon(ISB);
    }//GEN-LAST:event_SearchbypoMouseExited

    private void SearchbypoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbypoMouseReleased
         ImageIcon ISB=new ImageIcon(getClass().getResource("Searchpo_hover.png"));
         Searchbypo.setIcon(ISB);
    }//GEN-LAST:event_SearchbypoMouseReleased

    private void SearchbydepartmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbydepartmentMouseEntered
         ImageIcon ISB=new ImageIcon(getClass().getResource("searchdep_hover.png"));
      Searchbydepartment.setIcon(ISB);
    }//GEN-LAST:event_SearchbydepartmentMouseEntered

    private void SearchbydepartmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbydepartmentMouseExited
        ImageIcon ISB=new ImageIcon(getClass().getResource("searchdep.png"));
        Searchbydepartment.setIcon(ISB);
    }//GEN-LAST:event_SearchbydepartmentMouseExited

    private void SearchbydepartmentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbydepartmentMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("searchdep_hover.png"));
      Searchbydepartment.setIcon(ISB);
    }//GEN-LAST:event_SearchbydepartmentMouseReleased

    private void SearchbyunderrepairpoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbyunderrepairpoMouseEntered
        ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairPo_hover.png"));
      Searchbyunderrepairpo.setIcon(ISB);
    }//GEN-LAST:event_SearchbyunderrepairpoMouseEntered

    private void SearchbyunderrepairpoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbyunderrepairpoMouseExited
       ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairPo.png"));
      Searchbyunderrepairpo.setIcon(ISB);
    }//GEN-LAST:event_SearchbyunderrepairpoMouseExited

    private void SearchbyunderrepairpoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbyunderrepairpoMouseReleased
        ImageIcon ISB=new ImageIcon(getClass().getResource("UnderRepairPo_hover.png"));
        Searchbyunderrepairpo.setIcon(ISB);
    }//GEN-LAST:event_SearchbyunderrepairpoMouseReleased

    private void NextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseClicked
       
           
    }//GEN-LAST:event_NextButtonMouseClicked

    private void S_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_nextMouseClicked
       
    }//GEN-LAST:event_S_nextMouseClicked

    private void D_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_nextMouseClicked
      
    }//GEN-LAST:event_D_nextMouseClicked

    private void addrecordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addrecordMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("addrecordhelp_hover.png"));
       addrecord.setIcon(ISB);
       HelpPopup1 obj = new HelpPopup1();
       obj.setVisible(true);
    }//GEN-LAST:event_addrecordMousePressed

    private void addcomplainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcomplainMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("addingcomplain_hover.png"));
       addcomplain.setIcon(ISB);
       HelpPopup2 obj = new HelpPopup2();
       obj.setVisible(true);
    }//GEN-LAST:event_addcomplainMousePressed

    private void installhelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_installhelpMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("installdate_hover.png"));
       installhelp.setIcon(ISB);
       HelpPopup3 obj = new HelpPopup3();
       obj.setVisible(true);
    }//GEN-LAST:event_installhelpMousePressed

    private void reinstallhelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reinstallhelpMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("reinstall_hover.png"));
       reinstallhelp.setIcon(ISB);
       HelpPopup4 obj = new HelpPopup4();
       obj.setVisible(true);
    }//GEN-LAST:event_reinstallhelpMousePressed

    private void workingrecordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workingrecordMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("workingwithrecords_hover.png"));
       workingrecord.setIcon(ISB);
       HelpPopup5 obj = new HelpPopup5();
       obj.setVisible(true);
    }//GEN-LAST:event_workingrecordMousePressed

    private void usingprofileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usingprofileMousePressed
        ImageIcon ISB=new ImageIcon(getClass().getResource("Usingprofile_hover.png"));
      usingprofile.setIcon(ISB);
      HelpPopup6 obj = new HelpPopup6();
       obj.setVisible(true);
    }//GEN-LAST:event_usingprofileMousePressed

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

                new Welcome().setVisible(true); 
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel About;
    private javax.swing.JPanel AddNewUser;
    private javax.swing.JLabel Astrisk1;
    private javax.swing.JLabel Astrisk10;
    private javax.swing.JLabel Astrisk11;
    private javax.swing.JLabel Astrisk12;
    private javax.swing.JLabel Astrisk13;
    private javax.swing.JLabel Astrisk14;
    private javax.swing.JLabel Astrisk15;
    private javax.swing.JLabel Astrisk16;
    private javax.swing.JLabel Astrisk17;
    private javax.swing.JLabel Astrisk18;
    private javax.swing.JLabel Astrisk19;
    private javax.swing.JLabel Astrisk2;
    private javax.swing.JLabel Astrisk20;
    private javax.swing.JLabel Astrisk21;
    private javax.swing.JLabel Astrisk3;
    private javax.swing.JLabel Astrisk4;
    private javax.swing.JLabel Astrisk5;
    private javax.swing.JLabel Astrisk6;
    private javax.swing.JLabel Astrisk7;
    private javax.swing.JLabel Astrisk8;
    private javax.swing.JLabel Astrisk9;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Bar;
    private javax.swing.JLabel Bar1;
    private javax.swing.JLabel Bar2;
    private javax.swing.JLabel Bar3;
    private javax.swing.JLabel Bar4;
    private javax.swing.JLabel Bar5;
    private javax.swing.JLabel Bar7;
    private javax.swing.JLabel Buyer;
    private javax.swing.JLabel Buyer1;
    private javax.swing.JLabel BuyerField;
    private javax.swing.JLabel BuyerField1;
    private javax.swing.JTextField BuyerTextField;
    private javax.swing.JTextField BuyerTextField1;
    private javax.swing.JLabel COMPLAIN;
    private javax.swing.JLabel CancelButton;
    private javax.swing.JLabel CancelButton1;
    private javax.swing.JLabel Cancel_button;
    private javax.swing.JLabel Cause_of_failure;
    private javax.swing.JLabel ComplainButton;
    private javax.swing.JPanel Complain_Ridesidebarpanel;
    private javax.swing.JLabel Complain_background;
    private javax.swing.JLabel Createbutton;
    private javax.swing.JLabel D_Buyer;
    private javax.swing.JLabel D_Department;
    private javax.swing.JLabel D_Item;
    private javax.swing.JLabel D_Po_No;
    private javax.swing.JLabel D_Price;
    private javax.swing.JLabel D_PurchasedDate;
    private javax.swing.JLabel D_PurchasedMonth;
    private javax.swing.JLabel D_PurchasedYear;
    private javax.swing.JLabel D_SpecificationNumber;
    private javax.swing.JLabel D_Warehouse;
    private javax.swing.JLabel D_Warranty;
    private javax.swing.JLabel D_cancel;
    private javax.swing.JLabel D_next;
    private javax.swing.JLabel D_submit;
    private javax.swing.JLabel Dash1;
    private javax.swing.JLabel Dash2;
    private javax.swing.JLabel Dash3;
    private javax.swing.JLabel Dash4;
    private javax.swing.JLabel DateField;
    private javax.swing.JLabel DateField1;
    private javax.swing.JTextField DateTextField;
    private javax.swing.JTextField DateTextField1;
    private javax.swing.JLabel Date_of_complain;
    private javax.swing.JLabel Date_textbox;
    private javax.swing.JTextField Date_textfield;
    private javax.swing.JLabel Delete;
    private javax.swing.JPanel DeleteUserPanel;
    private javax.swing.JPanel Delete_Rightsidebarpanel;
    private javax.swing.JTextField Delete_SpecificationNumber;
    private javax.swing.JLabel Delete_rightsidebarpanel;
    private javax.swing.JLabel Department;
    private javax.swing.JTextField DeptTextField;
    private javax.swing.JTextField DeptTextField1;
    private javax.swing.JLabel Divide;
    private javax.swing.JLabel Divide1;
    private javax.swing.JLabel E_SpecificationNumber;
    private javax.swing.JLabel Edit;
    private javax.swing.JLabel EditButton3;
    private javax.swing.JPanel Edit_Rightsidebarpanel;
    private javax.swing.JLabel Edit_rightsidebarpanel;
    private javax.swing.JLabel EmailField1;
    private javax.swing.JTextField EmailTextField1;
    private javax.swing.JLabel Emailid;
    private javax.swing.JLabel FirstNameField1;
    private javax.swing.JTextField FirstNameTextField1;
    private javax.swing.JLabel Firstname;
    private javax.swing.JLabel HELP;
    private javax.swing.JPanel Help;
    private javax.swing.JPanel HelpRightside_panel;
    private javax.swing.JPanel Help_Leftsidebarpanel;
    private javax.swing.JLabel Help_leftsidebarpanel;
    private javax.swing.JLabel InstallationDate;
    private javax.swing.JLabel Item;
    private javax.swing.JLabel Item1;
    private javax.swing.JLabel ItemField;
    private javax.swing.JLabel ItemField1;
    private javax.swing.JTextField ItemTextField;
    private javax.swing.JTextField ItemTextField1;
    private javax.swing.JTextField LastNameTextField1;
    private javax.swing.JLabel Lastname;
    private javax.swing.JLabel Line;
    private javax.swing.JLabel Line1;
    private javax.swing.JLabel Line2;
    private javax.swing.JLabel Line3;
    private javax.swing.JLabel Line4;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Mandatory;
    private javax.swing.JLabel Mandatory1;
    private javax.swing.JLabel Mandatory2;
    private javax.swing.JLabel MonthField;
    private javax.swing.JLabel MonthField1;
    private javax.swing.JTextField MonthTextField;
    private javax.swing.JTextField MonthTextField1;
    private javax.swing.JLabel Month_textbox;
    private javax.swing.JTextField Month_textfield;
    private javax.swing.JPanel MultipleEntry;
    private javax.swing.JLabel NEW;
    private javax.swing.JLabel NEW1;
    private javax.swing.JLabel NEW2;
    private javax.swing.JLabel NEW3;
    private javax.swing.JLabel NEW4;
    private javax.swing.JLabel NEW6;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel New;
    private javax.swing.JPanel New_Rightsidebarpanel;
    private javax.swing.JLabel New_rightsidebarpanel;
    private javax.swing.JLabel New_rightsidebarpanel1;
    private javax.swing.JLabel NextButton;
    private javax.swing.JLabel NextButton1;
    private javax.swing.JLabel Next_button;
    private javax.swing.JLabel No_ofTransformers;
    private javax.swing.JTextField No_ofTransformersTextField1;
    private javax.swing.JLabel PROFILE;
    private javax.swing.JLabel PasswordField;
    private javax.swing.JLabel PasswordField1;
    private javax.swing.JLabel PasswordField2;
    private javax.swing.JLabel Place;
    private javax.swing.JLabel Place1;
    private javax.swing.JLabel PlaceField;
    private javax.swing.JLabel PlaceField1;
    private javax.swing.JLabel PoNo;
    private javax.swing.JLabel PoNo1;
    private javax.swing.JLabel PoNoField;
    private javax.swing.JLabel PoNoField1;
    private javax.swing.JTextField PoNoTextField;
    private javax.swing.JTextField PoNoTextField1;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Price1;
    private javax.swing.JLabel PriceField;
    private javax.swing.JLabel PriceField1;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JTextField PriceTextField1;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Profile_Leftsidebarpanel;
    private javax.swing.JPanel Profile_Rightsidebarpanel;
    private javax.swing.JLabel Profile_leftsidebarpanel;
    private javax.swing.JLabel Profile_rightsidebarpanel;
    private javax.swing.JLabel PurchasedDate;
    private javax.swing.JLabel PurchasedDate1;
    private javax.swing.JLabel R_add_history1;
    private javax.swing.JLabel R_add_history1_date;
    private javax.swing.JLabel R_add_history2;
    private javax.swing.JLabel R_add_history2_date;
    private javax.swing.JLabel R_add_history3;
    private javax.swing.JLabel R_add_history3_date;
    private javax.swing.JLabel R_add_history4;
    private javax.swing.JLabel R_add_history4_date;
    private javax.swing.JLabel R_add_history5;
    private javax.swing.JLabel R_add_history5_date;
    private javax.swing.JLabel R_add_history6;
    private javax.swing.JLabel R_add_history6_date;
    private javax.swing.JLabel R_add_history7;
    private javax.swing.JLabel R_add_history7_date;
    private javax.swing.JLabel R_add_history_button1;
    private javax.swing.JLabel R_add_history_button2;
    private javax.swing.JLabel R_add_history_button3;
    private javax.swing.JLabel R_add_history_button4;
    private javax.swing.JLabel R_add_history_button5;
    private javax.swing.JLabel R_add_history_button6;
    private javax.swing.JLabel R_add_history_button7;
    private javax.swing.JLabel R_delete_history1;
    private javax.swing.JLabel R_delete_history1_date;
    private javax.swing.JLabel R_delete_history2;
    private javax.swing.JLabel R_delete_history2_date;
    private javax.swing.JLabel R_delete_history3;
    private javax.swing.JLabel R_delete_history3_date;
    private javax.swing.JLabel R_delete_history4;
    private javax.swing.JLabel R_delete_history4_date;
    private javax.swing.JLabel R_delete_history5;
    private javax.swing.JLabel R_delete_history5_date;
    private javax.swing.JLabel R_delete_history6;
    private javax.swing.JLabel R_delete_history6_date;
    private javax.swing.JLabel R_delete_history7;
    private javax.swing.JLabel R_delete_history7_date;
    private javax.swing.JLabel R_delete_history_button1;
    private javax.swing.JLabel R_delete_history_button2;
    private javax.swing.JLabel R_delete_history_button3;
    private javax.swing.JLabel R_delete_history_button4;
    private javax.swing.JLabel R_delete_history_button5;
    private javax.swing.JLabel R_delete_history_button6;
    private javax.swing.JLabel R_delete_history_button7;
    private javax.swing.JLabel R_edit_history1;
    private javax.swing.JLabel R_edit_history1_date;
    private javax.swing.JLabel R_edit_history2;
    private javax.swing.JLabel R_edit_history2_date;
    private javax.swing.JLabel R_edit_history3;
    private javax.swing.JLabel R_edit_history3_date;
    private javax.swing.JLabel R_edit_history4;
    private javax.swing.JLabel R_edit_history4_date;
    private javax.swing.JLabel R_edit_history5;
    private javax.swing.JLabel R_edit_history5_date;
    private javax.swing.JLabel R_edit_history6;
    private javax.swing.JLabel R_edit_history6_date;
    private javax.swing.JLabel R_edit_history7;
    private javax.swing.JLabel R_edit_history7_date;
    private javax.swing.JLabel R_edit_history_button1;
    private javax.swing.JLabel R_edit_history_button2;
    private javax.swing.JLabel R_edit_history_button3;
    private javax.swing.JLabel R_edit_history_button4;
    private javax.swing.JLabel R_edit_history_button5;
    private javax.swing.JLabel R_edit_history_button6;
    private javax.swing.JLabel R_edit_history_button7;
    private javax.swing.JLabel R_history1;
    private javax.swing.JLabel R_history1_date;
    private javax.swing.JLabel R_history2;
    private javax.swing.JLabel R_history2_date;
    private javax.swing.JLabel R_history3;
    private javax.swing.JLabel R_history3_date;
    private javax.swing.JLabel R_history4;
    private javax.swing.JLabel R_history4_date;
    private javax.swing.JLabel R_history5;
    private javax.swing.JLabel R_history5_date;
    private javax.swing.JLabel R_history6;
    private javax.swing.JLabel R_history6_date;
    private javax.swing.JLabel R_history7;
    private javax.swing.JLabel R_history7_date;
    private javax.swing.JLabel R_history_button1;
    private javax.swing.JLabel R_history_button2;
    private javax.swing.JLabel R_history_button3;
    private javax.swing.JLabel R_history_button4;
    private javax.swing.JLabel R_history_button5;
    private javax.swing.JLabel R_history_button6;
    private javax.swing.JLabel R_history_button7;
    private javax.swing.JLabel Recent;
    private javax.swing.JLabel Recently_added;
    private javax.swing.JLabel Recently_deleted;
    private javax.swing.JLabel Recently_edited;
    private javax.swing.JLabel Recently_search;
    private javax.swing.JPanel Record;
    private javax.swing.JPanel Record_Leftsidebarpanel;
    private javax.swing.JLabel Record_leftsidebarpanel;
    private javax.swing.JTextField SD_Department;
    private javax.swing.JLabel SD_Submit;
    private javax.swing.JTextField SUP_Po_No;
    private javax.swing.JLabel SUP_Submit;
    private javax.swing.JTextField S_Buyer;
    private javax.swing.JTextField S_Department;
    private javax.swing.JTextField S_Item;
    private javax.swing.JTextField S_PONumber;
    private javax.swing.JTextField S_Price;
    private javax.swing.JTextField S_PurchasedDate;
    private javax.swing.JTextField S_PurchasedMonth;
    private javax.swing.JTextField S_PurchasedYear;
    private javax.swing.JTextField S_SpecificationNumber;
    private javax.swing.JTextField S_Warehouse;
    private javax.swing.JTextField S_Warranty;
    private javax.swing.JLabel S_cancel;
    private javax.swing.JLabel S_history1;
    private javax.swing.JLabel S_history1_date;
    private javax.swing.JLabel S_history2;
    private javax.swing.JLabel S_history2_date;
    private javax.swing.JLabel S_history3;
    private javax.swing.JLabel S_history3_date;
    private javax.swing.JLabel S_history4;
    private javax.swing.JLabel S_history4_date;
    private javax.swing.JLabel S_history5;
    private javax.swing.JLabel S_history5_date;
    private javax.swing.JLabel S_history6;
    private javax.swing.JLabel S_history6_date;
    private javax.swing.JLabel S_history7;
    private javax.swing.JLabel S_history7_date;
    private javax.swing.JLabel S_history_button1;
    private javax.swing.JLabel S_history_button2;
    private javax.swing.JLabel S_history_button3;
    private javax.swing.JLabel S_history_button4;
    private javax.swing.JLabel S_history_button5;
    private javax.swing.JLabel S_history_button6;
    private javax.swing.JLabel S_history_button7;
    private javax.swing.JLabel S_next;
    private javax.swing.JLabel S_submit;
    private javax.swing.JLabel Se_Buyer;
    private javax.swing.JLabel Se_Department;
    private javax.swing.JLabel Se_Item;
    private javax.swing.JLabel Se_Po_No;
    private javax.swing.JLabel Se_Price;
    private javax.swing.JLabel Se_PurchasedDate;
    private javax.swing.JLabel Se_PurchasedMonth;
    private javax.swing.JLabel Se_PurchasedYear;
    private javax.swing.JLabel Se_SpecificationNumber;
    private javax.swing.JLabel Se_Submit;
    private javax.swing.JLabel Se_Warehouse;
    private javax.swing.JLabel Se_Warranty;
    private javax.swing.JPanel Search;
    private javax.swing.JPanel SearchByDepartment;
    private javax.swing.JPanel SearchByPO;
    private javax.swing.JTextField SearchByPONumber;
    private javax.swing.JLabel SearchByPO_Submit;
    private javax.swing.JPanel SearchByUnderPO;
    private javax.swing.JPanel Search_Leftsidebarpanel;
    private javax.swing.JPanel Search_Rightsidebarpanel;
    private javax.swing.JTextField Search_SpecificationNumber;
    private javax.swing.JTextField Search_Specification_Number;
    private javax.swing.JLabel Search_leftsidebarpanel;
    private javax.swing.JLabel Search_rightsidebarpanel;
    private javax.swing.JLabel Search_rightsidebarpanel1;
    private javax.swing.JLabel Search_rightsidebarpanel2;
    private javax.swing.JLabel Search_rightsidebarpanel3;
    private javax.swing.JLabel Searchbydepartment;
    private javax.swing.JLabel Searchbypo;
    private javax.swing.JLabel Searchbyunderrepairpo;
    private javax.swing.JLabel Separator1;
    private javax.swing.JLabel Separator2;
    private javax.swing.JTextField SpecficationNoTextField;
    private javax.swing.JLabel SpecificationEditTxt;
    private javax.swing.JLabel SpecificationEditTxt1;
    private javax.swing.JLabel SpecificationNo;
    private javax.swing.JLabel Specification_No;
    private javax.swing.JLabel Specification_no_textbox;
    private javax.swing.JTextField Specification_no_textfield;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JLabel Text_box;
    private javax.swing.JLabel TypeOfWarranty;
    private javax.swing.JLabel TypeOfWarranty1;
    private javax.swing.JLabel UnderRepair;
    private javax.swing.JLabel UserNew;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel UsernameField1;
    private javax.swing.JTextField UsernameTextField1;
    private javax.swing.JLabel VIEW;
    private javax.swing.JPanel View;
    private javax.swing.JPanel View_Leftsidebarpanel;
    private javax.swing.JLabel View_leftsidebarpanel;
    private javax.swing.JTextField WarehouseMonth;
    private javax.swing.JTextField WarehouseMonth1;
    private javax.swing.JLabel WarehouseTextbox;
    private javax.swing.JLabel WarehouseTextbox1;
    private javax.swing.JLabel WarningArea;
    private javax.swing.JLabel WarningArea1;
    private javax.swing.JLabel WarningArea2;
    private javax.swing.JLabel Warninguser;
    private javax.swing.JTextField WarrantyMonth;
    private javax.swing.JTextField WarrantyMonth1;
    private javax.swing.JLabel WarrantyTextbox;
    private javax.swing.JLabel WarrantyTextbox1;
    private javax.swing.JLabel YearField;
    private javax.swing.JLabel YearField1;
    private javax.swing.JTextField YearTextField;
    private javax.swing.JTextField YearTextField1;
    private javax.swing.JTextField Year_textfield;
    private javax.swing.JLabel YourProfile;
    private javax.swing.JLabel about;
    private javax.swing.JLabel accounttype;
    private javax.swing.JLabel accountype;
    private javax.swing.JLabel accountype1;
    private javax.swing.JLabel acctypelabel;
    private javax.swing.JLabel addcomplain;
    private javax.swing.JLabel addrecord;
    private javax.swing.JLabel close;
    private javax.swing.JLabel confpassword;
    private javax.swing.JLabel deletebutton;
    private javax.swing.JLabel deleteuser;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailidlabel;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JLabel firstname1;
    private javax.swing.JLabel firstnamelabel;
    private javax.swing.JLabel help;
    private javax.swing.JLabel home;
    private javax.swing.JLabel id;
    private javax.swing.JLabel installhelp;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lastname1;
    private javax.swing.JLabel lastnamelabel;
    private javax.swing.JLabel menubar;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel multiple;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel popup1;
    private javax.swing.JLabel popup2;
    private javax.swing.JLabel popup3;
    private javax.swing.JLabel popup4;
    private javax.swing.JLabel popup5;
    private javax.swing.JLabel popup6;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel record;
    private javax.swing.JLabel reinstallhelp;
    private javax.swing.JLabel search;
    private javax.swing.JLabel searchby;
    private javax.swing.JLabel signout;
    private javax.swing.JLabel taskbar;
    private javax.swing.JLabel typeacc;
    private javax.swing.JLabel uname;
    private javax.swing.JLabel unamelabel;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JLabel usingprofile;
    private javax.swing.JLabel view;
    private javax.swing.JLabel workingrecord;
    private javax.swing.JLabel year_textbox;
    // End of variables declaration//GEN-END:variables
}
