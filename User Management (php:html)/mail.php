<?
        include ("include/header.php")
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                        <?php
                        if($_SESSION['temp_id']!=null)
                        {
                              ?>
                               <li><a href="index.php">Home</a></li>
                               <li><a href="addUser.php">Add Users</a></li>
                               <li><a href="aboutus.php">About Developers</a></li>       
                               <li id="current"><a href="mail.php">Comments</a></li>
							   <li><a href="faq.php">FAQ</a></li>
                               
                              <?php
                        }
                        else if(!isset($_SESSION['user_status']))
                        {
                             echo "<li><a href='index.php'>Home</a></li>";
                             echo "<li><a href='aboutus.php'>About Developers</a></li>";
							 echo "<li id='current'><a href='mail.php'>Comments</a></li>";       
                             echo "<li><a href='faq.php'>FAQ</a></li>";  
                        }
                       
                        else if($_SESSION['user_status']==3)
                         {
                         ?>
                                  <li><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li id="current"><a href="mail.php">Comments</a></li> 
								  
                               

                        <?php
                        }

                         else if($_SESSION['user_status']==2)
                         {
                        ?>
                                 <li><a href="index.php">Home</a></li>
                                 <li><a href="information.php">View Informations</a></li>
                                 <li><a href="profile.php">My Profile</a></li>
                                 <li><a href="search_category.php">Search</a></li>
                                 <li id="current"><a href="mail.php">Comments</a></li>       
								


                        <?php
                        }

                         else if($_SESSION['user_status']==1)
                         {
                        ?>
                                 <li ><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li id="current"><a href="mail.php">Comments</a></li>       
                                 <li><a href="faq.php">FAQ</a></li>

                        <?php
                        }

                         else if($_SESSION['user_status']==0)
                         {
                        ?>
                                <li><a href="index.php">Home</a></li>
                                <li><a href="addUser.php">Add Users</a></li>
                                <li><a href="information.php">View Informations</a></li>
                                <li ><a href="profile.php">My Profile</a></li>
                                <li><a href="search_category.php">Search</a></li>
                                <li><a href="admin.php">Administration</a></li>
                                 <li id="current"><a href="mail.php">Comments</a></li>       
                                 

                        <?php
                        }
                        ?>
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        

                                
                                
                                 <h1>Search</h1>
                                <form method="POST" action="aboutus.php" class="searchform">
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
                                  
                                  echo "<h1>Write to Us</h1><br>";
								  
								  if($form_mail)
								  {
										/* All form fields are automatically passed to the PHP script through the array $HTTP_POST_VARS. */
										$email = $HTTP_POST_VARS['email'];
										$subject = $HTTP_POST_VARS['subject'];
										$message = $HTTP_POST_VARS['message'];
                                         //echo "mail = $email<br>";
                                         //echo "sub = $subject<br>";
                                         //echo "msg = $message<br>";
										/* PHP form validation: the script checks that the Email field contains a valid email address and the Subject field isn't empty. preg_match performs a regular expression match. It's a very powerful PHP function to validate form fields and other strings - see PHP manual for details. */
										if (!preg_match("/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/", $email)) {
										  echo "<h4>Invalid email address</h4>";
										  echo "<a href='javascript:history.back(1);'>Back</a>";
										} elseif ($subject == "") {
										  echo "<h4>No subject</h4>";
										  echo "<a href='javascript:history.back(1);'>Back</a>";
										}

										/* Sends the mail and outputs the "Thank you" string if the mail is successfully sent, or the error string otherwise. */
										elseif (mail($email,$subject,$message)) {
										  echo "<h4>Thank you for sending email</h4>";
										} else 
										
										{
										  echo "<h4>Can't send email to $email</h4>";
										}
								  
								  }
								  else
								  {
	                                  						  
	                                  
	                                
	                            ?>   

								  
								  
									<b>You can give you comments or suggestions or ideas to us.</b><br><br>
									<fieldset>
									<form action = "aboutus.php" method="POST">
				                    <table align="left" width="100%">
				                        <tr>
				                            <td><b>Email Address:</b></td>
				                            <td>bikasbd@yahoo.com</td>
				                        </tr>
				                        <tr>
				                            <td><b>Subject:</b></td>
				                            <td><input type="text" size="52" name="subject"></td>
				                        </tr>
				                        <tr>
				                            <td><b>Comment:</b></td>
				                            <td><textarea cols=40 rows=10 name="message"></textarea></td>
				                        </tr>
				                        <tr>
				                            <td align="center" colspan="2">
	                                          <input type="submit" name="mail" value="Send" class="button">
	                                          <input type="hidden" name="form_mail" value="true">
											  <input type="hidden" name="email" value="bikasbd@yahoo.com">
	                                        </td>
				                        </tr>
				                        
				                    </table>
									</form>
				                </fieldset>
								
								
							<?php
							
								}
							}
							?>
							
							<br><br><br><br><br><br><br><br>

                        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
               ?>

































































































































































































































