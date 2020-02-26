package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.interactions.Actions;


public class TodoMvcPage implements TodoMvc  {

	 private final WebDriver driver;
	 
	 @FindBy(css = ".todo-list li")
	    private List<WebElement> todos;
		
	 @FindBy(css = "a[href='#/completed']")
	    private WebElement showCompleted;


	
	 public TodoMvcPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
		
		public void navigateTo() {
			
			driver.get("http://todomvc.com/examples/angularjs/#/");
			driver.manage().window().maximize();
			
		}

		
		public void createTodo(String todoName) {
			
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS); 
			driver.findElement(By.className("new-todo")).sendKeys(todoName + Keys.ENTER);
			
		}

		
		public boolean todoExists(String todoName) {
			
			  return getTodos().stream().anyMatch(todoName::equals);
		}

		
		public List<String> getTodos() {
			
			 return todos
		                .stream()
		                .map(WebElement::getText)
		                .collect(Collectors.toList());
		}
			

		public void removeTodo(String todoName) {

			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); 
			WebElement todoToRemove = getTodoElementByName(todoName);
	        moveToElement(todoToRemove);
	        click(By.cssSelector("button.destroy"),todoToRemove);
			
		}
		
		 public int getTodoCount() {
		        return todos.size();
		    }
		
		private WebElement getTodoElementByName(String todoName) {
		        return todos
		                .stream()
		                .filter(el -> todoName.equals(el.getText()))
		                .findFirst()
		                .orElseThrow(() -> new RuntimeException("Todo with name " + todoName + " not found!"));
		  }
		 
		private void moveToElement(WebElement element) {
		        new Actions(driver).moveToElement(element).perform();
		  }
		

		  private void click(By by, SearchContext searchContext) {
		        WebElement element = searchContext.findElement(by);
		        element.click();
		    }


	
		public void completeTodo(String todoName) {
			 WebElement todoToComplete = getTodoElementByName(todoName);
		        click(By.cssSelector("input.toggle"), todoToComplete);     
			
		}


	
		public void renameTodo(String todoName, String newTodoName) {
			
			  WebElement todoToEdit = getTodoElementByName(todoName);
		        doubleClick(todoToEdit);
		        
		        WebElement todoEditInput = find(By.cssSelector("input.edit"), todoToEdit);
		        executeScript("arguments[0].value = ''", todoEditInput);

		        todoEditInput.sendKeys(newTodoName + Keys.ENTER);
			
			
		}
		
		  private void doubleClick(WebElement element) {
		        new Actions(driver).doubleClick(element).perform();
		    }
		  
		  private WebElement find(By by, SearchContext searchContext) {
		        return searchContext.findElement(by);
		    }
		  
		  private void executeScript(String script, Object... arguments) {
		        ((JavascriptExecutor) driver).executeScript(script, arguments);
		    }
     
		  
		   public void showCompleted() {
		        showCompleted.click();
		    }
				

		  
}
