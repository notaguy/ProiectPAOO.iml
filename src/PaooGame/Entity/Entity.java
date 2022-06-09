package PaooGame.Entity;

import PaooGame.Game;
import PaooGame.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    public float x,y;
    protected int width, height; //marimea lui entity
    protected Rectangle bounds; //pt colziune sa nu imi mai iasa din ecran

    public Entity(Handler handler, float x, float y, int width, int height)
    {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0,0, width, height);
    }

    //unde enititatea isi updateaza toate variabilele si se va misca
    public abstract void Update();

    //entitatea va fi afisata pe ecran
    public abstract void Draw(Graphics g);

    //metoda ce ma ajuta sa iau zona de coliziune a playerului
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int)(x + bounds.x+xOffset), (int) (y +bounds.y +yOffset), bounds.width, bounds.height);
    }



    public boolean checkEntityCollisions(Entity e) {
        return e.getCollisionBounds().intersects(getCollisionBounds());
    }

    public Rectangle getCollisionBounds() {
        return new Rectangle((int) (x), (int) (y), bounds.width, bounds.height);
    }


    ///////////////////////////////////
    //getter: metoda care returneaza o variabla provata ca alte clase sa o poata accesa
    //setter: ia un parametru si seteaza o variabila privata

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    /////////////////////////////////////

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    /////////////////////////////////////

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    ///////////////////////////////////

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
