import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClickListener extends KeyAdapter implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT) {
        }
        if(e.getKeyCode()== KeyEvent.VK_W){
        }
        if(e.getKeyCode()== KeyEvent.VK_S){
        }
        if(e.getKeyCode()== KeyEvent.VK_D){
        }
        if(e.getKeyCode()== KeyEvent.VK_A){
        }

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }
}
