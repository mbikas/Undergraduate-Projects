<?php

  include ("include/header.php");
   $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = $tdegree =$tcontact = $tpadd = $tadd=null; 
    $p=1;
    
   
    $link = connect_db();
    if($_SESSION['temp_id']!=null)$id = $_SESSION['temp_id'];
    
    
       
    
?>

    
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                                <?php
                                if($_SESSION['temp_id']!=null)
                                {
                                ?>
                                      <li><a href="index.php">Home</a></li>
                                      <li id = "current"><a href="addUser.php">Add Users</a></li>
                                    
                                <?php  
                                }
                                
                                else
                                {
                                ?>
                                  <li><a href="index.php">Home</a></li>
                                  <li id="current"><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li ><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="admin.php">Administration</a></li>
                                <?php
                                }
                                ?>
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        
                                <h1>Links</h1>
                                <div class="left-box">
                                        <ul class="sidemenu">
                                         <?php
                                        if($_SESSION['temp_id']!=null)
                                        {
                                                $status = $_SESSION['temp_status'];
                                                if($status==3){
                                                         $name="Student Entry";
                                                         $load = "addStudent.php";
                                                }
                                                if($status==1){
                                                        $name="Teacher Entry";
                                                        $load = "addTeacher.php";
                                                }
                                                if($status==2){
                                                        $name="Employee Entry";
                                                        $load = "addEmployee.php";
                                                }
                                                if($_SESSION['temp_status']==null)
                                                  echo "<li><a href='index.php'>Home</a></li>";
                                               else
                                               {
                                                        echo "<li><a href=$load>$name</a></li>";
                                                        echo "<li><a href='file_format.php?person=2'>Uploaded File Format</a></li>";
                                                }
                                        }
                                        else
                                        {
                                        ?>
                                                <li><a href="addEmployee.php">Employee Entry</a></li>
                                                <li><a href="file_format.php?person=2">Uploaded File Format</a></li>
                                        <?php
                                        }
                                        ?>
                                        
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                
                                <h1>Search</h1>
                                <form method="POST" action="addEmployee.php" class="searchform">
                                <input type="text" name="search" class="search" >
                                <input type="submit" value="Search" class="button"> 
                                <input type="hidden" name="search_form" value="true">
                                </form>  
                                                        
                                <?php
                                        if($x==1 || $_SESSION['temp_user'])
                                        {
                                ?>
                                                <h1>Sign Out</h1>
                                                      <div class="left-box">
                                                      <ul class="sidemenu">
                                                       <li><a href="logout.php?logout_id=1">Signout</a></li>
                                                       </li>
                                                      </ul>
                                                      </div>
                                
                                <?php
                                        }
                                ?>           
                                
                        </div>
                                
        <div id="main">
        <a name="TemplateInfo"></a>
        <?php
        if($search_form)
        {
                   include ("include/search.php");
                 
        }
        else
        {
        
                if($x==1 || $_SESSION['temp_status']!=null)
                {
                   
                       
                                if($employee)
                                {
                                 $employee = false;
                                 $id = $ids;
                                 $tn = $tName;
                                 $tfn = $tFName;
                                 $tcontact = $contact;
                                 $tmail = $mail;
                                 $tpass = $tPass;
                                 $tcpass = $tCPass;
                                 $tdegree = $tDegree;
                                 $tcontact = $contact;
                                 $tpadd = $permanentAdd;
                                 $tadd= $presentAdd;
                                 $tsex=$sex;
                                 $flag=1; 

                                if($ids==null){
                                            echo "Enter User ID<br>";
                                            $flag=0;
                                }
                                /////////checking if ID alredy exists///////////
                                $sql = "select * from user where id='$ids'";
                                $result = mysql_query($sql, $link);
                                $found=0;
                                while($row = mysql_fetch_array($result))
                                {
                                        $found=1;
                                        break;
                                }
                                $sql = "select * from id_temp where id='$ids'";
                                $result = mysql_query($sql, $link);
                                while($row = mysql_fetch_array($result))
                                {
                                        $found=1;
                                        break;
                                }
                                if($found==1){
                                            echo "ID alredy exists<br>";
                                            $flag=0;
                                }                        
                                
                                ////////////////////////////////////////////////                                 
                                if($tName==null){
                                            echo "Enter Name<br>";
                                            $flag=0;
                                }                            
                                if($tPass==null){
                                            echo "Enter Password<br>";
                                            $flag=0;
                                } 
                                if(strlen($tPass)<6){
                                    echo "Password must be greater than or equal six characters long<br>";
                                    $flag=0;
                                } 
                                if($tCPass==null){
                                            echo "Retype Password<br>";
                                            $flag=0;
                                }                    
                                if($mail==null){
                                            echo "Enter Mail Address<br>";
                                            $flag=0;
                                }                            
                                if($contact==null){
                                            echo "Enter Contact Number<br>";
                                            $flag=0;
                                }
                                if($flag==1)
                                {
                                     $employee=false;
                                     if($tPass!=$tCPass){echo "Password Mismatch<br>";}
                                     else
                                        {
                                                   
                                                  
                                                    $link = connect_db();                              
                                                    
                                                    
                                                    
                                                    $sql = "delete from id";
                                                    $result = mysql_query($sql, $link);
                                                    
                                                    
                                                    $sql = "insert into user values('$id','$tpass',2)";
                                                    $result = mysql_query($sql, $link);
                                                    
                                                    
                                                    $result = mysql_query($sql, $link);
                                                    $sql = "insert into teachers values('$id','$tn','$tfn','$tpass','$tdegree','$tadd','$tpadd','$tsex','$tmail','$tcontact',2)";
                                                    $result = mysql_query($sql, $link);
                                                    
                                                    $temp = (int)$id;
                                                    $temp = $temp+1;
                                                    $p = (string)$temp;
                                                     $sql = "insert into id values('$p')";
                                                    $result = mysql_query($sql, $link);
                                                    $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = $tdegree =$tcontact = $tpadd = $tadd=null; 
                            
                                                  $p=$flag=0;
                                                  $employee = false;
                                                  $tn = $tName=null;   
                                                  $tfn = $tFName=null;
                                                  $tcontact = $contact=null;
                                                  $tmail = $mail=null;
                                                  $tpass = $tPass=null;
                                                  $tcpass = $tCPass=null;
                                                  $tdegree = $tDegree=null;
                                                  $tcontact = $contact=null;
                                                  $tpadd = $permanentAdd=null;
                                                  $tadd= $presentAdd=null;
                                                if($_SESSION['temp_id']!=null)
                                                {
                                                        $sql = "delete from id_temp where id = '$_SESSION[temp_id]'";
                                                        $result = mysql_query($sql, $link);
                                                        $_SESSION['temp_status']=null;
                                                        echo "<b>Your Profile have been Created.</b><br>";
                                                        echo "<b>To get full access, You must have to login with your new ID and Password</b><br>";
                                                } 
                                                else 
                                                echo "<h2>Your information have been successfully saved.</h2><br>";
                                                  
                                                
                                                
                                        
                                        }                    
                                }                
                            
                            }
                            if($upload)
                                {
                                        
                                  
                                        $archive_dir = "./files";    
                                        $gotfile=upload_file();
                                        if($gotfile==1){
                                          $filename = basename($userfile_name);
                                          $fp = fopen("$archive_dir/$filename","r");
                                          if(!fp) die ("can't open");
                                          $data = fread($fp,200000000);
                                          $msg=str_replace(chr(13).chr(10).chr(39).chr(38),"<br>",addslashes($data));
                                          fclose($fp);
                                        }
                                        
                                        //echo "$msg";
                                        $len = strlen($msg);
                                        $x=null;
                                        $line=1;
                                        for($i=0;$i<$len;$i++)
                                        {
                                                $x = $x. $msg[$i];
                                                if($msg[$i]=="\n")
                                                {
                                                        if($line==1)$tn = $x;
                                                        if($line==2)$tfn = $x;
                                                        if($line==3){
                                                                $tpass = $x;
                                                                $tcpass = $x;
                                                        }                                                        
                                                        if($line==4)$tdegree = $x;
                                                        if($line==5)$tadd = $x;
                                                        if($line==6)$tpadd = $x;
                                                        if($line==7)$tmail = $x;
                                                        if($line==8)$tcontact = $x;
                                                        //echo "line = $x<br>";
                                                        $x=null;
                                                        $line++;                                        
                                                }                               
                                        }
                                        if($line==8)$tcontact=$x;
                                       /*
                                        echo "<br>Name = $tn";
                                        echo "<br>Full Name = $tfn";
                                        echo "<br>Pass = $tpass";
                                        echo "<br>Retype = $tcpass";
                                        echo "<br>Degree = $tdegree";
                                        echo "<br>PRE ADD = $tadd";
                                        echo "<br>PER ADD = $tpadd";
                                        echo "<br>Mail = $tmail";
                                        echo "<br>Mobile = $tcontact";
                                        */  
                                        
                                
                                }
                            if($p==1){
                        ?>
                                        
                                        <!---
                                        <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        Employee Entry</h3>
                                        -->
                                        <table width="100%"  cellspacing="0" cellpadding="0" align="center" border="0" style="background: url(images/button-bg.jpg) repeat-x;font: bold 20px Arial, Sans-serif;color:#0a246a;">
                                        <tr>
                                                <td width="33%">
                                                &nbsp;
                                                </td>
                                                <td  align="center" height="80%" bgcolor="#c6eb56"> 
                                                Employee Entry
                                                </td>
                                                <td width="33%">
                                                &nbsp;
                                                </td>
                                                
                                        </tr>
                                </table>
                                    <br>
                                     <fieldset>
                                     <form action="addemployee.php">
                                     
                                     <table width="75%" align="center">
                                     
                                        <tr>
                                                <td><b>ID:</b></td>
                                                <td><input type="text" name="ids" size="20" value="<?php echo "$id" ?>"></td>
                                        </tr>
                                        
                                        <tr>
                                                <td><b>Name:</b></td>
                                                <td><input type="text" name="tName" size="20" value="<?php echo "$tn" ?>"></td>
                                        </tr>
                                        <tr>
                                                <td><b>Full Name:</b></td>
                                                <td><input type="text" name="tFName" size="20" value="<?php echo "$tfn" ?>"></td>

                                        </tr>

                                        <tr>
                                                <td><b>Password:</b></td>
                                                <td><input type="password" name="tPass" size="20" value="<?php echo "$tpass" ?>"></td>
                                        </tr>
                                        <tr>
                                                <td><b>Confirm Password:</b></td>
                                                <td><input type="password" name="tCPass" size="20" value="<?php echo "$tcpass" ?>"></td>
                                        </tr>
                                        
                                        <tr>
                                                <td><b>Degree:</b></td>
                                                <td><input type="text" name="tDegree" size="20" value="<?php echo "$tdegree" ?>"></td>

                                        </tr>

                                        <tr>
                                                <td><b>Present Address:</b></td>
                                                <td><textarea name="presentAdd" rows="2" cols="16"><?php echo "$tadd" ?></textarea></td>
                                        </tr>
                                        <tr>
                                                <td><b>Permanent Address:</b></td>
                                                <td><textarea name="permanentAdd" rows="2" cols="16"><?php echo "$tpadd" ?></textarea></td>
                                        </tr>
                                        <tr>
                                                <td><b>Sex:</b></td>
                                                <td><select type="combo" name="sex">
                                                <option name="sex">Male</option>
                                                <option name="sex">Female
                                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </option>
                                                </td>
                                        </tr>

                                        <tr>
                                                <td><b>E-Mail:</b></td>
                                                <td><input type="text" name="mail" size="20" value="<?php echo "$tmail" ?>"></td>
                                        </tr>
                                        <tr>
                                                <td><b>Contact No:</b></td>
                                                <td><input type="text" name="contact" size="20" value="<?php echo "$tcontact" ?>"></td>
                                        </tr>

                                        <tr>

                                                <td></td>

                                                <td>
                                                <input type="hidden" name="employee" value="true">
                                                <input type="submit" class="button" name = "save" value="Save">

                                                </form>
                                                </td>


                                        </tr>
                                        <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        </tr>
                                        
                                        
                                        <form method="POST" enctype="multipart/form-data" action="addEmployee.php">
                                        <tr>
                                                <td><b>Upload File(Optional)</b></td>
                                                                        
                                                <td>
                                                <input type="file" name="userfile" size="25">
                                                </td>
                                        </tr>
                                        
                                        <tr>
                                                <td>&nbsp;</td>                                      
                                                <td align="left">
                                                  <input type="submit" name="load" value="Upload" class="button">
                                                  <input type="hidden" name="upload" value="true">
                                                </form>
                                                </td>
                                         </tr>



                                    </table>
                                    </fieldset>
                                    <br><br><br><br><br><br><br>
                            
                        <?php
                           }
                        
                
                }
        }
        ?>           </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
               function upload_file() {
                           global $userfile, $userfile_name, $userfile_size, 
                                  $archive_dir, $WINDIR;
                        
                           if(isset($WINDIR)) $userfile = str_replace("\\\\","\\", $userfile);
                           
                           $filename = basename($userfile_name);
                           //echo "file name $filename";
                           
                           
                           

                           if(!@copy($userfile, "$archive_dir/$filename")){
                                echo "<font color='red'>Select a file</font>";
                                return 0;
                           }
                           
                           if($userfile_size <= 0) 
                           {
                                echo "<font color='red'>The file is empty</font>";
                           }
                           else { $fileposted=1;}
                            
                           return $fileposted;
                            
                           }
               ?>
