package problem.recursive_tree_graph.problem10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 10. Tree 말단노드까지의 까장 짧은 경로(BFS)
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

    public int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                if (current.lt == null && current.rt == null) {
                    return level;
                } else {
                    if (current.lt != null) queue.offer(current.lt);
                    if (current.rt != null) queue.offer(current.rt);
                }
            }
            level++;
        }
        return 0;
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

        System.out.println(main.bfs(root));
    }
}
