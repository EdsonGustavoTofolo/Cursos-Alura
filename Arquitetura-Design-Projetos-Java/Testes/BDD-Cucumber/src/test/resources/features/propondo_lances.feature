# language: pt
Funcionalidade: Propondo lances
  Cenario: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe o leilao
    Então o lance eh aceito

  Cenario: Propondo varios lances validos
    Dado varios lances validos
    Quando propoe varios lances ao leilao
    Então os lances sao aceitos

  Cenario: Propondo dois lances validos
    Dado um lance de 10.0 reais do usuario "fulano"
    E um lance de 15.0 reais do usuario "beltrano"
    Quando propoe dois lances ao leilao
    Entao os dois lances sao aceitos

  Esquema do Cenario: Propondo um lance invalido
    Dado um lance invalido de <valorInvalido> reais e do usuario '<nomeUsuario>'
    Quando propoe o leilao
    Entao o lance nao eh aceito
    Exemplos:
      | valorInvalido | nomeUsuario |
      | 0.0           | fulano      |
      | -0.1          | cicrano     |

  Cenario: Propondo uma sequencia de lances
    Dado dois lances
    | valor | nomeUsuario |
    | 10.0  | beltrano    |
    | 15.0  | cilcrano    |
    Quando propoe varios lances ao leilao
    Entao o segundo lance nao eh aceito
