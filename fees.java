package project1;

import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class fees extends javax.swing.JFrame {

    public fees() {
        initComponents();
        jPanel1.setLayout(null);
        jPanel1.add(jLabel9);
        jPanel1.add(am);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel8);
        jPanel1.add(jLabel2);
        jPanel1.add(idd);
        jPanel1.add(name);
        jPanel1.add(jScrollPane1);
        //jTextArea1.setEditable(false);
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1.setViewportView(jTextArea1);
        
                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
        jPanel1.add(rfees);
        jPanel1.add(srname);
        jPanel1.add(fname);
        jPanel1.add(jLabel7);
        jPanel1.add(clss);
        jPanel1.add(jButton2);
        jPanel1.add(jButton6);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel1);
    }

    private void design() {

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

        jTextArea1.setText(jTextArea1.getText() + "*******************************************************************************\n");
        jTextArea1.setText(jTextArea1.getText() + "**                                         The Smart School Sukkur                             **\n");
        jTextArea1.setText(jTextArea1.getText() + "**                                           Monthly Fees Receipt                                         **\n");
        jTextArea1.setText(jTextArea1.getText() + "*******************************************************************************\n");

        jTextArea1.setText(jTextArea1.getText() + "                                                                                                 Date : " + s.format(date) + "\n\n\n\n");

        jTextArea1.setText(jTextArea1.getText() + "       Name                                                                " + name.getText() + "\n\n");
        jTextArea1.setText(jTextArea1.getText() + "       Father's Name                                                " + fname.getText() + "\n\n");
        jTextArea1.setText(jTextArea1.getText() + "       Surname                                                          " + srname.getText() + "\n\n");
        jTextArea1.setText(jTextArea1.getText() + "       Class                                                                " + clss.getText() + "\n\n");

        jTextArea1.setText(jTextArea1.getText() + "      OutstandingFees                                               " + rfees.getText() + "\n\n");
        jTextArea1.setText(jTextArea1.getText() + "       Given Amount                                                   " + am.getText() + "\n\n");
        jTextArea1.setText(jTextArea1.getText() + "     \n\n\n\n\n");
//        
        jTextArea1.setText(jTextArea1.getText() + "                                                                                                      Signature");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(293, 23, 595, 55);
        jLabel1.setBackground(new Color(0, 255, 127));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(139, 140, 49, 17);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(139, 190, 51, 17);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(139, 246, 107, 17);
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBounds(139, 296, 75, 17);
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBounds(139, 354, 75, 17);
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setBounds(139, 410, 119, 17);
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setBounds(139, 465, 88, 17);
        name = new javax.swing.JTextField();
        name.setBounds(296, 185, 184, 29);
        fname = new javax.swing.JTextField();
        fname.setBounds(296, 241, 184, 29);
        srname = new javax.swing.JTextField();
        srname.setBounds(296, 291, 184, 29);
        clss = new javax.swing.JTextField();
        clss.setBounds(296, 349, 184, 29);
        rfees = new javax.swing.JTextField();
        rfees.setBounds(296, 405, 184, 29);
        am = new javax.swing.JTextField();
        am.setBounds(296, 460, 184, 29);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(539, 136, 407, 382);
        jButton2 = new javax.swing.JButton();
        jButton2.setBounds(177, 528, 89, 32);
        idd = new javax.swing.JTextField();
        idd.setBounds(296, 135, 184, 29);
        jButton6 = new javax.swing.JButton();
        jButton6.setBounds(322, 528, 89, 32);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(10, 11, 24, 24);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fees Management System");
        setResizable(false);

        jPanel1.setBackground(new Color(0, 255, 153));

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30)); // NOI18N
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fees Management System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Roll No");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fathers's Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Surname");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Class");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Outstandingfees");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Amount");

        name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name.setText(" ");

        fname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fname.setText(" ");

        srname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        srname.setText(" ");

        clss.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clss.setText(" ");

        rfees.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rfees.setText(" ");
        rfees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rfeesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rfeesKeyTyped(evt);
            }
        });

        am.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        am.setText(" ");
        am.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amKeyTyped(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        idd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idd.setText(" ");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Slip");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project1/back.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 978, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (idd.getText().equals("") || name.getText().equals("") || fname.getText().equals("") || srname.getText().equals("") || clss.getText().equals("") || rfees.getText().equals("") || am.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Alll Fields are required ");
        } else {
            design();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        idd.setText("");
        name.setText("");
        fname.setText("");
        srname.setText("");
        clss.setText("");
        rfees.setText("");
        am.setText("");
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rfeesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfeesKeyPressed
         char ch = evt.getKeyChar();
        if (!(Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_rfeesKeyPressed

    private void amKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amKeyPressed
         char ch = evt.getKeyChar();
        if (!(Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_amKeyPressed

    private void rfeesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfeesKeyTyped
        char ch = evt.getKeyChar();
        if (!(Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_rfeesKeyTyped

    private void amKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amKeyTyped
       char ch = evt.getKeyChar();
        if (!(Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_amKeyTyped

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.hide();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
           ( new fees()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField am;
    private javax.swing.JTextField clss;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField idd;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField rfees;
    private javax.swing.JTextField srname;
}
