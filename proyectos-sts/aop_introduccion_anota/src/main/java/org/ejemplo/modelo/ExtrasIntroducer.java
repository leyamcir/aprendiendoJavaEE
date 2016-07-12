package org.ejemplo.modelo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ExtrasIntroducer {

	@DeclareParents(value="org.ejemplo.modelo.IVehiculo+",
					defaultImpl = Extras.class)
	public static IExtras extras;
					
}
