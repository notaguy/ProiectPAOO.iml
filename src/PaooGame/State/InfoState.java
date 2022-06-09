package PaooGame.State;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;

import static java.awt.Color.*;

public class InfoState extends State{

    private UIManager uiManager1;

    public InfoState(Handler handler){
        super(handler);

        uiManager1 = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager1);

        uiManager1.addObject(new UIImageButton(710, 565, 64, 64, Assets.button_info, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(new MenuState(handler));
            }
        }));
    }

    @Override
    public void Update() {
        uiManager1.Update();
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    @Override
    public void Draw(Graphics g) {

        Image img= ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\imagine proiect.png");
        g.drawImage(img,0,0,null);

        g.setColor(black);
        g.fillRect(130,250,550,280);

        g.setFont(new Font("Cairo", Font.BOLD, 20));
        g.setColor(white);
        drawString(g,"\n Scopul jocului este sa gasesti toate partile din bucatile\n satelitului ca sa salvezi echipajul. Trebui sa te feresti\n de asteroizi si sa culegi din mancarea si piesele\n pierdute ca sa faci un punctaj cat mai mare.\n -> ca sa te misti te folosesti de W,A,S,D\n ->tasta space e pentru a culege piese si mancare\n ->poti sa apesi pe esc pentru a accesa setarile", 145,270);

        uiManager1.Draw(g);
    }

    @Override
    public int nivel() {
        return 0;
    }
}
