<?php
        include ("include/header.php");
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
                                <ul class="sidemenu">
                                     <?php
                                     echo "<li ><a href='student_class.php?semester=$sem'>Student Class</a></li>";
                                     echo"<li ><a href='student_grade.php?semester=$sem'>GradeBook</a></li>";
                                    ?>
         
                                </ul>

                                <h1>Search</h1>

                                <form method="POST" action="student_class.php" class="searchform">
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
                 
                      $s = $semester;
                      $link = connect_db();                 
                      $sql = "select * from std_grade where (id = '$_SESSION[user_id]' AND semester='$s')";
                      $result = mysql_query($sql, $link);
                      
                  
                      while($row = mysql_fetch_array($result))
                        {
                            
                            $entry = $row['startDate'];
                            $teacher = $row['instructor'];  
                            $batch = $row['batch'];
                        }
                        
                        if($teacher==null)$teacher = "Not Assigned";
                     
                      
                      
                      $class = 'CCNA#';
                      
                      for($i=5;$i<strlen($semester);$i++){
                              $class = $class . $semester[$i];
                              $year=$semester[$i];
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
                 
                   <h1>Student Class</h1><br>
                   <b><?php echo "$class"; ?></b>
                   <br><br>
                    <fieldset>
                    <table align="left" width="100%">
                        <tr>
                            <td><b>Class Details</b></td>                            
                        </tr>
                        <tr>
                            <td>Course Name:</td>
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
                            <td>Start Date:</td>
                            <td><?php echo "$entry"; ?></td>
                        </tr>
                        
                        <tr>
                            <td>Class Location:</td>
                            <td>        Shahjalal University of Science and Technology (SUST)</td>
                        </tr>
                        <tr>
                            <td>Instructor:</td>
                            <td><?php echo "$teacher"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                     
                      

                       <br><br><br><br><br>
                 <?php
                 }
                 ?>
         </div>

                <!-- content-wrap ends here -->
                </div>

        <?php
                include ("include/footer.php");
        ?>
