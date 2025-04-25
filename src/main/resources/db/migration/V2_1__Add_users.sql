insert into users values (1,'Jons', now(), '$2a$12$5bw2tWR.BVHOFNi6bAO.POugHeoF5GQRKAI3iKEZwUTQWWqZ6CMs.');
insert into users values (2,'Jenna', now(), '$2a$12$5bw2tWR.BVHOFNi6bAO.POugHeoF5GQRKAI3iKEZwUTQWWqZ6CMs.');
insert into users values (3,'Stanislav', now(), '$2a$12$5bw2tWR.BVHOFNi6bAO.POugHeoF5GQRKAI3iKEZwUTQWWqZ6CMs.');
insert into users values (4,'Viktor', now(), '$2a$12$5bw2tWR.BVHOFNi6bAO.POugHeoF5GQRKAI3iKEZwUTQWWqZ6CMs.');

insert into email_data values (1, 1, 'jons@gmail.com');
insert into email_data values (2, 2, 'jenna@gmail.com');
insert into email_data values (3, 3, 'stanislav@gmail.com');
insert into email_data values (4, 4, 'viktor@gmail.com');

insert into phone_data values (1,1,'7345123416474');
insert into phone_data values (2,2,'7345123416475');
insert into phone_data values (3,3,'7345123416476');
insert into phone_data values (4,4,'7345123416477');

insert into account values (1,1,100.1);
insert into account values (2,2,321.53);
insert into account values (3,3,5432.6);
insert into account values (4,4,743.32);

insert into deposit values (1, true, 1,100.1,0.1,2.07);
insert into deposit values (2, true, 2,321.53,0.1,2.07);
insert into deposit values (3, true, 3,5432.6,0.1,2.07);
insert into deposit values (4, true, 4,743.32,0.1,2.07);

update users set account_id = 1 where id = 1;
update users set account_id = 2 where id = 2;
update users set account_id = 3 where id = 3;
update users set account_id = 4 where id = 4;