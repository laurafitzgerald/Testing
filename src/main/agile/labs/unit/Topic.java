package agile.labs.unit;

public class Topic {
	
	private int noLectures ;
    private String name ;

    public Topic(int noLectures, String name) {
        this.noLectures = noLectures;
        this.name = name;
    }

    public int getNoLectures() {
        return noLectures;
    }

    public String getName() {
        return name;
    }

}
