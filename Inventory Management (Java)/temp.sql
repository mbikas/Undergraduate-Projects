-- phpMyAdmin SQL Dump
-- version 2.6.3-pl1
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Jun 17, 2007 at 10:02 PM
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

INSERT INTO dataentry_accessories (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Accessories_Name, Accessories_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-1', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');
INSERT INTO dataentry_accessories (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Accessories_Name, Accessories_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-5', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');

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

INSERT INTO dataentry_chemical (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Chemical_Name, Chemical_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-1', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');
INSERT INTO dataentry_chemical (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Chemical_Name, Chemical_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-5', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');

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

INSERT INTO dataentry_dyes (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Dyes_Name, Dyes_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-1', '02/03/2007', '03/03/2007', '1', '03/03/2007', '12', '03/03/2007', 'dyes1', 'dyes', 100, 120, 0, 0, 0, 0, 1.2, '12', 1, 'v-1', 732617, 'null', 'null');

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

INSERT INTO dataentry_fabrics (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Fabrics_Name, Fabrics_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-1', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');
INSERT INTO dataentry_fabrics (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Fabrics_Name, Fabrics_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-5', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');

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

INSERT INTO dataentry_yarn (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Yarn_Name, Yarn_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-1', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');
INSERT INTO dataentry_yarn (Bond_Name, Bond_Date, Into_Bond_Date, LC_No, LC_Date, BE_No, BE_Date, Yarn_Name, Yarn_Description, Import_Quantity, Import_Value, Adjusted_Quantity, Adjusted_Value, Balanced_Quantity, Balanced_Value, Unit_Price, HS_Code, Page_No, Volume, Day, UP_No, UP_Date) VALUES ('z-5', '01/03/2007', '01/03/2007', '100', '01/03/2007', '10', '01/03/2007', 'fabricks', 'cotton', 100, 1222, 0, 0, 100, 1222, 12.22, '1202', 1, 'v-2', 732615, 0, 'null');

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

INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 100);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 1, '01/02/2007', 10);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 2, '01/02/2007', 20);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 3, '01/02/2007', 30);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 4, '01/02/2007', 40);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 5, '01/02/2007', 50);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_accessories (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 122, '02/05/2007', 2000);

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

INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 100);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 1, '01/02/2007', 10);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 2, '01/02/2007', 20);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 3, '01/02/2007', 30);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 4, '01/02/2007', 40);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 5, '01/02/2007', 50);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_chemical (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 122, '02/05/2007', 2000);

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

INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 100);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 1, '01/02/2007', 10);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 2, '01/02/2007', 20);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 3, '01/02/2007', 30);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 4, '01/02/2007', 40);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 5, '01/02/2007', 50);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_dyes (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 122, '02/05/2007', 2000);

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

INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 100);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 1, '01/02/2007', 10);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 2, '01/02/2007', 20);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 3, '01/02/2007', 30);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 4, '01/02/2007', 40);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 5, '01/02/2007', 50);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_fabrics (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 122, '02/05/2007', 2000);

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

INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 100);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 1, '01/02/2007', 10);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 2, '01/02/2007', 20);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 3, '01/02/2007', 30);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 4, '01/02/2007', 40);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (0, 'null', 5, '01/02/2007', 50);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 1, '01/02/2007', 10);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 2, '01/02/2007', 20);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 3, '01/02/2007', 30);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 4, '01/02/2007', 40);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 5, '01/02/2007', 50);
INSERT INTO up_no_yarn (UP_No, UP_Date, LC_No, LC_Date, LC_Value) VALUES (2, '02/03/2007', 122, '02/05/2007', 2000);
