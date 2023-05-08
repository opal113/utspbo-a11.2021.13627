public class MahasiswaBaru extends Mahasiswa {
    String asalSekolah;

    public boolean ikutOspek() {
        if (semester == 1) {
            System.out.println("Harus Mengikuti Ospek, Karena Baru Semester 1");
            return true;
        } else {
            System.out.println("Tidak mengikuti Ospek, Karena di Atas Semester 1");
            return false;
        }
    }

    @Override
    public void infoMahasiswa() {
        System.out.println("Input Asal Sekolah :" + this.asalSekolah);
        super.infoMahasiswa();
    }
}
