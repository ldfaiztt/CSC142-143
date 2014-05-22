public class SearchTreeNode<E> {
    public E data;                   // data stored in this node
    public SearchTreeNode<E> left;   // left subtree
    public SearchTreeNode<E> right;  //  right subtree

    // post: constructs a leaf node with given data
    public SearchTreeNode(E data) {
        this(data, null, null);
    }

    // post: constructs a node with the given data and links
    public SearchTreeNode(E data, SearchTreeNode<E> left,
                          SearchTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
