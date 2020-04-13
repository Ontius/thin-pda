package ch.zhaw.thin.pda.components;

/**
 * The TransitionRule class is responsible for holding data about a specific transition.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class TransitionRule {

    private final int currentState;
    private final int newState;
    private final char readSymbol;
    private final char popSymbol;
    private final char[] pushSymbols;

    /**
     * Creates a {@link TransitionRule} object instance with the given arguments.
     *
     * @param currentState The current state.
     * @param newState The new state.
     * @param readSymbol The symbol that is being read.
     * @param pushSymbols The symbols that are being pushed.
     * @param popSymbol The symbol that is being popped.
     */
    public TransitionRule(int currentState, int newState, char readSymbol, char popSymbol, char... pushSymbols) {
        this.currentState = currentState;
        this.newState = newState;
        this.readSymbol = readSymbol;
        this.popSymbol = popSymbol;
        this.pushSymbols = pushSymbols;
    }

    /**
     * Returns the state that has to be the current state if this rule is applied.
     *
     * @return The current state.
     */
    public int getCurrentState() {
        return currentState;
    }

    /**
     * Returns the new state.
     *
     * @return The new state.
     */
    public int getNewState() {
        return newState;
    }

    /**
     * Returns the symbol that needs to be read when this rule is applied.
     *
     * @return The symbol that is being read.
     */
    public char getReadSymbol() {
        return readSymbol;
    }

    /**
     * Returns the symbols that are being pushed.
     *
     * @return The symbols that are being pushed.
     */
    public char[] getPushSymbols() {
        return pushSymbols;
    }

    /**
     * Returns the symbol that needs to be popped if this transition rule is applied.
     *
     * @return The symbol that is being popped.
     */
    public char getPopSymbol() {
        return popSymbol;
    }

    /**
     * Checks whether this rule is fulfilled with the given arguments or not.
     *
     * @param currentState The current state.
     * @param readSymbol The symbol that is being read.
     * @param popSymbol The symbol that is being popped.
     * @return A boolean state indicating whether this rule is fulfilled or not.
     */
    public boolean isRuleFulfilled(int currentState, char readSymbol, char popSymbol) {
        return currentState == getCurrentState() && this.readSymbol == readSymbol && this.popSymbol == popSymbol;
    }
}
