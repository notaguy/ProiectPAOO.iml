package PaooGame.State;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.io.IOException;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class YouLostState extends State{

    private UIManager uiManager2;

    public YouLostState(Handler handler){
        super(handler);

        uiManager2 = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager2);

        uiManager2.addObject(new UIImageButton(200, 500, 180, 100, Assets.button_start, new ClickListener() {
            @Override
            public void onClick() throws IOException {
                handler.getMouseManager().setUiManager(null);
                State.setState(new GameState(handler));
            }
        }));

        uiManager2.addObject(new UIImageButton(420, 500, 180, 100, Assets.button_exit, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));


    }

    @Override
    public void Update() {
        uiManager2.Update();
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    @Override
    public void Draw(Graphics g) {

        Image img= ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\imagine proiect.png");
        g.drawImage(img,0,0,null);

        g.setFont(new Font("Cairo", Font.BOLD, 40));
        g.setColor(white);
        drawString(g,"Ai pierdut!", 300,250);

        uiManager2.Draw(g);
    }

    @Override
    public int nivel() {
        return 0;
    }
}
