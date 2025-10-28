package graph.representation;

class GraphMatrix {
    private int[][] matrix;
    private int vertices;

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
        matrix[dest][src] = 1; // remove this line if directed graph
    }

    // Print matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.printMatrix();
    }
}

