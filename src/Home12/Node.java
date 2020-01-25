package Home12;
public class Node  {
    private Integer data;
    private Node parent;
    private Node left;
    private Node right;

    public Node(Integer data, Node parent, Node left, Node right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Integer getData() {
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

