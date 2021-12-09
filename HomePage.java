package project1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Muskaan\\Pictures\\FS.png"));
        setUI();
        initComponents();
        jTable1.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 14));
        
        //setColumn();
        //getData();
//        initComponents();
    }
    static ArrayList<data> list = new ArrayList<data>();
    private javax.swing.JTable jTable1;
    
    public DefaultTableModel buildTableModel() throws SQLException {
    	Vector<String> columnNames = null;   Vector<Vector<Object>> data = null;
    try {
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://StudentDB.accdb");
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("Select * from Table1;");  	
		//jTable1 = new JTable();
		//jTable1.setModel(buildTableModel(rs));

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        /*Vector<Vector<Object>>*/ data = new Vector<Vector<Object>>();
        while (rs.next()) {
         Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector); }
		
	}
	catch(ClassNotFoundException cnf) {
		cnf.printStackTrace();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
    return new DefaultTableModel(data, columnNames);
     
    }
    
    
     private void setUI() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

                if ("".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
    catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {System.out.println("Exception occur");    }
    }

    /*private void setColumn() {
    	TableColumnModel h = jTable1.getColumnModel();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setFont(new Font("Tahoma", Font.BOLD, 12));
        h.getColumn(0).setPreferredWidth(100);
        h.getColumn(1).setPreferredWidth(300);
        jTable1.setRowSelectionAllowed(true);
        h.getColumn(2).setPreferredWidth(300);
        h.getColumn(3).setPreferredWidth(150);
        h.getColumn(4).setPreferredWidth(350);
        h.getColumn(5).setPreferredWidth(150);
        h.getColumn(6).setPreferredWidth(100);
        h.getColumn(7).setPreferredWidth(100);
       // h.getColumn(8).setPreferredWidth(200);

        jTable1.setRowHeight(30);
    }*/

    /*private void getData() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Object rowData[] = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).id;
            rowData[1] = list.get(i).name;
            rowData[2] = list.get(i).fname;
            rowData[3] = list.get(i).srname;
            rowData[4] = list.get(i).dat;
            rowData[5] = list.get(i).add;
            rowData[6] = list.get(i).cls;
            rowData[7] = list.get(i).rel;
            model.addRow(rowData);
        }

        jTable1.setModel(model);

    }*/
    public class JPanelWithBackground extends JPanel
 {

    	  private Image backgroundImage;

    	  // Some code to initialize the background image.
    	  // Here, we use the constructor to load the image. This
    	  // can vary depending on the use case of the panel.
    	  public JPanelWithBackground(String fileName) throws IOException {
    	    backgroundImage = ImageIO.read(new File(fileName));
    	  }

    	  public void paintComponent(Graphics g) {
    	    super.paintComponent(g);

    	    // Draw the background image.
    	    g.drawImage(backgroundImage, 0, 0, this);
    	  }
    	}
   // JFrame f = new JFrame();
  // f.getContentPane().add(new JPanelWithBackground("sample.jpeg"));
    
    
    
    
    
    private void exportData() throws IOException {
        JFileChooser f = new JFileChooser();
//        f.showOpenDialog(this);
        f.showSaveDialog(this);
        String path = null;
        try {
            File file = f.getSelectedFile();
            path = file.getAbsolutePath();
//            path = path.replace("\\", "/");
//            System.out.println(path);

            TableModel model = jTable1.getModel();
            FileWriter out = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(out);
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write(model.getColumnName(i) + "\t");
            }
            bw.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j).toString() + "\t");
                }
                bw.write("\n");
            }
            bw.close();
            JOptionPane.showMessageDialog(this, "Data Exported to " + path + " Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new ImageIcon("C:\\Users\\Muskaan\\Pictures\\Stu1.png"));
        jLabel1.setBackground(Color.LIGHT_GRAY);
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Screen");
        setResizable(false);

        jPanel1.setBackground(new Color(0, 255, 153));

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 45)); // NOI18N
        jLabel1.setForeground(Color.DARK_GRAY);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Management System");

        jPanel3.setBackground(new Color(0, 255, 153));

        /*jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No", "Name", "Father's Name   ", "Surnamme", "Address", "Class", "Religion", "Paid Fees", "outstandingfees"
            }
        ));*/
        try {
			jTable1.setModel(buildTableModel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while populating table");
		}
          
        
        
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Search");
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton1.setIcon(new ImageIcon("C:\\Users\\Muskaan\\Pictures\\addS.png"));
        jButton2 = new javax.swing.JButton();
        jButton2.setIcon(new ImageIcon("C:\\Users\\Muskaan\\Pictures\\deleteS.png"));
        jButton3 = new javax.swing.JButton();
        jButton3.setIcon(new ImageIcon("C:\\Users\\Muskaan\\Pictures\\FeesS1.png"));
        jButton5 = new javax.swing.JButton();
        jButton5.setIcon(new ImageIcon("C:\\Users\\Muskaan\\Pictures\\ExitS.png"));
        
                jPanel2.setBackground(new Color(0, 255, 153));
                
                        jButton1.setBackground(Color.WHITE);
                        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                        jButton1.setText("Add Student");
                        jButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                               Dispose();
                            }
                        });
                        
                                jButton2.setBackground(new java.awt.Color(255, 255, 255));
                                jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                                jButton2.setText("Delete Student");
                                jButton2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton2ActionPerformed(evt);
                                    }
                                });
                                
                                        jButton3.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                                        jButton3.setText("Fees Management");
                                        jButton3.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            	//System.out.println(evt.getActionCommand());
                                                jButton3ActionPerformed(evt);
                                            }
                                        });
                                        
                                                jButton5.setBackground(new java.awt.Color(255, 255, 255));
                                                jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                                                jButton5.setText("Exit");
                                                jButton5.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        jButton5ActionPerformed(evt);
                                                    }
                                                });
                                                
                                                        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                                                        jPanel2Layout.setHorizontalGroup(
                                                        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        		.addGroup(jPanel2Layout.createSequentialGroup()
                                                        			.addGap(35)
                                                        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                                                        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                                                        				.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                                                        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
                                                        			.addContainerGap(54, Short.MAX_VALUE))
                                                        );
                                                        jPanel2Layout.setVerticalGroup(
                                                        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        		.addGroup(jPanel2Layout.createSequentialGroup()
                                                        			.addGap(26)
                                                        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        			.addGap(41)
                                                        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        			.addGap(37)
                                                        			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        			.addGap(37)
                                                        			.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        			.addContainerGap(62, Short.MAX_VALUE))
                                                        );
                                                        jPanel2.setLayout(jPanel2Layout);
        
        label = new JLabel("Developed by Muskan(19SW54)");
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(70)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
        			.addGap(112)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 745, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(label, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(1025, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(200, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        					.addGap(18))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE)
        					.addGap(117)))
        			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
        			.addGap(52))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(150)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(30)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(jPanel3, 0, 0, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1349, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(167, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

       pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // this.dispose();
        (new add_Student()).setVisible(true);
        
    }
    
     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        (new fees()).setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int se = jTable1.getSelectedRow();
        
        if (se >-1){
        model.removeRow(se);
        JOptionPane.showMessageDialog(this, "Deleted Successfully");
        }else{
        JOptionPane.showMessageDialog(this, "Please Select a Single Record Form Table");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) jTable1.getModel())); 
    sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));

    jTable1.setRowSorter(sorter);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      int x = JOptionPane.showConfirmDialog(this, "Do You Want to Exit ", "Message", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {

            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() ->{
            (new HomePage()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    
    private javax.swing.JTextField jTextField1;
    private JLabel label;


	public void Dispose() {
		this.dispose();
	}
class data {

    String id, name, fname, srname, add, cls, rel, dat;

    public data(String id, String name, String fname, String srname, String dat, String add, String cls, String rel) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.srname = srname;
        this.dat = dat;
        this.add = add;
        this.cls = cls;
        this.rel = rel;

    }
}
}
   



