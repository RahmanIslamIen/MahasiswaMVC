
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MahasiswaViewUI extends javax.swing.JPanel {
    private JTable mahasiswaTable;
    private DefaultTableModel tableModel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField nimField;

    public MahasiswaViewUI() {
        initComponents();
        initTable();
        initForm();
    }

    private void initTable() {
        // Inisialisasi DefaultTableModel dengan kolom-kolom yang dibutuhkan
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama");
        tableModel.addColumn("NIM");

        // Inisialisasi JTable dengan DefaultTableModel
        mahasiswaTable = new JTable(tableModel);

        // Tambahkan JTable ke JScrollPane agar bisa di-scroll jika banyak data
        JScrollPane scrollPane = new JScrollPane(mahasiswaTable);

        // Set tata letak panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initForm() {
        // Label dan field untuk input data mahasiswa
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(5);

        JLabel namaLabel = new JLabel("Nama:");
        namaField = new JTextField(20);

        JLabel nimLabel = new JLabel("NIM:");
        nimField = new JTextField(10);

        // Tombol untuk menambahkan mahasiswa
        JButton addButton = new JButton("Tambah Mahasiswa");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMahasiswa();
            }
        });

        // Panel untuk menempatkan label, field, dan tombol
        JPanel formPanel = new JPanel(new FlowLayout());
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(namaLabel);
        formPanel.add(namaField);
        formPanel.add(nimLabel);
        formPanel.add(nimField);
        formPanel.add(addButton);

        // Tambahkan formPanel ke bagian bawah panel utama
        add(formPanel, BorderLayout.SOUTH);
    }

    private void addMahasiswa() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nama = namaField.getText();
            String nim = nimField.getText();

            MahasiswaController mahasiswaController = new MahasiswaController(new MahasiswaModel(), this);
            Mahasiswa newMahasiswa = new Mahasiswa(id, nama, nim);
            mahasiswaController.addMahasiswa(newMahasiswa);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode untuk memperbarui tabel dengan data mahasiswa baru
    public void updateTable(List<Mahasiswa> mahasiswaList) {
        // Menghapus semua baris yang ada di tabel
        tableModel.setRowCount(0);

        // Menambahkan data mahasiswa ke tabel
        for (Mahasiswa mahasiswa : mahasiswaList) {
            Object[] rowData = {mahasiswa.getId(), mahasiswa.getNama(), mahasiswa.getNim()};
            tableModel.addRow(rowData);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
