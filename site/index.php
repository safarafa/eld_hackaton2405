<!DOCTYPE html>
<html>
<?php 
// podłączamy plik  connection.php 
include '../database.php';
require "../functions.php";
// wywołujemy funkcję connection() 

//mysql_query("SET CHARSET utf8");
//mysql_query("SET NAMES `utf8` COLLATE `utf8_polish_ci`"); 

?>
    
<?php
session_start(); ?>
    <head>
<title>KONFERENCJOMAT 2016 - LOSUJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    </head>
<?php include "header.php";

 include "nav.php"; 
echo '<body>';
if(isset($_GET["rezerwacja"]) && $_GET["rezerwacja"]==1){     //wyświetlenie wygranych
 
    include "rezerwuj.php";
    
}else
if(isset($_GET["wyswietlwszystko"]) && $_GET["wyswietlwszystko"]==1){       //losowanie konkretnego konkursu
 
    include 'losuj.php';
    
}else
{
 include 'content.php';         //treść alternatywna
}

echo '</body>';
 include 'footer.php'; //stopka
    ?>   

</html>