package PaooGame.Graphics;

import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler,float xOffset, float yOffset)
    {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;

    }

   /* public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }*/

    public void checkBlankSpace(){
        /*if(xOffset<0) {
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth())
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        if(yOffset <0) {
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight())
            yOffset=handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();*/

        if(xOffset<0)
            xOffset=0;
        else if(xOffset>800)
            xOffset=800;
        if(yOffset<0)
            yOffset=0;
        else if(yOffset>1000)
            yOffset=1000;
    }

    //trebuie o metoda care sa centreze camera pe player si sa il urmareasca pe harta

    public void center(Entity e)
    {
        xOffset = e.getX()-handler.getWidth() / 2 - 800/2;
        yOffset = e.getY()-handler.getHeight() / 2 - 640/2;

        checkBlankSpace();

    }

    //get and set
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
