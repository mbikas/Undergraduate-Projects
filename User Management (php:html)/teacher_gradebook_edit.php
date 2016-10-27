<?
        include ("include/header.php");
        $m1 = $m2 = $m3 = $m4 = $m5 = $m6 = $m7 = $m8 = $m9 = $m10 = $m11 = null;
        $tstatus = $tavg =  $skill = $lab = $final = null;  
        $sem = $semester; 
        $link = connect_db();

       
            
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                           <?php
                         if($_SESSION['user_status']==1)
                          {
                         ?>
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                        
                         <?php
                         }
                         
                         else if($_SESSION['user_status']==0)
                          {
                          
                         ?>
                                
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
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
                                             $bat=$batch;
                                             $class=$className;
                                             echo "<li ><a href='teacher_class_edit.php?semester=$sem&& batch=$bat'>Edit Class Informtion</a></li>";
                                             echo "<li ><a href='teacher_roster.php?semester=$sem&& batch=$bat'>Student Class Roster</a></li>";
                                             echo "<li ><a href='teacher_gradebook.php?semester=$sem&& batch=$bat'>GradeBook</a></li>";
                                             echo"<li ><a href='teacher_class_view.php?semester=$sem&& batch=$bat'>View Class Information</a></li>";
                                            ?>
                                        </ul>  
                               
                                </div>
                        
                                
                                

                                 <h1>Search</h1>
                                <form method="POST" action="teacher_gradebook_edit.php" class="searchform">
                                <input type="text" name="search" class="search" >
                                <input type="submit" value="Search" class="button">
                                <input type="hidden" name="search_form" value="true">
                                </form>

                                        <h1>Sign Out</h1>
                                        <div class="left-box">
                                        <ul class="sidemenu">
                                        <li><a href="logout.php?logout_id=1">Signout</a></li>
                                        </li>
                                              </ul>
                                              </div>

                               

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
               
        
                echo "<h1>GradeBook</h1>";
                class_info();                
        
                
                
                
                
               
               
                
                
                        $sql = "select * from std_grade where (id = '$ID' AND semester='$sem' AND batch='$batch')";
                        $result = mysql_query($sql, $link);     
                
               
                        while($row = mysql_fetch_array($result))
                        {
                                
                                $m1 = $row['module1'];                                
                                $m2 = $row['module2'];
                                $m3 = $row['module3'];
                                $m4 = $row['module4'];
                                $m5 = $row['module5'];
                                $m6 = $row['module6'];
                                $m7 = $row['module7'];
                                $m8 = $row['module8'];
                                $m9 = $row['module9'];
                                $m10 = $row['module10'];
                                $m11 = $row['module11'];
                                $skill = $row['skill'];                                
                                $lab = $row['lab'];
                                $practice = $row['practice'];
                                $final = $row['final'];
                                $weighted = $row['weighted'];
                                $grade = $row['grade'];
                                $attendence = $row['attendence'];
                                $certificate = $row['certificate'];
                                $letter = $row['letter'];
                                $status = $row['status'];
                                $start = $row['startDate'];
                                $end = $row['endDate'];
                                $instructor = $row['instructor'];
                                $secondary = $row['secondaryInstructor'];
                                
                                
                        } 
                        
                        
                if($button_press)
                {
                        $value=update_gradebook();
                        if($value==0)echo "<br><b>Gradebook Updated</b>";
                        if($value==1){
                                echo "<br><b>Gradebook Updated</b>";
                                echo "<br><b>Student have Passed<b>";
                                echo "<b>And automatically updated to new semester<b>";                             
                        
                        }
                        
                }  
                    
                 
                echo "<br><br><b><font color='blue'>Edit Gradebook</font></b>";
                    
                 
                 
        ?>                   
                              
                  
            
                 <form action="teacher_gradebook_edit.php" method="POST">
                  <table  width="50%" align="left" border="1" color="red">
                     
                       
                        
                        <tr>
                                <td bgcolor="#edfdce"><b>Name</b></td>
                                <td  bgcolor="#edfdce"><b>Marks</b></td>
                        </tr>
                        <tr>
                                <td>Module1:</td>
                                <td><input type="text" border="none" name="M1" size="5" value="<?php echo "$m1" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module2:</td>
                                <td><input type="text" border="none" name="M2" size="5" value="<?php echo "$m2" ?>"></td>
                               
                               
                               
                        </tr>
                        <tr>
                                <td>Module3:</td>
                                <td><input type="text" border="none" name="M3" size="5" value="<?php echo "$m3" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module4:</td>
                                <td><input type="text" border="none" name="M4" size="5" value="<?php echo "$m4" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module5:</td>
                                <td><input type="text" border="none" name="M5" size="5" value="<?php echo "$m5" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module6:</td>
                               <td><input type="text" border="none" name="M6" size="5" value="<?php echo "$m6" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module7:</td>
                                <td><input type="text" border="none" name="M7" size="5" value="<?php echo "$m7" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module8:</td>
                                <td><input type="text" border="none" name="M8" size="5" value="<?php echo "$m8" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module9:</td>
                               <td><input type="text" border="none" name="M9" size="5" value="<?php echo "$m9" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module10:</td>
                               <td><input type="text" border="none" name="M10" size="5" value="<?php echo "$m10" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Module11:</td>
                                <td><input type="text" border="none" name="M11" size="5" value="<?php echo "$m11" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Skill Test:</td>
                                <td><input type="text" border="none" name="Skill" size="5" value="<?php echo "$skill" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Lab Exam:</td>
                                <td><input type="text" border="none" name="Lab" size="5" value="<?php echo "$lab" ?>"></td>
                               
                        </tr>       
                                
                        <tr>
                                <td>Practice Final:</td>
                                <td><input type="text" border="none" name="Practice" size="5" value="<?php echo "$practice" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Final Exam:</td>
                                <td><input type="text" border="none" name="Final" size="5" value="<?php echo "$final" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td><b>Weighted Percentage:</b></td>
                                <td><input type="text" border="none" name="Weighted" size="5" value="<?php echo "$weighted" ?>"></td>
                               

                        </tr>
                        <tr>
                                <td><b>Grade:</b></td>
                                <td><input type="text" border="none" name="Grade" size="5" value="<?php echo "$grade" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Attendence:</td>
                                <td><input type="text" border="none" name="Attendence" size="5" value="<?php echo "$attendence" ?>"></td>
                               
                        </tr>
                        <tr>
                                <td>Eligible for certificate:</td>
                                <td><select type="combo" name="Certificate">
                                        <option name="Certificate">No</option>
                                        <option name="Certificate">Yes</option>
                                </td> 
                        </tr>
                        <tr>
                                <td>Eligible for letter:</td>
                                <td><select type="combo" name="Letter">
                                        <option name="Certificate">No</option>
                                        <option name="Certificate">Yes</option>
                                </td>                       
                        </tr>
                        <tr>
                                <td><b>Result:</b></td>
                                <td><select type="combo" name="Status">
                                        <option name="Status">E</option>
                                        <option name="Status">I</option>
                                        <option name="Status">F</option>
                                        <option name="Status">P</option>
                                </td> 
                        </tr>
                       
                        <tr >
                                <td align="center" colspan="2">
                                        <input type="submit" name="save" value="Submit" class="button">
                                        <input type="hidden" name="button_press" value="true">  
                                        <input type="hidden" name="semester" value="<?php echo "$semester"; ?>">
                                        <input type="hidden" name="batch" value="<?php echo "$batch"; ?>">
                                        <input type="hidden" name="ID" value="<?php echo "$ID"; ?>">
                                </td>
                        </tr>
                        
                </table>
               
                   
                </form>
                
                  
                   
                                
                
        <?php
        
          
        }
        ?>
                        
        
</div>
</div>

<?php
        include ("include/footer.php");
        
        function update_gradebook()
        {
                global  $semester,$ID,$batch,$link;
                global  $m1,$m2,$m3,$m4,$m5,$m6,$m7,$m8,$m9,$m10,$m11,$skill;
                global  $lab,$practice,$final,$weighted,$grade,$attendence;
                global  $certificate,$letter,$status;
                global $start,$end,$instructor,$secondary;

                $m1 = $_POST['M1'];
                $m2 = $_POST['M2'];
                $m3 = $_POST['M3'];
                $m4 = $_POST['M4'];
                $m5 = $_POST['M5'];
                $m6 = $_POST['M6'];
                $m7 = $_POST['M7'];
                $m8 = $_POST['M8'];
                $m9 = $_POST['M9'];
                $m10 = $_POST['M10'];
                $m11 = $_POST['M11'];
                $skill = $_POST['Skill'];
                $lab = $_POST['Lab'];
                $practice = $_POST['Practice'];
                $final = $_POST['Final'];
                $weighted = $_POST['Weighted'];
                $grade = $_POST['Grade'];
                $certificate = $_POST['Certificate'];
                $letter = $_POST['Letter'];
                $status = $_POST['Status'];
                
                $ok=1;
                if($status=="P")
                {
                        if($skill<70)
                        {
                                echo "<br><b><font color='red'>Student have low Marks(<70%) in Skill Exam</b></font>";
                                $ok=0;
                        }
                        if($final<70)
                        {
                                echo "<br><b><font color='red'>Student have low Marks(<70%) in Final Exam</b></font>";
                                $ok=0;
                        }
                        if($weighted<70)
                        {
                                echo "<br><b><font color='red'>Weighed percentenge have to be greater than 70%</b></font>";
                                $ok=0;
                        }
                        if($ok==1)
                        {
                                if($letter=="No" && $weighted>=80.0)
                                {
                                        echo "<br><b><font color='red'>Student is Eligible for Letter</b></font>";
                                        $ok=0;                                        
                                }                        
                        }
                        if($ok==1)
                        {
                                if($certificate=="No" && $weighted>=70.0)
                                {
                                        echo "<br><b><font color='red'>Student is Eligible for certificate</b></font>";
                                        $ok=0;                                        
                                }                        
                        }
                        if($ok==0)return -1;
                        $stat="Enrolled";
                        $p=1;
                        if($semester == "CCNA-1")$ss="CCNA-2";
                        else if($semester == "CCNA-2")$ss="CCNA-3";
                        else if($semester == "CCNA-3")$ss="CCNA-4";
                        else if($semester == "CCNA-4")
                        {
                                $ss="Completed";
                                $stat="Graduate";
                                $p=0;
                        }
                        if($certificate=='Yes')$certificate=1;
                        else $certificate=0;
                        if($letter=='Yes')$letter=1;
                        else $letter=0;
                        $pass = "Passed";
                        $blank=null;
                        
                        $sql = "delete from std_grade where (ID='$ID' AND semester='$semester' AND batch='$batch')";
                        $result = mysql_query($sql, $link); 
                        
                        
                        $blank="";
                        $sql = "insert into std_grade values('$ID','$semester','$batch','$start','$end','$instructor','$secondary',$m1,$m2,$m3,$m4,$m5,$m6,$m7,$m8,$m9,$m10,$m11,$skill,$lab,$practice,$final,$weighted,'$grade',$attendence,$certificate,$letter,'$pass')";
                        $result = mysql_query($sql, $link);
                        
                        $sql = "update students set semester = '$ss' where id = '$ID'";
                        $result = mysql_query($sql, $link);
                        
                        if($p==1)
                        {
                                $sql = "insert into std_grade values('$ID','$ss','$blank','$blank','$blank','$blank','$blank',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0,'$blank',0,0,0,'$stat')";
                                $result = mysql_query($sql, $link);
                        }
                        
                        return 1;
                }
                
                $stat="Enrolled";
                if($status=="E")$stat="Enrolled";
                if($status=="F")$stat="Failed";
                if($status=="I")$stat="Incomplete";
                
                if($certificate=='Yes')$certificate=1;
                else $certificate=0;
                if($letter=='Yes')$letter=1;
                else $letter=0;
                $sql = "delete from std_grade where (ID='$ID' AND semester='$semester' AND batch='$batch')";
                $result = mysql_query($sql, $link); 
                
                $sql = "insert into std_grade values('$ID','$semester','$batch','$start',";
                $sql  = $sql."'$end','$instructor','$secondary',$m1,$m2,$m3,$m4,$m5,$m6,$m7,$m8,$m9,$m10,$m11,$skill,$lab,$practice,$final,$weighted,'$grade',$attendence,$certificate,$letter,'$stat')";
                //echo "<br>$sql<br>";
                $result = mysql_query($sql, $link);
                return 0;
                              
                
                    
                               
                              
                
                
                
                
        
        
        }
        
        
        function check()
        {
                $i=0;
                global $link;
                $sql = "select semester from std_grade where id='$_SESSION[user_id]' order by semester";
                $result = mysql_query($sql, $link);
                while($row = mysql_fetch_array($result))
                {
                        $sems[$i]=$row['semester'];
                        $i++;                                
                }
                        
                for($k=0;$k<$i;$k++)
                {
                        $temp = $sems[$k];   
                        echo "<li><a href='student_grade.php?sem=$temp'>$temp</a></li>";    
                        
                }
                              
                            
        }
        
        function class_info()
        {
                global $semester,$ID,$batch,$link;
                
                if($semester=="CCNA-1")$course = "CCNA 1: Networking Basics";
                else if($semester=="CCNA-2")$course = "CCNA 2: Networking Basics";
                else if($semester=="CCNA-3")$course = "CCNA 3: Networking Basics";
                else if($semester=="CCNA-4")$course = "CCNA 4: Networking Basics";
                $className = get_class_name();
                echo "<br><b>$className</b>";
        ?>
        
                <br><br>
                <fieldset>
                        
                        <table align="left" width="100%">
                            <tr>
                                <td><b>Class Information</b></td>                            
                            </tr>
                            <tr>
                                <td>Curriculum:</td>
                                <td>CCNA</td>
                            </tr>
                            <tr>
                                <td>Class Name:</td>
                                <td><?php echo "$className"; ?></td>
                            </tr>
                            <tr>
                                <td>Course:</td>
                                <td><?php echo "$course"; ?></td>
                            </tr>
                            <tr>
                                <td>Version:</td>
                                <td>3.1</td>
                            </tr>
                            
                            
                        </table>
                    </fieldset>
                <?php
                    $sql = "select * from students where id='$ID'";
                    $result = mysql_query($sql, $link);
                    while($row = mysql_fetch_array($result))
                    {
                        $name=$row['fullName'];              
                    }
                ?>     
                    
                    <br>
                    <fieldset>
                        
                        <table align="left" width="100%">
                            <tr>
                                <td><b>Student Information</b></td>                            
                            </tr>
                            <tr>
                                <td>Student ID:</td>
                                <td><?php echo "$ID" ?></td>
                            </tr>
                            <tr>
                                <td>Full Name:</td>
                                <td><?php echo "$name"; ?></td>
                            </tr>
                            <tr>
                                <td>Semester:</td>
                                <td><?php echo "$semester"; ?></td>
                            </tr>
                            <tr>
                                <td>Batch</td>
                                <td><?php echo "$batch"; ?></td>
                            </tr>
                            
                            
                        </table>
                    </fieldset>
<?php
        }
        
        function get_class_name()
                {
                      global $link,$semester,$batch;
                      
                      
                      $class = 'CCNA#';
                      
                      for($i=0;$i<strlen($semester);$i++){
                              if($semester[$i]>='0' && $semester[$i]<='9')
                              $class = $class . $semester[$i];                              
                      }                      
                      $class = $class.'BATCH#';
                      for($i=0;$i<strlen($batch);$i++){
                        if($batch[$i]>='0' && $batch[$i]<='9')
                              $class = $class . $batch[$i];
                      }   
                    return $class;
                
                }
              
              
?>
