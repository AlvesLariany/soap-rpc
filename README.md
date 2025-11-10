# Implementação SOAP_RPC

##  Uso da API JAX-WS

O projeto foi desenvolvido utilizando a API **JAX-WS**, criada para uso em **serviços web SOAP**.

> ⚠️ Caso esteja utilizando uma versão do **Java superior à 11**, é necessário adicionar manualmente as dependências no arquivo `pom.xml`, pois os pacotes `javax.jws` foram removidos das versões mais recentes do JDK.

### Dependências (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>javax.jws</groupId>
        <artifactId>javax.jws-api</artifactId>
        <version>1.1</version>
    </dependency>
    <dependency>
        <groupId>com.sun.xml.ws</groupId>
        <artifactId>jaxws-rt</artifactId>
        <version>2.3.3</version>
    </dependency>
</dependencies>
```

---

##  Estrutura da Aplicação Servidor

```
src/
 └── org/example/rpc/services/
      ├── HelloWorld.java
      ├── HelloWorldImpl.java
      └── Publisher.java
```

### Descrição dos Arquivos

- **HelloWorld.java**  
  Interface onde definimos que é um *WebService* e que utilizará o estilo **RPC**.

- **HelloWorldImpl.java**  
  Classe que contém a implementação do serviço.  
  Define qual interface está sendo implementada e a lógica do método `sayHelloWorld`.

- **Publisher.java**  
  Classe responsável por **publicar** o serviço, disponibilizando-o em um endpoint HTTP.

---

##  Execução e Visualização

1. **Execute** a classe `Publisher.java`.
2. **Acesse** a URL informada no console, por exemplo:
   ```
   http://localhost:8080/rpc/helloworld?wsdl
   ```
3. O serviço será exibido no formato **WSDL** (Web Services Description Language), mostrando as definições do seu serviço SOAP.

---

## Exemplo de Estrutura WSDL

```xml
<definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
             xmlns:tns="http://services.rpc.example.org/"
             targetNamespace="http://services.rpc.example.org/"
             name="HelloWorldImplService">
    <service name="HelloWorldImplService">
        <port name="HelloWorldImplPort" binding="tns:HelloWorldImplPortBinding">
            <soap:address location="http://localhost:8080/rpc/helloworld"/>
        </port>
    </service>
</definitions>
```

---

## Testando com Postman 

Você pode testar o serviço enviando uma requisição SOAP do tipo `POST` para o endpoint:

```
http://localhost:8080/rpc/helloworld
```

### Headers
```
Content-Type: text/xml;charset=UTF-8
SOAPAction: ""
```

### Corpo da Requisição (Body → raw → XML)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://services.rpc.example.org/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:sayHelloWorld>
         <arg0>Lariany</arg0>
      </ser:sayHelloWorld>
   </soapenv:Body>
</soapenv:Envelope>
```

### Exemplo de Resposta

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:sayHelloWorldResponse xmlns:ns2="http://services.rpc.example.org/">
         <return>Olá, Lariany!</return>
      </ns2:sayHelloWorldResponse>
   </soap:Body>
</soap:Envelope>
```


