package lk.ijse.javaapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app")
public class AppController {

    @GetMapping
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(
                "Java spring application is running...",
                HttpStatus.OK
        );
    }

    @GetMapping(("/kill"))
    public ResponseEntity<?> killApplication() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("killing the application...");
                System.exit(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        return new ResponseEntity<>(
                "killing the application...",
                HttpStatus.OK
        );
    }
}
