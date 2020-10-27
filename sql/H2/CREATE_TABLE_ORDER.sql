CREATE TABLE ORDER_BOOK(
    ORDER_ID INT NOT NULL,
    DATE_CREATED DATE NOT NULL,
    STATUS NVARCHAR2(50) NOT NULL,
    DELIVERY_ADDRESS NVARCHAR2(50) NOT NULL,
    COUNT INT NOT NULL,
    PRICE INT NOT NULL,
    CLIENT INT,
    PRIMARY KEY (ORDER_ID),
    FOREIGN KEY (CLIENT) REFERENCES CLIENT(CLIENT_ID)
);