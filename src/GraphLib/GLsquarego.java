package GraphLib;

import java.awt.Color;
import java.awt.Graphics;

public class GLsquarego extends GLgameObject {
	
	protected int sizex_, sizey_;
	public boolean is3d_, raised_;
	
	public GLsquarego(){
		super(0,0);
		color_ = Color.black;
		sizex_ = 32;
		sizey_ = 32;
		draw_ = true;
		is3d_ = false;
		raised_ = true;
	}
	
	public GLsquarego(float x, float y){
		super(x, y);
		color_ = Color.black;
		sizex_ = 32;
		sizey_ = 32;
		draw_ = true;
		is3d_ = false;
		raised_ = true;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (draw_){	
			g.setColor(color_);
			if(!is3d_){
				g.fillRect((int)getX(), (int)y_, sizex_, sizey_);
			}else{
				g.fill3DRect((int)x_, (int)y_, sizex_, sizey_, raised_);
			}
		}
	}
	
	
	/**Sets the size*/
	public void setSize(int x, int y){
		sizex_ = x;
		sizey_ = y;
	}
	
	public void setSizex(int size){
		sizex_ = size;
	}
	
	public void setSizey(int size){
		sizey_ = size;
	}
	
	public int getSizex(){
		return sizex_;
	}
	
	public int getSizey(){
		return sizey_;
	}
}
