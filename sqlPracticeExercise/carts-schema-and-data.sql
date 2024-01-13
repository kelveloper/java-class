drop database if exists carts;

create database carts;

use carts;

create table cart(
	cart_id int primary key auto_increment,
    cart_name varchar(255)
);

create table item(
	item_id int primary key auto_increment,
    item_name varchar(255),
	cart_id int,
    Foreign key (cart_id) references cart(cart_id)

);

insert into cart(Cart_name) values ("Cart 1");
insert into cart(Cart_name) values ("Cart 2");
insert into cart(Cart_name) values ("Cart 3");
insert into cart(Cart_name) values ("Cart 4");
insert into cart(Cart_name) values ("Cart 5");
insert into cart(Cart_name) values ("Cart 6");

insert into item(item_name, cart_id) values ("Desktop PC", 1);
insert into item(item_name, cart_id) values ("Laptop", 1);
insert into item(item_name, cart_id) values ("Pencil", 1);
insert into item(item_name, cart_id) values ("Pen", 2);
insert into item(item_name, cart_id) values ("Apple", 2);
insert into item(item_name, cart_id) values ("Orange", 3);
insert into item(item_name, cart_id) values ("Clock", 3);
insert into item(item_name, cart_id) values ("JPA Book", 3);
insert into item(item_name, cart_id) values ("Reading glasses", 4);
insert into item(item_name, cart_id) values ("Baseball cap", 4);
insert into item(item_name, cart_id) values ("T-Shirt", 5);
insert into item(item_name, cart_id) values ("Running shoes", 5);
insert into item(item_name, cart_id) values ("Pepsi", 6);
insert into item(item_name, cart_id) values ("Helmut", 6);