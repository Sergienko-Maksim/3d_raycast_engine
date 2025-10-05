import java.awt.*;

public class PartOfGraphics {
    private short length;
    private float rot;
    private byte Entity = 1;
    private short LastLength;
    private Map map;
    private static double v = 0.1;
     static int LengthOfVision = 600;
     public  Color color;
    public PartOfGraphics(float rot, Map map, Color color){
        this.rot = rot;
        this.map = map;
        this.color = color;
    }


    public void Render(double PlayerRot, double x, double y){
        if(PlayerRot+rot>360){
            PlayerRot=PlayerRot-360+rot;
        }
        else if(PlayerRot+rot<0){
            PlayerRot=360+rot+PlayerRot;
        }
        else{
            PlayerRot+=rot;
        }

        short counter = 0;

        while(true){

            if(PlayerRot>90 && PlayerRot<=180) {
                x += (1 - ((PlayerRot - 90) / 90))*v;
                y += ((PlayerRot - 90) / 90)*v;
            }
            else if(PlayerRot>0 && PlayerRot<=90) {
                x += (1 - ((90-PlayerRot) / 90))*v;
                y -= ((90-PlayerRot) / 90)*v;
            }
            else if(PlayerRot>270 && PlayerRot<=360) {
                x -= (1-((PlayerRot-270)/90))*v;
                y -= ((PlayerRot-270)/90)*v;
            }
            else{
                x -= (((PlayerRot-180)/90))*v;
                y += (1-(PlayerRot-180)/90)*v;
            }
            counter++;
            Entity = map.PlayerMov((short)x, (short)y);
            if(Entity !=0|| counter>=LengthOfVision ){
                break;
            }
        }
        double coaf = 255-counter*((double)254/(double)LengthOfVision);

        if(Entity==2){
            color = Color.BLUE;
        }
        else {
            color = Color.GRAY;
        }

        length = (short)((LengthOfVision - counter)/(LengthOfVision/41));
        color = new Color(color.getRed(),color.getGreen(), color.getBlue(),(int)coaf);
    }




    public short getLength() {
        return length;
    }



    public float getRot() {
        return rot;
    }

    public Map getMap() {
        return map;
    }
}
