## Implementacion en AWS
Al iniciar el servicio se muestra la siguiente pantalla:

![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/5af7698d-a66b-416f-8836-43727ef46751)

Despues de ejecutar una busqueda genera la siguiente respuesta:

![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/6172d539-dab2-4349-9544-6c6b6516d042)

El link al despliegue que se uso fue 
```
http://ec2-3-81-62-164.compute-1.amazonaws.com:8080/
```
## Diseño
![Untitled](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/3fc83c5f-98b7-48fa-ad6a-453908562bf2)

El diseño utilzado es el siguiente:
1. Se tiene una clase que controla las solicitudes realizadas por el usuario mediante servicios REST de http (`Parcial1Controller`). Esta clase tiene memoria que permite identificar si la consulta se ha realizado antes, en caso de que se haya realizado con anterioridad llama a la respuesta que tiene guardada, si no ocurre este caso realiza el proceso para conectarse con el servicio externo.
2. Existe una clase que se conecta con la API externa y contiene la logica de la aplicación(`Parcial1Service`). Esta clase extiende una interfaz que permite que se creen diferentes instancias que permitan implementar diferentes API´s.
3. EL cliente web es el encargado de realizar la solicitud de los valores que desea consultar, en este caso estan disponibles las siguientes opciones:
    - **Tipo de valoracion**: Intraday. Daily, Weekly y Monthly
    - **Nombre de la empresa**: En este caso solo es funcinal `IBM` y `MSFT`
    - **Intervalo**: En caso de que el tipo de valoracion sea `Intraday`se debe elegir una opcion de intervalo (solo son funcionales 1min y 5min) en caso de elegir otro tipo de valoración es necesario dejarla en su valor por defecto `N/A`
4. La interfaz se encarga de que en caso de que se necesite utilizar otra API, la aplicación sea extendible.

## Test
Se realiza una prueba de concurrencia al servidor, donde se ejecutan 20 hilos y se recibe la respuesta de ada uno de ellos.

![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/d1846db3-3833-4ccd-b25c-201802b187a7)

## Patrones
Este proyecto usa inyeccion de dependencias e inversion de control mediante la etiquete en `@Autowired` en el controlador del servicio.

![image](https://github.com/alexandrac1420/Parcial1_ARSW/assets/138069735/c91513be-16b9-47fa-a981-8ae38771305a)


## Nuevas funcionalidades
En caso de que se necesite implementar otra API, se puede genera otra clase que implente esta interfaz y se genera la nueva implementación.




