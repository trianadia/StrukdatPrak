
package p5;

public class TriangleDemoNoBase {
    public static int triangleRecur(int n) {
        // Base case dihilangkan
        return n + triangleRecur(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("triangleRecur(" + n + ") = " + triangleRecur(n));
    }
}
