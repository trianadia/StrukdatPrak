
package Prak2;

public class Mahasiswa {

    private long nim;
    public String nama;
    private String asal;

    public Mahasiswa(long nim, String nama, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }
    public long getNim() {
        return nim;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getAsal(){
        return asal;
    }

    public void displayMhs() {
        System.out.print("\tNIM: " + nim);
        System.out.print(", Nama: " + nama);
        System.out.println(", Asal: " + asal);
    }

}