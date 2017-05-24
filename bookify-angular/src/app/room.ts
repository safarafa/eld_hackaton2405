export class Room {
    private numberOfRooms: number;
    private numberOfPeople: number;
    private price: number;
    private location: String;
    private hotel: String;

    constructor(numberOfRooms: number, numberOfPeople: number, price: number, location: String,
    hotel: String) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfPeople = numberOfPeople;
        this.price = price;
        this.location = location;
        this.hotel = hotel;
    }
}
