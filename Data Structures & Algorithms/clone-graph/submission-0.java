/*
class Node {
    public int val;
    public List<Node> neighbors;
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
}*/

class Solution {
    public Node cloneGraph(Node node) {
        
        return node != null ? clone(node, new HashMap<>()): null;
    }

    public Node clone(Node node, HashMap<Node, Node> ogVsClone) {
        if (ogVsClone.containsKey(node)) {
            return ogVsClone.get(node);
        }
        Node output = new Node();
        output.val = node.val;
        ogVsClone.put(node, output);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node cloned = clone(node.neighbors.get(i), ogVsClone);
            output.neighbors.add(cloned);
        }
        return output;
    }
}