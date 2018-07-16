/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapbo;

import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.TAPBO;
import static main.TAPBO.con;
import static main.TAPBO.pst;
import static main.TAPBO.rs;
import model.MechanicDAO;
import model.Mechanic;

/**
 *
 * @author ALOLA
 */
public class Mekanik extends javax.swing.JInternalFrame {

    static Mekanik instance = null;
    MechanicDAO mechaDao;

    /**
     * Creates new form Mekanik
     */
    public static Mekanik getInstance() {
        if (instance == null) {
            instance = new Mekanik();
        }
        return instance;
    }

    public Mekanik() {
        initComponents();
        male.setActionCommand("Laki-Laki");
        female.setActionCommand("Perempuan");
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(male);
        buttonGroup1.add(female);
        daftar();
    }

    private void empty() {
        fieldNom.setText("");
        fieldNamam.setText("");
        fieldNoTelp.setText("");
        male.setSelected(false);
        female.setSelected(false);
        fieldAlamat.setText("");
        String kolom[] = {"NIP", "Nama", "No Telp", "Jenis Kelamin", "Alamat"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
    }

    public void daftar() {
        String kolom[] = {"NIP", "Nama", "No Telp", "Jenis Kelamin", "Alamat"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            String sql = "select * from mekanik";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String no_mekanik = rs.getString(1);
                String nama = rs.getString(2);
                String telepon = rs.getString(3);
                String jk = rs.getString(4);
                String alamat = rs.getString(5);
                String data[] = {no_mekanik, nama, telepon, jk, alamat};
                dtm.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        mechaTabel.setModel(dtm);
    }

    private boolean Validasi() {
        boolean Valid = true;
        String Pesan = "Silahkan Cek Kembali Pengisian Data";

        if (fieldNom.getText().equals("")) {
            Pesan += "\nSilahkan Isi No Mekanik";
            Valid = false;
        }
        if (fieldNamam.getText().equals("")) {
            Pesan += "\nSilahkan Isi Nama";
            Valid = false;
        }
        if (fieldNoTelp.getText().equals("")) {
            Pesan += "\nSilahkan Isi Nomor Telepon";
            Valid = false;
        }
        if (fieldAlamat.getText().equals("")) {
            Pesan += "\nSilahkan Isi Alamat";
            Valid = false;
        }
        if (!Valid) {
            JOptionPane.showMessageDialog(this, Pesan, "Error Form", JOptionPane.ERROR_MESSAGE);
        }

        return Valid;
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
        input = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldNom = new javax.swing.JTextField();
        fieldNamam = new javax.swing.JTextField();
        fieldNoTelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldAlamat = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        button = new javax.swing.JPanel();
        insert = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mechaTabel = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(933, 400));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("NIP");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("NAMA");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("NO.TELP");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("ALAMAT");

        fieldNom.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        fieldNamam.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        fieldNoTelp.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        fieldAlamat.setColumns(20);
        fieldAlamat.setRows(5);
        jScrollPane1.setViewportView(fieldAlamat);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("JK");

        insert.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        insert.setText("Tambah");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancel.setText("Batal");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        delete.setText("Hapus");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(button);
        button.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
                .addComponent(insert, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        buttonLayout.setVerticalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(cancel))
        );

        male.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        male.setText("Laki-Laki");

        female.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        female.setText("Perempuan");

        mechaTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIP", "Nama", "No Telp", "Jenis Kelamin", "Alamat"
            }
        ));
        mechaTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mechaTabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mechaTabel);

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setText("Tutup");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNamam)
                                    .addComponent(fieldNom))
                                .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(male)
                                .addGap(18, 18, 18)
                                .addComponent(female))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNamam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(male)
                            .addComponent(female))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String gender = buttonGroup1.getSelection().getActionCommand();
        if (Validasi()) {
            mechaDao = new MechanicDAO();
            Mechanic mechanic = new Mechanic();
            mechanic.setNom(Integer.valueOf(fieldNom.getText()));
            mechanic.setNama(fieldNamam.getText());
            mechanic.setNotelp(fieldNoTelp.getText());
            mechanic.setGender(gender);
            mechanic.setAlamat(fieldAlamat.getText());

            if (mechanic != null) {
                try {
                    mechaDao.insert(mechanic);
                    daftar();
                    JOptionPane.showMessageDialog(this, "Data telah berhasil disimpan.", "Simpan Data", JOptionPane.INFORMATION_MESSAGE);
                    empty();
                } catch (SQLException ex) {
//                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Data Sudah Ada");
                    empty();
                }
            }
        }
    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
//        String gender = buttonGroup1.getSelection().getActionCommand();
        mechaDao = new MechanicDAO();
        Mechanic mechanic = new Mechanic();
        mechanic.setNom(Integer.valueOf(fieldNom.getText()));
        mechanic.setNama(fieldNamam.getText());
        mechanic.setNotelp(fieldNoTelp.getText());
//        mechanic.setGender(gender);
        mechanic.setAlamat(fieldAlamat.getText());

        if (mechanic != null) {
            try {
                mechaDao.delete(mechanic);
                daftar();
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                empty();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "SQL ERROR: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void mechaTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mechaTabelMouseClicked
        fieldNom.setEnabled(false);
        try {
            String kode = mechaTabel.getValueAt(mechaTabel.getSelectedRow(), 0).toString();
            String sql = "SELECT * from mekanik where no_mekanik = '" + kode + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String no_mekanik = rs.getString("no_mekanik");
                fieldNom.setText(no_mekanik);
                String nama = rs.getString("nama");
                fieldNamam.setText(nama);
//                String jk = rs.getString("jk");
//                buttonGroup1.getSelection();
                String telepon = rs.getString("telepon");
                fieldNoTelp.setText(telepon);
                String alamat = rs.getString("alamat");
                fieldAlamat.setText(alamat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_mechaTabelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        fieldNom.setEnabled(true);
        empty();
    }//GEN-LAST:event_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextArea fieldAlamat;
    private javax.swing.JTextField fieldNamam;
    private javax.swing.JTextField fieldNoTelp;
    private javax.swing.JTextField fieldNom;
    private javax.swing.JPanel input;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton male;
    private javax.swing.JTable mechaTabel;
    // End of variables declaration//GEN-END:variables
}
