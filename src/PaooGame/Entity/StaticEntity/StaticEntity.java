package PaooGame.Entity.StaticEntity;

import PaooGame.Entity.Entity;
import PaooGame.Handler;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x,y,width, height);
    }

}
