<!DOCTYPE html>
<html>
 
<?php
session_start(); ?>

<?php
include '../database.php';
require('../functions.php');

//mysql_query("SET CHARSET utf8");
//mysql_query("SET NAMES 'utf8'");  
    ?>
    
    <?php 
    if(isset($_GET["logout"])){
        $_SESSION["zalogowany"]=0;  
        header('Location: ../index.php');
    }
    
    if(isset($_POST["login"])){
      echo checkAdmin($conn,$_POST["login"],$_POST["password"]); 
    }
      if(isset($_SESSION["zalogowany"]) && $_SESSION["zalogowany"]==1){ 
?>

    <head>
    <title>HOTEL - ADMIN</title>
    </head>
<?php 
include "../site/header.php"; 
include 'nav.php';
  echo '<body>';        
if(isset($_GET["key"]) && $_GET["key"]=="zmienlogin"){     //zmiana danych logowania
    include 'editadmin.php';
}else
if(isset($_GET["echo"])){             //wyświetlanie komunikatów
    echo $_GET["echo"];
}else
if(isset($_GET["usunkonkurs"])){       // usuwanie konkursu
    usunKonkurs($conn,$_GET["usunkonkurs"]);
}else
if(isset($_GET["nazwakonkursu"])){      //wyświetlenie szczegółów konkursu
    include 'konkursszczegoly.php';
}else
if(isset($_GET["editu"]) && $_GET["editu"]=="1"){ //strona edycyjna
    include 'editu.php';
}else
{   
include 'content.php';      //treść alternatywna
}
          echo '</body>';
include '../site/footer.php';   //stopka 
    ?>    
</html>

<?php }else{                    //wyświetlenie okna logowania
include "../site/header.php"; 
          ?>
<a style="margin:10px" href="../index.php">WRÓĆ</a>
<center>
    ZALOGUJ SIĘ
    <form action='index.php' method="post">
    <input type="text" name="login" id="login"><br>
    <input type="password" name="password" id="password"><br>
    <input type="submit">
    </form>
    </center>
    <?php
include '../site/footer.php';
    }?>


