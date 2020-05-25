package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	@Bean("itemFactura")
	public List<ItemFactura> registrarItems(){
		 Producto p1 = new Producto("Camara Sony", 100);
		 Producto p2 = new Producto("Bicicleta Bianchi", 200);
		 
		 ItemFactura linea1 = new ItemFactura(p1, 2);
		 ItemFactura linea2 = new ItemFactura(p2, 4);

		 return Arrays.asList(linea1, linea2);
	}
}