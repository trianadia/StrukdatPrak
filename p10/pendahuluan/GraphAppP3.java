package p10.pendahuluan;

public class GraphAppP3 {
    private final int MAX_VERTS = 20;
    private char[] vertexList;
    private int[][] adjMat;
    private boolean[] wasVisited;
    private int nVerts;

    public GraphAppP3() {
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

    // ======================
    // === Topological Sort ===
    // ======================
    public void topoSort() {
        char[] sortedArray = new char[nVerts];
        int origVerts = nVerts; // simpan jumlah awal vertex

        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles!");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex];
            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");
        for (int i = 0; i < origVerts; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("\n");
    }

    // === Cari vertex tanpa successor ===
    private int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge)
                return row;
        }
        return -1;
    }

    // === Hapus vertex dari graph ===
    private void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }

            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

    // ===== Main untuk uji topological sort =====
    public static void main(String[] args) {
        GraphAppP3 theGraph = new GraphAppP3();

        // Contoh untuk Gambar 10.10 (mata kuliah prasyarat)
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('G'); // 6
        theGraph.addVertex('H'); // 7

        // Tambahkan edge sesuai diagram
        theGraph.addEdge(0, 3); // A -> D
        theGraph.addEdge(1, 4); // B -> E
        theGraph.addEdge(2, 5); // C -> F
        theGraph.addEdge(3, 6); // D -> G
        theGraph.addEdge(4, 6); // E -> G
        theGraph.addEdge(5, 7); // F -> H
        theGraph.addEdge(6, 7); // G -> H

        theGraph.displayAdjacency();
        theGraph.topoSort();
    }
}
