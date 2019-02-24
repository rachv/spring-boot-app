insert into user values(10001,'user1', 'Jane', 'Doe');
insert into user values(10002,'user2', 'John', 'Smith');
insert into account values(20001, '1111-1111', 'USD Savings', 'SAVINGS', CURRENT_TIMESTAMP, 'USD', 1000.00, 10001);
insert into account values(20002, '1111-1112', 'SGD Savings', 'SAVINGS', CURRENT_TIMESTAMP, 'SGD', 2000.00, 10001);
insert into account values(20003, '2222-2221', 'USD Savings', 'SAVINGS', CURRENT_TIMESTAMP, 'USD', 4000.00, 10002);
insert into account values(20004, '2222-2222', 'SGD Savings', 'SAVINGS', CURRENT_TIMESTAMP, 'SGD', 4000.00, 10002);
insert into account_transaction values(30001, 1000.00, null, 'some description', 'CREDIT', CURRENT_TIMESTAMP, 20001);
insert into account_transaction values(30002, null, 2000, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20001);
insert into account_transaction values(30003, 2000.00, null, 'some description', 'CREDIT', CURRENT_TIMESTAMP, 20002);
insert into account_transaction values(30004, 2000.00, null, 'some description', 'CREDIT', CURRENT_TIMESTAMP, 20002);
insert into account_transaction values(30005, null, 1000.00, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20002);
insert into account_transaction values(30006, null, 1000.00, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20002);
insert into account_transaction values(30007, null, 1000.00, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20003);
insert into account_transaction values(30008, null, 1000.00, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20003);
insert into account_transaction values(30009, null, 1000.00, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20003);
insert into account_transaction values(30010, null, 1000.00, 'some description', 'DEBIT', CURRENT_TIMESTAMP, 20003);