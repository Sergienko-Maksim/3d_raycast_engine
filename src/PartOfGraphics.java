import java.awt.*;

public class PartOfGraphics {
    private short length;
    private final float rot;
    private byte entity = 1;
    private Map map;
    private static byte v = 30;
    static int lengthOfVision = 900;
    public Color color;

    public PartOfGraphics(float rot, Map map, Color color){
        this.rot = rot;
        this.map = map;
        this.color = color;
    }

    public static byte getV() {
        return v;
    }

    public static void setV(byte v) {
        PartOfGraphics.v = v;
    }

    public static int getLengthOfVision() {
        return lengthOfVision;
    }

    public static void setLengthOfVision(int lengthOfVision) {
        PartOfGraphics.lengthOfVision = lengthOfVision;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(double playerRot, double x, double y){
        if(playerRot+rot>360){
            playerRot=playerRot-360+rot;
        }
        else if(playerRot+rot<0){
            playerRot=360+rot+playerRot;
        }
        else{
            playerRot+=rot;
        }

        short counter = 0;

        while(true){

            if(playerRot>90 && playerRot<=180) {
                x += (1 - ((playerRot - 90) / 90))/v;
                y += ((playerRot - 90) / 90)/v;
            }
            else if(playerRot>0 && playerRot<=90) {
                x += (1 - ((90-playerRot) / 90))/v;
                y -= ((90-playerRot) / 90)/v;
            }
            else if(playerRot>270 && playerRot<=360) {
                x -= (1-((playerRot-270)/90))/v;
                y -= ((playerRot-270)/90)/v;
            }
            else{
                x -= (((playerRot-180)/90))/v;
                y += (1-(playerRot-180)/90)/v;
            }
            counter++;
            entity = map.movPlayer((short)x, (short)y);
            if(entity !=0|| counter>= lengthOfVision){
                break;
            }
        }
        double coaf = 255-counter*((double)254/(double) lengthOfVision);

        if(entity ==2){
            color = Color.BLUE;
        }
        else {
            color = Color.GRAY;
        }

        length = (short)((lengthOfVision - counter)*2/(lengthOfVision /41));
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
