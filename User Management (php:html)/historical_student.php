<?php
        include ("include/header.php");
        
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                               <?php
                                  
                                  
                                  if($_SESSION['user_status']==1)
                                   {
                                  ?>
                                  <li  id="current"><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                                 
                                  <?php
                                  }
                                  
                                   if($_SESSION['user_status']==0)
                                   {
                                  ?>
                                  <li  id="current"><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
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
                                <div class="left-box">
                                        <ul class="sidemenu">
                                             <?php
              


                                                    echo "<li ><a href='historical_student.php'>View Historical Student Class List</a></li>";
                                                    echo "<li ><a href='message_send.php'>Send Message to Students</a></li>";
                                      
                                       

                                              ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                
                                <h1>Search</h1>
                                <form method="POST" action="historical_student.php" class="searchform">
                                <input type="text" name="search" class="search" >
                                <input type="submit" value="Search" class="button">
                                <input type="hidden" name="search_form" value="true">
                                </form>

                               
                                <h1>Signout</h1>
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
        
            echo "<h1>Historical Student Class List</h1><br>";
            
            $link = connect_db();
            $sql = "select * from teacher_batch where ( id='$_SESSION[user_id]' AND finished=1 )";
            $result = mysql_query($sql, $link);
            $found=0;
            
            while($row = mysql_fetch_array($result))
            {
                $semester = $row['semester'];
                $batch = $row['batch'];
                $found=1;  
                //    echo "$semester";
                    //~ echo "$batch";
            }
          
            if($found==0)
            {
            
                echo "<b>No Students Found</b>";
                echo "<br><br><br><br><br><br><br>";
            }
            if($found==1)
            {
    
                    
                    echo "<b>Select Students View Information</b><br>";
            
                    $sql = "select * from std_grade where batch='$batch' AND semester='$semester'";
                    $result = mysql_query($sql, $link);
                    $found=0;
                    $tot=0;
                    while($row = mysql_fetch_array($result))
                    {
                      
                        $found=1;
                        $ids[$tot] = $row['id'];
                        $tot++;
                       
                        
                    }
                    if($found==1)
                    {
                            
                        
                            echo  "<table border='1px solid red' width='100%'>";                        
                            echo "<tr>";
                            echo "<td><b> ID </b></td>";
                            echo "<td><b> NAME </b></td>";
                            echo "<td><b> E-MAIL </b></td>";
                            echo "</tr>";
                            for($i=0;$i<$tot;$i++)
                            {
                                $sql = "select * from students where id='$ids[$i]'";
                                $result = mysql_query($sql, $link);
                                while($row = mysql_fetch_array($result))
                                {
                                  
                                    $name = $row['fullName'];
                                    $mail= $row['mail'];
                                    
                                }
                                echo "<tr>";
                                $p=$ids[$i];
                                echo "<td><a href='information_all.php?person=3&& ID=$p&& historical=1'> $ids[$i] </a></td>";
                                echo "<td>$name</td>";
                                echo "<td>$mail</td>";
                                echo "</tr>";
                           
                            }
                        echo "</table>";    
                    }
                    else
                    {
                        echo "<b>No Students Found</b>";
                        echo "<br><br><br><br><br><br><br>";
                        
                    
                    }
                
            }
        }
    
    ?>   

    </div>
                
                <!-- content-wrap ends here -->        
    </div>
                
               <?php
               
               include ("include/footer.php");
               ?>
