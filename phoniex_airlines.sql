-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2022 at 08:27 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phoniex_airlines`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `email`, `password`) VALUES
(1, 'phoniexadmin', 'phoniexadmin@gmail.com', '@phoniexadmin#access');

-- --------------------------------------------------------

--
-- Table structure for table `blockedclient`
--

CREATE TABLE `blockedclient` (
  `id` int(11) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `blockedstaff`
--

CREATE TABLE `blockedstaff` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `grade` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `nic`, `username`, `email`, `password`) VALUES
(1, '12345678000v', 'user1updated', 'user1@gmail.com', '@phoniex#user'),
(3, '11111111111V', 'user2', 'user2@mail.com', '@phoniex#user2'),
(5, '22222222222V', 'user3', 'user3@mail.com', '@phoniex#user3'),
(6, '33333333333V', 'user4', 'user4@mail.com', '@phoniex#user4'),
(7, '44444444444V', 'user5', 'user5@mail.com', '@phoniex#user5'),
(9, '55555555555V', 'user6', 'user6@mail.com', '@phoniex#user6');

-- --------------------------------------------------------

--
-- Table structure for table `flightarrival`
--

CREATE TABLE `flightarrival` (
  `fid` int(11) NOT NULL,
  `arrival` datetime NOT NULL,
  `flight` varchar(6) NOT NULL,
  `departed_from` varchar(100) NOT NULL,
  `airline` varchar(20) NOT NULL,
  `aircraft` varchar(20) NOT NULL,
  `status` varchar(100) NOT NULL,
  `price` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flightarrival`
--

INSERT INTO `flightarrival` (`fid`, `arrival`, `flight`, `departed_from`, `airline`, `aircraft`, `status`, `price`) VALUES
(1, '2022-12-02 04:10:00', 'AK719', 'Kula Lampur', 'AirAsia', 'A2ON(9M-AGQ)', 'Landed', 58000.00);

-- --------------------------------------------------------

--
-- Table structure for table `flightdeparture`
--

CREATE TABLE `flightdeparture` (
  `fid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `flight` varchar(6) NOT NULL,
  `where_to` varchar(200) NOT NULL,
  `airline` varchar(20) NOT NULL,
  `aircraft` varchar(20) NOT NULL,
  `status` varchar(100) NOT NULL,
  `price` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flightdeparture`
--

INSERT INTO `flightdeparture` (`fid`, `time`, `flight`, `where_to`, `airline`, `aircraft`, `status`, `price`) VALUES
(16, '2022-12-30 01:20:00', 'asdad', 'adw', 'feq', 'we23', 'arrived', 100000.00);

-- --------------------------------------------------------

--
-- Table structure for table `onewaybookings`
--

CREATE TABLE `onewaybookings` (
  `ticketid` varchar(10) NOT NULL,
  `tickettype` varchar(10) NOT NULL,
  `usermail` varchar(100) NOT NULL,
  `userfullname` varchar(200) NOT NULL,
  `passportid` varchar(10) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `ticketclass` varchar(10) NOT NULL,
  `depdate` varchar(20) NOT NULL,
  `adult` int(10) NOT NULL,
  `child` int(10) DEFAULT NULL,
  `price` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `onewaybookings`
--

INSERT INTO `onewaybookings` (`ticketid`, `tickettype`, `usermail`, `userfullname`, `passportid`, `destination`, `ticketclass`, `depdate`, `adult`, `child`, `price`) VALUES
('mjfg9rFcZC', 'oneway', 'phoniexadmin@gmail.com', 'phoniexadmin', 'p000000000', 'adw', 'first', '2022-12-30', 1, 0, 100000.00);

-- --------------------------------------------------------

--
-- Table structure for table `roundtripbookings`
--

CREATE TABLE `roundtripbookings` (
  `ticketid` varchar(10) NOT NULL,
  `tickettype` varchar(10) NOT NULL,
  `usermail` varchar(100) NOT NULL,
  `userfullname` varchar(200) NOT NULL,
  `passportid` varchar(20) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `ticketclass` varchar(20) NOT NULL,
  `depdate` date NOT NULL,
  `rdate` date NOT NULL,
  `adult` int(10) NOT NULL,
  `child` int(10) DEFAULT NULL,
  `price` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roundtripbookings`
--

INSERT INTO `roundtripbookings` (`ticketid`, `tickettype`, `usermail`, `userfullname`, `passportid`, `destination`, `ticketclass`, `depdate`, `rdate`, `adult`, `child`, `price`) VALUES
('XM6C47feNl', 'round', 'phoniexadmin@gmail.com', 'temp', 'ptemp', 'adw', 'eco', '2022-12-30', '2022-12-31', 1, 1, 100000.00);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(100) NOT NULL,
  `grade` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `username`, `email`, `password`, `grade`) VALUES
(2, 'staffg2', 'staffg2@gmail.com', '@phoniex#staffg2', 'g2'),
(14, 'staffn1', 'staffn1@mail.com', '@phoniex#staffn1', 'g1'),
(15, 'staffn2', 'staffn2@mail.com', '@phoniex#staffn2', 'g2'),
(16, 'staffn4', 'staffn4@mail.com', '@phoniex#staffn4', 'g2'),
(17, 'staffn3', 'staffn3@mail.com', '@phoniex#staffn3', 'g1');

-- --------------------------------------------------------

--
-- Table structure for table `staffrequest`
--

CREATE TABLE `staffrequest` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `blockedclient`
--
ALTER TABLE `blockedclient`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nic` (`nic`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `blockedstaff`
--
ALTER TABLE `blockedstaff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `nic` (`nic`);

--
-- Indexes for table `flightarrival`
--
ALTER TABLE `flightarrival`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `flightdeparture`
--
ALTER TABLE `flightdeparture`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `onewaybookings`
--
ALTER TABLE `onewaybookings`
  ADD PRIMARY KEY (`ticketid`);

--
-- Indexes for table `roundtripbookings`
--
ALTER TABLE `roundtripbookings`
  ADD PRIMARY KEY (`ticketid`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `staffrequest`
--
ALTER TABLE `staffrequest`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `blockedclient`
--
ALTER TABLE `blockedclient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `blockedstaff`
--
ALTER TABLE `blockedstaff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `flightarrival`
--
ALTER TABLE `flightarrival`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `flightdeparture`
--
ALTER TABLE `flightdeparture`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `staffrequest`
--
ALTER TABLE `staffrequest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
