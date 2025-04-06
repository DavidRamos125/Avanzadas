CREATE TABLE Persona
(
    ID        BIGINT PRIMARY KEY,
    nombres   VARCHAR(100),
    apellidos VARCHAR(100),
    email     VARCHAR(150)
);

CREATE TABLE Profesor
(
    ID            BIGINT PRIMARY KEY,
    tipo_contrato VARCHAR(50),
    FOREIGN KEY (ID) REFERENCES Persona (ID)
);

CREATE TABLE Facultad
(
    ID        BIGINT PRIMARY KEY,
    nombre    VARCHAR(100),
    decano_id BIGINT,
    FOREIGN KEY (decano_id) REFERENCES Persona (ID)
);

CREATE TABLE Programa
(
    ID          BIGINT PRIMARY KEY,
    nombre      VARCHAR(100),
    duracion    INT,
    registro    VARCHAR(50),
    facultad_id BIGINT,
    FOREIGN KEY (facultad_id) REFERENCES Facultad (ID)
);

CREATE TABLE Curso
(
    ID          BIGINT PRIMARY KEY,
    programa_id BIGINT NOT NULL,
    activo      BOOLEAN,
    FOREIGN KEY (programa_id) REFERENCES Programa (ID)
);

CREATE TABLE Estudiante
(
    ID          BIGINT PRIMARY KEY,
    codigo      BIGINT UNIQUE,
    programa_id BIGINT NOT NULL,
    activo      BOOLEAN,
    promedio    DOUBLE,
    FOREIGN KEY (ID) REFERENCES Persona (ID),
    FOREIGN KEY (programa_id) REFERENCES Programa (ID)
);

CREATE TABLE Inscripcion
(
    estudianteID BIGINT,
    cursoID      BIGINT,
    año          INT,
    semestre     INT,
    PRIMARY KEY (estudianteID, cursoID, año, semestre),
    FOREIGN KEY (estudianteID) REFERENCES Estudiante (ID),
    FOREIGN KEY (cursoID) REFERENCES Curso (ID)
);

CREATE TABLE CursoProfesor
(
    cursoID    BIGINT,
    profesorID BIGINT,
    año        INT,
    semestre   INT,
    PRIMARY KEY (profesorID, cursoID, año, semestre),
    FOREIGN KEY (cursoID) REFERENCES Curso (ID),
    FOREIGN KEY (profesorID) REFERENCES Profesor (ID)
);
