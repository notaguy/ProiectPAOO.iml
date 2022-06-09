package PaooGame.KeyManage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import PaooGame.UI.*;
import PaooGame.UI.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;

    public MouseManager(){

    }

    public void setUiManager(UIManager uiManager){
        this.uiManager=uiManager;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            leftPressed=true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            leftPressed=false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }
        if(uiManager != null)
        {
            try {
                uiManager.onMouseRelease(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();

        if(uiManager != null)//nu trebuie sa fortam, jocul nu trebuie sa aiba un uimanager mereu
        {
            uiManager.onMouseMove(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    ////////////////////alta varianta//////////////////////////
    /*  private Position mousePosition;
    private boolean mouseClicked;
    private boolean mousePressed;

    public MouseManager(){
        //mousePosition=new Position(0,0);


    }

    public Position getPointerPosition(){
        return mousePosition;
    }

    public boolean isMouseClicked(){
        return mouseClicked;
    }

    public boolean isMousePressed(){
        return mousePressed;
    }


    public void clearMouseClicked(){
        mouseClicked=false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClicked=true;
        mousePressed=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {

        //mousePosition=new Position(e.getPoint().getX(), e.getPoint().getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
*/


}
