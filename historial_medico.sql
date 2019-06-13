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
-- Estructura de tabla para la tabla `citas`
--

DROP TABLE IF EXISTS `citas`;
CREATE TABLE IF NOT EXISTS `citas` (
  `idcitas` int(11) NOT NULL AUTO_INCREMENT,
  `idtratamiento` int(11) NOT NULL,
  `fecha_cita` date NOT NULL,
  `hora` time NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idcitas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dignostico`
--

DROP TABLE IF EXISTS `dignostico`;
CREATE TABLE IF NOT EXISTS `dignostico` (
  `iddignostico` int(11) NOT NULL AUTO_INCREMENT,
  `idsintomas` int(11) NOT NULL,
  `dignostico` varchar(5000) NOT NULL,
  `tratamiento` varchar(500) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`iddignostico`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `dignostico`
--

INSERT INTO `dignostico` (`iddignostico`, `idsintomas`, `dignostico`, `tratamiento`, `fecha`) VALUES
(6, 5, 'kjhkxhczxhc\r\nxzclkhx\r\ncxzhócxz\r\ncxzhhochxz\r\ncixzocjxz', 'ioxzhckhxz\r\ncxzjcb´kxzjhc\r\nxzcjbxzkjbcxz\r\ncjxzbckjxz\r\ncxzjcbxz\r\n', '2019-06-03'),
(7, 4, 'uihkhpikh', 'hvjlhvjl', NULL),
(8, 12, 'jhggjghjl\ngdfkjgd\ngdfklgnldkf\ngndfkgnd\ngndfkgndf\ngndfklgndf\ngndfgkjhfljs', 'kdfnjlsdjfksd\nfsdfkdjsfsdp\nfsdkjfsdlkjf', '2019-06-04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dts_pacientes`
--

DROP TABLE IF EXISTS `dts_pacientes`;
CREATE TABLE IF NOT EXISTS `dts_pacientes` (
  `iddts_pacientes` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `edad` int(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `peso` decimal(65,0) NOT NULL,
  `talla` decimal(65,0) NOT NULL,
  `temperatura` decimal(65,0) NOT NULL,
  `fc` int(100) NOT NULL,
  `fr` int(65) NOT NULL,
  `ta` int(100) NOT NULL,
  PRIMARY KEY (`iddts_pacientes`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `dts_pacientes`
--

INSERT INTO `dts_pacientes` (`iddts_pacientes`, `nombre`, `domicilio`, `genero`, `edad`, `telefono`, `peso`, `talla`, `temperatura`, `fc`, `fr`, `ta`) VALUES
(11, 'Jesús LópezGómez', '8a Calle Sur Oriente No.5, Barrio San Sebastian, Las Margaritas,Chiapas.', 'masculino', 25, '9631240000', '90', '34', '70', 5, 8, 7),
(12, 'Maria Guadalupe Lopez', 'vdcjhvcjlhsvdcjhvdjshvcj', 'Femenino', 15, '9631240000', '78', '48', '41', 4, 5, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_medico`
--

DROP TABLE IF EXISTS `historial_medico`;
CREATE TABLE IF NOT EXISTS `historial_medico` (
  `idhistorial_medico` int(11) NOT NULL AUTO_INCREMENT,
  `iddignostico` int(11) NOT NULL,
  PRIMARY KEY (`idhistorial_medico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sintomas`
--

DROP TABLE IF EXISTS `sintomas`;
CREATE TABLE IF NOT EXISTS `sintomas` (
  `idsintomas` int(11) NOT NULL AUTO_INCREMENT,
  `idpaciente` int(11) NOT NULL,
  `sintomas` varchar(45) NOT NULL,
  PRIMARY KEY (`idsintomas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sintomas`
--

INSERT INTO `sintomas` (`idsintomas`, `idpaciente`, `sintomas`) VALUES
(1, 5, 'kjhkjhkjh'),
(2, 5, 'tos'),
(3, 8, 'tos');

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

INSERT INTO `usuario` (`idUsuario`, `usuario`, `password`, `jerarquia`, `nombre_completo`, `direccion`) VALUES
(1, 'admin', 'admin', 'doctor', 'Victor Manuel Garcia Dominguez', '4a. avenida poniente norte No.85, barrio Cruz Grande,Comitan de Domguez, Chiapas.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
