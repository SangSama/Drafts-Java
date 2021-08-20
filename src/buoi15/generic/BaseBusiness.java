package buoi15.generic;

import java.util.HashMap;
import java.util.Map;

// design comment pattern
public abstract class BaseBusiness<T> implements Business<T> {
    // chứa map => ctdl : key - value
    // map => key mở khóa ra value  >> Map(K,V) : K,V là đại diện <=> Generic <<
    // String : kiểu dữ liệu của Key
    private static Map<String, Business> map = new HashMap<>();

    static {
        map.put(CKConstant.BOND, new BondBusiness());
        map.put(CKConstant.FUND, new FundBusiness());
    }

    public static Business get(String key) {
        return map.get(key); // lấy đc value tương ứng với key
    }
}
