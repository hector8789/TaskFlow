-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS 	;
USE TaskFlowDB;

CREATE TABLE IF NOT EXISTS Puestos (
    IDPuesto INT PRIMARY KEY AUTO_INCREMENT,
    NombrePuesto VARCHAR(20) NOT NULL,
    Estatus BIT NOT NULL
);

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    IDUsuario INT PRIMARY KEY AUTO_INCREMENT,
    IDPuesto  INT,
	NombreUsuario VARCHAR(50) NOT NULL,
    CorreoElectronico VARCHAR(255) NOT NULL,
    Contraseña VARCHAR(255) NOT NULL,
	Estatus BIT NOT NULL
	FOREIGN KEY (IDPuesto) REFERENCES Usuarios(IDPuesto)
);

-- Crear la tabla de proyectos
CREATE TABLE IF NOT EXISTS Proyectos (
    IDProyecto INT PRIMARY KEY AUTO_INCREMENT,
    NombreProyecto VARCHAR(255) NOT NULL,
    DescripcionProyecto TEXT,
    FechaInicio DATE,
    FechaFin DATE,
    IDUsuarioResponsable INT,
	Estatus BIT NOT NULL
    FOREIGN KEY (IDUsuarioResponsable) REFERENCES Usuarios(IDUsuario)
);

CREATE TABLE IF NOT EXISTS ProyectosDetalle (
    IDProyectoDetalle INT PRIMARY KEY AUTO_INCREMENT,
    IDProyecto        INT
    IDUsuarioIntegrante INT,
	Estatus BIT NOT NULL
    FOREIGN KEY (IDUsuarioIntegrante) REFERENCES Usuarios(IDUsuario)
);

-- Crear la tabla de tareas
CREATE TABLE IF NOT EXISTS Tareas (
    IDTarea INT PRIMARY KEY AUTO_INCREMENT,
    IDProyecto INT,
    NombreTarea VARCHAR(255) NOT NULL,
    DescripcionTarea TEXT,
    FechaInicioTarea DATE,
    FechaFinTarea DATE,
    EstadoTarea VARCHAR(50),
    IDUsuarioAsignado INT,
    FOREIGN KEY (IDProyecto) REFERENCES Proyectos(IDProyecto),
    FOREIGN KEY (IDUsuarioAsignado) REFERENCES Usuarios(IDUsuario)
);

-- Crear la tabla de asignación de tareas a usuarios
CREATE TABLE IF NOT EXISTS AsignacionTareas (
    IDAsignacion INT PRIMARY KEY AUTO_INCREMENT,
    IDTarea INT,
    IDUsuario INT,
    FechaAsignacion DATE,
    FOREIGN KEY (IDTarea) REFERENCES Tareas(IDTarea),
    FOREIGN KEY (IDUsuario) REFERENCES Usuarios(IDUsuario)
);

-- Crear la tabla de seguimiento de progreso de las tareas
CREATE TABLE IF NOT EXISTS SeguimientoProgreso (
    IDSeguimiento INT PRIMARY KEY AUTO_INCREMENT,
    IDTarea INT,
    PorcentajeCompletado INT,
    Comentarios TEXT,
    FechaSeguimiento DATE,
    FOREIGN KEY (IDTarea) REFERENCES Tareas(IDTarea)
);