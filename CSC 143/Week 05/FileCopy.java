import java.util.*; // for Scanner
import java.io.*;   // for File, PrintStream
/**
 * FileCopy demo - copy a file whose name is the first command line
 * argument to the file whose name is the second argument.  Print the
 * contents to System.out as we go.  
 * 
 * Completely reworked in W'12 to make use of a Scanner for reading
 * and a PrintStream for writing.
 * 
 * @author CSC 143
 * @version 2/7/12
 */

public class FileCopy {
    /**
     * Copy the file named in the first argument to a new file
     * whose name is given by the second argument
     */

    public static void main(String[] args) {

        // quit if we don't have exactly two command-line arguments
        if (args.length != 2) {
            System.err.println("FileCopy requires two filenames as arguments");
            return;
        }
        
        // quit if we cannot read the input file
        File inFile = new File(args[0]);
        if (!inFile.canRead()) {
            System.err.println("Cannot read from the file specified by the "
                               + "first argument.  Try again.");
            return;
        }
        
        // this program has a bug; can you figure out what additional input validation is needed?

        Scanner inStream = null;
        PrintStream outStream = null;
        try {
            // open input file using a Scanner
            inStream = new Scanner(inFile);

            // open output file using a PrintStream
            outStream = new PrintStream(new File(args[1]));

            // copy input file to output one line at a time,
            // and print lines on System.out also 
            while (inStream.hasNextLine()) {
                String line = inStream.nextLine();
                System.out.println(line); 
                outStream.println(line);
             }

            // close both streams
            inStream.close();
            outStream.close();
         } catch ( FileNotFoundException e) {  // should never happen because we test the file
            System.err.println("File not found.  Error object = ");
            System.err.println(e);
         }
    }
}
