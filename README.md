# Client

Para executar o projeto Client local é necessário ter instalado o postgress, maven a partir da versão 3.3.9 <br/>
e a JDK8 na máquina. Após realizar o clone do projeto através do comando:<br/>
git clone https://github.com/leticiaMalipense/Client.git

Vá até o diretorio do mesmo pelo terminal execute o comando maven: <br/>
mvn clean package<br/>
Com isso vc irá baixar todas as dependências necessarias para o projeto e também irá gerar um pacote .jar,<br/>
este se encontrará dentro da pasta target que foi criada a partir da execução do comando. Agora basta ir até a<br/>
pasta target ainda pelo terminal e executar o jar gerado, por meio do comando:<br/>
java -jar client-1.0.0-SNAPSHOT.jar

Este ultimo comando é responsável por executar o projeto compilado, a partir de agora o Client deve estar funcionando<br/>
corretamente.

Caso não queira subir o projeto através de linha de comando, basta importar o projeto na sua IDE de preferrência<br/>
e roda-lo como um projeto SpringBoot comum.
