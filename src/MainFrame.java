import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class MainFrame extends Thread {
    Frame frame = new Frame();
    final short speed;
    Player player;
    final int GraphicsQuality;
    PartOfGraphics[] Graphics;


    MainFrame(boolean Vis, short speed, Player player, short GraphicsQuality) {
        this.speed = speed;
        this.player = player;
        this.GraphicsQuality = GraphicsQuality;
        if (this.GraphicsQuality > 2400) {
            GraphicsQuality = 800;
        }
        if (this.GraphicsQuality < 1) {
            GraphicsQuality = 64;
        }
        if (2400 % this.GraphicsQuality != 0) {
            GraphicsQuality = 200;
        }
        Graphics = new PartOfGraphics[this.GraphicsQuality];
        frame.setSize(1600, 900);
        frame.setVisible(Vis);
    }

    public void InputArray(Color color) {
        float step = 100 / (float) GraphicsQuality;
        for (short i = 0; i < GraphicsQuality; i++) {
            Graphics[i] = new PartOfGraphics((100 - step * i), player.getMap(), color);
        }
    }

    @Override
    public void run() {
        frame.addKeyListener(new ClickListener() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    LocalMessege('w');
                } else if (keyCode == KeyEvent.VK_S) {
                    LocalMessege('s');
                } else if (keyCode == KeyEvent.VK_A) {
                    LocalMessege('a');
                } else if (keyCode == KeyEvent.VK_D) {
                    LocalMessege('d');
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    LocalMessege('l');
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    LocalMessege('r');
                }
            }

        });
    }

    public void DrawGraphics() {
        RenderGraphics();
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                int step = 2400 / GraphicsQuality;
                int LengthOfVision = 3600 / PartOfGraphics.LengthOfVision;
                for (short i = 0; i < GraphicsQuality; i++) {
                    for (short j = 0; j < step; j++) {
                        g.setColor(Graphics[i].color);

                        g.drawLine(i * step + j,
                                450 + Graphics[i].getLength() * LengthOfVision,
                                i * step + j,
                                450 - Graphics[i].getLength() * LengthOfVision);
                    }
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    public void LocalMessege(char str) {
        for (int i = 0; i < speed; i++) {
            Main.Messege(str);
        }


    }

    public void RenderGraphics() {
        for (short i = 0; i < GraphicsQuality; i++) {
            Graphics[i].Render(player.getRot(), player.getX_(), player.getY_());
        }
    }

}

 /*   public void DrawGraphics(){


        for (byte i = 42; i>0; i--) {
            for (byte j = 0; j < 64; j++) {
                Graphics[j].draw(i);
                Graphics[j].draw(i);
                Graphics[j].draw(i);
                Graphics[j].draw(i);
            }
            System.out.println();
            }



        }

    }
*/

