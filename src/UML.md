```
@startuml

class Entrenador {
  - nombre: String
  - equipo: List<Modelo.Pokemon>
  - pokemonesUsados: Set<Modelo.Pokemon>
  - rondasGanadas: int
  + elegirPokemon(): Modelo.Pokemon
  + aumentarRondasGanadas(): void
  + getNombre(): String
  + getRondasGanadas(): int
}

class Modelo.Pokemon {
  - nombre: String
  - tipo: String
  - ataque: int
  - defensa: int
  - habilidad: HabilidadEspecial
  - turnosConHabilidad: int
  + usarHabilidad(): boolean
  + calcularAtaqueTotal(oponente: Modelo.Pokemon): int
  + getNombre(): String
  + getTipo(): String
}

class HabilidadEspecial {
  - nombre: String
  - efecto: String
  - valor: int
  - probabilidad: int
  + activar(): boolean
  + aplicarEfecto(pokemon: Modelo.Pokemon, oponente: Modelo.Pokemon): void
}

class Batalla {
  - entrenador1: Entrenador
  - entrenador2: Entrenador
  - rondaActual: int
  + jugarRonda(): void
  + determinarGanador(): Entrenador
  + aplicarEfectosTipo(pokemon1: Modelo.Pokemon, pokemon2: Modelo.Pokemon): int
}

class Vista.Main {
  + main(args: String[]): void
}

Entrenador "1" o-- "*" Modelo.Pokemon
Modelo.Pokemon "1" o-- "1" HabilidadEspecial
Batalla --> Entrenador
Vista.Main --> Batalla

@enduml
