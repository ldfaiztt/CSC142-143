import java.io.*;

public class RecursionExample
{
  public static void crawl(File f) {
    crawl(f, "");
  }
  
  private static void crawl(File f, String indent) {
    System.out.println(indent + f.getName());
    if (f.isDirectory()) {
      for (File subFile : f.listFiles())
        crawl(subFile, indent + "    ");
    }
  }
  
  public static void main(String[] args) throws IOException {
    crawl(new File(args[0]));
  }
}