-- Tabla para Documentos
CREATE TABLE documentos (
    id VARCHAR(2) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


-- Tabla para Empleados
CREATE TABLE empleados (
    tipo_documento VARCHAR(2) NOT NULL,
    numero_documento VARCHAR(20) NOT NULL,
    area VARCHAR(50),
    nombre_completo VARCHAR(100) NOT NULL,
    PRIMARY KEY (tipo_documento, numero_documento),
    FOREIGN KEY (tipo_documento) REFERENCES documentos(id)
);


-- Tabla para Tipo de Solicitudes
CREATE TABLE tipo_solicitudes (
    id VARCHAR(3) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


-- Tabla para Solicitudes de Empleados
CREATE TABLE solicitudes_empleados (
    id_solicitud_empleado SERIAL PRIMARY KEY,
    id_solicitud VARCHAR(3) NOT NULL,
    id_documento VARCHAR(2) NOT NULL,
    numero_documento VARCHAR(20) NOT NULL,
    nombre_empleado VARCHAR(100) NOT NULL,
    fecha_solicitud DATE NOT NULL,
    estado VARCHAR(15) NOT NULL,
    comentarios TEXT,
    FOREIGN KEY (id_solicitud) REFERENCES tipo_solicitudes(id),
    FOREIGN KEY (id_documento) REFERENCES documentos(id),
    FOREIGN KEY (id_documento, numero_documento) REFERENCES empleados(tipo_documento, numero_documento)
);
