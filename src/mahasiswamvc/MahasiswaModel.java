import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaModel {
    private Connection connection;

    // Konstruktor untuk inisialisasi koneksi ke database
    public MahasiswaModel() {
        try {
            // Ganti parameter koneksi (url, username, password) sesuai dengan konfigurasi MySQL Anda
            String url = "jdbc:mysql://localhost:3306/pbo";
            String username = "root";
            String password = "";

            // Membuat koneksi
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menutup koneksi ke database
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk mendapatkan semua data mahasiswa dari database
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();

        try {
            String query = "SELECT * FROM mahasiswa";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String nim = resultSet.getString("nim");

                Mahasiswa mahasiswa = new Mahasiswa(id, nama, nim);
                mahasiswaList.add(mahasiswa);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mahasiswaList;
    }

    // Metode untuk menambahkan mahasiswa ke database
    public void addMahasiswa(Mahasiswa mahasiswa) {
        try {
            String query = "INSERT INTO mahasiswa (id, nama, nim) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, mahasiswa.getId());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mahasiswa.getNim());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode CRUD lainnya sesuai kebutuhan
}
