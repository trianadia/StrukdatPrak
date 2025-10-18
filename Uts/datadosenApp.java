import java.util.ArrayList;

public class datadosenApp {
    private ArrayList<datadosen> daftarDosen = new ArrayList<>();

    
    public void insert(String id, String nama) {
        daftarDosen.add(new datadosen(id, nama));
    }

    
    public void displayAll() {
        System.out.println("Daftar Dosen");
        for (datadosen d : daftarDosen) {
            System.out.println(d);
        }
    }

    
    public datadosen searchByName(String namaCari) {
        for (datadosen d : daftarDosen) {
            if (d.getNama().equalsIgnoreCase(namaCari)) {
                return d;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        datadosenApp app = new datadosenApp();

        
        app.insert("D001", "Budi");
        app.insert("D002", "Sinta");
        app.insert("D003", "Andi");
        app.insert("D004", "Nadia");

        
        app.displayAll();

     
        String namaCari = "Andi";
        System.out.println("\nMencari nama dosen: " + namaCari);

        datadosen hasil = app.searchByName(namaCari);
        if (hasil != null) {
            System.out.println("Dosen ditemukan: " + hasil);
        } else {
            System.out.println("Dosen dengan nama \"" + namaCari + "\" tidak ditemukan.");
        }
    }
}