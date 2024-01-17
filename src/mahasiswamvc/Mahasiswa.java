public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;

    // Constructor
    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk mendapatkan nilai id
    public int getId() {
        return id;
    }

    // Setter untuk mengatur nilai id
    public void setId(int id) {
        this.id = id;
    }

    // Getter untuk mendapatkan nilai nama
    public String getNama() {
        return nama;
    }

    // Setter untuk mengatur nilai nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk mendapatkan nilai nim
    public String getNim() {
        return nim;
    }

    // Setter untuk mengatur nilai nim
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Anda dapat menambahkan metode lain sesuai kebutuhan

    // Contoh metode toString untuk mencetak informasi Mahasiswa
    @Override
    public String toString() {
        return "Mahasiswa [id=" + id + ", nama=" + nama + ", nim=" + nim + "]";
    }
}
