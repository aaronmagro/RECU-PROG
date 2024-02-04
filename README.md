# COMERCIO JAVA

Autor: Aarón Magro Maldonado  
Fecha: 6 de febrero del 2024

- [Manual de Uso](#manual-de-uso)
  - [1. Lanzar el proyecto](#1-lanzar-el-proyecto)
  - [2. Seleccionar la opción](#2-seleccionar-la-opción)
      - [Opción 1: Añadir stock de un producto a una tienda](#opción-1-añadir-stock-de-un-producto-a-una-tienda)
      - [Opción 2: Eliminar stock de un producto de una tienda](#opción-2-eliminar-stock-de-un-producto-de-una-tienda)
      - [Opción 3: Buscar un producto en una tienda (mostrará el stock)](#opción-3-buscar-un-producto-en-una-tienda-mostrará-el-stock)
      - [Opción 4: Mostrar el producto con mayor stock de una tienda](#opción-4-mostrar-el-producto-con-mayor-stock-de-una-tienda)
      - [Opción 5: Mostrar la tienda con mayor valor. (Q x €)](#opción-5-mostrar-la-tienda-con-mayor-valor-q-x-€)
      - [Opción 6: Mostrar información de productos ordenada por stock](#opción-6-mostrar-información-de-productos-ordenada-por-stock)
      - [Opción 7: Ejecutar simulación de venta](#opción-7-ejecutar-simulación-de-venta)
      - [Opción 8: Salir del programa](#opción-8-salir-del-programa)
- [Estructura de clases](#estructura-de-clases)
  - [Package productos](#package-productos)
  - [Package local](#package-local)
    - [Package inventario](#package-inventario)
    - [Package manejo](#package-manejo)
  - [Package gestion](#package-gestion)

# Manual de Uso

## 1. Lanzar el proyecto

Primeramente, abrir la clase `MainApp` del proyecto. En la parte superior derecha del IDE encontramos un botón flecha y lo presionamos para ejecutar.

## 2. Seleccionar la opción

Escribimos el número de la opción que queremos seleccionar.

#### Opción 1: Añadir stock de un producto a una tienda

Saldrá la lista de tiendas del comercio para añadir el stock.
Escribimos el nombre de la tienda y el producto a añadir stock, junto con la cantidad deseada.
Recibiremos un mensaje con el stock total del producto modificado.

#### Opción 2: Eliminar stock de un producto de una tienda

Similar a la Opción 1, pero para eliminar stock.

#### Opción 3: Buscar un producto en una tienda (mostrará el stock)

Escribimos el nombre de la tienda y del producto. Nos da la respuesta con la búsqueda en la tienda.

#### Opción 4: Mostrar el producto con mayor stock de una tienda

Nos devuelve un mensaje con la lista de productos ordenados por stock y el producto con más unidades.

#### Opción 5: Mostrar la tienda con mayor valor. (Q x €)

Devuelve todas las tiendas con el capital del stock total y tienda con mayor valor.

#### Opción 6: Mostrar información de productos ordenada por stock

Nos devuelve un mensaje con la ordenación de productos por stock.

#### Opción 7: Ejecutar simulación de venta

Ejecuta una simulación de ventas, creando una carpeta con archivos .txt de cada compra.

#### Opción 8: Salir del programa

Finaliza la ejecución del programa.

# Estructura de clases

## Package productos

Incluye clases como `Producto`, `Carne`, `Pescado`, y `Verdura` con atributos específicos.

## Package local
Contiene los packages `inventario` y `manejo`.

### Package inventario
Contiene la clase `Stock`.

### Package manejo
Contiene las clases `Cliente` y `Tienda`.

## Package gestion

Contiene las clases `GestorProductos`, `GestorClientes`, `GestorFicheros`, y `GestorTiendas` para la gestión de la aplicación.