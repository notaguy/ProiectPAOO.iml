package PaooGame.Entity;

import PaooGame.Entity.Creature.Player;
import PaooGame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler=handler;
        this.player=player;
        entities=new ArrayList<Entity>();
        addEntity(player);
    }

    public void Update(){
        Iterator<Entity> it=entities.iterator();

        while(it.hasNext())
        {
            Entity e=it.next();
            e.Update();
        }
    }

    public void Draw(Graphics g)
    {
        for(Entity e:entities)
        {
            e.Draw(g);
        }
    }

    public void addEntity(Entity e)
    {
        entities.add(e);
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

    ///////////////////////////////////////
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
