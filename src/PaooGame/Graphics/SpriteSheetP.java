package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheetP {

    private BufferedImage sheet1;
    private static final int    tileWidth   = 32;
    private static final int    tileHeight  = 64;

    public SpriteSheetP(BufferedImage sheet1){
        this.sheet1=sheet1;
    }

    public BufferedImage crop(int x, int y){
        return sheet1.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }

}
