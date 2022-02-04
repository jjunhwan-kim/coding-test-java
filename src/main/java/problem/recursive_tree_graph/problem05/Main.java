package problem.recursive_tree_graph.problem05;

/**
 * 5. 이진트리순회
 */

public class Main {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    /**
     *        root
     *         1
     *     2      3
     *   4   5   6   7
     */

    public void traverse(Node node) {

        if (node == null) {
            return;
        } else {
            //System.out.print(node.data + " "); // 전위순회
            traverse(node.lt);
            //System.out.print(node.data + " "); // 중위순회
            traverse(node.rt);
            //System.out.print(node.data + " "); // 후위순회
        }
    }


    public static void main(String[] args){
        Main main = new Main();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        main.traverse(root);
    }
}
