package main.java.util;

public class Query {
    public static final String SELECT_ADMIN_FROM_USER = "select username, password from user where role_id = 2;";

    public static final String SELECT_ALL_PRODUCTS = "SELECT product.id,\n" +
            "       product.product_code,\n" +
            "       product.product_name,\n" +
            "       catalog.id           AS brand_id,\n" +
            "       catalog.catalog_code AS brand_code,\n" +
            "       catalog.name         AS brand_name,\n" +
            "       product.size,\n" +
            "       product.description,\n" +
            "       CASE product.status\n" +
            "           WHEN product.status = 1 THEN 'Đang kinh doanh'\n" +
            "           WHEN product.status = 0 THEN 'Không kinh doanh'\n" +
            "           ELSE 'Sản phẩm lỗi'\n" +
            "           END              AS status\n" +
            "FROM product\n" +
            "         JOIN catalog on product.catalog_id = catalog.id;";

    public static final String SELECT_ALL_IMAGES = "SELECT attachment.product_id, attachment.image_link\n" +
            "FROM attachment\n" +
            "         JOIN product on attachment.product_id = product.id\n" +
            "WHERE attachment.status = 1;\n";
}
