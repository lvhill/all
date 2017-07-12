package cn.sky.framework.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8151382366190260685L;

	public BusinessException() {
		super();
	}

	public BusinessException(String msg) {
		super(msg);
	}

}
