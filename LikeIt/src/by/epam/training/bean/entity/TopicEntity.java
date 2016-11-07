package by.epam.training.bean.entity;

public class TopicEntity {

	private String header;
	private String context;
	
	public TopicEntity(String header, String context){
		this.header = header;
		this.context = context;
	}
	
	public void setHeader(String value){
		header = value;
	}
	
	public String getHeader(){
		return header;
	}
	
	public void setContext(String value){
		header = value;
	}
	
	public String getContext(){
		return context;
	}
}
