package com.zzc.intern;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzc.intern.mapper")
public class TUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TUserApplication.class, args);
	}

}
