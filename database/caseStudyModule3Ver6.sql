create table catalog
(
    id           int auto_increment
        primary key,
    catalog_code int                                null,
    name         varchar(255)                       not null,
    description  text                               null,
    status       int                                not null,
    create_date  datetime default CURRENT_TIMESTAMP null,
    update_date  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create table product
(
    id           int auto_increment
        primary key,
    catalog_id   int                                not null,
    product_code int                                not null,
    product_name varchar(255)                       not null,
    size         float                              not null,
    image_link   text                               not null,
    description  text                               null,
    status       int                                not null,
    create_date  datetime default CURRENT_TIMESTAMP null,
    update_date  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint product_catalog_fk
        foreign key (catalog_id) references catalog (id)
)
    charset = utf8;

create table attachment
(
    id          int                                not null
        primary key,
    product_id  int                                not null,
    image_link  text                               not null,
    status      int                                not null,
    create_date datetime default CURRENT_TIMESTAMP null,
    update_date datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint attachment_product_fk
        foreign key (product_id) references product (id)
)
    charset = utf8;

create table import
(
    id           int auto_increment
        primary key,
    product_id   int                                not null,
    quantity     int                                not null,
    bid          double                             not null,
    import_date  datetime                           not null,
    export_date  datetime                           null,
    status       int                                not null,
    created_date datetime default CURRENT_TIMESTAMP null,
    update_date  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint import_product_fk
        foreign key (product_id) references product (id)
)
    charset = utf8;

create table role
(
    id          int auto_increment
        primary key,
    role_name   varchar(255)                       not null,
    status      int                                not null,
    create_date datetime default CURRENT_TIMESTAMP null,
    update_date datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create table sale
(
    id           int auto_increment
        primary key,
    product_id   int                                not null,
    price        double                             not null,
    status       int                                not null,
    created_date datetime default CURRENT_TIMESTAMP null,
    update_date  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint export_product_fk
        foreign key (product_id) references product (id)
)
    charset = utf8;

create table user
(
    id            int auto_increment
        primary key,
    role_id       int                                not null,
    first_name    varchar(255)                       not null,
    last_name     varchar(255)                       not null,
    gender        bit                                not null,
    date_of_birth date                               not null,
    phone         varchar(30)                        not null,
    address       varchar(255)                       not null,
    email         varchar(255)                       not null,
    username      varchar(255)                       not null,
    password      varchar(50)                        not null,
    status        int                                not null,
    created_date  datetime default CURRENT_TIMESTAMP null,
    update_date   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint user_role_fk
        foreign key (role_id) references role (id)
)
    charset = utf8;

create table bill
(
    id              int auto_increment
        primary key,
    user_id         int                                not null,
    amount          double                             not null,
    message         text                               null,
    discount        double                             null,
    shipping_fee    double                             null,
    payment         varchar(255)                       not null,
    date_of_payment datetime                           not null,
    status          int      default 0                 not null,
    create_date     datetime default CURRENT_TIMESTAMP null,
    update_date     datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint cart_shopping_user_fk
        foreign key (user_id) references user (id)
)
    charset = utf8;

create table bill_details
(
    id          int auto_increment
        primary key,
    bill_id     int                                not null,
    product_id  int                                not null,
    quantity    int                                not null,
    price       double                             not null,
    create_date datetime default CURRENT_TIMESTAMP null,
    update_date datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint cart_details_cart_shopping_fk
        foreign key (bill_id) references bill (id),
    constraint cart_details_product_fk
        foreign key (product_id) references product (id)
)
    charset = utf8;

