package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet64x64 {

    private BufferedImage sheet3;
    private static final int    tileWidth   = 64;
    private static final int    tileHeight  = 64;

    public SpriteSheet64x64(BufferedImage sheet3){
        this.sheet3=sheet3;
    }

    public BufferedImage crop(int x, int y){
        return sheet3.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }

}
