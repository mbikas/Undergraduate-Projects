<?php

  include ("include/header.php");
  
   
    
    $archive_dir = "./files"; 
   
    $link = connect_db();
    $sql = "select * from id";
    $result = mysql_query($sql, $link);
    $row = mysql_fetch_array($result);
    $id = $row['id']; 
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
                                        
                                                if($person==3)$p=3;
                                                if($person==2)$p=2;
                                                if($person==1)$p=1;
                                        
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
                                                        echo "<li><a href='file_format.php?person=$p'>Uploaded File Format</a></li>";
                                                }
                                        }
                                        else
                                        {
                                
                                                
                                                if($person==3)
                                                {
                                                        echo "<li><a href='addStudent.php'>Student Entry</a></li>";
                                                        echo "<li><a href='file_format.php?person=3'>Uploaded File Format</a></li>";
                                                }
                                                if($person==2)
                                                {
                                                        echo "<li><a href='addEmployee.php'>Employee Entry</a></li>";
                                                        echo "<li><a href='file_format.php?person=2'>Uploaded File Format</a></li>";
                                                }
                                                if($person==1)
                                                {
                                                        echo "<li><a href='addTeacher.php'>Teacher Entry</a></li>";
                                                        echo "<li><a href='file_format.php?person=1'>Uploaded File Format</a></li>";
                                                }
                                                
                                        
                                        }
                                        ?>
                                </ul>        
                                
                                <h1>Search</h1>        
                                
                                <form method="POST" action="file_format.php" class="searchform">
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
        
                 echo "<h1>Uploaded file format</h1>";
                if($person==3)
                {
                        echo "<br><b>File format for Student Entry</b>";
                        echo "<br>-------------------------------------<br>";
        ?>
                       
                        <ul>
                        <li>Input File should contains seven lines.</li>
                        <li>Each line will represent the following:</li>
                                <ul>
                                        <li>User Name</li>
                                        <li>Full Name</li>
                                        <li>Password(more than or equal six characters)</li>
                                        <li>Present Address</li>
                                        <li>Permanent Address</li>
                                        <li>Email Address</li>
                                        <li>Contact Number</li>                                 
                                </ul>
                        <li>If the input file conatin less than seven lines the required line will be considered as blank.</li>
                        <li>If the input file conatin more than seven lines the extra line will be eliminated.</li>
                        </ul>
                        <br><br><br><br><br><br>
                                
        <?php        
                }               
                else if($person==2 || $person==1)
                {
                        if($person==2)
                                echo "<br><b>File format for Employee Entry</b>";
                        if($person==1)
                                echo "<br><b>File format for Teacher Entry</b>";
                        echo "<br>-------------------------------------<br>";
        ?>
                       
                        <ul>
                        <li>Input File should contains eight lines.</li>
                        <li>Each line will represent the following:</li>
                                <ul>
                                        <li>User Name</li>
                                        <li>Full Name</li>
                                        <li>Password(more than or equal six characters)</li>                                        
                                        <li>Degree</li> 
                                        <li>Present Address</li>
                                        <li>Permanent Address</li>
                                        <li>Email Address</li>
                                        <li>Contact Number</li>                                 
                                </ul>
                        <li>If the input file conatin less than eight lines the required line will be considered as blank</li>
                        <li>If the input file conatin more than eight lines the extra line will be eliminated</li>
                        </ul>
                        <br><br><br><br><br><br>
        <?php        
                }
        
                 
        } 
        ?>

        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
       <?php
       
       include ("include/footer.php");
      
       ?>
