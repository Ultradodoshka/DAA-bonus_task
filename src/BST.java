public class BST {
    class Node{
        int key;
        Node left;
        Node right;
        Node(int key){
            this.key=key;
        }
    }
    private Node root;

    public boolean search(int key){
        Node current = root;
        while (current!=null){
            if(key==current.key) return true;
            current=(key< current.key) ? current.left : current.right;
        }
        return false;
    }

    public void insert(int key){
        if(root==null){
            root=new Node(key);
            return;
        }
        Node current=root;
        while (true){
            if(key<current.key){
                if(current.left==null){
                    current.left=new Node(key);
                    break;
                }
                current=current.left;
            } else if (key> current.key) {
                if (current.right==null){
                    current.right=new Node(key);
                    break;
                }
                current=current.right;
            } else break;
        }
    }

    public void delete(int key){
        delRec(key,root);
    }
    private Node delRec(int key, Node root){
        if(root==null) return root;
        if(key< root.key) root.left=delRec(key,root.left);
        else if(key> root.key) root.right=delRec(key,root.right);
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            root.key=minVal(root.right);
            root.right=delRec(root.key, root.right);
        }
        return root;
    }

    private int minVal(Node root){
        int minV=root.key;
        while (root.left!=null){
            minV=root.left.key;
            root=root.left;
        }
        return minV;
    }
}
