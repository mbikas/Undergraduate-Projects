<?
        include ("include/header.php")
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
              


                                                        echo "<li><a href='information.php?person=1'>Teachers</a></li>";
                                                        echo "<li><a href='information.php?person=2'>Employees</a></li>";
                                                        echo "<li><a href='information.php?person=3'>Students</a></li>";


                                              ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                
                                <h1>Search</h1>
                                <form method="POST" action="information.php" class="searchform">
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
          
            if($person==1)
            {
    
                echo "<h1>Teachers</h1><br>";
          
                $link = connect_db();
                $sql = "select * from teachers where status=1";
                $result = mysql_query($sql, $link);
                $found=0;
            
                $tot=0;
               
                while($row = mysql_fetch_array($result))
                {
                    $ids[$tot] = $row['id'];
                    $names[$tot] = $row['fullName'];
                    $mails[$tot] = $row['mail'];
                    $tot++;
                    $found=1;                                    
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
                            $p=$ids[$i];
                            echo "<tr>";
                            echo "<td><a href='information_all.php?person=1 && ID=$p'> $ids[$i] </a></td>";
                            echo "<td> <a href='information_all.php?person=1 && ID=$p'> $names[$i] </a></td>";
                            echo "<td>$mails[$i]</td>";
                            echo "</tr>";
                       
                        }
                    echo "</table>";    
                }
                else
                {
                    echo "<strong>";
                    echo "No Teacher Found";
                    echo "</strong>";
                }
            }          
            else if($person==2)
            {
                
                echo "<h1>Employees</h1><br>";
            
                $link = connect_db();
                $sql = "select * from teachers where status=2";
                $result = mysql_query($sql, $link);
                $found=0;
                $tot=0;
                while($row = mysql_fetch_array($result))
                {
                    $ids[$tot] = $row['id'];
                    $names[$tot] = $row['fullName'];
                    $mails[$tot] = $row['mail'];
                    $tot++;
                    $found=1;                   
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
                            $p=$ids[$i];
                            echo "<tr>";
                            echo "<td><a href='information_all.php?person=2 && ID=$p'> $ids[$i] </a></td>";
                            echo "<td> <a href='information_all.php?person=2 && ID=$p'> $names[$i] </a></td>";
                            echo "<td>$mails[$i]</td>";
                            echo "</tr>";
                       
                        }
                    echo "</table>";    
                }
                
                
                if($found==0)
                {
                    echo "<strong>";
                    echo "No Employee Found";
                    echo "</strong>";
                }
            }
            else if($person==3)
            {
                echo "<h1>Students</h1><br>";
        
                $link = connect_db();
                $sql = "select * from students";
                $result = mysql_query($sql, $link);
                $found=0;
                $tot=0;
                while($row = mysql_fetch_array($result))
                {
                  
                    $found=1;
                    $ids[$tot] = $row['id'];
                    $names[$tot] = $row['fullName'];
                    $mails[$tot] = $row['mail'];
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
                            echo "<tr>";
                            $p=$ids[$i];
                            echo "<td><a href='information_all.php?person=3 && ID=$p'> $ids[$i] </a></td>";
                            echo "<td> <a href='information_all.php?person=3 && ID=$p'> $names[$i] </a></td>";
                            echo "<td>$mails[$i]</td>";
                            echo "</tr>";
                       
                        }
                    echo "</table>";    
                }
                if($found==0)
                {
                    echo "<strong>";
                    echo "No Students Found";
                    echo "</strong>";
                }
          
            }
          
          
          else
            echo "<h2>Select Category</h2>";
        }
    
    ?>   

    </div>
                
                <!-- content-wrap ends here -->        
    </div>
                
               <?php
               
               include ("include/footer.php");
               ?>
