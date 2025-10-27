package p5;

public class PangkatRekursif {
    // Method rekursif untuk menghitung pangkat
    public static long pangkat(int base, int exp) {
        if (exp == 0) {
            return 1; // base^0 = 1
        } else if (exp % 2 == 0) {
            // jika eksponen genap → (base^2)^(exp/2)
            return pangkat(base * base, exp / 2);
        } else {
            // jika eksponen ganjil → base * base^(exp-1)
            return base * pangkat(base, exp - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + pangkat(2, 10));
        System.out.println("3^5 = " + pangkat(3, 5));
        System.out.println("3^16 = " + pangkat(3, 16));
    }
}
