import static java.lang.Thread.sleep;

public class Player implements PlayerInterface{


    private double x;
    private double y;
    private float v;
    private float rot = 90;
    private Map map;


    Player(double x, double y, char[][] Map, float v){
        map = new Map(Map);
        this.x = map.getX();
        this.y = map.getY();
        this.v=v;
    }
    Player(float v, short a){
        map = new Map(a);
        this.x = map.getX();
        this.y = map.getY();
        this.v=v;
    }
    Player(short a){
        map = new Map(a);
        x=map.getX();
        y=map.getY();
        v= 0.01F;
    }
    Player(Player player){
        this.x = player.getX_();
        this.y = player.getY_();
        map = player.getMap();
    }





    public void setX(short x) {
        this.x = x;
    }

    public void setY(short y) {
        this.y = y;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public void Mov(byte mov){
        double LocalRot = rot;
        double x2 = 0 ,y2 = 0;
         if(mov==2){
             if(LocalRot-180<0){
                 LocalRot += 180;
             }
             else {
                 LocalRot-=180;
             }
        }
        else if(mov==3){
             if(LocalRot-90<0){
                 LocalRot+=270;
             }
             else{
                 LocalRot-=90;
             }
        }
        else if(mov == 4 ){
             if(LocalRot+90>360){
                 LocalRot-=270;
             }
             else{
                 LocalRot+=90;
             }
        }
        if(LocalRot>90 && LocalRot<=180) {
            x2 += (1 - ((LocalRot - 90) / 90))*v;
            y2 += ((LocalRot - 90) / 90)*v;
        }
        else if(LocalRot>0 && LocalRot<=90) {
            x2 += (1 - ((90-LocalRot) / 90))*v;
            y2 -= ((90-LocalRot) / 90)*v;
        }
        else if(LocalRot>270 && LocalRot<=360) {
            x2 -= (1-((LocalRot-270)/90))*v;
            y2 -= ((LocalRot-270)/90)*v;
        }
        else{
            x2 -= (((LocalRot-180)/90))*v;
            y2 += (1-(LocalRot-180)/90)*v;
        }
        if(map.movPlayer((short)(x+x2), (short)(y+y2))==0) {
            x += x2;    y += y2;
        }
        else{
                if(LocalRot-90<0){
                    LocalRot+=270;
                }
                else{
                    LocalRot-=90;
                }
                x2=0; y2=0;
            if(LocalRot>90 && LocalRot<=180) {
                x2 += (1 - ((LocalRot - 90) / 90))*v*0.25;
                y2 += ((LocalRot - 90) / 90)*v*0.25;
            }
            else if(LocalRot>0 && LocalRot<=90) {
                x2 += (1 - ((90-LocalRot) / 90))*v*0.25;
                y2 -= ((90-LocalRot) / 90)*v*0.25;
            }
            else if(LocalRot>270 && LocalRot<=360) {
                x2 -= (1-((LocalRot-270)/90))*v*0.25;
                y2 -= ((LocalRot-270)/90)*v*0.25;
            }
            else{
                x2 -= (((LocalRot-180)/90))*v*0.25;
                y2 += (1-(LocalRot-180)/90)*v*0.25;
            }
               if(map.movPlayer((short)(x+x2), (short)(y+y2))==0){
                   x += x2; y += y2;
                }
               else{
                   if(LocalRot+90>360){
                       LocalRot-=270;
                   }
                   else{
                       LocalRot+=90;
                   }
                   x2=0; y2=0;
                   if(LocalRot>90 && LocalRot<=180) {
                       x2 += (1 - ((LocalRot - 90) / 90))*v*0.25;
                       y2 += ((LocalRot - 90) / 90)*v*0.25;
                   }
                   else if(LocalRot>0 && LocalRot<=90) {
                       x2 += (1 - ((90-LocalRot) / 90))*v*0.25;
                       y2 -= ((90-LocalRot) / 90)*v*0.25;
                   }
                   else if(LocalRot>270 && LocalRot<=360) {
                       x2 -= (1-((LocalRot-270)/90))*v*0.25;
                       y2 -= ((LocalRot-270)/90)*v*0.25;
                   }
                   else{
                       x2 -= (((LocalRot-180)/90))*v*0.25;
                       y2 += (1-(LocalRot-180)/90)*v*0.25;
                   }
                   if(map.movPlayer((short)(x+x2), (short)(y+y2))==0){
                       x += x2; y += y2;
                   }
               }
        }
    }
    public void Rot(short a){
                if(a==1) {
                    rot -= 0.15;
                    if (rot <= 0) {
                        rot = 360;
                    }
                }
                else {
                    rot += 0.15;
                    if (rot >= 360) {
                        rot = 0;
                    }
                }
    }

    @Override
    public String toString() {
        return "Player{" +
                "x=" + x +
                ", y=" + y +
                ", rot=" + rot +
                ", map=" + map +
                '}';
    }



    public Map getMap() {
        return map;
    }

    @Override
    public double getX_() {
        return x;
    }

    @Override
    public double getY_() {
        return y;
    }

    public float getRot() {
        return rot;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }
}
