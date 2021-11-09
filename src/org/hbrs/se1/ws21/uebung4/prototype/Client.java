package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    Scanner sc = new Scanner(System.in);
    String name;
    String vorname;
    Integer id;
    String rolle;
    String abteilung;

    public String textonlyDialogue(Scanner input, String label) {
        System.out.println("Bitte geben Sie " + label + " ein.");
        // TODO: REGEX CHECKEN
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);

        while (input.hasNext()) {
            String tmp = input.next();
            Matcher m = p.matcher(tmp);
            if (m.find()) {
                System.out.println("Bitte geben sie hier nur Buchstaben ein.");
            } else {
                return tmp;
            }
        }
        return "Fehler";
    }


    public static void main(String[] args){
        Client cl = new Client();
        System.out.println("ID?");
        cl.id = cl.sc.nextInt();
        cl.name = cl.textonlyDialogue(cl.sc,"Ihren Namen");
        cl.vorname = cl.textonlyDialogue(cl.sc, "Ihren Vornamen");
        cl.rolle = cl.textonlyDialogue(cl.sc, "Ihre Rolle");
        cl.abteilung = cl.textonlyDialogue(cl.sc, "Ihre Abteilung");
// TODO: US1 Expertise und abteilungscheck fehlen
    }
}
