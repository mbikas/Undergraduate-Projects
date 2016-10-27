<?php
        include ("include/header.php");
?>

                <!-- menu -->
                <div  id="menu">
                        <ul>
                          
                           <li id="current"><a href="index.php">Home</a></li>
                           <li><a href="information.php">View Informations</a></li>
                           <li><a href="profile.php">My Profile</a></li>
                           <li><a href="search_category.php">Search</a></li>
                           <li><a href="aboutus.php">About Developers</a></li>
                         
                        
                        </ul>
                </div>

                <!-- content-wrap starts here -->
                <div id="content-wrap">

                        <div id="sidebar">



                                <h1>Links</h1>
                                <ul class="sidemenu">

                                  <?php
                                   
                                    echo "<li ><a href='student_benefit.php'>Benefits</a></li>";
                                    echo "<li ><a href='student_instructor.php'>Become an instructor</a></li>";
                                    echo "<li ><a href='student_certificate.php'>CISCO Certificate</a></li>";
                                  
                                  ?>
                                </ul>

                                <h1>Search</h1>

                                <form method="POST" action="student_msg_display.php" class="searchform">
                               <input type="text" name="search" class="search" >
                                                       <input type="submit" value="Search" class="button">
                               <input type="hidden" name="search_form" value="true">
                               </form>



                             <h1>Signout</h1>
                              <div class="left-box">
                              <ul class="sidemenu">
                              <li><a href='logout.php?logout_id=1'>Signout</a></li>
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
              ?>
                        <h1>Message Details</h1>
                        <br><br>
                        
                          <?php
                          $link=connect_db();
                          $sql="select * from message where message_id=$messageID";
                          $result=mysql_query($sql,$link);
                          
                          while($row=mysql_fetch_array($result))
                          {
                            $msg=$row['content'];
                            $subject=$row['subject'];
                            $sender=$row['sender_id'];
                          }
                         ?> 
                           <fieldset>
                        
                          <table bgcolor="#EBF3C6" border=0 width=100%>
                           <tr>
                            <td><b>Message Sender : </b><?php echo "$sender"?></td>
                           </tr>
                           <tr></tr>
                           <tr>
                            <td><b>Subject : </b><?php echo "$subject"?></td>
                           </tr>
                           <tr></tr>
                           <tr>
                            <td><b>Message Content:</b></td>
                           </tr>
                           <tr></tr>
                           <tr>
                            <td border="1"><?php echo "$msg"?></td>
                           </tr>
                          
                        </table>
                        </fieldset>
                        
                <?php
                }
                ?>

     </div>

                <!-- content-wrap ends here -->
                </div>

        <?php
                include ("include/footer.php");
        ?>
