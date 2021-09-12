create database SpotSound;
use SpotSound;

CREATE TABLE artista (
    art_id INT PRIMARY KEY AUTO_INCREMENT,
    art_nombre CHAR(50),
    art_genero CHAR(30),
    art_pais CHAR(40)
);

insert into artista values (101, "Miles Davis Quintet", "Jazz", "Estados Unidos");
insert into artista values (102, "Django Reinhardt", "Jazz", "Bélgica");
insert into artista values (103, "Bily Joel", "Rock", "Estados Unidos");
insert into artista values (104, "Bill Winthers", "Soul", "Bélgica");
insert into artista values (105, "Puerto Candelaria", "Cumbia", "Colombia");
insert into artista values (106, "Estados Alterados", "Synthpop", "Colombia");

CREATE TABLE audio (
    audio_id INT PRIMARY KEY,
    audio_nombre CHAR(50)
);

insert into audio values (1, "Solar");
insert into audio values (2, "Minor Swing");
insert into audio values (3, "Vienna");
insert into audio values (4, "Aint No Sunshine");
insert into audio values (5, "Amor y Deudas");

insert into audio values (6, "Saberes con sabor");
insert into audio values (7, "Reencontrando el ser interior");
insert into audio values (8, "El mundo según Matheus");
insert into audio values (9, "Economía para no economistas");
insert into audio values (10, "Estableciendo relaciones duraderas");
insert into audio values (11, "Los grandes villanos del cine");
insert into audio values (12, "Los grandes héroes de la historia");
insert into audio values (13, "Lugares del mundo para visitar");

CREATE TABLE cancion (
    can_id INT PRIMARY KEY,
    audio_id INT,
    can_genero CHAR(50),
    can_year CHAR(50),
    art_id INT,
    FOREIGN KEY (audio_id)
        REFERENCES audio (audio_id),
    FOREIGN KEY (art_id)
        REFERENCES artista (art_id)
);

insert into cancion values (1, 1, "Jazz", "1954", 101);
insert into cancion values (2, 2, "Gypsy Jazz", "1960", 102);
insert into cancion values (3, 3, "Rock", "1977", 103);
insert into cancion values (4, 4, "R&B/Soul", "1971", 104 );
insert into cancion values (5, 5, "Cumbia", "2021", 105);

CREATE TABLE podcast (
    pod_id INT PRIMARY KEY,
    audio_id INT,
    pod_episodios INT,
    pod_temporadas INT,
    FOREIGN KEY (audio_id)
        REFERENCES audio (audio_id)
);

insert into podcast values (1,6,15,1);
insert into podcast values (2,7,30,3);
insert into podcast values (3,8,80,5);
insert into podcast values (4,9,160,8);
insert into podcast values (5,10,5,1);
insert into podcast values (6,11,25,4);
insert into podcast values (7,12,279,12);
insert into podcast values (8,13,79,6);

CREATE TABLE usuario (
    usuario_alias CHAR(50) PRIMARY KEY,
    usuario_nombre CHAR(50),
    usuario_apellido CHAR(50),
    usuario_email CHAR(50),
    usuario_celular CHAR(50),
    usuario_clave CHAR(50),
    usuario_fecha_nacimiento CHAR(50)
);

insert into usuario values ("pperez", "Pedro", "Perez", "","","","" );
insert into usuario values ("mlopez", "Maria", "Lopez", "","","","" );
insert into usuario values ("adiaz", "Ana", "Diaz", "","","","" );
insert into usuario values ("dreamer", "Luis", "Rojas", "","","","" );
insert into usuario values ("cruz.andres", "Andres", "Cruz", "","","","" );
insert into usuario values ("ruizelmejor", "Nelson", "Ruiz", "","","","" );
insert into usuario values ("claudita10", "Claudia", "Mendez", "","","","" );
insert into usuario values ("jorgeingeniero", "Jorge", "Rodriguez", "","","","" );

CREATE TABLE reproduccion (
    rep_id INT PRIMARY KEY,
    audio_id INT,
    usuario_alias CHAR(50),
    rep_fecha CHAR(50),
    FOREIGN KEY (audio_id)
        REFERENCES audio (audio_id),
    FOREIGN KEY (usuario_alias)
        REFERENCES usuario (usuario_alias)
);

insert into reproduccion values (1, 1, "pperez","2017-10-25 20:00:00");
insert into reproduccion values (2, 2, "pperez","2019-03-15 18:30:00");
insert into reproduccion values (3, 7, "pperez","2019-05-20 20:30:00");

insert into reproduccion values (4, 2, "mlopez","2018-05-20 20:30:00");
insert into reproduccion values (5, 7, "mlopez","2020-01-20 20:30:00");

insert into reproduccion values (6, 5, "adiaz","2019-05-20 20:30:00");
insert into reproduccion values (7, 13, "adiaz","2018-06-22 21:30:00");
insert into reproduccion values (8, 5, "adiaz","2020-03-17 15:30:20");

insert into reproduccion values (9, 4, "dreamer","2020-03-17 15:30:20");
insert into reproduccion values (10, 1, "dreamer","2020-04-10 18:30:20");

insert into reproduccion values (11, 1, "cruz.andres","2020-02-17 20:30:20");
insert into reproduccion values (12, 4, "cruz.andres","2020-02-20 16:30:20");
insert into reproduccion values (13, 13, "cruz.andres","2020-03-27 18:30:20");

insert into reproduccion values (14, 4, "ruizelmejor","2020-03-20 21:30:20");

insert into reproduccion values (15, 7, "claudita10","2020-02-17 20:30:20");
insert into reproduccion values (16, 12, "claudita10","2020-02-17 20:30:20");
insert into reproduccion values (17, 8, "claudita10","2020-02-17 20:30:20");




