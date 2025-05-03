
class Ex1{
    public void afisare()
    {
        System.out.println("Hello World!");
    }
}
class Ex2{
    private int a;
    private int b;
    public Ex2(int a,int b){
        this.a=a;
        this.b=b;
    }
    public void compara(){
        if(a>b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}
class Ex3{
    private int s=0;
    public void suma(){
        int i=0;
        for(i=1;i<=100;i++){
            if(i%2==1)
            {
                System.out.print(i+" ");
            }
            else{
                s=s+i;
            } 
        }
        System.out.println();
        System.out.println(s);
    }
}
class Lectia1{
    public static void main(String[] argv){
        Ex1 obiect1=new Ex1();
        obiect1.afisare();
        int a=5;
        int b=6;
        Ex2 obiect2=new Ex2(a,b);
        obiect2.compara();
        Ex3 obiect3=new Ex3();
        obiect3.suma();
    }
}