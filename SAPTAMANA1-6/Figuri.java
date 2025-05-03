class Figura{
    private double arie;
    public Figura(double arie){
        this.arie=arie;
    }
    public double getArie(){
        return this.arie;
    }
    public String toString(){
        String rezultat="<"+this.arie+"> ";
        return rezultat;
    }
}
class Desen{
    private String nume;
    private Figura[] figuri;
    private int contor;
    public Desen(String nume){
        this.nume=nume;
        this.figuri=new Figura[1024];
        this.contor=0;
    }
    public boolean adaugaFigura(Figura figura1){
        int ok=0;
        int i=0;
        for(i=0;i<this.contor;i++){
            if(figura1.equals(this.figuri[i])){
                ok=1;
            }
        }
        if(this.contor==1024){
            ok=1;
        }
        if(ok==0){
            this.figuri[this.contor]=figura1;
            this.contor++;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat=this.nume+":";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.figuri[i].toString();
        }
        return rezultat;
    }
    public double medieArie(){
        int i=0;
        double rezultat=0;
        double elemente=this.contor;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.figuri[i].getArie();
        }
        rezultat=rezultat/elemente;
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args) {
        Figura figura1=new Figura(1);
        Figura figura2=new Figura(1.2);
        Figura figura3=new Figura(2);
        Desen desen1=new Desen("desen1");
        desen1.adaugaFigura(figura1);
        desen1.adaugaFigura(figura2);
        desen1.adaugaFigura(figura3);
        desen1.adaugaFigura(figura1);
        System.out.println(desen1.toString());
        System.out.println(desen1.medieArie());
    }
}