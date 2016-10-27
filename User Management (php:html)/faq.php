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
							   <li><a href="mail.php">Comments</a></li>  
							   <li  id="current"><a href="faq.php">FAQ</a></li>
                               
                              <?php
                        }
                        else if(!isset($_SESSION['user_status']))
                        {
                             echo "<li><a href='index.php'>Home</a></li>";
                             echo "<li><a href='aboutus.php'>About Developers</a></li>";
							 echo "<li><a href='mail.php'>Comments</a></li>";
							 echo "<li  id='current'><a href='faq.php'>FAQ</a></li>";
                        }
                       
                        else if($_SESSION['user_status']==3)
                         {
                         ?>
                                  <li><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
								  <li><a href="mail.php">Comments</a></li>
								  <li  id="current"><a href="faq.php">FAQ</a></li>

                        <?php
                        }

                         else if($_SESSION['user_status']==2)
                         {
                        ?>
                                 <li><a href="index.php">Home</a></li>
                                 <li><a href="information.php">View Informations</a></li>
                                 <li><a href="profile.php">My Profile</a></li>
                                 <li><a href="search_category.php">Search</a></li>
                                 <li><a href="aboutus.php">About Developers</a></li>
								 <li><a href="mail.php">Comments</a></li>
								 <li  id="current"><a href="faq.php">FAQ</a></li>


                        <?php
                        }

                         else if($_SESSION['user_status']==1)
                         {
                        ?>
                                 <li ><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="mail.php">Comments</a></li>
								  <li  id="current"><a href="faq.php">FAQ</a></li>

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
                                <li  id="current"><a href="faq.php">FAQ</a></li>

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
                                  
                                  echo "<h1>Most Popular Questions</h1><br>";
								    $questions = array('For whom this site is useful?','What is CCNA?','What Academic qualification is required to admit in CCNA?','What is the Financial requirements for admitting CCNA?','What are the admission procedures?','What are the papers needed to get admit?','What is the duration of the course?','When does the session starts?','What benefit I will get after admitting in CCNA?','Whom will I knock for further information?');
									$ans[0]="The people who are associated with Cisco CCNA Program.";
									$ans[1]="CCNA courses are designed for people looking to gain professional certification which is recognised world wide. Many of the world's networks use Cisco equipment and technology. This course will be a good starting point for those what wanted a career in networks and networking.";
									$ans[2]="You will need the S.S.C and H.S.C certificates and English proficiency ceritificate and Computer lieracy cetificate or if you are a student of SUST you can be admitted in Special Batch.";
									$ans[3]="For SUST students Six Thousands(6000/=) and for ousiders Ten Thousands.";
									$ans[4]="First you have to contact with the office attendent to collect the admission form. An examination will be held on the due date that will be mentioned in the form and finally the qualified students can admit in CCNA.";
									$ans[5]="If You are a student of SUST you just need the confirmation, otherwise you need S.S.C and H.S.C certificates and English proficiency ceritificate and Computer lieracy cetificate.";
									$ans[6]="CCNA is one year couse.";
									$ans[7]="Session Starts at September of each year.";
									$ans[8]="Cisco CCNA helps to build professional carrier in netwoking sector and create a better job opportunities for todays dynamic and motivates computer professionals";
									$ans[9]="For further information you can directly contact with any CSE teachers in SUST.";
								   
								  
								   if($press==true)
								    {
									 echo "<div><p>";
									  echo "<b><u>Questtion:</u></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='blue'>$questions[$no]</font><br>";
									  echo "<b><u>Ans:</u></b><ul>$ans[$no]</ul><br><br>";
									 echo "</p></div>"; 
									 
									 echo "<br><b>Questions:</b>";
								   
								    }
								    echo "<div><ul>";
									
								      for($i=0;$i<10;$i++)
									  {
										echo "<li><a href='faq.php?no=$i&press=true'>$questions[$i]</a></li>";
									  
									  }
									  
									echo "</ul></div>";
									  
								}
	                            ?>   

							
							<br><br><br><br><br><br><br><br>
							

                        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
              <?php
               
               include ("include/footer.php");
               ?>
