public class Store
{
    private String StoreName;
    private Product[] products;
    private int[] soldCount;
    private int productCount;

    public Store(String storeName, int capacity)
    {
        this.StoreName = storeName;
        products = new Product[capacity];
        soldCount = new int[capacity];
        for (int i = 0; i < capacity; i++)
        {
            soldCount[i] = 0;
        }
    }

    public void addProduct(Product product)
    {
        if(product==null)return;
        if(findProductIndex(product.getId())!=-1)return;
        for (int i = 0; i < products.length; i++)
        {
            if(products[i]==null)
            {
                products[i]=product;
                break;
            }

        }
    }

    private int findProductIndex(int id)
    {
        int i = 0;
        int pIndex = -1;
        while(products.length > i)
        {
            if(products[i]==null)break;
            if(products[i].getId()==id)
            {
                pIndex = i;
                break;
            }
            i++;
        }
        return pIndex;
    }

    public boolean sellProduct(int id, int quantity)
    {
        int index = findProductIndex(id);
        if(index == -1)return false;
        boolean status = products[index].sell(quantity);
        if(status)
        {
            soldCount[index]+=quantity;
        }
        return status;
    }

    public void printAvailableProducts()
    {
        for (Product product : products)
        {
            if(product==null)break;
            if(product.getStock()==0)continue;
            System.out.println(product.getInfo() + "\n");
        }
    }

    public void printSalesReport()
    {
        System.out.println(StoreName);
        for (int i = 0; i < products.length; i++)
        {
            if(products[i]==null)break;
            System.out.println("Name: " + products[i].getName() + "Amount sold: " + soldCount[i] + "\n");
        }
    }

    public int getTotalSold()
    {
        int sum = 0;
        for (int i = 0; i < products.length; i++)
        {
            if(products[i]==null)break;
            sum += soldCount[i];
        }
        return sum;
    }








}
