   
   <?php
        
        $link = connect_db();                 
        
        
        $sql = "select * from std_grade where id = '$_SESSION[user_id]'";
        $result = mysql_query($sql, $link);
        $tot=0;
        while($row = mysql_fetch_array($result))
        {
            
            $semester = $row['semester'];
            $entry = $row['startDate'];
            $batch=$row['batch'];
            
             
            
            
            
            $class[$tot] = 'CCNA#';
        
            for($i=5;$i<strlen($semester);$i++){
                $class[$tot] = $class[$tot] . $semester[$i];
           }
        
            $class[$tot] = $class[$tot].'BATCH#';
            for($i=6;$i<strlen($batch);$i++){
                $class[$tot] = $class[$tot] . $batch[$i];
            }
            $sem[$tot] = $semester;
            $Batch[$tot]=$batch;
            if($entry==null)$startDate[$tot]="Not Started";
            else $startDate[$tot]=$entry;
            $tot++;
            
        
        }
       
        
        
        
       
        
   
   
   ?>
   <br><br>
   <fieldset>
   
   <table width="100%" align="left" >
   
      <tr>
              <td><b>My Classes<b></td>
      </tr>
              
      <tr>
              
              <td><br><b>Shahjalal University of Science & Technology(SUST)</b>
              
              <table align ="left" border="1">
                <tr>
                    
                    <td bgcolor="#CCCCCC"><font color="blue"><b>Class Name</b></font></td>
                    <td bgcolor="#CCCCCC"><font color="blue"><b>Start Date</b></font></td>
                    
                </tr>
                <?php
                $flag=0;
                for($i=0;$i<$tot;$i++)
                {
                        $x = $sem[$i];
                
                        echo "<tr>";
                    
                        echo "<td><a href='student_class.php?semester=$x'>$class[$i]</a></td>";
                        echo "<td>$startDate[$i]</td>";
                        echo "</tr>";
                        $flag=1;
                }
                if($flag==0)
                {
                        echo "<tr>";                    
                        echo "<td>Not Assigned</td>";
                        echo "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-</td>";
                        echo "</tr>";
                    
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
        
        //////////////////////////////deplaying message/////////
        
        
        
        $count=0;
        for($i=0;$i<$tot;$i++)
        {
                $sql = "select * from message where (semester='$sem[$i]' AND batch='$Batch[$i]')";
                //echo "sql = $sql";
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
        }        
            
    
  
        if($count>0)
        {
?>        
           <br><br>
           <fieldset>
           
           <table width="100%" align="left" >
           
              <tr>
                      <td><b>Messages From Instructor<b></td>
              </tr>
              <tr>
              <td></td>
              <tr>
                      
              <tr>
                      
                      <td>
                      
                      <table align ="left" border="1">
                        <tr>
                            
                            <td bgcolor="#CCCCCC"><font color="blue"><b>Sender</b></font></td>
                            <td bgcolor="#CCCCCC"><font color="blue"><b>Subject</b></font></td>                   
                            
                        </tr>
                        <?php
                        for($i=0;$i<$count;$i++)
                        {
                                echo "<tr>";
                                echo "<td>$sender[$i]</td>";
                                echo "<td><a href='student_msg_display.php?messageID=$msg_id[$i]'>$subject[$i]</a></td>";
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
        ?>
