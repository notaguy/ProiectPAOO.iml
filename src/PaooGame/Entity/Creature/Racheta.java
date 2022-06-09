package PaooGame.Entity.Creature;
import PaooGame.Graphics.Assets;
import PaooGame.HUD;
import PaooGame.Handler;
import PaooGame.State.GameState1;
import PaooGame.State.State;
import PaooGame.State.YouLostState;
import PaooGame.State.YouWonState;

import java.awt.*;
import java.io.IOException;

public class Racheta extends Creature{

    private HUD hud;

    public Racheta(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 0;
        bounds.y = 64;
        bounds.width = 64;
        bounds.height = 64;
        hud=new HUD();

    }

    public int checkCollision(){

        Rectangle cb=handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0);
        Rectangle ar=new Rectangle();
        ar.width = 110;
        ar.height = 100;

        ar.x = cb.x -20;
        ar.y = cb.y -20;

        if(this.getCollisionBounds(0,0).intersects(ar) && HUD.adunate>=5)
        {
            return 1;

        }
        return 0;
    }


    @Override
    public void Update() {
        checkCollision();
    }

    public void Draw(Graphics g) {
        g.drawImage(Assets.racheta,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),130,130,null);
    }


}

