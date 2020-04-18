package ch.zhaw.thin.pda;

import ch.zhaw.thin.pda.components.MetaVariable;
import ch.zhaw.thin.pda.components.PDA;

/**
 * The PDANumber class represents a PDA that accepts numbers and arithmetic operators (+, -, *, /).
 * An example input would be '99+'.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class PDANumber extends PDABasic {

    private static final char DIGIT = 'D';
    private static final char OPERATION = 'O';
    private static final char EPSILON = ' ';
    private final PDA pda;

    /**
     * Creates a {@link PDANumber} object instance.
     */
    public PDANumber() {
        pda = new PDA(getTransitionRules(), getAcceptedStates(), getMetaVariables(true));
    }

    /**
     * Processes the given {@code input}.
     *
     * @param input The input that is being processed.
     * @return A boolean state indicating whether the given {@code input} is accepted or not.
     */
    public boolean process(String input) {
        return pda.process(input);
    }

    /**
     * Returns the meta variables.
     *
     * @param includeMetaAlias Indicates whether the meta variable is included as a symbol.
     * @return An array containing the meta variables.
     */
    private MetaVariable[] getMetaVariables(boolean includeMetaAlias) {
        if(includeMetaAlias) {
            return new MetaVariable[]{
                    new MetaVariable('D', new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'D'}),
                    new MetaVariable('O', new char[]{'+', '-', '*', '/', 'O'})
            };
        } else {
            return new MetaVariable[]{
                    new MetaVariable('D', new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}),
                    new MetaVariable('O', new char[]{'+', '-', '*', '/'})
            };
        }
    }
}
