create table if not exists catalog
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

create table if not exists product
(
    id           int auto_increment
        primary key,
    catalog_id   int                                not null,
    product_name varchar(255)                       not null,
    description  text                               null,
    status       int                                not null,
    create_date  datetime default CURRENT_TIMESTAMP null,
    update_date  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint product_catalog_fk
        foreign key (catalog_id) references catalog (id)
)
    charset = utf8;

create table if not exists attachment
(
    id          int auto_increment
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

create table if not exists role
(
    id          int auto_increment
        primary key,
    role_name   varchar(255)                       not null,
    status      int                                not null,
    create_date datetime default CURRENT_TIMESTAMP null,
    update_date datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create table if not exists size
(
    id          int auto_increment
        primary key,
    size        float                              not null,
    status      int                                null,
    create_date datetime default CURRENT_TIMESTAMP null,
    update_date datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table if not exists product_detail
(
    id          int auto_increment
        primary key,
    product_id  int                                null,
    size_id     int                                null,
    create_date datetime default CURRENT_TIMESTAMP null,
    update_date datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    status      int      default 1                 not null,
    constraint size_detail_product_fk
        foreign key (product_id) references product (id),
    constraint size_detail_size_fk
        foreign key (size_id) references size (id)
);

create table if not exists import
(
    id                int auto_increment
        primary key,
    product_detail_id int                                not null,
    product_code      varchar(50)                        null,
    bid               double                             not null,
    import_date       datetime                           not null,
    status            int                                not null,
    created_date      datetime default CURRENT_TIMESTAMP null,
    update_date       datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint import_product_code_uindex
        unique (product_code),
    constraint import_product_fk
        foreign key (product_detail_id) references product_detail (id)
)
    charset = utf8;

create table if not exists sale
(
    id           int auto_increment
        primary key,
    product_id   int                                not null,
    price        double                             not null,
    status       int                                not null,
    created_date datetime default CURRENT_TIMESTAMP null,
    update_date  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint sale_product_detail_fk
        foreign key (product_id) references product_detail (id)
)
    charset = utf8;

create table if not exists user
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

create table if not exists bill
(
    id              int auto_increment
        primary key,
    user_id         int                                not null,
    message         text                               null,
    discount        double                             null,
    shipping_fee    double                             null,
    payment         varchar(255)                       not null,
    date_of_payment datetime                           not null,
    status          int      default 0                 not null,
    create_date     datetime default CURRENT_TIMESTAMP null,
    update_date     datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint bill_user_fk
        foreign key (user_id) references user (id)
)
    charset = utf8;

create table if not exists bill_details
(
    id                int auto_increment
        primary key,
    bill_id           int                                not null,
    product_detail_id int                                not null,
    quantity          int                                not null,
    price             double                             not null,
    create_date       datetime default CURRENT_TIMESTAMP null,
    update_date       datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint bill_details_cart_shopping_fk
        foreign key (bill_id) references bill (id),
    constraint bill_details_product_detail_fk
        foreign key (product_detail_id) references product_detail (id)
)
    charset = utf8;

