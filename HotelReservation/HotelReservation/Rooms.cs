using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation
{
    public class Rooms
    {
        int idRoom;
        int roomPlace;

        void setPlace(int roomPlace)
        {
            this.roomPlace = roomPlace;
        }

        public int getPlace()
        {
            return roomPlace;
        }

        void setId(int idRoom)
        {
            this.idRoom = idRoom;
        }

        int getId()
        {
            return roomPlace;
        }

      
    }
}
