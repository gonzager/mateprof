INSERT INTO PROFESOR (ID, APELLIDO, NOMBRE, PUNTAJE_DOCENTE) VALUES(1,'GONZALEZ','GERARDO',10);

INSERT INTO PROFESOR (ID,APELLIDO, NOMBRE, PUNTAJE_DOCENTE) VALUES(2, 'MOLINA','JAVIER',8);

INSERT INTO MATERIA (ID, ANIO, CODIGO, NOMBRE) VALUES(1,1,'202201','PROGRAMACION CON OBJETOS I');
INSERT INTO MATERIA (ID, ANIO, CODIGO, NOMBRE) VALUES(2,1,'202202','MATEMATICA');
INSERT INTO MATERIA (ID, ANIO, CODIGO, NOMBRE) VALUES(3,1,'202203','ALGORITMOS Y ESTRUCTURAS DE DATOS');
INSERT INTO MATERIA (ID, ANIO, CODIGO, NOMBRE) VALUES(4,2,'202202','PROGRAMACION CON OBJETOS II');
INSERT INTO MATERIA (ID, ANIO, CODIGO, NOMBRE) VALUES(5,2,'202202','ROBOTICA');
INSERT INTO MATERIA (ID, ANIO, CODIGO, NOMBRE) VALUES(6,4,'202203','SIN ASIGNACION');

INSERT INTO PROFESOR_MATERIAS VALUES (1,1);
INSERT INTO PROFESOR_MATERIAS VALUES (1,2);
INSERT INTO PROFESOR_MATERIAS VALUES (1,3);
INSERT INTO PROFESOR_MATERIAS VALUES (2,3);
INSERT INTO PROFESOR_MATERIAS VALUES (2,4);
INSERT INTO PROFESOR_MATERIAS VALUES (2,5);