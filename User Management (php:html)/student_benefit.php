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
        
                                    <li ><a href="student_benefit.php">Benefits</a></li>
                                    <li ><a href="student_instructor.php">Become an instructor</a></li>
                                    <li ><a href="student_certificate.php">CISCO Certificate</a></li>

         
                                </ul>

                                <h1>Search</h1>

                                <form method="POST" action="student_benefit.php" class="searchform">
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
                                 <h1>Have You Received Your Student Benefits?</h1>
                                 
                                 <p>
                                 <strong>Students,</strong><br>
                                 In addition to receiving access to quality instruction and course content, 
                                 the Cisco Networking Academy offers additional benefits to students who 
                                 successfully complete their courses. These benefits range from course 
                                 completion certificates to potential internship opportunities (Career Connection). Benefits are listed in the table below. 
                                 To receive these benefits a student must first meet the eligibility requirements. 
                                 Please check with your instructor to ensure you have met the student benefit criteria.
                                 </p>
                                 <p>
                                 
                                 <table cellSpacing=2 cellPadding=4 width="100%" border=1>
                                   <tr align="left">
                                      <td><b>Student Benefit</b></td>
                                      <td><b>Description</b></td>
                                      <td><b>How to receive student benefits?</b></td>
                                   </tr>
                                    
                                   <tr >
                                   <td >Course Completion Certificate (this is only an example of CCNA)</td>
                                      <td>Certificate specifies demonstrated competencies in the course.
                                          This could be useful when applying for higher education or when looking for career opportunities.</td>
                                      <td>Ask instructor for your Certificate of completion.</td>
                                   </tr>
                                   <tr>
                                   <td>Congratulatory Letter</td>
                                      <td>Letter of congratulation from John Chambers for CCNA and CCNP students.</td>
                                      <td>Ask your instructor if you have qualified for a letter.</td>
                                   </tr>
                                   <tr>
                                   <td>Alumni</td>
                                      <td>Alumni Benefits
                                          <ul>
                                        <li><span>Access to current and new versions of courses you have taken</span></li>
                                        <li><span>Keep up-to-date on technology trends</span></li>
                                        <li><span>Communicate with a global community of other IT Professionals, Educators and Students</span></li>
                                        <li><span>Career Connection tools to help you build your career</span></li>
                                        <li><span>Special discounts through the Academy Marketplace</span></li>                                              
                                         </ul>
                                      
                                      </td>
                                      <td>The Alumni Link will appear on the your homepage when you pass one Cisco Networking Academy course.</td>
                                   </tr>
                                   
                                 </table>
                                 
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
