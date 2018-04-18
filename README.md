# netlabs-devchallenge

Pasos:
1- correr el docker compose

GDC:
Servicios rest:
 - Modificar el umbral de una categoria : 
   	- url POST gdc/categoria
	- Body : 
		{
			"nombre": "Comestibles", #Nombre de categoria
			"umbral": 25 #Cantidad a cambiar
		}
	- ejemplo de respuesta:
		{
			"text": "OK",
			"errcode": 200
		}
- Ver compras:
	- url GET /gdc/compra
	- Body:
		{
			"fecha": "2018-04-17",
			"productoNombre": "Cheetos",
			"precio": 100	
		}
- Ingresar una compra
	- url POST /gdc/Compra
	- Body:
		{
			"productoNombre": "Cheetos",
			"cantidad": 6
		}
	- ejemplo de respuesta:
		{
			"text": "OK",
			"errcode": 200
		}
- Ver todos los productos
	- url GET gdc/productos
	- ejemplo de respuesta:
	[
		{
			"nombre": "Papas_Fritas",
			"precio": 30,
			"stock": 10,
			"categoriaNombre": "Comestibles"
		},
		{
			"nombre": "Cheetos",
			"precio": 50,
			"stock": 10,
			"categoriaNombre": "Comestibles"
		},
		{
			"nombre": "Doritos",
			"precio": 60,
			"stock": 10,
			"categoriaNombre": "Comestibles"
		}
	]
