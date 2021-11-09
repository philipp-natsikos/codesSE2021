package org.hbrs.se1.ws21.uebung2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Container{

//    Member [] liste;

    private Set<Member> liste = new HashSet<>();


    public void addMember(Member member) throws ContainerException{

        if (!this.liste.add(member)) {
            throw new ContainerException(member);
        }

    }

    public boolean deleteMember(int id){
   /*     Member y = null;
        for (int i = 0; i < this.liste.size(); i++) {
            Member x = this.liste.get(i);
            if(x.getID() == id){
                y = x;
                break;
            }
        }
        this.liste.remove(y);*/
        return this.liste.removeIf(member -> member.getID().equals(id));
        //Exceptions können detailliertere Fehlermeldungen enthalten
        //In meinen Fall habe ich nur binäre Werte, entweder der Member wurde entfernt oder nicht
    }

    public void dump(){
   /*     for (int i = 0; i < this.liste.size(); i++) {
            System.out.println(liste.get(i));
        }*/
        this.liste.forEach(System.out::println);
    }

    public int size(){
        return this.liste.size();
    }


}
