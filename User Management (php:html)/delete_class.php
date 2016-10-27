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



                               

                                <h1>Search</h1>

                                <form method="POST" action="delete_class.php" class="searchform">
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
                    echo "<h1>Delete Class</h1>";
                    $id = $_SESSION['user_id'];
                    
                    $sql = "select status from std_grade where (instructor = '$id' AND semester='$semester' AND batch='$batch')";
                    $result = mysql_query($sql, $link);
                    $flag=1;
                    while($row = mysql_fetch_array($result))
                    {
                            
                            $stat = $row['status'];
                            
                            if($stat=="Enrolled")
                            {
                                $flag=0;
                                break;
                            }
                    }
                    
                    if($flag==1)
                    {
                        $sql = "update teacher_batch set finished = 1 where (id = '$id' AND semester='$semester' AND batch='$batch')";
                        $result = mysql_query($sql, $link);

                        echo "<br><b><color='blue'> The Selected Class have been deleted</font></b>";
                        echo "<br><br><br><br><br><br><br><br>";
                    }
                    else
                    {
                        echo "<br><b><color='red'>Class Cannot be deleted.</font></b><br>";
                        echo "<b><color='red'>Enrolled students exists in the Class.</font></b><br>";
                        echo "<br><br><br><br><br><br><br><br>";
                    }
                }
                 ?>
         </div>

                <!-- content-wrap ends here -->
                </div>

        <?php
                include ("include/student_footer.php");
               
        ?>
