# tp2algo3

[![Build Status](https://travis-ci.com/JuanGaray93/tp2algo3.svg?branch=master)](https://travis-ci.com/JuanGaray93/tp2algo3)

Trabajo práctico 2 de Algoritmos 3, cátedra Fontela, Universidad de Buenos Aires.


Mapa: singleton. Le pedimos a una clase estática que nos pase el terreno.


Supuestos entrega 1:
  ·Las unidades creadas se crean instantáneamente en el casillero vacío más cercano al edificio que las crea y no se pueden mover hasta el siguiente turno.



Los edificios tienen un state que indican si están siendo construidos o si ya fueron construidos. El state "EnConstruccion" además podra tener un state que indique en qué nivel de construcción está.
Además, los edificios tienen una coordenada eje de la que va a calcularse dónde surgen las unidades que produce y qué lugar ocupa. 

Nota: Eliminamos clase Casillero, sólo necesitamos un mapa con un arreglo.

