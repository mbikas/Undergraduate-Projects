<?php
        include ("include/header_index.php");
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                         <?php
                          if($_SESSION['temp_id']!=null)
                          {
                          ?>
                           <li id="current"><a href="index.php">Home</a></li>
                           <li><a href="addUser.php">Add Users</a></li>
                                  
                           
                          <?php
                          }
                          else if($x==0)
                               echo "<li id='current'><a href='index.php'>Home</a></li>";
                          else if($_SESSION['user_status']==3)
                          {
                          ?>
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                         
                         <?php
                         }
                         
                        else if($_SESSION['user_status']==2)
                          {
                         ?>
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                         
                         <?php
                         }
                         
                         else if($_SESSION['user_status']==1)
                          {
                         ?>
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="aboutus.php">About Developers</a></li>
                        
                         <?php
                         }
                         
                         else if($_SESSION['user_status']==0)
                          {
                          
                         ?>
                                
                                  <li id="current"><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li><a href="profile.php">My Profile</a></li>
                                  <li><a href="search_category.php">Search</a></li>
                                  <li><a href="admin.php">Administration</a></li>
                                                
                                  
                         
                         <?php
                         }
                         
                         else
                          {
                          
                         ?>      
                                  <li id="current"><a href="index.php">Home</a></li>
                                  
                                                
                                  
                         
                         <?php
                         }
                         ?>
                                
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                        
                                
                                        
                                <h1>Links</h1>
                                <ul class="sidemenu">        
                                <?php 
                                  //~ echo "x = $x<br>";
                                  //~ echo "status = $_SESSION[user_status]<br>";
                                  if($_SESSION['user_status']==3  && $x==1)
                                  {
                                       echo "<li ><a href='student_benefit.php'>Benefits</a></li>";
                                       echo "<li ><a href='student_instructor.php'>Become an instructor</a></li>";
                                       echo "<li ><a href='student_certificate.php'>CISCO Certificate</a></li>";
                                       
                                  }
                                  else if($_SESSION['user_status']==2  && $x==1)
                                  {
                                       echo "<li ><a href='student_instructor.php'>Become an instructor</a></li>";
                                       
                                  }
                                  else if($_SESSION['user_status']==1 && $x==1)
                                  {
                                       echo "<li ><a href='historical_student.php'>View Historical Student Class List</a></li>";
                                       echo "<li ><a href='message_send.php'>Send Message to Students</a></li>";
                                       
                                       
                                       
                                  }
                                  else if($_SESSION['user_status']==0 && $x==1)
                                  {
                                   

                                       echo "<li ><a href='historical_student.php'>View Historical Student Class List</a></li>";
                                       echo "<li ><a href='message_send.php'>Send Message to Students</a></li>";
                                       
                                       
                                  }
                                  else
                                  {
                                       echo "<li ><a href='index.php?ccna=1'>CCNA-1</a></li>";
                                       echo "<li ><a href='index.php?ccna=2'>CCNA-2</a></li>";
                                       echo "<li ><a href='index.php?ccna=3'>CCNA-3</a></li>";
                                       echo "<li ><a href='index.php?ccna=4'>CCNA-4</a></li>";
                                  }
                                 ?>
                                </ul>        
                                
                                <h1>Search</h1>        
                                
                               <form method="POST" action="index.php" class="searchform">
                               <input type="text" name="search" class="search" >
                               <input type="submit" value="Search" class="button"> 
                               <input type="hidden" name="search_form" value="true">
                               </form>  
       
                                
    
        <?php
           include ("login.php");
        ?>
        </div>
    
   <div id="main">
    
    <a name="TemplateInfo"></a>
    <?Php
        
        if($search_form)
        {
                  include ("include/search.php");  
                 
        }
        else
        {
        
              //student
              
              if($_SESSION['user_status']==3 && $x==1)
              {
                    echo "<h1>Student Home</h1> "; 
                    include ("studentHome.php"); 
              
              }
              //employee
              else if($_SESSION['user_status']==2  && $x==1)
              {
                 echo "<h1>Employee Home</h1> <br><br>"; 
                 echo "<b>Welcome $_SESSION[user_name]</b><br>";            
                 echo "<b>You are logged in as an Employee</b>"; 
              
              }
              
              else if($_SESSION['user_status']==1 && $x==1)
              {
                 //echo "<h1>Welcome $_SESSION[user_name]</h1><br>";  
                 echo "<h1>Instructor Home</h1><br>"; 
                 include ("teacherHome.php");         
              
              }
               else if($_SESSION['user_status']==0 && $x==1)
              {
                 echo "<h1>Administrator Home</h1><br>"; 
                 include ("teacherHome.php");         
              
              
              }
              else
              {
                              if($ccna==1)
                              {
                              ?>
                                      <h1>CCNA 1</h1>
                                      <h3>Who Should Attend</h3>                                
                                      <p>
                                      <strong>This course</strong> is ideal 
                                          
                              <?php
                              }//end of CCNA1
                              else if($ccna==2)
                              {
                              ?>
                              
                                      <h1>CCNA 2</h1>
                                      <h3>Who Should Attend</h3>                                
                                      <p>
                                      <strong>This course</strong> is ideal                
                              <?php
                              }
                              else if($ccna==3)
                              {
                              ?>
                                      <h1>CCNA 3</h1>
                                      <h3>Who Should Attend</h3>                                
                                      <p>
                                      <strong>This course</strong> is ideal for 
                              <?php
                              }
                              else if($ccna==4)
                              {
                              ?>
                                      <h1>CCNA 4</h1>
                                      <h3>Who Should Attend</h3>                                
                                      <p>
                                      <strong>This course</strong> is ideal 
                              <?php
                              }
                              else
                              {
                              ?>
                                      <h1>CISCO COURSES</h1>
                                      <h3>Who Should Attend</h3>                                
                                      <p>
                                      The suite of <strong>Cisco CCNA </strong>courses are designed 
                              <?php
                              }//for main page
                              ?>
                              
                                      for people looking to gain professional
                                      certification which is recognised world wide. Many of the world's
                                      networks use Cisco equipment and technology. This course will be a
                                      good starting point for those what wanted a career in networks and
                                      networking.
                                      </p>
                                      
                                      <p>
                                      The CCNA certification (<strong>Cisco Certified Network Associate</strong>) is
                                      the first step in a Cisco career certification path. CCNA certified
                                      professionals can install, configure, and operate LAN, WAN, and
                                      dial access services for small networks (100 nodes or fewer),
                                      including but not limited to use of: IP, IGRP, Serial, Frame Relay,
                                      RIP, VLANs, RIP, Ethernet, Access Lists.
                                      </p>
                                      
                                      <p>
                                      IT is a growing industry, essential to economic and business
                                      development. New technologies such as converged devices, smart
                                      handhelds, wireless games, embedded devices in everyday durable
                                      goods will be on the rise. A study conducted by Certification
                                      Magazine on the&nbsp; industry's top 10 certifications picks CCNA
                                      as the best entry-level certification. The Cisco Networking Academy
                                      curriculum prepares students for industry standard certifications
                                      as well as vendor neutral certifications. These include CCNA; CCNP;
                                      Cisco Firewall Specialist; Cisco Wireless LAN Support Specialist;
                                      A+, Linux+, Network+, Security+, Server+ certifications,
                                      administered by CompTIA and Sun Certified
                                      Programmer for Java 2 Platform.
                                      
                                      </p>     
                              
                              
                              
                              <?Php
                              if($ccna==1)
                              {
                              ?>
                                                                     
                                     <h3>Course Contents</h3>
                                     <p>
                                      The <strong>Cisco CCNA 1 Course,</strong> Networking
                                      Basics,&nbsp;is the first of&nbsp;the four courses leading to the
                                      Cisco Certified Network Associate&nbsp;certification. CCNA 1
                                      focuses on network terminology and protocols, local area networks
                                      (LANs), wide area networks (WANs), Open System Interconnection
                                      (OSI) models, cabling, cabling tools, routers,&nbsp;router
                                      programming, Ethernet, Internet&nbsp;Protocol (IP) addressing and
                                      network standards.                               
                                     </p>                               
                                     
                                     <p><strong><b>The course contents are:</strong></b></p>
                                     <ul>
                                              <li><span><b>Introduction to Networking</b></span></li>
                                              <li><span><b>Networking Fundamentals</b></span></li>
                                              <li><span><b>Networking Media</b></span></li>
                                              <li><span><b>Cable Testing</b></span></li>
                                              <li><span><b>Cabling LANs and WANs</b></span></li>
                                              <li><span><b>Ethernet Fundamentals</b></span></li>
                                              <li><span><b>Ethernet Technologies</b></span></li>
                                              <li><span><b>Ethernet Switching</b></span></li>
                                              <li><span><b>TCP/IP Protocols Suite and IP Addressing</b></span></li>
                                              <li><span><b>Routing Fundamentals and Subnets</b></span></li>
                                              <li><span><b>TCP Transport and Application Layer</b></span></li>
                                              <li><span><b>Case Study</b></span></li>                                               
                                     </ul>

                                     <p><strong><b>Upon completion of CCNA1 students have an understanding<br> of
                                                   networking basics including:</strong></b></p>
                                     <ul>
                                              <li><span><b>Basics of Ethernet technologies</b></span></li>
                                              <li><span><b>TCI/IP</b></span></li>
                                              <li><span><b>Network media</b></span></li>
                                              <li><span><b>IP addressing</b></span></li>
                                              <li><span><b>Routing</b></span></li>                                              
                                     </ul>
                                     
                                     
                                              
                              <?php
                              }//end of CCNA1
                              else if($ccna==2)
                              {
                              ?>
                              
                                     <h3>Course Contents</h3>
                                     <p>
                                      The <strong>Cisco CCNA 2 Course,</strong> Networking
                                      Basics,&nbsp;is the first of&nbsp;the four courses leading to the
                                      Cisco Certified Network Associate&nbsp;certification. CCNA 1
                                      focuses on network terminology and protocols, local area networks
                                      (LANs), wide area networks (WANs), Open System Interconnection
                                      (OSI) models, cabling, cabling tools, routers,&nbsp;router
                                      programming, Ethernet, Internet&nbsp;Protocol (IP) addressing and
                                      network standards.                               
                                     </p>
                                     
                                      <p><strong><b>The course contents are:</strong></b></p>
                                     <ul>
                                              <li><span><b>WANs and Routers</b></span></li>
                                              <li><span><b>Introduction to Routers</b></span></li>
                                              <li><span><b>Configuring a Router</b></span></li> 
                                              <li><span><b>Learning about Other Devices</b></span></li> 
                                              <li><span><b>Managing Cisco IOS Software</b></span></li> 
                                              <li><span><b>Routing and Routing Protocols</b></span></li> 
                                              <li><span><b>Distance Vector Routing Protocols</b></span></li>
                                              <li><span><b>TCP/IP Suite Error and Control Messages</b></span></li> 
                                              <li><span><b>Basic Router Troubleshooting</b></span></li> 
                                              <li><span><b>Intermediate TCP/IP</b></span></li> 
                                              <li><span><b>Access Control Lists (ACLs)</b></span></li> 
                                              <li><span><b>Case Study - Routing</b></span></li>                                               
                                      </ul>

                                     <p><strong><b>Upon completion of CCNA2, students have an understanding<br> of
                                                      routers and routing including:</strong></b></p>
                                     <ul>
                                              <li><span><b>Router user interfaces, components and configurations</b></span></li> 
                                              <li><span><b>Basics of IOS versions, naming and software backup</b></span></li> 
                                              <li><span><b>TCP/IP Protocol Suite and IP addressing and subnetting</b></span></li> 
                                              <li><span><b>Interior routing protocolsRIP, IGRP</b></span></li>                                             
                                     </ul>
                              <?php
                              }
                              else if($ccna==3)
                              {
                              ?>
                                     <h3>Course Contents</h3>
                                     <p>
                                      The <strong>Cisco CCNA 3 Course,</strong> Networking
                                      Basics,&nbsp;is the first of&nbsp;the four courses leading to the
                                      Cisco Certified Network Associate&nbsp;certification. CCNA 1
                                      focuses on network terminology and protocols, local area networks
                                      (LANs), wide area networks (WANs), Open System Interconnection
                                      (OSI) models, cabling, cabling tools, routers,&nbsp;router
                                      programming, Ethernet, Internet&nbsp;Protocol (IP) addressing and
                                      network standards.                               
                                     </p>
                                     
                                     <p><strong><b>The course contents are:</strong></b></p>
                                     <ul>
                                              <li><span><b>Introduction to&nbsp; Classless Routing</b></span></li>
                                              <li><span><b>Single Area OSPF</b></span></li>
                                              <li><span><b>EIGRP</b></span></li>
                                              <li><span><b>Switching Concepts</b></span></li>
                                              <li><span><b>Switches</b></span></li>
                                              <li><span><b>Switch Configuration</b></span></li>
                                              <li><span><b>Spanning-Tree Protocol</b></span></li>
                                              <li><span><b>Virtual LANs</b></span></li>
                                              <li><span><b>VLAN Trunking Protocol</b></span></li>
                                              <li><span><b>Case Study: Access Control Lists (ACLs)</b></span></li>                                              
                                     </ul>

                                     <p><strong><b>Upon completion of CCNA3 students have an understanding of
                                                   networking basics including:</strong></b></p>
                                     <ul>
                                              <li><span><b>Switching and VLANs</b></span></li>
                                              <li><span><b>Spanning-Tree Protocol</b></span></li>
                                              <li><span><b>Routing and Routing Protocols</b></span></li>
                                              <li><span><b>Access Control Lists (ACLs)</b></span></li>
                                              <li><span><b>Network documentation, security and troubleshooting</b></span></li>                                              
                                     </ul>
                              
                              <?php
                              }
                              else if($ccna==4)
                              {
                              ?>
                                     <h3>Course Contents</h3>
                                     <p>
                                      The <strong>Cisco CCNA 4 Course,</strong> Networking
                                      Basics,&nbsp;is the first of&nbsp;the four courses leading to the
                                      Cisco Certified Network Associate&nbsp;certification. CCNA 1
                                      focuses on network terminology and protocols, local area networks
                                      (LANs), wide area networks (WANs), Open System Interconnection
                                      (OSI) models, cabling, cabling tools, routers,&nbsp;router
                                      programming, Ethernet, Internet&nbsp;Protocol (IP) addressing and
                                      network standards.                               
                                     </p>
                                     
                                     <p><strong><b>The course contents are:</strong></b></p>
                                     <ul>
                                              <li><span><b>Scaling IP Addresses</b></span></li> 
                                              <li><span><b>WAN Technologies</b></span></li> 
                                              <li><span><b>PPP</b></span></li> 
                                              <li><span><b>ISDN and DDR</b></span></li> 
                                              <li><span><b>Frame Relay</b></span></li> 
                                              <li><span><b>Introduction to Network Administration</b></span></li> 
                                              <li><span><b>Case Study: WANs</b></span></li>                                           
                                     </ul>

                                     <p><strong><b>Upon completion of CCNA4 students have an understanding of
                                                   networking basics including:</strong></b></p>
                                     <ul>
                                              <li><span><b>WAN devices, encapsulation formats, and communication</b></span></li> 
                                              <li><span><b>PPP components, session establishment, and authentication</b></span></li> 
                                              <li><span><b>ISDN uses, services, and configuration</b></span></li> 
                                              <li><span><b>Frame relay technology and configuration</b></span></li>                                                                                      
                                     </ul>
                              
                              <?php
                              }
                              else
                              {
                              ?>
                                                                     
                                     <h3>Courses and Course Contents</h3>
                                     <p>
                                     <strong><a href="index.php?ccna=1" title="CCNA 1 Course">CCNA
                                      1</a></strong><br>
                                      The <strong>Cisco CCNA 1 Course,</strong> Networking
                                      Basics,&nbsp;is the first of&nbsp;the four courses leading to the
                                      Cisco Certified Network Associate&nbsp;certification. CCNA 1
                                      focuses on network terminology and protocols, local area networks
                                      (LANs), wide area networks (WANs), Open System Interconnection
                                      (OSI) models, cabling, cabling tools, routers,&nbsp;router
                                      programming, Ethernet, Internet&nbsp;Protocol (IP) addressing and
                                      network standards.                               
                                     </p>
                                     
                                     <p>
                                     <strong><a href="index.php?ccna=2" title="CCNA 2 Course">CCNA
                                      2</a></strong><br>
                                      The <strong>Cisco CCNA&nbsp;2 Course,</strong> Routers and
                                      Routing Basics, is the second for four CCNA courses leading to
                                      Cisco certification. CCNA 2 focuses on initial router
                                      configuration, Cisco IOS Software management, routing protocol
                                      configuration, TCP/IP and access control lists (ACLs). Students
                                      will develop skills on how to configure a router, manage Cisco IOS
                                      Software, configure routing protocols and create access
                                      lists&nbsp;for basic&nbsp;network security.                                                            
                                     </p>
                                     
                                     <p>
                                      <strong><a href="index.php?ccna=3" title="CCNA 3 Course">CCNA
                                      3</a></strong><br>
                                      The <strong>Cisco CCNA 3 Course,</strong> Switching Basics and
                                      Intermediate Routing, is the third of&nbsp;the four courses leading
                                      to CCNA certification. CCNA 3 focuses on advanced IP addressing
                                      techniques (Variable Length Subnet Masking (VLSM)), intermediate
                                      routing protocols (RIP v2, single-area OSPF, EIGRP), command-line
                                      interface configuration of switches, Ethernet switching, Virtual
                                      LANs (VLANs), Spanning Tree Protocol (STP) and VLAN Trunking
                                      Protocol (VTP).
                                     </p>
                                     
                                     <p>
                                      <strong><a href="index.php?ccna=4" title="CCNA 4 Course">CCNA
                                      4</a></strong><br>
                                      The <strong>Cisco CCNA 4
                                      Course,</strong>&nbsp;WAN&nbsp;Technologies,&nbsp;is the last
                                      of&nbsp;the four courses leading to the Cisco CCNA certification.
                                      CCNA 4 focuses on advanced IP addressing techniques (Network
                                      Address Translation (NAT), Port Address Translation (PAT) and
                                      DHCP), WAN technology and terminology, PPP, ISDN, DDR, Frame Relay,
                                      network management and introduction to optical networking.
                                     </p>
                                     
                                     
                              <?php
                              }//for main page
              }
           }
                        ?>
          
                        
                        <br><br><br><br><br>

                        </div>
                
                <!-- content-wrap ends here -->        
                </div>
                                        
        <?php
                include ("include/footer.php");
        ?>
