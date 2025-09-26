
package p5;

public class TriangleDemo {
    public static int triangleIter(int n) {
        int result = 0;
        for (int i = n; i > 0; i--) {
            result += i;
        }
        return result;
    }

    public static int triangleRecur(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangleRecur(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("triangleIter(" + n + ") = " + triangleIter(n));
        System.out.println("triangleRecur(" + n + ") = " + triangleRecur(n));
    }
}

