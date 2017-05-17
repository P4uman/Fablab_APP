package GraphLib;

import java.awt.Graphics;
import java.util.LinkedList;

public class GLhandler {
	
	//dynamic array of GameObjects 
	LinkedList<GLgameObject> object_ = new LinkedList<GLgameObject>();
	
	//Updates every GameObject 
	public void tick(){
		for (int i = 0; i < object_.size(); ++i){
			GLgameObject tempObject = object_.get(i);
			
			tempObject.tick();
		}
	}
	
	//Renders every GameObject
	public void render(Graphics g){
		for (int i = 0; i < object_.size(); ++i){
			GLgameObject tempObject = object_.get(i);
			
			tempObject.render(g);
		}
	}
	
	//adds an object to the array
	public void addObject(GLgameObject object){
		this.object_.add(object);
	}
	
	//removes an object from the array
	public void removeObject(GLgameObject object){
		this.object_.remove(object);
	}
}
