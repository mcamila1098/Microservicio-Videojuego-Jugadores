CREATE TABLE IF NOT EXISTS
jugador(id VARCHAR2(80) NOT NULL,
    nombres VARCHAR2(80),
    apellidos VARCHAR2(80),
    email VARCHAR2(60),
    nick_usuario VARCHAR2(30),
    password VARCHAR2(40),
PRIMARY KEY(id));