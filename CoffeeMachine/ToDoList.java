package CoffeeMachine;
public interface ToDoList {
    void holdOn() throws InterruptedException;
    void toList() throws InterruptedException;
    void addMilk() throws InterruptedException;
    void addSugar() throws InterruptedException;
    void exit();
    void coffeeSize() throws InterruptedException;
    void bill() throws InterruptedException;
}
