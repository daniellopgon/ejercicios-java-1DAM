# Ejercicios Java 1DAM

Este repositorio contiene una colección de ejercicios de programación en Java desarrollados durante el primer curso de Desarrollo de Aplicaciones Multiplataforma. Los ejercicios están organizados por temáticas y cubren desde conceptos básicos hasta programación orientada a objetos avanzada.

## Estructura del proyecto

El código fuente se encuentra en la carpeta src y está dividido en diferentes paquetes según el tema que aborda cada ejercicio.

### Programación básica

El paquete basic_programming contiene ejercicios introductorios para familiarizarse con el lenguaje. Incluye programas para calcular billetes necesarios para una cantidad de dinero, convertir segundos a formato horario y determinar si un año es bisiesto.

### Estructuras de control

En control_structure se encuentran ejercicios que practican el uso de condicionales y bucles. Hay implementaciones de la serie de Fibonacci, un juego de adivinar números, un menú de calculadora, detección de números capicúa, generación de números primos y un programa que determina el signo del zodiaco según la fecha de nacimiento.

### Funciones

El paquete functions contiene ejercicios centrados en la creación y uso de métodos. Incluye un programa de cifrado y descifrado de texto, cálculo de factorial, ordenación alfabética de letras en una frase, redondeo de números decimales y detección de vocales.

### Arrays

En arrays hay ejercicios que trabajan con estructuras de datos unidimensionales. Destaca el cálculo del mínimo común múltiplo de un rango de números, el cálculo de la mediana de una serie numérica y un juego del ahorcado completo con su lógica de juego.

### Matrices

El paquete matrices contiene ejercicios con arrays bidimensionales. Incluye la verificación de cuadrados mágicos, un sistema de venta de entradas de cine con gestión de asientos y la generación de series numéricas en forma de matriz.

### Colecciones

En collections se practican las estructuras de datos de Java Collections Framework. Hay un gestor de estudiantes usando HashSet, una agenda de contactos implementada con HashMap y un gestor de tareas pendientes con ArrayList.

### Expresiones lambda

El paquete lambda contiene ejercicios que utilizan programación funcional con streams y expresiones lambda. Los ejercicios trabajan con listas de conciertos para filtrar y ordenar, listas de estudiantes para calcular promedios y listas de mascotas para realizar operaciones de conteo y filtrado.

### Excepciones

En exceptions se practican los mecanismos de manejo de errores. Incluye una calculadora con control de división por cero, un procesador de datos con múltiples tipos de excepciones y una jerarquía de clases Person y Employee que demuestran el uso de excepciones personalizadas.

### Programación orientada a objetos básica

El paquete oo_basic introduce los conceptos fundamentales de POO. Contiene una clase Point que calcula distancias entre puntos en un plano y una clase CheckingAccount que simula el funcionamiento de una cuenta corriente con operaciones de depósito y retirada.

### Programación orientada a objetos avanzada

En oo_advanced se trabajan conceptos más complejos como herencia y polimorfismo. La clase Person modela una persona con atributos como nombre, edad, peso y altura, incluyendo métodos para calcular el índice de masa corporal y generar DNI aleatorios. De ella heredan las clases Teacher, SubstituteTeacher y TenuredTeacher que añaden funcionalidad específica para profesores.

### JDBC

El paquete jdbc contiene un sistema completo de gestión de una tienda de videojuegos conectada a base de datos MariaDB. El subpaquete business define las entidades del negocio como Customer, Sale, SaleDetail y VideoGame. El subpaquete database contiene las clases DAO para operaciones de inserción, consulta, estadísticas y actualización. La clase StoreUI proporciona una interfaz de menú por consola para interactuar con el sistema.

### Tests

En test hay una clase BankAccount con su correspondiente clase de pruebas unitarias BankAccountTest que verifica el correcto funcionamiento de las operaciones bancarias.

## Requisitos

Para ejecutar los ejercicios es necesario tener instalado Java 17 o superior. Los ejercicios del paquete jdbc requieren además una conexión a una base de datos MariaDB con el esquema correspondiente.

## Ejecución

Cada clase que contiene un método main puede ejecutarse de forma independiente. Se recomienda usar un IDE como IntelliJ IDEA para facilitar la navegación y ejecución de los ejercicios.
