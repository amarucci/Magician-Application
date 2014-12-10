
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*Anthony Marucci*/
public class MagicianApplication extends javax.swing.JFrame {
    /**
     * Creates new form MagicianApplication
     */

    Holiday holiday = new Holiday();
    Waitlist waitlist = new Waitlist();
    Magician magician = new Magician();
    Bookings bookings = new Bookings();
    Customer customer = new Customer();
    
    public MagicianApplication() {
        initComponents();
        updateMagicianComboBoxes();
        updateHolidayComboBoxes();  
        updateCustomerComboBoxes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnBook = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPickHoliday = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMagician = new javax.swing.JTextField();
        btnAddMagician = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbRemoveMagician = new javax.swing.JComboBox();
        btnRemoveMagician = new javax.swing.JButton();
        cmbRemoveHoliday = new javax.swing.JComboBox();
        btnRemoveBooking = new javax.swing.JButton();
        cmbRemoveCustomer = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtHoliday = new javax.swing.JTextField();
        btnAddHoliday = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFilter = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();
        rbtnBookings = new javax.swing.JRadioButton();
        rbtnWaitlist = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jLabel1.setText("Magician Application");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        jLabel7.setText("Booking Information");

        jLabel3.setText("Holiday:");

        jLabel11.setText("Customer: ");

        txtCustomerName.setText("Cutomer Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(118, 118, 118)
                        .addComponent(cmbPickHoliday, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(104, 104, 104)
                        .addComponent(txtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(130, 130, 130))
                            .addComponent(btnBook, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbPickHoliday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Book", jPanel1);

        jLabel6.setText("Add Magician:");

        txtMagician.setText("Name");

        btnAddMagician.setText("Add");
        btnAddMagician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMagicianActionPerformed(evt);
            }
        });

        jLabel8.setText("Remove Magician:");

        btnRemoveMagician.setText("Remove");
        btnRemoveMagician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMagicianActionPerformed(evt);
            }
        });

        btnRemoveBooking.setText("Remove");
        btnRemoveBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveBookingActionPerformed(evt);
            }
        });

        jLabel5.setText("Add holiday:");

        txtHoliday.setText("Holiday");

        btnAddHoliday.setText("Add");
        btnAddHoliday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHolidayActionPerformed(evt);
            }
        });

        jLabel2.setText("Remove Booking:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMagician, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(cmbRemoveMagician, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoliday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoveMagician, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(btnAddMagician, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddHoliday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemoveBooking))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbRemoveHoliday, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRemoveCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMagician, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMagician))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbRemoveMagician, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveMagician))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHoliday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddHoliday))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRemoveHoliday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRemoveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRemoveBooking)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage", jPanel3);

        txtFilter.setText("Filter By Holiday");
        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnBookings);
        rbtnBookings.setText("Bookings");
        rbtnBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnBookingsActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnWaitlist);
        rbtnWaitlist.setText("Waitlist");
        rbtnWaitlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnWaitlistActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Miriam Fixed", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApply))
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnBookings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnWaitlist)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnBookings)
                    .addComponent(rbtnWaitlist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApply)))
        );

        jTabbedPane1.addTab("Status", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        outputTextArea();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnRemoveBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveBookingActionPerformed
        if(JOptionPane.showConfirmDialog(this.rootPane,"Are you sure you want to remove this booking?") == JOptionPane.YES_OPTION){
            //removes from waitlist first because if you delete a booking you want it to 
            //delete all the bookings with that date, but if it deletes bookings first
            //it will put bookings on the waitlist and there is a chance its one you 
            ///wanted to remove. 
            Waitlist.removeWaitlist((String)cmbRemoveCustomer.getSelectedItem(),
                                  (String)cmbRemoveHoliday.getSelectedItem());
            Bookings.removeBooking((String)cmbRemoveCustomer.getSelectedItem(),
                                  (String)cmbRemoveHoliday.getSelectedItem());
        }
    }//GEN-LAST:event_btnRemoveBookingActionPerformed

    private void btnRemoveMagicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMagicianActionPerformed
        if(JOptionPane.showConfirmDialog(this.rootPane,"Are you sure you want to remove this magician?") == JOptionPane.YES_OPTION){
            Magician.removeMagician((String)cmbRemoveMagician.getSelectedItem());
            updateMagicianComboBoxes();
        }
    }//GEN-LAST:event_btnRemoveMagicianActionPerformed

    private void btnAddMagicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMagicianActionPerformed
        Magician.addMagician(txtMagician.getText());
        updateMagicianComboBoxes();
    }//GEN-LAST:event_btnAddMagicianActionPerformed

    private void rbtnWaitlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnWaitlistActionPerformed
        outputTextArea();
    }//GEN-LAST:event_rbtnWaitlistActionPerformed

    private void rbtnBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnBookingsActionPerformed
        outputTextArea();
    }//GEN-LAST:event_rbtnBookingsActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        applyFilter();
    }//GEN-LAST:event_btnApplyActionPerformed

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        applyFilter();
    }//GEN-LAST:event_txtFilterActionPerformed

    //looks at combo boxes to see if they have values before it lets you book
    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        if(!cmbRemoveMagician.isEnabled()){
            JOptionPane.showMessageDialog(this.rootPane,"No Magicians");
        }else if(!cmbPickHoliday.isEnabled()){
            JOptionPane.showMessageDialog(this.rootPane,"No Holidays");
        }else{
            Bookings.addBooking(txtCustomerName.getText(),
                (String)cmbPickHoliday.getSelectedItem());
            updateCustomerComboBoxes();
        }
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnAddHolidayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHolidayActionPerformed
        Holiday.addHoliday(txtHoliday.getText());
        updateHolidayComboBoxes();
    }//GEN-LAST:event_btnAddHolidayActionPerformed
    
    //updates the remove magician combo box
    public void updateMagicianComboBoxes(){
        ResultSet results;
        try {
            results = Magician.getMagicianList();
            cmbRemoveMagician.removeAllItems();
            if (results.next()){//checks if it has any values
                cmbRemoveMagician.setEnabled(true);
                //since theres values in the drop down make the remove button enabled
                btnRemoveMagician.setEnabled(true); 
                cmbRemoveMagician.addItem(results.getString(1));//add the first index of the result set to the combo box
                while(results.next()){//and this will be the second index of the result set
                    cmbRemoveMagician.addItem(results.getString(1));
                }
            }else{
                cmbRemoveMagician.setEnabled(false);
                btnRemoveMagician.setEnabled(false);
                cmbRemoveMagician.addItem("No Magicians");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //update remove customer drop down
    public void updateCustomerComboBoxes(){
        ResultSet results;
        try {
            results = Customer.getCustomers();
            cmbRemoveCustomer.removeAllItems();
            if (results.next()){//checks if it has any values
                cmbRemoveCustomer.setEnabled(true);
                //since theres values in the drop down make the remove button enabled
                btnRemoveBooking.setEnabled(true); 
                cmbRemoveCustomer.addItem(results.getString(1));//add the first index of the result set to the combo box
                while(results.next()){//and this will be the second index of the result set
                    cmbRemoveCustomer.addItem(results.getString(1));
                }
            }else{
                cmbRemoveCustomer.setEnabled(false);
                btnRemoveBooking.setEnabled(false);
                cmbRemoveCustomer.addItem("No Customers");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //update holiday combo box
    //since there are two combo boxes that both display the holidays they will be equal
    public void updateHolidayComboBoxes(){
        ResultSet results;
        try {
            results = Holiday.getHolidays();
            
            cmbPickHoliday.removeAllItems();
            cmbRemoveHoliday.removeAllItems();
            if(results.next()){//checks if it has any values
                cmbPickHoliday.setEnabled(true);
                cmbRemoveHoliday.setEnabled(true);
                //since theres values in the drop down make the remove button enabled
                btnRemoveBooking.setEnabled(true);
                
                cmbPickHoliday.addItem(results.getString(1));//add the first index of the result set to the combo box
                cmbRemoveHoliday.addItem(results.getString(1));
                while(results.next()){//and this will be the second index of the result set
                    cmbPickHoliday.addItem(results.getString(1));
                    cmbRemoveHoliday.addItem(results.getString(1));
                }
            }else{
                cmbPickHoliday.setEnabled(false);
                cmbRemoveHoliday.setEnabled(false);
                btnRemoveBooking.setEnabled(false);
                cmbPickHoliday.addItem("No Holidays");
                cmbRemoveHoliday.addItem("No Holidays");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //applies a filter to the 
    private void applyFilter(){
        if(rbtnBookings.isSelected()){
            outputBookings(Bookings.getBookings(txtFilter.getText()));
        }else if (rbtnWaitlist.isSelected()){
            outputWaitList(Waitlist.getWaitList(txtFilter.getText()));
        }else{
            JOptionPane.showMessageDialog(null, "Nothing selected");
            txtFilter.setText("Filter");
        }
    }
    
    //outputs the bookings info to the text area
    private void outputBookings(ResultSet results){
        String format = "%-12s %-12s %s %n";
        String output = String.format(format,"Magician","Holiday","Customer");
        
        //sets the text field, all pretty and stuff.
        try {
            jTextArea1.setText("No Bookings Found"); //this will be shown if nothing is found in results
            while(results.next()){
                output += String.format(format,results.getString("Magician")
                        , results.getString("Holiday")
                        , results.getString("Customer"));
                jTextArea1.setText(output);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //outputs the waitlist info to the text area
    private void outputWaitList(ResultSet results){
        String format = "%-15s %-12s %s %n";
        String output = String.format(format,"Customer","Holiday","Timestamp");
        
        //sets the text field all pretty and stuff
        try {
            jTextArea1.setText("No Waitlist Found"); //this will be shown if nothing is found in results
            while(results.next()){
                output += String.format(format,results.getString("Customer")
                        , results.getString("Holiday"), results.getTimestamp("Timestamp"));
                jTextArea1.setText(output);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //will check which radio button is selected and then output the information to the text area
    private void outputTextArea() {
        if(rbtnBookings.isSelected()){
            //filter By Holiday is by detault in the text box so if they change it and still want the filter
            if("Filter By Holiday".equals(txtFilter.getText())){
                outputBookings(Bookings.getBookings()); //haven't changed the filter, display all
            }else{
                outputBookings(Bookings.getBookings(txtFilter.getText())); //chagned filter, only show filtered
            }
        } else if(rbtnWaitlist.isSelected()){
            //filter is by detauly in the text box so if they change it and still want the filter
            if("Filter By Holiday".equals(txtFilter.getText())){ 
                outputWaitList(Waitlist.getWaitList());//haven't changed the filter, display all
            }else{
                outputWaitList(Waitlist.getWaitList(txtFilter.getText()));//chagned filter, only show filtered
            }
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MagicianApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MagicianApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MagicianApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MagicianApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MagicianApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHoliday;
    private javax.swing.JButton btnAddMagician;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnRemoveBooking;
    private javax.swing.JButton btnRemoveMagician;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbPickHoliday;
    private javax.swing.JComboBox cmbRemoveCustomer;
    private javax.swing.JComboBox cmbRemoveHoliday;
    private javax.swing.JComboBox cmbRemoveMagician;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rbtnBookings;
    private javax.swing.JRadioButton rbtnWaitlist;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtHoliday;
    private javax.swing.JTextField txtMagician;
    // End of variables declaration//GEN-END:variables

}
