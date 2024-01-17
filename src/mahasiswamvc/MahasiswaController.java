import java.util.List;

public class MahasiswaController {
    private MahasiswaModel mahasiswaModel;
    private MahasiswaViewUI mahasiswaView;

    public MahasiswaController(MahasiswaModel mahasiswaModel, MahasiswaViewUI mahasiswaView) {
        this.mahasiswaModel = mahasiswaModel;
        this.mahasiswaView = mahasiswaView;
    }

    public void updateView() {
        List<Mahasiswa> mahasiswaList = mahasiswaModel.getAllMahasiswa();
        mahasiswaView.updateTable(mahasiswaList);
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaModel.addMahasiswa(mahasiswa);
        updateView();
    }
}
