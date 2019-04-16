# Torneo De Ferscas
Primer TP Laboratorio 5 - Strategy Pattern

## Qué es Maven
Maven es una herramienta para la gestión de proyectos de software, es usada para construir proyectos, dependencias y documentación. Básicamente automatiza y simplifica el proceso de construcción, resuelve dependencias y provee información sobre el proyecto.

## Qué es POM y para qué nos sirve
POM (Project Object Model) son archivos XML que contienen información relacionada con el proyecto y la información de configuración, como las dependencias, directorio fuente, plugins, metas, etc. Usadas por Maven para construir un proyecto.
Al ejecutar Maven sobre un archivo POM este se encarga de cargar automáticamente las dependencias y configuraciones de un proyecto, sin necesidad de hacerlo manualmente.

## Diferencia entre Archetype y Artifacid

- ArtifacId es el identificador único del artefacto principal de un proyecto. El artefacto principal para un proyecto es típicamente el archivo JAR. Los artefactos secundarios como los paquetes de origen también usan el artefacto como parte de su nombre final.

- En cambio Archetype es una plantilla de proyecto, definida como un patrón o modelo original a partir del cual se hacen todas las otras cosas del mismo tipo. También son empaquetados en un archivo JAR, pero solo contienen las configuraciones y datos necesarios para generar la plantilla del proyecto.
