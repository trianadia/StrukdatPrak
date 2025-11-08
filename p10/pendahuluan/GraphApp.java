package p10.pendahuluan;

// ====== CLASS VERTEX ======
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
}

// ====== CLASS STACK UNTUK DFS DAN MST ======
class Stack {
    private final int SIZE;
    private int[] stackArray;
    private int top;

    public Stack(int s) {
        SIZE = s;
        stackArray = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

// ====== CLASS QUEUE UNTUK BFS ======
class Queue {
    private final int SIZE;
    private int[] queueArray;
    private int front;
    private int rear;

    public Queue(int s) {
        SIZE = s;
        queueArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if (rear == SIZE - 1)
            rear = -1;
        queueArray[++rear] = j;
    }

    public int remove() {
        int temp = queueArray[front++];
        if (front == SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
}

// ====== CLASS GRAPH ======
class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack theStack;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        theStack = new Stack(MAX_VERTS);
        theQueue = new Queue(MAX_VERTS);

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1; // Undirected Graph
    }

    public void display() {
        System.out.println("Adjacency:");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < row; col++) {
                if (adjMat[row][col] == 1) {
                    System.out.println(
                            vertexList[row].label + " -- " + vertexList[col].label);
                }
            }
        }
        System.out.println();
    }

    // ====== METHOD DFS ======
    public void dfs() {
        System.out.println("Visit by using DFS algorithm:");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        System.out.println();
        resetFlags();
    }

    // ====== METHOD BFS ======
    public void bfs() {
        System.out.println("Visit by using BFS algorithm:");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        System.out.println();
        resetFlags();
    }

    // ====== METHOD MST ======
    public void mst() {
        System.out.println("Minimum spanning tree:");
        vertexList[0].wasVisited = true;
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);

            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
                displayVertex(currentVertex);
                System.out.print(" -- ");
                displayVertex(v);
                System.out.println();
            }
        }

        resetFlags();
    }

    // ====== METHOD TAMBAHAN ======
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}

// ====== CLASS UTAMA ======
public class GraphApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();

        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        theGraph.addEdge(2, 4); // CE (tambahan untuk MST)

        theGraph.display();

        // Jalankan DFS
        theGraph.dfs();

        // Jalankan BFS
        theGraph.bfs();

        // Jalankan MST
        theGraph.mst();
    }
}
