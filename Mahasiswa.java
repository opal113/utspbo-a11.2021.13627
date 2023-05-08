import java.util.Scanner;

public class Mahasiswa {
    Scanner inp = new Scanner(System.in);
    Scanner inpKRS = new Scanner(System.in);
    String nama, nim;
    int semester, usia;
    String[] krs;
    private static final int KRS_MAX = 10;
    float rata, totalIPK;
    int loop;

    public void inputKrs() {
        System.out.println("Input Krs : ");
        this.krs = new String[KRS_MAX];
        for (int i = 0; i < KRS_MAX; i++) {
            System.out.print("Input Mata Kuliah " + (i + 1) + " : ");
            this.krs[i] = inpKRS.nextLine();
            if (i >= 4) {
                System.out.print("Apa ada Mata Kuliah Lainnya? ( Y / N ) : ");
                String sudah = inpKRS.nextLine();
                if (sudah.equalsIgnoreCase("Y") || sudah.equalsIgnoreCase("y")) {
                    this.loop = i;
                    break;
                }
            }
            this.loop = i;
        }
    }

    public void infoKrsMahasiswa() {
        garis();
        System.out.println("KRS Mahasiswa dengan NIM " + this.nim + ": ");
        for (int i = 0; i <= this.loop; i++) {
            if (krs[i] == null) {
                break;
            }
            System.out.println("- " + this.krs[i]);
        }
        garis();
    }

    public float hitungRataNilai() {
        this.totalIPK = 0;
        int[] nilai = new int[this.loop + 1];
        for (int i = 0; i <= this.loop; i++) {
            System.out.print("Masukkan Nilai Mata Kuliah " + krs[i] + " : ");
            nilai[i] = inp.nextInt();
        }
        int total = 0;
        for (int i = 0; i <= this.loop; i++) {
            total += nilai[i];
        }
        for (int i = 0; i <= this.loop; i++) {
            if (nilai[i] >= 80 && nilai[i] <= 100) {
                float nilaiIPK = 4.0f;
                totalIPK += nilaiIPK;
            } else if (nilai[i] >= 70 && nilai[i] < 80) {
                float nilaiIPK = 3.0f;
                totalIPK += nilaiIPK;
            } else if (nilai[i] >= 60 && nilai[i] < 69) {
                float nilaiIPK = 2.0f;
                totalIPK += nilaiIPK;
            } else if (nilai[i] >= 50 && nilai[i] < 59) {
                float nilaiIPK = 1.0f;
                totalIPK += nilaiIPK;
            } else if (nilai[i] >= 0 && nilai[i] < 49) {
                float nilaiIPK = 0.0f;
                totalIPK += nilaiIPK;
            } else {
                return totalIPK;
            }
        }
        this.rata = (float) total / (this.loop + 1);
        return rata;
    }

    public void infoMahasiswa() {
        System.out.println("Nama Mahasiswa " + this.nama);
        System.out.println("NIM Mahasiswa " + this.nim);
        System.out.println("Semester " + this.semester);
        System.out.println("Usia Mahasiswa " + this.usia);
        System.out.println("Nilai Rata-Rata " + this.rata);
        if (this instanceof MahasiswaTransfer) {
            System.out.println(((MahasiswaTransfer) this).ikutOspek());
        } else if (this instanceof MahasiswaBaru) {
            System.out.println(((MahasiswaBaru) this).ikutOspek());
        }
    }

    public void garis() {
        System.out.println("\n=========================\n");
    }
}
