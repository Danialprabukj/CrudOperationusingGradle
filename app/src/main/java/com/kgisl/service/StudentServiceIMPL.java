// package com.kgisl.service;


// import com.kgisl.model.Student;

// import java.util.ArrayList;
// import java.util.List;

// public class StudentServiceIMPL implements IStudentService {

//     public static List<Student> studentList = new ArrayList<>();

//     static {
//         studentList.add(new Student(1L, "Chuan", "chuan@gmail.com", "Ha Noi"));
//         studentList.add(new Student(2L, "Thu", "thu@gmail.com", "Yen Bai"));
//         studentList.add(new Student(3L, "Yen", "yen@gmail.com", "Ha Noi"));
//     }

//     @Override
//     public List<Student> findAll() {
//         return studentList;
//     }

//     @Override
//     public Student findById(Long id) {
//         for (int i = 0; i < studentList.size(); i++) {
//             if (studentList.get(i).getId() == id) {
//                 return studentList.get(i);
//             }
            
//         }
//         return null;
//     }

//     @Override
//     public void save(Student student) {
//         if (findById(student.getId()) != null) {
//             studentList.set(studentList.indexOf(student), student);
//         } else {
//             studentList.add(student);
//         }
//     }

//     @Override
//     public void deleteById(Long id) {
//         for (int i = 0; i < studentList.size(); i++) {
//             if (studentList.get(i).getId() == id) {
//                 studentList.remove(i);
//             }
//         }
//     }
// }
