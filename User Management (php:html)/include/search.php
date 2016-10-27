<?php
       
       
        $word = $_POST['search'];        
        echo "<h1>Searched Word</h1>";
        echo "<b><font color='blue'>$word</font></b>";
        echo "<h3></h3>";
        $stat=1;
        $p=1;
        $flag=0;
        $got_std=0;
        $got_teacher=0;
        $got_emp=0;
        $link = connect_db();
        $count=0;
        $ids=null;
        $mails=null;
        $names=null;
        $persons=null;
        
        if($show)
        {
                $show=false;
        }
        else
        {
        
        $sql = "select * from students where id='$word'";
        $result = mysql_query($sql, $link);
        $got_std = fetch();
        
        $sql = "select * from students where name like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where fullName like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where stdCat like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where stdType like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where sex like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
               
        $sql = "select * from students where mail like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where batch like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where semester like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where status like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from students where contact like '$word'";
        $result = mysql_query($sql, $link);
        if($got_std==0)fetch();
        
        $sql = "select * from teachers where (id='$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        $stat=1;
        $got_teacher=fetch_teacher();
        
        $sql = "select * from teachers where (name like '$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        $stat=1;
        if($got_teacher==0)fetch_teacher();
        
        $sql = "select * from teachers where (fullName like '$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        $stat=1;
        if($got_teacher==0)fetch_teacher();
        
        $sql = "select * from teachers where (degree like '$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        $stat=1;
        if($got_teacher==0)fetch_teacher();
        
        $sql = "select * from teachers where (sex like '$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        if($got_teacher==0)fetch_teacher();
        
        $sql = "select * from teachers where (mail like '$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        $stat=1;
        if($got_teacher==0)fetch_teacher();
        
              
        $sql = "select * from teachers where (contact like '$word' AND status=1)" ;
        $result = mysql_query($sql, $link);
        if($got_teacher==0)fetch_teacher();
        
        $sql = "select * from teachers where (id='$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        $stat=2;
        $got_emp=fetch_teacher();
        
        $sql = "select * from teachers where (name like '$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        if($got_emp==0)fetch_teacher();
        
        $sql = "select * from teachers where (fullName like '$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        $stat=2;
        if($got_emp==0)fetch_teacher();
        
        $sql = "select * from teachers where (degree like '$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        $stat=2;
        if($got_emp==0)fetch_teacher();
        
        $sql = "select * from teachers where (sex like '$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        $stat=2;
        if($got_emp==0)fetch_teacher();
        
        $sql = "select * from teachers where (mail like '$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        $stat=2;
        if($got_emp==0)fetch_teacher();
        
        $sql = "select * from teachers where (contact like '$word' AND status=2)" ;
        $result = mysql_query($sql, $link);
        $stat=2;
        if($got_emp==0)fetch_teacher();
        
        
        
        
        
        
        if($flag==0)
        { 
                echo "<br><b><font color='red'>No Such Word Found</font></b><br>";
        }
        else
        {
                //echo "COUNT = $count";
                echo "<br><h1>The following items are found<br></h1>";
                echo "<br>";
                echo  "<table border='1px solid red' width='100%'>";                        
                        echo "<tr>";
                        echo "<td><b> ID </b></td>";
                        echo "<td><b> NAME </b></td>";
                        echo "<td><b> E-MAIL </b></td>";
                        echo "</tr>";
                        for($i=0;$i<$count;$i++)
                        {
                            $ID=$ids[$i];
                            $p=$persons[$i];
                            echo "<tr>";
                            echo "<td><a href='search_show.php?person=$p&& ID=$ID'> $ids[$i] </a></td>";
                            echo "<td> <a href='search_show.php?person=$p&& ID=$ID'> $names[$i] </a></td>";
                            echo "<td> <a href='search_show.php?person=$p&& ID=$ID'> $mails[$i] </a></td>";
                            echo "</tr>";
                       
                        }
                    echo "</table>";  
        }
                  
        
}
    ?>
    <?php
    
    function fetch_teacher()
        {
                $found=0;
                global $tid,$tdegree,$stat,$count,$ids,$mails,$names,$persons;
                global $tn,$tfn,$tcontact,$tmail,$tpass,$tsex;
                global $tcontact,$tpadd,$tadd;
                global $tcontact,$tpadd;
                 global $row,$result,$flag,$p;
                while($row = mysql_fetch_array($result))
                {       
                        if($stat==1)$persons[$count]=1;
                        else $persons[$count]=2;
                        $persons[$count]=3;
                        $mails[$count]=$row['mail'];
                        $ids[$count]=$row['id'];
                        $names[$count]=$row['fullName'];
                        $count++;
                        $flag=1;
                        $found=1;             
                }  
                return $found;
        
        }
        
        
        function fetch()
        {
                $found=0;
                global $row,$result,$flag,$p,$count,$ids,$mails,$names,$persons;
                global $tid;
                global $tn,$tfn,$tcontact,$tmail,$tsex,$tcpass;
                global $tbatch,$tcontact,$tpadd,$tadd,$tentry;
                global $tsem,$tstatus,$tteacher;
                global $ttype,$tcat,$tcontact,$tpadd,$tadd,$tbirth;
                while($row = mysql_fetch_array($result))
                {       
                        $persons[$count]=3;
                        $mails[$count]=$row['mail'];
                        $ids[$count]=$row['id'];
                        $names[$count]=$row['fullName'];
                        $count++;
                        $flag=1;
                        $found=1;
                }  
                return $found;
        
        }               
                     
        
?>

   

