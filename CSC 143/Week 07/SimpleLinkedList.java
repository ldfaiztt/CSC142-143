import java.util.*;
@SuppressWarnings("unchecked")
/**
 * A List with a linked list implementation.
 * Javadocs are somewhat incomplete.
 * 
 * To more clearly illustrate the basic principles of linked lists,
 * this collection will be restricted to include non-null items
 * only.  This restriction could be lifted with the addition of 
 * some extra tests in 'indexOf' and 'equals', as we did in the
 * SimpleArrayList class.
 * 
 * @author CSC 143
 * @version orig UW Spring 2002; 
 * modified 2/7/04, 2/15/07, 11/8/09, 2/12/12 by vo
 */
public class SimpleLinkedList<E> implements List<E>
{
  private Node<E> first, last; 
  private int numNodes;       
  
  /**
   * Constructor for objects of class SimpleLinkedList -- 
   * creates an empty list.
   */
  public SimpleLinkedList( ) {
    first = null;
    last = null;
    numNodes = 0;
  }
  
  /**
   * Copy Constructor: 
   * construct a new SimpleLinkedList and intialize it 
   * with contents of Collection c.
   * PRECONDITIONS: c must be non-null, and no item
   * in Collection c may be null.
   * @throws new IllegalArgumentException if c is null
   * or any item in the Collection c is null
   */
  public SimpleLinkedList( Collection<? extends E> c ) {
    first = null;
    last = null;
    numNodes = 0;
    
    if ( c == null ) throw new IllegalArgumentException();
    if ( c.size( ) != 0 ) {
      // Need to attach first node to the list's 'first' reference
      Iterator<? extends E> it = c.iterator( );
      E o = it.next( );
      checkObject( o );
      first = new Node<E>( o, null );
      last = first;
      numNodes++;
      
      // Now copy any more there are
      while ( it.hasNext( ) ){
        o = it.next( );
        checkObject( o );
        last.next = new Node<E>( o, null );
        last = last.next;
        numNodes++;
      }
    }
  }
  
  /**
   * Return true if o is contained in this list
   */
  public boolean contains( Object o ) { 
    return ( indexOf(o) != -1 );
  }
  
  /**
   * Return index of o if found, or -1 if not found
   */
  public int indexOf( Object o ) {
    Node<E> p = first;
    int location = 0;
    while( p != null && !( p.item.equals( o ) ) ){
      p = p.next;
      location++;
    }
    if ( p != null )
      return location;
    else
      return -1;
  }
  
  /** Returns size of this List */
  public int size( ) { 
    return numNodes; }
  
  /** Returns true if this List is empty */
  public boolean isEmpty() { 
    return ( size() == 0 ); }

  /** 
   * Returns a reference to the Node object at the specified position.
   * precondition: 0 <= pos < numNodes
   */
  private Node<E> getNodeAtPos( int pos ) {
    Node<E> p = first;
    for ( int k = 0; k < pos; k++ ){
      p = p.next;
    }
    return p;
  }
  
  /** check whether pos is valid */
  private void checkPosition( int pos ) {
    if ( pos < 0 || pos >= size( ) ) 
      throw new IndexOutOfBoundsException( );
  }  
  
  /** check whether obj is null */
  private void checkObject( E obj ) {
    if ( obj == null ) 
      throw new IllegalArgumentException( "no nulls allowed in List" );
  }  
  
  /**
   * Returns item stored at given position
   * @throws IllegalArgumentExcpetion if pos < 0 or pos >= size( )
   */
  public E get( int pos ) {
    checkPosition( pos );
    Node<E> curr = getNodeAtPos( pos );
    return curr.item; 
  }
  
  /** Clear all elements from the List */
  public void clear( ) {
    first = null;
    last = null;
    numNodes = 0;
  }
  
  /**
   * Stores Object o at given position
   * @return the object that was replaced
   * @throws IllegalArgumentException if pos < 0 or pos > size( )
   *       or obj == null
   */
  public E set( int pos, E obj ) {
    checkObject( obj );
    checkPosition( pos );
    Node<E> curr = getNodeAtPos( pos );
    E result = curr.item;
    curr.item = obj;
    return result;
  }
  
  /** Add object o to the end of this list 
   * @return true if list altered by this operation 
   * @throws new IllegalArgumentException if obj == null
   */
  public boolean add( E obj ) {
    checkObject( obj );
    Node<E> newOne = new Node<E>( obj, null );
    if ( first == null ) {
      first = newOne;
      last = newOne;
    } else {
      last.next = newOne;
      last = newOne;
    }
    numNodes++;
    return true;
  }
  
  /**
   * insert the element o into given position; shift 
   * contents from index pos to size()-1 up one location
   * @throws IllegalArgumentException if pos < 0 or pos > size( )
   *       or obj == null
   */
  public void add( int pos, E obj ) {
    checkObject( obj );
    if ( pos < 0 || pos > size( ) ) {
      throw new IndexOutOfBoundsException( );
    }
    Node<E> newOne = new Node<E>( obj, null );
    if ( pos == 0 ) {  // beginning of list
      newOne.next = first;
      first = newOne;
    } else {            // somewhere in middle or end
      Node<E> prev = getNodeAtPos( pos - 1 );
      newOne.next = prev.next;
      prev.next = newOne;
    }
    if ( pos == numNodes ){  // was this at the end?
      last = newOne;
    }
    numNodes++;
  }
  
  /** remove the first instance of the object from the List
   * @return true if list altered, false if not */
  public boolean remove ( Object o ) {
    int pos = indexOf( o );
    if ( pos >=0 ) {    //found it
      remove( pos );
      return true;
    } 
    else
      return false;
  }
  
  /** Remove the object at position pos from this list.  
   * @return object being removed
   *  precondition: 0 <= pos < size( ) */
  public E remove( int pos ) {
    if ( pos < 0 || pos >= numNodes ) 
      throw new IndexOutOfBoundsException( );
    E saved;    
    if ( pos == 0 ) {   // remove from begining
      saved = first.item; 
      first = first.next;
      // what if this was the last node?
      if ( first == null ) 
        last = null;
    } else {
      Node<E> prev = getNodeAtPos( pos - 1 );
      saved = prev.next.item; 
      prev.next = prev.next.next;
      //what if this was the last node?
      if ( pos == numNodes - 1 )  
        last = prev;
    }
    numNodes--;
    return saved;
  }   
  
  /** Return true if this list equals other element by element */
  public boolean equals( Object o ) {   
    if ( this == o )
      return true;
    if ( !( o instanceof SimpleLinkedList ) )
      return false;
    // now we know we have a SimpleLinkedList, so bind it
    // to an appropriate variable
    SimpleLinkedList other = ( SimpleLinkedList ) o;
    if ( size() != other.size() ) 
      return false;
    // This search uses a flag instead of returning early
    boolean success = true;

    // TO DO: Compare lists item by item to see if all are equal
    //        Waiting for completed iterator
    
    return success;
  }
  
  /**
   * @return an Iterator for this List
   */
  public Iterator<E> iterator( ) { 
    // left as an exercise
    throw new UnsupportedOperationException( );
  }
  
  /** Returns a string representation of this List */
  public String toString( ) {
    if (size() == 0)
      return "[]";
    // fencepost
    StringBuffer result = new StringBuffer( "[" + first.item ); // uses the item's toString method
    Node<E> p = first.next;  
    while (p != null) {
      result.append( ", " + p.item ); 
      p = p.next;
    }
    result.append( "]" );
    return result.toString( );
  }  
  
  // The rest of these methods are in the interface and so must be implemented
  
  public Object[] toArray() { throw new UnsupportedOperationException(); }   
  public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException( ); }  
  public boolean containsAll(Collection c) { throw new UnsupportedOperationException(); }
  public boolean addAll(Collection c) { throw new UnsupportedOperationException(); }
  public boolean removeAll(Collection c) { throw new UnsupportedOperationException(); }
  public boolean retainAll(Collection c) { throw new UnsupportedOperationException(); }
  public boolean addAll(int x, Collection c) { throw new UnsupportedOperationException(); }
  public int lastIndexOf(Object o) { throw new UnsupportedOperationException(); }
  public ListIterator<E> listIterator() { throw new UnsupportedOperationException(); }
  public ListIterator<E> listIterator(int x) { throw new UnsupportedOperationException(); }
  public List<E> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
  

  /** 
   * Private inner 'Node' class.
   * This is a good example of an application where non-private instance variables
   * make sense.  We grant the SimpleLinkedList unrestricted access to the members
   * of every Node object.  The syntax for working with them is simpler (and the 
   * code more efficient) with direct access.
   */
  private class Node<E> {
    E item;
    Node<E> next;
    Node( E o, Node<E> n ) {
      item = o;
      next = n;
    }
  }
  
}