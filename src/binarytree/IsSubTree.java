package binarytree;

public class IsSubTree {

    static class Tree{
        int data;
        Tree left;
        Tree right;
        public Tree(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        IsSubTree tree = new IsSubTree();
        Tree s = new Tree(26);
        s.left = new Tree(10);
        s.right = new Tree(3);
        s.right.right = new Tree(3);
        s.left.left = new Tree(4);
        s.left.right = new Tree(6);
        s.left.left.right = new Tree(30);

        Tree t = new Tree(10);
        t.left = new Tree(4);
        t.right = new Tree(6);
        t.left.right = new Tree(30);

        System.out.println("Tree 2 is subtree of tree 1 : " + tree.isSubTree(s,t));

    }

    private boolean isSubTree(Tree s, Tree t){
        if(s == null){
            return false;
        } else if (isSameTree(s,t)){
            return true;
        } else {
            return isSubTree(s.left,t) || isSubTree(s.right,t);
        }
    }

    private boolean isSameTree(Tree s, Tree t){
        if(s == null || t == null){
            return (s == null && t == null);
        } else if(s.data == t.data){
            return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
        } else {
            return false;
        }
    }

}
