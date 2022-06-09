package PaooGame.Entity.StaticEntity;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Piulita extends StaticEntity{
    public Piulita(Handler handler, float x, float y){
        super(handler,x,y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
    }

    @Override
    public void Update(){

    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.piulita,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),32,32,null);
    }
}
