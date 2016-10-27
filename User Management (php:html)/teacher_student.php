<?
        include ("include/header.php");
        $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = null;
        $tbatch =$tcontact = $tpadd = $tadd=$tentry=null;
        $tsem=$tstatus=$tteacher=null;
        $ttype = $tcat=$tcontact = $tpadd = $tadd=$tbirth=null; 
        $p=1;
        $_SESSION['student']=$std_id;
            
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                                 <li ><a href="index.php">Home</a></li>
                                  <li ><a href="addUser.php">Add User</a></li>
                                  <li  id="current"><a href="information.php">Informations</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="admin.php">Administrator</a></li>
                                  <li><a href="aboutus.php">About Us</a></li>
             
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        
                                <h1>Links</h1>
                                <div class="left-box">
                                        <ul class="sidemenu">
                                                 <?php 
                                                        $s = $std_id;
                                                        echo "<li><a href='teacher_student.php?std_id=$s'>View Profile</a></li>";
                                                        echo "<li><a href='grade_teacher.php?std_id=$s && value=1'>Grade Exam</a></li>";
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
                                                <h1>Log Out</h1>
                                                      <div class="left-box">
                                                      <ul class="sidemenu">
                                                       <li><a href="logout.php?logout_id=1">Logout</a></li>
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
                                
                                        $id = $std_id;
                                                       
                                            
                                        $link = connect_db();                 
                                        $sql = "select * from students where id = '$id'";
                                        $result = mysql_query($sql, $link);
                                        
                                       
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
                                        ?>                
                               
                                                <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                View Profile</h3>
                                            <br>
                                             <fieldset>
                                             
                                             
                                             <table width="75%" align="center">
                                             
                                                <tr>
                                                        <td><b>ID:</b></td>
                                                        <td><?php echo "$id" ?></td>
                                                </tr>
                                                
                                                <tr>
                                                        <td><b>Nick Name:</b></td>
                                                        <td><?php echo "$tn" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Full Name:</b></td>
                                                        <td><?php echo "$tfn" ?></td>

                                                </tr>

                                                                        
                                                <tr>
                                                        <td><b>Student Type:</b></td>
                                                        <td><?php echo "$ttype" ?></td>
                                                </td>
                                                </tr>
                                                <tr>
                                                        <td><b>Student Category:</b></td>
                                                        <td><?php echo "$tcat" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Present Address:</b></td>
                                                        <td><?php echo "$tadd" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Permanent Address:</b></td>
                                                        <td><?php echo "$tpadd" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Sex:</b></td>
                                                        <td><?php echo "$tsex" ?></td>
                                                
                                                </tr>
                                                <tr>
                                                        <td><b>Date of Birth:</b></td>
                                                        <td><?php echo "$tbirth" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>E-Mail:</b></td>
                                                        <td><?php echo "$tmail" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Contact No:</b></td>
                                                        <td><?php echo "$tcontact" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Entry Date:</b></td>
                                                        <td><?php echo "$tentry" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Batch No:</b></td>
                                                        <td><?php echo "$tbatch" ?></td>                        
                                                </tr>
                                                
                                                <tr>
                                                        <td><b>Semester:</b></td>
                                                        <td><?php echo "$tsem" ?></td>
                                                </tr>
                                                
                                                <tr>
                                                        <td><b>Status:</b></td>
                                                        <td><?php echo "$tstatus" ?></td>
                                                </tr>
                                                <tr>
                                                        <td><b>Assigned Teacher:</b></td>
                                                        <td><?php echo "$tteacher" ?></td>
                                                </tr>

                                                </table>
                                            </fieldset>
                                <?php    
                                }
                                ?>

                        </div>
                
                <!-- content-wrap ends here -->        
                </div>
      
        
                      <?php
                      include ("include/footer.php");
                      
                    ?>
