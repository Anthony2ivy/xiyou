/**
 * Created by Anthony on 2016/8/7.
 */
package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.StudentSession;

@RestController
@RequestMapping("/all")
public class HelloController {

    @Autowired
    private StudentSession studentSession;

    @RequestMapping("/helloworld")
    public String helloworld()
    {
        return "helloworld";
    }
    @RequestMapping(value="/findstudent/{studentid}")
    public Student findStudentById(@PathVariable int studentid)
    {
        return studentSession.findStudentById(studentid);
    }
}
