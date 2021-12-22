## PRÁCTICA 1 :woman_technologist:
* **FUNCIONALIDAD ELEGIDA** <br/>

En mi caso, he decidio hacer la funcionalidad de "número par". <br/>
En la página principal de dicha funcionalidad aparecerá mi nombre y apellido y abajo se mostrará un pequeño formulario para teclear un número. Si el usuario por lo que fuera
teclea un número negativo, un cero o incluso un caracter cualquiera, saldrá por pantalla un mensaje de error. Por lo que, el usuario deberá teclear un número que sea correcto, 
una vez que lo haga seleccionará el botón de enviar y saldrá por pantalla si el número tecleado es par o impar. <br/>

* **CÓDIGO AÑADIDO** <br/>

:one: En primer lugar, he añadido en el `pom.xml` la siguiente dependencia para tener en cuenta las validaciones del formulario: 
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

:two: Luego he añadido la clase `/src/main/java/demoapp/NumberForm.java` ya que esta es necesaria para poder crear un número. Dicha clase solo contiene el atributo del número, un getter,
un setter y un toString. <br/>

:three: También he creado el servicio `/src/main/java/demoapp/service/NumberService.java` que contiene la lógica de negocio de la aplicación. Dicha clase tendrá un método para comprobar
si el número que se le pasa por parámetro es mayor que 0, para poder comprobar si es par o impar. Según lo que se teclee, saldrá un mensaje u otro.
```
public String number(Integer num) {
   if (num > 0) {
       if (num % 2 == 0) {
           return "El numero " + num + " es par";
       } else {
           return "El numero " + num + " no es par";
       }
    } else {
       return "Tiene que ser un número mayor que 0";
    }
}
```

:four: Luego está la clase del controlador `/src/main/java/demoapp/controller/NumberController.java` que ejecutará el código de la respuesta HTTP. En dicha clase habrá
un método que llamará al método de la capa de servicio.
```
@RequestMapping("/number/{num}")
public @ResponseBody String number(@PathVariable(value="num") Integer num) {
   return service.number(num);
}
```

:five: Además, tendremos un controlador para mostrar plantillas `/src/main/java/demoapp/controller/NumberPlantillaController.java`.</br>
El primer método sirve para agregar un controlador de vista para la URL dada.
```
@Override
public void addViewControllers(ViewControllerRegistry registry) {
   registry.addViewController("/results1").setViewName("results1");
   registry.addViewController("/results").setViewName("results");
}
```
El método GET nos mostrará por pantalla el formulario cuando tecleemos la URL.
```
@GetMapping("/numberplantilla")
public String showForm(NumberForm numberForm) {
   return "form";
}
```
El método POST si ve que en el formulario hay algún error (que sea nulo, 0, otro carácter o negativo) lo mostrará por pantalla en el mismo formulario. Sin embargo, si todo va bien, mirará que dependiendo del número que teclee mostrará una vista u otra, pasando los datos a la vista.
```
@PostMapping("/")
public String checkInfo(@Valid NumberForm numberForm, BindingResult bindingResult, Model model) {
   if (bindingResult.hasErrors()) {
       return "form";
   }

   if (numberForm.getNum() % 2 == 0 ) {
       model.addAttribute("mensaje1", numberForm.getNum());
       return "results1";
    } else {
       model.addAttribute("mensaje2", numberForm.getNum());
       return "results";
    }
}
```

:six: Finalmente, he añadido las plantillas de `/src/main/resources/templates/form.html`, `/src/main/resources/templates/results1.html`,`/src/main/resources/templates/results.html`. El primero para poder imprimir el formulario con mis datos y para que el usuario
pueda teclear un número con un botón; el segundo para que imprima por pantalla que el número tecleado es par; el tercero para que imprima por pantalla que el número tecleado 
es impar.

* **URL** <br/>

**PARA SERVICIOS**:
- [http://localhost:8080/number/0](http://localhost:8080/number/0)
- [http://localhost:8080/number/2](http://localhost:8080/number/2)
- [http://localhost:8080/number/3](http://localhost:8080/number/3)

**PARA PLANTILLA**:
- [http://localhost:8080/numberplantilla](http://localhost:8080/numberplantilla)

**DOCKER**:
- [https://hub.docker.com/r/ys37/spring-boot-demoapp](https://hub.docker.com/r/ys37/spring-boot-demoapp)
