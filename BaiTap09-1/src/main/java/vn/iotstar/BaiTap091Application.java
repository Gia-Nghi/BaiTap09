package vn.iotstar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.iotstar.entity.Role;
import vn.iotstar.entity.User;
import vn.iotstar.repository.RoleRepository;
import vn.iotstar.repository.UserRepository;

@SpringBootApplication
public class BaiTap091Application {

    public static void main(String[] args) {
        SpringApplication.run(BaiTap091Application.class, args);
    }

    @Bean
    CommandLineRunner init(
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {

        return args -> {

            // Tìm ROLE_USER, nếu chưa có thì tạo mới
            Role userRole = roleRepository
                    .findByName("ROLE_USER")
                    .orElseGet(() ->
                        roleRepository.save(
                            Role.builder()
                                .name("ROLE_USER")
                                .build()
                        )
                    );

            // Kiểm tra user01 đã tồn tại chưa
            if (userRepository
                    .findByUsername("user01")
                    .isEmpty()) {

                // Nếu chưa có thì tạo user
                User user = User.builder()
                        .username("user01")
                        .email("user01@gmail.com")
                        .password(
                            passwordEncoder.encode("123456")
                        )
                        .fullName("Vy Gia Nghi")
                        .images("/images/user.png")
                        .role(userRole)
                        .enabled(true)
                        .build();

                userRepository.save(user);
            }
        };
    }
}