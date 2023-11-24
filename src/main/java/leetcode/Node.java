package leetcode;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public static void main(String[] args) {
    }
}
