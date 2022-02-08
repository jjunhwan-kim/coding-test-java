package problem.recursive_tree_graph.problem09;

/**
 * 9. Tree 말단노드까지의 까장 짧은 경로(DFS)
 * 이 코드는 노드의 왼쪽, 오른쪽 자식이 모두 존재해야 동작함
 */

public class Main {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = this.rt = null;
        }
    }

    public int dfs(Node node, int depth) {

        if (node.lt == null && node.rt == null) {
            return depth;
        } else {
            return Math.min(dfs(node.lt, depth + 1), dfs(node.rt, depth + 1));
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

        System.out.println(main.dfs(root, 0));
    }
}
