package org.hbrs.se1.ws21.uebung1.control.factory;

import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;

public class Translaterfactory {
    public static GermanTranslator createGermantranslater(){
        GermanTranslator x = new GermanTranslator();
        return x;
    }
}
