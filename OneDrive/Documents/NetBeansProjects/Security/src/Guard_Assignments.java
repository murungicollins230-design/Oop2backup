import java.sql.*;
import javax.swing.*;
import security.DatabaseConnection;

public class Guard_Assignments extends javax.swing.JFrame {
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public Guard_Assignments() {
        initComponents();
        setTitle("Guard Assignments");
        setLocationRelativeTo(null);
        con = DatabaseConnection.getConnection();
        loadGuards();
        loadSite();
        loadAssignment();
        clearFields();
    }
    private void loadAssignment(){
        try{
            if(rs!=null){
                rs.close();
            }
            if(st!=null){
                st.close();
            }
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("Select*FROM guard_assignments");
            
            if(rs.next()){
                displayResults();
            }
            else{
                System.out.println("EMpty!");
            }
            
        }catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    private void displayResults(){
        try{
        Assignment.setText(String.valueOf(rs.getString("assignment_id")));
        java.sql.Date sqlDate=rs.getDate("assignment_date");
        if(sqlDate != null){
            Start.setDate(sqlDate.toLocalDate());
        }
        java.sql.Date sqlDate1=rs.getDate("end_date");
        if(sqlDate1 != null){
            End.setDate(sqlDate1.toLocalDate());
        }
        Position.setSelectedItem(rs.getString("position"));
        Status.setSelectedItem(rs.getString("status"));
        cmbGuard.setSelectedItem(String.valueOf(rs.getString("idGUARDS")));
        cmbSite.setSelectedItem(String.valueOf(rs.getString("site_id")));
        } catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    private void loadGuards(){
        try{
           
            st= con.createStatement();
            rs=st.executeQuery("Select idGUARDS from guards");
            cmbGuard.removeAllItems();
            while(rs.next()){
                cmbGuard.addItem(String.valueOf(rs.getString("idGUARDS")));
            }
        }catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
        
    }
    private void loadSite(){
        try{
           
            st= con.createStatement();
            rs=st.executeQuery("Select site_id from security_sites");
            cmbSite.removeAllItems();
            while(rs.next()){
                cmbSite.addItem(String.valueOf(rs.getString("site_id")));
            }
        }catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Assignment = new javax.swing.JTextField();
        End = new com.github.lgooddatepicker.components.DatePicker();
        Start = new com.github.lgooddatepicker.components.DatePicker();
        Position = new javax.swing.JComboBox<>();
        Status = new javax.swing.JComboBox<>();
        cmbGuard = new javax.swing.JComboBox<>();
        cmbSite = new javax.swing.JComboBox<>();
        saveb = new javax.swing.JButton();
        deleteb = new javax.swing.JButton();
        Exitb = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Assignment ID");

        jLabel2.setText("Assignment Date");

        jLabel3.setText("End Date");

        jLabel4.setText("Position");

        jLabel5.setText("Status");

        jLabel6.setText("Guard ID");

        jLabel7.setText("Site ID");

        Position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "Leader", "Guard", "Supervisor" }));

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "Start", "Running", "End" }));

        cmbGuard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbSite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        saveb.setText("Save");
        saveb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebActionPerformed(evt);
            }
        });

        deleteb.setText("Delete");
        deleteb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebActionPerformed(evt);
            }
        });

        Exitb.setText("Exit");
        Exitb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Assignment, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(End, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Position, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGuard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Exitb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFirst))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLast)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFind))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton8)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Assignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbGuard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveb)
                    .addComponent(deleteb)
                    .addComponent(Exitb)
                    .addComponent(btnFirst))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnFind))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebActionPerformed
        try{
            if(Assignment.getText().trim().isEmpty()||Start.getDate()==null||End.getDate()==null){
                JOptionPane.showMessageDialog(this,"Fill All fields");
                return;
            }
            if(Position.getSelectedItem()==null|| Status.getSelectedItem()==null||
                cmbGuard.getSelectedItem()==null||cmbSite.getSelectedItem()==null){
                JOptionPane.showMessageDialog(this,"Combobox is empty");
                return;
            }

            String query ="INSERT INTO guard_assignments(assignment_id,assignment_date,end_date,position,"
            + "status,idGUARDS,site_id)VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(Assignment.getText()));
            java.time.LocalDate id =Start.getDate();
            ps.setDate(2, java.sql.Date.valueOf(id));
            java.time.LocalDate id1 =End.getDate();
            ps.setDate(3, java.sql.Date.valueOf(id1));
            ps.setString(4, Position.getSelectedItem().toString());
            ps.setString(5,Status.getSelectedItem().toString());
            ps.setInt(6, Integer.parseInt(cmbGuard.getSelectedItem().toString()));
            ps.setInt(7, Integer.parseInt(cmbSite.getSelectedItem().toString()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Saved");
            loadAssignment();
            clearFields();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error saving :"+e.getMessage());
        }
    }//GEN-LAST:event_savebActionPerformed
    private void clearFields(){
        Assignment.setText("");
        Start.clear();
        End.clear();
        Status.setSelectedIndex(0);
        Position.setSelectedIndex(0);
    }
    private void deletebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebActionPerformed
        String id = Assignment.getText().trim();
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this,"Not found");
            return;
        }
        int d =Integer.parseInt(id);

        String query = "DELETE FROM guard_assignments WHERE assignment_id =?";
        try{
            PreparedStatement statement  = con.prepareStatement(query);
            statement.setInt(1, d);
            int result = statement.executeUpdate();
            if(result>0){
                JOptionPane.showMessageDialog(this,"Deleted successfully");

            }else{
                JOptionPane.showMessageDialog(this,"Not found");
            }

            clearFields();
            loadAssignment();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this,"Error deleting "+e.getMessage());
        }
    }//GEN-LAST:event_deletebActionPerformed
    
    private void ExitbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbActionPerformed
        try{
            if(rs !=null){
                rs.close();
            }
            if(st !=null){
                st.close();
            }
            if(con !=null){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_ExitbActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try{
            if(rs != null && rs.first()){
                loadAssignment();
            }else{
                JOptionPane.showMessageDialog(
                    this,"None found");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error:"+ e.getMessage());
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try{
            if(rs !=null && rs.last()){
                displayResults();
            }else{
                JOptionPane.showMessageDialog(this,"None found");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error:"+e.getMessage());
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try{
            if(rs !=null){
                if(rs.next()){
                    displayResults();
                }else{
                    rs.last();
                    JOptionPane.showMessageDialog(this,"You are already at the last ");
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error:"+e.getMessage());
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        try{
            if(rs !=null){
                if(rs.previous()){
                    displayResults();
                }else{
                    rs.first();
                    JOptionPane.showMessageDialog(this,"You are already at the first");
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error:"+e.getMessage());
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String regNo = JOptionPane.showInputDialog(this,"Enter the ID");
        if(regNo ==null||regNo.trim().isEmpty()){
            return;
        }
        regNo = regNo.trim();

        try {
            if(rs.next()){
                displayResults();
            }else{
                JOptionPane.showMessageDialog(this,"Not found");
                loadAssignment();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error :"+ e.getMessage());
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Staff.Staff();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void Assignment() {
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
            java.util.logging.Logger.getLogger(Guard_Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guard_Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guard_Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guard_Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guard_Assignments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Assignment;
    private com.github.lgooddatepicker.components.DatePicker End;
    private javax.swing.JButton Exitb;
    private javax.swing.JComboBox<String> Position;
    private com.github.lgooddatepicker.components.DatePicker Start;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox<String> cmbGuard;
    private javax.swing.JComboBox<String> cmbSite;
    private javax.swing.JButton deleteb;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton saveb;
    // End of variables declaration//GEN-END:variables
}
