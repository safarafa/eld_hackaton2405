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


        List<Rooms> PrepereList(int neededPlace, List<Rooms> allRooms)
        {
            List<Rooms> list = new List<Rooms>();

            for (int i = neededPlace; i > 0; i--)
            {
                foreach (Rooms room in allRooms)
                {
                    if (room.getPlace() == i)
                    {
                        list.Add(room);
                    }
                }
            }

            return list;
        }
    }
}
