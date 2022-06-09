package PaooGame.State;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.HUD;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.io.IOException;
import java.sql.*;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(300, 300, 180, 100, Assets.button_start, new ClickListener() {
            @Override
            public void onClick() throws IOException {
                handler.getMouseManager().setUiManager(null);
                State.setState(new GameState(handler));
            }
        }));

        uiManager.addObject(new UIImageButton(300, 380, 180, 100, Assets.button_continue, new ClickListener() {
            @Override
            public void onClick() {
                Connection c =null;
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    c= DriverManager.getConnection("jdbc:sqlite:database.db");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement statement = null;
                try {
                    statement = c.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ResultSet res=null;
                try {
                    res=statement.executeQuery("SELECT * FROM StateSave ORDER BY ID DESC LIMIT 1;\n");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(res!=null)
                {
                    try {
                        HUD.adunate=res.getInt("Piese");
                        HUD.count=res.getInt("Punctaj");
                        switch (res.getInt("Nivel"))
                        {
                            case 1:
                                State.setState(new GameState(handler,HUD.count, HUD.adunate));
                                break;
                            case 2:
                                State.setState(new GameState1(handler,HUD.count, HUD.adunate));
                                break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    c.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }));

        uiManager.addObject(new UIImageButton(300, 460, 180, 100, Assets.button_exit, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));

        uiManager.addObject(new UIImageButton(710, 565, 64, 64, Assets.button_info, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(new InfoState(handler));
            }
        }));
    }

    @Override
    public void Update() {

        /*if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
        {
            State.setState(handler.getGame().gameState);
        }*/
        uiManager.Update();
    }

    @Override
    public void Draw(Graphics g) {
       /* g.setColor(Color.green);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),8,8);*/

        Image img= ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\imagine proiect.png");
        g.drawImage(img,0,0,null);
        uiManager.Draw(g);
    }

    @Override
    public int nivel() {
        return 0;
    }
}
