package ch.zhaw.thin.pda;

import java.util.Scanner;

/**
 * The Main class of the application.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        PDABasic pdaBasic = new PDABasic();
        PDANumber pdaNumber = new PDANumber();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string to parse: ");

        while(scanner.hasNext()) {
            String input =  scanner.nextLine();

            if (pdaNumber.process(input)) {
                System.out.println(input + " is a valid UPN notation");
            } else {
                System.err.println(input + " is not a valid UPN notation");
            }
        }

        System.exit(-1);
    }

}
