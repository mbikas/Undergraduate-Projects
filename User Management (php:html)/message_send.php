<?php
        include ("include/header_index.php");
        $archive_dir = "./files";
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
                                
                                <form method="POST" action="message_send.php" class="searchform">
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
        
            echo "<h1>Send Message to Students</h1>";
            
              if($upload ) 
              {
                   //echo "Bikas";
                   $gotfile=upload_file();
                   if($gotfile==1){
                   $filename = basename($userfile_name);
                   $fp = fopen("$archive_dir/$filename","r");
                   if(!fp) die ("can't open");
                   $data = fread($fp,200000000);
                   $message_content=str_replace(chr(13).chr(10).chr(39).chr(38),"<br>",addslashes($data));
                   fclose($fp);
                   }
                   $msg=null;
                   //echo "$message_content";
                   for($i=0;$i<strlen($message_content);$i++)
                   {
                     $msg = $msg. $message_content[$i];
                   }
                   //echo "msg = $msg";
              }

          if($form_give_message)
          {
             
             
             $link=connect_db();
             $msgs=null;
              
             $teacher_id = $_SESSION['user_id'];
             $sub = $_POST['subject'];
             $className=$_POST['class_name'];
             $msgs =$_POST['message'];
             //echo "<br>$teacher_id";
             //echo "<br>$sub";
             //echo "<br>$className";
             //echo "<br>$msgs";
             $flag=1;
             if($className==null)
             {
                 echo "<br><font color='red'>Select a Class</font>";
                 $flag=0;
                 
             }
             if($msgs==null)
             {
                 echo "<br><font color='red'>Write the message</font>";
                 $flag=0;                 
             }
             if($flag==1)
             {
                 $semester="CCNA-";
                 for($i=0;$i<strlen($className);$i++)
                 {
                   if($className[$i]>='1' && $className[$i]<='4')
                   {      $semester = $semester.$className[$i];
                          break;
                   }
                 }
                 $batch="Batch ";
                 for($j=$i+2;$j<strlen($className);$j++)
                 {
                   if($className[$j]>='0' && $className[$j]<='9')
                                  $batch = $batch.$className[$j];                  
                 }
                 //echo "<br>sem = $semester";
                 //echo "<br>batch=$batch";
                 
                  $sql = "select message_id from message where (semester='$semester' AND batch='$batch')";
                  $result = mysql_query($sql, $link);
                  $msgId=0;
                  while($row = mysql_fetch_array($result))
                  {
                     $msgId=$row['message_id'];                                
                  }
                   $msgId++;
                  // echo "$msgId";
                  $sql = "insert into message values($msgId,'$teacher_id','$sub','$msgs','$semester','$batch')";
                  mysql_query($sql, $link);
                  
                  echo "<br><br><b><font color='blue'>Your message have been sended successfully</font></b><br>";
              
             
             
             }
                 
             
             
          }          
    
 
?>
       
         <br><br>
         <fieldset>
         <form name="form" method="POST" enctype="multipart/form-data" action="message_send.php">
          <input type="hidden" name="form_give_message" value="true">
           
            
                    
       
         <table>    
           
              <tr>        
               <td>Class :</td>
               <td><select type="combo" name="class_name" >
                                  <?php 
                                   $link = connect_db();
                                   $sql = "select * from teacher_batch where (id = '$_SESSION[user_id]' AND finished=0)";
                                   $result = mysql_query($sql, $link);
                                   $tot=0;
                                   while($row = mysql_fetch_array($result))
                                   {
                                       
                                       $semester = $row['semester'];
                                       $batch=$row['batch'];                              
                                       $class[$tot] = 'CCNA#';                                   
                                       for($i=5;$i<strlen($semester);$i++){
                                           $class[$tot] = $class[$tot] . $semester[$i];
                                      }                                   
                                       $class[$tot] = $class[$tot].'BATCH#';
                                       for($i=6;$i<strlen($batch);$i++){
                                           $class[$tot] = $class[$tot] . $batch[$i];
                                       }
                                       $tot++;                                      
                                   
                                   }
                                  for($j=0;$j<$tot;$j++){                            
                                  echo "<option>$class[$j]</option>";
                                  }
                                  ?>
                                  </select></td>
              </tr>  
              
             <tr>
               <td>Subject :</td>
               <td><input type="text" name="subject" size=39></td>
             </tr>
            
             <tr>
               <td>Message :</td>
               <td><textarea name="message" rows="5" cols="30"><?php echo "$msg";?></textarea></td>
             </tr>
              <tr>
              <td></td>
              </tr>       
             <tr>
              <br>
              <td></td><td><input type="submit" value="Send Message" class="button"></td>
             </tr>
        </table>
        </form>
       <form name="form" method="POST" enctype="multipart/form-data" action="message_send.php">
      
       <table>
           <tr>
               <td>Include File (optional):</td>
                   <td>
                   <input type="file" name="userfile" size="30">
                </td>
                <td><td>
                
           </tr>
           <tr>
              <td>&nbsp;</td>
              <td><input type="submit" value="Upload" class="button"></td>
              <td><input type="hidden" name = "upload" value="true" ></td>
              <td></td>
          </tr>
       </table>
       </form>
       
   </fieldset>
   
   <?php
   }
   ?>

    
          

     </div>
    </div>
    
         
         
                                        
    <?php
            include ("include/footer.php");
             function upload_file() {
                global $userfile, $userfile_name, $userfile_size, 
                      $userfile_type, $archive_dir, $WINDIR;

                if(isset($WINDIR)) $userfile = str_replace("\\\\","\\", $userfile);
                
                $filename = basename($userfile_name);
                
                if($userfile_size <= 0) {}
                else { $fileposted=1;}

                if(!@copy($userfile, "$archive_dir/$filename")){}
                 
                return $fileposted;
                 
                }
                
    ?>
