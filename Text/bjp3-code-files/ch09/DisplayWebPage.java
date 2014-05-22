// This program reads the HTML text of a web page
// and prints it on the console.

import java.io.*;
import java.net.*;   // for URL
import java.util.*;

public class DisplayWebPage {
    public static void main(String[] args) 
            throws IOException {
        URL website = new URL("http://www.homestarrunner.com");
        InputStream stream = website.openStream();
        Scanner in = new Scanner(stream);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }
}
