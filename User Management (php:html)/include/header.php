<?php
        include("include/config.php");
        session_start();
        
        $x = 0;
        if($_SESSION['user_id']!=null)$x=1;
        
        
        if($logout_id==1)
        {
                $x=0;
                $logout_id=0;
        }
        
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<link rel="stylesheet" href="images/ccna.css" type="text/css" />

<title>CCNA USERS</title>

</head>

<body>
<!-- wrap starts here -->
<div id="wrap">

                <!--header -->
                <div id="header">

                        <h1 id="picture-left" ><a href="http://cisco.netacad.net"><img src="images/cisco.JPG"></a></h1>
                        <h1 id="logo-text" >CCNA USER MANAGEMENT</h1>
                        <h1 id="logo-text1" >ShahJalal University of Science &amp; Technology</h1>
                        
                        <h1 id="picture-right" ><a href="http://www.sust.edu">
                        <img src="images/sust.JPG"></a></h1>
                </div>
