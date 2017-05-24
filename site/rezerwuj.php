<?php 
//CONTENT TEMPLATE
if(isset($_GET["czysc"]) && $_GET["czysc"]==1){
    echo czyscWygranych($conn);
}
if(isset($_GET["usun"]) && $_GET["usun"]!=""){
    echo usunWygranego($conn,$_GET["usun"]);
}
?>

<article>
    
  <h1>Wprowadź dane</h1>


<form  method="post" action="index.php">
    <p><label for="ilosc">Podaj liczbę osób</label> <input type="number" name="ilosc"></p>
<!--    <p><label for="iloscP">Podaj ilość pokoi</label> <input type="number" name="iloscP"></p>-->
    <input type="submit">
</form>
</article>

