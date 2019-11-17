/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Grafo.Vertex;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Path2D;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DanielR
 */
public class CanvasController extends Canvas implements ActionListener,MouseListener{
 
    private Singleton singleton;
    private Color color;
    private String tempName;
    
    
   
    
    public CanvasController(int width,int height) {
        this.setBackground(color.white);
        this.setSize(width, height);
        this.singleton = Singleton.getInstance();
        this.tempName = "";
      
    }
    
    
    /**
     * Draw graph in canvas. clear the screen and draw.
     * @param g Canvas graphics.
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D drawer = (Graphics2D) g;
        
        Vertex aux = this.singleton.getGraphMethods().graph;
        while(aux != null){
            g.setColor(Color.BLACK);
            g.drawString(aux.getName(), aux.X(), aux.Y());
            aux.draw(drawer);
            aux = aux.getSigV();
        }
       
    }
    
    public void drawOrder(Vertex current,Vertex next,float time){
       
         //f(x) = mx+b;
        float m1 = next.Y()-current.Y();
        float m2 = next.X()-current.X();
        float m = m1/m2;
        float b = current.Y()-m*current.X();
        System.out.println("m="+m);
        System.out.println("B="+b);
        
        
        int y = 0;
        int x = current.X();
        System.out.println("F(x)="+m+"*"+x+"+"+b);
        
        float result = 0;
        while (result != next.Y()) {            
            result = m*x+b;
            y = (int) result;
            System.out.println(y);
            Graphics g = this.getGraphics();
            paint(g);
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 10, 10);
            
            try {              
                Thread.sleep(90);
            } catch (InterruptedException ex) {
                System.err.println("erorr");
            }
            x++;
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!this.tempName.isEmpty()){
            Dimension2D dimension = this.singleton.getGraphMethods().graph.getDimension2D();
            int width = (int)dimension.getWidth()/2;
            int height = (int)dimension.getHeight()/2;
            this.singleton.getGraphMethods().add( this.tempName, e.getX()-width, e.getY()-height );
            this.tempName = "";
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void setTempName(String name){
        this.tempName = name;
    }
    
}
