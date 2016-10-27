-- phpMyAdmin SQL Dump
-- version 2.6.3-pl1
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Jun 19, 2007 at 12:26 AM
-- Server version: 4.1.14
-- PHP Version: 5.0.4
-- 
-- Database: `inventory`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `dataentry_accessories`
-- 

DROP TABLE IF EXISTS dataentry_accessories;
CREATE TABLE dataentry_accessories (
  Bond_Name varchar(15) NOT NULL default '',
  Bond_Date varchar(15) default NULL,
  Into_Bond_Date varchar(15) NOT NULL default '',
  LC_No varchar(15) NOT NULL default '',
  LC_Date varchar(15) default NULL,
  BE_No varchar(15) NOT NULL default '',
  BE_Date varchar(15) default NULL,
  Accessories_Name varchar(15) NOT NULL default '',
  Accessories_Description varchar(50) default NULL,
  Import_Quantity double NOT NULL default '0',
  Import_Value double NOT NULL default '0',
  Adjusted_Quantity double NOT NULL default '0',
  Adjusted_Value double NOT NULL default '0',
  Balanced_Quantity double NOT NULL default '0',
  Balanced_Value double NOT NULL default '0',
  Unit_Price double NOT NULL default '0',
  HS_Code varchar(10) NOT NULL default '',
  Page_No int(11) NOT NULL default '0',
  Volume varchar(10) NOT NULL default '0',
  `Day` int(11) NOT NULL default '0',
  UP_No int(11) default NULL,
  UP_Date varchar(15) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `dataentry_accessories`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `dataentry_chemical`
-- 

DROP TABLE IF EXISTS dataentry_chemical;
CREATE TABLE dataentry_chemical (
  Bond_Name varchar(15) NOT NULL default '',
  Bond_Date varchar(15) default NULL,
  Into_Bond_Date varchar(15) NOT NULL default '',
  LC_No varchar(15) NOT NULL default '',
  LC_Date varchar(15) default NULL,
  BE_No varchar(15) NOT NULL default '',
  BE_Date varchar(15) default NULL,
  Chemical_Name varchar(15) NOT NULL default '',
  Chemical_Description varchar(50) default NULL,
  Import_Quantity double NOT NULL default '0',
  Import_Value double NOT NULL default '0',
  Adjusted_Quantity double NOT NULL default '0',
  Adjusted_Value double NOT NULL default '0',
  Balanced_Quantity double NOT NULL default '0',
  Balanced_Value double NOT NULL default '0',
  Unit_Price double NOT NULL default '0',
  HS_Code varchar(10) NOT NULL default '',
  Page_No int(11) NOT NULL default '0',
  Volume varchar(10) NOT NULL default '0',
  `Day` int(11) NOT NULL default '0',
  UP_No int(11) default NULL,
  UP_Date varchar(15) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `dataentry_chemical`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `dataentry_dyes`
-- 

DROP TABLE IF EXISTS dataentry_dyes;
CREATE TABLE dataentry_dyes (
  Bond_Name varchar(15) NOT NULL default '',
  Bond_Date varchar(15) default NULL,
  Into_Bond_Date varchar(15) NOT NULL default '',
  LC_No varchar(15) NOT NULL default '',
  LC_Date varchar(15) default NULL,
  BE_No varchar(15) NOT NULL default '',
  BE_Date varchar(15) default NULL,
  Dyes_Name varchar(15) NOT NULL default '',
  Dyes_Description varchar(50) default NULL,
  Import_Quantity double NOT NULL default '0',
  Import_Value double NOT NULL default '0',
  Adjusted_Quantity double NOT NULL default '0',
  Adjusted_Value double NOT NULL default '0',
  Balanced_Quantity double NOT NULL default '0',
  Balanced_Value double NOT NULL default '0',
  Unit_Price double NOT NULL default '0',
  HS_Code varchar(10) NOT NULL default '',
  Page_No int(11) NOT NULL default '0',
  Volume varchar(10) NOT NULL default '0',
  `Day` int(11) NOT NULL default '0',
  UP_No varchar(15) default NULL,
  UP_Date varchar(15) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `dataentry_dyes`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `dataentry_fabrics`
-- 

DROP TABLE IF EXISTS dataentry_fabrics;
CREATE TABLE dataentry_fabrics (
  Bond_Name varchar(15) NOT NULL default '',
  Bond_Date varchar(15) default NULL,
  Into_Bond_Date varchar(15) NOT NULL default '',
  LC_No varchar(15) NOT NULL default '',
  LC_Date varchar(15) default NULL,
  BE_No varchar(15) NOT NULL default '',
  BE_Date varchar(15) default NULL,
  Fabrics_Name varchar(15) NOT NULL default '',
  Fabrics_Description varchar(50) default NULL,
  Import_Quantity double NOT NULL default '0',
  Import_Value double NOT NULL default '0',
  Adjusted_Quantity double NOT NULL default '0',
  Adjusted_Value double NOT NULL default '0',
  Balanced_Quantity double NOT NULL default '0',
  Balanced_Value double NOT NULL default '0',
  Unit_Price double NOT NULL default '0',
  HS_Code varchar(10) NOT NULL default '',
  Page_No int(11) NOT NULL default '0',
  Volume varchar(10) NOT NULL default '0',
  `Day` int(11) NOT NULL default '0',
  UP_No int(11) default NULL,
  UP_Date varchar(15) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `dataentry_fabrics`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `dataentry_yarn`
-- 

DROP TABLE IF EXISTS dataentry_yarn;
CREATE TABLE dataentry_yarn (
  Bond_Name varchar(15) NOT NULL default '',
  Bond_Date varchar(15) default NULL,
  Into_Bond_Date varchar(15) NOT NULL default '',
  LC_No varchar(15) NOT NULL default '',
  LC_Date varchar(15) default NULL,
  BE_No varchar(15) NOT NULL default '',
  BE_Date varchar(15) default NULL,
  Yarn_Name varchar(15) NOT NULL default '',
  Yarn_Description varchar(50) default NULL,
  Import_Quantity double NOT NULL default '0',
  Import_Value double NOT NULL default '0',
  Adjusted_Quantity double NOT NULL default '0',
  Adjusted_Value double NOT NULL default '0',
  Balanced_Quantity double NOT NULL default '0',
  Balanced_Value double NOT NULL default '0',
  Unit_Price double NOT NULL default '0',
  HS_Code varchar(10) NOT NULL default '',
  Page_No int(11) NOT NULL default '0',
  Volume varchar(10) NOT NULL default '0',
  `Day` int(11) NOT NULL default '0',
  UP_No int(11) default NULL,
  UP_Date varchar(15) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `dataentry_yarn`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `up_no_accessories`
-- 

DROP TABLE IF EXISTS up_no_accessories;
CREATE TABLE up_no_accessories (
  UP_No int(11) NOT NULL default '0',
  UP_Date varchar(15) NOT NULL default '',
  LC_No int(11) NOT NULL default '0',
  LC_Date varchar(15) NOT NULL default '',
  LC_Value double NOT NULL default '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `up_no_accessories`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `up_no_chemical`
-- 

DROP TABLE IF EXISTS up_no_chemical;
CREATE TABLE up_no_chemical (
  UP_No int(11) NOT NULL default '0',
  UP_Date varchar(15) NOT NULL default '',
  LC_No int(11) NOT NULL default '0',
  LC_Date varchar(15) NOT NULL default '',
  LC_Value double NOT NULL default '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `up_no_chemical`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `up_no_dyes`
-- 

DROP TABLE IF EXISTS up_no_dyes;
CREATE TABLE up_no_dyes (
  UP_No int(11) NOT NULL default '0',
  UP_Date varchar(15) NOT NULL default '',
  LC_No int(11) NOT NULL default '0',
  LC_Date varchar(15) NOT NULL default '',
  LC_Value double NOT NULL default '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `up_no_dyes`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `up_no_fabrics`
-- 

DROP TABLE IF EXISTS up_no_fabrics;
CREATE TABLE up_no_fabrics (
  UP_No int(11) NOT NULL default '0',
  UP_Date varchar(15) NOT NULL default '',
  LC_No int(11) NOT NULL default '0',
  LC_Date varchar(15) NOT NULL default '',
  LC_Value double NOT NULL default '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `up_no_fabrics`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `up_no_yarn`
-- 

DROP TABLE IF EXISTS up_no_yarn;
CREATE TABLE up_no_yarn (
  UP_No int(11) NOT NULL default '0',
  UP_Date varchar(15) NOT NULL default '',
  LC_No int(11) NOT NULL default '0',
  LC_Date varchar(15) NOT NULL default '',
  LC_Value double NOT NULL default '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `up_no_yarn`
-- 

