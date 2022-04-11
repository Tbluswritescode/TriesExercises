import Solution4.Solution.MapSum;

public class Main {

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        obj.insert("a", 7);
        int param_2 = obj.sum("app");
        System.out.println(param_2);
    }
}
