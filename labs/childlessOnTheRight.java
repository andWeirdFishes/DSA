import java.util.*;

class BNode<E extends Comparable<E>>
{
    public E info;
    public BNode<E> left, right;
    public BNode(E info)
    {
        this.info=info;
        this.left=null;
        this.right=null;
    }
    public BNode(E info, BNode<E> left, BNode<E> right)
    {
        this.info=info;
        this.left=left;
        this.right=right;
    }
}
class BST<E extends Comparable<E>>{
    public BNode<E> root;
    public BST(){
        this.root=null;
    }
    public BST(BNode<E> root){
        this.root=root;
    }
    public BST(E r){
        this.root=new BNode<>(r);
    }
    public BNode<E> getRoot(){
        return this.root;
    }
    public void insert(E info) {
        root = insertRecursive(root, info);
    }
    public BNode<E> insertRecursive(BNode<E> r, E info) {
        if (r == null) {
            return new BNode<>(info);
        }
        if (info.compareTo(r.info) < 0) {
            r.left = insertRecursive(r.left, info);
        } else if (info.compareTo(r.info) > 0) {
            r.right = insertRecursive(r.right, info);
        }
        return r;
    }
    public boolean contains(E info) {
        return containsRecursive(info, root);
    }
    private boolean containsRecursive(E info, BNode<E> r) {
        if (r == null) {
            return false;
        }
        if (info.compareTo(r.info) < 0){
            return containsRecursive(info,r.left);
        }
        else if (info.compareTo(r.info) > 0) {
            return containsRecursive(info,r.right);
        }
        return true;
    }
    public void inorder(BNode<E> r){
        if(r==null){
            return;
        }
        inorder(r.left);
        System.out.print(r.info+" ");
        inorder(r.right);
    }
    public BNode<E> delete(E info) {
        if (!contains(info)) {
            return null;
        }
        return deleteRecursive(info, root);
    }
    private BNode<E> deleteRecursive(E info, BNode<E> r) {
        // Base case: if tree is empty
        if (r == null) {
            return null;
        }

        // Traverse to find the node to delete
        if (info.compareTo(r.info) < 0) {
            r.left = deleteRecursive(info, r.left);
        }
        else if (info.compareTo(r.info) > 0) {
            r.right = deleteRecursive(info, r.right);
        }
        else {
            if (r.left == null && r.right == null) {
                return null;
            }
            if (r.left == null) {
                return r.right;
            }
            if (r.right == null) {
                return r.left;
            }
            BNode<E> minNode = findMinRecursive(r.right);
            r.info = minNode.info;
            r.right = deleteRecursive(minNode.info, r.right);
        }
        return r;
    }
    public BNode<E> findMinRecursive(BNode<E> r) {
        if(r==null){
            return null;
        }
        else if (r.left==null){
            return r;
        }
        return findMinRecursive(r.left);
    }
    public Integer pairExists(BNode<E> r){
        if(r==null){
            return 0;
        }
        Integer imaVoLevo = pairExists(r.left);
        Integer imaVoDesno = pairExists(r.right);
        if(imaVoLevo==1 || imaVoDesno==1){
            return 1;
        }
        else if(r.left!=null && r.right==null && r.left.right==null){
            return 1;
        }
        return 0;
    }
}
public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(7);
        tree.insert(5);
        System.out.println(tree.pairExists(tree.root)); //0 -> ne postoi takov par jazli
        BST<Integer> t2 = new BST<>(3);
        t2.insert(2);
        t2.insert(1);
        t2.insert(4);
        System.out.println(t2.pairExists(t2.root)); //1 -> 2 i 1 se takov par -> postoi
    }
}
