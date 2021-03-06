package name.webdizz.sonar.grammar.sensor;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Mockito.*;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.issue.Issuable;
import org.sonar.api.issue.Issue;
import org.sonar.api.rule.RuleKey;


/**
 * Unit test for GrammarIssuesWrapper
 */
public class GrammarIssuesWrapperTest {
    
    private final InputFile inputFile = mock(InputFile.class);
    
    private final ResourcePerspectives perspectives = mock(ResourcePerspectives.class);
    
    private final RuleKey ruleKey = mock(RuleKey.class);
    
    private final GrammarIssuesWrapper wrapper = GrammarIssuesWrapper.builder()
            .setInputFile(inputFile)
            .setLine("Test line")
            .setLineNumber(1)
            .setPerspectives(perspectives)
            .setRuleKey(ruleKey)
            .build();
    
    public GrammarIssuesWrapperTest() {
        
    }

    /**
     * Test of getLine method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testGetLine() {
        System.out.println("Testing getLine");
        String expResult = "ABCDEF";
        GrammarIssuesWrapper instance = 
                GrammarIssuesWrapper.builder(wrapper).setLine(expResult).build();
        String result = instance.getLine();
        assertEquals(expResult, result);
        System.out.println("Done.");
    }

    /**
     * Test of getLineNumber method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testGetLineNumber() {
        System.out.println("Testing getLineNumber");
        int expResult = 100;
        GrammarIssuesWrapper instance = 
                GrammarIssuesWrapper.builder(wrapper).setLineNumber(expResult).build();
        int result = instance.getLineNumber();
        assertEquals(expResult, result);
        System.out.println("Done.");
    }

    /**
     * Test of incident method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testIncident_String_int() {
        System.out.println("Test incident (String, int)");
        String message = "ABCD";
        int column = 10;
        ResourcePerspectives mockPerspectives = mock(ResourcePerspectives.class);
        Issuable issuable = mock(Issuable.class);
        Issuable.IssueBuilder builder = mock(Issuable.IssueBuilder.class);
        Issue issue = mock(Issue.class);
        
        when(issuable.newIssueBuilder()).thenReturn(builder);
        when(builder.attribute(anyString(), anyString())).thenReturn(builder);
        when(builder.effortToFix(anyDouble())).thenReturn(builder);
        when(builder.line(wrapper.getLineNumber())).thenReturn(builder);
        when(builder.message(message)).thenReturn(builder);
        when(builder.reporter(anyString())).thenReturn(builder);
        when(builder.ruleKey(ruleKey)).thenReturn(builder);
        when(builder.severity(anyString())).thenReturn(builder);
        when(builder.build()).thenReturn(issue);
        when(mockPerspectives.as(Issuable.class, inputFile)).thenReturn(issuable);
        GrammarIssuesWrapper instance = 
                GrammarIssuesWrapper.builder(wrapper)
                        .setPerspectives(mockPerspectives)
                        .build();
        instance.incident(message, column);
        
        // check behavior
        verify(mockPerspectives).as(Issuable.class, inputFile);
        verify(builder).build();
        verify(builder).ruleKey(ruleKey);
        verify(builder).message(message);
        verify(builder).attribute(org.mockito.Matchers.anyString(), eq(Integer.toString(column)));
        verify(issuable).addIssue(issue);
        
        System.out.println("Done.");
    }

    /**
     * Test of incident method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testIncident_String() {
        System.out.println("Test incident (String)");
        String message = "ABCD";
        ResourcePerspectives mockPerspectives = mock(ResourcePerspectives.class);
        Issuable issuable = mock(Issuable.class);
        Issuable.IssueBuilder builder = mock(Issuable.IssueBuilder.class);
        Issue issue = mock(Issue.class);
        
        when(issuable.newIssueBuilder()).thenReturn(builder);
        when(builder.attribute(anyString(), anyString())).thenReturn(builder);
        when(builder.effortToFix(anyDouble())).thenReturn(builder);
        when(builder.line(wrapper.getLineNumber())).thenReturn(builder);
        when(builder.message(message)).thenReturn(builder);
        when(builder.reporter(anyString())).thenReturn(builder);
        when(builder.ruleKey(ruleKey)).thenReturn(builder);
        when(builder.severity(anyString())).thenReturn(builder);
        when(builder.build()).thenReturn(issue);
        when(mockPerspectives.as(Issuable.class, inputFile)).thenReturn(issuable);
        GrammarIssuesWrapper instance = 
                GrammarIssuesWrapper.builder(wrapper)
                        .setPerspectives(mockPerspectives)
                        .build();
        
        instance.incident(message);
        
        // check behavior
        verify(mockPerspectives).as(Issuable.class, inputFile);
        verify(builder).build();
        verify(builder).ruleKey(ruleKey);
        verify(builder).message(message);
        verify(issuable).addIssue(issue);
        
        System.out.println("Done.");
    }

    /**
     * Test of toString method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        GrammarIssuesWrapper instance = wrapper;
        when(ruleKey.toString()).thenReturn("ABCD");
        String expResult = "GrammarIssuesWrapper{line=\"Test line\", lineNumber=1, ruleKey=ABCD}";
        String result = instance.toString();
        assertEquals(expResult, result);
        System.out.println("Done.");
    }

    /**
     * Test of builder method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testBuilder_0args() {
        System.out.println("Empty builder");
        GrammarIssuesWrapper.Builder expResult = GrammarIssuesWrapper.builder();
        GrammarIssuesWrapper.Builder result = GrammarIssuesWrapper.builder();
        assertNotEquals(expResult, result);
        System.out.println("Done.");
    }

    /**
     * Test of builder method, of class GrammarIssuesWrapper.
     */
    @Test
    public void testBuilder_GrammarIssuesWrapper() {
        System.out.println("Copy wrapper builder");
        GrammarIssuesWrapper.Builder expResult = GrammarIssuesWrapper.builder(wrapper);
        GrammarIssuesWrapper.Builder result = GrammarIssuesWrapper.builder(wrapper);
        assertNotEquals(expResult, result);
        System.out.println("Done.");
    }
    
}
