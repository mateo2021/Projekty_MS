<?php

	session_start();
	
	if (isset($_POST['email']))
	{
		
		$wszystko_OK=true;
		
		
		$nick = $_POST['nick']; //Sprawdzanie poprawności nicka
		
		
		if ((strlen($nick)<3) || (strlen($nick)>20)) //Sprawdzanie długości nicka
		{
			$wszystko_OK=false;
			$_SESSION['e_nick']="Nick musi posiadać od 3 do 20 znaków!";
		}
		
		if (ctype_alnum($nick)==false)
		{
			$wszystko_OK=false;
			$_SESSION['e_nick']="Nick może składać się tylko z liter bez polskich znaków oraz cyfr! ";
		}
		
		// Sprawdzenie poprawności adresu e-mail
		$email = $_POST['email'];
		$emailB = filter_var($email, FILTER_SANITIZE_EMAIL);
		
		if ((filter_var($emailB, FILTER_VALIDATE_EMAIL)==false) || ($emailB!=$email))
		{
			$wszystko_OK=false;
			$_SESSION['e_email']="Adres e-mail nie jest poprawny. Podaj poprawny adres!";
		}
		
		//Sprawdzenie poprawności hasła
		$haslo1 = $_POST['haslo1'];
		$haslo2 = $_POST['haslo2'];
		
		if ((strlen($haslo1)<8) || (strlen($haslo1)>20))
		{
			$wszystko_OK=false;
			$_SESSION['e_haslo']="Hasło musi posiadać od 8 do 20 znaków!";
		}
		
		if ($haslo1!=$haslo2)
		{
			$wszystko_OK=false;
			$_SESSION['e_haslo']="Podane hasła nie są identyczne!";
		}	

		$haslo_hash = password_hash($haslo1, PASSWORD_DEFAULT);  //zabezpieczenie i kodowanie hasla
		
		//Sprawdzanie, czy regulamin został zaakceptowany
		if (!isset($_POST['regulamin']))
		{
			$wszystko_OK=false;
			$_SESSION['e_regulamin']="Potwierdź akceptację regulaminu!";
		}				
		
		//Zapamiętaj wprowadzone dane
		$_SESSION['fr_nick'] = $nick;
		$_SESSION['fr_email'] = $email;
		$_SESSION['fr_haslo1'] = $haslo1;
		$_SESSION['fr_haslo2'] = $haslo2;
		if (isset($_POST['regulamin'])) $_SESSION['fr_regulamin'] = true;
		
		require_once "connect.php";
		mysqli_report(MYSQLI_REPORT_STRICT);  //informuje php, ze reportujemy bledy zamiast warningow, zeby nie wyciekaly wazne dane 
		
		try 
		{
			$polaczenie = new mysqli($servername, $db_user, $db_password, $db_name);
			if ($polaczenie->connect_errno!=0)
			{
				throw new Exception(mysqli_connect_errno());
			}
			else
			{
				//Sprawdzanie czy e-mail już istnieje
				$rezultat = $polaczenie->query("SELECT id_uzytk FROM uzytkownicy WHERE email='$email'");
				
				if (!$rezultat) throw new Exception($polaczenie->error);
				
				$ile_takich_maili = $rezultat->num_rows;
				if($ile_takich_maili>0)
				{
					$wszystko_OK=false;
					$_SESSION['e_email']="Istnieje już konto przypisane do tego adresu e-mail!";
				}		

				//Sprawdzanie czy nick już istnieje
				$rezultat = $polaczenie->query("SELECT id_uzytk FROM uzytkownicy WHERE user='$nick'");
				
				if (!$rezultat) throw new Exception($polaczenie->error);
				
				$ile_takich_nickow = $rezultat->num_rows;
				if($ile_takich_nickow>0)
				{
					$wszystko_OK=false;
					$_SESSION['e_nick']="Istnieje już gracz o takim nicku! Wybierz inny.";
				}
				
				if ($wszystko_OK==true)
				{
					//Wszystko w porzadku, udalo sie dodac uzytkownika do bazy
					
					if ($polaczenie->query("INSERT INTO uzytkownicy VALUES (NULL, '$nick', '$haslo_hash', '$email')"))
					{
						$_SESSION['udanarejestracja']=true;
						header('Location: witamy.php');
					}
					else
					{
						throw new Exception($polaczenie->error);
					}
					
				}
				
				$polaczenie->close();
			}
			
		}
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Spróbuj ponownie w późniejszym czasie!</span>';
			echo '<br />Informacja developerska: '.$e;
		}
		
	}
	
	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Zakładanie konta</title>
	
	<style>
* {
  margin: 0;
  padding: 0;
}
body {
  width: 100vw;
  height: 100vh;
  background-image: url(../zdjecia/login.jpg);
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
}

form {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  font-size: 22px;
  font-weight: bold;
  color: white;
  letter-spacing:2px;
}
 form input {
  padding: 5px 15px;
  margin-bottom: 15px;
  margin-top:10px;
  opacity:0.7;
}

p {
  font-size: 18px;
}
.click{
	margin-top:10px;
	font-size:19px;
}

.error{
  color:red;
  font-size:18px;
  margin-top: 5px;
	margin-bottom: 5px;
}
 a{
  text-decoration:none;
  color:yellow;
	text-transform:uppercase;
	font-size:19px;
  letter-spacing:0;
}

.back{
  position:absolute;
  font-size:17px;
 top:5vh;
  right:7vw;
  padding:15px;
  border-bottom: 3px double red;
}
.back a{
 color:white;
}
.click input{
	font-size:30px;
}
	</style>
</head>

<body>
	
	<form method="post">
	
		Login: <br /> <input type="text" value="<?php
			if (isset($_SESSION['fr_nick']))
			{
				echo $_SESSION['fr_nick'];
				unset($_SESSION['fr_nick']);
			}
		?>" name="nick" /><br />
		
		<?php
			if (isset($_SESSION['e_nick']))   //jezeli jest ustawiona zmienna sesyjna to...
			{
				echo '<div class="error">'.$_SESSION['e_nick'].'</div>'; //wyswietl
				unset($_SESSION['e_nick']);  //wyczysc te sekcję, zeby nie zostala na amen w sekcji
				//i ktos mial szanse poprawic blad
			}
		?>
		
		E-mail: <br /> <input type="text" value="<?php
			if (isset($_SESSION['fr_email']))
			{
				echo $_SESSION['fr_email'];
				unset($_SESSION['fr_email']);
			}
		?>" name="email" /><br />
		
		<?php
			if (isset($_SESSION['e_email']))
			{
				echo '<div class="error">'.$_SESSION['e_email'].'</div>';
				unset($_SESSION['e_email']);
			}
		?>
		
		Twoje hasło: <br /> <input type="password"  value="<?php
			if (isset($_SESSION['fr_haslo1']))
			{
				echo $_SESSION['fr_haslo1'];
				unset($_SESSION['fr_haslo1']);
			}
		?>" name="haslo1" /><br />
		
		<?php
			if (isset($_SESSION['e_haslo']))
			{
				echo '<div class="error">'.$_SESSION['e_haslo'].'</div>';
				unset($_SESSION['e_haslo']);
			}
		?>		
		
		Powtórz hasło: <br /> <input type="password" value="<?php
			if (isset($_SESSION['fr_haslo2']))
			{
				echo $_SESSION['fr_haslo2'];
				unset($_SESSION['fr_haslo2']);
			}
		?>" name="haslo2" /><br />
		
		<label class="click">
			<input  type="checkbox" name="regulamin" <?php
			if (isset($_SESSION['fr_regulamin']))
			{
				echo "checked";
				unset($_SESSION['fr_regulamin']);
			}
				?>/> Akceptuję <<a href="regulamin.html">regulamin</a>>!
		</label>
		
		<?php
			if (isset($_SESSION['e_regulamin']))
			{
				echo '<div class="error">'.$_SESSION['e_regulamin'].'</div>';
				unset($_SESSION['e_regulamin']);
			}
		?>	
		
	
		<br /><br/>
		
		<input type="submit" value="Zarejestruj się" />
		
	</form>
	<div class="back">
      <a href='index.html'>Powrót do strony startowej!</a>
  </div>

</body>
</html>