package ProyectoIntegrador;

import java.awt.Color;

import GraphLib.*;

public class ProyectoIntegrador extends GLgraphicLib{

	private static final long serialVersionUID = 7331311049809494647L;
	GLbuttongo btn_;
	GLbuttongo btn2_;
	GLbuttongo btn3_;
	GLbuttongo btn4_;
	GLbuttongo btn5_;
	GLbuttongo btn6_;
	GLbuttongo btn7_;
	GLbuttongo btn8_;
	
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
	GLtablego table2_;
	GLtablego table3_;
	
	GLtextgo text1_;
	GLtextgo text2_;
	GLtextgo text3_;
	GLtextgo text4_;
	GLtextgo text5_;
	GLtextgo text6_;
	
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
			case ProyectState.kInitAddProyectos:{
				vistaAddProyectos();
				proyect_state_ = ProyectState.kAddProyectos;
				break;
			}
			case ProyectState.kAddProyectos:{
				controladorAddProyectos();
				break;
			}
			case ProyectState.kInitGestionUsuariosProyectos:{
				vistaGestionUsuariosProyectos();
				proyect_state_ = ProyectState.kGestionUsuariosProyectos;
				break;
			}
			case ProyectState.kGestionUsuariosProyectos:{
				
				break;
			}case ProyectState.kInitMaquinas:{
			    InitMaquinas();
			    proyect_state_ = ProyectState.kMaquinas;
			    break;
			   }
			   case ProyectState.kMaquinas:{
			       Maquinas();
			    break;
			   }
			   case ProyectState.kInitNuevaMaq:{
			    Maquinas();
			    InitNuevamaq();
			    proyect_state_ = ProyectState.kNuevaMaq;
			    break;
			    }
			   case ProyectState.kNuevaMaq:{
			     NuevaMaq();
			     break;
			    }
			   case ProyectState.kInitMateriales:{
			    freeLogin();
			    InitMateriales();
			    proyect_state_ = ProyectState.kMateriales;
			    break;
			   }
			   case ProyectState.kMateriales:{
			    Materiales();
			    break;
			   }
			   case ProyectState.kInitNuevoMat:{
			    Materiales();
			    InitNuevoMat();
			    proyect_state_ = ProyectState.kNuevoMat;
			    break;
			    }
			   case ProyectState.kNuevoMat:{
			    NuevoMat();
			    break;
			    }
			default:{
				System.out.println("FATAL ERROR");
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
		destroyObject(printerlogo_);
		destroyObject(uemlogo_);
		destroyObject(logofablab_);
		btn_ = null;
		btn2_ = null;
		textarea_ = null;
		textarea2_ = null;
		img1_ = null;
		img2_ = null;
		img3_ = null;
		printerlogo_ = null;
		uemlogo_ = null;
		logofablab_ = null;
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
		printerlogo_ = new GLimagego(46,5, 128, 128, 
				"./sprites/3d_printer_logo.png");
		addObject(printerlogo_);
		
		uemlogo_ = new GLimagego(950, 5, 320, 72,
				"./sprites/LogoUEM.png");
		addObject(uemlogo_);
		
		
		logofablab_ = new GLimagego(220, 20, 460, 175, 
				"./sprites/LogoFablab.png");
		addObject(logofablab_);
		
		btn_ = new GLbuttongo(160,250, 400, 80, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Usuarios";
		btn_.text_.setSize(25);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(60, 42);
		addObject(btn_);

		btn2_ = new GLbuttongo(720,250, 400, 80, Color.red);
		btn2_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn2_.useImages(true);
		btn2_.text_.str_ = "Proyectos";
		btn2_.text_.setSize(25);
		btn2_.text_.setColor(Color.black);
		btn2_.text_.setStyle(GLgameConstants.kBOLD);
		btn2_.text_.applyChanges();
		btn2_.changeTextOffset(60, 42);
		addObject(btn2_);
		
		btn3_ = new GLbuttongo(160,350, 400, 80, Color.red);
		btn3_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn3_.useImages(true);
		btn3_.text_.str_ = "Proveedores";
		btn3_.text_.setSize(25);
		btn3_.text_.setColor(Color.black);
		btn3_.text_.setStyle(GLgameConstants.kBOLD);
		btn3_.text_.applyChanges();
		btn3_.changeTextOffset(60, 42);
		addObject(btn3_);
		
		btn4_ = new GLbuttongo(720,350, 400, 80, Color.red);
		btn4_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn4_.useImages(true);
		btn4_.text_.str_ = "Pedidos";
		btn4_.text_.setSize(25);
		btn4_.text_.setColor(Color.black);
		btn4_.text_.setStyle(GLgameConstants.kBOLD);
		btn4_.text_.applyChanges();
		btn4_.changeTextOffset(60, 42);
		addObject(btn4_);
		
		btn5_ = new GLbuttongo(160,450, 400, 80, Color.red);
		btn5_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn5_.useImages(true);
		btn5_.text_.str_ = "Materiales";
		btn5_.text_.setSize(25);
		btn5_.text_.setColor(Color.black);
		btn5_.text_.setStyle(GLgameConstants.kBOLD);
		btn5_.text_.applyChanges();
		btn5_.changeTextOffset(60, 42);
		addObject(btn5_);
		
		btn6_ = new GLbuttongo(720,450, 400, 80, Color.red);
		btn6_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn6_.useImages(true);
		btn6_.text_.str_ = "Máquinas";
		btn6_.text_.setSize(25);
		btn6_.text_.setColor(Color.black);
		btn6_.text_.setStyle(GLgameConstants.kBOLD);
		btn6_.text_.applyChanges();
		btn6_.changeTextOffset(60, 42);
		addObject(btn6_);
		
		btn7_ = new GLbuttongo(160,550, 400, 80, Color.red);
		btn7_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn7_.useImages(true);
		btn7_.text_.str_ = "Eventos";
		btn7_.text_.setSize(25);
		btn7_.text_.setColor(Color.black);
		btn7_.text_.setStyle(GLgameConstants.kBOLD);
		btn7_.text_.applyChanges();
		btn7_.changeTextOffset(60, 42);
		addObject(btn7_);
		
		btn8_ = new GLbuttongo(720,550, 400, 80, Color.red);
		btn8_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn8_.useImages(true);
		btn8_.text_.str_ = "Log out";
		btn8_.text_.setSize(25);
		btn8_.text_.setColor(Color.black);
		btn8_.text_.setStyle(GLgameConstants.kBOLD);
		btn8_.text_.applyChanges();
		btn8_.changeTextOffset(60, 42);
		addObject(btn8_);
		
		
												
	}
	
	private void controladorMainMenu(){
		if(btn_.getisClicked()){
			//freeMainMenu();
			
		}else if(btn2_.getisClicked()){
			freeMainMenu();
			proyect_state_ = ProyectState.kInitProyectos;
		}else if(btn3_.getisClicked()){
			//freeMainMenu();
		}else if(btn4_.getisClicked()){
			//freeMainMenu();
		}else if(btn5_.getisClicked()){
			freeMainMenu();
			proyect_state_ = ProyectState.kInitMateriales;
		}else if(btn6_.getisClicked()){
			freeMainMenu();
			proyect_state_ = ProyectState.kInitMaquinas;
		}else if(btn7_.getisClicked()){
			//freeMainMenu();
		}else if(btn8_.getisClicked()){	
			freeMainMenu();
			proyect_state_ = ProyectState.kInitLogin;
		}
	}
	
	private void freeMainMenu(){
		destroyObject(btn_);
		destroyObject(btn2_);
		destroyObject(btn3_);
		destroyObject(btn4_);
		destroyObject(btn5_);
		destroyObject(btn6_);
		destroyObject(btn7_);
		destroyObject(btn8_);
		destroyObject(logofablab_);
		btn_ = null;
		btn2_ = null;
		btn3_ = null;
		btn4_ = null;
		btn5_ = null;
		btn6_ = null;
		btn7_ = null;
		btn8_ = null;
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
		btn_.changeTextOffset(53, 35);
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
		btn2_.changeTextOffset(53, 35);
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
		btn4_.loadImages("./Sprites/button.png", 
				"./Sprites/button_over.png", 
				"./Sprites/button_clicked.png", 
				"./Sprites/button_disabled.png");
		btn4_.useImages(true);
		btn4_.text_.str_ = "Gestion Usuarios";
		btn4_.text_.setSize(25);
		btn4_.text_.setColor(Color.black);
		btn4_.text_.setStyle(GLgameConstants.kBOLD);
		btn4_.text_.applyChanges();
		btn4_.changeTextOffset(38, 35);
		btn4_.disable();
		addObject(btn4_);
		
		btn5_ = new GLbuttongo(980, 100, 260, 140, Color.black);
		btn5_.loadImages("./Sprites/return.png",
				"./Sprites/return_over.png",
				"./Sprites/return_clicked.png");
		btn5_.useImages(true);
		btn5_.text_.str_ = "Menu principal";
		btn5_.text_.setSize(25);
		btn5_.text_.setColor(Color.black);
		btn5_.text_.setStyle(GLgameConstants.kBOLD);
		btn5_.text_.applyChanges();
		btn5_.changeTextOffset(48, 77);
		addObject(btn5_);
		
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
		int selectedrow = table1_.getGlobalfilaSelected();
		if( selectedrow !=0){
			btn2_.enable();
			btn3_.enable();
			btn4_.enable();
			
		}else{
			btn2_.disable();
			btn3_.disable();
			btn4_.disable();
		}
		
		if(btn_.getisClicked()){
			proyect_state_ = ProyectState.kInitAddProyectos;
			freeProyectos();
			
		}else if(btn2_.getisClicked()){
			table1_.deleteFila(selectedrow);			
			System.out.println("ELIMINAR");
		}else if(btn5_.getisClicked()){
			freeProyectos();
			proyect_state_ = ProyectState.kInitMainMenu;
		}else if(btn4_.getisClicked()){
			freeProyectos();
			proyect_state_ = ProyectState.kInitGestionUsuariosProyectos;
		}
		
	}
	
	private void freeProyectos(){
		destroyObject(btn_);
		destroyObject(btn2_);
		destroyObject(btn3_);
		destroyObject(btn4_);
		destroyObject(btn5_);
		destroyObject(text1_);
		destroyObject(table1_);
		btn_ = null;
		btn2_ = null;
		btn3_ = null;
		btn4_ = null;
		btn5_ = null;
		text1_ = null;
		table1_ = null;
	}
	
	private void vistaAddProyectos(){
		
		text1_ = new GLtextgo(300,120, "Añadir proyecto");
		text1_.setSize(80);
		text1_.setColor(new Color(0, 6, 91));
		text1_.setStyle(GLgameConstants.kBOLD);
		text1_.setType("Sans");
		text1_.applyChanges();
		addObject(text1_);
		
		btn_ = new GLbuttongo(180,550, 400, 80, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Guardar";
		btn_.text_.setSize(25);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(130, 42);
		addObject(btn_);
		
		btn2_ = new GLbuttongo(700,550, 400, 80, Color.red);
		btn2_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn2_.useImages(true);
		btn2_.text_.str_ = "Descartar";
		btn2_.text_.setSize(25);
		btn2_.text_.setColor(Color.black);
		btn2_.text_.setStyle(GLgameConstants.kBOLD);
		btn2_.text_.applyChanges();
		btn2_.changeTextOffset(130, 42);
		addObject(btn2_);
		
		textarea_ = new GLtextareago(60, 290, 20, 650, 40);
		textarea_.text_.setSize(20);
		textarea_.text_.setColor(Color.black);
		textarea_.text_.applyChanges();
		textarea_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea_.setTextOffset(30, 28);
		textarea_.setOverText("Nombre del proyecto*");
		addObject(textarea_);
		
		textarea2_ = new GLtextareago(60, 430, 80, 950, 40);
		textarea2_.text_.setSize(20);
		textarea2_.text_.setColor(Color.black);
		textarea2_.text_.applyChanges();
		textarea2_.setColorChanges(new Color(58, 75, 180), 
				new Color(58, 75, 255), 
				new Color(86, 101, 255));
		textarea2_.setTextOffset(30, 28);
		textarea2_.setOverText("Descripción");
		addObject(textarea2_);
		

	}
	
	private void controladorAddProyectos(){
		if(btn_.getisClicked()){
			freeAddProyectos();
			proyect_state_ = ProyectState.kInitProyectos;
		}else if(btn2_.getisClicked()){
			freeAddProyectos();
			proyect_state_ = ProyectState.kInitProyectos;
		}
	}
	
	private void freeAddProyectos(){
		destroyObject(btn_);
		destroyObject(btn2_);
		destroyObject(textarea_);
		destroyObject(textarea2_);
		destroyObject(text1_);
		btn_ = null;
		btn2_ = null;
		textarea_ = null;
		textarea2_ = null;
		text1_ = null;
	}
	
	private void vistaGestionUsuariosProyectos(){
		text1_ = new GLtextgo(300,120, "Gestión usuarios");
		text1_.setSize(80);
		text1_.setColor(new Color(0, 6, 91));
		text1_.setStyle(GLgameConstants.kBOLD);
		text1_.setType("Sans");
		text1_.applyChanges();
		addObject(text1_);
		
		btn_ = new GLbuttongo(40,250, 270, 60, Color.red);
		btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		btn_.useImages(true);
		btn_.text_.str_ = "Añadir Usuario";
		btn_.text_.setSize(23);
		btn_.text_.setColor(Color.black);
		btn_.text_.setStyle(GLgameConstants.kBOLD);
		btn_.text_.applyChanges();
		btn_.changeTextOffset(53, 35);
		addObject(btn_);
		
		btn2_ = new GLbuttongo(350,250, 270, 60, Color.red);
		btn2_.loadImages("./Sprites/button.png", 
				"./Sprites/button_over.png", 
				"./Sprites/button_clicked.png",
				"./Sprites/button_disabled.png");
		btn2_.useImages(true);
		btn2_.text_.str_ = "Eliminar usuario";
		btn2_.text_.setSize(21);
		btn2_.text_.setColor(Color.black);
		btn2_.text_.setStyle(GLgameConstants.kBOLD);
		btn2_.text_.applyChanges();
		btn2_.changeTextOffset(53, 35);
		btn2_.disable();
		addObject(btn2_);
		
		
		btn5_ = new GLbuttongo(980, 100, 260, 140, Color.black);
		btn5_.loadImages("./Sprites/return.png",
				"./Sprites/return_over.png",
				"./Sprites/return_clicked.png");
		btn5_.useImages(true);
		btn5_.text_.str_ = "Proyectos";
		btn5_.text_.setSize(25);
		btn5_.text_.setColor(Color.black);
		btn5_.text_.setStyle(GLgameConstants.kBOLD);
		btn5_.text_.applyChanges();
		btn5_.changeTextOffset(48, 77);
		addObject(btn5_);
		
		table1_ = new GLtablego(40,400, 3,15, 400, 30,8);
		table1_.setHeaderText(0, "Nombre");
		table1_.setHeaderText(1, "Apellidos");
		table1_.setHeaderText(2, "Participa");
		table1_.changeHeaderTextOffset(15, 22);
		table1_.changeCellTextOffset(15, 22);
		addObject(table1_);
		
		
		
		/************************
		 * 		Just for testing
		 ************************/
		
		table1_.addData(0, 0, "Usuario1");
		table1_.addData(1, 0, "Apellido1");
		table1_.addData(2, 0, "No");
		table1_.addData(0, 1, "Usuario2");
		table1_.addData(1, 1, "Apellido2");
		table1_.addData(2, 1, "No");
		table1_.addData(0, 2, "Usuario3");
		table1_.addData(1, 2, "Apellido3");
		table1_.addData(2, 2, "No");
		table1_.addData(0, 3, "Usuario4");
		table1_.addData(1, 3, "Apellido4");
		table1_.addData(2, 3, "No");
		table1_.addData(0, 4, "Usuario5");
		table1_.addData(1, 4, "Apellido5");
		table1_.addData(2, 4, "No");
		table1_.addData(0, 5, "Usuario6");
		table1_.addData(1, 5, "Apellido7");
		table1_.addData(2, 5, "No");
		
		/************************
		 * 		Just for testing
		 ************************/
		
		
	}
	









/**********************************************
 **********************************************
 *  		AUTHOR PAULA LABANDA
 *********************************************
 **********************************************/
	
	 private void InitMaquinas(){
		  
		  btn_ = new GLbuttongo(100,600, 400, 80, Color.red);
		  btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		  btn_.useImages(true);
		  btn_.text_.str_ = "Menú principal";
		  btn_.text_.setSize(25);
		  btn_.text_.setColor(Color.black);
		  btn_.text_.setStyle(GLgameConstants.kBOLD);
		  btn_.text_.applyChanges();
		  btn_.changeTextOffset(110, 42);
		  addObject(btn_);
		  
		  
		  btn4_ = new GLbuttongo(800,300, 400, 80, Color.red);
		  btn4_.useImages(true);
		  btn4_.text_.str_ = "Modificar";
		  btn4_.text_.setSize(25);
		  btn4_.text_.setColor(Color.black);
		  btn4_.text_.setStyle(GLgameConstants.kBOLD);
		  btn4_.text_.applyChanges();
		  btn4_.changeTextOffset(150, 42);
		  addObject(btn4_);
		  
		  btn5_ = new GLbuttongo(800,200, 400, 80, Color.red);
		  btn5_.useImages(true);
		  btn5_.text_.str_ = "Añadir a proyecto";
		  btn5_.text_.setSize(25);
		  btn5_.text_.setColor(Color.black);
		  btn5_.text_.setStyle(GLgameConstants.kBOLD);
		  btn5_.text_.applyChanges();
		  btn5_.changeTextOffset(110, 42);
		  addObject(btn5_);
		  
		  btn6_ = new GLbuttongo(800,400, 400, 80, Color.red);
		  btn6_.useImages(true);
		  btn6_.text_.str_ = "Eliminar";
		  btn6_.text_.setSize(25);
		  btn6_.text_.setColor(Color.black);
		  btn6_.text_.setStyle(GLgameConstants.kBOLD);
		  btn6_.text_.applyChanges();
		  btn6_.changeTextOffset(150, 42);
		  addObject(btn6_);
		   
		  
		  btn2_ = new GLbuttongo(800,600, 400, 80, Color.red);
		  btn2_.useImages(true);
		  btn2_.text_.str_ = "Nueva máquina";
		  btn2_.text_.setSize(25);
		  btn2_.text_.setColor(Color.black);
		  btn2_.text_.setStyle(GLgameConstants.kBOLD);
		  btn2_.text_.applyChanges();
		  btn2_.changeTextOffset(110, 42);
		  addObject(btn2_);

		  
		  
		 
		  table2_ = new GLtablego(70,250, 4,6, 170, 60,4);
		  table2_.setHeaderText(0, "Cod_Máquina");
		  table2_.setHeaderText(1, "Nombre");
		  table2_.setHeaderText(2, "Descripción");
		  table2_.setHeaderText(3, "Estado");
		  table2_.changeHeaderTextOffset(15, 22);
		  table2_.changeCellTextOffset(15, 22);
		  addObject(table2_);
		  
		  
		  table2_.addData(0, 0, "1");
		  table2_.addData(1, 0, "Maq 1");
		  
		  table2_.addData(2, 0, "Máquina para proyectos");
		  
		  table2_.addData(3, 0, "Bueno");
		  table2_.addData(0, 1, "2");
		  table2_.addData(1, 1, "Maq 2");
		  
		  table2_.addData(2, 1, "Máquina para proyectos");
		  
		  table2_.addData(3, 1, "Bueno");
		  table2_.addData(0, 2, "3");
		  table2_.addData(1, 2, "Maq 3");
		  
		  table2_.addData(2, 2, "Máquina para proyectos");
		  
		  table2_.addData(3, 2, "Arreglando");
		  table2_.addData(0, 3, "4");
		  table2_.addData(1, 3, "Maq 4");
		  
		  table2_.addData(2, 3, "Máquina para proyectos");
		  table2_.addData(3, 3, "Bueno");
		  
		  table2_.addData(0, 4, "5");
		  
		  table2_.addData(1, 4, "Maq 5");
		  
		  table2_.addData(2, 4, "Máquina para proyectos");
		 
		  table2_.addData(3, 4, "Bueno");
		  
		     table2_.addData(0, 5, "6");
		  
		  table2_.addData(1, 5, "Maq 6");
		  
		  table2_.addData(2, 5, "Máquina para proyectos");
		 
		  table2_.addData(3, 5, "Bueno");
		  
		 }


	 private void InitNuevamaq(){
		  
		  textarea_ = new GLtextareago(400, 240, 15, 400, 40);
		  textarea_.text_.setSize(20);
		  textarea_.text_.setColor(Color.black);
		  textarea_.text_.applyChanges();
		  textarea_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea_.setTextOffset(30, 28);
		  textarea_.setOverText("Cod_Máquina");
		  addObject(textarea_);
		  
		  textarea2_ = new GLtextareago(400, 320, 15, 400, 40);
		  textarea2_.text_.setSize(20);
		  textarea2_.text_.setColor(Color.black);
		  textarea2_.text_.applyChanges();
		  textarea2_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea2_.setTextOffset(30, 28);
		  textarea2_.setOverText("Nombre");
		  addObject(textarea2_);
		  
		  
		  textarea3_ = new GLtextareago(400, 400, 15, 400, 40);
		  textarea3_.text_.setSize(20);
		  textarea3_.text_.setColor(Color.black);
		  textarea3_.text_.applyChanges();
		  textarea3_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea3_.setTextOffset(30, 28);
		  textarea3_.setOverText("Descripción");
		  addObject(textarea3_);
		  
		  
		  textarea4_ = new GLtextareago(400, 480, 15, 400, 40);
		  textarea4_.text_.setSize(20);
		  textarea4_.text_.setColor(Color.black);
		  textarea4_.text_.applyChanges();
		  textarea4_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea4_.setTextOffset(30, 28);
		  textarea4_.setOverText("Estado");
		  addObject(textarea4_);
		  
		  
		  text1_ = new GLtextgo(200,260, "Código Máquina:");
		  text1_.setSize(20);
		  text1_.setColor(new Color(0, 6, 91));
		  text1_.setStyle(GLgameConstants.kBOLD);
		  text1_.setType("Sans");
		  text1_.applyChanges();
		  addObject(text1_);
		  
		     text2_ = new GLtextgo(200,340, "Nombre Máquina:");
		  text2_.setSize(20);
		  text2_.setColor(new Color(0, 6, 91));
		  text2_.setStyle(GLgameConstants.kBOLD);
		  text2_.setType("Sans");
		  text2_.applyChanges();
		  addObject(text2_);
		  
		      text3_ = new GLtextgo(160,420, "Descripción Máquina:");
		   text3_.setSize(20);
		   text3_.setColor(new Color(0, 6, 91));
		   text3_.setStyle(GLgameConstants.kBOLD); 
		   text3_.setType("Sans");
		         text3_.applyChanges();
		   addObject(text3_);
		  
		   
		    text4_ = new GLtextgo(200,500, "Estado Máquina:");
		    text4_.setSize(20);
		       text4_.setColor(new Color(0, 6, 91));
		    text4_.setStyle(GLgameConstants.kBOLD); 
		    text4_.setType("Sans");
		       text4_.applyChanges();
		    addObject(text4_);
		    
		    btn2_ = new GLbuttongo(850,550, 400, 80, Color.red);
		    btn2_.useImages(true);
		    btn2_.text_.str_ ="Cancelar";
		    btn2_.text_.setSize(25);
		    btn2_.text_.setColor(Color.black);
		    btn2_.text_.setStyle(GLgameConstants.kBOLD);
		    btn2_.text_.applyChanges();
		    btn2_.changeTextOffset(150, 42);
		   addObject(btn2_);
		   btn3_ = new GLbuttongo(850,450, 400, 80, Color.red);
		   btn3_.useImages(true);
		      btn3_.text_.str_ ="Aceptar";
		      btn3_.text_.setSize(25);
		   btn3_.text_.setColor(Color.black);
		   btn3_.text_.setStyle(GLgameConstants.kBOLD);
		   btn3_.text_.applyChanges();
		   btn3_.changeTextOffset(150, 42);
		   addObject(btn3_);
		  }
		   
		 
	private void NuevaMaq(){
		   if (btn2_.getisClicked() && init_state_){
		    proyect_state_ = ProyectState.kInitMaquinas;
		    destroyObject(btn2_);
		    destroyObject(text1_);
		    destroyObject(text2_);
		    
		    destroyObject(text3_);
		    destroyObject(text4_);
		    
		    destroyObject(textarea_);
		    
		    destroyObject(textarea2_);
		    
		             destroyObject(textarea3_);
		    
		    destroyObject(textarea4_);
		    
		    btn2_ = null;
		    text1_ = null;
		    text2_ = null;
		    text3_ = null;
		    text4_ = null;
		    textarea_ = null;
		    textarea2_ = null;
		    textarea3_ = null;
		    textarea4_ = null;
		   }
		   else if(btn3_.getisClicked() && init_state_){
		    
		   /* table2_.añadir("");*/
		    
		    proyect_state_ = ProyectState.kInitMaquinas;
		    
		       destroyObject(btn2_);
		    destroyObject(text1_);
		    destroyObject(text2_);
		    
		    destroyObject(text3_);
		    destroyObject(text4_);
		    
		    destroyObject(textarea_);
		    
		    destroyObject(textarea2_);
		    
		             destroyObject(textarea3_);
		    
		    destroyObject(textarea4_);
		    
		    btn2_ = null;
		    text1_ = null;
		    text2_ = null;
		    text3_ = null;
		    text4_ = null;
		    textarea_ = null;
		    textarea2_ = null;
		    textarea3_ = null;
		    textarea4_ = null;
		   
		   }
		 }

		  
	private void Maquinas(){
		  
		  if (btn_.getisClicked() && init_state_){
		            //Menu principal
		   
		   proyect_state_ = ProyectState.kInitMainMenu;
		   
		   destroyObject(btn_);
		   destroyObject(btn2_);
		   destroyObject(btn4_);
		   destroyObject(btn5_);
		   
		   destroyObject(btn6_);
		   destroyObject(table2_);
		  }
		  else if(btn2_.getisClicked() && init_state_){
		   //Nueva máquina
		      
		   proyect_state_ = ProyectState.kInitNuevaMaq;
		   
		   destroyObject(btn_);
		   destroyObject(btn2_);
		   destroyObject(btn4_);
		   destroyObject(btn5_);
		   
		   destroyObject(btn6_);
		   destroyObject(table2_);
		   
		  }
		  
		  else if(btn4_.getisClicked()){
		   //Modificar
		   
		            proyect_state_ = ProyectState.kInitNuevaMaq;
		   
		   destroyObject(btn_);
		   destroyObject(btn2_);
		   destroyObject(btn4_);
		   destroyObject(btn5_);
		   
		   destroyObject(btn6_);
		   destroyObject(table2_);
		   
		  }
		  else if(btn5_.getisClicked()){
		   //Añadir a proyecto
		  }
		  else if(btn6_.getisClicked()){
		   //Eliminar
		   //table2_.borrar(); 
		    }
		  
		  if(table2_.getGlobalfilaSelected() !=0){
		   btn4_.enable();
		   btn5_.enable();
		   
		   btn6_.enable();
		  }else{
		   btn2_.disable();
		   btn_.disable();
		  }
		 
		 }



	private void InitMateriales(){
		  
		  
		  btn_ = new GLbuttongo(100,600, 400, 80, Color.red);
		  btn_.loadImages("./Sprites/button.png", "./Sprites/button_over.png", "./Sprites/button_clicked.png");
		  btn_.useImages(true);
		  btn_.text_.str_ = "Menú principal";
		  btn_.text_.setSize(25);
		  btn_.text_.setColor(Color.black);
		  btn_.text_.setStyle(GLgameConstants.kBOLD);
		  btn_.text_.applyChanges();
		  btn_.changeTextOffset(110, 42);
		  addObject(btn_);
		  
		  
		  btn4_ = new GLbuttongo(950,300, 300, 80, Color.red);
		  btn4_.useImages(true);
		  btn4_.text_.str_ = "Modificar";
		  btn4_.text_.setSize(25);
		  btn4_.text_.setColor(Color.black);
		  btn4_.text_.setStyle(GLgameConstants.kBOLD);
		  btn4_.text_.applyChanges();
		  btn4_.changeTextOffset(100, 42);
		  addObject(btn4_);
		  
		  btn5_ = new GLbuttongo(950,200, 300, 80, Color.red);
		  btn5_.useImages(true);
		  btn5_.text_.str_ = "Añadir a proyecto";
		  btn5_.text_.setSize(25);
		  btn5_.text_.setColor(Color.black);
		  btn5_.text_.setStyle(GLgameConstants.kBOLD);
		  btn5_.text_.applyChanges();
		  btn5_.changeTextOffset(50, 42);
		  addObject(btn5_);
		  
		  btn6_ = new GLbuttongo(950,400, 300, 80, Color.red);
		  btn6_.useImages(true);
		  btn6_.text_.str_ = "Eliminar";
		  btn6_.text_.setSize(25);
		  btn6_.text_.setColor(Color.black);
		  btn6_.text_.setStyle(GLgameConstants.kBOLD);
		  btn6_.text_.applyChanges();
		  btn6_.changeTextOffset(100, 42);
		  addObject(btn6_);
		   
		  
		  btn2_ = new GLbuttongo(800,600, 400, 80, Color.red);
		  btn2_.useImages(true);
		  btn2_.text_.str_ = "Nuevo material";
		  btn2_.text_.setSize(25);
		  btn2_.text_.setColor(Color.black);
		  btn2_.text_.setStyle(GLgameConstants.kBOLD);
		  btn2_.text_.applyChanges();
		  btn2_.changeTextOffset(110, 42);
		  addObject(btn2_);
		  
		  
		  table3_ = new GLtablego(40,250, 6,5, 140, 60,3);
		  table3_.setHeaderText(0, "Cod_Material");
		  table3_.setHeaderText(1, "Nombre");
		  table3_.setHeaderText(2, "Descripción");
		  table3_.setHeaderText(3, "Tipo");
		  table3_.setHeaderText(4, "Stock");
		  table3_.setHeaderText(5, "Precio/Ud.(€)");
		  table3_.changeHeaderTextOffset(15, 22);
		  table3_.changeCellTextOffset(15, 22);
		  addObject(table3_);
		  
		  
		  
		  table3_.addData(0, 0, "1");
		  
		  table3_.addData(1, 0, "Mat 1");
		  
		  table3_.addData(2, 0, "Uso vario");
		  table3_.addData(3, 0, "Impresión 3D");
		  table3_.addData(4, 0, "20");
		  
		  table3_.addData(5, 0, "3.2");
		  
		  table3_.addData(0, 1, "2");
		  
		  table3_.addData(1, 1, "Mat 2");
		  
		  table3_.addData(2, 1, "Uso vario");
		  table3_.addData(3, 1, "Impresión 3D");
		  table3_.addData(4, 1, "20");
		  
		  table3_.addData(5, 1, "4.2");
		  
		  table3_.addData(0, 2, "3");
		  
		  table3_.addData(1, 2, "Mat 3");
		  
		  table3_.addData(2, 2, "Uso vario");
		  table3_.addData(3, 2, "Impresión 3D");
		  table3_.addData(4, 2, "20");
		  
		  table3_.addData(5, 2, "3.2");
		  
		  table3_.addData(0, 3, "4");
		  
		  table3_.addData(1, 3, "Mat 4");
		  
		  table3_.addData(2, 3, "Uso vario");
		  table3_.addData(3, 3, "Impresión 3D");
		  table3_.addData(4, 3, "20");
		  
		  table3_.addData(5, 3, "22");
		  
		  table3_.addData(0, 4, "5");
		  
		  table3_.addData(1, 4, "Mat 5");
		  
		  table3_.addData(2, 4, "Uso vario");
		  table3_.addData(3, 4, "Impresión 3D");
		  table3_.addData(4, 4, "20");
		  
		  table3_.addData(5, 4, "13.4");
		    }
		  


	private void Materiales(){
		  
		  if (btn_.getisClicked() && init_state_){
		           //Menu principal
		   proyect_state_ = ProyectState.kInitMainMenu;
		   
		   destroyObject(btn_);
		   destroyObject(btn2_);
		   destroyObject(btn4_);
		   destroyObject(btn5_);
		   
		   destroyObject(btn6_);
		   destroyObject(table3_);
		  }

		  else if(btn2_.getisClicked() && init_state_){
		   //Nueva máquina
		      
		   proyect_state_ = ProyectState.kInitNuevoMat;
		   
		   destroyObject(btn_);
		   destroyObject(btn2_);
		   destroyObject(btn4_);
		   destroyObject(btn5_);
		   
		   destroyObject(btn6_);
		   destroyObject(table3_);
		   
		  }
		  
		  else if(btn4_.getisClicked()){
		   //Modificar
		   
		    proyect_state_ = ProyectState.kInitNuevoMat;
		   
		   destroyObject(btn_);
		   destroyObject(btn2_);
		   destroyObject(btn4_);
		   destroyObject(btn5_);
		   
		   destroyObject(btn6_);
		   destroyObject(table3_);
		   
		  }

		  else if(btn5_.getisClicked()){
		   //Añadir a proyecto
		  }

		  else if(btn6_.getisClicked()){
		   //Eliminar
		   //table3_.borrar(); 
		    }
		  
		  if(table3_.getGlobalfilaSelected() !=0){
		   btn4_.enable();
		   btn5_.enable();
		   
		   btn6_.enable();
		  }
		else{
		   btn2_.disable();
		   btn_.disable();
		  }
		 }


	private void InitNuevoMat(){
		  
		  textarea_ = new GLtextareago(400, 220, 15, 400, 40);
		  textarea_.text_.setSize(20);
		  textarea_.text_.setColor(Color.black);
		  textarea_.text_.applyChanges();
		  textarea_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea_.setTextOffset(30, 28);
		  textarea_.setOverText("Cod_Material");
		  addObject(textarea_);
		  
		  textarea2_ = new GLtextareago(400, 300, 15, 400, 40);
		  textarea2_.text_.setSize(20);
		  textarea2_.text_.setColor(Color.black);
		  textarea2_.text_.applyChanges();
		  textarea2_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea2_.setTextOffset(30, 28);
		  textarea2_.setOverText("Nombre");
		  addObject(textarea2_);
		  
		  
		  textarea3_ = new GLtextareago(400, 380, 15, 400, 40);
		  textarea3_.text_.setSize(20);
		  textarea3_.text_.setColor(Color.black);
		  textarea3_.text_.applyChanges();
		  textarea3_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea3_.setTextOffset(30, 28);
		  textarea3_.setOverText("Descripción");
		  addObject(textarea3_);
		  
		  
		  textarea4_ = new GLtextareago(400, 460, 15, 400, 40);
		  textarea4_.text_.setSize(20);
		  textarea4_.text_.setColor(Color.black);
		  textarea4_.text_.applyChanges();
		  textarea4_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea4_.setTextOffset(30, 28);
		  textarea4_.setOverText("Tipo material");
		  addObject(textarea4_);
		  
		  textarea5_ = new GLtextareago(400, 540, 15, 400, 40);
		  textarea5_.text_.setSize(20);
		  textarea5_.text_.setColor(Color.black);
		  textarea5_.text_.applyChanges();
		  textarea5_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea5_.setTextOffset(30, 28);
		  textarea5_.setOverText("Stock");
		  addObject(textarea5_);
		  
		  textarea6_ = new GLtextareago(400, 620, 15, 400, 40);
		  textarea6_.text_.setSize(20);
		  textarea6_.text_.setColor(Color.black);
		  textarea6_.text_.applyChanges();
		  textarea6_.setColorChanges(new Color(58, 75, 180), 
		    new Color(58, 75, 255), 
		    new Color(86, 101, 255));
		  textarea6_.setTextOffset(30, 28);
		  textarea6_.setOverText("Precio/Ud.");
		  addObject(textarea6_);
		  
		  
		  text1_ = new GLtextgo(200,240, "Código Material:");
		  text1_.setSize(20);
		  text1_.setColor(new Color(0, 6, 91));
		  text1_.setStyle(GLgameConstants.kBOLD);
		  text1_.setType("Sans");
		  text1_.applyChanges();
		  addObject(text1_);
		  
		     text2_ = new GLtextgo(200,320, "Nombre Material:");
		  text2_.setSize(20);
		  text2_.setColor(new Color(0, 6, 91));
		  text2_.setStyle(GLgameConstants.kBOLD);
		  text2_.setType("Sans");
		  text2_.applyChanges();
		  addObject(text2_);
		  
		      text3_ = new GLtextgo(160,400, "Descripción Material:");
		   text3_.setSize(20);
		   text3_.setColor(new Color(0, 6, 91));
		   text3_.setStyle(GLgameConstants.kBOLD); 
		   text3_.setType("Sans");
		         text3_.applyChanges();
		   addObject(text3_);
		  
		   
		    text4_ = new GLtextgo(200,480, "Tipo Material:");
		    text4_.setSize(20);
		       text4_.setColor(new Color(0, 6, 91));
		    text4_.setStyle(GLgameConstants.kBOLD); 
		    text4_.setType("Sans");
		       text4_.applyChanges();
		    addObject(text4_);
		    
		    text5_ = new GLtextgo(200,560, "Stock Material:");
		    text5_.setSize(20);
		       text5_.setColor(new Color(0, 6, 91));
		    text5_.setStyle(GLgameConstants.kBOLD); 
		    text5_.setType("Sans");
		       text5_.applyChanges();
		    addObject(text5_);
		    
		    text6_ = new GLtextgo(180,640, "Precio/Unidad (€):");
		    text6_.setSize(20);
		       text6_.setColor(new Color(0, 6, 91));
		    text6_.setStyle(GLgameConstants.kBOLD); 
		    text6_.setType("Sans");
		       text6_.applyChanges();
		    addObject(text6_);
		    
		    btn2_ = new GLbuttongo(850,450, 400, 80, Color.red);
		    btn2_.useImages(true);
		    btn2_.text_.str_ ="Cancelar";
		    btn2_.text_.setSize(25);
		    btn2_.text_.setColor(Color.black);
		    btn2_.text_.setStyle(GLgameConstants.kBOLD);
		    btn2_.text_.applyChanges();
		    btn2_.changeTextOffset(150, 42);
		   addObject(btn2_);
		   btn3_ = new GLbuttongo(850,350, 400, 80, Color.red);
		   btn3_.useImages(true);
		      btn3_.text_.str_ ="Aceptar";
		      btn3_.text_.setSize(25);
		   btn3_.text_.setColor(Color.black);
		   btn3_.text_.setStyle(GLgameConstants.kBOLD);
		   btn3_.text_.applyChanges();
		   btn3_.changeTextOffset(150, 42);
		   addObject(btn3_);
		  }
		   
		 
	private void NuevoMat(){
		   if (btn2_.getisClicked() && init_state_){
		    proyect_state_ = ProyectState.kInitMateriales;
		    destroyObject(btn2_);
		    destroyObject(text1_);
		    destroyObject(text2_);
		    
		    destroyObject(text3_);
		    destroyObject(text4_);
		    
		    destroyObject(text5_);
		    
		    destroyObject(text6_);
		    
		    destroyObject(textarea_);
		    
		    destroyObject(textarea2_);
		    
		             destroyObject(textarea3_);
		    
		    destroyObject(textarea4_);
		    
		    destroyObject(textarea5_);
		    
		    destroyObject(textarea6_);
		    
		    btn2_ = null;
		    text1_ = null;
		    text2_ = null;
		    text3_ = null;
		    text4_ = null;
		    text5_= null;
		    text6_= null;
		    textarea_ = null;
		    textarea2_ = null;
		    textarea3_ = null;
		    textarea4_ = null;
		    textarea5_ = null;
		    textarea6_= null;
		   }
		   else if(btn3_.getisClicked() && init_state_){
		    
		   /* table2_.añadir("");*/
		    
		    proyect_state_ = ProyectState.kInitMateriales;
		    
		       destroyObject(btn2_);
		    destroyObject(text1_);
		    destroyObject(text2_);
		    
		    destroyObject(text3_);
		    destroyObject(text4_);
		    
		    destroyObject(text5_);
		    
		    destroyObject(text6_);
		    
		    destroyObject(textarea_);
		    
		    destroyObject(textarea2_);
		    
		             destroyObject(textarea3_);
		    
		    destroyObject(textarea4_);
		    
		    destroyObject(textarea5_);
		    
		    destroyObject(textarea6_);
		    
		    btn2_ = null;
		    text1_ = null;
		    text2_ = null;
		    text3_ = null;
		    text4_ = null;
		    text5_= null;
		    text6_= null;
		    textarea_ = null;
		    textarea2_ = null;
		    textarea3_ = null;
		    textarea4_ = null;
		    textarea5_ = null;
		    textarea6_= null;
		   }
		 }
	
}


