class Figura{
    private double arie;
    public Figura(double arie){
        this.arie=arie;
    }
    public double getArie(){
        return this.arie;
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
    public boolean adugaFigura(Figura figura1){
        int i=0;
        int ok=0;
        for(i=0;i<this.contor;i++){
            if(figura1.equals(this.figuri[i])){
                ok=1;
            }
        }
        if(ok==0)
        {
            this.figuri[contor]=figura1;
            this.contor++;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Titlu:"+this.nume+" ";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+"Figura"+(i+1)+" Arie-"+this.figuri[i].getArie()+" ";
        }
        return rezultat;
    }
    public double medieArie(){
        double arie=0;
        double elemente=0;
        int i=0;
        for(i=0;i<this.contor;i++){
            arie=arie+this.figuri[i].getArie();
        }
        elemente=this.contor;
        arie=arie/elemente;
        return arie;
    }
}
class Ex{
    public static void main(String[] args){
        Desen desen1=new Desen("desen1");
        Figura figura1=new Figura(0.5);
        Figura figura2=new Figura(0.6);
        Figura figura3=new Figura(0.74);
        Figura figura4=new Figura(0.74);
        desen1.adugaFigura(figura1);
        desen1.adugaFigura(figura2);
        desen1.adugaFigura(figura3);
        desen1.adugaFigura(figura3);
        desen1.adugaFigura(figura3);
        System.out.println(desen1.toString());
        System.out.println(desen1.medieArie());

    }
}