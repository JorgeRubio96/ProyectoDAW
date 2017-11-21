-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.26-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para proyecto
CREATE DATABASE IF NOT EXISTS `proyecto` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `proyecto`;

-- Volcando estructura para tabla proyecto.class
CREATE TABLE IF NOT EXISTS `class` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `course_id` bigint(20) unsigned NOT NULL,
  `teacher_id` bigint(20) unsigned NOT NULL,
  `class_no` int(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `course_id` (`course_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla proyecto.class: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` (`id`, `course_id`, `teacher_id`, `class_no`) VALUES
	(1, 1, 4, 1),
	(2, 6, 1, 1),
	(4, 6, 2, 2),
	(5, 2, 3, 1);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;

-- Volcando estructura para tabla proyecto.classroom
CREATE TABLE IF NOT EXISTS `classroom` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `building` varchar(40) NOT NULL,
  `room` int(11) unsigned NOT NULL,
  `capacity` int(11) unsigned NOT NULL,
  `admin` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla proyecto.classroom: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` (`id`, `code`, `building`, `room`, `capacity`, `admin`) VALUES
	(1, 'XLR32', 'A3', 301, 15, 'CS'),
	(2, 'XLR42', 'A4', 404, 30, 'CS'),
	(3, 'SEC32', 'A2', 202, 25, 'CS'),
	(4, 'TEC33', 'A1', 207, 34, 'Escolar'),
	(5, 'USP22', 'A3', 105, 40, 'CS');
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;

-- Volcando estructura para tabla proyecto.course
CREATE TABLE IF NOT EXISTS `course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` char(6) NOT NULL,
  `title` varchar(100) NOT NULL,
  `dependency_id` bigint(20) unsigned DEFAULT NULL,
  `honors` tinyint(1) NOT NULL,
  `lab_hrs` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `dependency_id` (`dependency_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`dependency_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla proyecto.course: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `code`, `title`, `dependency_id`, `honors`, `lab_hrs`) VALUES
	(1, 'MARS30', 'Modelos y Analitica de redes Sociales', NULL, 0, 0),
	(2, 'DAW67', 'Desarrollo de Aplicaciones Web', NULL, 1, 0),
	(3, 'CAL54', 'Calidad y Pruebas de Software', NULL, 1, 3),
	(4, 'PRO01', 'Introduccion a la Programacion', NULL, 0, 0),
	(5, 'EST13', 'Estructura de datos', 4, 0, 0),
	(6, 'ALG09', 'Disenio y analisis de Algoritmos', 5, 1, 1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Volcando estructura para tabla proyecto.schedule
CREATE TABLE IF NOT EXISTS `schedule` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `class_id` bigint(20) unsigned NOT NULL,
  `classroom_id` bigint(20) unsigned NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `day` char(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `class_id` (`class_id`),
  KEY `classroom_id` (`classroom_id`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`),
  CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla proyecto.schedule: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` (`id`, `class_id`, `classroom_id`, `start_time`, `end_time`, `day`) VALUES
	(1, 1, 5, '07:00:00', '08:30:00', 'Lu'),
	(2, 1, 5, '07:00:00', '08:30:00', 'Ju'),
	(3, 2, 4, '08:30:00', '10:00:00', 'Ma');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;

-- Volcando estructura para tabla proyecto.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nomina` char(9) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `course_no` int(10) unsigned NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `nomina` (`nomina`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla proyecto.teacher: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `nomina`, `first_name`, `last_name`, `phone`, `course_no`, `email`) VALUES
	(1, 'L0098', 'Luis', 'Perez', '8132876459', 2, 'l.peres@itesm.mx'),
	(2, 'L0088', 'Romina', 'De La Cruz', '8146233498', 1, 'RominaDLC@itesm.mx'),
	(3, 'L1099', 'Jaime', 'Corrales', '8190965432', 1, 'j.Corrales75@itesm.mx'),
	(4, 'L0012', 'Consuelo', 'Garcia', '8125353649', 3, 'garcia.C@itesm.mx');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Volcando estructura para tabla proyecto.user1
CREATE TABLE IF NOT EXISTS `user1` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pass` char(71) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla proyecto.user1: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `user1` DISABLE KEYS */;
INSERT INTO `user1` (`id`, `first_name`, `last_name`, `username`, `pass`) VALUES
	(1, 'juan', 'perez', 'jPerez', '123456');
/*!40000 ALTER TABLE `user1` ENABLE KEYS */;

-- Volcando estructura para disparador proyecto.check_overlap
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `check_overlap` BEFORE INSERT ON `schedule` FOR EACH ROW BEGIN
        DECLARE overlap BOOLEAN;
        SELECT EXISTS (
            SELECT * FROM schedule
                WHERE classroom_id = NEW.classroom_id
                AND day = NEW.day
                AND (
                    start_time <= NEW.start_time
                    AND end_time >= NEW.start_time
                ) OR (
                    start_time <= NEW.end_time
                    AND end_time >= NEW.end_time
                )
        ) INTO overlap;
        IF overlap THEN
            SET NEW.start_time = NULL; /* Stops query by violating not null constraint */
        END IF;
    END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
