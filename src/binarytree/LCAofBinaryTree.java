package binarytree;

public class LCAofBinaryTree {
    public static void main(String[] args) {
        LCAofBinaryTree tree = new LCAofBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findLCA_1(4, 5).data);
        /*
        System.out.println("LCA(4, 6) = " +
                tree.findLCA_1(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLCA_1(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA_1(2, 4).data);
         */
    }

    private static Node findLCA_1(int n1, int n2) {
        return findLCA(root, n1,n2);
    }

    private static Node findLCA(Node node, int n1, int n2) {
        if(node == null){
            return null;
        }

        if(node.data == n1 || node.data == n2){
            return node;
        }

        Node leftLCA = findLCA(root.left,n1,n2);
        Node rightLCA = findLCA(root.right,n1,n2);

        if(leftLCA != null && rightLCA != null){
            return node;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    private static  Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }



}
