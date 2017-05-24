using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace HotelReservation
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        RoomList roomList = new RoomList();
        Rooms room = new Rooms();

            Rooms room1 = new Rooms();

            Rooms room2 = new Rooms();

            Rooms room3 = new Rooms();


            List<Rooms> list = new List<Rooms>();
        public MainWindow()
        {
            InitializeComponent();

            Application.Current.MainWindow.Width = 250;
            Application.Current.MainWindow.Height = 150;

            WelcomeGrid.Visibility = Visibility.Visible;
            RoomsListGrid.Visibility = Visibility.Hidden;
            RoomDetailsGrid.Visibility = Visibility.Hidden;

            room.idRoom = 1;
            room.seats = 2;
            room.price = 100;

            room1.idRoom = 2;
            room1.seats = 4;
            room1.price = 200;

            room2.idRoom = 3;
            room2.seats = 6;
            room2.price = 500;

            room3.idRoom = 4;
            room3.seats = 3;
            room3.price = 250;

            list.Add(room);
            list.Add(room1);
            list.Add(room2);
            list.Add(room3);

        }
        private static bool IsTextAllowed(string text)
        {
            Regex regex = new Regex("[^0-9]+"); 
            return !regex.IsMatch(text);
        }

        private void buttonShowRooms_Click(object sender, RoutedEventArgs e)
        {
            if (IsTextAllowed(textBoxNumberOfPeople.Text) == true)
            {
                labelWarning.Content = "";

                Application.Current.MainWindow.Width = 300;
                Application.Current.MainWindow.Height = 600;

                WelcomeGrid.Visibility = Visibility.Hidden;
                RoomsListGrid.Visibility = Visibility.Visible;
                List<Rooms> tempList = roomList.PrepereList(Int32.Parse(textBoxNumberOfPeople.Text),list);

                foreach(Rooms rom in tempList)
                {
                    listBoxRoomsList.Items.Add(room.idRoom+"  "+room.seats+"  "+room.price);
                }

            }else
            {
                labelWarning.Content = "Wprowadź prawidłową wartość!";
            }
        }

        private void buttonBackToWelcome_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.MainWindow.Width = 250;
            Application.Current.MainWindow.Height = 150;

            RoomsListGrid.Visibility = Visibility.Hidden;
            WelcomeGrid.Visibility = Visibility.Visible;
        }

        private void buttonRoomBooking_Click(object sender, RoutedEventArgs e)
        {
            if (listBoxRoomsList.SelectedIndex != -1)
            {
                Application.Current.MainWindow.Width = 250;
                Application.Current.MainWindow.Height = 200;

                RoomsListGrid.Visibility = Visibility.Hidden;
                RoomDetailsGrid.Visibility = Visibility.Visible;
            }
                      
        }

        private void buttonBackToRoomsList_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.MainWindow.Width = 300;
            Application.Current.MainWindow.Height = 600;

            RoomDetailsGrid.Visibility = Visibility.Hidden;
            RoomsListGrid.Visibility = Visibility.Visible;

        }

        private void ListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
    }
}
