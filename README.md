# Parcial 1 ARSW

## Empezando

Estas instrucciones le proporcionarán una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y prueba.
### Prerrequisitos

Debe instalar las siguientes herramientas y configurar sus dependencias:

1. **Java** (versions 7 or 8)
    ```sh
    java -version
    ```
    Retorna
    ```sh
    java version "1.8.0"
    Java(TM) SE Runtime Environment (build 1.8.0-b132)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
    ```

2. **Maven**
    - Descarga Maven desde [here](http://maven.apache.org/download.html)
    - Sigue las siguientes instrucciones [here](http://maven.apache.org/download.html#Installation)

    verifica la instalación:
    ```sh
    mvn -version
    ```
    Retorna
    ```sh
    Apache Maven 3.2.5 (12a6b3acb947671f09b81f49094c53f426d8cea1; 2014-12-14T12:29:23-05:00)
    Maven home: /Users/dnielben/Applications/apache-maven-3.2.5
    Java version: 1.8.0, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre
    Default locale: es_ES, platform encoding: UTF-8
    OS name: "mac os x", version: "10.10.1", arch: "x86_64", family: "mac"
    ```
### Intalación

1.Clona el repositorio y navega hasta el directorio del proyecto:
    ```sh
    git clone https://github.com/alexandrac1420/Parcial1_ARSW
    cd Parcial1
    ```

 Construya el backend de Spring Boot:
    ```sh
    cd demo
    mvn package
    ```

3. Ejecuta el jar
    ```sh
    java -jar Parcial 0.0.1-SNAPSHOT.jar
    ```
    
### Implementacion en AWS
Siga estos pasos para implementar la aplicación en AWS:

1. **Iniciar la máquina virtual**

    Inicie una instancia EC2 con su configuración preferida.

    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image.png)

2. **Transferir dependencias y el archivo JAR.**

    Cargue el archivo dependencies.zip (que contiene las dependencias necesarias) y el archivo JAR creado en la máquina virtual creada.
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-1.png)
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-2.png)

3. **Ejecute el siguiente comando**

    Navegue hasta el directorio donde cargó los archivos y ejecute:
    ```sh
     java -jar demo-0.0.1-SNAPSHOT.jar
    ```
    Esto iniciará el servicio Spring.

4. **Iniciar el servicio de primavera**

    Asegúrese de que la aplicación Spring Boot se inicie sin errores.
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-3.png)

5. **Verificar la implementación**
6. 
    Al iniciar el servicio se muestra la siguiente pantalla:
    
    ![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/5af7698d-a66b-416f-8836-43727ef46751)
    
    Despues de ejecutar una busqueda genera la siguiente respuesta:
    
    ![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/6172d539-dab2-4349-9544-6c6b6516d042)
    
    El link al despliegue que se uso fue 
    ```
    http://ec2-3-81-62-164.compute-1.amazonaws.com:8080/
    ```
### Diseño
![Untitled](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/3fc83c5f-98b7-48fa-ad6a-453908562bf2)

El diseño utilzado es el siguiente:
1. Se tiene una clase que controla las solicitudes realizadas por el usuario mediante servicios REST de http (`Parcial1Controller`). Esta clase tiene memoria que permite identificar si la consulta se ha realizado antes, en caso de que se haya realizado con anterioridad llama a la respuesta que tiene guardada, si no ocurre este caso realiza el proceso para conectarse con el servicio externo.
2. Existe una clase que se conecta con la API externa y contiene la logica de la aplicación(`Parcial1Service`). Esta clase extiende una interfaz que permite que se creen diferentes instancias que permitan implementar diferentes API´s.
3. EL cliente web es el encargado de realizar la solicitud de los valores que desea consultar, en este caso estan disponibles las siguientes opciones:
    - **Tipo de valoracion**: Intraday. Daily, Weekly y Monthly
    - **Nombre de la empresa**: En este caso solo es funcinal `IBM` y `MSFT`
    - **Intervalo**: En caso de que el tipo de valoracion sea `Intraday`se debe elegir una opcion de intervalo (solo son funcionales 1min y 5min) en caso de elegir otro tipo de valoración es necesario dejarla en su valor por defecto `N/A`
4. La interfaz se encarga de que en caso de que se necesite utilizar otra API, la aplicación sea extendible.

### Test
Se realiza una prueba de concurrencia al servidor, donde se ejecutan 20 hilos y se recibe la respuesta de ada uno de ellos.

![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/d1846db3-3833-4ccd-b25c-201802b187a7)

### Patrones
Este proyecto usa inyeccion de dependencias e inversion de control mediante la etiquete en `@Autowired` en el controlador del servicio.

![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/c91513be-16b9-47fa-a981-8ae38771305a)


### Nuevas funcionalidades
En caso de que se necesite implementar otra API, se puede genera otra clase que implente esta interfaz (`Api_Interface`) y se genera la nueva implementación.


## Construido con 
* [Maven](https://maven.apache.org/) - Dependency Management for backend
* [Spring Boot](https://spring.io/projects/spring-boot) - Backend framework
* [Git](http://git-scm.com/) - Version Control System

## Versionamietno

Use [GitHub](https://github.com/) para versionar. Para conocer las versiones disponibles, consulte https://github.com/alexandrac1420/Parcial1_ARSW

## Authors

* **Alexandra Cortes Tovar** - [alexandrac1420](https://github.com/alexandrac1420)

