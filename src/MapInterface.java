public interface MapInterface {
    public int getHeigth();
    public int getWidth();
    public void setMap(char[][] Map);
    public void clearMap();
    public char[][] getMap();
    public void outputMap();
    public byte movPlayer(float j, float i);
}
