<?php
        include ("include/header.php");
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
                                  <li id = "current"><a href="addUser.php">Add Users</a></li>
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
                                                echo "<li><a href=$load>$name</a></li>";
                                        }
                                        else
                                        {
                                ?>
                                                 <li><a href="addStudent.php">Student Entry</a></li>
                                                 <li><a href="addTeacher.php">Teacher Entry</a></li>
                                                 <li><a href="addEmployee.php">Employee Entry</a></li>
                                        <?php
                                        }
                                        ?>
                                        </ul>        
                                
                                <h1>Search</h1>        
                                
                                <form method="POST" action="addUser.php" class="searchform">
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
                                
                                  if($_SESSION['temp_status']==null && $_SESSION['temp_id']!=null)
                                     echo "<b>Login with your new ID and Password</b>";
                                  else
                                     echo "<h2>Select Category</h2>";
                                }
                            ?>   
                        
                        <br><br><br><br><br>

                        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                                        
        <?php
                include ("include/footer.php");
        ?>
