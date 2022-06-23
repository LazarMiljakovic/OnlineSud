<?php
 if (isset($_GET['brlicne'])) 
 {
 $brLicne_value = strval($_GET['brlicne']);
 $lenght = strlen($brLicne_value);
	if($lenght != 9)
	{
		echo "Nije validna, potrebno je da licna ima 9 broja";
	}
	else
	{
		$array = str_split($brLicne_value);
		foreach($array as $char)
		{
			if($char < '0' || $char > '9')
			{
				echo "Nije validan";
				return;
			}
			
			
		}
		echo "Validan";
	}
 }
 else
 {
	 
 }

?>