package net.dorokhov.restygwt.client;

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
