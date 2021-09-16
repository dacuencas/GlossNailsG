-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-09-2021 a las 23:10:50
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_glossnailsg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banco`
--

CREATE TABLE `banco` (
  `id_banco` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id_cita` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `comentario` varchar(255) NOT NULL,
  `estado_cita_id_estado_cita` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `Servicio_Código_Servicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cita`
--

CREATE TABLE `estado_cita` (
  `id_estado_cita` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_pago`
--

CREATE TABLE `forma_pago` (
  `id_forma_pago` int(11) NOT NULL,
  `efectivo` float DEFAULT NULL,
  `transaccion` varchar(45) DEFAULT NULL,
  `banco_id_banco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo`
--

CREATE TABLE `insumo` (
  `id_insumo` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `cantidad` double NOT NULL,
  `total_insumo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_compra`
--

CREATE TABLE `orden_compra` (
  `id_liquidacion` int(11) NOT NULL,
  `empresa` varchar(25) NOT NULL,
  `nombre_asesor` varchar(45) NOT NULL,
  `costo_unitario` double NOT NULL,
  `descripcion_insumo` varchar(200) NOT NULL,
  `costo_total` double NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `forma_pago_id_forma_pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_pago`
--

CREATE TABLE `orden_pago` (
  `id_orden` int(11) NOT NULL,
  `fecha_orden` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nit` int(25) NOT NULL,
  `valor_total` float NOT NULL,
  `proveedor_nit` int(11) NOT NULL,
  `razon_social` varchar(45) DEFAULT NULL,
  `insumo_id_insumo` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `tipo_rol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `tipo_rol`) VALUES
(1, 'Gerente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `codigo_servicio` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_direccion`
--

CREATE TABLE `tipo_direccion` (
  `id_direccion` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_direccion`
--

INSERT INTO `tipo_direccion` (`id_direccion`, `descripcion`) VALUES
(1, 'casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_identificacion`
--

CREATE TABLE `tipo_identificacion` (
  `id_identificación` int(11) NOT NULL,
  `tipo_identificacion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_identificacion`
--

INSERT INTO `tipo_identificacion` (`id_identificación`, `tipo_identificacion`) VALUES
(1, 'CC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_telefono`
--

CREATE TABLE `tipo_telefono` (
  `id_telefono` int(11) NOT NULL,
  `tipo_telefono` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_telefono`
--

INSERT INTO `tipo_telefono` (`id_telefono`, `tipo_telefono`) VALUES
(1, 'CASA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `tipo_direccion_id_direccion` int(11) NOT NULL,
  `detalle_direccion` varchar(200) NOT NULL,
  `tipo_telefono_id_telefono` int(11) NOT NULL,
  `numero_telefono` varchar(60) DEFAULT NULL,
  `tipo_identificacion_id_identificación` int(11) NOT NULL,
  `numero_documento` varchar(100) DEFAULT NULL,
  `rol_id_rol` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `contrasena`, `correo`, `tipo_direccion_id_direccion`, `detalle_direccion`, `tipo_telefono_id_telefono`, `numero_telefono`, `tipo_identificacion_id_identificación`, `numero_documento`, `rol_id_rol`, `estado`) VALUES
(1, 'er', 'r', '12345', 'erlinolaya727@gmail.com', 1, '1', 1, '3423', 1, '234', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banco`
--
ALTER TABLE `banco`
  ADD PRIMARY KEY (`id_banco`);

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id_cita`),
  ADD KEY `fk_Cita_estado_cita1_idx` (`estado_cita_id_estado_cita`),
  ADD KEY `fk__usuario1_idx` (`usuario_id_usuario`),
  ADD KEY `fk__Servicio1_idx` (`Servicio_Código_Servicio`);

--
-- Indices de la tabla `estado_cita`
--
ALTER TABLE `estado_cita`
  ADD PRIMARY KEY (`id_estado_cita`);

--
-- Indices de la tabla `forma_pago`
--
ALTER TABLE `forma_pago`
  ADD PRIMARY KEY (`id_forma_pago`),
  ADD KEY `fk_forma_pago_banco1_idx` (`banco_id_banco`);

--
-- Indices de la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD PRIMARY KEY (`id_insumo`);

--
-- Indices de la tabla `orden_compra`
--
ALTER TABLE `orden_compra`
  ADD PRIMARY KEY (`id_liquidacion`),
  ADD KEY `fk_orden_compra_usuario1_idx` (`usuario_id_usuario`),
  ADD KEY `fk_orden_compra_forma_pago1_idx` (`forma_pago_id_forma_pago`);

--
-- Indices de la tabla `orden_pago`
--
ALTER TABLE `orden_pago`
  ADD PRIMARY KEY (`id_orden`),
  ADD KEY `fk_orden_Pago_insumo1_idx` (`insumo_id_insumo`),
  ADD KEY `fk_orden_Pago_usuario1_idx` (`usuario_id_usuario`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`codigo_servicio`);

--
-- Indices de la tabla `tipo_direccion`
--
ALTER TABLE `tipo_direccion`
  ADD PRIMARY KEY (`id_direccion`);

--
-- Indices de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  ADD PRIMARY KEY (`id_identificación`);

--
-- Indices de la tabla `tipo_telefono`
--
ALTER TABLE `tipo_telefono`
  ADD PRIMARY KEY (`id_telefono`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_rol1_idx` (`rol_id_rol`),
  ADD KEY `fk_usuario_tipo_direccion1_idx` (`tipo_direccion_id_direccion`),
  ADD KEY `fk_usuario_tipo_identificacion1_idx` (`tipo_identificacion_id_identificación`),
  ADD KEY `fk_usuario_tipo_telefono1_idx` (`tipo_telefono_id_telefono`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `banco`
--
ALTER TABLE `banco`
  MODIFY `id_banco` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id_cita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_cita`
--
ALTER TABLE `estado_cita`
  MODIFY `id_estado_cita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `forma_pago`
--
ALTER TABLE `forma_pago`
  MODIFY `id_forma_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `insumo`
--
ALTER TABLE `insumo`
  MODIFY `id_insumo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `orden_compra`
--
ALTER TABLE `orden_compra`
  MODIFY `id_liquidacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `codigo_servicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_direccion`
--
ALTER TABLE `tipo_direccion`
  MODIFY `id_direccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  MODIFY `id_identificación` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_telefono`
--
ALTER TABLE `tipo_telefono`
  MODIFY `id_telefono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `fk_Cita_estado_cita1` FOREIGN KEY (`estado_cita_id_estado_cita`) REFERENCES `estado_cita` (`id_estado_cita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk__Servicio1` FOREIGN KEY (`Servicio_Código_Servicio`) REFERENCES `servicio` (`codigo_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk__usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `forma_pago`
--
ALTER TABLE `forma_pago`
  ADD CONSTRAINT `fk_forma_pago_banco1` FOREIGN KEY (`banco_id_banco`) REFERENCES `banco` (`id_banco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden_compra`
--
ALTER TABLE `orden_compra`
  ADD CONSTRAINT `fk_orden_compra_forma_pago1` FOREIGN KEY (`forma_pago_id_forma_pago`) REFERENCES `forma_pago` (`id_forma_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orden_compra_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden_pago`
--
ALTER TABLE `orden_pago`
  ADD CONSTRAINT `fk_orden_Pago_insumo1` FOREIGN KEY (`insumo_id_insumo`) REFERENCES `insumo` (`id_insumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orden_Pago_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_tipo_direccion1` FOREIGN KEY (`tipo_direccion_id_direccion`) REFERENCES `tipo_direccion` (`id_direccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_tipo_identificacion1` FOREIGN KEY (`tipo_identificacion_id_identificación`) REFERENCES `tipo_identificacion` (`id_identificación`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_tipo_telefono1` FOREIGN KEY (`tipo_telefono_id_telefono`) REFERENCES `tipo_telefono` (`id_telefono`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
