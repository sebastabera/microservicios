package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);

	/**
	 * Si este metodo retorna true, ejecuta el metodo run,
	 * por tanto ejecuta el filtro
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * se resuelve la logica del filtro
	 */
	@Override
	public Object run() throws ZuulException {
		
		// Se obtiene el objeto contexto
		RequestContext ctx = RequestContext.getCurrentContext();
		// A traves del objeto contexto, obtenemos el requests
		HttpServletRequest request = ctx.getRequest();
		
		LOGGER.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		return null;
	}

	/**
	 * Aqui se define el tipo de filtro, se debe retornar el tipo de filtro asi:
	 * return "pre"
	 * return "post"
	 * return "route"
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
