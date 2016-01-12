/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anugrah
 */
public class ReportTable extends javax.swing.JFrame {
    Statement st,st1;ResultSet rt,rt1;
    Connection c,d;
    
    /**
     * Creates new form ReportTable
     */
    public ReportTable() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("Logo4.png")).getImage());
         jTable1.setFillsViewportHeight(true);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("error " + ex.getMessage());
        }
             String userName = "sa";
             String password = "zebra5110";
             String url = "jdbc:sqlserver://localhost:1025;databaseName=transrec;";
             Statement stmt=null;
             try{
                  c = DriverManager.getConnection(url, userName, password);
                  d = DriverManager.getConnection(url, userName, password);
             }
             catch (SQLException ex) {
            System.out.println("Error " +  ex.getMessage());
             }
         try {            
             st=c.createStatement();
             st1=d.createStatement();
            // st1=con.createStatement();
         } catch (SQLException e) {
             Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, e);
         }
        try {
             Calendar cal= new GregorianCalendar();
            int Date=cal.get(Calendar.DATE);
            int Month=cal.get(Calendar.MONTH);
            int Year=cal.get(Calendar.YEAR);
            Month=Month+1;
            rt=st.executeQuery("SELECT * FROM Transf_Details");
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                while(rt.next()){
                    String Tid=rt.getString(1);
                    String Expiry = null;
                    String ExpiryDate=null;
                    String ExpiryMonth=null;
                    String ExpiryYear=null;
                    String Status=null;
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
                    rt1=st1.executeQuery("SELECT max(Sno) FROM "+Tid);
                    if(rt1.next())
                    {
                        int sno=rt1.getInt(1);
                        rt1=st1.executeQuery("SELECT * FROM "+Tid+" WHERE Sno="+sno);
                        if(rt1.next())
                        {
                        ExpiryDate=Integer.toString(rt1.getInt(14));
                        ExpiryMonth=Integer.toString(rt1.getInt(15));
                        ExpiryYear=Integer.toString(rt1.getInt(16));
                        Expiry=(ExpiryDate+"/"+ExpiryMonth+"/"+ExpiryYear);
                        }
                    }
                    
                    int Exp_date=Integer.parseInt(ExpiryDate);
                    int Exp_month=Integer.parseInt(ExpiryMonth);
                    int Exp_year=Integer.parseInt(ExpiryYear);
                    if(Year==Exp_year)
                    {
                        if(Month==Exp_month)
                        {
                           if(Date==Exp_date)
                           {
                               Status="Under Warranty";
                           }
                           else
                           {
                               if(Date<Exp_date)
                               {
                                   Status="Under Warranty";
                               }
                               else
                               {
                                   Status="Out of Warranty";
                               }
                           }
                        }
                        else
                        {
                            if(Month<Exp_month)
                            {
                                Status="Under Warranty";
                            }
                            else
                            {
                                Status="Out of Warranty";
                            }
                        }
                    }
                    else
                    {
                        if(Year<Exp_year)
                        {
                            Status="Under Warranty";
                        }
                        else
                        {
                            Status="Out of Warranty";
                        }
                    }
                    model.addRow(new Object[] {Tid,Po,Buyer,Dept,Item,Type,Purchase,Installation,Expiry,Status});
                }
        } catch (SQLException e2) {
            Logger.getLogger(ReportTable.class.getName()).log(Level.SEVERE, null, e2);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 204));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(null);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setForeground(new java.awt.Color(153, 0, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Specification Number", "PO- Number", "Buyer", "Department ", "Item", "Type Of Warranty", "Purchase Date", "Installation Date", "ExpiryDate", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 960, 500);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/boundary.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 3, 700);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_close.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(997, 2, 23, 15);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Default_minimize.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(971, 2, 23, 15);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/boundary.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1021, 0, 3, 700);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Horizontal_boundary.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 697, 1024, 3);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Login_taskbar.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1024, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transformer/warranty/system/Background_1024700.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1024, 700));
        jLabel1.setMinimumSize(new java.awt.Dimension(10240, 700));
        jLabel1.setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1024, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        this.dispose();
    }//GEN-LAST:event_jLabel6MousePressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
