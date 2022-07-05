## Padrão State
É aplicado quando a chamada de um método depende do estado do objeto, como é o caso do método "aplicarDescontoExtra", 
cada situação irá ter suas próprias regras  onde a classe mãe é implementada para ser uma "casca" para cada classe filha.
<br/>
Ao invés de utilizar Enum para definir o estado do objeto, são criadas classes para representar esse estado, assim podemos
definir algumas lógicas para cada estado dentro das classes. Com a criação da classe mãe podemos abstrair algumas lógicas/métodos
comuns para as filhas, assim, as filhas só irão sobreescrever essas lógicas/métodos caso necessite.
<br/>
Dessa forma é possível transitar entre os estados do objeto através da própria instancia sem se preocupar com a lógica implementada
em cada estado.