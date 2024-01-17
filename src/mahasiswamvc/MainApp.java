import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaModel mahasiswaModel = new MahasiswaModel();
            MahasiswaViewUI mahasiswaView = new MahasiswaViewUI();
            MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaModel, mahasiswaView);

            // Menampilkan UI
            JFrame frame = new JFrame("Aplikasi Mahasiswa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(mahasiswaView);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Update tampilan
            mahasiswaController.updateView();

            // Ingat untuk menutup koneksi setelah selesai menggunakan model
            mahasiswaModel.closeConnection();
        });
    }
}
