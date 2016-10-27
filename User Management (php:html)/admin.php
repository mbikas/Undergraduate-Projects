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
                                        echo "<li><a href='admin_create_id.php'>Create ID & Password</a></li>";
                                        echo "<li><a href='admin.php?name=$n3'>Assign Teacher For Batch</a></li>";
                                        echo "<li><a href='admin_id.php?name=$n3'>Sec ID & Password</a></li>";
                                        ?>
                                        </ul>      
                                
                                
                               
                                </div>
                        
                                
                                 <h1>Search</h1>
                                <form method="POST" action="admin.php" class="searchform">
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
                        
                             
                                       
                if($press)
                {
                        if($_POST['ids']==null)
                                echo "<strong><br>Enter Batch Name</strong><br>";
                        else {
                                update_batch();
                        }
                        $press=false;
                        $name = $temp;
                }
                if($press1)
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
                        if($mm==1) {
                                update_id_password();
                        }
                        
                        //echo "$_POST[Cat]Bikas<br>";
                        $press1=false;
                        $name = $temp;
                }
                if($press_assign)
                {
                       
                        
                        $mm=1;
                        $day = $_POST['start_day'];
                        $month = $_POST['start_month'];
                        $year = $_POST['start_year'];
                        $p = check_valid_date($day,$month,$year);
                        if($p==0){
                                $mm=0;
                                echo "<strong><br>Start Date Error</strong>";
                        }
                        
                        $day = $_POST['end_day'];
                        $month = $_POST['end_month'];
                        $year = $_POST['end_year'];
                        $p = check_valid_date($day,$month,$year);
                        if($p==0){
                                $mm=0;
                                echo "<strong><br>End Date Error</strong>";
                        }       
                        if(check_diff()==0)
                        {
                                $mm=0;
                                echo "<strong><br>Start Date cannot be greater than End Date</strong>";
                                
                        }
                        if($mm==1) {
                               
                                assign_teacher();
                        }
                        
                        //echo "$_POST[Cat]Bikas<br>";
                        $press_assign=false;
                        $name = $temp;
                        
                }
                // code begins here
                if($name=="batch")
                {
                        $tid = $ids;
                        echo "<h1>Create Batch</h1><br>" ;
                ?>        
                        <form action="admin.php" method = "POST">
                        <table width="75%" align="center">

                        <tr>
                        <td><b>Batch Name:</b></td>
                        <td><input type="text" name="ids" size="20" value="<?php echo "$tid" ?>"></td>
                        </tr>
                        
                        <tr>
                        <td></td>
                        <input type="hidden" name="press" value="true">
                        <input type="hidden" name="temp" value=<? echo "$name"; ?>>
                        <td><input type="submit" name="save" value="Create"></td>
                        </tr>
                        </table>
                        </form>
                
                <?php
                }
                else if($name=="id")
                {
                        $tid = $Id;
                        $tid= $Id;
                        $Pass=$Pass;
                        echo "<h1>Create ID and Password</h1><br>" ;
                ?>        
                        <form action="admin.php" method = "POST">
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
                        <td><input type="text" name="Id" size="20" value="<?php echo "$tid" ?>"></td>
                        </tr>
                        
                        <tr>
                        <td><b>Password:</b></td>
                        <td><input type="text" name="Pass" size="20" value="<?php echo "$tpass" ?>"></td>
                        </tr>
                        
                        <tr>
                        <td></td>
                        <input type="hidden" name="press1" value="true">
                        <input type="hidden" name="temp" value=<? echo "$name"; ?>>
                        <td><input type="submit" name="save" value="Create"></td>
                        </tr>
                        </table>
                        </form>
                <?php
                
                }   
                else if($name=="assign")
                {
                        
                        $link = connect_db();
                        $sql = "select * from teachers where ( status=1 OR status=0 ) order by fullName";
                        $result = mysql_query($sql, $link);
                        $tot=0;
                        while($row = mysql_fetch_array($result))
                        {
                                $teachers[$tot]=$row['fullName'];
                                $teacher_id[$tot]=$row['id'];
                                $tot++;
                        }
                        $sql = "select * from batch order by name";
                        $result = mysql_query($sql, $link);
                        $tot_batch=0;
                        while($row = mysql_fetch_array($result))
                        {
                                $batches[$tot_batch]=$row['name'];
                                $tot_batch++;
                        }
                       
                        
                        $tid = $Id;
                        $tid= $Id;
                        $Pass=$Pass;
                        echo "<h1>Assign Teacher</h1><br>" ;
                ?>        
                        <form action="admin.php" method = "POST">
                        <table width="75%" align="center">

                        <tr>
                        <td><b>Primary Instractor:</b></td>
                        <td><select type="combo" name="teacher">
                                <?php
                                        
                                        for($d=0;$d<$tot;$d++)
                                              echo "<option> $teacher_id[$d] </option>";                                                       
                                ?>
                        </td>
                        </tr>
                        <tr>
                        <td><b>Secondary Instractor:</b></td>
                        <td><select type="combo" name="teacher2">
                                <?php
                                        
                                        for($d=0;$d<$tot;$d++)
                                              echo "<option> $teacher_id[$d] </option>";                                                       
                                ?>
                        </td>
                        </tr>
                        <tr>
                        <td><b>Batch:</b></td>
                        <td><select type="combo" name="batch">
                              <?php
                                        
                                        for($d=0;$d<$tot_batch;$d++)
                                              echo "<option> $batches[$d] </option>";                                                       
                                ?>
                        </td>
                        </tr>
                        
                        <tr>
                        <td><b>Course:</b></td>
                        <td><select type="combo" name="course">
                                <option name="course">CCNA-1</option>
                                <option name="course">CCNA-2</option>
                                <option name="course">CCNA-3</option>
                                <option name="course">CCNA-4</option>
                        </td>
                        </tr>
                        <tr>
                        <td><b>Start Date:</b></td>
                        <td>
                                <select type="combo" name="start_day" >
                                <?php
                                        echo "<option> Day </option>";
                                        for($d=1;$d<32;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                                <select type="combo" name="start_month">
                                <?php
                                        echo "<option> Month </option>";
                                        for($m=1;$m<13;$m++)
                                              echo "<option> $m </option>";                                                       
                                ?>
                                </select>
                                <select type="combo" name="start_year">
                                <?php
                                        echo "<option> Year </option>";
                                        for($d=2007;$d<2020;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                        </td>
                        </tr>
                        <tr>
                        <td><b>End Date:</b></td>
                        <td>
                        <select type="combo" name="end_day">
                                <?php
                                        echo "<option> Day </option>";
                                        for($d=1;$d<32;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                                <select type="combo" name="end_month">
                                <?php
                                        echo "<option> Month </option>";
                                        for($m=1;$m<13;$m++)
                                              echo "<option> $m </option>";                                                       
                                ?>
                                </select>
                                <select type="combo" name="end_year">
                                <?php
                                        echo "<option> Year </option>";
                                        for($d=2007;$d<2020;$d++)
                                              echo "<option> $d </option>";                                                       
                                ?>
                                </select>
                        </td>
                        </tr>
                        <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        </tr>
                        
                        
                        
                        <tr>
                        <td></td>
                        <input type="hidden" name="press_assign" value="true">
                        <input type="hidden" name="temp" value=<? echo "$name"; ?>>
                        <td><input type="submit" name="save" value="Assign"></td>
                        </tr>
                        </table>
                        </form>
                <?php
                
                }
                else
                     echo "<h2>Select category</h2>";   
                
                //code ends here 
                                        
                                
                            
        }
        
        ?>   

        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
               function update_batch()
               {
                        $bat = $_POST['ids'];
                        $link = connect_db();
                        $sql = "select * from batch";
                        $result = mysql_query($sql, $link);
                        $i=0;
                        while( $row = mysql_fetch_array($result))
                        {
                                $b[$i++] = $row['name'];                        
                        }
                        $flag=1;
                        for($j=0;$j<$i;$j++)
                        {
                                if($b[$j]==$bat)$flag=0;
                        }
                        if($flag==0)echo "<h2>Batch Name alredy exists</h2><br>";
                        else 
                        {
                                $sql = "insert into batch values('$bat')";
                                $result = mysql_query($sql, $link);
                                echo "<h2>New Batch Created</h2><br>";
                        }
                       
               
               }
               
               function assign_teacher()
               {
                        $teacher = $_POST['teacher'];
                        $teacher2 = $_POST['teacher2'];
                        $batch = $_POST['batch'];
                        $course = $_POST['course'];
                        $link = connect_db();
                        
                        
                        $entryDate=$_POST['start_day'].'/'.$_POST['start_month'].'/'.$_POST['start_year'];
                        $endDate=$_POST['end_day'].'/'.$_POST['end_month'].'/'.$_POST['end_year'];
                        //echo "teacher id = $teacher";
                        $sql = "select fullName from teachers where id='$teacher' ";
                        $result = mysql_query($sql, $link);
                        while( $row = mysql_fetch_array($result))
                        {
                                $teacher_name = $row['fullName'];
                        }
                        
                        $p=0;
                        $sql = "select * from teacher_batch where ( id='$teacher' AND batch='$batch' AND semester='$course') ";
                        $result = mysql_query($sql, $link);
                        while( $row = mysql_fetch_array($result))
                        {
                                $p=1;
                                break;
                        }
                           
                        if($p==1)
                        {
                                $sql = "delete from teacher_batch where ( id='$teacher' AND batch='$batch' AND semester='$course') ";
                                $result = mysql_query($sql, $link); 
                        }
                        $blank=null;
                        $sql = "insert into teacher_batch values('$teacher','$teacher_name','$teacher2','$batch','$course','$entryDate','$endDate','$blank','$blank',0)";
                        $result = mysql_query($sql, $link); 
                        
                        
                        
                        //echo "name = $teacher_name";
                        
                        $sql = "update std_grade set instructor = '$teacher' where (semester='$course' AND batch='$batch')";
                        $result = mysql_query($sql, $link); 
                         $sql = "update std_grade set secondaryInstructor = '$teacher2' where (semester='$course' AND batch='$batch')";
                        $result = mysql_query($sql, $link); 
                        
                        $sql = "update std_grade set startDate = '$entryDate' where (semester='$course' AND batch='$batch')";
                        $result = mysql_query($sql, $link); 
                        
                        $sql = "update std_grade set endDate = '$endDate' where (semester='$course' AND batch='$batch')";
                        $result = mysql_query($sql, $link); 
                        
                        
                        
                                                        
                        
                        
                        echo "<b><font color='blue'>Information have been updated</font></b>";
                                
                        
                       
               
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
               
               function check_valid_date($d,$m,$y)
               {
                   
                   if($m=="Month")return 0;
                   if($d=="Day")return 0;
                   if($y=="Year")return 0;
                   if( $m==2 )
                   {
                        if($y % 4==0 && ($y%400==0 || $y%100!=0) )
                        {
                           if($d>29)return 0;
                        }
                        else
                        {
                                if($d>28)return 0;
                        }
                   }
                  
                   if( ($m==4 || $m==6 || $m==9 || $m==11) && ($d==31) ) return 0;
                   return 1;
               
               }
               
               function  check_diff()
               {
                $y2 = $_POST['end_year'];
                $y1 = $_POST['start_year'];
                if($y1>$y2)return 0;
                if($y1<$y2)return 1;
                $m2 = $_POST['end_month'];
                $m1 = $_POST['start_month'];
                if($m1>$m2)return 0;
                $d2 = $_POST['end_day'];
                $d1 = $_POST['start_day'];
                if($d1>$d2)return 0;
                
                return 1;
               
               
               }
               
               
               
               
               ?>
