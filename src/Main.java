import java.awt.*;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Main {
    static Scanner in =new Scanner(System.in);
    static Player player;
    static Timer timer = new Timer();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите номер карты: ");
        player = new Player(in.nextShort());
        System.out.println("Введите разрешение экрана: ");
        MainFrame frame = new MainFrame( true, (short) 40, player, in.nextShort());
        player.getMap().InputMap();
        frame.start();
        frame.InputArray(Color.DARK_GRAY);
        Entity entity = new Entity(14,14,0.1);
        int index = player.getMap().SpawnEntity(entity);
        player.getMap().InputMap();
        sleep(3000);
        player.getMap().MovEnitity(15, 15, index);
        player.getMap().InputMap();

        timer.start();
        while (true){
            timer.a++;
            frame.DrawGraphics();
        }

    }

    public static void Messege(char mess) {
    switch (mess) {
                case 'r':
                    player.Rot((byte) 1);
                    break;
                case 'l':
                    player.Rot((byte) 0);
                    break;
                case 'w':
                    player.Mov((byte) 4);
                    break;
                case 's':
                    player.Mov((byte) 3);
                    break;
                case 'a':
                    player.Mov((byte) 2);
                    break;
                case 'd':
                    player.Mov((byte) 0);
                    break;


            }


    }


}