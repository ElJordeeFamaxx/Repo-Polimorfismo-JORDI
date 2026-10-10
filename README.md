# Repo-Polimorfismo-JORDI
UVG batalla de cartas - Ejercicio 5 sobre polimorfismo.

Para compilar y ejecutar desde la carpeta:
  javac *.java
  java Main

Arquitectura:
Modelo: Carta, Catedratico, Curso, EventoCampus, Mazo, Jugador, Juego.
Vista: JuegoView.
Controlador: JuegoController.
Entrada: Main.

Reglas propuestas (no fijadas por el enunciado):
- Batalla de 2 jugadores con 10 puntos de energia para comenzar.
- Utilizar una carta agota el costo, aplica su efecto y se acaba el turno.
- 12 cartas revueltas y 2 cartas iniciales para cada jugador.
- Catedratico recupera max(0, tiempoAtencion - llamadasAtencion).
- Tomar carta o pasar termina el turno.
- EventoCampus modifica energia en un valor positivo o negativo.
- Curso recupera max(0, creditos - dificultad).
- Buscar/listar solo consulta las cartas que siguen en el mazo.
- Energia minima 0. No hay condicion de victoria en el prototipo.

