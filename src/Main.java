//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Product product1 = new Product("Notebook", 12.5, 3);
        Product product2 = new Product("Pen", 4, 2);
        Product product3 = new Product("Bottle", 30, 0);
        Store store = new Store("Shain Inc.", 3);
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.printAvailableProducts();

        Product product4 = new Product("Bamba", 10, 5);
        store.addProduct(product4);
        store.printAvailableProducts();
        //failed

        store.sellProduct(product1.getId(), 2);
        store.sellProduct(product2.getId(), 3);//failed
        System.out.println(product2.getInfo());
        store.sellProduct(product2.getId(), 2);//succeeded
        System.out.println(product2.getInfo());

        product3.setPrice(-5);
        System.out.println(product3.getPrice());

        System.out.println("Final data: \n");
        store.printAvailableProducts();
        store.printSalesReport();
        System.out.println("Total sold: " + store.getTotalSold());
        System.out.println(product1.getId());
        System.out.println(product2.getId());
        System.out.println(product3.getId());
        System.out.println(Product.getNextId());
    }
}
