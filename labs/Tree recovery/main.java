import java.util.*;

class BNode<E>
{
    public E info;
    public BNode<E> left, right;
    public static int LEFT=1, RIGHT=2;
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

class BTree<E>
{
    public BNode<E> root;
    public BTree()
    {
        root=null;
    }
    public BTree(E info)
    {
        root = new BNode<E>(info);
    }

    public BNode<E> addChild(BNode<E> node, int where, E info)
    {
        BNode<E> tmp = new BNode<E>(info);
        if(where ==BNode.LEFT)
        {
            if(node.left!= null)
            {
                return null;
            }
            node.left=tmp;
        }
        else if(where == BNode.RIGHT)
        {
            if(node.right!=null)
            {
                return null;
            }
            node.right=tmp;
        }
        return tmp;
    }

    public void inorder(BNode<E> r)
    {
        if(r!=null)
        {
            inorder(r.left);
            System.out.print(r.info+ " ");
            inorder(r.right);
        }

    }
    public void preorder(BNode<E> r)
    {
        if(r!=null)
        {
            System.out.print(r.info+" ");
            preorder(r.left);
            preorder(r.right);
        }

    }
    public void postorder(BNode<E> r)
    {
        if(r!=null)
        {
            postorder(r.left);
            postorder(r.right);
            System.out.println(r.info);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>(-1);
        tree.addChild(tree.root,1,-1);
        tree.addChild(tree.root,2,-1);
        tree.addChild(tree.root.left,1,-1);
        tree.addChild(tree.root.left,2,-1);
        tree.addChild(tree.root.right,2,-1);
        recover(tree);
        tree.preorder(tree.root);
        System.out.println();
        System.out.println(search(tree.root, 5)); //false
        System.out.println(search(tree.root, 6)); //true
    }
    public static void recover(BTree<Integer> tree){
        recoverRecursive(tree, tree.root);
    }
    public static void recoverRecursive(BTree<Integer> tree, BNode<Integer> r){
        if(r==null){
            return;
        }
        if(tree.root==r){
            r.info=0;
        }
        if(r.left!=null)
            r.left.info = r.info * 2 + 1;
        if(r.right!=null)
            r.right.info = r.info * 2 + 2;
        recoverRecursive(tree,r.left);
        recoverRecursive(tree,r.right);
    }
    public static Boolean search(BNode<Integer> r, Integer key){
        if(r==null)
            return false;
        if(r.info==key)
            return true;
        return search(r.left,key)||search(r.right,key);
    }
}
