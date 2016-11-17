package lafore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {

    private String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.push(ch);
        }

        output = "";

        while (!theStack.isEmpty()) {
            output += theStack.pop();
        }

        return output;

    }

}

class ReverseApp {

    public static void main(String[] args) throws IOException {

        String input, output;
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed: " + output);
        }

    }

    public static String getString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        return s;
    }


}
