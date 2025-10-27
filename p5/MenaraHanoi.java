package p5;

public class MenaraHanoi {
    
    
    public static void doMenara(int jumlahCakram, char asal, char tujuan, char bantu) {
        if (jumlahCakram == 1) {
            System.out.println("Pindahkan cakram 1 dari " + asal + " ke " + tujuan);
        } else {
          
            doMenara(jumlahCakram - 1, asal, bantu, tujuan);

            System.out.println("Pindahkan cakram " + jumlahCakram + " dari " + asal + " ke " + tujuan);

            
            doMenara(jumlahCakram - 1, bantu, tujuan, asal);
        }
    }

    public static void main(String[] args) {
        int n = 3; 
        System.out.println("Penyelesaian Menara Hanoi dengan " + n + " cakram:");
        doMenara(n, 'A', 'C', 'B');
    }
}
