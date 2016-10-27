-- phpMyAdmin SQL Dump
-- version 2.6.3-pl1
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Sep 16, 2007 at 01:25 AM
-- Server version: 4.1.14
-- PHP Version: 5.0.4
-- 
-- Database: `ccna`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `batch`
-- 

CREATE TABLE `batch` (
  `name` varchar(20) NOT NULL default ''
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `batch`
-- 

INSERT INTO `batch` (`name`) VALUES ('Batch 02');
INSERT INTO `batch` (`name`) VALUES ('Batch 01');
INSERT INTO `batch` (`name`) VALUES ('Batch 03');
INSERT INTO `batch` (`name`) VALUES ('Batch 04');
INSERT INTO `batch` (`name`) VALUES ('Batch 05');
INSERT INTO `batch` (`name`) VALUES ('Batch 15');

-- --------------------------------------------------------

-- 
-- Table structure for table `id`
-- 

CREATE TABLE `id` (
  `id` varchar(15) NOT NULL default '10000'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `id`
-- 

INSERT INTO `id` (`id`) VALUES ('1');

-- --------------------------------------------------------

-- 
-- Table structure for table `id_temp`
-- 

CREATE TABLE `id_temp` (
  `id` varchar(25) NOT NULL default '',
  `password` varchar(25) NOT NULL default '',
  `status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `id_temp`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `message`
-- 

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL default '0',
  `sender_id` varchar(15) NOT NULL default '',
  `subject` varchar(50) NOT NULL default '',
  `content` varchar(200) NOT NULL default '',
  `semester` varchar(15) NOT NULL default '',
  `batch` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`message_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `message`
-- 

INSERT INTO `message` (`message_id`, `sender_id`, `subject`, `content`, `semester`, `batch`) VALUES (1, 'bikas', 'Class Opening', 'Your class will be open at 12th november', 'CCNA-1', 'Batch 01');
INSERT INTO `message` (`message_id`, `sender_id`, `subject`, `content`, `semester`, `batch`) VALUES (2, 'bikas', 'Final Exam Date', 'Your final exam will be held on 05/09/2007', 'CCNA-1', 'Batch 01');

-- --------------------------------------------------------

-- 
-- Table structure for table `std_grade`
-- 

CREATE TABLE `std_grade` (
  `id` varchar(15) NOT NULL default '',
  `semester` varchar(20) NOT NULL default '',
  `batch` varchar(20) default NULL,
  `startDate` varchar(20) default NULL,
  `endDate` varchar(20) default NULL,
  `instructor` varchar(25) default NULL,
  `secondaryInstructor` varchar(30) default NULL,
  `module1` double default NULL,
  `module2` double default NULL,
  `module3` double default NULL,
  `module4` double default NULL,
  `module5` double default NULL,
  `module6` double default NULL,
  `module7` double default NULL,
  `module8` double default NULL,
  `module9` double default NULL,
  `module10` double default NULL,
  `module11` double default NULL,
  `skill` double NOT NULL default '0',
  `lab` double NOT NULL default '0',
  `practice` double default NULL,
  `final` double NOT NULL default '0',
  `weighted` double default NULL,
  `grade` varchar(10) default NULL,
  `attendence` double default NULL,
  `certificate` int(11) default '0',
  `letter` int(11) default '0',
  `status` varchar(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `std_grade`
-- 

INSERT INTO `std_grade` (`id`, `semester`, `batch`, `startDate`, `endDate`, `instructor`, `secondaryInstructor`, `module1`, `module2`, `module3`, `module4`, `module5`, `module6`, `module7`, `module8`, `module9`, `module10`, `module11`, `skill`, `lab`, `practice`, `final`, `weighted`, `grade`, `attendence`, `certificate`, `letter`, `status`) VALUES ('student', 'CCNA-1', 'Batch 01', '12/5/2007', '15/9/2007', 'bikas', 'naser', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 'Enrolled');

-- --------------------------------------------------------

-- 
-- Table structure for table `students`
-- 

CREATE TABLE `students` (
  `id` varchar(15) NOT NULL default '',
  `name` varchar(20) NOT NULL default '',
  `fullName` varchar(30) NOT NULL default '',
  `password` varchar(20) NOT NULL default '',
  `stdType` varchar(20) default NULL,
  `stdCat` varchar(20) default NULL,
  `presentAdd` varchar(50) default NULL,
  `permanentAdd` varchar(50) default NULL,
  `sex` varchar(15) default NULL,
  `birth` varchar(30) default NULL,
  `mail` varchar(30) default NULL,
  `contact` varchar(20) NOT NULL default '',
  `entryDate` varchar(30) default NULL,
  `batch` varchar(20) NOT NULL default '',
  `semester` varchar(15) NOT NULL default '',
  `status` varchar(15) NOT NULL default '',
  `teacher` varchar(30) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `students`
-- 

INSERT INTO `students` (`id`, `name`, `fullName`, `password`, `stdType`, `stdCat`, `presentAdd`, `permanentAdd`, `sex`, `birth`, `mail`, `contact`, `entryDate`, `batch`, `semester`, `status`, `teacher`) VALUES ('student', 'Bikas', 'ABU NASER', 'student', 'Program Student', 'SpecialÂ ', 'Sylhet', 'Dhaka', 'Male', '12/4/1984', 'bikasbd@yahoo.com', '01911614279', '16/7/2007', 'Batch 01', 'CCNA-1', 'Enrolled', 'naser');

-- --------------------------------------------------------

-- 
-- Table structure for table `teacher_batch`
-- 

CREATE TABLE `teacher_batch` (
  `id` varchar(15) NOT NULL default '',
  `fullName` varchar(20) default NULL,
  `secondaryInstructor` varchar(30) default NULL,
  `batch` varchar(20) default NULL,
  `semester` varchar(20) default NULL,
  `startDate` varchar(20) default NULL,
  `endDate` varchar(20) NOT NULL default '',
  `finalExam` varchar(15) default NULL,
  `roomNo` varchar(10) default NULL,
  `finished` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `teacher_batch`
-- 

INSERT INTO `teacher_batch` (`id`, `fullName`, `secondaryInstructor`, `batch`, `semester`, `startDate`, `endDate`, `finalExam`, `roomNo`, `finished`) VALUES ('bikas', 'Abu Naser', 'naser', 'Batch 01', 'CCNA-1', '12/5/2007', '15/9/2007', '', '', 0);

-- --------------------------------------------------------

-- 
-- Table structure for table `teachers`
-- 

CREATE TABLE `teachers` (
  `id` varchar(15) NOT NULL default '',
  `name` varchar(20) NOT NULL default '',
  `fullName` varchar(30) default NULL,
  `password` varchar(20) NOT NULL default '',
  `degree` varchar(20) default NULL,
  `presentAdd` varchar(50) default NULL,
  `permanentAdd` varchar(50) default NULL,
  `sex` varchar(10) NOT NULL default '',
  `mail` varchar(30) NOT NULL default '',
  `contact` varchar(20) NOT NULL default '',
  `status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `teachers`
-- 

INSERT INTO `teachers` (`id`, `name`, `fullName`, `password`, `degree`, `presentAdd`, `permanentAdd`, `sex`, `mail`, `contact`, `status`) VALUES ('naser', 'Abu Naser', 'Abu Naser', 'naser', 'PHD', 'Dhaka', 'Dkaha', 'Male', 'bikasbd@yahoo.com', '01911614279', 1);
INSERT INTO `teachers` (`id`, `name`, `fullName`, `password`, `degree`, `presentAdd`, `permanentAdd`, `sex`, `mail`, `contact`, `status`) VALUES ('bikas', 'Bikas', 'Abu Naser', 'bikas', 'PHD', 'Dhaka', 'Dhaka', 'Male', 'bikasbd@yahoo.com', '01911614279', 0);
INSERT INTO `teachers` (`id`, `name`, `fullName`, `password`, `degree`, `presentAdd`, `permanentAdd`, `sex`, `mail`, `contact`, `status`) VALUES ('saurov', 'Saurov', 'Abu Asrar', 'saurov', 'HSC', 'Dhaka', 'Dhaka', 'Male', 'bikasbd@yahoo.com', '01911614279', 2);
INSERT INTO `teachers` (`id`, `name`, `fullName`, `password`, `degree`, `presentAdd`, `permanentAdd`, `sex`, `mail`, `contact`, `status`) VALUES ('admin', 'Bikas', 'Abu Naser', 'admin', 'PHD', 'Sylhet', 'Sylhet', 'Male', 'bikabd@yahoo.com', '01911614279', 0);

-- --------------------------------------------------------

-- 
-- Table structure for table `user`
-- 

CREATE TABLE `user` (
  `id` varchar(15) NOT NULL default '',
  `password` varchar(20) NOT NULL default '',
  `status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `user`
-- 

INSERT INTO `user` (`id`, `password`, `status`) VALUES ('admin', 'admin', 0);
INSERT INTO `user` (`id`, `password`, `status`) VALUES ('student', 'student', 3);
INSERT INTO `user` (`id`, `password`, `status`) VALUES ('naser', 'naser', 1);
INSERT INTO `user` (`id`, `password`, `status`) VALUES ('saurov', 'saurov', 2);
INSERT INTO `user` (`id`, `password`, `status`) VALUES ('bikas', 'bikas', 0);
