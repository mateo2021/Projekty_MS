<?php
 
    session_start();
     
    if (!isset($_SESSION['zalogowany']))
    {
        header('Location: logowanie.php');
        exit();
    }
     
?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Zalogowano:"Darz Bór"</title>
    <link rel="stylesheet" href="styl.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
 
<body>
    <nav class="title">
        <h1>
            Prezentacja ambon myśliwskich na obwodzie łowieckim należącym do koła "Darz Bór"
        </h1>


    </nav>
    <div class="log">   
     <?php
 
      echo "<p>Witaj ".$_SESSION['user'].'! [ <a href="logout.php">Wyloguj się!</a> ]</p>';
   
     ?>
      
     </div>

<div class="wrap">
<iframe src="https://www.google.com/maps/d/embed?mid=1SIbQ3RAqoDVnIG0zwXwHHcGKCLX7CWw-&hl=pl"></iframe>
</div>

<div class="title_form">
    <h1> Formularz zgłaszania usterek dotyczących ambon:</h1>
</div>

<div class="table">
<?php

$nazwa_bazy_danych = 'mstadnic_licencjat';
$adres_serwera = 'localhost';
 
$login_bazy_danych = 'mstadnic';
$haslo_bazy_danych = 'mstadnic';


if ( !mysql_connect($adres_serwera,$login_bazy_danych,$haslo_bazy_danych) ) {
    echo 'Nie moge polaczyc sie z baza danych';
 	 exit (0);
 }

 if ( !mysql_select_db($nazwa_bazy_danych) ) {
    echo 'Blad otwarcia bazy danych';
 	 exit (0);
 }
   mysql_query('SET character_set_connection=utf8');

   mysql_query('SET character_set_client=utf8');
 
   mysql_query('SET character_set_results=utf8');
 
   mysql_query('set names utf8;');

$zapytanie = "SELECT id_usterki,imie,nazwisko,rewir,ambona,data_zgloszenia,opis_usterki,naprawiona FROM usterki u JOIN ambony a ON u.id_ambony=a.id_ambony JOIN rewiry r ON r.id_rewiru =a.id_rewiru order by data_zgloszenia desc";
$wynik = mysql_query($zapytanie);
echo "<p>";
 echo "<table boder=\"1\"><tr>";
 echo "<td bgcolor=\"#F4A460\"><strong> Numer ID </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Imię </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Nazwisko </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Rewir </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Nazwa ambony </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Data zgłoszenia </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Opis usterki </strong></td>";
 echo "<td bgcolor=\"#F4A460\"><strong> Naprawiona </strong></td>";
 echo "</tr>";

 
 while ( $row = mysql_fetch_row($wynik) ) {
    echo "</tr>";
    echo "<td bgcolor=\"#FFDAB9\"width=\"100\">" . $row[0] . "</td>";
    echo "<td bgcolor=\"#FFEFD5\"width=\"150\">" . $row[1] . "</td>";
    echo "<td bgcolor=\"#FFDAB9\"width=\"150\">" . $row[2] . "</td>";
    echo "<td bgcolor=\"#FFEFD5\"width=\"150\">" . $row[3] . "</td>";
	echo "<td bgcolor=\"#FFDAB9\"width=\"150\">" . $row[4] . "</td>";
  echo "<td bgcolor=\"#FFEFD5\" width=\"150\">" . $row[5] . "</td>";
  echo "<td bgcolor=\"#FFDAB9\" >" . $row[6] . "</td>";
  echo "<td bgcolor=\"#FFEFD5\"width=\"100\">" . $row[7] . "</td>";
    echo "</tr>";
 }
 echo "</table>";
 
 

 if ( !mysql_close() ) {
    echo 'Nie moge zakonczyc polaczenia z baza danych';
    exit (0);
 }
 
 ?>

</div>
<br>
 <h2>Zauważyłeś nową usterkę? Zgłoś ją!</h2>
 <br>
 
 <form action="dodaj.php" method="post" class="center dodaj">
<strong>Podaj imię:</strong><br>
<input type="text" name="imie">
<br>
<strong>Podaj nazwisko:</strong><br>
<input type="text" name="nazwisko">
<br>
<strong>Podaj nazwę urządzenia:</strong><br>
<div class="addphp">
<?php 

$nazwa_bazy_danych = 'mstadnic_licencjat';
$adres_serwera = 'localhost';
 
$login_bazy_danych = 'mstadnic';
$haslo_bazy_danych = 'mstadnic';


if ( !mysql_connect($adres_serwera,$login_bazy_danych,$haslo_bazy_danych) ) {
    echo 'Nie moge polaczyc sie z baza danych';
 	 exit (0);
 }

 if ( !mysql_select_db($nazwa_bazy_danych) ) {
    echo 'Blad otwarcia bazy danych';
 	 exit (0);
 }
   mysql_query('SET character_set_connection=utf8');

   mysql_query('SET character_set_client=utf8');
 
   mysql_query('SET character_set_results=utf8');
 
   mysql_query('set names utf8;');

   $sql = mysql_query('SELECT id_ambony,ambona,rewir FROM ambony a JOIN rewiry r ON a.id_rewiru=r.id_rewiru');
   echo '<select name="ambona">';
   while($row = mysql_fetch_row($sql))
     echo "<option value = $row[0]>" ." " .$row[1]." ||  Rewir: ( ".$row[2]." ) " ."</option>";
   echo "</select>";
   
   


   
 if ( !mysql_close() ) {
    echo 'Nie moge zakonczyc polaczenia z baza danych';
    exit (0);
 }



?>
</div>
<br>
<strong>Podaj opis usterki:</strong><br>
<input class="txt" type="text" name="usterka">
<br>
<br>
<input class="click" type="submit" value="Dodaj nową usterkę"><input  class="click" type="reset" value="Wyczyść dane">

</form>

<br>
 <h2>Usterka została naprawiona? Zmień jej status!</h2>
 <br>
 
 <form action="usun.php" method="post" class="center usun">
<strong>Podaj numer id zgłoszenia:</strong><br>
<input type="int" name="id_usterki">
<br>
<br>
<input  class="click" type="submit" value="Zmień status"><input  class="click" type="reset" value="Wyczyść dane">
</form>


<div class="arrow">
<i class="fas fa-arrow-up"></i>
</div>

<footer>
    <p>
    Strona prezentująca rozmieszczenie ambon myśliwskich © WSZELKIE PRAWA ZASTRZEŻONE
    </p>
</footer>
<div class="wrapper active">
<div class="plus">
<i class="fas fa-times"></i>
</div>
<p>Witaj!</p>
<p>Aby zgłosić usterkę zlokalizuj uszkodzoną ambonę na mapie, klikij w nią a następnie wprowadź odpowiednie informacje w formularzu.</p>
<p>nazwa = nazwa ambony</p>
<p>opis = rewir, w którym się znajduje</p>
</div>

<script
      src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
      crossorigin="anonymous"
    ></script>

<script >
$(document).on("scroll", function() {
  const scrollValues = $(this).scrollTop();

  if (scrollValues > 700) {
    $(".arrow").addClass("active");
  }
  if (scrollValues < 700) {
    $(".arrow").removeClass("active");
  }
});
$(function() {
  $(".arrow").click(function(e) {
    e.preventDefault();
    $("html, body").animate(
      {
        scrollTop: 0
      },
      1500
    );
  });
});

$('.plus').on("click", function(e) {
  e.preventDefault();
  $('.wrapper').removeClass('active');
});
</script>
</body>
</html>