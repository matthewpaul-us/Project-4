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
import core.Ball;
import core.BallNumber;


public class Game implements Runnable{
   
   final int WIDTH = 400;
   final int HEIGHT = WIDTH * 2;
   
   JFrame frame;
   Canvas canvas;
   BufferStrategy bufferStrategy;
   
	static volatile Ball[] balls;
   
   public Game()
   {
      initializeBalls();
   }
   
        
   private void initializeBalls()
{
	   balls = new Ball[2];
		
		balls[0] = new Ball(200, 100);
		balls[1] = new Ball();
		
		balls[1].setLocX(200);
		balls[1].setLocY(200);
		balls[1].setBallColor(Color.RED);
		balls[1].setBallNumber(BallNumber.FIFTEEN);
}
   
    long desiredFPS = 210;
    long desiredDeltaLoop = (1000*1000*1000) / desiredFPS;
    
   boolean running = true;
   
   public void run(){
      
      long beginLoopTime;
      long endLoopTime;
      long currentUpdateTime = System.nanoTime();
      long lastUpdateTime;
      long deltaLoop;
      
      while(running){
         beginLoopTime = System.nanoTime();
         
//         render();
         
         lastUpdateTime = currentUpdateTime;
         currentUpdateTime = System.nanoTime();
         update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));
         
         endLoopTime = System.nanoTime();
         deltaLoop = endLoopTime - beginLoopTime;
           
           if(deltaLoop > desiredDeltaLoop){
               //Do nothing. We are already late.
           }else{
               try{
                   Thread.sleep((desiredDeltaLoop - deltaLoop)/(1000*1000));
               }catch(InterruptedException e){
                   //Do nothing
               }
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
   
   //TESTING
   private double x = 0;
   
   /**
    * Rewrite this method for your game
    */
   protected void update(int deltaTime){
      for (Ball ball: balls)
      {
    	  ball.moveBall(deltaTime);
    	  
    	  for (Ball b: balls)
    	  {
    		  if (ball.getLocX( ) == b.getLocX( ) && ball.getLocY( ) == b.getLocY( ))
    			  continue;
    		  else
    		  {
    			  double distance = Math.sqrt(Math.pow((b.getLocY() - ball.getLocY( )), 2) + Math.pow((b.getLocX( ) - ball.getLocX( )), 2)) / 292;
    			  
    			  System.out.println("Distance: " + Math.round(distance));
    			  
    			  if (distance < 2 * Ball.BALL_RADIUS)
    			  {
    				  System.out.println("Firing Collision!");
    				  ball.collide(b);
    			  }
    		  }
    	  }
    	  
    	  if (ball.getLocX( ) < 0)
    	  {
    		  ball.collideWithRail(Ball.LEFT_RAIL);
    	  }
    	  else if (ball.getLocX( ) > WIDTH)
    	  {
    		  ball.collideWithRail(Ball.RIGHT_RAIL);
    	  }
    	  
    	  if (ball.getLocY( ) < 0)
    	  {
    		  ball.collideWithRail(Ball.TOP_RAIL);
    	  }
    	  else if (ball.getLocY( ) > HEIGHT)
    	  {
    		  ball.collideWithRail(Ball.BOTTOM_RAIL);
    	  }
      }
   }
   
   /**
    * Rewrite this method for your game
    */
   protected void render(Graphics2D g){
      
	   for (Ball ball: balls)
		{
			ball.drawBall(g);
		}
	   
	   g.setColor(Color.BLACK);
	   g.drawString("Ball 2 X: " + Math.round(balls[1].getLocX( )) + " Ball 2 Y: " + Math.round(balls[1].getLocY( )), 10, 10);
	   g.drawString("Ball 2 velocity X: " + Math.round(balls[1].getVelX( )) + " Ball 2 velocity Y: " + Math.round(balls[1].getVelY( )), 10, 20);
   }
   
//   public static void main(String [] args){
//      Game ex = new Game();
//      new Thread(ex).start();
//      
//      balls[1].setVelX(-3);
//   }

}
