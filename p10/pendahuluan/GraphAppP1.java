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

    private void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(vertexList[start] + " ");
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[start][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    private void dfsCollect(int start, boolean[] visited, java.util.List<Character> list) {
        visited[start] = true;
        list.add(vertexList[start]);
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[start][i] == 1 && !visited[i]) {
                dfsCollect(i, visited, list);
            }
        }
    }

    public void displayConnectivity() {
        System.out.println("Connectivity Table:");
        for (int i = 0; i < nVerts; i++) {
            boolean[] visited = new boolean[nVerts];
            java.util.List<Character> reachable = new java.util.ArrayList<>();
            dfsCollect(i, visited, reachable);
            // cetak seluruh list (source pertama, lalu reachable)
            for (char c : reachable) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAppP1 theGraph = new GraphAppP1();

        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(1, 0); 
        theGraph.addEdge(0, 2); 
        theGraph.addEdge(2, 4); 
        theGraph.addEdge(3, 4); 
        theGraph.addEdge(4, 2); 

        theGraph.displayAdjacency();
        theGraph.displayConnectivity();
    }
}
