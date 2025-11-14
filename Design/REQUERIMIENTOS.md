# REQUIRIMIENTOS

## Requerimiento 1

R01: El sistema debe poder simular interacciones entre las bacterias registradas, comparando sus comportamientos
 para determinar el tipo de relación que se produce entre ellas.

## Requerimiento 2

R02: El sistema debe identificar una relación simbiótica cuando se encuentren en la simulación las bacterias
Lactobacillus acidophilus y Streptococcus thermophilus, registrando el resultado como “SIMBIOSIS (crecen juntas) ”.

## Requerimiento 3

R03:El sistema debe permitir registrar múltiples bacterias de distintas clases (eubacterias y arqueobacterias), cada una con sus propiedades biológicas (nombre científico, hábitat, pH óptimo, temperatura óptima, etc.)  y almacenarlas en una lista para su posterior simulación.

## Requerimiento 4

R04: El sistema debe indicar cuando exista una competencia entre las bacterias Methanococcus Jannaschii y Halobacterium Salinarum.

## Requerimiento 5

R05: El microbiologo ambiental va a poder hacer una simulación con las bacterias registradas para crear pruebas con las mismas.

## Requerimiento 6

R06: El Bacteriologo únicamente podrá registrar las bacterias dependiendo de la clasificacion asignada, los dos deben tener un login y contraseña distinta.

## Requerimeinto 7

R07: El sistema mostrará la clasificación de las arqueas Halobacterium Salinarum y Methanococcus Jannaschii, ambas pertenecientes al Dominio Arquea.

## Requerimeinto 8

R08: Se podrá  analizar la respuesta salina de la Halobacterium dependiendo del nivel de salinidad registrado por el bacteriólogo.

## Requerimeinto 9

R09:  Se podrá añadir los elementos necesarios para la generación de metano por parte del Methanococcus Jannaschii.

## Requerimeinto 10

R10: El sistema registrará si una bacteria reacciona a antibióticos, los cuales serán registrados por el bacteriólogo.

## Requerimeinto 11

R11: El sistema registrara la eficiencia en la produccion de fermentacion de Lactobacillus Acidophilus y de Streptococcus Thermophilus.

## Requerimeinto 12

R12: El sistema podrá registrar la actividad toxica que presenta la bacteria Clostridum Botulinum.


## Requerimiento 13
R13: El sistema debe permitir que Clostridium botulinum active su metabolismo anaeróbico al detectar ácido láctico producido por una instancia de Lactobacilus_Acidophilus.
- activarPorLactobacillus(Lactobacilus_Acidophilus Lactobacilus): String

## Requerimiento 14
El sistema debe simular una competencia por recursos entre Clostridium botulinum, Lactobacilus_Acidophilus y Streptococcus_Thermophilus, generando una descripción textual de la interacción.
- competirConDosBacterias(Lactobacilus_Acidophilus lacto, Streptococcus_Thermophilus strepto): String

## Requerimiento 15
El sistema debe evaluar si la toxina botulínica de Clostridium botulinum inhibe el crecimiento de otra bacteria, dependiendo del tipo de bacteria y del estado de activación de la toxina.
- inhibirBacteria(Eubacteria bacteria, Float crecimiento): String