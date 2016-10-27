<?
        include ("include/header.php");
        $m1 = $m2 = $m3 = $m4 = $m5 = $m6 = $m7 = $m8 = $m9 = $m10 = $m11 = null;
        $tstatus = $tavg =  $skill = $lab = $final = null;  
        $sem = $semester; 
       
            
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                           <li id="current"><a href="index.php">Home</a></li>
                           <li><a href="information.php">View Informations</a></li>
                           <li><a href="profile.php">My Profile</a></li>
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
                                               <?php
                                                echo "<li ><a href='student_grade.php?semester=$sem'>$sem</a></li>";
                                          ?>
                                        </ul>  
                               
                                </div>
                        
                                
                                

                                 <h1>Search</h1>
                                <form method="POST" action="student_grade.php" class="searchform">
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
               
               
                $id = $_SESSION['user_id'];
                $stat=$_SESSION['user_status'];              
                $link = connect_db();
                
                
               
               
                
                
                        $sql = "select * from std_grade where (id = '$id' AND semester='$sem')";
                        $result = mysql_query($sql, $link);     
                
               
                        while($row = mysql_fetch_array($result))
                        {
                                $tsem=$row['semester'];
                                $m1 = $row['module1'];
                                if($m1==0)$m1=(string)'-';
                                
                                $m2 = $row['module2'];
                                if($m2==0)$m2=(string)'-';
                                
                                $m3 = $row['module3'];
                                if($m3==0)$m3=(string)'-';
                                
                                $m4 = $row['module4'];
                                if($m4==0)$m4=(string)'-';
                                
                                $m5 = $row['module5'];
                                if($m5==0)$m5=(string)'-';
                                
                                $m6 = $row['module6'];
                                if($m6==0)$m6=(string)'-';
                                
                                $m7 = $row['module7'];
                                if($m7==0)$m7=(string)'-';
                                
                                $m8 = $row['module8'];
                                if($m8==0)$m8=(string)'-';
                                
                                $m9 = $row['module9'];
                                if($m9==0)$m9=(string)'-';
                                
                                $m10 = $row['module10'];
                                if($m10==0)$m10=(string)'-';
                                
                                $m11 = $row['module11'];
                                if($m11==0)$m11=(string)'-';
                                
                                $skill = $row['skill'];
                                if($skill==0)$skill=(string)'-';
                                
                                $lab = $row['lab'];
                                if($lab==0)$lab=(string)'-';
                                
                                $practice = $row['practice'];
                                if($practice==0)$practice=(string)'-';
                                
                                $final = $row['final'];
                                if($final==0)$final=(string)'-';
                                
                                $weighted = $row['weighted'];
                                if($weighted==0)$weighted=(string)'-';
                                
                                $grade = $row['grade'];
                                if($grade==0)$grade=(string)'-';
                                
                                $attendence = $row['attendence'];
                                if($attendence==0)$attendence=(string)'-';
                                
                                $certificate = $row['certificate'];
                                if($certificate==0)$certificate=(string)'No';
                                else $certificate=(string)'Yes';
                                
                                $letter = $row['letter'];
                                if($letter==0)$letter=(string)'No';
                                else $letter=(string)'Yes';
                                
                                $tstatus = $row['status'];
                                $batch=$row['batch'];
                        } 
                     
                     $class = 'CCNA#';               
                      for($i=5;$i<strlen($tsem);$i++){
                              $class = $class . $tsem[$i];
                              $year=$tsem[$i];
                      }                      
                      $class = $class.'BATCH#';
                      for($i=6;$i<strlen($batch);$i++){
                              $class = $class . $batch[$i];
                      } 
                     
                      
                    if($semester=="CCNA-1")$course = "CCNA 1: Networking Basics";
                    else if($semester=="CCNA-2")$course = "CCNA 2: Networking Basics";
                    else if($semester=="CCNA-3")$course = "CCNA 3: Networking Basics";
                    else if($semester=="CCNA-4")$course = "CCNA 4: Networking Basics";
                 

        ?>                   
                                  
                  
            
                        <h1>Grade Book </h1><br><br>
                        
                        <b><?php echo "$class"; ?></b><br><br>
                        <fieldset>
                        <table  align="left" >                
                        <tr>
                                <td><b>Class Information</b></td>                                
                        </tr>
                        <tr>
                                <td>Class Name:</td>
                                <td><?php echo "$class" ?></td>
                        </tr>
                        <tr>
                                <td>Student ID:</td>
                                <td><?php echo "$id" ?></td>
                        </tr>
                        <tr>
                                <td>Course:</td>
                                <td><?php echo "$course" ?></td>
                        </tr>
                        <tr>
                                <td>Version</td>
                                <td>3.1</td>
                        </tr>
                        
                        </table>
                        </fieldset>
                       
                        
                        
                    <br>
                     
                 <b>Gradebook</b><br>
                 
                  <table  width="60%" align="left" border="1px">
                     
                       
                        
                        <tr>
                                <td><b>Name</b></td>
                                <td><b>Your Score</b></td>
                        </tr>
                        <tr>
                                <td>Module1:</td>
                                <td><?php echo "$m1" ?></td>
                        </tr>
                        <tr>
                                <td>Module2:</td>
                                <td><?php echo "$m2" ?></td>
                        </tr>
                        <tr>
                                <td>Module3:</td>
                                <td><?php echo "$m3" ?></td>
                        </tr>
                        <tr>
                                <td>Module4:</td>
                                <td><?php echo "$m4" ?></td>
                        </tr>
                        <tr>
                                <td>Module5:</td>
                                <td><?php echo "$m5" ?></td>
                        </tr>
                        <tr>
                                <td>Module6:</td>
                                <td><?php echo "$m6" ?></td>
                        </tr>
                        <tr>
                                <td>Module7:</td>
                                <td><?php echo "$m7" ?></td>
                        </tr>
                        <tr>
                                <td>Module8:</td>
                                <td><?php echo "$m8" ?></td>
                        </tr>
                        <tr>
                                <td>Module9:</td>
                                <td><?php echo "$m9" ?></td>
                        </tr>
                        <tr>
                                <td>Module10:</td>
                                <td><?php echo "$m10" ?></td>
                        </tr>
                        <tr>
                                <td>Module11:</td>
                                <td><?php echo "$m11" ?></td>
                        </tr>
                        <tr>
                                <td>Skill Test:</td>
                                <td><?php echo "$skill" ?></td>
                        </tr>
                        <tr>
                                <td>Lab Exam:</td>
                                <td><?php echo "$lab" ?></td>
                        </tr>
                       
                        <tr>
                                <td>Practice Final:</td>
                                <td><?php echo "$practice" ?></td>
                        </tr>
                        <tr>
                                <td>Final Exam:</td>
                                <td><?php echo "$final" ?></td>
                        </tr>
                        <tr>
                                <td><b>Weighted Percentage:</b></td>
                                <td><?php echo "$weighted" ?></td>

                        </tr>
                        <tr>
                                <td><b>Grade:</b></td>
                                <td><?php echo "$grade" ?></td>
                        </tr>
                        <tr>
                                <td>Attendence:</td>
                                <td><?php echo "$attendence" ?></td>
                        </tr>
                        <tr>
                                <td>Eligible for certificate:</td>
                                <td><?php echo "$certificate" ?></td>
                        </tr>
                        <tr>
                                <td>Eligible for letter:</td>
                                <td><?php echo "$letter" ?></td>
                        </tr>
                        <tr>
                                <td><b>Result:</b></td>
                                <td><?php echo "$tstatus" ?></td>
                        </tr>
                        
                        
                
                   </table>
                   
                                
                
        <?php
        
          
        }
        ?>
                        
        
</div>
</div>

<?php
        include ("include/footer.php");
        
        
        function check()
        {
                $i=0;
                $link = connect_db();
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
              
?>
