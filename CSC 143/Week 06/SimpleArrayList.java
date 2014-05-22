import java.util.*;
@SuppressWarnings("unchecked") 
/**
 * Simple Array List implementation for CSE143 demonstration Au03, Sp04
 * The interface is a subset of java.util.ArrayList.
 * 
 * @author CSC 143
 * @version orig UW 4/7/04; modified 2/13/04 by vo; 
 * updated 5/10/06, 5/7/08, 5/11/08, 11/4/09, 2/9/12 by vo
 */
public class SimpleArrayList<E> implements List<E> {
  
  // instance variables
  private E[] items;        // items in this list are stored in
  private int numItems;          // items[0..numItems-1]
  
  // default capacity of a new SimpleArrayList if none is specified
  private static final int DEFAULT_CAPACITY = 5;
  
  /**
   * Construct a new SimpleArrayList with a default capacity.
   */
  public SimpleArrayList( ) {
    this( DEFAULT_CAPACITY );
  }
  
  /**
   * Construct a new SimpleArrayList with the specified capacity.
   * @param initialCapacity The initial size of this SimpleArrayList
   */
  public SimpleArrayList( int initialCapacity ) {
    items = (E[]) new Object[initialCapacity];
    numItems = 0;
  }
  
  // Basic query operations
  
  /**
   * Return the current size of this SimpleArrayList.
   * @return the number of items currently in this SimpleArrayList
   */
  public int size( ) {
    return numItems;
  }
  
  /**
   * Return whether this SimpleArrayList is empty or not.
   * @return true if this SimpleArrayList contains no items, otherwise false
   */
  public boolean isEmpty( ) {
    return size( ) == 0;
  }
  
  /**
   * Return the location of an item in the list.
   * @param obj the object we are looking for
   * @return the first location of obj in the list if found, otherwise -1
   */
  public int indexOf( Object obj ) {
    for ( int i = 0; i < numItems; i ++ ) {
      if ( items[i] == null ) {
        if ( obj == null )
          return i;  // separate test needed to prevent a NullPointerException
      }
      else if ( items[i].equals( obj ) ) {
        return i;
      }
    }
    return -1;
  }
  
  /**
   * Return whether this list contains a given object
   * @param obj the object we are looking for
   * @return true if obj is in the list, otherwise false
   */
  public boolean contains( Object obj ) {
    return indexOf( obj ) != -1;
  }
  
  // Add elements to this SimpleArrayList
  
  /** Increases the capacity of this ArrayList instance, if necessary, 
    * to ensure that it can hold at least the number of elements 
    * specified by the minimum capacity argument.  If an increase
    * in capacity is needed, this method doubles the the current 
    * capacity unless minCapacity is even larger.
    * @param minCapacity the desired minimum capacity.
    */
  private void ensureCapacity( int minCapacity ) {
    if ( minCapacity <= items.length ) {
      return;
    }
    int newCapacity = Math.max( minCapacity, 2*items.length );
    E[] newList = (E[]) new Object[newCapacity];
    for ( int i = 0; i < numItems; i++ ) {
      newList[i] = items[i];
    }
    items = newList;
  }
      
  
  /**
   * Add the given object to the end of this SimpleArrayList.
   * @param obj the object to be added
   * @return true - object is always added to the list
   */
  public boolean add( E obj ) {
    ensureCapacity( size( ) + 1 );
    items[numItems] = obj;
    numItems++;
    return true;
  }
  
  /**
   * Add an object at a specific position in the list.
   * @param pos position where object should be added
   * @param obj object to be added
   * @throws IndexOutOfBoundsException if the position is 
   * out of range ( < 0 or > size( ) )
   */
  public void add( int pos, E obj ) throws IndexOutOfBoundsException {
    if ( pos < 0 || pos > size( ) ) {
      throw new IndexOutOfBoundsException( );
    }
    ensureCapacity( size( ) + 1 );
    for ( int i = numItems; i > pos; i-- ) {
      items[i] = items[i-1];
    }
    items[pos] = obj;
    numItems++;
  }
  
  // remove items from the list
    
  /**
   * Remove all objects from this SimpleArrayList.
   */
  public void clear( ) {
    for ( int i = 0; i < numItems; i++ ) {
      items[i] = null;
    }
    numItems = 0;
  }
  
  /** check whether pos is valid */
  private void checkPosition( int pos ) {
    if ( pos < 0 || pos >= size( ) ) {
      throw new IndexOutOfBoundsException( );
    }
  }
  
  /**
   * Remove the object at a given position in the list.
   * @param pos position to be removed
   * @return the object removed
   * @throws IndexOutOfBoundsException if the position is 
   * out of range ( < 0 or >= size( ) )
   */
  public E remove( int pos ) throws IndexOutOfBoundsException {
    checkPosition( pos );
    E result = items[pos];
    for ( int i = pos; i < numItems - 1; i++ ) {
      items[i] = items[i+1];
    }
    items[numItems-1] = null;
    numItems--;
    return result;
  }
  
  /**
   * Remove the specified object if it appears in the list.
   * @param obj the object to be removed
   * @return true if obj removed and the list is altered, false otherwise
   */
  public boolean remove( Object obj ) {
    int pos = indexOf( obj );
    if ( pos != -1 ) {
      remove( pos );
      return true;
    } else {
      return false;
    }
  }
    
  // set and get items from the list
  
  /**
   * Return the element at the specified position in the list.
   * @param pos  the position of the element to return
   * @return the element at the specified position
   * @throws IndexOutOfBoundsException if the position is 
   * out of range ( < 0 or >= size( ) )
   */
  public E get( int pos ) throws IndexOutOfBoundsException {
    checkPosition( pos );
    return items[pos];
  }
  
  /**
   * Replace the element at the specified position with the specified element.
   * @param pos the position of the element to be replaced
   * @param obj the new element to be stored at that position
   * @return the element that was previously stored at that position
   * @throws IndexOutOfBoundsException if the position is 
   * out of range ( < 0 or >= size( ) )
   */
  public E set( int pos, E obj ) throws IndexOutOfBoundsException {
    checkPosition( pos );
    E result = items[pos];
    items[pos] = obj;
    return result;
  }
  
  /**
   * Test whether this list equals another object.  This SimpleArrayList is equal
   * to the other object if it is a SimpleArrayList with the same number of elements
   * and the elements are pairwise equal.
   * @param other the other object
   * @return true if the objects are equal, otherwise false
   */
  public boolean equals( Object other ) {
    if ( this == other ) {
      return true;
    }
    if ( !( other instanceof SimpleArrayList ) ) {
      return false;
    }
    SimpleArrayList otherList = (SimpleArrayList)other;
    if ( this.size( ) != otherList.size( ) ) {
      return false;
    }
    for ( int i = 0; i < size( ); i ++ ) {
      if ( this.get( i ) == null ) {
        if ( otherList.get( i ) != null )
          return false;  // separate test needed to prevent a NullPointerException
      }
      else if ( !this.get( i ).equals( otherList.get( i ) ) ) {
        return false;
      }
    }
    return true;
  }
  
  /** 
   * Return a new iterator object for this list
   * @return a new iterator object for this list 
   */
  public Iterator<E> iterator( ) {
    return new SimpleArrayListIterator<E>( this );
  }
  
  // INNER CLASS
    
  /** Iterator class for SimpleArrayList. */
  class SimpleArrayListIterator<E> implements Iterator<E> {
    // instance variables
    private List<E> list;
    private boolean removeOK;
    private int nextItem;   // position of next item in this iteration
                            // not yet returned by next( )
    
    /** 
     * Initialize a new iterator for this list. 
     */
    public SimpleArrayListIterator( List<E> theList ) {
      this.list = theList;
      this.removeOK = false;
      this.nextItem = 0;
    }
    
    /** 
     * Return true if there are more elements in the iteration
     * @return true if next can return an element
     */
    public boolean hasNext( ) {
      return nextItem < list.size( );
    }
    
    /** 
     * Return the next item in the iteration
     * @return next item
     * @throws NoSuchElementException if there is no next element
     */
    public E next( ) {
      if ( !hasNext( ) ) {
        throw new NoSuchElementException( );
      }
      E result = list.get( nextItem );
      nextItem++;
      removeOK = true;
      return result;
    }
    
    /** 
     * Remove last item returned by 'next'.
     * @throws IllegalStateException if 'next' was not called before 'remove'
     */
    public void remove( ){
      if (!removeOK)
        throw new IllegalStateException("Must call 'next' before 'remove'");
      list.remove(nextItem-1); // remove the item just viewed using 'next'
      nextItem--; // adjust the pointer because 'remove' shifts items down
      removeOK = false; // not OK to call 'remove' until 'next' is called again
    }
  }
  
  // more list interface methods to implement:
  
  public List<E> subList( int fromIndex, int toIndex ) { return null; }
  public ListIterator<E> listIterator() { return null; }
  public ListIterator<E> listIterator( int index ) { return null; }
  public int lastIndexOf( Object elem ) { throw new UnsupportedOperationException( ); }
  public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException( ); }
  public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException( ); }
  public boolean addAll(Collection<? extends E> c) { throw new UnsupportedOperationException( ); }
  public boolean addAll(int index, Collection<? extends E> c) { throw new UnsupportedOperationException( ); }
  public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException( ); }
  public Object[] toArray() { throw new UnsupportedOperationException( ); }
  public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException( ); }
    
}
  
  