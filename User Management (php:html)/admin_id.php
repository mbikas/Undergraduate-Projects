<?php

  include ("include/header.php");
    $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = null;
    $tdegree =$tcontact = $tpadd = $tadd=$tentry=null;
    $tdegree =$tcontact = $tpadd = $tadd=$tbirth=null; 
    $p=1;
    
    $status = $_SESSION['user_status'];    
    
    
    
       
    
?>

    
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                                <li><a href="index.php">Home</a></li>
                                <li><a href="addUser.php">Add Users</a></li>
                                <li><a href="information.php">View Informations</a></li>
                                <li ><a href="profile.php">My Profile</a></li>
                                <li><a href="search_category.php">Search</a></li>
                                <li id="current"><a href="admin.php">Administration</a></li>
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        
                                <h1>Links</h1>
                                <div class="left-box">
                                        <ul class="sidemenu">
                                        <?php $n1="batch";
                                              $n2="id";
                                              $n3="assign";
                                        
                                        echo "<li><a href='admin.php?name=$n1'>Create Batch</a></li>";
                                        echo "<li><a href='admin.php?name=$n2'>Create ID & Password</a></li>";
                                        echo "<li><a href='admin.php?name=$n3'>Assign Teacher For Batch</a></li>";
                                        echo "<li><a href='admin_id.php?name=$n3'>Sec ID & Password</a></li>";
                                        ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                 <h1>Search</h1>
                                <form method="POST" action="admin_id.php" class="searchform">
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
          
           
                echo "<h1>ID and Password</h1><br>";
          
                $link = connect_db();
                $sql = "select * from user order by id";
                $result = mysql_query($sql, $link);
                $found=0;
            
                $tot=0;
               
                while($row = mysql_fetch_array($result))
                {
                    $ids[$tot] = $row['id'];
                    $passwords[$tot] = $row['password'];
                    $status[$tot] = $row['status'];
                    $tot++;
                    $found=1;                                    
                }
                
                $sql = "select * from id_temp order by id";
                $result = mysql_query($sql, $link);
                $tot_temp=0;
                $found_temp=0;
               
                while($row = mysql_fetch_array($result))
                {
                    $id_temp[$tot_temp] = $row['id'];
                    $password_temp[$tot_temp] = $row['password'];
                    $status_temp[$tot_temp] = $row['status'];
                    $tot_temp++;
                    $found_temp=1;                                    
                }
                if($found==1)
                {
                        
            
                        echo  "<b><font  bgcolor='blue'>Current Users</font></b>";
                        echo "<br>------------------";
                        echo  "<table border='1px '>";                        
                        echo "<tr>";
                        echo "<td><b> ID </b></td>";
                        echo "<td><b> PASSWORD </b></td>";
                        echo "<td><b> CATEGORY </b></td>";
                        echo "</tr>";
                        for($i=0;$i<$tot;$i++)
                        {
                            $p=$ids[$i];
                            echo "<tr>";
                            echo "<td>$ids[$i]</td>";
                            echo "<td> $passwords[$i] </td>";
                            if($status[$i]==0)echo "<td>Administrator</td>";
                            if($status[$i]==1)echo "<td>Teacher</td>";
                            if($status[$i]==2)echo "<td>Employee</td>";
                            if($status[$i]==3)echo "<td>Student</td>";
                            echo "</tr>";
                       
                        }
                    echo "</table><br>"; 
                    
                }
                if($found_temp==1)
                {
                        
            
                        echo  "<b><font  bgcolor='blue'>NonAdmitted Users</font></b>";
                        echo "<br>------------------";
                        echo  "<table border='1px '>";                        
                        echo "<tr>";
                        echo "<td><b> ID </b></td>";
                        echo "<td><b> PASSWORD </b></td>";
                        echo "<td><b> CATEGORY </b></td>";
                        echo "</tr>";
                        for($i=0;$i<$tot_temp;$i++)
                        {
                            $p=$ids[$i];
                            echo "<tr>";
                            echo "<td>$id_temp[$i]</td>";
                            echo "<td> $password_temp[$i] </td>";
                            if($status_temp[$i]==0)echo "<td>Administrator</td>";
                            if($status_temp[$i]==1)echo "<td>Teacher</td>";
                            if($status_temp[$i]==2)echo "<td>Employee</td>";
                            if($status_temp[$i]==3)echo "<td>Student</td>";
                            echo "</tr>";
                       
                        }
                    echo "</table>";    
                }
                if($found==0 && $found_temp==0)
                {
                    echo "<strong>";
                    echo "No User Found";
                    echo "</strong>";
                }
           
               
              
        }
		
    
     ?> 
	 <br><br><br><br><br><br>

        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
         ?>
