1. 
- He creado el proyecto: https://github.com/ys37/dca-practicat10
- Para configurar push en local: git remote add origin https://github.com/ys37/dca-practicat10.git
- Para configurar pull en local: git pull https://github.com/ys37/dca-practicat10.git main

2. 
Alias en local:
* git config alias.stat status
* git config alias.com commit
* git config alias.ch checkout
* git config alias.ps push
* git config alias.pl pull

Alias en global:
* git config --global alias.stat status
* git config --global alias.com commit
* git config --global alias.ch checkout
* git config --global alias.ps push
* git config --global alias.pl pull

3. 
- Provocamos un fallo en el archivo: ~/dca-practicat10/proyecto/src/main/resources/templates/saludo.html
- Añadimos 3 archivos nuevos
- Ejecutamos lo siguiente:
* git log --oneline
* git bisect start
* git bisect bad --> commit donde estoy
* git bisect good a6aae4a --> commit donde todo iba bien
* Aparecen diferentes archivos y ponemos: git bisect bad o git bisect good
* Cuando encontremos el fallo: git bisect reset
* git show f1cd1eba904f3d9e6b8e667fce194c51d7c4c2af --> vemos commit que falla
- Arreglamos el error

4. 
