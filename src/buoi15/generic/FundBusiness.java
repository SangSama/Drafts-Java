package buoi15.generic;

public class FundBusiness extends BaseBusiness<Fund> {
    @Override
    public void execute(Fund business) {
        System.out.println("Gía trị trái phiếu: " + business.getBalance());
    }
}
