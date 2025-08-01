import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    public boolean addProduct(Product product) {
        if (product.getPrice() <= money) {
            products.add(product);
            money -= product.getPrice();
            return true;
        } else {
            return false;

        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("-");
        if (products.isEmpty()){
            sb.append("Ничего не куплено");
        }else {
            for (Product product : products){
                sb.append(product.getName()).append(",");
            }
             sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o== null||getClass()!=o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money)==0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(products,person.products);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,money,products);
    }
}
