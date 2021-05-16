<!DOCTYPE HTML>
<html>
<head>
<meta charset = "utf-8">
<title>Usuwanie z bazy</title>
<style>	
	*{
	margin:0;
	padding:0;}
    .back {
        position: absolute;
        top: 5vh;
        right: 7vw;
        padding: 15px;
        border-bottom: 3px double red;
      }
    .back a {
        text-decoration: none;
        color: black;
        text-transform: uppercase;
        font-weight: 900;
        font-size: 17px;
	  }  
	  body {
        background-color: rgb(230, 230, 230);
	  }  
	  h2{
		  text-align:center;
		  line-height:100vh;
	  }  
	
	</style>
</head>

	<?php
    function lacz_bd()
    {  
    $db = new mysqli('localhost','mstadnic','mstadnic', 'mstadnic_licencjat');  
    if (! $db)
          return false;
       $db->autocommit(TRUE);
       return $db;
    }
    $db = lacz_bd();
     
     
    $option = $_POST['id_usterki'];
            $zapytanie = "update usterki set naprawiona = 'T' where id_usterki='$option'";
            $wynik = $db->query($zapytanie);
   
    if ($db->affected_rows) { 
        echo "<h2> Poprawnie zmodyfikowano $db->affected_rows  rekord </h2> ";
	  		 
		
    } else {
        echo "<h2> Błąd podczas zmiany statusu, podaj poprawny numer id zgłoszenia </h2>";
    }
	
    ?>
<div class="back">
      <a href="logowanie.php">Sprawdź bazę usterek</a>
    </div>
</body>
</html>