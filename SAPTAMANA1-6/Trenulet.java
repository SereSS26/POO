abstract class Vagon{
    public Vagon(){

    }
    abstract public int capacitateColete();
}
abstract class VagonCalatori extends Vagon{
    public VagonCalatori(){

    }
    public void deschideUsa(){
        System.out.println("Deschide Usa");
    }
    public void inchideUsa(){
        System.out.println("Inchide Usa");
    }
    abstract public int numarCalatori();
}
class CalatoriA extends VagonCalatori{
    public CalatoriA(){

    }
    public int capacitateColete(){
        return 300;
    }
    public int numarCalatori(){
        return 40;
    }
}
class CalatoriB extends VagonCalatori{
    public CalatoriB(){

    }
    public int capacitateColete(){
        return 400;
    }
    public int numarCalatori(){
        return 50;
    }
    public void blocheazaGeam(){
        System.out.println("Blocheaza Geam");
    }
}
class Marfa extends Vagon{
    public Marfa(){

    }
    public int capacitateColete(){
        return 400;
    }
}
class Tren{
    private int nrVagoane;
    private Vagon[] vagoane;
    public Tren(Vagon vagoane1[]){
        this.nrVagoane=0;
        this.vagoane=new Vagon[15];
        int i;
        int numarVagoaneAdaugate=vagoane1.length;
        if(numarVagoaneAdaugate>15){
            numarVagoaneAdaugate=15;
        }
        for(i=0;i<numarVagoaneAdaugate;i++){
            this.vagoane[i]=vagoane1[i];
            this.nrVagoane++;
        }
    }
    public int totalColete(){
        int i=0;
        int totalCapacitate=0;
        for(i=0;i<this.nrVagoane;i++){
            totalCapacitate=totalCapacitate+this.vagoane[i].capacitateColete();
        }
        return totalCapacitate;
    }
    public boolean egale(Tren tren1){
        if(this.totalColete()==tren1.totalColete()){
            return true;
        }
        else{
            return false;
        }
    }
    public void tipVagoane(){
        int i=0;
        for(i=0;i<this.nrVagoane;i++){
            if(vagoane[i].capacitateColete()==300){
                System.out.println("Vagon CalatoriA");
            }
            else{
                if(vagoane[i].capacitateColete()==400){
                    if(vagoane[i] instanceof VagonCalatori){
                        System.out.println("Vagon CalatoriB");
                    }
                    else{
                        System.out.println("Vagon Marfa");
                    }
                }
            }
        }
    }
}
class Ex4{
    public static void main(String[] args) {
        Vagon vagon1=new CalatoriA();
        Vagon vagon2=new CalatoriB();
        Vagon vagon3=new Marfa();
        System.out.println("Vagon1:");
        if(vagon1 instanceof VagonCalatori){
            ((CalatoriA)vagon1).deschideUsa();
            ((CalatoriA)vagon1).inchideUsa();
            System.out.println(((CalatoriA)vagon1).capacitateColete());
        }
        System.out.println("Vagon2:");
        if(vagon2 instanceof VagonCalatori){
            ((CalatoriB)vagon2).deschideUsa();
            ((CalatoriB)vagon2).inchideUsa();
            ((CalatoriB)vagon2).blocheazaGeam();
            System.out.println(((CalatoriB)vagon2).capacitateColete());
        }
        System.out.println("Vagon3:");
        if(vagon3 instanceof Marfa){
            System.out.println(((Marfa)vagon3).capacitateColete());
        }
        Vagon[] vagoaneCalatori={vagon1,vagon2};
        Vagon[] vagoaneMarfa={vagon3};
        Tren tren1=new Tren(vagoaneCalatori);
        Tren tren2=new Tren(vagoaneMarfa);
        System.out.println("Sunt trenurile egaele?");
        System.out.println(tren1.egale(tren2));
        tren1.tipVagoane();
    }
}