// Data: 11/11/2026
## Sockets
Sockets são uma camada/interface que permite a comunicação entre processos em 
diferentes dispositivos através de uma rede.
Toda comunicação de rede tem uma porta especifica, e precisamos serializar esses dados
### Tipos de Socket em Java
- Socket Cliente (Socket):
• Um socket cliente é usado pelo lado que inicia a comunicação.
• Ele se conecta a um servidor esperando por conexões em um endereço específico e porta.
- Socket Servidor (ServerSocket):
• Um socket servidor espera por conexões de clientes.
• Uma vez que um cliente se conecta, o servidor cria um novo socket dedicado para lidar com essa conexão.

## Exercicio de Aula
Aplicamos conexão via socket a nosso projeto pessoa, realizar cadastro da pessoa em cliente servidor, mandando um objeto para o servidor
Cada solicitação do cliente terá uma Thread, 

## Threads
é uma unidade de conexão leve que permite que um programa execute tarefas concorrentes
uma forma capaz de tornar uma aplicação capaz de realizar múltiplas operações simultâneas