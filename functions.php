<?php 

function changeAdmin($conn,$login,$password){   //funkcja zmieniająca dane administratora
    $query = "UPDATE `admini` SET `login`='".$login."', `haslo`='".md5($password)."' WHERE `id`=2";
    $result = $conn->query($query);
}
function checkAdmin($conn,$login,$password){    //funkcja sprawdzająca czy admin o takich danych logowania istnieje

    $_SESSION["zalogowany"]=0;
    $query = "SELECT * FROM admini";
    $result = $conn->query($query);
    if(isset($result) && $result!=""){
    foreach($result as $row => $v){
        if($login==$row["login"] && md5($password)==$row["haslo"]){
            $_SESSION["zalogowany"]=1;
           

        }
    }
    }
    
    if($_SESSION["zalogowany"]==0){
       // echo "Złe dane logowania";
    }

}

function displayRooms($conn,$ilosc){
    $query = "SELECT * FROM rooms WHERE seats>".$ilosc."";
//    $json = file_get_contents('json.txt', FILE_USE_INCLUDE_PATH);
//
//    $result = json_decode($json);
    $result = $conn->query($query);
    $output = "Ilość osób : ".$ilosc;
    
    if(isset($result) && $result!=""){
        $output .= '<table>';
        $output .= '<tr><th>Numer</th><th>Miniatura</th><th>Ilość miejsc:</th></tr>';   
        foreach($result as $row){
            $output .= '<tr><th><a href="index.php?idSzczegoly='.$row["id_room"].'">'.$row["id_room"].'</a></th><td>Miniatura</td><td>'.$row["seats"].'</td></tr>';
            
        }
        $output .= '</table>';
    }
    echo $output;
}

function displayAll($conn){
    
    $query = "SELECT * FROM rooms";
//    $json = file_get_contents('json.txt', FILE_USE_INCLUDE_PATH);
//
//    $result = json_decode($json);
    $result = $conn->query($query);
    
    $output = "";
    
    if(isset($result) && $result!=""){
        $output .= '<table>';
        $output .= '<tr><th>Numer</th><th>Miniatura</th><th>Ilość miejsc:</th></tr>';
        foreach($result as $row){
            $output .= '<tr><th><a href="index.php?idSzczegoly='.$row["id_room"].'">'.$row["id_room"].'</a></th><td>Miniatura</td><td style="text-align:center">'.$row["seats"].'</td></tr>';
        }
        $output .= '</table>';
    }
    echo $output;
}

function displayRoom($conn,$id){   
    
    $query = "SELECT * FROM rooms WHERE id_room=".$id."";
//    $json = file_get_contents('json.txt', FILE_USE_INCLUDE_PATH);
//
//    $result = json_decode($json);
    $result = $conn->query($query); 
    
    $output = "";
    
    if(isset($result) && $result!=""){
        foreach($result as $row){
            if($id==$row["id_room"]){
            $output .= '<p>Id : '.$row["id_room"].'</p><p>Miejsca : '.$row["seats"].'</p><p>Cena : '.$row["price"].'</p> ';
            }
        }
    }
    echo $output;
}

function rezerwuj(){
    
}


?>