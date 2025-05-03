abstract class Avion{
    private String planeID;
    private int totalEnginePower;
    public Avion(String planeID,int totalEnginePower){
        this.planeID=planeID;
        this.totalEnginePower=totalEnginePower;
    }
    public abstract String getPlaneID();
    public abstract int getTotalEnginePower();
    public abstract void takeOff();
    public abstract void fly();
    public abstract void land();
}
abstract class AvionCalatori extends Avion{
    private int maxPasagers;
    public AvionCalatori(String planeID,int totalEnginePower,int maxPasagers){
        super(planeID,totalEnginePower);
        this.maxPasagers=maxPasagers;
    }
    public abstract int getMaxPasagers();
}
abstract class AvionLupta extends Avion{

}
class Concorde extends AvionCalatori{

}
class Boeing extends AvionCalatori{
    public Boeing(String planeID,int totalEnginePower,int maxPasagers){
        super(planeID,totalEnginePower,maxPasagers);
    }
}