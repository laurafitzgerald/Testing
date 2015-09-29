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
    
}
	

