package com.sms;

import com.sms.service.StudentService;
import com.sms.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService service = ctx.getBean(StudentService.class);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Add Student\n2. View Students\n3. Pay Fee\n4. Refund Fee\n5. Delete Student\n6. Exit");
            int ch = sc.nextInt();

            switch(ch){
                case 1: System.out.print("Enter name course fee: "); service.addStudent(sc.next(), sc.next(), sc.nextDouble()); break;
                case 2: service.viewStudents(); break;
                case 3: System.out.print("ID Amount: "); service.payFee(sc.nextInt(), sc.nextDouble()); break;
                case 4: System.out.print("ID Amount: "); service.refundFee(sc.nextInt(), sc.nextDouble()); break;
                case 5: System.out.print("ID: "); service.deleteStudent(sc.nextInt()); break;
                case 6: System.exit(0);
            }
        }
    }
}
