package top.singi.kotlin_scaffold.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.springframework.stereotype.Component
import top.singi.kotlin_scaffold.entity.Book

@Component
interface BookMapper: BaseMapper<Book> {
}