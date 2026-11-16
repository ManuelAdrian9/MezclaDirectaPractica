# Algoritmo de Mezcla Directa en Java (Straight Merge)

Implementación práctica de la fase de fusión (intercalación de bloques) del algoritmo de ordenamiento externo *Mezcla Directa* en Java. El programa lee dos archivos de texto plano auxiliares con bloques previamente ordenados de longitud L, los compara secuencialmente y genera un archivo de salida unificado y ordenado.

---

## 📋 Características

* *Ordenamiento externo:* Procesamiento de datos mediante flujos de entrada/salida (java.io) sin cargar todo el volumen de datos en memoria RAM.
* *Control de bloques de tamaño L:* Intercalación exacta respetando los límites de cada subsecuencia ordenada.
* *Gestión segura de recursos:* Uso de try-with-resources para garantizar el cierre automático de archivos y evitar fugas de memoria o bloqueos en disco.
* *Vaciado de remanentes:* Manejo seguro cuando uno de los archivos auxiliares finaliza antes que el otro, evitando la pérdida de datos o escritura de valores null.

---

## 🛠️ Requisitos Previos

* *Java Development Kit (JDK):* Versión 8 o superior.
* *Archivos de entrada:* Dos archivos de texto plano (f1.txt y f2.txt) ubicados en el directorio raíz del proyecto.

---

## 📂 Estructura del Proyecto

text
├── MezclaDirectaPractica.java   # Código fuente principal con la lógica de intercalación
├── f1.txt                       # Archivo auxiliar 1 (entrada)
├── f2.txt                       # Archivo auxiliar 2 (entrada)
└── f3.txt                       # Archivo de salida generado automáticamente


---

## 🚀 Cómo Ejecutar el Proyecto

### 1. Preparar los archivos de entrada
Crea dos archivos de texto plano (f1.txt y f2.txt) en la carpeta raíz del proyecto. Escribe *un número entero por línea* ordenado de forma ascendente en cada archivo.

*Ejemplo para L = 3:*

* *f1.txt*
  text
  1
  8
  15
  

* *f2.txt*
  text
  2
  12
  20
  

### 2. Compilar y ejecutar desde la terminal
Abre una consola en la carpeta raíz donde se encuentra el archivo .java y ejecuta:

bash
javac MezclaDirectaPractica.java
java MezclaDirectaPractica


(Si usas un IDE como NetBeans, IntelliJ IDEA o Eclipse, asegúrate de que f1.txt y f2.txt estén al mismo nivel que la carpeta src antes de presionar **Run).

---

## 📊 Ejemplo de Salida

Al finalizar la ejecución, la consola mostrará:

text
Bloque intercalado con exito!


Y se generará automáticamente el archivo *f3.txt* con los elementos intercalados en orden ascendente:

text
1
2
8
12
15
20


---

## ⚙️ Personalización

Puedes modificar el tamaño del bloque L o los nombres de los archivos directamente en el método main:

java
public static void main(String[] args) {
    // Parámetros: archivoF1, archivoF2, archivoSalida, tamañoBloqueL
    intercalarBloques("f1.txt", "f2.txt", "f3.txt", 3);
}
