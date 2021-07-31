package buoi11;

public class ManageAnimal {
    /*
    * dependency injection
    * => phu thuộc vào thằng trừu tượng thay vì phụ thuộc vào 1 thằng cục thể
    *
    * Thay vì quản lý từng mảng đối tượng DOg, Cat, thì t quản lý Animal nhờ vào tính kế thừa
    * */

    private Animal[] animals;

    public ManageAnimal(Animal[] animals) {
        this.animals = animals;
    }
}
