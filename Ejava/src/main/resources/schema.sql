CREATE TABLE Usuario (
                         idUsuario INT AUTO_INCREMENT PRIMARY KEY,
                         nombreCompleto VARCHAR(100),
                         nombreUsuario VARCHAR(50) UNIQUE,
                         password VARCHAR(50),
                         edad INT,
                         sexo VARCHAR(10),
                         estatura DECIMAL(5,2),
                         peso DECIMAL(5,2)
);

CREATE TABLE IMC (
                     idIMC INT AUTO_INCREMENT PRIMARY KEY,
                     idUsuario INT,
                     fechaMedicion DATE,
                     valorIMC DECIMAL(5,2),
                     FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);