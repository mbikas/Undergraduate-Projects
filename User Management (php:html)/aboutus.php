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
                               <li id="current"><a href="aboutus.php">About Developers</a></li>
							   <li><a href="mail.php">Comments</a></li>  
							   <li><a href="faq.php">FAQ</a></li>
                               
                              <?php
                        }
                        else if(!isset($_SESSION['user_status']))
                        {
                             echo "<li><a href='index.php'>Home</a></li>";
                             echo "<li id='current'><a href='aboutus.php'>About Developers</a></li>";
							 echo "<li><a href='mail.php'>Comments</a></li>";
							 echo "<li><a href='faq.php'>FAQ</a></li>";
                        }
                       
                        else if($_SESSION['user_status']==3)
                         {
                         ?>
                                  <li><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li id="current"><a href="aboutus.php">About Developers</a></li>
								  <li><a href="mail.php">Comments</a></li>
								  <li><a href="faq.php">FAQ</a></li>

                        <?php
                        }

                         else if($_SESSION['user_status']==2)
                         {
                        ?>
                                 <li><a href="index.php">Home</a></li>
                                 <li><a href="information.php">View Informations</a></li>
                                 <li><a href="profile.php">My Profile</a></li>
                                 <li><a href="search_category.php">Search</a></li>
                                 <li id="current"><a href="aboutus.php">About Developers</a></li>
								 <li><a href="mail.php">Comments</a></li>
								 <li><a href="faq.php">FAQ</a></li>


                        <?php
                        }

                         else if($_SESSION['user_status']==1)
                         {
                        ?>
                                 <li ><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li id="current"><a href="aboutus.php">About Developers</a></li>
								  <li><a href="mail.php">Comments</a></li>
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
                                <li id="current"><a href="aboutus.php">About Developers</a></li>
								

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
                                  
                                  echo "<h1>About Developers</h1><br>";
								  
								  
	                                  echo "<strong>Name &nbsp;&nbsp;    : Md. Abu Naser Bikas</strong><br>";
	                                  echo "<strong>E-Mail  &nbsp;&nbsp;: bikasbd@yahoo.com</strong><br>";
	                                  echo "<strong>Contact : +8801911614279</strong><br>";
	                                  echo "<strong>Reg. No : 2002331056</strong><br>";
	                                  echo "<strong>Section : B</strong><br>";
	                                  echo "<strong>3rd Year 2nd Semester</strong><br>";
	                                  echo "<strong>Department of Computer Science & Engineering</strong><br>";
	                                  echo "<strong>Shahjalal University of Science & Technology</strong><br><br><br>";
	                                  
	                                  
	                                  
	                                  echo "<strong>Name &nbsp;&nbsp;    : Janesar Azad</strong><br>";
	                                  echo "<strong>E-Mail  &nbsp;&nbsp;: kingshuk058@gmail.com</strong><br>";
	                                  echo "<strong>Contact : +8801552417996</strong><br>";
	                                  echo "<strong>Reg. No : 2002331058</strong><br>";
	                                  echo "<strong>Section : B</strong><br>";
	                                  echo "<strong>3rd Year 2nd Semester</strong><br>";
	                                  echo "<strong>Department of Computer Science & Engineering</strong><br>";
	                                  echo "<strong>Shahjalal University of Science & Technology</strong><br><br><br>";
	                                  
	                                  
	                                  echo "<strong>Name &nbsp;&nbsp;    : Biplab Chandra Sarkar</strong><br>";
	                                  echo "<strong>E-Mail  &nbsp;&nbsp;: biplab_06@yahoo.com</strong><br>";
	                                  echo "<strong>Contact : +8801717567800</strong><br>";
	                                  echo "<strong>Reg. No : 2002331019</strong><br>";
	                                  echo "<strong>Section : B</strong><br>";
	                                  echo "<strong>3rd Year 2nd Semester</strong><br>";
	                                  echo "<strong>Department of Computer Science & Engineering</strong><br>";
	                                  echo "<strong>Shahjalal University of Science & Technology</strong><br><br><br>";
	                                  
	                                  
									  
	                                  
								}        
	                            ?>   

							
							
							<br><br><br><br><br><br><br><br>

                        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                
               <?php
               
               include ("include/footer.php");
               ?>
