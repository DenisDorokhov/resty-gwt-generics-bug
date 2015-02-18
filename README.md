# resty-gwt-generics-bug

This project is created to demonstrate RestyGWT bug of failed compilation. This happens when response type declaration contains nested generic types.

```java
public interface RestyGwtService extends RestService {

	@POST
	@Path("/test.json")
	Request test(MethodCallback<ResponseDto<List<EntityDto>>> aCallback);

}

public class ResponseDto<T> {

	private boolean successful;

	private T data;

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean aSuccessful) {
		successful = aSuccessful;
	}

	public T getData() {
		return data;
	}

	public void setData(T aData) {
		data = aData;
	}

}

public class EntityDto {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long aId) {
		id = aId;
	}

}
```

The following error is shown after compilation:

```
Compiling module net.dorokhov.restygwt.RestyGwt
   Adding '3' new generated units
      Validating units:
         Errors in '/var/folders/h5/pq33x5b153g8g0b409bw42th0000gn/T/gwt-codeserver-7116306132178635550.tmp/net.dorokhov.restygwt.RestyGwt/compile-3/gen/net/dorokhov/restygwt/client/ResponseDto__java_util_List<net_dorokhov_restygwt_client_EntityDto>_Generated_JsonEncoderDecoder_.java'
            See snapshot: /var/folders/h5/pq33x5b153g8g0b409bw42th0000gn/T/net.dorokhov.restygwt.client.ResponseDto__java_util_List<net_dorokhov_restygwt_client_EntityDto>_Generated_JsonEncoderDecoder_3552918312874047953.java
         Errors in '/var/folders/h5/pq33x5b153g8g0b409bw42th0000gn/T/gwt-codeserver-7116306132178635550.tmp/net.dorokhov.restygwt.RestyGwt/compile-3/gen/net/dorokhov/restygwt/client/RestyGwtService_Generated_RestServiceProxy_.java'
            See snapshot: /var/folders/h5/pq33x5b153g8g0b409bw42th0000gn/T/net.dorokhov.restygwt.client.RestyGwtService_Generated_RestServiceProxy_6731985308319824370.java
         Ignored 2 units with compilation errors in first pass.
Compile with -strict or with -logLevel set to TRACE or DEBUG to see all errors.
   [ERROR] Errors in '/var/folders/h5/pq33x5b153g8g0b409bw42th0000gn/T/gwt-codeserver-7116306132178635550.tmp/net.dorokhov.restygwt.RestyGwt/compile-3/gen/net/dorokhov/restygwt/client/RestyGwtService_Generated_RestServiceProxy_.java'
      [ERROR] Line 36: net.dorokhov.restygwt.client.ResponseDto__java_util_List cannot be resolved to a variable
      [ERROR] Line 36: net_dorokhov_restygwt_client_EntityDto cannot be resolved to a variable
      [ERROR] Line 36: _Generated_JsonEncoderDecoder_ cannot be resolved
      See snapshot: /var/folders/h5/pq33x5b153g8g0b409bw42th0000gn/T/net.dorokhov.restygwt.client.RestyGwtService_Generated_RestServiceProxy_6139606325219816979.java
   [ERROR] Errors in 'net/dorokhov/restygwt/client/RestyGwt.java'
      [ERROR] Line 10: Rebind result 'net.dorokhov.restygwt.client.RestyGwtService_Generated_RestServiceProxy_' could not be found
[ERROR] Compiler returned false
```

At the same time, the following code will work without any problems (only one generic is used in response type):

```java
public interface RestyGwtService extends RestService {

	@POST
	@Path("/test.json")
	Request test(MethodCallback<ResponseDto<EntityDto>> aCallback);

}
```