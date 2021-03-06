/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swapchat;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class allinone extends javax.swing.JFrame {

    final int SERVER_PORT = 18524;
    Socket socket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    ClientInfoSeirialized info;
    
    /**
     * Creates new form NewJFrame1
     */
    public allinone() throws HeadlessException {
        initComponents();
        FilljListThree();
        FilljListTwo();
        conDisconOfServer();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                clostSockInOut();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setText("SwapChat");

        jList2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jTabbedPane1.addTab("single", jScrollPane2);

        jList3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList3);

        jTabbedPane1.addTab("group", jScrollPane3);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel2.setText(LoginPage.jTextField1.getText());

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton1.setText("Sent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel4.setText("Connected");

        jButton2.setText("Create Group");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Online clients");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                            .addComponent(jScrollPane4))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTabbedPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new groupcreate().setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        jLabel3.setText(jList2.getSelectedValue());
        jTextArea1.setText("");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","swapchat","swapchat");
            //Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:1521/","swapchat","swapchat");
            java.sql.Statement stmt;
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select sms,date_time,from_user from chat_database where (from_user='"+LoginPage.jTextField1.getText()+"' and to_user='"+jList2.getSelectedValue()+"') or(from_user='"+jList2.getSelectedValue()+"' and to_user='"+LoginPage.jTextField1.getText()+"') order by date_time");
            while(rs.next()){
                String from_sms=rs.getString("from_user");
                String sms=rs.getString("sms");
                String date=rs.getString("date_time");
                jTextArea1.append(from_sms+"\n"+sms+"\n"+date+"\n \n \n");
            }
            con.close();
	}catch(HeadlessException | ClassNotFoundException | SQLException ec){
            System.out.println(ec);
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void showOnlineClients() {
        new Thread() {
            @Override
            public void run() {
                try {
                    if (jLabel3.getText().equals("disconnected")) {
                        throw new Exception();
                    }
                    info.showOnline = true;
                    String serializedInfo = SerializeDeserialize.toString(info);
                    out.println(serializedInfo);
                    info.showOnline = false;
                    //FilljListOne();
                } //Error in the serialization procces occured 
                catch (Exception e) {
                    jTextArea1.append("Problem getting online clients list \n");
                }
                //The thread dies
            }
        }.start();
    }
    
    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        // TODO add your handling code here:
        jLabel3.setText(jList3.getSelectedValue());
        jTextArea1.setText("");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","swapchat","swapchat");
            //Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:1521/","swapchat","swapchat");
            java.sql.Statement stmt;
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select sms,date_time,from_user from chat_database where (group_name='"+jList3.getSelectedValue()+"') order by date_time");
            while(rs.next()){
                String from_sms=rs.getString("from_user");
                String sms=rs.getString("sms");
                String date=rs.getString("date_time");
                jTextArea1.append(from_sms+"\n"+sms+"\n"+date+"\n \n \n");
            }
            con.close();
	}catch(HeadlessException | ClassNotFoundException | SQLException ec){
            System.out.println(ec);
        }
    }//GEN-LAST:event_jList3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        sendMsg();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        showOnlineClients();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sendMsg(){
        new Thread(){
            @Override
            public void run(){
                try{
                    info.msg = jTextField1.getText();
                    info.recipient = jList2.getSelectedValue();
                    info.group=jList3.getSelectedValue();
                    String serializedInfo = SerializeDeserialize.toString(info);
                    out.println(serializedInfo);
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","swapchat","swapchat");
                    //Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:1521/","swapchat","swapchat");
                    java.sql.Statement stmt;
                    stmt = con.createStatement();
                    ResultSet rs=stmt.executeQuery("insert into chat_database(date_time, from_user, to_user, sms, group_name) values (current_timestamp,'"+LoginPage.jTextField1.getText()+"','"+jList2.getSelectedValue()+"','"+jTextField1.getText()+"','"+jList3.getSelectedValue()+"')");
                    //insert into chat_database values(GETDATE(),LoginPage.jTextField.getText(),jList2.getSelectedValue(),jTextField1.getText());
                    jTextField1.setText("");
                    con.close();
                }catch(IOException | ClassNotFoundException | SQLException e){
                    jTextArea1.append("Problem sending the message. \n" + e);
                }
            }
        }.start();
    }
    
    private void conDisconOfServer(){
        new Thread(){
            @Override
            public void run(){
                try{
                    socket = new Socket("127.0.0.1", SERVER_PORT);
                    out = new PrintWriter(socket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    info = new ClientInfoSeirialized();
                    info.name = LoginPage.jTextField1.getText();
                    
                    out.println(info.name);
                    jLabel4.setText("Connected");
                    try{
                        String line;
                        while((line = in.readLine()) != null){
                            //JOptionPane.showMessageDialog(null, line);
                            jTextArea1.append(line +" \n" );
                        }
                    }catch(IOException e){
                        if(jLabel4.getText().equals("Connected")){
                            JOptionPane.showMessageDialog(null,"Server disconnected");
                        }
                    }
                    
                }catch(IOException e){
                    jLabel4.setText("disconnected");
                    JOptionPane.showMessageDialog(null,"Couldn't establish a connection with the server");
                }finally{
                    jLabel4.setText("disconnected");
                    clostSockInOut();
                }
            }
        }.start();
    }
    
    private void FilljListTwo(){
        DefaultListModel dlm = new DefaultListModel();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","swapchat","swapchat");
            //Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:1521/","swapchat","swapchat");
            java.sql.Statement stmt;
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select user_name from user_database");
            while(rs.next()){
                String username=rs.getString("user_name");
                dlm.addElement(username);
            }
            jList2.setModel(dlm);
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    private void FilljListThree(){
        DefaultListModel dlm = new DefaultListModel();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","swapchat","swapchat");
            //Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:1521/","swapchat","swapchat");
            java.sql.Statement stmt;
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select group_name from group_database where group_member='"+LoginPage.jTextField1.getText()+"' ");
            while(rs.next()){
                String name=rs.getString("group_name");
                dlm.addElement(name);
            }
            jList3.setModel(dlm);
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    private void clostSockInOut(){

        if(socket != null){
            try{
                socket.close();
            }catch(IOException ex){
            }
        }
        if(in != null){
            try{
                in.close();
            }catch(IOException ex){
            }
        }
        if(out != null){
            out.close();
        }
        dispose();
    }
    
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
            java.util.logging.Logger.getLogger(allinone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allinone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allinone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allinone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allinone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JList<String> jList2;
    public static javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
