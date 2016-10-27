<?
        include ("include/header.php");
       
            
?>
                
                <!-- menu -->        
                <div  id="menu">
                        <ul>
                               <?php
       if($_SESSION['user_status']==3)
       {
       ?>
               <li><a href="index.php">Home</a></li>
               <li><a href="information.php">View Informations</a></li>
               <li><a href="profile.php">My Profile</a></li>
               <li  id="current"><a href="search_category.php">Search</a></li>
               <li><a href="aboutus.php">About Developers</a></li>

      <?php
      }

       if($_SESSION['user_status']==2)
       {
      ?>
               <li><a href="index.php">Home</a></li>
               <li><a href="information.php">View Informations</a></li>
               <li><a href="profile.php">My Profile</a></li>
               <li  id="current"><a href="search_category.php">Search</a></li>
               <li><a href="aboutus.php">About Developers</a></li>
      <?php
      }

       if($_SESSION['user_status']==1)
       {
      ?>
               <li><a href="index.php">Home</a></li>
               <li><a href="information.php">View Informations</a></li>
               <li><a href="profile.php">My Profile</a></li>
               <li  id="current"><a href="search_category.php">Search</a></li>
               <li><a href="aboutus.php">About Developers</a></li>

      <?php
      }

       if($_SESSION['user_status']==0)
       {
      ?>
               <li><a href="index.php">Home</a></li>
                                  <li><a href="addUser.php">Add Users</a></li>
                                  <li><a href="information.php">View Informations</a></li>
                                  <li ><a href="profile.php">My Profile</a></li>
                                  <li id="current"><a href="search_category.php">Search</a></li>
                                  <li><a href="admin.php">Administration</a></li>

      <?php
      }
      ?>
             
                        </ul>
                </div>                                        
                        
                <!-- content-wrap starts here -->
                <div id="content-wrap">
                                
                        <div id="sidebar">
                                        
                                <h1>Links</h1>
                                <div class="left-box">
                                        <ul class="sidemenu">
                                            <?php
                                              $n1="Student";
                                              $n2="Teacher";
                                              $n3="Employee";
                                              
                                            echo "<li><a href='search.php?name=$n1'>Student</a></li>";
                                            echo "<li><a href='search.php?name=$n2'>Teacher</a></li>";
                                            echo "<li><a href='search.php?name=$n3'>Employee</a></li>";
                                            ?>
                                        </ul>  
                               
                                </div>
                        
                                
                                
                               <h1>Search</h1>
                                <form method="POST" action="search_category.php" class="searchform">
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
                    if($x==0){
                        echo "<b>You must have to login first to view this page</b>" ;
                        echo "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>";
                    }                    
                    else    include ("include/search.php");  
                 
                }
                else
                {
                    echo "<h2>Select Category</h2>";
                }
       ?>
        </div>
    </div>

                      <?php
                      include ("include/footer.php");
                      ?>

