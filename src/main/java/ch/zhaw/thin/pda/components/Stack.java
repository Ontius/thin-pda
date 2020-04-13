package ch.zhaw.thin.pda.components;

import java.util.Arrays;

public class Stack {

    public static final char INITIAL_STACK_SYMBOL = '$';
    private char[] stack;

    /**
     * Creates a {@link Stack} object instance. The initial stack has the following content: [ '$' ].
     */
    public Stack() {
        stack = new char[] { INITIAL_STACK_SYMBOL };
    }

    /**
     * Returns the symbol being located on the top of the stack.
     *
     * @return The symbol being located on the top of the stack.
     */
    public char top() {
        return stack[stack.length - 1];
    }

    /**
     * Pushes the given {@code symbols} to the stack.
     *
     * @param symbols The symbols that are being pushed.
     */
    public void push(char... symbols) {
        if(symbols.length == 0) {
            return;
        }

        char[] newStack = new char[stack.length + symbols.length];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;

        for(int i = 0; i < symbols.length; i++) {
            stack[stack.length - i - 1] = symbols[i];
        }
    }

    /**
     * Pops the last element of the stack.
     *
     * @return The symbol that was removed from the stack.
     */
    public char pop() {
        if(stack.length == 0) {
            return INITIAL_STACK_SYMBOL;
        }

        char symbol = stack[stack.length - 1];
        stack = Arrays.copyOf(stack, stack.length - 1);
        return symbol;
    }

}
