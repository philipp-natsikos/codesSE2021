package org.hbrs.se1.ws21.uebung2;

public class ContainerException extends Exception {

    public ContainerException(Member x){
        super("Das Member-Objekt mit der ID" + x.getID() + " ist bereits\n" +
                "vorhanden!");
    }

}
