package ProyectoIntegrador;

import java.awt.Color;

import GraphLib.*;
//TODO Separar en Modelo Vista y Controlador, deando esta clase como principal
public class ProyectoIntegrador extends GLgraphicLib{

	private static final long serialVersionUID = 7331311049809494647L;
	GLbuttongo btn_;
	GLbuttongo btn2_;
	GLbuttongo btn3_;
	GLbuttongo btn4_;
	GLbuttongo btn5_;
	GLbuttongo btn6_;
	
	GLtextareago textarea_;
	GLtextareago textarea2_;
	GLtextareago textarea3_;
	GLtextareago textarea4_;
	GLtextareago textarea5_;
	GLtextareago textarea6_;
	GLtextareago textarea7_;
	GLtextareago textarea8_;
	
	GLimagego printerlogo_;
	GLimagego uemlogo_;
	GLimagego logofablab_;	
	GLimagego img1_;
	GLimagego img2_;
	GLimagego img3_;
	
	GLtablego table1_;
	
	GLtextgo text1_;
	
	int proyect_state_;
	
	Boolean init_state_;
	
	
	long timecounter_start_;
	
	@Override
	protected void constructor() {
		proyect_state_ = ProyectState.kInitLogin;
		init_state_ = false;
	}


	@Override
	protected void update() {
		
		switch(proyect_state_){
			case ProyectState.kInitLogin:{
				vistaLogin();
				timecounter_start_ = System.currentTimeMillis();
				proyect_state_ = ProyectState.kLogin;
				init_state_ = false;
				break;
			}
			case ProyectState.kLogin:{
				controladorLogin();
				break;
			}
			case ProyectState.kInitRegister:{
				freeLogin();
				vistaRegister();
				proyect_state_ = ProyectState.kRegister;
				init_state_ = false;
				break;
			}
			case ProyectState.kRegister:{
				controladorRegister();
				break;
			}
			case ProyectState.kInitMainMenu:{
				freeLogin();
				vistaMainMenu();
				proyect_state_ = ProyectState.kMainMenu;
				break;
			}
			case ProyectState.kMainMenu:{
				controladorMainMenu();
				break;
			}
			case ProyectState.kInitProyectos:{
				vistaProyectos();
				proyect_state_ = ProyectState.kProyectos;
				break;
			}
			case ProyectState.kProyectos:{
				controladorProyectos();
				break;
			}
			case ProyectState.kfreeProyectos:{
				freeProyectos();
				break;
			}
		
		}
		
	}

	@Override
	protected void draw() {

	}

	public static void main(String[] args) {
		new ProyectoIntegrador();
	}
	
	
	
	
	private void vistaLogin(){
		setBackgroundColor(new Color(180, 151, 58));
		btn_ = new GLbuttongo(50,420, 400, 80, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Entrar";
		btn_.text_.setSize(25);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(160, 42);
		addObject(btn_);
		
		btn2_ = new GLbuttongo(50,540, 400, 80, Color.red);
		btn2_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn2_.useImages(true);
		btn2_.text_.str_ = "Crear cuenta";
		btn2_.text_.setSize(25);
		btn2_.text_.setColor(Color.black);
		btn2_.text_.setStyle(GLgameConstants.kBOLD);
		btn2_.text_.applyChanges();
		btn2_.changeTextOffset(115, 42);
		addObject(btn2_);
		
		textarea_ = new GLtextareago(50, 240, 15, 400, 40);
		textarea_.text_.setSize(20);
		textarea_.text_.setColor(Color.black);
		textarea_.text_.applyChanges();
		textarea_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea_.setTextOffset(30, 28);
		textarea_.setOverText("Nick");
		addObject(textarea_);
		
		textarea2_ = new GLtextareago(50, 320, 15, 400, 40, true);
		textarea2_.text_.setSize(20);
		textarea2_.text_.setColor(Color.black);
		textarea2_.text_.applyChanges();
		textarea2_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea2_.setTextOffset(30, 28);
		textarea2_.setOverText("Contraseña");
		addObject(textarea2_);
		

		printerlogo_ = new GLimagego(46,5, 128, 128, 
				"./sprites/3d_printer_logo.png");
		addObject(printerlogo_);
		
		uemlogo_ = new GLimagego(950, 5, 320, 72,
				"./sprites/LogoUEM.png");
		addObject(uemlogo_);
		
		
		logofablab_ = new GLimagego(220, 20, 460, 175, 
				"./sprites/LogoFablab.png");
		addObject(logofablab_);
		
		img1_ = new GLimagego(510, 220, 695, 450, 
				"./sprites/img1.png", true);
		img1_.fadein();
		addObject(img1_);
		
		img2_ = new GLimagego(510, 220, 695, 450, 
				"./sprites/img2.png", true);
		img2_.disable();
		addObject(img2_);
		
		img3_ = new GLimagego(510, 220, 695, 450, 
				"./sprites/img3.png", true);
		img3_.disable();
		addObject(img3_);
		
	}

	private void controladorLogin(){
		if(!init_state_)
			init_state_ = !GLmouseManager.getInstance().isMousePressed();
			
		if (btn_.getisClicked() && init_state_){
			proyect_state_ = ProyectState.kInitMainMenu;
		}
			
		if (btn2_.getisClicked() && init_state_){
			proyect_state_ = ProyectState.kInitRegister;
		}
		
		long timer = 
				(System.currentTimeMillis() 
						- timecounter_start_);
		if( timer < 10000 && !img1_.isEnabled()){
			img1_.enable();
			img1_.fadein();
			img2_.disable();
			img3_.disable();
		}else if(timer < 20000 && timer > 10000
				&& !img2_.isEnabled()){
			img1_.disable();
			img2_.enable();
			img2_.fadein();
			img3_.disable();
		}else if(timer < 30000 && timer > 20000 
				&& !img3_.isEnabled()){
			img1_.disable();
			img2_.disable();
			img3_.enable();
			img3_.fadein();
		}else if(timer > 30000){
			timecounter_start_ = System.currentTimeMillis();
		}
	}
	
	private void freeLogin(){
		destroyObject(btn_);
		destroyObject(btn2_);
		destroyObject(textarea_);
		destroyObject(textarea2_);
		destroyObject(img1_);
		destroyObject(img2_);
		destroyObject(img3_);
		btn_ = null;
		btn2_ = null;
		textarea_ = null;
		textarea2_ = null;
		img1_ = null;
		img2_ = null;
		img3_ = null;
	}
	
	private void vistaRegister(){
		btn_ = new GLbuttongo(440,580, 400, 80, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Registrarse";
		btn_.text_.setSize(25);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(130, 42);
		addObject(btn_);
		
		textarea7_ = new GLtextareago(365, 210, 15, 550, 40);
		textarea7_.text_.setSize(20);
		textarea7_.text_.setColor(Color.black);
		textarea7_.text_.applyChanges();
		textarea7_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea7_.setTextOffset(30, 28);
		textarea7_.setOverText("Nick*");
		addObject(textarea7_);
		
		textarea_ = new GLtextareago(60, 290, 15, 550, 40);
		textarea_.text_.setSize(20);
		textarea_.text_.setColor(Color.black);
		textarea_.text_.applyChanges();
		textarea_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea_.setTextOffset(30, 28);
		textarea_.setOverText("Nombre*");
		addObject(textarea_);
		
		textarea2_ = new GLtextareago(670, 290, 15, 550, 40);
		textarea2_.text_.setSize(20);
		textarea2_.text_.setColor(Color.black);
		textarea2_.text_.applyChanges();
		textarea2_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea2_.setTextOffset(30, 28);
		textarea2_.setOverText("Apellidos*");
		addObject(textarea2_);
		
		textarea3_ = new GLtextareago(60, 390, 15, 550, 40);
		textarea3_.text_.setSize(20);
		textarea3_.text_.setColor(Color.black);
		textarea3_.text_.applyChanges();
		textarea3_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea3_.setTextOffset(30, 28);
		textarea3_.setOverText("Correo");
		addObject(textarea3_);
		
		textarea4_ = new GLtextareago(670, 390, 15, 550, 40);
		textarea4_.text_.setSize(20);
		textarea4_.text_.setColor(Color.black);
		textarea4_.text_.applyChanges();
		textarea4_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea4_.setTextOffset(30, 28);
		textarea4_.setOverText("Teléfono*");
		addObject(textarea4_);
		
		textarea5_ = new GLtextareago(60, 490, 15, 550, 40, true);
		textarea5_.text_.setSize(20);
		textarea5_.text_.setColor(Color.black);
		textarea5_.text_.applyChanges();
		textarea5_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea5_.setTextOffset(30, 28);
		textarea5_.setOverText("Contraseña*");
		addObject(textarea5_);
		
		textarea6_ = new GLtextareago(670, 490, 15, 550, 40, true);
		textarea6_.text_.setSize(20);
		textarea6_.text_.setColor(Color.black);
		textarea6_.text_.applyChanges();
		textarea6_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea6_.setTextOffset(30, 28);
		textarea6_.setOverText("Repetir Contraseña*");
		addObject(textarea6_);
		
		
	}
	
	private void freeRegister(){
		destroyObject(btn_);
		destroyObject(textarea_);
		destroyObject(textarea2_);
		destroyObject(textarea3_);
		destroyObject(textarea4_);
		destroyObject(textarea5_);
		destroyObject(textarea6_);
		destroyObject(textarea7_);
		btn_ = null;
		textarea_ = null;
		textarea2_ = null;
		textarea3_ = null;
		textarea4_ = null;
		textarea5_ = null;
		textarea6_ = null;
		textarea7_ = null;
		
	}
	
	private void controladorRegister(){
		if(!init_state_)
			init_state_ = !GLmouseManager.getInstance().isMousePressed();
		if (btn_.getisClicked() && init_state_){
			freeRegister();
			proyect_state_ = ProyectState.kInitLogin;
		}
	}
	
	private void vistaMainMenu(){
		btn_ = new GLbuttongo(50,250, 400, 80, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Proyectos";
		btn_.text_.setSize(25);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(60, 42);
		addObject(btn_);
		
		textarea_ = new GLtextareago(300,300, 20, 400, 30);
		textarea_.text_.setSize(35);
		textarea_.text_.setColor(Color.black);
		textarea_.text_.applyChanges();
		textarea_.setColorChanges(Color.red, Color.yellow, new Color(180,200,50));
		textarea_.setTextOffset(40, 20);
		textarea_.setOverText("Hola");
		addObject(textarea_);
		
		btn2_ = new GLbuttongo(800,250, 80, 80, Color.red);
		btn2_.loadImages("./sprites/cancel.png", "./sprites/cancel_over.png", "./sprites/cancel_clicked.png");
		btn2_.useImages(true);
		btn2_.text_.setSize(25);
		btn2_.text_.setColor(Color.black);
		btn2_.text_.setStyle(GLgameConstants.kBOLD);
		btn2_.text_.applyChanges();
		btn2_.changeTextOffset(115, 42);
		addObject(btn2_);
		
		table1_ = new GLtablego(30,400, 5,6, 200, 30,5);
		table1_.setHeaderText(0, "Nombre");
		table1_.setHeaderText(1, "Apellidos");
		table1_.setHeaderText(2, "Ciudad");
		table1_.setHeaderText(3, "Correo");
		table1_.setHeaderText(4, "Tipo usuario");
		table1_.changeHeaderTextOffset(15, 22);
		table1_.changeCellTextOffset(15, 22);
		addObject(table1_);
												
	}
	
	private void controladorMainMenu(){
		if(btn_.getisClicked()){
			freeMainMenu();
			proyect_state_ = ProyectState.kInitProyectos;
		}
	}
	
	private void freeMainMenu(){
		destroyObject(btn_);
		destroyObject(btn2_);
		destroyObject(table1_);
		destroyObject(textarea_);
		destroyObject(logofablab_);
		btn_ = null;
		btn2_ = null;
		table1_ = null;
		textarea_ = null;
		logofablab_ = null;
	}
	
	private void vistaProyectos(){
		btn_ = new GLbuttongo(40,250, 270, 60, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Añadir Proyecto";
		btn_.text_.setSize(23);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(55, 35);
		addObject(btn_);
		
		btn2_ = new GLbuttongo(350,250, 270, 60, Color.red);
		btn2_.loadImages("./Sprites/button.png", 
				"./Sprites/button_over.png", 
				"./Sprites/button_clicked.png",
				"./Sprites/button_disabled.png");
		btn2_.useImages(true);
		btn2_.text_.str_ = "Eliminar Proyecto";
		btn2_.text_.setSize(21);
		btn2_.text_.setColor(Color.black);
		btn2_.text_.setStyle(GLgameConstants.kBOLD);
		btn2_.text_.applyChanges();
		btn2_.changeTextOffset(55, 35);
		btn2_.disable();
		addObject(btn2_);
		
		btn3_ = new GLbuttongo(660,250, 270, 60, Color.red);
		btn3_.loadImages("./Sprites/button.png", 
				"./Sprites/button_over.png", 
				"./Sprites/button_clicked.png",
				"./Sprites/button_disabled.png");
		btn3_.useImages(true);
		btn3_.text_.str_ = "Editar Proyecto";
		btn3_.text_.setSize(23);
		btn3_.text_.setColor(Color.black);
		btn3_.text_.setStyle(GLgameConstants.kBOLD);
		btn3_.text_.applyChanges();
		btn3_.changeTextOffset(55, 35);
		btn3_.disable();
		addObject(btn3_);
		
		btn4_ = new GLbuttongo(970,250, 270, 60, Color.red);
		btn4_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn4_.useImages(true);
		btn4_.text_.str_ = "Menu principal";
		btn4_.text_.setSize(25);
		btn4_.text_.setColor(Color.black);
		btn4_.text_.setStyle(GLgameConstants.kBOLD);
		btn4_.text_.applyChanges();
		btn4_.changeTextOffset(55, 35);
		addObject(btn4_);
		
		table1_ = new GLtablego(40,400, 2,15, 575, 30,8);
		table1_.setHeaderText(0, "Proyectos");
		table1_.setHeaderText(1, "Descripción");
		table1_.changeHeaderTextOffset(15, 22);
		table1_.changeCellTextOffset(15, 22);
		addObject(table1_);
		
		text1_ = new GLtextgo(300,100, "Proyectos");
		text1_.setSize(80);
		text1_.setColor(new Color(0, 6, 91));
		text1_.setStyle(GLgameConstants.kBOLD);
		text1_.setType("Sans");
		text1_.applyChanges();
		addObject(text1_);
		
		/**********************************
		 * 			Just for testing
		 **********************************/
		table1_.addData(0, 0, "Proyecto 01");
		table1_.addData(1, 0, "Proyecto de prueba");
		table1_.addData(0, 1, "Proyecto 02");
		table1_.addData(1, 1, "Proyecto figuras warhummer");
		table1_.addData(0, 2, "Proyecto 03");
		table1_.addData(1, 2, "Proyecto respuestos con maquina 3D");
		table1_.addData(0, 3, "Proyecto 04");
		table1_.addData(1, 3, "Proyecto de exhibición en Barcelona");
		table1_.addData(0, 4, "Proyecto 05");
		table1_.addData(1, 4, "Proyecto piezas de moto");
		table1_.addData(0, 5, "Proyecto 06");
		table1_.addData(1, 5, "Proyecto figuras de marca");
		table1_.addData(0, 6, "Proyecto 07");
		table1_.addData(1, 6, "Proyecto accesorios de cocina");
		table1_.addData(0, 7, "Proyecto 08");
		table1_.addData(1, 7, "");
		table1_.addData(0, 8, "Proyecto 09");
		table1_.addData(1, 8, "");
		table1_.addData(0, 9, "Proyecto 10");
		table1_.addData(1, 9, "");
		table1_.addData(0, 10, "Proyecto 11");
		table1_.addData(1, 10, "Proyecto trabajo fin de grado");
		table1_.addData(0, 11, "Proyecto 12");
		table1_.addData(1, 11, "Proyecto para figuras de personajes");
		table1_.addData(0, 12, "Proyecto 13");
		table1_.addData(1, 12, "");
		table1_.addData(0, 13, "Proyecto 14");
		table1_.addData(1, 13, "Proyecto para artículos de regalo");
		table1_.addData(0, 14, "Proyecto 15");
		table1_.addData(1, 14, "");
		/**********************************
		 * 			Just for testing
		 **********************************/
		
		
	}
	
	private void controladorProyectos(){
		if(btn4_.getisClicked()){
			freeProyectos();
			proyect_state_ = ProyectState.kInitMainMenu;
		}
		
		if(btn2_.getisClicked()){
			System.out.println("ELIMINAR");
		}
		
		if(table1_.getGlobalRowSelected() !=0){
			btn2_.enable();
			btn3_.enable();
		}else{
			btn2_.disable();
			btn3_.disable();
		}
		
	}
	
	private void freeProyectos(){
		destroyObject(btn_);
		destroyObject(btn2_);
		destroyObject(btn3_);
		destroyObject(btn4_);
		destroyObject(text1_);
		destroyObject(table1_);
		btn_ = null;
		btn2_ = null;
		btn3_ = null;
		btn4_ = null;
		text1_ = null;
		table1_ = null;
	}
	
}


