package PaooGame;

import PaooGame.Entity.Entity;
import PaooGame.Graphics.GameCamera;
import PaooGame.KeyManage.KeyManager;
import PaooGame.KeyManage.MouseManager;

public class Handler {

    public Game game;
    private World world;
    private Entity entity;
    static private Handler instance=null;

    private Handler(Game game){
        this.game=game;
    }

    static public Handler getInstance(Game game) {
        if(instance==null)
            instance=new Handler(game);
        return instance;
    }

    public static void Reset() { instance = null; }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public Entity getEntity(){return entity;}

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
