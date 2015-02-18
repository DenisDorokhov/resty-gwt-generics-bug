package net.dorokhov.restygwt.client;

import com.google.gwt.http.client.Request;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

public interface RestyGwtService extends RestService {

	@POST
	@Path("/test.json")
	Request test(MethodCallback<ResponseDto<List<EntityDto>>> aCallback);

}
