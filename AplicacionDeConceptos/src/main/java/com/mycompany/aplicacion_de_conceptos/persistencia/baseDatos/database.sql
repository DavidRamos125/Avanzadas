CREATE TABLE Persona (
    ID BIGINT PRIMARY KEY,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    email VARCHAR(150)
);

CREATE TABLE Profesor (
    ID BIGINT PRIMARY KEY,
    tipo_contrato VARCHAR(50),
    FOREIGN KEY (ID) REFERENCES Persona(ID)
);

CREATE TABLE Facultad (
    ID BIGINT PRIMARY KEY,
    nombre VARCHAR(100),
    decano_id BIGINT,
    FOREIGN KEY (decano_id) REFERENCES Persona(ID)
);

CREATE TABLE Programa (
    ID BIGINT PRIMARY KEY,
    nombre VARCHAR(100),
    duracion INT,
    registro VARCHAR(50),
    facultad_id BIGINT,
    FOREIGN KEY (facultad_id) REFERENCES Facultad(ID)
);

CREATE TABLE Curso (
    ID BIGINT PRIMARY KEY,
    programa_id BIGINT,
    activo BOOLEAN,
    FOREIGN KEY (programa_id) REFERENCES Programa(ID)
);

CREATE TABLE Estudiante (
    ID BIGINT PRIMARY KEY,
    codigo BIGINT UNIQUE,
    programa_id BIGINT,
    activo BOOLEAN,
    promedio DOUBLE,
    FOREIGN KEY (ID) REFERENCES Persona(ID),
    FOREIGN KEY (programa_id) REFERENCES Programa(ID)
);

CREATE TABLE Inscripcion (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    curso_id BIGINT,
    anio INT,
    semestre INT,
    estudiante_id BIGINT,
    FOREIGN KEY (curso_id) REFERENCES Curso(ID),
    FOREIGN KEY (estudiante_id) REFERENCES Estudiante(ID)
);

CREATE TABLE CursoProfesor (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    profesor_id BIGINT,
    año INT,
    semestre INT,
    curso_id BIGINT,
    FOREIGN KEY (profesor_id) REFERENCES Profesor(ID),
    FOREIGN KEY (curso_id) REFERENCES Curso(ID)
);