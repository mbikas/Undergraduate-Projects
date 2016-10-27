<?
        include ("include/header.php");
        $link = connect_db();
        $tword=null;
            
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
               <li><a href="profile.php">My Profile</a></li>
               <li  id="current"><a href="search_category.php">Search</a></li>
               <li><a href="aboutus.php">About Developers</a></li>

      <?php
      }

       if($_SESSION['user_status']==2)
       {
      ?>
               <li><a href="index.php">Home</a></li>
               <li><a href="information.php">View Informations</a></li>
               <li><a href="profile.php">My Profile</a></li>
               <li  id="current"><a href="search_category.php">Search</a></li>
               <li><a href="aboutus.php">About Developers</a></li>


      <?php
      }

       if($_SESSION['user_status']==1)
       {
      ?>
               <li><a href="index.php">Home</a></li>
               <li><a href="information.php">View Informations</a></li>
               <li><a href="profile.php">My Profile</a></li>
               <li  id="current"><a href="search_category.php">Search</a></li>
               <li><a href="aboutus.php">About Developers</a></li>
      <?php
      }

       if($_SESSION['user_status']==0)
       {
      ?>
                                 <li><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li ><a href="profile.php">My Profile</a></li>
                                  <li id="current"><a href="search_category.php">Search</a></li>
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
                                                  $n1="Student";
                                                  $n2="Teacher";
                                                  $n3="Employee";
                                                  
                                                echo "<li><a href='search.php?name=$n1'>Student</a></li>";
                                                echo "<li><a href='search.php?name=$n2'>Teacher</a></li>";
                                                echo "<li><a href='search.php?name=$n3'>Employee</a></li>";
                                            ?>
                                        </ul>  
                               
                                </div>
                        
                                
                                
                                <h1>Search</h1>
                                <form method="POST" action="search.php" class="searchform">
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
           
              
                $n = $name;
                if($search1_form)$n = $catName;
                
                                 
                $tword = $word;
                echo "<h1>$n Search</h1><br>";
               
                echo "<b>Select Search Category And Type Search Word</b>";
                
              ?>
                  <fieldset>
                    <form action="search.php?" method="POST">
                        <table width="75%" align="center">
                                 
                        <tr>
                          <td><select type="combo" name="searchCat">
                            <?php
                               
                              if($catName=="Student" || $name==Student)                               
                              { $stdcat = array("Select....","ID","User Name","Full Name","Batch","Student Type","Student Category","Email","Contact No","Semester","Status");
                                for($i=0;$i<11;$i++){
                                  echo "<option>$stdcat[$i]</option>";
                                }
                              }
                              else                               
                              { $stdcat = array("Select....","ID","User Name","Full Name","Degree","Email","Contact No");
                                for($i=0;$i<7;$i++){
                                  echo "<option>$stdcat[$i]</option>";
                                }
                              }
                            ?>
                          </td>
                          <td><input type="text" name="word" value= "" size="20"></td>
                          <td>
                              <input type="hidden" name="search1_form" value="true">                                
                              <input type="submit" name = "Search" value="Search" class="button">
                              <input type="hidden" name="catName" value="<?php echo "$n"?>">                                  
                          </td>                          
                        </tr>
                        </table>
                      </form>
                  </fieldset>           
                  
            <?php  
              
              ///////////code for students when search button pressed////
              if($search1_form)
              {
                $cat = $_POST['searchCat'];
                //echo "$cat";
                //echo "<br>$tword";
                
                
                
                        $link = connect_db();
                        
                        echo "<h3>Searched Word</h3>";
                        echo "<b><font color='blue'>$cat : $tword</font></b>";
                        echo "<h3></h3>";
                        
                        if($catName=="Student")
                        {
                       
                         $ok=true;
                          if($cat=="ID")
                            $sql = "select * from students where id like '%$tword%'";
                          else if($cat=="User Name")
                            $sql = "select * from students where name like (upper('%$tword%'))";
                        else if($cat=="Full Name")
                            $sql = "select * from students where fullName like (upper('%$tword%'))";
                         else if($cat=="Student Type")
                            $sql = "select * from students where stdType like '%$tword%'";
                        else if($cat=="Batch")
                            $sql = "select * from students where batch like '%$tword%'";
                          else if($cat=="Semester")
                            $sql = "select * from students where semester like (upper('%$tword%'))";
                          else if($cat=="Status")
                            $sql = "select * from students where status like '%$tword%'";
                         else if($cat=="Contact No")
                            $sql = "select * from students where contact = '$tword'";
                        else if($cat=="Student Category")
                            $sql = "select * from students where stdCat like '%$tword%'";
                        else if($cat=="Email")
                            $sql = "select * from students where mail like '%$tword%'";
                        else 
                        {
                             echo "<br><b><font color='red'>Select Category</font></b>";
                             $ok=false;
                        }
                        if($tword==null)
                        {
                                echo "<br><b><font color='red'>Enter Search Word</font></b>";
                                $ok=false;
                        }
                                                
                        if($ok)
                        {                        
                          $result = mysql_query($sql, $link);
                          $flag=0;
                          $p=1;
                          while($row = mysql_fetch_array($result))
                          {
                                $tid = $row['id'];
                                $tn = $row['name'];
                                $tfn = $row['fullName'];
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
                                $flag=1;
                                 if($p==1){
                                      echo "<br><h1>The Found Items are listed below<br></h1>";
                                      $p=0;
                                  }
                                  echo "<br>";
                                  set_value_students();
                          }
                        
                         
                          if($flag==0)
                            echo "<b><font color='red'>No Such Word Found</font></b>";
                        }
                        
                        
                }
                
                  
                else
                {
                  $ok=true;
                  if($catName=="Teacher")$stat=1;
                  else $stat=2;
                  if($cat=="ID")
                      $sql = "select * from teachers where (id ='$tword' AND status=$stat)";
                  else if($cat=="User Name")
                    $sql = "select * from teachers where ( name like '%$tword%' AND status=$stat)";
                  else if($cat=="Full Name")
                    $sql = "select * from teachers where ( fullName like '%$tword%' AND status=$stat)";
                  else if($cat=="Degree")
                    $sql = "select * from teachers where ( degree like '%$tword%' AND status=$stat)";
                  else if($cat=="Email")
                    $sql = "select * from teachers where ( mail like '%$tword%' AND status=$stat)";
                  else if($cat=="Contact No")
                    $sql = "select * from teachers where (contact ='%$tword%' AND status=$stat)";
                  
                  else 
                  {
                             echo "<br><b><font color='red'>Select Category</font></b>";
                             $ok=false;
                  }
                   if($tword==null)
                   {
                                echo "<br><b><font color='red'>Enter Search Word</font></b>";
                                $ok=false;
                   }
                            
                   echo "$sql";         
                  
                  if($ok)
                  {
                    
                          $result = mysql_query($sql, $link);
                          $flag=0;
                          $p=1;
                          while($row = mysql_fetch_array($result))
                          {
                                    $tid = $row['id'];
                                    $tn = $row['name'];
                                    $tfn = $row['fullName'];
                                    $tpass=$row['password'];
                                    $tdegree = $row['degree'];
                                    $tadd = $row['presentAdd'];
                                    $tpadd = $row['permanentAdd'];
                                    $tsex = $row['sex'];
                                    $tmail = $row['mail'];
                                    $tcontact = $row['contact']; 
                                    $flag=1;
                                    if($p==1){
                                      echo "<br><h1>The Found Items are listed below<br></h1>";
                                      $p=0;
                                    }
                                    echo "<br>";
                                    set_value_teachers(); 
                                    
                          }
                        
                         
                          if($flag==0)
                           echo "<b><font color='red'>No Such Word Found</font></b>"; 
                    }
                
                     
                
                }
              }
            
        }
            
            ?>
            
        </div>
    </div>
        
     <?php
      include ("include/footer.php");
                     
     function set_value_students()
      {
            global $tid;
            global $tn,$tfn,$tcontact,$tmail,$tsex,$tcpass;
            global $tbatch,$tcontact,$tpadd,$tadd,$tentry;
            global $tsem,$tstatus,$tteacher;
            global $ttype,$tcat,$tcontact,$tpadd,$tadd,$tbirth;
       ?>           
                     <fieldset>                    
                     <table width="75%" align="center">
                     
                        <tr>
                                <td><b>ID:</b></td>
                                <td><?php echo "$tid" ?></td>
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
      
      
      function set_value_teachers()
      {
            global $tid,$tdegree;
            global $tn,$tfn,$tcontact,$tmail,$tpass,$tsex;
            global $tcontact,$tpadd,$tadd;
            global $tcontact,$tpadd;
    ?>           
                     <fieldset>                    
                     <table width="75%" align="center">
                     
                        <tr>
                                <td><b>ID:</b></td>
                                <td><?php echo "$tid" ?></td>
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
                                <td><b>Degree:</b></td>
                                <td><?php echo "$tdegree" ?></td>
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
                                <td><b>E-Mail:</b></td>
                                <td><?php echo "$tmail" ?></td>
                        </tr>
                        <tr>
                                <td><b>Contact No:</b></td>
                                <td><?php echo "$tcontact" ?></td>
                        </tr>                        

                        </table>
                    </fieldset>
            
    <?php  
      
        }
    ?>

