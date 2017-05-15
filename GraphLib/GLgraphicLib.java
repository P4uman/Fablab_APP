/*
 * @AUTHOR
 * Pablo Lira Sobrino
 * P4uman
 * */

package GraphLib;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public abstract class GLgraphicLib extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8621949295701944996L;
	
	private Thread thread_;
	private boolean running_ = false;
	private GLhandler myhandler_;
	
	private Color my_bg_color_;
	
	
	public GLgraphicLib(){
		//Creates the window and handler, then calls the constructor of the game
		new GLwindow(GLgameConstants.kWIDTH, GLgameConstants.kHEIGHT, "GraphLib", this);
		my_bg_color_ = Color.black;
		myhandler_ = new GLhandler();
		this.addMouseMotionListener(GLmouseManager.getInstance());
		this.addMouseListener(GLmouseManager.getInstance());
		this.addKeyListener(GLinputManager.getInstance());
		constructor();
	}
	
	
	
	//Makes a thread of the game
	public synchronized void start(){
		thread_ = new Thread(this);
		thread_.start();
		running_ = true;
	}
	
	//Stops the thread
	public synchronized void stop(){
		try{
			thread_.join();
			running_ = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Controls update and draw with a delta Time
	public void run(){
		long last_time = System.nanoTime();
		double amount_of_ticks = 60.0;
		double ns = 1000000000 / amount_of_ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		//int frames = 0;
		
		while (running_){
			long now = System.nanoTime();
			delta += (now - last_time) / ns;
			last_time = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			if (running_){
				render();
			}
			//frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				//frames = 0;
			}
		}
		stop();
	}
	
	//Update
	private void tick(){
		update();
		myhandler_.tick();
	}
	
	//Draw
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(my_bg_color_);
		g.fillRect(0,0,GLgameConstants.kWIDTH, GLgameConstants.kHEIGHT);
		
		myhandler_.render(g);
		
		g.dispose();
		bs.show();
	}
	
	
	/**Adds an object to the game*/
	protected void addObject(GLgameObject object){
		myhandler_.addObject(object);
	}
	
	/**Destroys an object from the game*/
	protected void destroyObject(GLgameObject object){
		myhandler_.removeObject(object);
	}
	
	/**Changes the color of the background*/
	protected void setBackgroundColor(Color mycolor){
		my_bg_color_ = mycolor;
	}
	

	
	
	//abstract methods
	
	
	
	/**Updates game state*/
	protected abstract void update();
	/**Draws game state*/
	protected abstract void draw();
	/**Runs at the begining of the game*/
	protected abstract void constructor();
	

}
