import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MahasiswaView extends JFrame {
    private JTable mahasiswaTable;
    private DefaultTableModel tableModel;

    public MahasiswaView() {
        // Inisialisasi frame
        setTitle("Daftar Mahasiswa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi tabel
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama");
        tableModel.addColumn("NIM");

        mahasiswaTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(mahasiswaTable);

        // Menambahkan tabel ke frame
        add(scrollPane, BorderLayout.CENTER);
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

    // Metode lain untuk menangani elemen UI lainnya
    // ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaView mahasiswaView = new MahasiswaView();
            mahasiswaView.setVisible(true);

            // Contoh penggunaan untuk mengupdate tabel dengan data mahasiswa
            MahasiswaModel mahasiswaModel = new MahasiswaModel();
            List<Mahasiswa> mahasiswaList = mahasiswaModel.getAllMahasiswa();
            mahasiswaView.updateTable(mahasiswaList);

            // Ingat untuk menutup koneksi setelah selesai menggunakan model
            mahasiswaModel.closeConnection();
        });
    }
}
