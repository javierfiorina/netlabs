package main.java.gdc;

public class ResponseCustom {
	private String text;
	private int errcode;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public ResponseCustom(String text, int errcode) {
		this.text = text;
		this.errcode = errcode;
	} 

}
