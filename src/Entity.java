public class Entity {
    double x,y,size;
    private boolean spawned;
    Entity(double x, double y){
        this.x = x;
        this.y = y;
        size=0.5;
    }
    Entity(double x, double y, double size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public boolean isSpawned() {
        return spawned;
    }
}
