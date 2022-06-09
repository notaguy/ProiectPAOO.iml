package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet96x96
{
    private BufferedImage       spriteSheet;              /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private static final int    tileWidth   = 96;   /*!< Latimea unei dale din sprite sheet.*/
    private static final int    tileHeight  = 96;   /*!< Inaltime unei dale din sprite sheet.*/

    public SpriteSheet96x96(BufferedImage buffImg)
    {
        spriteSheet = buffImg;
    }

    public BufferedImage crop(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
}
