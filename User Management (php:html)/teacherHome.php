   
   <?php
        
        $link = connect_db();                 
        
        
        $sql = "select * from teacher_batch where (id = '$_SESSION[user_id]' AND finished=0)";
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
            $batches[$tot] = $batch;
            if($entry==null)$startDate[$tot]="Not Started";
            else $startDate[$tot]=$entry;
            $tot++;
            
        
        }
       
        
        
        
       
        
   
   
   ?>
   <br><br>
   <fieldset>
   
   <table width="100%" align="left" >
   
      <tr>
              <td  style="BORDER-RIGHT: black; PADDING-RIGHT: 1.5pt; BORDER-TOP: medium none; PADDING-LEFT: 1.5pt; PADDING-BOTTOM: 0in; BORDER-LEFT: medium none; WIDTH: 79px; PADDING-TOP: 0in; BORDER-BOTTOM: black 1px solid; HEIGHT: 19px" 
                vAlign=top><b>My Classes<b></td>
      </tr>
              
      <tr>
              
              <td><br><b>Shahjalal University of Science & Technology(SUST)</b>
              
              <table align ="left" border="line">
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
                    
                        echo "<td><a href='teacher_class.php?semester=$x&& batch=$batches[$i]'>$class[$i]</a></td>";
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
    
