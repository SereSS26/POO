class Card{
    private String numar;
    private double sold;
    public Card(String numar,double sold){
        this.numar=numar;
        this.sold=sold;
    }
    public String getNumar(){
        return this.numar;
    }
    public double getSold(){
        return this.sold;
    }
    public String toString(){
        String rezultat="<"+this.numar+","+this.sold+"> ";
        return rezultat;
    }
}
class Portofel{
    private String nume;
    private int contor;
    private Card[] carduri;
    public Portofel(String nume){
        this.nume=nume;
        this.contor=0;
        this.carduri=new Card[6];
    } 
    public boolean adaugaCard(String numar1,double sold1){
        int ok=0;
        int i=0;
        if(this.contor>=6){
            return false;
        }
        for(i=0;i<this.contor;i++){
            if(numar1.equals(this.carduri[i].getNumar())){
                ok=1;
            }
        }
        if(ok==1){
            return false;
        }
        else{
            this.carduri[this.contor]=new Card(numar1,sold1);
            this.contor++;
            return true;
        }
    }
    public String toString(){
        String rezultat=this.nume+":";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.carduri[i].toString();
        }
        return rezultat;
    }
    public double calculeazaSold(){
        int i=0;
        double suma=0;
        double elemente=this.contor;
        for(i=0;i<this.contor;i++){
            suma=suma+this.carduri[i].getSold();
        }
        suma=suma/elemente;
        return suma;
    }
}
class Ex{
    public static void main(String[] args) {
        Portofel portofel1=new Portofel("Artur");
        portofel1.adaugaCard("1",0);
        portofel1.adaugaCard("2",3);
        portofel1.adaugaCard("3",2.4);
        portofel1.adaugaCard("4",14.2);
        System.out.println(portofel1.toString());
        System.out.println(portofel1.calculeazaSold());
    }
}