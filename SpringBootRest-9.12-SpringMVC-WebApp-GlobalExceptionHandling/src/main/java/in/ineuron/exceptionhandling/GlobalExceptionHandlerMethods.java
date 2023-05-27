package in.ineuron.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {

	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(UserNotFoundException ex, Model model, HttpServletRequest request) {
		System.out.println("Exception handled successfully");

		System.out.println("requested URI is :" + request.getRequestURI());
		model.addAttribute("errorMessage", ex.getMessage());

		return "errorPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllExceptions(UserNotFoundException ex, Model model, HttpServletRequest request) {
		System.out.println("Exception handled successfully");

		System.out.println("requested URI is :" + request.getRequestURI());
		model.addAttribute("errorMessage", ex.getMessage());

		return "errorPage";
	}
}

/**
 * In this example, the Model object is used to add the errorMessage attribute
 * with the value of ex.getMessage(). This attribute can be accessed in the
 * errorPage.jsp to display the error message.
 * 
 * In your errorPage.jsp, you can retrieve the error message using Expression
 * Language (EL).
 */
