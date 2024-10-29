package DAO;

import models.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    private static final List<Brand> brands = new ArrayList<>();

    public static List<Brand> getAllBrands() {
        return brands;
    }

    public static Brand getBrandById(int id) {
        return brands.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public static void addBrand(String brandName) {
        Brand brand = new Brand(brandName);
        brands.add(brand);
    }
}
