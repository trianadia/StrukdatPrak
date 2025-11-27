package UAS;

import java.util.*;

public class TSPSoalRinaldiMunir {
    static char[] vertices = {'a','b','c','d'};

    // Matriks bobot sesuai gambar
    static int[][] w = {
        //a   b   c   d
        { 0, 12,  5, 10 }, // a
        {12,  0,  8,  9 }, // b
        { 5,  8,  0, 15 }, // c
        {10,  9, 15,  0 }  // d
    };

    public static void main(String[] args) {
        List<int[]> permutations = generatePermutations(new int[]{1,2,3}); 
        // 1=b, 2=c, 3=d — titik awal selalu 'a'

        int bestWeight = Integer.MAX_VALUE;
        List<String> bestRoutes = new ArrayList<>();

        int routeNum = 1;
        for (int[] perm : permutations) {
            int total = 0;
            int prev = 0; // start at 'a' (index 0)

            System.out.print(routeNum + ". a");
            for (int p : perm) {
                System.out.print(" - " + vertices[p]);
                total += w[prev][p];
                prev = p;
            }
            System.out.print(" - a");

            total += w[prev][0]; // kembali ke a

            System.out.println("   | Bobot = " + total);

            if (total < bestWeight) {
                bestWeight = total;
                bestRoutes.clear();
                bestRoutes.add(buildRouteString(perm));
            } else if (total == bestWeight) {
                bestRoutes.add(buildRouteString(perm));
            }

            routeNum++;
        }

        System.out.println("\nRute terpendek sesuai gambar:");
        for (String r : bestRoutes) {
            System.out.println(r);
        }
        System.out.println("Bobot minimum = " + bestWeight);
    }

    static List<int[]> generatePermutations(int[] arr) {
        List<int[]> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    static void permute(int[] arr, int start, List<int[]> result) {
        if (start == arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            int t = arr[start]; arr[start] = arr[i]; arr[i] = t;
            permute(arr, start + 1, result);
            t = arr[start]; arr[start] = arr[i]; arr[i] = t;
        }
    }

    static String buildRouteString(int[] perm) {
        StringBuilder sb = new StringBuilder("a");
        for (int p : perm) sb.append(" - ").append(vertices[p]);
        sb.append(" - a");
        return sb.toString();
    }
}
