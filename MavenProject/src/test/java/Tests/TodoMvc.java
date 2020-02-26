package Tests;

import java.util.List;

public interface TodoMvc {
	
	  void navigateTo();
	  void createTodo(String todoName);
	  boolean todoExists(String todoName);
	  List<String> getTodos();
	  void removeTodo(String todoName);
	  void completeTodo(String todoName);
	  void renameTodo(String todoName, String newTodoName);
	  void showCompleted();	 
}
