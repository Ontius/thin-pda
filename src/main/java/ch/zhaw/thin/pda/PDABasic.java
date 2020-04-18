package ch.zhaw.thin.pda;

import ch.zhaw.thin.pda.components.PDA;
import ch.zhaw.thin.pda.components.Stack;
import ch.zhaw.thin.pda.components.TransitionRule;

/**
 * The PDABasic class represents a PDA that accepts D's, O's. An example input would be 'DDODDOO'.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class PDABasic {

    private static final char DIGIT = 'D';
    private static final char OPERATION = 'O';
    private static final char EPSILON = ' ';
    private final PDA pda;

    /**
     * Creates a {@link PDABasic} object instance.
     */
    public PDABasic() {
        pda = new PDA(getTransitionRules(), getAcceptedStates());
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
     * Returns the transition rules.
     *
     * @return An array containing all transition rules.
     */
    protected TransitionRule[] getTransitionRules() {
        return new TransitionRule[] {
                new TransitionRule(0, 1, DIGIT, Stack.INITIAL_STACK_SYMBOL, DIGIT), // q0 -> q1
                new TransitionRule(1, 2, DIGIT, DIGIT, DIGIT, DIGIT), // q1 -> q2
                new TransitionRule(2, 3, OPERATION, DIGIT), // q2 -> q3
                new TransitionRule(3, 1, DIGIT, DIGIT, DIGIT, DIGIT), // q3 -> q1
                new TransitionRule(3, 3, OPERATION, DIGIT), // q3 -> q3
                new TransitionRule(3, 4, EPSILON, DIGIT), // q3 -> q4
                new TransitionRule(4, 5, EPSILON, Stack.INITIAL_STACK_SYMBOL), // q4 -> q5
        };
    }

    /**
     * Returns the accepted states.
     *
     * @return An array containing the accepted states.
     */
    protected int[] getAcceptedStates() {
        return new int[] { 5 };
    }
}
