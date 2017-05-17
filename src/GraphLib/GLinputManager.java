package GraphLib;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GLinputManager extends KeyAdapter {

	private static GLinputManager instance_ = null;
	
	private char keycode_;
	
	private GLinputManager(){}
	
	
	
	public static GLinputManager getInstance(){
		if (instance_ == null){
			instance_ = new GLinputManager();
		}
		return instance_;
	}
	
	public void keyPressed(KeyEvent k){
			keycode_ = k.getKeyChar();
	}
	public void keyReleased(KeyEvent k){
		
	}
	
	public char getKeyPressed(){
		char key = keycode_;
		keycode_ = 0;
		return key;
	}
}
