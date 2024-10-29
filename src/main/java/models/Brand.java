package models;

public class Brand {
    private final int id;
    private String brandName;
    private static int count = 1;

    public Brand() {
        this.id = count++;
    }

    public Brand(String brandName) {
        this.id = count++;
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }
}
