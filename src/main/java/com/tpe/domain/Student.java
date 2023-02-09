package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor  // final yazdiklarimizi constructor da kullanir.
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull (message = "first name can not be null")
    @NotBlank (message="first name can not be white space")
    @Size(min=2,max=25,message = "First name '${validatedValue}' must be between {min} and {max} long")
    @Column (nullable = false, length =25 )   //repo katmaninda control yapilir.
    /*final*/ private String name;

    @Column (nullable = false, length =25 )
    /*final*/ private String lastName;

    /*final*/ private Integer grade;

    @Column(nullable = false, length =50, unique = true)
    @Email(message = "Provide valid email")
    /*final*/ private String email;

    /*final*/ private String phoneNumber;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();

    @OneToMany(mappedBy = "student")
    private List<Book> books = new ArrayList<>();

    @JoinColumn(name="user_id")
    @OneToOne
    private User user;



}
