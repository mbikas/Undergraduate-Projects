<?
        include ("include/header.php");
       
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                               <?php
                                   if($_SESSION['user_status']==3)
                                   {
                                   ?>
                                           <li><a href="index.php">Home</a></li>
                                           <li id="current"><a href="information.php">View Informations</a></li>
                                           <li><a href="profile.php">My Profile</a></li>
                                           <li><a href="search_category.php">Search</a></li>
                                           <li><a href="aboutus.php">About Developers</a></li>
                                  
                                  <?php
                                  }
                                  
                                   if($_SESSION['user_status']==2)
                                   {
                                  ?>
                                           <li><a href="index.php">Home</a></li>
                                           <li id="current"><a href="information.php">View Informations</a></li>
                                           <li><a href="profile.php">My Profile</a></li>
                                           <li><a href="search_category.php">Search</a></li>
                                           <li><a href="aboutus.php">About Developers</a></li>
                                  
                                  <?php
                                  }
                                  
                                   if($_SESSION['user_status']==1)
                                   {
                                  ?>
                                           <li><a href="index.php">Home</a></li>
                                  <li id="current"><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                                 
                                  <?php
                                  }
                                  
                                   if($_SESSION['user_status']==0)
                                   {
                                  ?>
                                          <li><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li id="current"><a href="information.php">View Informations</a></li>
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
                                <div class="left-box">
                                        <ul class="sidemenu">
                                             <?php
              
                                                    if($historical==1)
                                                    {
                                                      $p=$person;
                                                      $i = $ID;
                                                      $d= $delete;
                                                      
                                                      echo "<li><a href='information_all.php?ID=$i && person=$p && delete=$d&& historical=$historical'>View Information</a></li>";
                                                      
                                                    }
                                                    else
                                                    {
                                                        if($_SESSION['user_status']==0)
                                                        {
                                                          $p=$person;
                                                          $i = $ID;
                                                          $d= $delete;
                                                          echo "<li><a href='information_all.php?ID=$i && person=$p && delete=$d'>View Information</a></li>";
                                                          echo "<li><a href='admin_information_edit.php ?ID=$i && person=$p && delete=$d'>Edit Information</a></li>";
                                                          echo "<li><a href='information_all.php ?ID=$i && person=$p && delete=1'>Delete User</a></li>";
                                                        
                                                        }
                                                        else
                                                        {
                                                          echo "<li><a href='information.php?person=1'>Teachers</a></li>";
                                                          echo "<li><a href='information.php?person=2'>Employees</a></li>";
                                                          echo "<li><a href='information.php?person=3'>Students</a></li>";
                                                        
                                                        }
                                                    }


                                              ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                
                                <h1>Search</h1>
                                <form method="POST" action="information_all.php" class="searchform">
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
            if($person==1 && $delete!=1)
            {
    
                $link = connect_db();
                $sql = "select * from teachers where id='$ID'";
                $result = mysql_query($sql, $link);
                while($row = mysql_fetch_array($result))
                {
                    $name = $row['name'];
                    $fname = $row['fullName'];
                    $degree = $row['degree'];
                    $present = $row['presentAdd'];
                    $permanent = $row['permanentAdd'];
                    $sex = $row['sex'];
                    $mail = $row['mail'];
                    $contact = $row['contact'];
                    
                }
                
                echo "<h1>Teacher</h1><br><br>";
             ?>  
                <b>Academic Information<b>        
                <fieldset>
                    <table align="left" width="100%">
                        <tr>
                            <td>Institute:</td>
                            <td>Shahjalal University of Science & Technology(SUST)</td>
                        </tr>
                        <tr>
                            <td>ID:</td>
                            <td><?php echo "$ID"; ?></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><?php echo "$fname"; ?></td>
                        </tr>
                        <tr>
                            <td>Degree:</td>
                            <td><?php echo "$degree"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                <br>
                <b>Personal Information<b>        
                <fieldset>
                    <table align="left">
                        <tr>
                            <td>Present Address:</td>
                            <td><?php echo "$present"; ?></td>
                        </tr>
                        <tr>
                            <td>Permanent Address:</td>
                            <td><?php echo "$permanent"; ?></td>
                        </tr>
                        <tr>
                            <td>Sex:</td>
                            <td><?php echo "$sex"; ?></td>
                        </tr>
                        <tr>
                            <td>Mail:</td>
                            <td><?php echo "$mail"; ?></td>
                        </tr>
                        <tr>
                            <td>Contact No:</td>
                            <td><?php echo "$contact"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                <br><br><br>
        <?php
            }          
            else if($person==2  && $delete!=1)
            {
                
                $link = connect_db();
                $sql = "select * from teachers where id='$ID'";
                $result = mysql_query($sql, $link);
                while($row = mysql_fetch_array($result))
                {
                    $name = $row['name'];
                    $fname = $row['fullName'];
                    $degree = $row['degree'];
                    $present = $row['presentAdd'];
                    $permanent = $row['permanentAdd'];
                    $sex = $row['sex'];
                    $mail = $row['mail'];
                    $contact = $row['contact'];
                    
                }
                
                echo "<h1>Employee</h1><br><br>";
             ?>  
                <b>Academic Information<b>        
                <fieldset>
                    <table align="left">
                        <tr>
                            <td>Institute:</td>
                            <td>Shahjalal University of Science & Technology(SUST)</td>
                        </tr>
                        <tr>
                            <td>ID:</td>
                            <td><?php echo "$ID"; ?></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><?php echo "$fname"; ?></td>
                        </tr>
                        <tr>
                            <td>Degree:</td>
                            <td><?php echo "$degree"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                <br>
                <b>Personal Information<b>        
                <fieldset>
                    <table align="left">
                        <tr>
                            <td>Present Address:</td>
                            <td><?php echo "$present"; ?></td>
                        </tr>
                        <tr>
                            <td>Permanent Address:</td>
                            <td><?php echo "$permanent"; ?></td>
                        </tr>
                        <tr>
                            <td>Sex:</td>
                            <td><?php echo "$sex"; ?></td>
                        </tr>
                        <tr>
                            <td>Mail:</td>
                            <td><?php echo "$mail"; ?></td>
                        </tr>
                        <tr>
                            <td>Contact No:</td>
                            <td><?php echo "$contact"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                <br><br><br>
        <?php
            }
            else if($person==3  && $delete!=1)
            {
                
        
                $link = connect_db();
                $sql = "select * from students where id='$ID'";
                $result = mysql_query($sql, $link);
                while($row = mysql_fetch_array($result))
                {
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
                    $teacher = $row['teacher'];    
                    
                }
                
                echo "<h1>Student</h1><br><br>";
             ?>  
                <b>Academic Information<b>        
                <fieldset>
                    <table align="left">
                        <tr>
                            <td>Institute:</td>
                            <td>Shahjalal University of Science & Technology(SUST)</td>
                        </tr>
                        <tr>
                            <td>ID:</td>
                            <td><?php echo "$ID"; ?></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><?php echo "$fname"; ?></td>
                        </tr>
                        <tr>
                            <td>Student Type:</td>
                            <td><?php echo "$stype"; ?></td>
                        </tr>
                        <tr>
                            <td>Student Category:</td>
                            <td><?php echo "$scat"; ?></td>
                        </tr>
                        <tr>
                            <td>Batch No:</td>
                            <td><?php echo "$batch"; ?></td>
                        </tr>
                        <tr>
                            <td>Semester:</td>
                            <td><?php echo "$semester"; ?></td>
                        </tr>
                        <tr>
                            <td>Assigned Teacher:</td>
                            <td><?php echo "$teacher"; ?></td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td><?php echo "$status"; ?></td>
                        </tr>
                    </table>
                </fieldset>
                <br>
                <b>Personal Information<b>        
                <fieldset>
                    <table align="left">
                        <tr>
                            <td>Present Address:</td>
                            <td><?php echo "$present"; ?></td>
                        </tr>
                        <tr>
                            <td>Permanent Address:</td>
                            <td><?php echo "$permanent"; ?></td>
                        </tr>
                        <tr>
                            <td>Sex:</td>
                            <td><?php echo "$sex"; ?></td>
                        </tr>
                        <tr>
                            <td>Mail:</td>
                            <td><?php echo "$mail"; ?></td>
                        </tr>
                        <tr>
                            <td>Contact No:</td>
                            <td><?php echo "$contact"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                <br><br><br>
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
