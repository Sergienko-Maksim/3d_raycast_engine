import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map implements MapInterface{
    private char[][] Map;
    short x,y;
    List<Entity> EntityList = new ArrayList<>();

    Map(char[][] Map){
        this.Map = Map;
    }

    Map(Map map){
        this.Map = map.getMap();
    }

    Map(short a){
        final String FILE_PATH = "map" + a + ".txt";
       File file = new File(FILE_PATH);
         Scanner FileScanner;


            try {
                FileScanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        short heigth = (short) FileScanner.nextInt();
        short width  = (short) FileScanner.nextInt();
       Map = new char[heigth][width];
        String line=FileScanner.nextLine();
        for (short i = 0; i < heigth; i++) {
                line = FileScanner.nextLine();
                for (short j = 0; j < width; j++) {
                    Map[i][j] = line.charAt(j);
                }
            }
        y=FileScanner.nextShort();
        x=FileScanner.nextShort();
            Map[y][x]='*';

        }

        public short getX(){
            return x;
        }

    public short getY(){
        return y;
    }




    public int getHeigth(){
        return Map.length;
    }

    public int getWidth(){
        return Map[0].length;
    }

    public void setMap(char[][] Map){
        this.Map = Map;
    }

    public void clearMap(){
        try {
            for (int i = 0; i < Map.length; i++) {
                for (int j = 0; j < Map[i].length; j++) {
                    Map[i][j] = 0;
                }
            }
        }catch (NullPointerException e) {
            System.out.println(e);
        }

    }

    public char[][] getMap(){
        return Map;
    }

    public byte movPlayer(float j, float i){
        try {
            if(Map[0].length-1<j || Map.length-1<i){
                return 1;
            }
            else if(Map[(short)i][(short)j] == ' '){
                return 0;
            }
            else{
                for (int k = 0; k < EntityList.size(); k++) {
                    double x1,y1,x2,y2;

                    x1=(short)(EntityList.get(k).x)-(EntityList.get(k).size/2);
                    y1=(short)(EntityList.get(k).y)-(EntityList.get(k).size/2);
                    x2=(short)(EntityList.get(k).x)+(EntityList.get(k).size/2);
                    y2=(short)(EntityList.get(k).y)+(EntityList.get(k).size/2);
                    if(y1<=i && y2>=i && x1<=j && x2>=j){

                        return 2;
                    }
                }
                return 1;
            }
        }catch (NullPointerException e){
            System.out.println(e);
            return 1;
        }
    }



    public void outputMap(){
        try {
            for (short i = 0; i < Map.length; i++) {
                for (short j = 0; j < Map[i].length; j++) {
                    System.out.print(Map[i][j]);
                }
                System.out.println();
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }

    public int spawnEntity(Entity entity){
        EntityList.add(entity);
        Map[(short)entity.y][(short)entity.x]='&';
        return EntityList.size()-1;
    }

    public void movEntity(float x, float y, int index){
        Entity entity = EntityList.get(index);
        Map[(short)y][(short)x] = '&';
        Map[(short)entity.y][(short)entity.x] = ' ';
        entity.x = x;
        entity.y = y;

    }



}
