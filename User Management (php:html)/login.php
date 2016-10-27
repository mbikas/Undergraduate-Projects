<?php
       

        if($x==0)
        {
        ?>

        <?php
                if($login_form)
                {




                        if($row['id']==0)  
                        {
                                
                                if($_SESSION['temp_id']!=null)
                                {
                                       
                                        if($first==1)
                                        {
                                                echo "<p><b><font color='black'>You have successfully logged in.You can only create your profile.</font></b></p>";
                                                //echo "<p><b><font color='black'>You can only create your profile.</font></b></p>";
                                                
                                                //echo "<h2>You have successfully logged in.</h2>";
                                                //echo "<h2>You can only create your profile<br></h2>";  
                                                $first=0;                         
                                        }
                                ?>
                                                        
                                        <h1>Sign Out</h1>
                                        <div class="left-box">
                                        <ul class="sidemenu">
                                        <li><a href='logout.php?logout_id=1'>Signout</a></li>
                                        </li>
                                        </ul>
                                        </div>
                                <?php
                                }
                                
                                else
                                {
                                
                                        echo "<h4>Invalid Name or Password</h4>";
                                        ?>
                                        <h1>Signin</h1>
                                        <form action="index.php" class="searchform" method="POST" >
                                        <table border="0">
										<tr>
                                        <input type="hidden" name="login_form" value="true">
											<td><b>User ID: </b></td>
											<td><input type=text name="form_username" class="search" ></td>
										</tr>
										<tr>
										 <td><b>Password: </b></td>
										 <td><input type=password name="form_password" class="search"></td>
                                        </tr>
										<tr>	
											<td colspan="2" align="center"><input name="login" class="button" value="SIGNIN" type="submit"></td>
										</tr>
										</table>
										</form>
                                        <?php
                                }
                        }
                        else
                        {  
                                       

                        }

                }
                else
                {
                

                        if($_SESSION['temp_id']!=null)
                        {
                                        
                                        //echo "<h2>You have successfully logged in.</h2><br>";
                                        $first=0;                         
                                        
                ?>
                                                        
                                        <h1>Sign Out</h1>
                                        <div class="left-box">
                                        <ul class="sidemenu">
                                        <li><a href='logout.php?logout_id=1'>Signout</a></li>
                                        </li>
                                        </ul>
                                        </div>
                                <?php
                        }
                        else
                        {
                        ?>
                                        <h1>Signin</h1>
                                        <form action="index.php" class="searchform" method="POST" >
										<table border="0">
										<tr>
                                        <input type="hidden" name="login_form" value="true">
											<td><b>User ID: </b></td>
											<td><input type=text name="form_username" class="search" ></td>
										</tr>
										<tr>
										 <td><b>Password: </b></td>
										 <td><input type=password name="form_password" class="search"></td>
                                        </tr>
										<tr>	
											<td colspan="2" align="center"><input name="login" class="button" value="SIGNIN" type="submit"></td>
										</tr>
										</table>
											  </form>
                <?php                
                        }

                
                }
        }
        else  
        {
                           
                if($first==1)
                {
                        
                        echo "<h2>Welcome $_SESSION[user_name]</h2>";
                        if($_SESSION['user_status']==0)echo "<p><b><font color='black'>You have logged in as an Administrator.</font></b></p>";
                        else if($_SESSION['user_status']==1)echo "<p><b><font color='black'>You have logged in as a Teacher.</font></b></p>";
                        else if($_SESSION['user_status']==2)echo "<p><b><font color='black'>You have logged in as an Employee.</font></b></p>";
                        else if($_SESSION['user_status']==3)echo "<p><b><font color='black'>You have logged in as a Student.</font></b></p>";
                        $first=0;
                        
                
                }
                                
                                

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


