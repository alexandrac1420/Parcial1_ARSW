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

El diseño utilzado es el siguiente:
1. Se tiene una clase que controla las solicitudes realizadas por el usuario mediante servicios REST de http (Parcial1Controller)
2. Existe una clase que se conecta con la API externa y contiene la logica de la aplicación(Parcial1Service)
3. EL cliente web es el encargado de realizar la solicitud de los valores que desea consultar, en este caso estan disponibles las siguientes opciones:
    - Tipo de valoracion: Intraday. Daily, Weekly y Monthly
    - Nombre de la empresa: En este caso solo es funcinal ´IBM´ y ´MSFT´
    - Intervalo: En caso de que el tipo de valoracion sea ´Intraday´ se debe elegir una opcion de intervalo (solo son funcionales 1min y 5min) en caso de elegir otro tipo de valoración es necesario dejarla en su valor por defecto ´N/A

4. 


