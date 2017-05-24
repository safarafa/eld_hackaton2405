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
    foreach($result as $row){
        if($login==$row["login"] && md5($password)==$row["haslo"]){
            $_SESSION["zalogowany"]=1;
           

        }
    }
    }
    
    if($_SESSION["zalogowany"]==0){
       // echo "Złe dane logowania";
    }

}

function displayRooms($conn,$login,$password){
    $query = "SELECT * FROM admini";
    $result = $conn->query($query);
    $output = "";
    
    if(isset($result) && $result!=""){
        $output .= '<table>';
        $output .= '<tr><th>Numer</th><th>Miniatura</th><th>Ilość miejsc:</th></tr>';   
        foreach($result as $row){
            $output .= '<tr><th>'.$row["id"].'</th><td>Miniatura</td><td>'.$row["ilosc"].'</td></tr>';
        }
        $output .= '</table>';
    }
}


?>