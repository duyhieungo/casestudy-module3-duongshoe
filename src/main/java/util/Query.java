package main.java.util;

public class Query {
    public static final String SELECT_ADMIN_FROM_USER = "select username, password from user where role_id = 2;";
    public static final String SELECT_INFORMATION_FROM_USER = "select * from user;";

    public static final String SELECT_ALL_PRODUCT = "SELECT * FROM product_detail\n" +
            "JOIN product on product_detail.product_id = product.id\n" +
            "JOIN catalog on product.catalog_id = catalog.id\n" +
            "JOIN size on product_detail.size_id = size.id";

    public static final String SELECT_ALL_IMAGE_FROM_PRODUCT = "SELECT * FROM attachment\n" +
            "WHERE product_id = ?;";

    public static final String SELECT_PRODUCT_BY_ID = "SELECT *\n" +
            "FROM product_detail\n" +
            "         JOIN product on product_detail.product_id = product.id\n" +
            "         JOIN catalog on product.catalog_id = catalog.id\n" +
            "         JOIN size on product_detail.size_id = size.id " +
            "WHERE product_detail.id = ?;";

    public static final String SELECT_IMPORT_BY_PRODUCT_ID = "SELECT * FROM import\n" +
            "JOIN product_detail on import.product_detail_id = product_detail.id\n" +
            "WHERE product_detail_id = ?;";

    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product" +
            "    (catalog_id, product_name, description, status)" +
            "VALUES (?, ?, ?, ?);";

    public static final String INSERT_PRODUCT_SIZE = "INSERT INTO product_detail" +
            "    (product_id, size_id)" +
            "VALUES ((SELECT product.id FROM product ORDER BY id DESC LIMIT 1), " +
            "(SELECT size.id FROM size WHERE size = ?));";

    public static final String INSERT_PRODUCT_IMAGE = "INSERT INTO attachment(product_id, image_link, status) " +
            "VALUES ((SELECT product.id FROM product ORDER BY id DESC LIMIT 1),?,1);";

    public static final String UPDATE_PRODUCT = "UPDATE product\n" +
            "SET catalog_id = ?,\n" +
            "    product_name = ?,\n" +
            "    description = ?,\n" +
            "    status = ?\n" +
            "WHERE id = ?;";

    public static final String UPDATE_PRODUCT_SIZE = "UPDATE product_detail\n" +
            "SET size_id = (SELECT id FROM size WHERE size.size = ?)\n" +
            "WHERE id = ?;";

    public static final String SELECT_ATTACHMENT_ID_BY_PRODUCT_ID = "SELECT id FROM attachment\n" +
            "WHERE product_id = ?;";

    public static final String UPDATE_PRODUCT_IMAGE = "UPDATE attachment\n" +
            "SET image_link = ? \n" +
            "WHERE id = ?;";
}
