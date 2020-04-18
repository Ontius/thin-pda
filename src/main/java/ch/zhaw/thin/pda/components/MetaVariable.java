package ch.zhaw.thin.pda.components;

/**
 * The MetaVariable class represents a meta variable. That means a specific character is an alias for
 * multiple different characters.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class MetaVariable {

    private final char alias;
    private final char[] symbols;

    /**
     * Creates a {@link MetaVariable} object instance with the given arguments.
     *
     * @param alias The alias that is being set.
     * @param symbols The symbols that are being substituted by the given alias.
     */
    public MetaVariable(char alias, char[] symbols) {
        this.alias = alias;
        this.symbols = symbols;
    }

    /**
     * Returns the alias.
     *
     * @return The alias.
     */
    public char getAlias() {
        return alias;
    }

    /**
     * Returns the symbols that are being substituted by the given alias.
     *
     * @return The symbols.
     */
    public char[] getSymbols() {
        return symbols;
    }
}
