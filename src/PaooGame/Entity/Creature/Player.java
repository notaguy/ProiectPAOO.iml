package PaooGame.Entity.Creature;

import PaooGame.Game;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static java.lang.Math.round;

public class Player extends Creature{


    public static final int DEFAULT_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 64;

    //Animatii
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;


    public Player(Handler handler, float x, float y)  {
        super(handler, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Animatii
        animDown = new Animation(250, Assets.playerDown);
        animUp = new Animation(250, Assets.playerUp);
        animLeft = new Animation(250, Assets.playerLeft);
        animRight = new Animation(250, Assets.playerRight);

        bounds.x = 0; //dretunghiul pt coliziune sa fie cu 0px fata de coord. x
        bounds.y = 16;
        bounds.width = 32; //marimea dreptunghiului
        bounds.height = 32;

    }

    @Override
    public void Update() {

        //Animatii
        animDown.Update();
        animUp.Update();
        animLeft.Update();
        animRight.Update();

        getInput();
        move();

        ///pt camera////
        handler.getGameCamera().center(this);

    }

   private void getInput(){
        xMove=0;
        yMove=0;

        /*

                       ---------------------------------
                       |                               |
                       |      😃 ->                    |
                       |                               |
                       |                               |
                       ---------------------------------
        */

       System.out.println((int)(x/32)+" "+(int)((y-1*Tile.TILE_HEIGHT)/32));
        if(handler.getKeyManager().up)
            yMove=-speed;
        if(handler.getKeyManager().down)
            yMove=+speed;
        if(handler.getKeyManager().left)
            xMove=-speed;
        if(handler.getKeyManager().right)
            xMove=+speed;
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);

    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0)
            return animLeft.getCurrentFrame();
        else if (xMove > 0)
            return animRight.getCurrentFrame();
        else if (yMove < 0)
            return animUp.getCurrentFrame();
        else if(yMove > 0)
            return animDown.getCurrentFrame();
        else
            return Assets.player;
    }
}
