how databases ;

use historial_medico;

show  tables ;


-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 06-06-2019 a las 09:15:40
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `historial_medico`
--

-- --------------------------------------------------------


--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(30) NOT NULL,
  `jerarquia` varchar(45) NOT NULL,
  `nombre_completo` varchar(65) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` ( `usuario`, `password`, `jerarquia`, `nombre_completo`, `direccion`) VALUES
('admin', 'admin', 'doctor', 'Victor Manuel Garcia Dominguez', '4a. avenida poniente norte No.85, barrio Cruz Grande,Comitan de Domguez, Chiapas.');



--
-- Estructura de tabla para la tabla `const_dts_pacientes`
--


DROP TABLE IF EXISTS `const_dts_pacientes`;
CREATE TABLE IF NOT EXISTS `const_dts_pacientes` (
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `ap_paterno` varchar(30) NOT NULL,
  `ap_materno` varchar(30) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `fecha_nacimiento` date default NULL,
  `telefono` varchar(15) NULL,
  `ocupacion` varchar(35) NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




--
-- Estructura de tabla para la tabla `const_dts_recetas`
--

DROP TABLE IF EXISTS `const_dts_recetas`;
CREATE TABLE IF NOT EXISTS `const_dts_recetas`(
  `id_receta` int(11) NOT NULL AUTO_INCREMENT,
  `edad` int(5) NOT NULL,
  `peso` decimal(5,3) NULL,
  `talla` decimal(5,3) NULL,
  `temp` varchar(20)  NULL,
  `fc` varchar(20)  NULL,
  `rf` varchar(20)  NULL,
  `ta` varchar(20)  NULL,
  `rx` longtext  NULL,
  `fecha` date default NULL,
  `fecha_proxima_cita` date default NULL,
  PRIMARY KEY (`id_receta`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



--
-- Estructura de tabla para la tabla `const_dts_historial`
--
DROP TABLE IF EXISTS `const_dts_historial`;
CREATE TABLE IF NOT EXISTS `const_dts_historial` (
  `id_historial` int(11) NOT NULL AUTO_INCREMENT,
  `parecimiento_actual` longtext  NULL,
  `dxs` longtext  NULL,
  `plan_manejo` longtext  NULL,
   PRIMARY KEY (`id_historial`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Estructura de tabla para la tabla `const_dts_historial_sintomas`
--
DROP TABLE IF EXISTS `const_dts_historial_sintomas`;
CREATE TABLE IF NOT EXISTS `const_dts_historial_sintomas` (
  `id_historial_sintomas` int(11) NOT NULL AUTO_INCREMENT,
  `id_historial` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `antecedente_importante` longtext  NULL,
  PRIMARY KEY (`id_historial_sintomas`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Estructura de tabla para la tabla `const_dts_reporte_ultrasonico`
--
DROP TABLE IF EXISTS `const_dts_reporte_ultrasonico`;
CREATE TABLE IF NOT EXISTS `const_dts_reporte_ultrasonico` (
  `id_reporte_ultrasonico` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` longtext  NULL,
  PRIMARY KEY (`id_reporte_ultrasonico`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




--
-- Estructura de tabla para la tabla `const_dts_reporte_ultrasonico`
--
DROP TABLE IF EXISTS `const_dts_historial_mts`;
CREATE TABLE IF NOT EXISTS `const_dts_historial_mts` (
  `id_historial_mts` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int (11),
  `id_receta` int (11),
  `id_historial` int (11),
  `id_reporte_ultrasonico` int (11),
  `fecha` date NULL,
  PRIMARY KEY (`id_historial_mts`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Estructura de tabla para la tabla `sintomas`
--

DROP TABLE IF EXISTS `const_dts_sintomas`;
CREATE TABLE IF NOT EXISTS `const_dts_sintomas` (
  `id_sintoma` int(11) NOT NULL AUTO_INCREMENT,
  `id_historial_mts` int(11) NOT NULL,
  `sintomas` varchar(250)  NULL,
  PRIMARY KEY (`id_sintoma`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- Insert de test
INSERT INTO historial_medico.const_dts_pacientes (nombre, ap_paterno, ap_materno, domicilio, genero, fecha_nacimiento, telefono, ocupacion) VALUES ('Roberto', 'Antonio', 'Aguilar', 'Conocido', 'Masculino', '1993-06-16', '3634634', 'albañil');
INSERT INTO historial_medico.const_dts_pacientes (nombre, ap_paterno, ap_materno, domicilio, genero, fecha_nacimiento, telefono, ocupacion) VALUES ('Luis', 'camor', 'denor', 'conocido', 'Masculino', '1990-06-06', '345346', '');
INSERT INTO historial_medico.const_dts_pacientes (nombre, ap_paterno, ap_materno, domicilio, genero, fecha_nacimiento, telefono, ocupacion) VALUES ('Juan', 'almar', 'toscano', 'conocido', 'Masculino', '1992-06-12', '435643626', '');


commit ;



