# scoala_generala

descriere

clasa - elev : one-to-many
adaugam elev fara a-i specifica clasa. endpointul asigneazaClasa ii asigneaza o clasa elevului dar il si adauga listei de elevi din cadrul clasei noastre.

altele:
endpointuri pentru a afisa elevi dupa SSN(CNP), toti elevii sau toate clasele.

+-------------------------+                                 +----------------------------+
|          ELEVI          |                                 |         CLASE              |
+-------------------------+                                 +----------------------------+
|                         |                                 |                            |
| id Pk                   |                                 |   id Pk                    |
|                         |                                 |                            |
| firstName               |                                 |   numeClasa                |
|                         |                                 |                            |
| lastName                |                                 |   listaElevi               |
|                         |invata la                    are |                            |
| address                 +---------------------------------+                            |
|                         |M                               1|                            |
| emailAddress            |                                 |                            |
|                         |                                 |                            |
| phoneNumber             |                                 |                            |
|                         |                                 |                            |
| ssn                     |                                 |                            |
|                         |                                 |                            |
| clasa (Fk)              |                                 |                            |
|                         |                                 |                            |
|                         |                                 |                            |
|                         |                                 |                            |
+-------------------------+                                 +---------------+------------+
                                                                            |
                                                                            |
+-------------------------+                                                 |
|      PROFESORI          |                                                 |
+-------------------------+                                                 |
|                         |                                                 |
| id Pk                   |                                                 |
|                         |                                                 |
| firstName               |                                                 |
|                         |                                                 |
| lastName                |                                                 |
|                         |                                                 |
| speciality              |                                                 |
|                         |                                                 |
|                         |                                                 |
|                         |                                                 |
|                         |                                                 |
|                         |                                                 |
|                         |                                                 |
+-----------+-------------+                                                 |
            |                                                               |
            |                                                               |
            |                                                               |
            |                                                               |
            |                                                               |
            |               +------------------------------+                |
            |               |                              |                |
            |               |     PROFESOR_PREDA_LA_CLASA  |                |
            |               +------------------------------+                |
            |               |                              |                |
            |               |                              |                |
            |               |   id_profesor Pk Fk          |                |
            +---------------+                              +----------------+
                            |   id_clasa Pk Fk             |
                            |                              |
                            |                              |
                            |                              |
                            +------------------------------+
