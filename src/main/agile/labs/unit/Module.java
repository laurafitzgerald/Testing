package agile.labs.unit;

import java.util.List;
import java.util.Vector;

public class Module {

	public static final int wksPerSemester = 12 ;  
    private String name ;
    private int noLectures ;  // no. lectures per week
    private int credits;
    private List<Topic> topics = new Vector<Topic>();

public Module(String name, int noLectures, int credits) {
     this.name = name;
     this.noLectures = noLectures;
     this.credits = credits;
}

 public boolean addTopic (Topic t) {
      boolean result = false ;
      if ( (computeTopicTotal() + t.getNoLectures()) 
                <= this.noLectures * wksPerSemester ) {
          topics.add(t);
          result = true;
      }
      return result ;
  }

 public Topic findTopic (String name) {
      Topic result = null ;
      for (Topic t : topics) {
             if (t.getName().equalsIgnoreCase(name)) {
                 result = t ;
                 break ;
             }
      }
      return result ;
 }

 private int computeTopicTotal() {
     int result = 0 ;
     for (Topic t : topics) {
         result += t.getNoLectures();
     }
     return result;
 }
	
}
