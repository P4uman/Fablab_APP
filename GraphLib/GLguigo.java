package GraphLib;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GLguigo extends GLgameObject{

	protected int width_;
	protected int height_;
	protected Color color_;
	protected Color iddlecolor_;
	protected Color overcolor_;
	protected Color clickedcolor_;
	
	protected GLimagego iddle_image_;
	protected GLimagego over_image_;
	protected GLimagego clicked_image_;
	protected GLimagego image_;
	
	protected Boolean isover_;
	protected Boolean isclicked_;
	protected Boolean ispressed_;
	protected Boolean isselected_;
	protected Boolean use_images_;
	
	private Boolean clickcontrol_;
	
	public GLguigo(float x, float y) {
		super(x, y);
		isselected_ = false;
		isclicked_ = false;
		ispressed_ = false;
		clickcontrol_ = false;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setOverColor(Color color){
		overcolor_ = color;
	}
	
	public void setClickedColor(Color color){
		clickedcolor_ = color;
	}

	public void setSizex(int sizex){
		width_ = sizex;
	}
	
	public void setSizey(int sizey){
		height_ = sizey;
	}
	
	public boolean getisOver(){
		return isover_;
	}
	
	public boolean getisClicked(){
		if (clickcontrol_ && isclicked_){
			isclicked_ = false;
			return true;
		}
		return false;
	}
	
	
	public boolean getisPressed(){
		return ispressed_;
	}
	
	public int getSizex(){
		return width_;
	}
	
	public int getSizey(){
		return height_;
	}
	
	public void useImages(Boolean value){
		use_images_ = value;
	}

	protected void isOver(){
		isover_ = false;
		if(GLmouseManager.getInstance().positionX() > x_
			&& GLmouseManager.getInstance().positionX() < x_ + width_
			&& GLmouseManager.getInstance().positionY() > y_
			&& GLmouseManager.getInstance().positionY() < y_ + height_){
			isover_ = true;
		}
	}
	
	protected void isPressed(){
		ispressed_ = false;
		if(isover_ && GLmouseManager.getInstance().isMousePressed() ){
			ispressed_ = true;
		}else if(GLmouseManager.getInstance().isMousePressed() && !isover_){
			isselected_ = false;
			clickcontrol_ = false;
		}else{
			clickcontrol_ = false;
		}
	}
	
	protected void isClicked(){
		if( ispressed_ && !clickcontrol_ ){
			clickcontrol_ = true;
			isclicked_ = true;
		}
	}
	
	protected void isSelected(){
		if(isclicked_ && clickcontrol_){
			isselected_ = true;
		}
	}
	
}
