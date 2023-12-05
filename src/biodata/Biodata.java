// package biodata ini berfungsi untuk mengelola data diri
package biodata;

// Modul 9 (Pertemuan 10) - Studi Kasus

// class biodata ini berfungsi untuk mengelola data diri
public class Biodata {
    // deklarasi variabel
    private String id;
    private String nama;
    private String alamat;
    private String noHp;
    private String jenisKelamin;

    /* 
        * 
        * Kumpulan Getter dan Setter di kelas Biodata
        * 
    */
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoHp() {
        return this.noHp;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
}