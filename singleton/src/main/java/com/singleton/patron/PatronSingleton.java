package com.singleton.patron;

public class PatronSingleton {
    
    private static PatronSingleton patron;
    
    private PatronSingleton(){}
    
    
    public static PatronSingleton creaInstancia(){
    if(null==patron)
        patron=new PatronSingleton();
    return patron;
    }


    
    public Exception clone() throws CloneNotSupportedException{
    throw new CloneNotSupportedException();}
    
    public static void verInstancia(){
     System.out.println("uno "+PatronSingleton.creaInstancia());   
     System.out.println("dos "+PatronSingleton.creaInstancia()); 
    }
}