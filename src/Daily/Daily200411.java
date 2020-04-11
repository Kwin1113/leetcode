package Daily;

import java.util.*;

/**
 * @author Kwin
 * @since 2020/4/11 20:32
 * <p>
 * 1169. 查询无效交易
 * <p>
 * 如果出现下述两种情况，交易 可能无效：
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * <p>
 * 示例 2：
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * <p>
 * 示例 3：
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 * <p>
 * 提示：
 * transactions.length <= 1000
 * 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
 * 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
 * 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数
 */
public class Daily200411 {

    static String[] transactions1 = new String[]{"alice,20,800,mtv", "alice,50,100,beijing"};
    static String[] transactions2 = new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"};
    static String[] transactions3 = new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"};
    static String[] transactions4 = new String[]{"alice,20,800,mtv", "alice,50,100,beijing", "alice,60,100,zhejiang"};
    static String[] transactions5 = new String[]{"bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"};

    public static void main(String[] args) {
//        System.out.println(solution1(transactions1).toString());
//        System.out.println(solution1(transactions2).toString());
//        System.out.println(solution1(transactions3).toString());
//        System.out.println(solution1(transactions4).toString());
        System.out.println(solution1(transactions5).toString());
    }

    static List<String> solution1(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        Set<String> invalid = new HashSet<>();
        for (String transaction : transactions) {
            Transaction e = new Transaction(transaction);
            if (e.getAmount() > 1000) {
                invalid.add(transaction);
            }
            List<Transaction> transactionsByName = map.getOrDefault(e.getName(), new ArrayList<>());
            transactionsByName.add(e);
            map.put(e.getName(), transactionsByName);
        }

        for (List<Transaction> value : map.values()) {
            if (value.size() > 1) {
                for (int i = 0; i < value.size(); i++) {
                    for (int j = i + 1; j < value.size(); j++) {
                        Transaction e1 = value.get(i);
                        Transaction e2 = value.get(j);
                        if (Math.abs(e1.getTime() - e2.getTime()) <= 60 && !e1.getCity().equals(e2.getCity())) {
                            invalid.add(e1.toString());
                            invalid.add(e2.toString());
                        }
                    }
                }
            }
        }
        return new ArrayList<>(invalid);
    }

    static class Transaction {
        private String name;
        private Integer time;
        private Integer amount;
        private String city;

        public Transaction(String str) {
            String[] split = str.split(",");
            this.name = split[0];
            this.time = Integer.valueOf(split[1]);
            this.amount = Integer.valueOf(split[2]);
            this.city = split[3];
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return this.name + "," + this.time + "," + this.amount + "," + this.city;
        }

    }

}
