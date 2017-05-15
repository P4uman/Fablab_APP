package GraphLib;

import java.awt.Font;
import java.awt.Graphics;

public class GLtextgo  extends GLgameObject{


	public String str_;
	
	private Font font_;
	private int size_;
	private int style_;
	private String fonttype_;
	
	public GLtextgo(float x, float y, String str) {
		super(x, y);
		str_ = str;
		style_ = Font.PLAIN;
		fonttype_ = "Arial";
		size_ = 12;
		font_ = new Font(fonttype_, style_, size_);
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(draw_){
			g.setColor(color_);
			g.setFont(font_);
			g.drawString(str_, (int)getX(), (int)y_);
		}
	}
	
	
	public void setSize(int size){
		size_ = size;
	}
	
	public int getSize(){
		return size_;
	}
	
	/*Better use GameConstants*/
	public void setStyle(int kTEXTYPE){
		switch(kTEXTYPE){
			case GLgameConstants.kPLAIN:{
				style_ = Font.PLAIN;
				break;
			}
			case GLgameConstants.kBOLD:{
				style_ = Font.BOLD;
				break;
			}
			case GLgameConstants.kITALIC:{
				style_ = Font.ITALIC;
				break;
			}
			case GLgameConstants.kBOLDITALIC:{
				style_ = Font.ITALIC + Font.BOLD;
			}
		}

	}
	
	public void setType(String font_type){
		fonttype_ = font_type;
	}
	
	/**Is needed to use it after make changes */
	public void applyChanges(){
		font_ = new Font(fonttype_, style_, size_);
	}
}
