create table BRAND
(
    ID   INT auto_increment,
    NAME VARCHAR not null,
    constraint BRAND_PK
        primary key (ID)
);

create table CAR
(
    ID         INT auto_increment,
    MODEL_NAME VARCHAR not null,
    COLOR_NAME VARCHAR not null,
    constraint CAR_PK
        primary key (ID),
    constraint CAR_BRAND_ID_FK
        foreign key (ID) references BRAND (ID)
);

create table PRICE
(
    ID         INT auto_increment,
    START_TIME TIMESTAMP not null,
    END_TIME   TIMESTAMP not null,
    COST       FLOAT     not null,
    constraint PRICE_PK
        primary key (ID),
    constraint PRICE_CAR_ID_FK
        foreign key (ID) references CAR (ID)
);

