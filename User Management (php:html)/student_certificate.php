<?php
        include ("include/header.php");
?>

                <!-- menu -->
                <div  id="menu">
                        <ul>

                           <li id="current"><a href="index.php">Home</a></li>
                           <li><a href="information.php">View Informations</a></li>
                           <li><a href="profile.php">My Profile</a></li>
                           <li><a href="student_search.php">Search</a></li>
                           <li><a href="aboutus.php">About Developers</a></li>
                        </ul>
                </div>

                <!-- content-wrap starts here -->
                <div id="content-wrap">

                        <div id="sidebar">



                                <h1>Links</h1>
                                <ul class="sidemenu">

                                    <li ><a href="student_benefit.php">Benefits</a></li>
                                    <li ><a href="student_instructor.php">Become an instructor</a></li>
                                    <li ><a href="student_certificate.php">CISCO Certificate</a></li>


                                </ul>

                                <h1>Search</h1>

                                <form method="POST" action="student_certificate.php" class="searchform">
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

                                 <p><b>CCNA Certification Information</b></p>
                                 <p>
                                  The Cisco Certified Network Associate (CCNA) certification indicates a foundation in and apprentice knowledge of networking for the small office/home office market. CCNA certified professionals can install, configure, and operate LAN, WAN, and dial access services for small networks (100 nodes or fewer), including, but not limited to, use of these protocols: IP, IGRP, IPX, Serial, AppleTalk, Frame Relay, IP RIP, VLANs, RIP, Ethernet, Access Lists. </p>
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

