
<?php
 
 session_start();
  
 if (!isset($_SESSION['zalogowany']))
 {
     header('Location: logowanie.php');
     exit();
 }
  
?>



<!DOCTYPE HTML>
<html>
<head>
<meta charset = "utf-8">
<title>Dodawanie do bazy</title>
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
<?php      
            
            if( isset($_POST["imie"]) ){
				$imie = $_POST["imie"];
				$nazwisko = $_POST["nazwisko"];
                $usterka= $_POST["usterka"];
                $uzyt= $_SESSION['id_uzytk'];
                $ambona = $_POST["ambona"];
               
                
				
				if( empty($imie) || empty($nazwisko) || empty($usterka) ){
					echo "<h2> Wypełnij wszystkie pola </h2>";
				}else {
                  					
                    $conn = new mysqli("localhost", "mstadnic", "mstadnic", "mstadnic_licencjat");
                    $conn->set_charset ("utf8"); 
                    $odp = $conn->query("INSERT INTO `usterki` (`id_usterki`, `imie`, `nazwisko`, `id_ambony`, `opis_usterki`, `id_uzytk`, `data_zgloszenia`, `naprawiona`) VALUES (NULL, '$imie', '$nazwisko', '$ambona', '$usterka','$uzyt',current_date(),'N')");

					if($odp){
                        echo "<h2>  Poprawnie dodano 1 element do bazy </h2>";


					}else {
						echo "<h2> Nie udało się dodać elementu do bazy, spróbuj ponownie </h2>";
					}
					
					$conn->close();	
				
            }
        }
			
        ?>
       
      <div class="back">
      <a href="baza_usterki.php">Sprawdź bazę usterek</a>
    </div>

</body>
</html>