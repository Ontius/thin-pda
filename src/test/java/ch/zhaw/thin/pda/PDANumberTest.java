package ch.zhaw.thin.pda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PDANumberTest {

    private PDANumber pda;
    private final String ONLY_OPERATORS = "+++";
    private final String ONLY_DIGITS = "123";
    private final String CHAINED_BUT_INVALID = "12*2*";
    private final String SIMPLE = "99*";

    //Aufgabe 2: Test a
    private final String CHAINED = "34+62+*";
    //Aufgabe 2: Test b
    private final String TOO_MANY_OPERATORS = "34+*";
    //Aufgabe 2: Test c
    private final String DEVS_CHOICE = "23+89+34*89/34+*/+-";

    @BeforeEach
    void setUp() {
        pda = new PDANumber();
    }

    @AfterEach
    void CleanUp() {
        pda = null;
    }

    @Test
    void shouldBeTrueIfFollowsSimpleDefinition() {
        Assertions.assertTrue(pda.process(SIMPLE));
    }

    @Test
    void shouldBeTrueIfChainedCorrectly() {
        Assertions.assertTrue(pda.process(CHAINED));
    }

    @Test
    void shouldBeFalseIfOnlyDigitsDefined() {
        Assertions.assertFalse(pda.process(ONLY_DIGITS));
    }

    @Test
    void shouldBeFalseIfToManyOperationsDefined() { Assertions.assertFalse(pda.process(TOO_MANY_OPERATORS)); }

    @Test
    void shouldBeFalseIfOnlyOperatorsDefined() {
        Assertions.assertFalse(pda.process(ONLY_OPERATORS));
    }

    @Test
    void shouldBeFalseIfChainedButTooFewOperationsDefined() { Assertions.assertFalse(pda.process(CHAINED_BUT_INVALID)); }

    @Test
    void shouldBeTrueForDevsChoice() {Assertions.assertTrue(pda.process(DEVS_CHOICE));}
}



