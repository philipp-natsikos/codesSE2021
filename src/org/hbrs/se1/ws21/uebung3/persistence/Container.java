package org.hbrs.se1.ws21.uebung3.persistence;
import org.hbrs.se1.ws21.uebung2.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Container {

//    Member [] liste;

    public List<Member> liste = new ArrayList<>();

    private static final Container OBJ = new Container();
    public PersistenceStrategyStream strategy = null;

    private Container(){
    }

    public static Container getInstance(){
        return OBJ;
    }

    public void setX(PersistenceStrategyStream x) {
        this.strategy = x;
    }

    public void store() throws PersistenceException{
        if(strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Setz eine strategy");
        }
        strategy.openConnection();
        strategy.save(liste);
        strategy.closeConnection();

    }

    public void load()throws PersistenceException{
        if(strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Setz eine strategy");
        }
        strategy.openConnection();
        this.liste = strategy.load();
        strategy.closeConnection();
    }


    public void addMember(Member member) throws ContainerException {

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

    public int size(){
        return this.liste.size();
    }


}
