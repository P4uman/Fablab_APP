package GraphLib;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GLgameObject {
	protected float x_;
	protected float y_;
	protected float velx_, vely_;
	
	protected Color color_;
	
	
	/** Draws the square while is true*/
	protected boolean draw_;
	
	public GLgameObject(float x, float y){
		setX(x); y_ = y;
		draw_ = true;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	
	//setters
	public void setX(float x){
		x_ = x;
	}
	
	public void setY(float y){
		y_ = y;
	}
	
	public void setVelX(float velx){
		velx_ = velx;
	}
	
	public void setVelY(float vely){
		vely_ = vely;
	}
	
	//getters
	
	public float getX(){
		return x_;
	}
	
	public float getY(){
		return y_;
	}
	
	public float getVelX(){
		return velx_;
	}
	
	public float getVelY(){
		return vely_;
	}
	
	
	
	/**Sets the color*/
	public void setColor(Color color){
		color_ = color;
	}
	

	/**Sets the velocity*/
	public void setVelocity(float velx, float vely){
		setVelX(velx); 
		setVelY(vely);
	}
	
	/**Sets the position*/
	public void setPosition(float x, float y){
		setX(x);
		y_ = y;
	}
	
	
}
