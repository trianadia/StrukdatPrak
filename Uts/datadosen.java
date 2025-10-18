public class datadosen {
    private String id;
    private String nama;

    // Constructor
    public datadosen(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String toString() {
        return id + " - " + nama;
    }
}