-- Tablas progtv

--conn / as sysdba

--drop user curso cascade;
--create user curso identified by secreto
--       default tablespace users;
--grant dba to curso;

define user=&1
define pass=&1

conn &user/&pass@curso

CREATE TABLE USERS (
       IDUSER               VARCHAR2(12) NOT NULL,
       PASSWORD             VARCHAR2(64) NOT NULL,
       NOMBRE               VARCHAR2(50) NOT NULL,
       LASTLOGIN            DATE NULL,
       PRIMARY KEY (IDUSER)
);

CREATE TABLE CADENAS (
       ID_CADENA          INTEGER NOT NULL,
       NOMBRE             VARCHAR2(50),
       PRIMARY KEY (ID_CADENA)
);

CREATE TABLE PROGRAMAS (
       ID_PROG            INTEGER NOT NULL,
       ID_CADENA          INTEGER NOT NULL,
       PROGRAMA           VARCHAR2(50),
       HORAINICIO         VARCHAR2(50),
       HORAFIN            VARCHAR2(50),
       PRIMARY KEY (ID_PROG)
);

ALTER TABLE PROGRAMAS
 ADD CONSTRAINT CADENA_FK
 FOREIGN KEY (ID_CADENA)
 REFERENCES CADENAS (ID_CADENA);

insert into users (iduser,password,nombre)
       values ('root','root','Administrador');
insert into users (iduser,password,nombre)
       values ('gregor','123','Gregorio Samsa');

insert into cadenas values(1,'TV1');
insert into programas values(1,1,'Telediario','15:00','15:30');
insert into cadenas values(2,'TV2');
insert into programas values(2,2,'Noticias de la noche','21:00','21:30 aprox.');
insert into programas values(3,2,'Cifras y Letras','14:15','14:45');
insert into cadenas values (3,'Antena 3');
insert into programas values(4,3,'Teletienda','04:30','05:30');
insert into cadenas values (4,'Tele Madrid');
insert into programas values(5,4,'Deportes en la madrugada','02:30','03:45');
insert into cadenas values (5,'Tele 5');
insert into programas values(6,5,'Gran bisabuelo','sobre las 17','dura 1 hora');
insert into cadenas values (6,'Canal+');
insert into programas values(7, 6, 'Canal de la mancha', '24:00', 'no se sabe');

select * from users;

commit;

