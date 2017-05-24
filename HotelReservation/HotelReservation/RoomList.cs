using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation
{
    class RoomList
    {
        List<Rooms> getAllRoom()
        {
            List<Rooms> list = new List<Rooms>();


            return list;
        }


        public List<Rooms> PrepereList(int neededPlace, List<Rooms> allRooms)
        {
            List<Rooms> list = new List<Rooms>();

            
                foreach (Rooms room in allRooms)
                {
                    
                        list.Add(room);
                  
                }
            

            return list;
        }
    }
}
