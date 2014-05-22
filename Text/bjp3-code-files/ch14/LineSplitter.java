import java.util.*;

public class LineSplitter {
    private Queue<Character> characters;
    private boolean nextIsNumeric;
    private double number;
    private char character;
    private boolean hasNext;

    public static final String SPECIAL_CHARACTERS = "()+-*/";

    public LineSplitter(String line) {
        characters = new LinkedList<Character>();
        for (int i = 0; i < line.length(); i++) {
            characters.add(line.charAt(i));
        }
        characters.add(' ');
        hasNext = true;
        findNextToken();
    }

    private void findNextToken() {
        while (!characters.isEmpty() && Character.isWhitespace(characters.peek())) {
            characters.remove();
        }
        if (characters.isEmpty()) {
            hasNext = false;
        } else {
            nextIsNumeric = Character.isDigit(characters.peek());
            if (nextIsNumeric) {
                String text = "";
                while (Character.isDigit(characters.peek())) {
                    text = text + characters.remove();
                }
                if (characters.peek() == '.') {
                    text = text + characters.remove();
                    while (Character.isDigit(characters.peek())) {
                        text = text + characters.remove();
                    }
                }
                number = Double.parseDouble(text);
            } else {
                character = characters.remove();
            }
        }
    }

    public boolean hasNext() {
        return hasNext;
    }

    public boolean nextIsNumeric() {
        return nextIsNumeric;
    }

    public double nextDouble() {
        double result = number;
        findNextToken();
        return result;
    }

    public char nextChar() {
        char result = character;
        findNextToken();
        return result;
    }
}