package PaooGame.UI;

import PaooGame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class UIManager {

    private Handler handler;
     private ArrayList<UIObject> objects;

    public UIManager(Handler handler){
        this.handler=handler;
        objects=new ArrayList<UIObject>();

    }

    public Handler getHandler() {
        return handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void Update(){
        for(UIObject o:objects)
            o.Update();
    }

    public void Draw(Graphics g){
        for(UIObject o:objects)
            o.Draw(g);
    }

    public void onMouseMove(MouseEvent e)
    {
        for(UIObject o:objects)
            o.onMouseMove(e);
    }

     public void onMouseRelease(MouseEvent e) throws IOException {
        for(UIObject o:objects)
            o.onMouseRelease(e);
    }

    public void addObject(UIObject o)
    {
        objects.add(o);
    }

    public void removeObject(UIObject o)
    {
        objects.remove(o);
    }
}
