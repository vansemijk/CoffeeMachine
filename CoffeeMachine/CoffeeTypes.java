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
    @Override
    public String toString() {
        return "Size='" + size + '\'' + ",Price='" + price + '}';
    }

	public void setBill(int i) {
		// TODO Auto-generated method stub
		Steps.totalBill += i;
	}
}