
package PaooGame.State;

import PaooGame.Entity.Creature.Asteroid;
import PaooGame.Entity.Creature.Player;
import PaooGame.Entity.Creature.Racheta;
import PaooGame.Entity.EntityManager;
import PaooGame.Entity.StaticEntity.*;
import PaooGame.HUD;
import PaooGame.Handler;
import PaooGame.World;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameState1 extends State{

    private World world1;
    public EntityManager entityManager1;
    private HUD hud1;
    private Racheta racheta1=new Racheta(handler,1120,320);
    private int nr=5;

    private int min=40;
    private int max=1600;


    private Asteroid a=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));
    private Asteroid b=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));
    private Asteroid c=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));
    private Asteroid d=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));
    private Asteroid e=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));
    private Asteroid f=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));
    private Asteroid k=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getyOffset()));

    public GameState1(Handler handler) throws IOException {
        super(handler);//cheama constructorul clasei extinse

        world1 = new World(handler,"res/Worlds/world2.txt");
        hud1=new HUD();
        Entitati1();
        HUD.count=0;
        HUD.adunate=0;
        handler.setWorld(world1);
        handler.getGame().gameState=this;

    }

    public GameState1(Handler handler, int scor, int colectate)
    {
        super(handler);
        world1 = new World(handler,"res/Worlds/world1.txt");
        hud1=new HUD();
        try {
            Entitati1();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        handler.setWorld(world1);
        HUD.count=scor;
        HUD.adunate=colectate;
        handler.getGame().gameState=this;

    }

    public void Entitati1() throws IOException {

        entityManager1=new EntityManager(handler,new Player(handler,100,500));

        entityManager1= world1.getEntityManager();
        String file1="res/Worlds/nivel2_mancare.csv";
        BufferedReader gbr= new BufferedReader(new FileReader("res/Worlds/nivel2_mancare.csv"));
        String linie1;
        for(int i=0;(linie1=gbr.readLine())!=null;i++) {
            String[] l = linie1.split(",");
            for (int j = 0; j < l.length; j++) {
                if (Integer.parseInt(l[j]) > 0) {
                    entityManager1.addEntity((new Mancare(handler, i*35, j*34)));
                }
            }
        }
        file1="res/Worlds/nivel2_piulita.csv";
        BufferedReader gbr1= new BufferedReader(new FileReader("res/Worlds/nivel2_piulita.csv"));
        for(int i=0;(linie1=gbr1.readLine())!=null;i++) {
            String[] l = linie1.split(",");
            for (int j = 0; j < l.length; j++) {
                if (Integer.parseInt(l[j]) > 0) {
                    entityManager1.addEntity((new Piulita(handler, i*35, j*34)));
                }
            }
        }

        file1="res/Worlds/nivel2_surub";
        BufferedReader gbrr= new BufferedReader(new FileReader("res/Worlds/nivel2_surub.csv"));
        for(int i=0;(linie1=gbrr.readLine())!=null;i++) {
            String[] l = linie1.split(",");
            for (int j = 0; j < l.length; j++) {
                if (Integer.parseInt(l[j]) > 0) {
                    entityManager1.addEntity((new Surub(handler, i*35, j*34)));
                }
            }
        }

        entityManager1.addEntity(new Bucata1(handler,100,160));
        entityManager1.addEntity(new Bucata2(handler,260,480));
        entityManager1.addEntity(new Bucata3(handler,700,200));
        entityManager1.addEntity(new Bucata4(handler,1500,900));
        entityManager1.addEntity(new Bucata5(handler,930,1400));


    }

    public int nivel(){
           return 2;
    }

    @Override
    public void Update() {
        if(handler.getKeyManager().esc)
        {
            State.setState(new SettingsState(handler));
        }
        world1.Update();

        for(int i=1;i<entityManager1.getEntities().size();i++)
        {
            if (handler.getKeyManager().space && entityManager1.getEntities().get(0).checkEntityCollisions(entityManager1.getEntities().get(i))) {
                if(i<=entityManager1.getEntities().size()-nr-4)
                    hud1.count += 1;
                else
                {
                    nr--;
                    hud1.adunate+=1;
                }
                entityManager1.getEntities().remove(i);
            }
        }

        if(racheta1.checkCollision()==1)
        {
            State.setState(new YouWonState(handler));
        }

        a.Update();
        b.Update();
        c.Update();
        d.Update();
        e.Update();
        f.Update();
        k.Update();


    }

    @Override
    public void Draw(Graphics g) {

        world1.Draw(g);
        hud1.Draw(g);

        racheta1.Draw(g);

        a.Draw(g);
        b.Draw(g);
        c.Draw(g);
        d.Draw(g);
        e.Draw(g);
        f.Draw(g);
        k.Draw(g);


    }
}

