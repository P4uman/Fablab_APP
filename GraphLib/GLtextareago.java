package GraphLib;

import java.awt.Color;
import java.awt.Graphics;

public class GLtextareago extends GLguigo{
	public GLtextgo text_;
	private GLtextgo overtext_;
	private String auxstr_;
	
	private int maxlenght_;
	
	private Boolean hidetext_;
	
	GLsquarego area_;
	
	public GLtextareago(int x, int y, int maxlenght, int width,
			int height){
		super(x,y);
		text_ =new GLtextgo(x, y, "\0");
		text_.setColor(Color.red);
		text_.str_ = text_.str_.substring(
				0, text_.str_.length() -1);
		maxlenght_ = maxlenght;
		overtext_ = new GLtextgo(x, y, "");
		
		width_ = width;
		height_ = height;
		area_ = new GLsquarego(x, y);
		area_.setSize(width, height);
		hidetext_ = false;
		auxstr_ = "";
	}
	

	public GLtextareago(int x, int y, int maxlenght, int width,
			int height, Boolean hidetext){
		super(x,y);
		text_ =new GLtextgo(x, y, "\0");
		text_.setColor(Color.red);
		text_.str_ = text_.str_.substring(
				0, text_.str_.length() -1);
		maxlenght_ = maxlenght;
		overtext_ = new GLtextgo(x, y, "");
		
		width_ = width;
		height_ = height;
		area_ = new GLsquarego(x, y);
		area_.setSize(width, height);
		hidetext_ = hidetext;
		auxstr_ = "";
	}
	
	@Override
	public void tick() {
		
		isOver();
		isPressed();
		isClicked();
		isSelected();
		changeColor();
		
	
		if (isselected_){
			char key = GLinputManager.getInstance().getKeyPressed();
			if (key != 0){
				if (key == 8 && text_.str_.length() > 0){
					text_.str_ = text_.str_.substring(
									0, text_.str_.length() -1);
					if (hidetext_ && auxstr_.length() > 0){
						auxstr_ = auxstr_.substring(
								0, auxstr_.length() -1);
					}
				}else if(key == 10){
					/*StringBuilder strbld = new StringBuilder();
					strbld.append(text_.str_);
					strbld.append('\n');
					text_.str_ = strbld.toString();*/
				}else if(text_.str_.length() < maxlenght_ && 
						key!= 65535){
					StringBuilder strbld = new StringBuilder();
					strbld.append(text_.str_);
					strbld.append(key);
					text_.str_ = strbld.toString();
					
					if (hidetext_ && key != 8){
						StringBuilder strbld2 = new StringBuilder();
						strbld2.append(auxstr_);
						strbld2.append('*');
						auxstr_= strbld2.toString();
					}
				}
			}
		}
		
		if(text_.str_.length() == 0){
			overtext_.setColor(text_.color_);
			overtext_.setSize(text_.getSize());
			overtext_.applyChanges();
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		area_.render(g);
		if (!isselected_ && text_.str_.length() == 0){
			overtext_.render(g);
		}else{
			if(hidetext_){
				String strtmp = text_.str_;
				text_.str_ = auxstr_;
				text_.render(g);
				text_.str_ = strtmp;
			}else{
			text_.render(g);
			}
		}
		
	}
	
	
	public void setColorChanges(Color color_iddle,
			Color color_over, Color color_selected){
		color_ = color_iddle;
		iddlecolor_ = color_iddle;
		overcolor_ = color_over;
		clickedcolor_ = color_selected;
	}
	
	public void setTextOffset(int x, int y){
		text_.setPosition(x_ + x, y_ + y);
		overtext_.setPosition(x_ + x, y_ + y);
	}
	
	public void setOverText(String str){
		overtext_.str_ = str;
	}
	//Setters / getters
	
	public void setMaxlenght(int maxlenght){
		maxlenght_ = maxlenght;
	}
	
	public int getMaxlenght(){
		return maxlenght_;
	}
	
	private void changeColor(){
		color_ = iddlecolor_;
		if(isover_){
			color_ = overcolor_;
		}
		if(isselected_){
			color_ = clickedcolor_;
		}
		
		area_.setColor(color_);
	}
	
	
}
