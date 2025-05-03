import java.util.*;
abstract class Tip{
    public abstract String getTip();
    public abstract String toString();
}
class Intreg extends Tip{
    private int intreg;
    public Intreg(){

    }
    public String getTip(){
        String rezultat="";
        return rezultat;
    }
    public String toString(){
        String rezultat="";
        return rezultat;
    }
}
class Sir extends Tip{
    private String sir;
    public Sir(){

    }
    public String getTip(){
        String rezultat="";
        return rezultat;
    }
    public String toString(){
        String rezultat="";
        return rezultat;
    }
}
class Colectie extends Tip{
    private List <Tip> lista=new ArrayList<Tip>();
    public Colectie(){

    }
    public String getTip(){
        String rezultat="";
        return rezultat;
    }
    public String toString(){
        String rezultat="";
        return rezultat;
    }
    public boolean egalitate(List<Tip> lista1){
        boolean rezultat=true;
        if(this.lista.size()!=lista1.size()){
            rezultat=false;
            return rezultat;
        }
        for(Tip i:lista){
            
        }
    }

}
