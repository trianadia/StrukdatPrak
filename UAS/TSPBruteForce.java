package UAS;

/*
TSPBruteForce.java

Brute-force TSP solver (Java) untuk 8 node (A..H).
Menampilkan:
 - Semua permutasi dan jarak tiap tour
 - Summary (best tour)
 - Perbandingan jarak tambahan (A->F vs A->G->F)
 - DAFTAR 8 RUTE pilihan (seperti yang disepakati sebelumnya)
 - Path CSV yang dihasilkan sebelumnya (lokal)

CSV path (lokal): /mnt/data/tabel_jarak_uin_mog_nodes_A-H.csv
*/

public class TSPBruteForce {

    static final String[] NODE_LABEL = {"A","B","C","D","E","F","G","H"};
    static final String[] NODE_NAME = {
        "Perpustakaan UIN Maulana Malik Ibrahim", // A
        "Jl. Veteran (dekat UB/UM)",              // B
        "Simpang Balapan",                        // C
        "Jl. Besar Ijen (Boulevard Ijen)",       // D
        "Jl. Kawi (seputar sebelum MOG)",        // E
        "Mall Olympic Garden (MOG)",             // F
        "Brigjend Slamet Riadi",                  // G
        "Dinoyo / MT Haryono (Suhat)"            // H
    };

    static final double[][] DIST = {
        //A    B    C    D    E    F    G    H
        { 0.0, 1.2, 2.2, 3.8, 4.0, 4.4, 5.4, 5.3}, // A
        { 1.2, 0.0, 1.0, 2.6, 3.0, 3.8, 4.4, 4.1}, // B
        { 2.2, 1.0, 0.0, 1.6, 2.4, 3.2, 3.8, 3.9}, // C
        { 3.8, 2.6, 1.6, 0.0, 1.4, 2.2, 4.6, 4.2}, // D
        { 4.0, 3.0, 2.4, 1.4, 0.0, 0.8, 4.2, 3.5}, // E
        { 4.4, 3.8, 3.2, 2.2, 0.8, 0.0, 5.0, 4.0}, // F
        { 5.4, 4.4, 3.8, 4.6, 4.2, 5.0, 0.0, 2.9}, // G
        { 5.3, 4.1, 3.9, 4.2, 3.5, 4.0, 2.9, 0.0}  // H
    };

    // The 8 route descriptions you asked to keep (these are the route options)
    static final String[] ROUTE_OPTIONS = {
        "1. Veteran - Besar Ijen - Kawi - MOG (±4.4 km, tercepat via Ijen)",
        "2. Veteran - Simpang Balapan - Ijen - Kawi - MOG (±4.4 km, variasi loop)",
        "3. Veteran - Bandung - Tumapel - Kawi - MOG (±4.5 km, alternatif jika Ijen macet)",
        "4. MT Haryono - Soekarno-Hatta - Dinoyo - Kawi - MOG (±5.3 km, koridor barat kota)",
        "5. Sigura-Gura - Jakarta - Brigjend Slamet Riadi - Kawi - MOG (±5.4 km, alternatif populer)",
        "6. Sumbersari - Dinoyo - Ijen (sisi selatan) - Kawi - MOG (±5.0 km, tembus UB selatan)",
        "7. Sumbersari - Mayjend Panjaitan - Semeru - MOG (±6.0 km, rute utara via Semeru)",
        "8. Veteran - Kalpataru - Borobudur - Letjen Sutoyo - Kawi - MOG (±6.5 km, memutar via Blimbing)"
    };

    public static void main(String[] args) {
        int n = DIST.length; // 8

        int[] perm = new int[n-1];
        for (int i = 0; i < n-1; i++) perm[i] = i+1;

        double bestCost = Double.POSITIVE_INFINITY;
        int[] bestTour = null;
        long count = 0;

        System.out.println("Brute-force TSP (8 nodes) — enumerate all tours and print total distance for each\n");

        // iterate all permutations
        do {
            double cost = 0.0;
            int prev = 0;

            StringBuilder tourSb = new StringBuilder();
            tourSb.append("A"); // start label

            // A -> first
            cost += DIST[prev][perm[0]];
            prev = perm[0];
            tourSb.append(" -> ").append(NODE_LABEL[prev]);

            // middle legs
            for (int i = 1; i < perm.length; i++) {
                int cur = perm[i];
                cost += DIST[prev][cur];
                prev = cur;
                tourSb.append(" -> ").append(NODE_LABEL[prev]);
            }
            // back to A
            cost += DIST[prev][0];
            tourSb.append(" -> A");

            count++;
            // Print this permutation's total distance
            System.out.printf("%4d. %s  :  %.2f km%n", count, tourSb.toString(), cost);

            // Update best if needed
            if (cost < bestCost) {
                bestCost = cost;
                bestTour = new int[n+1];
                bestTour[0] = 0;
                for (int i = 0; i < perm.length; i++) bestTour[i+1] = perm[i];
                bestTour[n] = 0;
            }

        } while (nextPermutation(perm));

        // Summary
        System.out.println("\n=== Summary ===");
        System.out.println("Total permutations checked: " + count);
        System.out.printf("Best tour cost (km): %.2f%n", bestCost);
        System.out.print("Best tour (labels): ");
        for (int i = 0; i < bestTour.length; i++) {
            System.out.print(NODE_LABEL[bestTour[i]]);
            if (i < bestTour.length - 1) System.out.print(" -> ");
        }
        System.out.println("\nBest tour (full names):");
        for (int i = 0; i < bestTour.length; i++) {
            System.out.println("  " + NODE_LABEL[bestTour[i]] + ": " + NODE_NAME[bestTour[i]]);
        }

        // Additional comparisons (example A->F vs A->G->F)
        int A = 0, F = 5, G = 6;
        double AF = DIST[A][F];
        double AGF = DIST[A][G] + DIST[G][F];

        System.out.println("\n=== Perbandingan Jarak Tambahan ===");
        System.out.printf("Jarak langsung A - F : %.2f km%n", AF);
        System.out.printf("Jarak A - G - F     : %.2f km%n", AGF);
        if (AF < AGF) {
            System.out.println("Lewat langsung A - F lebih cepat daripada A - G - F");
        } else {
            System.out.println("Lewat A - G - F lebih cepat.");
        }

        // === NEW: tampilkan 8 rute pilihan yang kamu minta ===
        System.out.println("\n=== Daftar 8 Rute (opsi) ===");
        for (String r : ROUTE_OPTIONS) {
            System.out.println(r);
        }
    }

    // nextPermutation helper (lexicographic)
    static boolean nextPermutation(int[] perm) {
        int k = perm.length - 2;
        while (k >= 0 && perm[k] >= perm[k+1]) k--;
        if (k < 0) return false;
        int l = perm.length - 1;
        while (perm[k] >= perm[l]) l--;
        // swap
        int tmp = perm[k]; perm[k] = perm[l]; perm[l] = tmp;
        // reverse suffix
        int i = k+1, j = perm.length-1;
        while (i < j) { tmp = perm[i]; perm[i] = perm[j]; perm[j] = tmp; i++; j--; }
        return true;
    }
}
