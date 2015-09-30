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
 
 public Topic changeTopic(String name, Topic changes) {
     Topic currentTopic = findTopic(name); 
     Topic newTopic = new Topic(changes.getNoLectures(), changes.getName());
     removeTopic(currentTopic.getName() );
     addTopic(newTopic) ;
     return newTopic;
 }

 public Topic mergeTopic(String oldTopic1Name, String oldTopic2Name, String mergedTopicName){
	 
	 for (Topic t1: topics){
		 if(t1.getName().equals(oldTopic1Name)){
			 
			 for(Topic t2: topics){
				 
				 if(t2.getName().equals(oldTopic2Name)){
					 
					 Topic newTopic = new Topic(t1.getNoLectures()+t2.getNoLectures(), mergedTopicName);
					 topics.add(newTopic);
					 topics.remove(t1);
					 topics.remove(t2);
					 return newTopic;
					 
				 }
			 }
			 
			 return null;
			 
		 }
	 }
	 
	 
	 return null;
 }

 private int computeTopicTotal() {
     int result = 0 ;
     for (Topic t : topics) {
         result += t.getNoLectures();
     }
     return result;
 }
	
 public Topic removeTopic(String topicName){
	 
	 for (Topic t :topics){
		 
		 if(t.getName().equals(topicName)){
			 topics.remove(t);
			 return t;
		 }
		 
	 }
	 
	 return null;
 }
}
