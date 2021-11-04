package buoi12;

public class HolidayTravel {
    private Travel travel;

    public HolidayTravel(Travel travel) {
        this.travel = travel;
    }

    public void travel() {
        travel.move();
        // Default Method in JAVA 8
        travel.print();
    }
}
