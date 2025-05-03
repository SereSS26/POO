import java.util.*;
abstract class Autovehicul{

    private String numarInmatriculare;
    private double greutate;
    public Autovehicul(String numarInmatriculare,double greutate){
        this.numarInmatriculare=numarInmatriculare;
        this.greutate=greutate;
    }
    public String getNumarInmatriculare(){
        return this.numarInmatriculare;
    }
    public double getGreutate(){
        return this.greutate;
    }
    public abstract double calculeazaGreutateTotala();
    public abstract String toString();
}
class Autoturism extends Autovehicul{
    private double greutatePasageri;
    public Autoturism(String numarInmatriculare,double greutate,double greutatePasageri){
        super(numarInmatriculare,greutate);
        this.greutatePasageri=greutatePasageri;
    }
    public double calculeazaGreutateTotala(){
        return this.greutatePasageri+this.getGreutate();
    }
    public String toString(){
        return "<"+this.getNumarInmatriculare()+"-"+this.getGreutate()+"-"+this.greutatePasageri+">";
    }
}
class Camion extends Autovehicul{
    private ArrayList<Autovehicul> autovehicule=new ArrayList<Autovehicul>();
    private int numarAutoturisme;
    public Camion(String numarInmatriculare,double greutate){
        super(numarInmatriculare, greutate);
        this.numarAutoturisme=0;
    }
    public void adaugaAutoturism(Autovehicul autoturism){
        autovehicule.add(autoturism);
    }
    public double calculeazaGreutateTotala(){
        double rezultat=this.getGreutate();
        int i=0;
        for(i=0;i<this.autovehicule.size();i++){
            rezultat=rezultat+autovehicule.get(i).calculeazaGreutateTotala();
        }
        return rezultat;
    }
    public String toString(){
        String rezultat=this.getNumarInmatriculare()+"-"+this.getGreutate()+"-Contine:";
        int i=0;
        for(i=0;i<this.autovehicule.size();i++){
            rezultat=rezultat+this.autovehicule.get(i).toString();
        }
        return rezultat;
    }
}
class Bac{
    private double greutateMaxima;
    private double greutate;
    private ArrayList<Autovehicul> autovehicule=new ArrayList<Autovehicul>();
    public Bac(double greutateMaxima){
        this.greutate=0;
        this.greutateMaxima=greutateMaxima;
    }
    public boolean adaugaAutovehicul(Autovehicul autovehicul){
        if(this.greutate+autovehicul.calculeazaGreutateTotala()<=greutateMaxima){
            this.autovehicule.add(autovehicul);
            this.greutate=this.greutate+autovehicul.calculeazaGreutateTotala();
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="<"+this.greutate+" Contine:";
        int i=0;
        for(i=0;i<this.autovehicule.size();i++){
            rezultat=rezultat+this.autovehicule.get(i).toString();
        }
        rezultat=rezultat+">";
        return rezultat;
    }
}
class Transport{
    public static void main(String[] args){
        Autoturism autoturism1=new Autoturism("1", 4, 0.3);
        Autoturism autoturism2=new Autoturism("2", 5, 0.25);
        Autoturism autoturism3=new Autoturism("3", 4.5, 0.15);
        Camion camion1=new Camion("1", 10);
        camion1.adaugaAutoturism(autoturism1);
        camion1.adaugaAutoturism(autoturism2);
        Bac bac1=new Bac(20);
        bac1.adaugaAutovehicul(camion1);
        bac1.adaugaAutovehicul(autoturism3);
        System.out.println(bac1.toString());
    }
}