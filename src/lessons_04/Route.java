package lessons_04;

public class Route {
    public String fromPoint;
    public String toPoint;
    public double distance;
    public Route(String fromPoint, String toPoint, double distance) {
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.distance = distance;
    }
    public void showRoute(){
        System.out.printf("%s - %s: %.2f km\n", this.fromPoint, this.toPoint, this.distance);
    }
}
