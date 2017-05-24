//
//  HotelListVC.swift
//  iOSBookTheHotelRoomApp
//
//  Created by Paulina on 24.05.2017.
//  Copyright © 2017 Paulina. All rights reserved.
//

import UIKit

class HotelListVC: UIViewController, UITableViewDelegate, UITableViewDataSource {

    var hotel: Hotel!
    var hotels = [Hotel] ()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return hotels.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
    if let cell = tableView.dequeueReusableCell(withIdentifier: "hotelCell", for: indexPath) as? hotelCell {
        let hotel = hotels[indexPath.row]
        cell.configureCell(hotel: hotel)
        return cell
    } else {
    return hotelCell()
    }
}


}
