<?php

  include ("include/header.php");
  
   
    $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = null;
    $tdegree =$tcontact = $tpadd = $tadd=$tentry=null;
    $tdegree =$tcontact = $tpadd = $tadd=$tbirth=null; 
    $link=connect_db();
    $p=1;
    $archive_dir = "./files";
   
    
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
                                                        echo "<li><a href='file_format.php?person=3'>Uploaded File Format</a></li>";
                                                }
                                        }
                                        else
                                        {
                                ?>
                                                
                                                <li><a href="addStudent.php">Student Entry</a></li>
                                                <li><a href="file_format.php?person=3">Uploaded File Format</a></li>
                                                
                                        <?php
                                        }
                                        ?>
                                </ul>        
                                
                                <h1>Search</h1>        
                                
                                <form method="POST" action="addStudent.php" class="searchform">
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


                if($teacher)
                {
                         $teacher = false;
                         $id = $ids;
                         $tn = $tName;   
                         $tfn = $tFName; 
                         $tmail = $mail;
                         $tpass = $tPass;
                         $tcpass = $tCPass;
                         $tcontact = $contact;
                         $tpadd = $permanentAdd;
                         $tadd= $presentAdd;
                         $tsex=$sex;
                         $tbirth=$birthDate;
                         $tentry=$entryDate;
                         $flag=1;  
                        //echo "$ids";
                        
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
                                    echo "Enter Nick Name<br>";
                                    $flag=0;
                        } 
                        if($tFName==null){
                                    echo "Enter Full Name<br>";
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
                        if(check_valid_date()==0)
                        {
                                echo "Entry Date Error<br>";
                                $flag=0;                        
                        }
                        if(check_valid_birth_date()==0)
                        {
                                echo "Birth Date Error<br>";
                                $flag=0;                        
                        }
                            
                                                
                        $std_entry=$_POST['entry_day'].'/'.$_POST['entry_month'].'/'.$_POST['entry_year'];
                        $std_birth=$_POST['birth_day'].'/'.$_POST['birth_month'].'/'.$_POST['birth_year'];
                        
                        //echo "$std_entry";
                        if($flag==1)
                        {
                             $teacher=false;
                             if($tPass!=$tCPass){echo "Password Mismatch<br>";}
                             else
                                {
                                         
                                                                                   
                                          $link = connect_db();                             
                                                                              
                                          $sql = "delete from id";
                                          $result = mysql_query($sql, $link);
                                                                             
                                          
                                          
                                          //// for refresh///////
                                          $sql = "delete from user where id='$id'";
                                          $result = mysql_query($sql, $link);
                                          $sql = "delete from students where id='$id'";
                                          $result = mysql_query($sql, $link);
                                          $sql = "delete from std_grade where id='$id'";
                                          $result = mysql_query($sql, $link);
                                          ///////////////
                                          
                                          $sql = "insert into user values('$id','$tpass',3)";
                                          $result = mysql_query($sql, $link);
                                          
                                          $std_entry=$_POST['entry_day'].'/'.$_POST['entry_month'].'/'.$_POST['entry_year'];
                                          //echo "std_entry";
                                          $temp = "Enrolled";
                                          $temp1="CCNA-1";
                                          $sql = "insert into students values('$id','$tn','$tfn','$tpass','$stdType','$stdCategory','$tadd','$tpadd','$tsex','$std_birth','$mail','$contact','$std_entry','$batch','$temp1','$temp','$teachers')";
                                          $result = mysql_query($sql, $link);
                                          $b="";
                                          $blank=null;
                                          $sql = "insert into std_grade values('$id','$temp1','$batch','$std_entry','$b','$teachers','$teacher2',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0,'$blank',0,0,0,'$temp')";
                                          $result = mysql_query($sql, $link);
                                            
                                            
                                          $temp = (int)$id;
                                          $temp = $temp+1;
                                          $p = (string)$temp;
                                          $sql = "insert into id values('$p')";
                                          $result = mysql_query($sql, $link);
                                          $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = $tdegree =$tcontact = $tpadd = $tadd=null; 
                    
                                          $p=$flag=0;
                                          $teacher = false;
                                          $tn = $tName=null;   
                                          $tfn = $tFName=null;
                                          $tcontact = $contact=null;
                                          $tmail = $mail=null;
                                          $tpass = $tPass=null;
                                          $tcpass = $tCPass=null;
                                          $tdegree = $tDegree=null;
                                          $tpadd = $permanentAdd=null;
                                          $tadd= $presentAdd=null;
                                        if($_SESSION['temp_id']!=null)
                                        {
                                                $sql = "delete from id_temp where id = '$_SESSION[temp_id]'";
                                                $result = mysql_query($sql, $link);
                                                $_SESSION['temp_status']=null;
                                                echo "<b>Your Profile have been Created.</b><br>";
                                                echo "<b>To get full access, You have to login with your new ID and Password</b><br>";
                                                
                                        }
                                        else
                                        echo "<h2>Your information have been successfully saved.</h2><br>";
                                          
                                          
                                          
                                
                                }                    
                        }                
                    
                }
                /////////////upload file////////////////////////////////////////////////
                //$archive_dir = "./files";  
                if($upload)
                {
                        
                  
                           
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
                                                $tcpass=$x;
                                        }
                                        if($line==4)$tadd = $x;
                                        if($line==5)$tpadd = $x;
                                        if($line==6)$tmail = $x;
                                        if($line==7)$tcontact = $x;
                                        //echo "line = $x<br>";
                                        $x=null;
                                        $line++;                                        
                                }                               
                        }
                        if($line==7)$tcontact=$x;
                        /*
                          echo "<br>Name = $tn";
                          echo "<br>Full Name = $tfn";
                          echo "<br>Pass = $tpass";
                          echo "<br>Name = $tcpass";
                          echo "<br>PRE ADD = $tadd";
                          echo "<br>PER ADD = $tpadd";
                          echo "<br>Mail = $tmail";
                          echo "<br>Mobile = $tcontact";
                        */
                        $id=$ids;
                
                }
                /////////////////////////////////////////////////////////////
                if($p==1){
                ?>
                                <!--
                                <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                Student Entry</h3>
                                -->
                                <table width="100%"  cellspacing="0" cellpadding="0" align="center" border="0" style="background: url(images/button-bg.jpg) repeat-x;font: bold 20px Arial, Sans-serif;color:#0a246a;">
                                        <tr>
                                                <td width="33%">
                                                &nbsp;
                                                </td>
                                                <td  align="center" height="80%" bgcolor="#c6eb56"> 
                                                Student Entry
                                                </td>
                                                <td width="33%">
                                                &nbsp;
                                                </td>
                                                
                                        </tr>
                                </table>
                            <br>
                            
                            
                            
                             
                             <form action="addStudent.php" method="POST">
                             
                             <table width="100%" align="center">
                             
                                <tr>
                                        <td><b>ID:</b></td>
                                        <td><input type="text" name="ids" size="25" value="<?php echo "$id" ?>"></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Nick Name:</b></td>
                                        <td><input type="text" name="tName" size="25" value="<?php echo "$tn" ?>"></td>
                                </tr>
                                <tr>
                                        <td><b>Full Name:</b></td>
                                        <td><input type="text" name="tFName" size="25" value="<?php echo "$tfn" ?>"></td>

                                </tr>

                                <tr>
                                        <td><b>Password:</b></td>
                                        <td><input type="password" name="tPass" size="25" value="<?php echo "$tpass" ?>"></td>
                                </tr>
                                <tr>
                                        <td><b>Confirm Password:</b></td>
                                        <td><input type="password" name="tCPass" size="25" value="<?php echo "$tcpass" ?>"></td>
                                </tr>
                                
                                <tr>
                                <td><b>Student Type:</b></td>
                                <td><select type="combo" name="stdType">
                                        <option name="std">Program Student</option>
                                        <option name="std">Graduate Student&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                </td>
                                </tr>
                                <tr>
                                        <td><b>Student Category:</b></td>
                                        <td><select type="combo" name="stdCategory">
                                                <?php
                                                $stdcat[]="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                                                           
                                                $stdcat[]="SUST";
                                                $stdcat[]="Non SUST";
                                                $stdcat[]="Special";
                                                for($i=0;$i<4;$i++){
                                                        echo "<option>$stdcat[$i]&nbsp;</option>";
                                                }
                                                ?>
                                        </td>
                                </tr>
                                
                                

                                <tr>
                                        <td><b>Present Address:</b></td>
                                        <td><textarea name="presentAdd" rows="2" cols="20" ><?php echo "$tadd" ?></textarea></td>
                                </tr>
                                <tr>
                                        <td><b>Permanent Address:</b></td>
                                        <td><textarea name="permanentAdd" rows="2" cols="20" ><?php echo "$tpadd" ?></textarea></td>
                                </tr>
                                <tr>
                                        <td><b>Sex:</b></td>
                                        <td><select type="combo" name="sex">
                                        <option name="sex">Male</option>
                                        <option name="sex">Female
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </option>
                                        </td>
                                </tr>
                                <tr>
                                <td><b>Date of Birth:</b></td>
                                <td>
                                <select type="combo" name="birth_day">
                                        <?php
                                                echo "<option> Day</option>";
                                                for($d=1;$d<32;$d++)
                                                      echo "<option> $d </option>";                                                       
                                        ?>
                                        </select>
                                        <select type="combo" name="birth_month">
                                        <?php
                                                echo "<option> Month</option>";
                                                for($m=1;$m<13;$m++)
                                                      echo "<option> $m </option>";                                                       
                                        ?>
                                        </select>
                                        <select type="combo" name="birth_year">
                                        <?php
                                                echo "<option> Year</option>";
                                                for($d=1960;$d<2000;$d++)
                                                      echo "<option> $d </option>";                                                       
                                        ?>
                                        </select>
                                </td>
                                </tr>
                                <tr>
                                        <td><b>E-Mail:</b></td>
                                        <td><input type="text" name="mail" size="25" value="<?php echo "$tmail" ?>"></td>
                                </tr>
                                <tr>
                                        <td><b>Contact No:</b></td>
                                        <td><input type="text" name="contact" size="25" value="<?php echo "$tcontact" ?>"></td>
                                </tr>
                                <tr>
                                <td><b>Entry Date:</b></td>
                                <td>
                                <select type="combo" name="entry_day" >
                                <?php
                                        
                                        echo "<option>Day</option>";
                                        for($d=1;$d<32;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                                <select type="combo" name="entry_month">
                                <?php
                                        echo "<option> Month</option>";
                                        for($m=1;$m<13;$m++)
                                              echo "<option> $m </option>";                                                       
                                ?>
                                </select>
                                <select type="combo" name="entry_year">
                                <?php
                                        echo "<option> Year</option>";
                                        for($d=2007;$d<2020;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                                </td>
                                </tr>
                                <tr>
                                <td><b>Batch No:</b></td>
                                <?php
                                        $i=0;
                                        $link = connect_db();
                                        $sql = "select * from batch order by name";
                                        $result = mysql_query($sql, $link);
                                        while($row = mysql_fetch_array($result))
                                        {
                                                $batches[$i]=$row['name'];
                                                $i++;                                
                                        }
                                ?>
                                <td><select type="combo" name="batch">
                                <?php
                                        for($j=0;$j<$i;$j++)
                                        {
                                                echo "<option> $batches[$j] </option>";
                                        }
                                
                                ?>
                                </td>
                                </tr>
                                
                                <tr>
                                <td><b>Semester:</b></td>
                                <td><b>CCNA-1</b></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Status:</b></td>
                                        <td><b>Enrolled</b></td>
                                </tr>
                                <tr>
                                        
                                        <?php
                                        $i=0;
                                        $link = connect_db();
                                        $sql = "select * from teachers";
                                        $result = mysql_query($sql, $link);
                                        while($row = mysql_fetch_array($result))
                                        {
                                          $tech[$i]=$row['id'];                            
                                           $i++;                                
                                        }
                                        
                                        ?>
                                        
                                        <td><b>Primary Instructor:</b></td>
                                        <td><select type="combo" name="teachers">
                                        <?php
                                        for($j=0;$j<$i;$j++)
                                        {
                                                echo "<option> $tech[$j] </option>";
                                        
                                        }
                                        
                                        
                                        ?>
                                        </td>
                                </tr>
                                <tr>
                                
                                        <td><b>Seconadry Instructor:</b></td>
                                        <td><select type="combo" name="teacher2">
                                        <?php
                                        for($j=0;$j<$i;$j++)
                                        {
                                                echo "<option> $tech[$j] </option>";
                                        
                                        }
                                        
                                        
                                        ?>
                                        </td>
                                </tr>
                                
                                <tr>
                                <td> &nbsp; &nbsp; &nbsp;</td>
                                <td>&nbsp;&nbsp;</td>
                                
                                </tr>
                                
                                <tr>

                                       
                                        <td>&nbsp;</td>
                                        <td align="left">
                                        
                                        <input type="submit" name="save" value="Save" class="button" >
                                        <input type="hidden" name="teacher" value="true"> 
                                        </td>
                                        
                                </tr>
                                <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                </tr>
                                </form>
                                <form method="POST" enctype="multipart/form-data" action="addStudent.php">
                                <tr>
                                        <td><b>Upload File(Optional)</b></td>
                                                                
                                        <td >
                                        <input type="file" name="userfile" size="25" >
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
                            
                            <br><br><br><br><br><br><br>
                    
                <?php
                   }
        }
               
        
        }
        ?>   

        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
               function check_valid_date()
               {
                   $d = $_POST['entry_day'];
                   $m = $_POST['entry_month'];
                   $y = $_POST['entry_year'];
                   if($_POST['entry_month']=="Month")return 0;
                   if($_POST['entry_day']=="Day")return 0;
                   if($_POST['entry_year']=="Year")return 0;
                   if( $m==2 )
                   {
                        if($y % 4==0 && ($y%400==0 || $y%100!=0) )
                        {
                           if($d>29)return 0;
                        }
                        else
                        {
                                if($d>28)return 0;
                        }
                   }
                  
                   if( ($m==4 || $m==6 || $m==9 || $m==11) && ($d==31) ) return 0;
                   return 1;
               
               }
               
               function check_valid_birth_date()
               {
                   $d = $_POST['birth_day'];
                   $m = $_POST['birth_month'];
                   $y = $_POST['birth_year'];
                   if($_POST['birth_month']=="Month")return 0;
                   if($_POST['birth_day']=="Day")return 0;
                   if($_POST['birth_year']=="Year")return 0;
                   if( $m==2 )
                   {
                        if($y % 4==0 && ($y%400==0 || $y%100!=0) )
                        {
                           if($d>29)return 0;
                        }
                        else
                        {
                                if($d>28)return 0;
                        }
                   }
                  
                   if( ($m==4 || $m==6 || $m==9 || $m==11) && ($d==31) ) return 0;
                   return 1;
               
               }
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
