package GraphLib;


import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GLimagego extends GLgameObject {

	private BufferedImage img_ = null;
	private float width_;
	private float height_;
	private float alpha_;
	private Boolean usealpha_;
	private Boolean fadein_ = false;;
	
	
	public GLimagego(float x, float y, float width, 
			float height, String path) {
		super(x, y);
		draw_ = true;
		usealpha_ = false;
		alpha_ = 1.0f;
		try {
			width_ = width;
			height_ = height;
			color_ = null;
		    img_ = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error with image path\n" + e);
		}
	}
	
	public GLimagego(float x, float y, float width, 
			float height, String path, Boolean usealpha) {
		super(x, y);
		draw_ = true;
		usealpha_ = usealpha;
		alpha_ = 1.0f;
		try {
			width_ = width;
			height_ = height;
			color_ = null;
		    img_ = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error with image path\n" + e);
		}
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(draw_){
			fadeinUpdate();
			if(usealpha_){
				Graphics2D g2d = (Graphics2D)g;
				g2d.setComposite(
						AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                        alpha_));
				g2d.drawImage(img_, (int)x_, (int)y_, (int)width_, (int)height_, color_, null);
			}else{
				g.drawImage(img_, (int)x_, (int)y_, (int)width_, (int)height_, color_, null);
			}
		}
	}
	
	public void disable(){
		draw_ = false;
	}
	
	public void enable(){
		draw_ = true;
	}
	
	
	public void fadein(){
		if(!fadein_){
			alpha_ = 0.0f;
			fadein_ = true;
		}
	}
	private void fadeinUpdate(){
		if (fadein_){
			alpha_ += 0.02;
			if (alpha_ >= 1.0f){
				alpha_ = 1.0f;
				fadein_ = false;
			}
		}
	}
	
	public Boolean isEnabled(){
		return draw_;
	}
}
