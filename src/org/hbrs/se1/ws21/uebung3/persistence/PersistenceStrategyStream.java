package org.hbrs.se1.ws21.uebung3.persistence;

import java.io.*;

import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    // URL of file, in which the objects are stored
    private String location = "C:\\Users\\natsi\\OneDrive\\Desktop";

    private boolean connection = false;
    private ObjectInputStream oinput;
    private ObjectOutputStream ooutput;

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {
        try{
            ooutput = new ObjectOutputStream(new FileOutputStream(location));
            oinput = new ObjectInputStream(new FileInputStream(location));

        }catch (IOException x){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, x.getMessage());
        }

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            ooutput.close();
            ooutput.flush();
            oinput.close();
        }catch (IOException x){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, x.getMessage());
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {
        try{
            ooutput.writeObject(member);
            ooutput.flush();

        }catch (IOException x){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, x.getMessage());
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        //FileInputStream fis = null;
         //List<Member> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)

        try{
            Object x = oinput.readObject();
            return (List<Member>) x;

        }catch(IOException|ClassNotFoundException x){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, x.getMessage());
        }

        // Reading and extracting the list (try .. catch ommitted here)
        //Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
    }
}
