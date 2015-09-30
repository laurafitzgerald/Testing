package agile.labs.unit;
import junit.framework.TestCase;


public class TestModule extends TestCase{

	Module module;
    Topic topic1;
    Topic topic2;
    Topic topic3;

    public void setUp() throws Exception {
        module = new Module("Module 1", 2, 5) ;
        topic1 = new Topic(4,"topic 1") ;
        topic2 = new Topic(7,"topic 2") ;
        topic3 = new Topic(5,"topic 3") ;
    }
    public void tearDown() throws Exception {
        module = null ;
        topic1 = topic2 = topic3 = null ;
    }

    public void testaddTopic() {
        // Normal case
        module.addTopic(topic1) ; 
        Boolean result = module.addTopic(topic2) ;
        assertTrue("Normal add topic result incorrect ",result);
        Topic topic = module.findTopic("topic 1");
        assertSame("Module state - Valid (1st) topic not present ",topic1, topic);
        topic = module.findTopic("topic 2");
        assertSame("Module state - Valid (2nd) topic not present ",topic2, topic);
        // Boundary case
        Topic topic4 = new Topic(13,"topic 4") ;
        result = module.addTopic(topic4) ;
        assertTrue("No. lectures limit - incorrect result ",result);
        topic = module.findTopic("topic 4");
        assertSame("No lectures limit - incorrect topic list ",topic4, topic);
        // Error case
        result = module.addTopic(topic3) ;
        assertFalse("No lectures exceeded ",result);
        topic = module.findTopic("topic 3");
        assertNull("No lectures exceeded - Topic incorrectly added ",topic);
    }
    
    public void testfindTopic() {
        // Boundary case
        Topic result = module.findTopic("topic 1");
        assertNull("Empty module returning something ",result) ;
        // Normal cases
        module.addTopic(topic1) ;
        module.addTopic(topic2) ;
        module.addTopic(topic3) ;
        result  = module.findTopic("topic 2");
        assertSame("Valid Topic not found ",topic2,result) ;
        result = module.findTopic("topic 4");
        assertNull("Invalid topic found incorrectly",result) ;
    }
    
    
    public void testchangeTopic() {
        // Normal cases
        module.addTopic(topic1) ;
        module.addTopic(topic2) ; 
        module.addTopic(topic3) ; 
        Topic changes = new Topic(8,"topic 4");
        Topic result = module.changeTopic("topic 2", changes);
        assertEquals("Change topic - wrong name",changes.getName(),result.getName());
        assertEquals("Change topic - wrong no. lectures",changes.getNoLectures() ,
                                                         result.getNoLectures());
        Topic findResult = module.findTopic( changes.getName()); 
        assertSame("Change topic - not added to topic list",result,findResult);
        
        changes = new Topic(0,"topic 5");
        result = module.changeTopic("topic 4", changes);
        assertEquals("Change topic name only - wrong name",changes.getName(),result.getName());
        assertEquals("Change topic name only - wrong no. lectures", 8, result.getNoLectures());
        findResult = module.findTopic( changes.getName()); 
        assertSame("Change topic name only - not added to topic list",result,findResult);
    }
    
    public void testmergeTopic(){
    	
    	Topic result;
    	module.addTopic(topic1);
    	module.addTopic(topic2);
    	module.addTopic(topic3);
    	
    	// test return null if first topic is not found
    	result = module.mergeTopic("topic name that does not exists", topic1.getName(), "New Topic Name");
    	assertNull("First Topic of Merge not founde", result);
    	
    	//test return null if second topic is not found
    	result = module.mergeTopic(topic1.getName(), "topic name that does not exist", "New Topic Name");
    	assertNull("Second Topic of MErge not found", result);
    	
    	//test return topic when topic is merged
    	result = module.mergeTopic(topic1.getName(), topic2.getName(), "New Topic Name");
    	result = module.findTopic("New Topic Name");
    	assertNotNull("Merged Topic Found", result);
    	
    	//test that topics have been removed
    	assertNull(module.findTopic(topic1.getName()));
    	assertNull(module.findTopic(topic2.getName()));
    	
    	
    	//test search for merged topic after merge
    	
    	
    	
    }
    
    public void testremoveTopic(){
    	
    	module.addTopic(topic1);
    	module.addTopic(topic2);
    	
    	//test that a null value is returned when topicName is not currently in the list
    	Topic result = module.removeTopic("topic name");
    	assertNull("Topic cannot be found", result);
    	
    	//test that the topic is removed 
    	module.removeTopic(topic2.getName());
    	result = module.findTopic(topic2.getName());
    	assertNull("Topic cannot be found after removal", result);
    	
    	
    	//test that a topic is returned correctly after removal
    	result = module.removeTopic(topic1.getName());
    	assertEquals(topic1, result);
    	
    	
    }
    
}
	

