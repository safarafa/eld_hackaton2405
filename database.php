<?php 
    //konfiguracja i połączenie z bazą danych
//    $host = 'localhost';
//    $uzytkownik = 'root';
//    $haslo = "";
//    $nazwa_bazy = "";
//    $conn = new mysqli($host, $uzytkownik, $haslo, $nazwa_bazy); 
//    $conn->set_charset('utf8');

//    $json = '
//    {
//        "type": "donut",
//        "name": "Cake",
//        "toppings": [
//            { "id": "5002", "type": "Glazed" },
//            { "id": "5006", "type": "Chocolate with Sprinkles" },
//            { "id": "5004", "type": "Maple" }
//        ]
//    }';
//
//    $yummy = json_decode($json);
//
//    echo $yummy->toppings[2]->id;

$json = file_get_contents('json.txt', FILE_USE_INCLUDE_PATH);

$yummy = json_decode($json);

//echo $yummy->idCustomer;


    ?>