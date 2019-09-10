import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void testParse(){
         Parser parser = new Parser();
         Command cmd = null;
         try {
             cmd = parser.parse("todo testTodo");
         } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
             e.printStackTrace();
         }
         assertTrue(cmd instanceof TodoCommand, "command must be a TodoCommand");
         try {
             cmd = parser.parse("deadline testDeadline /by 01/01/2019 0520");
         } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
             e.printStackTrace();
         }
         assertTrue(cmd instanceof DeadlineCommand, "command must be a DeadlineCommand");
         try {
             cmd = parser.parse("event testEvent /at 01/01/2019 0520 - 02/01/2019 2030");
         } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
             e.printStackTrace();
         }
         assertTrue(cmd instanceof EventCommand, "command must be a EventCommand");
        try {
            cmd = parser.parse("event testEvent /at 01/01/2019 0520 - 02/01/2019 2030");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            e.printStackTrace();
        }
        assertTrue(cmd instanceof EventCommand, "command must be a EventCommand");
        try {
            cmd = parser.parse("list");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            e.printStackTrace();
        }
        assertTrue(cmd instanceof ListCommand, "command must be a ListCommand");
        try {
            cmd = parser.parse("bye");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            e.printStackTrace();
        }
        assertTrue(cmd instanceof ExitCommand, "command must be a ExitCommand");
        try {
            cmd = parser.parse("delete 1");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            e.printStackTrace();
        }
        assertTrue(cmd instanceof DeleteCommand, "command must be a DeleteCommand");
        try {
            cmd = parser.parse("done 1");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            e.printStackTrace();
        }
        assertTrue(cmd instanceof DoneCommand, "command must be a DoneCommand");
        try {
            cmd = parser.parse("find haaaa");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            e.printStackTrace();
        }
        assertTrue(cmd instanceof FindCommand, "command must be a FindCommand");
    }
    @Test
    public void testParseNoDescriptionException(){
        Parser parser = new Parser();
        try{
            parser.parse("todo");
            fail("should throw exception when there are no description");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("description"));
        }

        try{
            parser.parse("event");
            fail("should throw exception when there are no description");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("description"));
        }

        try{
            parser.parse("deadline");
            fail("should throw exception when there are no description");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("description"));
        }
        try{
            parser.parse("deadline /by 21/02/02 2030");
            fail("should throw exception when there are no description");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("description"));
        }

        try{
            parser.parse("event /at 01/01/2019 0520 - 02/01/2019 2030 ");
            fail("should throw exception when there are no description");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("description"));
        }
    }
    @Test
    public void testParseNoCommandException(){
        Parser parser = new Parser();
        try{
            parser.parse("blablabla");
            fail("should throw exception when there are no task");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("means"));
        }
        try{
            parser.parse("");
            fail("should throw exception when there are no command");
        } catch (NoCommandException | NoDescriptionException | NoKeywordException | NoDateException | NoNumberTaskException e) {
            assertTrue(e.getMessage().contains("means"));
        }
    }

    @Test
    public void testParseNoKeywordException(){
        Parser parser = new Parser();
        try {
            parser.parse("find");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("keyword"));
        }
    }

    @Test
    public void testParseNoNumberTaskException(){
        Parser parser = new Parser();
        try {
            parser.parse("delete");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("number"));
        }
        try {
            parser.parse("done");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("number"));
        }
    }

    @Test
    public void testNoDateException(){
        Parser parser = new Parser();
        try {
            parser.parse("event testEvent");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("date"));
        }
        try {
            parser.parse("event testEvent /at");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("date"));
        }
        try {
            parser.parse("event testEvent /at 21/02/1998 2030");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("date"));
        }
        try {
            parser.parse("event testEvent");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("date"));
        }
        try {
            parser.parse("deadline testDeadline /by");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("date"));
        }
        try {
            parser.parse("deadline testDeadline ");
        } catch (NoNumberTaskException | NoCommandException | NoKeywordException | NoDescriptionException | NoDateException e) {
            assertTrue(e.getMessage().contains("date"));
        }
    }
}
