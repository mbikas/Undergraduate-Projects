<?php

  include ("include/header.php");
    $tn =$tfn=$tcontact = $tmail =$tpass = $tsex=$tcpass = null;
    $tdegree =$tcontact = $tpadd = $tadd=$tentry=null;
    $tdegree =$tcontact = $tpadd = $tadd=$tbirth=null; 
    $p=1;
    
    
    $bat = $batch;    
        
    
    
    
       
    
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
                                        <?php 
                                        
                                        echo "<li><a href='admin_create_id.php?batch=1'>Student(Batch)</a></li>";
                                        echo "<li><a href='admin_create_id.php?batch=0'>Individual</a></li>";
                                      
                                        ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                 <h1>Search</h1>
                                <form method="POST" action="admin_create_id.php" class="searchform">
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
                $ok=true;
               if($press_individual)
                {
                        $mm=1;
                        if($_POST['Id']==null){
                                $mm=0;
                                echo "<strong><br>Enter ID</strong>";
                        }
                        if($_POST['Pass']==null){
                                $mm=0;
                                echo "<strong><br>Enter Password</strong><br>";
                        }
                        $name = $_POST['Id'];
                        $pass = $_POST['Pass'];
                        $press_individual=false;
                        
                        if($mm==1) {
                                update_id_password();                                
                        }
                        
                        
                }
                if($press_batch)
                {
                        $mm=1;
                        $y = $_POST['year'];
                        if($_POST['student']==null){
                                $mm=0;
                                echo "<strong><br>Enter Number of Students</strong>";
                        }
                        
                        if($y[0]=='Y'){
                                $mm=0;
                                echo "<strong><br>Select Year</strong><br>";
                        }
                        $nstudent = $_POST['student'];
                        $press_batch=false;
                        //$mm=1;
                        if($mm==1) {
                                update_temp_id_password();
                                $nstudent=null;
                                $ok=false;
                        }
                        
                        
                }
                if($batch==1 && $ok==true)
                {
                       
                        $tid = $Id;
                        $tid= $Id;
                        $Pass=$Pass;
                        echo "<h1>Create ID/Password For Students</h1><br>" ;
                        $link = connect_db();
                        $sql = "select * from batch order by name";
                        $result = mysql_query($sql, $link);
                        $tot_batch=0;
                        while($row = mysql_fetch_array($result))
                        {
                                $batches[$tot_batch]=$row['name'];
                                $tot_batch++;
                        }
                       
                ?>        
                        <form action="admin_create_id.php?batch = <?php echo "$bat"; ?>" method = "POST">
                        <table width="75%" align="center">

                        <tr>
                        <td><b>Batch:</b></td>
                        <td><select type="combo" name="batch_name">
                                <?php
                                      for($d=0;$d<$tot_batch;$d++)
                                              echo "<option> $batches[$d] </option>";                                                       
                                ?>
                        </td>
                        </tr>
                        <tr>
                        <td><b>Select Year:</b></td>
                        <td>
                                <select type="combo" name="year">
                                <?php
                                        echo "<option> Year &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </option>";
                                        for($d=2007;$d<2050;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                        </td>
                        <tr>
                        <tr>
                        <td><b>No Of Student:</b></td>
                        <td><input type="text" name="student" size="8" value="<?php echo "$nstudent" ?>"></td>
                        </tr>
                        
                        
                        <tr>
                        <td></td>
                        <input type="hidden" name="press_batch" value="true">
                        <input type="hidden" name="batch" value=<? echo "$bat"; ?> >
                        <td><input type="submit" name="save" value="Create"></td>
                        </tr>
                        </table>
                        </form>
                <?php
                
                }      
           
               if($batch==0)
                {
                        
                        echo "<h1>Create ID/Password For Individual</h1><br>" ;
                ?>        
                        <form action="admin_create_id.php" method = "POST">
                        <table width="75%" align="center">

                        <tr>
                        <td><b>Category:</b></td>
                        <td><select type="combo" name="Cat">
                                <option name="Cat">Teacher</option>
                                <option name="Cat">Employee</option>
                                <option name="Cat">Student</option>
                        </td>
                        </tr>
                        
                        <tr>
                        <td><b>ID:</b></td>
                        <td><input type="text" name="Id" size="20" value="<?php echo "$name" ?>"></td>
                        </tr>
                        
                        <tr>
                        <td><b>Password:</b></td>
                        <td><input type="text" name="Pass" size="20" value="<?php echo "$pass" ?>"></td>
                        </tr>
                        
                        <tr>
                        <td></td>
                        <input type="hidden" name="press_individual" value="true">
                        <input type="hidden" name="batch" value=<? echo "$bat"; ?> >
                        <td><input type="submit" name="save" value="Create"></td>
                        </tr>
                        </table>
                        </form>
                <?php
                
                } 
                 
                
              
        }
    
     ?> 

        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
               
               function update_temp_id_password()
               {
                        $std=$_POST['student'];
                        $batch_no=$_POST['batch_name'];
                        $year=$_POST['year'];
                        //echo "std = $std<br>$year<br>$batch_no<br>";
                        $link = connect_db();
                        
                        $id=$year;
                        for($i=0;$batch_no[$i]!=null;$i++){
                                if($batch_no[$i]>='0' && $batch_no[$i]<='9')
                                {
                                        $id = $id.$batch_no[$i];
                                }                               
                        }
                        
                        $sql = "select id from id_temp where id like '$id%' order by id";
                        $result = mysql_query($sql, $link);
                        $p=0;
                        while( $row = mysql_fetch_array($result))
                        {
                                     
                                //echo "<br>$row[id]";
                                $id=$row[id];
                                $p=1;
                        }
                        echo "<b>Generated Id/Password</b><br>";
                        $start=1;      
                        $tot=0;
                        for($i=0;$i<$std;$i++){
                                if($p==0)$name[$tot] = $id.$start;
                                else $name[$tot] = ++$id;  
                                $passwords[$tot]=rand(1,10000000);
                                $sql = "insert into id_temp values('$name[$tot]','$passwords[$tot]',3)";
                                $result = mysql_query($sql, $link);
                                //echo "<br>$name[$tot] $passwords[$tot]";
                                $start++;
                                $tot++;
                                                        
                        }
                        echo  "<table border='1px '>";                        
                        echo "<tr>";
                        echo "<td><b> ID </b></td>";
                        echo "<td><b> PASSWORD </b></td>";
                        echo "</tr>";
                        for($i=0;$i<$tot;$i++)
                        {
                            $p=$ids[$i];
                            echo "<tr>";
                            echo "<td>$name[$i]</td>";
                            echo "<td> $passwords[$i] </td>";
                            echo "</tr>";
                       
                        }
                        echo "</table><br>"; 
                        
                        
                        
               }
               
               function update_id_password()
               {
                        $cat = $_POST['Cat'];
                        $id =  $_POST['Id'];
                        $pass = $_POST['Pass'];
                        
                        //echo "$cat   && $id && $pass";
                        
                        $link = connect_db();
                        $sql = "select * from user";
                        $result = mysql_query($sql, $link);
                        $i=0;
                        while( $row = mysql_fetch_array($result))
                        {
                                $b[$i++] = $row['id'];                        
                        }
                        $sql = "select * from id_temp";
                        $result = mysql_query($sql, $link);
                        while( $row = mysql_fetch_array($result))
                        {
                                $b[$i++] = $row['id'];                        
                        }
                        $flag=1;
                        for($j=0;$j<$i;$j++)
                        {
                                if($b[$j]==$id)$flag=0;
                        }
                        if($flag==0)echo "<h2>ID alredy exists</h2><br>";
                        else 
                        {
                                if($cat=="Student")$stat=3;
                                else if($cat=="Teacher")$stat=1;
                                else if($cat=="Employee")$stat=2;
                                $sql = "insert into id_temp values('$id','$pass',$stat)";
                                $result = mysql_query($sql, $link);
                                echo "<h2>New ID & Password Created</h2><br>";
                        }
                       
               
               }
         ?>

