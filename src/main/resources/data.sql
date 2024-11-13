INSERT INTO `ASIGNATURA` (`NOMBRE`, `CODIGO`, `CREATED_AT`) VALUES
    ('Matemáticas Básicas', 'MAT101', NOW()),
    ('Física General', 'PHY102', NOW()),
    ('Introducción a la Programación', 'PROG101', NOW());

INSERT INTO `ESPACIO_FISICO` (`NOMBRE`, `CAPACIDAD`, `CREATED_AT`) VALUES
    ('Aula 101', 30, NOW()),
    ('Laboratorio A', 20, NOW()),
    ('Sala de Conferencias', 100, NOW());

INSERT INTO `OFICINA` (`NOMBRE`, `UBICACION`, `CREATED_AT`) VALUES
    ('Oficina 1', 'Edificio A', NOW()),
    ('Oficina 2', 'Edificio B', NOW()),
    ('Oficina 3', 'Edificio C', NOW());

INSERT INTO `PERSONA` (`ID`, `NOMBRE`, `APELLIDO`, `CORREO`, `CREATED_AT`) VALUES
    (1, 'Juan', 'Perez', 'juan.perez@universidad.edu', NOW()),
    (2, 'Maria', 'Garcia', 'maria.garcia@universidad.edu', NOW()),
    (3, 'Carlos', 'Lopez', 'carlos.lopez@universidad.edu', NOW()),
    (4, 'Ana', 'Martinez', 'ana.martinez@universidad.edu', NOW());

INSERT INTO `ADMINISTRATIVO` (`ADMINISTRATIVO_ID`, `ROL`) VALUES
    (1, 'Docente'),
    (2, 'Docente'),
    (3, 'Docente'),
    (4, 'Docente');

INSERT INTO `DOCENTE` (`ID`, `OFICINA_ID`, `PERSONA_ID`, `CREATED_AT`) VALUES
    (1, 1, 1, NOW()),
    (2, 2, 2, NOW()),
    (3, 3, 3, NOW());

INSERT INTO `CURSO` (`NOMBRE`, `ASIGNATURA_ID`, `CREATED_AT`) VALUES
    ('Matematicas 101 - Grupo A', 1, NOW()),
    ('Fisica General - Grupo B', 2, NOW()),
    ('Programacion 1 - Grupo C', 3, NOW());

INSERT INTO `CURSO_DOCENTE` (`CURSO_ID`, `DOCENTE_ID`) VALUES
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO `FRANJA_HORARIA` (`CURSO_ID`, `DIA`, `HORA_INICIO`, `HORA_FIN`, `ESPACIO_FISICO_ID`, `CREATED_AT`) VALUES
    (1, 'Miercoles', '08:00:00', '10:00:00', 1, NOW()),
    (2, 'Martes', '10:00:00', '12:00:00', 2, NOW()),
    (2, 'Jueves', '10:00:00', '12:00:00', 2, NOW()),
    (3, 'Viernes', '14:00:00', '16:00:00', 3, NOW()),
    (3, 'Sabado', '10:00:00', '12:00:00', 3, NOW());