-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-01-2023 a las 20:25:59
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id` int NOT NULL,
  `fecha_cita` date DEFAULT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `id_veterinario` int DEFAULT NULL,
  `id_mascota` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id`, `fecha_cita`, `diagnostico`, `valor`, `id_veterinario`, `id_mascota`) VALUES
(1, '2023-01-10', 'Apendicitis', 34, 4, 4),
(3, '2023-01-13', 'Pulgas y garrapatas', 7, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas_medicas`
--

CREATE TABLE `facturas_medicas` (
  `id` int NOT NULL,
  `medicamento` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `dosis` varchar(255) DEFAULT NULL,
  `id_cita` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `facturas_medicas`
--

INSERT INTO `facturas_medicas` (`id`, `medicamento`, `precio`, `dosis`, `id_cita`) VALUES
(1, 'Paracetamol', 4300, '1 cada 3 horas', 1),
(2, 'Nuevo', 333, 'Otra', 1),
(3, 'Prueba factura 3', 4300, 'una diaria', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

CREATE TABLE `mascotas` (
  `id` int NOT NULL,
  `nombre` varchar(70) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `id_propietario` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`id`, `nombre`, `foto`, `tipo`, `fecha_nacimiento`, `id_propietario`) VALUES
(1, 'Terry', 'terryimg.jpg', 'canino', '2022-12-13', 1),
(4, 'Doberman', 'eaf206c7-0123-49f4-9230-29f2446509ad_bover.jpg', 'Anfibio', '2022-11-10', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `id` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(75) DEFAULT NULL,
  `correo` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`id`, `nombre`, `telefono`, `direccion`, `correo`) VALUES
(1, 'Andres Pardo', '933838832', 'calle 24 st', 'andresp@mail.com'),
(2, 'Julio pardo', '28382992', 'st 24 # 31', 'juliop@mail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `veterinarios`
--

CREATE TABLE `veterinarios` (
  `id` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `especialidad` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `veterinarios`
--

INSERT INTO `veterinarios` (`id`, `nombre`, `telefono`, `especialidad`) VALUES
(1, 'Juan Esteban Cruz Suarez', '31133399912', 'Cirugía'),
(2, 'Pedro Eliecer Suarez Torrez', '92929818912', 'Dermatología'),
(3, 'Hugo Helidoro Bravo Bayona', '29293321010', 'Neurología'),
(4, 'Carmelo Julio Sochica Bonilla', '311834092', 'Medico Inspeccionista');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_citas_veterinarios_idx` (`id_veterinario`),
  ADD KEY `id_citas_mascotas_idx` (`id_mascota`);

--
-- Indices de la tabla `facturas_medicas`
--
ALTER TABLE `facturas_medicas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_facturasMedicas_citas_idx` (`id_cita`);

--
-- Indices de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_mascotas_propietario_idx` (`id_propietario`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `veterinarios`
--
ALTER TABLE `veterinarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `facturas_medicas`
--
ALTER TABLE `facturas_medicas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `veterinarios`
--
ALTER TABLE `veterinarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `id_citas_mascotas` FOREIGN KEY (`id_mascota`) REFERENCES `mascotas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_citas_veterinarios` FOREIGN KEY (`id_veterinario`) REFERENCES `veterinarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `facturas_medicas`
--
ALTER TABLE `facturas_medicas`
  ADD CONSTRAINT `id_facturasMedicas_citas` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD CONSTRAINT `id_mascotas_propietario` FOREIGN KEY (`id_propietario`) REFERENCES `propietarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
