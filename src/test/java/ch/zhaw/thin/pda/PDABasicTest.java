package ch.zhaw.thin.pda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PDABasicTest {

    private PDABasic pda;
    private final String TOO_MANY_OPERATORS =  "DDOO";
    private final String ONLY_OPERATORS =  "OOO";
    private final String ONLY_DIGITS =  "DDD";
    private final String CHAINED =  "DDODDOO";
    private final String CHAINED_BUT_INVALID =  "DDODDO";
    private final String SIMPLE = "DDO";



    @BeforeEach
    void setUp() {
        pda = new PDABasic();
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
    void shouldBeFalseIfToManyOperationsDefined() {
        Assertions.assertFalse(pda.process(TOO_MANY_OPERATORS));

    }

    @Test
    void shouldBeFalseIfOnlyOperatorsDefined() {
        Assertions.assertFalse(pda.process(ONLY_OPERATORS));
    }

    @Test
    void shouldBeFalseIfChainedButTooFewOperationsDefined() {
        Assertions.assertFalse(pda.process(CHAINED_BUT_INVALID));
    }
}
