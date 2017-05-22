package GraphLib;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class GLtablego extends GLguigo{

	private int columnas_;
	private int filas_;
	private int cellsize_x_;
	private int cellsize_y_;
	private int cell_offsetx_;
	private int cell_offsety_;
	private int max_filas_show_;
	private int position_displacement_;
	private int fila_over_;
	private int fila_selected_;
	private int global_columna_selected_;
	private GLbuttongo[] btns_;
	private ArrayList<String> content_;
	private GLbuttongo scrollup_;
	private GLbuttongo scrolldown_;	
	
	
	
	public GLtablego(float x, float y, int columnas, int filas, 
			int cellsize_x, int cellsize_y, int max_filas_show) {
		super(x, y);
		fila_over_ = 0;
		fila_selected_ = 0;
		global_columna_selected_ = 0;
		columnas_ = columnas;
		filas_ = filas;
		cellsize_x_ = cellsize_x;
		cellsize_y_ = cellsize_y;
		cell_offsetx_ = 0;
		cell_offsety_ = 0;
		max_filas_show_ = max_filas_show;
		position_displacement_ = 0;
		btns_ = new GLbuttongo[columnas];
		content_ = new ArrayList<String>();
		scrollup_ = new GLbuttongo(x + columnas*cellsize_x, y, 25,35,Color.white);
		scrollup_.loadImages("./sprites/bluearrowup.png",
				"./sprites/bluearrowup_over.png",
				"./sprites/bluearrowup_clicked.png");
		scrollup_.useImages(true);
		scrolldown_ = new GLbuttongo(x + columnas*cellsize_x, 
				y+(max_filas_show_-1)*cellsize_y+cellsize_y-4, 25,35,
				Color.white);
		scrolldown_.loadImages("./sprites/bluearrowdown.png",
				"./sprites/bluearrowdown_over.png",
				"./sprites/bluearrowdown_clicked.png");
		scrolldown_.useImages(true);
		/******************************
		 * 		Just for testing
		 ******************************/
		for(int i = 0; i < columnas*filas; ++i){
			content_.add(Integer.toString(i));
		}
		/******************************
		 * 		Just for testing
		 ******************************/
		
		for (int i = 0; i < columnas_; ++i){
			btns_[i] = new GLbuttongo(x + i*cellsize_x, y, cellsize_x, cellsize_y, new Color(94, 155, 255));
			btns_[i].useImages(false);		
			btns_[i].setOverColor(new Color(124, 174, 255));
			btns_[i].setClickedColor(new Color(67, 122, 211));			
		}
	}
	

	@Override
	public void tick() {
		global_columna_selected_ = fila_selected_ - position_displacement_;
		if(fila_selected_ == 0){
			global_columna_selected_ = 0;
		}
		for(int i = 0; i < columnas_; ++i ){
			btns_[i].tick();
		}
		scrollup_.tick();
		scrolldown_.tick();
		
		if(scrollup_.getisClicked() 
				&& position_displacement_ > -filas_ + max_filas_show_){
			position_displacement_--;
		}
		if(scrolldown_.getisClicked()
				&& position_displacement_ < 0){
			position_displacement_++;
		}
		getOvercolumna();
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < columnas_; ++i ){
			btns_[i].render(g);
		}
		drawfilas(g);
		g.setColor(new Color(196, 202, 211));
		g.fillRect((int)x_+cellsize_x_*columnas_, 
				(int)y_, 24, cellsize_y_+cellsize_y_*max_filas_show_);
		g.setColor(Color.BLACK);
		g.drawRect((int)x_+cellsize_x_*columnas_, 
				(int)y_, 24, cellsize_y_+cellsize_y_*max_filas_show_);
		scrollup_.render(g);
		scrolldown_.render(g);
		if(fila_over_>0 && fila_selected_==0){
			g.setColor(new Color(247, 255, 17, 70));
			g.fillRect((int)x_, (int)y_+cellsize_y_*fila_over_, 
					cellsize_x_*columnas_, cellsize_y_);
		
		}else if(fila_selected_ != 0){
			g.setColor(new Color(247, 255, 17, 110));
			g.fillRect((int)x_, (int)y_+cellsize_y_*fila_selected_, 
					cellsize_x_*columnas_, cellsize_y_);
		}
		
	}
	
	private void drawfilas(Graphics g){
		int count = 0;
		for (int i = 1; i < filas_+1; ++i){
			for (int j = 0; j < columnas_; ++j){
				int xpos = (int)x_+cellsize_x_*j;
				int ypos = (int)y_ + cellsize_y_*i + 
				position_displacement_*cellsize_y_;
				if(ypos > y_ && 
						ypos < (max_filas_show_+1)*cellsize_y_ + y_){
					g.setColor(new Color(196, 202, 211));
					g.fillRect(xpos, ypos, cellsize_x_, cellsize_y_);
					g.setColor(Color.black);
					g.drawRect(xpos, ypos, cellsize_x_, cellsize_y_);
					if(count < content_.size()){
						g.setFont(new Font("arial", GLgameConstants.kPLAIN, 20));
						g.drawString(content_.get(count), 
								xpos + cell_offsetx_, 
								ypos + cell_offsety_);
					}
				}
				count++;
			}
		}
	}
	
	
	private void getOvercolumna(){
		for(int i = 1; i < max_filas_show_+1; ++i){
			if(GLmouseManager.getInstance().positionX() > x_
					&& GLmouseManager.getInstance().positionX() < x_ + cellsize_x_*columnas_
					&& GLmouseManager.getInstance().positionY() > y_ + cellsize_y_* i
					&& GLmouseManager.getInstance().positionY() < y_  + cellsize_y_*(i+1)){
				fila_over_ = i;
				i = max_filas_show_+2;
				if(GLmouseManager.getInstance().isMousePressed()){
					fila_selected_ = fila_over_;
				}
			}else{
				fila_over_ = 0;
				if(GLmouseManager.getInstance().isMousePressed()){
					fila_selected_ = 0;
				}
			}
		}
		
	}
	
	
	
	public void setHeaderText(int position, String str){
		if(position < columnas_){
			btns_[position].text_.str_ = str;
		}
	}
	
	public void changeHeaderTextOffset(int x ,int y){
		for(int i = 0; i < columnas_; ++i ){
			btns_[i].changeTextOffset(x, y);
		}
	}
	
	public void changeCellTextOffset(int x, int y){
		cell_offsetx_ = x;
		cell_offsety_ = y;
	}
	
	public void addfila(){
			filas_++;
			for(int i = 0; i < columnas_; ++i){
				content_.add("");
			}
	}
	
	public void addData(int position_x, int position_y, String data){
		int arraypos = position_x  + columnas_ * position_y;
		if(arraypos < content_.size())
			content_.set(arraypos, data);
	}
	
	public String getData(int position_x, int position_y){
		int arraypos = position_x  + columnas_ * position_y;
		if(arraypos < content_.size())
			return content_.get(position_x  + columnas_ * position_y);
		return "NULLDATA";
	}
	
	
	public int getGlobalfilaSelected(){
		if (global_columna_selected_ <= 0){
			return 0;
		}
		return global_columna_selected_;
	}
	
	
	public void deleteFila(int globalcolumna){
		for (int i = globalcolumna -1; i < filas_; ++i){
			for (int j = 0; j < columnas_; ++j){
				addData(j, i, getData(j, i+1));			
			}
		}
		if(max_filas_show_ + globalcolumna > filas_ && filas_ > max_filas_show_){
			position_displacement_ ++;
		}
		if(filas_ <= max_filas_show_){
			addfila();
		}
		filas_--;
		fila_selected_ = 0;	
		global_columna_selected_ = 0;
		System.out.println(globalcolumna);
	}
	
}
