class Card{
    private String numar;
    private double sold;
    public Card(String numar,double sold){
        this.numar=numar;
        this.sold=sold;
    }
    public double getSold(){
        return sold;
    }
    public String getNumar(){
        return numar;
    }
}
class Portofel{
    private String nume;
    private Card[] carduri;
    private int numarCarduri;
    public Portofel(String nume){
        this.nume=nume;
        this.carduri=new Card[6];
        this.numarCarduri=0;
    }
    public boolean adaugaCard(String numar,double sold){
        int ok=0;
        int i=0;
        for(i=0;i<this.numarCarduri;i++){
            if(numar.equals(carduri[i].getNumar())){
                ok=1;
            }
        }
        if(this.numarCarduri>=6){
            ok=1;
        }
        if(ok==0){
            this.carduri[numarCarduri]=new Card(numar,sold);
            this.numarCarduri++;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Portofel: "+this.nume+" ";
        int i=0;
        for(i=0;i<this.numarCarduri;i++){
            rezultat=rezultat+"Card"+(i+1)+" <"+this.carduri[i].getNumar()+"-"+this.carduri[i].getSold()+" > ";
        }
        return rezultat;
    }
    public double calculeazaSold(){
        double suma=0;
        double elemente=this.numarCarduri;
        int i=0;
        for(i=0;i<this.numarCarduri;i++){
            suma=suma+carduri[i].getSold();
        }
        suma=suma/elemente;
        return suma;
    }
}
class Ex{
    public static void main(String[] args) {
        Portofel portofel1=new Portofel("Artur");
        portofel1.adaugaCard("1",0.5);
        portofel1.adaugaCard("1", 0.6);
        portofel1.adaugaCard("2", 0.3);
        portofel1.adaugaCard("4", 1.5);
        System.out.println(portofel1.toString());
        System.out.println(portofel1.calculeazaSold());
    }
}