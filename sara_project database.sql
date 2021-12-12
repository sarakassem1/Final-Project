-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 12, 2021 at 04:57 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sara_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `psychologists`
--

CREATE TABLE `psychologists` (
  `name` varchar(250) NOT NULL,
  `email` varchar(250) DEFAULT NULL,
  `available_time` varchar(250) DEFAULT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `psychologists`
--

INSERT INTO `psychologists` (`name`, `email`, `available_time`, `phone`) VALUES
('Dr. john', 'jndjb', '3:00\r\n18, dec, 2021', 71717171),
('Dr. Mohamad ', 'sdfdfdfc', '11:00\r\n23903,jul,2022', 7000992),
('Dr. Sara kassem', 'sra.ksk', '12:00\r\n22609,jan,2022', 71234567);

-- --------------------------------------------------------

--
-- Table structure for table `quotes`
--

CREATE TABLE `quotes` (
  `type` varchar(250) NOT NULL,
  `qoute` varchar(650) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quotes`
--

INSERT INTO `quotes` (`type`, `qoute`) VALUES
('depression', 'You are allowed to feel messed up inside out, it doesn’t mean you are weak, you’re just human.\r\nEvery thing you want is on the other side of depression and fear.\r\nAnd if today all you did was hold yourself together, i\'m proud of you.'),
('hope', 'Sometimes you need to be alone. Not to be lonely but to enjoy your free time being you and yourself.\r\nEach morning you are born again. What we do today is what matters most.\r\nYou may have to fight a battle more than once to win it.'),
('suicide', 'Do not believe the things you tell yourself when you are sad and alone.\r\nThe bravest thing you have ever done was continuing to live when you wanted to die.Stay strong, your story is not over yet.\r\nRemember sadness is always temporary. This too shall pass.\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(250) NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `age` int(11) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `phone`, `email`, `age`, `password`) VALUES
('a', 1, 'a', 1, '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b'),
('j', 723, 'add', 1, '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b'),
('jdeed', 12312, 'sjcdcn', 12, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('kka', 123, 'akdkd', 34, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('sara.kasem', 71234432, 'sara@gamil.com', 20, 'dd7f6bfb6e0d8bcd754e97cae4975c07996f00508f8346d649c5814e19c3f9b9'),
('saraa', 18383, 'bsbshs', 72, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
('sarak', 12383, 'bsbsbs', 11, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `psychologists`
--
ALTER TABLE `psychologists`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `quotes`
--
ALTER TABLE `quotes`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
