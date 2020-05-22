package main.java.util;

public class Query {
    public static final String SELECT_ADMIN_FROM_USER = "select username, password from user where role_id = 2;";
    public static final String SELECT_INFORMATION_FROM_USER = "select * from user where status <> -1;";
    public static final String SELECT_USER_WITH_ID = "select * from user where id = ?;";
    public static final String SELECT_CLIENT_WITH_ROLE = "select username, password from user where role_id <> 2 and status <> -1 and status <> 0;";
    public static final String CREATE_USER_WITH_PARAMETERS = "insert into user (role_id, first_name, last_name, gender, date_of_birth, phone, address, email, username, password, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_USER_WITH_ID = "update user set role_id = ?, first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, phone = ?, address = ?, email = ?, username = ?, password = ?, status = ? where id = ?;";
    //    public static final String DELETE_USER_WITH_ID = "delete from user where id = ?;";
    public static final String DELETE_USER_WITH_ID = "update user set status = -1 where id = ?;";

    public static final String SELECT_ALL_PRODUCT = "SELECT *\n" +
            "FROM product_detail\n" +
            "         JOIN product on product_detail.product_id = product.id\n" +
            "         JOIN catalog on product.catalog_id = catalog.id\n" +
            "         JOIN size on product_detail.size_id = size.id\n" +
            "WHERE product_detail.status != -1;";

    public static final String SELECT_PRODUCT_FOR_HOMEPAGE = "SELECT * FROM product\n" +
            "JOIN attachment ON product.id = attachment.product_id\n" +
            "JOIN catalog ON product.catalog_id = catalog.id" ;


    public static final String SELECT_ALL_IMAGE_FROM_PRODUCT = "SELECT * FROM attachment\n" +
            "WHERE product_id = ?;";

    public static final String SELECT_PRODUCT_BY_DETAIL_ID = "SELECT *\n" +
            "FROM product_detail\n" +
            "         JOIN product on product_detail.product_id = product.id\n" +
            "         JOIN catalog on product.catalog_id = catalog.id\n" +
            "         JOIN size on product_detail.size_id = size.id " +
            "WHERE product_detail.id = ?;";

    public static final String SELECT_PRODUCT_BY_PRODUCT_ID = "SELECT *\n" +
            "FROM product_detail\n" +
            "         JOIN product on product_detail.product_id = product.id\n" +
            "         JOIN catalog on product.catalog_id = catalog.id\n" +
            "         JOIN size on product_detail.size_id = size.id " +
            "WHERE product.id = ?;";

    public static final String SELECT_PRICE_BY_PRODUCT_ID = "SELECT * FROM product\n" +
            "JOIN sale ON product.id = sale.product_id\n" +
            "WHERE product.id = ?\n" +
            "ORDER BY created_date DESC LIMIT 1;";

    public static final String SELECT_SIZE_BY_PRODUCT_ID = "SELECT size FROM product_detail\n" +
            "JOIN size ON product_detail.size_id = size.id\n" +
            "WHERE product_id = ?";

    public static final String SELECT_IMPORT_BY_PRODUCT_ID = "SELECT * FROM import\n" +
            "JOIN product_detail on import.product_detail_id = product_detail.id\n" +
            "WHERE product_detail_id = ?;";

    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product" +
            "    (catalog_id, product_name, description, status)" +
            "VALUES (?, ?, ?, ?);";

    public static final String SELECT_NEW_PRODUCT = "SELECT product.id FROM product ORDER BY id DESC LIMIT 1;";

    public static final String INSERT_PRODUCT_SIZE = "INSERT INTO product_detail" +
            "    (product_id, size_id)" +
            "VALUES (?, " +
            "(SELECT size.id FROM size WHERE size = ?));";

    public static final String INSERT_PRODUCT_IMAGE = "INSERT INTO attachment (product_id, image_link, status) VALUES (?,?,?)";

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

    public static final String SELECT_FROM_SIZE = "SELECT * FROM size";

    public static final String SELECT_FROM_CATALOG = "SELECT * FROM catalog";

    public static final String SELECT_PRODUCT_BY_CATALOG_ID = "SELECT * " +
            "FROM product_detail\n" +
            "         JOIN product on product_detail.product_id = product.id\n" +
            "         JOIN catalog on product.catalog_id = catalog.id\n" +
            "         JOIN size on product_detail.size_id = size.id\n" +
            "WHERE catalog_id = ?;";
}
