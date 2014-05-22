/**
 * HNode is the node of the HuffmanTree, which contains the variables holding the
 * characters and the frequency of the characters, and also contains the reference
 * to its child nodes.
 * @author Chun-Wei Chen
 * @version 03/12/11
 */
public class HNode implements Comparable<HNode>
{
  public String c;    // character
  public int f;       // frequency of the character
  public HNode left;  // left child of the node
  public HNode right; // right child of the node
  
  /**
   * Constructs a node of the HuffmanTree with a character (in String) and
   * frquency.
   * @param c a character
   * @param f the frequency of the character
   * @throws IllegalArgumentException if the length of the String passed in
   * is more than one and that String is not new line character
   * @throws IllegalArgumentException if the frequency passed in is less than 1
   */
  public HNode(String c, int f) {
    if (c.length() > 1 && !c.equals("\\n"))
      throw new IllegalArgumentException("Invalid character.");
    if (f < 1)
      throw new IllegalArgumentException("Invalid frequency.");
    this.c = c;
    this.f = f;
    left = null;
    right = null;
  }
  
  /**
   * Compares a HNode with another HNode by the frequency hold in the node.
   * @param n a HNode
   * @return 0 if two frequencies are equal, 1 if the frequency of the current
   * HNode is greater than the one passed in, -1 if the frequency of the current
   * HNode is less than the one passed in
   */
  public int compareTo(HNode n) {
    if (this.f == n.f)
      return 0;
    else if (this.f > n.f)
      return 1;
    else
      return -1;
  }
}  