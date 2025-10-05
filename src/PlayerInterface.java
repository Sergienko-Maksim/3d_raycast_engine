public interface PlayerInterface {
    public void Mov(byte a);
    public void Rot(byte a);
    private void MakeCords(){};
    public double getX_() ;
    public double getY_();
    public Map getMap();
    public void setX(short x);
    public void setY(short y);
    public void setMap(Map map);
}
