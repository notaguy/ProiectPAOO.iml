package PaooGame.Entity.Creature;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.State.State;
import PaooGame.State.YouLostState;

import java.awt.*;
import java.util.Random;

public class Asteroid extends Creature {

    private float viteza=5f;


    public Asteroid(Handler handler, float x, float y)
    {
        super(handler,x,y,64,96);
        bounds.x = 0;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 32;
    }

    public void checkCollision(){

        Rectangle cb=handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0);
        Rectangle ar=new Rectangle();

        ar.width = 50;
        ar.height = 80;

        ar.x = cb.x -15;
        ar.y = cb.y -15;

        if(this.getCollisionBounds(0,0).intersects(ar))
        {
            System.out.println("Player atacat");
            State.setState(new YouLostState(handler));
        }
    }

    @Override
    public void Update() {
        checkCollision();
        deplasare();

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.asteroid,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),96,96,null);
    }

    private void deplasare(){
        y+=viteza;
        if(y > (handler.getGameCamera().getyOffset()+700))
        {
            y=0;
        }
    }

}
