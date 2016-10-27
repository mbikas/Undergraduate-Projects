<?
        include ("include/header.php");
        $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = null;
        $tbatch =$tcontact = $tpadd = $tadd=$tentry=null;
        $tsem=$tstatus=$tteacher=null;
        $ttype = $tcat=$tcontact = $tpadd = $tadd=$tbirth=null; 
        $p=1;
       
            
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                                <li><a href="index.php">Home</a></li>
                                <li><a href="information.php">View Informations</a></li>
                                <li  id="current"><a href="profile.php">My Profile</a></li>
                                <li><a href="search_category.php">Search</a></li>
                                <li><a href="aboutus.php">About Developers</a></li>
                              
             
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        
                                <h1>Links</h1>
                                <div class="left-box">
                                        <ul class="sidemenu">
                                                <li><a href='profile.php'>View Profile</a></li>
                                                <li><a href='edit_profile_std.php'>Edit Profile</a></li> 
                                        </ul>  
                               
                                </div>
                        
                                
                                

                                <h1>Search</h1>
                                <form method="POST" action="edit_profile_std.php" class="searchform">
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
                $id = $_SESSION['user_id'];
                $stat=$_SESSION['user_status'];
                
                    
                $link = connect_db();                 
                $sql = "select * from students where id = '$id'";
                $result = mysql_query($sql, $link);
                
               
                while($row = mysql_fetch_array($result))
                {
                        $tn = $row['name'];
                        $tfn = $row['fullName'];
                        $tpass=$row['password'];
                        $ttype = $row['stdType'];
                        $tcat = $row['stdCat'];
                        $tadd = $row['presentAdd'];
                        $tpadd = $row['permanentAdd'];
                        $tsex = $row['sex'];
                        $tbirth = $row['birth'];
                        $tmail = $row['mail'];
                        $tcontact = $row['contact']; 
                        $tentry = $row['entryDate'];
                        $tbatch = $row['batch'];
                        $tsem = $row['semester'];
                        $tstatus = $row['status'];
                        $tteacher = $row['teacher'];
                        $tcpass=$tpass;            
                }               
       
               
         
                if($teacher)
                {
                 $teacher = false;
                 
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
                     $teacher=false;
                     if($tPass!=$tCPass){echo "Password Mismatch<br>";}
                     else
                        {
                                                                     
                                $link = connect_db();                                   
                                
                                $sql = "delete from user where id='$_SESSION[user_id]'";
                                $result = mysql_query($sql, $link);
                                            
                                $sql = "insert into user values('$id','$tpass',$stat)";
                                $result = mysql_query($sql, $link);
                                            
                                            
                                $sql = "delete from students where id='$_SESSION[user_id]'";
                                $result = mysql_query($sql, $link);
                                   
                                            
                                    
                                $sql = "insert into students values('$id','$tn','$tfn','$tpass','$ttype','$tcat','$tadd','$tpadd','$tsex','$tbirth','$mail','$contact','$tentry','$tbatch','$tsem','$tstatus','$tteacher')";
                                $result = mysql_query($sql, $link);
                                    
                                
                                    
                                $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = $tdegree =$tcontact = $tpadd = $tadd=null; 
            
                                echo "<h2>Your information have been successfully Updated.</h2><br>";
                                $p=$flag=0;
                                  
                        
                        }                    
                }                
            
            }
        if($p==1)
        {
        ?>
                        
                        <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        
                        Edit Profile</h3>
                    <br>
                     <fieldset>
                     <form action="edit_profile_std.php" method="POST">
                     
                     <table width="75%" align="center">
                     
                        <tr>
                                <td><b>ID:</b></td>
                                <td><?php echo "$id" ?></td>
                        </tr>
                        
                        <tr>
                                <td><b>Nick Name:</b></td>
                                <td><input type="text" name="tName" size="20" value="<?php echo "$tn" ?>"></td>
                        </tr>
                        <tr>
                                <td><b>Full Name:</b></td>
                                <td><input type="text" name="tFName" size="20" value="<?php echo "$tfn" ?>"></td>

                        </tr>

                        <tr>
                                <td><b>Password:</b></td>
                                <td><input type="text" name="tPass" size="20" value="<?php echo "$tpass" ?>"></td>
                        </tr>
                        <tr>
                                <td><b>Confirm Password:</b></td>
                                <td><input type="text" name="tCPass" size="20" value="<?php echo "$tcpass" ?>"></td>
                        </tr>
                        
                        <tr>
                        <td><b>Student Type:</b></td>
                        <td><?php echo "$ttype" ?></td>
                        </td>
                        </tr>
                        <tr>
                                <td><b>Student Category:</b></td>
                                <td><?php echo "$tcat" ?></td>
                        
                        </tr>
                        
                        

                        <tr>
                                <td><b>Present Address:</b></td>
                                <td><textarea name="presentAdd" rows="2" cols="15"><?php echo "$tadd" ?></textarea></td>
                        </tr>
                        <tr>
                                <td><b>Permanent Address:</b></td>
                                <td><textarea name="permanentAdd" rows="2" cols="15" ><?php echo "$tpadd" ?></textarea></td>
                        </tr>
                        <tr>
                                <td><b>Sex:</b></td>
                                <td><select type="combo" name="sex">
                                <option name="sex">Male</option>
                                <option name="sex">Female
                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </option>
                                </td>
                        </tr>
                        <tr>
                        <td><b>Date of Birth:</b></td>
                        <td><input type="text" name="birthDate" size="20" value="<?php echo "$tbirth" ?>"></td>
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
                        <td><b>Entry Date:</b></td>
                        <td><?php echo "$tentry" ?></td>
                        </tr>
                        <tr>
                        <td><b>Batch No:</b></td>
                        <td><?php echo "$tbatch" ?></td>
                        
                        </tr>
                        
                        <tr>
                        <td><b>Semester:</b></td>
                        <td><?php echo "$tsem" ?></td>
                        </tr>
                        
                        <tr>
                                <td><b>Status:</b></td>
                                <td><?php echo "$tstatus" ?></td>
                        </tr>
                        <tr>
                                
                                
                                <td><b>Assigned Teacher:</b></td>
                                <td><?php echo "$tteacher" ?></td>
                        
                        </tr>
                        
                        
                        <tr>

                                <td></td>

                                <td>
                                <input type="hidden" name="teacher" value="true">                                
                                <input type="submit" name = "save" value="Update" > 

                                </form>
                                </td>


                        </tr>



                    </table>
                    </fieldset>
            
        <?php
           }
        }
        ?>

        </div>
    </div>

                      <?php
                      include ("include/footer.php");
                      ?>

