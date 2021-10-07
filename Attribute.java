public class Attribute {
    private String name;
    private Class type;

    public Attribute(String name, Class type) {
        this.name = name;
        if(type.equals(String.class) | type.equals(Integer.class)) {
        	this.type = type;
        }
    }
    
    public String getName() {
    	return name;
    }
    
    public Class getType() {
    	return this.type;
    }
    
    public String toString() {
    	return String.format("Attribute %s <{%s}>", this.name, this.type.toString());
    }
    
}