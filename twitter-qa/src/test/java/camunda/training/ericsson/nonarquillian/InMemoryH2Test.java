package camunda.training.ericsson.nonarquillian;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class InMemoryH2Test {

    @ClassRule
    @Rule
    public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

    private static final String PROCESS_DEFINITION_KEY = "twitter";



    static {
        LogFactory.useSlf4jLogging(); // MyBatis
    }
    //before unit test create engine
    @Before
    public void setup() {
        init(rule.getProcessEngine());
    }

    /**
     * Just tests if the process definition is deployable.
     */
    @Test
    @Deployment(resources = "twitter.bpmn")
    public void testParsingAndDeployment() {
        // nothing is done here, as we just want to check for exceptions during deployment
    }

//    @Test
//    @Deployment(resources = "twitter.bpmn")
//    public void testHappyPath() {
////	  ProcessInstance processInstance = processEngine().getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
////    Now: Drive the process by API and assert correct behavior by camunda-bpm-assert
//        Map<String,Object> variables = new HashMap<String, Object>();
//        variables.put("content", "Sharon");
//        ProcessInstance processInstance =  runtimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
//    //find the task we are at
//        List<Task> tasks = processEngine().getTaskService().createTaskQuery().taskAssignee("demo").list();
//    //assert we are at the task we expect
//        Task userTask = tasks.get(0);
//        assertEquals(userTask.getName(), "Review Tweet");
//    //complete the task
//        Map<String,Object> vars = new HashMap<String, Object>();
//        vars.put("approved", "true"); // approve tweet
//        processEngine().getTaskService().complete(userTask.getId(), vars);
//
//    // assert it completed
//        assertThat(processInstance).isEnded();
//    }

//    @Test
//    @Deployment(resources = "twitter.bpmn")
//    public void testHappyPathQuick() { // same as the above but easier and more readable
//        Map<String,Object> variables = new HashMap<String, Object>();
//        variables.put("content", "Sharon");
//        ProcessInstance processInstance =  runtimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
//
//        assertThat(processInstance).isWaitingAt("Task_0e5qc1f");
//        complete(task(), withVariables("approved", true));
//
//        // assert it completed
//        assertThat(processInstance).isEnded();
//    }

}
