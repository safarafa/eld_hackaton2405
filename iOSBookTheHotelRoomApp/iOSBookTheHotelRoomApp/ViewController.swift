//
//  ViewController.swift
//  iOSBookTheHotelRoomApp
//
//  Created by Paulina on 24.05.2017.
//  Copyright © 2017 Paulina. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var howManyPplTextField: UITextField!
    
    
    @IBAction func checkRoomsBtn(_ sender: UIButton) {
        
        performSegue(withIdentifier: "hotelListVC", sender: howManyPplTextField.text)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
