<html>
<body>
   
   <?php
   
	if($pressed)
	{
	    $Months = array( 'January','February','March','April','May','June',
							 'July','August','September','october','Novermber','December');
		
		$pressed=false;
		
		
		$Year = $_POST['year'];
		$mon = $_POST['month'];
		$Month=0;
		for($i=0;$i<12;$i++)
		{
			if($mon==$Months[$i])
			{
				$Month = $i+1;
				break;
			}
		}
		$date = get_date($Year,$Month,1);
		echo "<b>$mon &nbsp;$Year</b><br><br>";
		design_calender($date,$Month,$Year);
		//echo "date = $date";
		echo "<form action='index.php'>";
		echo "<input type='submit' name='back' value='MAIN'>";
		echo "</form>";
	}
	else
	{
	?>
   
	   <b>Welcome to Bikas's Calender </b>
	   <form action="index.php" method="POST">
	    Year&nbsp; &nbsp;  
		<select type="combo" name="year">
			<?php
			for($i=1981;$i<2050;$i++){
					echo "<option>$i</option>";
			}
			?>
		</select>
		<br><br>Month   
		<select type="combo" name="month">
			<?php		
			
			$Months = array( 'January','February','March','April','May','June',
							 'July','August','September','october','Novermber','December');
			for($i=0;$i<11;$i++){
					echo "<option>$Months[$i]</option>";
			}
			?>
		</select>
		<br><br>
		<input type="submit" name="show" value="SHOW CALENDER">
	    <input type="hidden" name="pressed" value="true"> 
		</form>
	<?php
	}
	?>
</body>


<?php

    //takes current date,month,year( for example 01-01-2007)
	function get_date($c_year,$c_month,$c_date)
	{
	    //01-01-1980 TUESDAY 
		$old_year=1980;
		$old_month=1;
		$old_date=1;    
		$days=array(0,31,59,90,120,151,181,212,243,273,304,334,365);
		
		$year_diff=$c_year-$old_year;
		$day1=$days[$old_month-1]+$old_date;
		$day2=$days[$c_month-1]+$c_date;
		
		if($c_month>2)
		{
			if( check_leapYear($c_year) )
			  $day2++;
		}
        for($i=$old_year;$i<$c_year;$i++)
		{
		    $day2=$day2+365;
		    if( check_leapYear($i))$day2++;
		}
		
		$day = $day2- $day1;
		
		$Dates = array('TUES','WED','THURS','FRI','SAT','SUN','MON');
		$rem = $day%7;
		//echo "<br>diff = $day";
		$date = $Dates[$rem];		
		//echo "<br>date = $date";
		return $date;
		
	}
	
	
	
	function design_calender($date,$Month,$Year)
	{
	    $days=get_number_of_date_in_the_month($Month,$Year);
		//echo "<br>total = $days <br>";
		$counter=0;
		if($date=="SUN")$counter=1;
		else if($date=="MON")$counter=0;
		else if($date=="TUES")$counter=-1;
		else if($date=="WED")$counter=-2;
		else if($date=="THURS")$counter=-3;
		else if($date=="FRI")$counter=-4;
		else if($date=="SAT")$counter=-5;
		 
		for($i=0;$i<7;$i++)
		{
		    if($counter<=0)$cal[0][$i]=0;
			else $cal[0][$i]=$counter;
			$counter++;			
		}
		for($i=1;$i<6;$i++)
		{
			for($j=0;$j<7;$j++)
			{
			  if($counter>$days)$cal[$i][$j]=0;
			  else $cal[$i][$j]=$counter;
			  $counter++;
			}
		}
		//print_r($cal);
	?>
	    
		<table border="1">
			<tr>
				<td  bgcolor="#7a96df"><font color="white"><b>SUN</b></font></td>
				<td  bgcolor="#7a96df"><font color="white"><b>MON</b></font></td>
				<td  bgcolor="#7a96df"><font color="white"><b>TUE</b></font></td>
				<td  bgcolor="#7a96df"><font color="white"><b>WED</b></font></td>
				<td  bgcolor="#7a96df"><font color="white"><b>THU</b></font></td>
				<td  bgcolor="#7a96df"><font color="white"><b>FRI</b></font></td>
				<td  bgcolor="#7a96df"><font color="white"><b>SAT</b></font></td>
			
			</tr>
			<?php
			$empty=null;
			for($i=0;$i<6;$i++)
			{
			    if($i>0 && $cal[$i][0]==0)break;
			    echo "<tr>";
				for($j=0;$j<7;$j++)
				{
				   echo "<td>";
			       if($cal[$i][$j]>0)echo $cal[$i][$j];
				   else echo "&nbsp;";
				   echo "</td>";
				}				
				echo "</tr>";
				
			}
			
			?>
		</table>
	
	<?php
	}
	
	function get_number_of_date_in_the_month($Month,$Year)
	{
	   if($Month==2)
	   {
			if( check_leapYear($Year) )	return 29;
			return 28;
	   }
	   if($Month==3 || $Month==4 || $Month==6 || $Month==9 || $Month==11)return 30;
	   return 31; 
	
	}
	
	function check_leapYear($c_year)
	{
	   
		if($c_year%100==0)
		{
			if($c_year%400==0)
			return true;
		}
		else if($c_year%4==0)
			return true;
		return false;
	}

?>

</html>