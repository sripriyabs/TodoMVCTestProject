package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ToDoMvcTests {
	
	public WebDriver driver;
	private TodoMvc todoMvc;
	
	public ToDoMvcTests()
	{
		  System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  this.todoMvc = PageFactory.initElements(driver, TodoMvcPage.class);
	      this.todoMvc.navigateTo();
	}
		
		
    @Test
    public void createTodoItem() {
    	
    	  String todoBuyMilk = "Buy Milk";
    	  this.todoMvc.createTodo(todoBuyMilk);
		  Assert.assertEquals(todoMvc.todoExists(todoBuyMilk), true); 
		  
		  String todoBuyBook = "Buy Book"; 
		  this.todoMvc.createTodo(todoBuyBook);
		  Assert.assertEquals(todoMvc.todoExists(todoBuyBook), true); 
		 		 		 	  
		  String todoBuyFuel = "Buy Fuel"; this.todoMvc.createTodo(todoBuyFuel);
		  Assert.assertEquals(todoMvc.todoExists(todoBuyFuel), true);
		  
		  driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS); 
					 		 
	  }
	 	   
	
	  @Test 
	  void removesTodoItem() {
	  
	  // arrange
	  String todoBuyFuel = "Buy Fuel";
	  
	  // act 
	  todoMvc.removeTodo(todoBuyFuel);
	  Assert.assertEquals(todoMvc.todoExists(todoBuyFuel),false);
	  
	  String todoBuyBook = "Buy Book"; 
	  todoMvc.removeTodo(todoBuyBook);
	  Assert.assertEquals(todoMvc.todoExists(todoBuyBook),false);
	  
	  
	  }
	 
  	
	  @Test 
	  void CompleteATodoItem() {
	  
	 	  String todoBuyPen = "Buy Pen"; this.todoMvc.createTodo(todoBuyPen);
	 	
	  	  todoMvc.completeTodo(todoBuyPen); 
	 	  
	  	  driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);
	  
	  }
	  
	  
	  @Test
	  void editsTodo() {
		  
		  driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS); 
		  
	        // arrange
		  String todoCleanTheRoom = "Clean the room"; 
		  this.todoMvc.createTodo(todoCleanTheRoom);
		  
		        
	        // act
		    String todoCleanTheGarage = "Clean the garage"; 
	        todoMvc.renameTodo(todoCleanTheRoom, todoCleanTheGarage);
	        
	        // assert
	        Assert.assertEquals(todoMvc.todoExists(todoCleanTheGarage), true);
	        driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS); 
	       	       
	    }
	    
	  @Test 
	  void showCompleted() {
	  
	  	  todoMvc.showCompleted();
	      //Assert.assertEquals(todoMvc.getTodoCount(), true);
	 	  
	  	  driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);
	  
	  }
	  
	 	  
	   
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}