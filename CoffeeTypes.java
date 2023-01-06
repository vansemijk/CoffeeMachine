package CoffeeMachine;

public class CoffeeTypes {
    private String size = "";
    private int price = 0;

    public CoffeeTypes(){
    }

    public CoffeeTypes(String size,int price){
        this.size = size;
        this.price = price;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int x){
        if (x == 1){
            if (Steps.whichCoffee.equalsIgnoreCase("Espresso")){
                price = 25;
            }
            else if (Steps.whichCoffee.equalsIgnoreCase("Americano")){
                price = 20;
            }
            else if (Steps.whichCoffee.equalsIgnoreCase("Latte")){
                price = 30;
            }
        }
    }
    @Override
    public String toString() {
        return "Size='" + size + '\'' + ",Price='" + price + '}';
    }
}