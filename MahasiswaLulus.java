public class MahasiswaLulus extends Mahasiswa {
    int tahunMasuk;
    float ipk;

    public boolean ikutWisuda(){
        if(tahunMasuk > 2018 && tahunMasuk <= 2020){
            System.out.println("Mahasiswa Sudah lulus");
            return true;   
        }else {
            System.out.println("Mahasiswa Belum Lulus, karena perkiraan untuk lulus tahun masuk dibawah 2021");
            return false;
        }
    }

    @Override
    public void infoMahasiswa() {
        if(ikutWisuda()== true){
            int temp = loop * 4;
            this.ipk = (super.totalIPK / temp) + 2;
            System.out.println("Sudah Lulus dengan IPK " + ipk);
            super.infoMahasiswa();
        }
    }
}
