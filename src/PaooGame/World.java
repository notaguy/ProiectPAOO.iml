package PaooGame;

import PaooGame.Entity.Creature.Player;
import PaooGame.Entity.EntityManager;
import PaooGame.Tiles.Tile;
import PaooGame.Utilitati.Utilitati;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX,spawnY;
    private int[][] tiles;

    //Entities
    private EntityManager entityManager;


    public World(Handler handler, String path)  {
        this.handler=handler;

        entityManager=new EntityManager(handler, new Player(handler,960,1280));


        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }

    public void Update(){
        entityManager.Update();

    }

    public void Draw(Graphics g){

        //e mai ok sa facem asa, pt ca nu se mai deseneaza tile-uri care nu se vad
        /*int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd =(int) Math.min(width,(handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILE_WIDTH+1);
        int yStart=(int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int yEnd=(int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()/Tile.TILE_HEIGHT+1));*/

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++)
            {
                Tile t = getTile(x,y);
                if (t != null && t != Tile.fundalTile) {
                    t.Draw(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
                }
            }
        }

        //entities
        entityManager.Draw(g);


    }

    public Tile getTile(int x, int y){

        if(x<0 || y<0 || x>=width || y>=height)
            return Tile.fundalTile;

        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null)
        {
            return Tile.fundalTile;
        }
        return t;
    }

    private void loadWorld(String path){

        String file = Utilitati.incarcaLumea(path);
        String[] l = file.split("\\s+");

        //marimea hartii
        width=Utilitati.parseInt(l[0]);
        height=Utilitati.parseInt(l[1]);

        //unde va aparea playerul la inceputul jocului
        spawnX=Utilitati.parseInt(l[2]);
        spawnY=Utilitati.parseInt(l[3]);


        tiles = new int[width][height];
        for(int y=0;y<height;y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utilitati.parseInt(l[(x + y * width)+4]);
            }
        }
    }

    //ca sa am acces la marimile hartii inafara clasei
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    //getter and setter pt item


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
