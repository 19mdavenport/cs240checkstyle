package edu.byu.cs240.checkstyle.readability;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import edu.byu.cs240.checkstyle.CheckTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;


class CommentedCodeTest extends CheckTest {

    @Override
    protected Set<Class<?>> getCheckClasses() {
        return Set.of(CommentedCode.class);
    }


    @Override
    protected boolean isTreeWalkerDependent(Class<?> clazz) {
        return true;
    }


    @Override
    protected Map<String, String> getCheckProperties(Class<?> clazz) {
        return Map.of("min", "3");
    }


    @Test
    @DisplayName("Should find no errors in code that has no comments")
    public void should_FindNoErrors_when_NoComments() throws CheckstyleException {
        String fileName = "testInputs/commentedCode/should_FindNoErrors_when_NoComments.java";
        testFiles(0, fileName);
    }


    @Test
    @DisplayName("Should find no errors in code that has non-code comments")
    public void should_FindNoErrors_when_OtherComments() throws CheckstyleException {
        String fileName = "testInputs/commentedCode/should_FindNoErrors_when_OtherComments.java";
        testFiles(0, fileName);
    }


    @Test
    @DisplayName("Should find no errors in code that has '/*' in a text block")
    public void should_FindNoErrors_when_TextBlock() throws CheckstyleException {
        String fileName = "testInputs/commentedCode/should_FindNoErrors_when_TextBlock.java";
        testFiles(0, fileName);
    }


    @Test
    @DisplayName("Should find no errors in code that has '/*' or related character sequences in a string")
    public void should_FindNoErrors_when_commentInString() throws CheckstyleException {
        String fileName = "testInputs/commentedCode/should_FindNoErrors_when_commentInString.java";
        testFiles(0, fileName);
    }


    @Test
    @DisplayName("Should find errors in code that has code comments")
    public void should_FindErrors_when_CodeComments() throws CheckstyleException {
        String fileName = "testInputs/commentedCode/should_FindErrors_when_CodeComments.java";
        testFiles(2, fileName);
    }


    @Test
    @DisplayName("Should find errors in code that has block code comments")
    public void should_FindErrors_when_BlockCodeComments() throws CheckstyleException {
        String fileName = "testInputs/commentedCode/should_FindErrors_when_BlockCodeComments.java";
        testFiles(1, fileName);
    }

}
