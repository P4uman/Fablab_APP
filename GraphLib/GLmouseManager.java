package GraphLib;



import java.awt.event.MouseEvent;


import javax.swing.event.MouseInputAdapter;

public class GLmouseManager  extends MouseInputAdapter{

	private static GLmouseManager instance_ = null;
	
	private boolean pressed_;
	private MouseEvent laste_;
	
	private GLmouseManager(){
		pressed_  = false;
		laste_ = null;
	}
	
	public static GLmouseManager getInstance(){
		if (instance_ == null){
			instance_ = new GLmouseManager();
		}
		return instance_;
		
	}
	
	
	public void mousePressed(MouseEvent e){		
		pressed_ = true;
		laste_ = e;
	}
	
	public void mouseReleased(MouseEvent e){
		pressed_ = false;
		laste_ = e;
		
	}
			
	 public void mouseMoved(MouseEvent e){
		 laste_ = e;
	 }
	
	 
	public boolean isMousePressed(){
		return pressed_;
	}
		
		

	public int positionX(){
		if(laste_ != null){
			return laste_.getX();
		}
		return -1;
	}
	
	public int positionY(){
		if(laste_ != null){
			return laste_.getY();
		}
		return -1;
	}

}
