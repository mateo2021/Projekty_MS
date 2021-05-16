<?php

	session_start();
	
	if (!isset($_SESSION['udanarejestracja']))
	{
		header('Location: logowanie.php');
		exit();
	}
	else
	{
		unset($_SESSION['udanarejestracja']);
	}
	
	//Usuwanie zmiennych pamiętających wartości wpisane do formularza
	if (isset($_SESSION['fr_nick'])) unset($_SESSION['fr_nick']);
	if (isset($_SESSION['fr_email'])) unset($_SESSION['fr_email']);
	if (isset($_SESSION['fr_haslo1'])) unset($_SESSION['fr_haslo1']);
	if (isset($_SESSION['fr_haslo2'])) unset($_SESSION['fr_haslo2']);
	if (isset($_SESSION['fr_regulamin'])) unset($_SESSION['fr_regulamin']);
	
	//Usuwanie błędów rejestracji
	if (isset($_SESSION['e_nick'])) unset($_SESSION['e_nick']);
	if (isset($_SESSION['e_email'])) unset($_SESSION['e_email']);
	if (isset($_SESSION['e_haslo'])) unset($_SESSION['e_haslo']);
	if (isset($_SESSION['e_regulamin'])) unset($_SESSION['e_regulamin']);

	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Udana rejestracja</title>
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

<body>
	
	<h2>Dziękuje za dokonanie rejestracji. A teraz możesz zalogować się na swoje konto!</h2>
	
	<div class="back">
      <a href="logowanie.php">Powrót logowania</a>
    </div>
	<br /><br />

</body>
</html>