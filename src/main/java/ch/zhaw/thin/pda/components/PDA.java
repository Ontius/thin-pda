package ch.zhaw.thin.pda.components;

/**
 * The PDA class represents a push down automata.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class PDA {

    private static final int INVALID_STATE = -1;
    private final Stack stack;
    private final TransitionRule[] transitionRules;
    private final int[] acceptedStates;
    private final MetaVariable[] metaVariables;

    /**
     * Creates a {@link PDA} object instance.
     *
     * @param transitionRules The transition rules.
     * @param acceptedStates The accepted states.
     */
    public PDA(TransitionRule[] transitionRules, int[] acceptedStates) {
        this(transitionRules, acceptedStates, new MetaVariable[0]);
    }

    /**
     * Creates a {@link PDA} object instance.
     *
     * @param transitionRules The transition rules.
     * @param acceptedStates The accepted states.
     * @param metaVariables The meta variables.
     */
    public PDA(
            TransitionRule[] transitionRules,
            int[] acceptedStates,
            MetaVariable[] metaVariables
    ) {
        this.transitionRules = transitionRules;
        this.acceptedStates = acceptedStates;
        this.metaVariables = metaVariables;
        this.stack = new Stack();
    }

    /**
     * Processes the given {@code input}.
     *
     * @param input The input that is being processed.
     * @return A boolean state indicating whether the given {@code input} is accepted or not.
     */
    public boolean process(String input) {
        int state = 0;

        // Add to whitespaces at the end of the string. This is relevant for the last two states of the PDA.
        input += "  ";
        char[] inputArray = input.toCharArray();

        for(int i = 0; i < input.length(); i++) {
            state = getNextState(state, inputArray[i]);

            if(state == INVALID_STATE) {
                return false;
            }

            if(isStateAccepted(state)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the next state.
     *
     * @param state The current state.
     * @param symbol The current symbol that is being read.
     * @return The next state. -1 if no next state was found.
     */
    private int getNextState(int state, char symbol) {
        char popSymbol = stack.pop();
        MetaVariable metaVariable = tryToFindMetaVariable(symbol);

        for(TransitionRule rule : transitionRules) {
            symbol = (metaVariable == null) ? symbol : metaVariable.getAlias();

            if(rule.isRuleFulfilled(state, symbol, popSymbol)) {
                if(rule.getPushSymbols() != null && rule.getPushSymbols().length > 0) {
                    stack.push(rule.getPushSymbols());
                }

                return rule.getNewState();
            }
        }

        return INVALID_STATE;
    }

    /**
     * Checks whether the given {@code state} is accepted or not.
     *
     * @param state The state that is being checked.
     * @return A boolean state indicating whether the given {@code state} is accepted or not.
     */
    private boolean isStateAccepted(int state) {
        for (int acceptedState : acceptedStates) {
            if (acceptedState == state) {
                return true;
            }
        }

        return false;
    }

    /**
     * Tries to find a meta variable with the given {@code symbol}.
     *
     * @param symbol The currently read symbol.
     * @return A {@link MetaVariable} object instance. Null if no meta variable was found.
     */
    private MetaVariable tryToFindMetaVariable(char symbol) {
        for(MetaVariable metaVariable : metaVariables) {
            for(char metaSymbol : metaVariable.getSymbols()) {
                if(metaSymbol == symbol) {
                    return metaVariable;
                }
            }
        }

        return null;
    }
}
