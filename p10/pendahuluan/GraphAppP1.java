package p10.pendahuluan;

public class GraphAppP1 {
    private final int MAX_VERTS = 20;
    private char[] vertexList;
    private int[][] adjMat;
    private boolean[] wasVisited;
    private int nVerts;

    public GraphAppP1() {
        vertexList = new char[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        wasVisited = new boolean[MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = label;
    }

    // Directed edge (satu arah)
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayAdjacency() {
        System.out.println("Adjacency:");
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i] + " --> ");
            for (int j = 0; j < nVerts; j++) {
                if (adjMat[i][j] == 1) {
                    System.out.print(vertexList[j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // ===== DFS (Depth First Search) =====
    private void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(vertexList[start] + " ");
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[start][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    // ===== Menampilkan Connectivity Table =====
    public void displayConnectivity() {
        System.out.println("Connectivity Table:");
        for (int i = 0; i < nVerts; i++) {
            boolean[] visited = new boolean[nVerts];
            dfs(i, visited);
            System.out.println();
        }
    }

    // ===== Main Program =====
    public static void main(String[] args) {
        GraphAppP1 theGraph = new GraphAppP1();

        // Tambahkan vertex (A, B, C, D, E)
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        // Tambahkan edge sesuai Gambar 10.8
        theGraph.addEdge(1, 0); // B -> A
        theGraph.addEdge(0, 2); // A -> C
        theGraph.addEdge(1, 4); // B -> E
        theGraph.addEdge(3, 4); // D -> E
        theGraph.addEdge(4, 2); // E -> C

        // Tampilkan hasil adjacency dan tabel koneksi
        theGraph.displayAdjacency();
        theGraph.displayConnectivity();
    }
}
