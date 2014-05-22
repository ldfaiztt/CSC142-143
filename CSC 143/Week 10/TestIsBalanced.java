import java.util.*;

public class TestIsBalanced
{
  public static boolean isBalanced(String s) {
    if (s != null && s.length() != 0) {
      if (s.length() == 1) {
        return !(s.equals("{") || s.equals("}") || s.equals("[") || 
                 s.equals("]") || s.equals("(") || s.equals(")"));
      }
      List<Character> stack= new ArrayList<Character>();
      char c;
      for (int i = 0; i < s.length(); i++) {
        c = s.charAt(i);
        if (c == '{' || c == '[' || c == '(') {
          if (s.length() - i <= 2)
            return false;
          else if ((s.charAt(i) == '{' && s.charAt(i + 1) == '}') || 
                   (s.charAt(i) == '[' && s.charAt(i + 1) == ']') || 
                   (s.charAt(i) == '(' && s.charAt(i + 1) == ')'))
            return false;
          else
            stack.add(c);
        } else if (c == '}' || c == ']' || c == ')') {
          if (i < 2 || stack.size() == 0)
            return false;
          else if ((s.charAt(i) == '}' && stack.get(stack.size() - 1) != '{') || 
                   (s.charAt(i) == ']' && stack.get(stack.size() - 1) != '[') || 
                   (s.charAt(i) == ')' && stack.get(stack.size() - 1) != '('))
            return false;
          else
            stack.remove(stack.size() - 1);
        }
      }
      if (stack.size() != 0)
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(isBalanced("abc{de(fg){ijk}{l{m[n]}}o[p]}qr"));
    System.out.println(isBalanced("abc{(def}}{ghij{kl}m]"));
    System.out.println(isBalanced("{(p)}"));
    System.out.println(isBalanced("{"));
    System.out.println(isBalanced("a"));
  }
}
