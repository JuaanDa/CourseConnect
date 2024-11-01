DROP DATABASE courseconnect;
CREATE DATABASE courseconnect;
USE courseconnect;

CREATE TABLE USUARIOS(
                         username VARCHAR(15) NOT NULL UNIQUE,
                         userpass VARCHAR(255) NOT NULL,
                         tipo_usuario VARCHAR(15) NOT NULL,
                         fecha_registro DATE NOT NULL,
                         ultimo_acceso DATETIME,
                         estado_usuario VARCHAR(15) NOT NULL,

                         PRIMARY KEY (username)
);

CREATE TABLE TEMAS(
                      id_tema INT AUTO_INCREMENT NOT NULL,
                      fecha_creacion DATE NOT NULL,
                      creado_por VARCHAR(15) NOT NULL,
                      nombre_tema VARCHAR(25) NOT NULL,
                      descripcion_tema VARCHAR(255),

                      PRIMARY KEY (id_tema),
                      FOREIGN KEY (creado_por) REFERENCES USUARIOS (username)
);

CREATE TABLE HABILIDADES(
                            id_habilidad INT AUTO_INCREMENT NOT NULL,
                            nombre_habilidad VARCHAR(35) NOT NULL,
                            descripcion VARCHAR(255),

                            PRIMARY KEY (id_habilidad)
);

CREATE TABLE CURSOS(
                       id_curso INT AUTO_INCREMENT NOT NULL,
                       titulo_curso VARCHAR(50) NOT NULL,
                       url_imagen_curso VARCHAR(50) NOT NULL,
                       tipo_curso VARCHAR(15) NOT NULL,
                       modalidad_curso VARCHAR(15) NOT NULL,
                       horario_curso VARCHAR(25) NOT NULL,
                       fecha_inicio DATE NOT NULL,
                       fecha_fin DATE NOT NULL,
                       horas_curso INT NOT NULL,
                       costo_curso INT NOT NULL,
                       estado_curso VARCHAR(15) NOT NULL,
                       fecha_creacion DATE NOT NULL,
                       creado_por VARCHAR(15) NOT NULL,

                       PRIMARY KEY (id_curso),
                       FOREIGN KEY (creado_por) REFERENCES USUARIOS (username)
);

CREATE TABLE HABILIDADES_CURSO(
                                  id_curso INT NOT NULL,
                                  id_habilidad INT NOT NULL,

                                  PRIMARY KEY (id_curso,id_habilidad),
                                  FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso),
                                  FOREIGN KEY (id_habilidad) REFERENCES HABILIDADES (id_habilidad)
);

CREATE TABLE TEMAS_CURSO(
                            id_tema INT NOT NULL,
                            id_curso INT NOT NULL,

                            PRIMARY KEY (id_tema, id_curso),
                            FOREIGN KEY (id_tema) REFERENCES TEMAS (id_tema),
                            FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso)
);

CREATE TABLE PROFESORES(
                           id_docente VARCHAR(15) NOT NULL,
                           nombre VARCHAR(20) NOT NULL,
                           apellidos VARCHAR(20) NOT NULL,
                           correo_electronico VARCHAR(30) NOT NULL,
                           resumen_experiencia VARCHAR(255) NOT NULL,
                           username VARCHAR(15) NOT NULL,

                           PRIMARY KEY (id_docente)
);

CREATE TABLE PROFESORES_CURSO(
                                 id_curso INT NOT NULL,
                                 id_docente VARCHAR(15) NOT NULL,
                                 rol_docente VARCHAR(15) NOT NULL,

                                 PRIMARY KEY (id_curso, id_docente),
                                 FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso),
                                 FOREIGN KEY (id_docente) REFERENCES PROFESORES (id_docente)
);

CREATE TABLE ESTUDIANTES(
                            id_estudiante VARCHAR(15) NOT NULL,
                            nombre VARCHAR(20) NOT NULL,
                            apellidos VARCHAR(20) NOT NULL,
                            correo_electronico VARCHAR(30) NOT NULL,
                            celular VARCHAR(10),
                            username VARCHAR(15) NOT NULL,

                            PRIMARY KEY (id_estudiante)
);

CREATE TABLE CURSOS_ESTUDIANTE(
                                  id_estudiante VARCHAR(15) NOT NULL,
                                  id_curso INT NOT NULL,

                                  PRIMARY KEY (id_estudiante, id_curso),
                                  FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES (id_estudiante),
                                  FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso)
);

CREATE TABLE CALIFICACIONES_CURSO(
                                     id_curso INT NOT NULL,
                                     id_estudiante VARCHAR(15) NOT NULL,
                                     calificacion DECIMAL NOT NULL,
                                     comentarios VARCHAR(255) NOT NULL,

                                     PRIMARY KEY (id_curso,id_estudiante),
                                     FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES (id_estudiante),
                                     FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso)
);

CREATE TABLE INSCRIPCIONES(
                              id_curso INT NOT NULL,
                              id_estudiante VARCHAR(15) NOT NULL,
                              fecha_inscripcion DATE NOT NULL,
                              url_link_confirmacion VARCHAR(150) NOT NULL,
                              estado_inscripcion VARCHAR(15) NOT NULL,
                              codigo_para_pago VARCHAR(50) NOT NULL,

                              PRIMARY KEY (id_estudiante, id_curso),
                              FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES (id_estudiante),
                              FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso)
);

CREATE TABLE PAGO_INSCRIPCIONES(
                                   id_pago_inscripcion INT AUTO_INCREMENT NOT NULL,
                                   id_curso INT NOT NULL,
                                   id_estudiante VARCHAR(15) NOT NULL,
                                   medio_pago VARCHAR(15) NOT NULL,
                                   valor_pago INT NOT NULL,
                                   estado_pago VARCHAR(15) NOT NULL,

                                   PRIMARY KEY (id_pago_inscripcion),
                                   FOREIGN KEY (id_estudiante,id_curso) REFERENCES INSCRIPCIONES (id_estudiante, id_curso)
);

CREATE TABLE CERTIFICADOS_CURSO(
                                   id_curso INT NOT NULL,
                                   id_estudiante VARCHAR(15) NOT NULL,
                                   fecha_expedicion_certificado DATE NOT NULL,
                                   url_descarga_certificado VARCHAR(150) NOT NULL,

                                   PRIMARY KEY (id_estudiante, id_curso),
                                   FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES (id_estudiante),
                                   FOREIGN KEY (id_curso) REFERENCES CURSOS (id_curso)
);

COMMIT;