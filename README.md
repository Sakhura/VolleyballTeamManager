# VolleyballTeamManager 🏐

Un programa de gestión de equipos de voleibol para la Escuela Secundaria Verde Valley que permite administrar jugadores, identificar mejores atacantes y bloqueadores, y crear equipos de práctica equilibrados.

## 📋 Características

- ✅ **Carga de datos** desde archivo de texto
- ✅ **Top 3 atacantes** ordenados por estadísticas
- ✅ **Top 3 bloqueadores** ordenados por estadísticas
- ✅ **Equipos equilibrados** de 6 jugadores cada uno
- ✅ **Interfaz de menú** interactiva
- ✅ **Validación de errores** y manejo de archivos

## 🎯 Requisitos del Sistema

- **Java**: Usado JDK 24 , tambien puede ser 8 o superior
- **IDE**: IntelliJ IDEA (recomendado) o cualquier IDE de Java
- **Sistema Operativo**: Windows, macOS o Linux

## 📁 Estructura del Proyecto

```
VolleyballManager/
├── .idea/                  # Configuración de IntelliJ
├── src/
│   ├── Player.java         # Clase para representar jugadores
│   └── VolleyballTeamManager.java  # Clase principal
├── jugadores.txt           # Archivo de datos (DEBE estar aquí)
├── VolleyballManager.iml   # Configuración del módulo
├── .gitignore
└── README.md
```

## 🚀 Instalación y Configuración

### Paso 1: Clonar o Descargar el Proyecto
```bash
# Si usas Git
git clone <https://github.com/Sakhura/VolleyballTeamManager>
cd VolleyballManager

# O descarga y extrae el ZIP
```

### Paso 2: Abrir en IntelliJ IDEA
1. **Abrir IntelliJ IDEA**
2. **File** → **Open**
3. **Seleccionar** la carpeta `VolleyballManager`
4. **Hacer clic** en "Open"
5. **Esperar** a que IntelliJ configure el proyecto

### Paso 3: Verificar Configuración de Java
1. **File** → **Project Structure** (Ctrl+Alt+Shift+S)
2. **Project Settings** → **Project**
3. **Verificar** que el SDK esté configurado (JDK 8+)
4. **Apply** → **OK**

### Paso 4: Crear el Archivo de Datos
1. **Click derecho** en la raíz del proyecto (fuera de `src/`)
2. **New** → **File**
3. **Nombre**: `jugadores.txt`
4. **Copiar** los siguientes datos:

```
Rachael Adams 3.36 1.93
Foluke Akinradewo 4.81 1.14
Kayla Banwarth 2.98 0.50
Michelle Bartsch 0.28 1.42
Krista Vansant 2.78 0.86
Courtney Thompson 0.59 0.93
Kelly Murphy 1.15 0.58
Lauren Gibbemeyer 2.25 0.50
Alexis Crimes 3.89 1.34
Tori Dixon 0.92 1.62
Nicole Fawcett 4.01 0.61
Alisha Glass 1.96 1.55
Natalie Hagglund 2.49 0.52
Kim Hill 1.53 1.76
Cursty Jackson 0.69 1.44
```

## ▶️ Cómo Ejecutar el Programa

### Método 1: Desde IntelliJ IDEA
1. **Abrir** `src/VolleyballTeamManager.java`
2. **Click derecho** en el archivo
3. **Seleccionar** "Run 'VolleyballTeamManager.main()'"
4. **O usar** el botón verde ▶️ junto al método `main`

### Método 2: Desde Terminal
```bash
# Compilar
javac -d out src/*.java

# Ejecutar
java -cp out VolleyballTeamManager
```

## 🎮 Guía de Uso Paso a Paso

### 1. Iniciar el Programa
Al ejecutar, verás:
```
=== Verde Valley Volleyball Team Manager ===

--- MENÚ PRINCIPAL ---
1. Abrir una lista de jugadores
2. Mostrar los 3 mejores atacantes
3. Mostrar los 3 mejores bloqueadores
4. Crear y mostrar equipos de práctica
5. Salir
Selecciona una opción (1-5):
```

### 2. Cargar Lista de Jugadores (¡IMPORTANTE - HACER PRIMERO!)
1. **Escribir**: `1` y presionar Enter
2. **Escribir**: `jugadores.txt` y presionar Enter
3. **Resultado esperado**:
```
¡Lista de jugadores cargada exitosamente!
Total de jugadores: 15
```

### 3. Ver Top 3 Atacantes
1. **Escribir**: `2` y presionar Enter
2. **Resultado esperado**:
```
=== 3 MEJORES ATACANTES ===
1. Foluke Akinradewo - Estadísticas de ataque: 4.81
2. Nicole Fawcett - Estadísticas de ataque: 4.01
3. Alexis Crimes - Estadísticas de ataque: 3.89
```

### 4. Ver Top 3 Bloqueadores
1. **Escribir**: `3` y presionar Enter
2. **Resultado esperado**:
```
=== 3 MEJORES BLOQUEADORES ===
1. Rachael Adams - Estadísticas de bloqueo: 1.93
2. Kim Hill - Estadísticas de bloqueo: 1.76
3. Tori Dixon - Estadísticas de bloqueo: 1.62
```

### 5. Crear Equipos de Práctica
1. **Escribir**: `4` y presionar Enter
2. **Resultado esperado**:
```
=== EQUIPOS DE PRÁCTICA ===
Jugadores totales: 15
Equipos a formar: 2

Equipo 1:
  Foluke Akinradewo    Ataque: 4.81  Bloqueo: 1.14
  Alexis Crimes        Ataque: 3.89  Bloqueo: 1.34
  Kayla Banwarth       Ataque: 2.98  Bloqueo: 0.50
  Kim Hill             Ataque: 1.53  Bloqueo: 1.76
  Alisha Glass         Ataque: 1.96  Bloqueo: 1.55
  Michelle Bartsch     Ataque: 0.28  Bloqueo: 1.42
  Promedio - Ataque: 2.58, Bloqueo: 1.29

Equipo 2:
  Nicole Fawcett       Ataque: 4.01  Bloqueo: 0.61
  Rachael Adams        Ataque: 3.36  Bloqueo: 1.93
  Krista Vansant       Ataque: 2.78  Bloqueo: 0.86
  Tori Dixon           Ataque: 0.92  Bloqueo: 1.62
  Cursty Jackson       Ataque: 0.69  Bloqueo: 1.44
  Courtney Thompson    Ataque: 0.59  Bloqueo: 0.93
  Promedio - Ataque: 2.06, Bloqueo: 1.23
```

### 6. Salir del Programa
1. **Escribir**: `5` y presionar Enter

## 📊 Formato del Archivo de Datos

El archivo `jugadores.txt` debe seguir este formato:
```
Nombre Apellido EstadísticasAtaque EstadísticasBloqueo
```

**Ejemplo**:
```
Rachael Adams 3.36 1.93
```

- **Separador**: Espacios
- **Decimales**: Usar punto (.) no coma (,)
- **Una línea por jugador**

## 🚨 Solución de Problemas

### Problema: "Por favor, abre una lista de jugadores"
**Causa**: No se ha cargado el archivo de jugadores
**Solución**: Usar opción 1 primero para cargar `jugadores.txt`

### Problema: "Error: No se pudo encontrar el archivo"
**Causa**: El archivo no está en la ubicación correcta
**Solución**:
1. Verificar que `jugadores.txt` esté en la raíz del proyecto (no en `src/`)
2. Verificar que el nombre sea exacto: `jugadores.txt`

### Problema: "No hay suficientes jugadores para formar equipos"
**Causa**: Menos de 6 jugadores en la lista
**Solución**: Añadir más jugadores al archivo `jugadores.txt`

### Problema: Números no se muestran correctamente
**Causa**: Formato incorrecto en el archivo
**Solución**: Verificar que los números usen punto (.) no coma (,)

### Problema: El programa no compila
**Causa**: Configuración de Java
**Solución**:
1. Verificar que el JDK esté configurado
2. **File** → **Invalidate Caches and Restart**

## 🔧 Algoritmo de Distribución de Equipos

El programa crea equipos equilibrados usando este algoritmo:

1. **Dividir** jugadores en grupos de 6
2. **Ordenar** por estadísticas de ataque (mayor a menor)
3. **Distribuir** mejores atacantes alternando entre equipos
4. **Ordenar** jugadores restantes por estadísticas de bloqueo
5. **Distribuir** mejores bloqueadores alternando entre equipos

Esto asegura que cada equipo tenga una mezcla equilibrada de atacantes y bloqueadores fuertes.

## 👥 Ejemplo de Uso Completo

```
=== Verde Valley Volleyball Team Manager ===

--- MENÚ PRINCIPAL ---
1. Abrir una lista de jugadores
2. Mostrar los 3 mejores atacantes
3. Mostrar los 3 mejores bloqueadores
4. Crear y mostrar equipos de práctica
5. Salir
Selecciona una opción (1-5): 1
Ingresa el nombre del archivo: jugadores.txt
¡Lista de jugadores cargada exitosamente!
Total de jugadores: 15

--- MENÚ PRINCIPAL ---
1. Abrir una lista de jugadores
2. Mostrar los 3 mejores atacantes
3. Mostrar los 3 mejores bloqueadores
4. Crear y mostrar equipos de práctica
5. Salir
Selecciona una opción (1-5): 2

=== 3 MEJORES ATACANTES ===
1. Foluke Akinradewo - Estadísticas de ataque: 4.81
2. Nicole Fawcett - Estadísticas de ataque: 4.01
3. Alexis Crimes - Estadísticas de ataque: 3.89

--- MENÚ PRINCIPAL ---
1. Abrir una lista de jugadores
2. Mostrar los 3 mejores atacantes
3. Mostrar los 3 mejores bloqueadores
4. Crear y mostrar equipos de práctica
5. Salir
Selecciona una opción (1-5): 5
¡Gracias por usar Verde Valley Volleyball Team Manager!
```

## 📝 Notas Importantes

- **SIEMPRE** cargar la lista de jugadores (opción 1) antes de usar otras opciones
- El archivo `jugadores.txt` debe estar en la **raíz** del proyecto, NO en `src/`
- Cada equipo tendrá exactamente **6 jugadores**
- Los jugadores sobrantes (si no son múltiplo de 6) no se asignan a equipos
- Las estadísticas se muestran con **2 decimales**

## 🆘 Soporte

Si tienes problemas:
1. Verifica que seguiste todos los pasos de instalación
2. Revisa la sección de "Solución de Problemas"
3. Asegúrate de que el archivo `jugadores.txt` tenga el formato correcto

## 👥 Créditos

Desarrollado por Sabina Romero y Andres Perot

## Iconografía

Link: https://iconos8.es/icons/set/whatsapp-emoji

---

**¡Listo para gestionar tus equipos de voleibol! 🏐**