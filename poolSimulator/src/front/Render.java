/**
 * ---------------------------------------------------------------------------
 * File name: BufferedCanvas.java<br/>
 * Project name: poolSimulator<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 11, 2012<br/>
 * Date of Last Modification: Apr 11, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import core.Ball;


public class Render implements Runnable{
   
   final int WIDTH = 400;
   final int HEIGHT = WIDTH * 2;
   
   JFrame frame;
   Canvas canvas;
   BufferStrategy bufferStrategy;
   
   public Render(){
      frame = new JFrame("Render Frame");
      
      JPanel panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      panel.setLayout(null);
      
      canvas = new Canvas();
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
      
      panel.add(canvas);
      
      canvas.addMouseListener(new MouseControl());
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
      
      canvas.createBufferStrategy(3);
      bufferStrategy = canvas.getBufferStrategy();
      
      canvas.requestFocus();
   }


private class MouseControl extends MouseAdapter{
      
   }
   
   long desiredFPS = 60;
    long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;
    
   boolean running = true;
   
   public void run(){
      
      long beginLoopTime;
      long endLoopTime;
      long currentUpdateTime = System.nanoTime();
      @SuppressWarnings ("unused")
	long lastUpdateTime;
      long deltaLoop;
      
      while(running){
         
         render();

         try
		{
			Thread.sleep(20);
		}
		catch (InterruptedException e)
		{
			
		}
      }
   }
   
   private void render() {
      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
      g.clearRect(0, 0, WIDTH, HEIGHT);
      render(g);
      g.dispose();
      bufferStrategy.show();
   }
   
   /**
    * Rewrite this method for your game
    */
   protected void render(Graphics2D g){
      
	   for (Ball ball: Game.balls)
		{
			ball.drawBall(g);
		}
	   
	   g.setColor(Color.BLACK);
	   g.drawString("Ball 2 X: " + Math.round(Game.balls[1].getLocX( )) + " Ball 2 Y: " + Math.round(Game.balls[1].getLocY( )), 10, 10);
	   g.drawString("Ball 2 velocity X: " + Math.round(Game.balls[1].getVelX( )) + " Ball 2 velocity Y: " + Math.round(Game.balls[1].getVelY( )), 10, 20);
	   
   }
   
   public static void main(String [] args){
      Game ex = new Game();
      new Thread(ex).start();
      
      Render rend = new Render();
      new Thread(rend).start( );
      
      Game.balls[1].setVelX(-2);
      Game.balls[1].setVelY(10);
   }

}
