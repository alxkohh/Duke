public class Parser {

    public static Command parse (String input) {
        String[] inputSplit = input.split(" ");
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new DisplayListCommand();
        } else if (inputSplit[0].equals("delete")) {
            int inputIndex = Integer.parseInt(inputSplit[1]);
            int actualIndex = inputIndex - 1;
            DeleteCommand delete = new DeleteCommand();
            delete.setIndexToRemove(actualIndex);
            return delete;
        } else if (inputSplit[0].equals("done")) {
            int inputIndex = Integer.parseInt(inputSplit[1]);
            int actualIndex = inputIndex - 1;
            DoneCommand done = new DoneCommand();
            done.setIndexToMarkDone(actualIndex);
            return done;
        } else if (inputSplit[0].equals("todo")) {
            AddTodoCommand addTodo = new AddTodoCommand();
            addTodo.setInputTodo(input);
            return addTodo;
        } else if (inputSplit[0].equals("event")) {
            AddEventCommand addEvent = new AddEventCommand();
            addEvent.setInputEvent(input);
            return addEvent;
        } else if (inputSplit[0].equals("deadline")) {
            AddDeadlineCommand addDeadline = new AddDeadlineCommand();
            addDeadline.setInputDeadline(input);
            return addDeadline;
        } else {
            return new UnrecognisedInputCommand();
        }
    }
}