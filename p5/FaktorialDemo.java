package p5;

public class FaktorialDemo {
    
    // Versi Iteratif
    public static long factorialIter(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    // Versi Rekursif
    public static long factorialRecur(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        } else {
            return n * factorialRecur(n - 1); 
        }
    }

    public static void main(String[] args) {
        int n = 5; 

        System.out.println("Faktorial " + n + " (Iteratif) = " + factorialIter(n));
        System.out.println("Faktorial " + n + " (Rekursif) = " + factorialRecur(n));
    }
}
