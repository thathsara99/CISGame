-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Nov 14, 2021 at 05:16 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iqpro`
--

-- --------------------------------------------------------

--
-- Table structure for table `correctq`
--

DROP TABLE IF EXISTS `correctq`;
CREATE TABLE IF NOT EXISTS `correctq` (
  `Pid` int(40) NOT NULL AUTO_INCREMENT,
  `question` varchar(150) NOT NULL,
  `correct` varchar(150) NOT NULL,
  PRIMARY KEY (`Pid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `questionans`
--

DROP TABLE IF EXISTS `questionans`;
CREATE TABLE IF NOT EXISTS `questionans` (
  `userName` varchar(150) NOT NULL,
  `q1` varchar(150) NOT NULL,
  `q2` varchar(150) NOT NULL,
  `q3` varchar(150) NOT NULL,
  `q4` varchar(150) NOT NULL,
  `q5` varchar(150) NOT NULL,
  `q6` varchar(150) NOT NULL,
  `q7` varchar(150) NOT NULL,
  `q8` varchar(150) NOT NULL,
  `q9` varchar(150) NOT NULL,
  `q10` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `totalmarks`
--

DROP TABLE IF EXISTS `totalmarks`;
CREATE TABLE IF NOT EXISTS `totalmarks` (
  `Tid` int(50) NOT NULL AUTO_INCREMENT,
  `userName` varchar(150) NOT NULL,
  `marks` varchar(150) NOT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `truefalse`
--

DROP TABLE IF EXISTS `truefalse`;
CREATE TABLE IF NOT EXISTS `truefalse` (
  `Pid` int(50) NOT NULL AUTO_INCREMENT,
  `question` varchar(150) NOT NULL,
  `truefalse` varchar(150) NOT NULL,
  PRIMARY KEY (`Pid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `truefalse`
--

INSERT INTO `truefalse` (`Pid`, `question`, `truefalse`) VALUES
(1, '1', 'True'),
(2, '2', 'False'),
(3, '3', 'False'),
(4, '4', 'False'),
(5, '5', 'False'),
(6, '6', 'False'),
(7, '7', 'False'),
(8, '8', 'Skipped');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `userName`, `email`, `password`) VALUES
(2, 'thathsara@gmail.com', 'thathsara', '1234'),
(3, 'hi', 'hi@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `win`
--

DROP TABLE IF EXISTS `win`;
CREATE TABLE IF NOT EXISTS `win` (
  `Pid` int(50) NOT NULL AUTO_INCREMENT,
  `question` varchar(150) NOT NULL,
  `win` varchar(150) NOT NULL,
  PRIMARY KEY (`Pid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
