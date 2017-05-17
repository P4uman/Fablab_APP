package GraphLib;

import java.awt.Color;
import java.awt.Graphics;

public class GLbuttongo extends GLguigo{
	
	private Boolean enabled_;
	
	public GLtextgo text_;
	
	private GLimagego disabled_image_;
	

	public GLbuttongo(){
		super(0,0);
		width_ = 0;
		height_ = 0;
		color_ = Color.black;
		iddlecolor_ = color_;
		isover_ = false;
		isclicked_ = false;
		use_images_ = false;
		iddle_image_ = null;
		over_image_ = null;
		clicked_image_ = null;
		disabled_image_ = null;
		image_ = iddle_image_;
		enabled_ = true;
		text_ = new GLtextgo(40, 60, "");
		text_.setColor(Color.white);
		text_.setSize(20);
		text_.applyChanges();
	}
	
	public GLbuttongo(float x, float y, int sizex, int sizey, Color color) {
		super(x, y);
		width_ = sizex;
		height_ = sizey;
		color_ = color;
		iddlecolor_ = color_;
		isover_ = false;
		isclicked_ = false;
		use_images_ = false;
		iddle_image_ = null;
		over_image_ = null;
		clicked_image_ = null;
		image_ = iddle_image_;
		enabled_ = true;
		
		text_ = new GLtextgo(x + 40, y + 60, "");
		text_.setColor(Color.white);
		text_.setSize(20);
		text_.applyChanges();
	}

	@Override
	public void tick() {
		if(enabled_){
			isOver();
			isPressed();
			isClicked();
			isSelected();
			if (!use_images_){
				color_ = iddlecolor_;
				if(isover_){
					color_ = overcolor_;
				}
				if(ispressed_){
					color_ = clickedcolor_;
				}
			}else{
				image_ = iddle_image_;
				if(isover_ && over_image_!=null){
					image_ = over_image_;
				}
				if(ispressed_ && clicked_image_!=null){
					image_ = clicked_image_;
				}
			}
		}else if(disabled_image_ != null){
			image_ = disabled_image_;
		}
	}

	@Override
	public void render(Graphics g) {
		if (!use_images_){
			g.setColor(color_);
			g.fillRect((int)x_,(int) y_, width_, height_);
			g.setColor(Color.black);
			g.drawRect((int)x_,(int) y_, width_, height_);
		}else if(image_!=null){
			image_.render(g);
			
		}
		text_.render(g);
	}
	
	//Cambia el desplazamiento del texto respecto al botón
	public void changeTextOffset(int x, int y){
		text_.setPosition(x_ + x, y + y_);
		text_.applyChanges();
	}
	
	public void loadImages(String path_iddle){
		iddle_image_ = new GLimagego(x_, y_, width_, height_, path_iddle);
		over_image_ = null;
		clicked_image_ = null;
	}

	public void loadImages(String path_iddle, String path_over){
		iddle_image_ = new GLimagego(x_, y_, width_, height_, path_iddle);
		over_image_ = new GLimagego(x_, y_, width_, height_, path_over);
		clicked_image_ = null;
	}
	
	public void loadImages(String path_iddle, String path_over, String path_clicked){
		iddle_image_ = new GLimagego(x_, y_, width_, height_, path_iddle);
		over_image_ = new GLimagego(x_, y_, width_, height_, path_over);
		clicked_image_ = new GLimagego(x_, y_, width_, height_, path_clicked);
	}
	
	public void loadImages(String path_iddle, String path_over, 
			String path_clicked, String path_disabled){
		iddle_image_ = new GLimagego(x_, y_, width_, height_, path_iddle);
		over_image_ = new GLimagego(x_, y_, width_, height_, path_over);
		clicked_image_ = new GLimagego(x_, y_, width_, height_, path_clicked);
		disabled_image_ = new GLimagego(x_, y_, width_, height_, path_disabled);
	}
	
	public void enable(){
		enabled_ = true;
	}
	
	public void disable(){
		enabled_ = false;
	}
	
	
}
