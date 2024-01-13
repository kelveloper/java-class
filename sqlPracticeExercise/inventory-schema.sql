drop database if exists inventory;
create database inventory;

use inventory;

create table store(
id int primary key auto_increment,
`name` varchar(30) not null,
`location` varchar(50) not null,
`manager` varchar(100));

create table product(
id int primary key auto_increment,
`name` varchar(30) not null,
`description` varchar(255),
quantity int not null default 0,
storeId int not null,
foreign key (storeId) references store(id));

create table supplier(
id int primary key auto_increment,
`name` varchar(50) not null,
`address` varchar(255),
`contact` varchar(50));

create table product_supplier(
productId int not null,
supplierId int not null,
primary key(productId, supplierId),
foreign key (productId) references product(id),
foreign key (supplierId) references supplier(id));