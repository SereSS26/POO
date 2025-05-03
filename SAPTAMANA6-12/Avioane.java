class Avion{
    protected String planeID;
    protected int totalEnginePower;
    public Avion(String planeID,int totalEnginePower){
        this.planeID=planeID;
        this.totalEnginePower=totalEnginePower;
    }
    public String getPlaneID(){
        return this.planeID;
    }
    public int getTotalEnginePower(){
        return this.totalEnginePower;
    }
    public void takeOff(){
        System.out.println(this.planeID+" - Initiating takeoff procedure - Starting engines - Accelerating down the runway - Taking off - Retracting gear - Takeoff complete");
    }
    public void fly(){
        System.out.println(this.planeID+" - Flying");
    }
    public void land(){
        System.out.println(this.planeID+" - Initiating landing procedure - Enabling airbrakes - Lowering gear - Contacting runway - Decelerating - Stopping engines - Landing complete");
    }
}
class AvionPasageri extends Avion{
    protected int maxPasenggers;
    public AvionPasageri(String planeID,int totalEnginePower,int maxPasenggers){
        super(planeID,totalEnginePower);
        this.maxPasenggers=maxPasenggers;
    }
    public int getMaxPasenggers(){
        return this.maxPasenggers;
    }
}
class Concorde extends AvionPasageri{
    public Concorde(String planeID,int totalEnginePower,int maxPasenggers){
        super(planeID,totalEnginePower,maxPasenggers);
    }
    public void goSuperSonic(){
        System.out.println(this.planeID+ "- Supersonic mode activated");
    }
    public void goSubSonic(){
        System.out.println(this.planeID+ "- Supersonic mode deactivated");
    }
}
class Boeing extends AvionPasageri{
    public Boeing(String planeID,int totalEnginePower,int maxPasenggers){
        super(planeID,totalEnginePower,maxPasenggers);
    }
}
class AvionLupta extends Avion{
    public AvionLupta(String planeID,int totalEnginePower){
        super(planeID,totalEnginePower);
    }
    public void launchMissile(){
        System.out.println(this.planeID+ "- Initiating missile launch procedure - Acquiring target - Launching missile - Breaking away - Missile launch complete");
    }
}
class Mig extends AvionLupta{
    public Mig(String planeID,int totalEnginePower){
        super(planeID,totalEnginePower);
    }
    public void highSpeedGeometry(){
        System.out.println(planeID+" - High speed geometry selected");
    }
    public void normalGeometry(){
        System.out.println(planeID+" - Normal geometry selected");
    }
}
class TomCat extends AvionLupta{
    public TomCat(String planeID,int totalEnginePower){
        super(planeID,totalEnginePower);
    }
    public void refuel(){///cum e posibil sa alimentezi un avion in zbor???
        System.out.println(planeID+" - Initiating refueling procedure - Locating refueller - Catching up - Refueling - Refueling complete");
    }
}
class Ex{
    public static void main(String[] args) {
        Avion avion1=new Concorde("Concorde", 100, 50);
        Avion avion2=new Boeing("Boeing", 50, 30);
        Avion avion3=new Mig("Mig", 250);
        Avion avion4=new TomCat("TomCat", 200);
        avion1.takeOff();
        avion1.fly();
        avion1.land();
        if(avion1 instanceof Concorde){
            ((Concorde)avion1).goSuperSonic();
            ((Concorde)avion1).goSubSonic();
        }
        if(avion3 instanceof AvionLupta){
            ((AvionLupta)avion3).launchMissile();
        }
        ///Se mai pot adauga comenzi pentru teste...
    }
}