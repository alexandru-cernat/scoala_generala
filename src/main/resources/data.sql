INSERT INTO clase (nume_clasa)
VALUES ('5A'),
       ('5B'),
       ('5C'),
       ('5D'),
       ('6A'),
       ('6B'),
       ('6C'),
       ('6D'),
       ('7A'),
       ('7B'),
       ('7C'),
       ('7D'),
       ('8A'),
       ('8B'),
       ('8C'),
       ('8D');


------------------------------------------------------------------------------
INSERT INTO elevi (first_name, last_name, address, email_address, phone_number, ssn, clasa_nume)
VALUES ('GMarian', 'Ion', 'Bucuresti', 'marian2.ion@gmail.com', '0767707246', '3111111111152', '5A'),
       ('Diana', 'Popescu', 'Cluj-Napoca', 'diana.popescu@gmail.com', '0720556723', '2111111111165', '5B'),
       ('Andrei', 'Ionescu', 'Timisoara', 'andrei.ionescu@gmail.com', '0746994568', '5111111111178', '5C'),
       ('Ioana', 'Dragomir', 'Bucuresti', 'ioana.dragomir@yahoo.com', '0745667789', '4111111111162', '6A'),
       ('Alexandru', 'Dumitrescu', 'Iasi', 'alex.dumitrescu@gmail.com', '0722334455', '6111111111191', '6B'),
       ('Maria', 'Popa', 'Brasov', 'maria.popa@gmail.com', '0734556677', '3111111111184', '6C'),
       ('Cristina', 'Constantin', 'Bucuresti', 'cristina.constantin@yahoo.com', '0744998877', '5111111111152', '6D'),
       ('Gabriel', 'Stan', 'Cluj-Napoca', 'gabriel.stan@gmail.com', '0720444333', '2111111111165', '7A'),
       ('Andreea', 'Muresan', 'Timisoara', 'andreea.muresan@yahoo.com', '0744555666', '6111111111191', '7B'),
       ('Razvan', 'Tudor', 'Bucuresti', 'razvan.tudor@gmail.com', '0722334222', '3111111111184', '7C'),
       ('Ana', 'Stanciu', 'Iasi', 'ana.stanciu@gmail.com', '0734225566', '5111111111152', '7D'),
       ('Mihai', 'Radu', 'Brasov', 'mihai.radu@yahoo.com', '0744667788', '2111111111165', '8A'),
       ('Elena', 'Constantinescu', 'Cluj-Napoca', 'elena.constantinescu@gmail.com', '0720223344', '4111111111162',
        '8B'),
       ('Adrian', 'Voinea', 'Timisoara', 'adrian.voinea@yahoo.com', '0733445566', '5111111111152', '8C'),
       ('Laura', 'Munteanu', 'Bucuresti', 'laura.munteanu@gmail.com', '0744778899', '6111111111191', '8D');

INSERT INTO elevi (first_name, last_name, address, email_address, phone_number, ssn, clasa_nume)
VALUES
    ('Mihnea', 'Stoica', 'Bucuresti', 'mihnea.stoica@gmail.com', '0722556789', '3111111111184', '5A'),
    ('Roxana', 'Popovici', 'Cluj-Napoca', 'roxana.popovici@yahoo.com', '0744667788', '4111111111171', '5B'),
    ('Vlad', 'Barbu', 'Timisoara', 'vlad.barbu@gmail.com', '0722887766', '6111111111191', '5C'),
    ('Mara', 'Bogdan', 'Iasi', 'mara.bogdan@yahoo.com', '0733556677', '2111111111165', '6A'),
    ('Cristian', 'Munteanu', 'Brasov', 'cristian.munteanu@gmail.com', '0745778899', '5111111111184', '6B'),
    ('Andreea', 'Voicu', 'Bucuresti', 'andreea.voicu@yahoo.com', '0720334455', '3111111111197', '6C'),
    ('Dragos', 'Stefanescu', 'Cluj-Napoca', 'dragos.stefanescu@gmail.com', '0744556677', '6111111111184', '6D'),
    ('Ioana', 'Nistor', 'Timisoara', 'ioana.nistor@gmail.com', '0720999888', '2111111111165', '7A'),
    ('Andrei', 'Moldovan', 'Iasi', 'andrei.moldovan@yahoo.com', '0733111222', '5111111111191', '7B'),
    ('Adina', 'Stanciu', 'Bucuresti', 'adina.stanciu@gmail.com', '0744225566', '4111111111162', '7C'),
    ('Rares', 'Vasilescu', 'Cluj-Napoca', 'rares.vasilescu@yahoo.com', '0722887755', '2111111111184', '7D'),
    ('Mirela', 'Cristea', 'Timisoara', 'mirela.cristea@gmail.com', '0734999888', '6111111111191', '8A'),
    ('Darius', 'Pop', 'Iasi', 'darius.pop@gmail.com', '0744111222', '5111111111178', '8B'),
    ('Ioana', 'Toma', 'Brasov', 'ioana.toma@yahoo.com', '0722666777', '2111111111165', '8C'),
    ('Andrei', 'Pavel', 'Bucuresti', 'andrei.pavel@gmail.com', '0733556677', '4111111111197', '8D'),
    ('Stefan', 'Marin', 'Cluj-Napoca', 'stefan.marin@yahoo.com', '0744333444', '3111111111184', '5A'),
    ('Ioana', 'Petrache', 'Timisoara', 'ioana.petrache@gmail.com', '0722999777', '6111111111191', '5B');

-----------------------------------------------------------------------------------------
--
INSERT INTO profesori (first_name, last_name, phone_number, email_address, specialty)
VALUES
    ('Andrei', 'Popescu', '0722334444', 'andrei.popescu@example.com', 'physics'),
    ('Irina', 'Dumitru', '0755223377', 'irina.dumitru@example.com', 'history'),
    ('Mihai', 'Stefanescu', '0744223311', 'mihai.stefanescu@example.com', 'chemistry'),
    ('Maria', 'Radulescu', '0733777888', 'maria.radulescu@example.com', 'biology'),
    ('Cristina', 'Gheorghiu', '0720999888', 'cristina.gheorghiu@example.com', 'computer science'),
    ('Adrian', 'Popa', '0722222233', 'adrian.popa@example.com', 'mathematics'),
    ('Laura', 'Tudor', '0766555444', 'laura.tudor@example.com', 'geography'),
    ('Ionut', 'Munteanu', '0720999111', 'ionut.munteanu@example.com', 'physical education'),
    ('Diana', 'Voinea', '0744333444', 'diana.voinea@example.com', 'english'),
    ('Gabriel', 'Ionescu', '0733999888', 'gabriel.ionescu@example.com', 'french');

INSERT INTO profesori (first_name, last_name, phone_number, email_address, specialty)
VALUES
    ('Alexandra', 'Pop', '0744223344', 'alexandra.pop@example.com', 'history'),
    ('Andrei', 'Muresan', '0721888888', 'andrei.muresan@example.com', 'biology'),
    ('Cristina', 'Radu', '0720777777', 'cristina.radu@example.com', 'chemistry'),
    ('Dragos', 'Ilie', '0733555333', 'dragos.ilie@example.com', 'mathematics'),
    ('Elena', 'Rusu', '0755444333', 'elena.rusu@example.com', 'english'),
    ('Florin', 'Matei', '0733222111', 'florin.matei@example.com', 'physics');


INSERT INTO profesor_preda_la_clasa (profesor_id, clasa_id) VALUES
                                                                (1, '5A'), (1, '5B'), (1, '5C'), (1, '6A'), (1, '6B'), (1, '7A'), (1, '7B'), (1, '8A'),
                                                                (2, '5A'), (2, '6B'), (2, '7C'), (2, '8B'),
                                                                (3, '5C'), (3, '6A'), (3, '6B'), (3, '7D'), (3, '8A'), (3, '8D'),
                                                                (4, '5B'), (4, '6C'), (4, '7A'), (4, '7B'),
                                                                (5, '5A'), (5, '6C'), (5, '7C'), (5, '8D'),
                                                                (6, '5D'), (6, '6D'), (6, '7D'), (6, '8C'),
                                                                (7, '5B'), (7, '6B'), (7, '7C'), (7, '8C'),
                                                                (8, '5C'), (8, '6C'), (8, '7D'), (8, '8B'),
                                                                (9, '5D'), (9, '6B'), (9, '7A'), (9, '8A'),
                                                                (10, '5A'), (10, '6A'), (10, '7D'), (10, '8C'),
                                                                (11, '5D'), (11, '6C'), (11, '7A'), (11, '8B'),
                                                                (12, '5C'), (12, '6D'), (12, '7B'), (12, '8D'),
                                                                (13, '5B'), (13, '6D'), (13, '7D'), (13, '8A'),
                                                                (14, '5C'), (14, '6C'), (14, '7A'), (14, '8D'),
                                                                (15, '5A'), (15, '6D'), (15, '7B'), (15, '8C'),
                                                                (16, '5B'), (16, '6A'), (16, '7C'), (16, '8B');