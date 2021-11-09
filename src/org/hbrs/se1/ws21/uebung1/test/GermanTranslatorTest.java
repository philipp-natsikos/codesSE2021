package org.hbrs.se1.ws21.uebung1.test;


import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @org.junit.jupiter.api.Test
    void translateNumber() {
        GermanTranslator x = new GermanTranslator();
        assertEquals("Übersetzung der Zahl " + -1 + " nicht\n" +
                "möglich" + 1.0, x.translateNumber(-1));
        assertEquals("Übersetzung der Zahl " + 0 + " nicht\n" +
                "möglich" + 1.0, x.translateNumber(0));
        assertEquals("Übersetzung der Zahl " + 11 + " nicht\n" +
                "möglich" + 1.0, x.translateNumber(11));
        assertEquals("fünf", x.translateNumber(5));
    }
}