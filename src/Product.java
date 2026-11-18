public class Product
{
   private String name;
   private double price;
   private int stock;
   private int id;
   private static int nextId = 1000;

    public boolean setName(String name)
    {
        if(isValidName(name))
        {
            this.name = name;
            return true;
        }
        else
        {
            this.name = "Unknown";
            return false;
        }
    }

    public boolean setPrice(double price)
    {
        if(isValidPrice(price))
        {
            this.price = price;
            return true;
        }
        return false;
    }

    public boolean setStock(int stock)
    {
        if(stock>0)
        {
            this.stock = stock;
            return true;
        }
        else
        {
            this.stock = 0;
            return false;
        }
    }

    public Product(String name, double price, int stock)
    {
        this.id = nextId++;

        setName(name);
        if(isValidPrice(price))
        {
            this.price = price;

        }
        else
        {
            this.price = 1.0;

        }
        setStock(stock);
    }

    private boolean isValidPrice(double price)
    {
        if(price<=0)
        {
            return false;
        }
        return true;
    }

    private boolean isValidName(String name)
    {
        if(name==null||name.isEmpty()||name.replaceAll(" ", "").isEmpty())
        {
            return false;
        }
        return true;
    }

    public boolean sell(int quantity)
    {
        if(quantity<=0)return false;
        if(stock<quantity)return false;
        this.stock -= quantity;
        return true;
    }

    public String getInfo()
    {
        String s = "Product number: " + this.id + " Product name: " + this.name + " Product price: " + this.price + " Product stock: " + this.stock;
        return s;
    }

    public static int getNextId()
    {
        return nextId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }
}
