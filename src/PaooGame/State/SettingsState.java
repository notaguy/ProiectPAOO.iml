package PaooGame.State;

import PaooGame.Exceptii.BaseExeption;
import PaooGame.Graphics.Assets;
import PaooGame.HUD;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SettingsState extends State{

    private UIManager uiManagerr;

    public SettingsState(Handler handler){
        super(handler);

        uiManagerr = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManagerr);

        uiManagerr.addObject(new UIImageButton(300, 300, 180, 100, Assets.button_resume, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));

        uiManagerr.addObject(new UIImageButton(300, 380, 180, 100, Assets.button_save, new ClickListener() {
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
                try{
                    if(c==null)
                        throw new BaseExeption("nu avem conexiune la baza");

                try {
                    statement = c.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String save = "CREATE TABLE IF NOT EXISTS \"StateSave\" (\n" +
                        "\t\"ID\"\tINTEGER UNIQUE,\n" +
                        "\t\"Nivel\"\tINTEGER,\n" +
                        "\t\"Punctaj\"\tINTEGER,\n" +
                        "\t\"Piese\"\tINTEGER,\n" +
                        "\tPRIMARY KEY(\"ID\" AUTOINCREMENT)\n" +
                        ")";
                try {
                    statement.execute(save);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    statement.executeUpdate("INSERT INTO StateSave (Nivel,Punctaj,Piese) VALUES (" + handler.getGame().gameState.nivel() + " , " + HUD.count + " ," + HUD.adunate + ")");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    c.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }));

        uiManagerr.addObject(new UIImageButton(300, 460, 180, 100, Assets.button_exit, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(new MenuState(handler));
            }
        }));

        uiManagerr.addObject(new UIImageButton(710, 565, 64, 64, Assets.button_info, new ClickListener() {
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
        uiManagerr.Update();
    }

    @Override
    public void Draw(Graphics g) {
       /* g.setColor(Color.green);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),8,8);*/

       /* Image img= ImageLoader.LoadImage("C:\\Users\\barca\\OneDrive\\Desktop\\SPACE-SAT\\res\\textures\\background1.png");
        g.drawImage(img,0,0,null);*/
        uiManagerr.Draw(g);
    }

    @Override
    public int nivel() {
        return 0;
    }

    /*CREATE TABLE IF NOT EXISTS "StateSave" (
            "Nivel"	INTEGER UNIQUE,
	"Punctaj"	INTEGER,
            "Piese culese"	INTEGER*/

}
