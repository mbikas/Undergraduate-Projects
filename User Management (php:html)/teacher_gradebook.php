<?
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
                                <form method="POST" action="teacher_gradebook.php" class="searchform">
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
                
                
                if($semester=="CCNA-1")$course = "CCNA 1: Networking Basics";
                else if($semester=="CCNA-2")$course = "CCNA 2: Networking Basics";
                else if($semester=="CCNA-3")$course = "CCNA 3: Networking Basics";
                else if($semester=="CCNA-4")$course = "CCNA 4: Networking Basics";

                $className = get_class_name();
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
                    echo "<br><br><b><font color='blue'>Select Student to Give his Number</font></b><br>";
                    //echo "Name= $name<br>";
                    //echo "sem = $semester<br>";
                    //echo "batch= $batch<br>";
                   
                    $sql = "select * from std_grade where ( batch='$batch' AND semester = '$semester' AND instructor='$_SESSION[user_id]')";
                    
                    $result = mysql_query($sql, $link);
                    $found=0;
                    $tot=0;
                    while($row = mysql_fetch_array($result))
                    {
                      
                        $found=1;
                        $ids[$tot] = $row['id'];
                        $tot++;       
                            
                    }
                    for($i=0;$i<$tot;$i++)
                    {
                        $Id=$ids[$i];
                        $sql = "select * from students where (id = '$Id')";
                        $result = mysql_query($sql, $link);
                        while($row = mysql_fetch_array($result))
                        {
                            //echo "Bikas";
                            $userName[$i] = $row['name'];
                            $fullName[$i] = $row['fullName'];                        
                        }
                        
                    }
                    if($found==1)
                    {
                            
                
                            echo  "<table border='1px solid red' width='100%'>";                        
                            echo "<tr>";
                            echo "<td><b> Student ID </b></td>";
                            echo "<td><b> User Name </b></td>";
                            echo "<td><b> Full Name </b></td>";
                            
                            echo "</tr>";
                            for($i=0;$i<$tot;$i++)
                            {
                                echo "<tr>";
                                $p=$ids[$i];
                                
                                $bat=$batch;
                                             
                                echo "<td><a href='teacher_gradebook_edit.php?semester=$sem&& batch=$bat&& ID=$p'> $ids[$i] </a></td>";
                                echo "<td>$userName[$i]</td>";
                                echo "<td>$fullName[$i]</td>";
                               
                               echo "</tr>";
                           
                            }
                        echo "</table>";  
                        echo "<br><br><br><br>";
                    }
                    if($found==0)
                    {
                        echo "<strong>";
                        echo "<br>No Student Enrolled Yet";
                        echo "</strong>";
                    }        
                    
                 
                
                
               
               
                
                
                     
                      
                    
                 

        ?>                   
                                  
                  
            
                     
                
                   
                                
                
        <?php
        
          
        }
        ?>
                        
        
</div>
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
              
?>
