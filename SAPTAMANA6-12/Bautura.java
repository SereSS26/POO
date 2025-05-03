import java.util.*;
abstract class Whiskey{
    private String nume;
    public Whiskey(String nume){
        this.nume=nume;
    }
    public String getNume(){
        return this.nume;
    }
    public abstract double getNrCalorii(double mililitrii);
    public abstract double getConcentratieAlcool();
    public abstract String toString();
}
class ClassicWhiskey extends Whiskey{
    private double concentratieAlcool;
    public ClassicWhiskey(String nume,double concentratieAlcool){
        super(nume);
        this.concentratieAlcool=concentratieAlcool;
    }
    public double getNrCalorii(double mililitrii){
        double rezultat=0;
        rezultat=this.concentratieAlcool*mililitrii*0.5;
        return rezultat;
    }
    public double getConcentratieAlcool(){
        return this.concentratieAlcool;
    }
    public String toString(){
        String rezultat="";
        rezultat="<"+this.getNume()+"-"+this.concentratieAlcool+"-"+this.getNrCalorii(100)+">";
        return rezultat;
    }
}
class JackAndHoney extends Whiskey{
    private double concentratieAlcool;
    private int indulcitor;
    public JackAndHoney(String nume,double concentratieAlcool,int indulcitor){
        super(nume);
        this.concentratieAlcool=concentratieAlcool;
        this.indulcitor=indulcitor;
    }
    public double getNrCalorii(double mililitrii){
        double rezultat=0;
        rezultat=this.concentratieAlcool*mililitrii*5+this.indulcitor*mililitrii*15;
        return rezultat;
    }
    public double getConcentratieAlcool(){
        return this.concentratieAlcool;
    }
    public String toString(){
        String rezultat="";
        rezultat="<"+this.getNume()+"-"+this.concentratieAlcool+this.getNrCalorii(100)+"-"+this.indulcitor;
        return rezultat;
    }
}
class BlendedWhiskey extends Whiskey{
    private ArrayList<Whiskey> whiskeys=new ArrayList<Whiskey>();
    private int numarWhiskeys=0;
    public BlendedWhiskey(String nume){
        super(nume);
        this.numarWhiskeys=0;
    }
    public void adaugaUnWhiskey(Whiskey whiskey){
        this.whiskeys.add(whiskey);
        this.numarWhiskeys++;
    }
    public double getConcentratieAlcool(){
        double rezultat=0;
        double contor=this.numarWhiskeys;
        int i=0;
        for(i=0;i<this.whiskeys.size();i++){
            rezultat=rezultat+this.whiskeys.get(i).getConcentratieAlcool();
        }
        rezultat=rezultat/contor;
        return rezultat;
    }
    public double getNrCalorii(double mililitrii){
        double rezultat=0;
        double numar=100/this.numarWhiskeys;
        int i=0;
        for(i=0;i<this.whiskeys.size();i++){
            rezultat=rezultat+this.whiskeys.get(i).getNrCalorii(numar);
        }
        return rezultat;
    }
    public String toString(){
        String rezultat=this.getNume()+"-"+this.getConcentratieAlcool()+"-"+this.getNrCalorii(100)+"-"+"Compozitie:";
        int i=0;
        for(i=0;i<this.whiskeys.size();i++){
            rezultat=rezultat+this.whiskeys.get(i).getNume()+" ";
        }
        rezultat=rezultat+">";
        return rezultat;
    }
}
class Bautura{
    public static void main(String[] args){
        ClassicWhiskey whiskey1=new ClassicWhiskey("Whiskey1", 0.25);
        JackAndHoney whiskey2=new JackAndHoney("Whiskey2", 0.1, 10);
        BlendedWhiskey whiskey3=new BlendedWhiskey("Whiskey3");
        whiskey3.adaugaUnWhiskey(whiskey1);
        whiskey3.adaugaUnWhiskey(whiskey2);
        BlendedWhiskey whiskey4=new BlendedWhiskey("WhiskeyBunRauDeTot");
        whiskey4.adaugaUnWhiskey(whiskey1);
        whiskey4.adaugaUnWhiskey(whiskey2);
        whiskey4.adaugaUnWhiskey(whiskey3);
        System.out.println(whiskey4.toString());
        System.out.println(whiskey4.getNrCalorii(150));
    }
}