package net.dorokhov.restygwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class RestyGwt implements EntryPoint {

	public void onModuleLoad() {

		RestyGwtService service = GWT.create(RestyGwtService.class);

		service.test(null);
	}

}
