<?php
          include("include/config.php");
          session_start();
          $first=0;
          
                if($login_form)
                {

                        $link = connect_db();
                        $sql = "select * from user where id='$form_username' and password='$form_password'";
                        $result = mysql_query($sql, $link);
                        $row = mysql_fetch_array($result);
                        session_start();
                        $_SESSION['user_id'] = $row['id'];
                        $_SESSION['user_password'] = $row['password'];
                        $_SESSION['user_status'] = $row['status'];
                        
                        
                        if($_SESSION['user_id']!=null)
                        {
                                $first=1;
                                if($_SESSION['user_status']==3)
                                $sql = "select name from students where id='$form_username'";
                                else
                                $sql = "select name from teachers where id='$form_username'";
                                
                                $result = mysql_query($sql, $link);
                                $row1 = mysql_fetch_array($result);  
                                $_SESSION['user_name'] = $row1['name'];
                                
                                
                                
                        }
                        else
                        {
                                $first=1;
                                $sql = "select * from id_temp where (id='$form_username' AND password = '$form_password')";
                                $result = mysql_query($sql, $link);
                                $row2 = mysql_fetch_array($result);  
                                session_start();
                                $_SESSION['temp_id'] = $row2['id'];
                                $_SESSION['temp_password'] = $row2['password'];
                                $_SESSION['temp_status'] = $row2['status'];
                                $_SESSION['temp_user'] = true;
                               
                        }
                        
                        
                        
                        
                        
                }
       
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

<title>CCNA USER</title>

</head>

<body>
<!-- wrap starts here -->
<div id="wrap">

                <!--header -->
                <div id="header">
                        
                        <h1 id="picture-left" ><a href="http://cisco.netacad.net"><img src="images/cisco.JPG"></a></h1>
                        <h1 id="logo-text" >CCNA USER MANAGEMENT</h1>
                        <h1 id="logo-text1" >ShahJalal University of Science & Technology</h1>
                        
                        <h1 id="picture-right" ><a href="http://www.sust.edu">
                        <img src="images/sust.JPG"></a></h1>
                </div>
