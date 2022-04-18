//package com.example.hr_management_task.component;
//
//import com.example.hr_management_task.entity.Company;
//import com.example.hr_management_task.entity.Employee;
//import com.example.hr_management_task.entity.Role;
//import com.example.hr_management_task.repository.CompanyRepository;
//import com.example.hr_management_task.repository.EmployeeRepository;
//import com.example.hr_management_task.repository.RoleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class DataLoader implements CommandLineRunner {
//
//    final PasswordEncoder passwordEncoder;
//    final RoleRepository roleRepository;
//    final CompanyRepository companyRepository;
//    final EmployeeRepository employeeRepository;
//
//    @Value("${spring.jpa.hibernate.ddl-auto}")
//    private String ddl;
//    @Value("${spring.sql.init.mode}")
//    private String mode;
//
//    @Override
//    public void run(String... args){
//         if(ddl.equals("create") && mode.equals("always")){
//             Role director = roleRepository.save(new Role(1, "DIRECTOR"));
////             Role manager = roleRepository.save(new Role(2, "MANAGER"));
////             Role user = roleRepository.save(new Role(3, "USER"));
//
//             Employee bexruz = employeeRepository.save(new Employee("Bexruz", passwordEncoder.encode("0000"), "bexruzizzatullayev@gmail.com", director, true));
//             companyRepository.save(new Company(1, "PDP", bexruz));
//         }
//    }
//}
