import java.util.Date;
import java.util.Random;

class Out extends Exception{
    public Out(String mesaj){
        super(mesaj);
    }
}
class Gol extends Exception{
    public Gol(String mesaj){
        super(mesaj);
    }
}
class Corner extends Exception{
    public Corner(String mesaj){
        super(mesaj);
    }
}
class Minge{
    private int x;
    private int y;
    public Minge(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void suteaza(Generator generator) throws Out,Gol,Corner{
        this.x = generator.generateX();
        this.y = generator.generateY();
        if(y==0||y==50){
            throw new Out("Mingea a ieșit în out la ("+x+", "+y+").");
        }else if((x==0||x==100)&&y>=20&&y<=30){
            throw new Gol("GOL! Mingea a ajuns în poartă la ("+x+", "+y+").");
        }else if(x==0||x==100){
            throw new Corner("Corner la ("+x+", "+y+").");
        }
    }
}
class Generator{
    private Random randomGenerator;
    public Generator(){
        Date now=new Date();
        long sec=now.getTime();
        randomGenerator=new Random(sec);
    }
    public int generateX(){
        int x=randomGenerator.nextInt(101);
        if(x<5){
            x=0;
        }else if(x>95){
            x=100;
        }else{
            x=randomGenerator.nextInt(99)+1;
        }
        return x;
    }
    public int generateY(){
        int y=randomGenerator.nextInt(101);
        if(y<5){
            y=0;
        }else if(y>95){
            y=50;
        }else{
            y=randomGenerator.nextInt(49)+1;
        }
        return y;
    }
}
class Joc{
    private String echipa1;
    private String echipa2;
    private int goluriEchipa1;
    private int goluriEchipa2;
    private int totalOuturi;
    private int totalCornere;
    public Joc(String echipa1,String echipa2){
        this.echipa1=echipa1;
        this.echipa2=echipa2;
        this.goluriEchipa1=0;
        this.goluriEchipa2=0;
        this.totalOuturi=0;
        this.totalCornere=0;
    }
    public void simuleaza(){
        Generator generator=new Generator();
        Minge minge=new Minge(50, 25);// Mingea incepe de la centru
        int i=0;
        for(i=0;i<1000;i++){
            try{
                System.out.println(echipa1+" - "+echipa2+" : Mingea se află la coordonatele("+minge.getX()+", "+minge.getY()+").");
                minge.suteaza(generator);
            }catch(Out e){
                System.out.println(e.getMessage());
                totalOuturi++;
                // Mingea rămâne pe aceeași poziție
            }catch(Gol e){
                System.out.println(e.getMessage());
                if(minge.getX()==0){
                    goluriEchipa2++;
                }else{
                    goluriEchipa1++;
                }
                // Mingea revine la centru
                minge=new Minge(50, 25);
            }catch(Corner e){
                System.out.println(e.getMessage());
                totalCornere++;
                // Mingea se mută în colțul corespunzător
                if(minge.getX()==0){
                    minge=new Minge(0,(minge.getY()<25)?0:50);
                }else{
                    minge=new Minge(100,(minge.getY()<25)?0:50);
                }
            }
        }
    }
    public String toString(){
        String rezultat=echipa1+"-"+echipa2+":"+goluriEchipa1+"-"+goluriEchipa2+"\n"+
        "Statistici:\n"+
        "Total out-uri:"+totalOuturi+"\n"+
        "Total cornere:"+totalCornere;
        return rezultat;
    }
}
class Ex4{
    public static void main(String[] args){
        Joc joc1=new Joc("Echipa A", "Echipa B");
        Joc joc2=new Joc("Echipa C", "Echipa D");

        System.out.println("Simulăm primul joc:");
        joc1.simuleaza();
        System.out.println(joc1);

        System.out.println("\nSimulăm al doilea joc:");
        joc2.simuleaza();
        System.out.println(joc2);
    }
}
