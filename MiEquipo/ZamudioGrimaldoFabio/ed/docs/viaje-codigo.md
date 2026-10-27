# Evidencia 3. Memoria técnica de compilación, virtualización y entornos

**Ubicación del archivo:** `ed/docs/viaje-codigo.md`  
**Proyecto:** `ZamudioGrimaldoFabio`  
**Captura del entorno:** `ed/docs/entorno2.png`  

---

## 1. La cadena de transformación del código

En el paradigma de desarrollo con Java, el proceso mediante el cual las instrucciones escritas por el programador terminan ejecutándose en la CPU del sistema anfitrión involucra tres etapas técnicas claramente delimitadas:

1. **Código Fuente (`.java`):**
   * **Naturaleza:** Archivo de texto plano que contiene la implementación estructurada en sintaxis Java (clases, métodos, interfaces).
   * **Propósito:** Está diseñado exclusivamente para la lectura, escritura y mantenimiento por parte de seres humanos.
   * **Ejecución:** No es ejecutable directamente por ningún procesador ni sistema operativo.

2. **Código Objeto o Intermedio (`.class` / *Bytecode*):**
   * **Naturaleza:** Formato binario de alto nivel generado tras procesar los archivos `.java` mediante el compilador de Java (`javac`).
   * **Propósito:** Constituye un conjunto de instrucciones estandarizadas orientadas a un procesador abstracto o virtual.
   * **Ejecución:** No está ligado a ninguna arquitectura física (x86-64, ARM, etc.), por lo que requiere un entorno de ejecución especializado para ser interpretado.

3. **Código Máquina Ejecutable Nativo:**
   * **Naturaleza:** Secuencia binaria pura de instrucciones de bajo nivel específicas del juego de instrucciones de la CPU anfitriona.
   * **Propósito:** Es la representación final que el hardware procesa directamente a través de sus registros y unidades aritmético-lógicas (ALU).
   * **Ejecución:** Generado en tiempo de ejecución (*Just-In-Time* / JIT Compilation) a partir del *bytecode* para lograr la velocidad de ejecución nativa en la máquina física.

---

## 2. Tecnologías de virtualización y la JVM

La **Máquina Virtual de Java (JVM)** es el componente central del entorno de ejecución de Java (JRE/JDK). Actúa como una capa de abstracción de software situada entre el *bytecode* de la aplicación y el sistema operativo de la máquina física.

### Funcionamiento de la JVM
Cuando se inicia una aplicación Java, la JVM realiza las siguientes tareas esenciales:
1. **Carga de Clases (*ClassLoader*):** Busca y carga en memoria los archivos `.class` requeridos.
2. **Verificación de Bytecode:** Garantiza que el código no viole las restricciones de seguridad ni la integridad de la memoria.
3. **Motor de Ejecución (*Execution Engine*):** 
   * **Interprete:** Traduce línea a línea el *bytecode* a código máquina nativo.
   * **Compilador JIT (Just-In-Time):** Identifica las secciones de código ejecutadas con mayor frecuencia (*hotspots*) y las compila directamente a código máquina almacenándolas en caché para maximizar el rendimiento.
4. **Gestión de Memoria (*Garbage Collector*):** Administra de forma automática la asignación y liberación de memoria Heap sin intervención manual del desarrollador.

### Justificación de «Write Once, Run Anywhere» (WORA)
El lema «Escríbelo una vez, ejecútalo en cualquier lugar» se sostiene en la separación explícita entre el compilador y la JVM:

$$\text{Código Fuente (.java)} \xrightarrow{\text{javac}} \text{Bytecode (.class)} \xrightarrow{\text{JVM Específica}} \text{Código Nativo}$$

* El desarrollador solo necesita compilar el código fuente **una vez** para generar el archivo `.class` uniforme.
* Existe una versión específica de la JVM desarrollada e instalable para cada sistema operativo y arquitectura (Windows x64, Linux ARM, macOS Apple Silicon, etc.).
* Dado que cada JVM conoce cómo traducir el *bytecode* estándar a las instrucciones nativas de su propio sistema operativo, el mismo archivo `.class` se ejecuta sin necesidad de modificación o recompilación alguna.

---

## 3. Evaluación comparativa de entornos de desarrollo

Para el soporte del proyecto `ZamudioGrimaldoFabio`, se ha evaluado el rendimiento y la adecuación técnica entre un entorno de desarrollo integrado especializado (**IntelliJ IDEA Community**) y un editor de código extensible (**Visual Studio Code con extensiones Java**).

| Criterio | IntelliJ IDEA Community Edition | Visual Studio Code (con Java Extension Pack) |
| :--- | :--- | :--- |
| **Categoría** | IDE Integral out-of-the-box | Editor de texto modular y ligero |
| **Consumo de recursos** | **Alto:** Requiere entre 1.5 GB y 4 GB de RAM. Uso intensivo de CPU durante la indexación. | **Bajo / Moderado:** Requiere entre 500 MB y 1.5 GB de RAM según las extensiones activas. |
| **Velocidad de arranque** | **Lenta:** La carga inicial del proyecto e indexación del árbol de clases toma más tiempo. | **Rápida:** Apertura casi instantánea de la interfaz y archivos individuales. |
| **Análisis de código y refactorización** | **Avanzado y Nativo:** Detección de errores en tiempo real, refactorización segura de paquetes/clases e introspección de dependencias. | **Básico / Intermedio:** Depende del servidor de lenguaje (*Language Server Protocol*). Puede presentar demoras o inconsistencias. |
| **Integración con Build Tools** | Integración nativa e indolora con Maven/Gradle. Soporta reestructuraciones automáticamente. | Requiere extensiones de terceros para gestionar tareas y proyectos Maven. |
| **Adecuación Técnica** | **Recomendado para el proyecto:** Ideal para desarrollo profesional Java, minimiza fallos en la estructura de paquetes y manejo de dependencias. | Ideal para ediciones rápidas, scripts ligeros o entornos con limitaciones severas de hardware. |

---

## 4. El porqué de Apache Maven

El uso de **Apache Maven** como herramienta de automatización de la construcción (*build tool*) resuelve las limitaciones estructurales y operativas de la compilación manual por consola (`javac`, `java`).

### A. Ventajas frente a la compilación manual por consola
* **Reproducibilidad:** Garantiza que cualquier miembro del equipo compile el proyecto exactamente con las mismas reglas y dependencias sin depender de la configuración local del sistema.
* **Automatización del ciclo de vida:** Permite ejecutar fases complejas (limpieza, compilación, pruebas unitarias, empaquetado en `.jar` y despliegue) mediante comandos estandarizados como `mvn clean package`.

### B. Principio de «Convención sobre Configuración» (*Convention over Configuration*)
Maven establece una estructura estandarizada de directorios que evita escribir archivos de configuración extensos y propensos a errores:

```text
ZamudioGrimaldoFabio/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/       <-- Código fuente Java
    │   └── resources/  <-- Archivos de configuración y activos
    └── test/
        ├── java/       <-- Pruebas unitarias
        └── resources/  <-- Recursos para pruebas
```

Al adherirse a esta estructura convencional, Maven asume automáticamente las rutas de entrada y salida de los binarios sin necesidad de especificarlas manualmente en el `pom.xml`.

### C. Resolución de dependencias transitivas
En el desarrollo de software moderno, una librería externa suele depender de otras librerías secundarias.
* **Sin Maven:** El desarrollador tendría que buscar, descargar y agregar manualmente al *classpath* la librería deseada y todas sus subdependencias.
* **Con Maven:** Basta con declarar la librería directa dentro de las etiquetas `<dependencies>` del archivo `pom.xml`. Maven consulta el repositorio central, calcula el árbol de dependencias e identifica, descarga e incluye automáticamente todas las **dependencias transitivas** requeridas, gestionando también la resolución de conflictos de versión.

---

## 5. Registro visual y trazabilidad del entorno

El entorno de desarrollo, la jerarquía de paquetes de la solución y la integración del archivo de construcción `pom.xml` se encuentran documentados visualmente en la siguiente referencia del proyecto:

* **Archivo de captura:** `ed/docs/entorno2.png`