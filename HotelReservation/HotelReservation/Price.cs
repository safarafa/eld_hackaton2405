using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation
{
    class Price
    {
        double price;
        Dictionary<int, double> Dic = new Dictionary<int, double>
        {
            {1,100},
            {2,150},
            {3,200},
            {4,250},
            {5,300},
            {6, 350}
        };
        
        

        double getPrice(Rooms room)
        {
            if (Dic.ContainsKey(room.getPlace()))
                price = Dic[room.getPlace()];

            return price;
        }

    }
}
