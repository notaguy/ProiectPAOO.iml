package PaooGame.Entity.StaticEntity;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Bucata6 extends StaticEntity{
    public Bucata6(Handler handler, float x, float y){
        super(handler,x,y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
    }

    @Override
    public void Update(){
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.antena1,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),64,64,null);
    }
}
