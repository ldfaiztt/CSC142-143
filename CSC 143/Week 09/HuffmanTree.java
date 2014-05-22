import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;

/**
 * Proof of concept of Huffman Coding. Use a file content to build a 
 * HuffmanTree in order to encode the original text. This process 
 * will use less memory to store the content.
 * @author Chun-Wei Chen
 * @version 03/12/11
 */
public class HuffmanTree
{
  // a map holds characters (in String) and the nodes 
  // contain each character and its frequency
  private HashMap<String, HNode> fMap;
  
  // a map holds characters (in String) and the values 
  // of each character after encoded (in String)
  private HashMap<String, String> lookupTable;
  private File inFile;           // a file object
  private HNode root;            // the root of the HuffmanTree
  private String encodedMessage;  // the message after encoded 
  
  /**
   * Constructs a HuffmanTree with a file passed in. 
   * @param file a file object
   * @throws IllegalArgumentException if the file cannot be read
   * @throws IOException signals that an I/O exception of some sort has occurred
   */
  public HuffmanTree(File file) throws IOException {
    if (!file.canRead())
      throw new IllegalArgumentException("The file passed in cannot be read");
    
    // Initilizes instance variables.
    inFile = file;
    fMap = fillMap();
    root = buildHuffmanTree();
    lookupTable = fillLookupTable();
    encodedMessage = encode();
  }
  
  /**
   * Fills the map with keys -- characrters (in String) from the file and 
   * values -- the HNodes contain each character and its frequency.
   * @return a map contains keys -- characrters (in String) from the file and 
   * values -- the HNodes contain each character and its frequency
   * @throws IOException signals that an I/O exception of some sort has occurred
   */
  public HashMap<String, HNode> fillMap() throws IOException {
    HashMap<String, HNode> map = new HashMap<String, HNode>();
    Scanner sc = new Scanner(inFile);  // Read the content of the file.
    while (sc.hasNextLine()) {
      String s = sc.nextLine();  // Read the file line by line.
      
      // Read the line character by character.
      for (int i = 0; i < s.length(); i++) {
        String temp = s.substring(i, i + 1);
        
        // Put the character and the HNode contains that character and 
        // its frequency in the map if the character hasn't been put in 
        // the map; otherwise, change the frequency in the original value (HNode).
        if (map.containsKey(temp))
          map.put(temp, new HNode(temp, map.get(temp).f + 1));
        else
          map.put(temp, new HNode(temp, 1));
      }
      
      // Take care of new line character as well as the other characters
      // in order to decode later.
      HNode p = new HNode("\\n", 1);
      if (map.containsKey(p.c))
        map.put("\\n", new HNode("\\n", map.get("\\n").f + 1));
      else
        map.put("\\n", p);
    }
    return map;
  }
  
  /**
   * Creates a PriorityQueue to hold HNodes in acsending order based 
   * on the frequency of the character.
   * @param map a map contains characters (in String) and HNodes 
   * which hold the characters and their frequencies.
   * @return a PriorityQueue to hold HNodes in acsending order based 
   * on the frequency of the character
   */
  private PriorityQueue<HNode> fillQueue(HashMap<String, HNode> map) {
    PriorityQueue<HNode> queue = new PriorityQueue<HNode>();
    Set<String> set = map.keySet(); // Get the characters from the frequency map.
    for (String s : set)
      queue.add(map.get(s));
    return queue;
  }
  
  /**
   * Builds the HuffmanTree for the file. Each leaf of the tree contains a character
   * and its frequency. Other node only contain the frequency, the frequencies of its
   * left and right child combined.
   * @return the root of the tree.
   */
  public HNode buildHuffmanTree() {
    // Use the PriorityQueue to build the tree from low frequency to high frequency.
    PriorityQueue<HNode> q = fillQueue(fMap);
    
    if (q.peek() == null)
      return null;
    
    // If the file contains more than one character, take out the first two elements
    // in the queue, create a new node whose left and right child are the two elements
    // just be taken out, and then put the new node back to the queue. Repeat doing this
    // util the queue only has one element.
    else {
      HNode p1 = q.poll();
      HNode p2 = q.poll();
      while (p2 != null) {
        HNode p = new HNode("", p1.f + p2.f);
        p.left = p1;
        p.right = p2;
        q.add(p);
        p1 = q.poll();
        p2 = q.poll();
      }
      return p1;
    }
  }
  
  /**
   * Fills a lookup table with keys -- characrters (in String) from the file and 
   * values -- the character after encoded (00, 101, etc.).
   * @return a map contains keys -- characrters (in String) from the file and 
   * values -- the character after encoded (00, 101, etc.).
   */
  public HashMap<String, String> fillLookupTable() {
    return fillLookupTable(root, "");
  }
  
  /**
   * A private recursive fillLookupTable method.
   * @param p a HNode object
   * @param s the String value of the character after encoded
   * @return a map contains keys -- characrters (in String) from the file and 
   * values -- the character after encoded (00, 101, etc.).
   */
  private HashMap<String, String> fillLookupTable(HNode p, String s) {
    HashMap<String, String> table = new HashMap<String, String>();
    if (p != null) {
      // Put the character and the value after encoded in the map
      // if the current node is a leaf.
      if (p.left == null && p.right == null)
        table.put(p.c, s);
      
      // Breakdown the tree into left and right and use the method to call
      // left subtree and right subtree, and then combine the two parts together.
      // Keep track on the value before the method encounter a leaf node.
      // 0 -- go left, 1 -- go eight.
      else {
        HashMap<String, String> table1 = fillLookupTable(p.left, s + 0);
        Set<String> keySet1 = table1.keySet();
        for (String c : keySet1)
          table.put(c, table1.get(c));
        HashMap<String, String> table2 = fillLookupTable(p.right, s + 1);
        Set<String> keySet2 = table2.keySet();
        for (String c : keySet2)
          table.put(c, table2.get(c));
      }
    }
    return table;
  }
  
  /**
   * Returns the output of the file after encoded.
   * @return the output of the file after encoded
   * @throws IOException signals that an I/O exception of some sort has occurred
   */
  public String encode() throws IOException {
    Scanner sc = new Scanner(inFile); // Read the content of the file.
    String result = "";
    while (sc.hasNextLine()) {
      String s = sc.nextLine(); // Read the file line by line.
      
      // Read the line character by character.
      for (int i = 0; i < s.length(); i++) {
        String temp = s.substring(i, i + 1);
        
        // Get the value of the character after encoded from the lookup table.
        result += lookupTable.get(temp);
      }
      // Add the value of the new line character after encoded at the end of each line.  
      result += lookupTable.get("\\n");
    }
    encodedMessage = result;
    return result;
  }
  
  /**
   * Returns the output of encoded message after decoded. 
   * This should be the same as the original file.
   * @return the output of encoded message after decoded
   * @throws IOException signals that an I/O exception of some sort has occurred
   */
  public String decode() throws IOException {
    return decode(root, encodedMessage);
  }
  
  /**
   * A private recursive decode method.
   * @param p a HNode object
   * @param s the String value of the decoded message
   * @return the output of encoded message after decoded
   */
  private String decode(HNode p, String s) {
    String result = "";
    if (p != null) {
      // While the current node is not a leaf node, if the first number of the 
      // encoded message is 0, call the method with left subtree and the encoded message
      // without the first number; otherwise, call the method with right subtree and 
      // the encoded message without the first number.
      if (p.c == "") {
        if (s.substring(0, 1).equals("0"))
          result = decode(p.left, s.substring(1, s.length()));
        else
          result = decode(p.right, s.substring(1, s.length()));
      }
      
      // If the current node contains new line character, add new line character to
      // the result in order to make the rest of the result show up at the next line; 
      // otherwise, add the character to the result.
      else {
        if (s.length() == 0) {
          if (p.c.equals("\\n"))            
            result += "\n";
          else
            result += p.c;
        } else {
          if (p.c.equals("\\n"))            
            result += "\n" + decode(root, s);
          else
            result += p.c + decode(root, s);
        }
      }
    }
    return result;
  }
  
  /**
   * Shows the frequency table, which displays each character 
   * and its frequency in each line.
   */
  public void showFreqTable() {
    System.out.println("Frequency Table:\n");
    Set<String> keySet = fMap.keySet();
    for (String s : keySet)
      System.out.println("'" + s + "'  " + fMap.get(s).f);
    System.out.println();
  }
  
  /**
   * String represrntation of the HuffmanTree. Shows the preorder traversal of the tree.
   */
  public void treeToString() {
    System.out.println("Huffman Tree:\n");
    treeToString(root, "");
    System.out.println();
  }
  
  /**
   * A private recursive treeToString method.
   * @param p a HNode object
   * @param indent indentation in order to show the node's level
   */
  private void treeToString(HNode p, String indent) {
    if (p != null) {
      // Print the field of the current node first. If it's not a leaf node,
      // it will only show the frequency; otherwise, it will show both
      // frequency and the character.
      if (p.c != "")
        System.out.println(indent + "node (" + p.f + ") '" + p.c + "'");
      else
        System.out.println(indent + "node (" + p.f + ")");
      
      // Print the left subtree first, and then right subtree.
      treeToString(p.left, indent + "    ");
      treeToString(p.right, indent + "    ");
    }
  }
  
  /**
   * String representation of the lookup table. Shows each character and its value
   * after encoded in each line.
   */
  public void lookupTableToString() {
    System.out.println("Lookup Table:\n");
    Set<String> keySet = lookupTable.keySet();
    for (String s : keySet)
      // Get the corresponding encoded value from the lookup table. 
      System.out.println("'" + s + "'  " + lookupTable.get(s));
    System.out.println();
  }
  
  /**
   * This methods show the original text, the symbol frequency table, 
   * the Huffman Tree (include the 'symbol' and 'frequency' value for each node), 
   * the symbol/code table, the encoded message, the decoded message, and 
   * the average number of bits per symbol used in the encoded file.
   * @throws IOException signals that an I/O exception of some sort has occurred 
   */
  public void showEverything() throws IOException {
    System.out.println("Original Text:\n");
    Scanner sc = new Scanner(inFile);
    double count = 0;
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      // Count the number of the characters in the original text
      // and add one for counting the new line character.
      count += s.length() + 1;
      System.out.println(s);
    }
    System.out.println();
    showFreqTable();
    treeToString();
    lookupTableToString();
    System.out.println("Encoded Message:\n");
    System.out.println(encodedMessage);
    System.out.println();
    System.out.println("Decoded Message:\n");
    System.out.println(decode());
    System.out.println("Average number of bits per symbol used: " + 
                       encodedMessage.length() / count);
  }
  
  /**
   * The main method allows the user use JFileChooser to choose a file and do the 
   * Huffman coding, and then displays original text, freqeuncy table, encoded/decoded 
   * message, Huffman Tree, lookup table, and average number of bits per symbol used 
   * corresponding to the file.
   * @param args
   * @throws IOException signals that an I/O exception of some sort has occurred
   */
  public static void main(String[] args) throws IOException {
    JFileChooser jfc = new JFileChooser(".");
    int returnVal = jfc.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      HuffmanTree tree = new HuffmanTree(jfc.getSelectedFile());
      tree.showEverything();
    }
  }
}