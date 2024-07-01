package top.singi.kotlin_scaffold

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("top.singi.kotlin_scaffold.mapper")
class KotlinScaffoldApplication

fun main(args: Array<String>) {
    runApplication<KotlinScaffoldApplication>(*args)
}
