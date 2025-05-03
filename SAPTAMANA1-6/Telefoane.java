import java.util.Random;
class Telefon{
    private String nume;
    private String[] apeluri;
    private int contor;
    public Telefon(String nume){
        this.nume=nume;
        this.apeluri=new String[100];
        this.contor=0;
    }
    public boolean apeleaza(Telefon telefon1){
        if(telefon1.contor<100){
            telefon1.apeluri[telefon1.contor]=this.nume;
            telefon1.contor++;
            return true;
        }
        else{
            return false;
        }
    }
    public Integer numarDeApeluri(String nume){
        int i=0;
        Integer j=0;
        for(i=0;i<this.contor;i++){
            if(this.apeluri[i].equals(nume)){
                j++;
            }
        }
        return j;
    }
    public String getNume(){
        return this.nume;
    }
    public String toString(){
        String rezultat=this.getNume()+": ";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.apeluri[i]+" ";
        }
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args){
        Telefon telefon1=new Telefon("Artur");
        Telefon telefon2=new Telefon("Alex");
        Telefon telefon3=new Telefon("Tobi");
        Telefon telefon4=new Telefon("Mirela");
        int a=40;
        int i=0;
        Telefon[] telefoane = { telefon1, telefon2, telefon3, telefon4 };
        Random random = new Random();
        for(i=0;i<a;i++){
            int apelantIndex = random.nextInt(telefoane.length);
            int destinatarIndex = random.nextInt(telefoane.length);

            while (apelantIndex == destinatarIndex) {
                destinatarIndex = random.nextInt(telefoane.length);
            }

            Telefon apelant = telefoane[apelantIndex];
            Telefon destinatar = telefoane[destinatarIndex];
            apelant.apeleaza(destinatar);
        }
        System.out.println(telefon1.toString());
        System.out.println(telefon2.toString());
        System.out.println(telefon3.toString());
        System.out.println(telefon4.toString());
    }
}