// This class breaks up a string into a sequence of tokens using
// both whitespace and a list of special characters that are each
// considered tokens.  The special characters in this case are
// used to tokenize an arithmetic expression.  For example, the
// expression:
//     2*3.8/(4.95-7.8)
// would be tokenized as 2 * 3.8 / ( 4.95 - 7.8 ) even though it
// has no whitespace to separate these tokens.

import java.util.*;

public class StringSplitter {
    private Queue<Character> characters;
    private String token;

    public static final String SPECIAL_CHARACTERS = "()+-*/^";

    public StringSplitter(String line) {
        characters = new LinkedList<Character>();
        for (int i = 0; i < line.length(); i++) {
            characters.add(line.charAt(i));
        }
        findNextToken();
    }

    // post: Returns true if there is another token
    public boolean hasNext() {
        return token != null;
    }

    // pre : there is another token to return (throws
    //       NoSuchElementException if not)
    // post: returns and consumes the next token
    public String next() {
        checkToken();
        String result = token;
        findNextToken();
        return result;
    }

    // pre : there is another token to return (throws
    //       NoSuchElementException if not)
    // post: returns the next token without consuming it
    public String peek() {
        checkToken();
        return token;
    }

    // post: finds the next token, if any
    private void findNextToken() {
        while (!characters.isEmpty() &&
               Character.isWhitespace(characters.peek())) {
            characters.remove();
        }
        if (characters.isEmpty()) {
            token = null;
        } else {
            token = "" + characters.remove();
            if (SPECIAL_CHARACTERS.indexOf(token) == -1) {
                boolean done = false;
                while (!characters.isEmpty() && !done) {
                    char ch = characters.peek();
                    if (Character.isWhitespace(ch) || 
                        SPECIAL_CHARACTERS.indexOf(ch) != -1) {
                        done = true;
                    } else {
                        token = token + characters.remove();
                    }
                }
            }
        }
    }

    // post: throws an exception if there is no token left
    private void checkToken() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }
}