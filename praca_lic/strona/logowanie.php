<?php
 
    session_start();
     
    if ((isset($_SESSION['zalogowany'])) && ($_SESSION['zalogowany']==true))
    {
        header('Location: baza_usterki.php');
         exit();
    }
 
?>
 
<!DOCTYPE HTML>
<html lang="pl">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Logowanie do serwisu</title>
    <style>
        * {
  margin: 0;
  padding: 0;
}
body {
  width: 100vw;
  height: 100vh;
  background-image: url(../zdjecia/rej.jpg);
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
  }

.wrap {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  font-size: 25px;
  font-weight: bold;
  letter-spacing:2px;
  color: white;
}
form input {
  padding: 5px 10px;
  margin-bottom: 15px;
  margin-top:10px;
  opacity:0.7;
}

p {
  font-size: 19px;
  letter-spacing:1px;
}

.log {
  padding: 5px 10px;
  font-size: 16px;
}
a{
    text-decoration:none;
    color:yellow;
    text-transform:uppercase;
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

    </style>
</head>
 
<body>
       <div class="wrap">
   Logowanie do serwisu :<br /><br />
     
    <form action="zaloguj.php" method="post">
     
        Login: <br /> <input type="text" name="login" /> <br />
        Hasło: <br /> <input type="password" name="haslo" /> <br /><br />
        <input type="submit" value="Zaloguj się" />
     
    </form>
    <br/>
    <p>Jeżeli nie masz jeszcze konta <<a href="rejestracja.php">zarejestruj się</a>>!
    <br/><br/>
   

    
     
<?php
    if(isset($_SESSION['blad']))    echo $_SESSION['blad'];
?>
</div>

<div class="back">
<a href='index.html'>Powrót do strony startowej!</a>
</div>
   

 
</body>
</html>