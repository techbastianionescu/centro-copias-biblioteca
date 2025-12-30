# Centro de Copias de la Biblioteca

Proyecto realizado en **Java** para la asignatura **Programación de Servicios y Procesos** del Grado Superior de **Desarrollo de Aplicaciones Multiplataforma (DAM)**.

El objetivo del proyecto es simular el funcionamiento de un centro de copias de una biblioteca utilizando **programación concurrente**, garantizando el uso correcto de hilos, la exclusión mutua y la coordinación entre procesos mediante `synchronized`, `wait()` y `notifyAll()`.

---

## 🧠 Contexto del problema

En una biblioteca existe un centro de copias utilizado por estudiantes:

- Hay **5 estudiantes**, cada uno representado por un hilo.
- El centro dispone de **2 máquinas de copiado**.
- Cada máquina solo puede ser utilizada por **un estudiante a la vez**.
- Si no hay máquinas disponibles, los estudiantes deben **esperar** hasta que una se libere.

Cada estudiante repite el siguiente ciclo:
1. Estudia durante un tiempo aleatorio.
2. Solicita una máquina de copiado.
3. Realiza las copias.
4. Libera la máquina.
5. Vuelve a estudiar.

El programa se ejecuta durante **20 segundos** y, al finalizar, se muestra cuántas veces ha realizado copias cada estudiante.

---

## ⚙️ Tecnologías utilizadas

- Lenguaje: **Java**
- Programación concurrente:
  - `Thread`
  - `Runnable`
  - `synchronized`
  - `wait()` / `notifyAll()`

No se utilizan frameworks ni gestores de dependencias como Maven o Gradle.

---

## 🗂️ Estructura del proyecto

```
centro-copias-biblioteca/
└── src/
    ├── Main.java
    ├── Estudiante.java
    └── CentroCopias.java
```

---

## 🧩 Descripción de las clases

### CentroCopias
Clase encargada de gestionar las máquinas de copiado.  
Controla el acceso concurrente al recurso compartido mediante métodos `synchronized` y gestiona la espera de los estudiantes utilizando `wait()` y `notifyAll()`.

### Estudiante
Representa a un estudiante y se ejecuta como un hilo.  
Simula el ciclo de estudio y copiado, solicitando y liberando máquinas de forma sincronizada y contabilizando el número de copias realizadas.

### Main
Clase principal del programa.  
Inicializa los estudiantes, controla el tiempo total de ejecución (20 segundos), finaliza correctamente los hilos y muestra el resultado final por consola.

---

## ▶️ Compilación y ejecución

Desde la carpeta `src` del proyecto, ejecutar los siguientes comandos:

```
javac *.java
java Main
```

---

## 📤 Salida por consola

Durante la ejecución se muestra el comportamiento del sistema, por ejemplo:

```
Estudiante 2 está estudiando
Estudiante 2 solicita máquina
Estudiante 2 usa máquina 1
Estudiante 2 libera máquina 1
```

Al finalizar el programa se muestra un resumen con el número de copias realizadas por cada estudiante:

```
--- RESULTADO FINAL ---
Estudiante 0 hizo copias 9 veces
Estudiante 1 hizo copias 9 veces
Estudiante 2 hizo copias 8 veces
Estudiante 3 hizo copias 9 veces
Estudiante 4 hizo copias 8 veces
```

---

## ✅ Cumplimiento de requisitos

- Uso correcto de hilos.
- Exclusión mutua garantizada.
- Sincronización mediante `synchronized`.
- Uso correcto de `wait()` y `notifyAll()`.
- No existen esperas activas.
- Gestión correcta del recurso compartido.
- Finalización correcta de todos los hilos.
- Salida clara y comprensible por consola.

---

## 👤 Autor

Proyecto desarrollado de forma individual como parte de la formación en el Grado Superior de Desarrollo de Aplicaciones Multiplataforma (DAM).
