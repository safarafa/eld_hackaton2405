//
//  hotelCell.swift
//  iOSBookTheHotelRoomApp
//
//  Created by Paulina on 24.05.2017.
//  Copyright © 2017 Paulina. All rights reserved.
//

import UIKit

class hotelCell: UITableViewCell {

    
    @IBOutlet weak var hotelImage: UIImageView!
    @IBOutlet weak var hotelName: UILabel!
    @IBOutlet weak var hotelPrice: UILabel!
    
    
    func configureCell(hotel: Hotel) {
        hotelName.text = "\(hotel.seats)"
        hotelPrice.text = "\(hotel.price)"
        hotelImage.image = UIImage(named: hotel.Image)
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
