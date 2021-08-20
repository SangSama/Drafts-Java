package buoi15.generic;

public class BondBusiness extends BaseBusiness<Bond>{

    @Override
    public void execute(Bond business) {
        System.out.println("Tên cổ phiếu: " + business.getName());
    }
}
