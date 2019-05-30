package src.src.main;

public class Car {

    private final String name;
    private final int price;

    public Car(String name,int price){
        this.name=name;
        this.price=price;
    }
    public int getPrice()
    {
        return price;
    }
    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("src.src.main.Car{name=").append(name).append(", price=")
                .append(price).append("}");

        return builder.toString();
    }

}
