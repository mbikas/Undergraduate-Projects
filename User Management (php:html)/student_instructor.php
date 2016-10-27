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
                                   if($_SESSION['user_status']==3)
                                   {
                                    echo "<li ><a href='student_benefit.php'>Benefits</a></li>";
                                    echo "<li ><a href='student_instructor.php'>Become an instructor</a></li>";
                                    echo "<li ><a href='student_certificate.php'>CISCO Certificate</a></li>";
                                   } 
                                   else if($_SESSION['user_status']==2)
                                   {
                                    echo "<li ><a href='student_instructor.php'>Become an instructor</a></li>";
                                   } 
                                  ?>
                                </ul>

                                <h1>Search</h1>

                                <form method="POST" action="student_instructor.php" class="searchform">
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
                                 <h1> Career Development</h1>
                                 
                                 <p><b>Become an Instructor</b></p>
                                 <p>
                                  The Cisco Networking Academy Program is unique in its approach to instructor training. Cisco has partnered with educational institutions around the world to provide the highest technical as well as pedagogical instruction for IT courses. There are many instructor level classes available through colleges, universities, or secondary schools known as Cisco Academy Training Centers (CATC) and Regional Academies.
                                 </p>
                                 <p>
                                   In addition to the high quality of training, the Academy Program provides additional mentoring through support relationships established between the instructor’s educational institution and a CATC or Regional Academy. Various instructional aids such as an Instructor Guide, Lab Manuals, Chapter PowerPoint presentations, lab simulators, and other interactive tools are available to instructors at no cost when teaching in the program.
                                 </p>
                                 <p>
                                   Instructors must pass an appropriate instructor level training course given at a CATC or Regional Academy, as well as an Academy Orientation course before they are given access through the online system to teach the Academy curriculum to students. An instructor may only attend training through the Academy Program structure if their educational institution has signed up to be an Academy.
                                 </p>

                                  <br><br><br><br><br>
                                  <?php
                                  }
                                  ?>

                        </div>

                <!-- content-wrap ends here -->
                </div>

        <?php
                include ("include/footer.php");
        ?>
