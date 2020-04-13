package ch.zhaw.thin.pda;

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
        boolean isAccepted = pdaBasic.process("DDODDOO");
        System.out.println(isAccepted);
    }

}
