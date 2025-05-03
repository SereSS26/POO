import java.util.*;
abstract class Utilizator{
    private String nume;
    public Utilizator(String nume){
        this.nume=nume;
    }
    public String getNume(){
        return this.nume;
    }
    public abstract double calculeazaVenit(int minuteVizionate);
    public abstract String toString();
}
class Subscriber extends Utilizator{
    private int nivelSubscriptie;
    public Subscriber(String nume,int nivelSubscriptie)
    {
        super(nume);
        this.nivelSubscriptie=nivelSubscriptie;
    }
    public double calculeazaVenit(int minuteVizionate){
        double rezultat=minuteVizionate;
        return rezultat*1.5*this.nivelSubscriptie;
    }
    public String toString(){
        String rezultat="<"+this.getNume()+"-"+this.nivelSubscriptie+">";
        return rezultat;
    }
}
class Creator extends Utilizator{
    private ArrayList<Subscriber> subscriberi=new ArrayList<Subscriber>();
    public Creator(String nume){
        super(nume);
    }
    public void adaugaSubscriber(Subscriber subscriber){
        subscriberi.add(subscriber);
    }
    public double calculeazaVenit(int minuteVizionate){
        double rezultat=0;
        int i=0;
        for(i=0;i<subscriberi.size();i++){
            rezultat=rezultat+this.subscriberi.get(i).calculeazaVenit(minuteVizionate);
        }
        return rezultat;
    }
    public String toString(){
        String rezultat=this.getNume()+" ";
        int i=0;
        for(i=0;i<subscriberi.size();i++){
            rezultat=rezultat+this.subscriberi.get(i).toString()+" ";
        }
        return rezultat;
    }
}
class Platforma{
    private static final int MAX_UTILIZATORI=100;
    private Utilizator[] utilizatori;
    private int numarUtilizatori;
    public Platforma(){
        this.utilizatori=new Utilizator[MAX_UTILIZATORI];
        this.numarUtilizatori=0;
    }
    public boolean adaugaUtilizator(Utilizator utilizator){
        if(this.numarUtilizatori<MAX_UTILIZATORI){
            this.utilizatori[this.numarUtilizatori]=utilizator;
            this.numarUtilizatori++;
            return true;
        }
        else{
            return false;
        }
    }
    public Utilizator determinaVIP(int minuteVizionate){
        Utilizator vip=null;
        double maxVenit=0;
        int i=0;
        for(i=0;i<this.numarUtilizatori;i++){
            if(utilizatori[i].calculeazaVenit(minuteVizionate)>maxVenit){
                maxVenit=utilizatori[i].calculeazaVenit(minuteVizionate);
                vip=utilizatori[i];
            }
        }
        return vip;
    }
}
class Twitch{
    public static void main(String[] args) {
        Platforma platforma=new Platforma();
        Subscriber subscriber1=new Subscriber("Alina", 1);
        Subscriber subscriber2=new Subscriber("Mirela", 1);
        Subscriber subscriber3=new Subscriber("Nadira", 2);
        Subscriber subscriber4=new Subscriber("Sabina", 2);
        Subscriber subscriber5=new Subscriber("Roxi", 2);
        Creator creator1=new Creator("Artur");
        Creator creator2=new Creator("Solo");
        creator1.adaugaSubscriber(subscriber1);
        creator1.adaugaSubscriber(subscriber2);
        creator1.adaugaSubscriber(subscriber3);
        platforma.adaugaUtilizator(creator1);
        platforma.adaugaUtilizator(creator2);
        platforma.adaugaUtilizator(subscriber1);
        Utilizator vip=platforma.determinaVIP(30);
        if(vip!=null){
            System.out.println(vip.toString());
        }
    }
}