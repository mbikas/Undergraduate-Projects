<?php
        include ("include/header.php");
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

                                <h1>Search</h1>

                                <form method="POST" action="teacher_class_view.php" class="searchform">
                               <input type="text" name="search" class="search" >
                                                       <input type="submit" value="Search" class="button">
                               <input type="hidden" name="search_form" value="true">
                               </form>



                             <h1>Signout</h1>
                              <div class="left-box">
                              <ul class="sidemenu">
                              <li><a href='logout.php?logout_id=1'>Signout</a></li>
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
                    $className = get_class_name();
                    //echo "sem = $semester<br>";
                    //echo "batch= $batch<br>";
                    //echo "class =$className<br>";
                    echo "<h1>View Student Class Information</h1>";
                    
                    
                                         

                    if($semester=="CCNA-1")$course = "CCNA 1: Networking Basics";
                    else if($semester=="CCNA-2")$course = "CCNA 2: Networking Basics";
                    else if($semester=="CCNA-3")$course = "CCNA 3: Networking Basics";
                    else if($semester=="CCNA-4")$course = "CCNA 4: Networking Basics";
                    
                    
                    $sql = "select * from teacher_batch where (id = '$_SESSION[user_id]' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link);
                    while($row = mysql_fetch_array($result))
                    {
                            
                            $entry = $row['startDate'];
                            $end = $row['endDate'];
                            $finalexam=$row['finalExam'];
                            $name = $row['fullName'];
                            $room = $row['roomNo'];
                            $secondary=$row['secondaryInstructor'];
                    }
                    $sql = "select * from teachers where id = '$_SESSION[user_id]'";
                    $result = mysql_query($sql, $link);
                    while($row = mysql_fetch_array($result))
                    {                            
                            $mail = $row['mail'];
                    }
                    
                    
                    echo "<br>This is the information currently on record for the selected class.<br>";
                    echo "<br><br>";                    
                    echo "<b><font color='blue'>Class Details</font></b>";
                    
                 ?>
                        
                        
                        <fieldset>
                        
                        <table align="left" width="100%">
                            <tr>
                                <td><b>Class Overview</b></td>                            
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
                                <td>Language:</td>
                                <td>English</td>
                            </tr>
                            <tr>
                                <td>Version:</td>
                                <td>3.1</td>
                            </tr>
                            <tr>
                                <td>&nbsp;<td>
                            </tr>
                            <tr>
                                <td><b>Date, Location</b></td>                            
                            </tr>
                            <tr>
                                <td>Start Date:</td>
                                <td><?php echo "$entry"; ?></td>
                            </tr>
                            <tr>
                                <td>End Date:</td>
                                <td><?php echo "$end"; ?></td>
                            </tr>
                            <tr>
                                <td>Final Exam Date:</td>
                                <td><?php echo "$finalexam"; ?></td>
                            </tr>
                            <tr>
                                <td>Class Location:</td>
                                <td>        Shahjalal University of Science and Technology (SUST)</td>
                            </tr>
                            
                            <tr>
                                <td>&nbsp;<td>
                            </tr>
                            <tr>
                                <td><b>Instructors</b></td>                            
                            </tr>
                            <tr>
                                <td>Primary Instructor:</td>
                                <td><?php echo "$name" ?></td>
                                
                            </tr>
                            <tr>
                                <td>Secondary Instructor:</td>
                                 <td><?php echo "$secondary"; ?></td>
                                
                            </tr>
                            
                            <tr>
                                <td>&nbsp;<td>
                            </tr>
                            <tr>
                                <td><b>Room No</b></td>                            
                            </tr>
                            <tr>
                                <td>Room No:</td>
                                <td><?php echo "$room"; ?></td>
                            </tr>
                            
                        </table>
                    </fieldset>
                    <br><br><br><br>
                     
                      

                       
                 <?php
                    
                 }
                 ?>
         </div>

                <!-- content-wrap ends here -->
                </div>

        <?php
                include ("include/footer.php");
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
                function update_information()
                {
                    global $link,$semester,$batch;
                    $entry = $_POST['start_date'];
                    $end = $_POST['end_date'];
                    $finalexam = $_POST['final_exam'];
                    $secondary = $_POST['instructor'];
                    $room = $_POST['room_no'];
                    $id = $_SESSION['user_id'];
                    
                    $sql = "update teacher_batch set secondaryInstructor = '$secondary' where (id = '$id' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    
                    $sql = "update teacher_batch set startDate = '$entry' where (id = '$id' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    $sql = "update teacher_batch set endDate = '$entry' where (id = '$id' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    $sql = "update teacher_batch set finalExam = '$finalexam' where (id = '$id' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    $sql = "update teacher_batch set roomNo = '$room' where (id = '$id' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    
                    $sql = "update std_grade set secondaryInstructor = '$secondary' where (semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    
                    $sql = "update std_grade set startDate = '$entry' where (semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
                    
                    $sql = "update std_grade set endDate = '$end' where (semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link); 
            
            
                
                }
        ?>
