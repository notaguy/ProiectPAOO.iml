package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet128x128
{
    private BufferedImage       spriteSheet;              /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private static final int    tileWidth   = 128;   /*!< Latimea unei dale din sprite sheet.*/
    private static final int    tileHeight  = 128;   /*!< Inaltime unei dale din sprite sheet.*/

    public SpriteSheet128x128(BufferedImage buffImg)
    {
            /// Retine referinta catre BufferedImage object.
        spriteSheet = buffImg;
    }

    public BufferedImage crop(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
}
