package it.todolist.model;

public class Singleton {
    private static Singleton istanza;
    private String valore;
    private Singleton(){ //costruttore vuoto
    }
    public static Singleton getInstance(){
        if(istanza == null){
            istanza = new Singleton();
        }
        return istanza;
    }

}
