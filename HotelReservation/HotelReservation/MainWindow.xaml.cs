using System;
using System.Collections.Generic;
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

        public MainWindow()
        {
            InitializeComponent();

            Application.Current.MainWindow.Width = 250;
            Application.Current.MainWindow.Height = 150;

            WelcomeGrid.Visibility = Visibility.Visible;
            RoomsListGrid.Visibility = Visibility.Hidden;
            RoomDetailsGrid.Visibility = Visibility.Hidden;



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
