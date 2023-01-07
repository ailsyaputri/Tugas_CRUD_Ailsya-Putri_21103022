/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudmahasiswasederhana.view;

import com.mycompany.crudmahasiswasederhana.Controller.MahasiswaController;
import com.mycompany.crudmahasiswasederhana.Interface.MahasiswaInterface;
import com.mycompany.crudmahasiswasederhana.models.Mahasiswa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author ASUS
 * Ailsya Putri / 21103022
 */

public class MahasiswaFrame extends javax.swing.JFrame {
    List<Mahasiswa> record=new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;
    
    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrame() {
        initComponents();
        nimValidasiLabel.setVisible(false);
        namaValidasiLabel.setVisible(false);
        alamatValidasiLabel.setVisible(false);
        mhsServis = new MahasiswaController();
        
        MahasiswaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                row = MahasiswaTable.getSelectedRow();
                if(row!=-1){
                    isiText();
                }
            }
        });
        this.statusAwal(); 
    }
    
    void loadData(){
        try{
            record = mhsServis.getAll();
        }catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void isiTabel(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(Mahasiswa mhs:record){
            data[x][0]=mhs.getNim();
            data[x][1]=mhs.getNama();
            data[x][2]=mhs.getAlamat();
            x++;
        }
        String judul[]={"nim","nama","alamat"};
        MahasiswaTable.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(MahasiswaTable);
    } 
    
    void isiText(){
        Mahasiswa mhs = record.get(row);
        nimText.setText(mhs.getNim());
        namaText.setText(mhs.getNama());
        nimText.setText(mhs.getNim());
        alamatText.setText(mhs.getAlamat());
    }
    
    void kosongkanText(){
        nimText.setText("");
        namaText.setText("");
        alamatText.setText(""); 
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    void validasiInput(Mahasiswa o){
        if(nimText.getText().equals("")){
            nimValidasiLabel.setText("NIM belum diisi");
            nimValidasiLabel.setVisible(true);
        }else if(!nimText.getText().matches("[0-9]*")){
            nimValidasiLabel.setText("NIM harus berisi angka");
            nimValidasiLabel.setVisible(true);
        }else if(nimText.getText().length() < 5){
            nimValidasiLabel.setText("NIM minimal berisi 5 angka");
            nimValidasiLabel.setVisible(true);
        }else if(nimText.getText().length() > 12){
            nimValidasiLabel.setText("NIM maksimal berisi 12 angka");
            nimValidasiLabel.setVisible(true);
        }else{
            o.setNim(nimText.getText());
            nimValidasiLabel.setVisible(false);
        }
        
        if(namaText.getText().equals("")){
            namaValidasiLabel.setText("Nama belum diisi");
            namaValidasiLabel.setVisible(true);
        }else{
            o.setNama(namaText.getText());
            namaValidasiLabel.setVisible(false);
        }
        if(alamatText.getText().equals("")){
            alamatValidasiLabel.setText("Alamat belum diisi");
            alamatValidasiLabel.setVisible(true);
        }else{
            o.setAlamat(alamatText.getText());
            alamatValidasiLabel.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        nimLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        alamatLabel = new javax.swing.JLabel();
        alamatText = new javax.swing.JTextField();
        nimText = new javax.swing.JTextField();
        namaText = new javax.swing.JTextField();
        TambahBtn = new javax.swing.JButton();
        UbahBtn = new javax.swing.JButton();
        HapusBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MahasiswaTable = new javax.swing.JTable();
        nimValidasiLabel = new javax.swing.JLabel();
        namaValidasiLabel = new javax.swing.JLabel();
        alamatValidasiLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nimLabel.setText("NIM");

        namaLabel.setText("Nama");

        alamatLabel.setText("Alamat");

        alamatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatTextActionPerformed(evt);
            }
        });

        nimText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextActionPerformed(evt);
            }
        });

        namaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextActionPerformed(evt);
            }
        });

        TambahBtn.setText("Tambah");
        TambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahBtnActionPerformed(evt);
            }
        });

        UbahBtn.setText("Ubah");
        UbahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahBtnActionPerformed(evt);
            }
        });

        HapusBtn.setText("Hapus");
        HapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBtnActionPerformed(evt);
            }
        });

        MahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title1", "Title2", "Title3"
            }
        ));
        jScrollPane1.setViewportView(MahasiswaTable);

        nimValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        nimValidasiLabel.setText("jLabel1");

        namaValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        namaValidasiLabel.setText("jLabel2");

        alamatValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        alamatValidasiLabel.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaLabel)
                            .addComponent(nimLabel)
                            .addComponent(alamatLabel))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nimText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nimValidasiLabel)
                            .addComponent(namaValidasiLabel)
                            .addComponent(alamatValidasiLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HapusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UbahBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TambahBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahBtn)
                    .addComponent(nimLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nimValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UbahBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaValidasiLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HapusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alamatLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alamatValidasiLabel)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alamatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatTextActionPerformed
          // TODO add your handlings code here
    }//GEN-LAST:event_alamatTextActionPerformed

    private void nimTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextActionPerformed
          // TODO add your handlings code here
    }//GEN-LAST:event_nimTextActionPerformed

    private void namaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTextActionPerformed

    private void TambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahBtnActionPerformed
        try{
          // TODO add your handlings code here
            Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            mhsServis.insert(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Tersimpan"); 
       }catch (SQLException ex){
           JOptionPane.showMessageDialog(this, "Data Tidak Berhasil Tersimpan");
           Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_TambahBtnActionPerformed

    private void UbahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahBtnActionPerformed
        try{
          // TODO add your handlings code here
            Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah"); 
       }catch (SQLException ex){
           JOptionPane.showMessageDialog(this, "Data Tidak Berhasil Diubah");
           Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_UbahBtnActionPerformed

    private void HapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBtnActionPerformed
        try{
            String nim = nimText.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        }catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HapusBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HapusBtn;
    private javax.swing.JTable MahasiswaTable;
    private javax.swing.JButton TambahBtn;
    private javax.swing.JButton UbahBtn;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JTextField alamatText;
    private javax.swing.JLabel alamatValidasiLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField namaText;
    private javax.swing.JLabel namaValidasiLabel;
    private javax.swing.JLabel nimLabel;
    private javax.swing.JTextField nimText;
    private javax.swing.JLabel nimValidasiLabel;
    // End of variables declaration//GEN-END:variables
    
    }
