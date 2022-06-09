package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheetB {

    private BufferedImage sheet2;
    private static final int    tileWidth   = 320;
    private static final int    tileHeight  = 160;

    public SpriteSheetB(BufferedImage sheet2){
        this.sheet2=sheet2;
    }

    public BufferedImage crop(int x, int y){
        return sheet2.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }

}
