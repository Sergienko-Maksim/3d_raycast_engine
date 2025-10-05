public interface MapInterface {

    public int Heigth();
    public int Width();
    public void SetMap(char[][] Map);
    public void ClearMap();
    public char[][] GetMap();
    public void InputMap();
    public byte PlayerMov(float j, float i);
}
