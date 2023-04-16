CREATE DATABASE BancoSangre;
go
USE BancoSangre;
go

CREATE TABLE sangre (
  id_sangre int identity,
  factor_rh char(1) CHECK (factor_rh IN ('+', '-')),
  grupo_abo char(2) CHECK (grupo_abo IN ('A', 'B', 'AB', 'O')),
  CONSTRAINT pk_sangre PRIMARY KEY(id_sangre)
);

CREATE TABLE unidad_sanguinea(
	id_unidad varchar(10) not null,
	id_sangre int,
	cantidad_unidades_sanguineas int
	constraint pk_unidad_sanguinea primary key(id_unidad)
	constraint fk_sangre foreign key(id_sangre) references sangre(id_sangre)
);

CREATE TABLE entidad(
	id_entidad int identity,
	nombre_entidad varchar(30),
	ruc char(11),
	razon_social varchar(30),
	constraint pk_entidad primary key(id_entidad)
);

CREATE TABLE donante(
	id_donante int identity,
	id_entidad int,
	nombre_donante varchar(20),
	apellido_paterno_donante varchar(20),
	apellido_materno_donante varchar(20),
	telefono_donante varchar(9),
	correo_donante varchar(40),
	constraint pk_donante primary key(id_donante),
	constraint fk_entidad_1 foreign key(id_entidad) references entidad(id_entidad)
);

CREATE TABLE solicitante(
	id_solicitante int identity,
	id_entidad int,
	nombre_solicitante varchar(20),
	apellido_paterno_solicitante varchar(20),
	apellido_materno_solicitante varchar(20),
	telefono_solicitante varchar(9),
	correo_solicitante varchar(40),
	constraint pk_solicitante primary key(id_solicitante),
	constraint fk_entidad_2 foreign key(id_entidad) references entidad(id_entidad)
);

CREATE TABLE solicitud(
	id_solicitud int identity,
	id_solicitante int,
	id_unidad varchar(10),
	motivo_solicitud varchar(140),
	unidades_sanguineas int,
	fecha_solicitud date,
	constraint pk_solicitud primary key(id_solicitud),
	constraint fk_solicitante foreign key(id_solicitante) references solicitante(id_solicitante),
	constraint fk_unidad_sanguinea_1 foreign key(id_unidad) references unidad_sanguinea(id_unidad)
);

CREATE TABLE extraccion(
	id_extraccion int identity,
	id_unidad varchar(10),
	id_donante int,
	unidad_sanguinea_extraccion int,
	fecha_extraccion date,
	constraint pk_extraccion primary key(id_extraccion),
	constraint fk_unidad_sanguinea_2 foreign key(id_unidad) references unidad_sanguinea(id_unidad),
	constraint fk_donante foreign key(id_donante) references donante(id_donante)
);

SELECT *
FROM sangre

SELECT *
FROM unidad_sanguinea

SELECT *
FROM solicitud

SELECT *
FROM solicitante

SELECT *
FROM entidad

SELECT *
FROM donante

SELECT *
FROM extraccion


-- inserción de datos tabla sangre:
INSERT INTO sangre (factor_rh, grupo_abo) VALUES
  ('+', 'A'),
  ('+', 'B'),
  ('+', 'AB'),
  ('+', 'O'),
  ('-', 'A'),
  ('-', 'B'),
  ('-', 'AB'),
  ('-', 'O');

-- inserción de datos tabla unidad sanguinea:
INSERT INTO unidad_sanguinea (id_unidad, id_sangre, cantidad_unidades_sanguineas) VALUES
('US001', 1, 10),
('US002', 2, 5),
('US003', 3, 15),
('US004', 4, 20),
('US005', 5, 10),
('US006', 6, 5),
('US007', 7, 15),
('US008', 8, 20);

-- inserción de datos tabla entidad:
insert into entidad values
	('Hospital jose', '1000000000', 'jose.SAC'),
	('Hospital negreiros', '2000000000', 'negreiros.SA'),
	('Hospital Loayza', '3000000000', 'Loayza.SAC'),
	('Hospital del niño', '4000000000', 'del niño.SA'),
	('Hospital de la policía', '5000000000', 'de la policía.SA'),
	('Hospital alamo', '6000000000', 'alamo.SA'),
	('Hospital san martin', '7000000000', 'san martin.SA'),
	('Voluntariado jose', default, 'jose.SA');

-- inserción de datos tabla solicitante:
insert into solicitante values
	(1, 'FRANCISCO JAVIER', 'HUAMAN', 'ABAD', '900000000', 'francisco.abad@unmsm.edu.pe'),
	(2, 'FLAVIA FRANCESCA', 'ABANTO', 'SALAS', '910000000', 'abanto.salas@unmsm.edu.pe'),
	(3, 'ALBERTO JUNIOR', 'ABARCA', 'RAMOS', '920000000', 'abarca.ramos@unmsm.edu.pe'),
	(4, 'RODRIGO YAMIL', 'AGÜERO', 'CARHUAVILCA', '930000000', 'aguero.car@unmsm.edu.pe'),
	(5, 'NICOLLE', 'AGUIRRE', 'POZO', '940000000', 'aguirre.pozo@unmsm.edu.pe'),
	(default, 'BRAULIO RENATO', 'ALFARO', 'MAURICIO', '950000000', 'alfaro.mauricio@unmsm.edu.pe'),
	(1, 'Ana', 'Castillo', 'Fernandez', '987654324', 'ana.castillo@hospitalnacional.com'),
	(2, 'Luis', 'Mendoza', 'Garcia', '987654325', 'luis.mendoza@clinicasanmiguel.com'),
	(3, 'Carla', 'Ramirez', 'Lopez', '987654326', 'carla.ramirez@cruzroja.org');

-- inserción de datos tabla donante:
insert into donante values
	(default, 'RENZO OMAR', 'BENDEZÚ', 'PAUTRAT', '999999999', 'bendezu.pautra@unmsm.edu.pe'),
	(7, 'RENZO OMAR', 'BENDEZÚ', 'PAUTRAT', '999999999', 'bendezu.pautra@unmsm.edu.pe'),
	(1, 'JUAN CARLOS', 'BERLANGA', 'PÉREZ' , '990999990', 'berlanga.perez@unmsm.edu.pe'),
	(2, 'WILMER ANDRÉS', 'BERNAOLA', 'CEDANO' , '939919979', 'bernaola.cedano@unmsm.edu.pe'),
	(3, 'OMAR SERGIO', 'BLAS', 'LÓPEZ' , '939033410', 'blas.lopez@unmsm.edu.pe'),
	(4, 'JHAMIL RODRIGO', 'BRAVO', 'CHUQUILLANQUI' , '959149388', 'bravo.chuqui@unmsm.edu.pe'),
	(5, 'RONAL JAIRO', 'CABELLO', 'CORDOVA' , '941993751', 'cabello,cordova@unmsm.edu.pe'),
	(1, 'Juan', 'Perez', 'Garcia', '987654321', 'juan.perez@hospitalnacional.com'),
	(2, 'Maria', 'Gomez', 'Mendoza', '987654322', 'maria.gomez@clinicasanmiguel.com'),
	(3, 'Pedro', 'Ramirez', 'Lopez', '987654323', 'pedro.ramirez@cruzroja.org');

-- inserción de datos tabla extracción:
INSERT INTO extraccion (id_unidad, id_donante, unidad_sanguinea_extraccion, fecha_extraccion) VALUES
('US001', 1, 1, '2023-02-10'),
('US002', 2, 1, '2023-02-12'),
('US003', 3, 2, '2023-02-13'),
('US004', 3, 1, '2023-02-14');

-- inserción de datos tabla solicitud:
INSERT INTO solicitud (id_solicitante, id_unidad, motivo_solicitud, unidades_sanguineas, fecha_solicitud) VALUES
( 1, 'US001', 'Operación de corazón', 3, '2023-02-15'),
( 2, 'US003', 'Parto de alto riesgo', 2, '2023-02-17'),
( 3, 'US002', 'Accidente de tránsito', 1, '2023-02-20');
