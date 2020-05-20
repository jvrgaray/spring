package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("miServicioSimple")
@Primary
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "hola";
	}

}
