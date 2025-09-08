package beverages_decorator;

public class Client {
    public static void main(String[] args) {
        // Plain Cappuccino
        Beverage coffee = new Cappuccino();
        System.out.println("Cappuccino: " + coffee.cost());

        // Cappuccino + Milk
        Beverage coffeeWithMilk = new Milk(new Cappuccino());
        System.out.println("Cappuccino + Milk: " + coffeeWithMilk.cost());

        // Latte + Sugar + Whipped Cream
        Beverage fancyLatte = new WhippedCream(new Sugar(new Latte()));
        System.out.println("Latte + Sugar + WhippedCream: " + fancyLatte.cost());

        // Cappuccino + Milk + Sugar + Whipped Cream
        Beverage superCoffee = new WhippedCream(new Sugar(new Milk(new Cappuccino())));
        System.out.println("Cappuccino + Milk + Sugar + WhippedCream: " + superCoffee.cost());
    }
}