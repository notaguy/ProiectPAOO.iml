package PaooGame.State;

import PaooGame.Entity.Creature.Asteroid;
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

public class GameState extends State{

    private World world;
    public EntityManager entityManager;
    private HUD hud;
    private Racheta racheta=new Racheta(handler,1000,1340);

    private int min=40;
    private int max=1600;
    private int nr=5;

    private Asteroid a=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()));
    private Asteroid b=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()));
    private Asteroid c=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()));
    private Asteroid d=new Asteroid(handler,(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()),(int)Math.floor(Math.random()*(max-min+1)+handler.getGameCamera().getxOffset()));

    public GameState(Handler handler) throws IOException {
        super(handler);//cheama constructorul clasei extinse

        world = new World(handler,"res/Worlds/world1.txt");
        hud=new HUD();
        Entitati();
        handler.setWorld(world);
        HUD.count=0;
        HUD.adunate=0;
        handler.getGame().gameState=this;

    }

    public GameState(Handler handler, int scor, int colectate)
    {
        super(handler);

        world = new World(handler,"res/Worlds/world1.txt");

        world = new World(handler,"res/Worlds/world1.txt");
        hud=new HUD();
        try {
            Entitati();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        handler.setWorld(world);
        HUD.count=scor;
        HUD.adunate=colectate;
        handler.getGame().gameState=this;

    }

    public void Entitati() throws IOException {

        entityManager= world.getEntityManager();

        String file="res/Worlds/nivel1_mancare.csv";
        BufferedReader br= new BufferedReader(new FileReader("res/Worlds/nivel1_mancare.csv"));
        String linie;
        for(int i=0;(linie=br.readLine())!=null;i++) {
            String[] l = linie.split(",");
            for (int j = 0; j < l.length; j++) {
                if (Integer.parseInt(l[j]) > 0) {
                    entityManager.addEntity((new Mancare(handler, i*35, j*34)));
                }
            }
        }
        file="res/Worlds/nivel1_piulita.csv";
        BufferedReader br1= new BufferedReader(new FileReader("res/Worlds/nivel1_piulita.csv"));
        for(int i=0;(linie=br1.readLine())!=null;i++) {
            String[] l = linie.split(",");
            for (int j = 0; j < l.length; j++) {
                if (Integer.parseInt(l[j]) > 0) {
                    entityManager.addEntity((new Piulita(handler, i*35, j*34)));
                }
            }
        }

        file="res/Worlds/nivel1_surub.csv";
        BufferedReader brr= new BufferedReader(new FileReader("res/Worlds/nivel1_surub.csv"));
        for(int i=0;(linie=brr.readLine())!=null;i++) {
            String[] l = linie.split(",");
            for (int j = 0; j < l.length; j++) {
                if (Integer.parseInt(l[j]) > 0) {
                    entityManager.addEntity((new Surub(handler, i*35, j*34)));
                }
            }
        }

        entityManager.addEntity(new Bucata1(handler,160,260));
        entityManager.addEntity(new Bucata2(handler,1200,70));
        entityManager.addEntity(new Bucata3(handler,1300,610));
        entityManager.addEntity(new Bucata4(handler,1500,1500));
        entityManager.addEntity(new Bucata5(handler,70,1200));

    }

    @Override
    public void Update() {

        //ca sa pot iesi din game in settings apas esc
        if(handler.getKeyManager().esc)
        {
            handler.getGame().gameState=this;
            State.setState(new SettingsState(handler));
        }
        world.Update();

        for(int i=1;i<entityManager.getEntities().size();i++)
        {
            if (handler.getKeyManager().space && entityManager.getEntities().get(0).checkEntityCollisions(entityManager.getEntities().get(i))) {
                if(i<=entityManager.getEntities().size()-nr-4)
                    hud.count += 1;
                else
                {
                    nr--;
                    hud.adunate+=1;
                }
                entityManager.getEntities().remove(i);
            }
        }


        //cand ma intorc la racheta cu cele 5 piese, trec la nivelul urmator
        if(racheta.checkCollision()==1)
        {
            try {
                State.setState(new GameState1(handler));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        a.Update();
        b.Update();
        c.Update();
        d.Update();

    }

    public int nivel(){
           return 1;
    }


    @Override
    public void Draw(Graphics g) {

        world.Draw(g);

        hud.Draw(g);
        racheta.Draw(g);

        a.Draw(g);
        b.Draw(g);
        c.Draw(g);
        d.Draw(g);

    }
}
