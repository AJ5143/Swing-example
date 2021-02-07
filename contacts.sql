-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2021 at 12:46 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nishtha practical`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `ContactID` int(11) NOT NULL,
  `ContactName` varchar(100) NOT NULL,
  `ContactGender` tinyint(1) NOT NULL,
  `ContactMobile` varchar(100) NOT NULL,
  `ContactEmail` varchar(100) NOT NULL,
  `ContactAddress` varchar(2000) NOT NULL,
  `ContactImage` varchar(300) NOT NULL DEFAULT '3',
  `ContactCityID` int(11) NOT NULL DEFAULT '1',
  `ContactUserID` int(11) NOT NULL,
  `Created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`ContactID`, `ContactName`, `ContactGender`, `ContactMobile`, `ContactEmail`, `ContactAddress`, `ContactImage`, `ContactCityID`, `ContactUserID`, `Created`, `Modified`) VALUES
(1, 'Jitang', 1, '1234567890', 'jitang@abc.com', 'Rajkot', '3', 1, 1, '2021-02-07 17:56:09', '2021-02-07 17:56:09'),
(2, 'Jitang', 1, '1234657890', 'jitang@abc.com', 'Rajkot', '3', 1, 1, '2021-02-07 17:58:14', '2021-02-07 17:58:14'),
(3, 'Yash', 1, '1236547890', 'yashudanand@gmail.com', 'Rajkot', '3', 1, 2, '2021-02-07 18:01:09', '2021-02-07 18:01:09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`ContactID`),
  ADD KEY `ContactCityID` (`ContactCityID`),
  ADD KEY `ContactUserID` (`ContactUserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `ContactID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
