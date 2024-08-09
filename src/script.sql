DROP TABLE IF EXISTS odontologo;

CREATE TABLE odontologo (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    numeroMatricula INT NOT NULL
);