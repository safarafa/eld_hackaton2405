//
//  Hotel.swift
//  iOSBookTheHotelRoomApp
//
//  Created by Paulina on 24.05.2017.
//  Copyright © 2017 Paulina. All rights reserved.
//

import Foundation
import UIKit

let DATA_URL = "TUTAJ ADRES"

typealias dataDownloaded = () -> ()

class Hotel {
    
    var _seats: Double!
    var _price: Double!
    
    var seats: Double {
        
        if _seats == nil {
            _seats = 0.0
        }
        return _seats
    }
    
    var price: Double {
        if _price == nil {
            _price = 0.0
        }
        return _price
    }
    
    func downloadRoomsData(downloaded: dataDownloaded) {
        
        let hotelURL = URL(string: DATA_URL)!
        request(hotelURL).responseJSON {
            response in
            let result = response.result
            
            if let dict = result.value as? [Dictionary<String, AnyObject>] {
                
                if let seats = dict[0]["seats"] as? Double {
                    
                    self._seats = seats
                }
                
                if let price = dict[0]["price"] as? Double {
                    
                    self._price = price
                }
            }
            dataDownloaded()
        }
    }
}
