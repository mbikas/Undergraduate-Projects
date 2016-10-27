<?
        include ("include/header.php");
        $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = null;
        $tbatch =$tcontact = $tpadd = $tadd=$tentry=null;
        $tsem=$tstatus=$tteacher=null;
        $tdegree=$ttype = $tcat=$tcontact = $tpadd = $tadd=$tbirth=null; 
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                               <?php
                               if($_SESSION['user_status']==3)
                               {
                               ?>
                                       <li><a href="index.php">Home</a></li>
                                       <li><a href="information.php">View Informations</a></li>
                                       <li  id="current"><a href="profile.php">My Profile</a></li>
                                       <li><a href="search_category.php">Search</a></li>
                                       <li><a href="aboutus.php">About Developers</a></li>
                              
                              <?php
                              }
                              
                               if($_SESSION['user_status']==2)
                               {
                              ?>
                                       <li ><a href="index.php">Home</a></li>
                                       <li><a href="information.php">View Informations</a></li>
                                       <li  id="current"><a href="profile.php">My Profile</a></li>
                                       <li><a href="search_category.php">Search</a></li>
                                       <li><a href="aboutus.php">About Developers</a></li>
                              
                              <?php
                              }
                              
                               if($_SESSION['user_status']==1)
                               {
                              ?>
                                  <li><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li id="current"><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                             
                              <?php
                              }
                              
                               if($_SESSION['user_status']==0)
                               {
                              ?>
                                  <li><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li id="current"><a href="profile.php">My Profile</a></li>
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
              
                                                    if($_SESSION['user_status']==0 || $_SESSION['user_status']==1 || $_SESSION['user_status']==2)
                                                    {    
                                                        
                                                        echo "<li><a href='profile.php'>View Profile</a></li>";
                                                        echo "<li><a href='edit_profile.php'>Edit Profile</a></li>";                          
                                                    }
                                                    if($_SESSION['user_status']==3)
                                                    {    
                                                        
                                                        echo "<li><a href='profile.php'>View Profile</a></li>";
                                                        echo "<li><a href='edit_profile_std.php'>Edit Profile</a></li>";                          
                                                    }
                                              ?>
                                        </ul>  
                               
                                </div>
                        
                                
                                
                               <h1>Search</h1>
                                <form method="POST" action="index.php" class="searchform">
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
                    $id = $_SESSION['user_id'];
                    
                    
                    $link = connect_db();     
                    if($_SESSION['user_status']==0)
                          $sql = "select * from teachers where (status=0 AND id = '$id')";
                    if($_SESSION['user_status']==1)
                          $sql = "select * from teachers where (status=1 AND id = '$id')";
                    else if($_SESSION['user_status']==2)
                          $sql = "select * from teachers where (status=2 AND id = '$id')";
                    else if($_SESSION['user_status']==3)
                          $sql = "select * from students where id = '$id'";
                           
                    $result = mysql_query($sql, $link);
                    
                        
            
                    echo "<h1>View Profile</h1><br>";
                    
                    if($_SESSION['user_status']==0 || $_SESSION['user_status']==1 || $_SESSION['user_status']==2)
                    {
              
                        while($row = mysql_fetch_array($result))
                        {
                            $tn = $row['name'];
                            $tfn = $row['fullName'];
                            $tpass=$row['password'];
                            $tdegree = $row['degree'];
                            $tadd = $row['presentAdd'];
                            $tpadd = $row['permanentAdd'];
                            $tsex = $row['sex'];
                            $tmail = $row['mail'];
                            $tcontact = $row['contact']; 
                            
                        }
                        set_value_teacher();
                        
                    }
                    else
                    {
                       
                       
                        while($row = mysql_fetch_array($result))
                        {
                            $tn = $row['name'];
                            $tfn = $row['fullName'];
                            $tpass=$row['password'];
                            $ttype = $row['stdType'];
                            $tcat = $row['stdCat'];
                            $tadd = $row['presentAdd'];
                            $tpadd = $row['permanentAdd'];
                            $tsex = $row['sex'];
                            $tbirth = $row['birth'];
                            $tmail = $row['mail'];
                            $tcontact = $row['contact']; 
                            $tentry = $row['entryDate'];
                            $tbatch = $row['batch'];
                            $tsem = $row['semester'];
                            $tstatus = $row['status'];
                            $tteacher = $row['teacher'];
                            $tcpass=$tpass;        
                                         
                        }
                        
                        set_value_student();
                    
                    
                    } 
                }
            
            ?>    

         </div>
               
                <!-- content-wrap ends here -->        
                </div>
        <?php
      include ("include/footer.php");
      
      function set_value_student()
      {
            echo "This is your profile information currently on record. Click on the <a href='edit_profile_std.php'> Edit Profile </a>link to update this information.";
                    
            global $id;
            global $tn,$tfn,$tcontact,$tmail,$tpass,$tsex,$tcpass;
            global $tbatch,$tcontact,$tpadd,$tadd,$tentry;
            global $tsem,$tstatus,$tteacher;
            global $ttype,$tcat,$tcontact,$tpadd,$tadd,$tbirth;
       ?>           
                                     
                    
                
                
                <br><br>
                <b ><font color="#88ac0b">Profile Information</font></b>             
                <fieldset>
                    <table align="left">
                        <tr>
                            <td><b>Login Information&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
                           
                        </tr>
                        
                        <tr>
                            <td>Student ID:</td>
                            <td><?php echo "$id"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                      
                <fieldset>
                    <table align="left">
                        <tr>
                          <td><b>Personal Information&nbsp;&nbsp;</b></td>
                        </tr>
                        <tr>
                            <td>Nick Name:</td>
                            <td><?php echo "$tn"; ?></td>
                        </tr>
                        <tr>
                            <td>Full Name:</td>
                            <td><?php echo "$tfn"; ?></td>
                        </tr>
                        <tr>
                            <td>Present Address:</td>
                            <td><?php echo "$tadd"; ?></td>
                        </tr>
                        <tr>
                            <td>Permanent Address:</td>
                            <td><?php echo "$tpadd"; ?></td>
                        </tr>
                        <tr>
                            <td>Birth Date:</td>
                            <td><?php echo "$tbirth"; ?></td>
                        </tr>
                        <tr>
                            <td>Sex:</td>
                            <td><?php echo "$tsex"; ?></td>
                        </tr>
                        <tr>
                            <td>E-Mail:</td>
                            <td><?php echo "$tmail"; ?></td>
                        </tr>
                        <tr>
                            <td>Contact No:</td>
                            <td><?php echo "$tcontact"; ?></td>
                        </tr>
                        
                        
                    </table>
                </fieldset>
                
                <fieldset>
                    <table align="left">
                        <tr>
                          <td><b>Academic Information</b></td>
                        </tr>
                        <tr>
                            <td>Institute:</td>
                            <td>Shahjalal University of Science & Technology(SUST)</td>
                        </tr>
                        <tr>
                            <td>Entry Date:</td>
                            <td><?php echo "$tentry"; ?></td>
                        </tr>
                        <tr>
                            <td>Student Type:</td>
                            <td><?php echo "$ttype"; ?></td>
                        </tr>
                        <tr>
                            <td>Student Category:</td>
                            <td><?php echo "$tcat"; ?></td>
                        </tr>
                        <tr>
                            <td>Batch No:</td>
                            <td><?php echo "$tbatch"; ?></td>
                        </tr>
                        <tr>
                            <td>Semester:</td>
                            <td><?php echo "$tsem"; ?></td>
                        </tr>
                        <tr>
                            <td>Assigned Teacher:</td>
                            <td><?php echo "$tteacher"; ?></td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td><?php echo "$tstatus"; ?></td>
                        </tr>
                        
                        
                    </table>
                </fieldset>
                <br><br><br>        
    <?php  
      
        }  
    
    
    
    function set_value_teacher()
      {
            echo "This is your profile information currently on record. Click on the <a href='edit_profile.php'> Edit Profile </a>link to update this information.";
            
            global $id,$tdegree;
            global $tn,$tfn,$tcontact,$tmail,$tpass,$tsex;
            global $tcontact,$tpadd,$tadd;
            global $tcontact,$tpadd;
            if($_SESSION['user_status']==2)$person="Employee";
            if($_SESSION['user_status']==1)$person="Teacher";
    ?>           
                               
                <br><br>
                <b ><font color="#88ac0b">Profile Information</font></b>        
                <fieldset>
                    <table align="left">
                        <tr>
                            <td><b>Login Information&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
                           
                        </tr>
                        
                        <tr>
                            <td><?php echo "$person";?> ID:</td>
                            <td><?php echo "$id"; ?></td>
                        </tr>
                        
                    </table>
                </fieldset>
                      
                <fieldset>
                    <table align="left">
                        <tr>
                          <td><b>Personal Information&nbsp;&nbsp;</b></td>
                        </tr>
                        <tr>
                            <td>Nick Name:</td>
                            <td><?php echo "$tn"; ?></td>
                        </tr>
                        <tr>
                            <td>Full Name:</td>
                            <td><?php echo "$tfn"; ?></td>
                        </tr>
                        <tr>
                            <td>Present Address:</td>
                            <td><?php echo "$tadd"; ?></td>
                        </tr>
                        <tr>
                            <td>Permanent Address:</td>
                            <td><?php echo "$tpadd"; ?></td>
                        </tr>
                        
                        <tr>
                            <td>Sex:</td>
                            <td><?php echo "$tsex"; ?></td>
                        </tr>
                        <tr>
                            <td>E-Mail:</td>
                            <td><?php echo "$tmail"; ?></td>
                        </tr>
                        <tr>
                            <td>Contact No:</td>
                            <td><?php echo "$tcontact"; ?></td>
                        </tr>
                        
                        
                    </table>
                </fieldset>
                
                <fieldset>
                    <table align="left">
                        <tr>
                          <td><b>Academic Information</b></td>
                        </tr>
                        <tr>
                            <td>Institute:</td>
                            <td>Shahjalal University of Science & Technology(SUST)</td>
                        </tr>
                        
                        <tr>
                            <td>Degree:</td>
                            <td><?php echo "$tdegree"; ?></td>
                        </tr>
                        
                        
                    </table>
                </fieldset>
                <br><br><br>
                    
            
    <?php  
      
        }
    ?>

