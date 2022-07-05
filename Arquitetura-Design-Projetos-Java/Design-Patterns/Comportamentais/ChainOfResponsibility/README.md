## Padrão Chain of Responsibility
Padrão que encadeia as chamadas de várias regras.
<br/>
Principal diferença para saber aplicar Strategy ou Chain Of Responsiblity é que o Strategy precisa de um parâmetro para saber qual regra aplicar e a condição irá sumir, pois será substituída pela classe, já o Chain Of Responsibility não tem um parâmetro conhecido e a condição (o "if") continuará existindo.