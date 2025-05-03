class Ex2{
    private int a;
    private char b;
    public Ex2(){

    }
    public void tipareste(){
        System.out.println(a+" "+b);
    }
}
class Lectia2{
    public static void main(String[] argv){
        Ex2 obiect2=new Ex2();
        obiect2.tipareste();
    }
}
class Sertar{
    private int l;
    private int L;
    private int H;
    public Sertar(int lungime,int latime,int inaltime){
        this.L=lungime;
        this.l=latime;
        this.H=inaltime;
    }
    public void afiseaza(){
        System.out.println(L+" "+l+" "+H);
    }
}
class Birou{
    private int l;
    private int L;
    private int H;
    private Sertar sertar1;
    private Sertar sertar2;
    public Birou(int lungime,int latime,int inaltime,Sertar sertar1,Sertar sertar2){
        this.L=lungime;
        this.l=latime;
        this.H=inaltime;
        this.sertar1=sertar1;
        this.sertar2=sertar2;
    }
    public void afiseaza(){
        System.out.println(L+" "+l+" "+H);
        sertar1.afiseaza();
        sertar2.afiseaza();
    }
}
class Ex4{
    public static void main(String[] argv){
        Sertar sertar1=new Sertar(10,20,30);
        Sertar sertar2=new Sertar(20,30,40);
        Birou birou1=new Birou(100,200,300,sertar1,sertar2);
        birou1.afiseaza();
    }
}
class Complex{
    double real;
    double imaginar;
    static int contor=0;
    public Complex(double real,double imaginar){
        this.real=real;
        this.imaginar=imaginar;
    }
    public double modul(){
        return Math.sqrt(real*real+imaginar*imaginar);
    }
    public void afiseaza(){
        System.out.println(real+"+"+"i*"+imaginar);
        contor++;
    }
    public Complex adunare(Complex complex1)
    {
        double real1=this.real+complex1.real;
        double imaginar1=this.imaginar+complex1.imaginar;
        return new Complex(real1,imaginar1);
    }
    public static int getContor(){
        return contor;
    }
}
class ClientComplex{
    public static void main(String[] argv){
        Complex complex1=new Complex(1,1);
        Complex complex2=new Complex(2,2);
        complex1.afiseaza();
        complex2.afiseaza();
        double modul1=complex1.modul();
        System.out.println(modul1);
        Complex complex3=complex1.adunare(complex2);
        complex3.afiseaza();
        int contor=complex3.getContor();
        System.out.println(contor);
    }
}