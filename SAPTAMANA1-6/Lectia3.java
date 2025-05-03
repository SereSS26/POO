class Carte{
    private int numarPagini;
    public Carte(int numarPagini){
        this.numarPagini=numarPagini;
    }
    public void afiseaza(){
        System.out.println(numarPagini);
    }
    public boolean comparare(Carte carte1){
        if(carte1.numarPagini==this.numarPagini){
            return true;
        }
        else{
            return false;
        }
    }
}
class Ex2{
    public static void main(String[] argv){
        Carte carte1=new Carte(10);
        Carte carte2=new Carte(10);
        boolean ok=carte1.comparare(carte2);
        System.out.println(ok);
    }
}
class Patrat{
    private int latura;
    public Patrat(){
        this.latura=10;
    }
    public Patrat(int latura){
        this.latura=latura;
    }
    public void tipareste(){
        System.out.println("Aria este: "+latura*latura);
    }
}
class Ex3{
    public static void main(String[] args) {
        Patrat patrat1=new Patrat();
        Patrat patrat2=new Patrat(20);
        patrat1.tipareste();
        patrat2.tipareste();
    }
}
class Piramida{
    private int n;
    public Piramida(int n){
        this.n=n;
    }
    public void tipareste(){
        int i=0;
        int j=0;
        for(i=0;i<n;i++){
            for(j=i;j<n;j++){
                System.out.print((i+1)+" ");
            }
            System.out.println();
        }
    }
}
class Ex4{
    public static void main(String[] args) {
        Piramida piramida1=new Piramida(10);
        Piramida piramida2=new Piramida(3);
        piramida1.tipareste();
        piramida2.tipareste();
    }
}
class Suma{
    public static int suma(int a,int b){
        return a+b;
    }
    public static int suma(int a,int b,int c){
        return a+suma(b,c);
    }
    public static int suma(int a,int b,int c,int d){
        return a+suma(b,suma(c,d));
    }
}
class Ex5{
    public static void main(String[] args) {
        int suma1=Suma.suma(2,2,2,2);
        System.out.println(suma1);   
    }
}