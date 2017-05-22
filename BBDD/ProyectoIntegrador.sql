DROP TABLE SE_USA;
DROP TABLE RESERVAS;
DROP TABLE HACEN;
DROP TABLE ASISTE;

DROP TABLE LINEA_PEDIDO;
DROP TABLE PEDIDO;
DROP TABLE PROVEEDORES;
DROP TABLE MATERIALES;

DROP TABLE MAQUINAS;
DROP TABLE PROYECTO;
DROP TABLE EVENTOS;
DROP TABLE USUARIO;


create table PROVEEDORES (
  CIF varchar2(9) constraint Cif_prov_pk primary key,
  Nombre varchar2(50) constraint Nom_prov_nn not null,
  Correo varchar2(40),
  Teléfono number(9) constraint Tlfno_prov_nn not null,
  Dirección varchar2(60) constraint Dir_prov_nn not null,
  Cod_Postal number(5) constraint CP_prov_nn not null,
  Descripcón varchar2(100)
);


create table PEDIDO (
  Cod_pedido number(5) constraint Cod_ped_pk primary key,
  Fecha date default sysdate,
  Total_importe number(5,2) constraint Total_pedido_nn not null,
  CIF_PROV VARCHAR2(9), 
  CONSTRAINT CIF_PROV_FK FOREIGN KEY(CIF_PROV)
  REFERENCES PROVEEDORES(CIF) ON DELETE CASCADE
);


create table MATERIALES (
  Cod_material VARCHAR2(5) constraint Cod_mat_pk primary key,
  Descripción varchar2(100),
  Nombre varchar2(30) constraint Nom_material_nn not null,
  Tipo_mat varchar2(20),
  Stock number(3) constraint Stock_material_nn not null,
  Precio_unidad number(5,2) constraint Precio_uni_mat_nn not null
);


create table LINEA_PEDIDO (
  Cod_mat VARCHAR2(5),
Cod_ped number(5),
Cantidad number(3) constraint Cant_línea_pedido_nn not null,
constraint Línea_ped_pk primary key(Cod_mat,Cod_ped),
constraint Cod_material_fk foreign key(Cod_mat)
references Materiales(Cod_material) on delete cascade,
constraint Dni_Cod_pedido_fk foreign key(Cod_ped)
references Pedido(Cod_pedido) on delete cascade
);



CREATE TABLE MAQUINAS(
  COD_MAQUINA VARCHAR2(5) CONSTRAINT MAQUINAS_PK  PRIMARY KEY,
  NOMBRE VARCHAR2(30) CONSTRAINT NOMBRE_MAQUINA_NN NOT NULL,
  DESCRIPCION VARCHAR2(100),
  ESTADO VARCHAR2(20) CONSTRAINT ESTADO_MAQUINA_NN NOT NULL
);

CREATE TABLE PROYECTO(
  COD_PROYECTO VARCHAR2(5) CONSTRAINT COD_PROYECTO_PK PRIMARY KEY,
  NOMBRE VARCHAR2(20) CONSTRAINT NOMBRE_PROYECTO_NN NOT NULL,
  DESCRIPCION VARCHAR2(80)
);

CREATE TABLE USUARIO(
  ID_SOCIO NUMBER(5) CONSTRAINT USUARIO_PK PRIMARY KEY,
  CONTRASENYA VARCHAR2(20) CONSTRAINT CONSTRASENYA_NN NOT NULL,
  NOMBRE VARCHAR2(20) CONSTRAINT NOMBRE_USUARIO_NN NOT NULL,
  APELLIDOS VARCHAR2(50) CONSTRAINT APELLIDOS_USUARIO_NN NOT NULL,
  CORREO VARCHAR2(50),
  TELEFONO NUMBER(9) CONSTRAINT TELEFONO_USUARIO_NN NOT NULL,
  TIPO_USUARIO VARCHAR2(20) CONSTRAINT TIPO_USUARIO_NN NOT NULL
);

CREATE TABLE EVENTOS(
  COD_EVENTO NUMBER(5) CONSTRAINT CODEVENTOS_PK PRIMARY KEY,
  FECHA DATE DEFAULT SYSDATE,
  MENTOR NUMBER(5),
  DURACION NUMBER(3) CONSTRAINT DURACION_EVENTOS_NN NOT NULL,
  LUGAR VARCHAR2(20) CONSTRAINT LUGAR_EVENTOS_NN NOT NULL,
  CONSTRAINT MENTOR_EVENTOS_FK FOREIGN KEY(MENTOR) REFERENCES USUARIO(ID_SOCIO),
  CATEGORIA VARCHAR2(20)
);

CREATE TABLE SE_USA(
  Cod_material VARCHAR2(5),
  COD_PROYECTO VARCHAR2(5),
  CANTIDAD_USADA NUMBER(5),
  CONSTRAINT SE_USA_PK PRIMARY KEY(Cod_material, COD_PROYECTO),
    CONSTRAINT COD_MATERIAL_SEUSA_FK FOREIGN KEY(Cod_material) 
    REFERENCES MATERIALES(Cod_material),
    CONSTRAINT COD_PROYECTO_FK FOREIGN KEY(COD_PROYECTO)
    REFERENCES PROYECTO(COD_PROYECTO)
);

CREATE TABLE RESERVAS (
    COD_MAQUINA VARCHAR2(5),
  COD_PROY VARCHAR2(5),
  FECHA_INI DATE DEFAULT SYSDATE,
  FECHA_FIN DATE,
    CONSTRAINT RESERVAS_PK PRIMARY KEY(COD_MAQUINA, COD_PROY, FECHA_INI),
    CONSTRAINT COD_MAQUINA_FK FOREIGN KEY(COD_MAQUINA) 
    REFERENCES MAQUINAS(COD_MAQUINA),
    CONSTRAINT COD_PROY_RESERVAS_FK FOREIGN KEY(COD_PROY) 
    REFERENCES PROYECTO(COD_PROYECTO)
);

CREATE TABLE HACEN (
    ID_SOCIO NUMBER(5),
  COD_PROY VARCHAR2(5),
    CONSTRAINT HACEN_PK PRIMARY KEY(ID_SOCIO, COD_PROY),
  CONSTRAINT ID_SOCIO_HACEN_FK FOREIGN KEY(ID_SOCIO)
    REFERENCES USUARIO(ID_SOCIO),
    CONSTRAINT COD_PROY_HACEN_FK FOREIGN KEY(COD_PROY)
    REFERENCES PROYECTO(COD_PROYECTO)
);

CREATE TABLE ASISTE (
    ID_SOCIO NUMBER(5),
  COD_EVENTO NUMBER(5),
  CONSTRAINT ASISTE_PK PRIMARY KEY(ID_SOCIO, COD_EVENTO),
  CONSTRAINT ID_SOCIO_ASISTE_FK FOREIGN KEY(ID_SOCIO)
    REFERENCES USUARIO(ID_SOCIO),
    CONSTRAINT COD_EVENTO_FK FOREIGN KEY(COD_EVENTO)
    REFERENCES EVENTOS(COD_EVENTO)
);



INSERT INTO PROVEEDORES VALUES( 'B8818501,', 'TECNO3D', 'TECNO3D_CONTACT@GMAIL.COM', 695834687, 'AV. DOCTOR FLEMING 147',  28021, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'A38183501', 'SANCHEZMATS', 'SANCHEZMATS@GMAIL.COM', 687598149, 'CALLE OBERON 6', 28030, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'A58818501', 'APEXSPRINT', 'APEX_PRINT@HOTMAIL.COM', 632598741, 'AV. VIRREINA 69', '28010', 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'D97983502', 'RUBEN3D', 'RUBEN_MARGIOTTA3D@YAHOO.COM', 647956743, 'CALLE MORTADELO Y FILEMON 25', 28017, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'E98501999', 'IGNACIO_FIGURES', 'ILOVEWOW_FIGURES@GMAIL.COM', 625441579, 'CALLE BATMAN y ROBIN 69', 28005, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'D38818987', 'WRASPPS', 'PORQUENOTECALLAS@HOTMAIL.ES', 609697169, 'CALLE JOSE BERGAMIN 18', 28229,  'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'A38718501', 'SUPERCOMPU', 'YOSOYPATY@HOTMAIL.COM', 654271744, 'CALLE ANTONIO CUMELLA 23', 28030,  'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'J58817496', 'LINAVATION', 'RAUL_VICENTE@GMAIL.COM', 651552547, 'CALLE NARVAEZ 97',  28047,  'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'A58963211', 'BBMATS', 'BRENDOLA_CATOLA@GMAIL.COM', 627428398, 'AV. DOCTOR GARCIA TAPIA 285', 28002,  'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'L78645501', 'MARIOPRINTERS', 'MARIONACARINO@GMAIL.COM', 617552562, 'CALLE PRIEGOLA 2', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'B82938112', 'CORP SA', 'CORP_SA_@GMAIL.COM', 617552729, 'CALLE EUROPA 22', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'L78675654', 'LUIGIPRINTERS', 'LUIGICARINO@GMAIL.COM', 617756582, 'CALLE FUERNACAL 2', 28087, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'Q99284531', 'TO PRINT', 'TOPRINTCONTACT@GMAIL.COM', 629887731, 'CALLE MANZANO SN', 28009, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'T34289945', 'IKEPRINTS', 'I_KE_PRINTS@GMAIL.COM', 902777777, 'CALLE TRUFA 43', 28039, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'O99384738', 'TLO3D', 'TLO3D_CONTACT@GMAIL.COM', 916582288, 'CALLE HMNOS MACHADO 76', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'A22330012', '3DMATS', '3DMATS_CONTACT@GMAIL.COM', 902334455, 'CALLE DALMATA 12', 28027, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'I99283332', 'FECNOCORP', 'FEC@GMAIL.COM', 622343635, 'CALLE GATO 5', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'K12983273', 'PLASTICSCOP', 'PLASTICSCOP@GMAIL.COM', 916809922, 'CALLE PATAPON 15', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'W32837457', 'TOO90', 'TOO90@GMAIL.COM', 917789977, 'CALLE IGLESIAS 23', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'F32803218', 'THEPRI', 'THEPRI@GMAIL.COM', 912346622, 'CALLE PERU 57', 28022, 'MATERIALES FANTÁSTICOS');
INSERT INTO PROVEEDORES VALUES( 'E12810384', 'CANV3D', 'CANV3D@GMAIL.COM', 918902244, 'CALLE FUNDICION SN', 28022, 'MATERIALES FANTÁSTICOS');


INSERT INTO PEDIDO VALUES(001, '12/20/2015', 202.85, 'A58963211');
INSERT INTO PEDIDO VALUES(002, '12/25/2015', 64.58, 'A58963211');
INSERT INTO PEDIDO VALUES(003, '01/13/2016', 58.95, 'K12983273');
INSERT INTO PEDIDO VALUES(004, '11/01/2016', 108.98, 'W32837457');
INSERT INTO PEDIDO VALUES(005, '03/19/2016', 525.47, 'W32837457');
INSERT INTO PEDIDO VALUES(006, '05/25/2016', 302.57, 'J58817496');
INSERT INTO PEDIDO VALUES(007, '06/14/2016', 746.41, 'J58817496');
INSERT INTO PEDIDO VALUES(008, '07/02/2016', 147.47, 'F32803218');
INSERT INTO PEDIDO VALUES(009, '07/22/2016', 943.74, 'F32803218');
INSERT INTO PEDIDO VALUES(010, '08/15/2016', 587.36, 'E12810384');
INSERT INTO PEDIDO VALUES(011, '03/15/2016', 223.32, 'E12810384');
INSERT INTO PEDIDO VALUES(012, '08/21/2016', 767.16, 'E12810384');
INSERT INTO PEDIDO VALUES(013, '04/05/2016', 736.23, 'E98501999');
INSERT INTO PEDIDO VALUES(014, '09/04/2016', 476.98, 'A22330012');
INSERT INTO PEDIDO VALUES(015, '11/05/2016', 845.49, 'L78675654');
INSERT INTO PEDIDO VALUES(016, '10/16/2016', 475.67, 'E98501999');
INSERT INTO PEDIDO VALUES(017, '06/21/2016', 576.43, 'B82938112');
INSERT INTO PEDIDO VALUES(018, '01/23/2016', 485.09, 'A22330012');
INSERT INTO PEDIDO VALUES(019, '03/15/2016', 847.56, 'B82938112');
INSERT INTO PEDIDO VALUES(020, '05/01/2016', 648.49, 'E98501999');


INSERT INTO MATERIALES VALUES('P250N', 'Filamento negro 1,75mm 600 g', 'FILAMENTO NEGRO', 'Suministro', 254, 2.50 );
INSERT INTO MATERIALES VALUES('P250B', 'Filamento blanco 1,75mm 600 g', 'FILAMENTO BLANCO', 'Suministro', 367, 2.50 );
INSERT INTO MATERIALES VALUES('P250V', 'Filamento verde 1,75mm 600 g', 'FILAMENTO VERDE', 'Suministro', 574, 2.50 );
INSERT INTO MATERIALES VALUES('P250A', 'Filamento azul 1,75mm 600 g', 'FILAMENTO AZUL', 'Suministro', 197, 2.50 );
INSERT INTO MATERIALES VALUES('P250C', 'Filamento amarillo 1,75mm 600 g', 'FILAMENTO AMARILLO', 'Suministro', 487, 2.50 );
INSERT INTO MATERIALES VALUES('R1995', 'Kit de rodamientos para impresora 3D', 'RODAMIENTOS', 'Recambio', 10, 19.95);
INSERT INTO MATERIALES VALUES('F2495', 'Fuente de alimentación 12V 25A  300W', 'FUENTE', 'Recambio', 17, 24.95);
INSERT INTO MATERIALES VALUES('K1595', 'Kit de cama caliente MK2A',  'CAMA', 'Recambio', 5, 15.95);
INSERT INTO MATERIALES VALUES('KT159', 'Kit de transmisión para impresora 3D para prusa', 'TRANSMISION', 'Recambio', 5, 15.95);
INSERT INTO MATERIALES VALUES('HP289', 'Hotend para prusa', 'HOTEND', 'Recambio',25, 18.95);
INSERT INTO MATERIALES VALUES('P251R', 'Filamento rojo 1,75 600G', 'FILAMENTO ROJO', 'Suministro', 324 ,2.50);
INSERT INTO MATERIALES VALUES('P251G', 'Filamento gris  1,75 600G', 'FILAMENTO GRIS', 'Suministro', 456 ,2.50);
INSERT INTO MATERIALES VALUES('P251M', 'Filamento marrón 1,75 600G', 'FILAMENTO MARRÓN', 'Suministro', 244 ,2.50);
INSERT INTO MATERIALES VALUES('P251N', 'Filamento naranja 1,75 600G', 'FILAMENTO NARANJA', 'Suministro', 475 ,2.50);
INSERT INTO MATERIALES VALUES('P252R', 'Filamento rosa 1,75 600G', 'FILAMENTO ROSA', 'Suministro', 283 ,2.50);
INSERT INTO MATERIALES VALUES('P252M', 'Filamento morado 1,75 600G', 'FILAMENTO MORADO', 'Suministro', 384 ,2.50);
INSERT INTO MATERIALES VALUES('P251C', 'Filamento celeste 1,75 600G', 'FILAMENTO CELESTE', 'Suministro', 435 ,2.50);
INSERT INTO MATERIALES VALUES('P252C', 'Filamento carmín 1,75 600G', 'FILAMENTO CARMÍN', 'Suministro', 340 ,2.50);
INSERT INTO MATERIALES VALUES('P252G', 'Filamento granate 1,75 600G', 'FILAMENTO GRANATE', 'Suministro', 228 ,2.50);
INSERT INTO MATERIALES VALUES('P251T', 'Filamento turquesa 1,75 600G', 'FILAMENTO TURQUESA', 'Suministro', 745 ,2.50);


INSERT INTO LINEA_PEDIDO VALUES('P250N', 001, 10);
INSERT INTO LINEA_PEDIDO VALUES('P250B', 002, 25);
INSERT INTO LINEA_PEDIDO VALUES('P250A', 003, 18);
INSERT INTO LINEA_PEDIDO VALUES('P250N', 004, 50);
INSERT INTO LINEA_PEDIDO VALUES('KT159', 005, 1);
INSERT INTO LINEA_PEDIDO VALUES('F2495', 006, 3);
INSERT INTO LINEA_PEDIDO VALUES('R1995', 007, 1);
INSERT INTO LINEA_PEDIDO VALUES('K1595', 008, 2);
INSERT INTO LINEA_PEDIDO VALUES('P250A', 009, 10);
INSERT INTO LINEA_PEDIDO VALUES('P250A', 010, 34);
INSERT INTO LINEA_PEDIDO VALUES('P250N', 011, 12);
INSERT INTO LINEA_PEDIDO VALUES('P251M', 012, 22);
INSERT INTO LINEA_PEDIDO VALUES('P251C', 013, 34);
INSERT INTO LINEA_PEDIDO VALUES('P251C', 014, 16);
INSERT INTO LINEA_PEDIDO VALUES('P251G', 015, 13);
INSERT INTO LINEA_PEDIDO VALUES('P251T', 016, 25);
INSERT INTO LINEA_PEDIDO VALUES('P251R', 017, 23);
INSERT INTO LINEA_PEDIDO VALUES('P251R', 018, 4);
INSERT INTO LINEA_PEDIDO VALUES('P251M', 019, 1);
INSERT INTO LINEA_PEDIDO VALUES('P251M', 020, 17);

INSERT INTO MAQUINAS VALUES('MQN01', 'Máquina eventos', 'máquina principal para los eventos', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN02', 'Máquina de eventos2', 'máquina suplente de eventos', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN03', 'Máquina de eventos3', 'máquina suplente de eventos', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN04', 'Máquina de eventos4', 'máquina suplente de eventos', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN05', 'Máquina de eventos5', 'máquina suplente de eventos', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN06', 'Máquina de muestra',  'Máquina de exposición', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN07', 'Máquina de muestra2', 'Segunda máquina de exposición', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN08', 'Máquina de muestra3', 'Segunda máquina de exposición', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN09', 'Máquina de muestra4', 'Segunda máquina de exposición', 'OPERATIVA');
INSERT INTO MAQUINAS VALUES('MQN10', 'Máquina de muestra5', 'Segunda máquina de exposición', 'OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN11', 'Máquina uso del personal', 'OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN12', 'Máquina uso del personal2', 'OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN13', 'Máquina uso del personal3', 'OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN14', 'Máquina uso del personal4', 'OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN15', 'Máquina uso del personal5', 'OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN16', 'Máquina uso cursos', 'NO OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN17', 'Máquina uso cursos2', 'NO OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN18', 'Máquina uso cursos3', 'NO OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN19', 'Máquina uso cursos4', 'NO OPERATIVA');
INSERT INTO MAQUINAS (COD_MAQUINA, NOMBRE, ESTADO) VALUES('MQN20', 'Máquina uso cursos5', 'NO OPERATIVA');



INSERT INTO PROYECTO VALUES('PRY01', 'PROYECTO 1','Proyecto de prueba');
INSERT INTO PROYECTO VALUES('PRY02', 'PROYECTO 2', 'Proyecto de exhibición en Barcelona');
INSERT INTO PROYECTO VALUES('PRY03', 'PROYECTO 3', 'Proyecto figuras warhummer');
INSERT INTO PROYECTO VALUES('PRY04', 'PROYECTO 4', 'Proyecto respuestos con maquina 3D');
INSERT INTO PROYECTO VALUES('PRY05', 'PROYECTO 5', 'Proyecto piezas de moto');
INSERT INTO PROYECTO VALUES('PRY06', 'PROYECTO 6', 'Proyecto figuras de marca');
INSERT INTO PROYECTO VALUES('PRY07', 'PROYECTO 7', 'Proyecto accesorios de cocina');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY08', 'PROYECTO 8');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY09', 'PROYECTO 9');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY10', 'PROYECTO 10');
INSERT INTO PROYECTO VALUES('PRY11', 'PROYECTO 11', 'Proyecto trabajo fin de grado');
INSERT INTO PROYECTO VALUES('PRY12', 'PROYECTO 12','Proyecto para figuras de personajes');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY13', 'PROYECTO 13');
INSERT INTO PROYECTO VALUES('PRY14', 'PROYECTO 14','Proyecto para artículos de regalo');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY15', 'PROYECTO 15');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY16', 'PROYECTO 16');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY17', 'PROYECTO 17');
INSERT INTO PROYECTO VALUES('PRY18', 'PROYECTO 18', 'Proyecto para piezas varias');
INSERT INTO PROYECTO VALUES('PRY19', 'PROYECTO 19','Proyecto para piezas máquinas ');
INSERT INTO PROYECTO (COD_PROYECTO, NOMBRE) VALUES('PRY20', 'PROYECTO 20');


INSERT INTO USUARIO VALUES(001, '123456', 'PABLO', 'DE BLAS ESCOBAR', 'PDEBLAS@GMAIL.COM', 697852654, 'VETERANO');
INSERT INTO USUARIO VALUES(002, '123456', 'PATRICIA', 'RUIZ DEL CASTILLO', 'P.RUIZ@GMAIL.COM', 647856985, 'AFILIADO' );
INSERT INTO USUARIO VALUES(003, '123456', 'ESTHER', 'AYUSO', 'EAYUSO@GMAIL.COM', 632201547, 'AFILIADO');
INSERT INTO USUARIO VALUES(004, '123456', 'SERGIO', 'BORGES', 'SGBORGES@GMAIL.COM', 665837276, 'ADMINISTRADOR');
INSERT INTO USUARIO VALUES(005, '123456', 'JAVIER', 'MARTINEZ','JMARTINEZ@GMAIL.COM', 654789541, 'ADMINISTRADOR');
INSERT INTO USUARIO VALUES(006, '123456', 'KARIM', 'MOHAMMED','MOROKARIM@GMAIL.COM', 695741415, 'AFILIADO');
INSERT INTO USUARIO VALUES(007, '123456', 'RAFAEL', 'MARQUEZ' ,'RAFICASHUHERMANIKOO@GMAIL.COM', 651552563, 'ORGANIZADOR');
INSERT INTO USUARIO VALUES(008, '123456', 'IGNACIO','BARRAGAN', 'NACHOBARRA@GMAIL.COM', 616887722, 'AFILIADO');
INSERT INTO USUARIO VALUES(009, '123456', 'RUBEN', 'MARGIOTTA', 'RUBITORESHULON69@GMAIL.COM', 694693578, 'PROFESOR');
INSERT INTO USUARIO VALUES(010, '123456', 'PEDRO', 'RIVAS', 'PEDROELGUAY@GMAIL.COM', 660193556, 'PROFESOR');
INSERT INTO USUARIO VALUES(011, '123456', 'ALEJANDRO', 'TAMAMES', 'ALEXGROGMEN@GMAIL.COM', 629887733, 'ORGANIZADOR' );
INSERT INTO USUARIO VALUES(012, '123456', 'SANDRA', 'RODRIGUEZ', 'RODRIGEZZG@GMAIL.COM', 648991427, 'CONVERSADOR' );
INSERT INTO USUARIO VALUES(013, '123456', 'FABIOLA', 'GARCIA', 'FDEFABIOLA@GMAIL.COM', 660193522, 'CONVERSADOR' );
INSERT INTO USUARIO VALUES(014, '123456', 'RIGOBERTA', 'RIGOBERTEZ', 'REGOBERTAEZ@GMAIL.COM', 676239823, 'AFILIADO' );
INSERT INTO USUARIO VALUES(015, '123456', 'FERNANDO', 'TROLLENZ', 'LOLMASTER@GMAIL.COM', 601234567, 'AFILIADO' );
INSERT INTO USUARIO VALUES(016, '123456', 'JOSE', 'CASTILLAR', 'ELPEPE_77@GMAIL.COM', 609876543, 'CONVERSADOR' );
INSERT INTO USUARIO VALUES(017, '123456', 'ALVARO', 'DE VIVAR', 'EUROARLVARO@GMAIL.COM', 609772663, 'AFILIADO' );
INSERT INTO USUARIO VALUES(018, '123456', 'JUAN', 'TALAMERA', 'JUAN_OFICIAL@GMAIL.COM', 626332211, 'AFILIADO' );
INSERT INTO USUARIO VALUES(019, '123456', 'PERICO', 'SANCHIS', 'SANPE@GMAIL.COM', 660138556, 'AFILIADO' );
INSERT INTO USUARIO VALUES(020, '123456', 'JAIME', 'ALFILES', 'ELPROFEJAIME@GMAIL.COM', 632443377, 'AFILIADO' );



INSERT INTO EVENTOS VALUES(001, '01/15/2016', 016, 60 , 'Madrid', 'Principiante');
INSERT INTO EVENTOS VALUES(002, '01/30/2016', 013, 60 , 'Madrid', 'Principiante');
INSERT INTO EVENTOS VALUES(003, '02/15/2016', 016, 60 , 'Valencia', 'Principiante');
INSERT INTO EVENTOS VALUES(004, '02/25/2016', 016, 90 , 'Valencia', 'Medio');
INSERT INTO EVENTOS VALUES(005, '03/05/2016', 013, 90 , 'Madrid', 'Medio');
INSERT INTO EVENTOS VALUES(006, '03/15/2016', 013, 90 , 'Madrid', 'Medio');
INSERT INTO EVENTOS VALUES(007, '04/01/2016', 016, 90 , 'Valencia', 'Avanzado');
INSERT INTO EVENTOS VALUES(008, '04/20/2016', 016, 90 , 'Barcelona', 'Medio');
INSERT INTO EVENTOS VALUES(009, '04/30/2016', 011, 90 , 'Barcelona', 'Avanzado');
INSERT INTO EVENTOS VALUES(010, '05/05/2016', 016, 90 , 'Madrid', 'Principiante');
INSERT INTO EVENTOS VALUES(011, '05/20/2016', 011, 60 , 'Barcelona', 'Principiante');
INSERT INTO EVENTOS VALUES(012, '06/05/2016', 016, 60 , 'Barcelona', 'Principiante');
INSERT INTO EVENTOS VALUES(013, '06/15/2016', 013, 60 , 'Madrid', 'Principiante');
INSERT INTO EVENTOS VALUES(014, '06/25/2016', 013, 60 , 'Valencia', 'Principiante');
INSERT INTO EVENTOS VALUES(015, '07/10/2016', 016, 60 , 'Toledo', 'Principiante');
INSERT INTO EVENTOS VALUES(016, '07/25/2016', 016, 60 , 'Sevilla', 'Principiante');
INSERT INTO EVENTOS VALUES(017, '07/30/2016', 016, 60 , 'Sevilla', 'Principiante');
INSERT INTO EVENTOS VALUES(018, '08/05/2016', 011, 60 , 'Sevilla', 'Principiante');
INSERT INTO EVENTOS VALUES(019, '08/15/2016', 011, 90 , 'Valencia', 'Medio');
INSERT INTO EVENTOS VALUES(020, '08/25/2016', 011, 90 , 'Madrid', 'Avanzado');


INSERT INTO SE_USA VALUES('P250N', 'PRY01', 2);
INSERT INTO SE_USA VALUES('P250N', 'PRY06', 1);
INSERT INTO SE_USA VALUES('P251N', 'PRY02', 5);
INSERT INTO SE_USA VALUES('P250N', 'PRY03', 6);
INSERT INTO SE_USA VALUES('P251N', 'PRY03', 4);
INSERT INTO SE_USA VALUES('P250N', 'PRY07', 1);
INSERT INTO SE_USA VALUES('P251N', 'PRY07', 1);
INSERT INTO SE_USA VALUES('P252G', 'PRY04', 15);
INSERT INTO SE_USA VALUES('P252G', 'PRY05', 42);
INSERT INTO SE_USA VALUES('P250N', 'PRY05', 14);
INSERT INTO SE_USA VALUES('P252G', 'PRY08', 2);
INSERT INTO SE_USA VALUES('P250N', 'PRY08', 1);
INSERT INTO SE_USA VALUES('P252G', 'PRY09', 5);
INSERT INTO SE_USA VALUES('P250N', 'PRY02', 6);
INSERT INTO SE_USA VALUES('P252G', 'PRY03', 4);
INSERT INTO SE_USA VALUES('P250N', 'PRY09', 1);
INSERT INTO SE_USA VALUES('P252G', 'PRY10', 1);
INSERT INTO SE_USA VALUES('P250N', 'PRY15', 15);
INSERT INTO SE_USA VALUES('P252G', 'PRY01', 42);
INSERT INTO SE_USA VALUES('P252G', 'PRY15', 14);



INSERT INTO RESERVAS VALUES('MQN01', 'PRY01', '01/07/2016', '01/10/2016');
INSERT INTO RESERVAS VALUES('MQN02', 'PRY01', '01/09/2016', '01/10/2016');
INSERT INTO RESERVAS VALUES('MQN03', 'PRY01', '01/01/2016', '01/10/2016');
INSERT INTO RESERVAS VALUES('MQN01', 'PRY02', '03/20/2016', '04/05/2016');
INSERT INTO RESERVAS VALUES('MQN02', 'PRY02', '03/20/2016', '04/05/2016');
INSERT INTO RESERVAS VALUES('MQN03', 'PRY02', '03/20/2016', '04/05/2016');
INSERT INTO RESERVAS VALUES('MQN06', 'PRY03', '08/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN07', 'PRY03', '08/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN08', 'PRY03', '08/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN01', 'PRY01', '10/01/2016', '01/10/2016');
INSERT INTO RESERVAS VALUES('MQN02', 'PRY05', '01/01/2016', '01/10/2016');
INSERT INTO RESERVAS VALUES('MQN03', 'PRY01', '05/01/2016', '01/10/2016');
INSERT INTO RESERVAS VALUES('MQN01', 'PRY02', '05/20/2016', '04/05/2016');
INSERT INTO RESERVAS VALUES('MQN02', 'PRY07', '05/20/2016', '04/05/2016');
INSERT INTO RESERVAS VALUES('MQN03', 'PRY06', '05/20/2016', '04/05/2016');
INSERT INTO RESERVAS VALUES('MQN06', 'PRY03', '09/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN07', 'PRY08', '12/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN08', 'PRY03', '11/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN07', 'PRY09', '04/01/2016', '08/31/2016');
INSERT INTO RESERVAS VALUES('MQN08', 'PRY07', '10/01/2016', '08/31/2016');



INSERT INTO HACEN VALUES(001, 'PRY01');
INSERT INTO HACEN VALUES(002, 'PRY01');
INSERT INTO HACEN VALUES(003, 'PRY01');
INSERT INTO HACEN VALUES(001, 'PRY03');
INSERT INTO HACEN VALUES(002, 'PRY03');
INSERT INTO HACEN VALUES(003, 'PRY03');
INSERT INTO HACEN VALUES(004, 'PRY03');
INSERT INTO HACEN VALUES(005, 'PRY03');
INSERT INTO HACEN VALUES(006, 'PRY03');
INSERT INTO HACEN VALUES(006, 'PRY07');
INSERT INTO HACEN VALUES(007, 'PRY07');
INSERT INTO HACEN VALUES(007, 'PRY02');
INSERT INTO HACEN VALUES(008, 'PRY05');
INSERT INTO HACEN VALUES(009, 'PRY02');
INSERT INTO HACEN VALUES(010, 'PRY07');
INSERT INTO HACEN VALUES(010, 'PRY06');
INSERT INTO HACEN VALUES(007, 'PRY05');
INSERT INTO HACEN VALUES(007, 'PRY08');
INSERT INTO HACEN VALUES(010, 'PRY09');
INSERT INTO HACEN VALUES(006, 'PRY01');



INSERT INTO ASISTE VALUES(001, 001);
INSERT INTO ASISTE VALUES(002, 006);
INSERT INTO ASISTE VALUES(003, 001);
INSERT INTO ASISTE VALUES(004, 001);
INSERT INTO ASISTE VALUES(005, 001);
INSERT INTO ASISTE VALUES(006, 001);
INSERT INTO ASISTE VALUES(007, 001);
INSERT INTO ASISTE VALUES(008, 001);
INSERT INTO ASISTE VALUES(009, 001);
INSERT INTO ASISTE VALUES(001, 004);
INSERT INTO ASISTE VALUES(008, 002);
INSERT INTO ASISTE VALUES(003, 002);
INSERT INTO ASISTE VALUES(001, 003);
INSERT INTO ASISTE VALUES(002, 003);
INSERT INTO ASISTE VALUES(003, 003);
INSERT INTO ASISTE VALUES(004, 003);
INSERT INTO ASISTE VALUES(001, 002);
INSERT INTO ASISTE VALUES(002, 002);