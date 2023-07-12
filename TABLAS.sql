CREATE DATABASE IF NOT EXISTS xsurvive DEFAULT CHARACTER SET latin1 ;
use xsurvive;
CREATE TABLE IF NOT EXISTS `armas` (
`id_Arma` int(10) unsigned NOT NULL AUTO_INCREMENT,
`nombre` varchar(100) NOT NULL,
`daño` int(10) unsigned NOT NULL DEFAULT 0,
PRIMARY KEY(`id_Arma`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `avatares` (
`id_Avatar` int(10) unsigned NOT NULL AUTO_INCREMENT,
`raza` varchar(100) NOT NULL,
`vida` int(10) NOT NULL DEFAULT 0,
`daño` int(10) NOT NULL DEFAULT 0,
PRIMARY KEY(`id_Avatar`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `poderes` (
`id_Poder` int(10) unsigned NOT NULL AUTO_INCREMENT,
`nombre` varchar(100) NOT NULL,
`daño` int(10) unsigned NOT NULL DEFAULT 0,
`defensa` int(10) unsigned NOT NULL DEFAULT 0,
PRIMARY KEY(`id_Poder`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `partidas` (
`id_Partida` int(10) unsigned NOT NULL AUTO_INCREMENT,
`usuario` varchar(100) NOT NULL,
`puntos` int(10) unsigned NOT NULL DEFAULT 0,
PRIMARY KEY(`id_Partida`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `personajes` (
`id_Personaje` int(10) unsigned NOT NULL AUTO_INCREMENT,
`nombre` varchar(100) NOT NULL,
`raza` varchar(100) NOT NULL,
`arma` varchar(100) NOT NULL,
`poder` varchar(100) NOT NULL,
`vida` int(10) unsigned NOT NULL DEFAULT 0,
`daño` int(10) unsigned NOT NULL DEFAULT 0,
`defensa` int(10) unsigned NOT NULL DEFAULT 0,
PRIMARY KEY(`id_Personaje`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `preguntas` (
`id_Pregunta` int(10) unsigned NOT NULL AUTO_INCREMENT,
`pregunta` varchar(500) NOT NULL,
`opcion1` varchar(500) NOT NULL,
`desencadenante1` varchar(500) NOT NULL,
`efecto1` int(10) NOT NULL,
`siguiente1` int(10) NOT NULL,
`opcion2` varchar(500) NOT NULL,
`desencadenante2` varchar(500) NOT NULL,
`efecto2` int(10) NOT NULL,
`siguiente2` int(10) NOT NULL,
PRIMARY KEY(`id_Pregunta`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

INSERT INTO `preguntas` (`pregunta`, `opcion1`, `desencadenante1`, `efecto1`, `siguiente1`, `opcion2`, `desencadenante2`, `efecto2`, `siguiente2`) VALUES
('Estas en tu casa y alguien llama a la puerta. ¿Abres la puerta o no?', 'Si', 'Abres la puerta, pero por el camino te tropiezas y pierdes 200pt', '-200', '2', 'No', 
'No abres la puerta y decides ir a cenar obtienes 100pt', '100', '3' ),
('Al abrir la puerta te encuentras una cesta llena de pociones magicas ¿Que pocion te tomas?', 'Roja', 'Te tomas la pocion roja y obtienes 200pt', '200', '4', 'Verde',
'Te tomas la pocion verde y te quita 100pt', '-100', '4'),
('Despues de cenar alguien llama a la puerta gritando de forma agresiva "Donde estas pequeña sabandija" ¿Decides hablar con él o luchar contra él?', 'Hablar',
 'Sales con la intencion de hablar con el y al estar relajado te asesta un golpe que te resta 200pt', '-200', '5', 'Luchar', 'Luchas y vences al enemigo, pero este no venia 
 solo y sus compañeros te dejan sin vida', '-10000', '0'),
 ('Te vas a dormir, y te despiertas en la mazmorra de un dragon ¿Que haces?', 'Atacas',
 'Atacas al dragon con toda tu fuerza y te quita 1000pt', '-1000', '0', 'Sigilo', 'Pasas sigilosamente y encuentras un anillo magico maligno, te resta 500pt', '-500', '0'),
('Tienes que huir ¿Pero donde?', 'Cueva',
 'Entras a la cueva con la mala suerte de encontrarte un oso, este te resta 300pt', '-300', '0', 'Campo', 'Corres por el campo y encuentras un arbol sanador, recuperas
 200pt', '200', '0');

INSERT INTO `armas` (`nombre`, `daño`) VALUES 
('Hacha Leviatán', '30'),
('Arco de renegado', '15'),
('Espada Kusanagi', '20'),
('Pluma de Damocles', '50');

INSERT INTO `avatares` (`raza`, `vida`, `daño`) VALUES 
('Humano', '200', '100'),
('Ogro', '400', '150'),
('Vampiro', '250', '180'),
('Hombre lobo', '300', '250');

INSERT INTO `partidas` (`usuario`, `puntos`) VALUES 
('Admin', '0'),
('Nacho', '10');

INSERT INTO `poderes` (`nombre`, `daño`, `defensa`) VALUES 
('Proyección astral', '50', '50'),
('Telepatía', '50', '30'),
('Terapia de energía', '0', '100'),
('Piroquinesis', '100', '0'),
('Invisibilidad', '20', '80');

INSERT INTO `personajes` (`nombre`, `raza`, `arma`, `poder`, `vida`, `daño`, `defensa`) 
VALUES ('Ragnar', 'Ogro', 'Hacha Leviatán', 'Invisibilidad', '400', '200', '80');



