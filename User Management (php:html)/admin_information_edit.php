<?
        include ("include/header.php")
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                                  <li><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li id="current"><a href="information.php">View Informations</a></li>
                                  <li ><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="admin.php">Administration</a></li>
                                  
                                     
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        
                                <h1>Links</h1>
                                <div class="left-box">
                                        <ul class="sidemenu">
                                             <?php
              
                                                          
                                                          $p=$person;
                                                          $i = $ID;
                                                          $d= $delete;
                                                          echo "<li><a href='information_all.php?ID=$i && person=$p && delete=$d'>View Information</a></li>";
                                                          echo "<li><a href='admin_information_edit.php ?ID=$i && person=$p && delete=$d'>Edit Information</a></li>";
                                                          echo "<li><a href='information_all.php ?ID=$i && person=$p && delete=1'>Delete User</a></li>";
                                                        

                                                      
                                                ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                
                                <h1>Search</h1>
                                <form method="POST" action="admin_information_edit.php" class="searchform">
                                <input type="text" name="search" class="search" >
                                <input type="submit" value="Search" class="button">
                                <input type="hidden" name="search_form" value="true">
                                </form>

                                <?php
                                        if($x==1 || $_SESSION['temp_user'])
                                        {
                                ?>
                                                <h1>Signout</h1>
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
            if($delete==1)
            {
                echo "<b>User Deleted</b>";
                $link = connect_db();
                $sql = "delete from user where id='$ID'";
                $result = mysql_query($sql, $link);
                
                if($person==1 || $person==2)
                {
                    
                    $sql = "delete from teachers where id='$ID'";
                    $result = mysql_query($sql, $link);
                }
                else
                {
                    
                    $sql = "delete from students where id='$ID'";
                    $result = mysql_query($sql, $link);
                    
                    $sql = "delete from std_grade where id='$ID'";
                    $result = mysql_query($sql, $link);
                }
            
            }
            
            else
            {
                    //echo "id = $ID<br>";
                    //echo "person = $person<br>";
                    if($person==3)student();
                    if($person==1)teacher();
                    if($person==2)employee();
            }
        ?>
            
                <br><br>
    <?php        
            
        }
    
    ?>   

    </div>
                
                <!-- content-wrap ends here -->        
    </div>
                
               <?php
               
               include ("include/footer.php");
               function employee()
                {
                        global $ID,$employee_button,$person;
                        
                        $link = connect_db();
                        $sql = "select * from teachers where id='$ID' AND status=$person";
                        $result = mysql_query($sql, $link);
                        while($row = mysql_fetch_array($result))
                        {
                            $id = $row['id'];
                            $name = $row['name'];
                            $fname = $row['fullName'];
                            $degree = $row['degree'];
                            $present = $row['presentAdd'];
                            $permanent = $row['permanentAdd'];
                            $sex = $row['sex'];
                            $mail = $row['mail'];
                            $contact = $row['contact'];
                            $status = $row['status'];
                                
                            
                        }
                        $p=1;
                        if($employee_button)
                        {
                                 
                         $employee_button=false;                                                            
                         $link = connect_db();                             
                                                              
                         $degree = $_POST['Degree'];
                         $state = $_POST['state'];
                         if($state=="Teacher")$x=1;
                         else $x=2;
                         
                         $p=0;
                         $sql = "update teachers set degree = '$degree' where id='$ID'";
                         $result = mysql_query($sql, $link);
                         $sql = "update teachers set status = $x where id='$ID'";
                         $result = mysql_query($sql, $link);
                         $sql = "update user set status = $x where id='$ID'";
                         $result = mysql_query($sql, $link);
                                
                         echo "<h2>Information have been successfully Updated.</h2><br>";
                        }                
                    
                       
                        if($p==1)
                        {
                
                                
                                                
                                    
                ?>            
                        <h2>Edit Employee Information</h2>    
                             <fieldset>
                             <form action="admin_information_edit.php" method="POST">
                             
                             <table width="75%" align="center">
                             
                                <tr>
                                        <td><b>ID:</b></td>
                                        <td><?php echo "$id" ?></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Nick Name:</b></td>
                                        <td><?php echo "$name" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Full Name:</b></td>
                                        <td><?php echo "$fname" ?></td>

                                </tr>

                             
                                <tr>
                                        <td><b>Degree:</b></td>
                                        <td><input type="text" name="Degree" size="20" value="<?php echo "$degree" ?>"></td>
                                </tr>
                                <tr>
                                        <td><b>Present Address:</b></td>
                                        <td><?php echo "$present" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Permanent Address:</b></td>
                                        <td><?php echo "$permanent" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Sex:</b></td>
                                        <td><?php echo "$sex" ?></td>
                                </tr>
                                <tr>
                                        <td><b>E-Mail:</b></td>
                                        <td><?php echo "$mail" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Contact No:</b></td>
                                        <td><?php echo "$contact" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Status:</b></td>
                                        <td><select type="combo" name="state">
                                        <option name="state">Employee</option>
                                        <option name="state">Teacher</option>
                                        </td>
                                       
                                </tr>
                                
                               
                                <tr>
                                <td> &nbsp; &nbsp; &nbsp;</td>
                                <td>&nbsp;&nbsp;</td>
                                </tr>
                                <tr>

                                       
                                       
                                        <td align="right">
                                        
                                        <input type="submit" name="save" value="Update" class="button">
                                        <?php
                                        global $person;
                                        $per=$person;
                                        $i = $ID;
                                        ?>
                                        <input type="hidden" name="person" value="<?php echo "$per";?>">
                                        <input type="hidden" name="ID" value="<?php echo "$i";?>">
                                        <input type="hidden" name="employee_button" value="true">   

                                        </form>
                                        </td>
                                        

                                </tr>
                                



                            </table>
                            </fieldset>
                            
                    
                        <?php
                        }
                }
               function teacher()
                {
                        global $ID,$teacher_button,$person;
                        
                        $link = connect_db();
                        $sql = "select * from teachers where id='$ID' AND status=$person";
                        $result = mysql_query($sql, $link);
                        while($row = mysql_fetch_array($result))
                        {
                            $id = $row['id'];
                            $name = $row['name'];
                            $fname = $row['fullName'];
                            $degree = $row['degree'];
                            $present = $row['presentAdd'];
                            $permanent = $row['permanentAdd'];
                            $sex = $row['sex'];
                            $mail = $row['mail'];
                            $contact = $row['contact'];
                            $status = $row['status'];
                                
                            
                        }
                        $p=1;
                        if($teacher_button)
                        {
                                 
                         $teacher_button=false;                                                            
                         $link = connect_db();                             
                                                              
                         $degree = $_POST['Degree'];
                         $state = $_POST['state'];
                         if($state=="Teacher")$x=1;
                         else $x=0;
                         
                         $p=0;
                         $sql = "update teachers set degree = '$degree' where id='$ID'";
                         $result = mysql_query($sql, $link);
                         $sql = "update teachers set status = $x where id='$ID'";
                         $result = mysql_query($sql, $link);
                         $sql = "update user set status = $x where id='$ID'";
                         $result = mysql_query($sql, $link);
                                
                         echo "<h2>Information have been successfully Updated.</h2><br>";
                        }                
                    
                       
                        if($p==1)
                        {
                
                                
                                                
                                    
                ?>            
                        <h2>Edit Teacher Information</h2>    
                             <fieldset>
                             <form action="admin_information_edit.php" method="POST">
                             
                             <table width="75%" align="center">
                             
                                <tr>
                                        <td><b>ID:</b></td>
                                        <td><?php echo "$id" ?></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Nick Name:</b></td>
                                        <td><?php echo "$name" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Full Name:</b></td>
                                        <td><?php echo "$fname" ?></td>

                                </tr>

                             
                                <tr>
                                        <td><b>Degree:</b></td>
                                        <td><input type="text" name="Degree" size="20" value="<?php echo "$degree" ?>"></td>
                                </tr>
                                <tr>
                                        <td><b>Present Address:</b></td>
                                        <td><?php echo "$present" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Permanent Address:</b></td>
                                        <td><?php echo "$permanent" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Sex:</b></td>
                                        <td><?php echo "$sex" ?></td>
                                </tr>
                                <tr>
                                        <td><b>E-Mail:</b></td>
                                        <td><?php echo "$mail" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Contact No:</b></td>
                                        <td><?php echo "$contact" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Status:</b></td>
                                        <td><select type="combo" name="state">
                                        <option name="state">Teacher</option>
                                        <option name="state">Admisitrator</option>
                                        </td>
                                       
                                </tr>
                                
                               
                                <tr>
                                <td> &nbsp; &nbsp; &nbsp;</td>
                                <td>&nbsp;&nbsp;</td>
                                </tr>
                                <tr>

                                       
                                       
                                        <td align="right">
                                        
                                        <input type="submit" name="save" value="Update" class="button">
                                        <?php
                                        global $person;
                                        $per=$person;
                                        $i = $ID;
                                        ?>
                                        <input type="hidden" name="person" value="<?php echo "$per";?>">
                                        <input type="hidden" name="ID" value="<?php echo "$i";?>">
                                        <input type="hidden" name="teacher_button" value="true">   

                                        </form>
                                        </td>
                                        

                                </tr>
                                



                            </table>
                            </fieldset>
                            
                    
                        <?php
                        }
                }
                     
               
              
               function student()
                {
                        global $ID,$student_button;
                        
                        $link = connect_db();
                        $sql = "select * from students where id='$ID'";
                        $result = mysql_query($sql, $link);
                        while($row = mysql_fetch_array($result))
                        {
                            $id = $row['id'];
                            $name = $row['name'];
                            $fname = $row['fullName'];
                            $stype = $row['stdType'];
                            $scat = $row['stdCat'];
                            $present = $row['presentAdd'];
                            $permanent = $row['permanentAdd'];
                            $sex = $row['sex'];
                            $birth = $row['birth'];
                            $mail = $row['mail'];
                            $contact = $row['contact'];
                            $batch = $row['batch'];
                            $semester = $row['semester'];
                            $status = $row['status'];
                            $teacher1 = $row['teacher'];  
                            $teacher2 = $row['secondaryInstractor'];
                            
                        }
                        $p=1;
                        if($student_button)
                        {
                                
                         $student_button=false;
                                                                                     
                         $link = connect_db();                             
                                                              
                         $stype = $_POST['stdtype'];
                         $cat = $_POST['stdCategory'];
                         $bat = $_POST['batch'];
                         $teacher = $_POST['teachers'];
                         $p=0;
                         $sql = "update students set stdType = '$stype' where id='$ID'";
                         $result = mysql_query($sql, $link);
                         $sql = "update students set stdCat = '$stype' where id='$ID'";
                         $result = mysql_query($sql, $link);
                         echo "<h2>Information have been successfully Updated.</h2><br>";
                        }                
                    
                       
                    if($p==1){
                
                                
                                                
                                    
                ?>            
                        <h2>Edit Student Information</h2>    
                             <fieldset>
                             <form action="admin_information_edit.php" method="POST">
                             
                             <table width="75%" align="center">
                             
                                <tr>
                                        <td><b>ID:</b></td>
                                        <td><?php echo "$ID" ?></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Nick Name:</b></td>
                                        <td><?php echo "$name" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Full Name:</b></td>
                                        <td><?php echo "$fname" ?></td>

                                </tr>

                             
                                <tr>
                                <td><b>Student Type:</b></td>
                                <td><select type="combo" name="stdtype">
                                        <option name="std">Program Student</option>
                                        <option name="std">Graduate Student</option>
                                </td>
                                </tr>
                                <tr>
                                        <td><b>Student Category:</b></td>
                                        <td><select type="combo" name="stdCategory">
                                                <?php
                                                $stdcat[]="SUST";
                                                $stdcat[]="Non SUST";
                                                $stdcat[]="Special";
                                                for($i=0;$i<3;$i++){
                                                        echo "<option>$stdcat[$i]</option>";
                                                }
                                                ?>
                                        </td>
                                </tr>
                                
                                

                                <tr>
                                        <td><b>Present Address:</b></td>
                                        <td><?php echo "$present" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Permanent Address:</b></td>
                                        <td><?php echo "$permanent" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Sex:</b></td>
                                        <td><?php echo "$sex" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Date of Birth:</b></td>
                                        <td><?php echo "$birth" ?></td>
                                </tr>
                                <tr>
                                        <td><b>E-Mail:</b></td>
                                        <td><?php echo "$mail" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Contact No:</b></td>
                                        <td><?php echo "$contact" ?></td>
                                </tr>
                                <tr>
                                        <td><b>Batch No:</b></td>
                                        <td><?php echo "$batch" ?></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Semester:</b></td>
                                        <td><?php echo "$semester"; ?></td>
                                </tr>
                                
                                <tr>
                                        <td><b>Status:</b></td>
                                        <td><?php echo "$status"; ?></td>
                                        </td>
                                        </td>
                                </tr>
                                <tr>
                                        
                                        <td><b>Primary Instructor:</b></td>
                                        <td><?php echo "$teacher1" ?></td>
                                </tr>
                                <tr>
                                        
                                        <td><b>Secondary Instructor:</b></td>
                                        <td><?php echo "$teacher2" ?></td>
                                </tr>
                                
                               
                                <tr>
                                <td> &nbsp; &nbsp; &nbsp;</td>
                                <td>&nbsp;&nbsp;</td>
                                </tr>
                                <tr>

                                       
                                       
                                        <td align="right">
                                        
                                        <input type="submit" name="save" value="Update" class="button">
                                        <?php
                                        global $person;
                                        $per=$person;
                                        $i = $ID;
                                        ?>
                                        <input type="hidden" name="person" value="<?php echo "$per";?>">
                                        <input type="hidden" name="ID" value="<?php echo "$i";?>">
                                        <input type="hidden" name="student_button" value="true">   

                                        </form>
                                        </td>
                                        

                                </tr>
                                



                            </table>
                            </fieldset>
                            
                    
                <?php
                 }
                     
               
               }
               ?>
