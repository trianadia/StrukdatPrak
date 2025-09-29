
public class MenaraHanoi {
    
    // method rekursif untuk memindahkan cakram
    public static void doMenara(int jumlahCakram, char asal, char tujuan, char bantu) {
        if (jumlahCakram == 1) {
            System.out.println("Pindahkan cakram 1 dari " + asal + " ke " + tujuan);
        } else {
            // pindahkan n-1 cakram dari tiang asal ke tiang bantu
            doMenara(jumlahCakram - 1, asal, bantu, tujuan);

            // pindahkan cakram terbesar dari tiang asal ke tiang tujuan
            System.out.println("Pindahkan cakram " + jumlahCakram + " dari " + asal + " ke " + tujuan);

            // pindahkan n-1 cakram dari tiang bantu ke tiang tujuan
            doMenara(jumlahCakram - 1, bantu, tujuan, asal);
        }
    }

    public static void main(String[] args) {
        int n = 3; // jumlah cakram, bisa diganti 3, 4, 5, dll
        System.out.println("Penyelesaian Menara Hanoi dengan " + n + " cakram:");
        doMenara(n, 'A', 'C', 'B');
    }
}
