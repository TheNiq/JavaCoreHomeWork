package Home14;


import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class MySet2 implements Set {
    private int size;
    private Node root = null;
    private Node current;
    private Comparator comparator;

    public MySet2() {
    }

    public MySet2(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(root == null){
            return false;
        }
        if(comparator != null){
            if(comparator.compare(o,root.getData()) == 0){
                return true;
            }else {
                current = root;
                while (current != null){
                    if(comparator.compare(o,current.getData()) == 0){
                        return true;
                    }
                    if(comparator.compare(o,current.getData()) > 0){
                        current = current.getRight();

                    }
                    else if(comparator.compare(o,current.getData()) < 0){
                        current = current.getLeft();
                    }
                }
                return false;
            }
        }else {
            Comparable oData = null;
            if(o instanceof Comparable){
                oData = (Comparable) o;
            }
            if(oData.equals(root.getData())){
                return true;
            }else {
                current = root;
                while (current != null){
                    if(oData.compareTo(current.getData()) == 0){
                        return true;
                    }
                    if(oData.compareTo(current.getData())> 0){
                        current = current.getRight();

                    }
                    else if(oData.compareTo(current.getData()) < 0){
                        current = current.getLeft();
                    }
                }
            }

        }


        return false;
    }

    @Override
    public Iterator iterator() {
        return new SetIterator(root);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    private boolean addIfHasComparator(Object o) {

        Node node = new Node(o,null,null,null);
        if(root == null){
            root = node;
            current = root;
            size++;
            return true;
        }
        else {
            current = root;
            while (current != null){
                if(comparator.compare(o, current.getData()) > 0){
                    if(current.getRight() != null){
                        current = current.getRight();

                    }else {
                        current.setRight(node);
                        node.setParent(current);
                        size++;
                        return true;
                    }
                }
               if(comparator.compare(o, current.getData()) < 0){
                    if(current.getLeft() != null){
                        current = current.getLeft();
                    }
                    else {
                        current.setLeft(node);
                        node.setParent(current);
                        size++;
                        return true;
                    }

                }
                else if(comparator.compare(o, current.getData()) == 0){
                    return false;
                }


            }
        }
        return false;
    }
    @Override
    public boolean add(Object o) {
        if(comparator != null){
            return addIfHasComparator(o);
        }
        Comparable oData = null;
        if (o instanceof Comparable ){
            oData = (Comparable) o;
        }else {
            System.out.println("Not comparable ");
            return false;
        }

        Node node = new Node(o,null,null,null);
        if(root == null){
            root = node;
            current = root;
            size++;
            return true;
        }
        else {
            current = root;
            while (current != null){
                if(oData.compareTo(current.getData()) > 0 ){
                    if(current.getRight() != null){
                        current = current.getRight();

                    }else {
                        current.setRight(node);
                        node.setParent(current);
                        size++;
                        return true;
                    }
                }
                if(oData.compareTo(current.getData()) < 0){
                    if(current.getLeft() != null){
                        current = current.getLeft();
                    }
                    else {
                        current.setLeft(node);
                        node.setParent(current);
                        size++;
                        return true;
                    }

                }
                else if(oData.compareTo(current.getData()) == 0){
                    return false;
                }


            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for(Object o : c){
            add(o);
        }
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public String toString() {
        return toString(root);
    }
    public String toString(Node root){
        String result = "";
        if(root == null){
            return result;
        }
        else {
            result += root.getData();
            if(root.getRight() != null || root.getLeft() != null){
                result = "(" + result + ", " + toString(root.getLeft());
                result +=  ", " + toString(root.getRight() ) + ")";
            }
        }
        return result;

    }



    public static class Node{
        private Object data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Object getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + data + " ";
        }

    }



}
