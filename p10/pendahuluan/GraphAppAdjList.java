package p10.pendahuluan;

import java.util.*;

public class GraphAppAdjList {

    // Representasi vertex dengan linked list
    private static class Vertex {
        char label;
        LinkedList<Integer> adjList;

        Vertex(char label) {
            this.label = label;
            this.adjList = new LinkedList<>();
        }
    }

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int nVerts;

    public GraphAppAdjList() {
        vertexList = new Vertex[MAX_VERTS];
        nVerts = 0;
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        vertexList[start].adjList.add(end);
    }

    public void displayAdjList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + " --> ");
            for (int dest : vertexList[i].adjList) {
                System.out.print(vertexList[dest].label + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(vertexList[start].label + " ");
        for (int dest : vertexList[start].adjList) {
            if (!visited[dest]) {
                dfs(dest, visited);
            }
        }
    }

    public void displayConnectivity() {
        System.out.println("Connectivity Table:");
        for (int i = 0; i < nVerts; i++) {
            boolean[] visited = new boolean[nVerts];
            dfs(i, visited);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphAppAdjList graph = new GraphAppAdjList();

        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4

        graph.addEdge(1, 0); // B -> A
        graph.addEdge(0, 2); // A -> C
        graph.addEdge(1, 4); // B -> E
        graph.addEdge(3, 4); // D -> E
        graph.addEdge(4, 2); // E -> C

        graph.displayAdjList();
        graph.displayConnectivity();
    }
}
