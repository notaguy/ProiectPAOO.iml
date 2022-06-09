package PaooGame.KeyManage;

import PaooGame.Game;
import PaooGame.Handler;
import PaooGame.State.State;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right,space,esc;

    private Handler handler;

    public KeyManager(){
        keys = new boolean[256];
    }
    public KeyManager(Handler handler){
        keys = new boolean[256];
        this.handler=handler;
    }

    public void Update(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        space = keys[KeyEvent.VK_SPACE];
        esc=keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        keys[e.getKeyCode()] = true;
        //System.out.println("am apasat");

            if(code==KeyEvent.VK_ESCAPE)
            {
                esc=true;
            }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            esc=false;

    }
}
