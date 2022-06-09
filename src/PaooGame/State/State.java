package PaooGame.State;

import PaooGame.Game;
import PaooGame.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state)
    {
        currentState = state;
    }

    public static State getState()
    {
        return currentState;
    }


    //Class
    static protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void Update();
    public abstract void Draw(Graphics g);
    public abstract int nivel();

}
