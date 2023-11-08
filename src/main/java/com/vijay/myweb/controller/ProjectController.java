import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository; // Assuming you have a StudentRepository

    @GetMapping("/student-form")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form"; // This should match the name of your HTML file
    }

    @PostMapping("/submit-student")
    public String submitStudent(@ModelAttribute Student student) {
        // Save the student data to the database using the repository
        studentRepository.save(student);

        return "redirect:/success"; // Redirect to a success page
    }
}