-- phpMyAdmin SQL Dump
-- version 3.5.3
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 27 2012 г., 18:18
-- Версия сервера: 5.1.65-community-log
-- Версия PHP: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `checkers`
--

-- --------------------------------------------------------

--
-- Структура таблицы `COUNTRIES`
--

CREATE TABLE IF NOT EXISTS `COUNTRIES` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(50) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Дамп данных таблицы `COUNTRIES`
--

INSERT INTO `COUNTRIES` (`id`, `name`) VALUES
(1, 'Россия'),
(2, 'Украина'),
(3, 'Белоруссия'),
(4, 'США'),
(5, 'Франция'),
(6, 'Германия'),
(7, 'Испания'),
(8, 'Канада'),
(9, 'Венгрия'),
(10, 'Соединенное Королевство'),
(21, 'Южная Корея'),
(22, 'Япония'),
(23, 'Китай'),
(24, 'Казахстан'),
(25, 'Финляндия'),
(26, 'Норвегия'),
(27, 'Австрия'),
(28, 'Италия'),
(29, 'Египет'),
(30, 'Болгария');

-- --------------------------------------------------------

--
-- Структура таблицы `PLAYER`
--

CREATE TABLE IF NOT EXISTS `PLAYER` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `password` char(80) NOT NULL,
  `won_games_count` int(11) NOT NULL,
  `lost_games_count` int(11) NOT NULL,
  `actual_name` char(20) NOT NULL,
  `email` char(20) NOT NULL,
  `id_country` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `PLAYER`
--

INSERT INTO `PLAYER` (`id`, `name`, `password`, `won_games_count`, `lost_games_count`, `actual_name`, `email`, `id_country`) VALUES
(1, 'check', 'check', 0, 0, 'check_name', 'qwerty', 0),
(2, 'altaos', 'altaos', 8, 2, 'altaos_name', 'ytrewq', 0),
(3, 'totzhe', 'totzhe', 7, 3, 'totzhe_name', 'qazwsx', 0),
(4, 'something', 'something', 4, 8, 'something_name', 'xswqaz', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
