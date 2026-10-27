# Memoria Técnica: Marco Metodológico y Ciclo de Vida del Software
**Consultora:** AzaharTech Software Consulting  
**Proyecto:** [nombre de tu proyecto elegido de la bolsa de proyectos]  
**Desarrollador/a:** [tus apellidos, tu nombre]  
**Fecha:** 25 de septiembre de 2026  
**Versión:** 1.0 (Sprint 1)

---

## 1. Justificación del modelo de proceso: Cascada vs. Scrum
Para el desarrollo de este proyecto se descarta el modelo tradicional en cascada debido a su rigidez ante los cambios de requisitos y a la dilatación en la entrega de resultados tangibles al cliente.

Se adopta el marco de trabajo ágil **Scrum**, estructurado en ciclos iterativos de desarrollo (**Sprints de 3 semanas**). Al finalizar cada sprint, el equipo entrega un **incremento de software potencialmente desplegable**, permitiendo que el cliente valide el producto de forma continua y minimizando el riesgo de desviación temporal o económica.

---

## 2. Aplicación de las fases del Ciclo de Vida del Software (SDLC)
En cada ciclo de sprint se ejecutan de forma coordinada las fases de la ingeniería del software adaptadas a nuestro sistema:

1. **Análisis.** Identificación de las necesidades del cliente y especificación de historias de usuario con criterios de aceptación claros.
2. **Diseño.** Modelado de la arquitectura de la solución, diagramas funcionales en Proyecto Intermodular y definición de estructuras de datos.
3. **Codificación.** Implementación de los algoritmos en lenguaje Java (OpenJDK 21) utilizando el entorno integrado IntelliJ IDEA Community.
4. **Pruebas (Testing).** Verificación de casos límite, validación de trazas de memoria e inspección visual con depurador.
5. **Despliegue.** Empaquetado y publicación de las entregas formales mediante etiquetas de versión (*Git Tags*) en el repositorio de GitHub.
6. **Mantenimiento.** Refactorización continua del código y corrección de incidencias detectadas en revisiones de sprint.

---

## 3. Organización y Roles en el Equipo de Trabajo
* **Product Owner.** Representa los intereses del cliente de nuestro proyecto, priorizando los requisitos en el *Product Backlog*.
* **Scrum Master (Laia Claramunt).** Supervisa el cumplimiento de los tiempos de entrega, elimina bloqueos técnicos y vela por la calidad metodológica.
* **Developer (El estudiante).** Responsable técnico del diseño algorítmico, implementación en Java, control de versiones en Git y documentación técnica.