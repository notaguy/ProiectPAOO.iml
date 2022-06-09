package PaooGame.Entity.Creature;

import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final float DEFAULT_SPEED = 2.5f;
    public static final int DEFAULT_CREATURE_WIDTH = 96;
    public static final int DEFAULT_CREATURE_HEIGHT = 96;
    public static final int DEFAULT_CREATURE_HEALTH = 10;

    protected int health;

    protected float speed;
    static protected float xMove, yMove;//coordonatele miscarii unei creaturi

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        health = DEFAULT_CREATURE_HEALTH;
    }

    public void move(){
        //if(!checkEntityCollisions(xMove,0f))
            moveX();
        //if(!checkEntityCollisions(0f,yMove))
            moveY();
    }
    ///////////////////COLIZIUNI///////////////////////////

    public void moveX() {
        if (xMove > 0)//ne miscam in dreapta
        {
            int tx=(int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
                //sa nu trec marginile hartii
                if(x>49*Tile.TILE_WIDTH){
                    x=49*Tile.TILE_WIDTH;
                }
            }
            else{
                x=tx*Tile.TILE_WIDTH - bounds.x -bounds.width-1;
            }

        }else if(xMove < 0){
            int tx=(int) (x + xMove + bounds.x ) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))
            {x += xMove;
            if(x< 0) {
                x = 0;
            }
            }
            else{
                x=tx*Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY(){
        if(yMove < 0){//mergem in sus
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty))
            {   y += yMove;
                if(y<0)
                    y = 0;
            }
            else{
                y=ty*Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }
        }else if(yMove > 0){
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                y += yMove;
                if(y>49*Tile.TILE_WIDTH)
                    y=49*Tile.TILE_WIDTH;
            }else{
                y= ty*Tile.TILE_HEIGHT- bounds.y -bounds.height -1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x,y).IsSolid();
    }
    //////////////////////////////////////////////////////
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    /////////////////////////////////////////////////////
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }
    //////////////////////////////////////////////////
    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    //////////////////////////////////////////////////
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}

