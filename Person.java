import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;
    public Person (String name, double money){
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void setName (String name){
        if (name ==null || name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length()<3){
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.name=name;
    }
    public double getMoney (){
        return money;
    }
    public void setMoney(double money){
        if (money<0){
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money=money;
    }
    public void addProduct (Product product){

    }
}
