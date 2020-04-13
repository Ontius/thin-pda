package ch.zhaw.thin.pda;

public class PdaBasic {

    private static final char DIGIT = 'D';
    private static final char OPERATION = 'O';
    private Stack stack;

    public PdaBasic() {
        stack = new Stack();
    }

    public void process(String s) {
        int state = 0;

        for(int i = 0; i < s.length(); i++) {
        }
    }

    /**
     * Returns the next state.
     *
     * @param state The current state.
     * @param symbol The current symbol that is being read.
     * @return The next state. -1 if no next state was found.
     */
    private int getNextState(int state, char symbol) {
        char topSymbol = stack.pop();

        // q0 -> q1
        if(state == 0 && symbol == DIGIT && topSymbol == Stack.INITIAL_STACK_SYMBOL) {
            stack.push(DIGIT);
            return 1;
        }

        // q1 -> q2
        if(state == 1 && symbol == DIGIT && topSymbol == DIGIT) {
            stack.push(DIGIT, DIGIT);
            return 2;
        }

        // q2 -> q3
        if(state == 2 && symbol == OPERATION && topSymbol == DIGIT) {
            // Push noting
            return 3;
        }

        // q3 -> q1
        if(state == 3 && symbol == DIGIT && topSymbol == DIGIT) {
            stack.push(DIGIT, DIGIT);
            return 1;
        }

        // q3 -> q3
        if(state == 3 && symbol == OPERATION && topSymbol == DIGIT) {
            // Push noting
            return 1;
        }

        // q3 -> q4
        // if(state == 3 && symbol == '')

        return -1;
    }
}
