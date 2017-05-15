package GraphLib;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class GLtablego extends GLguigo{

	private int rows_;
	private int cols_;
	private int cellsize_x_;
	private int cellsize_y_;
	private int cell_offsetx_;
	private int cell_offsety_;
	private int max_cols_show_;
	private int position_displacement_;
	private int row_over_;
	private int row_selected_;
	private int global_row_selected_;
	private GLbuttongo[] btns_;
	private ArrayList<String> content_;
	private GLbuttongo scrollup_;
	private GLbuttongo scrolldown_;	
	
	
	
	public GLtablego(float x, float y, int rows, int cols, 
			int cellsize_x, int cellsize_y, int max_cols_show) {
		super(x, y);
		row_over_ = 0;
		row_selected_ = 0;
		global_row_selected_ = 0;
		rows_ = rows;
		cols_ = cols;
		cellsize_x_ = cellsize_x;
		cellsize_y_ = cellsize_y;
		cell_offsetx_ = 0;
		cell_offsety_ = 0;
		max_cols_show_ = max_cols_show;
		position_displacement_ = 0;
		btns_ = new GLbuttongo[rows];
		content_ = new ArrayList<String>();
		scrollup_ = new GLbuttongo(x + rows*cellsize_x, y, 25,35,Color.white);
		scrollup_.loadImages("./sprites/bluearrowup.png",
				"./sprites/bluearrowup_over.png",
				"./sprites/bluearrowup_clicked.png");
		scrollup_.useImages(true);
		scrolldown_ = new GLbuttongo(x + rows*cellsize_x, 
				y+(max_cols_show_-1)*cellsize_y+cellsize_y-4, 25,35,
				Color.white);
		scrolldown_.loadImages("./sprites/bluearrowdown.png",
				"./sprites/bluearrowdown_over.png",
				"./sprites/bluearrowdown_clicked.png");
		scrolldown_.useImages(true);
		/******************************
		 * 		Just for testing
		 ******************************/
		for(int i = 0; i < rows*cols; ++i){
			content_.add(Integer.toString(i));
		}
		/******************************
		 * 		Just for testing
		 ******************************/
		
		for (int i = 0; i < rows_; ++i){
			btns_[i] = new GLbuttongo(x + i*cellsize_x, y, cellsize_x, cellsize_y, new Color(94, 155, 255));
			btns_[i].useImages(false);		
			btns_[i].setOverColor(new Color(124, 174, 255));
			btns_[i].setClickedColor(new Color(67, 122, 211));			
		}
	}
	

	@Override
	public void tick() {
		for(int i = 0; i < rows_; ++i ){
			btns_[i].tick();
		}
		scrollup_.tick();
		scrolldown_.tick();
		
		if(scrollup_.getisClicked() 
				&& position_displacement_ > -cols_ + max_cols_show_){
			position_displacement_--;
		}
		if(scrolldown_.getisClicked()
				&& position_displacement_ < 0){
			position_displacement_++;
		}
		getOverRow();
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < rows_; ++i ){
			btns_[i].render(g);
		}
		drawCols(g);
		g.setColor(new Color(196, 202, 211));
		g.fillRect((int)x_+cellsize_x_*rows_, 
				(int)y_, 24, cellsize_y_+cellsize_y_*max_cols_show_);
		g.setColor(Color.BLACK);
		g.drawRect((int)x_+cellsize_x_*rows_, 
				(int)y_, 24, cellsize_y_+cellsize_y_*max_cols_show_);
		scrollup_.render(g);
		scrolldown_.render(g);
		if(row_over_>0 && row_selected_==0){
			g.setColor(new Color(247, 255, 17, 70));
			g.fillRect((int)x_, (int)y_+cellsize_y_*row_over_, 
					cellsize_x_*rows_, cellsize_y_);
		
		}else if(row_selected_ != 0){
			g.setColor(new Color(247, 255, 17, 110));
			g.fillRect((int)x_, (int)y_+cellsize_y_*row_selected_, 
					cellsize_x_*rows_, cellsize_y_);
		}
		
	}
	
	private void drawCols(Graphics g){
		int count = 0;
		for (int i = 1; i < cols_+1; ++i){
			for (int j = 0; j < rows_; ++j){
				int xpos = (int)x_+cellsize_x_*j;
				int ypos = (int)y_ + cellsize_y_*i + 
				position_displacement_*cellsize_y_;
				if(ypos > y_ && 
						ypos < (max_cols_show_+1)*cellsize_y_ + y_){
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
	
	
	private void getOverRow(){
		for(int i = 1; i < max_cols_show_+1; ++i){
			if(GLmouseManager.getInstance().positionX() > x_
					&& GLmouseManager.getInstance().positionX() < x_ + cellsize_x_*rows_
					&& GLmouseManager.getInstance().positionY() > y_ + cellsize_y_* i
					&& GLmouseManager.getInstance().positionY() < y_  + cellsize_y_*(i+1)){
				row_over_ = i;
				i = max_cols_show_+2;
				if(GLmouseManager.getInstance().isMousePressed()){
					row_selected_ = row_over_;
					global_row_selected_ =row_over_ + position_displacement_;
				}
			}else{
				row_over_ = 0;
				if(GLmouseManager.getInstance().isMousePressed()){
					row_selected_ = 0;
					global_row_selected_ = 0;
				}
			}
		}
		
	}
	
	
	
	public void setHeaderText(int position, String str){
		if(position < rows_){
			btns_[position].text_.str_ = str;
		}
	}
	
	public void changeHeaderTextOffset(int x ,int y){
		for(int i = 0; i < rows_; ++i ){
			btns_[i].changeTextOffset(x, y);
		}
	}
	
	public void changeCellTextOffset(int x, int y){
		cell_offsetx_ = x;
		cell_offsety_ = y;
	}
	
	public void addCol(){
			cols_++;
			for(int i = 0; i < rows_; ++i){
				content_.add("");
			}
	}
	
	public void addData(int position_x, int position_y, String data){
		content_.set(position_x  + rows_ * position_y, data);
	}
	
	public int getGlobalRowSelected(){
		return global_row_selected_;
	}
	
}
