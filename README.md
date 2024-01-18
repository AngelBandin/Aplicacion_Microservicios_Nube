2 micro servicios que interactuan ente si para simular la compra de acciones.

Compra se encarga de recibir solicitudes json con los atributos de la solicitud

Un ejemplo para insertar una accion presente en la base de datos es:

curl -X POST -H "Content-Type: application/json" -d '{ 
  "fecha": "2010-01-04",
  "simbolo": "A",
  "volumen": 100,
  "unidad": 2.2,
  "total": 220.0,
  "metodoPago": "Tarjeta de credito",
  "numeroTarjeta": "1235-2345-4567-0977"
}' http://localhost:8081/compras

Para iniciar base de datos, tener docker instalado y ejecutar el archivo start_bd.sh
