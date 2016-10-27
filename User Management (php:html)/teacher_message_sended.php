<?php
        include ("include/header_index.php");
         $link = connect_db();
        
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                         <?php
                          if($_SESSION['user_status']==1)
                          {
                         ?>
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                        
                         <?php
                         }
                         
                         else if($_SESSION['user_status']==0)
                          {
                          
                         ?>
                                
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
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
                                       <li ><a href='message_send.php'>Send Message to Students</a></li>
                                       <li ><a href='teacher_message_sended.php'>Sended Messages</a></li>
                                </ul>        
                                
                                <h1>Search</h1>        
                                
                                <form method="POST" action="teacher_message_sended.php" class="searchform">
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
            echo "<h1>Sended Messages to Students</h1>";
            
            $p=0;
            $show=true;
            
            if($value==true)
            {
            
              $show=false;
             
              //for delete
              if($delete==1)
              {
                 echo "<br><br>";
                $sql = "delete from message where message_id=$messageID";
                mysql_query($sql, $link);
                echo "<b><font color='blue'>Message have been successfully Deleted</font><b>" ; 
                $p=1;
              }
              //for show
              else
              {
                   
              ?>
                    
                    <p>
                    <b><font color="blue"> message Details</font></b>
                    </p>
                          <fieldset>
                        
                          <table bgcolor="#EBF3C6" border=0 width=100%>
                           
                           <tr>
                            <td><b>Subject : </b><?php echo "$Subject"?></td>
                           </tr>
                           <tr></tr>
                           <tr>
                            <td><b>Message Content:</b></td>
                           </tr>
                           <tr></tr>
                           <tr>
                            <td border="1"><?php echo "$Msg"?></td>
                           </tr>
                          
                        </table>
                        </fieldset>
            <?php  
              }
              
              $value=false;
              $show=false;
            }
           
            if($show==true || $p==1)
            {
        
               
               
                $id = $_SESSION['user_id'];
                $count=0;
                $sql = "select * from message where (sender_id='$id')";
                $result = mysql_query($sql, $link);
                
                while($row = mysql_fetch_array($result))
                {
                    $msg_id[$count] = $row['message_id'];
                    $sender[$count] = $row['sender_id'];
                    $subject[$count] = $row['subject'];
                    $msg[$count]=$row['content'];
                    
                    //echo "<br>$sender[$count]";
                    //echo "<br>$subject[$count]";
                    //echo "<br>$msg[$count]";
                    $count++;
                }  
                
            
    
  
        if($count>0)
        {
?>        
           <br><br>
           <fieldset>
           
           <table width="100%" align="left" >
           
              <tr>
              <td><b>Messages<b></td>
              <tr>
              
                      
              <tr>
                      
                      <td>
                      
                      <table align ="left" border="1">
                        <tr>
                            
                            <td bgcolor="#CCCCCC"><font color="blue"><b>Subject</b></font></td>
                            <td bgcolor="#CCCCCC"><font color="blue"><b>Delete</b></font></td>                   
                            
                        </tr>
                        <?php
                        for($i=0;$i<$count;$i++)
                        {
                                echo "<tr>";
                                echo "<td><a href='teacher_message_sended.php?messageID=$msg_id[$i]&& value=true&& delete=0&& Subject=$subject[$i]&& Msg=$msg[$i]'>$subject[$i]</a></td>";
                                echo "<td><a href='teacher_message_sended.php?messageID=$msg_id[$i]&& value=true&& delete=1'>Delete</a></td>";
                                echo "</tr>";
                                $flag=1;
                        }                                                
                        ?>
                   
                       
                      </table>
                      
                      </td>
                    
              </tr>
              <tr>
                      <td><br><br></td>
              </tr>
              
            </table>
            </fieldset>
        <?php
        }
        else
        {
          echo "<br>";
          echo "<b><font color='black'>No message Found</font></b>";
        
        }
        ?>
   
   <?php
     }
   }
   ?>

    
          

     </div>
    </div>
    
         
         
                                        
    <?php
            include ("include/footer.php");
            
                
    ?>
