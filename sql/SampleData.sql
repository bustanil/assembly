insert into category (id, name, label) values(1, 'root', 'root');

insert into category (id, name, label, parent_id) values(2, 'intel', 'Intel', 1);
insert into category (id, name, label, parent_id) values(3, 'amd', 'Intel', 1);
insert into category (id, name, label, parent_id) values(4, 'price', 'Price', 1);
insert into category (id, name, label, parent_id) values(5, 'performance', 'Performance', 1);

insert into category (id, name, label, parent_id) values(6, 'core2duo', 'Intel', 2);
insert into category (id, name, label, parent_id) values(7, 'corei3', 'Core i3', 2);
insert into category (id, name, label, parent_id) values(8, 'corei5', 'Core i5', 2);
insert into category (id, name, label, parent_id) values(9, 'corei7', 'Core i7', 2);

insert into category (id, name, label, parent_id) values(10, 'athlon', 'Athlon', 3);
insert into category (id, name, label, parent_id) values(11, 'phenom', 'Phenom', 3);
insert into category (id, name, label, parent_id) values(12, 'opteron', 'Opteron', 3);

